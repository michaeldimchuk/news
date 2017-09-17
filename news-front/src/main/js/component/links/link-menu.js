import LinkMenuElement from './link-menu-element';

import { generateLinks } from '../../utils/link-generator';
import { resolveText } from '../../utils/text-resource';

const React = require('react');
const ReactDOM = require('react-dom');

export default class LinkMenu extends React.Component {
  createMenuElement_(index, text, url) {
    return <LinkMenuElement key={index} text={resolveText(text)} url={url} />;
  };

  render() {
    var links = generateLinks(this.props.data, this.createMenuElement_);
		return (
			<div className="col s4">
        <h5 className="white-text">{this.props.title}</h5>
        <ul>
          {links}
        </ul>
      </div>
		);
	}
}