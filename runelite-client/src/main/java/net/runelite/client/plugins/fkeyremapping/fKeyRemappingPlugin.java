package net.runelite.client.plugins.fkeyremapping;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.VarClientInt;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
        name = "fKeyRemapping",
        description = "Used for interface hotkeys",
        tags = {"hotkey", "remapping"},
		    type = "utility",
        enabledByDefault = true
)
public class fKeyRemappingPlugin extends Plugin
{
    @Inject
    private Client client;

    @Inject
    private ClientThread clientThread;

    @Inject
    private KeyManager keyManager;

    @Inject
    private fKeyRemappingListener inputListener;


    @Override
    protected void startUp() throws Exception
    {
        keyManager.registerKeyListener(inputListener);


    }

    @Override
    protected void shutDown() throws Exception
    {


        keyManager.unregisterKeyListener(inputListener);
    }

    @Provides
    fKeyRemappingConfig getConfig(ConfigManager configManager)
    {
        return configManager.getConfig(fKeyRemappingConfig.class);
    }

    boolean chatboxFocused()
    {
        Widget chatboxParent = client.getWidget(WidgetInfo.CHATBOX_PARENT);
        if (chatboxParent == null || chatboxParent.getOnKeyListener() == null)
        {
            return false;
        }

        // the search box on the world map can be focused, and chat input goes there, even
        // though the chatbox still has its key listener.
        Widget worldMapSearch = client.getWidget(WidgetInfo.WORLD_MAP_SEARCH);
        if (worldMapSearch != null && client.getVar(VarClientInt.WORLD_MAP_SEARCH_FOCUSED) == 1)
        {
            return false;
        }

        return true;
    }







}
