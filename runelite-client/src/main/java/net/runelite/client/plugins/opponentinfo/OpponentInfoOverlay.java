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
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.game.HiscoreManager;
import net.runelite.client.game.NPCManager;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.ComponentConstants;
import net.runelite.client.ui.overlay.components.ProgressBarComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import net.runelite.client.util.Text;
import net.runelite.client.util.WildcardMatcher;
import net.runelite.http.api.hiscore.HiscoreResult;

class OpponentInfoOverlay extends OverlayPanel
{
	private static final Color HP_GREEN = new Color(0, 146, 54, 230);
	private static final Color HP_RED = new Color(102, 15, 16, 230);
	private static final Color FONT_WHITE = new Color(15395562);
	/**
	 * using these non-final values so that the colors can be changed. Using the HP_GREEN, HP_RED and FONT_WHITE colors
	 * for resetting the colors
	 */
	private Color HP_Foreground = HP_GREEN;
	private Color HP_Background = HP_RED;
	private Color HP_FontColor = FONT_WHITE;

	private final OpponentInfoPlugin opponentInfoPlugin;
	private final OpponentInfoConfig opponentInfoConfig;
	private final HiscoreManager hiscoreManager;
	private final NPCManager npcManager;

	private Integer lastMaxHealth;
	private int lastRatio;
	private int lastHealthScale;

	private String opponentName;
	private int vanillaHealthBarHealth;
	private int vanillaHealthBarMaxHealth;
	private String vanillaHealthBarOpponentName;
	boolean useVanilla;

	@Inject
	private OpponentInfoOverlay(
		OpponentInfoPlugin opponentInfoPlugin,
		OpponentInfoConfig opponentInfoConfig,
		HiscoreManager hiscoreManager,
		NPCManager npcManager)
	{
		super(opponentInfoPlugin);
		this.opponentInfoPlugin = opponentInfoPlugin;
		this.opponentInfoConfig = opponentInfoConfig;
		this.hiscoreManager = hiscoreManager;
		this.npcManager = npcManager;

		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.HIGH);

		panelComponent.setBorder(new Rectangle(2, 2, 2, 2));
		panelComponent.setGap(new Point(0, 2));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Opponent info overlay"));
	}

	public void updateHealthBarVars(int lastHealth, int maxHealth, String bossName)
	{
		Widget vanillaHealthBar = client.getWidget(WidgetInfo.HEALTH_OVERLAY_BAR);

		if (bossName != null)
		{
			useVanilla = false;
			for (String boss : opponentInfoConfig.vanillaHealthBarOverride().split(","))
			{
				if (WildcardMatcher.matches(boss.toLowerCase().trim(), bossName.toLowerCase().trim()))
				{
					useVanilla = true;
					break;
				}
			}
		}

		if (vanillaHealthBar != null && (!useVanilla) && opponentInfoConfig.mergeVanillaHealthBar())
		{
			vanillaHealthBar.setHidden(true);
		}

		vanillaHealthBarHealth = lastHealth;
		vanillaHealthBarMaxHealth = maxHealth;
		vanillaHealthBarOpponentName = bossName;

		if (lastHealth == 0 || maxHealth == 0 || bossName == null)
		{
			//if any of these values are zero/null, the Vanilla Health Bar is supposed to disappear,
			//or the opponent is dead, so remove the vanilla opponent name and max health vars,
			//and reset the color
			vanillaHealthBarOpponentName = null;
			vanillaHealthBarMaxHealth = 0;
			resetColors();
		}
	}

	public void setVanillaHealthText()
	{
		int lastHealth = client.getVar(Varbits.HEALTH_OVERLAY_BAR_CURRENT_VALUE);
		int maxHealth = client.getVar(Varbits.HEALTH_OVERLAY_BAR_MAX_VALUE);

		Widget vanillaHealthBarHealthText = client.getWidget(WidgetInfo.HEALTH_OVERLAY_HEALTH_TEXT);
			if (vanillaHealthBarHealthText != null && lastHealth != 0 && maxHealth != 0)
			{
				vanillaHealthBarHealthText.setText(opponentInfoConfig.showVanillaPercentages() ?
					lastHealth + " / " + maxHealth + " (" + String.format("%.1f", (lastHealth * 100.0) / maxHealth) + "%)" :
					lastHealth + " / " + maxHealth);
			}
	}

	public void setHealthBarColors()
	{
		Widget vanillaBackgroundColor = client.getWidget(WidgetInfo.HEALTH_OVERLAY_BAR_BACKGROUND);
		Widget vanillaForegroundColor = client.getWidget(WidgetInfo.HEALTH_OVERLAY_BAR_FOREGROUND);
		Widget vanillaHealthText = client.getWidget(WidgetInfo.HEALTH_OVERLAY_HEALTH_TEXT);

		if (vanillaBackgroundColor != null)
		{
			HP_Background = new Color(vanillaBackgroundColor.getTextColor());
		}
		else
		{
			HP_Background = HP_RED;
		}

		if (vanillaForegroundColor != null)
		{
			HP_Foreground = new Color(vanillaForegroundColor.getTextColor());
		}
		else
		{
			HP_Foreground = HP_GREEN;
		}

		if (vanillaHealthText != null)
		{
			HP_FontColor = new Color(vanillaHealthText.getTextColor());
		}
		else
		{
			HP_FontColor = FONT_WHITE;
		}
	}

	public void unHideVanillaHealthBar()
	{
		Widget vanillaHealthBar = client.getWidget(WidgetInfo.HEALTH_OVERLAY_BAR);

		if (vanillaHealthBar != null)
		{
			vanillaHealthBar.setHidden(false);
		}

		setVanillaHealthText();
		resetColors();
	}

	public void resetColors()
	{
		HP_Background = HP_RED;
		HP_Foreground = HP_GREEN;
		HP_FontColor = FONT_WHITE;
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (useVanilla && opponentInfoConfig.mergeVanillaHealthBar())
		{
			return null;
		}

		final Actor opponent = opponentInfoPlugin.getLastOpponent();

		if (opponent != null)
		{
			if (opponent.getName() != null && opponent.getHealthScale() > 0)
			{
				lastRatio = opponent.getHealthRatio();
				lastHealthScale = opponent.getHealthScale();
				opponentName = Text.removeTags(opponent.getName());

				lastMaxHealth = null;
				if (opponent instanceof NPC)
				{
					lastMaxHealth = npcManager.getHealth(((NPC) opponent).getId());
				}
				else if (opponent instanceof Player)
				{
					//this method doesn't work for the nightmare/changing health bosses
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
			}

			if (vanillaHealthBarOpponentName != null && opponentName == null)
			{
				opponentName = vanillaHealthBarOpponentName;
			}
			else if (vanillaHealthBarOpponentName == null && opponentName == null)
			{
				return null;
			}
		}

		if (vanillaHealthBarMaxHealth != 0 && opponentInfoConfig.mergeVanillaHealthBar())
		{
			lastMaxHealth = vanillaHealthBarMaxHealth;
			lastHealthScale = vanillaHealthBarMaxHealth;
			opponentName = vanillaHealthBarOpponentName;
			lastRatio = vanillaHealthBarHealth;
		}

		if ((opponent == null && (vanillaHealthBarMaxHealth == 0 || !opponentInfoConfig.mergeVanillaHealthBar())) ||
			opponentName == null)
		{
			opponentName = null;
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
			progressBarComponent.setBackgroundColor(HP_Background);
			progressBarComponent.setForegroundColor(HP_Foreground);
			progressBarComponent.setFontColor(HP_FontColor);

			final HitpointsDisplayStyle displayStyle = opponentInfoConfig.hitpointsDisplayStyle();

			if ((displayStyle == HitpointsDisplayStyle.HITPOINTS || displayStyle == HitpointsDisplayStyle.BOTH)
				&& lastMaxHealth != null)
			{
				// This is the reverse of the calculation of healthRatio done by the server
				// which is: healthRatio = 1 + (healthScale - 1) * health / maxHealth (if health > 0, 0 otherwise)
				// It's able to recover the exact health if maxHealth <= healthScale.

				/*
				 * vanillaHealthBarHealth is non-zero if the vanilla health overlay is active;
				 * The max and min health don't have to be calculated then.
				 * If the health overlay isn't active, the health value will be zero.
				 */
				int health = vanillaHealthBarHealth;

				if (lastRatio > 0 && vanillaHealthBarHealth != 0)
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
}
