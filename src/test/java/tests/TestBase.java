package tests;

import Pages.registrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    Pages.registrationPage registrationPage = new registrationPage();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";  // baseUrl = "https://demoqa.com"
        Configuration.browserSize = "1920x1080"; // browserSize hd 1080p
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;    //headless mode
        //position of the browser window
        //Configuration.browserPosition = "0,0";
    }
}
