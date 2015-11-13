package net.runelite.cache.definitions;

import net.runelite.cache.definitions.loaders.SpriteLoader;

public class SpriteDefinition
{
	private SpriteLoader loader;
	private int offsetX;
	private int offsetY;
	private int width;
	private int height;
	private byte[] pixels;
	private int maxWidth;
	private int maxHeight;

	public SpriteDefinition(SpriteLoader loader)
	{
		this.loader = loader;
	}

	public SpriteLoader getLoader()
	{
		return loader;
	}

	public void setLoader(SpriteLoader loader)
	{
		this.loader = loader;
	}

	public int getOffsetX()
	{
		return offsetX;
	}

	public void setOffsetX(int offsetX)
	{
		this.offsetX = offsetX;
	}

	public int getOffsetY()
	{
		return offsetY;
	}

	public void setOffsetY(int offsetY)
	{
		this.offsetY = offsetY;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public byte[] getPixels()
	{
		return pixels;
	}

	public void setPixels(byte[] pixels)
	{
		this.pixels = pixels;
	}

	public int getMaxWidth()
	{
		return maxWidth;
	}

	public void setMaxWidth(int maxWidth)
	{
		this.maxWidth = maxWidth;
	}

	public int getMaxHeight()
	{
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight)
	{
		this.maxHeight = maxHeight;
	}
	
	
}
