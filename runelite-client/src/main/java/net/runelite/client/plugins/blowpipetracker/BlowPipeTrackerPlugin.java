/*
 * Copyright (c) 2018, Sir Girion <https://github.com/darakelian>
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
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.api.kit.KitType;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.attackstyles.AttackStyle;
import net.runelite.client.plugins.attackstyles.WeaponType;
import net.runelite.client.plugins.slayer.TaskCounter;
import net.runelite.client.ui.overlay.infobox.Counter;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;

import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.runelite.client.plugins.attackstyles.AttackStyle.*;

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

    private int dartsLeft;
    private int scalesLeft;
    private int dartId;
	private int shotsFired;
	private boolean parsedValuesFromText = false;

	private Counter dartCounter;
	private Counter scaleCounter;

	private int ticks = 0;
	private int ticksInAnimation;
	private int attackStyleVarbit = -1;
	private AttackStyle attackStyle;

    private static final Random random = new Random();
    private static final Pattern DART_AND_SCALE_PATTERN = Pattern.compile("Darts: (\\S*) dart x (\\d*[,]?\\d*). Scales: \\d+[.]?\\d%, (\\d*[,]?\\d*)");

    private static final int TICKS_RAPID_PVM = 2;
    private static final int TICKS_RAPID_PVP = 3;
    private static final int TICKS_NORMAL_PVM = 3;
    private static final int TICKS_NORMAL_PVP = 4;

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
			log.info("Fired a shot from blowpipe");
			AttractorDefinition attractorDefinition = getAttractorForPlayer();
			if (attractorDefinition == null)
				return;

			shotsFired++;
			if (shouldConsumeDart(attractorDefinition))
				dartsLeft--;

			if (shouldConsumeScales())
				scalesLeft -= 2;

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
				ticksInAnimation = client.getLocalPlayer().getInteracting() instanceof Player ? TICKS_NORMAL_PVP : TICKS_NORMAL_PVM;
			else if (attackStyleVarbit == 1)
				ticksInAnimation = client.getLocalPlayer().getInteracting() instanceof Player ? TICKS_RAPID_PVP : TICKS_RAPID_PVM;
		}
	}

	private AttractorDefinition getAttractorForPlayer()
	{
		int attractorEquippedId = client.getLocalPlayer().getPlayerComposition().getEquipmentId(KitType.CAPE);

		return AttractorDefinition.getAttractorById(attractorEquippedId);
	}

	private boolean shouldConsumeDart(AttractorDefinition attractorDefinition)
	{
		double dartRoll = random.nextDouble();
		if (dartRoll <= attractorDefinition.getSavedChance())
			return false;
		else
			return dartRoll > 1 - (attractorDefinition.getBreakOnImpactPercentage() + attractorDefinition.getDropToFloorChance());
	}

	private boolean shouldConsumeScales()
	{
		if (shotsFired == 3)
		{
			shotsFired = 0;
			return true;
		}

		return false;
	}

    @Subscribe
	public void onChatMessage(ChatMessage event) {
		if (event.getType() != ChatMessageType.SERVER && event.getType() != ChatMessageType.FILTERED)
			return;

		String chatMsg = Text.removeTags(event.getMessage()); //remove color and linebreaks
		//Extract dart quantity and type as well as number of scal
		Matcher mComplete = DART_AND_SCALE_PATTERN.matcher(chatMsg);

		List<String> matches = new ArrayList<>();
		if (mComplete.find())
		{
			for (int i = 1; i <= mComplete.groupCount(); i++) {
				matches.add(mComplete.group(i));
				log.debug("Match: " + mComplete.group(i));
			}
		}

		switch (matches.size())
		{
			case 3:
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

		if (config.showDarts())
			clientThread.invokeLater(this::modifyCounters);
		else
			clientThread.invokeLater(this::removeDartCounter);

		if (config.showScales())
			clientThread.invokeLater(this::modifyCounters);
		else
			clientThread.invokeLater(this::removeScaleCounter);
	}

	private void removeDartCounter()
	{
		if (dartCounter == null)
			return;

		infoBoxManager.removeInfoBox(dartCounter);
		dartCounter = null;
	}

	private void removeScaleCounter()
	{
		if (scaleCounter == null)
			return;

		infoBoxManager.removeInfoBox(scaleCounter);
		scaleCounter = null;
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
				return  ItemID.STEEL_DART;
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
		if (!parsedValuesFromText)
			return;

		if (config.showDarts())
		{
			if (dartCounter == null)
			{
				BufferedImage dartImg = itemManager.getImage(dartId);
				dartCounter = new Counter(dartImg, this, String.valueOf(dartsLeft));
				dartCounter.setTooltip(String.format("<col=ff7700>Darts:</col> %s", dartsLeft));

				infoBoxManager.addInfoBox(dartCounter);
			}
			else
				dartCounter.setText(String.valueOf(dartsLeft));
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
				scaleCounter.setText(String.valueOf(scalesLeft));
		}
	}

	@Provides
	BlowPipeTrackerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BlowPipeTrackerConfig.class);
	}
}
