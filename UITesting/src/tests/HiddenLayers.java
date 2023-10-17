package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HiddenLayers {
	@Test
	public void testHiddenLayers() {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();

			page.navigate("http://uitestingplayground.com/hiddenlayers");

			// Hitta och klicka på knappen med hjälp av dess ID
			page.click("#greenButton");

			boolean isClickable = true;
			try {
				// Försöker klicka på knappen igen med en timeout, förväntas att det inte går.
				page.click("#greenButton", new Page.ClickOptions().setTimeout(3000));
			} catch (PlaywrightException e) {

				isClickable = false;
			}

			// Steg 4: Assertion för att verifiera att knappen inte var klickbar.
			Assertions.assertFalse(isClickable,
					"The button should not be clickable as it is supposed to be hidden or overlapped by another layer.");

		}
	}

}
