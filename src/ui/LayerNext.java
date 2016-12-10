package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerNext extends Layer {
	
	private static final Image[] NEXT_ACT;
	
	static{
		NEXT_ACT = new Image[7];
		for(int i = 0;i < NEXT_ACT.length;i++){
			NEXT_ACT[i] = new ImageIcon("graphics/game/"+i+".png").getImage();
		}
	}

	public LayerNext(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g){
		this.createWindow(g);
		if(this.dto.isStart()){
			drawImageOfCenter(NEXT_ACT[this.dto.getNext()], g);
		}
		
		
	}
	
	/**
	 * Í¼ÐÎ¾ÓÖÐ
	 */
	private void drawImageOfCenter(Image img,Graphics g){
		int imgW=img.getWidth(null);
		int imgH=img.getHeight(null);
		
		g.drawImage(img, this.x+(this.w-imgW>>1), this.y+(this.h-imgH>>1), null);
	}

}
