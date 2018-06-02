package net.runelite.cache.models;

public class VertexNormal
{
	public int x;
	public int y;
	public int z;
	public int magnitude;

	public Vector3f normalize()
	{
		Vector3f v = new Vector3f();

		int length = (int) Math.sqrt((double) (x * x + y * y + z * z));
		if (length == 0)
		{
			length = 1;
		}

		v.x = (float) x / length;
		v.y = (float) y / length;
		v.z = (float) z / length;

		assert v.x >= -1f && v.x <= 1f;
		assert v.y >= -1f && v.y <= 1f;
		assert v.z >= -1f && v.z <= 1f;

		return v;
	}
}
