import NewsView from './news-view';
import NewsSide from './news-side';

const React = require('react');
const ReactDOM = require('react-dom');

export default class Body extends React.Component {
  getViewComponent_() {
    var articleMode = window.DATA.mode === "ARTICLE";
    if(articleMode) {

    }
    return <NewsView />;
  };

  render() {
    var view = this.getViewComponent_();
    return (
      <div className="row container body">
        <div className="col s9">
          {view}
        </div>
        <div className="col s3">
          <NewsSide />
        </div>
      </div>
    );
  }
}