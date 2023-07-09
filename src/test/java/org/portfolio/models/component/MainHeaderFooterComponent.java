package org.portfolio.models.component;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.portfolio.models.*;
import org.portfolio.models.base.BaseComponent;
import org.portfolio.models.base.BaseModel;
import org.portfolio.models.base.BasePage;

//this is a header and footer realisation (where we will have action methods)
public class MainHeaderFooterComponent<Page extends BasePage<?>> extends BaseComponent<Page> {

    @FindBy(id = "visible-sec-am-button")
    private WebElement notificationButton;
    @FindBy(xpath = "//a[@href='/user/admin']")
    private WebElement usersButton;
    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutButton;
    @FindBy(xpath = "//a[@href='/user/admin']/button")
    private WebElement usersButtonArrow;
    @FindBy(xpath = "//div[@id='breadcrumb-menu']//span[contains(text(), 'Builds')]")
    private WebElement buildsButtonInDropdownMenu;
    @FindBy(xpath = "//div[@id='breadcrumb-menu']//span[contains(text(), 'Configure')]")
    private WebElement configureButtonInDropdownMenu;
    @FindBy(xpath = "//div[@id='breadcrumb-menu']//span[contains(text(), 'My Views')]")
    private WebElement myViewsButtonInDropdownMenu;
    @FindBy(xpath = "//div[@id='breadcrumb-menu']//span[contains(text(), 'Credentials')]")
    private WebElement credentialsButtonInDropdownMenu;
    @FindBy(id = "visible-sec-am-list")
    private WebElement notificationPopup;
    @FindBy(xpath = "//div[@id='visible-sec-am-list']//a[@href='/manage']")
    private WebElement manageJenkinsLink;
    @FindBy(id = "jenkins-home-link")
    private WebElement jenkinsLogo;
    @FindBy(xpath = "//input[@id='search-box']")
    private WebElement searchBar;
    @FindBy(xpath = "//a[@href='https://www.jenkins.io/redirect/search-box']")
    private WebElement questionMarkButtonInSearchBar;
    @FindBy(xpath = "//li[@class='jenkins-breadcrumbs__list-item']")
    private WebElement dashboardButtonInBreadcrumbs;
    @FindBy(xpath = "//div[@id='breadcrumbBar']//button[@class='jenkins-menu-dropdown-chevron']")
    private WebElement dashboardButtonArrowInBreadcrumbs;
    @FindBy(xpath = "//div[@id='breadcrumb-menu']//span[contains(text(), 'New Item')]")
    private WebElement newItemButtonInDropdownMenuBreadcrumbs;
    @FindBy(xpath = "//a[@rel='noopener noreferrer']")
    private WebElement jenkinsVersionLink;
    @FindBy(xpath = "//a[@href='api/']")
    private WebElement jenkinsAPILink;

    public MainHeaderFooterComponent(Page page) {
        super(page);
    }

    //header
    private String getBackgroundColor(WebElement element) {
        return element.getCssValue("background-color");
    }

    private void hoverOver(WebElement element) {
        new Actions(getDriver())
                .moveToElement(element)
                .pause(500)
                .perform();
    }

    private void openUsersDropdownMenu() {
        BaseModel.clickByJSExecutor(this, usersButtonArrow);
    }

    public BuildsPage getUsersDropdownMenuAndClickBuilds() {
        openUsersDropdownMenu();
        getWait5().until(ExpectedConditions.elementToBeClickable(buildsButtonInDropdownMenu)).click();
        return new BuildsPage(getDriver());
    }

    public UserConfigPage getUsersDropdownMenuAndClickConfigure() {
        openUsersDropdownMenu();
        getWait5().until(ExpectedConditions.elementToBeClickable(configureButtonInDropdownMenu)).click();
        return new UserConfigPage(getDriver());
    }

    public MyViewsPage getUsersDropdownMenuAndClickMyViews() {
        openUsersDropdownMenu();
        getWait5().until(ExpectedConditions.elementToBeClickable(myViewsButtonInDropdownMenu)).click();
        return new MyViewsPage(getDriver());
    }

    public CredentialsPage getUsersDropdownMenuAndClickCredentials() {
        openUsersDropdownMenu();
        getWait5().until(ExpectedConditions.elementToBeClickable(credentialsButtonInDropdownMenu)).click();
        return new CredentialsPage(getDriver());
    }

    public String getNotificationButtonColor() {
        return getBackgroundColor(notificationButton);
    }

    public String getUsersButtonColor() {
        return getBackgroundColor(usersButton);
    }

    public String getLogoutButtonColor() {
        return getBackgroundColor(logoutButton);
    }

    public MainHeaderFooterComponent<Page> hoverOverNotificationButton() {
        hoverOver(notificationButton);
        return this;
    }

    public MainHeaderFooterComponent<Page> hoverOverUsersButton() {
        hoverOver(usersButton);
        return this;
    }

    public MainHeaderFooterComponent<Page> hoverOverLogoutButton() {
        hoverOver(logoutButton);
        return this;
    }

    public MainHeaderFooterComponent<Page> clickNotificationButton() {
        notificationButton.click();
        return this;
    }

    public boolean isNotificationPopupDisplayed() {
        return getWait5().until(ExpectedConditions.visibilityOf(notificationPopup)).isDisplayed();
    }

    public ManageJenkinsPage clickNotificationButtonAndManageJenkins() {
        clickNotificationButton();
        getWait5().until(ExpectedConditions.elementToBeClickable(manageJenkinsLink)).click();
        return new ManageJenkinsPage(getDriver());
    }

    public DashboardPage clickLogo() {
        getWait5().until(ExpectedConditions.elementToBeClickable(jenkinsLogo)).click();
        return new DashboardPage(getDriver());
    }

    public FreestyleProjectPage typeInSearchBarAndEnter(String projectName) {
        getWait5().until(ExpectedConditions.elementToBeClickable(searchBar))
                .sendKeys(projectName, Keys.ENTER);
        return new FreestyleProjectPage(getDriver());
    }

    public UserHandbookPage clickQuestionMarkButtonInSearchBar() {
        getWait5().until(ExpectedConditions.elementToBeClickable(questionMarkButtonInSearchBar)).click();
        return new UserHandbookPage(getDriver());
    }

    public UsersPage clickUsersButton() {
        usersButton.click();
        return new UsersPage(getDriver());
    }

    public CreateNewItemPage clickNewItemButtonBreadcrumbs() {
        new Actions(getDriver())
                .moveToElement(dashboardButtonInBreadcrumbs)
                .pause(500)
                .moveToElement(dashboardButtonArrowInBreadcrumbs)
                .click()
                .pause(500)
                .perform();

        clickByJSExecutor(this, newItemButtonInDropdownMenuBreadcrumbs);
        return new CreateNewItemPage(getDriver());
    }

    //footer
    public String getJenkinsVersionFromFooter() {
        return jenkinsVersionLink.getText();
    }

    public RestApiPage clickRestApiLinkFooter() {
        jenkinsAPILink.click();
        return new RestApiPage(getDriver());
    }

    public JenkinsOfficialWebsitePage clickJenkinsVersionLinkAndRedirectToOffWebsite() {
        String originalHandle = getDriver().getWindowHandle();
        assert getDriver().getWindowHandles().size() == 1;

        jenkinsVersionLink.click();
        getWait5().until(ExpectedConditions.numberOfWindowsToBe(2));

        for(String windowHandle : getDriver().getWindowHandles()) {
            if(!originalHandle.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return new JenkinsOfficialWebsitePage(getDriver());
    }
}
