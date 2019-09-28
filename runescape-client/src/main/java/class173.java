import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class173 {
	@ObfuscatedName("v")
	@Export("directions")
	static int[][] directions;
	@ObfuscatedName("u")
	@Export("distances")
	static int[][] distances;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 764450151
	)
	static int field2075;
	@ObfuscatedName("m")
	@Export("bufferX")
	static int[] bufferX;
	@ObfuscatedName("y")
	@Export("bufferY")
	static int[] bufferY;
	@ObfuscatedName("fu")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	@Export("fontBold12")
	static Font fontBold12;

	static {
		directions = new int[128][128];
		distances = new int[128][128];
		bufferX = new int[4096];
		bufferY = new int[4096];
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "1868348372"
	)
	public static int method3556(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if (var4 <= 127) {
				++var2;
			} else if (var4 <= 2047) {
				var2 += 2;
			} else {
				var2 += 3;
			}
		}

		return var2;
	}
}
