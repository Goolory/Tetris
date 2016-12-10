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

	private JButton btnOk =new JButton("ȷ��");
	
	private JButton btnCancel =new JButton("ȡ��");
	
	private GameControl gameControl;
	
	private GameDto dto;
	
	private int nowLevel=0;
	
	public JFrameSet(GameControl gameControl,GameDto dto){
//		�����Ϸ����
		this.gameControl=gameControl;
		
		this.dto=dto;
		
		
		this.setTitle("����");
		
		this.setSize(400,150);
		
		//���ñ߽粼��
		this.setLayout(new BorderLayout());
//		����title
		this.add(this.createTitlePanel(),BorderLayout.NORTH );
		
		this.add(createMainPanel(),BorderLayout.CENTER );
//		��Ӱ�ť��
		this.add(this.createButtonPanel(),BorderLayout.SOUTH);
		
		
		//���ò��ܸı䴰�ڴ�С
		this.setResizable(false);
				
				
				
		//����
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
				
				
		int w=(screen.width-this.getWidth())>>1;
		int h=(screen.height-this.getHeight()-100)>>1;
		//���þ���
		this.setLocation(w,h);
		
		
		
	}
	
	/**
	 * @return ����title
	 */
	private JPanel createTitlePanel() {
		JPanel jp =new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel jl=new JLabel("���õ�ǰ�ȼ�Ϊ��");
		jl.setSize(200, 40);
		jp.add(jl);
		System.out.println(Integer.toString(nowLevel));
		return jp;
	}

	/**
	 * @return���������
	 */
	private JPanel createMainPanel() {
		JPanel jp =new JPanel();
		JLabel jl=new JLabel("��ǰ�ȼ�:");
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
	 * @return c������ť���
	 */
	private JPanel createButtonPanel() {
		//��ʽ����
		JPanel jp =new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		��ťȷ���¼�����
		
		this.btnOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				dto.setNowlevel(nowLevel);
				setVisible(false);
				gameControl.setOver();
				
				
			}
			
		});
//		��ťȡ������
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
