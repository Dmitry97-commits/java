package test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pages.MainPage;
import pages.SubmittingPage;
import utils.RandomUtils;

import static org.junit.Assert.assertEquals;


public class FirstExperienceJavaTest  extends  BaseTest{
    MainPage mainPage = new MainPage();
    SubmittingPage submittingPage = new SubmittingPage();

    @Test
    public void FormTest()
    {
        mainPage.closeBanner();
        var firstname = mainPage.sendName(RandomUtils.RandomString(10));
        var lastname = mainPage.sendLastName(RandomUtils.RandomString(10));
        var email = mainPage.sendEmail(String.format("%s@%s.com",RandomUtils.RandomString(5),
                RandomUtils.RandomString(5)));
        var gender = mainPage.chooseGender();
        var phoneNumber = mainPage.enterPhoneNumber();
        var hobbie = mainPage.enterHobbies();
        var bd = mainPage.enterBD("18","December","1997");
        mainPage.uploadFile();
        var stateAndCity = mainPage.enterStateAndCity();
        mainPage.clickSubmit();
        var dictStudent = submittingPage.getStudentInfo();

        Assertions.assertAll("Information doesnt match",
                ()->assertEquals(dictStudent.get("nameStudent"), String.format("%s %s",firstname,lastname)),
                ()->assertEquals(dictStudent.get("emailStudent"),email),
                ()->assertEquals(dictStudent.get("gender"),gender),
                ()->assertEquals(dictStudent.get("mobile"),phoneNumber),
                ()->assertEquals(dictStudent.get("dateOfBirth"),bd),
                ()->assertEquals(dictStudent.get("hobbies"),hobbie),
                ()->assertEquals(dictStudent.get("picture"),"screenshot.png"),
                ()->assertEquals(dictStudent.get("stateAndCity"),stateAndCity)
        );
    }
}
