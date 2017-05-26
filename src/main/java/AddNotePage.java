import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNotePage {

    String titleField = "//android.widget.EditText[@text='Title']";
    String noteField = "//android.widget.EditText[@text='Note']";
    String backBut = "//android.widget.ImageButton";
    String saveMessage = "//android.widget.TextView[@text='Save changes?']";
    String saveYes = "//android.widget.Button[@text='Yes']";
    String saveNo = "//android.widget.Button[@text='No']";

    private static AndroidDriver driver;

    public AddNotePage(AndroidDriver driver){
        this.driver = driver;
    }

    public void addNoteTitleText(String title, String text){
        new WebDriverWait(driver, 5000).until(ExpectedConditions.presenceOfElementLocated(By.xpath(titleField)));
        AndroidElement titleT = (AndroidElement) driver.findElement(By.xpath(titleField));
        titleT.sendKeys(title);
        new WebDriverWait(driver, 5000).until(ExpectedConditions.elementToBeClickable(By.xpath(noteField)));
        AndroidElement note = (AndroidElement) driver.findElement(By.xpath(noteField));
        note.click();
        note.sendKeys(text);
    }

    public void clickBackButton(){
        AndroidElement backButton = (AndroidElement) driver.findElement(By.xpath(backBut));
        backButton.click();
    }

    public void saveNoteYes(){
        new WebDriverWait(driver, 5000).until(ExpectedConditions.elementToBeClickable(By.xpath(saveMessage)));
        AndroidElement yesButton = (AndroidElement) driver.findElement(By.xpath(saveYes));
        yesButton.click();
    }

    public void saveNoteNo(){
        new WebDriverWait(driver, 5000).until(ExpectedConditions.elementToBeClickable(By.xpath(saveMessage)));
        AndroidElement noButton = (AndroidElement) driver.findElement(By.xpath(saveNo));
        noButton.click();
    }
}
