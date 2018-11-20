package net.runelite.client.plugins.bosslog;

import net.runelite.api.Client;
import net.runelite.client.game.AsyncBufferedImage;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.bosslog.enums.Tab;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.materialtabs.MaterialTab;
import net.runelite.client.ui.components.materialtabs.MaterialTabGroup;

import javax.annotation.Nullable;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

class BossLogPanel extends PluginPanel {

    private final ItemManager itemManager;
    public final BossLogPlugin plugin;

    public final JPanel display = new JPanel();
    private final MaterialTabGroup tabGroup = new MaterialTabGroup(display);
    private final Map<Tab, MaterialTab> uiTabs = new HashMap<>();

    private final JLabel overallIcon = new JLabel();

    @Nullable
    private BossLogDropPanel activeTabPanel = null;

    BossLogPanel(final BossLogPlugin plugin, final ItemManager itemManager, final Client client)
    {
        super(false);
        this.itemManager = itemManager;
        this.plugin = plugin;

        setLayout(new BorderLayout());
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        display.setBorder(new EmptyBorder(7, 6, 7, 0));
        display.setLayout(new DynamicGridLayout());

        add(display, BorderLayout.CENTER);
        addTab(Tab.OVERVIEW, new BossLogOverviewPanel(itemManager, this));
        for(Boss b : plugin.bosses)
            addTab(b.getBoss().getTab(), new BossLogDropPanel(itemManager, b, client, this));
    }

    private void addTab(Tab tab, BossLogDropPanel tabContentPanel)
    {
        JPanel wrapped = new JPanel(new BorderLayout());
        wrapped.add(tabContentPanel, BorderLayout.NORTH);
        wrapped.setBackground(ColorScheme.DARK_GRAY_COLOR);

        JScrollPane scroller = new JScrollPane(wrapped);
        scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.getVerticalScrollBar().setPreferredSize(new Dimension(16, 0));
        scroller.getVerticalScrollBar().setBorder(new EmptyBorder(0, 9, 0, 0));
        scroller.setBackground(ColorScheme.DARK_GRAY_COLOR);

        MaterialTab materialTab = new MaterialTab(new ImageIcon(), tabGroup, scroller);
        materialTab.setName(tab.getName());
        materialTab.setToolTipText(tab.getName());

        AsyncBufferedImage icon = itemManager.getImage(tab.getItemID());
        Runnable resize = () ->
        {
            BufferedImage subIcon = icon.getSubimage(0, 0, 32, 32);
            materialTab.setIcon(new ImageIcon(subIcon.getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
        };
        icon.onChanged(resize);
        resize.run();

        materialTab.setOnSelectEvent(() ->
        {
            activeTabPanel = tabContentPanel;
            tabContentPanel.update();
            return true;
        });

        uiTabs.put(tab, materialTab);
        tabGroup.addTab(materialTab);
    }

    private void addTab(Tab tab, BossLogOverviewPanel tabContentPanel)
    {
        JPanel wrapped = new JPanel(new BorderLayout());
        wrapped.add(tabContentPanel, BorderLayout.NORTH);
        wrapped.setBackground(ColorScheme.DARK_GRAY_COLOR);

        JScrollPane scroller = new JScrollPane(wrapped);
        scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.getVerticalScrollBar().setPreferredSize(new Dimension(16, 0));
        scroller.getVerticalScrollBar().setBorder(new EmptyBorder(0, 9, 0, 0));
        scroller.setBackground(ColorScheme.DARK_GRAY_COLOR);

        // Use a placeholder icon until the async image gets loaded
        MaterialTab materialTab = new MaterialTab(new ImageIcon(), tabGroup, scroller);
        materialTab.setName(tab.getName());
        materialTab.setToolTipText(tab.getName());

        AsyncBufferedImage icon = itemManager.getImage(tab.getItemID());
        Runnable resize = () ->
        {
            BufferedImage subIcon = icon.getSubimage(0, 0, 32, 32);
            materialTab.setIcon(new ImageIcon(subIcon.getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
        };
        icon.onChanged(resize);
        resize.run();

        materialTab.setOnSelectEvent(() ->
        {
            activeTabPanel = null;
            return true;
        });
        uiTabs.put(tab, materialTab);
        tabGroup.addTab(materialTab);
    }

    void update() {
        for(Boss b : plugin.bosses) {
            b.update(itemManager);
        }

        if(activeTabPanel != null) {
            activeTabPanel.update();
            display.revalidate();
            display.repaint();
        }
    }

    public void switchTab(Tab tab) {
        tabGroup.select(uiTabs.get(tab));
    }

    void loadHeaderIcon(BufferedImage img)
    {
        overallIcon.setIcon(new ImageIcon(img));
    }
}
