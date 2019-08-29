import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ah")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
	@ObfuscatedName("ob")
	@ObfuscatedSignature(
		signature = "Lfo;"
	)
	@Export("mouseWheel")
	static MouseWheel mouseWheel;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1288652121
	)
	static int field389;
	@ObfuscatedName("s")
	@Export("component")
	Component component;

	Canvas(Component var1) {
		this.component = var1;
	}

	public final void paint(Graphics var1) {
		this.component.paint(var1);
	}

	public final void update(Graphics var1) {
		this.component.update(var1);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "260955923"
	)
	@Export("itemContainerSetItem")
	static void itemContainerSetItem(int var0, int var1, int var2, int var3) {
		ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var4 == null) {
			var4 = new ItemContainer();
			ItemContainer.itemContainers.put(var4, (long)var0);
		}

		if (var4.ids.length <= var1) {
			int[] var5 = new int[var1 + 1];
			int[] var6 = new int[var1 + 1];

			int var7;
			for (var7 = 0; var7 < var4.ids.length; ++var7) {
				var5[var7] = var4.ids[var7];
				var6[var7] = var4.quantities[var7];
			}

			for (var7 = var4.ids.length; var7 < var1; ++var7) {
				var5[var7] = -1;
				var6[var7] = 0;
			}

			var4.ids = var5;
			var4.quantities = var6;
		}

		var4.ids[var1] = var2;
		var4.quantities[var1] = var3;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "65535"
	)
	static int method806(int var0, Script var1, boolean var2) {
		int var4 = -1;
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			var3 = WorldMapElement.getWidget(var4);
		} else {
			var3 = var2 ? class286.field3623 : class297.field3693;
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

			FriendSystem.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETCOLOUR) {
			var3.color = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			FriendSystem.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETFILL) {
			var3.fill = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			FriendSystem.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTRANS) {
			var3.transparencyTop = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			FriendSystem.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETLINEWID) {
			var3.lineWid = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			FriendSystem.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETGRAPHIC) {
			var3.spriteId2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			FriendSystem.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SET2DANGLE) {
			var3.spriteAngle = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			FriendSystem.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTILING) {
			var3.spriteTiling = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			FriendSystem.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODEL) {
			var3.modelType = 1;
			var3.modelId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			FriendSystem.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODELANGLE) {
			Interpreter.Interpreter_intStackSize -= 6;
			var3.modelOffsetX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var3.modelOffsetY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			var3.modelAngleX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			var3.modelAngleY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			var3.modelAngleZ = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 4];
			var3.modelZoom = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 5];
			FriendSystem.invalidateWidget(var3);
			return 1;
		} else {
			int var8;
			if (var0 == ScriptOpcodes.CC_SETMODELANIM) {
				var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				if (var8 != var3.sequenceId) {
					var3.sequenceId = var8;
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
					FriendSystem.invalidateWidget(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETMODELORTHOG) {
				var3.modelOrthog = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				FriendSystem.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXT) {
				String var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
				if (!var7.equals(var3.text)) {
					var3.text = var7;
					FriendSystem.invalidateWidget(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTFONT) {
				var3.fontId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				FriendSystem.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTALIGN) {
				Interpreter.Interpreter_intStackSize -= 3;
				var3.textXAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var3.textYAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				var3.textLineHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
				FriendSystem.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTSHADOW) {
				var3.textShadowed = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				FriendSystem.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETOUTLINE) {
				var3.outline = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				FriendSystem.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETGRAPHICSHADOW) {
				var3.spriteShadow = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				FriendSystem.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETVFLIP) {
				var3.spriteFlipV = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				FriendSystem.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETHFLIP) {
				var3.spriteFlipH = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				FriendSystem.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETSCROLLSIZE) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3.scrollWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var3.scrollHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				FriendSystem.invalidateWidget(var3);
				if (var4 != -1 && var3.type == 0) {
					WorldMapAreaData.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var4 >> 16], var3, false);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_RESUME_PAUSEBUTTON) {
				GameShell.resumePauseWidget(var3.id, var3.childIndex);
				Client.meslayerContinueWidget = var3;
				FriendSystem.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1122) {
				var3.spriteId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				FriendSystem.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLCOLOUR) {
				var3.color2 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				FriendSystem.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1124) {
				var3.transparencyBot = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				FriendSystem.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLMODE) {
				var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				FillMode var6 = (FillMode)FriendSystem.findEnumerated(SequenceDefinition.FillMode_values(), var8);
				if (var6 != null) {
					var3.fillMode = var6;
					FriendSystem.invalidateWidget(var3);
				}

				return 1;
			} else {
				boolean var5;
				if (var0 == ScriptOpcodes.CC_SETLINEDIRECTION) {
					var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
					var3.field2601 = var5;
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
}
