package org.portfolio.tests;

import org.portfolio.models.DashboardPage;
import org.portfolio.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {

    private final String PROJECT_NAME = "ProjectName" + getTimeStamp();

    private void createProject() {
        new DashboardPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings();
    }

    private void deleteProject() {
        new DashboardPage(getDriver()).clickFreestyleProjectOnDashboard(PROJECT_NAME).deleteFreestyleProject();
    }

    @Test
    public void testLogoReturnToDashboard() {
        boolean isMainPanelDisplayed = new DashboardPage(getDriver())
                .clickManageJenkinsButton()
                .getHeaderFooter()
                .clickLogo()
                .getMainPanel();

        Assert.assertTrue(isMainPanelDisplayed, "The dashboard page was not opened after clicking logo.");
    }

    @Test
    public void testSearchBarFindAndGoToProjectPage() {
        createProject();

        String projectPageTitle = new DashboardPage(getDriver())
                .getHeaderFooter()
                .typeInSearchBarAndEnter(PROJECT_NAME)
                .getProjectPageTitle();

        Assert.assertEquals(projectPageTitle, "Project " + PROJECT_NAME,
                "Searched Bar redirected not where was expected.");

        //post-condition
//        new MainPage(getDriver()).clickFreestyleProjectOnDashboard(PROJECT_NAME).deleteFreestyleProject();
    }

    @Test
    public void testSearchBarOpenHandbook() {
        String userHandbookPageTitle = new DashboardPage(getDriver())
                .getHeaderFooter()
                .clickQuestionMarkButtonInSearchBar()
                .getUserHandbookPageTitle();

        Assert.assertTrue(userHandbookPageTitle.contains("User Handbook"),
                "User Handbook page isn't opened.");

        //post-condition
        getDriver().navigate().back();
    }

    @Test
    public void testVerifyNotificationButtonColorChange() {
        String notificationButtonColorBefore = new DashboardPage(getDriver())
                .getHeaderFooter()
                .getNotificationButtonColor();

        String notificationButtonColorAfter = new DashboardPage(getDriver())
                .getHeaderFooter()
                .hoverOverNotificationButton()
                .getNotificationButtonColor();

        Assert.assertNotEquals(notificationButtonColorAfter, notificationButtonColorBefore,
                "Notification Button color did not change.");
    }

    @Test
    public void testIsNotificationPopupAppears() {
        boolean isNotificationPopupAppears = new DashboardPage(getDriver())
                .getHeaderFooter()
                .clickNotificationButton()
                .isNotificationPopupDisplayed();

        Assert.assertTrue(isNotificationPopupAppears, "Notification Popup wasn't displayed.");
    }

    @Test
    public void testOpenManageJenkinsFromPopup() {
        String manageJenkinsPageTitle = new DashboardPage(getDriver())
                .getHeaderFooter()
                .clickNotificationButtonAndManageJenkins()
                .getManageJenkinsPageTitle();

        Assert.assertEquals(manageJenkinsPageTitle, "Manage Jenkins",
                "ManageJenkins Link in the Notification Popup didn't work.");
    }

    @Test
    public void testOpenUsersProfilePage() {
        String usersPageTitle = new DashboardPage(getDriver())
                .getHeaderFooter()
                .clickUsersButton()
                .getUsersPageTitle();

        Assert.assertEquals(usersPageTitle, "admin");
    }

    @Test
    public void testVerifyUsersProfileButtonColorChange() {
        String usersProfileButtonColorBefore = new DashboardPage(getDriver())
                .getHeaderFooter()
                .getUsersButtonColor();

        String usersProfileButtonColorAfter = new DashboardPage(getDriver())
                .getHeaderFooter()
                .hoverOverUsersButton()
                .getUsersButtonColor();

        Assert.assertNotEquals(usersProfileButtonColorAfter, usersProfileButtonColorBefore,
                "Users Profile Button color did not change.");
    }

    @Test
    public void testBuildsPageOpenFromUsersDropdownMenu() {
        final String userName = "admin";

        String buildsPageTitle = new DashboardPage(getDriver())
                .getHeaderFooter()
                .getUsersDropdownMenuAndClickBuilds()
                .getBuildsPageTitle();

        Assert.assertEquals(buildsPageTitle, "Builds for " + userName,
                "Builds Page was not opened.");
    }

    @Test
    public void testConfigPageOpenFromUsersDropdownMenu() {
        String usersConfigPageTitleFromBreadcrumbs = new DashboardPage(getDriver())
                .getHeaderFooter()
                .getUsersDropdownMenuAndClickConfigure()
                .getUserConfigPageTitleFromBreadcrumbs();

        Assert.assertEquals(usersConfigPageTitleFromBreadcrumbs, "Configure",
                "Configure Page was not opened.");
    }

    @Test
    public void testMyViewsPageOpenFromUsersDropdownMenu() {
        String myViewsPageTitleFromBreadcrumbs = new DashboardPage(getDriver())
                .getHeaderFooter()
                .getUsersDropdownMenuAndClickMyViews()
                .getMyViewsPageTitleFromBreadcrumbs();

        Assert.assertEquals(myViewsPageTitleFromBreadcrumbs, "My Views",
                "My Views Page was not opened.");
    }

    @Test
    public void testCredentialsPageOpenFromUsersDropdownMenu() {
        String credentialsPageTitle = new DashboardPage(getDriver())
                .getHeaderFooter()
                .getUsersDropdownMenuAndClickCredentials()
                .getCredentialsPageTitle();

        Assert.assertEquals(credentialsPageTitle, "Credentials",
                "Credentials Page was not opened.");
    }

    @Test
    public void testVerifyLogoutButtonColorChange() {
        String logoutButtonColorBefore = new DashboardPage(getDriver())
                .getHeaderFooter()
                .getLogoutButtonColor();

        String logoutButtonColorAfter = new DashboardPage(getDriver())
                .getHeaderFooter()
                .hoverOverLogoutButton()
                .getLogoutButtonColor();

        Assert.assertNotEquals(logoutButtonColorAfter, logoutButtonColorBefore,
                "Logout Button color did not change.");
    }
}
