import java.text.DecimalFormat;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cd")
@Implements("Login")
public class Login {
	@ObfuscatedName("n")
	static boolean field1160;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1085278935
	)
	@Export("xPadding")
	static int xPadding;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "[Llp;"
	)
	@Export("runesSprite")
	static IndexedSprite[] runesSprite;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	static IndexedSprite field1163;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1106370935
	)
	@Export("loginBoxX")
	static int loginBoxX;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1258124087
	)
	@Export("Login_loadingPercent")
	static int Login_loadingPercent;
	@ObfuscatedName("j")
	@Export("Login_loadingText")
	static String Login_loadingText;
	@ObfuscatedName("aa")
	@ObfuscatedGetter(
		intValue = 1751945439
	)
	static int field1174;
	@ObfuscatedName("ab")
	@ObfuscatedGetter(
		intValue = -1223310887
	)
	static int field1171;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = -857433701
	)
	@Export("loginIndex")
	static int loginIndex;
	@ObfuscatedName("ad")
	@Export("Login_response0")
	static String Login_response0;
	@ObfuscatedName("an")
	@Export("Login_response1")
	static String Login_response1;
	@ObfuscatedName("ai")
	@Export("Login_response2")
	static String Login_response2;
	@ObfuscatedName("ak")
	@Export("Login_response3")
	static String Login_response3;
	@ObfuscatedName("aq")
	@Export("Login_username")
	static String Login_username;
	@ObfuscatedName("am")
	@Export("Login_password")
	static String Login_password;
	@ObfuscatedName("au")
	static boolean field1176;
	@ObfuscatedName("af")
	static boolean field1192;
	@ObfuscatedName("bh")
	static boolean field1183;
	@ObfuscatedName("bd")
	@ObfuscatedGetter(
		intValue = -1323916819
	)
	@Export("currentLoginField")
	static int currentLoginField;
	@ObfuscatedName("bs")
	@Export("worldSelectOpen")
	static boolean worldSelectOpen;
	@ObfuscatedName("bi")
	@ObfuscatedGetter(
		intValue = 1218721579
	)
	@Export("hoveredWorldIndex")
	static int hoveredWorldIndex;
	@ObfuscatedName("bb")
	@ObfuscatedGetter(
		intValue = 838409867
	)
	@Export("worldSelectPage")
	static int worldSelectPage;
	@ObfuscatedName("bt")
	@ObfuscatedGetter(
		intValue = -94881399
	)
	@Export("worldSelectPagesCount")
	static int worldSelectPagesCount;
	@ObfuscatedName("by")
	@ObfuscatedGetter(
		longValue = 5865138585351193781L
	)
	static long field1181;
	@ObfuscatedName("bq")
	@ObfuscatedGetter(
		longValue = 4842998671579245891L
	)
	static long field1177;
	@ObfuscatedName("dn")
	@ObfuscatedSignature(
		signature = "Lfv;"
	)
	@Export("js5SocketTask")
	static Task js5SocketTask;

	static {
		xPadding = 0;
		loginBoxX = xPadding + 202;
		Login_loadingPercent = 10;
		Login_loadingText = "";
		field1174 = -1;
		field1171 = 1;
		loginIndex = 0;
		Login_response0 = "";
		Login_response1 = "";
		Login_response2 = "";
		Login_response3 = "";
		Login_username = "";
		Login_password = "";
		field1176 = false;
		field1192 = false;
		field1183 = true;
		currentLoginField = 0;
		worldSelectOpen = false;
		hoveredWorldIndex = -1;
		worldSelectPage = 0;
		worldSelectPagesCount = 0;
		new DecimalFormat("##0.00");
		new class162();
		field1181 = -1L;
		field1177 = -1L;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "432150558"
	)
	static int method2115(int var0, Script var1, boolean var2) {
		int var3 = -1;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			var4 = Canvas.getWidget(var3);
		} else {
			var4 = var2 ? GrandExchangeOfferAgeComparator.field76 : KitDefinition.field3252;
		}

		if (var0 == ScriptOpcodes.CC_SETPOSITION) {
			Interpreter.Interpreter_intStackSize -= 4;
			var4.rawX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4.rawY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var4.xAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			var4.yAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			WorldMapSectionType.invalidateWidget(var4);
			ViewportMouse.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				GameShell.revalidateWidgetScroll(UserComparator5.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETSIZE) {
			Interpreter.Interpreter_intStackSize -= 4;
			var4.rawWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4.rawHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var4.widthAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			var4.heightAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			WorldMapSectionType.invalidateWidget(var4);
			ViewportMouse.client.alignWidget(var4);
			if (var3 != -1 && var4.type == 0) {
				GameShell.revalidateWidgetScroll(UserComparator5.Widget_interfaceComponents[var3 >> 16], var4, false);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETHIDE) {
			boolean var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			if (var5 != var4.isHidden) {
				var4.isHidden = var5;
				WorldMapSectionType.invalidateWidget(var4);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETNOCLICKTHROUGH) {
			var4.noClickThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETNOSCROLLTHROUGH) {
			var4.noScrollThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-161600604"
	)
	static final int method2100(int var0, int var1) {
		int var2 = class160.method3416(var0 - 1, var1 - 1) + class160.method3416(var0 + 1, var1 - 1) + class160.method3416(var0 - 1, 1 + var1) + class160.method3416(1 + var0, var1 + 1);
		int var3 = class160.method3416(var0 - 1, var1) + class160.method3416(var0 + 1, var1) + class160.method3416(var0, var1 - 1) + class160.method3416(var0, var1 + 1);
		int var4 = class160.method3416(var0, var1);
		return var2 / 16 + var3 / 8 + var4 / 4;
	}

	@ObfuscatedName("ge")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "8"
	)
	static void method2114() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			if (var1[var2] != Client.combatTargetPlayerIndex && var1[var2] != Client.localPlayerIndex) {
				Players.addPlayerToScene(Client.players[var1[var2]], true);
			}
		}

	}
}
