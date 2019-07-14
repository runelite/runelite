/*
 * Copyright (c) 2018, Joris K <kjorisje@gmail.com>
 * Copyright (c) 2018, Lasse <cronick@zytex.dk>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.cooking;

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GraphicID;
import net.runelite.api.ItemID;
import net.runelite.api.Player;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.SpotAnimationChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@PluginDescriptor(
	name = "Cooking",
	description = "Show cooking statistics",
	tags = {"overlay", "skilling", "cook"}
)
@Singleton
@PluginDependency(XpTrackerPlugin.class)
public class CookingPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private CookingConfig config;

	@Inject
	private CookingOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private CookingSession session;

	private int statTimeout;
	@Setter(AccessLevel.PACKAGE)
	private boolean fermentTimer;

	@Provides
	CookingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CookingConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		session = null;
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		infoBoxManager.removeIf(FermentTimer.class::isInstance);
		overlayManager.remove(overlay);
		session = null;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(SpotAnimationChanged.class, this, this::onSpotAnimationChanged);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
	}

	private void onGameTick(GameTick gameTick)
	{
		if (session == null || this.statTimeout == 0)
		{
			return;
		}

		Duration statTimeout = Duration.ofMinutes(this.statTimeout);
		Duration sinceCut = Duration.between(session.getLastCookingAction(), Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			session = null;
		}
	}

	void onSpotAnimationChanged(SpotAnimationChanged graphicChanged)
	{
		Player player = client.getLocalPlayer();

		if (graphicChanged.getActor() != player)
		{
			return;
		}

		if (player.getSpotAnimation() == GraphicID.WINE_MAKE && this.fermentTimer)
		{
			Optional<FermentTimer> fermentTimerOpt = infoBoxManager.getInfoBoxes().stream()
				.filter(FermentTimer.class::isInstance)
				.map(FermentTimer.class::cast)
				.findAny();

			if (fermentTimerOpt.isPresent())
			{
				FermentTimer fermentTimer = fermentTimerOpt.get();
				fermentTimer.reset();
			}
			else
			{
				FermentTimer fermentTimer = new FermentTimer(itemManager.getImage(ItemID.JUG_OF_WINE), this);
				infoBoxManager.addInfoBox(fermentTimer);
			}
		}
	}

	void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		final String message = event.getMessage();

		if (message.startsWith("You successfully cook")
			|| message.startsWith("You successfully bake")
			|| message.startsWith("You manage to cook")
			|| message.startsWith("You roast a")
			|| message.startsWith("You cook"))
		{
			if (session == null)
			{
				session = new CookingSession();
			}

			session.updateLastCookingAction();
			session.increaseCookAmount();

		}
		else if (message.startsWith("You accidentally burn")
			|| message.startsWith("You accidentally spoil"))
		{
			if (session == null)
			{
				session = new CookingSession();
			}

			session.updateLastCookingAction();
			session.increaseBurnAmount();
		}
	}

	private void onConfigChanged(ConfigChanged configChanged)
	{
		if (configChanged.getGroup().equals("cooking"))
		{
			updateConfig();
		}
	}

	private void updateConfig()
	{
		this.statTimeout = config.statTimeout();
		this.fermentTimer = config.fermentTimer();
	}
}
