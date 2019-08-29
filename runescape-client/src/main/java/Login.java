import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("Login")
public class Login {
	@ObfuscatedName("j")
	static boolean field1146;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1653930727
	)
	@Export("xPadding")
	static int xPadding;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("titleboxSprite")
	static IndexedSprite titleboxSprite;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("titlebuttonSprite")
	static IndexedSprite titlebuttonSprite;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	@Export("leftTitleSprite")
	static Sprite leftTitleSprite;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	@Export("rightTitleSprite")
	static Sprite rightTitleSprite;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("options_buttons_0Sprite")
	static IndexedSprite options_buttons_0Sprite;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Llq;"
	)
	@Export("options_buttons_2Sprite")
	static IndexedSprite options_buttons_2Sprite;
	@ObfuscatedName("e")
	public static String[] field1181;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 751514225
	)
	@Export("loginBoxX")
	static int loginBoxX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1040783223
	)
	@Export("loginBoxCenter")
	static int loginBoxCenter;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1487498995
	)
	@Export("Login_loadingPercent")
	static int Login_loadingPercent;
	@ObfuscatedName("h")
	@Export("Login_loadingText")
	static String Login_loadingText;
	@ObfuscatedName("af")
	@ObfuscatedGetter(
		intValue = -577440455
	)
	static int field1160;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		intValue = 226287731
	)
	static int field1161;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -847558949
	)
	@Export("loginIndex")
	static int loginIndex;
	@ObfuscatedName("ac")
	@Export("Login_response0")
	static String Login_response0;
	@ObfuscatedName("ar")
	@Export("Login_response1")
	static String Login_response1;
	@ObfuscatedName("au")
	@Export("Login_response2")
	static String Login_response2;
	@ObfuscatedName("ax")
	@Export("Login_response3")
	static String Login_response3;
	@ObfuscatedName("ag")
	@Export("Login_username")
	static String Login_username;
	@ObfuscatedName("aa")
	@Export("Login_password")
	static String Login_password;
	@ObfuscatedName("ab")
	static boolean field1169;
	@ObfuscatedName("aw")
	static boolean field1170;
	@ObfuscatedName("bw")
	static boolean field1171;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		intValue = -1465778129
	)
	@Export("currentLoginField")
	static int currentLoginField;
	@ObfuscatedName("bh")
	@Export("worldSelectOpen")
	static boolean worldSelectOpen;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = 1853226103
	)
	@Export("hoveredWorldIndex")
	static int hoveredWorldIndex;
	@ObfuscatedName("br")
	@ObfuscatedGetter(
		intValue = 585792987
	)
	@Export("worldSelectPage")
	static int worldSelectPage;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = -2101798589
	)
	@Export("worldSelectPagesCount")
	static int worldSelectPagesCount;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		longValue = 2127987050025711637L
	)
	static long field1179;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		longValue = 2452989139374894339L
	)
	static long field1150;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field1160 = -1;
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
		field1171 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class162();
		field1179 = -1L;
		field1150 = -1L;
	}

	@ObfuscatedName("kv")
	@ObfuscatedSignature(
		signature = "(Lky;II)V",
		garbageValue = "1329186424"
	)
	static void method2031(Buffer var0, int var1) {
		Tiles.method1088(var0.array, var1);
		WorldMapIcon_1.method295(var0, var1);
	}
}
