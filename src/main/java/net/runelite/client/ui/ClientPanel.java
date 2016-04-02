package net.runelite.client.ui;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import net.runelite.client.ClientLoader;

final class ClientPanel extends JPanel
{

	public ClientPanel() throws Exception
	{
		setSize(new Dimension(ClientUI.PANEL_WIDTH, ClientUI.PANEL_HEIGHT));
		setMinimumSize(new Dimension(ClientUI.PANEL_WIDTH, ClientUI.PANEL_HEIGHT));
		setPreferredSize(new Dimension(ClientUI.PANEL_WIDTH, ClientUI.PANEL_HEIGHT));
		setBackground(Color.black);

		ClientLoader loader = new ClientLoader();

		Applet rs = loader.load();
		rs.setSize(this.getSize());
		rs.init();
		rs.start();
		this.add(rs);
	}
}