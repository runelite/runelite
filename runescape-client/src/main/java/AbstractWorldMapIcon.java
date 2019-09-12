import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ap")
@Implements("AbstractWorldMapIcon")
public abstract class AbstractWorldMapIcon {
	@ObfuscatedName("la")
	@ObfuscatedSignature(
		signature = "Lhy;"
	)
	static Widget field292;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("coord2")
	public final Coord coord2;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lhj;"
	)
	@Export("coord1")
	public final Coord coord1;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 870912939
	)
	@Export("screenX")
	int screenX;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1786217753
	)
	@Export("screenY")
	int screenY;

	@ObfuscatedSignature(
		signature = "(Lhj;Lhj;)V"
	)
	AbstractWorldMapIcon(Coord var1, Coord var2) {
		this.coord1 = var1;
		this.coord2 = var2;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "861849893"
	)
	@Export("getElement")
	public abstract int getElement();

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Lao;",
		garbageValue = "1066707711"
	)
	@Export("getLabel")
	abstract WorldMapLabel getLabel();

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1386026878"
	)
	@Export("getSubWidth")
	abstract int getSubWidth();

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "174908718"
	)
	@Export("getSubHeight")
	abstract int getSubHeight();

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "1"
	)
	@Export("fitsScreen")
	boolean fitsScreen(int var1, int var2) {
		if (this.elementFitsScreen(var1, var2)) {
			return true;
		} else {
			return this.labelFitsScreen(var1, var2);
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1217113364"
	)
	@Export("hasValidElement")
	boolean hasValidElement() {
		return this.getElement() >= 0;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "682818721"
	)
	@Export("elementFitsScreen")
	boolean elementFitsScreen(int var1, int var2) {
		if (!this.hasValidElement()) {
			return false;
		} else {
			WorldMapElement var3 = WorldMapSection1.WorldMapElement_get(this.getElement());
			int var4 = this.getSubWidth();
			int var5 = this.getSubHeight();
			switch(var3.horizontalAlignment.value) {
			case 0:
				if (var1 < this.screenX || var1 >= var4 + this.screenX) {
					return false;
				}
				break;
			case 1:
				if (var1 >= this.screenX - var4 / 2 && var1 <= var4 / 2 + this.screenX) {
					break;
				}

				return false;
			case 2:
				if (var1 <= this.screenX - var4 || var1 > this.screenX) {
					return false;
				}
			}

			switch(var3.verticalAlignment.value) {
			case 0:
				if (var2 < this.screenY || var2 >= var5 + this.screenY) {
					return false;
				}
				break;
			case 1:
				if (var2 <= this.screenY - var5 || var2 > this.screenY) {
					return false;
				}
				break;
			case 2:
				if (var2 < this.screenY - var5 / 2 || var2 > var5 / 2 + this.screenY) {
					return false;
				}
			}

			return true;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(IIS)Z",
		garbageValue = "3172"
	)
	@Export("labelFitsScreen")
	boolean labelFitsScreen(int var1, int var2) {
		WorldMapLabel var3 = this.getLabel();
		if (var3 == null) {
			return false;
		} else if (var1 >= this.screenX - var3.width / 2 && var1 <= var3.width / 2 + this.screenX) {
			return var2 >= this.screenY && var2 <= this.screenY + var3.height;
		} else {
			return false;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "6"
	)
	static int method587() {
		return 11;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "131093374"
	)
	static int method576(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? UserComparator9.field1941 : MidiPcmStream.field2410;
		if (var0 == ScriptOpcodes.CC_GETTARGETMASK) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = WorldMapElement.method4390(class60.getWidgetClickMask(var3));
			return 1;
		} else if (var0 != ScriptOpcodes.CC_GETOP) {
			if (var0 == ScriptOpcodes.CC_GETOPBASE) {
				if (var3.dataText == null) {
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
				} else {
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3.dataText;
				}

				return 1;
			} else {
				return 2;
			}
		} else {
			int var4 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			--var4;
			if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
				Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var3.actions[var4];
			} else {
				Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
			}

			return 1;
		}
	}

	@ObfuscatedName("he")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1120874637"
	)
	static final void method572(int var0) {
		if (var0 >= 0) {
			int var1 = Client.menuArguments1[var0];
			int var2 = Client.menuArguments2[var0];
			int var3 = Client.menuOpcodes[var0];
			int var4 = Client.menuIdentifiers[var0];
			String var5 = Client.menuActions[var0];
			String var6 = Client.menuTargets[var0];
			EnumDefinition.menuAction(var1, var2, var3, var4, var5, var6, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
		}
	}

	@ObfuscatedName("ii")
	@ObfuscatedSignature(
		signature = "(IIIIIIIIB)V",
		garbageValue = "-109"
	)
	@Export("drawWidgets")
	static final void drawWidgets(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (TaskHandler.loadInterface(var0)) {
			SoundCache.field1410 = null;
			MusicPatchPcmStream.drawInterface(class289.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
			if (SoundCache.field1410 != null) {
				MusicPatchPcmStream.drawInterface(SoundCache.field1410, -1412584499, var1, var2, var3, var4, WorldMapSection0.field138, GrandExchangeOfferNameComparator.field79, var7);
				SoundCache.field1410 = null;
			}

		} else {
			if (var7 != -1) {
				Client.field827[var7] = true;
			} else {
				for (int var8 = 0; var8 < 100; ++var8) {
					Client.field827[var8] = true;
				}
			}

		}
	}
}
