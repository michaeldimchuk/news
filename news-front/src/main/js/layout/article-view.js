const React = require('react');
const ReactDOM = require('react-dom');

export default class ArticleView extends React.Component {
  createParagraphs_(body) {
    var paragraphs = [];
    for(let i = 0; i < body.paragraphs.length; i++) {
      var component = <p key={i}>{body.paragraphs[i]}</p>
      paragraphs.push(component);
    }
    return paragraphs;
  };

  render() {
    var body = window.DATA.body;
    var paragraphs = this.createParagraphs_(body);
    return (
      <div className="card-panel article-view">
        <div className="article-view-img">
          <img src={body.image}></img>
        </div>
        <h4>{body.title}</h4>
        {paragraphs}
      </div>
    );
  }
}