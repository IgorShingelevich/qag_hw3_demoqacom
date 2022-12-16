package tests;


import org.junit.jupiter.api.Test;

import static tests.TestData.*;
import static utils.RandomUtils.*;
import static utils.RandomUtils.randomItemFromAllArray;

/**
 * Page Object organisation *
 *
 * @1.PageClass Create a class for RegistrationPage class (and extend it from TestBase class)
 * @2.TestBase Create a class for TestBase class and call it from RegistrationPage class. BeforeAll and AfterAll methods should be in TestBase class
 * @3.TestClass Create a class for RegistrationWithPageObjectsTests class
 * @4.PageClass_SelenideElement In RegistrationPage class create SelenideElement for all the locators.  For example: private SelenideElement firstNameInputLocator =  $("#firstName");
 * @5.pageMethods In RegistrationPage class create  a set of pageMethods -From  openPage() to submit()
 * @6.testMethods In RegistrationTest class then call the methods   openPage() from the RegistrationPage class in testMethods- new RegistrationPage.openPage()
 * @7.utils.RandomUtils Create a class for RandomUtils class and call it from RegistrationPage class.
 * @8.TestData_declare In TestData declare the variables for the data that will be used in the test
 * @9.TestClass_initialize In TestClass initialize the variables with the data from TestData class inside the test method
 *
 */
public class RegistrationWithPageObjectsTests extends TestBase {



    @Test
    void successfulRegistrationTest() {

        firstName = "Igor";
        lastName = "Shingelevich";
        userEmail = randomEmailRndDomainSetLen(2).toString();             // why .toString()?
        userNumber = randomPhone("7", 9);                 // how to use regex formatting for phone number?
        userDayDob = randomDobDay().toString();                  // rnd day implementation according to Month?
        userMonthDob = randomDobMonth().toString();                            // why .toString()? determined list - no arguments in methods?
        userYearDob = randomDobYear().toString();
        currentAddress = "Moscow";
        userGenter = randomItemFromAllArray(userGenterArray).toString();  // why .toString()?   error - randomItemFromAllArray
        userSubject = randomItemFromAllArray(userSubjectsArray);        // undetermined list - set arguments in methods? error -  randomItemFromAllArray
        userPicture = "src/test/java/resources/a_test_png_logo.png";
        userHobbies = randomItemFromAllArray(userHobbiesArray).toString();  // error - randomItemFromAllArray
       // userState = "NCR";
       // userCity = "Delhi";

        registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(userEmail);
        registrationPage.setGenterWrapper(userGenter);
        registrationPage.setDateOfBirth(userDayDob, userMonthDob, userYearDob);
        registrationPage.setUserNumber(userNumber);
        registrationPage.setSubject(userSubject);
        registrationPage.setHobbies(userHobbies);
        registrationPage.uploadPicture(userPicture);
        registrationPage.setCurrentAddress(currentAddress);
        registrationPage.setState(userState);
        registrationPage.setCity(userCity);
        registrationPage.clickSubmitButton();
        registrationPage.openModalWindow();
        registrationPage.checkModalWindow(firstName, lastName, userEmail, userNumber, userGenter, userHobbies, userSubject, currentAddress, userState, userCity);

    }
 /* TODO
              difference between utils.RandomUtils.randomItemFromAllArray and _OLD_ method that cause the error with randomItemFromAllArray    ArrayIndexOutOfBoundsException  https://rollbar.com/blog/how-to-fix-the-array-index-out-of-bounds-excepiton-in-java/
              how to pass min year to randomDobYear() method?       utils.RandomUtils.randomDob
              How to parse String and send multiple values to constructor for parsing randomDob().toString     https://stackoverflow.com/questions/41498163/how-to-parse-string-and-send-multiple-values-to-constructor
              why .toString() - in variables                                                         utils.RandomUtils.randomEmailRndDomainSetLen
              this. and static
              setSubject(userSubject) to multiple random subjects in one field from the array              pages.RegistrationPage.setSubject
             import Java Faker for Faker faker = new Faker()                                    utils/RandomUtils.java:214
              the file upload -  set rnd from folder                                            pages.RegistrationPage.uploadPicture
             reg ex apply ("(\\d{3})(?=\\d)", "$1 ").replaceAll(" ", "-")) for phone number using  randomLongRange(10000L, 1000000l)) .toString()       utils.RandomUtils.randomPhone
             represent Check Modal Window as Selenide Collection for separated rows        pages.RegistrationPage.checkModalWindow
              search alternatives for   userDayDobSelectLocator implementation
              do not understand uploadPicture method alternative                                                      https://github.com/MrDos180/demoqa_test/blob/ddfc0be12eede26a10962a9432ef7ec5c760f5a5/src/test/java/pages/RegistrationPage.java#L84
              do not understand how to implement stateLocator          $x("//div[text()='" + value + "']").click();     https://github.com/MrDos180/demoqa_test/blob/ddfc0be12eede26a10962a9432ef7ec5c760f5a5/src/test/java/pages/RegistrationPage.java#L96
              negative test case - check the error message
              replaceAll() for regex
             */

}
