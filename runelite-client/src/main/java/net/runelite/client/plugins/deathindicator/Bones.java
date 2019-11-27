package net.runelite.client.plugins.deathindicator;

import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Scene;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.config.ConfigManager;
import static net.runelite.http.api.RuneLiteAPI.GSON;

@Slf4j
class Bones
{
	private static final String CONFIG_GROUP = "deathIndicator";
	private static final String BONES_PREFIX = "bones_";

	private ImmutableMap<Integer, Map<WorldPoint, List<Bone>>> map;

	void init(Client client, ConfigManager configManager)
	{
		// Clone is important here as the normal array changes
		int[] regions = client.getMapRegions().clone();
		Bone[][] bones = getBones(configManager, regions);
		if (log.isDebugEnabled())
		{
			log.trace("Regions are now {}", Arrays.toString(regions));

			int n = 0;
			for (Bone[] ar : bones)
			{
				n += ar.length;
			}
			log.debug("Loaded {} Bones", n);
		}

		initMap(regions, bones);

		showBones(client.getScene());
	}

	private Bone[][] getBones(ConfigManager configManager, int[] regions)
	{
		Bone[][] bones = new Bone[regions.length][];

		for (int i = 0; i < regions.length; i++)
		{
			int region = regions[i];
			bones[i] = getBones(configManager, region);
		}

		return bones;
	}

	private Bone[] getBones(ConfigManager configManager, int regionId)
	{
		String json = configManager.getConfiguration(CONFIG_GROUP, BONES_PREFIX + regionId);
		if (json == null)
		{
			return new Bone[0];
		}

		return GSON.fromJson(json, Bone[].class);
	}

	@SuppressWarnings("unchecked")
	private void initMap(int[] regions, Bone[][] bones)
	{
		ImmutableMap.Builder<Integer, Map<WorldPoint, List<Bone>>> builder = ImmutableMap.builder();

		for (int i = 0; i < regions.length; i++)
		{
			int region = regions[i];
			Bone[] boneA = bones[i];
			if (boneA.length == 0)
			{
				builder.put(region, new HashMap<>());
				continue;
			}

			Map<WorldPoint, List<Bone>> map = new HashMap(boneA.length);
			for (Bone b : boneA)
			{
				List<Bone> list = map.computeIfAbsent(b.getLoc(), wp -> new ArrayList<>());
				list.add(b);
			}

			builder.put(region, map);
		}

		this.map = builder.build();
	}

	private void showBones(Scene scene)
	{
		this.forEach(bone -> bone.addToScene(scene));
	}

	void save(ConfigManager configManager, int region)
	{
		final Map<WorldPoint, List<Bone>> regionBones = this.map.get(region);
		if (regionBones == null)
		{
			return;
		}

		final String key = BONES_PREFIX + region;

		if (regionBones.size() == 0)
		{
			configManager.unsetConfiguration(CONFIG_GROUP, key);
		}

		List<Bone> list = new ArrayList<>(regionBones.values().size());
		for (List<Bone> lb : regionBones.values())
		{
			list.addAll(lb);
		}

		String val = GSON.toJson(list.toArray(new Bone[0]));
		configManager.setConfiguration(CONFIG_GROUP, key, val);
	}

	public boolean add(Bone bone)
	{
		if (this.map == null || bone == null)
		{
			return false;
		}

		final int region = bone.getLoc().getRegionID();
		final Map<WorldPoint, List<Bone>> map = this.map.get(region);
		final List<Bone> list = map.computeIfAbsent(bone.getLoc(), wp -> new ArrayList<>());
		list.add(bone);
		return true;
	}

	public void remove(Bone bone)
	{
		final int region = bone.getLoc().getRegionID();
		final Map<WorldPoint, List<Bone>> map = this.map.get(region);
		final List<Bone> list = map.get(bone.getLoc());
		list.remove(bone);
	}

	public void clear(Scene scene)
	{
		if (map == null)
		{
			return;
		}

		this.forEach(bone -> bone.removeFromScene(scene));
	}

	public Bone get(WorldPoint point, int i)
	{
		return get(point).get(i);
	}

	public List<Bone> get(WorldPoint point)
	{
		final int reg = point.getRegionID();
		final Map<WorldPoint, List<Bone>> map = this.map.get(reg);
		if (map == null)
		{
			return null;
		}
		return map.get(point);
	}

	private void forEach(Consumer<Bone> consumer)
	{
		for (Map<WorldPoint, List<Bone>> map : this.map.values())
		{
			for (Map.Entry<WorldPoint, List<Bone>> entry : map.entrySet())
			{
				for (Bone bone : entry.getValue())
				{
					consumer.accept(bone);
				}
			}
		}
	}
}
