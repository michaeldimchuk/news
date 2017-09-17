const React = require('react');
const ReactDOM = require('react-dom');

export default class LocalViewPanelElement extends React.Component {
  render() {
    return (
      <a href={this.props.url} className="collection-item local-view-panel-element">{this.props.text}</a>
    );
  }
}