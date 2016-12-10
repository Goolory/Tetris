package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dto.Player;

public class DataBase implements Data {
	
	private static String DRIVER= "com.mysql.jdbc.Driver"; 
	
	private static String DB_URL="jdbc:mysql://localhost:3306/game_tetris";  
	
	private static String BD_USER="gm";
	
	private static String DB_PWD="gm123";
	
	
	
	private static String LOAD_SQL="select * from user_point where type_id=1 order by point desc limit 5;";
	
	private static String SAVE_SQL="insert into user_point(user_name,`point`,type_id) values (?,?,?)";
	
	
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Player> loadData(){
		Connection conn=null;
		java.sql.PreparedStatement stmt=null;
		ResultSet ret = null;  
		List<Player> players =new ArrayList<Player>();
		try {
			conn =(Connection) DriverManager.getConnection(DB_URL, BD_USER,DB_PWD);
			stmt=conn.prepareStatement(LOAD_SQL);
			ret=stmt.executeQuery();
			while(ret.next()){
				players.add(new Player(ret.getString(2),ret.getInt(3)));
			}
;			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)conn.close();
				if(stmt!=null)stmt.close();
				if(ret!=null)ret.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return players;
	
	}
	
	
	@Override
	public void saveData(Player player){
		Connection conn=null;
		java.sql.PreparedStatement stmt=null;
		try {
			conn =(Connection) DriverManager.getConnection(DB_URL, BD_USER,DB_PWD);
			stmt=conn.prepareStatement(SAVE_SQL);
			stmt.setObject(1, player.getName());
			stmt.setObject(2, player.getPoint());
			stmt.setObject(3, 1);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(conn!=null)conn.close();
				if(stmt!=null)stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
}
