import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("ViewportMouse")
public class ViewportMouse {
	@ObfuscatedName("u")
	@Export("ViewportMouse_isInViewport")
	static boolean ViewportMouse_isInViewport;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 2136731005
	)
	@Export("ViewportMouse_x")
	static int ViewportMouse_x;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1807081523
	)
	@Export("ViewportMouse_y")
	static int ViewportMouse_y;
	@ObfuscatedName("g")
	@Export("ViewportMouse_false0")
	static boolean ViewportMouse_false0;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 998794847
	)
	static int field1737;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 529684695
	)
	static int field1739;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 421048203
	)
	@Export("ViewportMouse_entityCount")
	public static int ViewportMouse_entityCount;
	@ObfuscatedName("n")
	@Export("ViewportMouse_entityTags")
	public static long[] ViewportMouse_entityTags;

	static {
		ViewportMouse_isInViewport = false;
		ViewportMouse_x = 0;
		ViewportMouse_y = 0;
		ViewportMouse_false0 = false;
		ViewportMouse_entityCount = 0;
		ViewportMouse_entityTags = new long[1000];
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(ZZI)I",
		garbageValue = "-1821844574"
	)
	public static int method3015(boolean var0, boolean var1) {
		byte var2 = 0;
		int var3 = var2 + NetCache.NetCache_pendingPriorityResponsesCount + NetCache.NetCache_pendingPriorityWritesCount;
		return var3;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-950495199"
	)
	public static void method3012() {
		StructDefinition.StructDefinition_cached.clear();
	}
}
