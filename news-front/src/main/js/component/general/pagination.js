const React = require('react');
const ReactDOM = require('react-dom');

const WAVES = "waves-effect";
const ACTIVE = "active news-active";

export default class Pagination extends React.Component {
  generatePrevButton_() {
    var firstPage = this.props.data.length < 2 || this.props.firstPage;
    return (
      <li className={(firstPage ? "disabled" : WAVES)}>
        <a href={this.props.prevPageUrl}><i className="material-icons">chevron_left</i></a>
      </li>
    );
  };

  generateNextButton_() {
    var lastPage = this.props.data.length < 2 || this.props.lastPage;
    return (
      <li className={(lastPage ? "disabled" : WAVES)}>
        <a href={this.props.nextPageUrl}><i className="material-icons">chevron_right</i></a>
      </li>
    );
  };

  generatePaginationButtons_() {
    var pages = [];
    for(let i = 0; i < this.props.data.length; i++) {
      let page = this.props.data[i];
      var component = (
        <li className={(page.active ? ACTIVE : WAVES)} key={i}>
          <a href={page.url}>{page.text}</a>
        </li>
      );
      pages.push(component);
    }
    return pages;
  };

	render() {
	  var customClass = "news-pagination " + (this.props.customClass ? this.props.customClass : "");
	  var prevButton = this.generatePrevButton_();
	  var nextButton = this.generateNextButton_();
    var pages = this.generatePaginationButtons_();
		return (
		  <ul className={"pagination center-align " + customClass}>
        {prevButton}
        {pages}
        {nextButton}
      </ul>
		);
	}
}