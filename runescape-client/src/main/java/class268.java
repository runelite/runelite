import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
public class class268 {
	@ObfuscatedName("m")
	@Export("Tiles_hue")
	static int[] Tiles_hue;

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1645671847"
	)
	public static boolean method5042(int var0) {
		return (var0 >> 31 & 1) != 0;
	}
}
