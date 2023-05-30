package e2e;

import api.RegistrationApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.BookStorePage;
import ui.pages.LoginPage;
import ui.pages.ProfilePage;

import static org.testng.AssertJUnit.assertEquals;

public class ProfilePageTests extends TestBase {

    LoginPage loginPage;
    ProfilePage profilePage;
    Response response;
    RegistrationApi registrationApi;
    BookStorePage bookStorePage;

    @Test
    public void checkButtonLogOut() {
        String password = "8389!Mariva";
        String userName = "mariva";

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillLoginForm(userName, password);
        loginPage.clickLoginButton();

        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoading();

        profilePage.pushButtonLogout();
        assertEquals("Login in Book Store", loginPage.checkHeader());

    }

    @Test
    public void checkButtonGoToBookStore() {
        String password = "52689@Tyuu";
        registrationApi = new RegistrationApi();
        response = registrationApi.registerUser(201, password);
        String userName = response.jsonPath().getString("username");

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillLoginForm(userName, password);
        loginPage.clickLoginButton();

        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoading();

        profilePage.pushButtonGoToBookStore();
        profilePage.waitForLoading();
        bookStorePage.goToBookStore();
    }

    @Test
    public void checkButtonDeleteAllBooks() {
        String password = "52689@Tyuu";
        registrationApi = new RegistrationApi();
        response = registrationApi.registerUser(201, password);
        String userName = response.jsonPath().getString("username");

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillLoginForm(userName, password);
        loginPage.clickLoginButton();

        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoading();

        profilePage.pushButtonDeleteAllBooks();
        

    }


}
