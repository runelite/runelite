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

import com.google.common.base.Strings;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.ParamID;
import net.runelite.api.Player;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.client.game.NPCManager;
import net.runelite.client.hiscore.HiscoreManager;
import net.runelite.client.hiscore.HiscoreResult;
import net.runelite.client.hiscore.HiscoreSkill;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ProgressBarComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.Text;

class OpponentInfoOverlay extends OverlayPanel
{
	private static final Color HP_GREEN = new Color(0, 146, 54, 230);
	private static final Color HP_RED = new Color(102, 15, 16, 230);

	private final Client client;
	private final OpponentInfoPlugin opponentInfoPlugin;
	private final OpponentInfoConfig opponentInfoConfig;
	private final HiscoreManager hiscoreManager;
	private final NPCManager npcManager;

	private Integer lastMaxHealth;
	private int lastRatio = 0;
	private int lastHealthScale = 0;
	private String opponentName;

	@Inject
	private OpponentInfoOverlay(
		Client client,
		OpponentInfoPlugin opponentInfoPlugin,
		OpponentInfoConfig opponentInfoConfig,
		HiscoreManager hiscoreManager,
		NPCManager npcManager)
	{
		super(opponentInfoPlugin);
		this.client = client;
		this.opponentInfoPlugin = opponentInfoPlugin;
		this.opponentInfoConfig = opponentInfoConfig;
		this.hiscoreManager = hiscoreManager;
		this.npcManager = npcManager;

		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(PRIORITY_HIGH);

		panelComponent.setBorder(new Rectangle(2, 2, 2, 2));
		panelComponent.setGap(new Point(0, 2));
		addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Opponent info overlay");
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

		if (opponent.getName() != null && opponent.getHealthScale() > 0)
		{
			lastRatio = opponent.getHealthRatio();
			lastHealthScale = opponent.getHealthScale();
			opponentName = Text.removeTags(opponent.getName());

			lastMaxHealth = null;
			if (opponent instanceof NPC)
			{
				NPCComposition composition = ((NPC) opponent).getTransformedComposition();
				if (composition != null)
				{
					String longName = composition.getStringValue(ParamID.NPC_HP_NAME);
					if (!Strings.isNullOrEmpty(longName))
					{
						opponentName = longName;
					}
				}
				lastMaxHealth = npcManager.getHealth(((NPC) opponent).getId());
			}
			else if (opponent instanceof Player)
			{
				final HiscoreResult hiscoreResult = hiscoreManager.lookupAsync(opponentName, opponentInfoPlugin.getHiscoreEndpoint());
				if (hiscoreResult != null)
				{
					final int hp = hiscoreResult.getSkill(HiscoreSkill.HITPOINTS).getLevel();
					if (hp > 0)
					{
						lastMaxHealth = hp;
					}
				}
			}
		}

		// The in-game hp hud is more accurate than our overlay and duplicates all of the information on it,
		// so hide ours if it is visible, or if our overlay is toggled off.
		if (opponentName == null || hasHpHud(opponent) || !opponentInfoConfig.showOpponentHealthOverlay())
		{
			return null;
		}

		final FontMetrics fontMetrics = graphics.getFontMetrics();

		// Opponent name
		int panelWidth = Math.max(ComponentConstants.STANDARD_WIDTH, fontMetrics.stringWidth(opponentName) + ComponentConstants.STANDARD_BORDER + ComponentConstants.STANDARD_BORDER);
		panelComponent.setPreferredSize(new Dimension(panelWidth, 0));
		panelComponent.getChildren().add(TitleComponent.builder()
			.text(opponentName)
			.build());

		// Health bar
		if (lastRatio >= 0 && lastHealthScale > 0)
		{
			final ProgressBarComponent progressBarComponent = new ProgressBarComponent();
			progressBarComponent.setBackgroundColor(HP_RED);
			progressBarComponent.setForegroundColor(HP_GREEN);

			final HitpointsDisplayStyle displayStyle = opponentInfoConfig.hitpointsDisplayStyle();

			if ((displayStyle == HitpointsDisplayStyle.HITPOINTS || displayStyle == HitpointsDisplayStyle.BOTH)
				&& lastMaxHealth != null)
			{
				// This is the reverse of the calculation of healthRatio done by the server
				// which is: healthRatio = 1 + (healthScale - 1) * health / maxHealth (if health > 0, 0 otherwise)
				// It's able to recover the exact health if maxHealth <= healthScale.
				int health = 0;
				if (lastRatio > 0)
				{
					int minHealth = 1;
					int maxHealth;
					if (lastHealthScale > 1)
					{
						if (lastRatio > 1)
						{
							// This doesn't apply if healthRatio = 1, because of the special case in the server calculation that
							// health = 0 forces healthRatio = 0 instead of the expected healthRatio = 1
							minHealth = (lastMaxHealth * (lastRatio - 1) + lastHealthScale - 2) / (lastHealthScale - 1);
						}
						maxHealth = (lastMaxHealth * lastRatio - 1) / (lastHealthScale - 1);
						if (maxHealth > lastMaxHealth)
						{
							maxHealth = lastMaxHealth;
						}
					}
					else
					{
						// If healthScale is 1, healthRatio will always be 1 unless health = 0
						// so we know nothing about the upper limit except that it can't be higher than maxHealth
						maxHealth = lastMaxHealth;
					}
					// Take the average of min and max possible healths
					health = (minHealth + maxHealth + 1) / 2;
				}

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

		return super.render(graphics);
	}

	/**
	 * Check if the hp hud is active for an opponent
	 * @param opponent
	 * @return
	 */
	private boolean hasHpHud(Actor opponent)
	{
		boolean settingEnabled = client.getVarbitValue(Varbits.BOSS_HEALTH_OVERLAY) == 0;
		if (settingEnabled && opponent instanceof NPC)
		{
			int opponentId = client.getVarpValue(VarPlayer.HP_HUD_NPC_ID);
			NPC npc = (NPC) opponent;
			return opponentId != -1 && npc.getComposition() != null && opponentId == npc.getComposition().getId();
		}
		return false;
	}
}
