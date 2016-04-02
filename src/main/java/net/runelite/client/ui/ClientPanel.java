package net.runelite.client.ui;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;
import java.net.URLClassLoader;
import javax.swing.JPanel;
import net.runelite.client.ConfigLoader;
import net.runelite.client.RSStub;

final class ClientPanel extends JPanel
{

	public ClientPanel() throws Exception
	{
		setSize(new Dimension(ClientUI.PANEL_WIDTH, ClientUI.PANEL_HEIGHT));
		setMinimumSize(new Dimension(ClientUI.PANEL_WIDTH, ClientUI.PANEL_HEIGHT));
		setPreferredSize(new Dimension(ClientUI.PANEL_WIDTH, ClientUI.PANEL_HEIGHT));
		setBackground(Color.black);

		Applet rs = dl();
		rs.setSize(this.getSize());
		rs.init();
		rs.start();
		this.add(rs);
	}

	private Applet dl() throws Exception
	{
		ConfigLoader config = new ConfigLoader();

		config.fetch();

		//URL clientUrl = new URL(config.getProperty(ConfigLoader.CODEBASE) + config.getProperty(ConfigLoader.INITIAL_JAR));
		URL clientUrl = new URL("http://192.168.1.2/rs/" + config.getProperty(ConfigLoader.INITIAL_JAR));
		String initialClass = config.getProperty(ConfigLoader.INITIAL_CLASS).replace(".class", "");

		URLClassLoader loader = new URLClassLoader(new URL[]{ clientUrl });
		Class<?> clientClass = loader.loadClass(initialClass);

		Applet rs = (Applet) clientClass.newInstance();

		rs.setStub(new RSStub(config, rs));
		return rs;
	}
}