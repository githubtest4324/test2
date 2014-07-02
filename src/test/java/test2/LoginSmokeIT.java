package test2;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlFont;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class LoginSmokeIT {
	private final static Logger logger = Logger.getLogger(LoginSmokeIT.class.getName());

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
		HtmlPage page = webClient.getPage(webUrl + "/login/main");
		String body = page.getBody().asText();
		logger.info(String.format("Body: '%s'", body));

		HtmlTextInput username = (HtmlTextInput) page.getByXPath("//input[@id='username']").get(0);
		HtmlPasswordInput password = (HtmlPasswordInput) page.getByXPath("//input[@id='password']").get(0);
		HtmlSubmitInput submit = (HtmlSubmitInput) page.getByXPath("//input[@type='submit']").get(0);
		username.setValueAttribute("admin");
		password.setValueAttribute("admin");

		HtmlPage page2 = submit.click();

		// assertTrue(body.indexOf("Testing with HtmlUnit + Maven!") != -1);
	}
}