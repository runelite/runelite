import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
@Implements("FloorDecoration")
public final class FloorDecoration {
	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive4")
	static Archive archive4;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -813492053
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -508707057
	)
	@Export("x")
	int x;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1453565009
	)
	@Export("y")
	int y;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		longValue = 5434856025712210831L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1187671267
	)
	@Export("flags")
	int flags;

	FloorDecoration() {
	}
}
