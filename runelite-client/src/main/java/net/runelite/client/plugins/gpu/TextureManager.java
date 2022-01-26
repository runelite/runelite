/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.gpu;

import com.jogamp.opengl.GL4;
import java.nio.ByteBuffer;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Texture;
import net.runelite.api.TextureProvider;

@Singleton
@Slf4j
class TextureManager
{
	private static final float PERC_64 = 1f / 64f;
	private static final float PERC_128 = 1f / 128f;

	private static final int TEXTURE_SIZE = 128;

	int initTextureArray(TextureProvider textureProvider, GL4 gl)
	{
		if (!allTexturesLoaded(textureProvider))
		{
			return -1;
		}

		Texture[] textures = textureProvider.getTextures();

		int textureArrayId = GLUtil.glGenTexture(gl);
		gl.glBindTexture(gl.GL_TEXTURE_2D_ARRAY, textureArrayId);
		gl.glTexStorage3D(gl.GL_TEXTURE_2D_ARRAY, 8, gl.GL_RGBA8, TEXTURE_SIZE, TEXTURE_SIZE, textures.length);

		gl.glTexParameteri(gl.GL_TEXTURE_2D_ARRAY, gl.GL_TEXTURE_MIN_FILTER, gl.GL_NEAREST);
		gl.glTexParameteri(gl.GL_TEXTURE_2D_ARRAY, gl.GL_TEXTURE_MAG_FILTER, gl.GL_NEAREST);

		gl.glTexParameteri(gl.GL_TEXTURE_2D_ARRAY, gl.GL_TEXTURE_WRAP_S, gl.GL_CLAMP_TO_EDGE);

		// Set brightness to 1.0d to upload unmodified textures to GPU
		double save = textureProvider.getBrightness();
		textureProvider.setBrightness(1.0d);

		updateTextures(textureProvider, gl, textureArrayId);

		textureProvider.setBrightness(save);

		gl.glActiveTexture(gl.GL_TEXTURE1);
		gl.glBindTexture(gl.GL_TEXTURE_2D_ARRAY, textureArrayId);
		gl.glGenerateMipmap(gl.GL_TEXTURE_2D_ARRAY);
		gl.glActiveTexture(gl.GL_TEXTURE0);

		return textureArrayId;
	}

	void setAnisotropicFilteringLevel(int textureArrayId, int level, GL4 gl)
	{
		gl.glBindTexture(gl.GL_TEXTURE_2D_ARRAY, textureArrayId);

		//level = 0 means no mipmaps and no anisotropic filtering
		if (level == 0)
		{
			gl.glTexParameteri(gl.GL_TEXTURE_2D_ARRAY, gl.GL_TEXTURE_MIN_FILTER, gl.GL_NEAREST);
		}
		//level = 1 means with mipmaps but without anisotropic filtering GL_MAX_TEXTURE_MAX_ANISOTROPY_EXT defaults to 1.0 which is off
		//level > 1 enables anisotropic filtering. It's up to the vendor what the values mean
		//Even if anisotropic filtering isn't supported, mipmaps will be enabled with any level >= 1
		else
		{
			// Set on GL_NEAREST_MIPMAP_LINEAR (bilinear filtering with mipmaps) since the pixel nature of the game means that nearest filtering
			// looks best for objects up close but allows linear filtering to resolve possible aliasing and noise with mipmaps from far away objects.
			gl.glTexParameteri(gl.GL_TEXTURE_2D_ARRAY, gl.GL_TEXTURE_MIN_FILTER, gl.GL_NEAREST_MIPMAP_LINEAR);
		}

		if (gl.isExtensionAvailable("GL_EXT_texture_filter_anisotropic"))
		{
			final float maxSamples = GLUtil.glGetFloat(gl, gl.GL_MAX_TEXTURE_MAX_ANISOTROPY_EXT);
			//Clamp from 1 to max GL says it supports.
			final float anisoLevel = Math.max(1, Math.min(maxSamples, level));
			gl.glTexParameterf(gl.GL_TEXTURE_2D_ARRAY, gl.GL_TEXTURE_MAX_ANISOTROPY_EXT, anisoLevel);
		}
	}

	void freeTextureArray(GL4 gl, int textureArrayId)
	{
		GLUtil.glDeleteTexture(gl, textureArrayId);
	}

	/**
	 * Check if all textures have been loaded and cached yet.
	 *
	 * @param textureProvider
	 * @return
	 */
	private boolean allTexturesLoaded(TextureProvider textureProvider)
	{
		Texture[] textures = textureProvider.getTextures();
		if (textures == null || textures.length == 0)
		{
			return false;
		}

		for (int textureId = 0; textureId < textures.length; textureId++)
		{
			Texture texture = textures[textureId];
			if (texture != null)
			{
				int[] pixels = textureProvider.load(textureId);
				if (pixels == null)
				{
					return false;
				}
			}
		}

		return true;
	}

	private void updateTextures(TextureProvider textureProvider, GL4 gl, int textureArrayId)
	{
		Texture[] textures = textureProvider.getTextures();

		gl.glBindTexture(gl.GL_TEXTURE_2D_ARRAY, textureArrayId);

		int cnt = 0;
		for (int textureId = 0; textureId < textures.length; textureId++)
		{
			Texture texture = textures[textureId];
			if (texture != null)
			{
				int[] srcPixels = textureProvider.load(textureId);
				if (srcPixels == null)
				{
					log.warn("No pixels for texture {}!", textureId);
					continue; // this can't happen
				}

				++cnt;

				if (srcPixels.length != TEXTURE_SIZE * TEXTURE_SIZE)
				{
					// The texture storage is 128x128 bytes, and will only work correctly with the
					// 128x128 textures from high detail mode
					log.warn("Texture size for {} is {}!", textureId, srcPixels.length);
					continue;
				}

				byte[] pixels = convertPixels(srcPixels, TEXTURE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE);
				ByteBuffer pixelBuffer = ByteBuffer.wrap(pixels);
				gl.glTexSubImage3D(gl.GL_TEXTURE_2D_ARRAY, 0, 0, 0, textureId, TEXTURE_SIZE, TEXTURE_SIZE,
					1, gl.GL_RGBA, gl.GL_UNSIGNED_BYTE, pixelBuffer);
			}
		}

		log.debug("Uploaded textures {}", cnt);
	}

	private static byte[] convertPixels(int[] srcPixels, int width, int height, int textureWidth, int textureHeight)
	{
		byte[] pixels = new byte[textureWidth * textureHeight * 4];

		int pixelIdx = 0;
		int srcPixelIdx = 0;

		int offset = (textureWidth - width) * 4;

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				int rgb = srcPixels[srcPixelIdx++];
				if (rgb != 0)
				{
					pixels[pixelIdx++] = (byte) (rgb >> 16);
					pixels[pixelIdx++] = (byte) (rgb >> 8);
					pixels[pixelIdx++] = (byte) rgb;
					pixels[pixelIdx++] = (byte) -1;
				}
				else
				{
					pixelIdx += 4;
				}
			}
			pixelIdx += offset;
		}
		return pixels;
	}

	/**
	 * Animate the given texture
	 *
	 * @param texture
	 * @param diff    Number of elapsed client ticks since last animation
	 */
	void animate(Texture texture, int diff)
	{
		final int[] pixels = texture.getPixels();
		if (pixels == null)
		{
			return;
		}

		final int animationSpeed = texture.getAnimationSpeed();
		final float uvdiff = pixels.length == 4096 ? PERC_64 : PERC_128;

		float u = texture.getU();
		float v = texture.getV();

		int offset = animationSpeed * diff;
		float d = (float) offset * uvdiff;

		switch (texture.getAnimationDirection())
		{
			case 1:
				v -= d;
				if (v < 0f)
				{
					v += 1f;
				}
				break;
			case 3:
				v += d;
				if (v > 1f)
				{
					v -= 1f;
				}
				break;
			case 2:
				u -= d;
				if (u < 0f)
				{
					u += 1f;
				}
				break;
			case 4:
				u += d;
				if (u > 1f)
				{
					u -= 1f;
				}
				break;
			default:
				return;
		}

		texture.setU(u);
		texture.setV(v);
	}
}
