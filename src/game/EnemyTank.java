package game;

import java.util.Vector;

/**
 * 敌人的坦克
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
            //根据坦克的方向来继续移动
            switch (getDirect()){
                case 0:

//                      for (int i = 0; i < 30; i++) {
                           moveUP();

//                        try {
//                            Thread.sleep(50);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//
//                    }
//                      break;
                case 1:
//                    for (int i = 0; i < 30; i++) {
                        moveRight();
//                        try {
//                            Thread.sleep(50);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//
//                    }
//                    break;
                case 2:
//                    for (int i = 0; i < 30; i++) {
                        moveDown();
//                        try {
//                            Thread.sleep(50);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//
//                    }
//                    break;
                case 3:
//                    for (int i = 0; i < 30; i++) {
                        moveLeft();
//                        try {
//                            Thread.sleep(50);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//
//                    }
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
