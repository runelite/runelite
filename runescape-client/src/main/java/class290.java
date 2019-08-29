import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
public final class class290 {
	@ObfuscatedName("k")
	@Export("JagexCache_locationFile")
	static File JagexCache_locationFile;

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lhz;II)Z",
		garbageValue = "-691629841"
	)
	@Export("SpriteBuffer_bufferFileFlat")
	public static boolean SpriteBuffer_bufferFileFlat(AbstractArchive var0, int var1) {
		byte[] var2 = var0.takeFileFlat(var1);
		if (var2 == null) {
			return false;
		} else {
			Player.SpriteBuffer_decode(var2);
			return true;
		}
	}
}
