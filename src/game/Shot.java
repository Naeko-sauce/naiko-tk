package game;

/**
 * 子弹射击
 */
public class Shot implements Runnable {
    int x;                  // 子弹x坐标
    int y;                  // 子弹的y坐标
    int direct = 0;         // 子弹的方向
    int speed = 2;          // 子弹的速度
    boolean isLive = true;  // 子弹是否还存活

    //构造器

    /**
     * 子弹的速度用get方法控制
     *
     * @param x
     * @param y
     * @param direct
     */
    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    /**
     * 射击行为，不断调整子弹的坐标
     */
    @Override
    public void run() {

        while (true) {

            //让子弹休眠一下/线程休眠
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direct) {
                case 0:  //向上，子弹减去速度
                    y -= speed;
                    break;
                case 1:  //向右，子弹加速度
                    x += speed;
                    break;
                case 2:  //向下，子弹加速度
                    y += speed;
                    break;
                case 3: //向左，子弹加速度
                    x -= speed;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + direct);
            }
            // 测试
            System.out.println("x" + x + "y" + y);
            // 当子弹移动到面板边界时，就应该自动销毁(把启动子弹的线程销毁)
            // 当子弹碰到敌人坦克时也应该退出
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                isLive = false;
                break;
            }
        }
    }
}
