package test;

import data.Configs;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pages.MainPage;
import pages.SubmittingPage;
import utils.RandomUtils;
import utils.ResourcesUtils;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static utils.ResourcesUtils.getResources;


public class FirstExperienceJavaTest  extends  BaseTest{

    MainPage mainPage = new MainPage();

    String name = RandomUtils.RandomString(10);
    String lastName = RandomUtils.RandomString(10);
    String email = String.format("%s@%s.com",RandomUtils.RandomString(5),
            RandomUtils.RandomString(5));
    String gender = "Male";
    String hobbie = "Sports";
    String phoneNumber = RandomStringUtils.randomNumeric(10);

    @Test
    public void FormTest() throws IOException {
        mainPage
                .closeBanner()
                .sendName(name)
                .sendLastName(lastName)
                .sendEmail(email)
                .enterGender(gender)
                .enterPhoneNumber(phoneNumber)
                .enterHobbie(hobbie)
                .enterBD("18","December","1997")
                .uploadFile()
                .enterStateAndCity()
                .clickSubmit();

        Map<String,String> dictStudent = SubmittingPage.getStudentInfo();

        Assertions.assertAll("Information doesnt match",
                ()->assertEquals(dictStudent.get("nameStudent"), String.format("%s %s",name,lastName)),
                ()->assertEquals(dictStudent.get("emailStudent"),email),
                ()->assertEquals(dictStudent.get("gender"),gender),
                ()->assertEquals(dictStudent.get("mobile"),phoneNumber),
                //()->assertEquals(dictStudent.get("dateOfBirth"),bd),
                ()->assertEquals(dictStudent.get("hobbies"),hobbie),
                ()->assertEquals(dictStudent.get("picture"),"screenshot.png")
                //()->assertEquals(dictStudent.get("stateAndCity"),stateAndCity)
        );
        System.out.println(Configs.mainUrl);
    }
}
