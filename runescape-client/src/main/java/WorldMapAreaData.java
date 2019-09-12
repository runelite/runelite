import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("af")
@Implements("WorldMapAreaData")
public class WorldMapAreaData extends WorldMapArea {
	@ObfuscatedName("f")
	@Export("worldMapData0Set")
	HashSet worldMapData0Set;
	@ObfuscatedName("s")
	@Export("worldMapData1Set")
	HashSet worldMapData1Set;
	@ObfuscatedName("p")
	@Export("iconList")
	List iconList;

	WorldMapAreaData() {
	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		signature = "(Lkz;Lkz;IZI)V",
		garbageValue = "419518570"
	)
	@Export("init")
	void init(Buffer var1, Buffer var2, int var3, boolean var4) {
		this.read(var1, var3);
		int var5 = var2.readUnsignedShort();
		this.worldMapData0Set = new HashSet(var5);

		int var6;
		for (var6 = 0; var6 < var5; ++var6) {
			WorldMapData_0 var7 = new WorldMapData_0();

			try {
				var7.init(var2);
			} catch (IllegalStateException var12) {
				continue;
			}

			this.worldMapData0Set.add(var7);
		}

		var6 = var2.readUnsignedShort();
		this.worldMapData1Set = new HashSet(var6);

		for (int var10 = 0; var10 < var6; ++var10) {
			WorldMapData_1 var8 = new WorldMapData_1();

			try {
				var8.init(var2);
			} catch (IllegalStateException var11) {
				continue;
			}

			this.worldMapData1Set.add(var8);
		}

		this.initIconsList(var2, var4);
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		signature = "(Lkz;ZI)V",
		garbageValue = "-889272811"
	)
	@Export("initIconsList")
	void initIconsList(Buffer var1, boolean var2) {
		this.iconList = new LinkedList();
		int var3 = var1.readUnsignedShort();

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = var1.method5623();
			Coord var6 = new Coord(var1.readInt());
			boolean var7 = var1.readUnsignedByte() == 1;
			if (var2 || !var7) {
				this.iconList.add(new WorldMapIcon_0((Coord)null, var6, var5, (WorldMapLabel)null));
			}
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIIIIII)I",
		garbageValue = "1344959877"
	)
	public static int method673(int var0, int var1, int var2, int var3, int var4, int var5) {
		if ((var5 & 1) == 1) {
			int var6 = var3;
			var3 = var4;
			var4 = var6;
		}

		var2 &= 3;
		if (var2 == 0) {
			return var0;
		} else if (var2 == 1) {
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 - (var3 - 1) : 7 - var1 - (var4 - 1);
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "76"
	)
	static int method670(int var0, Script var1, boolean var2) {
		if (var0 < 1000) {
			return TileItem.method2091(var0, var1, var2);
		} else if (var0 < 1100) {
			return WorldMapManager.method626(var0, var1, var2);
		} else if (var0 < 1200) {
			return method668(var0, var1, var2);
		} else if (var0 < 1300) {
			return WorldMapLabelSize.method166(var0, var1, var2);
		} else if (var0 < 1400) {
			return WorldMapData_1.method705(var0, var1, var2);
		} else if (var0 < 1500) {
			return class216.method4015(var0, var1, var2);
		} else if (var0 < 1600) {
			return WorldMapRectangle.method255(var0, var1, var2);
		} else if (var0 < 1700) {
			return ModelData0.method3221(var0, var1, var2);
		} else if (var0 < 1800) {
			return PlayerAppearance.method3990(var0, var1, var2);
		} else if (var0 < 1900) {
			return AbstractWorldMapIcon.method576(var0, var1, var2);
		} else if (var0 < 2000) {
			return ArchiveLoader.method1096(var0, var1, var2);
		} else if (var0 < 2100) {
			return WorldMapManager.method626(var0, var1, var2);
		} else if (var0 < 2200) {
			return method668(var0, var1, var2);
		} else if (var0 < 2300) {
			return WorldMapLabelSize.method166(var0, var1, var2);
		} else if (var0 < 2400) {
			return WorldMapData_1.method705(var0, var1, var2);
		} else if (var0 < 2500) {
			return class216.method4015(var0, var1, var2);
		} else if (var0 < 2600) {
			return ModelData0.method3219(var0, var1, var2);
		} else if (var0 < 2700) {
			return class16.method162(var0, var1, var2);
		} else if (var0 < 2800) {
			return PlayerType.method4121(var0, var1, var2);
		} else if (var0 < 2900) {
			return class51.method861(var0, var1, var2);
		} else if (var0 < 3000) {
			return ArchiveLoader.method1096(var0, var1, var2);
		} else if (var0 < 3200) {
			return Messages.method2194(var0, var1, var2);
		} else if (var0 < 3300) {
			return FloorUnderlayDefinition.method4423(var0, var1, var2);
		} else if (var0 < 3400) {
			return class226.method4109(var0, var1, var2);
		} else if (var0 < 3500) {
			return DevicePcmPlayerProvider.method809(var0, var1, var2);
		} else if (var0 < 3700) {
			return WorldMapData_1.method702(var0, var1, var2);
		} else if (var0 < 4000) {
			return Clock.method3490(var0, var1, var2);
		} else if (var0 < 4100) {
			return HealthBar.method2006(var0, var1, var2);
		} else if (var0 < 4200) {
			return class49.method829(var0, var1, var2);
		} else if (var0 < 4300) {
			return MusicPatchNode2.method3666(var0, var1, var2);
		} else if (var0 < 5100) {
			return class218.method4091(var0, var1, var2);
		} else if (var0 < 5400) {
			return World.method1762(var0, var1, var2);
		} else if (var0 < 5600) {
			return SequenceDefinition.method4799(var0, var1, var2);
		} else if (var0 < 5700) {
			return HealthBar.method1999(var0, var1, var2);
		} else if (var0 < 6300) {
			return Decimator.method2494(var0, var1, var2);
		} else if (var0 < 6600) {
			return GrandExchangeOffer.method103(var0, var1, var2);
		} else {
			return var0 < 6700 ? ObjectSound.method1884(var0, var1, var2) : 2;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ILcu;ZS)I",
		garbageValue = "-53"
	)
	static int method668(int var0, Script var1, boolean var2) {
		int var4 = -1;
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			var3 = Player.getWidget(var4);
		} else {
			var3 = var2 ? UserComparator9.field1941 : MidiPcmStream.field2410;
		}

		if (var0 == ScriptOpcodes.CC_SETSCROLLPOS) {
			class160.Interpreter_intStackSize -= 2;
			var3.scrollX = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			if (var3.scrollX > var3.scrollWidth - var3.width) {
				var3.scrollX = var3.scrollWidth - var3.width;
			}

			if (var3.scrollX < 0) {
				var3.scrollX = 0;
			}

			var3.scrollY = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			if (var3.scrollY > var3.scrollHeight - var3.height) {
				var3.scrollY = var3.scrollHeight - var3.height;
			}

			if (var3.scrollY < 0) {
				var3.scrollY = 0;
			}

			WorldMapID.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETCOLOUR) {
			var3.color = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			WorldMapID.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETFILL) {
			var3.fill = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
			WorldMapID.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTRANS) {
			var3.transparencyTop = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			WorldMapID.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETLINEWID) {
			var3.lineWid = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			WorldMapID.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETGRAPHIC) {
			var3.spriteId2 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			WorldMapID.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SET2DANGLE) {
			var3.spriteAngle = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			WorldMapID.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETTILING) {
			var3.spriteTiling = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
			WorldMapID.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODEL) {
			var3.modelType = 1;
			var3.modelId = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			WorldMapID.invalidateWidget(var3);
			return 1;
		} else if (var0 == ScriptOpcodes.CC_SETMODELANGLE) {
			class160.Interpreter_intStackSize -= 6;
			var3.modelOffsetX = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			var3.modelOffsetY = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			var3.modelAngleX = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 2];
			var3.modelAngleY = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 3];
			var3.modelAngleZ = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 4];
			var3.modelZoom = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 5];
			WorldMapID.invalidateWidget(var3);
			return 1;
		} else {
			int var8;
			if (var0 == ScriptOpcodes.CC_SETMODELANIM) {
				var8 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				if (var8 != var3.sequenceId) {
					var3.sequenceId = var8;
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
					WorldMapID.invalidateWidget(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETMODELORTHOG) {
				var3.modelOrthog = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
				WorldMapID.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXT) {
				String var7 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
				if (!var7.equals(var3.text)) {
					var3.text = var7;
					WorldMapID.invalidateWidget(var3);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTFONT) {
				var3.fontId = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				WorldMapID.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTALIGN) {
				class160.Interpreter_intStackSize -= 3;
				var3.textXAlignment = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
				var3.textYAlignment = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
				var3.textLineHeight = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 2];
				WorldMapID.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTEXTSHADOW) {
				var3.textShadowed = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
				WorldMapID.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETOUTLINE) {
				var3.outline = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				WorldMapID.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETGRAPHICSHADOW) {
				var3.spriteShadow = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				WorldMapID.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETVFLIP) {
				var3.spriteFlipV = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
				WorldMapID.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETHFLIP) {
				var3.spriteFlipH = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
				WorldMapID.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETSCROLLSIZE) {
				class160.Interpreter_intStackSize -= 2;
				var3.scrollWidth = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
				var3.scrollHeight = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
				WorldMapID.invalidateWidget(var3);
				if (var4 != -1 && var3.type == 0) {
					class197.revalidateWidgetScroll(class289.Widget_interfaceComponents[var4 >> 16], var3, false);
				}

				return 1;
			} else if (var0 == ScriptOpcodes.CC_RESUME_PAUSEBUTTON) {
				WorldMapSection1.resumePauseWidget(var3.id, var3.childIndex);
				Client.meslayerContinueWidget = var3;
				WorldMapID.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1122) {
				var3.spriteId = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				WorldMapID.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLCOLOUR) {
				var3.color2 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				WorldMapID.invalidateWidget(var3);
				return 1;
			} else if (var0 == 1124) {
				var3.transparencyBot = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				WorldMapID.invalidateWidget(var3);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETFILLMODE) {
				var8 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				FillMode var6 = (FillMode)ServerPacket.findEnumerated(class227.FillMode_values(), var8);
				if (var6 != null) {
					var3.fillMode = var6;
					WorldMapID.invalidateWidget(var3);
				}

				return 1;
			} else {
				boolean var5;
				if (var0 == ScriptOpcodes.CC_SETLINEDIRECTION) {
					var5 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
					var3.field2675 = var5;
					return 1;
				} else if (var0 == ScriptOpcodes.CC_SETMODELTRANSPARENT) {
					var5 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
					var3.modelTransparency = var5;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IIIIIIII)Z",
		garbageValue = "-1111796932"
	)
	static final boolean method671(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7 = ViewportMouse.ViewportMouse_y + var6;
		if (var7 < var0 && var7 < var1 && var7 < var2) {
			return false;
		} else {
			var7 = ViewportMouse.ViewportMouse_y - var6;
			if (var7 > var0 && var7 > var1 && var7 > var2) {
				return false;
			} else {
				var7 = ViewportMouse.ViewportMouse_x + var6;
				if (var7 < var3 && var7 < var4 && var7 < var5) {
					return false;
				} else {
					var7 = ViewportMouse.ViewportMouse_x - var6;
					return var7 <= var3 || var7 <= var4 || var7 <= var5;
				}
			}
		}
	}

	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "588671931"
	)
	@Export("getTileHeight")
	static final int getTileHeight(int var0, int var1, int var2) {
		int var3 = var0 >> 7;
		int var4 = var1 >> 7;
		if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
			int var5 = var2;
			if (var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
				var5 = var2 + 1;
			}

			int var6 = var0 & 127;
			int var7 = var1 & 127;
			int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4] + var6 * Tiles.Tiles_heights[var5][var3 + 1][var4] >> 7;
			int var9 = var6 * Tiles.Tiles_heights[var5][var3 + 1][var4 + 1] + Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) >> 7;
			return var8 * (128 - var7) + var9 * var7 >> 7;
		} else {
			return 0;
		}
	}
}
