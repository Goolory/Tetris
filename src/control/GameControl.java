package control;

import dao.Data;
import dao.DataBase;
import dao.DataDisk;
import dto.Player;
import service.GameService;
import ui.JFrameLose;
import ui.JFrameSet;
import ui.JPanelGame;

/**接受玩家键盘事件
 * 控制画面
 * 控制游戏逻辑
 * @author lenovo
 *
 */
public class GameControl {
	
	/**
	 * 数据访问接口A
	 */
	private Data dataA;
	/**
	 * 数据访问接口B
	 */
	private Data dataB;
	/**
	 * 游戏界面层
	 */
	private JPanelGame panelGame;
	/**
	 * 游戏逻辑层
	 */
	private GameService gameService;
	
	
	private JFrameSet frameSet;
	
	/**
	 * 游戏线程
	 */
	private Thread gameThread=null;
	
	public GameControl(JPanelGame panelGame,GameService gameService){
		this.panelGame=panelGame;
		this.gameService=gameService;
		
//		从数据接口A获取数据
		dataA = new DataBase();
		//设置数据至画面
		this.gameService.setDbRecode(dataA.loadData());
//		从数据接口B获取数据
		dataB = new DataDisk();
		//设置数据至画面
		this.gameService.setDiskRecode(dataB.loadData());
		
		this.frameSet=new JFrameSet(this,gameService.getDto());
	}


	/**
	 * 键盘控制旋转
	 */
	public void keyUp() {
		if(this.gameService.getDto().isPause()){
			return;
		}
		this.gameService.keyUp();
		this.panelGame.repaint();
	}


	/**
	 * 键盘控制向下
	 */
	public void keyDown() {
		if(this.gameService.getDto().isPause()){
			return;
		}
		this.gameService.keyDown();
		this.panelGame.repaint();
	}

	/**
	 * 键盘控制左移
	 */
	public void keyLeft() {
		if(this.gameService.getDto().isPause()){
			return;
		}
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}


	/**
	 * 键盘控制右移
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
		//游戏数据初始化
		this.gameService.startGame();
		
		//创建线程对象
		this.gameThread=new MainThread();
		//启动线程
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
