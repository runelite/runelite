package net.runelite.client.plugins.osrswikia;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.events.CommandExecuted;
import net.runelite.client.util.LinkBrowser;

import javax.inject.Inject;

@PluginDescriptor(
        name = "OSRS Wikia",
        enabledByDefault = false
)
public class OSRSWikiaPlugin extends Plugin {
    private final String BASEURI = "http://oldschoolrunescape.wikia.com/wiki";
    
    @Inject
    private OSRSWikiaConfig config;
    
    @Provides
    OSRSWikiaConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(OSRSWikiaConfig.class);
    }
    
    @Subscribe
    public void onCommand(CommandExecuted commandExecuted) {
        if(!commandExecuted.getCommand().equals("wiki") || !config.allowWikiCommand())
            return;
    
        String browseURI = BASEURI;
        String searchQuery = String.join("+", commandExecuted.getArguments());
    
        // empty query after ::wiki should just take user to osrs wikia home
        if(searchQuery.trim().length() > 0) {
            browseURI += "/Special:Search?query=" + searchQuery;
        }
    
        LinkBrowser.browse(browseURI);
    }
}
