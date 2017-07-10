import io.swagger.models.Contact;
import leapstack.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhuochen on 2017/7/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)
public class TempTest {

    @Test
    public void testContact(){
        Contact contact = new Contact();
        contact.setName("name");
        contact.setEmail("email");
        contact.setUrl("url");
        System.out.println(contact.toString());

    }
}
