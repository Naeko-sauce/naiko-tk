package demo;

import javax.swing.*;
import java.awt.*;

//坦克大战绘图区
public class ht extends JPanel {
    //定义自己的坦克
    ziji ho = null;
    public ht(){
        ho = new ziji(100,100);//初始化自己的坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形，默认黑色
        //画出坦克-封装方法
        drawTank(ho.getX(), ho.getY(), g,0,0);

    }
    //编写方法，画出坦克

    /**
     *
     * @param x 坦克的右上角x坐标
     * @param y 坦克的右上角y坐标
     * @param g 画笔
     * @param direct 坦克的方向（上下左右
     * @param type 坦克的类型
     */
    public  void drawTank(int x,int y,Graphics g,int direct ,int type){
         //判断坦克类型
        //根据不同的坦克类型，设置不同的颜色
        switch (type){
            case 0://表示自己的坦克

                g.setColor(Color.cyan);
                break;
            case 1://表示敌人的坦克
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克方向，来绘制坦克
        switch (direct){
            case 0://表示向上
                g.fill3DRect(x, y, 10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x+30, y, 10,60,false);//画出坦克右边的轮子
                g.fill3DRect(x+10,y+10,20,40,false);//画出坦克的盖子
                g.fillOval(x+10,y+20,20,20);//画出坦克圆形盖子
                g.drawLine(x+20,y+30,x+20,y);
                break;
                //如果没有匹配则会分配到default
            default:
                System.out.println("暂时未处理");
        }
    }
}
