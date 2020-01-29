import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("BoundaryObject")
public final class BoundaryObject {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -432640287
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -970419585
	)
	@Export("x")
	int x;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1222089633
	)
	@Export("y")
	int y;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 778552875
	)
	@Export("orientationA")
	int orientationA;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -829648765
	)
	@Export("orientationB")
	int orientationB;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Leq;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Leq;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		longValue = 515248560912133581L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1262947559
	)
	@Export("flags")
	int flags;

	BoundaryObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2085601803"
	)
	public static void method3333() {
		synchronized(KeyHandler.KeyHandler_instance) {
			++KeyHandler.KeyHandler_idleCycles;
			KeyHandler.field406 = KeyHandler.field408;
			KeyHandler.field405 = 0;
			int var1;
			if (KeyHandler.field387 < 0) {
				for (var1 = 0; var1 < 112; ++var1) {
					KeyHandler.KeyHandler_pressedKeys[var1] = false;
				}

				KeyHandler.field387 = KeyHandler.field400;
			} else {
				while (KeyHandler.field387 != KeyHandler.field400) {
					var1 = KeyHandler.field399[KeyHandler.field400];
					KeyHandler.field400 = KeyHandler.field400 + 1 & 127;
					if (var1 < 0) {
						KeyHandler.KeyHandler_pressedKeys[~var1] = false;
					} else {
						if (!KeyHandler.KeyHandler_pressedKeys[var1] && KeyHandler.field405 < KeyHandler.field404.length - 1) {
							KeyHandler.field404[++KeyHandler.field405 - 1] = var1;
						}

						KeyHandler.KeyHandler_pressedKeys[var1] = true;
					}
				}
			}

			if (KeyHandler.field405 > 0) {
				KeyHandler.KeyHandler_idleCycles = 0;
			}

			KeyHandler.field408 = KeyHandler.field407;
		}
	}
}
