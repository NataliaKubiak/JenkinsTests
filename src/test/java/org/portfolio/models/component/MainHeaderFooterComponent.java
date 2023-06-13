package org.portfolio.models.component;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.*;
import org.portfolio.models.base.BaseComponent;
import org.portfolio.models.base.BasePage;

//this is a header realisation (where we will have action methods)
public class MainHeaderFooterComponent<Page extends BasePage<?>> extends BaseComponent<Page> {

    public MainHeaderFooterComponent(Page page) {
        super(page);
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

    public String getJenkinsVersionFromFooter() {
        return getDriver().findElement(By.xpath("//a[@rel='noopener noreferrer']")).getText();
    }

    public RestApiPage clickRestApiLinkFooter() {
        getDriver().findElement(By.xpath("//a[@href='api/']")).click();
        return new RestApiPage(getDriver());
    }

    public JenkinsOfficialWebsitePage clickJenkinsVersionLinkAndRedirectToOffWebsite() {
        getDriver().findElement(By.xpath("//a[@rel='noopener noreferrer']")).click();
        return new JenkinsOfficialWebsitePage(getDriver());
    }
}
