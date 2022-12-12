package tests;


import org.junit.jupiter.api.Test;

import java.util.List;

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
    void successfulRegistrationTest() {
        /* String firstName = "Igor";
    String lastName = "Shingelevich";
    String userEmail = "shingelevich@gmail.com";
    String userNumber = "1234567890";
     String userDayDob = "22";
    String userMonthDob = "January";
    String userYearDob = "1985";
    String currentAddress = "Moscow";
    String userGenter = "Other";
    List<String> userSubjects = List.of("Maths", "Arts", "Chemistry");
    String userPicture = "src/test/java/resources/a_test_png_logo.png";
    String userHobbies = "Sports";
    String userState = "NCR";
    String userCity = "Delhi";*/

        firstName = "Igor";
        lastName = "Shingelevich";
        userEmail = "shingelevich@gmail.com";
        userNumber = "1234567890";
        userDayDob = "22";
        userMonthDob = "January";
        userYearDob = "1985";
        currentAddress = "Moscow";
        userGenter = "Other";
        userSubjects = List.of("Maths", "Arts", "Chemistry");
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
        registrationPage.setSubjects(userSubjects);
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
             */

}
