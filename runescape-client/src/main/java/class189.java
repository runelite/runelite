import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class189 {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("HitSplatDefinition_fontsArchive")
	static AbstractArchive HitSplatDefinition_fontsArchive;

	@ObfuscatedName("eb")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1691938154"
	)
	static int method3626() {
		if (Client.archiveLoaders != null && Client.archiveLoaderArchive < Client.archiveLoaders.size()) {
			int var0 = 0;

			for (int var1 = 0; var1 <= Client.archiveLoaderArchive; ++var1) {
				var0 += ((ArchiveLoader)Client.archiveLoaders.get(var1)).loadedCount;
			}

			return var0 * 10000 / Client.field895;
		} else {
			return 10000;
		}
	}
}
