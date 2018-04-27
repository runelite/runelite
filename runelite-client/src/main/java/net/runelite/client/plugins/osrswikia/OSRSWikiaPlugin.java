/*
 * Copyright (c) 2018, Grant <grant.dellar@live.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.osrswikia;

import com.google.common.eventbus.Subscribe;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.stream.IntStream;
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
	private final String BASEURI = "http://oldschoolrunescape.wikia.com/wiki";
	private final int[] VALID_STATUS_CODES = {200, 302};

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

		boolean forceSearch = false;
		String lastArgItem = args[args.length - 1].toLowerCase();

		if (lastArgItem.equals("-s") ||
			lastArgItem.equals("-search"))
		{
			forceSearch = true;
			args = Arrays.copyOfRange(args, 0, args.length - 1);
		}

		String directPageQuery = browseURI + "/" + String.join("%20", args);
		int statusCode = getStatusCode(directPageQuery);

		if (forceSearch || IntStream.of(VALID_STATUS_CODES).noneMatch(x -> x == statusCode))
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
