/*
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.tmorph;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.Arrays;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Player;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.SpotAnimationChanged;
import net.runelite.api.kit.KitType;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.util.Clipboard;
import net.runelite.client.util.ColorUtil;
import org.apache.commons.lang3.ObjectUtils;

@PluginDescriptor(
	name = "TMorph",
	description = "Want to wear a infernal cape? well now you can!",
	tags = {"transform", "model", "item", "morph"},
	type = PluginType.UTILITY,
	enabledByDefault = false
)
@Singleton
public class TMorph extends Plugin
{
	@Getter(AccessLevel.PACKAGE)
	private static final Map<String, KitType> kit;
	private static final Color COLOR = new Color(10, 134, 74, 255);

	static
	{
		final ImmutableMap.Builder<String, KitType> builder = new ImmutableMap.Builder<>();
		for (KitType kit : KitType.values())
		{
			builder.put(kit.getName(), kit);
		}
		kit = builder.build();
	}

	@Getter(AccessLevel.PACKAGE)
	private static final Splitter NEWLINE_SPLITTER = Splitter
		.on("\n")
		.omitEmptyStrings()
		.trimResults();

	@Inject
	private Client client;

	@Inject
	private TMorphConfig config;

	@Inject
	private EventBus eventBus;

	private Map<String, String> set1;
	private Map<String, String> set2;
	private Map<String, String> set3;
	private int animation;
	private int globalAnimSwap;
	private int globalGraphicSwap;
	private int graphic;
	private int targetAnimation;
	private int targetGraphic;

	@Provides
	TMorphConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TMorphConfig.class);
	}

	@Override
	protected void startUp()
	{
		updateConfig();
		addSubscriptions();
	}

	@Override
	protected void shutDown()
	{
		eventBus.unregister(this);
	}

	private void addSubscriptions()
	{
		eventBus.subscribe(AnimationChanged.class, this, this::onAnimationChanged);
		eventBus.subscribe(GameTick.class, this, this::onGameTick);
		eventBus.subscribe(SpotAnimationChanged.class, this, this::onSpotAnimationChanged);
		eventBus.subscribe(CommandExecuted.class, this, this::onCommandExecuted);
	}

	private void onCommandExecuted(CommandExecuted event)
	{
		final String[] args = event.getArguments();

		if (event.getCommand().equals("tmorph"))
		{
			try
			{
				if (args[0].equals("copy"))
				{
					final StringBuilder sb = new StringBuilder();
					final Player player = client.getLocalPlayer();

					if (player == null
						|| player.getPlayerAppearance() == null
						|| client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null
						|| client.getViewportWidget() == null)
					{
						return;
					}

					for (KitType kitType : KitType.values())
					{
						if (kitType.equals(KitType.RING) || kitType.equals(KitType.AMMUNITION))
						{
							continue;
						}

						final int id = player.getPlayerAppearance().getEquipmentId(kitType);

						if (id == -1)
						{
							continue;
						}

						sb.append(id);
						sb.append(",-1");
						sb.append(":");
						sb.append(kitType.getName());
						sb.append("\n");
					}
					client.addChatMessage(ChatMessageType.GAMEMESSAGE, "TMorph", ColorUtil.prependColorTag("Your current gear has been copied to your clipboard", COLOR), null);
					Clipboard.store(sb.toString());
				}
				else
				{
					client.addChatMessage(ChatMessageType.GAMEMESSAGE, "TMorph", ColorUtil.prependColorTag("Invalid syntax, do ::tmorph copy", Color.RED), null);
				}
			}
			catch (Exception e)
			{
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "TMorph", ColorUtil.prependColorTag("Invalid syntax, do ::tmorph copy", Color.RED), null);
			}
		}
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (event.getGroup().equals("TMorph"))
		{
			updateConfig();
		}
	}

	private void onSpotAnimationChanged(SpotAnimationChanged event)
	{
		final Actor actor = event.getActor();

		if (actor.getSpotAnimation() == -1)
		{
			return;
		}

		if (this.graphic <= 0 && this.targetGraphic <= 0 && this.globalGraphicSwap > 0)
		{
			actor.setSpotAnimation(this.globalGraphicSwap);
		}
		if (this.graphic > 0 && this.targetGraphic > 0)
		{
			if (actor.getSpotAnimation() == this.targetGraphic)
			{
				actor.setSpotAnimation(this.graphic);
			}
		}
	}

	private void onAnimationChanged(AnimationChanged event)
	{
		final Actor actor = event.getActor();

		if (actor.getAnimation() == -1)
		{
			return;
		}

		if (this.targetAnimation <= 0 && this.animation <= 0 && this.globalAnimSwap > 0)
		{
			actor.setAnimation(this.globalAnimSwap);
		}
		if (this.targetAnimation > 0 && this.animation > 0)
		{
			if (actor.getAnimation() == this.targetAnimation)
			{
				actor.setAnimation(this.animation);
			}
		}
	}

	private void onGameTick(GameTick event)
	{
		if (client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}

		final Player player = client.getLocalPlayer();

		if (player == null
			|| player.getPlayerAppearance() == null
			|| client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null
			|| client.getViewportWidget() == null)
		{
			return;
		}

		updateGear(set1, player);
		updateGear(set2, player);
		updateGear(set3, player);
	}

	private void updateGear(Map<String, String> map, Player player)
	{
		if (map == null || map.isEmpty())
		{
			return;
		}

		for (Map.Entry<String, String> entry : map.entrySet())
		{
			if (!kit.containsKey(entry.getValue()))
			{
				continue;
			}

			final KitType slot = kit.get(entry.getValue());
			int[] ints;

			try
			{
				ints = Arrays.stream(entry.getKey().split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
			}
			catch (NumberFormatException ex)
			{
				ints = null;
			}

			if (ints == null || ints.length <= 1)
			{
				continue;
			}

			final int item = ObjectUtils.defaultIfNull(player.getPlayerAppearance().getEquipmentId(slot), 0);

			if (item == ints[0])
			{
				if (ints[1] == -1)
				{
					continue;
				}
				player.getPlayerAppearance().getEquipmentIds()[slot.getIndex()] = ints[1] + 512;
			}
		}
	}

	private void updateConfig()
	{
		this.set1 = NEWLINE_SPLITTER.withKeyValueSeparator(':').split(config.set1());
		this.set2 = NEWLINE_SPLITTER.withKeyValueSeparator(':').split(config.set2());
		this.set3 = NEWLINE_SPLITTER.withKeyValueSeparator(':').split(config.set3());
		this.animation = config.animationSwap();
		this.globalAnimSwap = config.globalAnimSwap();
		this.globalGraphicSwap = config.globalGraphicSwap();
		this.graphic = config.graphicSwap();
		this.targetAnimation = config.animationTarget();
		this.targetGraphic = config.graphicTarget();
	}
}
