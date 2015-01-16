import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 10/9/14
 * Time: 10:47 AM
 */
public class MyJunit {

    private int num = 1;

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

    @Test
    public void testArray() {
        String dateStr = "20140702054407.30";
        Date myDate;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss.mmm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月ddhhmmss.mmm");
        try {
            myDate = sdf.parse(dateStr);
            System.out.println(sdf2.format(myDate.toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void randomTest() {
        List<String> aaa = Lists.newArrayList("12345", "54321");
        System.out.println("Result : " + aaa.toString());
    }
}
