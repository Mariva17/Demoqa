package e2e;

import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.FramePages;
import ui.pages.SelectPage;

import static java.lang.Thread.sleep;

public class SelectAllTests extends TestBase {

    SelectPage selectPage;

    FramePages framePages;

    @Test
    public void checkSelectValue() throws InterruptedException {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.selectInFirstInput("Group 1, option 2");

    }

    @Test
    public void checkOldSelectMenu() {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.selectOld("8");

    }

    @Test
    public void checkMultiSelectMenu() throws InterruptedException {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.selectMulti();
        sleep(5000);
    }

    @Test
    public void checkMultiSelectDropAndDown() throws InterruptedException {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.multiSelectDD("Green");
        selectPage.multiSelectDD("Black");
        sleep(3000);
        selectPage.cleanInput();
        sleep(3000);
    }

    @Test
    public void checkSelectValueSecondInput() throws InterruptedException {
        selectPage = new SelectPage(app.driver);
        selectPage.goToSelectPage();
        selectPage.selectSecondInput("Prof.");

    }


//    @Test
//    public void checkLogin() throws InterruptedException {
//        framePages = new FramePages(app.driver);
//        framePages.login("selenium.introduction@mail.ru", "qwerty@2020");
//        Thread.sleep(10000);
//
//    }


}
