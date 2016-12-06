package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataTest implements Data{

	@Override
	public List<Player> loadData() {
		List<Player> players=new ArrayList<Player>();
		players.add(new Player("ÁõÃ÷",1000));
		players.add(new Player("ÁõÃ÷",1800));
		players.add(new Player("ÁõÃ÷",2700));
		return players;
	}

	@Override
	public void saveData(Player player) {
		// TODO Auto-generated method stub
		System.out.println();
		
		
	}

}
