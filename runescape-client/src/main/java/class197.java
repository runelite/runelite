import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class197 {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("musicPatchesArchive")
	public static AbstractArchive musicPatchesArchive;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("musicSamplesArchive")
	public static AbstractArchive musicSamplesArchive;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("soundEffectsArchive")
	public static AbstractArchive soundEffectsArchive;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -680038187
	)
	public static int field2392;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1263500685
	)
	@Export("musicTrackVolume")
	static int musicTrackVolume;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lgh;"
	)
	@Export("musicTrack")
	public static MusicTrack musicTrack;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	static Widget field2398;
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "Llh;"
	)
	static Bounds field2397;
	@ObfuscatedName("en")
	@ObfuscatedGetter(
		intValue = -54870407
	)
	@Export("port1")
	static int port1;

	static {
		field2392 = 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)Lip;",
		garbageValue = "760670759"
	)
	@Export("getInvDefinition")
	public static InvDefinition getInvDefinition(int var0) {
		InvDefinition var1 = (InvDefinition)InvDefinition.InvDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = InvDefinition.InvDefinition_archive.takeFile(5, var0);
			var1 = new InvDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			InvDefinition.InvDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
