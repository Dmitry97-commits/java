package test;

import pages.MainPage;
import utils.RandomUtils;
import org.junit.Test;


public class FirstExperienceJavaTest  extends  BaseTest{
    MainPage mainPage = new MainPage();

    @Test
    public void user()
    {
        mainPage.closeBanner();
        var firstname = mainPage.sendName(RandomUtils.RandomString(10));
        var lastname = mainPage.sendLastName(RandomUtils.RandomString(10));
        var email = mainPage.sendEmail(String.format("%s@%s.com",RandomUtils.RandomString(5),
                RandomUtils.RandomString(5)));
        var gender = mainPage.chooseGender();
        var phoneNumber = mainPage.enterPhoneNumber();
        var hobbie = mainPage.enterHobbies();
        var bd = mainPage.enterBD("18","december","1997");
        mainPage.uploadFile();
        mainPage.enterStateAndCity();
        mainPage.clickSubmit();
    }
}
