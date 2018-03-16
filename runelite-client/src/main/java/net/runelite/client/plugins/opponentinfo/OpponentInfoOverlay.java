/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.BackgroundComponent;
import net.runelite.client.ui.overlay.components.TextComponent;
import net.runelite.client.util.Text;

class OpponentInfoOverlay extends Overlay
{
	private static final int WIDTH = 129;

	private static final int TOP_BORDER = 4;
	private static final int BOTTOM_BORDER = 4;

	private static final int BAR_WIDTH = WIDTH - 10;
	private static final int BAR_HEIGHT = 16;

	private static final Color HP_GREEN = new Color(0, 146, 54, 230);
	private static final Color HP_RED = new Color(102, 15, 16, 230);
	private static final Duration WAIT = Duration.ofSeconds(3);

	private final Client client;
	private final NPC[] clientNpcs;

	private Integer lastMaxHealth;
	private DecimalFormat df = new DecimalFormat("0.0");
	private float lastRatio = 0;
	private Instant lastTime = Instant.now();
	private String opponentName;
	private String opponentsOpponentName;
	private Map<String, Integer> oppInfoHealth = OpponentInfoPlugin.loadNpcHealth();
	private NPC lastOpponent;

	@Inject
	OpponentInfoOverlay(Client client)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.HIGH);
		this.client = client;
		this.clientNpcs = client.getCachedNPCs();
	}

	private Actor getOpponent()
	{
		Player player = client.getLocalPlayer();
		if (player == null)
		{
			return null;
		}

		return player.getInteracting();
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		Actor opponent = getOpponent();

		// If opponent is null, try to use last opponent
		if (opponent == null)
		{
			if (lastOpponent != null && clientNpcs[lastOpponent.getIndex()] != lastOpponent)
			{
				// lastOpponent is no longer valid
				lastOpponent = null;
			}
			else
			{
				opponent = lastOpponent;
			}
		}
		else
		{
			// Update last opponent
			lastOpponent = opponent instanceof NPC ? (NPC) opponent : null;
		}

		if (opponent != null && opponent.getHealth() > 0)
		{
			lastTime = Instant.now();
			lastRatio = (float) opponent.getHealthRatio() / (float) opponent.getHealth();
			opponentName = Text.removeTags(opponent.getName());
			lastMaxHealth = oppInfoHealth.get(opponentName + "_" + opponent.getCombatLevel());

			Actor opponentsOpponent = opponent.getInteracting();
			if (opponentsOpponent != null
					&& (opponentsOpponent != client.getLocalPlayer() || client.getSetting(Varbits.MULTICOMBAT_AREA) == 1))
			{
				opponentsOpponentName = Text.removeTags(opponentsOpponent.getName());
			}
			else
			{
				opponentsOpponentName = null;
			}
		}

		if (Duration.between(Instant.now(), lastTime).abs().compareTo(WAIT) > 0)
		{
			return null; //don't draw anything.
		}

		FontMetrics fm = graphics.getFontMetrics();

		int height = TOP_BORDER + fm.getHeight(); // opponent name
		if (lastRatio >= 0)
		{
			height += BAR_HEIGHT + 6;
		}
		if (opponentsOpponentName != null)
		{
			height += fm.getHeight() + 3;
		}
		height += 3;
		height += BOTTOM_BORDER;

		final BackgroundComponent backgroundComponent = new BackgroundComponent();
		backgroundComponent.setRectangle(new Rectangle(0, 0, WIDTH, height));
		backgroundComponent.render(graphics, parent);

		int y = TOP_BORDER + fm.getHeight();

		{
			int x = (WIDTH - fm.stringWidth(opponentName)) / 2;
			final TextComponent textComponent = new TextComponent();
			textComponent.setPosition(new Point(x, y));
			textComponent.setText(opponentName);
			textComponent.render(graphics, parent);

			y += 3;
		}

		if (lastRatio >= 0)
		{
			int barWidth = (int) (lastRatio * (float) BAR_WIDTH);
			y += 3;

			graphics.setColor(HP_GREEN);
			graphics.fillRect((WIDTH - BAR_WIDTH) / 2, y, barWidth, BAR_HEIGHT);

			graphics.setColor(HP_RED);
			graphics.fillRect(((WIDTH - BAR_WIDTH) / 2) + barWidth, y, BAR_WIDTH - barWidth, BAR_HEIGHT);

			String str;

			if (lastMaxHealth != null)
			{
				int currHealth = (int) (lastRatio * lastMaxHealth);
				str = currHealth + "/" + lastMaxHealth;
			}
			else
			{
				str = df.format(lastRatio * 100) + "%";
			}

			y += BAR_HEIGHT;

			final TextComponent textComponent1 = new TextComponent();
			textComponent1.setText(str);
			textComponent1.setPosition(new Point((WIDTH - fm.stringWidth(str)) / 2, y));
			textComponent1.render(graphics, parent);

			y += 3;
		}

		if (opponentsOpponentName != null)
		{
			y += fm.getHeight();

			int x = (WIDTH - fm.stringWidth(opponentsOpponentName)) / 2;
			final TextComponent textComponent = new TextComponent();
			textComponent.setPosition(new Point(x, y));
			textComponent.setText(opponentsOpponentName);
			textComponent.render(graphics, parent);
		}

		return new Dimension(WIDTH, height);
	}
}
