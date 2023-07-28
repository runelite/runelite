package net.runelite.client.plugins.alfred.event;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.alfred.Alfred;
import net.runelite.client.plugins.alfred.AlfredPlugin;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;

@Slf4j
public class EventSelector {

    private static final BufferedImage ENABLED_IMAGE, DISABLED_IMAGE;

    static {
        ENABLED_IMAGE = ImageUtil.loadImageResource(AlfredPlugin.class, "enabled_small.png");
        DISABLED_IMAGE = ImageUtil.loadImageResource(AlfredPlugin.class, "disabled_small.png");
    }

    private final ClientToolbar clientToolbar;
    private NavigationButton enableButton;
    private NavigationButton disableButton;

    public EventSelector(ClientToolbar clientToolbar) {
        log.info("Alfred is trying to add some buttons for you.");
        this.clientToolbar = clientToolbar;
    }

    public void startUp() {
        enableButton = NavigationButton.builder().tab(false).icon(ENABLED_IMAGE).tooltip("Enable Input").onClick(this::enableClick).build();
        disableButton = NavigationButton.builder().tab(false).icon(DISABLED_IMAGE).tooltip("Disable Input").onClick(this::disableClick).build();
        addAndRemoveButtons();
    }


    public void shutDown() {
        clientToolbar.removeNavigation(enableButton);
        clientToolbar.removeNavigation(disableButton);
    }

    private void addAndRemoveButtons() {
        clientToolbar.removeNavigation(enableButton);
        clientToolbar.removeNavigation(disableButton);
        clientToolbar.addNavigation(Alfred.getEventHandler().isBlocked() ? enableButton : disableButton);
    }

    public void enableClick() {
        Alfred.getEventHandler().setBlocked(false);
        addAndRemoveButtons();
    }

    public void disableClick() {
        Alfred.getEventHandler().setBlocked(true);
        addAndRemoveButtons();
    }
}
