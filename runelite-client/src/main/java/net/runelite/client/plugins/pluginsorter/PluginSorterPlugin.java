package net.runelite.client.plugins.pluginsorter;

import com.google.inject.Provides;
import net.runelite.api.GameState;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigItemDescriptor;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.config.ConfigPanel;
import net.runelite.client.plugins.config.PluginListItem;

import javax.inject.Inject;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@PluginDescriptor(
        name = "Plugin Organizer",
        description = "Hides and colors 3rd party plugins for better control",
        tags = {"Fuck RL","Abex is shit :p"},
        type = PluginType.PLUGIN_ORGANIZER
)
public class PluginSorterPlugin extends Plugin {

    //Cache the hidden plugins
    public static List<PluginListItem> removedPlugins = new ArrayList<>();

    @Inject
    private PluginSorterConfig config;

    @Provides
    PluginSorterConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(PluginSorterConfig.class);
    }

    @Override
    protected void startUp() throws Exception
    {
        updateColors();
    }

    @Override
    protected void shutDown() throws Exception
    {

    }

    @Subscribe
    public void onGameStateChanged (GameStateChanged gameStateChanged)
    {
        if (gameStateChanged.getGameState()== GameState.LOGIN_SCREEN) {
            if (config.hidePlugins())
                hidePlugins();
            updateColors();
        }
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged configChanged) {
        if (configChanged.getKey().equals("hidePlugins")) {
            if (config.hidePlugins()) {
                hidePlugins();
            } else {
                showPlugins();
            }
        }
        updateColors();
    }

    public void updateColors() {
        for (PluginListItem pli : ConfigPanel.pluginList) {
            if (pli.getPlugin()!=null) {
                if (pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type()!=null)
                    switch (pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type()) {
                        case EXTERNAL:
                            pli.nameLabel.setForeground(config.externalColor());
                            break;
                        case PVM:
                            pli.nameLabel.setForeground(config.pvmColor());
                            break;
                        case PVP:
                            pli.nameLabel.setForeground(config.pvpColor());
                            break;
                        case UTILITY:
                            pli.nameLabel.setForeground(config.utilityColor());
                            break;
                        default:
                            pli.nameLabel.setForeground(Color.WHITE);
                            break;
                    }
            }
        }
    }

    public void hidePlugins() {
        Iterator<PluginListItem> iter = ConfigPanel.pluginList.iterator();
        while (iter.hasNext()) {
            PluginListItem pli = iter.next();
            if (pli.getPlugin() != null) {
                if (!pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type().equals(""))
                    if (pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type().equals("external")) {
                        iter.remove();
                        removedPlugins.add(pli);
                    }
                if (!pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type().equals(""))
                    if (pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type().equals("PVM")) {
                        iter.remove();
                        removedPlugins.add(pli);
                    }
                if (!pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type().equals(""))
                    if (pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type().equals("PVP")) {
                        iter.remove();
                        removedPlugins.add(pli);
                    }
                if (!pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type().equals(""))
                    if (pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type().equals("utility")) {
                        iter.remove();
                        removedPlugins.add(pli);
                    }
            }
        }
    }

    public void showPlugins() {
        List<PluginListItem> tempList = new ArrayList<>();
        for (PluginListItem pli : removedPlugins) {
            tempList.add(pli);
        }
        for (PluginListItem pli : ConfigPanel.pluginList) {
            tempList.add(pli);
        }
        ConfigPanel.pluginList = tempList;
    }
}
