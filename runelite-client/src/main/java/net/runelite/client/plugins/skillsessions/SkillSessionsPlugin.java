/*
 * Copyright (c) 2018, Desetude <harry@desetude.com>
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
package net.runelite.client.plugins.skillsessions;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.skillsessions.skillsessions.CookingSkillSession;
import net.runelite.client.plugins.skillsessions.skillsessions.FishingSkillSession;
import net.runelite.client.plugins.skillsessions.skillsessions.WoodcuttingSkillSession;
import net.runelite.client.plugins.xptracker.XpTrackerPlugin;
import net.runelite.client.plugins.xptracker.XpTrackerService;
import net.runelite.client.ui.overlay.Overlay;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.function.Supplier;

@PluginDescriptor(
		name = "Skill Sessions"
)
@PluginDependency(XpTrackerPlugin.class)
public class SkillSessionsPlugin extends Plugin
{
	@Inject
	private SkillSessionsOverlay overlay;

	@Inject
	private SkillSessionsConfig config;

	@Inject
	private XpTrackerService xpTracker;

	@Getter
	@Setter
	private SkillSession focused;

	private ClassToInstanceMap<SkillSession> sessions;

	@Override
	protected void startUp() throws Exception
	{
		sessions = MutableClassToInstanceMap.create();
	}

	@Provides
	SkillSessionsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SkillSessionsConfig.class);
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	public <T extends SkillSession> T updateSession(Class<T> clazz, Supplier<T> absenceSupplier)
	{
		T session;
		if (sessions.containsKey(clazz))
		{
			session = sessions.getInstance(clazz);
		}
		else
		{
			session = absenceSupplier.get();
			sessions.putInstance(clazz, session);
		}

		session.updateLastAction();
		if (session.shouldDisplay(config))
		{
			focused = session;
		}
		return session;
	}

	@Subscribe
	public void onConfigChange(ConfigChanged event)
	{
		if (focused != null && !focused.shouldDisplay(config))
		{
			focused = null;
		}
	}

	@Subscribe
	public void onTick(GameTick event)
	{
		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		for (Map.Entry<Class<? extends SkillSession>, ? extends SkillSession> session : sessions.entrySet())
		{
			int timeoutDifference = Duration.between(session.getValue().getLastAction(), Instant.now())
					.compareTo(statTimeout);

			if (timeoutDifference >= 0)
			{
				if (session.getValue().equals(focused))
				{
					focused = null;
				}

				if (config.statTimeoutReset())
				{
					sessions.remove(session.getKey());
				}
			}
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		if (event.getMessage().startsWith("You successfully cook ") ||
				event.getMessage().startsWith("You successfully bake "))
		{
			updateSession(CookingSkillSession.class, CookingSkillSession::new).incrementCookedAmount();
		}
		else if (event.getMessage().startsWith("You accidentally burn "))
		{
			updateSession(CookingSkillSession.class, CookingSkillSession::new).incrementBurntAmount();
		}
		else if (event.getMessage().contains("You catch a") || event.getMessage().contains("You catch some"))
		{
			updateSession(FishingSkillSession.class, () -> new FishingSkillSession(xpTracker));
		}
		else if (event.getMessage().startsWith("You get some") && event.getMessage().endsWith("logs."))
		{
			updateSession(WoodcuttingSkillSession.class, () -> new WoodcuttingSkillSession(xpTracker));
		}
	}
}
