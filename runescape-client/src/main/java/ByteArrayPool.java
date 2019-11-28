import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
@Implements("ByteArrayPool")
public class ByteArrayPool {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 153239603
	)
	@Export("ByteArrayPool_smallCount")
	static int ByteArrayPool_smallCount;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -433125971
	)
	@Export("ByteArrayPool_mediumCount")
	static int ByteArrayPool_mediumCount;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1031778889
	)
	@Export("ByteArrayPool_largeCount")
	static int ByteArrayPool_largeCount;
	@ObfuscatedName("g")
	@Export("ByteArrayPool_small")
	static byte[][] ByteArrayPool_small;
	@ObfuscatedName("z")
	@Export("ByteArrayPool_medium")
	static byte[][] ByteArrayPool_medium;
	@ObfuscatedName("p")
	@Export("ByteArrayPool_large")
	static byte[][] ByteArrayPool_large;
	@ObfuscatedName("w")
	@Export("ByteArrayPool_arrays")
	static byte[][][] ByteArrayPool_arrays;

	static {
		ByteArrayPool_smallCount = 0;
		ByteArrayPool_mediumCount = 0;
		ByteArrayPool_largeCount = 0;
		ByteArrayPool_small = new byte[1000][];
		ByteArrayPool_medium = new byte[250][];
		ByteArrayPool_large = new byte[50][];
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IZI)[B",
		garbageValue = "-2110348593"
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

		if (ByteArrayPool_arrays != null) {
			for (int var4 = 0; var4 < WorldMapSprite.ByteArrayPool_alternativeSizes.length; ++var4) {
				if (WorldMapSprite.ByteArrayPool_alternativeSizes[var4] != var0) {
					if (var0 < WorldMapSprite.ByteArrayPool_alternativeSizes[var4]) {
					}
				} else if (class216.ByteArrayPool_altSizeArrayCounts[var4] > 0) {
					byte[] var3 = ByteArrayPool_arrays[var4][--class216.ByteArrayPool_altSizeArrayCounts[var4]];
					ByteArrayPool_arrays[var4][class216.ByteArrayPool_altSizeArrayCounts[var4]] = null;
					return var3;
				}
			}
		}

		return new byte[var0];
	}
}
