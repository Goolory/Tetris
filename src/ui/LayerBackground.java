package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class LayerBackground extends Layer {
	//TODO ¡Ÿ ±±≥æ∞
	private static Image IMG_BG=new ImageIcon("graphics/background/Sea.jpg").getImage();
	
	private static List<Image> BG_LIST;
	
	static {
		File dir = new File("graphics/background");
		File[] files=dir.listFiles();
		BG_LIST=new ArrayList<Image>();
		for(File file:files){
			if(!file.isDirectory()){
				BG_LIST.add(new ImageIcon(file.getPath()).getImage());
			}
		}
	}

	public LayerBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(BG_LIST.get(this.dto.getNowlevel()%BG_LIST.size()), 0, 0,1200,700, null);
		

	}

}
