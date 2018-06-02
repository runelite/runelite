package net.runelite.cache.models;

public class Vector3f
{
	public float x;
	public float y;
	public float z;

	public Vector3f()
	{
	}

	public Vector3f(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3f(Vector3f other)
	{
		this.x = other.x;
		this.y = other.y;
		this.z = other.z;
	}

	@Override
	public String toString()
	{
		return "Vector3f{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 23 * hash + Float.floatToIntBits(this.x);
		hash = 23 * hash + Float.floatToIntBits(this.y);
		hash = 23 * hash + Float.floatToIntBits(this.z);
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
		final Vector3f other = (Vector3f) obj;
		if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x))
		{
			return false;
		}
		if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y))
		{
			return false;
		}
		if (Float.floatToIntBits(this.z) != Float.floatToIntBits(other.z))
		{
			return false;
		}
		return true;
	}

	public float getX()
	{
		return x;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY(float y)
	{
		this.y = y;
	}

	public float getZ()
	{
		return z;
	}

	public void setZ(float z)
	{
		this.z = z;
	}
}
