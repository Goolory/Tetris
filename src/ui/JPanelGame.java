package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;

public class JPanelGame extends JPanel{
	
	private List<Layer> layers=null;
	
	
	public JPanelGame(){
		
		try {
			//获取游戏配置
			GameConfig cfg =ConfigFactory.getGameConfig();
//			获取窗口配置
			List<LayerConfig> layersCfg=cfg.getLayersConfig();
//			创建游戏层数组
			layers=new ArrayList<Layer>(layersCfg.size());
//			创建所有层对象
			for(LayerConfig layerCfg:layersCfg){
				//获得类对象
				Class<?> cls = Class.forName(layerCfg.getClassName());
				//获得构造函数
				Constructor<?> ctr=cls.getConstructor(int.class,int.class,int.class,int.class);
				//创建调用构造函数创建对象
				Layer l=(Layer)ctr.newInstance(
						layerCfg.getX(),layerCfg.getY(),layerCfg.getW(),layerCfg.getH()
						);
				//把创建的layer对象放入集合
				layers.add(l);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		lays=new Layer[]{
//				new LayerBackground(0,0,0,0),
//				new LayerDataBase(40,32,334,279),
//				new LayerDisk(40,343,334,279),
//				new LayerGame(414,32,334,590),
//				new LayerButton(788,32,334,124),
//				new LayerNext(788,188,176,148),
//				new LayerLevel(964,188,158,148),
//				new LayerPoint(788,368,334,250),
//		};
		
	}
	
	
	@Override
	//覆盖父类方法
	public void paintComponent(Graphics g){
		//循环刷新游戏窗口 
		for(int i=0;i<layers.size();i++){
			
			//刷新层窗口
			layers.get(i).paint(g);
		}
	}

}
