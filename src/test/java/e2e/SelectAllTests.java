package e2e;

import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.FramePages;
import ui.pages.SelectPage;

import java.util.ArrayList;
import java.util.List;

public class SelectAllTests extends TestBase {

    SelectPage selectPage;

    FramePages framePages;

    @Test
    public void checkSelectValue() {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.selectValueDropdown("Group 1, option 2");

    }

    @Test
    public void checkOldSelectMenu() {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.selectOldDropDown("Yellow");

    }

    @Test
    public void checkMultiSelectMenu() {
        List<String> values = new ArrayList<>();
        values.add("volvo");
        values.add("saab");
        values.add("audi");
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.standardMultiSelect(values);
    }

    @Test
    public void checkMultiSelectDropAndDown() {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.multiSelectDropDown("Green");
        selectPage.multiSelectDropDown("Black");
        selectPage.cleanInput();

    }

    @Test
    public void checkSelectValueSecondInput() {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.selectOneDropdown("Prof.");

    }


//    @Test
//    public void checkLogin() throws InterruptedException {
//        framePages = new FramePages(app.driver);
//        framePages.login("selenium.introduction@mail.ru", "qwerty@2020");
//        Thread.sleep(10000);
//
//    }


}
