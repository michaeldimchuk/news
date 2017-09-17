import LinkMenu from '../component/links/link-menu';
import FooterContact from '../component/footer-contact';

import { resolveText } from '../utils/text-resource';

const React = require('react');
const ReactDOM = require('react-dom');

export default class Footer extends React.Component {
  generateLinkMenus_() {
    var socialTitle = resolveText(this.props.socialTitle);
    var servicesTitle = resolveText(this.props.servicesTitle);
    return [
      <LinkMenu title={socialTitle} data={this.props.socialLinks} key={0} />,
      <LinkMenu title={servicesTitle} data={this.props.servicesLinks} key={1} />
    ]
  };

  generateContactUs_() {
    var title = resolveText(this.props.contactTitle);
    var text = resolveText(this.props.contactText);
    return <FooterContact title={title} text={text} />;
  };

  generateCopyright_() {
    var text = resolveText(this.props.copyright);
    return (
      <div className="footer-copyright">
        <div className="container center">{text}</div>
      </div>
    );
  };

  render() {
    return (
      <footer className="page-footer indigo darken-1">
        <div className="container">
          <div className="row">
            {this.generateLinkMenus_()}
            {this.generateContactUs_()}
          </div>
        </div>
        {this.generateCopyright_()}
      </footer>
    );
  }
}