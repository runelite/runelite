package net.runelite.rs.api;

import net.runelite.api.TilePaint;
import net.runelite.mapping.Import;

public interface RSTilePaint extends TilePaint
{
	@Import("rgb")
	@Override
	int getRBG();

	@Import("swColor")
	@Override
	int getSwColor();

	@Import("nwColor")
	@Override
	int getSeColor();

	@Import("seColor")
	@Override
	int getNwColor();

	@Import("neColor")
	@Override
	int getNeColor();

	@Import("texture")
	@Override
	int getTexture();
}
