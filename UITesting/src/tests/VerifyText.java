package tests;

import org.junit.jupiter.api.Test;
import com.microsoft.playwright.ElementHandle;
import testbase.TestBaseUI;
import static org.junit.jupiter.api.Assertions.*;

public class VerifyText extends TestBaseUI {

	@Test
	public void verifyWelcomeText() {
		// Steg 1: Navigera till webbsidan
		page.navigate("http://uitestingplayground.com/verifytext");

		// Steg 2: Hitta elementet med texten "Welcome UserName!"
		ElementHandle welcomeTextElement = page.querySelector("text=Welcome UserName!");

		// Steg 3: Verifiera att elementet finns
		assertNotNull(welcomeTextElement, "Failed to find the 'Welcome UserName!' text element.");
	}
}
