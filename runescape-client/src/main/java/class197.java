import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class197 {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("musicPatchesArchive")
	public static AbstractArchive musicPatchesArchive;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("musicSamplesArchive")
	public static AbstractArchive musicSamplesArchive;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("soundEffectsArchive")
	public static AbstractArchive soundEffectsArchive;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 569775055
	)
	public static int field2411;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhf;"
	)
	@Export("musicTrackArchive")
	public static AbstractArchive musicTrackArchive;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 2134983541
	)
	@Export("musicTrackVolume")
	public static int musicTrackVolume;

	static {
		field2411 = 0;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(III)Lba;",
		garbageValue = "1833957440"
	)
	@Export("Messages_getByChannelAndID")
	static Message Messages_getByChannelAndID(int var0, int var1) {
		ChatChannel var2 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var2.getMessage(var1);
	}
}
