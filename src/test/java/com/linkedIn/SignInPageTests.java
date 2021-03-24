package com.linkedIn;

import com.linkedIn.helpers.excelUtils.ExcelDataProvider;
import com.linkedIn.pages.HomePage;
import com.linkedIn.pages.SignInPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.linkedIn.helpers.properties.UserProperty.EMAIL;
import static com.linkedIn.helpers.properties.UserProperty.PASSWORD;
import static org.assertj.core.api.Assertions.assertThat;

public class SignInPageTests extends BaseTest{

    private SignInPage signInPage = new SignInPage();
    private HomePage homePage = new HomePage();

    @BeforeMethod
    public void openSignInPage(){
        open(baseUrl + "/login");
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Test(description = "Positive test, signIn with valid credentials")
    public void signInTest(){
        signInPage.signIn(EMAIL,PASSWORD);
        signInPage.signIn(EMAIL,PASSWORD);
        assertThat(homePage.getWelcomeMessage().getText()).isEqualTo("Welcome, Anton!");
    }

    @Test(description = "Negative test, signIn with invalid credentials",
    dataProvider = "Wrong data for user login",
    dataProviderClass = ExcelDataProvider.class)
    public void signInWithInvalidCredentialsTest(String email, String password){
        String em = email;
        String pw = password;
        signInPage.signIn(em, pw);
    }
}
