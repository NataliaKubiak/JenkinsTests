package org.portfolio.tests;

import org.portfolio.models.MainPage;
import org.portfolio.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderFooterTest extends BaseTest {

    private final String PROJECT_NAME = "Project12345";

    private void createProject() {
        new MainPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings();
    }

    private void deleteProject() {
        new MainPage(getDriver()).clickFreestyleProjectOnDashboard(PROJECT_NAME).deleteFreestyleProject();
    }

    @Test
    public void testLogoReturnToDashboard() {
        String mainPageTitle = new MainPage(getDriver())
                .clickManageJenkinsButton()
                .getHeaderFooter()
                .clickLogo()
                .getMainPageTitle();

        Assert.assertEquals(mainPageTitle, "Welcome to Jenkins!",
                "The dashboard page was not opened after clicking logo");
    }

    @Test
    public void testSearchBarFindAndGoToProjectPage() {
        createProject();

        String projectPageTitle = new MainPage(getDriver())
                .getHeaderFooter()
                .typeInSearchBarAndEnter(PROJECT_NAME)
                .getProjectPageTitle();

        Assert.assertEquals(projectPageTitle, "Project " + PROJECT_NAME,
                "Searched Bar redirected not where was expected");

        //post-condition
//        new MainPage(getDriver()).clickFreestyleProjectOnDashboard(PROJECT_NAME).deleteFreestyleProject();
    }

    @Test
    public void testSearchBarOpenHandbook() {
        String userHandbookPageTitle = new MainPage(getDriver())
                .getHeaderFooter()
                .clickQuestionMarkButtonInSearchBar()
                .getUserHandbookPageTitle();

        Assert.assertTrue(userHandbookPageTitle.contains("User Handbook"),
                "User Handbook page isn't opened");

        //post-condition
        getDriver().navigate().back();
    }
    @Test
    public void testJenkinsVersion() {
        String jenkinsVersion = new MainPage(getDriver())
                .getHeaderFooter()
                .getJenkinsVersionFromFooter();

        Assert.assertEquals(jenkinsVersion, "Jenkins 2.387.2",
                "Jenkins version in footer is not as expected");
    }

    @Test
    public void testJenkinsVersionLinkRedirect() {
        String officialWebsiteTitle = new MainPage(getDriver())
                .getHeaderFooter()
                .clickJenkinsVersionLinkAndRedirectToOffWebsite()
                .getOfficialWebsiteTitle();

        Assert.assertTrue(officialWebsiteTitle.contains("Jenkins"));
    }

    @Test
    public void testRestApiLink() {
        String restApiPageTitle = new MainPage(getDriver())
                .getHeaderFooter()
                .clickRestApiLinkFooter()
                .getRestApiPageTitle();

        Assert.assertEquals(restApiPageTitle, "REST API",
                "REST API Link redirected to a wrong page");
    }
}
