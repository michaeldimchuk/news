const React = require('react');
const ReactDOM = require('react-dom');

export default class HeaderMenuElement extends React.Component {
	render() {
		return (
			<li>
			  <a className="header-child" href={this.props.url}>{this.props.text}</a>
			</li>
		);
	}
}