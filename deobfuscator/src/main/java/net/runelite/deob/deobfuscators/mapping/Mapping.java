package net.runelite.deob.deobfuscators.mapping;

public class Mapping
{
	private Object object;
	private int count;

	public Mapping(Object object)
	{
		this.object = object;
	}

	@Override
	public String toString()
	{
		return "Mapping{" + "object=" + object + ", count=" + count + '}';
	}

	public Object getObject()
	{
		return object;
	}

	public int getCount()
	{
		return count;
	}

	public void inc()
	{
		++count;
	}

	public void merge(Mapping other)
	{
		assert object == other.object;
		count += other.count;
	}
}
