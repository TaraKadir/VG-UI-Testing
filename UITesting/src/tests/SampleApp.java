package tests;

import testbase.TestBaseUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleApp extends TestBaseUI {

	@Test
	public void loginFormTest() {
		// Steg 1: Navigera till webbsidan
		page.navigate("http://uitestingplayground.com/sampleapp"); // Ändra till den rätta URL:en

		// Steg 2: Fylla i användarnamn och lösenord
		page.fill("input[placeholder='User Name']", "Tara");

		page.fill("input[placeholder='********']", "pwd");

		// Steg 3: Klicka på login-knappen
		page.click("#login");

		// Steg 4: Verifiera att inloggningen lyckades
		boolean loginSuccessful = page.isVisible("text=Welcome, Tara!");
		assertTrue(loginSuccessful, "Failed to log in.");
	}
}
