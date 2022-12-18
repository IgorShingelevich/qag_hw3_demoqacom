package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationModalWindowComponent {
    private SelenideElement
            modalTitleLocator = $(".modal-title"),
            tableLocator = $(".table-responsive"),
            closeButtonLocator = $("#closeLargeModal");

    public void appearModalWindowComponent(String MODAL_TITLE) {
        tableLocator.should(appear);
        modalTitleLocator.shouldHave(text(MODAL_TITLE));
    }

    public void verifyResultsModalWindowComponent(String key, String value) {
        tableLocator.$(byText(key)).parent().shouldHave(text(value));  //codrall
    }

    public void closeModalWindowComponent() {
        closeButtonLocator.click();
    }

}
