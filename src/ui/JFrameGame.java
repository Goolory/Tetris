package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JFrameGame extends JFrame {
	public JFrameGame(){
		//设置标题
		this.setTitle("java俄罗斯方块");
		
		//设置默认的关闭属性，程序结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置窗口大小
		this.setSize(1200, 700);
		
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
		this.setContentPane(new JPanelGame());
		
	}

}
