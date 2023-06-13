package practice.sy.lxxcff;

public class a {
    public static void main(String[] args) {
        //测试相关的方法
        T t = new T();
        t.setName("小a");//给线程设置名称
        t.setPriority(Thread.MIN_PRIORITY);//设置优先级最低
        t.start();//启动了子线程
        System.out.println(t.getName());
        //让主线程打印五个hi，然后就终端子线程 子线程的休眠吗
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("h1"+i );
        }
        System.out.println(t.getName()+"线程优先级"+t.getPriority());
        t.interrupt();//中断线程，当执行到这里，就会中断t线程的休眠
    }
}
class T extends Thread { //自定义线程类

    @Override
    public void run() {
        while (true) {
//        Thread.currentThread().getName()获取当前线程的名称，如果你给他设置了什么名称他就返回什么名称，如果没有设置他就返回默认名称
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "吃包子" + i);

            }
            try {
                System.out.println(Thread.currentThread().getName() + "休眠中");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                //当该线程执行到一个interrupt 方法时，会catch一个异常，可以加入自己的业务代码
                System.out.println(Thread.currentThread().getName() + "被interrupt了");
                //InterruptedException是捕获到一个中断异常
            }
        }
    }
}
