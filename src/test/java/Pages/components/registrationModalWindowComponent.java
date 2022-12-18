package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationModalWindowComponent {
    private final String MODAL_TITLE = "Thanks for submitting the form"; // MODAL_TITLE is constant
    private SelenideElement
            modalTitleLocator = $(".modal-title"),
            tableLocator = $(".table-responsive");

    public void appearModalWindowComponent(String MODAL_TITLEArg) {
        tableLocator.should(appear);
        modalTitleLocator.shouldHave(text(MODAL_TITLEArg));
    }

}
