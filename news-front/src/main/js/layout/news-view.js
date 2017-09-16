import ArticlePreview from '../component/article-preview';
import Pagination from '../component/general/pagination';

const React = require('react');
const ReactDOM = require('react-dom');

export default class NewsView extends React.Component {
  generateArticles_() {
    var articles = window.DATA.body.news.articles;
    var viewingTop = window.DATA.body.viewingTop;
    var components = [];
    for(let i = 0; i < articles.length; i++) {
      var article = articles[i];
      var component = <ArticlePreview key={i} suggested={viewingTop && i === 0} title={article.title}
                        text={article.text} cardImage={article.cardImage} cardTitle={article.cardTitle}
                        linkText={article.link.text} linkUrl={article.link.url} />;
      components.push(component);
    }
    return components;
  };

  generatePaginationUrls_() {
    var page = window.DATA.body.news.page;
    var prefix = page.prefix;
    var prev = page.currentPage <= 1 ? 1 : (page.currentPage - 1);
    return {
      nextPageUrl : prefix + (page.currentPage + 1),
      prevPageUrl : prefix + prev
    };
  };

  render() {
    var page = window.DATA.body.news.page;
    var articles = this.generateArticles_();
    var links = this.generatePaginationUrls_();
    console.log(links);
    return (
      <div className="row">
        {articles}
        <Pagination customClass="col s12" prevPageUrl={links.prevPageUrl} nextPageUrl={links.nextPageUrl}
            firstPage={page.firstPage} lastPage={page.lastPage} data={page.pages}/>
      </div>
    );
  }
}