package net.runelite.client.plugins.menuentryswapper.util;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GrimyHerbLookup
{
	private static Map<String, HerbInfo> mapping;

	static
	{
		final InputStream herbFile = GrimyHerbLookup.class.getResourceAsStream("/herbs.json");
		Gson gson = new Gson();
		mapping = gson.fromJson(new InputStreamReader(herbFile), new TypeToken<Map<String, HerbInfo>>()
		{
		}.getType());
	}

	public int getCleanLevel(int itemId)
	{
		HerbInfo info = mapping.get(String.valueOf(itemId));
		if (info == null)
		{
			throw new HerbNotFoundException();
		}

		return info.level;
	}

	public int getCleanedItemId(int itemId)
	{
		HerbInfo info = mapping.get(String.valueOf(itemId));
		if (info == null)
		{
			throw new HerbNotFoundException();
		}

		return info.cleanedId;
	}

	public List<Integer> getGrimyHerbIds()
	{
		return mapping.keySet().stream().mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
	}

	private class HerbInfo
	{
		@SerializedName("cleaned")
		private int cleanedId;
		private int level;
	}

}
