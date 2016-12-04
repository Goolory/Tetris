package ui;

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
	
	private static final int IMG_RMLIKE_H=IMG_RMLIKE.getHeight(null);

	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g){
		this.createWindow(g);
		//窗口标题(分数)
		g.drawImage(IMG_POINT, this.x+32, this.y+32, null);
		drowNumber(128,32,0, g);
		//窗口标题（消行）
		g.drawImage(IMG_RMLIKE, this.x+32, this.y+IMG_RMLIKE_H*3, null);
		drowNumber(128,IMG_RMLIKE_H*3,0, g);
	}

}
