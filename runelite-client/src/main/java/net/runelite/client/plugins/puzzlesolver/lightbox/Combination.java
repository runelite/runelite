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
package net.runelite.client.plugins.puzzlesolver.lightbox;

import java.util.HashMap;
import java.util.Map;
import net.runelite.api.widgets.WidgetInfo;

public enum Combination
{
	A(WidgetInfo.LIGHT_BOX_BUTTON_A.getId()),
	B(WidgetInfo.LIGHT_BOX_BUTTON_B.getId()),
	C(WidgetInfo.LIGHT_BOX_BUTTON_C.getId()),
	D(WidgetInfo.LIGHT_BOX_BUTTON_D.getId()),
	E(WidgetInfo.LIGHT_BOX_BUTTON_E.getId()),
	F(WidgetInfo.LIGHT_BOX_BUTTON_F.getId()),
	G(WidgetInfo.LIGHT_BOX_BUTTON_G.getId()),
	H(WidgetInfo.LIGHT_BOX_BUTTON_H.getId());

	private static final Map<String, Integer> combinations = new HashMap<>();

	private final int id;

	static
	{
		for (Combination combination : values())
		{
			combinations.put(combination.name(), combination.getId());
		}
	}

	Combination(int id)
	{
		this.id = id;
	}

	private int getId()
	{
		return id;
	}

	public static int find(String letter)
	{
		return combinations.get(letter);
	}
}
