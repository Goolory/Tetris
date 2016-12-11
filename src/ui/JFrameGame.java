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
		
		//��ȡ��Ϸ����
		GameConfig cfg =ConfigFactory.getGameConfig();
		//���ñ���
		this.setTitle(cfg.getTitle());
		
		//����Ĭ�ϵĹر����ԣ��������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���ô��ڴ�С
		this.setSize(cfg.getWidth(), cfg.getHeight());
		
		//���ò��ܸı䴰�ڴ�С
		this.setResizable(false);
		
		
		
		//����
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		
		
		int w=(screen.width-this.getWidth())>>1;
		int h=(screen.height-this.getHeight()-100)>>1;
		//���þ���
		this.setLocation(w,h);
		
		//����Ĭ��panel
		this.setContentPane(panelGame);
		
		new Bgm();
		//Ĭ�ϸĴ���Ϊ��ʾ
		this.setVisible(true);
		
	}

	

}
