package ui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.swing.JFrame;

public class Bgm extends JFrame{
	File f;
	URI uri;
	URL url;
	Bgm(){
		
		try {
			f=new File("music/bgm.wav");
			uri=f.toURI();
			url=uri.toURL();
			AudioClip aau;
			aau = Applet.newAudioClip(url);
			aau.loop();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
