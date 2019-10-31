import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("ArchiveDiskActionHandler")
public class ArchiveDiskActionHandler implements Runnable {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("ArchiveDiskActionHandler_requestQueue")
	public static NodeDeque ArchiveDiskActionHandler_requestQueue;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ljb;"
	)
	@Export("ArchiveDiskActionHandler_responseQueue")
	public static NodeDeque ArchiveDiskActionHandler_responseQueue;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -2025054069
	)
	static int field3132;
	@ObfuscatedName("v")
	@Export("ArchiveDiskActionHandler_lock")
	static Object ArchiveDiskActionHandler_lock;
	@ObfuscatedName("l")
	@Export("ArchiveDiskActionHandler_thread")
	static Thread ArchiveDiskActionHandler_thread;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1867272823
	)
	static int field3133;
	@ObfuscatedName("dr")
	@ObfuscatedGetter(
		longValue = -4581696908763214333L
	)
	static long field3130;
	@ObfuscatedName("fk")
	@ObfuscatedSignature(
		signature = "Lks;"
	)
	@Export("fontPlain12")
	static Font fontPlain12;

	static {
		ArchiveDiskActionHandler_requestQueue = new NodeDeque();
		ArchiveDiskActionHandler_responseQueue = new NodeDeque();
		field3132 = 0;
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
						if (field3132 <= 1) {
							field3132 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						field3132 = 600;
					}
				} else {
					ClanChat.method5367(100L);
					synchronized(ArchiveDiskActionHandler_lock) {
						if (field3132 <= 1) {
							field3132 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						--field3132;
					}
				}
			}
		} catch (Exception var13) {
			User.RunException_sendStackTrace((String)null, var13);
		}
	}
}
