import CardImage from './general/card-image';

const React = require('react');
const ReactDOM = require('react-dom');

export default class ArticlePreview extends React.Component {
	render() {
	  var suggested = this.props.suggested;
		return (
      <div className={"col " + (suggested ? "s12" : "s4")}>
        <div className="card hoverable">
          <CardImage customClass={(suggested ? "article-preview-image" : "")}
              image={this.props.cardImage} title={this.props.cardTitle} />

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