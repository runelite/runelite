package net.runelite.client.plugins.batools;

import lombok.Getter;


enum HealerCode
{

	WAVEONE(new int[] {1,1}, new int[] {0,0}, new int[] {0,0}),
	WAVETWO(new int[] {1,1,2}, new int[] {0,0,0}, new int[] {0,0,21}),
	WAVETHREE(new int[] {1,6,2}, new int[] {0,0,0}, new int[] {0,0,0}),
	WAVEFOUR(new int[] {2,5,2,0}, new int[] {0,0,7,10}, new int[] {0,0,0,0}),
	WAVEFIVE(new int[] {2,5,2,3,0}, new int[] {0,0,0,0,7}, new int[] {0,0,21,30,0}),
	WAVESIX(new int[] {3,5,2,2,0,0}, new int[] {0,0,0,2,9,10}, new int[] {12,18,21,0,0,0}),
	WAVESEVEN(new int[] {3,7,1,1,0,0,0}, new int[] {2,0,1,1,2,4,10}, new int[] {0,21,0,0,30,45,0}),
	WAVEEIGHT(new int[] {1,9,1,1,0,0,0}, new int[] {1,0,1,1,2,2,10}, new int[] {0,0,0,0,33,42,0}),
	WAVENINE(new int[] {2,8,1,1,0,0,0,0}, new int[] {1,0,1,1,2,1,1,10}, new int[] {0,21,0,0,0,0,0,0,0}),
	WAVETEN(new int[] {2,5,1,1,0,0,0}, new int[] {1,0,1,1,4,4,8}, new int[] {21,33,0,33,30,45,0});


	@Getter
	private final int[] firstCallFood;
	@Getter
	private final int[] secondCallFood;
	@Getter
	private final int[] spacing;

	HealerCode(int[] firstCallFood, int[] secondCallFood, int[] spacing)
	{
		this.firstCallFood = firstCallFood;
		this.secondCallFood = secondCallFood;
		this.spacing = spacing;
	}
}
