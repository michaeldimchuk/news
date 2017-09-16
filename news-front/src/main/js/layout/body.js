import NewsView from './news-view';
import NewsSide from './news-side';
import ArticleView from './article-view'

const React = require('react');
const ReactDOM = require('react-dom');

export default class Body extends React.Component {
  getNewsViewComponent_() {
    return [
      <div className="col s9" key={0}>
        <NewsView />
      </div>,
      <div className="col s3" key={1}>
        <NewsSide />
      </div>
    ];
  };

  getViewComponent_() {
    var articleMode = window.DATA.mode === "ARTICLE";
    if(articleMode) {
      return <ArticleView />;
    }
    return this.getNewsViewComponent_();
  };

  render() {
    var view = this.getViewComponent_();
    return (
      <div className="row container body">
        {view}
      </div>
    );
  }
}