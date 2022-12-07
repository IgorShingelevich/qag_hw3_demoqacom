package tests;



import Pages.registrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationWithPageObjectsTests extends TestBase {


    @Test
    void succsessfulRegistrationTest() {
        String firstName = "Igor";
        String lastName = "Shingelevich";
        String userEmail = "shingelevich@gmail.com";
        String userNumber = "1234567890";
        String currentAddress = "Moscow";

        // economy of memory

        registrationPage.openPage(); // open page
        registrationPage.setFirstName(firstName); // set first name
        registrationPage.setLastName(lastName); // set last name
        registrationPage.setEmail(userEmail); // set email
        registrationPage.setGenterWrapper("Other");



        $("#firstName").setValue(firstName); // possible syntax for filling in the form $("#userName").setValue("John Smith") or $("[id='userName']")

        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(userNumber);


        //        $("label[for='gender-radio-1']").clickk(); //good
        //        $("#gender-radio-1").parent().click();  // not informative
        //        $(byText("Other")).click();  //may cause problems with translation into other languages. Other - is widespread word


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
