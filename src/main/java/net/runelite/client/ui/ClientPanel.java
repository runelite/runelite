package net.runelite.client.ui;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JPanel;
import net.runelite.api.Client;
import net.runelite.client.ClientLoader;
import net.runelite.client.RuneLite;

final class ClientPanel extends JPanel implements ComponentListener
{
	public static final int PANEL_WIDTH = 765, PANEL_HEIGHT = 503;
	
	private Applet rs;

	public ClientPanel() throws Exception
	{
		setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setBackground(Color.black);
		this.addComponentListener(this);

		ClientLoader loader = new ClientLoader();

		rs = loader.load();
		rs.setSize(this.getSize());
		rs.init();
		rs.start();
		this.add(rs);

		RuneLite.setClient(new Client((net.runelite.rs.api.Client) rs));
	}

	@Override
	public void componentResized(ComponentEvent e)
	{
		rs.setSize(this.getSize());
		this.setPreferredSize(this.getSize());
		rs.setPreferredSize(this.getPreferredSize());
	}

	@Override
	public void componentMoved(ComponentEvent e)
	{
	}

	@Override
	public void componentShown(ComponentEvent e)
	{
	}

	@Override
	public void componentHidden(ComponentEvent e)
	{
	}
}