package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private void enterYearBD(String year){
        $x(String.format("//div[@class='react-datepicker']//select[contains(@class,'year-select')]//option[contains(text(),%s)]",year)).click();
    }

    private void enterMonthBD(String month){
        $x(String.format("//div[@class='react-datepicker']//select[contains(@class,'month-select')]//option[contains(text(),'%s')]",month)).click();
    }

    private void enterDayBD(String day){
        $x(String.format("//div[contains(@class,'datepicker__day')and contains(text(),%s)]",day)).click();
    }

    public MainPage closeBanner(){
        $(By.id("close-fixedban")).click();
        return this;
    }

    public MainPage sendName(String name){
        $(By.id("firstName")).sendKeys(name);
        return this;
    }

    public MainPage sendLastName(String lastname){
        $(By.id("lastName")).sendKeys(lastname);
        return this;
    }

    public MainPage sendEmail(String email){
        $(By.id("userEmail")).sendKeys(email);
        return this;
    }

    public MainPage enterGender(String gender){
        $(By.xpath(String.format("//label[contains(text(), '%s')]",gender))).click();
        return this;
    }

    public MainPage enterPhoneNumber(String number){
        $(By.id("userNumber")).sendKeys(number);
        return this;
    }

    public MainPage enterHobbie(String hobbie){
        $(By.xpath(String.format("//label[contains(text(), '%s')]", hobbie))).click();
        return this;
    }

    public MainPage enterBD(String day, String month, String year){
        $(By.id("dateOfBirthInput")).click();
        enterYearBD(year);
        enterMonthBD(month);
        enterDayBD(day);
        return this;
    }

    public MainPage uploadFile(){
        $(By.id("uploadPicture")).uploadFromClasspath("screenshot.png");
        return this;
    }

    public MainPage enterStateAndCity(){
        var state = $(By.id("state")).scrollIntoView(true);
        var city = $(By.id("city"));
        actions().moveToElement(state).click(state).sendKeys(Keys.ENTER).moveToElement(city)
                .click(city).sendKeys(Keys.ENTER).perform();
        return this;
    }

    public MainPage clickSubmit(){
        $(By.id("submit")).click();
        return this;
    }
}
