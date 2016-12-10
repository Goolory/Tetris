package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.GameControl;
import dto.GameDto;

public class JFrameSet extends JFrame {

	private JButton btnOk =new JButton("确定");
	
	private JButton btnCancel =new JButton("取消");
	
	private GameControl gameControl;
	
	private GameDto dto;
	
	private int nowLevel=0;
	
	public JFrameSet(GameControl gameControl,GameDto dto){
//		获得游戏对象
		this.gameControl=gameControl;
		
		this.dto=dto;
		
		
		this.setTitle("设置");
		
		this.setSize(400,150);
		
		//设置边界布局
		this.setLayout(new BorderLayout());
//		创建title
		this.add(this.createTitlePanel(),BorderLayout.NORTH );
		
		this.add(createMainPanel(),BorderLayout.CENTER );
//		添加按钮面
		this.add(this.createButtonPanel(),BorderLayout.SOUTH);
		
		
		//设置不能改变窗口大小
		this.setResizable(false);
				
				
				
		//居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
				
				
		int w=(screen.width-this.getWidth())>>1;
		int h=(screen.height-this.getHeight()-100)>>1;
		//设置居中
		this.setLocation(w,h);
		
		
		
	}
	
	/**
	 * @return 创建title
	 */
	private JPanel createTitlePanel() {
		JPanel jp =new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jl=new JLabel("设置当前等级为：");
		jl.setSize(200, 40);
		jp.add(jl);
		System.out.println(Integer.toString(nowLevel));
		return jp;
	}

	/**
	 * @return创建主面板
	 */
	private JPanel createMainPanel() {
		JPanel jp =new JPanel();
		JLabel jl=new JLabel("当前等级:");
		JSlider js=new JSlider(0,9);
		
		JTextField text= new JTextField(5);
		text.setEditable(false);
		jp.add(jl);
		jp.add(js);
		jp.add(text);
		js.setValue(dto.getNowlevel());
		text.setText(Integer.toString(nowLevel));
		js.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				text.setText(Integer.toString(js.getValue()));
				nowLevel=(int) js.getValue();
			}
			
		});
		
		return jp;
	}

	/**
	 * @return c创建按钮面板
	 */
	private JPanel createButtonPanel() {
		//流式布局
		JPanel jp =new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		按钮确定事件监听
		
		this.btnOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				dto.setNowlevel(nowLevel);
				setVisible(false);
				gameControl.setOver();
				
				
			}
			
		});
//		按钮取消监听
		this.btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				gameControl.setOver();
			}
			
		});
		jp.add(this.btnOk);
		jp.add(this.btnCancel);
		return jp;
	}
}
