import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 1/14/15
 * Time: 4:12 PM
 */
public class Compare {

    private static String FILE1_PATH = "D://Container Event//1.14//0106//0110.txt";

    private static String FILE2_PATH = "D://Container Event//1.14//0106//0110_shp.txt";


    public static void main(String[] args) throws Exception {
        File file1 = new File(FILE1_PATH);
        File file2 = new File(FILE2_PATH);
        BufferedReader br = new BufferedReader(new FileReader(file1));
        Set<String> setA = new HashSet<String>();
        Set<String> setB = new HashSet<String>();
        String lineData;
        while ((lineData = br.readLine()) != null) {
            setA.add(lineData);
        }
        br = new BufferedReader(new FileReader(file2));
        while ((lineData = br.readLine()) != null) {
            setB.add(lineData);
        }
        setB.removeAll(setA);
        System.out.println(setB);
        System.out.println("--------------");
    }
}
