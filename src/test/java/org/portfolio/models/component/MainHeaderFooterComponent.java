package org.portfolio.models.component;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.*;
import org.portfolio.models.base.BaseComponent;
import org.portfolio.models.base.BasePage;

//this is a header realisation (where we will have action methods)
public class MainHeaderFooterComponent<Page extends BasePage<?>> extends BaseComponent<Page> {

    private static final By NOTIFICATION_BUTTON = By.id("visible-am-button");
    private static final By SECURITY_BUTTON = By.id("visible-sec-am-button");
    private static final By USERS_BUTTON =  By.xpath("//a[@href='/user/admin']");
    private static final By LOGOUT_BUTTON = By.xpath("//a[@href='/logout']");

    public MainHeaderFooterComponent(Page page) {
        super(page);
    }

    private String getBackgroundColor(By locator) {
        return getDriver().findElement(locator).getCssValue("background-color");
    }

    private void hoverOver(By locator) {
        new Actions(getDriver())
                .moveToElement(getDriver().findElement(locator))
                .pause(500)
                .perform();
    }

    public String getNotificationButtonColor() {
        return getBackgroundColor(NOTIFICATION_BUTTON);
    }

    public String getSecurityButtonColor() {
        return getBackgroundColor(SECURITY_BUTTON);
    }

    public String getUsersButtonColor() {
        return getBackgroundColor(USERS_BUTTON);
    }

    public String getLogoutButtonColor() {
        return getBackgroundColor(LOGOUT_BUTTON);
    }

    public MainHeaderFooterComponent<Page> hoverOverNotificationButton() {
        hoverOver(NOTIFICATION_BUTTON);
        return this;
    }

    public MainHeaderFooterComponent<Page> hoverOverSecurityButton() {
        hoverOver(SECURITY_BUTTON);
        return this;
    }

    public MainHeaderFooterComponent<Page> hoverOverUsersButton() {
        hoverOver(USERS_BUTTON);
        return this;
    }

    public MainHeaderFooterComponent<Page> hoverOverLogoutButton() {
        hoverOver(LOGOUT_BUTTON);
        return this;
    }

    public MainPage clickLogo() {
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("jenkins-home-link"))).click();
        return new MainPage(getDriver());
    }

    public FreestyleProjectPage typeInSearchBarAndEnter(String projectName) {
        getWait5().until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@id='search-box']")))
                .sendKeys(projectName, Keys.ENTER);

        return new FreestyleProjectPage(getDriver());
    }

    public UserHandbookPage clickQuestionMarkButtonInSearchBar() {
        getWait5().until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[@href='https://www.jenkins.io/redirect/search-box']"))).click();
        return new UserHandbookPage(getDriver());
    }

    public UsersPage clickUsersButton() {
        getDriver().findElement(USERS_BUTTON).click();
        return new UsersPage(getDriver());
    }

    public String getJenkinsVersionFromFooter() {
        return getDriver().findElement(By.xpath("//a[@rel='noopener noreferrer']")).getText();
    }

    public RestApiPage clickRestApiLinkFooter() {
        getDriver().findElement(By.xpath("//a[@href='api/']")).click();
        return new RestApiPage(getDriver());
    }

    //TODO rewrite with switching tabs methods
//    public JenkinsOfficialWebsitePage clickJenkinsVersionLinkAndRedirectToOffWebsite() {
//        getDriver().findElement(By.xpath("//a[@rel='noopener noreferrer']")).click();
//        return new JenkinsOfficialWebsitePage(getDriver());
//    }
}
