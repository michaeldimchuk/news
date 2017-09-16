import LinkMenu from '../component/links/link-menu';
import FooterContact from '../component/footer-contact';

const React = require('react');
const ReactDOM = require('react-dom');

export default class Footer extends React.Component {
  render() {
    var footer = window.DATA.footer;
    return (
      <footer className="page-footer indigo darken-1">
        <div className="container">
          <div className="row">
            <LinkMenu title={footer.social.title} data={footer.social.links}/>
            <LinkMenu title={footer.services.title} data={footer.services.links}/>
            <FooterContact title={footer.contact.title} text={footer.contact.text} />
          </div>
        </div>
        <div className="footer-copyright">
          <div className="container center">{footer.copyright}</div>
        </div>
      </footer>
    );
  }
}