import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("FloorDecoration")
public final class FloorDecoration {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1588480469
	)
	@Export("y")
	int y;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		longValue = -6831837537966124847L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -198900691
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1743466221
	)
	@Export("x")
	int x;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1370776167
	)
	@Export("flags")
	int flags;

	FloorDecoration() {
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-95"
	)
	public static void method2952(int var0, int var1) {
		VarbitDefinition var2 = SpriteMask.method4061(var0);
		int var3 = var2.baseVar;
		int var4 = var2.startBit;
		int var5 = var2.endBit;
		int var6 = Varps.Varps_masks[var5 - var4];
		if (var1 < 0 || var1 > var6) {
			var1 = 0;
		}

		var6 <<= var4;
		Varps.Varps_main[var3] = Varps.Varps_main[var3] & ~var6 | var1 << var4 & var6;
	}
}
