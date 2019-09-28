import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("GameObject")
public final class GameObject {
	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "[Llf;"
	)
	@Export("mapMarkerSprites")
	static Sprite[] mapMarkerSprites;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ler;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 23072497
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1467218039
	)
	@Export("height")
	int height;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1096373851
	)
	@Export("centerX")
	int centerX;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -921514335
	)
	@Export("centerY")
	int centerY;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1901316909
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -714921437
	)
	@Export("startX")
	int startX;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1336647537
	)
	@Export("endX")
	int endX;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1244242871
	)
	@Export("startY")
	int startY;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1759509999
	)
	@Export("endY")
	int endY;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1933245697
	)
	int field1914;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 505349389
	)
	@Export("lastDrawn")
	int lastDrawn;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		longValue = 2276908467403178719L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 8294449
	)
	@Export("flags")
	int flags;

	GameObject() {
		this.tag = 0L;
		this.flags = 0;
	}
}
