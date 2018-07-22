package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Karthik on 10/25/2016.
 */
public class ZkossMainPage extends ZkossBasePage {
    private WebDriver driver;

    public ZkossMainPage(){
        super();
    }
    public ZkossMainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver , this);
    }

   @FindBy(name = "UserName")
   private WebElement userNameInput;

   @FindBy(name = "Password")
   private WebElement userPassword;

   @FindBy(name = "Login")
   private WebElement loginBtn;

    public void Login(String userName, String password)
    {
        sendChar(userNameInput,userName);
        sendChar(userPassword,password);
    }

    public void ClickLogin()
    {
        submit(loginBtn);
    }


}
