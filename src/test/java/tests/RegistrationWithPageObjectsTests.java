package tests;


import org.junit.jupiter.api.Test;

import java.util.List;

/** Page Object organisation *
 * @1. Create a class for RegistrationPage class (and extend it from TestBase class)
 * @2. Create a class for TestBase class and call it from RegistrationPage class. BeforeAll and AfterAll methods should be in TestBase class
 * @3. Create a class for RegistrationWithPageObjectsTests class
 * @4. In RegistrationPage class create SelenideElement for all the locators.  For example: private SelenideElement firstNameInputLocator =  $("#firstName");
 * @5. In RegistrationPage class create  a methods for interacting with the page -From  openPage() to submit()
 * @6. In RegistrationTest class then call the methods   openPage() from the RegistrationPage class - new RegistrationPage.openPage()
 * @7. In TestBase class declare all the variables
 * @8. In RegistrationTest initialize all the variables inside specific test method and pass them to the methods from RegistrationPage class
 *
 */
public class RegistrationWithPageObjectsTests extends TestBase {

    // split variables into declaration and initialization


    @Test
    void successfulRegistrationTest() {

        String firstName,
                lastName,
                userEmail,
                userNumber,
                userDayDob,
                userMonthDob,
                userYearDob,
                currentAddress,
                userGenter,
                userPicture,
                userHobbies,
                userState,
                userCity;
        List<String> userSubjectsList;



        firstName = "Igor";
        lastName = "Shingelevich";
        userEmail = "shingelevich@gmail.com";
        userNumber = "1234567890";
        userDayDob = "22";
        userMonthDob = "January";
        userYearDob = "1985";
        currentAddress = "Moscow";
        userGenter = "Other";
        userSubjectsList = List.of("Maths", "Arts", "Chemistry");
        userPicture = "src/test/java/resources/a_test_png_logo.png";
        userHobbies = "Sports";
        userState = "NCR";
        userCity = "Delhi";

        registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(userEmail);
        registrationPage.setGenterWrapper(userGenter);
        registrationPage.setDateOfBirth(userDayDob, userMonthDob, userYearDob);
        registrationPage.setUserNumber(userNumber);
        registrationPage.setSubjects(userSubjectsList);
        registrationPage.setHobbies(userHobbies);
        registrationPage.uploadPicture(userPicture);
        registrationPage.setCurrentAddress(currentAddress);
        registrationPage.setState(userState);
        registrationPage.setCity(userCity);
        registrationPage.clickSubmitButton();
        registrationPage.openModalWindow();
        registrationPage.checkModalWindow(firstName, lastName, userEmail, userNumber, userGenter, userHobbies, currentAddress, userState, userCity);

    }
 /* TODO
             check the file upload,
             check the list of subjects
             represent Modal Window as Selenide Collection
              search alternatives for   userDayDobSelectLocator implementation
              do not understand uploadPicture method alternative                                                      https://github.com/MrDos180/demoqa_test/blob/ddfc0be12eede26a10962a9432ef7ec5c760f5a5/src/test/java/pages/RegistrationPage.java#L84
              do not understand how to implement stateLocator          $x("//div[text()='" + value + "']").click();     https://github.com/MrDos180/demoqa_test/blob/ddfc0be12eede26a10962a9432ef7ec5c760f5a5/src/test/java/pages/RegistrationPage.java#L96
              negative test case - check the error message
              replaceAll() for regex
             */

}
