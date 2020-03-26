import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class206 {
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("musicSamplesArchive")
	public static AbstractArchive musicSamplesArchive;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("soundEffectsArchive")
	public static AbstractArchive soundEffectsArchive;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgi;"
	)
	@Export("midiPcmStream")
	public static MidiPcmStream midiPcmStream;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -972786961
	)
	public static int field2406;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Liy;"
	)
	@Export("musicTrackArchive")
	public static AbstractArchive musicTrackArchive;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 11413497
	)
	@Export("musicTrackGroupId")
	public static int musicTrackGroupId;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1578862753
	)
	@Export("musicTrackFileId")
	public static int musicTrackFileId;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhh;"
	)
	@Export("musicTrack")
	public static MusicTrack musicTrack;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "Llj;"
	)
	@Export("rasterProvider")
	public static AbstractRasterProvider rasterProvider;

	static {
		field2406 = 0;
	}
}
