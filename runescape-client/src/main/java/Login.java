import java.security.SecureRandom;
import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("Login")
public class Login {
	@ObfuscatedName("i")
	static boolean field1173;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 263999523
	)
	@Export("xPadding")
	static int xPadding;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("runesSprite")
	static IndexedSprite[] runesSprite;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("titleboxSprite")
	static IndexedSprite titleboxSprite;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("titlebuttonSprite")
	static IndexedSprite titlebuttonSprite;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("logoSprite")
	static IndexedSprite logoSprite;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lex;"
	)
	@Export("World_request")
	static UrlRequest World_request;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("options_buttons_2Sprite")
	static IndexedSprite options_buttons_2Sprite;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	static IndexedSprite field1162;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1796142123
	)
	@Export("loginBoxX")
	static int loginBoxX;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 853386151
	)
	@Export("Login_loadingPercent")
	static int Login_loadingPercent;
	@ObfuscatedName("m")
	@Export("Login_loadingText")
	static String Login_loadingText;
	@ObfuscatedName("as")
	@ObfuscatedGetter(
		intValue = 2047015599
	)
	static int field1167;
	@ObfuscatedName("ah")
	@ObfuscatedGetter(
		intValue = -421620705
	)
	static int field1181;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -996897081
	)
	@Export("loginIndex")
	static int loginIndex;
	@ObfuscatedName("az")
	@Export("Login_response0")
	static String Login_response0;
	@ObfuscatedName("ay")
	@Export("Login_response1")
	static String Login_response1;
	@ObfuscatedName("ag")
	@Export("Login_response2")
	static String Login_response2;
	@ObfuscatedName("ac")
	@Export("Login_response3")
	static String Login_response3;
	@ObfuscatedName("al")
	@Export("Login_username")
	static String Login_username;
	@ObfuscatedName("ae")
	@Export("Login_password")
	static String Login_password;
	@ObfuscatedName("ai")
	static boolean field1186;
	@ObfuscatedName("am")
	static boolean field1182;
	@ObfuscatedName("bg")
	static boolean field1178;
	@ObfuscatedName("bw")
	@ObfuscatedGetter(
		intValue = -436671027
	)
	@Export("currentLoginField")
	static int currentLoginField;
	@ObfuscatedName("bx")
	@Export("worldSelectOpen")
	static boolean worldSelectOpen;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = 1729150303
	)
	@Export("hoveredWorldIndex")
	static int hoveredWorldIndex;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 1430406405
	)
	@Export("worldSelectPage")
	static int worldSelectPage;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		intValue = 552421487
	)
	@Export("worldSelectPagesCount")
	static int worldSelectPagesCount;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		longValue = 1507915071699624777L
	)
	static long field1158;
	@ObfuscatedName("be")
	@ObfuscatedGetter(
		longValue = 8918979635006641127L
	)
	static long field1187;
	@ObfuscatedName("eh")
	@Export("secureRandom")
	static SecureRandom secureRandom;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field1167 = -1;
		field1181 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field1186 = false;
		field1182 = false;
		field1178 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class162();
		field1158 = -1L;
		field1187 = -1L;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1893655286"
	)
	public static boolean method2119(int var0) {
		return (var0 >> 21 & 1) != 0;
	}
}
