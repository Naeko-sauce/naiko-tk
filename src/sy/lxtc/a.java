package sy.lxtc;

public class a {
    public static void main(String[] args) {
        t t = new t();
        t.start();
//        如果希望main可以控制t线程的终止，必须添加一个控制变量，去修改loo
        //让t 退出run方法，从而终止t线程 -》 通知方式
        //让主线程休眠10秒 在通知t线程退出
        try {
            Thread.sleep(4*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t.setLoo(false);
        System.out.println("线程结束");
    }
}
class t extends Thread {
    //设置一个控制变量
    private boolean loo = true;
    @Override
    public void run() {
    while (loo){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("线程还在运行");
    }

    }
    public void setLoo(boolean loo){
        this.loo = loo;
    }
}