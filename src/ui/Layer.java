package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

//绘制窗口
public abstract class Layer {
	//内边距
	protected static final int PADDING;
	//背景图
	private static final int SIZE;
	
	static{
		//获取游戏配置
		GameConfig cfg =ConfigFactory.getGameConfig();
		PADDING=cfg.getPadding();
		SIZE=cfg.getWindowSize();
	}
	
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
//	游戏数据
	protected GameDto dto=null;
	
	protected Layer(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	
	/**
	 * 数字图片260* 36
	 */
	private static Image IMG_NUMBER=new ImageIcon("graphics/string/num.png").getImage();
	
	/**
	 * 数字切片宽度
	 */
	private static final int IMG_NUMBER_W = IMG_NUMBER.getWidth(null)/10; 
	/**
	 * 数字切片高度
	 */
	private static final int IMG_NUMBER_H = IMG_NUMBER.getHeight(null); 
	
	
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


	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	
	/**
	 * @param x 左上角x坐标
	 * @param y 左上角y坐标
	 * @param num 要显示的数字
	 * @param g 画笔对象
	 */
	public void drowNumber(int x,int y,int num,Graphics g){
		
		String strNum = Integer.toString(num);
		for(int i=0;i<strNum.length();i++){
			int bit = strNum.charAt(i)-'0';
			g.drawImage(IMG_NUMBER, 
					this.x+x+i*IMG_NUMBER_W, this.y+y, this.x+x+(i+1)*IMG_NUMBER_W-2, this.y+y+IMG_NUMBER_H,
					bit*IMG_NUMBER_W, 0, (bit+1)*IMG_NUMBER_W, IMG_NUMBER_H, null);
		}
		
		
	}
	
	
	
}
