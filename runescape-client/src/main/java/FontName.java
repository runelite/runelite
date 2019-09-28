import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ko")
@Implements("FontName")
public class FontName {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("FontName_plain11")
	public static final FontName FontName_plain11;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("FontName_plain12")
	public static final FontName FontName_plain12;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("FontName_bold12")
	public static final FontName FontName_bold12;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("FontName_verdana11")
	public static final FontName FontName_verdana11;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("FontName_verdana13")
	public static final FontName FontName_verdana13;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("FontName_verdana15")
	public static final FontName FontName_verdana15;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	@Export("logoSprite")
	static IndexedSprite logoSprite;
	@ObfuscatedName("o")
	@Export("Tiles_hueMultiplier")
	static int[] Tiles_hueMultiplier;
	@ObfuscatedName("q")
	@Export("name")
	String name;

	static {
		FontName_plain11 = new FontName("p11_full");
		FontName_plain12 = new FontName("p12_full");
		FontName_bold12 = new FontName("b12_full");
		FontName_verdana11 = new FontName("verdana_11pt_regular");
		FontName_verdana13 = new FontName("verdana_13pt_regular");
		FontName_verdana15 = new FontName("verdana_15pt_regular");
	}

	FontName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)[Lko;",
		garbageValue = "-88"
	)
	public static FontName[] method5272() {
		return new FontName[]{FontName_verdana13, FontName_bold12, FontName_verdana11, FontName_plain12, FontName_verdana15, FontName_plain11};
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "14"
	)
	static void method5266() {
		ItemContainer.itemContainers = new NodeHashTable(32);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-1537038267"
	)
	static int method5271(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? GrandExchangeOfferAgeComparator.field76 : KitDefinition.field3252;
		if (var0 == ScriptOpcodes.CC_GETX) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETY) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETWIDTH) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETHIDE) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETLAYER) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("jr")
	@ObfuscatedSignature(
		signature = "(Lbk;ZI)V",
		garbageValue = "2027801614"
	)
	@Export("closeInterface")
	static final void closeInterface(InterfaceParent var0, boolean var1) {
		int var2 = var0.group;
		int var3 = (int)var0.key;
		var0.remove();
		if (var1) {
			InterfaceParent.method1192(var2);
		}

		for (IntegerNode var4 = (IntegerNode)Client.widgetClickMasks.first(); var4 != null; var4 = (IntegerNode)Client.widgetClickMasks.next()) {
			if ((long)var2 == (var4.key >> 48 & 65535L)) {
				var4.remove();
			}
		}

		Widget var5 = Canvas.getWidget(var3);
		if (var5 != null) {
			WorldMapSectionType.invalidateWidget(var5);
		}

		SecureRandomFuture.method2138();
		if (Client.rootInterface != -1) {
			class40.runIntfCloseListeners(Client.rootInterface, 1);
		}

	}
}
