package service;

import java.awt.Point;
import java.util.List;
import java.util.Random;

import dto.GameDto;
import dto.Player;
import entity.GameAct;

public class GameService {
	
	/**
	 * 
	 */
	private GameDto dto;
	
	/**
	 * 随机数生成器
	 */
	private Random random = new Random();
	
	private static final int MAX_TYPE=6;
	
	public GameService(GameDto dto){
		
		this.dto=dto;
		
		GameAct act =new GameAct(random.nextInt(MAX_TYPE));
		
		
		dto.setGameAct(act);
	}
	
//	键盘控制旋转
	public void keyUp() {
		this.dto.getGameAct().round(this.dto.getGameMap());
	}

//	键盘控制向下
	public void keyDown() {
//		方块向下移动，并判断是否移动成功
		if(this.dto.getGameAct().move(0, 1,this.dto.getGameMap())){
			return;
		}
//		获取地图
		boolean[][] map = this.dto.getGameMap();
//		获取方块对象
		Point[] act = this.dto.getGameAct().getActPoints();
//		将方块堆积到地图数组
		for(int i = 0; i < act.length; i++){
			map[act[i].x][act[i].y] = true;
		}
//		TODO判断是否可以消行
//		消行操作
//		算分操作
//		判断是否升级
//		升级操作
//		创建下一个方块
		this.dto.getGameAct().init(this.dto.getNext());
//		随机生成下一个方块
		this.dto.setNext(random.nextInt(MAX_TYPE));
		
	}

//	键盘控制左移
	public void keyLeft() {
		this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
	}

//	键盘控制右移
	public void keyRight() {
		this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
	}
	
	
	
	 
//==========测试==============================
	public void testKeyDown() {
		// TODO Auto-generated method stub
		int point =this.dto.getNowPoint();
		int rmLine= this.dto.getNowRemoveLine();
		int ly=this.dto.getNowlevel();
		point+=10;
		rmLine+=1;
		if(rmLine%20==0){
			ly++;
		}
		this.dto.setNowPoint(point);
		this.dto.setNowRemoveLine(rmLine);
		this.dto.setNowlevel(ly);
	}
	
	public void setDbRecode(List<Player> players){
		this.dto.setDbRecode(players);
	}
	public void setDiskRecode(List<Player> players){
		this.dto.setDiskRecode(players);
		
	}
}
