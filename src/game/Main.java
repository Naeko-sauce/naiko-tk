package game;

import javax.swing.*;
/*
* 坦克大战的界面
* */
public class Main extends JFrame {
    // 定义一个绘图区域
    Ht mp = null;

    public static void main(String[] args) {
        Main kc = new Main();
    }

    //初始化一个构造器
    public Main() {
        mp = new Ht();// 初始化绘图区域
        // 将mp放入到Thread，并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp); // 把绘图区域加进去
        this.setSize(1000,750);// 设置窗口大小
        this.addKeyListener(mp); // 让JFrame监听mp的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 点击关闭按钮时结束程序
        this.setVisible(true);
    }
}
