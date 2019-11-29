import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class65 extends RouteStrategy {
	@ObfuscatedName("sp")
	@ObfuscatedGetter(
		longValue = -1800768745141065643L
	)
	static long field604;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 44255735
	)
	static int field603;

	class65() {
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIILfh;B)Z",
		garbageValue = "-103"
	)
	@Export("hasArrived")
	protected boolean hasArrived(int var1, int var2, int var3, CollisionMap var4) {
		return var2 == super.approxDestinationX && var3 == super.approxDestinationY;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lhf;IIIZI)V",
		garbageValue = "-1389497499"
	)
	@Export("playMusicTrack")
	public static void playMusicTrack(AbstractArchive var0, int var1, int var2, int var3, boolean var4) {
		class197.field2411 = 1;
		class197.musicTrackArchive = var0;
		UrlRequester.musicTrackGroupId = var1;
		UserComparator7.musicTrackFileId = var2;
		class197.musicTrackVolume = var3;
		ArchiveLoader.musicTrackBoolean = var4;
		class335.field4014 = 10000;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1885600103"
	)
	static final void method1244(String var0) {
		WorldMapSection2.method347(var0 + " is already on your friend list");
	}

	@ObfuscatedName("iq")
	@ObfuscatedSignature(
		signature = "(IIIIIIIII)V",
		garbageValue = "-1636724870"
	)
	@Export("drawWidgets")
	static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (UserComparator3.loadInterface(var0)) {
			class4.field22 = null;
			class40.drawInterface(FloorDecoration.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
			if (class4.field22 != null) {
				class40.drawInterface(class4.field22, -1412584499, var1, var2, var3, var4, WorldMapSection2.field200, TilePaint.field1782, var7);
				class4.field22 = null;
			}

		} else {
			if (var7 != -1) {
				Client.field847[var7] = true;
			} else {
				for (int var8 = 0; var8 < 100; ++var8) {
					Client.field847[var8] = true;
				}
			}

		}
	}
}
