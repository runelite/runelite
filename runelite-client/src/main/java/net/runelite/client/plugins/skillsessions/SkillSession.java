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

import java.awt.Color;
import java.time.Duration;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.ui.overlay.components.PanelComponent;
import org.apache.commons.lang3.time.DurationFormatUtils;

@Getter
public abstract class SkillSession
{
	protected final Skill skill;
	protected final Instant start;
	@Setter
	protected Instant lastAction;

	public SkillSession(Skill skill)
	{
		this.skill = skill;
		start = Instant.now();
		lastAction = start;
	}

	public Duration getSessionTime()
	{
		return Duration.between(start, Instant.now());
	}

	public int getActionsPerHour()
	{
		return (int) (((double) getActions() / getSessionTime().getSeconds()) * 3600);
	}

	public void updateLastAction()
	{
		lastAction = Instant.now();
	}

	public abstract boolean shouldDisplay(SkillSessionsConfig config);

	public abstract boolean isInAction(Client client);

	public abstract String getActionName();

	public abstract int getActions();

	/**
	 * Modifies the supplied {@link PanelComponent} to add statistics relevant to
	 * {@code this} skilling session.
	 */
	public void modifyPanel(PanelComponent panelComponent, Client client)
	{
		panelComponent.setWidth(145);
		panelComponent.setTitle(skill.getName());
		panelComponent.setTitleColor(isInAction(client) ? Color.GREEN : Color.RED);

		panelComponent.getLines().add(new PanelComponent.Line(
			"Time:",
			DurationFormatUtils.formatDuration(Duration.between(start, Instant.now()).toMillis(), "HH:mm:ss")
		));

		int actions = getActions();
		panelComponent.getLines().add(new PanelComponent.Line(getActionName() + ":", Integer.toString(actions) +
			(actions > 2 ? " (" + Integer.toString(getActionsPerHour()) + "/hr)" : "")));
	}
}
