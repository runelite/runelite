import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("ArchiveLoader")
public class ArchiveLoader {
	@ObfuscatedName("c")
	@Export("Tiles_saturation")
	static int[] Tiles_saturation;
	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "[Llf;"
	)
	@Export("worldSelectBackSprites")
	static Sprite[] worldSelectBackSprites;
	@ObfuscatedName("gi")
	@Export("regionMapArchives")
	static byte[][] regionMapArchives;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive")
	final Archive archive;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1526719037
	)
	@Export("groupCount")
	final int groupCount;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 966789861
	)
	@Export("loadedCount")
	int loadedCount;

	@ObfuscatedSignature(
		signature = "(Lie;Ljava/lang/String;)V"
	)
	ArchiveLoader(Archive var1, String var2) {
		this.loadedCount = 0;
		this.archive = var1;
		this.groupCount = var1.getGroupCount();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1969120013"
	)
	@Export("isLoaded")
	boolean isLoaded() {
		this.loadedCount = 0;

		for (int var1 = 0; var1 < this.groupCount; ++var1) {
			if (!this.archive.method4244(var1) || this.archive.method4243(var1)) {
				++this.loadedCount;
			}
		}

		return this.loadedCount >= this.groupCount;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-238840199"
	)
	public static int method1173(int var0) {
		return class32.method578(ViewportMouse.ViewportMouse_entityTags[var0]);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lbo;Lbo;IZIZB)I",
		garbageValue = "7"
	)
	static int method1174(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
		int var6 = UserComparator7.compareWorlds(var0, var1, var2, var3);
		if (var6 != 0) {
			return var3 ? -var6 : var6;
		} else if (var4 == -1) {
			return 0;
		} else {
			int var7 = UserComparator7.compareWorlds(var0, var1, var4, var5);
			return var5 ? -var7 : var7;
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([BIIB)Ljava/lang/String;",
		garbageValue = "-113"
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
}
