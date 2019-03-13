package net.runelite.client.plugins.remotebankcontents;

import com.google.inject.Provides;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@PluginDescriptor(
        name = "Remote Bank Contents",
        description = "View how many of inventory items you have in your bank.",
        tags = {"remotebankcontents", "skilling", "combat", "utility"}
)

public class RemoteBankContentsPlugin extends Plugin {

    @Inject
    private RemoteBankContentsProcess remoteBankContentsProcess;

    @Inject
    private RemoteBankContentsOverlay overlay;

    @Inject
    private OverlayManager overlayManager;

    @Inject
    private RemoteBankContentsConfig config;

    @Provides
    RemoteBankContentsConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(RemoteBankContentsConfig.class);
    }

    @Override
    protected void startUp() throws Exception {
        overlayManager.add(overlay);

        //pass a reference to the remoteBankContentsProcess which has the hashmap in to make sure that both classes use the same hashmap
        overlay.setRemoteBankContentsProcess(remoteBankContentsProcess);
    }


    @Subscribe
    public void onItemContainerChanged(ItemContainerChanged event) {
        remoteBankContentsProcess.populateBankItemMap();
    }

    @Subscribe
    public void onScriptCallbackEvent(ScriptCallbackEvent event) {

        //only run this if the bank is open
        if (!event.getEventName().equals("setBankTitle")) {
            return;
        }

        //populate the hashmap with all of the items from the bank
        remoteBankContentsProcess.populateBankItemMap();

    }

    @Subscribe
    public void onMenuOptionClicked(MenuOptionClicked event) {

        //only run this if the examine option in the configuration is checked
        if (config.examine()) {
            remoteBankContentsProcess.outputExamine(event);
        }
    }

}






