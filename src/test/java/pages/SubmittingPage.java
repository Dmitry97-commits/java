package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class SubmittingPage {

    private static final ElementsCollection valuesForm = $$(By.xpath("//tbody//tr//td[2]"));

    public static String getStudentInfo(int field){
        return valuesForm.get(field).getText();
    }

}
