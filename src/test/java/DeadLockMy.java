/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 12/24/14
 * Time: 4:58 PM
 */
public class DeadLockMy {
    public static void main(String[] args) {
        MyResource r1 = new MyResource();
        MyResource r2 = new MyResource();
        Thread t1 = new ThreadTest1(r1, r2);
        Thread t2 = new ThreadTest2(r1, r2);
        t1.start();
        t2.start();
    }
}

class MyResource {
    int i = 0;
}
class ThreadTest1 extends Thread{
    private MyResource r1, r2;
    public ThreadTest1(MyResource r1, MyResource r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (r1) {
                System.out.println("R1 in test 1");
                synchronized (r2) {
                    System.out.println("R2 in test 1");
                }
            }
        }
    }
}

class ThreadTest2 extends Thread{
    private MyResource r1, r2;
    public ThreadTest2(MyResource r1, MyResource r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (r1) {
                System.out.println("R1 in test 2");
                synchronized (r2) {
                    System.out.println("R2 in test 2");
                }
            }
        }
    }
}