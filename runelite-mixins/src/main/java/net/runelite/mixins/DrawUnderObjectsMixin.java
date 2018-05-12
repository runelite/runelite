/*
 * Copyright (c) 2018 Abex
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
package net.runelite.mixins;

import java.awt.Point;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Arrays;
import java.util.Hashtable;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSBufferProvider;
import net.runelite.rs.api.RSClient;

@Mixin(RSClient.class)
public abstract class DrawUnderObjectsMixin implements RSClient
{
	@Inject
	public static BufferedImage underObjectBuffer;

	@Inject
	public static boolean isUnderObject = false;

	@Inject
	public static int[] underObjectPixels = new int[0];

	@Inject
	@Override
	public BufferedImage getUnderObjectBuffer()
	{
		RSBufferProvider mainBuf = getBufferProvider();
		if (underObjectPixels.length != mainBuf.getPixels().length)
		{
			int width = mainBuf.getWidth();
			int height = mainBuf.getHeight();
			underObjectPixels = new int[width * height + 1];
			DataBufferInt var4 = new DataBufferInt(underObjectPixels, underObjectPixels.length);
			DirectColorModel var5 = new DirectColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), 32, 0x00FF0000, 0x0000FF00, 0x000000FF, 0xFF000000, true, DataBuffer.TYPE_INT);
			WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(width, height), var4, (Point) null);
			underObjectBuffer = new BufferedImage(var5, var6, false, new Hashtable());
		}
		Arrays.fill(underObjectPixels, 0);
		return underObjectBuffer;
	}

	@Inject
	public static void blendUnderObjectBuffer(final int[] array, final int index, final int d)
	{
		final int s = underObjectPixels[index];
		final int a = (s >>> 24) + 1;

		final int drb = d & 0x00FF00FF;
		final int srb = s & 0x00FF00FF;
		final int nrb = ((srb - drb) * a) >>> 8;
		final int frb = (nrb + drb) & 0x00FF00FF;

		final int dg = d & 0x0000FF00;
		final int sg = s & 0x0000FF00;
		final int ng = ((sg - dg) * a) >>> 8;
		final int fg = (ng + dg) & 0x0000FF00;

		array[index] = frb | fg;
	}
}
