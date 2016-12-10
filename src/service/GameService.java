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
	
	private static final int MAX_TYPE=7;
	
	public GameService(GameDto dto){
		
		this.dto=dto;
		
	}
	
//	键盘控制旋转
	public void keyUp() {
		synchronized(this.dto){
			this.dto.getGameAct().round(this.dto.getGameMap());
		}
		
	}

//	键盘控制向下
	public void keyDown() {
//		方块向下移动，并判断是否移动成功
		if(!this.dto.isStart()){
			return;
		}
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
//		判断消行
		int exp=this.plusPoint();
//		算分操作，加分
		this.dto.setNowPoint(this.dto.getNowPoint()+exp*20);
//		消行数增加
		this.dto.setNowRemoveLine(this.dto.getNowRemoveLine()+exp);
//		判断是否升级
		int rl=this.dto.getNowRemoveLine();
		if(rl/20<20){
			this.dto.setNowlevel(this.dto.getNowlevel()+rl/20);
		}
//		升级操作
//		创建下一个方块
		this.dto.getGameAct().init(this.dto.getNext());
//		随机生成下一个方块
		this.dto.setNext(random.nextInt(MAX_TYPE));
		//判断游戏结束
		if(this.checkLose()){
			this.afterLose();
		}
//		下落一个方块加5分
		this.dto.setNowPoint(this.dto.getNowPoint()+5);
		
		
		
	}

	private void afterLose() {
		this.dto.setStart(false);
		
		
	
}

	private boolean checkLose() {
		boolean[][] map=this.dto.getGameMap();
		for(int x=0;x<10;x++){
			if(map[x][0]){
				return true;
			}
		}
		return false;
	
}

	/**
	 * @return 加分消行操作
	 */
	private int plusPoint() {
		int exp=0;
//		获得地图
		boolean[][] map=this.dto.getGameMap();
//		扫面地图
		for(int y=0;y<18;y++){
//			判断是否可消行
			if(isCanPemoveLine(y,map)){
//				消行
				this.removeLine(y,map);
				exp++;
			}
			
		}
		return exp;
			
	
	}
	private void removeLine(int rowNumber, boolean[][] map) {
		for(int x=0;x<10;x++){
			for(int y=rowNumber;y>0;y--){
				map[x][y]=map[x][y-1];
			}
			map[x][0]=false;
		}
		
	}

	private boolean isCanPemoveLine(int y,boolean[][] map){
		for(int x=0;x<10;x++){
			if(!map[x][y]){
				return false;
			}
		}
		return true;
	}
	
	

//	键盘控制左移
	public void keyLeft() {
			this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
	}

//	键盘控制右移
	public void keyRight() {
			this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
	}
	//暂停
	public void keyPause() {
		if(this.dto.isStart()){
			this.dto.channgePause();
		}
		
	}
	public void keyF() {
		if(this.dto.isStart()){
			this.dto.setNowPoint(this.dto.getNowPoint()+500);;
		}
		
	}
	
	
	
	 
	public GameDto getDto() {
		return dto;
	}

	
	
	public void setDbRecode(List<Player> players){
		this.dto.setDbRecode(players);
	}
	public void setDiskRecode(List<Player> players){
		this.dto.setDiskRecode(players);
		
	}

	/**
	 * 启动主线程
	 */
	public void startGame() {
		GameAct act =new GameAct(random.nextInt(MAX_TYPE));
		this.dto.setNext(random.nextInt(MAX_TYPE));
//		this.dto.setGameMap();
		dto.setGameAct(act);
		dto.setStart(true);
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

		

		
}
