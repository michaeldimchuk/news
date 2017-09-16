import ArticlePreview from '../component/article-preview';
import Pagination from '../component/general/pagination';

const React = require('react');
const ReactDOM = require('react-dom');

export default class NewsView extends React.Component {
  constructor() {
    super();
    this.linkText_ = "Read Further";
    this.linkUrl_ = "#";
    this.title_ = "Lorem ipsum dolor sit";
    this.cardUrl_ = "images/sample-1.jpg";
    this.cardTitle_ = "Lorem ipsum dolor sit";
    this.text_ = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                 "sed do eiusmodtempor incididunt ut labore et dolore magna" +
                 "aliqua. Ut enim ad minim veniam, quisnostrud exercitation " +
                 "ullamco laboris nisi ut aliquip ex ea commodo consequat.";
    this.pages_ = [
      {active:true, url:"#", text:"1"},
      {url:"#", text:"2"},
      {url:"#", text:"3"},
      {url:"#", text:"4"},
      {url:"#", text:"5"}
    ];
  }

  generateArticles_() {
    var articles = [];
    for(let i = 0; i < 6; i++) {
      var article = <ArticlePreview key={i} title={this.title_} text={this.text_}
                        cardUrl={this.cardUrl_} cardTitle={this.cardTitle_}
                        linkText={this.linkText_} linkUrl={this.linkUrl_} />;
      articles.push(article);
    }
    return articles;
  };

  render() {
    var articles = this.generateArticles_();
    return (
      <div className="row">
        <ArticlePreview suggested={true} title={this.title_} text={this.text_}
            cardUrl={this.cardUrl_} cardTitle={this.cardTitle_} linkText={this.linkText_}
            linkUrl={this.linkUrl_} />

        {articles}

        <Pagination customClass="col s12" prevPageUrl="#"
            nextPageUrl="#" firstPage={true} data={this.pages_}/>
      </div>
    );
  }
}