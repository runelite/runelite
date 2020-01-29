import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Login")
public class Login {
	@ObfuscatedName("t")
	static boolean field1163;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1501257187
	)
	@Export("xPadding")
	static int xPadding;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("titlebuttonSprite")
	static IndexedSprite titlebuttonSprite;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("leftTitleSprite")
	static Sprite leftTitleSprite;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("title_muteSprite")
	static IndexedSprite[] title_muteSprite;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -130819791
	)
	@Export("loginBoxX")
	static int loginBoxX;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -515852009
	)
	@Export("Login_loadingPercent")
	static int Login_loadingPercent;
	@ObfuscatedName("r")
	@Export("Login_loadingText")
	static String Login_loadingText;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = 591976709
	)
	static int field1165;
	@ObfuscatedName("ay")
	@ObfuscatedGetter(
		intValue = -366456801
	)
	static int field1193;
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "Lll;"
	)
	static Bounds field1175;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -2042925581
	)
	@Export("loginIndex")
	static int loginIndex;
	@ObfuscatedName("ac")
	@Export("Login_response0")
	static String Login_response0;
	@ObfuscatedName("aw")
	@Export("Login_response1")
	static String Login_response1;
	@ObfuscatedName("ar")
	@Export("Login_response2")
	static String Login_response2;
	@ObfuscatedName("av")
	@Export("Login_response3")
	static String Login_response3;
	@ObfuscatedName("al")
	@Export("Login_username")
	static String Login_username;
	@ObfuscatedName("ad")
	@Export("Login_password")
	static String Login_password;
	@ObfuscatedName("ab")
	static boolean field1183;
	@ObfuscatedName("ap")
	static boolean field1184;
	@ObfuscatedName("bf")
	static boolean field1185;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = 2063292443
	)
	@Export("currentLoginField")
	static int currentLoginField;
	@ObfuscatedName("bp")
	@Export("worldSelectOpen")
	static boolean worldSelectOpen;
	@ObfuscatedName("ba")
	@ObfuscatedGetter(
		intValue = -921814137
	)
	@Export("hoveredWorldIndex")
	static int hoveredWorldIndex;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = 1630219319
	)
	@Export("worldSelectPage")
	static int worldSelectPage;
	@ObfuscatedName("bs")
	@ObfuscatedGetter(
		intValue = -2032377127
	)
	@Export("worldSelectPagesCount")
	static int worldSelectPagesCount;
	@ObfuscatedName("bh")
	@ObfuscatedGetter(
		longValue = 5886153640443907315L
	)
	static long field1180;
	@ObfuscatedName("bg")
	@ObfuscatedGetter(
		longValue = 3027012337338464175L
	)
	static long field1194;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field1165 = -1;
		field1193 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field1183 = false;
		field1184 = false;
		field1185 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class162();
		field1180 = -1L;
		field1194 = -1L;
	}
}
