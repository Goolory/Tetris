package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

//���ƴ���
public abstract class Layer {
	//�ڱ߾�
	protected static final int PADDING;
	//����ͼ
	private static final int SIZE;
	
	static{
		//��ȡ��Ϸ����
		GameConfig cfg =ConfigFactory.getGameConfig();
		PADDING=cfg.getPadding();
		SIZE=cfg.getWindowSize();
	}
	
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
//	��Ϸ����
	protected GameDto dto=null;
	
	protected Layer(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	
	/**
	 * ����ͼƬ260* 36
	 */
	private static Image IMG_NUMBER=new ImageIcon("graphics/string/num.png").getImage();
	
	/**
	 * ������Ƭ���
	 */
	private static final int IMG_NUMBER_W = IMG_NUMBER.getWidth(null)/10; 
	/**
	 * ������Ƭ�߶�
	 */
	private static final int IMG_NUMBER_H = IMG_NUMBER.getHeight(null); 
	
	
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


	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	
	/**
	 * @param x ���Ͻ�x����
	 * @param y ���Ͻ�y����
	 * @param num Ҫ��ʾ������
	 * @param g ���ʶ���
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
