import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class188 {
	@ObfuscatedName("s")
	static int[] field2326;
	@ObfuscatedName("q")
	static byte[][][] field2321;
	@ObfuscatedName("jy")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("dragInventoryWidget")
	static Widget dragInventoryWidget;

	static {
		new Object();
		field2326 = new int[33];
		field2326[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field2326[var1] = var0 - 1;
			var0 += var0;
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;ZLkb;I)V",
		garbageValue = "639342200"
	)
	public static void method3589(AbstractArchive var0, AbstractArchive var1, boolean var2, Font var3) {
		class65.ItemDefinition_archive = var0;
		Frames.ItemDefinition_modelArchive = var1;
		UrlRequester.ItemDefinition_inMembersWorld = var2;
		MouseRecorder.ItemDefinition_fileCount = class65.ItemDefinition_archive.getGroupFileCount(10);
		ArchiveLoader.ItemDefinition_fontPlain11 = var3;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "0"
	)
	static final boolean method3588() {
		return ViewportMouse.ViewportMouse_isInViewport;
	}
}
