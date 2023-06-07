package xc.state;
//测试
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        /*
        * 在Java中，
        * Thread.State是一个枚举类型，
        * 表示线程的状态。
        * 它包括NEW（新建）、
        * RUNNABLE（可运行）、
        * BLOCKED（阻塞）、
        * WAITING（等待）、
        * TIMED_WAITING（超时等待）
        * 和TERMINATED（终止）六种状态。

这句话的意思是，
* 在一个线程t终止之前，
* 不断地检查该线程的状态是否为TERMINATED。
* 如果线程状态不是TERMINATED，
* 则继续执行循环体内的代码；
* 如果线程状态已经是TERMINATED，
* 则跳出循环。
* 这个循环可以用来等待一个线程执行完毕后再继续执行后面的代码。
* 其中getName()方法用来获取线程的名称，getState()方法用来获取线程的状态
        * */
        System.out.println(t.getName()+"状态"+t.getState());
        t.start();
        while (Thread.State.TERMINATED != t.getState()){
            System.out.println(t.getName()+"状态"+t.getState());
            Thread.sleep(500);
        }
        System.out.println(t.getName()+"状态"+t.getState());
    }
}

class T extends  Thread{
    @Override
    public void run() {
        while (true){
            for (int j = 0; j < 10; j++) {
                System.out.println("h1"+ j);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            break;
        }
    }
}