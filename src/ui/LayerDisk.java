package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerDisk extends Layer {
	
	private static Image IMG_DISK=new ImageIcon("graphics/string/disk.png").getImage();
	
	/**
	 * ����ͼ�߶�
	 */
	private static final int IMG_DB_H=IMG_DISK.getHeight(null);
	/**
	 * ֵ�۸߶�
	 */
	private static final int LINE_H = 28;
	/**
	 * ����
	 */
	private static final int MAX_ROW=5;
	/**
	 * ֵ�۱���ɫ
	 */
	private static final Color DEF_BGCOLOR = Color.GREEN;

	public LayerDisk(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(IMG_DISK, this.x+PADDING, this.y+PADDING, null);
		for(int i=0;i<MAX_ROW;i++){
			drawRect(this.x+PADDING*2,this.y+PADDING+IMG_DB_H+i*(LINE_H+12)+15,this.w-PADDING*4 ,"����", "300",DEF_BGCOLOR, 300,3000, g );
		}
	}

}
