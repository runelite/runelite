/*
 * Copyright (c) 2026 zom
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
package net.runelite.client.plugins.worldmap;

import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import org.apache.commons.lang3.ArrayUtils;

@Singleton
public class WorldMapSearch
{
	private final Client client;
	private final ClientThread clientThread;

	@Inject
	private WorldMapSearch(
		final Client client,
		final ClientThread clientThread
	)
	{
		this.client = client;
		this.clientThread = clientThread;
	}

	public void initSearch()
	{
		clientThread.invoke(() ->
		{
			Widget searchContainer = client.getWidget(InterfaceID.Worldmap.SEARCH);
			if (searchContainer == null || searchContainer.isHidden())
			{
				return;
			}

			Widget searchContainerOps = searchContainer.getChild(0);

			if (searchContainerOps == null || searchContainerOps.isHidden())
			{
				return;
			}

			Object[] worldMapSearchBuildArgs = searchContainerOps.getOnOpListener();
			if (worldMapSearchBuildArgs == null)
			{
				return;
			}

			// the search toggle script requires 1 as its first argument
			Object[] searchToggleArgs = ArrayUtils.insert(1, worldMapSearchBuildArgs);
			searchToggleArgs[0] = ScriptID.WORLDMAP_SEARCH_START;

			client.runScript(searchToggleArgs);
		});
	}
}
