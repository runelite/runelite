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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

import net.runelite.api.Actor;
import net.runelite.api.Client;

import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;

import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
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

	private final Client client;
	private final OpponentInfoPlugin opponentInfoPlugin;
	private final OpponentInfoConfig opponentInfoConfig;
	private final HiscoreManager hiscoreManager;
	private final NPCManager npcManager;
	private final ClientThread clientThread;

	private Integer lastMaxHealth;
	private int lastRatio = 0;
	private int lastHealthScale = 0;
	private String opponentName;
	private int raidOpponentHealth = 0;
	private int raidOpponentMaxHealth = 0;
	private String raidOpponentName;
	private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
	boolean useVanilla = false;
	boolean shouldUnHide = false;

	@Inject
	private OpponentInfoOverlay(
		Client client,
		OpponentInfoPlugin opponentInfoPlugin,
		OpponentInfoConfig opponentInfoConfig,
		HiscoreManager hiscoreManager,
		NPCManager npcManager,
		ClientThread clientThread)
	{
		super(opponentInfoPlugin);
		this.client = client;
		this.opponentInfoPlugin = opponentInfoPlugin;
		this.opponentInfoConfig = opponentInfoConfig;
		this.hiscoreManager = hiscoreManager;
		this.npcManager = npcManager;
		this.clientThread = clientThread;

		setPosition(OverlayPosition.TOP_LEFT);
		setPriority(OverlayPriority.HIGH);

		panelComponent.setBorder(new Rectangle(2, 2, 2, 2));
		panelComponent.setGap(new Point(0, 2));
		getMenuEntries().add(new OverlayMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Opponent info overlay"));
	}

	public void updateRaidVars(int lastHealth)
	{
		if (opponentInfoConfig.mergeRaidOverlay() || opponentInfoConfig.showVanillaPercentages())
		{
			clientThread.invokeLater(() -> {
				//hide the raid health bar, since the opponent info will take its place,
				//and initialize the variables if they aren't loaded yet.
				Widget raidOpponentWrapper = client.getWidget(303, 6);
				Widget raidOpponentNameWidget = client.getWidget(303, 11);
				Widget raidOpponentHealthWidget = client.getWidget(303, 20);

				if (raidOpponentNameWidget != null)
				{
					useVanilla = false;

					if (lastHealth != 0)
					{
						for (String boss : opponentInfoConfig.vanillaHPBarOverride().split(","))
						{
							if (WildcardMatcher.matches(boss.toLowerCase().trim(), raidOpponentNameWidget.getText().toLowerCase().trim()))
							{
								useVanilla = true;
								break;
							}
						}
					}
				}

				if (raidOpponentWrapper != null && (!useVanilla && opponentInfoConfig.mergeRaidOverlay()))
				{
					raidOpponentWrapper.setHidden(true);
					shouldUnHide = false;
				}

				if (raidOpponentNameWidget != null && raidOpponentName == null)
				{
					raidOpponentName = raidOpponentNameWidget.getText();
				}

				if (raidOpponentHealthWidget != null && raidOpponentMaxHealth == 0)
				{
					raidOpponentMaxHealth = Integer.parseInt(raidOpponentHealthWidget.getText().split(" / ")[1].split(" \\(")[0]);
				}

				else if (raidOpponentHealthWidget != null && opponentInfoConfig.showVanillaPercentages())
				{
					raidOpponentHealthWidget.setText(lastHealth + " / " + raidOpponentMaxHealth + " (" + String.format("%.1f", (lastHealth * 100.0) / raidOpponentMaxHealth) + "%)");
				}

				raidOpponentHealth = lastHealth;

				if (lastHealth == 0)
				{
					//if lastHealth is zero, either the Raid Health Bar is supposed to disappear,
					//or the opponent is dead, so remove the raid opponent name and max health vars
					raidOpponentName = null;
					raidOpponentMaxHealth = 0;

					if (raidOpponentWrapper != null)
					{
						//unhide so that initial values can be read again, but wait 7 seconds so that the hp bar isn't shown
						//while the boss is dying. It's possible to cancel the unhide by changing shouldUnHide back to false
						shouldUnHide = true;

						scheduler.schedule(() ->
						{
							if (shouldUnHide)
							{
								raidOpponentWrapper.setHidden(false);
							}
						}, 7, TimeUnit.SECONDS);
					}
				}
			});
		}
	}

	public void unHideHPBar()
	{
		clientThread.invokeLater(() ->
		{
			Widget raidOpponentWrapper = client.getWidget(303, 6);
			if (raidOpponentWrapper != null)
			{
				raidOpponentWrapper.setHidden(false);
			}

			raidOpponentName = null;
			raidOpponentMaxHealth = 0;
			raidOpponentHealth = 0;
			shouldUnHide = true;
		});
	}


	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (useVanilla && opponentInfoConfig.mergeRaidOverlay())
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

			if (raidOpponentName != null && opponentName == null)
			{
				opponentName = raidOpponentName;
			}
			else if (raidOpponentName == null && opponentName == null)
			{
				return null;
			}

			//update raid vars so that they can be used after the opponent vars disappear, or if a target is switched
			//if the opponent is a glowing crystal or the meat tree, don't update vars, but rather keep using the ones in use
			//aka: show vasa and muttadile rather than the glowing crystal and the meat tree hp
			if (raidOpponentHealth != 0 && opponentInfoConfig.mergeRaidOverlay() &&
				!opponentName.equals("Glowing crystal") &&
				!opponentName.equals("Meat tree") &&
				!opponentName.toLowerCase().contains("vesp"))
			{
				raidOpponentMaxHealth = lastMaxHealth != null ? lastMaxHealth : raidOpponentMaxHealth != 0 ? raidOpponentMaxHealth : 1;

				if (raidOpponentMaxHealth == 1)
				{
					return null;
				}

				raidOpponentName = opponentName;
			}
		}

		if (raidOpponentHealth != 0 && opponentInfoConfig.mergeRaidOverlay())
		{
			lastMaxHealth = raidOpponentMaxHealth;
			lastHealthScale = raidOpponentMaxHealth;
			opponentName = raidOpponentName;
			lastRatio = raidOpponentHealth;
		}

		if ((opponent == null && raidOpponentHealth == 0) || opponentName == null)
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
			progressBarComponent.setBackgroundColor(HP_RED);
			progressBarComponent.setForegroundColor(HP_GREEN);

			final HitpointsDisplayStyle displayStyle = opponentInfoConfig.hitpointsDisplayStyle();

			if ((displayStyle == HitpointsDisplayStyle.HITPOINTS || displayStyle == HitpointsDisplayStyle.BOTH)
				&& lastMaxHealth != null)
			{
				// This is the reverse of the calculation of healthRatio done by the server
				// which is: healthRatio = 1 + (healthScale - 1) * health / maxHealth (if health > 0, 0 otherwise)
				// It's able to recover the exact health if maxHealth <= healthScale.

				//raidOpponentHealth is non-zero if the raid health overlay is active;
				//The max and min health don't have to be calculated then
				int health = raidOpponentHealth;

				if (lastRatio > 0 && raidOpponentHealth != 0)
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
