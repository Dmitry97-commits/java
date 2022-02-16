package test;

import org.junit.jupiter.api.Assertions;
import pages.MainPage;
import pages.SubmittingPage;
import utils.RandomUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FirstExperienceJavaTest  extends  BaseTest{
    MainPage mainPage = new MainPage();
    SubmittingPage submittingPage = new SubmittingPage();

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

        Assertions.assertAll("Information doesnt match",
                ()->assertEquals(SubmittingPage.getStudentInfo(0), String.format("%s %s",firstname,lastname)),
                ()->assertEquals(SubmittingPage.getStudentInfo(1),email)

        );
    }
}
