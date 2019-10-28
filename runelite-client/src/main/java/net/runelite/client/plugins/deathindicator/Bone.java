package net.runelite.client.plugins.deathindicator;

import java.time.Duration;
import java.time.Instant;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Scene;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.deathindicator.DeathIndicatorPlugin.HIJACKED_ITEMID;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.MiscUtils;

@EqualsAndHashCode
@Getter
@Setter
class Bone
{
	private String name;
	private WorldPoint loc;
	private Instant time;

	void addToScene(Scene scene)
	{
		scene.addItem(HIJACKED_ITEMID, 1, loc);
	}

	void removeFromScene(Scene scene)
	{
		scene.removeItem(HIJACKED_ITEMID, 1, loc);
	}

	String getName()
	{
		return ColorUtil.colorStartTag(0xff9040) + "Bones (" + name + ")";
	}

	String getExamine()
	{
		return name + " died here " + MiscUtils.formatTimeAgo(Duration.between(time, Instant.now()));
	}
}
