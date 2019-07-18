import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class186 {
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Ljava/io/File;ZS)Z",
		garbageValue = "25650"
	)
	static boolean method3618(File var0, boolean var1) {
		try {
			RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
			int var3 = var2.read();
			var2.seek(0L);
			var2.write(var3);
			var2.seek(0L);
			var2.close();
			if (var1) {
				var0.delete();
			}

			return true;
		} catch (Exception var4) {
			return false;
		}
	}

	@ObfuscatedName("fz")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "33"
	)
	@Export("playPcmPlayers")
	static final void playPcmPlayers() {
		if (class190.pcmPlayer1 != null) {
			class190.pcmPlayer1.run();
		}

		if (class80.pcmPlayer0 != null) {
			class80.pcmPlayer0.run();
		}

	}
}
