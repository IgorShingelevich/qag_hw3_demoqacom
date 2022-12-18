package tests;


import org.junit.jupiter.api.*;

import static tests.TestData.*;
import static utils.RandomUtils.*;

/**
 * Page Object organisation *
 *
 * @1.PageClass Create a class for RegistrationTest class (and extend it from TestBase class)
 * @2.TestBase Create a class for TestBase class and call it from RegistrationTest class. BeforeAll and AfterAll methods should be in TestBase class
 * @3.TestClass Create a class for RegistrationTest class
 * @4.PageClass_SelenideElement In RegistrationTest class create SelenideElement for all the locators.  For example: private SelenideElement firstNameInputLocator =  $("#firstName");
 * @5.pageMethods In RegistrationTest class create  a set of pageMethods -From  openPage() to submit()
 * @6.testMethods In RegistrationTest class then call the methods   openPage() from the RegistrationTest class in testMethods- new RegistrationTest.openPage()
 * @7.utils.RandomUtils Create a class for RandomUtils class and call it from RegistrationTest class.
 * @8.TestData_declare In TestData declare the variables for the data that will be used in the test
 * @9.TestClass_initialize In TestClass initialize the variables with the data from TestData class inside the test method
 * @10.CalendarComponent set methods  for CalendarComponent class and call it from RegistrationTest class. Add exemplar of CalendarComponent class in RegistrationTest class
 * @11.RegistrationModalWindowComponent set methods  for RegistrationModalWindowComponent class and call it from RegistrationTest class. Add exemplar of RegistrationModalWindowComponent class in RegistrationTest class
 */
public class RegistrationTest extends TestBase {


    @BeforeEach
        //before each test open the page
    void openPage() {
        registrationPage.openPage();
    }

    @AfterEach
    void closePage() {
        registrationPage
                .closeModalWindowComponent()
                .closeBrowser();
    }


    @DisplayName("successful registration with single form check")
    @Tags({@Tag("web"), @Tag("regression")})

    @Test
    void successfulRegistrationTestSingleCheck() {

        firstName = fakerRelativeName();
        lastName = fakerRelativeSurname();
        userEmail = randomEmailRndDomainSetLen(2).toString();             // why .toString()?
        userNumber = randomPhone("7", 9);                 // how to use regex formatting for phone number?
        userDayDob = randomDobDay().toString();                  // rnd day implementation according to Month?
        userMonthDob = randomDobMonth().toString();                            // why .toString()? determined list - no arguments in methods?
        userYearDob = randomDobYear().toString();
        currentAddress = fakerCity();
        userGenter = fakerRelativeGender();
        userSubject = randomItemFromAllArray(userSubjectsArray);        // undetermined list - set arguments in methods? error -  randomItemFromAllArray
        userPictureRepoPath = "src/test/resources/a_test_png_logo.png"; // ??  = "src/test/resources/" + userPicture;  = "src/test/resources/ " + userPicture
        userPicture = "a_test_png_logo.png";
        userHobbies = randomItemFromAllArray(userHobbiesArray).toString();  // error - randomItemFromAllArray
        userState = "NCR";
        userCity = "Delhi";

        registrationPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGenterWrapper(userGenter)
                .setDateOfBirth(userDayDob, userMonthDob, userYearDob)
                .setUserNumber(userNumber)
                .setSubject(userSubject)
                .setHobbies(userHobbies)
                .uploadPicture(userPictureRepoPath)
                .setCurrentAddress(currentAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmitButton()
                .openModalWindowComponent()
                .checkModalWindowComponent(firstName, lastName, userEmail, userNumber, userGenter, userHobbies, userSubject, currentAddress, userState, userCity);
    }

    @DisplayName("successful registration with multiple line form check")
    @Tags({@Tag("web"), @Tag("regression")})

    @Test
    void successfulRegistrationTestMultipleChecks() {

        firstName = fakerRelativeName();
        lastName = fakerRelativeSurname();
        userEmail = randomEmailRndDomainSetLen(2).toString();             // why .toString()?
        userNumber = randomPhone("7", 9);                 // how to use regex formatting for phone number?
        userDayDob = randomDobDay().toString();                  // rnd day implementation according to Month?
        userMonthDob = randomDobMonth().toString();                            // why .toString()? determined list - no arguments in methods?
        userYearDob = randomDobYear().toString();
        currentAddress = fakerCity();
        userGenter = fakerRelativeGender();
        userSubject = randomItemFromAllArray(userSubjectsArray);        // undetermined list - set arguments in methods? error -  randomItemFromAllArray
        userPictureRepoPath = "src/test/resources/a_test_png_logo.png"; // ??  = "src/test/resources/" + userPicture;  = "src/test/resources/ " + userPicture
        userPicture = "a_test_png_logo.png";
        userHobbies = randomItemFromAllArray(userHobbiesArray).toString();  // error - randomItemFromAllArray
        userState = "NCR";
        userCity = "Delhi";

        registrationPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGenterWrapper(userGenter)
                .setDateOfBirth(userDayDob, userMonthDob, userYearDob)
                .setUserNumber(userNumber)
                .setSubject(userSubject)
                .setHobbies(userHobbies)
                .uploadPicture(userPictureRepoPath)
                .setCurrentAddress(currentAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmitButton()
                .openModalWindowComponent()
                .checkStudentName(firstName)
                .checkStudentEmail(userEmail)
                .checkStudentGender(userGenter)
                .checkStudentMobile(userNumber)
                .checkStudentDateOfBirth(userDayDob, userMonthDob, userYearDob)
                .checkStudentSubjects(userSubject)
                .checkStudentHobbies(userHobbies)
                .checkStudentPicture(userPicture)
                .checkStudentAddress(currentAddress)
                .checkStudentStateAndCity(userState, userCity);
    }








 /* TODO
             learn transliteration library handling for Test Data
             https://mvnrepository.com/artifact/com.ibm.icu/icu4j/51.1
             https://stackoverflow.com/questions/16273318/transliteration-from-cyrillic-to-latin-icu4j-java
             https://ru.stackoverflow.com/questions/633355/%D0%9F%D0%BE%D0%BA%D0%B0%D0%B7%D0%B0%D1%82%D1%8C-%D0%BF%D1%80%D0%B0%D0%B2%D0%B8%D0%BB%D1%8C%D0%BD%D1%8B%D0%B9-%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%80-%D1%82%D1%80%D0%B0%D0%BD%D1%81%D0%BB%D0%B8%D1%82%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D0%B8-%D0%BD%D0%B0-java
              difference between utils.RandomUtils.randomItemFromAllArray and _OLD_ method that cause the error with randomItemFromAllArray    ArrayIndexOutOfBoundsException  https://rollbar.com/blog/how-to-fix-the-array-index-out-of-bounds-excepiton-in-java/
              how to pass min year to randomDobYear() method?       utils.RandomUtils.randomDob
              How to parse String and send multiple values to constructor for parsing randomDob().toString     https://stackoverflow.com/questions/41498163/how-to-parse-string-and-send-multiple-values-to-constructor
              why .toString() - in variables                                                         utils.RandomUtils.randomEmailRndDomainSetLen
              this. and static
              setSubject(userSubject) to multiple random subjects in one field from the array              pages.RegistrationTest.setSubject
             import Java Faker for Faker faker = new Faker()                                    utils/RandomUtils.java:214
              the file upload -  set rnd from folder                                            pages.RegistrationTest.uploadPicture
             reg ex apply ("(\\d{3})(?=\\d)", "$1 ").replaceAll(" ", "-")) for phone number using  randomLongRange(10000L, 1000000l)) .toString()       utils.RandomUtils.randomPhone
             represent Check Modal Window as Selenide Collection for separated rows        pages.RegistrationTest.checkModalWindow
              search alternatives for   userDayDobSelectLocator implementation
              do not understand uploadPicture method alternative                                                      https://github.com/MrDos180/demoqa_test/blob/ddfc0be12eede26a10962a9432ef7ec5c760f5a5/src/test/java/pages/RegistrationPage.java#L84
              do not understand how to implement stateLocator          $x("//div[text()='" + value + "']").click();     https://github.com/MrDos180/demoqa_test/blob/ddfc0be12eede26a10962a9432ef7ec5c760f5a5/src/test/java/pages/RegistrationPage.java#L96
              negative test case - check the error message
              replaceAll() for regex
             */

}
