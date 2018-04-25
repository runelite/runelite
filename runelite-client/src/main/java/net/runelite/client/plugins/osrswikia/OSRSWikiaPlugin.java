package net.runelite.client.plugins.osrswikia;

import com.google.common.eventbus.Subscribe;
import java.net.HttpURLConnection;
import java.net.URL;
import net.runelite.api.events.CommandExecuted;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.LinkBrowser;

@PluginDescriptor(
	name = "OSRS Wikia",
	enabledByDefault = false
)
public class OSRSWikiaPlugin extends Plugin
{
	private final String BASEURI = "https://oldschoolrunescape.wikia.com/wiki";

	@Subscribe
	public void onCommand(CommandExecuted commandExecuted)
	{
		if (!commandExecuted.getCommand().toLowerCase().equals("wiki"))
		{
			return;
		}

		String browseURI = BASEURI;
		String[] args = commandExecuted.getArguments();

		// empty query after ::wiki should just take user to osrs wikia home
		if (args.length == 0)
		{
			LinkBrowser.browse(browseURI);
			return;
		}

		String directPageQuery = browseURI + "/" + String.join("%20", args);
		int statusCode = getStatusCode(directPageQuery);

		if (statusCode != 200)
		{
			browseURI += "/Special:Search?query=" + String.join("+", args);
		}
		else
		{
			browseURI = directPageQuery;
		}

		LinkBrowser.browse(browseURI);
	}

	private int getStatusCode(String address)
	{
		try
		{
			URL url = new URL(address);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			return http.getResponseCode();
		}
		catch (java.io.IOException e)
		{
			e.printStackTrace();
			return -1;
		}
	}
}
