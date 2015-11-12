package net.runelite.cache;

public enum IndexType
{
	SPRITE(8);

	private int id;
	
	IndexType(int id)
	{
		this.id = id;
	}
	
	public int getNumber()
	{
		return id;
	}
}