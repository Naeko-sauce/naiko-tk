package ck.tk2;

import javax.swing.*;
//界面
public class kc2 extends JFrame {
    //定义一个ht
    ht mp = null;

    public static void main(String[] args) {
        kc2 kc = new kc2();
    }
    //初始化一个构造器
    public kc2() {
        mp = new ht();//初始化界面
        this.add(mp);//把游戏的绘图区域加进去
        this.setSize(1000,750);//窗口大小
        this.addKeyListener(mp);//让JFrame 监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//结束的小×
        this.setVisible(true);
    }
}
