import HeaderMenuElement from './header-menu-element';

import { generateLinks } from '../utils/link-generator';

const React = require('react');
const ReactDOM = require('react-dom');

export default class HeaderMenu extends React.Component {
  createMenuElement_(index, text, url) {
    return <HeaderMenuElement key={index} text={text} url={url} />;
  };

	render() {
	  var links = generateLinks(this.props.data, this.createMenuElement_);
		return (
			<ul id="nav-mobile" className="hide-on-med-and-down header-items">
        {links}
      </ul>
		);
	}
}