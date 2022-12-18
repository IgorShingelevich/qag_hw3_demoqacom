package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {


    private SelenideElement
            userDateOfBirthContainerLocator = $("#dateOfBirthInput"),
            userMonthDobSelectLocator = $(".react-datepicker__month-select"),
            userYearDobSelectLocator = $(".react-datepicker__year-select");


    public void setDateOfBirthCalendar(String dayArg, String monthArg, String yearArg) {
        userDateOfBirthContainerLocator.click();
        userMonthDobSelectLocator.selectOption(monthArg);
        userYearDobSelectLocator.selectOption(yearArg);
        $(".react-datepicker__day--0" + dayArg + ":not(.react-datepicker__day--outside-month)").click();
    }

}
