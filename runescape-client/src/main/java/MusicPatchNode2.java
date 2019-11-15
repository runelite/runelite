import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("MusicPatchNode2")
public class MusicPatchNode2 {
	@ObfuscatedName("a")
	byte[] field2364;
	@ObfuscatedName("t")
	byte[] field2361;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -269057751
	)
	int field2371;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -390074671
	)
	int field2366;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1385616309
	)
	int field2363;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1962896855
	)
	int field2365;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 353135561
	)
	int field2360;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -538931737
	)
	int field2367;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1418952589
	)
	int field2368;

	MusicPatchNode2() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1508520519"
	)
	static void method3829() {
		class237.field3174 = new int[2000];
		int var0 = 0;
		int var1 = 240;

		int var3;
		for (byte var2 = 12; var0 < 16; var1 -= var2) {
			var3 = WorldMapSprite.method472((double)((float)var1 / 360.0F), 0.9998999834060669D, (double)((float)var0 * 0.425F / 16.0F + 0.075F));
			class237.field3174[var0] = var3;
			++var0;
		}

		var1 = 48;

		for (int var5 = var1 / 6; var0 < class237.field3174.length; var1 -= var5) {
			var3 = var0 * 2;

			for (int var4 = WorldMapSprite.method472((double)((float)var1 / 360.0F), 0.9998999834060669D, 0.5D); var0 < var3 && var0 < class237.field3174.length; ++var0) {
				class237.field3174[var0] = var4;
			}
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhq;I)V",
		garbageValue = "-1954771173"
	)
	public static void method3831(AbstractArchive var0) {
		FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lhq;IIIZI)V",
		garbageValue = "1856110966"
	)
	@Export("playMusicTrack")
	public static void playMusicTrack(AbstractArchive var0, int var1, int var2, int var3, boolean var4) {
		class197.field2377 = 1;
		class247.musicTrackArchive = var0;
		class189.musicTrackGroupId = var1;
		class197.musicTrackFileId = var2;
		class197.musicTrackVolume = var3;
		ScriptFrame.musicTrackBoolean = var4;
		class197.field2384 = 10000;
	}
}
