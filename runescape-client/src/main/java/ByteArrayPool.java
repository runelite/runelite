import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
@Implements("ByteArrayPool")
public class ByteArrayPool {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -2023224885
	)
	@Export("ByteArrayPool_smallCount")
	static int ByteArrayPool_smallCount;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -770015567
	)
	@Export("ByteArrayPool_mediumCount")
	static int ByteArrayPool_mediumCount;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -155376471
	)
	@Export("ByteArrayPool_largeCount")
	static int ByteArrayPool_largeCount;
	@ObfuscatedName("k")
	@Export("ByteArrayPool_small")
	static byte[][] ByteArrayPool_small;
	@ObfuscatedName("u")
	@Export("ByteArrayPool_medium")
	static byte[][] ByteArrayPool_medium;
	@ObfuscatedName("n")
	@Export("ByteArrayPool_large")
	static byte[][] ByteArrayPool_large;
	@ObfuscatedName("q")
	@Export("ByteArrayPool_altSizeArrayCounts")
	public static int[] ByteArrayPool_altSizeArrayCounts;
	@ObfuscatedName("w")
	public static String field3708;

	static {
		ByteArrayPool_smallCount = 0;
		ByteArrayPool_mediumCount = 0;
		ByteArrayPool_largeCount = 0;
		ByteArrayPool_small = new byte[1000][];
		ByteArrayPool_medium = new byte[250][];
		ByteArrayPool_large = new byte[50][];
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IZB)[B",
		garbageValue = "82"
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

		if (FaceNormal.ByteArrayPool_arrays != null) {
			for (int var4 = 0; var4 < UserComparator4.ByteArrayPool_alternativeSizes.length; ++var4) {
				if (UserComparator4.ByteArrayPool_alternativeSizes[var4] != var0) {
					if (var0 < UserComparator4.ByteArrayPool_alternativeSizes[var4]) {
					}
				} else if (ByteArrayPool_altSizeArrayCounts[var4] > 0) {
					byte[] var3 = FaceNormal.ByteArrayPool_arrays[var4][--ByteArrayPool_altSizeArrayCounts[var4]];
					FaceNormal.ByteArrayPool_arrays[var4][ByteArrayPool_altSizeArrayCounts[var4]] = null;
					return var3;
				}
			}
		}

		return new byte[var0];
	}
}
