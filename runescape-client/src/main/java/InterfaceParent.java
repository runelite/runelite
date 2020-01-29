import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;
import netscape.javascript.JSObject;

@ObfuscatedName("be")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
	@ObfuscatedName("ps")
	@ObfuscatedSignature(
		signature = "Ljl;"
	)
	@Export("clanChat")
	static ClanChat clanChat;
	@ObfuscatedName("l")
	static byte[][][] field565;
	@ObfuscatedName("gz")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("modIconSprites")
	static IndexedSprite[] modIconSprites;
	@ObfuscatedName("kx")
	@ObfuscatedGetter(
		intValue = 311386537
	)
	@Export("menuWidth")
	static int menuWidth;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 741333459
	)
	@Export("group")
	int group;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1361979275
	)
	@Export("type")
	int type;
	@ObfuscatedName("o")
	boolean field568;

	InterfaceParent() {
		this.field568 = false;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIIZIZI)V",
		garbageValue = "-753308840"
	)
	@Export("doWorldSorting")
	static void doWorldSorting(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
		if (var0 < var1) {
			int var6 = (var0 + var1) / 2;
			int var7 = var0;
			World var8 = class96.World_worlds[var6];
			class96.World_worlds[var6] = class96.World_worlds[var1];
			class96.World_worlds[var1] = var8;

			for (int var9 = var0; var9 < var1; ++var9) {
				if (class1.method19(class96.World_worlds[var9], var8, var2, var3, var4, var5) <= 0) {
					World var10 = class96.World_worlds[var9];
					class96.World_worlds[var9] = class96.World_worlds[var7];
					class96.World_worlds[var7++] = var10;
				}
			}

			class96.World_worlds[var1] = class96.World_worlds[var7];
			class96.World_worlds[var7] = var8;
			doWorldSorting(var0, var7 - 1, var2, var3, var4, var5);
			doWorldSorting(var7 + 1, var1, var2, var3, var4, var5);
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "-332647401"
	)
	static int method1191(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 == ScriptOpcodes.IF_GETINVOBJECT) {
			var3 = Varps.getWidget(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.itemId;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETINVCOUNT) {
			var3 = Varps.getWidget(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
			if (var3.itemId != -1) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.itemQuantity;
			} else {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.IF_HASSUB) {
			int var5 = Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize];
			InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var5);
			if (var4 != null) {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 1;
			} else {
				Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = 0;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETTOP) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = Client.rootInterface;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("gs")
	@ObfuscatedSignature(
		signature = "(Lba;III)V",
		garbageValue = "1714214597"
	)
	@Export("performPlayerAnimation")
	static void performPlayerAnimation(Player var0, int var1, int var2) {
		if (var0.sequence == var1 && var1 != -1) {
			int var3 = GraphicsDefaults.SequenceDefinition_get(var1).field3516;
			if (var3 == 1) {
				var0.sequenceFrame = 0;
				var0.sequenceFrameCycle = 0;
				var0.sequenceDelay = var2;
				var0.field983 = 0;
			}

			if (var3 == 2) {
				var0.field983 = 0;
			}
		} else if (var1 == -1 || var0.sequence == -1 || GraphicsDefaults.SequenceDefinition_get(var1).field3508 >= GraphicsDefaults.SequenceDefinition_get(var0.sequence).field3508) {
			var0.sequence = var1;
			var0.sequenceFrame = 0;
			var0.sequenceFrameCycle = 0;
			var0.sequenceDelay = var2;
			var0.field983 = 0;
			var0.field998 = var0.pathLength;
		}

	}

	@ObfuscatedName("iz")
	@ObfuscatedSignature(
		signature = "(Lhn;III)V",
		garbageValue = "-749720569"
	)
	@Export("alignWidgetPosition")
	static void alignWidgetPosition(Widget var0, int var1, int var2) {
		if (var0.xAlignment == 0) {
			var0.x = var0.rawX;
		} else if (var0.xAlignment == 1) {
			var0.x = var0.rawX + (var1 - var0.width) / 2;
		} else if (var0.xAlignment == 2) {
			var0.x = var1 - var0.width - var0.rawX;
		} else if (var0.xAlignment == 3) {
			var0.x = var0.rawX * var1 >> 14;
		} else if (var0.xAlignment == 4) {
			var0.x = (var0.rawX * var1 >> 14) + (var1 - var0.width) / 2;
		} else {
			var0.x = var1 - var0.width - (var0.rawX * var1 >> 14);
		}

		if (var0.yAlignment == 0) {
			var0.y = var0.rawY;
		} else if (var0.yAlignment == 1) {
			var0.y = (var2 - var0.height) / 2 + var0.rawY;
		} else if (var0.yAlignment == 2) {
			var0.y = var2 - var0.height - var0.rawY;
		} else if (var0.yAlignment == 3) {
			var0.y = var2 * var0.rawY >> 14;
		} else if (var0.yAlignment == 4) {
			var0.y = (var2 * var0.rawY >> 14) + (var2 - var0.height) / 2;
		} else {
			var0.y = var2 - var0.height - (var2 * var0.rawY >> 14);
		}

	}

	@ObfuscatedName("kr")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-53"
	)
	static void method1192(String var0) {
		GameShell.field477 = var0;

		try {
			String var1 = Username.client.getParameter(Integer.toString(18));
			String var2 = Username.client.getParameter(Integer.toString(13));
			String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
			if (var0.length() == 0) {
				var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
			} else {
				var3 = var3 + "; Expires=" + HealthBarUpdate.method1758(WorldMapIcon_0.currentTimeMillis() + 94608000000L) + "; Max-Age=" + 94608000L;
			}

			Client var4 = Username.client;
			String var5 = "document.cookie=\"" + var3 + "\"";
			JSObject.getWindow(var4).eval(var5);
		} catch (Throwable var6) {
		}

	}
}
