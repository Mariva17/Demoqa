package ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ui.wait.Wait;

import java.util.List;

public class SelectPage extends PageBase {

    Wait wait;

    public SelectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "withOptGroup")
    WebElement selectValueDropDown;

    @FindBy(id = "react-select-2-input")
    WebElement selectOptionInput;

    @FindBy(id = "selectOne")
    WebElement selectOneDropDown;

    @FindBy(id = "react-select-3-input")
    WebElement selectTitleInput;

    @FindBy(id = "oldSelectMenu")
    WebElement selectOldDropDown;

    @FindBy(id = "cars")
    WebElement standardMultiSelect;

    @FindBy(xpath = "(//*[@class=' css-2b097c-container'])[3]")
    WebElement multiSelectDropDown;

    @FindBy(id = "react-select-4-input")
    WebElement multiSelectDropDownInput;

    @FindBy(xpath = "(//*[@class='css-19bqh2r'])[5]")
    WebElement clean;


    public void goToSelectPage() {
        driver.get("https://demoqa.com/select-menu");
    }

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(selectValueDropDown);
        wait.forVisibility(selectOptionInput);
        wait.forVisibility(selectOneDropDown);
        wait.forVisibility(selectOldDropDown);
        wait.forVisibility(multiSelectDropDown);
        wait.forVisibility(multiSelectDropDownInput);
        wait.forVisibility(clean);
    }

    public void selectValueDropdown(String inputValue) {
        click(selectValueDropDown);
        fillField(selectOptionInput, inputValue);
        pressKey(selectOptionInput, Keys.ENTER);
    }

    public void selectOneDropdown(String inputValue) {
        click(selectOneDropDown);
        selectTitleInput.sendKeys(inputValue);
        pressKey(selectTitleInput, Keys.ENTER);
    }

    public void selectOldDropDown(String text) {
        Select select = new Select(selectOldDropDown);
//        select.selectByValue(value);
//        select.selectByIndex(0);
        select.selectByVisibleText(text);
    }

    public void standardMultiSelect(List<String> values) {
        Select select = new Select(standardMultiSelect);
        for (String value : values) {
            select.selectByValue(value);
        }

    }

    public void multiSelectDropDown(String inputValue) {
        Actions actions = new Actions(driver);
        actions.moveToElement(multiSelectDropDownInput).click().build().perform();
//        click(multiSelectDropDown);
        multiSelectDropDownInput.sendKeys(inputValue);
        pressKey(multiSelectDropDownInput, Keys.ENTER);
    }

    public void cleanInput() {
        Actions actions = new Actions(driver);
        actions.moveToElement(clean).click().build().perform();
    }


}
