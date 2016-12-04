package ui;

import java.awt.Color;
import java.awt.Font;
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
	/**
	 * ��ֵĬ������
	 */
	private static final Font DEF_FONT=new Font("����",Font.BOLD,20);
	
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
	
	/**
	 * @param x ��ֵ��ʾ�����Ͻ�x����
	 * @param y ��ֵ��ʾ�����Ͻ�y����
	 * @param w �ۿ�
	 * @param title ������ʾ����
	 * @param number ������ʾ������
	 * @param color ֵ�۱���ɫ
	 * @param value �۵�ֵ
	 * @param maxValue �����ֵ
	 * @param g ����
	 */
	public void drawRect(int x,int y,int w ,String title, String number,Color color, int value,int maxValue,Graphics g ){
		g.setColor(Color.BLACK);
		g.fillRect(x, y, w, 32);
		g.setColor(Color.WHITE);
		g.fillRect(x+1, y+1, w-2, 30);
		g.setColor(color);
		
		int vw = value*(w-2)/maxValue;
		g.fillRect(x+2, y+2, vw, 28);
		g.setColor(Color.BLACK);
		g.setFont(DEF_FONT);
		g.drawString(title,x+20,y+24);
		g.drawString(number,x+200,y+24);
		
	}
	
	
	
}
