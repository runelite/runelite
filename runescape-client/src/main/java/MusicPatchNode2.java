import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("MusicPatchNode2")
public class MusicPatchNode2 {
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1235370225
	)
	public static int field2382;
	@ObfuscatedName("z")
	byte[] field2376;
	@ObfuscatedName("n")
	byte[] field2374;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 93349913
	)
	int field2375;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1109994129
	)
	int field2373;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1372771045
	)
	int field2377;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1580268847
	)
	int field2378;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1867393453
	)
	int field2379;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1316855939
	)
	int field2380;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1262915041
	)
	int field2381;

	MusicPatchNode2() {
	}

	@ObfuscatedName("fq")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-521075601"
	)
	@Export("playSong")
	static void playSong(int var0) {
		if (var0 == -1 && !Client.field759) {
			VertexNormal.method2960();
		} else if (var0 != -1 && var0 != Client.field666 && Client.field761 != 0 && !Client.field759) {
			Archive var1 = class225.archive6;
			int var2 = Client.field761;
			class197.field2386 = 1;
			class197.musicTrackArchive = var1;
			class188.musicTrackGroupId = var0;
			class49.musicTrackFileId = 0;
			TileItem.field1223 = var2;
			WorldMapSectionType.musicTrackBoolean = false;
			field2382 = 2;
		}

		Client.field666 = var0;
	}

	@ObfuscatedName("ic")
	@ObfuscatedSignature(
		signature = "(IB)Z",
		garbageValue = "-93"
	)
	static boolean method3658(int var0) {
		for (int var1 = 0; var1 < Client.field857; ++var1) {
			if (Client.field859[var1] == var0) {
				return true;
			}
		}

		return false;
	}
}
