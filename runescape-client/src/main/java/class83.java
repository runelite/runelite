import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cy")
public class class83 {
	@ObfuscatedName("qj")
	@ObfuscatedGetter(
		intValue = -297282221
	)
	static int field1166;
	@ObfuscatedName("q")
	static final BigInteger field1165;
	@ObfuscatedName("w")
	static final BigInteger field1162;

	static {
		field1165 = new BigInteger("10001", 16);
		field1162 = new BigInteger("83ff79a3e258b99ead1a70e1049883e78e513c4cdec538d8da9483879a9f81689c0c7d146d7b82b52d05cf26132b1cda5930eeef894e4ccf3d41eebc3aabe54598c4ca48eb5a31d736bfeea17875a35558b9e3fcd4aebe2a9cc970312a477771b36e173dc2ece6001ab895c553e2770de40073ea278026f36961c94428d8d7db", 16);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIILiy;II)V",
		garbageValue = "1789870821"
	)
	static void method1996(int var0, int var1, int var2, ObjectDefinition var3, int var4) {
		ObjectSound var5 = new ObjectSound();
		var5.field1078 = var0;
		var5.field1083 = var1 * 128;
		var5.field1090 = var2 * 16384;
		int var6 = var3.sizeX;
		int var7 = var3.sizeY;
		if (var4 == 1 || var4 == 3) {
			var6 = var3.sizeY;
			var7 = var3.sizeX;
		}

		var5.field1077 = (var6 + var1) * 16384;
		var5.field1082 = (var7 + var2) * 16384;
		var5.soundEffectId = var3.ambientSoundId;
		var5.field1091 = var3.int4 * 128;
		var5.field1086 = var3.int5;
		var5.field1081 = var3.int6;
		var5.soundEffectIds = var3.field3367;
		if (var3.transforms != null) {
			var5.obj = var3;
			var5.set();
		}

		ObjectSound.objectSounds.addFirst(var5);
		if (var5.soundEffectIds != null) {
			var5.field1089 = var5.field1086 + (int)(Math.random() * (double)(var5.field1081 - var5.field1086));
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "-9434950"
	)
	static int method1994(int var0, Script var1, boolean var2) {
		int var4 = -1;
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			var3 = class80.getWidget(var4);
		} else {
			var3 = var2 ? Interpreter.field1111 : Calendar.field2507;
		}

		if (var0 == ScriptOpcodes.CC_SETSCROLLPOS) {
			HealthBarUpdate.Interpreter_intStackSize -= 2;
			var3.scrollX = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			if (var3.scrollX > var3.scrollWidth - var3.width) {
				var3.scrollX = var3.scrollWidth - var3.width;
			}

			if (var3.scrollX < 0) {
				var3.scrollX = 0;
			}

			var3.scrollY = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			if (var3.scrollY > var3.scrollHeight - var3.height) {
				var3.scrollY = var3.scrollHeight - var3.height;
			}

			if (var3.scrollY < 0) {
				var3.scrollY = 0;
			}

			Strings.method4120(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETCOLOUR) {
			var3.color = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Strings.method4120(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETFILL) {
			var3.fill = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
			Strings.method4120(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTRANS) {
			var3.transparencyTop = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Strings.method4120(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETLINEWID) {
			var3.lineWid = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Strings.method4120(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETGRAPHIC) {
			var3.spriteId2 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Strings.method4120(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SET2DANGLE) {
			var3.spriteAngle = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Strings.method4120(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTILING) {
			var3.spriteTiling = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
			Strings.method4120(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODEL) {
			var3.modelType = 1;
			var3.modelId = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
			Strings.method4120(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODELANGLE) {
			HealthBarUpdate.Interpreter_intStackSize -= 6;
			var3.modelOffsetX = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
			var3.modelOffsetY = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
			var3.modelAngleX = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2];
			var3.modelAngleY = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 3];
			var3.modelAngleZ = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 4];
			var3.modelZoom = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 5];
			Strings.method4120(var3);
			return 1;
		} else {
			int var8;
			if (var0 == ScriptOpcodes.CC_SETMODELANIM) {
				var8 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				if (var8 != var3.sequenceId) {
					var3.sequenceId = var8;
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
					Strings.method4120(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETMODELORTHOG) {
				var3.modelOrthog = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
				Strings.method4120(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXT) {
				String var7 = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
				if (!var7.equals(var3.text)) {
					var3.text = var7;
					Strings.method4120(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTFONT) {
				var3.fontId = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				Strings.method4120(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTALIGN) {
				HealthBarUpdate.Interpreter_intStackSize -= 3;
				var3.textXAlignment = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
				var3.textYAlignment = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
				var3.textLineHeight = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2];
				Strings.method4120(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTSHADOW) {
				var3.textShadowed = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
				Strings.method4120(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETOUTLINE) {
				var3.outline = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				Strings.method4120(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETGRAPHICSHADOW) {
				var3.spriteShadow = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				Strings.method4120(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETVFLIP) {
				var3.spriteFlipV = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
				Strings.method4120(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETHFLIP) {
				var3.spriteFlipH = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
				Strings.method4120(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETSCROLLSIZE) {
				HealthBarUpdate.Interpreter_intStackSize -= 2;
				var3.scrollWidth = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
				var3.scrollHeight = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
				Strings.method4120(var3);
				if (var4 != -1 && var3.type == 0) {
					WorldMapSprite.revalidateWidgetScroll(Widget.Widget_interfaceComponents[var4 >> 16], var3, false);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_RESUME_PAUSEBUTTON) {
				ScriptFrame.method1086(var3.id, var3.childIndex);
				Client.field850 = var3;
				Strings.method4120(var3);
				return 1;
			} else if (var0 == 1122) {
				var3.spriteId = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				Strings.method4120(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLCOLOUR) {
				var3.color2 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				Strings.method4120(var3);
				return 1;
			} else if (var0 == 1124) {
				var3.transparencyBot = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				Strings.method4120(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLMODE) {
				var8 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				class323 var6 = (class323)SoundSystem.findEnumerated(PcmPlayer.method2405(), var8);
				if (var6 != null) {
					var3.fillMode = var6;
					Strings.method4120(var3);
				}

				return 1;
			} else {
				boolean var5;
				if (var0 == ScriptOpcodes.CC_SETLINEDIRECTION) {
					var5 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
					var3.field2598 = var5;
					return 1;
				} else if (var0 == ScriptOpcodes.CC_SETMODELTRANSPARENT) {
					var5 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
					var3.modelTransparency = var5;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}

	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1224050195"
	)
	static final int method1995() {
		if (WorldMapLabelSize.clientPreferences.roofsHidden) {
			return class42.plane;
		} else {
			int var0 = ScriptEvent.getTileHeight(PacketBuffer.cameraX, class1.cameraZ, class42.plane);
			return var0 - class43.cameraY < 800 && (Tiles.Tiles_renderFlags[class42.plane][PacketBuffer.cameraX >> 7][class1.cameraZ >> 7] & 4) != 0 ? class42.plane : 3;
		}
	}
}
