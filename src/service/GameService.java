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
	
	private static final int MAX_TYPE=6;
	
	public GameService(GameDto dto){
		
		this.dto=dto;
		
		GameAct act =new GameAct(random.nextInt(MAX_TYPE));
		
		
		dto.setGameAct(act);
	}
	
//	���̿�����ת
	public void keyUp() {
		this.dto.getGameAct().round(this.dto.getGameMap());
	}

//	���̿�������
	public void keyDown() {
//		���������ƶ������ж��Ƿ��ƶ��ɹ�
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
//		TODO�ж��Ƿ��������
//		���в���
//		��ֲ���
//		�ж��Ƿ�����
//		��������
//		������һ������
		this.dto.getGameAct().init(this.dto.getNext());
//		���������һ������
		this.dto.setNext(random.nextInt(MAX_TYPE));
		
	}

//	���̿�������
	public void keyLeft() {
		this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
	}

//	���̿�������
	public void keyRight() {
		this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
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
	
	public void setDbRecode(List<Player> players){
		this.dto.setDbRecode(players);
	}
	public void setDiskRecode(List<Player> players){
		this.dto.setDiskRecode(players);
		
	}
}
