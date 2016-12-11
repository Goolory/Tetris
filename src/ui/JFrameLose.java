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
	
	private JButton btnOk =new JButton("ȷ��");
	
	private JTextField text=new JTextField(5);
	
	private JLabel errMsg=null;
	
	private GameDto dto;
	
	private GameControl gameControl=null;
	
	public JFrameLose(GameDto dto,GameControl gameControl){
		this.dto=dto;
		this.gameControl=gameControl;
		this.setTitle("�����¼");
		this.setSize(256,128);
		
		//���ò��ܸı䴰�ڴ�С
		this.setResizable(false);
		
		//���ñ߽粼��
		this.setLayout(new BorderLayout());
//		����title
		this.add(this.createTitlePanel(),BorderLayout.NORTH );
		//�����в������
		this.add(this.createMainPanel(),BorderLayout.CENTER );
//		��Ӱ�ť��
		this.add(this.createButtonPanel(),BorderLayout.SOUTH);
						
						
						
		//����
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
						
						
		int w=(screen.width-this.getWidth())>>1;
		int h=(screen.height-this.getHeight()-100)>>1;
		//���þ���
		this.setLocation(w,h);
		
//		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}
	private JPanel createTitlePanel() {
		JPanel jp =new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jl=new JLabel("��Ϸ��������ǰ����:"+this.dto.getNowPoint());
		this.errMsg=new JLabel();
		this.errMsg.setForeground(Color.RED);
		jp.add(jl);
		jp.add(this.errMsg);
		return jp;
	}
	private JPanel createMainPanel() {
		JPanel jp =new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel jl=new JLabel("���������֣�");
		
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
					errMsg.setText("������12���ַ�����");
				}else{
					gameControl.savePoint(name);
					setVisible(false);
					
				}
				
			}
			
		});
		return jp;
	}
	
	

}
