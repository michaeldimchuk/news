import NewsView from './news-view';
import NewsSide from './news-side';
import ArticleView from './article-view'

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

  handleScrollEvent_(e, self) {
    if(canRequestMore() && needsMorePages(e.target.body)) {
      enableLoading(true);
      let url = generateUrl();
      fetch(url).then(result => { return result.json(); })
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
    var body = window.DATA.body;
    return [
      <div className="col s9" key={0}>
        <NewsView feedMode={body.feedMode} articles={this.state.articles} />
      </div>,
      <div className="col s3" key={1}>
        <NewsSide />
      </div>
    ];
  };

  getViewComponent_() {
    var articleMode = window.DATA.body.mode === "ARTICLE";
    if(articleMode) {
      return <ArticleView />;
    }
    return this.getNewsViewComponent_();
  };

  render() {
    var view = this.getViewComponent_();
    return (
      <div className="row container body">
        {view}
      </div>
    );
  }
}