import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("GameObject")
public final class GameObject {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1570301061
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1372995053
	)
	@Export("height")
	int height;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 3597047
	)
	@Export("centerX")
	int centerX;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1286023919
	)
	@Export("centerY")
	int centerY;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Leo;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1679497939
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 2072838249
	)
	@Export("startX")
	int startX;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1679068867
	)
	@Export("endX")
	int endX;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1593954751
	)
	@Export("startY")
	int startY;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 614764075
	)
	@Export("endY")
	int endY;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -2081842773
	)
	int field1939;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1806951057
	)
	@Export("lastDrawn")
	int lastDrawn;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		longValue = -3308425322664563893L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -320745509
	)
	@Export("flags")
	int flags;

	GameObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;III)Lke;",
		garbageValue = "-1252480817"
	)
	@Export("loadFont")
	public static Font loadFont(AbstractArchive var0, AbstractArchive var1, int var2, int var3) {
		return !Friend.doesSpriteExist(var0, var2, var3) ? null : WallDecoration.getWorldMapSprite(var1.takeFile(var2, var3));
	}
}
