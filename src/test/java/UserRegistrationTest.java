import org.example.UserRegistration;
import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationTest {
    @Test
    public void fnameTest(){
        String result=UserRegistration.fNameValidate("Harshal");
        Assert.assertEquals("HAPPY",result);
    }
    @Test
    public void lnameTest(){
        String result=UserRegistration.lNameValidate("Gotarne");
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void emailTest(){
        String result=UserRegistration.emailValidate("asa.sds@sds.sds.ds");
        Assert.assertEquals("HAPPY",result);
    }

    @Test
    public void phoneNumberTest(){
        String result=UserRegistration.phoneNumberValidate("91 9876987698");
        Assert.assertEquals("HAPPY",result);
    }
    @Test
    public void passwordTest(){
        String result=UserRegistration.passwordValidate("asA!1asa");
        Assert.assertEquals("HAPPY",result);
    }


}
