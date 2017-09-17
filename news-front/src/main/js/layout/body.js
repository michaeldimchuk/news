import NewsView from './news-view';
import ArticleView from './article-view'
import LocalView from '../component/local/local-view';

const React = require('react');
const ReactDOM = require('react-dom');

import { canRequestMore } from '../utils/paged-response-util';
import { generateUrl } from '../utils/paged-response-util';
import { updateBody } from '../utils/paged-response-util';
import { needsMorePages } from '../utils/paged-response-util';
import { isPaginationEnabled } from '../utils/paged-response-util';
import { enableLoading } from '../utils/paged-response-util';

export default class Body extends React.Component {
  constructor() {
    super();
    this.state = {
      articles: window.DATA.body.articles
    };
  };

  handleLoadedData_(data, self) {
    let updatedArticles = self.state.articles.concat(data.articles);
    self.setState({articles : updatedArticles});
    updateBody(data, updatedArticles);
    enableLoading(false);
  };

  handleScrollEvent_(e, self) {
    if(canRequestMore() && needsMorePages(e.target.body)) {
      enableLoading(true);
      let url = generateUrl();
      fetch(url)
        .then(result => { return result.json(); })
        .then(data => {
          let updatedArticles = self.state.articles.concat(data.articles);
          self.setState({articles : updatedArticles});
          updateBody(data, updatedArticles);
          enableLoading(false);
        }).catch((error) => { enableLoading(false); });
    }
  };

  componentDidMount() {
    if(isPaginationEnabled()) {
      var self = this;
      var scrollHandler = this.handleScrollEvent_;
      window.addEventListener("scroll", function(e) {
        scrollHandler(e, self);
      });
    }
  };

  getNewsViewComponent_() {
    return [
      <div className="col s9" key={0}>
        <NewsView feedMode={this.props.feedMode} articles={this.state.articles} />
      </div>,
      <div className="col s3" key={1}>
        <LocalView title={this.props.localTitle} image={this.props.localImage}
                   data={this.props.localLinks} />
      </div>
    ];
  };

  getViewComponent_() {
    if(this.props.displayMode === "ARTICLE") {
      return <ArticleView image={this.props.articleImage} title={this.props.articleTitle}
                          content={this.props.articleContent} />;
    }
    return this.getNewsViewComponent_();
  };

  render() {
    return (
      <div className="row container body">
        {this.getViewComponent_()}
      </div>
    );
  }
}