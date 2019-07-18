import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class173 {
	@ObfuscatedName("e")
	@Export("directions")
	public static int[][] directions;
	@ObfuscatedName("p")
	@Export("distances")
	public static int[][] distances;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1613442925
	)
	public static int field2088;
	@ObfuscatedName("i")
	@Export("bufferX")
	public static int[] bufferX;
	@ObfuscatedName("c")
	@Export("bufferY")
	public static int[] bufferY;
	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		signature = "[Lly;"
	)
	@Export("headIconHintSprites")
	static Sprite[] headIconHintSprites;

	static {
		directions = new int[128][128];
		distances = new int[128][128];
		bufferX = new int[4096];
		bufferY = new int[4096];
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)Lfu;",
		garbageValue = "-1483717574"
	)
	public static Clock method3589() {
		try {
			return new NanoClock();
		} catch (Throwable var1) {
			return new MilliClock();
		}
	}
}
