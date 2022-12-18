package old;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
static void setup() {
        // hold the browser open
        Configuration.holdBrowserOpen = true;
        // set the browser to Chrome
        Configuration.browser = "chrome";
        // browserSize hd 1080p
        Configuration.browserSize = "1920x1080";
        // baseUrl = "https://demoqa.com"
        Configuration.baseUrl = "https://demoqa.com";
        //headless mode
        Configuration.headless = false;
        //position of the browser window
       //Configuration.browserPosition = "0,0";

    }

    @Test
    void fillFormTest() {


     open ("/text-box");
     // possible syntax for filling in the form
        // $("#userName").setValue("John Smith") or $("[id='userName']")
     $("#userName").setValue("Igor");
     $("[id='userEmail']").setValue("Igor@igor.com");
     $("[id='currentAddress']").setValue("address1");
     $("[id='permanentAddress']").setValue("address2");
     $("[id='submit']").click();

     //assertions
        //possible syntax for assertions
        // element inside other element &( "#output > #name") or $("#output").$( "#name")
        $("[id='output']").shouldBe(Condition.visible);
        //if visible, then print ln
        System.out.println("The form is visible");
        $("#output #email").shouldHave(Condition.text("Igor@igor.com"));
        $("#output").$( "#name").shouldHave(Condition.text("Igor"));


    }


}
