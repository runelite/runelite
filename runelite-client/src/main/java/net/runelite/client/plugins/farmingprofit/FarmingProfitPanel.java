package net.runelite.client.plugins.farmingprofit;

import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.StackFormatter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class FarmingProfitPanel extends PluginPanel {

    private static final String HTML_LABEL_TEMPLATE =
            "<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>";

    // When no runs have been done, display an error panel
    private final PluginErrorPanel errorPanel = new PluginErrorPanel();

    // Handle farm run logs
    private final JPanel runsContainer = new JPanel();

    // Handle overall session data
    private final JPanel overallPanel = new JPanel();
    private final JLabel overallIcon = new JLabel();
    private final JLabel overallProfitLabel = new JLabel();
    private final JLabel overallPatchesLabel = new JLabel();
    private final ItemManager itemManager;
    private int overallProfit;
    private int overallPatches;

    private ArrayList<FarmingProfitRun> runs = new ArrayList<>();

    FarmingProfitPanel(ItemManager itemManager)
    {
        this.itemManager = itemManager;
        setBorder(new EmptyBorder(6, 6, 6, 6));
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        setLayout(new BorderLayout());

        // Create layout panel for wrapping
        final JPanel layoutPanel = new JPanel();
        layoutPanel.setLayout(new BoxLayout(layoutPanel, BoxLayout.Y_AXIS));
        add(layoutPanel, BorderLayout.NORTH);

        // Create panel that will contain overall data
        overallPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        overallPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        overallPanel.setLayout(new BorderLayout());

        // Add icon and contents
        final JPanel overallInfo = new JPanel();
        overallInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        overallInfo.setLayout(new GridLayout(2, 1));
        overallInfo.setBorder(new EmptyBorder(0, 10, 0, 0));
        overallProfitLabel.setFont(FontManager.getRunescapeSmallFont());
        overallPatchesLabel.setFont(FontManager.getRunescapeSmallFont());
        overallInfo.add(overallProfitLabel);
        overallInfo.add(overallPatchesLabel);
        overallPanel.add(overallIcon, BorderLayout.WEST);
        overallPanel.add(overallInfo, BorderLayout.CENTER);

        // Create reset all menu
        final JMenuItem reset = new JMenuItem("Reset All");
        reset.addActionListener(e ->
        {
            overallProfit = 0;
            overallPatches = 0;
        });

        // Create loot logs wrapper
        runsContainer.setLayout(new BoxLayout(runsContainer, BoxLayout.Y_AXIS));
//        runsContainer.add(new FarmingProfitBox(ItemID.RANARR_WEED, 100000, 7));
        layoutPanel.add(overallPanel);
        layoutPanel.add(runsContainer);
    }

    public void addRun(FarmingProfitRun run)
    {
        runs.add(run);

        final FarmingProfitBox box = new FarmingProfitBox(itemManager,
                run.getProductId(), run.getSeedId(), run.getAmount());

        runsContainer.add(box);
        runsContainer.repaint();

        updateOverall();
    }

    void loadHeaderIcon(BufferedImage img)
    {
        overallIcon.setIcon(new ImageIcon(img));
    }

    private static String htmlLabel(String key, long value)
    {
        final String valueStr = StackFormatter.quantityToStackSize(value);
        return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR), key, valueStr);
    }

    private void updateOverall()
    {
        overallProfitLabel.setText(htmlLabel("Total profit: ", overallProfit));
        overallPatchesLabel.setText(htmlLabel("Total patches: ", overallPatches));
    }

}
