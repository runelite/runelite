/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Good luck on your raids!
 */

package net.runelite.client.plugins.theatre;

import com.google.inject.Provides;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.NpcDefinitionChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.events.SpotAnimationChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.graphics.ModelOutlineRenderer;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.theatre.rooms.BloatHandler;
import net.runelite.client.plugins.theatre.rooms.MaidenHandler;
import net.runelite.client.plugins.theatre.rooms.SotetsegHandler;
import net.runelite.client.plugins.theatre.rooms.VerzikHandler;
import net.runelite.client.plugins.theatre.rooms.nylocas.NyloHandler;
import net.runelite.client.plugins.theatre.rooms.xarpus.XarpusHandler;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Theatre of Blood",
	description = "All-in-one plugin for Theatre of Blood.",
	tags = {"ToB", "Theatre", "Theatre of Blood", "Lyzrd"},
	type = PluginType.PVM,
	enabledByDefault = false
)
@Singleton
@Slf4j
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

	@Inject
	private EventBus eventBus;

	private Widget widget = null;

	@Getter(AccessLevel.PUBLIC)
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TheatreOverlay overlay;

	@Inject
	private TheatreConfig config;

	@Inject
	private ModelOutlineRenderer modelOutline;

	@Getter
	private boolean showMaidenBloodToss;
	@Getter
	private boolean showMaidenBloodSpawns;
	@Getter
	private boolean showNyloFreezeHighlights;
	@Getter
	private boolean showBloatIndicator;
	@Getter
	private boolean showBloatHands;
	@Getter
	private boolean BloatFeetIndicatorRaveEdition;
	@Getter
	private boolean showBloatTimer;
	@Getter
	private boolean showNyloPillarHealth;
	@Getter
	private TheatreConfig.NYLOOPTION showNylocasExplosions;
	@Getter
	private boolean showNylocasAmount;
	@Getter
	private boolean highlightNyloAgros;
	@Getter
	private boolean showSotetsegAttacks;
	@Getter
	private boolean showSotetsegMaze;
	@Getter
	private boolean showSotetsegSolo;
	@Getter
	private Color mazeTileColour;
	@Getter
	private boolean showXarpusHeals;
	@Getter
	private boolean showXarpusTick;
	@Getter
	private boolean showVerzikAttacks;
	@Getter
	private boolean showVerzikYellows;
	@Getter
	private boolean showCrabTargets;
	@Getter
	private boolean VerzikTankTile;
	@Getter
	private boolean verzikRangeAttacks;
	@Getter
	private boolean extraTimers;
	@Getter
	private boolean p1attacks;
	@Getter
	private boolean p2attacks;
	@Getter
	private boolean p3attacks;

	@Provides
	TheatreConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TheatreConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();
		
		room = TheatreRoom.UNKNOWN;

		maidenHandler = new MaidenHandler(client, this, modelOutline);
		bloatHandler = new BloatHandler(client, this);
		nyloHandler = new NyloHandler(client, this);
		sotetsegHandler = new SotetsegHandler(client, this);
		xarpusHandler = new XarpusHandler(client, this);
		verzikHandler = new VerzikHandler(client, this);

		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);

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

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(SpotAnimationChanged.class, this, this::onSpotAnimationChanged);
		eventBus.subscribe(NpcDefinitionChanged.class, this, this::onNpcDefinitionChanged);
		eventBus.subscribe(NpcSpawned.class, this, this::onNpcSpawned);
		eventBus.subscribe(NpcDespawned.class, this, this::onNpcDespawned);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(WidgetLoaded.class, this, this::onWidgetLoaded);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(GroundObjectSpawned.class, this, this::onGroundObjectSpawned);
		eventBus.subscribe(VarbitChanged.class, this, this::onVarbitChanged);
		eventBus.subscribe(ProjectileMoved.class, this, this::onProjectileMoved);
	}

	private void onSpotAnimationChanged(SpotAnimationChanged event)
	{
		if (maidenHandler != null)
		{
			maidenHandler.onSpotAnimationChanged(event);
		}
	}

	private void onNpcDefinitionChanged(NpcDefinitionChanged event)
	{
		if (maidenHandler != null)
		{
			maidenHandler.onNpcDefinitionChanged(event);
		}
	}

	private void onNpcSpawned(NpcSpawned event)
	{
		if (maidenHandler != null)
		{
			maidenHandler.onNpcSpawned(event);
		}

		if (bloatHandler != null)
		{
			bloatHandler.onNpcSpawned(event);
		}

		if (nyloHandler != null)
		{
			nyloHandler.onNpcSpawned(event);
		}

		if (sotetsegHandler != null)
		{
			sotetsegHandler.onNpcSpawned(event);
		}

		if (xarpusHandler != null)
		{
			xarpusHandler.onNpcSpawned(event);
		}

		if (verzikHandler != null)
		{
			verzikHandler.onNpcSpawned(event);
		}

	}

	private void onNpcDespawned(NpcDespawned event)
	{
		if (maidenHandler != null)
		{
			maidenHandler.onNpcDespawned(event);
		}

		if (bloatHandler != null)
		{
			bloatHandler.onNpcDespawned(event);
		}

		if (nyloHandler != null)
		{
			nyloHandler.onNpcDespawned(event);
		}

		if (sotetsegHandler != null)
		{
			sotetsegHandler.onNpcDespawned(event);
		}

		if (xarpusHandler != null)
		{
			xarpusHandler.onNpcDespawned(event);
		}

	}

	private void onAnimationChanged(AnimationChanged event)
	{
		if (verzikHandler != null)
		{
			verzikHandler.onAnimationChanged(event);
		}
	}

	private void onChatMessage(ChatMessage event)
	{
		if (maidenHandler != null)
		{
			maidenHandler.onChatMessage(event);
		}
	}

	private void onWidgetLoaded(WidgetLoaded event)
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

	private void onGameTick(GameTick event)
	{
		if (maidenHandler != null)
		{
			maidenHandler.onGameTick();
		}

		if (bloatHandler != null)
		{
			bloatHandler.onGameTick();
		}

		if (nyloHandler != null)
		{
			nyloHandler.onGameTick();
		}

		if (sotetsegHandler != null)
		{
			sotetsegHandler.onGameTick();
		}

		if (xarpusHandler != null)
		{
			xarpusHandler.onGameTick();
		}

		if (verzikHandler != null)
		{
			verzikHandler.onGameTick();
		}

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

	private void onGroundObjectSpawned(GroundObjectSpawned event)
	{
		if (sotetsegHandler != null)
		{
			sotetsegHandler.onGroundObjectSpawned(event);
		}

		if (xarpusHandler != null)
		{
			xarpusHandler.onGroundObjectSpawned(event);
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("Theatre"))
		{
			return;
		}

		if (nyloHandler != null)
		{
			nyloHandler.onConfigChanged();
		}
	}

	private void onVarbitChanged(VarbitChanged event)
	{
		if (bloatHandler != null)
		{
			bloatHandler.onVarbitChanged(event);
		}

		if (xarpusHandler != null)
		{
			xarpusHandler.onVarbitChanged(event);
		}
	}

	private void onProjectileMoved(ProjectileMoved event)
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
	
	private void updateConfig()
	{
		this.showMaidenBloodToss = config.showMaidenBloodToss();
		this.showMaidenBloodSpawns = config.showMaidenBloodSpawns();
		this.showNyloFreezeHighlights = config.showNyloFreezeHighlights();
		this.showBloatIndicator = config.showBloatIndicator();
		this.showBloatHands = config.showBloatHands();
		this.BloatFeetIndicatorRaveEdition = config.BloatFeetIndicatorRaveEdition();
		this.showBloatTimer = config.showBloatTimer();
		this.showNyloPillarHealth = config.showNyloPillarHealth();
		this.showNylocasExplosions = config.showNylocasExplosions();
		this.showNylocasAmount = config.showNylocasAmount();
		this.highlightNyloAgros = config.highlightNyloAgros();
		this.showSotetsegAttacks = config.showSotetsegAttacks();
		this.showSotetsegMaze = config.showSotetsegMaze();
		this.showSotetsegSolo = config.showSotetsegSolo();
		this.mazeTileColour = config.mazeTileColour();
		this.showXarpusHeals = config.showXarpusHeals();
		this.showXarpusTick = config.showXarpusTick();
		this.showVerzikAttacks = config.showVerzikAttacks();
		this.showVerzikYellows = config.showVerzikYellows();
		this.showCrabTargets = config.showCrabTargets();
		this.VerzikTankTile = config.VerzikTankTile();
		this.verzikRangeAttacks = config.verzikRangeAttacks();
		this.extraTimers = config.extraTimers();
		this.p1attacks = config.p1attacks();
		this.p2attacks = config.p2attacks();
		this.p3attacks = config.p3attacks();
	}
}