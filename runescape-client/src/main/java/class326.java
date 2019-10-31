import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lz")
public class class326 {
	@ObfuscatedName("i")
	public static short[] field3881;

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1165668124"
	)
	public static int method6375(int var0) {
		if (var0 > 0) {
			return 1;
		} else {
			return var0 < 0 ? -1 : 0;
		}
	}
}
