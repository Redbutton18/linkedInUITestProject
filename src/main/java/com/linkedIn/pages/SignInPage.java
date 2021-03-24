package com.linkedIn.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class SignInPage {

    private SelenideElement emailField = $(By.id("username"));
    private SelenideElement passwordField = $(By.id("password"));
    private SelenideElement signInButton = $(By.className("btn__primary--large"));

    @Step
    public void signIn(String email, String password){
        emailField.setValue(email);
        passwordField.setValue(password);
        signInButton.click();
    }

}
