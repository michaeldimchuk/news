import HeaderMenu from '../component/header/header-menu';

import { resolveText } from '../utils/text-resource';

const React = require('react');
const ReactDOM = require('react-dom');

export default class Header extends React.Component {
  render() {
    var header = window.DATA.header;
    var logoText = resolveText(header.logo.text);
    return (
      <nav className="header indigo darken-1">
        <div className="nav-wrapper">
          <a href={header.logo.url} className="brand-logo">{logoText}</a>
          <HeaderMenu data={header.tabs} />
        </div>
      </nav>
    );
  }
}