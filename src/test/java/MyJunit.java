import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 10/9/14
 * Time: 10:47 AM
 */
public class MyJunit {



    @Test
    public void testAssert() {
        Assert.assertFalse(false);
    }

    public final Logger logger = Logger.getLogger(MyJunit.class.getName());

    @Test
    public void testLog4J() {
        for (int i = 0; i < 800000; i++) {
            logger.debug(i);
            logger.debug("===============================================");
        }
    }
}
