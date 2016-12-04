package main;

import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;

public class GameStart {
	public static void main(String[] args){
		//������Ϸ����Դ
		GameDto dto = new GameDto();
//		������Ϸ���
		JPanelGame panel=new JPanelGame(dto);
//		������Ϸ�߼���
		GameService service =new GameService(dto);
//		������Ϸ��������������Ϸ�������Ϸ�߼��죩
		GameControl gameControl =new GameControl(panel,service);
//		������ҿ�����
		PlayerControl control = new PlayerControl(gameControl);
//		��װ��ҿ�����
		panel.setGameControl(control);
//		��������
		new JFrameGame(panel);
	}

}
