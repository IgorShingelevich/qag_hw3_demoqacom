package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class registrationPage {
    // optimization shouldHave(text(formTitle));
    private String TITLE_TEXT = "Student Registration Form";

    /*
    let's organise our locators in one place
    private SelenideElement firstNameInputLocator =  $("#firstName");
    private SelenideElement lastNameInputLocator =  $("#lastName"); */
    private SelenideElement // set variables for locators
        firstNameInputLocator = $("#firstName"), // set variables for #firstName
        lastNameInputLocator = $("#lastName"), // set variables for #lastName
        userEmailInputLocator = $("#userEmail"), // set variables for #userEmail

         userNumberInputLocator = $("#userNumber"),
        userGenterWrapperLocator = $("#genterWrapper");


   


    // open("https://demoqa.com/automation-practice-form");
    public void openPage() {
        open ("/automation-practice-form");
        //Configuration.browserSize = "0.5";
        executeJavaScript("$('#fixedban').remove();");
        executeJavaScript("$('footer').remove();");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT)); //check that the page is open at all
    }

    // $("#firstName").setValue(firstName)
    public void setFirstName(String value) {

        firstNameInputLocator.setValue(value);
    }
     /* bad decision to hardcode the value
     public void setLastName(){
         $("#lastName").setValue("Shingelevich");

     }*/

    public void setLastName(String value) {
        // $("#lastName").setValue(lastName);
        lastNameInputLocator.setValue(value);
    }

    // $("#lastName").clear()
    public void clearLastName() { ;

        lastNameInputLocator.clear();
    }

    //setEmail
    public void setEmail(String value) { // $("#userEmail").setValue(userEmail);

        userEmailInputLocator.setValue(value);
    }

    //setUserNumber
    public void setUserNumber(String value) { // $("#userNumber").setValue(userNumber);

        userNumberInputLocator.setValue(value);
    }

    //setGenterWrapper  $("#genterWrapper").setValue(
    public void setGenterWrapper(String value) { // $("#genterWrapper").setValue("Other")
            userGenterWrapperLocator.$(byText(value)).click();
    }



}
