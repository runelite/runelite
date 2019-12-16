import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lan;"
	)
	public static final WorldMapCacheName field291;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lan;"
	)
	public static final WorldMapCacheName field286;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lan;"
	)
	public static final WorldMapCacheName field287;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lan;"
	)
	static final WorldMapCacheName field288;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lan;"
	)
	public static final WorldMapCacheName field289;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1099236205
	)
	static int field293;
	@ObfuscatedName("b")
	@Export("name")
	public final String name;

	static {
		field291 = new WorldMapCacheName("details");
		field286 = new WorldMapCacheName("compositemap");
		field287 = new WorldMapCacheName("compositetexture");
		field288 = new WorldMapCacheName("area");
		field289 = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-61"
	)
	static void method618() {
		if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
			Login.currentLoginField = 1;
		} else {
			Login.currentLoginField = 0;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(ILhz;Ljava/lang/String;Ljava/lang/String;IZI)V",
		garbageValue = "-1803872156"
	)
	public static void method616(int var0, AbstractArchive var1, String var2, String var3, int var4, boolean var5) {
		int var6 = var1.getGroupId(var2);
		int var7 = var1.getFileId(var6, var3);
		class4.method59(var0, var1, var6, var7, var4, var5);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-574207472"
	)
	public static boolean method619() {
		try {
			if (class197.field2392 == 2) {
				if (class197.musicTrack == null) {
					class197.musicTrack = MusicTrack.readTrack(Coord.musicTrackArchive, class16.musicTrackGroupId, GrandExchangeOffer.musicTrackFileId);
					if (class197.musicTrack == null) {
						return false;
					}
				}

				if (class268.soundCache == null) {
					class268.soundCache = new SoundCache(class197.soundEffectsArchive, class197.musicSamplesArchive);
				}

				if (GZipDecompressor.midiPcmStream.loadMusicTrack(class197.musicTrack, class197.musicPatchesArchive, class268.soundCache, 22050)) {
					GZipDecompressor.midiPcmStream.clearAll();
					GZipDecompressor.midiPcmStream.setPcmStreamVolume(class197.musicTrackVolume);
					GZipDecompressor.midiPcmStream.setMusicTrack(class197.musicTrack, WorldMapDecoration.musicTrackBoolean);
					class197.field2392 = 0;
					class197.musicTrack = null;
					class268.soundCache = null;
					Coord.musicTrackArchive = null;
					return true;
				}
			}
		} catch (Exception var1) {
			var1.printStackTrace();
			GZipDecompressor.midiPcmStream.clear();
			class197.field2392 = 0;
			class197.musicTrack = null;
			class268.soundCache = null;
			Coord.musicTrackArchive = null;
		}

		return false;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lha;II)V",
		garbageValue = "-1662716370"
	)
	@Export("Widget_setKeyIgnoreHeld")
	static final void Widget_setKeyIgnoreHeld(Widget var0, int var1) {
		if (var0.field2626 == null) {
			throw new RuntimeException();
		} else {
			if (var0.field2655 == null) {
				var0.field2655 = new int[var0.field2626.length];
			}

			var0.field2655[var1] = Integer.MAX_VALUE;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "158917025"
	)
	static final void method620() {
		Tiles.method1143("You can't add yourself to your own ignore list");
	}
}
