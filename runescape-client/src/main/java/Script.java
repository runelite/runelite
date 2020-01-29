import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Script")
public class Script extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Leh;"
	)
	@Export("Script_cached")
	static EvictingDualNodeHashTable Script_cached;
	@ObfuscatedName("t")
	@Export("opcodes")
	int[] opcodes;
	@ObfuscatedName("o")
	@Export("intOperands")
	int[] intOperands;
	@ObfuscatedName("e")
	@Export("stringOperands")
	String[] stringOperands;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1871581323
	)
	@Export("localIntCount")
	int localIntCount;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 822375411
	)
	@Export("localStringCount")
	int localStringCount;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1252836573
	)
	@Export("intArgumentCount")
	int intArgumentCount;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1735199639
	)
	@Export("stringArgumentCount")
	int stringArgumentCount;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "[Llp;"
	)
	@Export("switches")
	IterableNodeHashTable[] switches;

	static {
		Script_cached = new EvictingDualNodeHashTable(128);
	}

	Script() {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IB)[Llp;",
		garbageValue = "1"
	)
	@Export("newIterableNodeHashTable")
	IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
		return new IterableNodeHashTable[var1];
	}

	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		signature = "(IIIILlt;Lhf;I)V",
		garbageValue = "631816704"
	)
	@Export("drawSpriteOnMinimap")
	static final void drawSpriteOnMinimap(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
		if (var4 != null) {
			int var6 = Client.camAngleY & 2047;
			int var7 = var3 * var3 + var2 * var2;
			if (var7 <= 6400) {
				int var8 = Rasterizer3D.Rasterizer3D_sine[var6];
				int var9 = Rasterizer3D.Rasterizer3D_cosine[var6];
				int var10 = var3 * var8 + var9 * var2 >> 16;
				int var11 = var3 * var9 - var8 * var2 >> 16;
				if (var7 > 2500) {
					var4.method6207(var10 + var5.width / 2 - var4.width / 2, var5.height / 2 - var11 - var4.height / 2, var0, var1, var5.width, var5.height, var5.xStarts, var5.xWidths);
				} else {
					var4.drawTransBgAt(var0 + var10 + var5.width / 2 - var4.width / 2, var5.height / 2 + var1 - var11 - var4.height / 2);
				}

			}
		}
	}
}
