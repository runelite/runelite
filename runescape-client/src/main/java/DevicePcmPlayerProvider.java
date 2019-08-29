import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("DevicePcmPlayerProvider")
public class DevicePcmPlayerProvider implements PcmPlayerProvider {
	DevicePcmPlayerProvider() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(S)Ldd;",
		garbageValue = "-22145"
	)
	@Export("player")
	public PcmPlayer player() {
		return new DevicePcmPlayer();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "1"
	)
	static boolean method794(int var0, int var1) {
		return var0 != 4 || var1 < 8;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "895453465"
	)
	public static void method793(int var0) {
		class197.field2378 = 1;
		WorldMapDecoration.musicTrackArchive = null;
		class197.musicTrackGroupId = -1;
		class197.musicTrackFileId = -1;
		WorldMapSprite.field222 = 0;
		Varcs.musicTrackBoolean = false;
		class16.field98 = var0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lbl;",
		garbageValue = "-1981262323"
	)
	@Export("worldListStart")
	static World worldListStart() {
		World.World_listCount = 0;
		return GrandExchangeOfferAgeComparator.getNextWorldListWorld();
	}
}
