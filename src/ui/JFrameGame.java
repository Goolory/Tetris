package ui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.swing.JFrame;

import config.ConfigFactory;
import config.GameConfig;

@SuppressWarnings("serial")
public class JFrameGame extends JFrame {
	public JFrameGame(JPanelGame panelGame){
		
		//获取游戏配置
		GameConfig cfg =ConfigFactory.getGameConfig();
		//设置标题
		this.setTitle(cfg.getTitle());
		
		//设置默认的关闭属性，程序结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置窗口大小
		this.setSize(cfg.getWidth(), cfg.getHeight());
		
		//设置不能改变窗口大小
		this.setResizable(false);
		
		
		
		//居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		
		
		int w=(screen.width-this.getWidth())>>1;
		int h=(screen.height-this.getHeight()-100)>>1;
		//设置居中
		this.setLocation(w,h);
		
		//设置默认panel
		this.setContentPane(panelGame);
		
		new Bgm();
		//默认改窗口为显示
		this.setVisible(true);
		
	}

	

}
