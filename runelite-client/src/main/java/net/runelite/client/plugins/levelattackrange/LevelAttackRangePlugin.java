package net.runelite.client.plugins.levelattackrange;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import javax.inject.Inject;

@Slf4j
@PluginDescriptor(name = "Level Attack Range")
public class LevelAttackRangePlugin extends Plugin
{
	@Inject
	private Client client;

	@Subscribe
	public void onScriptEvent(ScriptCallbackEvent event)
	{
		String eventName = event.getEventName();

		int[] intStack = client.getIntStack();
		int intStackSize = client.getIntStackSize();

		switch (eventName)
		{
			case "levelAttackRangeActive":
				// let the script know the plugin is active
				intStack[intStackSize - 1] = 1;
				break;
			case "loadCombatLevel":
				// load the local player combat level
				intStack[intStackSize - 1] = client.getLocalPlayer().getCombatLevel();
				break;
		}
	}

}
