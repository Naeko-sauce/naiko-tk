package practice.sy.xc;
//演示通过继承TRhread 类创建线程
public class xcl {
    public static void main(String[] args) {
        //创建一个cha对象，当作线程使用、
        cha cha = new cha();
        //1当start启动后会进入
       /*
       *     public synchronized void start() {
                然后执行
                * start0()
*                }
* //start0()是本地方法是由jvm机调用的，底层是c/c++实现的
    private native void start0();
    * 真正实现多线程效果的是start0()，而不是run
        * */
        cha.start();
        //每个线程都会单独执行不会影响到下面的代码
        //这时主线程和线程是交替执行的
        for (int i = 0; i < 20; i++) {
            System.out.println("111");
            //让主线程休眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
//当一个类继承了 Thread类，该类就可以当作线程使用
//run Thread类，实现了Runnable 接口的run方法
class cha extends Thread{
    int t = 0;

    @Override
    public void run() {//重写run方法写上自己的业务逻辑
        //该线程每隔1秒在控制台输入喵喵
        while (true){
            t++;
            System.out.println("喵喵"+"线程名"+Thread.currentThread().getName());
            //让该线程休息一秒,有异常让他抛出
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (t == 80){
                break;
            }
        }
    }
}
//jconsole在终端控制打开查看线程的进程
