package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.GameControl;
import dto.GameDto;

public class JFrameLose extends JFrame{
	
	private JButton btnOk =new JButton("确定");
	
	private JTextField text=new JTextField(5);
	
	private JLabel errMsg=null;
	
	private GameDto dto;
	
	private GameControl gameControl=null;
	
	public JFrameLose(GameDto dto,GameControl gameControl){
		this.dto=dto;
		this.gameControl=gameControl;
		this.setTitle("保存记录");
		this.setSize(256,128);
		
		//设置不能改变窗口大小
		this.setResizable(false);
		
		//设置边界布局
		this.setLayout(new BorderLayout());
//		创建title
		this.add(this.createTitlePanel(),BorderLayout.NORTH );
		//创建中部输入框
		this.add(this.createMainPanel(),BorderLayout.CENTER );
//		添加按钮面
		this.add(this.createButtonPanel(),BorderLayout.SOUTH);
						
						
						
		//居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
						
						
		int w=(screen.width-this.getWidth())>>1;
		int h=(screen.height-this.getHeight()-100)>>1;
		//设置居中
		this.setLocation(w,h);
		
//		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}
	private JPanel createTitlePanel() {
		JPanel jp =new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jl=new JLabel("游戏结束，当前分数:"+this.dto.getNowPoint());
		this.errMsg=new JLabel();
		this.errMsg.setForeground(Color.RED);
		jp.add(jl);
		jp.add(this.errMsg);
		return jp;
	}
	private JPanel createMainPanel() {
		JPanel jp =new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel jl=new JLabel("请输入名字：");
		
		jp.add(jl);
		jp.add(text);
		return jp;
	}
	private JPanel createButtonPanel() {
		JPanel jp =new JPanel();
		jp.add(btnOk);
		this.btnOk.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				String name=text.getText();
				if(name.length()>16||name.length()<=0){
					errMsg.setText("请输入12个字符以内");
				}else{
					gameControl.savePoint(name);
					setVisible(false);
					
				}
				
			}
			
		});
		return jp;
	}
	
	

}
