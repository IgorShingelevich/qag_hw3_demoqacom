package tests;



import pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object organisation
 * 1. Create a class for RegistrationPage
 * 2. Create inside  RegistrationPage class  a method for opening the page - openPage() and put inside also the check that the page is open
 * 3. Then call the method openPage() from the RegistrationPage class - new RegistrationPage.openPage() in RegistrationTest  test class
 * 4. Put all locators in one place - RegistrationPage class
 * 5. In RegistrationPage class set variables for locators.  For example: private SelenideElement firstNameInputLocator =  $("#firstName");
 * 6. In TestBase class set variables for all input fields and call them in RegistrationPage class. For example: String firstName = "Igor";
 * 7. Create a method for each locator variable and field value variable. For example: setFirstName(String value) { firstNameInputLocator.setValue(value); }
 * 8. From RegistrationTest class call the method from the RegistrationPage class - new RegistrationPage.setFirstName(userName) in RegistrationTest  test class
 * 9. In RegistrationPage class create a methods for filling all fields
 * 10. In RegistrationTest class call the methods from the RegistrationPage class - new RegistrationPage.setFirstName(userName) in RegistrationTest  test class
 *
 * *
 */
public class RegistrationWithPageObjectsTests extends TestBase {


    @Test
    void succsessfulRegistrationTest() {


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
        $(".table-responsive").shouldHave(text("Igor"), text("Shingelevich"), text(userEmail), text(userNumber), text("Other"),  text("Maths, Arts"), text("Sports"), text("a_test_png_logo.png"), text(currentAddress), text("NCR Delhi"));


    }


}
