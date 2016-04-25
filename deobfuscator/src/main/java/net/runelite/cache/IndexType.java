package net.runelite.cache;

public enum IndexType
{
	TWO(2),
	MODELS(7),
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