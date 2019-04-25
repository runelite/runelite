package net.runelite.client.plugins.locationchatter;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ScriptID;
import net.runelite.api.VarClientStr;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.plugins.wildernesslocations.WildernessLocationsPlugin;
import net.runelite.client.util.HotkeyListener;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
	name = "Location Chatter", 
	tags = {"location", "exilent", "pklite", "spammer"},
	type = PluginType.UTILITY
	)
public class LocationChatterPlugin extends Plugin
{
	@Inject
	private Client client;
	
	@Inject
	private ClientThread clientThread;
	
	@Inject
	LocationChatterConfig config;
	
	@Inject
	private KeyManager keyManager;
	
	@Inject
	private PluginManager pluginManager;
	
	private WildernessLocationsPlugin wildyLocsPlugin;
	
	private String oldChat = "";
	private int currentCooldown = 0;
	private final int COOLDOWN_TICKS = 30;
	
	private final HotkeyListener hotkeyListener = new HotkeyListener(() -> config.keybind())
	{
		@Override
		public void hotkeyPressed()
		{
			sendLocToCC();
		}
	};
	
	@Override
	public void startUp()
	{
		for (Plugin pl : pluginManager.getPlugins())
		{
			if (pl instanceof WildernessLocationsPlugin)
			{
				wildyLocsPlugin = (WildernessLocationsPlugin) pl;
			}
		}
		keyManager.registerKeyListener(hotkeyListener);
	}
	
	@Override
	public void shutDown()
	{
		keyManager.unregisterKeyListener(hotkeyListener);
	}
	
	@Provides
	LocationChatterConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LocationChatterConfig.class);
	}
	
	@Subscribe
	public void onGameTick(GameTick tickEvent)
	{
		if (currentCooldown != 0)
		{
			currentCooldown--;
		}
	}
	
	@Subscribe
	public void onVarClientStrChanged(VarClientStrChanged varClient)
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
		String location = wildyLocsPlugin.getLocationString();
		if (location.equals(""))
		{
			return;
		}
		sendMessage("/World: " + client.getWorld() + " Location: " + location);
		currentCooldown = COOLDOWN_TICKS;
	}
}
