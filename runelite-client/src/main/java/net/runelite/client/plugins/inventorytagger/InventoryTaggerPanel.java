package net.runelite.client.plugins.inventorytagger;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.runelite.api.Client;
import net.runelite.client.ui.PluginPanel;

public class InventoryTaggerPanel extends PluginPanel
{
	InventoryTaggerPanel(InventoryTaggerPlugin inventoryTaggerPlugin, Client client)
	{
		super();

		final JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout(0, 3));
		add(layoutPanel);
	}
}
