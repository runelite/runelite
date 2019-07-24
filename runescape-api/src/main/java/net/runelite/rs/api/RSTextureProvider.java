package net.runelite.rs.api;

import net.runelite.api.TextureProvider;
import net.runelite.mapping.Import;

public interface RSTextureProvider extends TextureProvider
{
	@Import("brightness")
	@Override
	double getBrightness();

	@Import("setBrightness")
	@Override
	void setBrightness(double brightness);

	@Import("capacity")
	void setMaxSize(int maxSize);

	@Import("remaining")
	void setSize(int size);

	@Import("textures")
	@Override
	RSTexture[] getTextures();

	@Import("load")
	@Override
	int[] load(int textureId);
}
