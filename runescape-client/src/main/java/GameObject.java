import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("GameObject")
public final class GameObject {
	@ObfuscatedName("sg")
	@ObfuscatedSignature(
		signature = "Lic;"
	)
	public static class237 field1921;
	@ObfuscatedName("dg")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive10")
	static Archive archive10;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 744501361
	)
	@Export("plane")
	int plane;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 2026651009
	)
	@Export("height")
	int height;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -500411517
	)
	@Export("centerX")
	int centerX;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -560576891
	)
	@Export("centerY")
	int centerY;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Len;"
	)
	@Export("entity")
	public Entity entity;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 939156699
	)
	@Export("orientation")
	int orientation;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 86850281
	)
	@Export("startX")
	int startX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -698919929
	)
	@Export("endX")
	int endX;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1676112193
	)
	@Export("startY")
	int startY;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 2114738955
	)
	@Export("endY")
	int endY;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1792624973
	)
	int field1916;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1739525873
	)
	@Export("lastDrawn")
	int lastDrawn;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		longValue = 7927595607641920085L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 692610593
	)
	@Export("flags")
	int flags;

	GameObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZZI)V",
		garbageValue = "-1828723850"
	)
	@Export("openURL")
	public static void openURL(String var0, boolean var1, boolean var2) {
		StudioGame.method4056(var0, var1, "openjs", var2);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-2110373438"
	)
	@Export("ViewportMouse_unpackY")
	public static int ViewportMouse_unpackY(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int)(var2 >>> 7 & 127L);
		return var1;
	}
}
