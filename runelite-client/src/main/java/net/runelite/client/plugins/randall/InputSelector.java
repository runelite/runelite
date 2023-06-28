package net.runelite.client.plugins.randall;

import net.runelite.client.plugins.randall.event.EventHandler;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;

public class InputSelector {

    private static final BufferedImage ENABLED_IMAGE, DISABLED_IMAGE;

    static {
        ENABLED_IMAGE = ImageUtil.loadImageResource(net.runelite.client.plugins.randall.RandallPlugin.class, "enabled_small.png");
        DISABLED_IMAGE = ImageUtil.loadImageResource(net.runelite.client.plugins.randall.RandallPlugin.class, "disabled_small.png");
    }

    private final ClientToolbar clientToolbar;
    private NavigationButton enableButton;
    private NavigationButton disableButton;

    public InputSelector(ClientToolbar clientToolbar) {
        this.clientToolbar = clientToolbar;
    }

    protected void startUp() throws Exception {
        enableButton = NavigationButton.builder().tab(false).icon(ENABLED_IMAGE).tooltip("Enable Input").onClick(this::enableClick).build();

        disableButton = NavigationButton.builder().tab(false).icon(DISABLED_IMAGE).tooltip("Disable Input").onClick(this::disableClick).build();

        addAndRemoveButtons();
    }


    protected void shutDown() throws Exception {
        clientToolbar.removeNavigation(enableButton);
        clientToolbar.removeNavigation(disableButton);
    }

    private void addAndRemoveButtons() {
        this.clientToolbar.removeNavigation(enableButton);
        this.clientToolbar.removeNavigation(disableButton);
        this.clientToolbar.addNavigation(EventHandler.isBlocking() ? enableButton : disableButton);
    }

    public void enableClick() {
        EventHandler.setBlocking(false);
        addAndRemoveButtons();
    }

    public void disableClick() {
        EventHandler.setBlocking(true);
        addAndRemoveButtons();
    }
}
