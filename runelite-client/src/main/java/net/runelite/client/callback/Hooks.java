/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.callback;

import com.google.common.eventbus.EventBus;
import com.google.inject.Injector;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MainBufferProvider;
import net.runelite.api.MenuAction;
import net.runelite.api.MessageNode;
import net.runelite.api.PacketBuffer;
import net.runelite.api.Point;
import net.runelite.api.Projectile;
import net.runelite.api.Skill;
import net.runelite.client.RuneLite;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.events.*;
import net.runelite.client.game.DeathChecker;
import net.runelite.client.task.Scheduler;
import net.runelite.client.ui.overlay.OverlayRenderer;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@Slf4j
public class Hooks
{
	private static final long CHECK = 600; // ms - how often to run checks

	private static final Injector injector = RuneLite.getInjector();
	private static final Client client = injector.getInstance(Client.class);
	private static final EventBus eventBus = injector.getInstance(EventBus.class);
	private static final Scheduler scheduler = injector.getInstance(Scheduler.class);
	private static final InfoBoxManager infoBoxManager = injector.getInstance(InfoBoxManager.class);
	private static final ChatMessageManager chatMessageManager = injector.getInstance(ChatMessageManager.class);
	private static final OverlayRenderer renderer = injector.getInstance(OverlayRenderer.class);
	private static final DeathChecker death = new DeathChecker(client, eventBus);
	private static final GameTick tick = new GameTick();

	private static long lastCheck;

	public static void clientMainLoop(Client client, boolean arg1)
	{
		long now = System.currentTimeMillis();

		if (now - lastCheck < CHECK)
		{
			return;
		}

		lastCheck = now;

		try
		{
			death.check();
		}
		catch (Exception ex)
		{
			log.warn("error during death check", ex);
		}

		// tick pending scheduled tasks
		scheduler.tick();

		// cull infoboxes
		infoBoxManager.cull();

		chatMessageManager.process();
	}

	public static void draw(MainBufferProvider mainBufferProvider, Graphics graphics, int x, int y)
	{
		final BufferedImage image = (BufferedImage) mainBufferProvider.getImage();
		final Graphics2D graphics2d = (Graphics2D) image.getGraphics();

		try
		{
			renderer.render(graphics2d);
		}
		catch (Exception ex)
		{
			log.warn("Error during overlay rendering", ex);
		}
	}

	public static void callHook(String name, int idx, Object object)
	{
		switch (name)
		{
			case "experienceChanged":
			{
				ExperienceChanged experienceChanged = new ExperienceChanged();
				Skill[] possibleSkills = Skill.values();

				// We subtract one here because 'Overall' isn't considered a skill that's updated.
				if (idx < possibleSkills.length - 1)
				{
					Skill updatedSkill = possibleSkills[idx];
					experienceChanged.setSkill(updatedSkill);
					eventBus.post(experienceChanged);
				}
				break;
			}
			case "mapRegionsChanged":
			{
				MapRegionChanged regionChanged = new MapRegionChanged();
				regionChanged.setIndex(idx);
				eventBus.post(regionChanged);
				break;
			}
			case "playerMenuOptionsChanged":
			{
				PlayerMenuOptionsChanged optionsChanged = new PlayerMenuOptionsChanged();
				optionsChanged.setIndex(idx);
				eventBus.post(optionsChanged);
				break;
			}
			case "animationChanged":
			{
				Actor actor = (Actor) object;
				AnimationChanged animationChange = new AnimationChanged();
				animationChange.setActor(actor);
				eventBus.post(animationChange);
				break;
			}
			case "gameStateChanged":
			{
				GameStateChanged gameStateChange = new GameStateChanged();
				gameStateChange.setGameState(client.getGameState());
				eventBus.post(gameStateChange);
				break;
			}
			case "varbitChanged":
			{
				VarbitChanged varbitChanged = new VarbitChanged();
				eventBus.post(varbitChanged);
				break;
			}
			case "clanMembersChanged":
			{
				ClanMembersChanged clanMembersChanged = new ClanMembersChanged();
				eventBus.post(clanMembersChanged);
				break;
			}
			case "resizeChanged":
			{
				//maybe couple with varbitChanged. resizeable may not be a varbit but it would fit with the other client settings.
				ResizeableChanged resizeableChanged = new ResizeableChanged();
				resizeableChanged.setResized(client.isResized());
				eventBus.post(resizeableChanged);
				break;
			}
			default:
				log.warn("Unknown event {} triggered on {}", name, object);
				return;
		}

		if (object != null)
		{
			log.trace("Event {} (idx {}) triggered on {}", name, idx, object);
		}
		else
		{
			log.trace("Event {} (idx {}) triggered", name, idx);
		}
	}

	public static void menuActionHook(int actionParam, int widgetId, int menuAction, int id, String menuOption, String menuTarget, int var6, int var7)
	{
		/* Along the way, the RuneScape client may change a menuAction by incrementing it with 2000.
		 * I have no idea why, but it does. Their code contains the same conditional statement.
		 */
		if (menuAction >= 2000)
		{
			menuAction -= 2000;
		}

		log.debug("Menu action clicked: {} ({}) on {} ({} widget: {})",
			menuOption, menuAction, menuTarget.isEmpty() ? "<nothing>" : menuTarget, id, actionParam, widgetId);

		MenuOptionClicked menuOptionClicked = new MenuOptionClicked();
		menuOptionClicked.setActionParam(actionParam);
		menuOptionClicked.setMenuOption(menuOption);
		menuOptionClicked.setMenuTarget(menuTarget);
		menuOptionClicked.setMenuAction(MenuAction.of(menuAction));
		menuOptionClicked.setId(id);
		menuOptionClicked.setWidgetId(widgetId);

		eventBus.post(menuOptionClicked);
	}

	public static void addMenuEntry(String option, String target, int type, int identifier, int param0, int param1)
	{
		if (log.isTraceEnabled())
		{
			log.trace("Menu entry added {} {}", option, target);
		}

		MenuEntryAdded menuEntry = new MenuEntryAdded(option, target, type, identifier, param0, param1);

		eventBus.post(menuEntry);
	}

	public static void addChatMessage(int type, String sender, String message, String clan)
	{
		if (log.isDebugEnabled())
		{
			log.debug("Chat message type {}: {}", ChatMessageType.of(type), message);
		}

		ChatMessageType chatMessageType = ChatMessageType.of(type);
		ChatMessage chatMessage = new ChatMessage(chatMessageType, sender, message, clan);

		eventBus.post(chatMessage);
	}

	/**
	 * Called when a projectile is set to move towards a point. For
	 * projectiles that target the ground, like AoE projectiles from
	 * Lizardman Shamans, this is only called once
	 *
	 * @param projectile The projectile being moved
	 * @param targetX X position of where the projectile is being moved to
	 * @param targetY Y position of where the projectile is being moved to
	 * @param targetZ Z position of where the projectile is being moved to
	 * @param cycle
	 */
	public static void projectileMoved(Projectile projectile, int targetX, int targetY, int targetZ, int cycle)
	{
		Point position = new Point(targetX, targetY);
		ProjectileMoved projectileMoved = new ProjectileMoved();
		projectileMoved.setProjectile(projectile);
		projectileMoved.setPosition(position);
		projectileMoved.setPlane(targetZ);
		eventBus.post(projectileMoved);
	}

	public static void setMessage(MessageNode messageNode, int type, String name, String sender, String value)
	{
		SetMessage setMessage = new SetMessage();
		setMessage.setMessageNode(messageNode);
		setMessage.setType(ChatMessageType.of(type));
		setMessage.setName(name);
		setMessage.setSender(sender);
		setMessage.setValue(value);

		eventBus.post(setMessage);
	}

	public static void onNpcUpdate(boolean var0, PacketBuffer var1)
	{
		eventBus.post(tick);
	}
}
