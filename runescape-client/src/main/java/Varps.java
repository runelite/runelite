import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
@Implements("Varps")
public class Varps {
	@ObfuscatedName("x")
	@Export("Varps_masks")
	static int[] Varps_masks;
	@ObfuscatedName("m")
	@Export("Varps_temp")
	public static int[] Varps_temp;
	@ObfuscatedName("k")
	@Export("Varps_main")
	public static int[] Varps_main;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("Widget_spritesArchive")
	static AbstractArchive Widget_spritesArchive;
	@ObfuscatedName("i")
	public static String[] field2522;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 675557919
	)
	@Export("canvasHeight")
	public static int canvasHeight;

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
