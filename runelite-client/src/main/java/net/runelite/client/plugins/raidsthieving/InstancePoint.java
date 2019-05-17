package net.runelite.client.plugins.raidsthieving;

import java.util.Objects;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;

/**
 * Represents a point in the instance chunk, invariant of rotation.
 */
@Getter
public class InstancePoint
{
	private static final int CHUNK_SIZE = 8;
	private static final double CHUNK_OFFSET = 3.5;

	public InstancePoint(int x, int y, int rot)
	{
		this.x = x;
		this.y = y;
		this.rot = rot;
	}

	public InstancePoint(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.rot = 0;
	}

	public static InstancePoint buildFromPoint(WorldPoint worldPoint, Client client)
	{
		Point point = new Point(worldPoint.getX(), worldPoint.getY());
		Point base = new Point(client.getBaseX(), client.getBaseY());
		int plane = worldPoint.getPlane();

		int deltaX = point.getX() - base.getX();
		int deltaY = point.getY() - base.getY();
		int chunkIndexX = deltaX / CHUNK_SIZE;
		int chunkIndexY = deltaY / CHUNK_SIZE;

		int chunkData = client.getInstanceTemplateChunks()[plane][chunkIndexX][chunkIndexY];
		int rotation = chunkData >> 1 & 0x3;
		int y = (chunkData >> 3 & 0x7FF) * 8;
		int x = (chunkData >> 14 & 0x3FF) * 8;

		return buildFromTile(base, point, rotation, new Point(x, y));
	}

	public static InstancePoint buildFromTile(Point base, Point tile, int rot, Point chunkOrigin)
	{
		int deltaX = tile.getX() - base.getX();
		int deltaY = tile.getY() - base.getY();

		double chunkOffsetX = (deltaX % CHUNK_SIZE) - CHUNK_OFFSET;
		double chunkOffsetY = (deltaY % CHUNK_SIZE) - CHUNK_OFFSET;

		for (int i = 0; i < rot; i++)
		{
			double temp = chunkOffsetX;
			chunkOffsetX = -chunkOffsetY;
			chunkOffsetY = temp;
		}

		chunkOffsetX += CHUNK_OFFSET;
		chunkOffsetY += CHUNK_OFFSET;

		int invariantChunkOffsetX = (int) chunkOffsetX;
		int invariantChunkOffsetY = (int) chunkOffsetY;

		return new InstancePoint(
			chunkOrigin.getX() + invariantChunkOffsetX,
			chunkOrigin.getY() + invariantChunkOffsetY,
			rot);
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		InstancePoint that = (InstancePoint) o;
		return x == that.x &&
			y == that.y;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(x, y);
	}

	private int x;
	private int y;
	private int rot;
}
