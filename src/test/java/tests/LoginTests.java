package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if(app.getHelperUser().isLogged()) {
        app.getHelperUser().logout();
        }
    }


    @Test
    public void loginSuccess() {
    app.getHelperUser().openloginForm();
    app.getHelperUser().fillLoginForm("mikh.panfilovv31145@gmail.com","Mixan31145$");
    app.getHelperUser().submitLogin();
        //Assert --> if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
     // app.getHelperUser().clickOkButton();


    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openloginForm();
        app.getHelperUser().fillLoginForm("mikh.panfilovv31145@gmail.com","Mixan31145$");
        app.getHelperUser().submitLogin();
        //Assert --> if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        //app.getHelperUser().clickOkButton();


    }

    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openloginForm();
        app.getHelperUser().fillLoginForm("mikh.panfilovvgmail.com","Mixan31145$");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().wrongEmailData(),"It'snot look like email");
    }

    @Test
    public void loginWrongPassword() {
        app.getHelperUser().openloginForm();
        app.getHelperUser().fillLoginForm("mikh.panfilovv31145@gmail.com","Mixan311");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }

    @Test
    public void loginUnregisteredUser() {
        app.getHelperUser().openloginForm();
        app.getHelperUser().fillLoginForm("mikh.panfilovv45@gmail.com","Mixan31145$");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }

}
