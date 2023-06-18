package game;

import java.util.Vector;

/**
 * 敌人的坦克类
 */
public class EnemyTank extends Tk implements Runnable{
    // 在敌人坦克类，使用Vector保存多个Shot，不用私有是因为懒得创建get和set
    Vector<Shot> shots = new Vector<>();
    // 控制敌人坦克是否销毁
    boolean isLeve = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true){
            //这里判断如果shots size() ==0 ，就创建一颗子弹，放入到shts集合，并启动
            if (isLeve && shots.size() <20){
                Shot s = null;
                //判断坦克的方向创建对应的子弹
                switch (getDirect()){
                    case 0:
                        s = new Shot(getX() +20,getY(),0);
                        break;
                    case 1:
                        s = new Shot(getX()+60,getY()+20,1);
                        break;
                    case 2:
                        s = new Shot(getX() +20,getY()+60,2);
                        break;
                    case 3:
                        s = new Shot(getX(),getY()+20,3);
                        break;
                }
                shots.add(s);
                //启动子弹线程
                new Thread(s).start();
            }
            //根据坦克的方向来继续移动
            switch (getDirect()){
                //向上
                case 0:

                      for (int i = 0; i < 30; i++) {
                          // 判断坦克是否触碰到上边界
                          if (getY() >=0) {
                              moveUP();
                          }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                      break;
                      //右边
                case 1:
                    for (int i = 0; i < 30; i++) {
                        // 判断是否触碰到右边界
                        if (getX() +60 <=1000) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    break;
                    //下边
                case 2:
                    for (int i = 0; i < 30; i++) {
                        // 判断是否触碰到下边界
                        if (getY() +60 <750) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    break;
//                    左边
                case 3:
                    for (int i = 0; i < 30; i++) {
                        // 判断是否触碰到左边界
                        if (getX()>0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + getDirect());
            }
            // 然后随机改变坦克的方向
            setDirect((int)(Math.random()*4));
            // 判断线程什么时候退出
            if (!isLeve){
                break;
            }
        }
    }
}
