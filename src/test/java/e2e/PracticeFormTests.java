package e2e;

import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.PracticeForm;

public class PracticeFormTests extends TestBase {

    PracticeForm practiceForm;

    @Test
    public void checkMainPageForm() {
        practiceForm = new PracticeForm(app.driver);
        practiceForm.goToPracticeFormPage();
        practiceForm.waitForLoading();
    }

    @Test
    public void checkFieldsOfPracticeForm() {
        practiceForm = new PracticeForm(app.driver);
        practiceForm.goToPracticeFormPage();
        practiceForm.waitForLoading();
        practiceForm.fillFirstAndLastnameEmail("Bob", "Ivanov", "bmw@gmail.com");
        practiceForm.checkMaleRadioButton();
        practiceForm.fillMobileNumber("+491523698512");
        practiceForm.fillDayOfBirthdayField("07 Jun 2023");
        practiceForm.fillSubjectField("Subject");
        practiceForm.checkHobbiesRadioButton();
        practiceForm.checkSelectState("NCR");
        practiceForm.checkSelectCity("Agra");
    }

}

