import LocalViewPanelElement from './local-view-panel-element';

const React = require('react');
const ReactDOM = require('react-dom');

export default class LocalViewPanel extends React.Component {

  render() {
		return (
      <div className="col s12">
        <div className="card">
          <div className="card-image">
            <img src="images/bc.jpg"></img>
            <span className="card-title">Local Stories</span>
          </div>
          <ul className="collection local-view-panel-collection">
            <LocalViewPanelElement text="Lorem ipsum dolor" />
            <LocalViewPanelElement text="Lorem ipsum dolor" />
            <LocalViewPanelElement text="Lorem ipsum dolor" />
            <LocalViewPanelElement text="Lorem ipsum dolor" />
            <LocalViewPanelElement text="Lorem ipsum dolor" />
          </ul>
        </div>
      </div>
		);
	}
}