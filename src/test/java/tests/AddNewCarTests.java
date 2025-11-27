package tests;

import models.Car;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase{

    @BeforeClass
    public void preCondition() {
        if(!app.getHelperUser().isLogged())
            app.getHelperUser().login(new User().setEmail("mikh.panfilovv31145@gmail.com").setPassword("Mixan12345$"));
    }

    @Test
    public void addNewCarSuccess() {
        int i = new Random().nextInt(1000)+1000;
        Car car = Car.builder()
                .location("Haifa,Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2024")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900-"+i)
                .price(50.)
                .about("Very nice car")
                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("C:\\Lessons\\Qa_31\\Qa_31_ilCarro\\Bugatti_Veyron_16.4_–_Frontansicht_(1),_5._April_2012,_Düsseldorf 1.jpg");
        app.getHelperCar().submitCarForm();
    }

}
