package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @BeforeAll
    @Disabled
    public static void init(){
        Configuration.pageLoadStrategy="eager";
        open("https://demoqa.com/automation-practice-form");
        Configuration.timeout=6000;

    }

    @Disabled
    @Test
    void formCheck() throws InterruptedException {
        $("#firstName").setValue("Petya");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("p@mail.ru");
        $("#genterWrapper div:nth-of-type(2) > label").click();
        $("#userNumber").setValue("9096776685");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2023");
        $(".react-datepicker__month-select").selectOption("January");
        $("div.react-datepicker__day--029").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("label[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFile(new File("C:\\Users\\taron\\OneDrive\\Рабочий стол\\java tasks\\Снимок экрана 2025-02-21 130657.png"));
        $("#currentAddress").setValue("Molochnaya st 24");
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();




        $(".table-responsive").shouldHave(text("Petya Petrov"));
        $(".table-responsive").shouldHave(text("p@mail.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("9096776685"));
        $(".table-responsive").shouldHave(Condition.text("29 January,2023"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("Снимок экрана 2025-02-21 130657.png"));
        $(".table-responsive").shouldHave(text("Molochnaya st 24"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));
    }


}
