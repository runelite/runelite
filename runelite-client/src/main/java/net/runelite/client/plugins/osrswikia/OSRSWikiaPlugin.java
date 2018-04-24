package net.runelite.client.plugins.osrswikia;

import com.google.common.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.events.CommandExecuted;
import net.runelite.client.util.LinkBrowser;

@PluginDescriptor(
	name = "OSRS Wikia",
	enabledByDefault = false
)
public class OSRSWikiaPlugin extends Plugin
{
	private final String BASEURI = "http://oldschoolrunescape.wikia.com/wiki";

	@Subscribe
	public void onCommand(CommandExecuted commandExecuted)
	{
		if (!commandExecuted.getCommand().toLowerCase().equals("wiki"))
		{
			return;
		}

		String browseURI = BASEURI;
		String searchQuery = String.join("+", commandExecuted.getArguments());

		// empty query after ::wiki should just take user to osrs wikia home
		if (searchQuery.trim().length() > 0)
		{
			browseURI += "/Special:Search?query=" + searchQuery;
		}

		LinkBrowser.browse(browseURI);
	}
}
