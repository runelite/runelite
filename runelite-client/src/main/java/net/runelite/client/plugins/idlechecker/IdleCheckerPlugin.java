
package net.runelite.client.plugins.idlechecker;

import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.InventoryID;
import net.runelite.api.ItemContainer;
import net.runelite.api.Player;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.InteractingChanged;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.FlashNotification;
import net.runelite.client.config.Notification;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import java.time.Duration;
import java.time.Instant;

@PluginDescriptor(
	name = "Idle Checker",
	description = "Display a square that changes color when you are idle.",
	tags = {"idle", "checker", "status"}
)
public class IdleCheckerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private IdleCheckerOverlay overlay;

	@Inject
	private IdleCheckerConfig config;

	@Inject
	private Notifier notifier;

	private IdleCheckerSession session;
	private boolean inventoryNotified;

	private static final int INVENTORY_SIZE = 28;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
		session = null;
	}

	public boolean isIdle()
	{
		return session == null || !session.isActive();
	}

	public boolean isInventoryFull()
	{
		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		if (inventory == null)
		{
			return false;
		}
		return inventory.count() == INVENTORY_SIZE;
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			session = null;
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		Player localPlayer = client.getLocalPlayer();
		if (localPlayer != event.getActor())
		{
			return;
		}

		if (localPlayer.getAnimation() != -1)
		{
			if (session == null)
			{
				session = new IdleCheckerSession();
			}
			session.setLastActionTime();
			session.setActive(true);
		}
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		if (event.getTarget() != null && event.getSource() == client.getLocalPlayer())
		{
			if (session == null)
			{
				session = new IdleCheckerSession();
			}
			session.setLastActionTime();
			session.setActive(true);
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (isInventoryFull())
		{
			if (config.flashWindowOnFull() && !inventoryNotified)
			{
				notifier.notify(new Notification()
					.withFlash(FlashNotification.SOLID_UNTIL_CANCELLED)
					.withFlashColor(config.getFullInventoryColor()), "");
				inventoryNotified = true;
			}
		}
		else
		{
			inventoryNotified = false;
		}

		if (session == null || session.getLastActionTime() == null)
		{
			return;
		}

		if (client.getLocalPlayer().getAnimation() != -1)
		{
			session.setLastActionTime();
			return;
		}

		Duration sinceAction = Duration.between(session.getLastActionTime(), Instant.now());
		if (sinceAction.compareTo(Duration.ofMillis(config.getIdleTimeout())) >= 0)
		{
			session.setActive(false);
		}
	}

	@Provides
	IdleCheckerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(IdleCheckerConfig.class);
	}
}
