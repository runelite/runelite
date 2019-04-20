package net.runelite.client.plugins.batools;


import lombok.Getter;
import lombok.Setter;

import net.runelite.api.NPC;
import net.runelite.api.Actor;


public class Healer
{

	@Getter
	private NPC npc;

	@Getter
	@Setter
	private int wave;

	@Getter
	@Setter
	private int spawnNumber;

	@Getter
	@Setter
	private int foodRemaining;

	@Getter
	@Setter
	private int lastFoodTime;

	@Getter
	@Setter
	private int firstCallFood;

	@Getter
	@Setter
	private int secondCallFood;



	public Healer(NPC npc, int spawnNumber, int wave)
	{
		this.npc = npc;
		this.wave = wave;
		this.spawnNumber = spawnNumber;
		this.firstCallFood = getCode(wave).getFirstCallFood()[spawnNumber];
		this.secondCallFood = getCode(wave).getSecondCallFood()[spawnNumber];
		this.foodRemaining = firstCallFood + secondCallFood;
		this.lastFoodTime = getCode(wave).getSpacing()[spawnNumber];
	}

	private HealerCode getCode(int wave)
	{
		switch(wave)
		{
			case 1:
				return HealerCode.WAVEONE;
			case 2:
				return HealerCode.WAVETWO;
			case 3:
				return HealerCode.WAVETHREE;
			case 4:
				return HealerCode.WAVEFOUR;
			case 5:
				return HealerCode.WAVEFIVE;
			case 6:
				return HealerCode.WAVESIX;
			case 7:
				return HealerCode.WAVESEVEN;
			case 8:
				return HealerCode.WAVEEIGHT;
			case 9:
				return HealerCode.WAVENINE;
			case 10:
				return HealerCode.WAVETEN;
				default: return null;
		}
	}



}