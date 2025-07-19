/*
 * Copyright (c) 2021, Trevor <https://github.com/Trevor159>
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
package net.runelite.client.plugins.grounditems;

import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Animation;
import net.runelite.api.Client;
import net.runelite.api.JagexColor;
import net.runelite.api.Model;
import net.runelite.api.ModelData;
import net.runelite.api.RuneLiteObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import java.awt.Color;
import net.runelite.api.gameval.AnimationID;
import net.runelite.client.callback.ClientThread;

class Lootbeam
{
	private final RuneLiteObject runeLiteObject;
	private final Client client;
	private final ClientThread clientThread;
	private Color color;
	private Style style;

	@RequiredArgsConstructor
	public enum Style
	{
		LIGHT(l -> l.client.loadModel(
			5809,
			new short[]{6371},
			new short[]{JagexColor.rgbToHSL(l.color.getRGB(), 1.0d)}
		), anim(AnimationID.ENAKH_LIGHT_STREAMING)),
		MODERN(l ->
		{
			ModelData md = l.client.loadModelData(43330);
			if (md == null)
			{
				return null;
			}

			short hsl = JagexColor.rgbToHSL(l.color.getRGB(), 1.0d);
			int hue = JagexColor.unpackHue(hsl);
			int sat = JagexColor.unpackSaturation(hsl);
			int lum = JagexColor.unpackLuminance(hsl);
			int satDelta = sat > 2 ? 1 : 0;

			return md.cloneColors()
				.recolor((short) 26432, JagexColor.packHSL(hue, sat - satDelta, lum))
				.recolor((short) 26584, JagexColor.packHSL(hue, sat, Math.min(lum + 24, JagexColor.LUMINANCE_MAX)))
				.light(75 + ModelData.DEFAULT_AMBIENT, 1875 + ModelData.DEFAULT_CONTRAST,
					ModelData.DEFAULT_X, ModelData.DEFAULT_Y, ModelData.DEFAULT_Z);
		}, anim(AnimationID.FX_BEAM_IDLE)),
		;

		private final Function<Lootbeam, Model> modelSupplier;
		private final Function<Lootbeam, Animation> animationSupplier;
	}

	private static Function<Lootbeam, Animation> anim(int id)
	{
		return b -> b.client.loadAnimation(id);
	}

	public Lootbeam(Client client, ClientThread clientThread, WorldPoint worldPoint, Color color, Style style)
	{
		this.client = client;
		this.clientThread = clientThread;
		runeLiteObject = client.createRuneLiteObject();

		this.color = color;
		this.style = style;
		update();
		runeLiteObject.setShouldLoop(true);

		LocalPoint lp = LocalPoint.fromWorld(client, worldPoint);
		runeLiteObject.setLocation(lp, client.getPlane());

		runeLiteObject.setActive(true);
	}

	public void setColor(Color color)
	{
		if (this.color != null && this.color.equals(color))
		{
			return;
		}

		this.color = color;
		update();
	}

	public void setStyle(Style style)
	{
		if (this.style == style)
		{
			return;
		}

		this.style = style;
		update();
	}

	private void update()
	{
		clientThread.invoke(() ->
		{
			Model model = style.modelSupplier.apply(this);
			if (model == null)
			{
				return false;
			}

			Animation anim = style.animationSupplier.apply(this);

			runeLiteObject.setAnimation(anim);
			runeLiteObject.setModel(model);
			return true;
		});
	}

	public void remove()
	{
		runeLiteObject.setActive(false);
	}

}
