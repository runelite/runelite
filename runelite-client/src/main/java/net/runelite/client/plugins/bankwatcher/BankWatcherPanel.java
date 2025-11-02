package net.runelite.client.plugins.bankwatcher;

import net.runelite.client.callback.ClientThread;
import net.runelite.client.ui.PluginPanel;
import javax.inject.Inject;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BankWatcherPanel extends PluginPanel
{
    private final JButton scanButton;
    private final JPanel itemListPanel;

    @Inject
    private BankWatcherService bankWatcherService;

    @Inject
    private ClientThread clientThread;

    public BankWatcherPanel()
    {
        setLayout(new BorderLayout());

        scanButton = new JButton("Scan Bank");
        add(scanButton, BorderLayout.NORTH);

        itemListPanel = new JPanel();
        itemListPanel.setLayout(new BoxLayout(itemListPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(itemListPanel);
        add(scrollPane, BorderLayout.CENTER);

        scanButton.addActionListener(e ->
        {
            // Run on the RuneLite client thread to avoid IllegalStateException
            clientThread.invokeLater(() -> {
                List<BankItem> trackedItems = bankWatcherService.scanBank();
                SwingUtilities.invokeLater(() -> updateItems(trackedItems));
            });
        });
    }

    private void updateItems(List<BankItem> trackedItems)
    {
        itemListPanel.removeAll();

        for (BankItem item : trackedItems)
        {
            BankItemPanel itemPanel = new BankItemPanel(item, null);
            itemListPanel.add(itemPanel);
        }

        itemListPanel.revalidate();
        itemListPanel.repaint();
    }
}
