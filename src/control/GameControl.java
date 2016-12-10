package control;

import dao.Data;
import dao.DataBase;
import dao.DataDisk;
import dto.Player;
import service.GameService;
import ui.JFrameLose;
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
	
	/**
	 * ��Ϸ�߳�
	 */
	private Thread gameThread=null;
	
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
		if(this.gameService.getDto().isPause()){
			return;
		}
		this.gameService.keyUp();
		this.panelGame.repaint();
	}


	/**
	 * ���̿�������
	 */
	public void keyDown() {
		if(this.gameService.getDto().isPause()){
			return;
		}
		this.gameService.keyDown();
		this.panelGame.repaint();
	}

	/**
	 * ���̿�������
	 */
	public void keyLeft() {
		if(this.gameService.getDto().isPause()){
			return;
		}
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}


	/**
	 * ���̿�������
	 */
	public void keyRight() {
		if(this.gameService.getDto().isPause()){
			return;
		}
		this.gameService.keyRight();
		this.panelGame.repaint();
	}

	public void keyPause() {
		this.gameService.keyPause();
		this.panelGame.repaint();
		
	}
	
	public void keyF() {
		this.gameService.keyF();
		this.panelGame.repaint();
	}

	public void showSetControl() {
		this.frameSet.setVisible(true);
		
	}


	public void setOver() {
		this.panelGame.repaint();
	}


	public void start() {
		//��Ϸ���ݳ�ʼ��
		this.gameService.startGame();
		
		//�����̶߳���
		this.gameThread=new MainThread();
		//�����߳�
		this.gameThread.start();
		this.panelGame.repaint();
	}
	
	public void afterLose() {
		new JFrameLose(this.gameService.getDto(),this);
		
	}
	
	private class MainThread extends Thread{
		@Override
		public void run(){
			panelGame.repaint();
			while(true){
				if(!gameService.getDto().isStart()){
					afterLose();
					break;
				}
					
				try {
					Thread.sleep(1000-gameService.getDto().getNowlevel()*100);
					if(gameService.getDto().isPause()){
						continue;
					}
					gameService.keyDown();
					
					panelGame.repaint();
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		
	}

	/**
	 * @param name
	 */
	public void savePoint(String name) {
		Player p =new Player(name,gameService.getDto().getNowPoint());
		this.dataA.saveData(p);
		this.dataB.saveData(p);
		this.gameService.getDto().setDbRecode(dataA.loadData());
		this.gameService.getDto().setDiskRecode(dataB.loadData());
		this.panelGame.repaint();
	}

	


	
}
