package steps;


import Base.ZkossUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.PropertyPermission;
import java.util.concurrent.TimeUnit;

/**
 * Created by Karthik on 10/17/2016.
 */
public class Container extends ZkossUtil {

    private ZkossUtil base;
    private WebDriver driver;
    //This is a Pico container
    private Properties zkossProperties;
    private WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public ZkossUtil getBase() {
        return base;
    }

    public void setBase(ZkossUtil base) {
        this.base = base;
    }

    public Container(ZkossUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {

        System.out.println("Opening the browser ");
        try{
            /*System.setProperty("webdriver.firefox.marionette", "D:\\Libs\\geckodriver.exe");
        base.Driver = new FirefoxDriver();*/

/*        //Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        base.Driver = new ChromeDriver();
        base.Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);*/

            // Initialize drivers and properties
            zkossProperties = new Properties();
            zkossProperties.load(this.getClass().getClassLoader().getResourceAsStream("zkoss.properties"));
            String driverSelected = zkossProperties.getProperty("driver");
            System.out.println("***** Driver selected is ****"+driverSelected);
            if(driverSelected.equalsIgnoreCase("chrome")){
                //load chrome driver. //chrome driver
                System.setProperty("webdriver.chrome.driver","chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
                driver.manage().window().maximize();
            }
            base = new ZkossUtil();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }

       //driver.quit();
    }

}
