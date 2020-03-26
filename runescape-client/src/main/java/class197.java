import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
public class class197 {
	@ObfuscatedName("x")
	static int[] field2350;
	@ObfuscatedName("w")
	@Export("ArchiveDiskActionHandler_thread")
	static Thread ArchiveDiskActionHandler_thread;

	static {
		new Object();
		field2350 = new int[33];
		field2350[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field2350[var1] = var0 - 1;
			var0 += var0;
		}

	}
}
