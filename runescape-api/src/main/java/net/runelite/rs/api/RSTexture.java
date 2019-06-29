package net.runelite.rs.api;

import net.runelite.api.Texture;
import net.runelite.mapping.Import;

public interface RSTexture extends Texture, RSNode
{
	@Import("pixels")
	@Override
	int[] getPixels();

	@Import("animationDirection")
	@Override
	int getAnimationDirection();

	@Import("animationSpeed")
	@Override
	int getAnimationSpeed();

	@Import("isLoaded")
	@Override
	boolean isLoaded();
}
