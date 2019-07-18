import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("ArchiveDiskActionHandler")
public class ArchiveDiskActionHandler implements Runnable {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("ArchiveDiskActionHandler_requestQueue")
	public static NodeDeque ArchiveDiskActionHandler_requestQueue;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("ArchiveDiskActionHandler_responseQueue")
	public static NodeDeque ArchiveDiskActionHandler_responseQueue;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1331634311
	)
	static int field3144;
	@ObfuscatedName("p")
	@Export("ArchiveDiskActionHandler_lock")
	static Object ArchiveDiskActionHandler_lock;
	@ObfuscatedName("k")
	@Export("ArchiveDiskActionHandler_thread")
	static Thread ArchiveDiskActionHandler_thread;

	static {
		ArchiveDiskActionHandler_requestQueue = new NodeDeque();
		ArchiveDiskActionHandler_responseQueue = new NodeDeque();
		field3144 = 0;
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
						if (field3144 <= 1) {
							field3144 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						field3144 = 600;
					}
				} else {
					EnumDefinition.method4550(100L);
					synchronized(ArchiveDiskActionHandler_lock) {
						if (field3144 <= 1) {
							field3144 = 0;
							ArchiveDiskActionHandler_lock.notifyAll();
							return;
						}

						--field3144;
					}
				}
			}
		} catch (Exception var13) {
			HitSplatDefinition.sendStackTrace((String)null, var13);
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		signature = "(Lfs;III)Ldn;",
		garbageValue = "2015059645"
	)
	public static final PcmPlayer method4256(TaskHandler var0, int var1, int var2) {
		if (CollisionMap.PcmPlayer_sampleRate == 0) {
			throw new IllegalStateException();
		} else if (var1 >= 0 && var1 < 2) {
			if (var2 < 256) {
				var2 = 256;
			}

			try {
				PcmPlayer var3 = class32.pcmPlayerProvider.player();
				var3.samples = new int[256 * (class169.isStereo ? 2 : 1)];
				var3.field1414 = var2;
				var3.init();
				var3.capacity = (var2 & -1024) + 1024;
				if (var3.capacity > 16384) {
					var3.capacity = 16384;
				}

				var3.open(var3.capacity);
				if (PcmPlayer.pcmPlayerCount > 0 && SecureRandomFuture.soundSystem == null) {
					SecureRandomFuture.soundSystem = new SoundSystem();
					class14.soundSystemExecutor = Executors.newScheduledThreadPool(1);
					class14.soundSystemExecutor.scheduleAtFixedRate(SecureRandomFuture.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
				}

				if (SecureRandomFuture.soundSystem != null) {
					if (SecureRandomFuture.soundSystem.players[var1] != null) {
						throw new IllegalArgumentException();
					}

					SecureRandomFuture.soundSystem.players[var1] = var3;
				}

				return var3;
			} catch (Throwable var4) {
				return new PcmPlayer();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
}
