package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

//���ƴ���
public abstract class Lay {
	//�ڱ߾�
	protected static final int PADDING=16;
	//����ͼ
	private static final int SIZE=7;
	
	private static  Image WINDOW_IMG = new ImageIcon("graphics/window/Window.png").getImage();
	
	private static  int WINDOW_H=WINDOW_IMG.getHeight(null);
	private static  int WINDOW_W=WINDOW_IMG.getWidth(null);
	//�������Ͻ�x����
	protected int x;
	//�������Ͻ�y����
	protected int y;
	//��
	protected int w;
	//��
	protected int h;
	
	protected Lay(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	
	
	//��������
	
	protected void createWindow(Graphics g){
		
		//����
		g.drawImage(WINDOW_IMG, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
		//����
		g.drawImage(WINDOW_IMG, x+SIZE, y, w+x-SIZE, y+SIZE, SIZE, 0, WINDOW_W-SIZE, SIZE, null);
		//����
		g.drawImage(WINDOW_IMG, w-SIZE+x, y, w+x, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);
		//����
		g.drawImage(WINDOW_IMG, x, y+SIZE,x+SIZE, y+h-SIZE,  0, SIZE, SIZE, WINDOW_H-SIZE, null);
		//����
		g.drawImage(WINDOW_IMG, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);
		//����
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W, WINDOW_H-SIZE, null);
		//����
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W, WINDOW_H, null);
		//����
		g.drawImage(WINDOW_IMG, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE, WINDOW_W-SIZE, WINDOW_H, null);
		//��
		g.drawImage(WINDOW_IMG, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_W-SIZE, WINDOW_H-SIZE, null);
		
	}
	//ˢ����Ϸ�������
	abstract public void paint(Graphics g);
}
