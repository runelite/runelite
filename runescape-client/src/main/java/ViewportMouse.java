import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("ViewportMouse")
public class ViewportMouse {
	@ObfuscatedName("rd")
	@ObfuscatedGetter(
		intValue = -645347533
	)
	static int field1713;
	@ObfuscatedName("a")
	@Export("ViewportMouse_isInViewport")
	public static boolean ViewportMouse_isInViewport;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1568349329
	)
	@Export("ViewportMouse_x")
	public static int ViewportMouse_x;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1582090041
	)
	@Export("ViewportMouse_y")
	public static int ViewportMouse_y;
	@ObfuscatedName("q")
	@Export("ViewportMouse_false0")
	public static boolean ViewportMouse_false0;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1490381659
	)
	static int field1717;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1887189981
	)
	static int field1718;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 355686719
	)
	static int field1719;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1299455817
	)
	static int field1720;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 702740743
	)
	@Export("ViewportMouse_entityCount")
	public static int ViewportMouse_entityCount;
	@ObfuscatedName("x")
	@Export("ViewportMouse_entityTags")
	public static long[] ViewportMouse_entityTags;

	static {
		ViewportMouse_isInViewport = false;
		ViewportMouse_x = 0;
		ViewportMouse_y = 0;
		ViewportMouse_false0 = false;
		ViewportMouse_entityCount = 0;
		ViewportMouse_entityTags = new long[1000];
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1115855205"
	)
	@Export("WorldMapRegion_clearCachedSprites")
	static void WorldMapRegion_clearCachedSprites() {
		WorldMapRegion.WorldMapRegion_cachedSprites.clear();
	}
}
