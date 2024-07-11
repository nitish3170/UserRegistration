import org.example.UserRegistration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.ValueSource;

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
    @ParameterizedTest
    @ValueSource(strings = {
            "test.sds@example.co.ij",
            "user.name+tag+sorting@example.com",
            "user.name@example.co.uk",
//            "invalid-email@",
//            "@example.com",
//            "user@.com.my"
            })
    void validEmail (String mail){
        String result= UserRegistration.emailValidate(mail);
        Assert.assertEquals("HAPPY",result);
    }

}
