package net.runelite.client.plugins.raids;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import com.google.inject.Provides;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
	private final String RAID_COMPLETE_MESSAGE = "Congratulations - your raid is complete!";
	private final int TOTAL_POINTS = 0, PERSONAL_POINTS = 1, TEXT_CHILD = 4;

	@Inject
	ChatMessageManager chatMessageManager;
	@Inject
	Client client;
	@Inject
	RaidsConfig config;

	@Override
	public void configure(Binder binder)
	{
	}

	@Provides
	RaidsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RaidsConfig.class);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (config.pointsMessage())
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
			int totalPoints = Integer.parseInt(raidPoints[TOTAL_POINTS]),
				personalPoints = Integer.parseInt(raidPoints[PERSONAL_POINTS]);

			double percentage = personalPoints / (totalPoints / 100.0);

			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setNaN("0");
			DecimalFormat df = new DecimalFormat("###.##", symbols);

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
					.append(df.format(percentage))
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
				.cacheColor(new ChatColor(ChatColorType.NORMAL, Color.BLACK, true), ChatMessageType.CLANCHAT_INFO)
				.cacheColor(new ChatColor(ChatColorType.HIGHLIGHT, Color.RED, true), ChatMessageType.CLANCHAT_INFO)
				.refreshAll();
	}
}
