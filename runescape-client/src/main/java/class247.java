import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
public class class247 {
	@ObfuscatedName("qw")
	@ObfuscatedSignature(
		signature = "Ldb;"
	)
	@Export("decimator")
	static Decimator decimator;

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1267026427"
	)
	@Export("WorldMapRegion_clearCachedSprites")
	static void WorldMapRegion_clearCachedSprites() {
		WorldMapRegion.WorldMapRegion_cachedSprites.clear();
	}
}
