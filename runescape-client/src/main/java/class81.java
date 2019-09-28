import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("co")
public class class81 {
	@ObfuscatedName("sp")
	@ObfuscatedGetter(
		longValue = -8179620885535776663L
	)
	static long field1135;
	@ObfuscatedName("y")
	@Export("ByteArrayPool_arrays")
	public static byte[][][] ByteArrayPool_arrays;
	@ObfuscatedName("as")
	static Image field1127;

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "116"
	)
	static int method2062(int var0, Script var1, boolean var2) {
		int var4 = -1;
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			var3 = Canvas.getWidget(var4);
		} else {
			var3 = var2 ? GrandExchangeOfferAgeComparator.field76 : KitDefinition.field3252;
		}

		if (var0 == ScriptOpcodes.CC_SETSCROLLPOS) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3.scrollX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			if (var3.scrollX > var3.scrollWidth - var3.width) {
				var3.scrollX = var3.scrollWidth - var3.width;
			}

			if (var3.scrollX < 0) {
				var3.scrollX = 0;
			}

			var3.scrollY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (var3.scrollY > var3.scrollHeight - var3.height) {
				var3.scrollY = var3.scrollHeight - var3.height;
			}

			if (var3.scrollY < 0) {
				var3.scrollY = 0;
			}

			WorldMapSectionType.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETCOLOUR) {
			var3.color = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			WorldMapSectionType.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETFILL) {
			var3.fill = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			WorldMapSectionType.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTRANS) {
			var3.transparencyTop = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			WorldMapSectionType.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETLINEWID) {
			var3.lineWid = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			WorldMapSectionType.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETGRAPHIC) {
			var3.spriteId2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			WorldMapSectionType.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SET2DANGLE) {
			var3.spriteAngle = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			WorldMapSectionType.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTILING) {
			var3.spriteTiling = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			WorldMapSectionType.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODEL) {
			var3.modelType = 1;
			var3.modelId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			WorldMapSectionType.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODELANGLE) {
			Interpreter.Interpreter_intStackSize -= 6;
			var3.modelOffsetX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var3.modelOffsetY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var3.modelAngleX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			var3.modelAngleY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			var3.modelAngleZ = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 4];
			var3.modelZoom = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 5];
			WorldMapSectionType.invalidateWidget(var3);
			return 1;
		} else {
			int var8;
			if (var0 == ScriptOpcodes.CC_SETMODELANIM) {
				var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var8 != var3.sequenceId) {
					var3.sequenceId = var8;
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
					WorldMapSectionType.invalidateWidget(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETMODELORTHOG) {
				var3.modelOrthog = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				WorldMapSectionType.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXT) {
				String var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
				if (!var7.equals(var3.text)) {
					var3.text = var7;
					WorldMapSectionType.invalidateWidget(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTFONT) {
				var3.fontId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				WorldMapSectionType.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTALIGN) {
				Interpreter.Interpreter_intStackSize -= 3;
				var3.textXAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var3.textYAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				var3.textLineHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
				WorldMapSectionType.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTSHADOW) {
				var3.textShadowed = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				WorldMapSectionType.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETOUTLINE) {
				var3.outline = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				WorldMapSectionType.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETGRAPHICSHADOW) {
				var3.spriteShadow = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				WorldMapSectionType.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETVFLIP) {
				var3.spriteFlipV = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				WorldMapSectionType.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETHFLIP) {
				var3.spriteFlipH = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				WorldMapSectionType.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETSCROLLSIZE) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3.scrollWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var3.scrollHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				WorldMapSectionType.invalidateWidget(var3);
				if (var4 != -1 && var3.type == 0) {
					GameShell.revalidateWidgetScroll(UserComparator5.Widget_interfaceComponents[var4 >> 16], var3, false);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_RESUME_PAUSEBUTTON) {
				Clock.resumePauseWidget(var3.id, var3.childIndex);
				Client.meslayerContinueWidget = var3;
				WorldMapSectionType.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1122) {
				var3.spriteId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				WorldMapSectionType.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLCOLOUR) {
				var3.color2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				WorldMapSectionType.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1124) {
				var3.transparencyBot = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				WorldMapSectionType.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLMODE) {
				var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				FillMode var6 = (FillMode)NetSocket.findEnumerated(class96.FillMode_values(), var8);
				if (var6 != null) {
					var3.fillMode = var6;
					WorldMapSectionType.invalidateWidget(var3);
				}

				return 1;
			} else {
				boolean var5;
				if (var0 == ScriptOpcodes.CC_SETLINEDIRECTION) {
					var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					var3.field2579 = var5;
					return 1;
				} else if (var0 == ScriptOpcodes.CC_SETMODELTRANSPARENT) {
					var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					var3.modelTransparency = var5;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "550144839"
	)
	public static int method2063(int var0) {
		return Client.method1708(ViewportMouse.ViewportMouse_entityTags[var0]);
	}

	@ObfuscatedName("m")
	@Export("Entity_unpackID")
	public static int Entity_unpackID(long var0) {
		return (int)(var0 >>> 17 & 4294967295L);
	}
}
