package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @Before
    public void SetUp(){
        open("https://demoqa.com/automation-practice-form");
        Configuration.holdBrowserOpen = true;
    }
}
