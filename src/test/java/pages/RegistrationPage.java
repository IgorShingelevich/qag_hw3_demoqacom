package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationModalWindowComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationModalWindowComponent registrationModalWindowComponent = new RegistrationModalWindowComponent();


    private final String TITLE_TEXT = "Student Registration Form"; // TITLE_TEXT is constant
    private final String MODAL_TITLE = "Thanks for submitting the form"; // MODAL_TITLE is constant

    private SelenideElement

            practiceFormWrapperLocator = $(".practice-form-wrapper"),
            firstNameInputLocator = $("#firstName"),                             // or $("[id='firstName']")
            lastNameInputLocator = $("#lastName"),
            userEmailInputLocator = $("#userEmail"),
            userNumberInputLocator = $("#userNumber"),
            userDateOfBirthContainerLocator = $("#dateOfBirthInput"),  // or $("[id='dateOfBirthInput']") or $(.react-datepicker__input-container)
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

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove();");
        executeJavaScript("$('footer').remove();");
        practiceFormWrapperLocator.shouldHave(text(TITLE_TEXT));
        return this;
    }

    public RegistrationPage setFirstName(String firstNameArg) {                        // bad decision to hardcode the value     public void setLastName(){$("#lastName").setValue("Shingelevich");}
        firstNameInputLocator.setValue(firstNameArg);
        return this;
    }

    public RegistrationPage setLastName(String lastNameArg) {
        lastNameInputLocator.setValue(lastNameArg);
        return this;
    }

    public RegistrationPage setEmail(String emailArg) {
        userEmailInputLocator.setValue(emailArg);
        return this;
    }

    public RegistrationPage setUserNumber(String userNumberArg) {
        userNumberInputLocator.setValue(userNumberArg);
        return this;
    }

    public RegistrationPage setGenterWrapper(String genterArg) {                           //!!! I did not understand how to set the value of the radio button, but it works
        userGenterWrapperLocator.$(byText(genterArg)).click();
        return this;
    }

    public RegistrationPage setDateOfBirth(String dayArg, String monthArg, String yearArg) {
        calendarComponent.setDateOfBirthCalendar(dayArg, monthArg, yearArg);
        return this;
    }


    public RegistrationPage setSubject(String randomSubjectListArg) {
            subjectsInputLocator.setValue(randomSubjectListArg).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbiesArg) {                           //!!! I did not understand how to set the value of the radio button, but it works
        hobbiesWrapperLocator.$(byText(hobbiesArg)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String picturePathArg) {                   // do not understand other solution https://github.com/MrDos180/demoqa_test/blob/ddfc0be12eede26a10962a9432ef7ec5c760f5a5/src/test/java/pages/RegistrationPage.java#L84
        uploadPictureLocator.uploadFile(new File(picturePathArg));
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddressArg) {
        currentAddressInputLocator.setValue(currentAddressArg);
        return this;
    }

    public RegistrationPage setState(String stateArg) {
        stateContainerLocator.click();
        stateDropdownNCRLocator.$(byText(stateArg)).click();
        return this;
    }

    public RegistrationPage setCity(String cityArg) {
        cityContainerLocator.click();
        cityContainerLocator.$(byText(cityArg)).click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButtonLocator.click();
        return this;
    }

    public RegistrationPage openModalWindowComponent() {
        registrationModalWindowComponent.appearModalWindowComponent(MODAL_TITLE);
        return this;
    }

    public RegistrationPage checkModalWindowComponent(String firstNameArg, String lastNameArg, String emailArg, String userNumberArg, String genterArg, String hobbiesArg, String randomSubjectListArg, String currentAddressArg, String stateArg, String cityArg) {
        tableLocator.shouldHave(
        text(firstNameArg),
        text(lastNameArg),
        text(emailArg),
        text(userNumberArg),
        text(randomSubjectListArg),
        text(genterArg),
        text(hobbiesArg),
        text(currentAddressArg),
        text(stateArg),
        text(cityArg));
        return this;
    }




    public RegistrationPage checkStudentName(String firstNameArg) {
        tableLocator.shouldHave(text(firstNameArg));
        return this;
    }

    public RegistrationPage checkStudentLastName(String lastNameArg) {
        tableLocator.shouldHave(text(lastNameArg));
        return this;
    }

    public RegistrationPage checkStudentEmail(String emailArg) {
        tableLocator.shouldHave(text(emailArg));
        return this;
    }

    public RegistrationPage checkStudentGender(String genterArg) {
        tableLocator.shouldHave(text(genterArg));
        return this;
    }

    public RegistrationPage checkStudentMobile(String userNumberArg) {
        tableLocator.shouldHave(text(userNumberArg));
        return this;
    }

    public RegistrationPage checkStudentDateOfBirth(String dayArg, String monthArg, String yearArg) {
        tableLocator.shouldHave(text(dayArg + " " + monthArg + "," + yearArg));
        return this;
    }

    public RegistrationPage checkStudentSubjects(String randomSubjectListArg) {
        tableLocator.shouldHave(text(randomSubjectListArg));
        return this;
    }

    public RegistrationPage checkStudentHobbies(String hobbiesArg) {
        tableLocator.shouldHave(text(hobbiesArg));
        return this;
    }

    public RegistrationPage checkStudentPicture(String picturePathArg) {
        tableLocator.shouldHave(text(picturePathArg));
        return this;
    }

    public RegistrationPage checkStudentAddress(String currentAddressArg) {
        tableLocator.shouldHave(text(currentAddressArg));
        return this;
    }

    public RegistrationPage checkStudentStateAndCity(String stateArg, String cityArg) {
        tableLocator.shouldHave(text(stateArg + " " + cityArg));
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationModalWindowComponent.verifyResultsModalWindowComponent(key, value);
        return this;
    }



    public void closeBrowser() {
        closeWebDriver();
    }




    public RegistrationPage closeModalWindowComponent() {
        registrationModalWindowComponent.closeModalWindowComponent();
        return this;
    }




}
