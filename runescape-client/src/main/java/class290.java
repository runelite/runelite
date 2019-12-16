import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kf")
public final class class290 {
	@ObfuscatedName("a")
	@Export("SpriteBuffer_pixels")
	public static byte[][] SpriteBuffer_pixels;

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "-1637680700"
	)
	public static int method5375(String var0) {
		return var0.length() + 2;
	}
}
