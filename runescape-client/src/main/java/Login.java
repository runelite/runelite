import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("Login")
public class Login {
	@ObfuscatedName("x")
	static boolean field1181;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 479838183
	)
	@Export("xPadding")
	static int xPadding;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("titleboxSprite")
	static IndexedSprite titleboxSprite;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("leftTitleSprite")
	static Sprite leftTitleSprite;
	@ObfuscatedName("v")
	@Export("ByteArrayPool_altSizeArrayCounts")
	static int[] ByteArrayPool_altSizeArrayCounts;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	static IndexedSprite field1153;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("options_buttons_2Sprite")
	static IndexedSprite options_buttons_2Sprite;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 236963295
	)
	@Export("loginBoxX")
	static int loginBoxX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1854305915
	)
	@Export("Login_loadingPercent")
	static int Login_loadingPercent;
	@ObfuscatedName("m")
	@Export("Login_loadingText")
	static String Login_loadingText;
	@ObfuscatedName("av")
	@ObfuscatedGetter(
		intValue = -1732800523
	)
	static int field1156;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 123946901
	)
	static int field1161;
	@ObfuscatedName("aj")
	@ObfuscatedGetter(
		intValue = -356113497
	)
	@Export("loginIndex")
	static int loginIndex;
	@ObfuscatedName("ab")
	@Export("Login_response0")
	static String Login_response0;
	@ObfuscatedName("af")
	@Export("Login_response1")
	static String Login_response1;
	@ObfuscatedName("ak")
	@Export("Login_response2")
	static String Login_response2;
	@ObfuscatedName("ay")
	@Export("Login_response3")
	static String Login_response3;
	@ObfuscatedName("ae")
	@Export("Login_username")
	static String Login_username;
	@ObfuscatedName("ah")
	@Export("Login_password")
	static String Login_password;
	@ObfuscatedName("am")
	static boolean field1169;
	@ObfuscatedName("aw")
	static boolean field1170;
	@ObfuscatedName("bn")
	static boolean field1183;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		intValue = -533909079
	)
	@Export("currentLoginField")
	static int currentLoginField;
	@ObfuscatedName("bv")
	@Export("worldSelectOpen")
	static boolean worldSelectOpen;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = 574364551
	)
	@Export("hoveredWorldIndex")
	static int hoveredWorldIndex;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = -1143147941
	)
	@Export("worldSelectPage")
	static int worldSelectPage;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = -1385855305
	)
	@Export("worldSelectPagesCount")
	static int worldSelectPagesCount;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		longValue = 2260055487054663861L
	)
	static long field1162;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		longValue = -6819623631366416043L
	)
	static long field1164;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field1156 = -1;
		field1161 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field1169 = false;
		field1170 = false;
		field1183 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class162();
		field1162 = -1L;
		field1164 = -1L;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-387768527"
	)
	public static void method2051() {
		while (true) {
			ArchiveDiskAction var0;
			synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
				var0 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_responseQueue.removeLast();
			}

			if (var0 == null) {
				return;
			}

			var0.archive.load(var0.archiveDisk, (int)var0.key, var0.data, false);
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(IZII)V",
		garbageValue = "-12269440"
	)
	@Export("PcmPlayer_configure")
	public static final void PcmPlayer_configure(int var0, boolean var1, int var2) {
		if (var0 >= 8000 && var0 <= 48000) {
			GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate = var0;
			PcmPlayer.PcmPlayer_stereo = var1;
			GrandExchangeEvents.PcmPlayer_count = var2;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("fk")
	@ObfuscatedSignature(
		signature = "(Lbe;I)V",
		garbageValue = "697733270"
	)
	static final void method2075(Actor var0) {
		if (var0.field964 == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0 || var0.sequenceFrameCycle + 1 > class83.SequenceDefinition_get(var0.sequence).frameLengths[var0.sequenceFrame]) {
			int var1 = var0.field964 - var0.field963;
			int var2 = Client.cycle - var0.field963;
			int var3 = var0.field959 * 128 + var0.size * 64;
			int var4 = var0.field961 * 128 + var0.size * 64;
			int var5 = var0.field960 * 128 + var0.size * 64;
			int var6 = var0.field962 * 128 + var0.size * 64;
			var0.x = (var5 * var2 + var3 * (var1 - var2)) / var1 * 62504387;
			var0.y = (var6 * var2 + var4 * (var1 - var2)) / var1;
		}

		var0.field975 = 0;
		var0.orientation = var0.field965;
		var0.rotation = var0.orientation;
	}
}
