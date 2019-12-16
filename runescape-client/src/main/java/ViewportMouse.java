import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
@Implements("ViewportMouse")
public class ViewportMouse {
	@ObfuscatedName("f")
	@Export("ViewportMouse_isInViewport")
	public static boolean ViewportMouse_isInViewport;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -52069035
	)
	@Export("ViewportMouse_x")
	public static int ViewportMouse_x;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -819033673
	)
	@Export("ViewportMouse_y")
	public static int ViewportMouse_y;
	@ObfuscatedName("w")
	@Export("ViewportMouse_false0")
	public static boolean ViewportMouse_false0;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 945572255
	)
	static int field1717;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -45541993
	)
	static int field1718;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1585979181
	)
	static int field1719;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1002877627
	)
	static int field1720;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1949057711
	)
	@Export("ViewportMouse_entityCount")
	public static int ViewportMouse_entityCount;
	@ObfuscatedName("s")
	@Export("ViewportMouse_entityTags")
	public static long[] ViewportMouse_entityTags;
	@ObfuscatedName("hb")
	@ObfuscatedGetter(
		intValue = -1167251555
	)
	@Export("cameraPitch")
	static int cameraPitch;

	static {
		ViewportMouse_isInViewport = false;
		ViewportMouse_x = 0;
		ViewportMouse_y = 0;
		ViewportMouse_false0 = false;
		ViewportMouse_entityCount = 0;
		ViewportMouse_entityTags = new long[1000];
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1626465516"
	)
	public static int method2993(int var0) {
		if (var0 > 0) {
			return 1;
		} else {
			return var0 < 0 ? -1 : 0;
		}
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)I",
		garbageValue = "-8"
	)
	@Export("stringCp1252NullTerminatedByteSize")
	public static int stringCp1252NullTerminatedByteSize(String var0) {
		return var0.length() + 1;
	}
}
