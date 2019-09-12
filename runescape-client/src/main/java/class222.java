import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class222 {
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1751013611
	)
	static int field2726;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1104641647
	)
	static int field2724;
	@ObfuscatedName("au")
	@ObfuscatedGetter(
		intValue = -653819607
	)
	static int field2729;

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-617072385"
	)
	public static boolean method4101(int var0) {
		return (var0 >> 20 & 1) != 0;
	}
}
