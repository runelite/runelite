package net.runelite.client.plugins.farmingprofit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

public enum HarvestMessages
{
	SEEWEED(Crop.SEEWEED, "You pick some giant seeweed.");


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
