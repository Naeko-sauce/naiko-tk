package ht;

import javax.swing.*;
import java.awt.*;

//如何在Java中绘图
public class h extends JFrame{//对应窗口,可以理解为一个画框
    //定义一个画板
    String d = "<a href=\"html\">超链接</a>j";
//    String d = """<a href="html">超链接</a>""";
    private Mypanel mp = null;
    public static void main(String[] args) {
        new h();
    }
    public h(){
        //初始化画板
        mp = new Mypanel();
        //把画板放入到窗口\
        this.add(mp);
        //设置大小
        this.setSize(400,400);
        //当点击窗口的×程序就被彻底终止
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可以显示symotion-s)
    }
}

//symotion-s)先定义一个MyPanel，继承Jpanel，画图型，就在面板上画
class Mypanel extends JPanel{
    //调用他的构造器
    //mypnel对象就是一个画板
    //Graphics g 把 g 理解成一只画笔
    //Graphics 提供了很多绘图方法
    @Override
    public void paint(Graphics g) {//绘图方法
        System.out.println("a");
        super.paint(g);//调用父类的方法完成初始化
        g.drawOval(10,10,100,100);

    }
}
