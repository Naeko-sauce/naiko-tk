package practice.sy.lxxcd;

public class a {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new t());
        for (int i = 0; i < 10; i++) {
            System.out.println("haa"+i);
            if (i == 5){//说明主线程走了5次
                thread.start();//立即启动子线程
                thread.join();//立即礼让子线程插入道main让子线程先执行
            }
        }
    }
}
class t implements Runnable {
    private int cont= 0;
    @Override
    public void run() {
       while (true){
           System.out.println("h"+(++cont));
           //线程休眠
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           if (cont == 10){
               break;
           }
       }
    }
}
