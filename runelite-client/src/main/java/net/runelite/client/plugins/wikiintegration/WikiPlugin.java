package net.runelite.client.plugins.wikiintegration;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.LinkBrowser;
import javax.inject.Inject;


@Slf4j
@PluginDescriptor(
        name = "OSRS Wiki Integration",
        description = "Search OSRS Wiki for selected NPC",
        tags = {"actions", "wiki"}
)
public class WikiPlugin extends Plugin {

    @Inject
    private MenuManager menuManager;

    private static final String WIKI = "Wiki";

    @Inject
    private Client client;

    @Override
    protected void startUp()
    {
        menuManager.addNpcMenuOption(WIKI);
    }

    @Override
    protected void shutDown() throws Exception
    {
        menuManager.removeNpcMenuOption(WIKI);
    }

    private String buildWikiURL(String gameObject) {

        String baseURL = "http://oldschoolrunescape.wikia.com/wiki/Special:Search?query=";

        try
        {
            return baseURL + URLEncoder.encode(gameObject, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            log.debug(e.getMessage());
            return baseURL + gameObject;
        }
    }


    @Subscribe
    public void onWikiMenuClicked(MenuOptionClicked event)
    {
        if (event.getMenuOption().equals(WIKI))
        {
            LinkBrowser.browse(buildWikiURL(event.getMenuTarget()));
        }
    }

}
