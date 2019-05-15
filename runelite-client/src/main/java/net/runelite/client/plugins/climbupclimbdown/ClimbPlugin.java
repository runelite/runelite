package net.runelite.client.plugins.climbupclimbdown;

import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;

@PluginDescriptor(
	name = "Climb Up Climb Down",
	description = "Hold Shift to Climb up, Ctrl to Climb down",
	tags = {"climb", "stairs", "ladder", "swap", "key", "input"},
	type = PluginType.UTILITY
)
@Slf4j
@Singleton
public class ClimbPlugin extends Plugin
{

	@Inject
	Client client;

	@Inject
	KeyManager keyManager;

	@Inject
	ShiftCtrlInputListener inputListener;

	@Getter
	@Setter
	private boolean isHoldingShift;

	@Getter
	@Setter
	private boolean isHoldingCtrl;

	@Override
	protected void startUp() throws Exception
	{
		enableCustomization();
	}

	@Override
	protected void shutDown() throws Exception
	{
		disableCustomization();
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded menuEntryAdded)
	{
		try
		{
			if (menuEntryAdded.getOption().equalsIgnoreCase("climb"))
			{
				if (isHoldingCtrl ^ isHoldingShift)
				{
					if (isHoldingShift)
					{
						stripExceptFor("climb-up");
					}
					if (isHoldingCtrl)
					{
						stripExceptFor("climb-down");
					}
				}
			}
		}
		catch (Exception e)
		{
			log.error("Uh oh!", e);
		}
	}


	private void enableCustomization()
	{
		keyManager.registerKeyListener(inputListener);
	}

	private void disableCustomization()
	{
		keyManager.unregisterKeyListener(inputListener);
	}

	private void stripExceptFor(String option)
	{
		MenuEntry[] newEntries = new MenuEntry[1];

		for (MenuEntry entry : client.getMenuEntries())
		{
			if (entry.getOption().equalsIgnoreCase(option))
			{
				newEntries[0] = entry;
			}
		}

		if (newEntries[0] != null)
		{
			client.setMenuEntries(newEntries);
		}
	}
}
