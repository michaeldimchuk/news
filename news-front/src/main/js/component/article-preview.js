const React = require('react');
const ReactDOM = require('react-dom');

export default class ArticlePreview extends React.Component {
	render() {
	  var suggested = this.props.suggested;
		return (
      <div className={"col " + (suggested ? "s12" : "s4")}>
        <div className="card hoverable">
          <div className={"card-image " + (suggested ? "article-preview-image" : "")}>
            <img src={this.props.cardUrl}></img>
            <span className="card-title">{this.props.cardTitle}</span>
          </div>
          <div className={(suggested ? "article-preview-body" : "")}>
            <div className="card-content">
              <h5>{this.props.title}</h5>
              <p>{this.props.text}</p>
            </div>
            <div className="card-action">
              <a href={this.props.linkUrl}>{this.props.linkText}</a>
            </div>
          </div>
        </div>
      </div>
		);
	}
}