/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.opponentinfo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Player;
import net.runelite.api.Skill;
import net.runelite.api.util.Text;
import net.runelite.client.game.HiscoreManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;
import net.runelite.client.util.ColorUtil;
import net.runelite.http.api.hiscore.HiscoreResult;
import net.runelite.http.api.hiscore.HiscoreSkill;

@Singleton
class PlayerComparisonOverlay extends Overlay
{
	private static final Color HIGHER_STAT_TEXT_COLOR = Color.GREEN;
	private static final Color LOWER_STAT_TEXT_COLOR = Color.RED;
	private static final Color NEUTRAL_TEXT_COLOR = Color.WHITE;
	private static final Color HIGHLIGHT_COLOR = new Color(255, 200, 0, 255);

	private static final Skill[] COMBAT_SKILLS = new Skill[]{
		Skill.ATTACK,
		Skill.STRENGTH,
		Skill.DEFENCE,
		Skill.HITPOINTS,
		Skill.RANGED,
		Skill.MAGIC,
		Skill.PRAYER
	};

	private static final HiscoreSkill[] HISCORE_COMBAT_SKILLS = new HiscoreSkill[]{
		HiscoreSkill.ATTACK,
		HiscoreSkill.STRENGTH,
		HiscoreSkill.DEFENCE,
		HiscoreSkill.HITPOINTS,
		HiscoreSkill.RANGED,
		HiscoreSkill.MAGIC,
		HiscoreSkill.PRAYER
	};

	private static final String SKILL_COLUMN_HEADER = "Skill";
	private static final String PLAYER_COLUMN_HEADER = "You";
	private static final String OPPONENT_COLUMN_HEADER = "Them";

	private final Client client;
	private final OpponentInfoPlugin opponentInfoPlugin;
	private final HiscoreManager hiscoreManager;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private PlayerComparisonOverlay(final Client client, final OpponentInfoPlugin opponentInfoPlugin, final HiscoreManager hiscoreManager)
	{
		super(opponentInfoPlugin);
		this.client = client;
		this.opponentInfoPlugin = opponentInfoPlugin;
		this.hiscoreManager = hiscoreManager;

		setPosition(OverlayPosition.BOTTOM_LEFT);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Opponent info overlay"));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!opponentInfoPlugin.isLookupOnInteraction())
		{
			return null;
		}

		final Actor opponent = opponentInfoPlugin.getLastOpponent();

		if (opponent == null)
		{
			return null;
		}

		// Don't try to look up NPC names
		if (!(opponent instanceof Player))
		{
			return null;
		}

		final String opponentName = Text.removeTags(opponent.getName());
		final HiscoreResult hiscoreResult = hiscoreManager.lookupAsync(opponentName, opponentInfoPlugin.getHiscoreEndpoint());
		if (hiscoreResult == null)
		{
			return null;
		}

		panelComponent.getChildren().clear();
		generateComparisonTable(panelComponent, hiscoreResult);
		return panelComponent.render(graphics);
	}

	private void generateComparisonTable(PanelComponent panelComponent, HiscoreResult opponentSkills)
	{
		final String opponentName = opponentSkills.getPlayer();

		panelComponent.getChildren().add(
			TitleComponent.builder()
				.text(opponentName)
				.color(HIGHLIGHT_COLOR)
				.build());

		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.CENTER, TableAlignment.RIGHT);
		tableComponent.addRow(
			ColorUtil.prependColorTag(SKILL_COLUMN_HEADER, HIGHLIGHT_COLOR),
			ColorUtil.prependColorTag(PLAYER_COLUMN_HEADER, HIGHLIGHT_COLOR),
			ColorUtil.prependColorTag(OPPONENT_COLUMN_HEADER, HIGHLIGHT_COLOR));

		for (int i = 0; i < COMBAT_SKILLS.length; ++i)
		{
			final HiscoreSkill hiscoreSkill = HISCORE_COMBAT_SKILLS[i];
			final Skill skill = COMBAT_SKILLS[i];

			final net.runelite.http.api.hiscore.Skill opponentSkill = opponentSkills.getSkill(hiscoreSkill);

			if (opponentSkill == null || opponentSkill.getLevel() == -1)
			{
				continue;
			}

			final int playerSkillLevel = client.getRealSkillLevel(skill);
			final int opponentSkillLevel = opponentSkill.getLevel();

			tableComponent.addRow(
				hiscoreSkill.getName(),
				ColorUtil.prependColorTag(Integer.toString(playerSkillLevel), comparisonStatColor(playerSkillLevel, opponentSkillLevel)),
				ColorUtil.prependColorTag(Integer.toString(opponentSkillLevel), comparisonStatColor(opponentSkillLevel, playerSkillLevel)));
		}

		panelComponent.getChildren().add(tableComponent);
	}

	private static Color comparisonStatColor(int a, int b)
	{
		if (a > b)
		{
			return HIGHER_STAT_TEXT_COLOR;
		}
		if (a < b)
		{
			return LOWER_STAT_TEXT_COLOR;
		}
		return NEUTRAL_TEXT_COLOR;
	}
}
