package net.runelite.client;

import net.runelite.client.ui.ClientUI;


public class RuneLite
{
	private ClientUI gui;

	public static void main(String[] args) throws Exception
	{
		new RuneLite().start();
	}

	public void start() throws Exception
	{
		gui = new ClientUI();
		gui.setVisible(true);
	}
}
