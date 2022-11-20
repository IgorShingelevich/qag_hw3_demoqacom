package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class RegistrationTests {
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

     open ("/automation-practice-form");

        //Configuration.browserSize = "0.5";

        executeJavaScript("$('#fixedban').remove();"); //executeJavaScript in Selenide to remove the banner and footer
        executeJavaScript("$('#footer').remove();");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(firstName); // possible syntax for filling in the form $("#userName").setValue("John Smith") or $("[id='userName']")
        $("#lastName").setValue(lastName);
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

       /* $("#output").shouldBe(Condition.visible);
        $("#output #name").shouldHave(text(firstName));
        $("#output #email").shouldHave(text(userEmail));*/




    }


}
