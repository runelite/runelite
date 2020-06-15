package net.runelite.client.plugins.tzhaartimers;

import com.google.inject.Provides;
import java.time.Instant;
import java.util.Arrays;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.SoundEffectID;
import net.runelite.api.SoundEffectVolume;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Tzhaar Cave Timers",
	description = "Times Inferno and Fight Caves runs"
)

@Slf4j

public class TzhaarTimersPlugin extends Plugin
{
	private static final int[] JAD_MAP_REGION = {9551};
	private static final int[] ZUK_MAP_REGION = {9043};

	@Inject
	private ChatMessageManager chatMessageManager;
	@Inject
	private TzhaarTimersConfig tzhaarTimersConfig;
	@Inject
	private Client client;
	@Inject
	private ItemManager itemManager;
	@Inject
	private InfoBoxManager infoBoxManager;

	private CapeTimers timer;
	private boolean inCaves;

	@Provides
	TzhaarTimersConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TzhaarTimersConfig.class);
	}


	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		String message = Text.removeTags(event.getMessage());

		if (timer == null)
		{
			if (isInFightCaves() && message.startsWith("Wave:") && tzhaarTimersConfig.fightcaves())
			{
				inCaves = true;
				timer = new CapeTimers(this, Instant.now(), itemManager.getImage(ItemID.FIRE_CAPE));
				infoBoxManager.addInfoBox(timer);
			}
			else if (isInInferno() && message.startsWith("Wave:") && tzhaarTimersConfig.inferno())
			{
				inCaves = true;
				timer = new CapeTimers(this, Instant.now(), itemManager.getImage(ItemID.INFERNAL_CAPE));
				infoBoxManager.addInfoBox(timer);
			}
		}
		else if (message.startsWith("Your TzKal-Zuk") || message.startsWith("Your TzTok-Jad"))
		{
			System.out.println("Dead Boss!");
			client.playSoundEffect(SoundEffectID.PRAYER_ACTIVATE_CLARITY_OF_THOUGHT, client.getSoundEffectVolume());
			timer.setStopped(true);
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (inCaves && !timer.stopped && (!isInFightCaves() && !isInInferno()))
		{
			inCaves = false;
			client.playSoundEffect(SoundEffectID.MAGIC_SPLASH_BOING, client.getSoundEffectVolume());

			final String message = new ChatMessageBuilder()
				.append(ChatColorType.HIGHLIGHT)
				.append("You have left the caves!")
				.build();

			chatMessageManager.queue(
				QueuedMessage.builder()
					.type(ChatMessageType.CONSOLE)
					.runeLiteFormattedMessage(message)
					.build());

			infoBoxManager.removeInfoBox(timer);
			timer = null;
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		System.out.println("Fight Caves Status: " + tzhaarTimersConfig.fightcaves());
		System.out.println("Inferno Status: " + tzhaarTimersConfig.inferno());

	}


	public boolean isInFightCaves()
	{
		if (client.getLocalPlayer() == null)
		{
			return false;
		}
		return Arrays.equals(client.getMapRegions(), JAD_MAP_REGION);
	}

	public boolean isInInferno()
	{
		if (client.getLocalPlayer() == null)
		{
			return false;
		}
		return Arrays.equals(client.getMapRegions(), ZUK_MAP_REGION);
	}

	@Override
	public void startUp()
	{
		timer = null;
	}

	@Override
	public void shutDown()
	{
		infoBoxManager.removeInfoBox(timer);
		timer = null;

	}
}
