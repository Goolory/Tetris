package dto;

import java.util.List;

import entity.GameAct;

public class GameDto {
	/**
	 * 数据库中玩家数据
	 */
	private List<Player> dbRecode;
	
	/**本地磁盘玩家数据
	 * 
	 */
	private List<Player> diskRecode;
	
	/**
	 * 游戏地图
	 */
	private boolean[][] gameMap;
	
	/**
	 * 下落方块
	 */
	private GameAct gameAct;
	
	/**
	 * 下一方块
	 */
	private int next;
	
	/**
	 * 当前等级
	 */
	private int nowlevel;
	
	/**
	 * 当前分数
	 */
	private int nowPoint;
	
	/**
	 * 当前消除行数
	 */
	private int nowRemoveLine;
	
	public GameDto(){
		dtoInit();
		
	}
	
	/**
	 * dto初始化
	 */
	public void dtoInit(){
		//TODO
		this.gameMap=new boolean[10][18];
		//TODO 初始化所有游戏对象
	}

	public List<Player> getDbRecode() {
		return dbRecode;
	}

	public void setDbRecode(List<Player> dbRecode) {
		this.dbRecode = dbRecode;
	}

	public List<Player> getDiskRecode() {
		return diskRecode;
	}

	public void setDiskRecode(List<Player> diskRecode) {
		this.diskRecode = diskRecode;
	}

	public boolean[][] getGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct ganeAct) {
		this.gameAct = ganeAct;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}


	public int getNowlevel() {
		return nowlevel;
	}

	public void setNowlevel(int nowlevel) {
		this.nowlevel = nowlevel;
	}

	public int getNowPoint() {
		return nowPoint;
	}

	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}

	public int getNowRemoveLine() {
		return nowRemoveLine;
	}

	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}
	
	
}
