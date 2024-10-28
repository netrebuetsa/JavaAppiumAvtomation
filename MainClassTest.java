import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MainClassTest {

    @Test
    public void testGetClassString()
    {
        MainClass String = new MainClass();
        Assert.assertTrue("class_string does not contain a substring hello or Hello", String.getClassString().contains("Hello") | String.getClassString().contains("hello"));
    }

    @Test
    public void testGetClassNumber()
    {
        MainClass Number2 = new MainClass();
        Assert.assertTrue("class_number <= 45",Number2.getClassNumber() > 45);
    }

    @Test
    public void testGetLocalNumber()
    {
        MainClass Number1 = new MainClass();
        Assert.assertTrue("number != 14",Number1.getLocalNumber() == 14);
    }
}
