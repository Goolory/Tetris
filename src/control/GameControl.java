package control;

import dao.Data;
import dao.DataTest;
import service.GameService;
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
	
	public GameControl(JPanelGame panelGame,GameService gameService){
		this.panelGame=panelGame;
		this.gameService=gameService;
		
//		从数据接口A获取数据
		dataA = new DataTest();
		//设置数据至画面
		this.gameService.setDbRecode(dataA.loadData());
//		从数据接口B获取数据
		dataB = new DataTest();
		//设置数据至画面
		this.gameService.setDiskRecode(dataB.loadData());
	}


	/**
	 * 键盘控制旋转
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();
	}


	/**
	 * 键盘控制向下
	 */
	public void keyDown() {
		this.gameService.keyDown();
		
		this.gameService.testKeyDown();
		this.panelGame.repaint();
	}

	/**
	 * 键盘控制左移
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}


	/**
	 * 键盘控制右移
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();
	}
}
