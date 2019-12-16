import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
@Implements("Varps")
public class Varps {
	@ObfuscatedName("f")
	@Export("Varps_masks")
	static int[] Varps_masks;
	@ObfuscatedName("i")
	@Export("Varps_temp")
	public static int[] Varps_temp;
	@ObfuscatedName("y")
	@Export("Varps_main")
	public static int[] Varps_main;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lfc;"
	)
	@Export("clock")
	static Clock clock;
	@ObfuscatedName("by")
	@ObfuscatedSignature(
		signature = "Lgs;"
	)
	@Export("clientLanguage")
	static Language clientLanguage;
	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "[Lls;"
	)
	@Export("mapMarkerSprites")
	static Sprite[] mapMarkerSprites;

	static {
		Varps_masks = new int[32];
		int var0 = 2;

		for (int var1 = 0; var1 < 32; ++var1) {
			Varps_masks[var1] = var0 - 1;
			var0 += var0;
		}

		Varps_temp = new int[4000];
		Varps_main = new int[4000];
	}
}
