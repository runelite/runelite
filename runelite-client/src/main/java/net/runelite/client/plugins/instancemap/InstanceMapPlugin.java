/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.instancemap;

import static net.runelite.api.widgets.WidgetInfo.WORLD_MAP;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import javax.inject.Inject;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MapRegionChanged;
import net.runelite.api.events.WidgetMenuOptionClicked;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.menus.WidgetMenuOption;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
	name = "Instance Map"
)
public class InstanceMapPlugin extends Plugin
{
	private final WidgetMenuOption openMapOption = new WidgetMenuOption("Show", "Instance Map", WidgetInfo.WORLD_MAP);
	private final WidgetMenuOption ascendOption = new WidgetMenuOption("Ascend", "Instance Map", WidgetInfo.WORLD_MAP);
	private final WidgetMenuOption descendOption = new WidgetMenuOption("Descend", "Instance Map", WidgetInfo.WORLD_MAP);

	@Inject
	private InstanceMapOverlay overlay;

	@Inject
	private MenuManager menuManager;

	@Override
	public void configure(Binder binder)
	{
		binder.bind(InstanceMapOverlay.class);
	}

	private void addCustomOptions()
	{
		menuManager.addManagedCustomMenu(openMapOption);
		menuManager.addManagedCustomMenu(descendOption);
		menuManager.addManagedCustomMenu(ascendOption);
	}

	private void removeCustomOptions()
	{
		menuManager.removeManagedCustomMenu(openMapOption);
		menuManager.removeManagedCustomMenu(descendOption);
		menuManager.removeManagedCustomMenu(ascendOption);
	}

	@Override
	protected void startUp() throws Exception
	{
		addCustomOptions();
	}

	@Override
	protected void shutDown() throws Exception
	{
		removeCustomOptions();
	}

	@Subscribe
	public void regionChange(MapRegionChanged event)
	{
		overlay.onRegionChange(event);
	}

	@Subscribe
	public void gameStateChange(GameStateChanged event)
	{
		overlay.onGameStateChange(event);
	}

	private boolean clickedOptionEquals(WidgetMenuOptionClicked event, WidgetMenuOption widgetMenuOption)
	{
		return event.getMenuOption().equals(widgetMenuOption.getMenuOption()) && event.getMenuTarget().equals(widgetMenuOption.getMenuTarget());
	}

	@Subscribe
	public void onWidgetMenuOptionClicked(WidgetMenuOptionClicked event)
	{
		if (event.getWidget() != WORLD_MAP)
		{
			return;
		}

		if (clickedOptionEquals(event, openMapOption))
		{
			overlay.setShowMap(!overlay.isMapShown());

			if (overlay.isMapShown())
			{
				openMapOption.setMenuOption("Hide");
			}
			else
			{
				openMapOption.setMenuOption("Show");
			}
		}
		else if (clickedOptionEquals(event, ascendOption))
		{
			overlay.onAscend();
		}
		else if (clickedOptionEquals(event, descendOption))
		{
			overlay.onDescend();
		}
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}
}
