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
		//���ò��ֹ�����Ϊ���ɲ���
		this.setLayout(null);
		//��ʼ����
		initLayer();
//		��ʼ�����
		initComponent();
		
	}
	


	/**
	 * @param control
	 * 
	 * ��װ��ҿ�����
	 */
	public void setGameControl(PlayerControl control){
		this.addKeyListener(control);
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent(){
		
		this.btnStart=new JButton(IMG_BTN_STATRT);
		btnStart.setBounds(828, 76, 105, 40);
		
		this.add(btnStart);
		this.btnControl=new JButton(IMG_BTN_CONTROL);
		btnControl.setBounds(968, 76, 105, 40);
		this.add(btnControl);
		//Ϊ���ð�ť����¼�����
		this.btnControl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				gameControl.showSetControl();
				
			}
		});
		//Ϊ��ʼ��ť����¼�����
		this.btnStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				gameControl.start();
			}
			
		});
	}
	
	/**
	 * ���ʼ��
	 */
	private void initLayer(){
		try {
			//��ȡ��Ϸ����
			GameConfig cfg =ConfigFactory.getGameConfig();
//			��ȡ��������
			List<LayerConfig> layersCfg=cfg.getLayersConfig();
//			������Ϸ������
			layers=new ArrayList<Layer>(layersCfg.size());
//			�������в����
			for(LayerConfig layerCfg:layersCfg){
				//��������
				Class<?> cls = Class.forName(layerCfg.getClassName());
				//��ù��캯��
				Constructor<?> ctr=cls.getConstructor(int.class,int.class,int.class,int.class);
				//�������ù��캯����������
				Layer layer=(Layer)ctr.newInstance(
						layerCfg.getX(),layerCfg.getY(),layerCfg.getW(),layerCfg.getH()
						);
				
				
//				������Ϸ���ݶ���
				layer.setDto(this.dto);
				
				
				//�Ѵ�����layer������뼯��
				layers.add(layer);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/* (non-Javadoc)
	 * 
	 * ���Ǹ��෽��
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g){
		//���û��෽��
		super.paintComponent(g);
		//ѭ��ˢ����Ϸ���� 
		for(int i=0;i<layers.size();layers.get(i++).paint(g));
		//���ؽ���
		this.requestFocus();
	}



	public void setGameControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}
	

}
