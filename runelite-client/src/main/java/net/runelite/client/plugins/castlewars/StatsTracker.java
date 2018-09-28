/*
 * Copyright (c) 2018, cw-dev
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.castlewars;

import java.util.Objects;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.PlayerComposition;
import net.runelite.api.Skill;
import static net.runelite.api.Skill.HITPOINTS;
import net.runelite.api.Varbits;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.kit.KitType;
import net.runelite.client.plugins.castlewars.data.CWArea;
import net.runelite.client.plugins.castlewars.data.CWBase;
import net.runelite.client.plugins.castlewars.data.CWFlag;
import net.runelite.client.plugins.castlewars.data.CWTeam;
import net.runelite.client.util.Text;

class StatsTracker
{
	// Number of ticks after which we will no longer associate an action with a click.
	private static final int CLICK_ACTION_TICK_THRESHOLD = 5;
	private static final double HP_XP_PER_HIT = 1.3333;

	private final Client client;

	private GameRecord currentGame;
	private CWTeam ourTeam;
	private int lastHPXP;

	// Flags
	private boolean holdingTheirsLastTick = false;
	private boolean holdingOwnLastTick = false;
	private int clickedOwnDroppedFlagOnTick;
	private int clickedFlagStandOnTick;

	@Inject
	private StatsTracker(final Client client)
	{
		this.client = client;
	}

	void startGame(int world, int validLobbyPlayers)
	{
		ourTeam = CWTeam.ofPlayer(client.getLocalPlayer());
		currentGame = new GameRecord(world, validLobbyPlayers, ourTeam);
		lastHPXP = client.getSkillExperience(Skill.HITPOINTS);
	}

	GameRecord finishGame()
	{
		currentGame.setSaraScore(client.getVar(Varbits.CW_SARA_SCORE));
		currentGame.setZamScore(client.getVar(Varbits.CW_ZAM_SCORE));
		return currentGame;
	}

	void reset()
	{
		currentGame = null;
		ourTeam = null;
		lastHPXP = 0;
	}

	void recordDamageDealt()
	{
		int currentHPXP = client.getSkillExperience(HITPOINTS);
		int hpXpGained = currentHPXP - lastHPXP;
		lastHPXP = currentHPXP;
		currentGame.recordDamageDealt((double) hpXpGained / HP_XP_PER_HIT);
	}

	void recordDamageTaken(int amount)
	{
		currentGame.recordDamageTaken(amount);
	}

	void recordFrozen()
	{
		currentGame.setFreezesOnMe(currentGame.getFreezesOnMe() + 1);
	}

	void recordSpeared()
	{
		currentGame.setTimesSpeared(currentGame.getTimesSpeared() + 1);
	}

	void recordDeath()
	{
		currentGame.setDeaths(currentGame.getDeaths() + 1);

		if (holdingOwnFlag())
		{
			lostOurFlag();
		}
	}

	void checkHoldingFlag()
	{
		boolean holdingOwnThisTick = holdingOwnFlag();
		if (holdingOwnLastTick && !holdingOwnThisTick)
		{
			lostOurFlag();
		}
		holdingOwnLastTick = holdingOwnThisTick;


		boolean holdingTheirsThisTick = holdingTheirFlag();
		if (holdingTheirsLastTick && !holdingTheirsThisTick)
		{
			lostTheirFlag();
		}
		holdingTheirsLastTick = holdingTheirsThisTick;
	}

	void onDroppedFlagDespawned(CWFlag despawnedFlag, WorldPoint despawnedAt)
	{
		final int onTick = client.getTickCount();
		boolean isOurFlag = despawnedFlag != null && despawnedFlag.equals(ourTeam.getFlag());
		boolean recentlyClickedOwnFlag = onTick - clickedOwnDroppedFlagOnTick < CLICK_ACTION_TICK_THRESHOLD;
		boolean nextToFlag = despawnedAt.distanceTo(client.getLocalPlayer().getWorldLocation()) == 1;

		if (recentlyClickedOwnFlag && isOurFlag && inOwnBase() && nextToFlag && !visiblePlayerHoldingOurFlag())
		{
			currentGame.setFlagsSafed(currentGame.getFlagsSafed() + 1);
		}
	}

	void onMenuOptionClicked(MenuOptionClicked event)
	{
		final int currentTick = client.getTickCount();

		if ("Capture".equals(event.getMenuOption()))
		{
			clickedFlagStandOnTick = currentTick;
		}
		else if (matchesOwnDroppedFlag(event))
		{
			clickedOwnDroppedFlagOnTick = currentTick;
		}
	}

	private void lostTheirFlag()
	{
		final int currentTick = client.getTickCount();
		final CWArea playerArea = CWArea.match(client.getLocalPlayer().getWorldLocation());
		final CWArea ourFourth = ourTeam.getBase().getFourth();
		final boolean recentlyClickedFlagStand = currentTick - clickedFlagStandOnTick < CLICK_ACTION_TICK_THRESHOLD;

		if (ourFourth != null && ourFourth.equals(playerArea) && recentlyClickedFlagStand)
		{
			currentGame.setFlagsScored(currentGame.getFlagsSafed() + 1);
		}
	}

	private void lostOurFlag()
	{
		CWArea playerArea = CWArea.match(client.getLocalPlayer().getWorldLocation());
		if (playerArea == null)
		{
			return;
		}

		CWArea ourGround = ourTeam.getBase().getGround();
		if (playerArea.equals(ourGround) || playerArea.equals(CWArea.NORTH_ROCKS) || playerArea.equals(CWArea.SOUTH_ROCKS))
		{
			currentGame.setFlagsSafed(currentGame.getFlagsSafed() + 1);
		}
	}

	private boolean holdingTheirFlag()
	{
		CWFlag flag = getWieldedFlag();
		return ourTeam.opposite().getFlag().equals(flag);
	}

	private boolean holdingOwnFlag()
	{
		CWFlag flag = getWieldedFlag();
		return ourTeam.getFlag().equals(flag);
	}

	private CWFlag getWieldedFlag()
	{
		Player local = client.getLocalPlayer();
		if (local == null)
		{
			return null;
		}

		PlayerComposition playerComposition = local.getPlayerComposition();
		if (playerComposition == null)
		{
			return null;
		}

		return CWFlag.fromEquipment(playerComposition.getEquipmentId(KitType.WEAPON));
	}

	private boolean inOwnBase()
	{
		CWBase currentBase = CWBase.match(client.getLocalPlayer().getWorldLocation());
		return ourTeam.getBase().equals(currentBase);
	}

	private boolean visiblePlayerHoldingOurFlag()
	{
		Player me = client.getLocalPlayer();
		return client.getPlayers().stream()
			.filter(Objects::nonNull)
			.filter(player -> player != me)
			.filter(player -> player.getPlayerComposition() != null)
			.anyMatch(player ->
			{
				int weaponID = player.getPlayerComposition().getEquipmentId(KitType.WEAPON);
				CWFlag flag = CWFlag.fromEquipment(weaponID);
				return ourTeam.getFlag().equals(flag);
			});
	}

	private boolean matchesOwnDroppedFlag(MenuOptionClicked event)
	{
		String menuTarget = Text.removeTags(event.getMenuTarget());
		CWFlag ownFlag = ourTeam.getFlag();
		return ownFlag != null && ownFlag.getMenuName().equals(menuTarget);
	}
}
