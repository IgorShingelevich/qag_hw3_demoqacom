package tests;

import org.junit.jupiter.api.AfterAll;
import pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

public class TestBase {
// split variables into declaration and initialization

    String firstName;
    String lastName;
    String userEmail;
    String userNumber;
    String userDayDob;
    String userMonthDob;
    String userYearDob;
    String currentAddress;
    String userGenter;
    List<String> userSubjects;
    String userPicture;
    String userHobbies;
    String userState;
    String userCity;

    pages.RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";  // baseUrl = "https://demoqa.com"
        Configuration.browserSize = "1920x1080"; // browserSize hd 1080p
//        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;    //headless mode
        //position of the browser window
        //Configuration.browserPosition = "0,0";
    }

    @AfterAll // close browser after 5 seconds
    static void tearDown() { //copy-paste not understand
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
