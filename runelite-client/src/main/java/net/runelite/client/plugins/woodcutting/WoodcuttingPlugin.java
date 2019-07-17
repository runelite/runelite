/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.woodcutting;

import com.google.inject.Provides;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.Notifier;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Woodcutting",
	description = "Show woodcutting statistics and/or bird nest notifications",
	tags = {"birds", "nest", "notifications", "overlay", "skilling", "wc"}
)
@Singleton
@PluginDependency(XpTrackerPlugin.class)
public class WoodcuttingPlugin extends Plugin
{
	@Inject
	private Notifier notifier;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private WoodcuttingOverlay overlay;

	@Inject
	private WoodcuttingTreesOverlay treesOverlay;

	@Inject
	private WoodcuttingConfig config;

	@Inject
	private EventBus eventBus;

	@Getter(AccessLevel.PACKAGE)
	private WoodcuttingSession session;

	@Getter(AccessLevel.PACKAGE)
	private Axe axe;

	@Getter(AccessLevel.PACKAGE)
	private final Set<GameObject> treeObjects = new HashSet<>();

	private int statTimeout;
	private boolean showNestNotification;
	@Getter(AccessLevel.PACKAGE)
	private boolean showWoodcuttingStats;
	@Getter(AccessLevel.PACKAGE)
	private boolean showRedwoodTrees;

	@Provides
	WoodcuttingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WoodcuttingConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		updateConfig();
		addSubscriptions();

		overlayManager.add(overlay);
		overlayManager.add(treesOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(this);

		overlayManager.remove(overlay);
		overlayManager.remove(treesOverlay);
		treeObjects.clear();
		session = null;
		axe = null;
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(ConfigChanged.class, this, this::onConfigChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(ChatMessage.class, this, this::onChatMessage);
		eventBus.subscribe(GameObjectSpawned.class, this, this::onGameObjectSpawned);
		eventBus.subscribe(GameObjectDespawned.class, this, this::onGameObjectDespawned);
		eventBus.subscribe(GameObjectChanged.class, this, this::onGameObjectChanged);
		eventBus.subscribe(GameStateChanged.class, this, this::onGameStateChanged);
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
	}

	private void onGameTick(GameTick gameTick)
	{
		if (session == null || session.getLastLogCut() == null)
		{
			return;
		}

		Duration statTimeout = Duration.ofMinutes(this.statTimeout);
		Duration sinceCut = Duration.between(session.getLastLogCut(), Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			session = null;
			axe = null;
		}
	}

	private void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.SPAM || event.getType() == ChatMessageType.GAMEMESSAGE)
		{
			if (event.getMessage().startsWith("You get some") && (event.getMessage().endsWith("logs.") || event.getMessage().endsWith("mushrooms.")))
			{
				if (session == null)
				{
					session = new WoodcuttingSession();
				}

				session.setLastLogCut();
			}

			if (event.getMessage().contains("A bird's nest falls out of the tree") && this.showNestNotification)
			{
				notifier.notify("A bird nest has spawned!");
			}
		}
	}

	private void onGameObjectSpawned(final GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();
		Tree tree = Tree.findTree(gameObject.getId());

		if (tree != null)
		{
			treeObjects.add(gameObject);
		}
	}

	private void onGameObjectDespawned(final GameObjectDespawned event)
	{
		treeObjects.remove(event.getGameObject());
	}

	private void onGameObjectChanged(final GameObjectChanged event)
	{
		treeObjects.remove(event.getGameObject());
	}

	private void onGameStateChanged(final GameStateChanged event)
	{
		if (event.getGameState() != GameState.LOGGED_IN)
		{
			treeObjects.clear();
		}
	}

	private void onAnimationChanged(final AnimationChanged event)
	{
		Player local = client.getLocalPlayer();

		if (event.getActor() != local)
		{
			return;
		}

		int animId = local.getAnimation();
		Axe axe = Axe.findAxeByAnimId(animId);
		if (axe != null)
		{
			this.axe = axe;
		}
	}

	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("woodcutting"))
		{
			return;
		}

		updateConfig();
	}

	private void updateConfig()
	{
		this.statTimeout = config.statTimeout();
		this.showNestNotification = config.showNestNotification();
		this.showWoodcuttingStats = config.showWoodcuttingStats();
		this.showRedwoodTrees = config.showRedwoodTrees();
	}
}