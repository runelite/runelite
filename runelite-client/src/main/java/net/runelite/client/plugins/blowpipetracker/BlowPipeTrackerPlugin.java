/*
 * Copyright (c) 2018, Sir Girion <https://github.com/sirgirion>
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
package net.runelite.client.plugins.blowpipetracker;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.AnimationID;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Player;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.kit.KitType;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.Counter;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;

@PluginDescriptor(
	name = "Blowpipe Tracker"
)
@Slf4j
public class BlowPipeTrackerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private BlowPipeTrackerConfig config;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ItemManager itemManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private Notifier notifier;

	private int dartsLeft = -1;
	private int scalesLeft = -1;
	private int dartId;
	private boolean parsedValuesFromText = false;
	private String dartType;

	private Counter combinedCounter;
	private Counter dartCounter;
	private Counter scaleCounter;

	private int ticks = 0;
	private int ticksInAnimation;
	private int attackStyleVarbit = -1;

	private static final Random RANDOM = new Random();
	private static final Pattern DART_AND_SCALE_PATTERN = Pattern.compile("Darts: (\\S*)(?: dart)? x (\\d*[,]?\\d*). Scales: \\d+[.]?\\d%, (\\d*[,]?\\d*)");
	private static final String OUT_OF_DARTS = "Your blowpipe has run out of darts";
	private static final String OUT_OF_SCALES = "Your blowpipe needs to be charged with Zulrah's scales";

	private static final int TICKS_RAPID_PVM = 2;
	private static final int TICKS_RAPID_PVP = 3;
	private static final int TICKS_NORMAL_PVM = 3;
	private static final int TICKS_NORMAL_PVP = 4;
	private static final int MAX_SCALES = 16383;

	@Subscribe
	public void onGameTick(GameTick tick)
	{
		Player player = client.getLocalPlayer();

		if (player.getAnimation() == AnimationID.BLOWPIPE_ATTACK_ANIMATION)
		{
			ticks++;
		}

		if (ticks == ticksInAnimation && (player.getAnimation() == AnimationID.BLOWPIPE_ATTACK_ANIMATION))
		{
			AttractorDefinition attractorDefinition = getAttractorForPlayer();
			if (attractorDefinition == null)
			{
				return;
			}

			if (shouldConsumeDart(attractorDefinition))
			{
				dartsLeft--;
			}

			if (shouldConsumeScales())
			{
				scalesLeft--;
			}

			modifyCounters();
			ticks = 0;
		}
	}

	@Subscribe
	public void onAttackStyleChange(VarbitChanged event)
	{
		if (attackStyleVarbit == -1 || attackStyleVarbit != client.getVar(VarPlayer.ATTACK_STYLE))
		{
			attackStyleVarbit = client.getVar(VarPlayer.ATTACK_STYLE);

			if (attackStyleVarbit == 0 || attackStyleVarbit == 3)
			{
				ticksInAnimation = client.getLocalPlayer().getInteracting() instanceof Player ? TICKS_NORMAL_PVP : TICKS_NORMAL_PVM;
			}
			else if (attackStyleVarbit == 1)
			{
				ticksInAnimation = client.getLocalPlayer().getInteracting() instanceof Player ? TICKS_RAPID_PVP : TICKS_RAPID_PVM;
			}
		}
	}

	private AttractorDefinition getAttractorForPlayer()
	{
		int attractorEquippedId = client.getLocalPlayer().getPlayerComposition().getEquipmentId(KitType.CAPE);

		return AttractorDefinition.getAttractorById(attractorEquippedId);
	}

	private boolean shouldConsumeDart(AttractorDefinition attractorDefinition)
	{
		double dartRoll = RANDOM.nextDouble();
		if (dartRoll <= attractorDefinition.getSavedChance())
		{
			return false;
		}
		else
		{
			return dartRoll > 1 - (attractorDefinition.getBreakOnImpactChance() + attractorDefinition.getDropToFloorChance());
		}
	}

	private boolean shouldConsumeScales()
	{
		return RANDOM.nextDouble() <= 0.66;
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
		{
			return;
		}

		String chatMsg = Text.removeTags(event.getMessage()); //remove color and linebreaks
		if (chatMsg.contains(OUT_OF_DARTS))
		{
			if (config.showEmptyBlowpipeNotification())
			{
				notifier.notify("You have run out of darts!");
			}

			return;
		}
		if (chatMsg.contains(OUT_OF_SCALES))
		{
			if (config.showEmptyBlowpipeNotification())
			{
				notifier.notify("You have run out of scales!");
			}

			return;
		}

		//Extract dart quantity and type as well as number of scales
		Matcher mComplete = DART_AND_SCALE_PATTERN.matcher(chatMsg);

		List<String> matches = new ArrayList<>();
		if (mComplete.find())
		{
			for (int i = 1; i <= mComplete.groupCount(); i++)
			{
				matches.add(mComplete.group(i));
				log.debug("Match: " + mComplete.group(i));
			}
		}

		switch (matches.size())
		{
			case 3:
				dartType = matches.get(0);
				dartId = getDartIdByName(matches.get(0));
				dartsLeft = Integer.valueOf(matches.get(1).replace(",", ""));
				scalesLeft = Integer.valueOf(matches.get(2).replace(",", ""));
				parsedValuesFromText = true;
				modifyCounters();
				break;
			default:
				log.warn("Unknown match condition occurred.");
				break;
		}
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals("blowpipetracker"))
		{
			return;
		}

		if (config.showInfobox())
		{
			removeDartCounter();
			removeScaleCounter();
			removeCombinedCounter();
		}

		if (config.displayStyleMode() == DisplayStyleMode.COMBINED)
		{
			removeDartCounter();
			removeScaleCounter();

			if (dartsLeft >= 0 || scalesLeft >= 0)
			{
				clientThread.invokeLater(this::modifyCounters);
			}
		}

		if (config.displayStyleMode() == DisplayStyleMode.INDIVIDUAL)
		{
			removeCombinedCounter();

			if (dartsLeft >= 0 || scalesLeft >= 0)
			{
				clientThread.invokeLater(this::modifyCounters);
			}
		}
	}

	private void removeDartCounter()
	{
		if (dartCounter == null)
		{
			return;
		}

		infoBoxManager.removeInfoBox(dartCounter);
		dartCounter = null;
	}

	private void removeScaleCounter()
	{
		if (scaleCounter == null)
		{
			return;
		}

		infoBoxManager.removeInfoBox(scaleCounter);
		scaleCounter = null;
	}

	private void removeCombinedCounter()
	{
		if (combinedCounter == null)
		{
			return;
		}

		infoBoxManager.removeInfoBox(combinedCounter);
		combinedCounter = null;
	}

	private int getDartIdByName(String dartName)
	{
		switch (dartName.toLowerCase())
		{
			case "bronze":
				return ItemID.BRONZE_DART;
			case "iron":
				return ItemID.IRON_DART;
			case "steel":
				return ItemID.STEEL_DART;
			case "mithril":
				return ItemID.MITHRIL_DART;
			case "adamant":
				return ItemID.ADAMANT_DART;
			case "rune":
				return ItemID.RUNE_DART;
			case "dragon":
				return ItemID.DRAGON_DART;
			default:
				return -1;
		}
	}

	private void modifyCounters()
	{
		if (!parsedValuesFromText || config.showInfobox())
		{
			return;
		}

		if (config.displayStyleMode() == DisplayStyleMode.COMBINED)
		{
			if (combinedCounter == null)
			{
				final BufferedImage blowpipeImg = itemManager.getImage(ItemID.TOXIC_BLOWPIPE);
				combinedCounter = new Counter(blowpipeImg, this,
					String.format("%.1f%%", 100 * (double) scalesLeft / MAX_SCALES));
				combinedCounter.setTooltip(String.format("<col=ffff00>Darts (%s):</col> %s</br><col=ffff00>Scales:</col> %s", dartType, dartsLeft, scalesLeft));
				combinedCounter.setColor(getColorForScalesLeft());

				infoBoxManager.addInfoBox(combinedCounter);
			}
			else
			{
				combinedCounter.setText(String.format("%.1f%%", 100 * (double) scalesLeft / MAX_SCALES));
				combinedCounter.setTooltip(String.format("<col=ffff00>Darts (%s):</col> %s</br><col=ffff00>Scales:</col> %s", dartType, dartsLeft, scalesLeft));
				combinedCounter.setColor(getColorForScalesLeft());
			}
		}
		else if (config.displayStyleMode() == DisplayStyleMode.INDIVIDUAL)
		{
			if (config.showDarts())
			{
				if (dartCounter == null)
				{
					final BufferedImage dartImg = itemManager.getImage(dartId);
					dartCounter = new Counter(dartImg, this, String.valueOf(dartsLeft));
					dartCounter.setTooltip(String.format("<col=ff7700>Darts:</col> %s", dartsLeft));

					infoBoxManager.addInfoBox(dartCounter);
				}
				else
				{
					dartCounter.setText(String.valueOf(dartsLeft));
					dartCounter.setTooltip(String.format("<col=ff7700>Darts:</col> %s", dartsLeft));
				}
			}
			if (config.showScales())
			{
				if (scaleCounter == null)
				{
					BufferedImage scaleImage = itemManager.getImage(ItemID.ZULRAHS_SCALES);
					scaleCounter = new Counter(scaleImage, this, String.valueOf(scalesLeft));
					scaleCounter.setTooltip(String.format("<col=ff7700>Scales:</col> %s", scalesLeft));

					infoBoxManager.addInfoBox(scaleCounter);
				}
				else
				{
					scaleCounter.setText(String.valueOf(scalesLeft));
					scaleCounter.setTooltip(String.format("<col=ff7700>Scales:</col> %s", scalesLeft));
				}
			}
		}
	}

	private Color getColorForScalesLeft()
	{
		float percent = (float) scalesLeft / MAX_SCALES;

		return Color.getHSBColor((float) (percent * 0.334), 1F, 1F);
	}

	@Provides
	BlowPipeTrackerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BlowPipeTrackerConfig.class);
	}
}
