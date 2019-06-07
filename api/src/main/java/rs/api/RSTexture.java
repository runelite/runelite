package rs.api;

import api.Texture;
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
