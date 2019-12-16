import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("TileItemPile")
public final class TileItemPile {
	@ObfuscatedName("so")
	@ObfuscatedGetter(
		longValue = 3482799438459679755L
	)
	static long field1522;
	@ObfuscatedName("cn")
	public static char field1521;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 2053459421
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 972029952
	)
	@Export("x")
	int x;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1850274101
	)
	@Export("y")
	int y;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("first")
	Entity first;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("second")
	Entity second;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lep;"
	)
	@Export("third")
	Entity third;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		longValue = 6402708744668809381L
	)
	@Export("tag")
	long tag;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 790929517
	)
	@Export("height")
	int height;

	TileItemPile() {
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2014741616"
	)
	static final int method2797() {
		return ViewportMouse.ViewportMouse_y;
	}
}
