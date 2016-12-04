package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {
	
	/**
	 * 窗口标题(分数)
	 */
	private static final Image IMG_POINT =new ImageIcon("graphics/string/point.png").getImage();
	
	/**窗口标题（消行）
	 * 
	 */
	private static final Image IMG_RMLIKE =new ImageIcon("graphics/string/rmline.png").getImage();
	/**
	 * 显示分数y轴偏移量
	 */
	private final int pointY;
	/**
	 * 消行y坐标
	 */
	private final int rmLineY;
	
	/**
	 * x轴偏移量
	 */
	private final int ComX;
	
	/**
	 * 经验值y轴偏移量
	 */
	private final int expY;
	
	/**
	 * 经验值槽宽度
	 */
	private final int expW;
	
	/**
	 * 消20行进入下一级
	 */
	private static final int  LEVEL_UP=20; 
	
	private static final int IMG_RMLIKE_H=IMG_RMLIKE.getHeight(null);
	
	

	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		//初始化ComX
		this.ComX=this.x+32;
		//初始化分数显示y坐标
		this.pointY=this.y+32;
		//初始化消行显示y坐标
		this.rmLineY=this.pointY+IMG_RMLIKE.getHeight(null)+32;
		//初始化经验值显示y坐标
		this.expY=this.rmLineY+IMG_RMLIKE.getHeight(null)+32;
		//经验值槽宽度
		this.expW=this.w-64;
	}
	public void paint(Graphics g){
		this.createWindow(g);
		//窗口标题(分数)
		g.drawImage(IMG_POINT, this.x+32, this.y+32, null);
		this.drowNumber(128,32,this.dto.getNowPoint(), g);
		//窗口标题（消行）
		g.drawImage(IMG_RMLIKE, this.x+32, this.y+IMG_RMLIKE_H*3, null);
		this.drowNumber(128,IMG_RMLIKE_H*3,this.dto.getNowRemoveLine(), g);
		//画值槽框
		drawRect(this.ComX,this.expY, this.expW,"下一级",Integer.toString(this.dto.getNowRemoveLine()%LEVEL_UP),Color.RED,this.dto.getNowRemoveLine()%LEVEL_UP,LEVEL_UP, g);
	}
}
