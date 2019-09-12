import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("ScriptFrame")
public class ScriptFrame {
	@ObfuscatedName("hp")
	@ObfuscatedGetter(
		intValue = 583805703
	)
	@Export("cameraX")
	static int cameraX;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lcu;"
	)
	@Export("script")
	Script script;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 669580895
	)
	@Export("pc")
	int pc;
	@ObfuscatedName("t")
	@Export("intLocals")
	int[] intLocals;
	@ObfuscatedName("g")
	@Export("stringLocals")
	String[] stringLocals;

	ScriptFrame() {
		this.pc = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIII)Lli;",
		garbageValue = "-283029695"
	)
	static Sprite method1085(int var0, int var1, int var2) {
		DemotingHashTable var3 = WorldMapRegion.WorldMapRegion_cachedSprites;
		long var4 = (long)(var2 << 16 | var0 << 8 | var1);
		return (Sprite)var3.get(var4);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "46"
	)
	@Export("WorldMapRegion_clearCachedSprites")
	static void WorldMapRegion_clearCachedSprites() {
		WorldMapRegion.WorldMapRegion_cachedSprites.clear();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1564175728"
	)
	public static int method1086(int var0) {
		return var0 >> 17 & 7;
	}
}
