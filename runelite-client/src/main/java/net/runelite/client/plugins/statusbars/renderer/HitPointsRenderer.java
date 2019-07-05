/*
 * Copyright (c) 2018, Rheon <https://github.com/Rheon-D>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package net.runelite.client.plugins.statusbars.renderer;

import java.awt.Color;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.statusbars.StatusBarsOverlay;
import net.runelite.client.plugins.statusbars.StatusBarsPlugin;

@Singleton
public class HitPointsRenderer extends BarRenderer
{
	private static final Color COLOR_STANDARD = new Color(225, 35, 0, 125);
	private static final Color COLOR_POISON = new Color(0, 145, 0, 150);
	private static final Color COLOR_VENOM = new Color(0, 65, 0, 150);

	@Inject
	public HitPointsRenderer(final StatusBarsPlugin plugin, final SkillIconManager iconManager)
	{
		super(plugin);
		icon = iconManager.getSkillImage(Skill.HITPOINTS, true);
		restoreColor = new Color(255, 112, 6, 150);
	}

	@Override
	protected void update(Client client, StatusBarsOverlay overlay)
	{
		maximumValue = client.getRealSkillLevel(Skill.HITPOINTS);
		currentValue = client.getBoostedSkillLevel(Skill.HITPOINTS);
		restore = overlay.getRestoreValue(Skill.HITPOINTS.getName());

		final int poisonState = client.getVar(VarPlayer.IS_POISONED);

		if (poisonState > 0 && poisonState < 50)
		{
			standardColor = COLOR_POISON;
		}
		else if (poisonState >= 1000000)
		{
			standardColor = COLOR_VENOM;
		}
		else
		{
			standardColor = COLOR_STANDARD;
		}
	}
}
