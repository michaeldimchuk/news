const React = require('react');
const ReactDOM = require('react-dom');

export default class ArticleView extends React.Component {
  createParagraphs_(article) {
    var paragraphs = [];
    for(let i = 0; i < article.paragraphs.length; i++) {
      var component = <p key={i}>{article.paragraphs[i]}</p>
      paragraphs.push(component);
    }
    return paragraphs;
  };

  render() {
    var article = window.DATA.body.news.article;
    var paragraphs = this.createParagraphs_(article);
    return (
      <div className="card-panel article-view">
        <div className="article-view-img">
          <img src={article.image}></img>
        </div>
        <h4>{article.title}</h4>
        {paragraphs}
      </div>
    );
  }
}