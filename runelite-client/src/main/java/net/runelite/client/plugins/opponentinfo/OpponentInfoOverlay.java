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
import javax.inject.Singleton;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import static net.runelite.api.MenuOpcode.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.Varbits;
import net.runelite.client.ui.overlay.Overlay;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.ProgressBarComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.api.util.Text;

@Singleton
class OpponentInfoOverlay extends Overlay
{
	private static final Color HP_GREEN = new Color(0, 146, 54, 230);
	private static final Color HP_RED = new Color(102, 15, 16, 230);

	private final Client client;
	private final OpponentInfoPlugin opponentInfoPlugin;

	private final PanelComponent panelComponent = new PanelComponent();

	private int lastMaxHealth;
	private int lastRatio = 0;
	private int lastHealthScale = 0;
	private String opponentName;
	private String opponentsOpponentName;

	@Inject
	private OpponentInfoOverlay(
		final Client client,
		final OpponentInfoPlugin opponentInfoPlugin)
	{
		super(opponentInfoPlugin);
		this.client = client;
		this.opponentInfoPlugin = opponentInfoPlugin;

		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.HIGH);

		panelComponent.setBorder(new Rectangle(2, 2, 2, 2));
		panelComponent.setGap(new Point(0, 2));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Opponent info overlay"));
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
			lastRatio = opponent.getHealthRatio();
			lastHealthScale = opponent.getHealth();
			opponentName = Text.removeTags(opponent.getName());

			lastMaxHealth = opponentInfoPlugin.getMaxHp(opponent);

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
		if (lastRatio >= 0 && lastHealthScale > 0)
		{
			final ProgressBarComponent progressBarComponent = new ProgressBarComponent();
			progressBarComponent.setBackgroundColor(HP_RED);
			progressBarComponent.setForegroundColor(HP_GREEN);

			final HitpointsDisplayStyle displayStyle = opponentInfoPlugin.getHitpointsDisplayStyle();

			if ((displayStyle == HitpointsDisplayStyle.HITPOINTS || displayStyle == HitpointsDisplayStyle.BOTH)
				&& lastMaxHealth != -1)
			{
				int health = getExactHp(lastRatio, lastHealthScale, lastMaxHealth);

				// Show both the hitpoint and percentage values if enabled in the config
				final ProgressBarComponent.LabelDisplayMode progressBarDisplayMode = displayStyle == HitpointsDisplayStyle.BOTH ?
					ProgressBarComponent.LabelDisplayMode.BOTH : ProgressBarComponent.LabelDisplayMode.FULL;

				progressBarComponent.setLabelDisplayMode(progressBarDisplayMode);
				progressBarComponent.setMaximum(lastMaxHealth);
				progressBarComponent.setValue(health);
			}
			else
			{
				float floatRatio = (float) lastRatio / (float) lastHealthScale;
				progressBarComponent.setValue(floatRatio * 100d);
			}

			panelComponent.getChildren().add(progressBarComponent);
		}

		// Opponents opponent
		if (opponentsOpponentName != null && opponentInfoPlugin.isShowOpponentsOpponent())
		{
			textWidth = Math.max(textWidth, fontMetrics.stringWidth(opponentsOpponentName));
			panelComponent.setPreferredSize(new Dimension(textWidth, 0));
			panelComponent.getChildren().add(TitleComponent.builder()
				.text(opponentsOpponentName)
				.build());
		}

		return panelComponent.render(graphics);
	}

	static int getExactHp(int ratio, int health, int maxHp)
	{
		if (ratio < 0 || health <= 0 || maxHp == -1)
		{
			return -1;
		}

		int exactHealth = 0;

		// This is the reverse of the calculation of healthRatio done by the server
		// which is: healthRatio = 1 + (healthScale - 1) * health / maxHealth (if health > 0, 0 otherwise)
		// It's able to recover the exact health if maxHealth <= healthScale.
		if (ratio > 0)
		{
			int minHealth = 1;
			int maxHealth;
			if (health > 1)
			{
				if (ratio > 1)
				{
					// This doesn't apply if healthRatio = 1, because of the special case in the server calculation that
					// health = 0 forces healthRatio = 0 instead of the expected healthRatio = 1
					minHealth = (maxHp * (ratio - 1) + health - 2) / (health - 1);
				}
				maxHealth = (maxHp * ratio - 1) / (health - 1);
				if (maxHealth > maxHp)
				{
					maxHealth = maxHp;
				}
			}
			else
			{
				// If healthScale is 1, healthRatio will always be 1 unless health = 0
				// so we know nothing about the upper limit except that it can't be higher than maxHealth
				maxHealth = maxHp;
			}
			// Take the average of min and max possible healths
			exactHealth = (minHealth + maxHealth + 1) / 2;
		}

		return exactHealth;
	}
}
