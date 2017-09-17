const React = require('react');
const ReactDOM = require('react-dom');

export default class HeaderMenuElement extends React.Component {
  render() {
    var activeClass = this.props.active ? "active" : "";
    return (
      <li className={activeClass}>
        <a className="header-child" href={this.props.url}>{this.props.text}</a>
      </li>
    );
  }
}