package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 坦克大战绘图区
 * Eileen监听 键盘事件 实现KeyListener
 * 为了让panel不停的重绘子弹，需要将ht 实现Run able，当作一个线程使用
 */
public class Ht extends JPanel implements KeyListener, Runnable {
    // 定义自己的坦克
    PlayerThank playerThank = null;
    // 定义敌人坦克，放入Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    // 定义一个Vector，用于存放炸弹图片, 当子弹击中坦克时，就加入一个bumb对象到boms
    Vector<Bomb> bombs = new Vector<>();
    // 定义三张图片，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    int enemyTankSize = 3;

    public Ht() {
        // 初始化自己的坦克
        playerThank = new PlayerThank(100, 100);
        playerThank.setSpeed(10);
        EnemyTank enemyTank;
        // 初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            // 初始化敌人的坦克并且指定方向
            enemyTank = new EnemyTank((100 * (i + 1)), 0);
            // 指定方向
            enemyTank.setDirect(2);
            enemyTank.setSpeed(2);
            new Thread(enemyTank).start();
            // 给enemy Tank加入一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            // 加入enemytank的Vector 成员
            enemyTank.shots.add(shot);
            // 启动shot对象
            new Thread(shot).start();
            // 加入数组
            enemyTanks.add(enemyTank);
        }

        //初始化图片对象
        /*
         * 这段代码是Java中获取图像资源的方法。
         * 具体来说，Toolkit类是Java中用于访问本地窗口系统的工具类，
         * 然后，通过Panel类的getResource()方法获取资源路径，
         * 再通过getImage()方法获取图像资源。
         * "/bomb_1.gif"是资源路径，表示在程序运行时，
         * 从项目的根目录开始寻找名为"bomb_1.gif"的图像文件。
         * 总之，这段代码的作用是获取指定路径下的图像资源，并将其存储在Image对象中，以便在程序中使用。
         */
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色
        //画出坦克-封装方法
        drawTank(playerThank.getX(), playerThank.getY(), g, playerThank.getDirect(), 1);
        //画出ho射击子弹
        if (playerThank.shot != null && playerThank.shot.isLive == true) {
//            g.fill3DRect(playerThank.shot.x,playerThank.shot.y,1,1,false);
            g.draw3DRect(playerThank.shot.x, playerThank.shot.y, 3, 3, false);
        }
        // 如果bombs集合中有对象就画出爆炸效果
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            // 根据当前bomb对象的life值画出对应的图片
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            // 让炸弹生命值减少
            bomb.lifeDown();
            // 如果bomb为0 就从bombs集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }
        // 画出敌人的坦克，遍历vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            // 取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            // 然后调用敌人坦克的方法
            // 判断敌人坦克是否为false如果是false就不绘制
            if (enemyTank.isLeve) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                // 画出enemyTank 所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    // 取出当前enemytan的k子弹
                    Shot shot = enemyTank.shots.get(j);
                    // 绘制
                    // isLive == true才绘制子弹
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 3, 3, false);
                    } else {
                        //从Vector移出子弹
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
    }

    //编写方法，画出坦克

    /**
     * @param x      坦克的右上角x坐标
     * @param y      坦克的右上角y坐标
     * @param g      画笔
     * @param direct 坦克的方向（上下左右
     * @param type   坦克的类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        // 判断坦克类型
        // 根据不同的坦克类型，设置不同的颜色
        switch (type) {
            // 表示敌人的坦克
            case 0:
                g.setColor(Color.cyan);
                break;
            // 表示自己的坦克
            case 1:
                g.setColor(Color.yellow);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        // 根据坦克方向，来绘制坦克
        // direct 表示方向(0：表示向上，1表示向右，2表示向下，3表示向左)
        switch (direct) {
            case 0: // 表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1: // 表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克的盖子
                g.fillOval(x + 10, y + 10, 20, 20);//画出坦克圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2: // 向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3: // 向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克的盖子
                g.fillOval(x + 10, y + 10, 20, 20);//画出坦克圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            // 如果没有匹配则会分配到default
            default:
                System.out.println("暂时未处理");
        }
    }

    /**
     * 编写方法判断我方子弹是否击中地方坦克
     *
     * @param s//表示子弹
     * @param enemyTank//表示敌方坦克
     */
    public void hitTank(Shot s, EnemyTank enemyTank) {
        // 判断s是否击中坦克
        // enemyTank.getDirect()传入敌人坦克的上下左右进行判断
        switch (enemyTank.getDirect()) {
            // 坦克向上
            case 0:
                // 坦克向下
            case 2:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40 && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    // 如果满足以上条件就销毁子弹线程和坦克
                    s.isLive = false;
                    enemyTank.isLeve = false;
                    // 当我的子弹击中敌人坦克后，将enemytan从kvector拿掉
                    enemyTanks.remove(enemyTank);
                    // 创建bomb对象，加入到bobms集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    // 创建好一个对象后加入到boms里面去
                    bombs.add(bomb);
                }
                break;
            // 向右
            case 1:
            // 向左
            case 3:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60 && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLeve = false;
                    enemyTanks.remove(enemyTank);
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    // 创建好一个对象后加入到boms里面去
                    bombs.add(bomb);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + enemyTank.getDirect());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 处理键wdsa 按下的情况
     *
     * @param e 键盘处理事件
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {//按下w键
            //改变坦克的方向
            playerThank.setDirect(0);
            // 当我放坦克向上到达边界的时候就停止移动
            if (playerThank.getY() >= 0) {
                //修改坦克的坐标
                playerThank.moveUP();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {//D键
            playerThank.setDirect(1);
            // 控制自己坦克向右移动到边界的时候就停止
            if (playerThank.getX() +60 <= 1000) {
                playerThank.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {//S键
            playerThank.setDirect(2);
            //判断坦克向下移动到边界就停止
            if (playerThank.getY() +60 <= 750) {
                playerThank.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {//A键
            //判断是否移动到右边边界上
            playerThank.setDirect(3);
            if (playerThank.getX() >= 0) {
                playerThank.moveLeft();
            }
        }
        //如果用户按下的是j，就发射
        if (e.getKeyCode() == KeyEvent.VK_J) {
            playerThank.Shotziji();
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔一百毫秒，重绘区域//刷新绘图区
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断是否击中了敌人坦克因为这个每隔一百秒就会执行一次所以把上面的扔下来
            //这里要判断一下这个是否创建了
            if (playerThank.shot != null && playerThank.shot.isLive) {//判断自己的子弹是否还活着
                //因为不知道你击中了敌人的哪个坦克所以说用遍历
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //取出敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(playerThank.shot, enemyTank);
                }
            }
            this.repaint();
        }

    }
}
