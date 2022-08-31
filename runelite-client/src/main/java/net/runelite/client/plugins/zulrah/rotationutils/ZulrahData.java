package net.runelite.client.plugins.zulrah.rotationutils;

import java.util.Optional;
import javax.annotation.Nullable;
import net.runelite.api.Prayer;
import net.runelite.client.plugins.zulrah.ZulrahPlugin;
import net.runelite.client.plugins.zulrah.constants.StandLocation;
import net.runelite.client.plugins.zulrah.constants.ZulrahType;

public class ZulrahData
{
	@Nullable
	private final ZulrahPhase current;
	@Nullable
	private final ZulrahPhase next;

	public ZulrahData(@Nullable ZulrahPhase current, @Nullable ZulrahPhase next)
	{
		this.current = current;
		this.next = next;
	}

	public Optional<ZulrahPhase> getCurrentPhase()
	{
		return Optional.ofNullable(current);
	}

	public Optional<ZulrahPhase> getNextPhase()
	{
		return Optional.ofNullable(next);
	}

	public Optional<ZulrahNpc> getCurrentZulrahNpc()
	{
		return current == null ? Optional.empty() : Optional.ofNullable(current.getZulrahNpc());
	}

	public Optional<ZulrahNpc> getNextZulrahNpc()
	{
		return next == null ? Optional.empty() : Optional.ofNullable(next.getZulrahNpc());
	}

	public Optional<StandLocation> getCurrentDynamicStandLocation()
	{
		if (current == null)
		{
			return Optional.empty();
		}
		else if (current.getZulrahNpc().getType() == ZulrahType.MELEE)
		{
			switch (current.getAttributes().getStandLocation())
			{
				case NORTHEAST_TOP:
					return ZulrahPlugin.isFlipStandLocation() ? Optional.of(StandLocation.NORTHEAST_BOTTOM) : Optional.of(current.getAttributes().getStandLocation());
				case WEST:
					return ZulrahPlugin.isFlipStandLocation() ? Optional.of(StandLocation.NORTHWEST_BOTTOM) : Optional.of(current.getAttributes().getStandLocation());
				default:
					return Optional.of(current.getAttributes().getStandLocation());
			}
		}
		else
		{
			return Optional.of(current.getAttributes().getStandLocation());
		}
	}

	public Optional<StandLocation> getNextStandLocation()
	{
		return next == null ? Optional.empty() : Optional.of(next.getAttributes().getStandLocation());
	}

	public Optional<StandLocation> getCurrentStallLocation()
	{
		return current == null ? Optional.empty() : Optional.ofNullable(current.getAttributes().getStallLocation());
	}

	public Optional<StandLocation> getNextStallLocation()
	{
		return next == null ? Optional.empty() : Optional.ofNullable(next.getAttributes().getStallLocation());
	}

	public Optional<Prayer> getCurrentPhasePrayer()
	{
		if (ZulrahPlugin.isZulrahReset())
		{
			return Optional.of(Prayer.PROTECT_FROM_MISSILES);
		}
		else if (current != null && current.getAttributes().getPrayer() != null)
		{
			Prayer phasePrayer = current.getAttributes().getPrayer();
			Prayer invertedPhasePrayer = phasePrayer == Prayer.PROTECT_FROM_MAGIC ? Prayer.PROTECT_FROM_MISSILES : Prayer.PROTECT_FROM_MAGIC;
			return isJad() ? (ZulrahPlugin.isFlipPhasePrayer() ? Optional.of(invertedPhasePrayer) : Optional.of(phasePrayer)) : Optional.of(phasePrayer);
		}
		else
		{
			return Optional.empty();
		}
	}

	public boolean standLocationsMatch()
	{
		return getCurrentDynamicStandLocation().isPresent() && getNextStandLocation().isPresent() && (getCurrentDynamicStandLocation().get()).equals(getNextStandLocation().get());
	}

	public boolean stallLocationsMatch()
	{
		return isPhasesNotNull() && current.getAttributes().getStallLocation() != null && next.getAttributes().getStallLocation() != null && current.getAttributes().getStallLocation().equals(next.getAttributes().getStallLocation());
	}

	public boolean isJad()
	{
		return current != null && current.getZulrahNpc().isJad();
	}

	private boolean isPhasesNotNull()
	{
		return current != null && next != null;
	}
}
