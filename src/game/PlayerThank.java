package game;

import java.util.Vector;

/**
 * 自己的坦克
 */
public class PlayerThank extends Tk {
    // 定义一个SHot对象，用于发射子弹,表示一个射击线程
    Shot shot = null;
    //发射多颗子弹
    Vector<Shot> shots = new Vector<>();
    public PlayerThank(int x, int y) {
        super(x, y);
    }
    /**
     * 射击
     */
    public void ShotPlayerTank(){
        //让他只发射五颗子弹
        if (shots.size() == 5){
            return;
        }
        // 创建Shot对象，根据当前坦克ziji对象的位置和方向来创建Shot
        switch (getDirect()){
            // 向上
            case 0:
                // 这个二十是坦克轮子到炮筒的位置
                shot = new Shot(getX()+20,getY(),0);
                break;
                case 1:
                // 向右
                shot = new Shot(getX()+20,getY()+20,1);
                break;
                 case 2:
                // 向下
                shot = new Shot(getX()+20,getY()+60,2);
                break;
                 case 3:
                // 向下
                shot = new Shot(getX(),getY()+60,3);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + getDirect());
        }
        //把新创建的shot放入到集合中
        shots.add(shot);
        // 启动Shot线程
        new Thread(shot).start();
    }
}
