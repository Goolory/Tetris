package dao;

import java.util.List;

import dto.Player;

/**
 * ���ݽӿ�
 *
 */
public interface Data {
	
	/**
	 * �������
	 */
	public List<Player> loadData();
	
	/**
	 * �洢����
	 */
	public void saveData(List<Player> players);
}
