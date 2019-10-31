import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class188 {
	@ObfuscatedName("a")
	static int[] field2313;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lcc;"
	)
	@Export("pcmPlayerProvider")
	static class99 pcmPlayerProvider;

	static {
		new Object();
		field2313 = new int[33];
		field2313[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field2313[var1] = var0 - 1;
			var0 += var0;
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(B)[Llt;",
		garbageValue = "80"
	)
	@Export("FillMode_values")
	public static FillMode[] FillMode_values() {
		return new FillMode[]{FillMode.SOLID, FillMode.field3849, FillMode.field3847};
	}

	@ObfuscatedName("t")
	static boolean method3793(long var0) {
		int var2 = (int)(var0 >>> 14 & 3L);
		return var2 == 2;
	}
}
