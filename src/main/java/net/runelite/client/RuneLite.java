package net.runelite.client;

import java.io.File;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import net.runelite.api.Client;
import net.runelite.client.ui.ClientUI;


public class RuneLite
{
	public static final File RUNELITE_DIR = new File(System.getProperty("user.home"), ".runelite");
	public static final File REPO_DIR = new File(RUNELITE_DIR, "repository");

	public static OptionSet options;
	private ClientUI gui;
	private static Client client;

	public static void main(String[] args) throws Exception
	{
		OptionParser parser = new OptionParser();
		parser.accepts("developer-mode");
		options = parser.parse(args);
		
		new RuneLite().start();
	}

	public void start() throws Exception
	{
		gui = new ClientUI();
		gui.setVisible(true);
	}

	public static Client getClient()
	{
		return client;
	}

	public static void setClient(Client client)
	{
		RuneLite.client = client;
	}
}
