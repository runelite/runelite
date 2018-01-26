/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
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
package net.runelite.client.plugins.barbarianassault;

import java.util.HashMap;
import java.util.Map;

public enum Calls
{
	//Attacker Calls
	RED_EGG("Red egg", "Tell-red"),
	GREEN_EGG("Green egg", "Tell-green"),
	BLUE_EGG("Blue egg", "Tell-blue"),
	//Collector Calls
	CONTROLLED("Controlled/Bullet/Wind", "Tell-controlled"),
	ACCURATE("Accurate/Field/Water", "Tell-accurate"),
	AGGRESSIVE("Aggressive/Blunt/Earth", "Tell-aggressive"),
	DEFENSIVE("Defensive/Barbed/Fire", "Tell-defensive"),
	//Healer Calls
	TOFU("Tofu", "Tell-tofu"),
	CRACKERS("Crackers", "Tell-crackers"),
	WORMS("Worms", "Tell-worms"),
	//Defender Calls
	POIS_WORMS("Pois. Worms", "Tell-worms"),
	POIS_TOFU("Pois. Tofu", "Tell-tofu"),
	POIS_MEAT("Pois. Meat", "Tell-meat");

	private final String call;
	private final String option;

	private static final Map<String, String> CALL_MENU = new HashMap<>();

	static
	{
		for (Calls s : values())
		{
			CALL_MENU.put(s.getCall(), s.getOption());
		}
	}

	Calls(String call, String option)
	{
		this.call = call;
		this.option = option;
	}

	public String getCall()
	{
		return call;
	}

	public String getOption()
	{
		return option;
	}

	public static String getOption(String call)
	{
		return CALL_MENU.get(call);
	}

}
