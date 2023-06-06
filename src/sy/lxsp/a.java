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
    @Override
    public void run() {
        while (true){
            if (num <= 0){
                System.out.println("售票结束");
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
class rl implements Runnable {
        //让多个线程共享num
    private  int num = 100;
    @Override
    public void run() {
        while (true){
            if (num <= 0){
                System.out.println("售票结束");
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