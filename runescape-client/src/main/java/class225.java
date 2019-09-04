import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class225 {
	@ObfuscatedName("t")
	@Export("SpriteBuffer_spriteHeights")
	public static int[] SpriteBuffer_spriteHeights;

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "793886120"
	)
	@Export("getGcDuration")
	protected static int getGcDuration() {
		int var0 = 0;
		if (GrandExchangeEvent.garbageCollector == null || !GrandExchangeEvent.garbageCollector.isValid()) {
			try {
				Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

				while (var1.hasNext()) {
					GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
					if (var2.isValid()) {
						GrandExchangeEvent.garbageCollector = var2;
						GameShell.garbageCollectorLastCheckTimeMs = -1L;
						GameShell.garbageCollectorLastCollectionTime = -1L;
					}
				}
			} catch (Throwable var11) {
			}
		}

		if (GrandExchangeEvent.garbageCollector != null) {
			long var9 = SequenceDefinition.method4686();
			long var3 = GrandExchangeEvent.garbageCollector.getCollectionTime();
			if (GameShell.garbageCollectorLastCollectionTime != -1L) {
				long var5 = var3 - GameShell.garbageCollectorLastCollectionTime;
				long var7 = var9 - GameShell.garbageCollectorLastCheckTimeMs;
				if (var7 != 0L) {
					var0 = (int)(100L * var5 / var7);
				}
			}

			GameShell.garbageCollectorLastCollectionTime = var3;
			GameShell.garbageCollectorLastCheckTimeMs = var9;
		}

		return var0;
	}

	@ObfuscatedName("if")
	@ObfuscatedSignature(
		signature = "(III)Ljava/lang/String;",
		garbageValue = "1269667837"
	)
	@Export("getLevelColorString")
	static final String getLevelColorString(int var0, int var1) {
		int var2 = var1 - var0;
		if (var2 < -9) {
			return class16.colorStartTag(0xff0000);
		} else if (var2 < -6) {
			return class16.colorStartTag(0xff3000);
		} else if (var2 < -3) {
			return class16.colorStartTag(0xff7000);
		} else if (var2 < 0) {
			return class16.colorStartTag(0xffb000);
		} else if (var2 > 9) {
			return class16.colorStartTag(0x00ff00);
		} else if (var2 > 6) {
			return class16.colorStartTag(0x40ff00);
		} else if (var2 > 3) {
			return class16.colorStartTag(0x80ff00);
		} else if (var2 > 0) {
			return class16.colorStartTag(0xc0ff00);
		} else {
			return class16.colorStartTag(0xffff00);
		}
	}
}
