package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataTest implements Data{

	@Override
	public List<Player> loadData() {
		List<Player> players=new ArrayList<Player>();
		players.add(new Player("刘明",1000));
		players.add(new Player("刘明",800));
		players.add(new Player("刘明",700));
		players.add(new Player("刘明",500));
		players.add(new Player("刘明",400));
		return players;
	}

	@Override
	public void saveData(List<Player> players) {
		// TODO Auto-generated method stub
		System.out.println();
		
		
	}

}
