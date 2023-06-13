package practice.d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class event_  extends  JFrame{//继承窗口
    ma ma = null;
    public static void main(String[] args) {
        event_ event_ = new event_();
    }
    //构造器
    public event_(){
        ma = new ma();
        this.add(ma);
        this.setSize(400,300);
        //窗口JFrame可以监听键盘事件，即可以监听到面板上发生的事件
        this.addKeyListener(ma);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
//面板 可以画出小球
//KeyListener 是监听器，可以监听键盘事件
class ma extends JPanel implements KeyListener {
    //为了让小球可以移动，把左上角的坐标(x,y)设置为变量
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);//默认黑色
    }
    //有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
//当某个键按下，某个键就会触发
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println((char) e.getKeyCode()+"键被按下了");
        //根据哟农户按下的不同键来处理移动
        //在Java中会给每一个键分配一个int值
        if (e.getKeyCode()== KeyEvent.VK_DOWN){// KeyEvent.VK_DOWN就是箭头向下对应的code值\
//           如果向下就让y++
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP){
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            x--;
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            x++;
        }
        //让面板重绘
        this.repaint();
    }
//当某个键松开，该方法就会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
