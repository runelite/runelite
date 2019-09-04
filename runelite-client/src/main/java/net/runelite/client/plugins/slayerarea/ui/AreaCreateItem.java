package net.runelite.client.plugins.slayerarea.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import net.runelite.api.Client;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.slayerarea.SlayerArea;
import net.runelite.client.plugins.slayerarea.SlayerAreas;

public class AreaCreateItem extends AreaPanelItem
{
	private SlayerAreaPluginPanel parent;
	private Boolean hide;
	private Client client;

	AreaCreateItem(SlayerAreaPluginPanel parent, Client client)
	{
		super(-1, new SlayerArea());
		this.parent = parent;
		this.client = client;
		setBackground(new Color(.10f, .15f, .25f));
	}

	@Override
	public void childPanel()
	{
		if (hide == null) hide = true;
		addButtons();
		if (hide) removeAll();
		addHideButton();
	}

	private void addHideButton()
	{
		JButton hideButton = new JButton(hide ? "Show" : "Hide");
		hideButton.addActionListener(e ->
		{
			hide = !hide;
			rebuild();
		});
		add(hideButton, gbc);
		gbc.gridy++;
	}

	private void addButtons()
	{
		JButton resetButton = new JButton("Reset");
		resetButton.setLayout(new BorderLayout(0, 6));
		resetButton.addActionListener(e ->
		{
			area = new SlayerArea(oldArea);
			rebuild();
		});
		add(resetButton, gbc);
		gbc.gridy++;

		JButton calcButton = new JButton("Calculate");
		calcButton.setLayout(new BorderLayout(0, 6));
		calcButton.addActionListener(e ->
		{
			WorldPoint localWorld = client.getLocalPlayer().getWorldLocation();
			id = localWorld.getRegionID();
			rebuild();
		});
		add(calcButton, gbc);
		gbc.gridy++;

		JButton saveButton = new JButton("Save");
		calcButton.setLayout(new BorderLayout(0, 6));
		saveButton.addActionListener(e ->
		{
			oldArea = new SlayerArea(area);
			SlayerAreas.addArea(id, area);
			parent.addArea(id, area);
			parent.refresh();
			area = new SlayerArea();
			rebuild();
		});
		add(saveButton, gbc);
		gbc.gridy++;
	}
}
