package Pages.components;

import static com.codeborne.selenide.Selenide.$;
//1 cut fromregistrtionWithPageObject
public class CalendarComponent {
    public void setDate(String day, String month, String year) { //3set attributes string day, month, year
        // 2 paste here
        // 4 paste attributes in the method day, month, year
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month); // other way  $(".react-datepicker__month-select").selectOptionByValue("1")
        $(".react-datepicker__year-select").selectOptionByValue(year);
        //5 !!paste variable day in the middle of the selector ".react-datepicker__day--030:not(.react-datepicker__day--outside-month)"
        $(".react-datepicker__day--0" + day +":not(.react-datepicker__day--outside-month)").click(); //syntax :not(.

    }

}
