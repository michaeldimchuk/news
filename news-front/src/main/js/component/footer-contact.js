const React = require('react');
const ReactDOM = require('react-dom');

export default class FooterContact extends React.Component {
  render() {
    return (
      <div className="col s4">
        <h5 className="white-text">{this.props.title}</h5>
        <p className="grey-text text-lighten-4">{this.props.text}</p>
      </div>
    );
  }
}