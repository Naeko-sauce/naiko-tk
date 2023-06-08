package xc.Deadlock;
//模拟线程死锁
public class DeadLoc {
    public static void main(String[] args) {
        //模拟死锁现象
        DeadLockDemo A = new DeadLockDemo(true);
        DeadLockDemo b = new DeadLockDemo(false);
        A.start();
        b.start();
    }
}
class  DeadLockDemo extends Thread{
    static Object o1 = new Object();//保证多线程，共享一个对象，这里用static
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        //如果flag为t，线程A 就会先得到o1对象锁，然后会尝试去获取o2对象锁
        //如果线程A得不到o2对象锁，就会blocke(阻塞 )
        //如果另一个线程围为f，线程b就会先得到o2对象锁，然后尝试获取o1对象锁
        //如果线程b得不到o1，就会blocked(阻塞)
       if (flag){
           synchronized (o1){//对象互斥锁，下面是同步代码
//               currentThread()currentThread()是Thread类的一个静态方法，返回当前正在执行的线程对象。getName()是Thread类的一个实例方法，返回线程的名称。所以Thread.currentThread().getName()就是获取当前线程的名称。
               System.out.println(Thread.currentThread().getName()+"进入1");
               synchronized (o2){//这里获得li对象的监视权
               System.out.println(Thread.currentThread().getName()+"进入2");
           }
           }

       }else {
           synchronized (o2){
               System.out.println(Thread.currentThread().getName()+"进入3");
               synchronized (o1){
               System.out.println(Thread.currentThread().getName()+"进入4");
           }
           }

       }
    }
}