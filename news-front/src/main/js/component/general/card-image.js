const React = require('react');
const ReactDOM = require('react-dom');

export default class CardImage extends React.Component {
  render() {
    var customClass = this.props.customClass ? this.props.customClass : "";
		return (
      <div className={"card-image " + customClass}>
        <img src={this.props.image}></img>
        <span className="card-title">{this.props.title}</span>
      </div>
		);
	}
}