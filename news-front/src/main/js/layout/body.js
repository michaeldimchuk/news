import NewsView from './news-view';
import NewsSide from './news-side';

const React = require('react');
const ReactDOM = require('react-dom');

export default class Body extends React.Component {
  render() {
    return (
      <div className="row container body">
        <div className="col s9">
          <NewsView />
        </div>
        <div className="col s3">
          <NewsSide />
        </div>
      </div>
    );
  }
}