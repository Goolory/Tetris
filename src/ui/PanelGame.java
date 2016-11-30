package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelGame extends JPanel{
	
	private Lay[] lays=null;
	public PanelGame(){
		lays=new Lay[]{
				new LayDataBase(40,32,334,279),
				new LayDisk(40,343,334,279),
				new LayGame(414,32,334,590),
				new LayButton(788,32,334,124),
				new LayNext(788,188,176,148),
				new LayLevel(964,188,158,148),
				new LayPoint(788,368,334,250),
		};
		
	}
	
	
	@Override
	//���Ǹ��෽��
	public void paintComponent(Graphics g){
		//ѭ��ˢ����Ϸ���� 
		for(int i=0;i<lays.length;i++){
			
			//ˢ�²㴰��
			lays[i].paint(g);
		}
	}

}
