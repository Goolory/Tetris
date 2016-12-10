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
	 * �����������
	 */
	private Random random = new Random();
	
	private static final int MAX_TYPE=7;
	
	public GameService(GameDto dto){
		
		this.dto=dto;
		
	}
	
//	���̿�����ת
	public void keyUp() {
		synchronized(this.dto){
			this.dto.getGameAct().round(this.dto.getGameMap());
		}
		
	}

//	���̿�������
	public void keyDown() {
//		���������ƶ������ж��Ƿ��ƶ��ɹ�
		if(!this.dto.isStart()){
			return;
		}
		if(this.dto.getGameAct().move(0, 1,this.dto.getGameMap())){
			return;
		}
//		��ȡ��ͼ
		boolean[][] map = this.dto.getGameMap();
//		��ȡ�������
		Point[] act = this.dto.getGameAct().getActPoints();
//		������ѻ�����ͼ����
		for(int i = 0; i < act.length; i++){
			map[act[i].x][act[i].y] = true;
		}
//		�ж�����
		int exp=this.plusPoint();
//		��ֲ������ӷ�
		this.dto.setNowPoint(this.dto.getNowPoint()+exp*20);
//		����������
		this.dto.setNowRemoveLine(this.dto.getNowRemoveLine()+exp);
//		�ж��Ƿ�����
		int rl=this.dto.getNowRemoveLine();
		if(rl/20<20){
			this.dto.setNowlevel(this.dto.getNowlevel()+rl/20);
		}
//		��������
//		������һ������
		this.dto.getGameAct().init(this.dto.getNext());
//		���������һ������
		this.dto.setNext(random.nextInt(MAX_TYPE));
		//�ж���Ϸ����
		if(this.checkLose()){
			this.afterLose();
		}
//		����һ�������5��
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
	 * @return �ӷ����в���
	 */
	private int plusPoint() {
		int exp=0;
//		��õ�ͼ
		boolean[][] map=this.dto.getGameMap();
//		ɨ���ͼ
		for(int y=0;y<18;y++){
//			�ж��Ƿ������
			if(isCanPemoveLine(y,map)){
//				����
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
	
	

//	���̿�������
	public void keyLeft() {
			this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
	}

//	���̿�������
	public void keyRight() {
			this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
	}
	//��ͣ
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
	 * �������߳�
	 */
	public void startGame() {
		GameAct act =new GameAct(random.nextInt(MAX_TYPE));
		this.dto.setNext(random.nextInt(MAX_TYPE));
//		this.dto.setGameMap();
		dto.setGameAct(act);
		dto.setStart(true);
	}
	
	
	
	//==========����==============================
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
