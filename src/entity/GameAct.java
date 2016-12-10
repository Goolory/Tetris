package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameAct {
	
	/**
	 * 方块数组
	 */
	private Point[] actPoints;
	
	/**
	 * 方块编号
	 */
	private int typeCode;
	
	private static int MIN_X=0;
	private static int MIN_Y=0;
	private static int MAX_X=9;
	private static int MAX_Y=17;
	
	
	private static List<Point[]> TYPE_CONFIG;
	
	static{
		TYPE_CONFIG=new ArrayList<Point[]>(7);
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(6,0),});//----
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(4,1),});//品
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(3,1),});//|--
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(5,0),new Point(3,1),new Point(4,1),});//倒Z
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(5,0),new Point(4,1),new Point(5,1),});//方
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(5,1),});//--|
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(4,1),new Point(5,1),});//Z
	}
	
	public  GameAct(int typeCode){
		this.init(typeCode);
		
		
	}
	
	public void init(int typeCode){
		this.typeCode = typeCode;
//		更新actCode的值刷新方块
		Point[] points = TYPE_CONFIG.get(typeCode);
		actPoints = new Point[points.length];
		for(int i = 0; i < points.length; i++){
			actPoints[i] = new Point(points[i].x,points[i].y);
		}
		
		
	}

	public Point[] getActPoints() {
		return actPoints;
	}
	
	
	/**
	 * 方块移动
	 * 
	 * @param moveX  X轴偏移量
	 * @param moveY  Y轴偏移量
	 */
	public boolean move(int moveX,int moveY, boolean[][] gameMap){
//		移动处理
		for(int i=0;i<this.actPoints.length;i++){
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			if(this.isOverZone(newX,newY,gameMap)){
				return false;
			}
		}
		for(int i=0;i<this.actPoints.length;i++){
			actPoints[i].x += moveX;
			actPoints[i].y += moveY;
		}
		return true;
	}
	
	/**
	 * 方块旋转
	 * 
	 * 顺时针旋转
	 * 公式：
	 * A.x = 0.y+0.x-B.y;
	 * A.y = 0.y-0.x+B.x;
	 */
	public void round(boolean[][] gameMap){
		if(this.typeCode == 4){
			return;
		}
		
		for(int i=1;i<actPoints.length;i++){
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			//TODO判断是否可旋转
			if(this.isOverZone(newX,newY,gameMap)){
				return;
			}
		}
		//方块旋转
		for(int i=1;i<actPoints.length;i++){
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			this.actPoints[i].x = newX;
			this.actPoints[i].y = newY;
		}
	}

	/**判断能否超出边界
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isOverZone(int x,int y, boolean[][] gameMap){
		return x<MIN_X||x>MAX_X||y<MIN_Y||y>MAX_Y||gameMap[x][y];
	}

	

	/**
	 * @return
	 */
	public int getTypeCode() {
		return typeCode;
	}
	
	
	

}
