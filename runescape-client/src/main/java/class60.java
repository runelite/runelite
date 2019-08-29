import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class60 {
	@ObfuscatedName("ng")
	@ObfuscatedGetter(
		intValue = -2116581745
	)
	@Export("widgetDragDuration")
	static int widgetDragDuration;
	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "Lgk;"
	)
	@Export("clientLanguage")
	static Language clientLanguage;

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(IB)[B",
		garbageValue = "73"
	)
	@Export("ByteArrayPool_getArray")
	public static synchronized byte[] ByteArrayPool_getArray(int var0) {
		return ByteArrayPool.ByteArrayPool_getArrayBool(var0, false);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2044529336"
	)
	public static void method1122() {
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3124 != 0) {
				ArchiveDiskActionHandler.field3124 = 1;

				try {
					ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
				} catch (InterruptedException var3) {
				}
			}

		}
	}
}
