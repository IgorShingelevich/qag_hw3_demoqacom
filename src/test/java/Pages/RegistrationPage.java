package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    /*
    let's organise our locators in one place
    private SelenideElement firstNameInputLocator =  $("#firstName");
    private SelenideElement lastNameInputLocator =  $("#lastName"); */
    private SelenideElement // set variables for locators
        firstNameInputLocator = $("#firstName"), // set variables for #firstName
        lastNameInputLocator = $("#lastName"), // set variables for #lastName
        userEmailInputLocator = $("#userEmail"), // set variables for #userEmail

         userNumberInputLocator = $("#userNumber"); // set variables for #userNumber


    private String titleText = "Student Registration Form";// optimization shouldHave(text(formTitle));
    public void openPage() { // open("https://demoqa.com/automation-practice-form");
        open ("/automation-practice-form");

        //Configuration.browserSize = "0.5";

        executeJavaScript("$('#fixedban').remove();");
        executeJavaScript("$('footer').remove();");

        $(".practice-form-wrapper").shouldHave(text(titleText)); //check that the page is open at all
    }

    public void setFirstName(String value) { // $("#firstName").setValue(firstName);
        firstNameInputLocator.setValue(value);
    }
     /* bad decision to hardcode the value
     public void setLastName(){
         $("#lastName").setValue("Shingelevich");

     }*/
    public void setLastName(String value) { // $("#lastName").setValue(lastName);
        lastNameInputLocator.setValue(value);
    }
    public void clearLastName() { // $("#lastName").clear();
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

}
