import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class188 {
	@ObfuscatedName("rg")
	@ObfuscatedGetter(
		intValue = -1778980480
	)
	static int field2346;
	@ObfuscatedName("c")
	static int[] field2344;

	static {
		new Object();
		field2344 = new int[33];
		field2344[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field2344[var1] = var0 - 1;
			var0 += var0;
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "568041026"
	)
	static void method3708() {
		for (ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var0.obj != null) {
				var0.set();
			}
		}

	}
}
