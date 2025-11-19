package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openloginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }


    public void fillLoginForm(String email, String password) {
    type(By.id("email"),email);
    type(By.id("password"),password);
    }

    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));
    }

    public String getMessage() {
//        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = element.getText();
//        return text;
       // pause(2000);

        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public void clickOkButton() {
        By okButtonLocator = By.xpath("//button[text()='Ok']");
        if (isElementPresent(okButtonLocator)) {
            click(okButtonLocator);
        }
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

    public String wrongEmailData() {
        return wd.findElement(By.cssSelector(".error")).getText();
    }
}
