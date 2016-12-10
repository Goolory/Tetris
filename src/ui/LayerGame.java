package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class LayerGame extends Layer {
	
	private static final Image ACT = new ImageIcon("graphics/game/rect.png").getImage();
	
	private static final Image PAUSE = new ImageIcon("graphics/string/pause.png").getImage();
	
	private static final int ACT_SIZE=32;

	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		
		if(this.dto.getGameAct()!=null){
			Point[] points = this.dto.getGameAct().getActPoints();
//			获得方块类型编号(0-6)
			int typeCode = this.dto.getGameAct().getTypeCode();
			
			//打印方块
			for(int i=0;i<points.length;i++){
				drawActByPoint(points[i].x,points[i].y,typeCode+1, g);
			}
		}
			//打印地图
			boolean[][] map =this.dto.getGameMap();
			for(int x = 0;x < map.length;x++){
				for(int y = 0; y < map[x].length; y++){
					if(map[x][y]){
						drawActByPoint(x,y,dto.getNowlevel()%7, g);
					}
				}
			}
//			暂停
			if(this.dto.isPause()){
				g.drawImage(PAUSE, 430, 250, null);
			}
		
	}
	
	private void drawActByPoint(int x,int y,int imgIdx, Graphics g){
		g.drawImage(ACT, 
				this.x+x*ACT_SIZE+7, 
				this.y+y*ACT_SIZE+7, 
				this.x+x*ACT_SIZE+ACT_SIZE+7, 
				this.y+y*ACT_SIZE+ACT_SIZE+7, 
				imgIdx*ACT_SIZE, 0, (imgIdx+1)*ACT_SIZE, ACT_SIZE, null);
	}

}
