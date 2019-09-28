import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("TileItemPile")
public final class TileItemPile {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ler;"
	)
	@Export("first")
	Entity first;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -149113077
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 905063527
	)
	@Export("x")
	int x;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1956463223
	)
	@Export("y")
	int y;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Ler;"
	)
	@Export("second")
	Entity second;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Ler;"
	)
	@Export("third")
	Entity third;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		longValue = 3581588196263566823L
	)
	@Export("tag")
	long tag;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 814116925
	)
	@Export("height")
	int height;

	TileItemPile() {
	}
}
