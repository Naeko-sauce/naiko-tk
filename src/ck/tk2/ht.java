package ck.tk2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//坦克大战绘图区
//Eileen监听 键盘事件 实现KeyListener
//为了让panel不停的重绘子弹，需要将ht 实现Run able，当作一个线程使用
public class ht extends JPanel  implements KeyListener,Runnable  {
    //定义自己的坦克
    ziji ho = null;
    //定义敌人坦克，放入Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;
    public ht(){
        ho = new ziji(100,100);//初始化自己的坦克
        ho.setSpeed(2);
        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //初始化敌人的坦克并且指定方向
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            //指定方向
            enemyTank.setDirect(2);
            //给enemy Tank加入一颗子弹
           Shot shot = new Shot(enemyTank.getX() +20,enemyTank.getY()+60,enemyTank.getDirect());
           //加入enemytank的Vector 成员
            enemyTank.shots.add(shot);
            //启动shot对象
            new Thread(shot).start();
            //加入数组
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形，默认黑色
        //画出坦克-封装方法
        drawTank(ho.getX(), ho.getY(), g, ho.getDirect(), 1);
        //画出ho射击子弹
        if (ho.shot != null && ho.shot.isLive == true){
//            g.fill3DRect(ho.shot.x,ho.shot.y,1,1,false);
            g.draw3DRect(ho.shot.x,ho.shot.y,3,3,false);
        }
        //画出敌人的坦克，遍历vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //然后调用敌人坦克的方法
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),0);
            //画出enemyTank 所有子弹
            for (int j = 0; j <enemyTank.shots.size() ; j++) {
                //取出当前enemytan的k子弹
                Shot shot = enemyTank.shots.get(j);
                //绘制
                if (shot.isLive){ // isLive == true才绘制子弹
                    g.draw3DRect(shot.x,shot.y,3,3,false);
                } else {
                    //从Vector移出子弹
                    enemyTank.shots.remove(shot);
                }
            }
        }
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
            case 0:
                //表示敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1://表示自己的坦克
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克方向，来绘制坦克
        //direct 表示方向(0：表示向上，1表示向右，2表示向下，3表示向左)
        switch (direct){
            case 0://表示向上
                g.fill3DRect(x, y, 10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x+30, y, 10,60,false);//画出坦克右边的轮子
                g.fill3DRect(x+10,y+10,20,40,false);//画出坦克的盖子
                g.fillOval(x+10,y+20,20,20);//画出坦克圆形盖子
                g.drawLine(x+20,y+30,x+20,y);
                break;
            case 1://表示向右
                g.fill3DRect(x, y, 60,10,false);//画出坦克上边的轮子
                g.fill3DRect(x, y+30, 60,10,false);//画出坦克下边的轮子
                g.fill3DRect(x+10,y+10,40,20,false);//画出坦克的盖子
                g.fillOval(x+10,y+10,20,20);//画出坦克圆形盖子
                g.drawLine(x+30,y+20,x+60,y+20);
                break;
            case 2://向下
                g.fill3DRect(x, y, 10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x+30, y, 10,60,false);//画出坦克右边的轮子
                g.fill3DRect(x+10,y+10,20,40,false);//画出坦克的盖子
                g.fillOval(x+10,y+20,20,20);//画出坦克圆形盖子
                g.drawLine(x+20,y+30,x+20,y+60);
                break;
            case 3://向右
                g.fill3DRect(x, y, 60,10,false);//画出坦克上边的轮子
                g.fill3DRect(x, y+30, 60,10,false);//画出坦克下边的轮子
                g.fill3DRect(x+10,y+10,40,20,false);//画出坦克的盖子
                g.fillOval(x+10,y+10,20,20);//画出坦克圆形盖子
                g.drawLine(x+30,y+20,x,y+20);
                break;
                //如果没有匹配则会分配到default
            default:
                System.out.println("暂时未处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
//处理键wdsa 按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){//按下w键
            //改变坦克的方向
            ho.setDirect(0);
            //修改坦克的坐标
            ho.moveUP();
        } else if (e.getKeyCode() == KeyEvent.VK_D){//D键
            ho.setDirect(1);
            ho.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S){//S键
            ho.setDirect(2);
            ho.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A){//A键
            ho.setDirect(3);
            ho.moveLeft();
        }
        //如果用户按下的是j，就发射
        if (e.getKeyCode() == KeyEvent.VK_J){
            ho.Shotziji();
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔一百毫秒，重绘区域//刷新绘图区
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.repaint();
        }

    }
}
