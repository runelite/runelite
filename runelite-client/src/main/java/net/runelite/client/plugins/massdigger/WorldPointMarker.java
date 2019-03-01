package net.runelite.client.plugins.massdigger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldPointMarker
{
	private int x;
	private int y;
	private int z;
	private int color;

	@Override
	public int hashCode()
	{
		return x | (y << 14) | (z << 28);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || obj.getClass() != this.getClass())
		{
			return false;
		}

		WorldPointMarker o = (WorldPointMarker)obj;
		return x == o.x && y == o.y && z == o.z;
	}
}
