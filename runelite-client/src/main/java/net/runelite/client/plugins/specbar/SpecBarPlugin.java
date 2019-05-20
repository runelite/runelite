package net.runelite.client.plugins.specbar;

import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;

@PluginDescriptor(
	name = "Spec Bar",
	description = "Adds a spec bar to every weapon",
	tags = {"spec bar", "special attack", "spec", "bar", "pklite"},
	enabledByDefault = false,
	type = PluginType.PVP
)
public class SpecBarPlugin extends Plugin
{

	@Inject
	private Client client;

	@Override
	protected void startUp() throws Exception
	{
	}

	@Override
	protected void shutDown() throws Exception
	{
	}

	@Subscribe
	private void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		if (WidgetInfo.TO_GROUP(event.getWidget().getId()) == WidgetID.COMBAT_GROUP_ID)
		{
			hideSpecBar();
		}
	}

	@Subscribe
	private void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState().equals(GameState.LOGGING_IN))
		{
			hideSpecBar();
		}

	}

	/**
	 * Displays the special attack bar
	 */
	private void hideSpecBar()
	{
		try
		{
			Widget specBar = client.getWidget(WidgetInfo.COMBAT_SPECIAL_ATTACK);
			specBar.setHidden(false);
			specBar.revalidate();
		}
		catch (NullPointerException e)
		{
			// Stops the nulls that occur before the spec bar is loaded by player equipping a spec wep
		}
	}
}
