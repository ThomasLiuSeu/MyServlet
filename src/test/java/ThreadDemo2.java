/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 12/24/14
 * Time: 4:13 PM
 */
public class ThreadDemo2{
    public static void main(String args[]){
        TestThread t = new TestThread();
        new Thread(t).start();

        for(int i=0; i<100;i++){
            System.out.println("main is running");
        }
    }
}

class TestThread implements Runnable{
    public void run(){
        for(int i = 0;i<100;i++){
            System.out.println("Test thread is running");
        }
    }
}