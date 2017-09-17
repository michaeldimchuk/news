import LocalViewPanel from './local-view-panel';

import { resolveText } from '../../utils/text-resource';

const React = require('react');
const ReactDOM = require('react-dom');

export default class LocalView extends React.Component {
  render() {
    var local = window.DATA.body.local;
    var text = resolveText(local.title);
		return (
      <LocalViewPanel title={text} image={local.image} data={local.links}/>
		);
	}
}