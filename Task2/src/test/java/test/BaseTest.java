package test;

import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @Before
     public void setUp()  {
        open("https://demoqa.com/automation-practice-form");
    }

    @After
    public void TearDown(){
        Selenide.closeWebDriver();
    }
}
