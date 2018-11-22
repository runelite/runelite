package net.runelite.client.plugins.bosslog;

import net.runelite.api.Client;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.bosslog.enums.Tab;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;

import javax.annotation.Nullable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

class BossLogPanel extends PluginPanel
{

	private final ItemManager itemManager;
	public final BossLogPlugin plugin;
	private final Client client;

	public final JPanel display = new JPanel();
	private final MaterialTabGroup tabGroup = new MaterialTabGroup(display);
	private final Map<Tab, MaterialTab> uiTabs = new HashMap<>();

	@Nullable
	private BossLogPanelView activeTabPanel = null;

	BossLogPanel(final BossLogPlugin plugin, final ItemManager itemManager, final Client client)
	{
		super(false);
		this.itemManager = itemManager;
		this.plugin = plugin;
		this.client = client;

		setLayout(new BorderLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		display.setBorder(new EmptyBorder(7, 6, 7, 0));
		display.setLayout(new DynamicGridLayout());

		add(display, BorderLayout.CENTER);

		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());
		display.add(loginPanel);

		JLabel loginLabel = new JLabel("Please login to initalize your boss log");
		loginLabel.setFont(FontManager.getRunescapeFont());
		loginLabel.setForeground(Color.white);
		loginLabel.setHorizontalAlignment(JLabel.CENTER);
		loginLabel.setVerticalAlignment(JLabel.CENTER);
		loginPanel.add(loginLabel, BorderLayout.CENTER);
	}

	private void addTab(Tab tab, BossLogPanelView tabContentPanel)
	{
		JPanel wrapped = new JPanel(new BorderLayout());
		wrapped.add(tabContentPanel, BorderLayout.NORTH);
		wrapped.setBackground(ColorScheme.DARK_GRAY_COLOR);

		JScrollPane scroller = new JScrollPane(wrapped);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
		scroller.getVerticalScrollBar().setBorder(new EmptyBorder(0, 6, 0, 0));
		scroller.setBackground(ColorScheme.DARK_GRAY_COLOR);

		MaterialTab materialTab = new MaterialTab(new ImageIcon(), tabGroup, scroller);
		materialTab.setName(tab.getName());
		materialTab.setToolTipText(tab.getName());

		materialTab.setOnSelectEvent(() ->
		{
			activeTabPanel = tabContentPanel;
			tabContentPanel.update();
			return true;
		});

		uiTabs.put(tab, materialTab);
		tabGroup.addTab(materialTab);
	}

	void update()
	{
		for (Boss b : plugin.bosses)
		{
			b.update(itemManager);
		}

		if (activeTabPanel != null)
		{
			activeTabPanel.update();
			//display.revalidate();
			//display.repaint();
		}
	}

	void init()
	{
		uiTabs.clear();
		tabGroup.removeAll();
		addTab(Tab.OVERVIEW, new BossLogOverviewPanel(itemManager, this));
		for (Boss b : plugin.bosses)
			addTab(b.getBoss().getTab(), new BossLogDropPanel(itemManager, b, client, this));
	}

	void clear()
	{
		uiTabs.clear();
		tabGroup.removeAll();
		display.removeAll();

		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());
		display.add(loginPanel);

		JLabel loginLabel = new JLabel("Please login to initalize your boss log");
		loginLabel.setFont(FontManager.getRunescapeFont());
		loginLabel.setForeground(Color.white);
		loginLabel.setHorizontalAlignment(JLabel.CENTER);
		loginLabel.setVerticalAlignment(JLabel.CENTER);
		loginPanel.add(loginLabel, BorderLayout.CENTER);

		display.revalidate();
		display.repaint();
	}

	void switchTab(Tab tab)
	{
		tabGroup.select(uiTabs.get(tab));
	}
}
