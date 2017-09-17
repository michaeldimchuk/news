import LocalViewPanel from './local-view-panel';

import { resolveText } from '../../utils/text-resource';

const React = require('react');
const ReactDOM = require('react-dom');

export default class LocalView extends React.Component {
  render() {
    return (
      <LocalViewPanel title={resolveText(this.props.title)}
            image={this.props.image} data={this.props.data}/>
    );
  }
}