import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class AddNoteTest extends AndroidSetup {

    String noteTitleText = "New test note title";
    String noteText = "New test note text";

    String noteTitleNoSave = "Xeniya test";
    String noteTextNoSave = "Xeniya test note";

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void addNoteSaveTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        HomePage homePage = new HomePage(driver);
        homePage.addNoteClick();

        AddNotePage addNotePage = new AddNotePage(driver);
        addNotePage.addNoteTitleText(noteTitleText, noteText);

        addNotePage.clickBackButton();
        addNotePage.saveNoteYes();

        homePage.waitForSavedNote();
        String savedTitle = homePage.getNoteTitle();
        String savedNote = homePage.getNoteText();

        assertEquals(savedTitle, noteTitleText);
        assertEquals(savedNote, noteText);

    }

    @Test(expectedExceptions = {NoSuchElementException.class})
    public void addNoteNotSaveTest(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        HomePage homePage = new HomePage(driver);
        homePage.addNoteClick();

        AddNotePage addNotePage = new AddNotePage(driver);
        addNotePage.addNoteTitleText(noteTitleNoSave, noteTextNoSave);

        addNotePage.clickBackButton();
        addNotePage.saveNoteNo();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(homePage.addNoteButton)));

        driver.findElement(By.xpath(homePage.notSavedTitle));


    }
}
