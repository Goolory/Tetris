package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {
	
	/**
	 * ���ڱ���(����)
	 */
	private static final Image IMG_POINT =new ImageIcon("graphics/string/point.png").getImage();
	
	/**���ڱ��⣨���У�
	 * 
	 */
	private static final Image IMG_RMLIKE =new ImageIcon("graphics/string/rmline.png").getImage();
	/**
	 * ��ʾ����y��ƫ����
	 */
	private final int pointY;
	/**
	 * ����y����
	 */
	private final int rmLineY;
	
	/**
	 * x��ƫ����
	 */
	private final int ComX;
	
	/**
	 * ����ֵy��ƫ����
	 */
	private final int expY;
	
	/**
	 * ����ֵ�ۿ��
	 */
	private final int expW;
	
	/**
	 * ��20�н�����һ��
	 */
	private static final int  LEVEL_UP=20; 
	
	private static final int IMG_RMLIKE_H=IMG_RMLIKE.getHeight(null);
	
	

	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		//��ʼ��ComX
		this.ComX=this.x+32;
		//��ʼ��������ʾy����
		this.pointY=this.y+32;
		//��ʼ��������ʾy����
		this.rmLineY=this.pointY+IMG_RMLIKE.getHeight(null)+32;
		//��ʼ������ֵ��ʾy����
		this.expY=this.rmLineY+IMG_RMLIKE.getHeight(null)+32;
		//����ֵ�ۿ��
		this.expW=this.w-64;
	}
	public void paint(Graphics g){
		this.createWindow(g);
		//���ڱ���(����)
		g.drawImage(IMG_POINT, this.x+32, this.y+32, null);
		this.drowNumber(128,32,this.dto.getNowPoint(), g);
		//���ڱ��⣨���У�
		g.drawImage(IMG_RMLIKE, this.x+32, this.y+IMG_RMLIKE_H*3, null);
		this.drowNumber(128,IMG_RMLIKE_H*3,this.dto.getNowRemoveLine(), g);
		//��ֵ�ۿ�
		drawRect(this.ComX,this.expY, this.expW,"��һ��",Integer.toString(this.dto.getNowRemoveLine()%LEVEL_UP),Color.RED,this.dto.getNowRemoveLine()%LEVEL_UP,LEVEL_UP, g);
	}
}
