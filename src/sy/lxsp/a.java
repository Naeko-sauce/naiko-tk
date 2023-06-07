package sy.lxsp;
//模拟三个窗口使用多线程同时售票
public class a {
    public static void main(String[] args) {
//        //测试创建三个线程
//        sellt sellt1 = new sellt();
//        sellt sellt2 = new sellt();
//        sellt sellt3 = new sellt();
//        //这里会出现票数超卖现象
//        sellt1.start();//启动线程
//
//        sellt2.start();//启动线程
//        sellt3.start();//启动线程
        rl rl = new rl();
         new Thread(rl).start();//第一个线程窗口
        new Thread(rl).start();//第二个线程窗口
        new Thread(rl).start();//第三个线程窗口
    }
}
//Thread方式
class  sellt extends Thread {
    //让多个线程共享num
    private static int num = 100 ;
    private  boolean loop = true;
    @Override
    public void run() {
        while (true){
            if (num <= 0){
                System.out.println("售票结束");
                loop = false;
                break;
            }
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //打印出线程名，表示这一个窗口售卖了一张票
            System.out.println("窗口"+Thread.currentThread().getName()+"售出"+"剩余"+(--num));
        }
    }
}
//用实现接口的方式//后面可以值创建一个rl对象就可以不用静态
//实现接口方式，使用synchronized实现线程同步
class rl implements Runnable {
        //让多个线程共享num
     private  int num = 100;
     private  boolean loop = true;//退出循环
    Object object = new Object();
    //同步方法(静态的)的锁为当前本身
    //public synchronized static void m1(){}锁是在rl.class

    public synchronized static void m1(){

    }
    //如果在静态方法中，实现一个同步代码
    public static void m2(){
        synchronized (/*this*/rl.class){//不能直接写this
            System.out.println("m2");
        }
    }
    //public synchronized void m(){}就是一个同步方法
    //这时锁在this对象
    //也可以在代码块上写synchronized，同步代码块
    public  /*synchronized*/ void m() {// 同步方法，在同一个时刻，只能有一个线程来执行m方法
        synchronized (/*this*/ object) {//互斥锁还是在this对象 //因为他们操作的是同一个对象object所以也可以实现线程锁
            if (num <= 0) {
                System.out.println("售票结束");
                loop = false;
                return;
            }
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //打印出线程名，表示这一个窗口售卖了一张票
            System.out.println("窗口" + Thread.currentThread().getName() + "售出" + "剩余" + (--num));
        }
    }
          @Override
    public void run() {
        while (loop){
            m();

    }
  }
}

