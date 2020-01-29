import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
	@ObfuscatedName("du")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive11")
	static Archive archive11;
	@ObfuscatedName("hd")
	@ObfuscatedGetter(
		intValue = -1999981463
	)
	@Export("cameraPitch")
	static int cameraPitch;
	@ObfuscatedName("c")
	@Export("state")
	byte state;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1202522813
	)
	@Export("id")
	public int id;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -286950223
	)
	@Export("unitPrice")
	public int unitPrice;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -191142567
	)
	@Export("totalQuantity")
	public int totalQuantity;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1418175861
	)
	@Export("currentQuantity")
	public int currentQuantity;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 45465727
	)
	@Export("currentPrice")
	public int currentPrice;

	public GrandExchangeOffer() {
	}

	@ObfuscatedSignature(
		signature = "(Lkp;Z)V",
		garbageValue = "0"
	)
	public GrandExchangeOffer(Buffer var1, boolean var2) {
		this.state = var1.readByte();
		this.id = var1.readUnsignedShort();
		this.unitPrice = var1.readInt();
		this.totalQuantity = var1.readInt();
		this.currentQuantity = var1.readInt();
		this.currentPrice = var1.readInt();
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-51"
	)
	@Export("status")
	public int status() {
		return this.state & 7;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-96"
	)
	@Export("type")
	public int type() {
		return (this.state & 8) == 8 ? 1 : 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "-38"
	)
	void method120(int var1) {
		this.state &= -8;
		this.state = (byte)(this.state | var1 & 7);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-59985742"
	)
	void method112(int var1) {
		this.state &= -9;
		if (var1 == 1) {
			this.state = (byte)(this.state | 8);
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-27"
	)
	public static int method128(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int)(var2 >>> 0 & 127L);
		return var1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1764789679"
	)
	public static boolean method129() {
		try {
			if (class197.field2414 == 2) {
				if (FileSystem.musicTrack == null) {
					FileSystem.musicTrack = MusicTrack.readTrack(UserComparator5.musicTrackArchive, class197.musicTrackGroupId, class83.musicTrackFileId);
					if (FileSystem.musicTrack == null) {
						return false;
					}
				}

				if (class197.soundCache == null) {
					class197.soundCache = new SoundCache(UserComparator10.soundEffectsArchive, class197.musicSamplesArchive);
				}

				if (class197.midiPcmStream.loadMusicTrack(FileSystem.musicTrack, class197.musicPatchesArchive, class197.soundCache, 22050)) {
					class197.midiPcmStream.clearAll();
					class197.midiPcmStream.setPcmStreamVolume(AttackOption.musicTrackVolume);
					class197.midiPcmStream.setMusicTrack(FileSystem.musicTrack, KeyHandler.musicTrackBoolean);
					class197.field2414 = 0;
					FileSystem.musicTrack = null;
					class197.soundCache = null;
					UserComparator5.musicTrackArchive = null;
					return true;
				}
			}
		} catch (Exception var1) {
			var1.printStackTrace();
			class197.midiPcmStream.clear();
			class197.field2414 = 0;
			FileSystem.musicTrack = null;
			class197.soundCache = null;
			UserComparator5.musicTrackArchive = null;
		}

		return false;
	}

	@ObfuscatedName("kn")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1055020085"
	)
	static void method127(int var0) {
		Client.oculusOrbState = var0;
	}
}
