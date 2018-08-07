/*
 * Copyright (c) 2018, Psikoi <https://github.com/Psikoi>
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
package net.runelite.client.plugins.worldswitcher;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.http.api.worlds.World;

@PluginDescriptor(
	name = "World Switcher",
	description = "", //TODO fill later
	tags = {""} //TODO fill later
)
@Slf4j
public class WorldSwitcherPlugin extends Plugin
{
	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private Client client;

	private NavigationButton navButton;
	private WorldSwitcherPanel panel;

	@Override
	protected void startUp() throws Exception
	{

		panel = new WorldSwitcherPanel(this);

		final BufferedImage icon;
		synchronized (ImageIO.class)
		{
			icon = ImageIO.read(WorldSwitcherPlugin.class.getResourceAsStream("icon.png"));
		}

		navButton = NavigationButton.builder()
			.tooltip("World Switcher")
			.icon(icon)
			.priority(3)
			.panel(panel)
			.build();

		clientToolbar.addNavigation(navButton);
	}

	public boolean isFavorite(World world)
	{
		return true; //TODO
	}

	public int getCurrentWorld()
	{
		return client.getWorld();
	}

	public void hopTo(World world)
	{
		System.out.println("Hopping to " + world.getId()); // TODO
	}

	public void addToFavorites(World world)
	{
		System.out.println("Add world " + world.getId() + " to favorites"); // TODO
	}

	public void removeFromFavorites(World world)
	{
		System.out.println("Remove world " + world.getId() + " from favorites"); // TODO
	}

	@Override
	protected void shutDown()
	{
		clientToolbar.removeNavigation(navButton);
	}
}
