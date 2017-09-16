import Header from './header';
import Body from './body';
import Footer from './footer';

const React = require('react');
const ReactDOM = require('react-dom');

export default class Application extends React.Component {
	render() {
		return (
      <div>
        <Header />
        <Body />
        <Footer />
      </div>
		);
	}
}