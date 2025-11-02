package net.runelite.client.plugins.bankwatcher;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.image.BufferedImage;

@Slf4j
@PluginDescriptor(
        name = "Bank Watcher",
        description = "View and scan your bank for valuable items",
        tags = {"bank", "tracker", "ge", "price"}
)
public class BankWatcherPlugin extends Plugin
{
    @Inject
    private ClientToolbar clientToolbar;

    @Inject
    private BankWatcherPanel bankWatcherPanel;

    private NavigationButton navButton;

    @Override
    protected void startUp() throws Exception
    {
        log.info("Bank Watcher plugin started");

        // You can replace this with your own icon later
        final BufferedImage icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);

        navButton = NavigationButton.builder()
                .tooltip("Bank Watcher")
                .icon(icon)
                .priority(5)
                .panel(bankWatcherPanel)
                .build();

        clientToolbar.addNavigation(navButton);
    }

    @Override
    protected void shutDown() throws Exception
    {
        clientToolbar.removeNavigation(navButton);
        log.info("Bank Watcher plugin has stopped");
    }
}
