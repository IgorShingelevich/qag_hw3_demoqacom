package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

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

    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove();");
        executeJavaScript("$('footer').remove();");
        practiceFormWrapperLocator.shouldHave(text(TITLE_TEXT));           //check that the page is open at all
    }

    public void setFirstName(String FirstNameArg) {                        // bad decision to hardcode the value     public void setLastName(){$("#lastName").setValue("Shingelevich");}
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

    public void setGenterWrapper(String GenterArg) {                           //!!! I did not understand how to set the value of the radio button, but it works
        userGenterWrapperLocator.$(byText(GenterArg)).click();
    }

    public void setDateOfBirth(String dayArg, String monthArg, String yearArg) {
        userDateOfBirthContainerLocator.click();
        userMonthDobSelectLocator.selectOption(monthArg);
        userYearDobSelectLocator.selectOption(yearArg);
        $(".react-datepicker__day--0" + dayArg + ":not(.react-datepicker__day--outside-month)").click();
    }

    public void setSubject(String randomSubjectListArg) {
            subjectsInputLocator.setValue(randomSubjectListArg).pressEnter();

    }

    public void setHobbies(String HobbiesArg) {                           //!!! I did not understand how to set the value of the radio button, but it works
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

    public void openModalWindow() {
        modalTitleLocator.should(appear);
        modalTitleLocator.shouldHave(text(MODAL_TITLE));
    }

    public void checkModalWindow(String FirstNameArg, String LastNameArg, String EmailArg, String UserNumberArg, String GenterArg, String HobbiesArg, String randomSubjectListArg, String CurrentAddressArg, String StateArg, String CityArg) {
        tableLocator.shouldHave(text(FirstNameArg));
        tableLocator.shouldHave(text(LastNameArg));
        tableLocator.shouldHave(text(EmailArg));
        tableLocator.shouldHave(text(UserNumberArg));
        tableLocator.shouldHave(text(randomSubjectListArg));
        tableLocator.shouldHave(text(GenterArg));
        tableLocator.shouldHave(text(HobbiesArg));
        tableLocator.shouldHave(text(CurrentAddressArg));
        tableLocator.shouldHave(text(StateArg));
        tableLocator.shouldHave(text(CityArg));
    }


}
