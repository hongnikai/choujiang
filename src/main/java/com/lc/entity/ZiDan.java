/**
 * Project Name:javaui1
 * File Name:ZiDan.java
 * Package Name:cn.java.game
 * Date:上午9:51:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 *
*/

package com.lc.entity;

/**
 * Description: 子弹<br/>
 * Date: 上午9:51:16 <br/>
 * 
 * @author dingP
 * @version
 * @see
 */
public class ZiDan implements Runnable {

    public int x;// 子弹x坐标

    public int y;// 子弹Y坐标

    public int width;// 子弹图片素材宽度

    public int height;// 子弹图片素材高度

    public String direct;// 子弹射击的方向

    public ZiDan() {
        super();
    }

    public ZiDan(int x, int y, int width, int height, String direct) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.direct = direct;
    }

    @Override
    public void run() {
        try {
            while (true) {
                switch (direct) {
                case "top":
                    this.y -= 5;
                    break;
                case "bottom":
                    this.y += 5;
                    break;
                case "left":
                    this.x -= 5;
                    break;
                case "right":
                    this.x += 5;
                    break;
                }
                Thread.sleep(50);
                // 如果子弹超出边界则线程结束
                if (this.x == 0 || this.y == 0 || this.x >= 700 || this.y >= 500) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ZiDan [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", direct=" + direct + "]";
    }

}
