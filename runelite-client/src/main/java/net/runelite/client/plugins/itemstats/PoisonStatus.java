package net.runelite.client.plugins.itemstats;

import com.google.inject.Singleton;
import java.awt.Color;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import net.runelite.client.util.ColorUtil;

@Singleton
class PoisonStatus
{
	private static final int POISON_TICK_MILLIS = 18200;
	private static final int VENOM_THRESHOLD = 1000000;
	private static final int VENOM_MAXIMUM_DAMAGE = 20;

	private int nextDamage;
	private boolean envenomed;
	private Instant nextTick;

	void update(int poisonValue, Instant now)
	{
		if (poisonValue > 0)
		{
			nextDamage = nextDamage(poisonValue);
			envenomed = poisonValue >= VENOM_THRESHOLD;
			nextTick = now.plusMillis(POISON_TICK_MILLIS);
		}
		else
		{
			clear();
		}
	}

	void clear()
	{
		nextDamage = 0;
		envenomed = false;
		nextTick = null;
	}

	static int nextDamage(int poisonValue)
	{
		if (poisonValue >= VENOM_THRESHOLD)
		{
			final int damage = (poisonValue - VENOM_THRESHOLD + 3) * 2;
			return Math.min(damage, VENOM_MAXIMUM_DAMAGE);
		}

		return (int) Math.ceil(poisonValue / 5.0f);
	}

	String createTooltip(Instant now)
	{
		if (nextTick == null)
		{
			return null;
		}

		final long seconds = Math.max(0, Duration.between(now, nextTick).toMillis() / 1000L);
		return MessageFormat.format("Next {0} damage: {1}</br>Time until damage: {2}:{3,number,00}",
			envenomed ? "venom" : "poison", ColorUtil.wrapWithColorTag(String.valueOf(nextDamage), Color.RED),
			seconds / 60, seconds % 60);
	}
}
