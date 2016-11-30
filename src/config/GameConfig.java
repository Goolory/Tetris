package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	/*窗口高度*/
	private int width;
	private int height;
	private int windowSize;
	private int padding;
	
	private List<LayerConfig> layersConfig;
	
	public GameConfig() throws Exception{
		SAXReader reader=new SAXReader();
		Document doc = reader.read("config/cfg.xml");
		Element game=doc.getRootElement();
		//		配置窗口
		this.setUiConfig(game.element("frame"));
		//配置系统参数
		this.setSystemConfig(game.element("System"));
//		配置数据访问参数
		this.setDataConfig(game.element("data"));
		
		
	}
	
	/**
	 * @param frame 配置文件窗口配置元素
	 */
	private void setUiConfig(Element frame){
		this.width=Integer.parseInt(frame.attributeValue("width"));
		this.height=Integer.parseInt(frame.attributeValue("height"));
		this.windowSize=Integer.parseInt(frame.attributeValue("windowSize"));
		this.padding=Integer.parseInt(frame.attributeValue("padding"));
		
		List<Element> layers= frame.elements("layer");
		
		layersConfig=new ArrayList<LayerConfig>();
		for(Element layer:layers){
			LayerConfig lc=new LayerConfig(
					layer.attributeValue("className"),
					Integer.parseInt(layer.attributeValue("x")),
					Integer.parseInt(layer.attributeValue("y")),
					Integer.parseInt(layer.attributeValue("w")),
					Integer.parseInt(layer.attributeValue("h"))
			);
			layersConfig.add(lc);
		}
	}
	
	/**
	 * 配置系统参数
	 * @param frame
	 */
	private void setSystemConfig(Element frame){
		//TODO
	}
	
	/**
	 * 
	 * 配置数据访问
	 * @param data
	 */
	private void setDataConfig(Element data){
		//TODO
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getWindowSize() {
		return windowSize;
	}

	public int getPadding() {
		return padding;
	}

	public List<LayerConfig> getLayersConfig() {
		return layersConfig;
	}
	
	

}
