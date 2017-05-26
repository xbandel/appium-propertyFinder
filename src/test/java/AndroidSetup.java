import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSetup {

    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
        File appDir = new File("/home/victor/xenia/appium/androidTest/apps");
        File app = new File(appDir, "app-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("app", app.getAbsolutePath());

        driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        String DEVICE_NAME = "emulator-5554";
        String DEVICE_ORIENTATION = "portrait";

        String PLATFORM_VERSION = "5.1.1";
        //String PLATFORM_VERSION = "6.0";
        String PLATFORM_NAME = "Android";
        String HUB_URL = "http://127.0.0.1:4723/wd/hub";

        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("appiumVersion","1.6.4");
        //caps.setCapability("AVD_NAME", NConstants.AVD_NAME);
        caps.setCapability("deviceName",DEVICE_NAME);
        caps.setCapability("deviceOrientation", DEVICE_ORIENTATION);
        //cap.setCapability("browserName", NConstants.BROWSER_NAME);
        caps.setCapability("platformVersion",PLATFORM_VERSION);
        caps.setCapability("platformName",PLATFORM_NAME);
        //caps.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT,500000);
        caps.setCapability("fullReset","false");
        caps.setCapability("locationServicesAuthorized", true);

    }
}
