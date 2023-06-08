package xc.Homewor01;

import java.util.Scanner;

public class Homewor {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);//要把a传给b

        a.start();
         b.start();
    }
}
//创建A线程类，因为这里的A不会去继承别的类所以说用继承比较简单
class A extends Thread{
    private boolean loop = true;

    @Override
    public void run() {
        //输出一到一百随机数字
        while (loop){
            System.out.println((int) (Math.random() * 100 +1));
              //休眠
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        }
    }
    public  void loo(boolean loop){//可以修改loop变量实现关闭
        this.loop = loop;
    }
}
//知道第二个线程从键盘读取了q命令
class B extends Thread{
    //创建A的对象
    private A a;
    private Scanner scanner = new Scanner(System.in);//接收键盘输入
    public B(A a) {//构造器中直接传入A类对象
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            //接收用户输入
            System.out.println("请输入Q退出线程");
        /*
1. scanner.next()：从控制台输入一个字符串，保存在scanner对象中。
2. toLowerCase()：将字符串转换为小写字母形式。
3. charAt(0)：取得字符串的第一个字符。
最终结果是获取用户输入的第一个字符，并将其转换为小写字母形式*/
            char c = scanner.next().toLowerCase().charAt(0);
            if (c == 'q'){
                //以通知的方式结束线程
                a.loo(false);
                System.out.println("b线程退出");
                break;
            }
        }
    }
}