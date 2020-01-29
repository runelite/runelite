import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class228 {
	static {
		Math.sqrt(8192.0D);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lii;III)Z",
		garbageValue = "-1380695861"
	)
	public static boolean method4199(AbstractArchive var0, int var1, int var2) {
		byte[] var3 = var0.takeFile(var1, var2);
		if (var3 == null) {
			return false;
		} else {
			SpriteMask.SpriteBuffer_decode(var3);
			return true;
		}
	}
}
