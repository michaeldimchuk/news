import LinkMenu from '../component/link-menu';
import FooterContact from '../component/footer-contact';

const React = require('react');
const ReactDOM = require('react-dom');

export default class Footer extends React.Component {
  constructor() {
      super();

      this.social_ = [
            {text:"Facebook", url:"#!"},
            {text:"Twitter", url:"#!"},
            {text:"YouTube", url:"#!"},
            {text:"Instagram", url:"#!"},
            {text:"LinkedIn", url:"#!"},
            {text:"RSS", url:"#!"}];

      this.services_ = [
            {text:"Corporate Info", url:"#!"},
            {text:"Public Appearances", url:"#!"},
            {text:"Commercial Services", url:"#!"},
            {text:"Terms of Use", url:"#!"},
            {text:"Privacy Policy", url:"#!"},
            {text:"FAQ", url:"#!"}];

      this.contact_ = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod" +
            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis" +
            "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu " +
            "fugiat nulla pariatur."
    }

	render() {
		return (
      <footer className="page-footer blue-grey darken-1">
        <div className="container">
          <div className="row">
            <LinkMenu title="Social Media" data={this.social_}/>
            <LinkMenu title="Services & Info" data={this.services_}/>
            <FooterContact title="Contact Lorem Ipsum" text={this.contact_} />
          </div>
        </div>
        <div className="footer-copyright blue-grey darken-1">
          <div className="container center">© 2017 Lorem Ipsum Co., Ltd.</div>
        </div>
      </footer>
		);
	}
}