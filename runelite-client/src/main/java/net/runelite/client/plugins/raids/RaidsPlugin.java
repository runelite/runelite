package net.runelite.client.plugins.raids;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColor;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
		name = "Raids Plugin"
)
public class RaidsPlugin extends Plugin
{
	private static final String RAID_COMPLETE_MESSAGE = "Congratulations - your raid is complete!";
	private static final int TOTAL_POINTS = 0, PERSONAL_POINTS = 1, TEXT_CHILD = 4;
	private static final DecimalFormat format = new DecimalFormat("###.##");

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private Client client;

	@Inject
	RaidsConfig config;

	@Provides
	RaidsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RaidsConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (config.enabled() && config.pointsMessage())
		{
			cacheColors();
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (!config.enabled())
		{
			return;
		}

		if (config.pointsMessage() && event.getType() == ChatMessageType.CLANCHAT_INFO
				&& event.getMessage().startsWith(RAID_COMPLETE_MESSAGE))
		{
			Widget raidsWidget = client.getWidget(WidgetInfo.RAIDS_POINTS_INFOBOX).getChild(TEXT_CHILD);
			String[] raidPoints = raidsWidget.getText().split("<br>");
			int totalPoints = Integer.parseInt(raidPoints[TOTAL_POINTS]);
			int personalPoints = Integer.parseInt(raidPoints[PERSONAL_POINTS]);

			double percentage = personalPoints / (totalPoints / 100.0);

			String message = new ChatMessageBuilder()
					.append(ChatColorType.NORMAL)
					.append("Total points: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(raidPoints[TOTAL_POINTS])
					.append(ChatColorType.NORMAL)
					.append(", Personal points: ")
					.append(ChatColorType.HIGHLIGHT)
					.append(raidPoints[PERSONAL_POINTS])
					.append(ChatColorType.NORMAL)
					.append(" (")
					.append(ChatColorType.HIGHLIGHT)
					.append(format.format(percentage))
					.append(ChatColorType.NORMAL)
					.append("%)")
					.build();

			chatMessageManager.queue(ChatMessageType.CLANCHAT_INFO, message);
		}
	}

	public void cacheColors()
	{
		chatMessageManager.cacheColor(new ChatColor(ChatColorType.NORMAL, Color.BLACK, false), ChatMessageType.CLANCHAT_INFO)
				.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, Color.RED, false), ChatMessageType.CLANCHAT_INFO)
				.cacheColor(new ChatColor(ChatColorType.NORMAL, Color.WHITE, true), ChatMessageType.CLANCHAT_INFO)
				.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, Color.RED, true), ChatMessageType.CLANCHAT_INFO)
				.refreshAll();
	}
}
