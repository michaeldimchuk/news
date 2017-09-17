package io.md.news.view.service.mock;

import io.md.news.view.model.Link;

import java.util.Arrays;
import java.util.List;

public class MockUtil {
    public static final String CONTEXT = "/news";

    public static final List<Link> HEADER_ELEMENTS = Arrays.asList(
            new Link("header.logo", CONTEXT),
            new Link("header.menu.top", CONTEXT),
            new Link("header.menu.world", CONTEXT + "/category/world"),
            new Link("header.menu.canada", CONTEXT + "/category/canada"),
            new Link("header.menu.local", CONTEXT + "/category/local"),
            new Link("header.menu.politics", CONTEXT + "/category/politics"),
            new Link("header.menu.opinion", CONTEXT + "/category/opinion")
    );

    public static final List<Link> SOCIAL_LINKS = Arrays.asList(
            new Link("Facebook", CONTEXT),
            new Link("Twitter", CONTEXT),
            new Link("Youtube", CONTEXT),
            new Link("Instagram", CONTEXT),
            new Link("LinkedIn", CONTEXT),
            new Link("RSS", CONTEXT)
    );

    public static final List<Link> SERVICE_LINKS = Arrays.asList(
            new Link("footer.menu.services.corporate", CONTEXT),
            new Link("footer.menu.services.appearances", CONTEXT),
            new Link("footer.menu.services.commercial", CONTEXT),
            new Link("footer.menu.services.terms", CONTEXT),
            new Link("footer.menu.services.privacy", CONTEXT),
            new Link("footer.menu.services.faq", CONTEXT)
    );

    public static final List<String> BODY_ELEMENTS = Arrays.asList("body.article.continue", "body.side.title");

    public static final List<String> FOOTER_ELEMENTS = Arrays.asList("footer.menu.social", "footer.menu.services",
            "footer.contact.title", "footer.contact.text", "footer.copyright", "footer.menu.services.corporate",
            "footer.menu.services.appearances", "footer.menu.services.commercial", "footer.menu.services.terms",
            "footer.menu.services.privacy", "footer.menu.services.faq");

    public static final String MOCK_TITLE = "Lorem ipsum dolor";

    public static final String MOCK_PREVIEW = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmodtempor incididunt ut labore et dolore magnaaliqua. Ut enim ad minim veniam, " +
            "quisnostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";

    public static final String MOCK_CONTENT = MOCK_PREVIEW + "\n" + MOCK_PREVIEW + "\n" + MOCK_PREVIEW +
            "\n" + MOCK_PREVIEW + "\n" + MOCK_PREVIEW + "\n";

    public static final String MOCK_IMAGE = "/news/images/sample-1.jpg";

    public static final String MOCK_LOCAL_IMAGE = "/news/images/bc.jpg";

    public static final int FIRST_PAGE = 0;

    public static final int LAST_PAGE = 5;

    public static final String PAGED_CONTEXT = "/news/page/";
}
