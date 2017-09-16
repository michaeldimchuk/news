import LocalViewPanel from './local-view-panel';

const React = require('react');
const ReactDOM = require('react-dom');

export default class LocalView extends React.Component {
  render() {
    var local = window.DATA.body.local;
		return (
      <LocalViewPanel title={local.stories.title} image={local.image} data={local.stories.links}/>
		);
	}
}