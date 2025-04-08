/*
 * Copyright (c) 2025 Abex
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
package net.runelite.client.plugins.runecraft;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.function.ToIntFunction;
import javax.inject.Inject;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.annotations.Varbit;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

class EssencePouchOverlay extends WidgetItemOverlay
{
	@RequiredArgsConstructor
	enum EssPouch
	{
		SMALL(VarbitID.SMALL_ESSENCE_POUCH, null, new int[]{
			// script 3198
		}, 3),
		MEDIUM(VarbitID.MEDIUM_ESSENCE_POUCH, client -> client.getVarpValue(VarPlayerID.RCU_POUCH_DEGRADATION_MED), new int[]{
			// script 3670
			800, 0,
			400, 3,
		}, 6),
		LARGE(VarbitID.LARGE_ESSENCE_POUCH, client -> client.getVarpValue(VarPlayerID.RCU_POUCH_DEGRADATION_LARGE), new int[]{
			// script 3671
			1000, 0,
			800, 3,
			600, 5,
			400, 7,
		}, 9),
		GIANT(VarbitID.GIANT_ESSENCE_POUCH, client -> client.getVarpValue(VarPlayerID.RCU_POUCH_DEGRADATION_GIANT), new int[]{
			// script 3695
			1200, 0,
			1000, 3,
			800, 5,
			600, 6,
			400, 7,
			300, 8,
			200, 9,
		}, 12),
		COLOSSAL(VarbitID.COLOSSAL_ESSENCE_POUCH, client -> client.getVarbitValue(VarbitID.RCU_POUCH_DEGRADATION_COLOSSAL), new int[]{
			// script 4592
			1020, 0,
			1015, 5,
			995, 10,
			950, 15,
			870, 20,
			745, 25,
			565, 30,
			320, 35,
		}, 40)
			{
				@Override
				int scaleLimit(Client client, int limit)
				{
					// script 4592
					int rc = client.getRealSkillLevel(Skill.RUNECRAFT);
					int scaledMax;
					if (rc >= 85)
					{
						scaledMax = 40;
					}
					else if (rc >= 75)
					{
						scaledMax = 27;
					}
					else if (rc >= 50)
					{
						scaledMax = 16;
					}
					else
					{
						scaledMax = 8;
					}

					return Math.max(1, (limit * scaledMax) / 40);
				}
			},
		;

		@Varbit
		private final int amountVarb;
		private final ToIntFunction<Client> getDegradation;
		private final int[] degradationLevels;
		private final int maxFill;

		int scaleLimit(Client client, int limit)
		{
			return limit;
		}

		int maxAmount(Client client)
		{
			int deg = getDegradation(client);
			int limit = this.maxFill;
			for (int i = 0; i < degradationLevels.length; i += 2)
			{
				if (deg >= degradationLevels[i])
				{
					limit = degradationLevels[i + 1];
					break;
				}
			}

			if (limit > 0)
			{
				limit = this.scaleLimit(client, limit);
			}

			return limit;
		}

		int nextDegradationBreakpoint(Client client)
		{
			int deg = this.getDegradation.applyAsInt(client);
			for (int i = degradationLevels.length - 2; i >= 0; i -= 2)
			{
				if (deg < degradationLevels[i])
				{
					return degradationLevels[i];
				}
			}
			return deg;
		}

		int getDegradation(Client client)
		{
			if (this.getDegradation == null)
			{
				return 0;
			}

			return this.getDegradation.applyAsInt(client);
		}

		int getAmount(Client client)
		{
			return client.getVarbitValue(amountVarb);
		}
	}

	private final Client client;
	private final RunecraftConfig config;

	@Inject
	EssencePouchOverlay(Client client, RunecraftConfig config)
	{
		this.client = client;
		this.config = config;

		showOnInventory();
	}

	private int durabilityToEssence(int remainingDurability)
	{
		// each ess is worth 0 through 3 durability, randomly chosen per essence.
		// It is possible to calculate this with the central limit theorem, but
		// that has poor accuracy at low durability. Instead we use the following
		// equation, which is curve-fit from empirical trials to match the 99th
		// percentile.

		return (int) Math.ceil(.4 * Math.pow(remainingDurability, 1.07));
	}

	@Override
	public void renderItemOverlay(Graphics2D g, int itemId, WidgetItem widgetItem)
	{
		EssPouch pouch;
		boolean degraded = false;
		switch (itemId)
		{
			case ItemID.RCU_POUCH_SMALL:
				pouch = EssPouch.SMALL;
				break;
			case ItemID.RCU_POUCH_MEDIUM_DEGRADE:
				degraded = true;
				// fallthrough
			case ItemID.RCU_POUCH_MEDIUM:
				pouch = EssPouch.MEDIUM;
				break;
			case ItemID.RCU_POUCH_LARGE_DEGRADE:
				degraded = true;
				// fallthrough
			case ItemID.RCU_POUCH_LARGE:
				pouch = EssPouch.LARGE;
				break;
			case ItemID.RCU_POUCH_GIANT_DEGRADE:
				degraded = true;
				// fallthrough
			case ItemID.RCU_POUCH_GIANT:
				pouch = EssPouch.GIANT;
				break;
			case ItemID.RCU_POUCH_COLOSSAL_DEGRADE:
				degraded = true;
				// fallthrough
			case ItemID.RCU_POUCH_COLOSSAL:
				pouch = EssPouch.COLOSSAL;
				break;
			default:
				return;
		}

		var pt = widgetItem.getCanvasLocation();

		if (config.showPouch())
		{
			int limit = pouch.maxAmount(client);
			int amount = pouch.getAmount(client);

			if (amount != 0 && amount != limit)
			{
				g.setColor(Color.YELLOW);
			}
			else
			{
				g.setColor(Color.CYAN);
			}

			g.drawString("" + amount, pt.getX(), pt.getY() + 15);
		}

		if (pouch.getDegradation != null && config.pouchDegrade())
		{
			int breakpoint = pouch.nextDegradationBreakpoint(client);
			int remEss = durabilityToEssence(breakpoint - pouch.getDegradation(client));
			int limit = pouch.maxAmount(client);
			int remFills = (remEss + limit - 1) / limit;
			if (degraded)
			{
				g.setColor(Color.RED);
			}
			else if (remFills <= 1)
			{
				g.setColor(Color.YELLOW);
			}
			else
			{
				g.setColor(Color.CYAN);
			}
			g.drawString("" + remFills, pt.getX(), pt.getY() + 30);
		}
	}
}
