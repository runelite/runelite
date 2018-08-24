/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.farmingprofit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

/**
 * Enumeration for the crops that have a harvesting message.
 */
public enum HarvestMessages
{
	SEAWEED(Crop.SEAWEED, "You pick some giant seaweed."),
	CADAVABERRY(Crop.CADAVABERRY, "You pick some cadavaberries."),
	DWELLBERRY(Crop.DWELLBERRY, "You pick some dwellberries."),
	REDBERRY(Crop.REDBERRY, "You pick some redberries."),
	JANGERBERRY(Crop.JANGERBERRY, "You pick some jangerberries."),
	WHITEBERRY(Crop.WHITEBERRY, "You pick some whiteberries.");


	HarvestMessages(Crop crop, String harvestMessage)
	{
		this.crop = crop;
		this.harvestMessage = harvestMessage;
	}

	@Getter
	private final Crop crop;
	@Getter
	private final String harvestMessage;

	private static final Map<String, Crop> map = Collections.unmodifiableMap(initializeMapping());

	public static Crop cropFromMessage(String harvestMessage)
	{
		if (map.containsKey(harvestMessage))
		{
			return map.get(harvestMessage);
		}
		return Crop.UNKNOWN;
	}

	private static Map<String, Crop> initializeMapping()
	{
		Map<String, Crop> mMap = new HashMap<>();
		for (HarvestMessages s : HarvestMessages.values())
		{
			mMap.put(s.harvestMessage, s.crop);
		}
		return mMap;
	}

}
