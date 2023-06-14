package game;
/*
* 坦克大战炸弹的类
* 用于坦克爆炸时显示爆炸贴图
*
* */
public class Bomb {

    // 炸弹的坐标
    int x,y;
    // 炸弹的生命周期
    int life = 9;
    // 是否存活
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //减少生命值
    public void lifeDown(){
        if (life >0){
            life--;
        }else {
            isLive = false;
        }
    }
}
