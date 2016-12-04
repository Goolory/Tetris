package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import dto.Player;

public class LayerDataBase extends Layer{
	/**
	 * 窗口title
	 */
	private static Image IMG_DB=new ImageIcon("graphics/string/db.png").getImage();
	/**
	 * 背景图高度
	 */
	private static final int IMG_DB_H=IMG_DB.getHeight(null);
	/**
	 * 值槽高度
	 */
	private static final int LINE_H = 28;
	/**
	 * 行数
	 */
	private static final int MAX_ROW=5;
	/**
	 * 值槽背景色
	 */
	private static final Color DEF_BGCOLOR = Color.YELLOW;

	public LayerDataBase(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(IMG_DB, this.x+PADDING, this.y+PADDING, null);
		List<Player> players=this.dto.getDbRecode();
		for(int i=0;i<MAX_ROW;i++){
			Player p = players.get(i);
			drawRect(this.x+PADDING*2,this.y+PADDING+IMG_DB_H+i*(LINE_H+12)+15,this.w-PADDING*4 ,p.getName(), Integer.toString(p.getPoint()),DEF_BGCOLOR, p.getPoint(),3000, g );
		}
	}

}
