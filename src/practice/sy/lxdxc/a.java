package practice.sy.lxdxc;

public class a {
    public static void main(String[] args) {
        t2 t2 = new t2();
        t2.start();
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("主线程吃了"+i+"个包子");
            if (i== 5){
//                Thread.yield();//让主线程礼让子线程执行不一定成功
                System.out.println("主线程让，子线程先吃");
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("子线程吃完了，让主线程吃");
            }
        }
    }
}
class t2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);//休眠一秒钟
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("子线程吃了"+i+"个包子");
        }
    }
}
