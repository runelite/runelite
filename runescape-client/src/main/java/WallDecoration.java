import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("WallDecoration")
public final class WallDecoration {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1682517589
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 835715707
	)
	@Export("x")
	int x;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 196779483
	)
	@Export("y")
	int y;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1668025043
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -36455913
	)
	@Export("orientation2")
	int orientation2;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1853023359
	)
	@Export("xOffset")
	int xOffset;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1490962747
	)
	@Export("yOffset")
	int yOffset;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		longValue = 7500452750327667815L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -265932947
	)
	@Export("flags")
	int flags;

	WallDecoration() {
		this.tag = 0L;
		this.flags = 0;
	}
}
