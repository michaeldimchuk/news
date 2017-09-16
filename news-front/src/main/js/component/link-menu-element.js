const React = require('react');
const ReactDOM = require('react-dom');

const LINK_TEXT = "grey-text text-lighten-3 footer-link";

export default class LinkMenuElement extends React.Component {
  render() {
		return (
			<li>
			  <a className="grey-text text-lighten-3 footer-link" href={this.props.url}>{this.props.text}</a>
      </li>
		);
	}
}