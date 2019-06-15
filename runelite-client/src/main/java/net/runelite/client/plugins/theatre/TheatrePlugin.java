/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.theatre;

import com.google.inject.Provides;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import java.util.LinkedList;
import java.util.List;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.theatre.rooms.BloatHandler;
import net.runelite.client.plugins.theatre.rooms.MaidenHandler;
import net.runelite.client.plugins.theatre.rooms.SotetsegHandler;
import net.runelite.client.plugins.theatre.rooms.VerzikHandler;
import net.runelite.client.plugins.theatre.rooms.xarpus.XarpusHandler;
import net.runelite.client.plugins.theatre.rooms.nylocas.NyloHandler;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.awt.*;

@PluginDescriptor(
	name = "Theatre of Blood",
	description = "All-in-one plugin for Theatre of Blood.",
	tags = {"ToB", "Theatre", "Theatre of Blood", "Lyzrd"},
	type = PluginType.PVM,
	enabledByDefault = false
)

public class TheatrePlugin extends Plugin 
{

	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PUBLIC)
	private TheatreRoom room;

	@Getter(AccessLevel.PUBLIC)
	private MaidenHandler maidenHandler;

	@Getter(AccessLevel.PUBLIC)
	private BloatHandler bloatHandler;

	@Getter(AccessLevel.PUBLIC)
	private NyloHandler nyloHandler;

	@Getter(AccessLevel.PUBLIC)
	private SotetsegHandler sotetsegHandler;

	@Getter(AccessLevel.PUBLIC)
	private XarpusHandler xarpusHandler;

	@Getter(AccessLevel.PUBLIC)
	private VerzikHandler verzikHandler;

	@Inject
	private Client client;

	private Widget widget = null;

	@Getter(AccessLevel.PUBLIC)
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TheatreOverlay overlay;

	@Inject
	private TheatreConfig config;

	@Provides
	TheatreConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TheatreConfig.class);
	}

	@Override
	protected void startUp()
	{
		room = TheatreRoom.UNKNOWN;

		maidenHandler = new MaidenHandler(client, this, config);
		bloatHandler = new BloatHandler(client, this, config);
		nyloHandler = new NyloHandler(client, this, config);
		sotetsegHandler = new SotetsegHandler(client, this, config);
		xarpusHandler = new XarpusHandler(client, this, config);
		verzikHandler = new VerzikHandler(client, this, config);

		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		maidenHandler.onStop();
		maidenHandler = null;

		bloatHandler.onStop();
		bloatHandler = null;

		nyloHandler.startTime = 0L;
		nyloHandler.onStop();
		nyloHandler = null;

		sotetsegHandler.onStop();
		sotetsegHandler = null;

		xarpusHandler.onStop();
		xarpusHandler = null;

		verzikHandler.onStop();
		verzikHandler = null;

		room = TheatreRoom.UNKNOWN;

		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		if (maidenHandler != null)
			maidenHandler.onNpcSpawned(event);

		if (bloatHandler != null)
			bloatHandler.onNpcSpawned(event);

		if (nyloHandler != null)
			nyloHandler.onNpcSpawned(event);

		if (sotetsegHandler != null)
			sotetsegHandler.onNpcSpawned(event);

		if (xarpusHandler != null)
			xarpusHandler.onNpcSpawned(event);

		if (verzikHandler != null)
			verzikHandler.onNpcSpawned(event);

	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		if (maidenHandler != null)
			maidenHandler.onNpcDespawned(event);

		if (bloatHandler != null)
			bloatHandler.onNpcDespawned(event);

		if (nyloHandler != null)
			nyloHandler.onNpcDespawned(event);

		if (sotetsegHandler != null)
			sotetsegHandler.onNpcDespawned(event);

		if (xarpusHandler != null)
			xarpusHandler.onNpcDespawned(event);

	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		if (verzikHandler != null)
			verzikHandler.onAnimationChanged(event);
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() != WidgetID.PERFORMERS_FOR_THE_THEATRE_GROUPS_GROUP_ID && event.getGroupId() != WidgetID.PERFORMERS_FOR_THE_THEATRE_PLAYERS_GROUP_ID)
		{
			return;
		}

		if (event.getGroupId() == WidgetID.PERFORMERS_FOR_THE_THEATRE_GROUPS_GROUP_ID)
		{
			widget = client.getWidget(WidgetID.PERFORMERS_FOR_THE_THEATRE_GROUPS_GROUP_ID, 0);
		}

		if (event.getGroupId() == WidgetID.PERFORMERS_FOR_THE_THEATRE_PLAYERS_GROUP_ID)
		{
			widget = client.getWidget(WidgetID.PERFORMERS_FOR_THE_THEATRE_PLAYERS_GROUP_ID, 0);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (maidenHandler != null)
			maidenHandler.onGameTick();

		if (bloatHandler != null)
			bloatHandler.onGameTick();

		if (nyloHandler != null)
			nyloHandler.onGameTick();

		if (sotetsegHandler != null)
			sotetsegHandler.onGameTick();

		if (xarpusHandler != null)
			xarpusHandler.onGameTick();

		if (verzikHandler != null)
			verzikHandler.onGameTick();

		if (widget == null)
		{
			return;
		}

		// recheck if the widget is still active
		int p_id = WidgetInfo.TO_GROUP(widget.getId());

		List<Widget> widgetList = new LinkedList<>();

		if (p_id == WidgetID.PERFORMERS_FOR_THE_THEATRE_GROUPS_GROUP_ID)
		{
			Widget w = client.getWidget(p_id, 16);
			if (w == null)
			{
				return;
			}

			Widget[] ws = w.getStaticChildren();
			for (Widget widget : ws)
			{
				Widget[] widgets = widget.getDynamicChildren();
				if (widgets.length > 3)
				{
					widgetList.add(widgets[3]);
				}
			}

		}
		else if (p_id == WidgetID.PERFORMERS_FOR_THE_THEATRE_PLAYERS_GROUP_ID)
		{
			Widget w1 = client.getWidget(p_id, 26);

			if (w1 != null)
			{
				Widget[] dChildsAccepted = w1.getDynamicChildren();

				if (dChildsAccepted.length > 2)
				{
					for (int i = 1; i < dChildsAccepted.length; i += 11)
					{
						if (!dChildsAccepted[i].getText().equals("-"))
						{
							widgetList.add(dChildsAccepted[i]);
						}
					}
				}
			}

			Widget w2 = client.getWidget(p_id, 41);

			if (w2 != null)
			{
				Widget[] dChildsApplied = w2.getDynamicChildren();

				if (dChildsApplied.length > 2)
				{
					for (int i = 1; i < dChildsApplied.length; i += 11)
					{
						if (!dChildsApplied[i].getText().equals("-"))
						{
							widgetList.add(dChildsApplied[i]);
						}
					}
				}
			}
		}

		for (Widget w : widgetList)
		{
			String wtext = w.getText();
			if (client.isFriended(wtext, false))
			{
				w.setTextColor(Color.green.getRGB());
				continue;
			}
			for (int i = 0; i < client.getIgnoreCount(); i++)
			{
				String name = client.getIgnores()[i].getName();
				if (name.replace('\u00A0', ' ').equals(wtext))
				{
					w.setTextColor(Color.red.getRGB());
					break;
				}
			}
		}

		widget = null;
	}

	@Subscribe
	public void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		if (sotetsegHandler != null)
			sotetsegHandler.onGroundObjectSpawned(event);

		if (xarpusHandler != null)
			xarpusHandler.onGroundObjectSpawned(event);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (nyloHandler != null)
			nyloHandler.onConfigChanged();
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		if (bloatHandler != null)
			bloatHandler.onVarbitChanged(event);

		if (xarpusHandler != null)
			xarpusHandler.onVarbitChanged(event);
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		if (sotetsegHandler != null)
		{
			sotetsegHandler.onProjectileMoved(event);

		}
		if (verzikHandler != null)
		{
			verzikHandler.onProjectileMoved(event);
		}
	}
}