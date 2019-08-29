import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class197 {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("musicPatchesArchive")
	public static AbstractArchive musicPatchesArchive;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("musicSamplesArchive")
	public static AbstractArchive musicSamplesArchive;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("soundEffectsArchive")
	public static AbstractArchive soundEffectsArchive;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgp;"
	)
	@Export("midiPcmStream")
	public static MidiPcmStream midiPcmStream;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1319916027
	)
	public static int field2378;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -2004813651
	)
	@Export("musicTrackGroupId")
	public static int musicTrackGroupId;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1949584783
	)
	@Export("musicTrackFileId")
	public static int musicTrackFileId;
	@ObfuscatedName("ea")
	@ObfuscatedSignature(
		signature = "Lkp;"
	)
	@Export("spriteIds")
	static GraphicsDefaults spriteIds;

	static {
		field2378 = 0;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "2056468523"
	)
	static final int method3645(int var0, int var1) {
		if (var0 == -1) {
			return 12345678;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}
}
