const React = require('react');
const ReactDOM = require('react-dom');

export default class ArticleView extends React.Component {
  createParagraphs_(content) {
    var paragraphs = [];
    for(let i = 0; i < content.length; i++) {
      var component = <p key={i}>{content[i]}</p>;
      paragraphs.push(component);
    }
    return paragraphs;
  };

  render() {
    var paragraphs = this.createParagraphs_(this.props.content);
    return (
      <div className="card-panel article-view">
        <div className="article-view-img">
          <img src={this.props.image}></img>
        </div>
        <h4>{this.props.title}</h4>
        {paragraphs}
      </div>
    );
  }
}