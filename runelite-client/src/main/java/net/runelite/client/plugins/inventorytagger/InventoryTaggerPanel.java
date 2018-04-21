package net.runelite.client.plugins.inventorytagger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import net.runelite.api.Client;
import net.runelite.client.ui.PluginPanel;

public class InventoryTaggerPanel extends PluginPanel
{
	InventoryTaggerPanel(InventoryTaggerPlugin inventoryTaggerPlugin, Client client, InventoryTaggerPlugin plugin)
	{
		super();

		final JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout(0, 3));
		add(layoutPanel);

		final JCheckBox editorModeButton = new JCheckBox("Editor mode");
		editorModeButton.addActionListener(e -> resetAllInfoBoxes());
		add(editorModeButton);

		final JPanel infoBoxPanel = new JPanel();
		infoBoxPanel.setLayout(new BoxLayout(infoBoxPanel, BoxLayout.Y_AXIS));
		infoBoxPanel.setBackground(Color.CYAN);
		infoBoxPanel.setBounds(0, 0, 100, 700);
		layoutPanel.add(infoBoxPanel, BorderLayout.CENTER);

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@" + plugin.taggedItems.size());

		for (TaggedItems ti :plugin.taggedItems)
		{
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLUE);
			infoBoxPanel.add( new PresetBox(ti) );
		}

	}

	private void resetAllInfoBoxes()
	{

	}
}
