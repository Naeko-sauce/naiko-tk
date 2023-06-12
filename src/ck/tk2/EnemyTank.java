package ck.tk2;

import java.util.Vector;

//敌人的坦克
public class EnemyTank extends tk{
    //在敌人坦克类，使用Vector保存多个Shot，不用私有是因为懒得创建get和set
    Vector<Shot> shots = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
