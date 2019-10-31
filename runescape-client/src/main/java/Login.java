import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("Login")
public class Login {
	@ObfuscatedName("se")
	@ObfuscatedSignature(
		signature = "Llo;"
	)
	@Export("worldMap")
	static WorldMap worldMap;
	@ObfuscatedName("t")
	static boolean field1188;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1763315451
	)
	@Export("xPadding")
	static int xPadding;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	@Export("leftTitleSprite")
	static Sprite leftTitleSprite;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Llw;"
	)
	@Export("options_buttons_2Sprite")
	static IndexedSprite options_buttons_2Sprite;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lbv;"
	)
	@Export("loginScreenRunesAnimation")
	static LoginScreenAnimation loginScreenRunesAnimation;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -2059277113
	)
	@Export("loginBoxX")
	static int loginBoxX;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1978997765
	)
	@Export("Login_loadingPercent")
	static int Login_loadingPercent;
	@ObfuscatedName("g")
	@Export("Login_loadingText")
	static String Login_loadingText;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 1768123277
	)
	static int field1156;
	@ObfuscatedName("ak")
	@ObfuscatedGetter(
		intValue = -1622828931
	)
	static int field1166;
	@ObfuscatedName("ax")
	@ObfuscatedGetter(
		intValue = -750997095
	)
	@Export("loginIndex")
	static int loginIndex;
	@ObfuscatedName("al")
	@Export("Login_response0")
	static String Login_response0;
	@ObfuscatedName("ap")
	@Export("Login_response1")
	static String Login_response1;
	@ObfuscatedName("aj")
	@Export("Login_response2")
	static String Login_response2;
	@ObfuscatedName("ae")
	@Export("Login_response3")
	static String Login_response3;
	@ObfuscatedName("au")
	@Export("Login_username")
	static String Login_username;
	@ObfuscatedName("ah")
	@Export("Login_password")
	static String Login_password;
	@ObfuscatedName("ao")
	@ObfuscatedGetter(
		intValue = -557990001
	)
	static int field1174;
	@ObfuscatedName("ac")
	static boolean field1159;
	@ObfuscatedName("at")
	static boolean field1175;
	@ObfuscatedName("bg")
	static boolean field1177;
	@ObfuscatedName("bc")
	@ObfuscatedGetter(
		intValue = -255503835
	)
	@Export("currentLoginField")
	static int currentLoginField;
	@ObfuscatedName("bh")
	@Export("worldSelectOpen")
	static boolean worldSelectOpen;
	@ObfuscatedName("bj")
	@ObfuscatedGetter(
		intValue = -236759579
	)
	@Export("hoveredWorldIndex")
	static int hoveredWorldIndex;
	@ObfuscatedName("bm")
	@ObfuscatedGetter(
		intValue = -1991064971
	)
	@Export("worldSelectPage")
	static int worldSelectPage;
	@ObfuscatedName("bn")
	@ObfuscatedGetter(
		intValue = -1550903987
	)
	@Export("worldSelectPagesCount")
	static int worldSelectPagesCount;
	@ObfuscatedName("bo")
	@ObfuscatedGetter(
		longValue = -6046220397950701943L
	)
	static long field1185;
	@ObfuscatedName("bk")
	@ObfuscatedGetter(
		longValue = -7219619967505319403L
	)
	static long field1186;
	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("headIconPrayerSprites")
	static Sprite[] headIconPrayerSprites;
	@ObfuscatedName("jq")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	static Widget field1165;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field1156 = -1;
		field1166 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field1159 = false;
		field1175 = false;
		field1177 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class162();
		field1185 = -1L;
		field1186 = -1L;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1795095420"
	)
	public static void method2258() {
		FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-722020095"
	)
	public static boolean method2256() {
		return class197.field2377 != 0 ? true : class197.midiPcmStream.isReady();
	}
}
