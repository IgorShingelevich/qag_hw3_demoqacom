package tests;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object organisation
 *
 * @1. Create a class for RegistrationPage
 * @2. Create inside  RegistrationPage class  a method for opening the page - openPage() and put inside also the check that the page is open
 * @3. Then call the method openPage() from the RegistrationPage class - new RegistrationPage.openPage() in RegistrationTest  test class
 * @4. Put all locators in one place - RegistrationPage class
 * @5. In RegistrationPage class set variables for locators.  For example: private SelenideElement firstNameInputLocator =  $("#firstName");
 * @6. In TestBase class set variables for all input fields and call them in RegistrationPage class. For example: String firstName = "Igor";
 * @7. Create a method for each locator variable and field value variable. For example: setFirstName(String value) { firstNameInputLocator.setValue(value); }
 * @8. From RegistrationTest class call the method from the RegistrationPage class - new RegistrationPage.setFirstName(userName) in RegistrationTest  test class
 * @9. In RegistrationPage class create a methods for filling all fields
 * @10. In RegistrationTest class call the methods from the RegistrationPage class - new RegistrationPage.setFirstName(userName) in RegistrationTest  test class
 * <p>
 * <p>
 * *
 */
public class RegistrationWithPageObjectsTests extends TestBase {


    @Test
    void succsessfulRegistrationTest() {

        registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(userEmail);
        registrationPage.setGenterWrapper(userGenter);
        registrationPage.setDateOfBirth(userMonthDob, userYearDob);
        registrationPage.setUserNumber(userNumber);
        registrationPage.setSubjects(userSubjects);
        registrationPage.setHobbies(userHobbies);
        registrationPage.uploadPicture(userPicture);
        registrationPage.setCurrentAddress(currentAddress);
        registrationPage.setState(userState);
        registrationPage.setCity(userCity);
        registrationPage.clickSubmitButton();


        //assertions
        registrationPage.openModalWindow();
        registrationPage.checkModalWindow(firstName, lastName, userEmail, userNumber, userGenter, userHobbies, currentAddress, userState, userCity);


        /* TODO
             check the file upload,
             check the list of subjects
             represent Modal Window as Selenide Collection
              search alternatives for   userDayDobSelectLocator implementation
              do not understand uploadPicture method alternative                                                      https://github.com/MrDos180/demoqa_test/blob/ddfc0be12eede26a10962a9432ef7ec5c760f5a5/src/test/java/pages/RegistrationPage.java#L84
              do not understand how to implement stateLocator          $x("//div[text()='" + value + "']").click();     https://github.com/MrDos180/demoqa_test/blob/ddfc0be12eede26a10962a9432ef7ec5c760f5a5/src/test/java/pages/RegistrationPage.java#L96
              negative test case - check the error message


             */

    }


}
