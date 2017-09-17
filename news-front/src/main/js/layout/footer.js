import LinkMenu from '../component/links/link-menu';
import FooterContact from '../component/footer-contact';

import { resolveText } from '../utils/text-resource';

const React = require('react');
const ReactDOM = require('react-dom');

export default class Footer extends React.Component {
  generateLinkMenus_() {
    var footer = window.DATA.footer;
    var socialTitle = resolveText(footer.social.title);
    var servicesTitle = resolveText(footer.services.title);
    return [
      <LinkMenu title={socialTitle} data={footer.social.links} key={0} />,
      <LinkMenu title={servicesTitle} data={footer.services.links} key={1} />
    ]
  };

  generateContactUs_() {
    var footer = window.DATA.footer;
    var title = resolveText(footer.contact.title);
    var text = resolveText(footer.contact.text);
    return <FooterContact title={title} text={text} />;
  };

  generateCopyright_() {
    var text = resolveText(window.DATA.footer.copyright);
    return (
      <div className="footer-copyright">
        <div className="container center">{text}</div>
      </div>
    );
  };

  render() {
    var footer = window.DATA.footer;
    var linkMenus = this.generateLinkMenus_();
    var copyright = this.generateCopyright_();
    var contactUs = this.generateContactUs_();

    return (
      <footer className="page-footer indigo darken-1">
        <div className="container">
          <div className="row">
            {linkMenus}
            {contactUs}
          </div>
        </div>
        {copyright}
      </footer>
    );
  }
}