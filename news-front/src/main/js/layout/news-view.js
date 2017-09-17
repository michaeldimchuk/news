import ArticlePreview from '../component/article-preview';

import { canRequestMore } from '../utils/paged-response-util';
import { generateUrl } from '../utils/paged-response-util';
import { updateBody } from '../utils/paged-response-util';
import { needsMorePages } from '../utils/paged-response-util';

const React = require('react');
const ReactDOM = require('react-dom');

export default class NewsView extends React.Component {
  generateArticles_() {
    var viewingTop = this.props.feedMode === "TOP";
    var articles = this.props.articles;
    var components = [];

    for(let i = 0; i < articles.length; i++) {
      var article = articles[i];
      var component = <ArticlePreview key={i} suggested={viewingTop && i === 0} title={article.content.title}
                        text={article.content.text} cardImage={article.image.url} cardTitle={article.image.text}
                        linkText={article.readMore.text} linkUrl={article.readMore.url} />;
      components.push(component);
    }
    return components;
  };

  render() {
    var articles = this.generateArticles_();
    return (
      <div className="row">
        {articles}
      </div>
    );
  }
}