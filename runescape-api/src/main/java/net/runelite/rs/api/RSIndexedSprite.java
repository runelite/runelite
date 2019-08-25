package net.runelite.rs.api;

import net.runelite.api.IndexedSprite;
import net.runelite.mapping.Import;

public interface RSIndexedSprite extends IndexedSprite
{
	@Import("pixels")
	@Override
	byte[] getPixels();

	@Import("pixels")
	@Override
	void setPixels(byte[] pixels);

	@Import("palette")
	@Override
	int[] getPalette();

	@Import("palette")
	@Override
	void setPalette(int[] palette);

	@Import("width")
	@Override
	int getOriginalWidth();

	@Import("width")
	@Override
	void setOriginalWidth(int originalWidth);

	@Import("height")
	@Override
	int getOriginalHeight();

	@Import("height")
	@Override
	void setOriginalHeight(int originalHeight);

	@Import("subHeight")
	@Override
	int getHeight();

	@Import("subHeight")
	@Override
	void setHeight(int height);

	@Import("xOffset")
	@Override
	int getOffsetX();

	@Import("xOffset")
	@Override
	void setOffsetX(int offsetX);

	@Import("yOffset")
	@Override
	int getOffsetY();

	@Import("yOffset")
	@Override
	void setOffsetY(int offsetY);

	@Import("subWidth")
	@Override
	int getWidth();

	@Import("subWidth")
	@Override
	void setWidth(int width);
}
