/*
 * Copyright (c) 2016-2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import static net.runelite.api.NpcID.*;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.client.game.HiscoreManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.ProgressBarComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.Text;
import net.runelite.http.api.hiscore.HiscoreResult;

class OpponentInfoOverlay extends Overlay
{
	private static final Color HP_GREEN = new Color(0, 146, 54, 230);
	private static final Color HP_RED = new Color(102, 15, 16, 230);

	private final Client client;
	private final OpponentInfoPlugin opponentInfoPlugin;
	private final OpponentInfoConfig opponentInfoConfig;
	private final HiscoreManager hiscoreManager;

	private final PanelComponent panelComponent = new PanelComponent();

	private Integer lastMaxHealth;
	private float lastRatio = 0;
	private String opponentName;
	private String opponentsOpponentName;

	@Inject
	private OpponentInfoOverlay(Client client, OpponentInfoPlugin opponentInfoPlugin,
		OpponentInfoConfig opponentInfoConfig, HiscoreManager hiscoreManager)
	{
		this.client = client;
		this.opponentInfoPlugin = opponentInfoPlugin;
		this.opponentInfoConfig = opponentInfoConfig;
		this.hiscoreManager = hiscoreManager;

		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.HIGH);

		panelComponent.setBorder(new Rectangle(2, 2, 2, 2));
		panelComponent.setGap(new Point(0, 2));
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		final Actor opponent = opponentInfoPlugin.getLastOpponent();

		if (opponent == null)
		{
			opponentName = null;
			return null;
		}

		if (opponent.getName() != null && opponent.getHealth() > 0)
		{
			if (opponentInfoConfig.hideOnExisting() && opponent instanceof NPC && bossHasHealthBar(((NPC) opponent).getId()))
			{
				return null;
			}
			lastRatio = (float) opponent.getHealthRatio() / (float) opponent.getHealth();
			opponentName = Text.removeTags(opponent.getName());

			lastMaxHealth = null;
			if (opponent instanceof NPC)
			{
				lastMaxHealth = opponentInfoPlugin.getOppInfoHealth().get(opponentName + "_" + opponent.getCombatLevel());
			}
			else if (opponent instanceof Player)
			{
				final HiscoreResult hiscoreResult = hiscoreManager.lookupAsync(opponentName, opponentInfoPlugin.getHiscoreEndpoint());
				if (hiscoreResult != null)
				{
					final int hp = hiscoreResult.getHitpoints().getLevel();
					if (hp > 0)
					{
						lastMaxHealth = hp;
					}
				}
			}

			final Actor opponentsOpponent = opponent.getInteracting();
			if (opponentsOpponent != null
					&& (opponentsOpponent != client.getLocalPlayer() || client.getVar(Varbits.MULTICOMBAT_AREA) == 1))
			{
				opponentsOpponentName = Text.removeTags(opponentsOpponent.getName());
			}
			else
			{
				opponentsOpponentName = null;
			}
		}

		if (opponentName == null)
		{
			return null;
		}

		final FontMetrics fontMetrics = graphics.getFontMetrics();

		panelComponent.getChildren().clear();

		// Opponent name
		int textWidth = Math.max(ComponentConstants.STANDARD_WIDTH, fontMetrics.stringWidth(opponentName));
		panelComponent.setPreferredSize(new Dimension(textWidth, 0));
		panelComponent.getChildren().add(TitleComponent.builder()
			.text(opponentName)
			.build());

		// Health bar
		if (lastRatio >= 0)
		{
			final ProgressBarComponent progressBarComponent = new ProgressBarComponent();
			progressBarComponent.setBackgroundColor(HP_RED);
			progressBarComponent.setForegroundColor(HP_GREEN);

			if (lastMaxHealth != null && !opponentInfoConfig.showPercent())
			{
				progressBarComponent.setLabelDisplayMode(ProgressBarComponent.LabelDisplayMode.FULL);
				progressBarComponent.setMaximum(lastMaxHealth);
				progressBarComponent.setValue(lastRatio * lastMaxHealth);
			}
			else
			{
				progressBarComponent.setValue(lastRatio * 100d);
			}

			panelComponent.getChildren().add(progressBarComponent);
		}

		// Opponents opponent
		if (opponentsOpponentName != null)
		{
			textWidth = Math.max(textWidth, fontMetrics.stringWidth(opponentsOpponentName));
			panelComponent.setPreferredSize(new Dimension(textWidth, 0));
			panelComponent.getChildren().add(TitleComponent.builder()
				.text(opponentsOpponentName)
				.build());
		}

		return panelComponent.render(graphics);
	}

	private static boolean bossHasHealthBar(int bossId)
	{
		switch (bossId)
		{
			// All defined in NpcID.java
			case TZKALZUK:
			case THE_MAIDEN_OF_SUGADINTI:
			case THE_MAIDEN_OF_SUGADINTI_8361:
			case THE_MAIDEN_OF_SUGADINTI_8362:
			case THE_MAIDEN_OF_SUGADINTI_8363:
			case THE_MAIDEN_OF_SUGADINTI_8364:
			case THE_MAIDEN_OF_SUGADINTI_8365:
			case PESTILENT_BLOAT:
			case XARPUS:
			case XARPUS_8339:
			case XARPUS_8340:
			case XARPUS_8341:
			case VERZIK_VITUR:
			case VERZIK_VITUR_8369:
			case VERZIK_VITUR_8370:
			case VERZIK_VITUR_8371:
			case VERZIK_VITUR_8372:
			case VERZIK_VITUR_8373:
			case VERZIK_VITUR_8374:
			case VERZIK_VITUR_8375:
			case GALVEK:
				return true;
			default:
				return false;
		}
	}
}
