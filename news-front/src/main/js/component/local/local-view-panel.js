import LocalViewPanelElement from './local-view-panel-element';
import CardImage from '../general/card-image';

import { generateLinks } from '../../utils/link-generator';

const React = require('react');
const ReactDOM = require('react-dom');

export default class LocalViewPanel extends React.Component {
  createLocalElement_(index, text, url) {
    return <LocalViewPanelElement key={index} text={text} url={url}/>;
  };

  render() {
    var links = generateLinks(this.props.data, this.createLocalElement_);
		return (
      <div className="col s12">
        <div className="card">
          <CardImage image={this.props.image} title={this.props.title} />

          <ul className="collection local-view-panel-collection">
            {links}
          </ul>
        </div>
      </div>
		);
	}
}