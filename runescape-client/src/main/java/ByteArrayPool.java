import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("ByteArrayPool")
public class ByteArrayPool {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1085109787
	)
	@Export("ByteArrayPool_smallCount")
	static int ByteArrayPool_smallCount;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -745592959
	)
	@Export("ByteArrayPool_mediumCount")
	static int ByteArrayPool_mediumCount;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1171490501
	)
	@Export("ByteArrayPool_largeCount")
	static int ByteArrayPool_largeCount;
	@ObfuscatedName("u")
	@Export("ByteArrayPool_small")
	static byte[][] ByteArrayPool_small;
	@ObfuscatedName("r")
	@Export("ByteArrayPool_medium")
	static byte[][] ByteArrayPool_medium;
	@ObfuscatedName("p")
	@Export("ByteArrayPool_large")
	static byte[][] ByteArrayPool_large;
	@ObfuscatedName("q")
	@Export("ByteArrayPool_alternativeSizes")
	public static int[] ByteArrayPool_alternativeSizes;
	@ObfuscatedName("m")
	@Export("ByteArrayPool_altSizeArrayCounts")
	public static int[] ByteArrayPool_altSizeArrayCounts;

	static {
		ByteArrayPool_smallCount = 0;
		ByteArrayPool_mediumCount = 0;
		ByteArrayPool_largeCount = 0;
		ByteArrayPool_small = new byte[1000][];
		ByteArrayPool_medium = new byte[250][];
		ByteArrayPool_large = new byte[50][];
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IZB)[B",
		garbageValue = "-44"
	)
	@Export("ByteArrayPool_getArrayBool")
	static synchronized byte[] ByteArrayPool_getArrayBool(int var0, boolean var1) {
		byte[] var2;
		if (var0 != 100) {
			if (var0 < 100) {
			}
		} else if (ByteArrayPool_smallCount > 0) {
			var2 = ByteArrayPool_small[--ByteArrayPool_smallCount];
			ByteArrayPool_small[ByteArrayPool_smallCount] = null;
			return var2;
		}

		if (var0 != 5000) {
			if (var0 < 5000) {
			}
		} else if (ByteArrayPool_mediumCount > 0) {
			var2 = ByteArrayPool_medium[--ByteArrayPool_mediumCount];
			ByteArrayPool_medium[ByteArrayPool_mediumCount] = null;
			return var2;
		}

		if (var0 != 30000) {
			if (var0 < 30000) {
			}
		} else if (ByteArrayPool_largeCount > 0) {
			var2 = ByteArrayPool_large[--ByteArrayPool_largeCount];
			ByteArrayPool_large[ByteArrayPool_largeCount] = null;
			return var2;
		}

		if (class81.ByteArrayPool_arrays != null) {
			for (int var4 = 0; var4 < ByteArrayPool_alternativeSizes.length; ++var4) {
				if (ByteArrayPool_alternativeSizes[var4] != var0) {
					if (var0 < ByteArrayPool_alternativeSizes[var4]) {
					}
				} else if (ByteArrayPool_altSizeArrayCounts[var4] > 0) {
					byte[] var3 = class81.ByteArrayPool_arrays[var4][--ByteArrayPool_altSizeArrayCounts[var4]];
					class81.ByteArrayPool_arrays[var4][ByteArrayPool_altSizeArrayCounts[var4]] = null;
					return var3;
				}
			}
		}

		return new byte[var0];
	}
}
