import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("Login")
public class Login {
	@ObfuscatedName("f")
	static boolean field1194;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -690855735
	)
	@Export("xPadding")
	static int xPadding;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("titleboxSprite")
	static IndexedSprite titleboxSprite;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("titlebuttonSprite")
	static IndexedSprite titlebuttonSprite;
	@ObfuscatedName("w")
	static int[][] field1207;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "[Llm;"
	)
	@Export("title_muteSprite")
	static IndexedSprite[] title_muteSprite;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	static IndexedSprite field1179;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -848328951
	)
	@Export("loginBoxX")
	static int loginBoxX;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 718703291
	)
	@Export("Login_loadingPercent")
	static int Login_loadingPercent;
	@ObfuscatedName("v")
	@Export("Login_loadingText")
	static String Login_loadingText;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		intValue = 287436993
	)
	static int field1185;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = 1502422869
	)
	static int field1186;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -748182157
	)
	@Export("loginIndex")
	static int loginIndex;
	@ObfuscatedName("av")
	@Export("Login_response0")
	static String Login_response0;
	@ObfuscatedName("aq")
	@Export("Login_response1")
	static String Login_response1;
	@ObfuscatedName("ac")
	@Export("Login_response2")
	static String Login_response2;
	@ObfuscatedName("az")
	@Export("Login_response3")
	static String Login_response3;
	@ObfuscatedName("at")
	@Export("Login_username")
	static String Login_username;
	@ObfuscatedName("ae")
	@Export("Login_password")
	static String Login_password;
	@ObfuscatedName("au")
	static boolean field1173;
	@ObfuscatedName("as")
	static boolean field1195;
	@ObfuscatedName("bo")
	static boolean field1196;
	@ObfuscatedName("bx")
	@ObfuscatedGetter(
		intValue = 942896695
	)
	@Export("currentLoginField")
	static int currentLoginField;
	@ObfuscatedName("bj")
	@Export("worldSelectOpen")
	static boolean worldSelectOpen;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		intValue = 417919885
	)
	@Export("hoveredWorldIndex")
	static int hoveredWorldIndex;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = -505554321
	)
	@Export("worldSelectPage")
	static int worldSelectPage;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		intValue = 1487083195
	)
	@Export("worldSelectPagesCount")
	static int worldSelectPagesCount;
	@ObfuscatedName("bl")
	@ObfuscatedGetter(
		longValue = -5043018622497011003L
	)
	static long field1205;
	@ObfuscatedName("bp")
	@ObfuscatedGetter(
		longValue = -8955113663343183185L
	)
	static long field1206;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field1185 = -1;
		field1186 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field1173 = false;
		field1195 = false;
		field1196 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class162();
		field1205 = -1L;
		field1206 = -1L;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "84"
	)
	public static void method2125() {
		try {
			JagexCache.JagexCache_dat2File.close();

			for (int var0 = 0; var0 < JagexCache.idxCount; ++var0) {
				WorldMapSection1.JagexCache_idxFiles[var0].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var2) {
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lkj;I)I",
		garbageValue = "-1079578182"
	)
	static int method2124(PacketBuffer var0) {
		int var1 = var0.readBits(2);
		int var2;
		if (var1 == 0) {
			var2 = 0;
		} else if (var1 == 1) {
			var2 = var0.readBits(5);
		} else if (var1 == 2) {
			var2 = var0.readBits(8);
		} else {
			var2 = var0.readBits(11);
		}

		return var2;
	}
}
