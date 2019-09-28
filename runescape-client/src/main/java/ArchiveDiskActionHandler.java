import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("ArchiveDiskActionHandler")
public class ArchiveDiskActionHandler implements Runnable {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("ArchiveDiskActionHandler_requestQueue")
	public static NodeDeque ArchiveDiskActionHandler_requestQueue;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ljv;"
	)
	@Export("ArchiveDiskActionHandler_responseQueue")
	public static NodeDeque ArchiveDiskActionHandler_responseQueue;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1320379029
	)
	static int field3127;
	@ObfuscatedName("u")
	@Export("ArchiveDiskActionHandler_lock")
	static Object ArchiveDiskActionHandler_lock;

	static {
		ArchiveDiskActionHandler_requestQueue = new NodeDeque();
		ArchiveDiskActionHandler_responseQueue = new NodeDeque();
		field3127 = 0;
		ArchiveDiskActionHandler_lock = new Object();
	}

	ArchiveDiskActionHandler() {
	}

	public void run() {
		try {
			while (true) {
				ArchiveDiskAction var1;
				synchronized(ArchiveDiskActionHandler_requestQueue) {
					var1 = (ArchiveDiskAction)ArchiveDiskActionHandler_requestQueue.last();
				}

				if (var1 != null) {
					if (var1.type == 0) {
						var1.archiveDisk.write((int)var1.key, var1.data, var1.data.length);
						synchronized(ArchiveDiskActionHandler_requestQueue) {
							var1.remove();
						}
					} else if (var1.type == 1) {
						var1.data = var1.archiveDisk.read((int)var1.key);
						synchronized(ArchiveDiskActionHandler_requestQueue) {
							ArchiveDiskActionHandler_responseQueue.addFirst(var1);
						}
					}

					synchronized(ArchiveDiskActionHandler_lock) {
						if (field3127 <= 1) {
							field3127 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						field3127 = 600;
					}
				} else {
					long var8 = 99L;

					try {
						Thread.sleep(var8);
					} catch (InterruptedException var15) {
					}

					try {
						Thread.sleep(1L);
					} catch (InterruptedException var14) {
					}

					synchronized(ArchiveDiskActionHandler_lock) {
						if (field3127 <= 1) {
							field3127 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						--field3127;
					}
				}
			}
		} catch (Exception var17) {
			class32.RunException_sendStackTrace((String)null, var17);
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZZB)V",
		garbageValue = "10"
	)
	@Export("openURL")
	public static void openURL(String var0, boolean var1, boolean var2) {
		WorldMapID.method568(var0, var1, "openjs", var2);
	}
}
