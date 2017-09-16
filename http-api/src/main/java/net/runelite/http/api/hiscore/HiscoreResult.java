/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.http.api.hiscore;

import java.util.Objects;

public class HiscoreResult
{
	private String player;
	private Skill overall;
	private Skill attack;
	private Skill defence;
	private Skill strength;
	private Skill hitpoints;
	private Skill ranged;
	private Skill prayer;
	private Skill magic;
	private Skill cooking;
	private Skill woodcutting;
	private Skill fletching;
	private Skill fishing;
	private Skill firemaking;
	private Skill crafting;
	private Skill smithing;
	private Skill mining;
	private Skill herblore;
	private Skill agility;
	private Skill thieving;
	private Skill slayer;
	private Skill farming;
	private Skill runecraft;
	private Skill hunter;
	private Skill construction;
	private Skill clueScrollEasy;
	private Skill clueScrollMedium;
	private Skill clueScrollAll;
	private Skill bountyHunterRogue;
	private Skill bountyHunterHunter;
	private Skill clueScrollHard;
	private Skill lastManStanding;
	private Skill clueScrollElite;
	private Skill clueScrollMaster;

	public String getPlayer()
	{
		return player;
	}

	public void setPlayer(String player)
	{
		this.player = player;
	}

	public Skill getOverall()
	{
		return overall;
	}

	public void setOverall(Skill overall)
	{
		this.overall = overall;
	}

	public Skill getAttack()
	{
		return attack;
	}

	public void setAttack(Skill attack)
	{
		this.attack = attack;
	}

	public Skill getDefence()
	{
		return defence;
	}

	public void setDefence(Skill defence)
	{
		this.defence = defence;
	}

	public Skill getStrength()
	{
		return strength;
	}

	public void setStrength(Skill strength)
	{
		this.strength = strength;
	}

	public Skill getHitpoints()
	{
		return hitpoints;
	}

	public void setHitpoints(Skill hitpoints)
	{
		this.hitpoints = hitpoints;
	}

	public Skill getRanged()
	{
		return ranged;
	}

	public void setRanged(Skill ranged)
	{
		this.ranged = ranged;
	}

	public Skill getPrayer()
	{
		return prayer;
	}

	public void setPrayer(Skill prayer)
	{
		this.prayer = prayer;
	}

	public Skill getMagic()
	{
		return magic;
	}

	public void setMagic(Skill magic)
	{
		this.magic = magic;
	}

	public Skill getCooking()
	{
		return cooking;
	}

	public void setCooking(Skill cooking)
	{
		this.cooking = cooking;
	}

	public Skill getWoodcutting()
	{
		return woodcutting;
	}

	public void setWoodcutting(Skill woodcutting)
	{
		this.woodcutting = woodcutting;
	}

	public Skill getFletching()
	{
		return fletching;
	}

	public void setFletching(Skill fletching)
	{
		this.fletching = fletching;
	}

	public Skill getFishing()
	{
		return fishing;
	}

	public void setFishing(Skill fishing)
	{
		this.fishing = fishing;
	}

	public Skill getFiremaking()
	{
		return firemaking;
	}

	public void setFiremaking(Skill firemaking)
	{
		this.firemaking = firemaking;
	}

	public Skill getCrafting()
	{
		return crafting;
	}

	public void setCrafting(Skill crafting)
	{
		this.crafting = crafting;
	}

	public Skill getSmithing()
	{
		return smithing;
	}

	public void setSmithing(Skill smithing)
	{
		this.smithing = smithing;
	}

	public Skill getMining()
	{
		return mining;
	}

	public void setMining(Skill mining)
	{
		this.mining = mining;
	}

	public Skill getHerblore()
	{
		return herblore;
	}

	public void setHerblore(Skill herblore)
	{
		this.herblore = herblore;
	}

	public Skill getAgility()
	{
		return agility;
	}

	public void setAgility(Skill agility)
	{
		this.agility = agility;
	}

	public Skill getThieving()
	{
		return thieving;
	}

	public void setThieving(Skill thieving)
	{
		this.thieving = thieving;
	}

	public Skill getSlayer()
	{
		return slayer;
	}

	public void setSlayer(Skill slayer)
	{
		this.slayer = slayer;
	}

	public Skill getFarming()
	{
		return farming;
	}

	public void setFarming(Skill farming)
	{
		this.farming = farming;
	}

	public Skill getRunecraft()
	{
		return runecraft;
	}

	public void setRunecraft(Skill runecraft)
	{
		this.runecraft = runecraft;
	}

	public Skill getHunter()
	{
		return hunter;
	}

	public void setHunter(Skill hunter)
	{
		this.hunter = hunter;
	}

	public Skill getConstruction()
	{
		return construction;
	}

	public void setConstruction(Skill construction)
	{
		this.construction = construction;
	}

	public Skill getClueScrollEasy()
	{
		return clueScrollEasy;
	}

	public void setClueScrollEasy(Skill clueScrollEasy)
	{
		this.clueScrollEasy = clueScrollEasy;
	}

	public Skill getClueScrollMedium()
	{
		return clueScrollMedium;
	}

	public void setClueScrollMedium(Skill clueScrollMedium)
	{
		this.clueScrollMedium = clueScrollMedium;
	}

	public Skill getClueScrollAll()
	{
		return clueScrollAll;
	}

	public void setClueScrollAll(Skill clueScrollAll)
	{
		this.clueScrollAll = clueScrollAll;
	}

	public Skill getBountyHunterRogue()
	{
		return bountyHunterRogue;
	}

	public void setBountyHunterRogue(Skill bountyHunterRogue)
	{
		this.bountyHunterRogue = bountyHunterRogue;
	}

	public Skill getBountyHunterHunter()
	{
		return bountyHunterHunter;
	}

	public void setBountyHunterHunter(Skill bountyHunterHunter)
	{
		this.bountyHunterHunter = bountyHunterHunter;
	}

	public Skill getClueScrollHard()
	{
		return clueScrollHard;
	}

	public void setClueScrollHard(Skill clueScrollHard)
	{
		this.clueScrollHard = clueScrollHard;
	}

	public Skill getLastManStanding()
	{
		return lastManStanding;
	}

	public void setLastManStanding(Skill lastManStanding)
	{
		this.lastManStanding = lastManStanding;
	}

	public Skill getClueScrollElite()
	{
		return clueScrollElite;
	}

	public void setClueScrollElite(Skill clueScrollElite)
	{
		this.clueScrollElite = clueScrollElite;
	}

	public Skill getClueScrollMaster()
	{
		return clueScrollMaster;
	}

	public void setClueScrollMaster(Skill clueScrollMaster)
	{
		this.clueScrollMaster = clueScrollMaster;
	}

	public Skill getSkill(HiscoreSkill skill)
	{
		switch (skill)
		{
			case ATTACK:
				return getAttack();
			case DEFENCE:
				return getDefence();
			case STRENGTH:
				return getStrength();
			case HITPOINTS:
				return getHitpoints();
			case RANGED:
				return getRanged();
			case PRAYER:
				return getPrayer();
			case MAGIC:
				return getMagic();
			case COOKING:
				return getCooking();
			case WOODCUTTING:
				return getWoodcutting();
			case FLETCHING:
				return getFletching();
			case FISHING:
				return getFishing();
			case FIREMAKING:
				return getFiremaking();
			case CRAFTING:
				return getCrafting();
			case SMITHING:
				return getSmithing();
			case MINING:
				return getMining();
			case HERBLORE:
				return getHerblore();
			case AGILITY:
				return getAgility();
			case THIEVING:
				return getThieving();
			case SLAYER:
				return getSlayer();
			case FARMING:
				return getFarming();
			case RUNECRAFT:
				return getRunecraft();
			case HUNTER:
				return getHunter();
			case CONSTRUCTION:
				return getConstruction();
			case OVERALL:
				return getOverall();
			case CLUE_SCROLL_EASY:
				return getClueScrollEasy();
			case CLUE_SCROLL_MEDIUM:
				return getClueScrollMedium();
			case CLUE_SCROLL_ALL:
				return getClueScrollAll();
			case BOUNTY_HUNTER_ROGUE:
				return getBountyHunterRogue();
			case BOUNTY_HUNTER_HUNTER:
				return getBountyHunterHunter();
			case CLUE_SCROLL_HARD:
				return getClueScrollHard();
			case LAST_MAN_STANDING:
				return getLastManStanding();
			case CLUE_SCROLL_ELITE:
				return getClueScrollElite();
			case CLUE_SCROLL_MASTER:
				return getClueScrollMaster();
		}

		throw new IllegalArgumentException("Invalid hiscore item");
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 29 * hash + Objects.hashCode(this.player);
		hash = 29 * hash + Objects.hashCode(this.overall);
		hash = 29 * hash + Objects.hashCode(this.attack);
		hash = 29 * hash + Objects.hashCode(this.defence);
		hash = 29 * hash + Objects.hashCode(this.strength);
		hash = 29 * hash + Objects.hashCode(this.hitpoints);
		hash = 29 * hash + Objects.hashCode(this.ranged);
		hash = 29 * hash + Objects.hashCode(this.prayer);
		hash = 29 * hash + Objects.hashCode(this.magic);
		hash = 29 * hash + Objects.hashCode(this.cooking);
		hash = 29 * hash + Objects.hashCode(this.woodcutting);
		hash = 29 * hash + Objects.hashCode(this.fletching);
		hash = 29 * hash + Objects.hashCode(this.fishing);
		hash = 29 * hash + Objects.hashCode(this.firemaking);
		hash = 29 * hash + Objects.hashCode(this.crafting);
		hash = 29 * hash + Objects.hashCode(this.smithing);
		hash = 29 * hash + Objects.hashCode(this.mining);
		hash = 29 * hash + Objects.hashCode(this.herblore);
		hash = 29 * hash + Objects.hashCode(this.agility);
		hash = 29 * hash + Objects.hashCode(this.thieving);
		hash = 29 * hash + Objects.hashCode(this.slayer);
		hash = 29 * hash + Objects.hashCode(this.farming);
		hash = 29 * hash + Objects.hashCode(this.runecraft);
		hash = 29 * hash + Objects.hashCode(this.hunter);
		hash = 29 * hash + Objects.hashCode(this.construction);
		hash = 29 * hash + Objects.hashCode(this.clueScrollEasy);
		hash = 29 * hash + Objects.hashCode(this.clueScrollMedium);
		hash = 29 * hash + Objects.hashCode(this.clueScrollAll);
		hash = 29 * hash + Objects.hashCode(this.bountyHunterRogue);
		hash = 29 * hash + Objects.hashCode(this.bountyHunterHunter);
		hash = 29 * hash + Objects.hashCode(this.clueScrollHard);
		hash = 29 * hash + Objects.hashCode(this.lastManStanding);
		hash = 29 * hash + Objects.hashCode(this.clueScrollElite);
		hash = 29 * hash + Objects.hashCode(this.clueScrollMaster);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final HiscoreResult other = (HiscoreResult) obj;
		if (!Objects.equals(this.player, other.player))
		{
			return false;
		}
		if (!Objects.equals(this.overall, other.overall))
		{
			return false;
		}
		if (!Objects.equals(this.attack, other.attack))
		{
			return false;
		}
		if (!Objects.equals(this.defence, other.defence))
		{
			return false;
		}
		if (!Objects.equals(this.strength, other.strength))
		{
			return false;
		}
		if (!Objects.equals(this.hitpoints, other.hitpoints))
		{
			return false;
		}
		if (!Objects.equals(this.ranged, other.ranged))
		{
			return false;
		}
		if (!Objects.equals(this.prayer, other.prayer))
		{
			return false;
		}
		if (!Objects.equals(this.magic, other.magic))
		{
			return false;
		}
		if (!Objects.equals(this.cooking, other.cooking))
		{
			return false;
		}
		if (!Objects.equals(this.woodcutting, other.woodcutting))
		{
			return false;
		}
		if (!Objects.equals(this.fletching, other.fletching))
		{
			return false;
		}
		if (!Objects.equals(this.fishing, other.fishing))
		{
			return false;
		}
		if (!Objects.equals(this.firemaking, other.firemaking))
		{
			return false;
		}
		if (!Objects.equals(this.crafting, other.crafting))
		{
			return false;
		}
		if (!Objects.equals(this.smithing, other.smithing))
		{
			return false;
		}
		if (!Objects.equals(this.mining, other.mining))
		{
			return false;
		}
		if (!Objects.equals(this.herblore, other.herblore))
		{
			return false;
		}
		if (!Objects.equals(this.agility, other.agility))
		{
			return false;
		}
		if (!Objects.equals(this.thieving, other.thieving))
		{
			return false;
		}
		if (!Objects.equals(this.slayer, other.slayer))
		{
			return false;
		}
		if (!Objects.equals(this.farming, other.farming))
		{
			return false;
		}
		if (!Objects.equals(this.runecraft, other.runecraft))
		{
			return false;
		}
		if (!Objects.equals(this.hunter, other.hunter))
		{
			return false;
		}
		if (!Objects.equals(this.construction, other.construction))
		{
			return false;
		}
		if (!Objects.equals(this.clueScrollEasy, other.clueScrollEasy))
		{
			return false;
		}
		if (!Objects.equals(this.clueScrollMedium, other.clueScrollMedium))
		{
			return false;
		}
		if (!Objects.equals(this.clueScrollAll, other.clueScrollAll))
		{
			return false;
		}
		if (!Objects.equals(this.bountyHunterRogue, other.bountyHunterRogue))
		{
			return false;
		}
		if (!Objects.equals(this.bountyHunterHunter, other.bountyHunterHunter))
		{
			return false;
		}
		if (!Objects.equals(this.clueScrollHard, other.clueScrollHard))
		{
			return false;
		}
		if (!Objects.equals(this.lastManStanding, other.lastManStanding))
		{
			return false;
		}
		if (!Objects.equals(this.clueScrollElite, other.clueScrollElite))
		{
			return false;
		}
		if (!Objects.equals(this.clueScrollMaster, other.clueScrollMaster))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "HiscoreResult{" + "player=" + player + ", overall=" + overall + ", attack=" + attack + ", defence=" + defence + ", strength=" + strength + ", hitpoints=" + hitpoints + ", ranged=" + ranged + ", prayer=" + prayer + ", magic=" + magic + ", cooking=" + cooking + ", woodcutting=" + woodcutting + ", fletching=" + fletching + ", fishing=" + fishing + ", firemaking=" + firemaking + ", crafting=" + crafting + ", smithing=" + smithing + ", mining=" + mining + ", herblore=" + herblore + ", agility=" + agility + ", thieving=" + thieving + ", slayer=" + slayer + ", farming=" + farming + ", runecraft=" + runecraft + ", hunter=" + hunter + ", construction=" + construction + ", clueScrollEasy=" + clueScrollEasy + ", clueScrollMedium=" + clueScrollMedium + ", clueScrollAll=" + clueScrollAll + ", bountyHunterRogue=" + bountyHunterRogue + ", bountyHunterHunter=" + bountyHunterHunter + ", clueScrollHard=" + clueScrollHard + ", lastManStanding=" + lastManStanding + ", clueScrollElite=" + clueScrollElite + ", clueScrollMaster=" + clueScrollMaster + '}';
	}
}
