package io.md.news.service;

import io.md.news.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockViewServiceImpl implements ViewService {
    private static final String CONTEXT = "/news";

    private static final String ARTICLE = CONTEXT + "/article";

    private static final String TITLE = "Lorem ipsum dolor";

    private static final String ARTICLE_IMG = CONTEXT + "/images/sample-1.jpg";

    private static final String LOCAL_IMG = CONTEXT + "/images/bc.jpg";

    private static final String READ = "Continue reading";

    private static final String CONTENT = "Lorem ipsum dolor sit amet, consectetur " +
            "adipiscing elit, sed do eiusmodtempor incididunt ut labore et dolore " +
            "magnaaliqua. Ut enim ad minim veniam, quisnostrud exercitation ullamco " +
            "laboris nisi ut aliquip ex ea commodo consequat. ";

    private static final String CONTACT_US = CONTENT + "Duis aute irure dolor in " +
            "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";

    private static final String COPYRIGHT = "© 2017 Lorem Ipsum Co., Ltd.";

    private static final int FIRST_PAGE = 1;

    private static final int LAST_PAGE = 5;

    @Override
    public View getView(int page) {
        return getView(page, false);
    }

    @Override
    public View getView(int page, boolean viewingTop) {
        return getView(page, viewingTop, ViewMode.NORMAL);
    }

    @Override
    public View getArticleView(int page, boolean viewingTop) {
        return getView(page, viewingTop, ViewMode.ARTICLE);
    }

    private View getView(int page, boolean viewingTop, ViewMode mode) {
        return new View(createHeader(), createBody(page, viewingTop, mode),
                createFooter(), mode.toString());
    }

    private Header createHeader() {
        Link logo = new Link("News", CONTEXT);
        return new Header(logo, createHeaderLinks());
    }

    private Body createBody(int page, boolean viewingTop, ViewMode mode) {
        if(ViewMode.NORMAL.equals(mode)) {
            return new Body(createBodyNews(page), createLocalNews(), viewingTop);
        } else {
            return new Body(createSingleBodyNews(page), null, viewingTop);
        }
    }

    private MainNews createBodyNews(int page) {
        return new MainNews(createArticles(page), createPagination(page), null);
    }

    private MainNews createSingleBodyNews(int page) {
        return new MainNews(null, null, createArticleView(page));
    }

    private ArticleView createArticleView(int page) {
        List<String> paragraphs = new ArrayList<>();
        for(int x = 0; x < 5; x++) {
            paragraphs.add(CONTENT + CONTENT + CONTENT);
        }
        return new ArticleView(ARTICLE_IMG, TITLE + " " + page, paragraphs);
    }

    private List<ArticleCard> createArticles(int page) {
        List<ArticleCard> articles = new ArrayList<>();
        for(int x = 0; x < (page == 1 ? 7 : 9); x++) {
            articles.add(createArticle(offset(page) + x));
        }
        return articles;
    }

    private ArticleCard createArticle(int count) {
        String title = TITLE + " " + count;
        Link link = new Link(READ, ARTICLE + "/" + count);
        return new ArticleCard(ARTICLE_IMG, title, title, CONTENT, link);
    }

    private int offset(int page) {
        return (page - 1) * 7;
    }

    private LocalNews createLocalNews() {
        return new LocalNews(createLocalNewsLinkList(), LOCAL_IMG);
    }

    private LinkList createLocalNewsLinkList() {
        return new LinkList("Local Stories", createLocalNewsLinks());
    }

    private List<Link> createLocalNewsLinks() {
        return Arrays.asList(
                new Link(TITLE + " 1", ARTICLE + "/40"),
                new Link(TITLE + " 2", ARTICLE + "/41"),
                new Link(TITLE + " 3", ARTICLE + "/42"),
                new Link(TITLE + " 4", ARTICLE + "/43"),
                new Link(TITLE + " 5", ARTICLE + "/44"),
                new Link(TITLE + " 6", ARTICLE + "/45")
        );
    }

    private Pagination createPagination(int page) {
        return new Pagination(page == FIRST_PAGE, page == LAST_PAGE,
                page, createPages(), CONTEXT + "/");
    }

    private List<Link> createPages() {
        return Arrays.asList(
            new Link("1", CONTEXT + "/1"),
            new Link("2", CONTEXT + "/2"),
            new Link("3", CONTEXT + "/3"),
            new Link("4", CONTEXT + "/4"),
            new Link("5", CONTEXT + "/5")
        );
    }

    private Footer createFooter() {
        LinkList social = new LinkList("Social Media", createFooterSocialLinks());
        LinkList services = new LinkList("Services & Info", createFooterServiceLinks());
        return new Footer(COPYRIGHT, social, services, createContact());
    }

    private List<Link> createHeaderLinks() {
        return Arrays.asList(
                new Link("Top Stories", CONTEXT),
                new Link("World", CONTEXT + "/world"),
                new Link("Canada", CONTEXT + "/canada"),
                new Link("Local", CONTEXT + "/local"),
                new Link("Politics", CONTEXT + "/politics"),
                new Link("Opinion", CONTEXT + "/opinion")
        );
    }

    private List<Link> createFooterSocialLinks() {
        return Arrays.asList(
                new Link("Facebook", "https://www.facebook.com/"),
                new Link("Twitter", "https://twitter.com/"),
                new Link("YouTube", "https://www.youtube.com/"),
                new Link("Instagram", "https://www.instagram.com"),
                new Link("LinkedIn", "http://linkedin.com/"),
                new Link("RSS", "https://en.wikipedia.org/wiki/RSS")
        );
    }

    private List<Link> createFooterServiceLinks() {
        return Arrays.asList(
                new Link("Corporate Info", CONTEXT + "/corporate"),
                new Link("Public Appearances", CONTEXT + "/appearances"),
                new Link("Commercial Services", CONTEXT + "/commercial"),
                new Link("Terms of Use", CONTEXT + "/terms"),
                new Link("Privacy Policy", CONTEXT + "/privacy"),
                new Link("FAQ", CONTEXT + "/faq")
        );
    }

    private Contact createContact() {
        return new Contact("Contact Lorem Ipsum", CONTACT_US);
    }
}