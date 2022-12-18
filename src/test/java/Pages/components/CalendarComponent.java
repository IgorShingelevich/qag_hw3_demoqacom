package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    /*public void setDate(String day, String month, String year) { //3set attributes string day, month, year
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month); // other way  $(".react-datepicker__month-select").selectOptionByValue("1")
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day--0" + day +":not(.react-datepicker__day--outside-month)").click(); //syntax :not(.

    }*/

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
