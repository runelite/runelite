import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Script")
public class Script extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("Script_cached")
	static EvictingDualNodeHashTable Script_cached;
	@ObfuscatedName("x")
	@Export("opcodes")
	int[] opcodes;
	@ObfuscatedName("t")
	@Export("intOperands")
	int[] intOperands;
	@ObfuscatedName("g")
	@Export("stringOperands")
	String[] stringOperands;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1662651269
	)
	@Export("localIntCount")
	int localIntCount;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 925895493
	)
	@Export("localStringCount")
	int localStringCount;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1615704029
	)
	@Export("intArgumentCount")
	int intArgumentCount;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1886789561
	)
	@Export("stringArgumentCount")
	int stringArgumentCount;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "[Llj;"
	)
	@Export("switches")
	IterableNodeHashTable[] switches;

	static {
		Script_cached = new EvictingDualNodeHashTable(128);
	}

	Script() {
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IB)[Llj;",
		garbageValue = "58"
	)
	@Export("newIterableNodeHashTable")
	IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
		return new IterableNodeHashTable[var1];
	}

	@ObfuscatedName("gu")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-4"
	)
	static final void method2201() {
		for (GraphicsObject var0 = (GraphicsObject)Client.graphicsObjects.last(); var0 != null; var0 = (GraphicsObject)Client.graphicsObjects.previous()) {
			if (var0.plane == MouseRecorder.plane && !var0.isFinished) {
				if (Client.cycle >= var0.cycleStart) {
					var0.advance(Client.field683);
					if (var0.isFinished) {
						var0.remove();
					} else {
						WorldMapIcon_1.scene.drawEntity(var0.plane, var0.x, var0.y, var0.height, 60, var0, 0, -1L, false);
					}
				}
			} else {
				var0.remove();
			}
		}

	}
}
