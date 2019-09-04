package net.runelite.client.plugins.slayerarea.ui;

import com.google.inject.Inject;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.api.Client;
import net.runelite.client.plugins.slayerarea.SlayerArea;
import net.runelite.client.plugins.slayerarea.SlayerAreaPlugin;
import net.runelite.client.plugins.slayerarea.SlayerAreas;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.IconTextField;

public class SlayerAreaPluginPanel extends PluginPanel
{

	@Inject
	private SlayerAreaPlugin plugin;

	@Inject
	private Client client;

	private final List<AreaPanelItem> areaPanelList = new ArrayList<>();
	private final JPanel markerView = new JPanel(new GridBagLayout());
	private final IconTextField searchBar = new IconTextField();
	private JPanel topPanel;
	private JPanel centerPanel;
	private GridBagConstraints gbc;

	public void init()
	{
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));

		topPanel = new JPanel();
		topPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
		topPanel.setLayout(new BorderLayout(0, 6));
		add(topPanel, BorderLayout.NORTH);

		AreaCreateItem createItem = new AreaCreateItem(this, client);
		topPanel.add(createItem, BorderLayout.NORTH);

		centerPanel = new JPanel(new BorderLayout());
		centerPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);

		searchBar.setIcon(IconTextField.Icon.SEARCH);
		searchBar.setPreferredSize(new Dimension(PluginPanel.PANEL_WIDTH - 20, 30));
		searchBar.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		searchBar.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
		searchBar.addActionListener(e -> onSearchBarChanged());

		buildAreaList();
		markerView.setBackground(ColorScheme.DARK_GRAY_COLOR);
		onSearchBarChanged();

		centerPanel.add(markerView, BorderLayout.CENTER);
		add(centerPanel, BorderLayout.CENTER);

		topPanel.add(searchBar, BorderLayout.CENTER);
		searchBar.requestFocusInWindow();
		validate();
	}

	private void onSearchBarChanged()
	{
		final String text = searchBar.getText();

		showMatchingPlugins(text);

		repaint();
		revalidate();
	}

	private void showMatchingPlugins(String text)
	{

		gbc = AreaPanelItem.buildConstraints();
		markerView.removeAll();

		if (text.isEmpty())
		{
			areaPanelList.forEach(item ->
			{
				addAreaPanel(item);
			});
			return;
		}

		final String[] searchTerms = text.toLowerCase().split(",");
		areaPanelList.forEach(item ->
		{
			if (item.matchesSearchTerms(searchTerms))
			{
				addAreaPanel(item);
			}
		});
	}

	public void addAreaPanel(AreaPanelItem item)
	{
		markerView.add(item, gbc);
		gbc.gridy++;

		markerView.add(Box.createRigidArea(new Dimension(0, 10)), gbc);
		gbc.gridy++;
	}

	public void addArea(int id, SlayerArea area)
	{
		areaPanelList.add(0, new AreaPanelItem(id, area));
	}

	public void buildAreaList()
	{
		Map<Integer, SlayerArea> areas = SlayerAreas.getAreas();
		for (Map.Entry<Integer, SlayerArea> entry : areas.entrySet())
		{
			int id = entry.getKey();
			SlayerArea area = entry.getValue();
			AreaPanelItem item = new AreaPanelItem(id, area);
			areaPanelList.add(item);
		}
	}

	public void rebuild()
	{
		removeAll();
		repaint();
		revalidate();
		init();
	}

	public void refresh()
	{
		onSearchBarChanged();
	}
}
