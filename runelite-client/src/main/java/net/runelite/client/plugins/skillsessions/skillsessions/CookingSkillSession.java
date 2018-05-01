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
package net.runelite.client.plugins.skillsessions.skillsessions;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;
import lombok.Getter;
import net.runelite.api.AnimationID;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.plugins.skillsessions.SkillSession;
import net.runelite.client.plugins.skillsessions.SkillSessionsConfig;
import net.runelite.client.ui.overlay.components.PanelComponent;

//Doesn't use XpTrackerSkillSession as the number of actions
//is tracked anyway in order to calculate the burn percentage.
public class CookingSkillSession extends SkillSession
{
	private static final int[] animationIds = {
		AnimationID.COOKING_FIRE, AnimationID.COOKING_RANGE
	};

	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.#");

	@Getter
	private int cookedAmount;
	@Getter
	private int burntAmount;

	public CookingSkillSession()
	{
		super(Skill.COOKING);
	}

	public void incrementCookedAmount()
	{
		cookedAmount++;
	}

	public void incrementBurntAmount()
	{
		burntAmount++;
	}

	public String getBurntPercentage()
	{
		return DECIMAL_FORMAT.format(((double) burntAmount / (cookedAmount + burntAmount)) * 100);
	}

	@Override
	public boolean shouldDisplay(SkillSessionsConfig config)
	{
		return config.showCooking();
	}

	@Override
	public boolean isInAction(Client client)
	{
		return IntStream.of(animationIds).anyMatch(x -> x == client.getLocalPlayer().getAnimation()) ||
			+Duration.between(lastAction, Instant.now()).getSeconds() < 3;
	}

	@Override
	public String getActionName()
	{
		return "Cooked";
	}

	@Override
	public int getActions()
	{
		return cookedAmount;
	}

	@Override
	public void modifyPanel(PanelComponent panelComponent, Client client)
	{
		super.modifyPanel(panelComponent, client);
		panelComponent.getLines().add(new PanelComponent.Line("Burnt:", Integer.toString(burntAmount)
			+ " (" + getBurntPercentage() + "%)"));
	}
}
