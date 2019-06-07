package rs.api;

import api.TextureProvider;
import net.runelite.mapping.Import;

public interface RSTextureProvider extends TextureProvider
{
	@Import("brightness0")
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
