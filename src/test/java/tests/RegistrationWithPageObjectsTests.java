package tests;



import Pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationWithPageObjectsTests {
    @BeforeAll
static void setup() {
        Configuration.baseUrl = "https://demoqa.com";  // baseUrl = "https://demoqa.com"
        Configuration.browserSize = "1920x1080"; // browserSize hd 1080p
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;    //headless mode
        //position of the browser window
       //Configuration.browserPosition = "0,0";
    }

    @Test
    void succsessfulRegistrationTest() {
        String firstName = "Igor";
        String lastName = "Shingelevich";
        String userEmail = "shingelevich@gmail.com";
        String userNumber = "1234567890";
        String currentAddress = "Moscow";

        new RegistrationPage().openPage(); // open page
        new RegistrationPage().setFirstName(firstName); // set first name
        new RegistrationPage().setLastName(lastName); // set last name



        $("#firstName").setValue(firstName); // possible syntax for filling in the form $("#userName").setValue("John Smith") or $("[id='userName']")

        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(userNumber);
        $("#genterWrapper").$(byText("Other")).click(); //informative

        //        $("label[for='gender-radio-1']").click(); //good
        //        $("#gender-radio-1").parent().click();  // not informative
        //        $(byText("Other")).click();  //may cause problems with translation into other languages. Other - is widespread word

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January"); // other way  $(".react-datepicker__month-select").selectOptionByValue("1")


        $(".react-datepicker__year-select").selectOptionByValue("1985");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click(); //syntax :not(.
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click(); //informative
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/a_test_png_logo.png"));  //     $("#uploadPicture").uploadFromClasspath("");  // only type=file

        $("#currentAddress").setValue(currentAddress);
        $("#state").click();

        $("#stateCity-wrapper").$("#react-select-3-option-0").click(); //        $("#stateCity-wrapper").$(byText("NCR")).click(); // other way
        $("#city").click();

        $("#city").$(byText("Delhi")).click(); //        $("#city").$("#react-select-4-option-0").click(); // other way
        $("#submit").click();

       //assertions
        $(".modal-title").should(appear);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Igor"), text("Shingelevich"), text(userEmail), text(userNumber), text("Other"), text("30 January,1985"), text("Maths, Arts"), text("Sports"), text("a_test_png_logo.png"), text(currentAddress), text("NCR Delhi"));


    }


}
