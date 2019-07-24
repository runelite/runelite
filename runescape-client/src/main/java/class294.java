import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kz")
public class class294 {
	@ObfuscatedName("bb")
	static String field3695;
	@ObfuscatedName("jp")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	static Widget field3697;

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I[BLkm;I)V",
		garbageValue = "-966151502"
	)
	static void method5328(int var0, byte[] var1, ArchiveDisk var2) {
		ArchiveDiskAction var3 = new ArchiveDiskAction();
		var3.type = 0;
		var3.key = (long)var0;
		var3.data = var1;
		var3.archiveDisk = var2;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
		}

		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3144 == 0) {
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setDaemon(true);
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.start();
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setPriority(5);
			}

			ArchiveDiskActionHandler.field3144 = 600;
		}
	}

	@ObfuscatedName("gy")
	@ObfuscatedSignature(
		signature = "(Lbt;I)V",
		garbageValue = "-938277055"
	)
	static final void method5327(PendingSpawn var0) {
		long var1 = 0L;
		int var3 = -1;
		int var4 = 0;
		int var5 = 0;
		if (var0.type == 0) {
			var1 = GrandExchangeOfferWorldComparator.scene.getBoundaryObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 1) {
			var1 = GrandExchangeOfferWorldComparator.scene.getWallDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 2) {
			var1 = GrandExchangeOfferWorldComparator.scene.getGameObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 3) {
			var1 = GrandExchangeOfferWorldComparator.scene.getFloorDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (0L != var1) {
			int var6 = GrandExchangeOfferWorldComparator.scene.getObjectFlags(var0.plane, var0.x, var0.y, var1);
			var3 = class43.method770(var1);
			var4 = var6 & 31;
			var5 = var6 >> 6 & 3;
		}

		var0.field935 = var3;
		var0.field933 = var4;
		var0.field936 = var5;
	}
}
