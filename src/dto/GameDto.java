package dto;

import java.util.ArrayList;
import java.util.Collections;
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
	
	/**
	 * 开始
	 */
	private boolean start;
	
	/**
	 * 暂停
	 */
	private boolean pause;
	public GameDto(){
		dtoInit();
		
	}
	
	/**
	 * dto初始化
	 */
	public void dtoInit(){
		this.gameMap=new boolean[10][18];
		this.nowlevel=0;
		this.nowPoint=0;
		this.nowRemoveLine=0;
	}

	public List<Player> getDbRecode() {
		return dbRecode;
	}

	public void setDbRecode(List<Player> dbRecode) {
		setFillRecode(dbRecode);
		this.dbRecode = dbRecode;
	}

	public List<Player> getDiskRecode() {
		return diskRecode;
	}

	public void setDiskRecode(List<Player> diskRecode) {
		setFillRecode(diskRecode);
		this.diskRecode = diskRecode;
	}
	
	private List<Player> setFillRecode(List<Player> players){
		if(players==null){
			players=new ArrayList<Player>();
		}
		while(players.size()<5){
			players.add(new Player("No Data",0));
		}
//		排序
		Collections.sort(players);
		return players;
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

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isPause() {
		return pause;
	}

	public void channgePause() {
		this.pause = !this.pause;
	}
	
	
	
}
