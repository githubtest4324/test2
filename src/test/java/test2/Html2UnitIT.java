package test2;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Html2UnitIT {
	private final static Logger logger = Logger.getLogger(Html2UnitIT.class.getName());

	private String webUrl;

	private WebClient webClient;

	@Before
	public void setUp() {
		webUrl = System.getProperty("integration.base.url");
		webClient = new WebClient();
	}

	@After
	public void tearDown() {
		webClient.closeAllWindows();
	}

	/**
	 * Test /index.html
	 */
	@Test
	public void testIndexHtml() throws Exception {
		System.out.println("Connecting to: " + webUrl);
		HtmlPage page = webClient.getPage(webUrl + "/index.jsp");
		String body = page.getBody().asText();
		logger.info(String.format("Body: '%s'", body));
		assertTrue(body.indexOf("Testing with HtmlUnit + Maven!") != -1);
	}
}