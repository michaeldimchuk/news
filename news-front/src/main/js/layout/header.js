import HeaderMenu from '../component/header/header-menu';

import { resolveText } from '../utils/text-resource';

const React = require('react');
const ReactDOM = require('react-dom');

export default class Header extends React.Component {
  render() {
    var logoText = resolveText(this.props.logoText);
    return (
      <nav className="header indigo darken-1">
        <div className="nav-wrapper">
          <a href={this.props.logoUrl} className="brand-logo">{logoText}</a>
          <HeaderMenu data={this.props.tabs} active={this.props.active} />
        </div>
      </nav>
    );
  }
}