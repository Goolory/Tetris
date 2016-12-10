package ui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;
import control.GameControl;
import control.PlayerControl;
import dto.GameDto;

public class JPanelGame extends JPanel{
	
	private List<Layer> layers=null;
	private static  ImageIcon IMG_BTN_STATRT = new ImageIcon("graphics/string/strat.png");
	private static  ImageIcon IMG_BTN_CONTROL = new ImageIcon("graphics/string/config.png");
	private JButton btnStart;
	
	private JButton btnControl;
	
	private GameDto dto=null;
	
	private GameControl gameControl=null;
	
	public JPanelGame(GameDto dto){
		
		this.dto=dto;
		//设置布局管理器为自由布局
		this.setLayout(null);
		//初始化层
		initLayer();
//		初始化组件
		initComponent();
		
	}
	


	/**
	 * @param control
	 * 
	 * 安装玩家控制器
	 */
	public void setGameControl(PlayerControl control){
		this.addKeyListener(control);
	}
	/**
	 * 初始化组件
	 */
	private void initComponent(){
		
		this.btnStart=new JButton(IMG_BTN_STATRT);
		btnStart.setBounds(828, 76, 105, 40);
		
		this.add(btnStart);
		this.btnControl=new JButton(IMG_BTN_CONTROL);
		btnControl.setBounds(968, 76, 105, 40);
		this.add(btnControl);
		//为设置按钮添加事件监听
		this.btnControl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				gameControl.showSetControl();
				
			}
		});
		//为开始按钮添加事件监听
		this.btnStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				gameControl.start();
			}
			
		});
	}
	
	/**
	 * 层初始化
	 */
	private void initLayer(){
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
				Layer layer=(Layer)ctr.newInstance(
						layerCfg.getX(),layerCfg.getY(),layerCfg.getW(),layerCfg.getH()
						);
				
				
//				设置游戏数据对象
				layer.setDto(this.dto);
				
				
				//把创建的layer对象放入集合
				layers.add(layer);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/* (non-Javadoc)
	 * 
	 * 覆盖父类方法
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g){
		//调用基类方法
		super.paintComponent(g);
		//循环刷新游戏窗口 
		for(int i=0;i<layers.size();layers.get(i++).paint(g));
		//返回焦点
		this.requestFocus();
	}



	public void setGameControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}
	

}
