package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.wait.Wait;

public class ProfilePage extends PageBase {

    Wait wait;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement username;

    @FindBy(xpath = "//button[contains(text(), 'Log out')]")
    WebElement buttonLogout;

    @FindBy(xpath = "(//*[@class='text-left button'])/button")
    WebElement buttonGoToBookStore;
    @FindBy(xpath = "(//button[contains(text(), 'Delete All Books')])[1]")
    WebElement buttonDeleteAllBooks;

    @FindBy(xpath = "//*[@class='text-center button'])/button")
    WebElement buttonDeleteAccount;


    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(username);
    }

    public void checkUsername(String expectedUsername) {
        checkItemText(username, expectedUsername, "Username is not correct");
    }

    public void pushButtonLogout() {
        buttonLogout.click();
    }

    public void pushButtonGoToBookStore() {
        buttonGoToBookStore.click();
    }

    public void pushButtonDeleteAllBooks() {
        buttonDeleteAllBooks.click();
    }

    public void pushButtonDeleteAccount() {
        buttonDeleteAccount.click();
    }

}
