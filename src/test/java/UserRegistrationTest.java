import org.example.CustomException;
import org.example.UserRegistration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.ValueSource;

public class UserRegistrationTest {
    @Test
    public void fNameTest(){
        try {
            Assert.assertEquals(true, UserRegistration.fNameValidate("Harshal"));
        } catch ( CustomException e) {
            Assert.fail("Exception should not have been thrown");
        }
    }
    @Test
    public void invalidFirstNameTest() {
        try {
            UserRegistration.fNameValidate("harshal"); // Invalid last name
            Assert.fail("Expected CustomException not thrown");
        } catch (CustomException e) {
            Assert.assertEquals("Invalid First Name", e.getMessage());
        }
    }


    @Test
    public void lnameTest(){
        try {
            Assert.assertEquals(true, UserRegistration.lNameValidate("Gotarne"));
        } catch (CustomException e) {
            Assert.fail("Exception should not have been thrown");
        }
    }
    @Test
    public void invalidLastNameTest() {
        try {
            UserRegistration.lNameValidate("gotarne"); // Invalid last name
            Assert.fail("Expected CustomException not thrown");
        } catch (CustomException e) {
            Assert.assertEquals("Invalid Last Name", e.getMessage());
        }
    }

    @Test
    public void emailTest(){
        try {
            Assert.assertEquals(true, UserRegistration.emailValidate("asa.sds@sds.sds.ds"));
        } catch (CustomException e) {
            Assert.fail("Exception should not have been thrown");
        }
    }

    @Test
    public void phoneNumberTest(){
        try {
            Assert.assertEquals( true, UserRegistration.phoneNumberValidate("91 9876987698"));
        } catch (CustomException e) {
            Assert.fail("Exception should not have been thrown");
        }
    }
    @Test
    public void invalidPhoneNumberTest(){
        Assert.assertThrows(CustomException.class,
                () -> {
                    UserRegistration.phoneNumberValidate("91 987697698");
                });
    }
    @Test
    public void passwordTest(){
        try {
            Assert.assertEquals(true, UserRegistration.passwordValidate("asA!1asa"));
        } catch (CustomException e) {
            Assert.fail("Exception should not have been thrown");
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {
            "test.sds@example.co.ij",
            "user.name+tag+sorting@example.com",
            "user.name@example.co.uk"
            })
    void validEmail (String mail){
        try {
            Assert.assertEquals(true, UserRegistration.emailValidate(mail));
        } catch (CustomException e) {
            Assert.fail("Exception should not have been thrown");
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {
            "invalid-email@",
            "@example.com",
            "user@.com.my"
    })
    void invalidEmail (String mail){
        try {
            UserRegistration.emailValidate(mail); // Invalid email
            Assert.fail("Expected CustomException not thrown");
        } catch (CustomException e) {
            Assert.assertEquals("Invalid Email", e.getMessage());
        }
    }

}
