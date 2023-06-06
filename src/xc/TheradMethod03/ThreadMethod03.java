package xc.TheradMethod03;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemoThread myDaemoThread = new MyDaemoThread();
        myDaemoThread.start();
        //主线程运行十次后就退出了
        for (int i = 0; i < 10; i++) {
            System.out.println("工作中");
            Thread.sleep(1000);
        }
    }
}
class MyDaemoThread extends Thread{
    int i = 0;
    @Override
    public void run() {
      for (;;){//无限循环
          try {
              Thread.sleep(1000);//休眠一千毫秒
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
          System.out.println("输出"+(i++));
      }
    }
}
