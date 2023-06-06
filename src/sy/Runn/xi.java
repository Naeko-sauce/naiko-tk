package sy.Runn;
/*
* 线程使用runnable实现
*说明
* Java是单继承的，在某些情况下一个类可能已经继承了某个父类，这时在用继承thread类来创建线程显然是不可能的
* Java设计者提供了另一个创建线程，就是通过实现RUnnable接口来创建
* */
public class xi {
    //请编写程序，该程序可以每隔1秒。在控制台输出“h!”，当输出10次后，自动退出。请，
    //使用实现Runnable接口的方式实现。
    public static void main(String[] args) {
//        dog dog = new dog();
////        dog.start()这里不能调用start方法
//        //创建Thread对象，把dog对象(实现了Runnable)，放入Thread
//        Thread thread = new Thread();
//        //这里使用了一个设计模式【代理模式】
//        thread.start();
        ta ta = new ta();
        proxy proxy = new proxy(ta);
        proxy.start();
    }
}
class ainm{}
class ta extends ainm implements Runnable {

    @Override
    public void run() {
        System.out.println("1212");
    }
}
//模拟设计模式【代理模式】
class proxy implements Runnable {
    private Runnable tagr = null;
    @Override
    public void run() {
        if (tagr != null){
            tagr.run();//动态绑定（运行Ta类型 ）
        }
    }//你可以吧proxy类当做 Thread

    public proxy(Runnable tagr) {
        this.tagr = tagr;
    }
    public void start(){
        start0();
    }
    public  void start0(){
        run();
    }
}
class dog implements  Runnable {//通过实现Runnable接口，开发线程
    int nu = 0;
    @Override
    public void run() {
        while (true){
            System.out.println("小狗汪汪叫"+(++nu)+"线程名称"+ Thread.currentThread().getName());
            //休眠一秒并抛出异常
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (nu == 10){
                break;
            }
        }
    }
}

