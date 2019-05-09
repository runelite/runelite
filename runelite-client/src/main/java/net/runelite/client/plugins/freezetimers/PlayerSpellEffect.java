package net.runelite.client.plugins.freezetimers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PlayerSpellEffect
{
	BIND("Bind", 181, 5000, true, 0, TimerType.FREEZE),
	SNARE("Snare", 180, 10000, true, 1, TimerType.FREEZE),
	ENTANGLE("Entangle", 179, 15000, true, 2, TimerType.FREEZE),
	RUSH("Ice Rush", 361, 5000, false, 3, TimerType.FREEZE),
	BURST("Ice Burst", 363, 10000, false, 4, TimerType.FREEZE),
	BLITZ("Ice Blitz", 367, 15000, false, 5, TimerType.FREEZE),
	BARRAGE("Ice Barrage", 369, 20000, false, 6, TimerType.FREEZE),
	TELEBLOCK("Teleblock", 345, 300000, true, 7, TimerType.TELEBLOCK),
	VENG("Vengeance", 726, 30000, false, 8, TimerType.VENG),
	VENG_OTHER("Vengeance Other", 725, 30000, false, 9, TimerType.VENG),
	NONE("Nothing", -69, 420, true, 9999, TimerType.THIS_SHIT_BROKE);

	@Getter
	private final String name;
	@Getter
	private final int spotAnimId;
	@Getter
	private final int timerLengthTicks;
	@Getter
	private boolean halvable;
	@Getter
	private final int spriteIdx;
	@Getter
	private final TimerType type;

	public static PlayerSpellEffect getFromSpotAnim(int spotAnim)
	{
		for(PlayerSpellEffect effect : values())
		{
			if(effect.getSpotAnimId() == spotAnim)
				return effect;
		}
		return NONE;
	}

}
