import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("SoundSystem")
public class SoundSystem implements Runnable {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "[Ldn;"
	)
	@Export("players")
	volatile PcmPlayer[] players;

	SoundSystem() {
		this.players = new PcmPlayer[2];
	}

	public void run() {
		try {
			for (int var1 = 0; var1 < 2; ++var1) {
				PcmPlayer var2 = this.players[var1];
				if (var2 != null) {
					var2.run();
				}
			}
		} catch (Exception var4) {
			HitSplatDefinition.sendStackTrace((String)null, var4);
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([Lgo;IB)Lgo;",
		garbageValue = "0"
	)
	@Export("findEnumerated")
	public static Enumerated findEnumerated(Enumerated[] var0, int var1) {
		Enumerated[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			Enumerated var4 = var2[var3];
			if (var1 == var4.rsOrdinal()) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "([BB)V",
		garbageValue = "103"
	)
	public static synchronized void method2478(byte[] var0) {
		if (var0.length == 100 && ByteArrayPool.ByteArrayPool_smallCount < 1000) {
			ByteArrayPool.ByteArrayPool_small[++ByteArrayPool.ByteArrayPool_smallCount - 1] = var0;
		} else if (var0.length == 5000 && ByteArrayPool.ByteArrayPool_mediumCount < 250) {
			ByteArrayPool.ByteArrayPool_medium[++ByteArrayPool.ByteArrayPool_mediumCount - 1] = var0;
		} else if (var0.length == 30000 && ByteArrayPool.ByteArrayPool_largeCount < 50) {
			ByteArrayPool.ByteArrayPool_large[++ByteArrayPool.ByteArrayPool_largeCount - 1] = var0;
		} else {
			if (class189.ByteArrayPool_arrays != null) {
				for (int var1 = 0; var1 < ByteArrayPool.ByteArrayPool_alternativeSizes.length; ++var1) {
					if (var0.length == ByteArrayPool.ByteArrayPool_alternativeSizes[var1] && class43.ByteArrayPool_altSizeArrayCounts[var1] < class189.ByteArrayPool_arrays[var1].length) {
						class189.ByteArrayPool_arrays[var1][class43.ByteArrayPool_altSizeArrayCounts[var1]++] = var0;
						return;
					}
				}
			}

		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-925078025"
	)
	protected static int method2479() {
		int var0 = 0;
		if (class43.garbageCollector == null || !class43.garbageCollector.isValid()) {
			try {
				Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

				while (var1.hasNext()) {
					GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
					if (var2.isValid()) {
						class43.garbageCollector = var2;
						GameShell.garbageCollectorLastCheckTimeMs = -1L;
						GameShell.garbageCollectorLastCollectionTime = -1L;
					}
				}
			} catch (Throwable var11) {
			}
		}

		if (class43.garbageCollector != null) {
			long var9 = DirectByteArrayCopier.currentTimeMs();
			long var3 = class43.garbageCollector.getCollectionTime();
			if (-1L != GameShell.garbageCollectorLastCollectionTime) {
				long var5 = var3 - GameShell.garbageCollectorLastCollectionTime;
				long var7 = var9 - GameShell.garbageCollectorLastCheckTimeMs;
				if (0L != var7) {
					var0 = (int)(100L * var5 / var7);
				}
			}

			GameShell.garbageCollectorLastCollectionTime = var3;
			GameShell.garbageCollectorLastCheckTimeMs = var9;
		}

		return var0;
	}
}
