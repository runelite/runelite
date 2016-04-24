package net.runelite.client;

import java.io.File;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import net.runelite.api.Client;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.overlay.OverlayRenderer;


public class RuneLite
{
	public static final File RUNELITE_DIR = new File(System.getProperty("user.home"), ".runelite");
	public static final File REPO_DIR = new File(RUNELITE_DIR, "repository");

	public static OptionSet options;
	private static Client client;
	private static RuneLite runelite;

	private ClientUI gui;
	private PluginManager pluginManager;
	private OverlayRenderer renderer;

	public static void main(String[] args) throws Exception
	{
		OptionParser parser = new OptionParser();
		parser.accepts("developer-mode");
		options = parser.parse(args);
		
		runelite = new RuneLite();
		runelite.start();
	}

	public void start() throws Exception
	{
		gui = new ClientUI();
		gui.setVisible(true);

		pluginManager = new PluginManager();
		pluginManager.loadAll();

		renderer = new OverlayRenderer();
	}

	public static Client getClient()
	{
		return client;
	}

	public static void setClient(Client client)
	{
		RuneLite.client = client;
	}

	public static RuneLite getRunelite()
	{
		return runelite;
	}

	public PluginManager getPluginManager()
	{
		return pluginManager;
	}

	public OverlayRenderer getRenderer()
	{
		return renderer;
	}
}
