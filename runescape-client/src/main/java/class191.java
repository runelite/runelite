import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class191 {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	static final class191 field2333;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	static final class191 field2336;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgt;"
	)
	static final class191 field2335;

	static {
		field2333 = new class191();
		field2336 = new class191();
		field2335 = new class191();
	}

	class191() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "200014911"
	)
	@Export("ByteArrayPool_release")
	public static synchronized void ByteArrayPool_release(byte[] var0) {
		if (var0.length == 100 && ByteArrayPool.ByteArrayPool_smallCount < 1000) {
			ByteArrayPool.ByteArrayPool_small[++ByteArrayPool.ByteArrayPool_smallCount - 1] = var0;
		} else if (var0.length == 5000 && ByteArrayPool.ByteArrayPool_mediumCount < 250) {
			ByteArrayPool.ByteArrayPool_medium[++ByteArrayPool.ByteArrayPool_mediumCount - 1] = var0;
		} else if (var0.length == 30000 && ByteArrayPool.ByteArrayPool_largeCount < 50) {
			ByteArrayPool.ByteArrayPool_large[++ByteArrayPool.ByteArrayPool_largeCount - 1] = var0;
		} else {
			if (HorizontalAlignment.ByteArrayPool_arrays != null) {
				for (int var1 = 0; var1 < ByteArrayPool.ByteArrayPool_alternativeSizes.length; ++var1) {
					if (var0.length == ByteArrayPool.ByteArrayPool_alternativeSizes[var1] && class222.ByteArrayPool_altSizeArrayCounts[var1] < HorizontalAlignment.ByteArrayPool_arrays[var1].length) {
						HorizontalAlignment.ByteArrayPool_arrays[var1][class222.ByteArrayPool_altSizeArrayCounts[var1]++] = var0;
						return;
					}
				}
			}

		}
	}
}
