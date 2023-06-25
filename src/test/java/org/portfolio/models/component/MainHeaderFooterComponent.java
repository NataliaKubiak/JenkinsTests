package org.portfolio.models.component;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.*;
import org.portfolio.models.base.BaseComponent;
import org.portfolio.models.base.BaseModel;
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

    //header
    private String getBackgroundColor(By locator) {
        return getDriver().findElement(locator).getCssValue("background-color");
    }

    private void hoverOver(By locator) {
        new Actions(getDriver())
                .moveToElement(getDriver().findElement(locator))
                .pause(500)
                .perform();
    }

    private void openUsersDropdownMenu() {
        BaseModel.clickByJSExecutor(this, getDriver().findElement(By.xpath("//a[@href='/user/admin']/button")));
    }

    public BuildsPage getUsersDropdownMenuAndClickBuilds() {
        openUsersDropdownMenu();
        getWait5().until(ExpectedConditions
                .elementToBeClickable(By.xpath("//div[@id='breadcrumb-menu']//span[contains(text(), 'Builds')]"))).click();
        return new BuildsPage(getDriver());
    }

    public UserConfigPage getUsersDropdownMenuAndClickConfigure() {
        openUsersDropdownMenu();
        getWait5().until(ExpectedConditions
                .elementToBeClickable(By.xpath("//div[@id='breadcrumb-menu']//span[contains(text(), 'Configure')]"))).click();
        return new UserConfigPage(getDriver());
    }

    public MyViewsPage getUsersDropdownMenuAndClickMyViews() {
        openUsersDropdownMenu();
        getWait5().until(ExpectedConditions
                .elementToBeClickable(By.xpath("//div[@id='breadcrumb-menu']//span[contains(text(), 'My Views')]"))).click();
        return new MyViewsPage(getDriver());
    }

    public CredentialsPage getUsersDropdownMenuAndClickCredentials() {
        openUsersDropdownMenu();
        getWait5().until(ExpectedConditions
                .elementToBeClickable(By.xpath("//div[@id='breadcrumb-menu']//span[contains(text(), 'Credentials')]"))).click();
        return new CredentialsPage(getDriver());
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

    public MainHeaderFooterComponent<Page> clickNotificationButton() {
        getDriver().findElement(NOTIFICATION_BUTTON).click();
        return this;
    }

    public MainHeaderFooterComponent<Page> clickSecurityButton() {
        getDriver().findElement(SECURITY_BUTTON).click();
        return this;
    }

    public boolean isNotificationPopupDisplayed() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.id("visible-am-list"))).isDisplayed();
    }

    public boolean isSecurityPopupDisplayed() {
        return getWait5().until(ExpectedConditions
                .visibilityOfElementLocated(By.id("visible-sec-am-list"))).isDisplayed();
    }

    public ManageJenkinsPage clickNotificationButtonAndManageJenkins() {
        clickNotificationButton();
        getWait5().until(ExpectedConditions
                .elementToBeClickable(By.xpath("//div[@id='visible-am-list']//a[@href='/manage']"))).click();
        return new ManageJenkinsPage(getDriver());
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

    //TODO write proper XPath for NewItem Button in Dropdown Menu
//    public CreateNewItemPage clickNewItemButtonBreadcrumbs() {
//        new Actions(getDriver())
//                .moveToElement(getDriver().findElement(By.xpath("//li[@class='jenkins-breadcrumbs__list-item']")))
//                .pause(500)
//                .moveToElement(getDriver().findElement(By.xpath("//div[@id='breadcrumbBar']//button[@class='jenkins-menu-dropdown-chevron']")))
//                .click()
//                .pause(500)
//                .moveToElement(getDriver().findElement(By.xpath("//div[@id='breadcrumb-menu']//span[contains(text(), 'New Item')]")))
//                .click()
//                .perform();
//
//        return new CreateNewItemPage(getDriver());
//    }

    //footer
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
