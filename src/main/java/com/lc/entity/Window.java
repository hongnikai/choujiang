/**
 * Project Name:javaui1
 * File Name:Window.java
 * Package Name:cn.java.game
 * Date:上午9:52:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 *
*/

package com.lc.entity;

import java.awt.Container;

import javax.servlet.ServletContext;
import javax.swing.*;

/**
 * Description: 程序启动窗口<br/>
 * Date: 上午9:52:09 <br/>
 * 
 * @author dingP
 * @version
 * @see
 */
@SuppressWarnings("all")
public class Window {

    public static void main(String[] args) {


        JFrame jFrame = new JFrame("坦克大战");
        jFrame.setBounds(300, 300, 600, 400);

        Container container = jFrame.getContentPane();
        GamePanel gamePanel = new GamePanel();
        container.add(gamePanel);
        jFrame.addKeyListener(gamePanel);
        Thread thread = new Thread(gamePanel);
        thread.start();

        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
