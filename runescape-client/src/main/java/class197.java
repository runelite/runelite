import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class197 {
	@ObfuscatedName("ok")
	@ObfuscatedSignature(
		signature = "Lct;"
	)
	@Export("varcs")
	static Varcs varcs;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("musicPatchesArchive")
	public static AbstractArchive musicPatchesArchive;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("soundEffectsArchive")
	public static AbstractArchive soundEffectsArchive;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1857449183
	)
	public static int field2386;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("musicTrackArchive")
	public static AbstractArchive musicTrackArchive;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	@Export("musicTrack")
	public static MusicTrack musicTrack;
	@ObfuscatedName("ba")
	static String field2390;
	@ObfuscatedName("gw")
	@Export("regionMapArchiveIds")
	static int[] regionMapArchiveIds;

	static {
		field2386 = 0;
	}
}
