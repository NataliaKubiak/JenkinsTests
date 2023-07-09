package org.portfolio.tests;

import org.portfolio.models.CreateNewItemErrorPage;
import org.portfolio.models.CreateNewItemPage;
import org.portfolio.models.CreateProjectLongNameErrorPage;
import org.portfolio.models.DashboardPage;
import org.portfolio.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateFreestyleProjectTest extends BaseTest {

    private final String PROJECT_NAME = "Project" + getTimeStamp();

    @Test
    public void testCreateProject() {
        boolean freestyleProjectIsPresent = new DashboardPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings()
                .getHeaderFooter()
                .clickLogo()
                .itemIsDisplayedOnDashboard(PROJECT_NAME);

        Assert.assertTrue(freestyleProjectIsPresent, "Freestyle Project with a name " + PROJECT_NAME
                + " was not created or displayed on Dashboard");


        //post-condition
        new DashboardPage(getDriver()).clickFreestyleProjectOnDashboard(PROJECT_NAME).deleteFreestyleProject();
    }

    @DataProvider(name = "allowedChar")
    public Object[][] provideAllowedChar() {
        return new Object[][] {
                {"_"}, {"-"}, {"+"},
                {"="}, {"{"},
                {"}"}, {","}
        };
    }

    @Test(dataProvider = "allowedChar")
    public void testCreateProjectWithAllowedChars(String allowedChar) {
        boolean freestyleProjectIsPresent = new DashboardPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(allowedChar)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings()
                .getHeaderFooter()
                .clickLogo()
                .itemIsDisplayedOnDashboard(allowedChar);

        Assert.assertTrue(freestyleProjectIsPresent, "Freestyle Project with a name " + allowedChar
                + " is not displayed on Dashboard");

        //post-condition
        switch (allowedChar) {
            case "_", "-", "+", "=", ",":
                new DashboardPage(getDriver()).clickFreestyleProjectOnDashboard(allowedChar).deleteFreestyleProject();
                break;
            case "{":
                new DashboardPage(getDriver()).clickFreestyleProjectOnDashboard("%7B").deleteFreestyleProject();
                break;
            case "}":
                new DashboardPage(getDriver()).clickFreestyleProjectOnDashboard("%7D").deleteFreestyleProject();
                break;
        }
    }

    @Test
    public void testCreateProjectSpacesInsteadOfName() {
        CreateNewItemErrorPage createNewItemErrorPage = new DashboardPage(getDriver())
                .clickNewItemButton()
                .enterProjectName("   ")
                .chooseFreestyleProjectAndOkToErrorPage();

        Assert.assertEquals(createNewItemErrorPage.getErrorPageTitle(), "Error",
                "The title of an Error is not as expected");
        Assert.assertEquals(createNewItemErrorPage.getErrorText(), "No name is specified",
                "The error text is not as expected");
    }

    @Test
    public void testProjectNameEndingWithDot() {
        CreateNewItemPage createNewItemPage = new DashboardPage(getDriver())
                .clickNewItemButton()
                .enterProjectName("Freestyle.")
                .clickToBlankSpace();

        Assert.assertEquals(createNewItemPage.getWarningMessageWrongData(), "» A name cannot end with ‘.’",
                "Warning message is not as expected");
        Assert.assertFalse(createNewItemPage.isOkButtonActive(), "Ok button has incorrect state");
    }

    @Test
    public void testVerifyWarningMessageDuplicateProjectName() {
        new DashboardPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings()
                .getHeaderFooter()
                .clickLogo();

        String warningMessageText = new DashboardPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .clickToBlankSpace()
                .getWarningMessageWrongData();

        Assert.assertEquals(warningMessageText, "» A job already exists with the name ‘"
                + PROJECT_NAME + "’", "Warning message is not as expected");

        //post-condition - doesn't work coz I finished not on a MainPage
//        new MainPage(getDriver()).clickFreestyleProjectOnDashboard(PROJECT_NAME).deleteFreestyleProject();
    }

    @Test
    public void testCreateProjectDuplicateProjectName() {
        new DashboardPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings()
                .getHeaderFooter()
                .clickLogo();

        CreateNewItemErrorPage createNewItemErrorPage = new DashboardPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .chooseFreestyleProjectAndOkToErrorPage();

        Assert.assertEquals(createNewItemErrorPage.getErrorPageTitle(), "Error",
                "The title of an Error is not as expected");
        Assert.assertEquals(createNewItemErrorPage.getErrorText(), "A job already exists with the name ‘"
                + PROJECT_NAME + "’", "The error text is not as expected");

        //post-condition
        new DashboardPage(getDriver())
                .getHeaderFooter()
                .clickLogo()
                .clickFreestyleProjectOnDashboard(PROJECT_NAME)
                .deleteFreestyleProject();
    }

    @Test
    public void testCreateProjectLongName() {
        final String longName = "THIS STRING IS 257 CHARACTERS xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxY";

        String problemText = new DashboardPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(longName)
                .chooseFreestyleProjectAndOkToErrorLongNamePage()
                .getProblemText();

        Assert.assertEquals(problemText, "A problem occurred while processing the request.",
                "The Text of the problem is not as expected");

        //post-condition
        new CreateProjectLongNameErrorPage(getDriver())
                .getHeaderFooter()
                .clickLogo();
    }

    @Test
    public void testCreateProjectEmptyName() {
        CreateNewItemPage createNewItemPage = new DashboardPage(getDriver())
                .clickNewItemButton()
                .clickFreestyleProjectButton();

        Assert.assertFalse(createNewItemPage.isOkButtonActive(), "Ok button has incorrect state");
        Assert.assertEquals(createNewItemPage.getWarningMessageEmptyInput(),
                "» This field cannot be empty, please enter a valid name",
                "Warning message is not as expected");
    }

    @DataProvider(name = "unsafeChar")
    public Object[][] provideUnsafeChars() {
        return new Object[][] {
                {"!"}, {"@"}, {"#"}, {"$"}, {"%"},
                {"^"}, {"&"}, {"*"}, {":"}, {";"},
                {"/"}, {"|"}, {"?"}, {"<"}, {">"}
        };
    }

    @Test(dataProvider = "unsafeChar")
    public void testCreateProjectUnsafeChar(String unsafeChar) {
        CreateNewItemPage createNewItemPage = new DashboardPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(unsafeChar)
                .clickFreestyleProjectButton();

        Assert.assertEquals(createNewItemPage.getWarningMessageWrongData(),
                "» ‘" + unsafeChar + "’ is an unsafe character",
                "Warning message is not as expected");
        Assert.assertFalse(createNewItemPage.isOkButtonActive(),"Ok button has incorrect state");
    }

    @Test
    public void testCreateProjectFromDropdownMenu() {
        boolean freestyleProjectIsPresent = new DashboardPage(getDriver())
                .getHeaderFooter()
                .clickNewItemButtonBreadcrumbs()
                .enterProjectName(PROJECT_NAME)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings()
                .getHeaderFooter()
                .clickLogo()
                .itemIsDisplayedOnDashboard(PROJECT_NAME);

        Assert.assertTrue(freestyleProjectIsPresent, "Freestyle Project with name " + PROJECT_NAME +
                " was not created or displayed on a Dashboard");

        //post-condition
        new DashboardPage(getDriver()).clickFreestyleProjectOnDashboard(PROJECT_NAME).deleteFreestyleProject();
    }
}
