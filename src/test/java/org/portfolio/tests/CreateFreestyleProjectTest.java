package org.portfolio.tests;

import org.portfolio.models.CreateNewItemErrorPage;
import org.portfolio.models.CreateNewItemPage;
import org.portfolio.models.CreateProjectLongNameErrorPage;
import org.portfolio.models.MainPage;
import org.portfolio.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Ignore
public class CreateFreestyleProjectTest extends BaseTest {

    private final String PROJECT_NAME = "Project" + getTimeStamp();

    @Test
    public void testCreateFreestyleProject() {
        boolean freestyleProjectIsPresent = new MainPage(getDriver())
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
        new MainPage(getDriver()).clickFreestyleProjectOnDashboard(PROJECT_NAME).deleteFreestyleProject();
    }

    //TODO write clearData(). won't be a problem with clearData
//    @Test
//    public void testCreateFreestyleProjectWithAllowedChars() {
//        final String allowedChar = "_-+=”{},";
//
//        boolean freestyleProjectIsPresent = new MainPage(getDriver())
//                .clickNewItemButton()
//                .enterTheNameOfTheProject(allowedChar)
//                .chooseFreestyleProjectAndOK()
//                .clickSaveWithDefaultSettings()
//                .getHeader()
//                .clickLogo()
//                .itemIsDisplayedOnDashboard(allowedChar);
//
//        Assert.assertTrue(freestyleProjectIsPresent, "Freestyle Project with a name " + allowedChar
//                + " is not displayed on Dashboard");
//
//        //post-condition
//        new MainPage(getDriver()).clickFreestyleProjectOnDashboard(allowedChar).deleteFreestyleProject();
//    }

    @Test
    public void testCreateFreestyleProjectSpacesInsteadOfName() {
        CreateNewItemErrorPage createNewItemErrorPage = new MainPage(getDriver())
                .clickNewItemButton()
                .enterProjectName("   ")
                .chooseFreestyleProjectAndOkToErrorPage();

        Assert.assertEquals(createNewItemErrorPage.getErrorPageTitle(), "Error",
                "The title of an Error is not as expected");
        Assert.assertEquals(createNewItemErrorPage.getErrorText(), "No name is specified",
                "The error text is not as expected");
    }

    //TODO fix the test and make it stable
    //sometimes Warning message appears, sometimes no. Weird
    @Ignore
    @Test
    public void testVerifyWarningMessageProjectNameEndingWithDot() {
        String warningMessageText = new MainPage(getDriver())
                .clickNewItemButton()
                .enterProjectName("Freestyle.")
                .getWarningMessageWrongData();

        Assert.assertEquals(warningMessageText, "» A name cannot end with ‘.’",
                "Warning message is not as expected");
    }

    @Test
    public void testCreateFreestyleProjectNameEndingWithDot() {
        CreateNewItemErrorPage createNewItemErrorPage = new MainPage(getDriver())
                .clickNewItemButton()
                .enterProjectName("Freestyle.")
                .chooseFreestyleProjectAndOkToErrorPage();

        Assert.assertEquals(createNewItemErrorPage.getErrorPageTitle(), "Error",
                "The title of an Error is not as expected");
        Assert.assertEquals(createNewItemErrorPage.getErrorText(), "A name cannot end with ‘.’",
                "The error text is not as expected");
    }

    //TODO fix the test and make it stable
    //sometimes Warning message appears, sometimes no
    @Ignore
    @Test
    public void testVerifyWarningMessageDuplicateProjectName() {
        new MainPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings()
                .getHeaderFooter()
                .clickLogo();

        String warningMessageText = new MainPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .getWarningMessageWrongData();

        Assert.assertEquals(warningMessageText, "» A job already exists with the name ‘"
                + PROJECT_NAME + "’", "Warning message is not as expected");

        //post-condition
        new MainPage(getDriver()).clickFreestyleProjectOnDashboard(PROJECT_NAME).deleteFreestyleProject();
    }

    //TODO add dependency from createFreestyleProject after adding clearData()
    @Test
    public void testCreateFreestyleProjectDuplicateProjectName() {
        new MainPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .chooseFreestyleProjectAndOK()
                .clickSaveWithDefaultSettings()
                .getHeaderFooter()
                .clickLogo();

        CreateNewItemErrorPage createNewItemErrorPage = new MainPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(PROJECT_NAME)
                .chooseFreestyleProjectAndOkToErrorPage();

        Assert.assertEquals(createNewItemErrorPage.getErrorPageTitle(), "Error",
                "The title of an Error is not as expected");
        Assert.assertEquals(createNewItemErrorPage.getErrorText(), "A job already exists with the name ‘"
                + PROJECT_NAME + "’", "The error text is not as expected");

        //post-condition
        new MainPage(getDriver())
                .getHeaderFooter()
                .clickLogo()
                .clickFreestyleProjectOnDashboard(PROJECT_NAME)
                .deleteFreestyleProject();
    }

    @Test
    public void testCreateFreestyleProjectLongName() {
        final String longName = "THIS STRING IS 257 CHARACTERS xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxY";

        String problemText = new MainPage(getDriver())
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
    public void testCreateFreestyleProjectEmptyName() {
        CreateNewItemPage createNewItemPage = new MainPage(getDriver())
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
    public void testCreateFreestyleProjectUnsafeChar(String unsafeChar) {
        CreateNewItemPage createNewItemPage = new MainPage(getDriver())
                .clickNewItemButton()
                .enterProjectName(unsafeChar)
                .clickFreestyleProjectButton();

        Assert.assertEquals(createNewItemPage.getWarningMessageWrongData(),
                "» ‘" + unsafeChar + "’ is an unsafe character",
                "Warning message is not as expected");
        Assert.assertFalse(createNewItemPage.isOkButtonActive(),"Ok button has incorrect state");
    }

    @Test
    public void testCreateFreestyleProjectFromDropdownMenu() {
        boolean freestyleProjectIsPresent = new MainPage(getDriver())
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
        new MainPage(getDriver()).clickFreestyleProjectOnDashboard(PROJECT_NAME).deleteFreestyleProject();
    }
}
