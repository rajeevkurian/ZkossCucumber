package Base;

import org.openqa.selenium.WebDriver;

/**
 * Created by Karthik on 10/21/2016.
 */
public class ZkossUtil {

    public WebDriver Driver;

    public static void waitFor(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
