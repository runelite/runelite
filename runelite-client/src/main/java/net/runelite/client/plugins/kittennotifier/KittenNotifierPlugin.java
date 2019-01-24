package net.runelite.client.plugins.kittennotifier;
import com.google.inject.Provides;
import net.runelite.api.ChatMessageType;
import net.runelite.api.NPC;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcSpawned;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.Client;
import javax.inject.Inject;

@PluginDescriptor
(
	name = "Kitten Notifier",
	description = "Sends a notification when your kitten needs food, attention, or is grown.",
	tags = {"kitten", "cat", "notifications"}
)
public class KittenNotifierPlugin extends Plugin
{
	@Inject
	private Notifier notifier;

	@Inject
	private KittenNotifierConfig config;

	@Inject
	private Client client;

	@Provides
	KittenNotifierConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(KittenNotifierConfig.class);
	}

	private NPC kitCat;
	private String kitCatWas;

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (config.kittenNeeds() && event.getType() == ChatMessageType.SERVER)
		{
			if (event.getMessage().contentEquals("<col=ef1020>Your kitten is hungry.</col>"))
			{
				notifier.notify("Your kitten is hungry.");
			}
			if (event.getMessage().contentEquals("<col=ef1020>Your kitten wants attention.</col>"))
			{
				notifier.notify("Your kitten wants attention.");
			}
			if (event.getMessage().contentEquals("<col=ef1020>Your kitten is very hungry.</col>"))
			{
				notifier.notify("Your kitten is very hungry.");
			}
			if (event.getMessage().contentEquals("<col=ef1020>Your kitten really wants attention.</col>"))
			{
				notifier.notify("Your kitten really wants attention.");
			}
		}
	}
	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (kitCat != null && kitCat.getName() != null)
		{
			if (kitCatWas.contentEquals("Kitten") && kitCat.getName().contentEquals("Cat"))
			{
				notifier.notify("Your kitten has grown into a cat.");
			}
			kitCatWas = kitCat.getName();
		}
		else
		{
			kitCat = null;
		}
	}
	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		if (event.getNpc().getInteracting() != null && event.getNpc().getInteracting().getName().contentEquals(client.getLocalPlayer().getName()))
		{
			if (event.getNpc().getName().contentEquals("Kitten") || event.getNpc().getName().contentEquals("Cat"))
			{
				kitCat = event.getNpc();
				kitCatWas = event.getNpc().getName();
			}
		}
	}
}
