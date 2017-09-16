import HeaderMenu from '../component/header/header-menu';

const React = require('react');
const ReactDOM = require('react-dom');

export default class Header extends React.Component {
  render() {
    var header = window.DATA.header;
    return (
      <nav className="header indigo darken-1">
        <div className="nav-wrapper">
          <a href={header.logo.url} className="brand-logo">{header.logo.text}</a>
          <HeaderMenu data={header.links} />
        </div>
      </nav>
    );
  }
}