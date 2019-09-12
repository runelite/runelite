import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public class class96 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("reflectionChecks")
	public static IterableNodeDeque reflectionChecks;

	static {
		reflectionChecks = new IterableNodeDeque();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I[BLkx;I)V",
		garbageValue = "188105448"
	)
	static void method2259(int var0, byte[] var1, ArchiveDisk var2) {
		ArchiveDiskAction var3 = new ArchiveDiskAction();
		var3.type = 0;
		var3.key = (long)var0;
		var3.data = var1;
		var3.archiveDisk = var2;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
		}

		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3126 == 0) {
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setDaemon(true);
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.start();
				ArchiveDiskActionHandler.ArchiveDiskActionHandler_thread.setPriority(5);
			}

			ArchiveDiskActionHandler.field3126 = 600;
		}
	}

	@ObfuscatedName("ki")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1927050446"
	)
	static void method2258(int var0) {
		Client.oculusOrbState = var0;
	}
}
