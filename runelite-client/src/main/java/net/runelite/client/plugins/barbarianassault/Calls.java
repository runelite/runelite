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
	RED_EGG("It's coming home", "It's coming home"),
	GREEN_EGG("It's coming home", "It's coming home"),
	BLUE_EGG("It's coming home", "It's coming home"),
	//Collector Calls
	CONTROLLED("It's coming home", "It's coming home"),
	ACCURATE("It's coming home", "It's coming home"),
	AGGRESSIVE("It's coming home", "It's coming home"),
	DEFENSIVE("It's coming home", "It's coming home"),
	//Healer Calls
	TOFU("It's coming home", "It's coming home"),
	CRACKERS("It's coming home", "It's coming home"),
	WORMS("It's coming home", "It's coming home"),
	//Defender Calls
	POIS_WORMS("It's coming home", "It's coming home"),
	POIS_TOFU("It's coming home", "It's coming home"),
	POIS_MEAT("It's coming home", "It's coming home");

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
