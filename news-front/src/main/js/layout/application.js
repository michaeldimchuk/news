import Header from './header';
import Body from './body';
import Footer from './footer';

const React = require('react');
const ReactDOM = require('react-dom');

export default class Application extends React.Component {
  render() {
    var header = window.DATA.header;
    var body = window.DATA.body;
    var footer = window.DATA.footer;

    return (
      <div>
        <Header logoUrl={header.logo.url} logoText={header.logo.text} tabs={header.tabs} active={header.active} />

        <Body displayMode={body.mode} feedMode={body.feedMode}
              localTitle={body.local.title} localImage={body.local.image} localLinks={body.local.links}
              articleTitle={body.title} articleImage={body.image} articleContent={body.paragraphs} />

        <Footer socialTitle={footer.social.title} socialLinks={footer.social.links}
                servicesTitle={footer.services.title} servicesLinks={footer.services.links}
                contactTitle={footer.contact.title} contactText={footer.contact.text}
                copyright={footer.copyright} />
      </div>
    );
  }
}