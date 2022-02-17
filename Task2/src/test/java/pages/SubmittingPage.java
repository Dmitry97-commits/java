package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$$;

public class SubmittingPage {

    private static final ElementsCollection valuesForm = $$(By.xpath("//tbody//tr//td[2]"));

    public Map<String,String> getStudentInfo(){
        Map<String,String> values = new HashMap<>();
        values.put("nameStudent",valuesForm.get(0).getText());
        values.put("emailStudent",valuesForm.get(1).getText());
        values.put("gender",valuesForm.get(2).getText());
        values.put("mobile",valuesForm.get(3).getText());
        values.put("dateOfBirth",valuesForm.get(4).getText());
        values.put("hobbies",valuesForm.get(6).getText());
        values.put("picture",valuesForm.get(7).getText());
        values.put("stateAndCity",valuesForm.get(9).getText());
        return values;
    }
}
