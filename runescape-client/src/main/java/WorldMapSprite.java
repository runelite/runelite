import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
@Implements("WorldMapSprite")
public final class WorldMapSprite {
	@ObfuscatedName("rc")
	@ObfuscatedGetter(
		intValue = -936631043
	)
	static int field240;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("options_buttons_0Sprite")
	static IndexedSprite options_buttons_0Sprite;
	@ObfuscatedName("t")
	@Export("tileColors")
	final int[] tileColors;

	WorldMapSprite() {
		this.tileColors = new int[4096];
	}

	WorldMapSprite(int[] var1) {
		this.tileColors = var1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "35"
	)
	@Export("getTileColor")
	final int getTileColor(int var1, int var2) {
		return this.tileColors[var1 + var2 * 64];
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkp;IS)V",
		garbageValue = "-20256"
	)
	public static void method427(Buffer var0, int var1) {
		if (JagexCache.JagexCache_randomDat != null) {
			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.write(var0.array, var1, 24);
			} catch (Exception var3) {
			}
		}

	}

	@ObfuscatedName("gb")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "96"
	)
	static final void method434() {
		for (int var0 = 0; var0 < Client.npcCount; ++var0) {
			int var1 = Client.npcIndices[var0];
			NPC var2 = Client.npcs[var1];
			if (var2 != null) {
				ScriptFrame.updateActorSequence(var2, var2.definition.size);
			}
		}

	}
}
