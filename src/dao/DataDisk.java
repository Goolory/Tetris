package dao;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import dto.Player;

public class DataDisk implements Data{

	@Override
	public List<Player> loadData() {
		ObjectInputStream ois=null;
		List<Player> players=null;
		try {
			ois=new ObjectInputStream(new FileInputStream("save/recode.dot"));
			players=(List<Player>)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return players;
	}

	@Override
	public void saveData(Player player) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("save/recode.dot"));
			oos.writeObject(player);
		}  catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
