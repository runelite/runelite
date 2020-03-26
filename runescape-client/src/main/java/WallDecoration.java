import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("WallDecoration")
public final class WallDecoration {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1214014955
	)
	@Export("y")
	int y;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -166681381
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1454515853
	)
	@Export("x")
	int x;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -985506123
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 817578233
	)
	@Export("orientation2")
	int orientation2;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1515780955
	)
	@Export("xOffset")
	int xOffset;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -102361683
	)
	@Export("yOffset")
	int yOffset;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lee;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		longValue = -7258048285485333861L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1418566089
	)
	@Export("flags")
	int flags;

	WallDecoration() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I[BLlq;S)V",
		garbageValue = "4729"
	)
	static void method3402(int var0, byte[] var1, ArchiveDisk var2) {
		ArchiveDiskAction var3 = new ArchiveDiskAction();
		var3.type = 0;
		var3.key = (long)var0;
		var3.data = var1;
		var3.archiveDisk = var2;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
		}

		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3151 == 0) {
				class197.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
				class197.ArchiveDiskActionHandler_thread.setDaemon(true);
				class197.ArchiveDiskActionHandler_thread.start();
				class197.ArchiveDiskActionHandler_thread.setPriority(5);
			}

			ArchiveDiskActionHandler.field3151 = 600;
		}
	}

	@ObfuscatedName("iw")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lhe;I)Ljava/lang/String;",
		garbageValue = "-748115662"
	)
	static String method3403(String var0, Widget var1) {
		if (var0.indexOf("%") != -1) {
			for (int var2 = 1; var2 <= 5; ++var2) {
				while (true) {
					int var3 = var0.indexOf("%" + var2);
					if (var3 == -1) {
						break;
					}

					String var4 = var0.substring(0, var3);
					int var6 = Tiles.method1227(var1, var2 - 1);
					String var5;
					if (var6 < 999999999) {
						var5 = Integer.toString(var6);
					} else {
						var5 = "*";
					}

					var0 = var4 + var5 + var0.substring(var3 + 2);
				}
			}
		}

		return var0;
	}
}
