package examples;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {

    void cssXpathExamples(){
        //example we have data-testid="email"
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email]").setValue("1");
        $(by("data-testid", "email")).setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email>
        $("[data-testid=email]").setValue("1");
        $("#email").setValue("1");
        // by attribute and value
        $(by("id", "email")).setValue("1");
        //by Xpath
        Selenide.$x("//*[@id=email]").setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email">
        // by attribute name and value email
        $(by("name", "email")).setValue("1");
        //byName
        $(byName("email")).setValue("1");
        // <input type="email" class="inputtext login_form_input_box">
        //by class
        $("[class=login_form_input_box]").setValue("1");
        //by class shortcut .class
        $(".login_form_input_box.inputtext").setValue("1"); //simultaneously two attributes no space

        // by id shortcut #id
        $("#email").setValue("1");
        // by Xpath
        $x("//input[@class='login_form_input_box'][@class='inputtext']").setValue("1");
/*
           <div class="inputtext>
                <input type="email" class="login_form_input_box">
           </div>
         */

        $(".login_form_input_box.inputtext").setValue("1"); //simultaneously two attributes no space in one element
        $(".login_form_input_box .inputtext").setValue("1"); // space between two attributes means child

        $(".login_form_input_box").$(".inputtext").setValue("1"); // similar to above

        // <div>Hello qa.guru</div>
        //by Xpath
        $x("//div[text()='Hello qa.guru']");
        //by text in Selenide
        $(byText("Hello qa.guru"));






    }

}
