package net.runelite.client.plugins.zulrah.rotationutils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.runelite.api.Prayer;
import net.runelite.client.plugins.zulrah.constants.StandLocation;

public final class ZulrahAttributes
{
	@Nonnull
	private final StandLocation standLocation;
	@Nullable
	private final StandLocation stallLocation;
	@Nullable
	private final Prayer prayer;
	private final int phaseTicks;

	public ZulrahAttributes(@Nonnull StandLocation standLocation, @Nullable StandLocation stallLocation, @Nullable Prayer prayer, int phaseTicks)
	{
		if (standLocation == null)
		{
			throw new NullPointerException("standLocation is marked non-null but is null");
		}
		else
		{
			this.standLocation = standLocation;
			this.stallLocation = stallLocation;
			this.prayer = prayer;
			this.phaseTicks = phaseTicks;
		}
	}

	@Nonnull
	public StandLocation getStandLocation()
	{
		return this.standLocation;
	}

	@Nullable
	public StandLocation getStallLocation()
	{
		return this.stallLocation;
	}

	@Nullable
	public Prayer getPrayer()
	{
		return this.prayer;
	}

	public int getPhaseTicks()
	{
		return this.phaseTicks;
	}

	public boolean equals(Object o)
	{
		if (o == this)
		{
			return true;
		}
		else if (!(o instanceof ZulrahAttributes))
		{
			return false;
		}
		else
		{
			ZulrahAttributes other = (ZulrahAttributes) o;
			Object this$standLocation = getStandLocation();
			Object other$standLocation = other.getStandLocation();
			if (this$standLocation == null)
			{
				if (other$standLocation != null)
				{
					return false;
				}
			}
			else if (!this$standLocation.equals(other$standLocation))
			{
				return false;
			}

			label41:
			{
				Object this$stallLocation = getStallLocation();
				Object other$stallLocation = other.getStallLocation();
				if (this$stallLocation == null)
				{
					if (other$stallLocation == null)
					{
						break label41;
					}
				}
				else if (this$stallLocation.equals(other$stallLocation))
				{
					break label41;
				}

				return false;
			}

			Object this$prayer = getPrayer();
			Object other$prayer = other.getPrayer();
			if (this$prayer == null)
			{
				if (other$prayer != null)
				{
					return false;
				}
			}
			else if (!this$prayer.equals(other$prayer))
			{
				return false;
			}

			if (getPhaseTicks() != other.getPhaseTicks())
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}

	public int hashCode()
	{
		byte PRIME = 59;
		int result = 1;
		Object $standLocation = getStandLocation();
		result = result * PRIME + $standLocation.hashCode();
		Object $stallLocation = getStallLocation();
		result = result * PRIME + ($stallLocation == null ? 43 : $stallLocation.hashCode());
		Object $prayer = getPrayer();
		result = result * PRIME + ($prayer == null ? 43 : $prayer.hashCode());
		result = result * PRIME + getPhaseTicks();
		return result;
	}

	public String toString()
	{
		StandLocation standLocation = getStandLocation();
		return "ZulrahAttributes(standLocation=" + standLocation + ", stallLocation=" + getStallLocation() + ", prayer=" + getPrayer() + ", phaseTicks=" + getPhaseTicks() + ")";
	}
}
