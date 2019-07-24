/*
 * Copyright (c) 2019. PKLite  - All Rights Reserved
 * Unauthorized modification, distribution, or possession of this source file, via any medium is strictly prohibited.
 * Proprietary and confidential. Refer to PKLite License file for more information on
 * full terms of this copyright and to determine what constitutes authorized use.
 * Written by PKLite(ST0NEWALL, others) <stonewall@thots.cc.usa>, 2019
 *
 */

package net.runelite.client.plugins.wildernesslocations;


import com.google.inject.Provides;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.VarClientStr;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Keybind;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.util.WildernessLocation;

@Slf4j
@PluginDescriptor(
	name = "Wild Locations",
	description = "Indicates the players current location in the wild",
	tags = {"Wildy", "Wilderness Location", "location", "loc", "pvp", "pklite"},
	type = PluginType.PVP,
	enabledByDefault = false
)
@Singleton
public class WildernessLocationsPlugin extends Plugin
{

	@Inject
	private Client client;

	@Inject
	OverlayManager overlayManager;

	@Inject
	private WildernessLocationsOverlay overlay = new WildernessLocationsOverlay(this);

	@Getter
	private boolean renderLocation;

	@Getter
	private String locationString = "";

	@Inject
	private ClientThread clientThread;

	@Inject
	private WildernessLocationsConfig wildyConfig;

	@Inject
	private KeyManager keyManager;

	@Inject
	private EventBus eventBus;

	private String oldChat = "";
	private int currentCooldown = 0;
	private WorldPoint worldPoint = null;
	private final Map<WorldArea, String> wildLocs = getLocationMap();

	private final HotkeyListener hotkeyListener = new HotkeyListener(() -> this.keybind)
	{
		@Override
		public void hotkeyPressed()
		{
			sendLocToCC();
		}
	};

	@Getter(AccessLevel.PACKAGE)
	private boolean drawOverlay;
	private Keybind keybind;

	@Provides
	WildernessLocationsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WildernessLocationsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		addSubscriptions();

		this.drawOverlay = wildyConfig.drawOverlay();
		this.keybind = wildyConfig.keybind();

		overlayManager.add(overlay);
		keyManager.registerKeyListener(hotkeyListener);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(VarClientStrChanged.class, this, this::onVarClientStrChanged);
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("wildernesslocations"))
		{
			return;
		}

		this.drawOverlay = wildyConfig.drawOverlay();
		this.keybind = wildyConfig.keybind();
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		keyManager.unregisterKeyListener(hotkeyListener);
	}

	private void onGameTick(GameTick event)
	{
		if (currentCooldown != 0)
		{
			currentCooldown--;
		}
		renderLocation = client.getVar(Varbits.IN_WILDERNESS) == 1;
		if (renderLocation)
		{
			if (client.getLocalPlayer().getWorldLocation() != worldPoint)
			{
				locationString = location();
				worldPoint = client.getLocalPlayer().getWorldLocation();
			}
		}
		else
		{
			worldPoint = null;
			locationString = "";
		}
	}

	private String location()
	{
		int dist = 10000;
		String s = "";
		WorldArea closestArea = null;
		for (Map.Entry<WorldArea, String> entry : wildLocs.entrySet())
		{
			WorldArea worldArea = entry.getKey();

			if (worldArea.toWorldPointList().contains(client.getLocalPlayer().getWorldLocation()))
			{
				s = entry.getValue();
				return s;
			}
			int distTo = worldArea.distanceTo(client.getLocalPlayer().getWorldLocation());
			if (distTo < dist)
			{
				dist = distTo;
				closestArea = worldArea;
			}
		}
		if (client.getLocalPlayer().getWorldLocation().getY() >
			(Objects.requireNonNull(closestArea).toWorldPoint().getY() + closestArea.getHeight()))
		{
			s = s + "N";
		}
		if (client.getLocalPlayer().getWorldLocation().getY() < closestArea.toWorldPoint().getY())
		{
			s = s + "S";
		}
		if (client.getLocalPlayer().getWorldLocation().getX() < closestArea.toWorldPoint().getX())
		{
			s = s + "W";
		}
		if (client.getLocalPlayer().getWorldLocation().getX() >
			(closestArea.toWorldPoint().getX() + closestArea.getWidth()))
		{
			s = s + "E";
		}
		s = s + " of ";
		s = s + wildLocs.get(closestArea);
		if (s.startsWith(" of "))
		{
			s = s.substring(3);
		}
		return s;
	}

	private static Map<WorldArea, String> getLocationMap()
	{
		Map<WorldArea, String> hashMap = new HashMap<>();
		Arrays.stream(WildernessLocation.values()).forEach(wildernessLocation ->
			hashMap.put(wildernessLocation.getWorldArea(), wildernessLocation.getName()));
		return hashMap;
	}

	private void onVarClientStrChanged(VarClientStrChanged varClient)
	{
		String newChat = client.getVar(VarClientStr.CHATBOX_TYPED_TEXT);
		if (varClient.getIndex() == VarClientStr.CHATBOX_TYPED_TEXT.getIndex() && !newChat.equals(oldChat))
		{
			oldChat = newChat;
		}
	}

	private boolean inClanChat()
	{
		return client.getWidget(WidgetInfo.CLAN_CHAT_TITLE) != null;
	}

	private void sendMessage(String text)
	{
		int mode = 0;
		if (inClanChat() && text.startsWith("/"))
		{
			mode = 2;
		}
		int finalMode = mode;
		Runnable r = () ->
		{
			String cached = oldChat;
			client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, text);
			client.runScript(ScriptID.CHATBOX_INPUT, finalMode, text);
			oldChat = cached;
			client.setVar(VarClientStr.CHATBOX_TYPED_TEXT, oldChat);
		};
		clientThread.invoke(r);
	}

	private void sendLocToCC()
	{
		if (currentCooldown != 0)
		{
			return;
		}
		String location = getLocationString();
		if (location.equals(""))
		{
			return;
		}
		sendMessage("/World: " + client.getWorld() + " Location: " + location);
		currentCooldown = 30;
	}
}
