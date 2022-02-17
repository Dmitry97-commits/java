package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.RandomUtils;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement closeBannerButton = $(By.id("close-fixedban"));
    private final SelenideElement nameField = $(By.id("firstName"));
    private final SelenideElement lastNameField = $(By.id("lastName"));
    private final SelenideElement emailField = $(By.id("userEmail"));
    private final ElementsCollection genders = $$(By.xpath("//label[contains(@for,'gender')]"));
    private final SelenideElement phoneField = $(By.id("userNumber"));
    private final ElementsCollection hobbies = $$(By.xpath("//label[contains(@for,'hobbies-checkbox')]"));
    private final SelenideElement birthDayLabel = $(By.id("dateOfBirthInput"));
    private final SelenideElement attachmentLabel = $(By.id("uploadPicture"));
    private final SelenideElement stateField = $(By.id("state"));
    private final SelenideElement cityField = $(By.id("city"));
    private final ElementsCollection resultOfStateAndCity = $$(By.xpath("//div[contains(@class,'singleValue')]"));
    private final SelenideElement submitButton = $(By.id("submit"));

    private void enterYearBD(String year){
        var selectedYear
                = $x(String.format("//div[@class='react-datepicker']//select[contains(@class,'year-select')]//option[contains(text(),%s)]",year));
        selectedYear.click();
    }

    private void enterMonthBD(String month){
        var selectedMonth
                = $x(String.format("//div[@class='react-datepicker']//select[contains(@class,'month-select')]//option[contains(text(),'%s')]",month));
        selectedMonth.click();
    }

    private void enterDayBD(String day){
        var selectedDay
                = $x(String.format("//div[contains(@class,'datepicker__day')and contains(text(),%s)]",day));
        selectedDay.click();
    }

    public void closeBanner(){
        closeBannerButton.click();
    }

    public String sendName(String name){
        nameField.sendKeys(name);
        return name;
    }

    public String sendLastName(String lastname){
        lastNameField.sendKeys(lastname);
        return lastname;
    }

    public String sendEmail(String email){
        emailField.sendKeys(email);
        return email;
    }

    public String chooseGender(){
        var gender = genders.get(RandomUtils.RandomInt(genders.size()-1));
        gender.click();
        return gender.getText();
    }

    public String enterPhoneNumber(){
        var number = RandomStringUtils.randomNumeric(10);
        phoneField.sendKeys(number);
        return number;
    }

    public String enterHobbies(){
        var hobbie = hobbies.get(RandomUtils.RandomInt(hobbies.size()-1));
        hobbie.click();
        return hobbie.getText();
    }

    public String enterBD(String day, String month, String year){
        birthDayLabel.click();
        enterYearBD(year);
        enterMonthBD(month);
        enterDayBD(day);
        return String.format("%s %s,%s",day,month,year);
    }

    public void uploadFile(){
        attachmentLabel.uploadFromClasspath("screenshot.png");
    }

    public String enterStateAndCity(){
        stateField.scrollIntoView(true);
        actions().moveToElement(stateField).click(stateField).sendKeys(Keys.ENTER).moveToElement(cityField)
                .click(cityField).sendKeys(Keys.ENTER).perform();
        var state = resultOfStateAndCity.first().getText();
        var city = resultOfStateAndCity.last().getText();
        return String.format("%s %s",state,city);
    }

    public void clickSubmit(){
        submitButton.click();
    }
}
