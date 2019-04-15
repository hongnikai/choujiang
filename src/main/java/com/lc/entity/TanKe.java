/**
 * Project Name:javaui1
 * File Name:TanKe.java
 * Package Name:cn.java.game
 * Date:上午9:49:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 *
*/

package com.lc.entity;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 定义坦克类<br/>
 * Date: 上午9:49:29 <br/>
 * 
 * @author dingP
 * @version
 * @see
 */
public class TanKe {
    public int x;// 坦克x坐标

    public int y;// 坦克y坐标

    public Image tanKePic;// 坦克素材图片

    public int width;// 坦克图片素材的宽度

    public int height;// 坦克图片素材的高度

    public String direct;// 坦克炮筒方向

    public List<ZiDan> ziDanList = null;// 用来装子弹的

    public TanKe() {
        super();
        ziDanList = new ArrayList<ZiDan>();
    }

    public TanKe(int x, int y, int width, int height, String direct, Image tanKePic) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.direct = direct;
        this.tanKePic = tanKePic;
        ziDanList = new ArrayList<ZiDan>();
    }

    /**
     * 
     * Description: 发射子弹<br/>
     * 刚开始发射的子弹与与炮筒方向有关
     * 
     * @author dingP
     */
    public void fire() {
        ZiDan ziDan = null;
        switch (direct) {
        case "top":
            ziDan = new ZiDan(this.x + 32, this.y, 5, 5, "top");
            ziDanList.add(ziDan);
            break;
        case "bottom":
            ziDan = new ZiDan(this.x + 32, this.y + 99, 5, 5, "bottom");
            ziDanList.add(ziDan);
            break;
        case "left":
            ziDan = new ZiDan(this.x, this.y + 35, 5, 5, "left");
            ziDanList.add(ziDan);
            break;
        case "right":
            ziDan = new ZiDan(this.x + 99, this.y + 36, 5, 5, "right");
            ziDanList.add(ziDan);
            break;
        }
        System.out.println("TanKe...............ziDanList=" + ziDanList.size());
        Thread thread = new Thread(ziDan);
        thread.start();
    }

    @Override
    public String toString() {
        return "TanKe [x=" + x + ", y=" + y + ", tanKePic=" + tanKePic + ", width=" + width + ", height=" + height
                + ", direct=" + direct + ", ziDanList=" + ziDanList + "]";
    }

}
