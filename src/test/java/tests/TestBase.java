package tests;

import pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

public class TestBase {

    String firstName = "Igor";
    String lastName = "Shingelevich";
    String userEmail = "shingelevich@gmail.com";
    String userNumber = "1234567890";
    String currentAddress = "Moscow";
    String userGenter = "Other";
    //read from file txt
    List<String> userSubjects = List.of("Maths", "Arts", "Chemistry");
    String userPicture = "src/test/java/resources/a_test_png_logo.png";
    String userHobbies = "Sports";
    String userState = "NCR";
    String userCity = "Delhi";





    pages.RegistrationPage registrationPage = new RegistrationPage();



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
