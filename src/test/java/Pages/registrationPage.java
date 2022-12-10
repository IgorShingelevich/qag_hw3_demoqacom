package pages;

import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final String TITLE_TEXT = "Student Registration Form"; // TITLE_TEXT is constant
    private final String MODAL_TITLE = "Thanks for submitting the form"; // MODAL_TITLE is constant
    private final int userDayDob = 22; // bad solution


    //    String userState = "NCR";
    // 5. In RegistrationPage class set variables for locators.
    private SelenideElement
            firstNameInputLocator = $("#firstName"),                             // or $("[id='firstName']")
            lastNameInputLocator = $("#lastName"),
            userEmailInputLocator = $("#userEmail"),
            userNumberInputLocator = $("#userNumber"),
            userDateOfBirthContainerLocator = $("#dateOfBirthInput"),  // or $("[id='dateOfBirthInput']") or $(.react-datepicker__input-container)


    userDayDobSelectLocator = $(".react-datepicker__day--0" + userDayDob + ":not(.react-datepicker__day--outside-month)"),  // !! how to set 30  as a variable inside the locator
            userMonthDobSelectLocator = $(".react-datepicker__month-select"),
            userYearDobSelectLocator = $(".react-datepicker__year-select"),

    userGenterWrapperLocator = $("#genterWrapper"),
            subjectsInputLocator = $("#subjectsInput"),
            hobbiesWrapperLocator = $("#hobbiesWrapper"),
            uploadPictureLocator = $("#uploadPicture"),
            currentAddressInputLocator = $("#currentAddress"),
            stateContainerLocator = $("#state"),

    stateDropdownNCRLocator = $("#stateCity-wrapper"),    // or $("#stateCity-wrapper").$("#react-select-3-option-0");  $("#stateCity-wrapper").$(byText(userState)  //  $("#stateCity-wrapper").$("#react-select-3-option-0")   $(byText("NCR"))
            cityContainerLocator = $("#city"), // $("#city").$("#react-select-4-option-0")  $("#city").$(byText("Delhi"))
            submitButtonLocator = $("#submit"),
            modalTitleLocator = $(".modal-title"),
            tableLocator = $(".table-responsive");

    //set method for Date of Birth
    public void setDateOfBirth(String monthArg, String yearArg) {
        userDateOfBirthContainerLocator.click();
        userMonthDobSelectLocator.selectOption(monthArg);
        userYearDobSelectLocator.selectOption(yearArg);
        userDayDobSelectLocator.click();

    }


    /**
     * $("label[for='gender-radio-1']").clickk(); //good
     * $("#gender-radio-1").parent().click();  // not informative
     * $(byText("Other")).click();  //may cause problems with translation into other languages. Other - is widespread word
     */


    // 2. Create inside  RegistrationPage class  a method for opening the page
    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove();");
        executeJavaScript("$('footer').remove();");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));           //check that the page is open at all
    }


    //6. In TestBase class set variables for all input fields
    public void setFirstName(String FirstNameArg) {                                            // bad decision to hardcode the value     public void setLastName(){$("#lastName").setValue("Shingelevich");}
        firstNameInputLocator.setValue(FirstNameArg);
    }

    public void setLastName(String LastNameArg) {
        lastNameInputLocator.setValue(LastNameArg);
    }

    public void setEmail(String EmailArg) {
        userEmailInputLocator.setValue(EmailArg);
    }

    public void setUserNumber(String UserNumberArg) {
        userNumberInputLocator.setValue(UserNumberArg);
    }

    public void setGenterWrapper(String GenterArg) {                           //!!! I did not understand how to set the value of the radio button but it works
        userGenterWrapperLocator.$(byText(GenterArg)).click();
    }

    public void setSubjects(List<String> subjects) {
        // set cycle for subjects
        for (String subject : subjects) {
            subjectsInputLocator.setValue(subject).pressEnter();
        }
    }

    public void setHobbies(String HobbiesArg) {                           //!!! I did not understand how to set the value of the radio button but it works
        hobbiesWrapperLocator.$(byText(HobbiesArg)).click();
    }

    public void uploadPicture(String PicturePathArg) {                   // do not understand other solution https://github.com/MrDos180/demoqa_test/blob/ddfc0be12eede26a10962a9432ef7ec5c760f5a5/src/test/java/pages/RegistrationPage.java#L84
        uploadPictureLocator.uploadFile(new File(PicturePathArg));
    }

    public void setCurrentAddress(String CurrentAddressArg) {
        currentAddressInputLocator.setValue(CurrentAddressArg);
    }

    public void setState(String StateArg) {
        stateContainerLocator.click();
        stateDropdownNCRLocator.$(byText(StateArg)).click();
    }

    public void setCity(String CityArg) {
        cityContainerLocator.click();
        cityContainerLocator.$(byText(CityArg)).click();
    }

    public void clickSubmitButton() {
        submitButtonLocator.click();
    }

    //method for checking the data in the table
    public void openModalWindow() {
        modalTitleLocator.should(appear);
        modalTitleLocator.shouldHave(text(MODAL_TITLE));
    }

    public void checkModalWindow(String FirstNameArg, String LastNameArg, String EmailArg, String UserNumberArg, String GenterArg, String HobbiesArg, String CurrentAddressArg, String StateArg, String CityArg) {
        tableLocator.shouldHave(text(FirstNameArg));
        tableLocator.shouldHave(text(LastNameArg));
        tableLocator.shouldHave(text(EmailArg));
        tableLocator.shouldHave(text(UserNumberArg));
        tableLocator.shouldHave(text(GenterArg));
        ;
        tableLocator.shouldHave(text(HobbiesArg));
        tableLocator.shouldHave(text(CurrentAddressArg));
        tableLocator.shouldHave(text(StateArg));
        tableLocator.shouldHave(text(CityArg));
    }



}
