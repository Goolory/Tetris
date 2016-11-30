package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

//绘制窗口
public abstract class Lay {
	//内边距
	protected static final int PADDING=16;
	//背景图
	private static final int SIZE=7;
	
	private static  Image WINDOW_IMG = new ImageIcon("graphics/window/Window.png").getImage();
	
	private static  int WINDOW_H=WINDOW_IMG.getHeight(null);
	private static  int WINDOW_W=WINDOW_IMG.getWidth(null);
	//窗口左上角x坐标
	protected int x;
	//窗口左上角y坐标
	protected int y;
	//宽
	protected int w;
	//高
	protected int h;
	
	protected Lay(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	
	
	//创建窗口
	
	protected void createWindow(Graphics g){
		
		//左上
		g.drawImage(WINDOW_IMG, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
		//中上
		g.drawImage(WINDOW_IMG, x+SIZE, y, w+x-SIZE, y+SIZE, SIZE, 0, WINDOW_W-SIZE, SIZE, null);
		//右上
		g.drawImage(WINDOW_IMG, w-SIZE+x, y, w+x, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);
		//左中
		g.drawImage(WINDOW_IMG, x, y+SIZE,x+SIZE, y+h-SIZE,  0, SIZE, SIZE, WINDOW_H-SIZE, null);
		//左下
		g.drawImage(WINDOW_IMG, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);
		//右中
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W, WINDOW_H-SIZE, null);
		//右下
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W, WINDOW_H, null);
		//下中
		g.drawImage(WINDOW_IMG, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE, WINDOW_W-SIZE, WINDOW_H, null);
		//中
		g.drawImage(WINDOW_IMG, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_W-SIZE, WINDOW_H-SIZE, null);
		
	}
	//刷新游戏具体界面
	abstract public void paint(Graphics g);
}
