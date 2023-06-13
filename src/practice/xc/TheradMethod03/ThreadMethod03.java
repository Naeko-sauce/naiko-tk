package practice.xc.TheradMethod03;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemoThread myDaemoThread = new MyDaemoThread();
        //如果我们希望当主线程结束后子线程自动结束
        //只需将子线程设为守护线程即可
        //要先设置守护线程在启动线程
        myDaemoThread.setDaemon(true);
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
