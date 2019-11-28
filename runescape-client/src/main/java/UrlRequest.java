import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("UrlRequest")
public class UrlRequest {
	@ObfuscatedName("m")
	public static String field1947;
	@ObfuscatedName("gb")
	@Export("regionMapArchives")
	static byte[][] regionMapArchives;
	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		signature = "[Lln;"
	)
	@Export("headIconPrayerSprites")
	static Sprite[] headIconPrayerSprites;
	@ObfuscatedName("u")
	@Export("url")
	final URL url;
	@ObfuscatedName("f")
	@Export("isDone0")
	volatile boolean isDone0;
	@ObfuscatedName("b")
	@Export("response0")
	volatile byte[] response0;

	UrlRequest(URL var1) {
		this.url = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1603935718"
	)
	@Export("isDone")
	public boolean isDone() {
		return this.isDone0;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "-66601461"
	)
	@Export("getResponse")
	public byte[] getResponse() {
		return this.response0;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lkj;II)V",
		garbageValue = "1138294820"
	)
	@Export("updatePlayers")
	static final void updatePlayers(PacketBuffer var0, int var1) {
		int var2 = var0.offset;
		Players.Players_pendingUpdateCount = 0;
		GraphicsObject.method2041(var0);

		for (int var3 = 0; var3 < Players.Players_pendingUpdateCount; ++var3) {
			int var4 = Players.Players_pendingUpdateIndices[var3];
			Player var5 = Client.players[var4];
			int var6 = var0.readUnsignedByte();
			if ((var6 & 4) != 0) {
				var6 += var0.readUnsignedByte() << 8;
			}

			Players.method2167(var0, var4, var5, var6);
		}

		if (var0.offset - var2 != var1) {
			throw new RuntimeException(var0.offset - var2 + " " + var1);
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-791590790"
	)
	public static void method3358(int var0) {
		class197.field2411 = 1;
		class197.musicTrackArchive = null;
		UrlRequester.musicTrackGroupId = -1;
		UserComparator7.musicTrackFileId = -1;
		class197.musicTrackVolume = 0;
		ArchiveLoader.musicTrackBoolean = false;
		class335.field4014 = var0;
	}

	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "(Lhl;II)Ljava/lang/String;",
		garbageValue = "-1934633021"
	)
	static String method3361(Widget var0, int var1) {
		if (!WorldMapManager.method651(MenuAction.getWidgetClickMask(var0), var1) && var0.onOp == null) {
			return null;
		} else {
			return var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0 ? var0.actions[var1] : null;
		}
	}
}
