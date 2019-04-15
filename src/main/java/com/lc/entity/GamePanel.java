package com.lc.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JPanel;
/**
 * @描述： 坦克大战小游戏
 *
 *  @discription ：
 * @param
 * @return
 */
public class GamePanel extends JPanel implements Runnable,KeyListener{

    private TanKe tanKe = null;

//    F:\workplace\choujiang\src\main\webapp\resource\tankeimg\images\heart.png
//    F:\workplace\choujiang\src\main\java\com\lc\entity\GamePanel.java
    public GamePanel() {
        Image tanKeTop = Toolkit.getDefaultToolkit().getImage("conf/images/tanKe1.png");
        tanKe = new TanKe(20, 20, 66, 99, "top", tanKeTop);
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.repaint();
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        // 1、在面板上画飞机
        g.drawImage(tanKe.tanKePic, tanKe.x, tanKe.y, this);
        // 2、在面板上画子弹
        List<ZiDan> ziDanList = tanKe.ziDanList;
        if (ziDanList != null) {
            for (ZiDan ziDan : ziDanList) {
                g.drawImage(Toolkit.getDefaultToolkit().getImage("resource/tankeimg/images/zidan.png"), ziDan.x, ziDan.y, ziDan.width,
                        ziDan.height, this);
            }
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println("keyCode=" + keyCode);
        if (keyCode == KeyEvent.VK_UP) {// 上方向键
            tanKe.tanKePic = Toolkit.getDefaultToolkit().getImage("resource/tankeimg/images/tanKe1.png");
            tanKe.y -= 5;
            tanKe.width = 66;
            tanKe.height = 99;
            tanKe.direct = "top";
            System.out.println("上");
        } else if (keyCode == KeyEvent.VK_DOWN) {// 下方向键
            tanKe.tanKePic = Toolkit.getDefaultToolkit().getImage("resource/tankeimg/images/tanKe2.png");
            tanKe.y += 5;
            tanKe.width = 66;
            tanKe.height = 99;
            tanKe.direct = "bottom";
            System.out.println("下");
        } else if (keyCode == KeyEvent.VK_LEFT) {// 左方向键
            tanKe.tanKePic = Toolkit.getDefaultToolkit().getImage("resource/tankeimg/images/tanKe3.png");
            tanKe.width = 99;
            tanKe.height = 72;
            tanKe.x -= 5;
            tanKe.direct = "left";
            System.out.println("左");
        } else if (keyCode == KeyEvent.VK_RIGHT) {// 右方向键
            tanKe.tanKePic = Toolkit.getDefaultToolkit().getImage("resource/tankeimg/images/tanKe4.png");
            tanKe.x += 5;

            tanKe.width = 99;
            tanKe.height = 72;
            tanKe.direct = "right";
            System.out.println("右");
        } else if (keyCode == 32) {// 空格为发射子弹
            tanKe.fire();// 开火
            System.out.println("您按下的是空格");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
