import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class14 {
	@ObfuscatedName("qn")
	@ObfuscatedGetter(
		intValue = 1643724800
	)
	static int field88;
	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("headIconHintSprites")
	static Sprite[] headIconHintSprites;

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1580849456"
	)
	static void method204() {
		try {
			File var0 = new File(class30.userHomeDirectory, "random.dat");
			int var2;
			if (var0.exists()) {
				JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
			} else {
				label39:
				for (int var1 = 0; var1 < class312.field3803.length; ++var1) {
					for (var2 = 0; var2 < BoundaryObject.field1859.length; ++var2) {
						File var3 = new File(BoundaryObject.field1859[var2] + class312.field3803[var1] + File.separatorChar + "random.dat");
						if (var3.exists()) {
							JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var3, "rw", 25L), 24, 0);
							break label39;
						}
					}
				}
			}

			if (JagexCache.JagexCache_randomDat == null) {
				RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
				var2 = var4.read();
				var4.seek(0L);
				var4.write(var2);
				var4.seek(0L);
				var4.close();
				JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
			}
		} catch (IOException var5) {
		}

	}

	@ObfuscatedName("fw")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "363418967"
	)
	static int method203() {
		if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
			int var0 = 0;

			for (int var1 = 0; var1 <= Client.archiveLoadersDone; ++var1) {
				var0 += ((ArchiveLoader)Client.archiveLoaders.get(var1)).loadedCount;
			}

			return var0 * 10000 / Client.field903;
		} else {
			return 10000;
		}
	}
}
