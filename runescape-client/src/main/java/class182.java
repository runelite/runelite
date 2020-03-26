import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class182 {
	@ObfuscatedName("k")
	@Export("directions")
	public static int[][] directions;
	@ObfuscatedName("d")
	@Export("distances")
	public static int[][] distances;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1538364035
	)
	public static int field2097;
	@ObfuscatedName("z")
	@Export("bufferX")
	public static int[] bufferX;
	@ObfuscatedName("t")
	@Export("bufferY")
	public static int[] bufferY;

	static {
		directions = new int[128][128];
		distances = new int[128][128];
		bufferX = new int[4096];
		bufferY = new int[4096];
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(II)[B",
		garbageValue = "130729022"
	)
	@Export("ByteArrayPool_getArray")
	public static synchronized byte[] ByteArrayPool_getArray(int var0) {
		return ByteArrayPool.ByteArrayPool_getArrayBool(var0, false);
	}
}
