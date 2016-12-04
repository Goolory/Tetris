package dto;

import java.util.List;

import entity.GameAct;

public class GameDto {
	/**
	 * ���ݿ����������
	 */
	private List<Player> dbRecode;
	
	/**���ش����������
	 * 
	 */
	private List<Player> diskRecode;
	
	/**
	 * ��Ϸ��ͼ
	 */
	private boolean[][] gameMap;
	
	/**
	 * ���䷽��
	 */
	private GameAct gameAct;
	
	/**
	 * ��һ����
	 */
	private int next;
	
	/**
	 * ��ǰ�ȼ�
	 */
	private int nowlevel;
	
	/**
	 * ��ǰ����
	 */
	private int nowPoint;
	
	/**
	 * ��ǰ��������
	 */
	private int nowRemoveLine;
	
	public GameDto(){
		dtoInit();
		
	}
	
	/**
	 * dto��ʼ��
	 */
	public void dtoInit(){
		//TODO
		this.gameMap=new boolean[10][18];
		//TODO ��ʼ��������Ϸ����
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