package net.runelite.client.plugins.grandexchange;

import java.time.temporal.ChronoUnit;
import javax.imageio.ImageIO;
import javax.swing.*;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.task.Schedule;
import net.runelite.client.ui.ClientUI;
import net.runelite.client.ui.NavigationButton;

/**
 * @author Robbie, created on 29/10/2017 09:59 AM
 */
@PluginDescriptor(name = "Grand Exchange offer plugin")
public class GrandExchangePlugin extends Plugin
{

	private ImageIcon icon;
	private NavigationButton button;

	GrandExchangePanel panel;

	private ClientUI ui;
	private boolean isInitialized = false;

	@Override
	protected void startUp() throws Exception
	{
		ui = RuneLite.getRunelite().getGui();

		button = new NavigationButton("GE Offers", this::doPanel);
		icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("ge_icon.png")));
		button.getButton().setIcon(icon);

		ui.getPluginToolbar().addNavigation(button);
	}

	@Schedule(
			period = 1000,
			unit = ChronoUnit.MILLIS
	)
	public void doUpdate()
	{
		if (!isInitialized) return;
		panel.updateOffers();
	}

	@Override
	protected void shutDown() throws Exception
	{

	}

	private GrandExchangePanel doPanel()
	{
		panel = panel == null ? panel = GrandExchangePanel.getInstance() : panel;
		panel.init();
		isInitialized = true;
		return panel;
	}


}
