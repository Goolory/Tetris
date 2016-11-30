package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JFrameGame extends JFrame {
	public JFrameGame(){
		//���ñ���
		this.setTitle("java����˹����");
		
		//����Ĭ�ϵĹر����ԣ��������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���ô��ڴ�С
		this.setSize(1200, 700);
		
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
		this.setContentPane(new JPanelGame());
		
	}

}
