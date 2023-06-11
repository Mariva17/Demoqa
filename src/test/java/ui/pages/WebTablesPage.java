package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ui.wait.Wait;

public class WebTablesPage extends PageBase {

    Wait wait;

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='mb-3 input-group']//input[@autocomplete='off']")
    WebElement typeToSearch;

    @FindBy(id = "addNewRecordButton")
    WebElement buttonAdd;

    public void goToWebTables() {
        driver.get("https://demoqa.com/webtables");
    }

    public void filterByName(String inputValue) {
        fillField(typeToSearch, inputValue);

    }

    public void checkFilterByName(String value) {
        String text = driver.findElement(By.xpath("//*[@role='row']//*[contains(text(), '" + value + "')]")).getText();
        Assert.assertEquals(text, value);
    }

    public void goToRegistrationFormByAddButton() {
        click(buttonAdd);
        
    }


}
