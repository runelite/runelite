import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class197 {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("musicPatchesArchive")
	public static AbstractArchive musicPatchesArchive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("musicSamplesArchive")
	public static AbstractArchive musicSamplesArchive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("soundEffectsArchive")
	public static AbstractArchive soundEffectsArchive;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgg;"
	)
	@Export("midiPcmStream")
	public static MidiPcmStream midiPcmStream;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1610594971
	)
	public static int field2377;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 319435127
	)
	@Export("musicTrackFileId")
	public static int musicTrackFileId;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1006961815
	)
	@Export("musicTrackVolume")
	public static int musicTrackVolume;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1415687209
	)
	public static int field2384;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	@Export("musicTrack")
	public static MusicTrack musicTrack;

	static {
		field2377 = 0;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhq;Lhq;Lhq;I)V",
		garbageValue = "1749712810"
	)
	public static void method3845(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
		SequenceDefinition.SequenceDefinition_archive = var0;
		DevicePcmPlayerProvider.SequenceDefinition_animationsArchive = var1;
		SequenceDefinition.SequenceDefinition_skeletonsArchive = var2;
	}

	@ObfuscatedName("lr")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-224459169"
	)
	static void method3844(int var0) {
		for (IntegerNode var1 = (IntegerNode)Client.widgetClickMasks.first(); var1 != null; var1 = (IntegerNode)Client.widgetClickMasks.next()) {
			if ((long)var0 == (var1.key >> 48 & 65535L)) {
				var1.remove();
			}
		}

	}
}
