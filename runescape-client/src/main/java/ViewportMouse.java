import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
@Implements("ViewportMouse")
public class ViewportMouse {
	@ObfuscatedName("s")
	@Export("ViewportMouse_isInViewport")
	public static boolean ViewportMouse_isInViewport;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1673614765
	)
	@Export("ViewportMouse_x")
	static int ViewportMouse_x;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 97939103
	)
	@Export("ViewportMouse_y")
	static int ViewportMouse_y;
	@ObfuscatedName("k")
	@Export("ViewportMouse_false0")
	static boolean ViewportMouse_false0;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 214371075
	)
	static int field1723;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -228881629
	)
	static int field1724;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1565231911
	)
	static int field1725;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -942869669
	)
	static int field1726;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 155548297
	)
	static int field1727;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1633088205
	)
	@Export("ViewportMouse_entityCount")
	public static int ViewportMouse_entityCount;
	@ObfuscatedName("p")
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

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "([BI)Ljava/lang/String;",
		garbageValue = "1521597342"
	)
	public static String method2902(byte[] var0) {
		return WorldMapSection0.method211(var0, 0, var0.length);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(II)Lii;",
		garbageValue = "-1840851483"
	)
	@Export("getNpcDefinition")
	public static NPCDefinition getNpcDefinition(int var0) {
		NPCDefinition var1 = (NPCDefinition)NPCDefinition.NpcDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = NPCDefinition.NpcDefinition_archive.takeFile(9, var0);
			var1 = new NPCDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			NPCDefinition.NpcDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "([BIII)Ljava/lang/String;",
		garbageValue = "810099755"
	)
	@Export("decodeStringCp1252")
	public static String decodeStringCp1252(byte[] var0, int var1, int var2) {
		char[] var3 = new char[var2];
		int var4 = 0;

		for (int var5 = 0; var5 < var2; ++var5) {
			int var6 = var0[var5 + var1] & 255;
			if (var6 != 0) {
				if (var6 >= 128 && var6 < 160) {
					char var7 = class287.cp1252AsciiExtension[var6 - 128];
					if (var7 == 0) {
						var7 = '?';
					}

					var6 = var7;
				}

				var3[var4++] = (char)var6;
			}
		}

		return new String(var3, 0, var4);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lct;B)V",
		garbageValue = "16"
	)
	public static final void method2891(PcmPlayerProvider var0) {
		SecureRandomCallable.pcmPlayerProvider = var0;
	}
}
