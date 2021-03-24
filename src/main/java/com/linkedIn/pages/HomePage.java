package com.linkedIn.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class HomePage {

    public SelenideElement welcomeMessage = $(By.className("profile-rail-card__actor-link"));
}
