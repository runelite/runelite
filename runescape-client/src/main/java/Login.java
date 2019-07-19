import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("Login")
public class Login {
	@ObfuscatedName("w")
	static boolean field1179;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -581394193
	)
	@Export("xPadding")
	static int xPadding;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("runesSprite")
	static IndexedSprite[] runesSprite;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	@Export("titleboxSprite")
	static IndexedSprite titleboxSprite;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("title_muteSprite")
	static IndexedSprite[] title_muteSprite;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	@Export("options_buttons_0Sprite")
	static IndexedSprite options_buttons_0Sprite;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	static IndexedSprite field1185;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1807280197
	)
	@Export("loginBoxX")
	static int loginBoxX;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 779254255
	)
	@Export("Login_loadingPercent")
	static int Login_loadingPercent;
	@ObfuscatedName("n")
	@Export("Login_loadingText")
	static String Login_loadingText;
	@ObfuscatedName("aw")
	@ObfuscatedGetter(
		intValue = -642459289
	)
	static int field1182;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -2013151801
	)
	static int field1212;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = 2026223077
	)
	@Export("loginIndex")
	static int loginIndex;
	@ObfuscatedName("aj")
	@Export("Login_response0")
	static String Login_response0;
	@ObfuscatedName("at")
	@Export("Login_response1")
	static String Login_response1;
	@ObfuscatedName("ac")
	@Export("Login_response2")
	static String Login_response2;
	@ObfuscatedName("ap")
	@Export("Login_response3")
	static String Login_response3;
	@ObfuscatedName("aq")
	@Export("Login_username")
	static String Login_username;
	@ObfuscatedName("aa")
	@Export("Login_password")
	static String Login_password;
	@ObfuscatedName("ay")
	static boolean field1199;
	@ObfuscatedName("af")
	static boolean field1184;
	@ObfuscatedName("bz")
	static boolean field1201;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = 59123185
	)
	@Export("currentLoginField")
	static int currentLoginField;
	@ObfuscatedName("bn")
	@Export("worldSelectOpen")
	static boolean worldSelectOpen;
	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	@Export("worldSelectLeftSprite")
	static IndexedSprite worldSelectLeftSprite;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = 1090438369
	)
	@Export("hoveredWorldIndex")
	static int hoveredWorldIndex;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		intValue = -2109532815
	)
	@Export("worldSelectPage")
	static int worldSelectPage;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = -1875714111
	)
	@Export("worldSelectPagesCount")
	static int worldSelectPagesCount;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		longValue = 7221732976161775211L
	)
	static long field1193;
	@ObfuscatedName("bu")
	@ObfuscatedGetter(
		longValue = -1649813103700171861L
	)
	static long field1211;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field1182 = -1;
		field1212 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field1199 = false;
		field1184 = false;
		field1201 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class162();
		field1193 = -1L;
		field1211 = -1L;
	}
}
