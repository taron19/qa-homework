package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FormTest2Xpath {



    @BeforeAll
    public static void init(){
        Configuration.pageLoadStrategy="eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout=6000;

    }


    @Test
    void formCheck() {

        open("/automation-practice-form");
        $x("//*[@id='firstName']").setValue("Petya");
        //Или: //$(byXpath("//*[@id='firstName']")).setValue("Petya");
        $x("//*[@id='lastName']").setValue("Petrov");
        $x("//*[@id='userEmail']").setValue("p@mail.ru");
        //  .// искать внутри родителя где текст male
        $x("//*[@id='genterWrapper']").$x(".//*[text()='Male']").click();
        //ИЛИ $x("//*[@id='genterWrapper']//*[text()='Male']").click();
        // ИЛИ $x("//*[@id='genterWrapper']").$(byText("Male")).click();

        $x("//*[@id='userNumber']").setValue("9096776685");
        $x("//*[@id='dateOfBirthInput']").click();
        //ВСЕГО 1 КЛАСС
        $x("//*[@class='react-datepicker__year-select']").selectOption("2023");
        //ВСЕГО 1 КЛАСС
        $x("//*[@class='react-datepicker__month-select']").selectOption("January");
        //в dive МНОГО классов и для этого используем contains чтобы нашел ОДИН ИЗ
        $x("//*[contains(@class, 'react-datepicker__day--029')]").click();



        $x("//*[@id='subjectsInput']").setValue("Maths").pressEnter();
        $x("//*[@id='hobbiesWrapper']").$x(".//*[text()='Sports']").click();
        $x("//*[@id='uploadPicture']").uploadFromClasspath("Снимок экрана 2025-02-21 130657.png");
        $x("//*[@id='currentAddress']").setValue("Molochnaya st 24");
        $x("//*[@id='state']").click();
        $x("//*[@id='react-select-3-option-2']").click();
        $x("//*[@id='city']").click();
        $x("//*[@id='react-select-4-option-0']").click();
        $x("//*[@id='submit']").click();




        $x("//*[@class='table-responsive']").shouldHave(text("Petya Petrov"));
        $x("//*[@class='table-responsive']").shouldHave(text("p@mail.ru"));
        $x("//*[@class='table-responsive']").shouldHave(text("Male"));
        $x("//*[@class='table-responsive']").shouldHave(text("9096776685"));
        $x("//*[@class='table-responsive']").shouldHave(Condition.text("29 January,2023"));
        $x("//*[@class='table-responsive']").shouldHave(text("Maths"));
        $x("//*[@class='table-responsive']").shouldHave(text("Sports"));
        $x("//*[@class='table-responsive']").shouldHave(text("Снимок экрана 2025-02-21 130657.png"));
        $x("//*[@class='table-responsive']").shouldHave(text("Molochnaya st 24"));
        $x("//*[@class='table-responsive']").shouldHave(text("Haryana Karnal"));
    }
}
