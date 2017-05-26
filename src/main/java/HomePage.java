import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class HomePage {
    private static AndroidDriver driver;

    public HomePage(AndroidDriver driver){
        this.driver = driver;
    }

    public  static String addNoteButton = "//android.widget.ImageButton[@resource-id='com.moonpi.swiftnotes:id/newNote']";
    public  static String savedNoteTitle = "//android.widget.TextView[@resource-id='com.moonpi.swiftnotes:id/titleView']";
    public  static String savedNoteText = "//android.widget.TextView[@resource-id='com.moonpi.swiftnotes:id/bodyView']";

    public static String notSavedTitle = "//android.widget.TextView[@text=$noteTitleNoSave]";
    public static String notSavedNote = "//android.widget.TextView[@text=$noteTextNoSave";

    public static void addNoteClick(){

        new WebDriverWait(driver, 5000).until(ExpectedConditions.elementToBeClickable(By.xpath(addNoteButton)));
        AndroidElement addNote = (AndroidElement) driver.findElement(By.xpath(addNoteButton));
        addNote.click();
    }

    public void waitForSavedNote(){
        new WebDriverWait(driver, 5000).until(ExpectedConditions.presenceOfElementLocated(By.xpath(savedNoteTitle)));
    }

    public String getNoteTitle(){
        String savedTitle = driver.findElement(By.xpath(savedNoteTitle)) .getText();
        return savedTitle;
    }

    public String getNoteText(){
        String savedNote = driver.findElement(By.xpath(savedNoteText)).getText();
        return savedNote;
    }



}
