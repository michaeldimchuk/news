import HeaderMenu from '../component/header-menu';

const React = require('react');
const ReactDOM = require('react-dom');

export default class Header extends React.Component {
  constructor() {
    super();

    this.elements_ = [
      {text:"Top Stories", url:"#"},
      {text:"World", url:"#"},
      {text:"Canada", url:"#"},
      {text:"Local", url:"#"},
      {text:"Politics", url:"#"},
      {text:"Opinion", url:"#"}
    ];
  }

  render() {
    return (
      <nav className="header indigo darken-1">
        <div className="nav-wrapper">
          <a href="" className="brand-logo">News</a>
          <HeaderMenu data={this.elements_} />
        </div>
      </nav>
    );
  }
}