package ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ui.wait.Wait;

public class PracticeForm extends PageBase {
    public PracticeForm(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy(className = "main-header")
    public WebElement mainHeaderElement;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement email;

    @FindBy(xpath = "//label[normalize-space()='Male']")
    public WebElement maleRadioButton;

    @FindBy(id = "userNumber")
    public WebElement mobileElement;

    @FindBy(id = "dateOfBirthInput")
    public WebElement birthdayElement;

    @FindBy(className = "subjects-auto-complete__input")
    public WebElement subjectElement;

    @FindBy(xpath = "//label[contains(text(), 'Sports')]")
    //@FindBy(id = "hobbies-checkbox-2")
    public WebElement hobbies;

    @FindBy(id = "state")
    public WebElement selectState;

    @FindBy(id = "react-select-3-input")
    public WebElement selectStateInput;

    @FindBy(id = "city")
    public WebElement selectCity;

    @FindBy(id = "react-select-4-input")
    public WebElement selectCityInput;


    public void goToPracticeFormPage() {
        driver.get("https://demoqa.com/automation-practice-form");

    }


    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(mainHeaderElement);
        wait.forVisibility(firstName);
        wait.forVisibility(subjectElement);
        wait.forVisibility(hobbies);
        wait.forVisibility(selectState);
        wait.forVisibility(selectCity);


    }

    public void fillFirstAndLastnameEmail(String firstnameText, String lastnameText, String emailText) {
        fillField(firstName, firstnameText);
        fillField(lastName, lastnameText);
        fillField(email, emailText);
    }

    public void checkMaleRadioButton() {
        maleRadioButton.click();
    }

    public void fillMobileNumber(String phoneNumber) {
        fillField(mobileElement, phoneNumber);
    }

    public void fillDayOfBirthdayField(String value) {
        fillField(birthdayElement, value);
    }

    public void fillSubjectField(String value) {
        Actions actions = new Actions(driver);
        actions.moveToElement(subjectElement).click().build().perform();

        //       fillField(subjectElement, value);
    }

    public void checkHobbiesRadioButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(hobbies).click().build().perform();

    }

    public void checkSelectState(String inputValue) {
        Actions actions = new Actions(driver);
        actions.moveToElement(selectState).click().build().perform();
        selectStateInput.sendKeys(inputValue);
        pressKey(selectStateInput, Keys.ENTER);
    }

    public void checkSelectCity(String inputValue) {
        Actions actions = new Actions(driver);
        actions.moveToElement(selectCity).click().build().perform();
        selectCityInput.sendKeys(inputValue);
        pressKey(selectCityInput, Keys.ENTER);
    }


}




