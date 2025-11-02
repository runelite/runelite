package net.runelite.client.plugins.bankwatcher;

import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.PluginPanel;

import javax.inject.Inject;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.stream.Collectors;

class BankWatcherPanel extends PluginPanel
{
    private JComboBox<String> filterDropdown;
    private JButton scanButton;
    private JLabel headerLabel;
    private JPanel itemListPanel;

    private final BankWatcherService service;
    private final ItemManager itemManager;
    private final ClientThread clientThread;

    private List<BankItem> currentItems;

    @Inject
    public BankWatcherPanel(BankWatcherService service, ItemManager itemManager, ClientThread clientThread)
    {
        this.service = service;
        this.itemManager = itemManager;
        this.clientThread = clientThread;

        // Let the RuneLite sidebar's OUTER JScrollPane handle scrolling (like World Hopper)
        setBorder(null);
        setLayout(new DynamicGridLayout(0, 1, 0, 6));
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        setOpaque(true);

        // --- HEADER ---
        JPanel topPanel = buildHeader();
        add(topPanel);

        // --- LIST (no inner scrollpane) ---
        itemListPanel = new JPanel(new DynamicGridLayout(0, 1, 0, 6));
        itemListPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);
        itemListPanel.setOpaque(true);
        add(itemListPanel);
    }

    /**
     * When this panel is attached to the sidebar, theme the OUTER scrollpane so it’s dark/minimal.
     */
    @Override
    public void addNotify()
    {
        super.addNotify();

        JScrollPane outer = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, this);
        if (outer != null)
        {
            // Ensure the outer scrollpane is the one visible/enabled
            outer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            outer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            // Dark backgrounds
            outer.setBorder(null);
            outer.setBackground(ColorScheme.DARK_GRAY_COLOR);
            JViewport vp = outer.getViewport();
            if (vp != null)
            {
                vp.setBackground(ColorScheme.DARK_GRAY_COLOR);
                vp.setOpaque(true);
            }

            // Dark corner (bottom-right) so no white square shows
            JPanel corner = new JPanel();
            corner.setBackground(ColorScheme.DARK_GRAY_COLOR);
            outer.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, corner);

            // Minimal dark scrollbar UI
            JScrollBar vsb = outer.getVerticalScrollBar();
            if (vsb != null)
            {
                vsb.setOpaque(true);
                vsb.setBackground(ColorScheme.DARK_GRAY_COLOR);
                vsb.setUnitIncrement(16);

                vsb.setUI(new BasicScrollBarUI()
                {
                    @Override
                    protected void configureScrollBarColors()
                    {
                        // Ensure super doesn't reset things
                        super.configureScrollBarColors();
                        this.thumbColor = ColorScheme.DARKER_GRAY_COLOR;
                        this.trackColor = ColorScheme.DARK_GRAY_COLOR;
                    }

                    @Override
                    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds)
                    {
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2.setColor(ColorScheme.DARK_GRAY_COLOR);
                        g2.fillRoundRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height, 8, 8);
                        g2.dispose();
                    }

                    @Override
                    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds)
                    {
                        if (thumbBounds.isEmpty() || !scrollbar.isEnabled()) return;
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                        // Slightly lighter than track
                        g2.setColor(ColorScheme.DARKER_GRAY_COLOR);
                        int arc = 8;
                        g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, arc, arc);
                        g2.dispose();
                    }

                    @Override
                    protected JButton createDecreaseButton(int orientation)
                    {
                        return zeroButton();
                    }

                    @Override
                    protected JButton createIncreaseButton(int orientation)
                    {
                        return zeroButton();
                    }

                    private JButton zeroButton()
                    {
                        JButton b = new JButton();
                        b.setPreferredSize(new Dimension(0, 0));
                        b.setMinimumSize(new Dimension(0, 0));
                        b.setMaximumSize(new Dimension(0, 0));
                        b.setBorder(null);
                        b.setFocusable(false);
                        b.setContentAreaFilled(false);
                        return b;
                    }

                    @Override
                    protected Dimension getMinimumThumbSize()
                    {
                        // Slim, but still usable
                        return new Dimension(6, 24);
                    }

                    @Override
                    protected Dimension getMaximumThumbSize()
                    {
                        return new Dimension(6, Integer.MAX_VALUE);
                    }
                });
                // Narrow width for minimalist look
                vsb.setPreferredSize(new Dimension(8, Integer.MAX_VALUE));
            }
        }
    }

    private JPanel buildHeader()
    {
        JPanel topPanel = new JPanel(new BorderLayout(6, 0));
        topPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ColorScheme.DARKER_GRAY_COLOR));

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 4));
        controlPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);

        JLabel filterLabel = new JLabel("Filter:");
        filterLabel.setForeground(Color.WHITE);

        filterDropdown = new JComboBox<>(new String[]{"All Items", "Top Movers", "Gainers", "Losers"});
        filterDropdown.setFocusable(false);
        filterDropdown.setBackground(Color.WHITE);
        filterDropdown.setForeground(Color.BLACK);

        scanButton = new JButton("Scan Bank");
        scanButton.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        scanButton.setForeground(Color.WHITE);
        scanButton.setFocusPainted(false);
        scanButton.setBorder(BorderFactory.createLineBorder(ColorScheme.SCROLL_TRACK_COLOR));

        headerLabel = new JLabel("Showing All Items", SwingConstants.CENTER);
        headerLabel.setFont(headerLabel.getFont().deriveFont(Font.BOLD, 13f));
        headerLabel.setForeground(Color.WHITE);

        controlPanel.add(filterLabel);
        controlPanel.add(filterDropdown);
        controlPanel.add(scanButton);

        topPanel.add(controlPanel, BorderLayout.WEST);
        topPanel.add(headerLabel, BorderLayout.CENTER);

        // Listeners
        scanButton.addActionListener(e -> clientThread.invoke(this::refreshItems));
        filterDropdown.addActionListener(e -> applyFilter());

        return topPanel;
    }

    private void refreshItems()
    {
        currentItems = service.scanBank();
        applyFilter();
    }

    private void applyFilter()
    {
        if (currentItems == null || currentItems.isEmpty())
        {
            itemListPanel.removeAll();
            headerLabel.setText("No items to display");
            revalidate();
            repaint();
            return;
        }

        String selected = (String) filterDropdown.getSelectedItem();
        List<BankItem> filtered = currentItems;

        switch (selected)
        {
            case "Top Movers":
                filtered = currentItems.stream()
                        .sorted((a, b) -> Integer.compare(Math.abs(b.getDelta()), Math.abs(a.getDelta())))
                        .limit(25)
                        .collect(Collectors.toList());
                headerLabel.setText("Showing Top 25 Movers");
                break;

            case "Gainers":
                filtered = currentItems.stream()
                        .filter(i -> i.getDelta() > 0)
                        .sorted((a, b) -> Integer.compare(b.getDelta(), a.getDelta()))
                        .collect(Collectors.toList());
                headerLabel.setText("Showing Gainers");
                break;

            case "Losers":
                filtered = currentItems.stream()
                        .filter(i -> i.getDelta() < 0)
                        .sorted((a, b) -> Integer.compare(a.getDelta(), b.getDelta()))
                        .collect(Collectors.toList());
                headerLabel.setText("Showing Losers");
                break;

            default:
                headerLabel.setText("Showing All Items");
                break;
        }

        updateItemList(filtered);
    }

    private void updateItemList(List<BankItem> items)
    {
        itemListPanel.removeAll();

        for (BankItem item : items)
        {
            BufferedImage icon = itemManager.getImage(item.getId(), item.getQuantity(), false);
            BankItemPanel panel = new BankItemPanel(item, icon);
            panel.setBackground(Color.BLACK);
            itemListPanel.add(panel);
        }

        itemListPanel.revalidate();
        itemListPanel.repaint();
    }
}
