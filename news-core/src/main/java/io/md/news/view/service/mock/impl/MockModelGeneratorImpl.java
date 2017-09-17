package io.md.news.view.service.mock.impl;

import io.md.news.dto.ArticleDto;
import io.md.news.mode.FeedMode;
import io.md.news.view.model.*;
import io.md.news.view.service.mock.MockUtil;
import io.md.news.view.service.spec.ModelGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MockModelGeneratorImpl implements ModelGenerator {
    @Override
    public View generateArticle(ArticleDto article) {
        View view = generateView(article);
        view.getHeader().setActive(null);
        return view;
    }

    @Override
    public View generateTopFeed(List<ArticleDto> articles, List<ArticleDto> local) {
        return generateView(articles, local);
    }

    @Override
    public View generateNormalFeed(String category, List<ArticleDto> articles, List<ArticleDto> local,
                                   int page, boolean hasMore) {
        return generatePagedView(category, articles, local, page, hasMore);
    }

    private View generatePagedView(String category, List<ArticleDto> articles, List<ArticleDto> local,
                                   int page, boolean hasMore) {
        Body body = generateNormalFeedBody(category, articles, local, page, hasMore);
        View view = generateViewWithBody(body);
        view.getHeader().setActive("header.menu." + category);
        return view;
    }

    private View generateView(List<ArticleDto> articles, List<ArticleDto> local) {
        Body body = generateTopFeedBody(articles, local);
        return generateViewWithBody(body);
    }

    private View generateView(ArticleDto article) {
        Body body = generateArticleBody(article);
        return generateViewWithBody(body);
    }

    private View generateViewWithBody(Body body) {
        Header header = generateHeader();
        Footer footer = generateFooter();
        return new View(header, body, footer);
    }

    private Body generateTopFeedBody(List<ArticleDto> articles, List<ArticleDto> localArticles) {
        LabeledList local = generateLocalArticles(localArticles);
        List<FeedElement> feeds = generateFeeds(articles);
        return new Feed(feeds, local, FeedMode.TOP);
    }

    private Body generateNormalFeedBody(String category, List<ArticleDto> articles, List<ArticleDto>
            localArticles, int page, boolean hasMore) {
        LabeledList local = generateLocalArticles(localArticles);
        List<FeedElement> feeds = generateFeeds(articles);
        Pagination pagination = new Pagination(page, hasMore);
        return new NormalFeed(feeds, local, pagination, category, MockUtil.PAGED_CONTEXT);
    }

    private LabeledList generateLocalArticles(List<ArticleDto> localArticles) {
        List<Link> links = localArticles.stream()
                .map(p -> new Link(p.getTitle(), "/news/articles/" + p.getArticleId()))
                .collect(Collectors.toList());
        return new LabeledList("body.side.title", MockUtil.MOCK_LOCAL_IMAGE, links);
    }

    private List<FeedElement> generateFeeds(List<ArticleDto> articles) {
        return articles.stream()
                .map(this::generateFeed)
                .collect(Collectors.toList());
    }

    private FeedElement generateFeed(ArticleDto article) {
        Link image = new Link(article.getTitle(), article.getImage());
        Link readMore = new Link("body.article.continue", "/news/articles/" + article.getArticleId());
        LabeledText preview = new LabeledText(article.getTitle(), article.getPreview());
        return new FeedElement(image, readMore, preview);
    }

    private Body generateArticleBody(ArticleDto article) {
        String[] paragraphs = article.getContent().split("\n");
        return new Article(article.getTitle(), article.getImage(), Arrays.asList(paragraphs));
    }

    private Header generateHeader() {
        Link logo = new Link("header.logo", MockUtil.CONTEXT);
        return new Header(logo, generateHeaderTabs(), "header.menu.top");
    }

    private List<Link> generateHeaderTabs() {
        List<Link> headerCopy = new ArrayList<>();
        for (int x = 1; x < MockUtil.HEADER_ELEMENTS.size(); x++) {
            headerCopy.add(MockUtil.HEADER_ELEMENTS.get(x));
        }
        return headerCopy;
    }

    private Footer generateFooter() {
        LabeledList social = new LabeledList("footer.menu.social", null, MockUtil.SOCIAL_LINKS);
        LabeledList services = new LabeledList("footer.menu.services", null, MockUtil.SERVICE_LINKS);
        LabeledText content = new LabeledText("footer.contact.title", "footer.contact.text");
        return new Footer(social, services, content, "footer.copyright");
    }
}