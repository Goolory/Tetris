package control;

import dao.Data;
import dao.DataBase;
import dao.DataDisk;
import dao.DataTest;
import dto.GameDto;
import service.GameService;
import ui.JFrameSet;
import ui.JPanelGame;

/**������Ҽ����¼�
 * ���ƻ���
 * ������Ϸ�߼�
 * @author lenovo
 *
 */
public class GameControl {
	
	/**
	 * ���ݷ��ʽӿ�A
	 */
	private Data dataA;
	/**
	 * ���ݷ��ʽӿ�B
	 */
	private Data dataB;
	/**
	 * ��Ϸ�����
	 */
	private JPanelGame panelGame;
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;
	
	
	private JFrameSet frameSet;
	
	public GameControl(JPanelGame panelGame,GameService gameService){
		this.panelGame=panelGame;
		this.gameService=gameService;
		
//		�����ݽӿ�A��ȡ����
		dataA = new DataBase();
		//��������������
		this.gameService.setDbRecode(dataA.loadData());
//		�����ݽӿ�B��ȡ����
		dataB = new DataDisk();
		//��������������
		this.gameService.setDiskRecode(dataB.loadData());
		
		this.frameSet=new JFrameSet(this,gameService.getDto());
	}


	/**
	 * ���̿�����ת
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();
	}


	/**
	 * ���̿�������
	 */
	public void keyDown() {
		this.gameService.keyDown();
		
		//this.gameService.testKeyDown();
		this.panelGame.repaint();
	}

	/**
	 * ���̿�������
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}


	/**
	 * ���̿�������
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();
	}


	public void showSetControl() {
		this.frameSet.setVisible(true);
		
	}


	public void setOver() {
		this.panelGame.repaint();
	}


	public void start() {
		this.gameService.startMainThread();
		this.panelGame.repaint();
		
	}
}
