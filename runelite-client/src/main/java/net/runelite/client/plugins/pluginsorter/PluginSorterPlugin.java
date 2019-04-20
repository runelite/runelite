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
        type = "pluginOrganizer"
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
                    if (pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type().equals("PVM"))
                        pli.nameLabel.setForeground(config.pvmColor());
                    else if (pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type().equals("PVP"))
                        pli.nameLabel.setForeground(config.pvpColor());
                    else if (pli.getPlugin().getClass().getAnnotation(PluginDescriptor.class).type().equals("utility"))
                        pli.nameLabel.setForeground(config.utilityColor());
                    else
                        pli.nameLabel.setForeground(Color.WHITE);
            }
        }
    }

    public void hidePlugins() {
        Iterator<PluginListItem> iter = ConfigPanel.pluginList.iterator();
        while (iter.hasNext()) {
            PluginListItem pli = iter.next();
            if (pli.getPlugin() != null)
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
