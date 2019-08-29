import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("v")
@Implements("WorldMapIcon_1")
public class WorldMapIcon_1 extends AbstractWorldMapIcon {
	@ObfuscatedName("nj")
	@ObfuscatedSignature(
		signature = "[Lhp;"
	)
	static Widget[] field174;
	@ObfuscatedName("ef")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive17")
	static Archive archive17;
	@ObfuscatedName("jl")
	@ObfuscatedSignature(
		signature = "Lbd;"
	)
	@Export("localPlayer")
	static Player localPlayer;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1136778235
	)
	@Export("objectDefId")
	final int objectDefId;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Laf;"
	)
	@Export("region")
	final WorldMapRegion region;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1028371623
	)
	@Export("element")
	int element;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lai;"
	)
	@Export("label")
	WorldMapLabel label;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1027796521
	)
	@Export("subWidth")
	int subWidth;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1822952027
	)
	@Export("subHeight")
	int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhd;Lhd;ILaf;)V"
	)
	WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
		super(var1, var2);
		this.objectDefId = var3;
		this.region = var4;
		this.init();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "78"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)Lai;",
		garbageValue = "1"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1930584854"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-56"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1614216514"
	)
	@Export("init")
	void init() {
		this.element = class215.getObjectDefinition(this.objectDefId).transform().mapIconId;
		this.label = this.region.createMapLabel(WorldMapData_0.WorldMapElement_get(this.element));
		WorldMapElement var1 = WorldMapData_0.WorldMapElement_get(this.getElement());
		Sprite var2 = var1.getSpriteBool(false);
		if (var2 != null) {
			this.subWidth = var2.subWidth;
			this.subHeight = var2.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1744841172"
	)
	public static int method301(int var0, int var1) {
		int var2;
		if (var1 > var0) {
			var2 = var0;
			var0 = var1;
			var1 = var2;
		}

		while (var1 != 0) {
			var2 = var0 % var1;
			var0 = var1;
			var1 = var2;
		}

		return var0;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(Lby;IB)V",
		garbageValue = "-74"
	)
	@Export("runScript")
	static void runScript(ScriptEvent var0, int var1) {
		Object[] var2 = var0.args;
		Script var3;
		int var17;
		if (DirectByteArrayCopier.isWorldMapEvent(var0.type)) {
			class162.worldMapEvent = (WorldMapEvent)var2[0];
			WorldMapElement var4 = WorldMapData_0.WorldMapElement_get(class162.worldMapEvent.mapElement);
			var3 = class30.getWorldMapScript(var0.type, var4.objectId, var4.category);
		} else {
			var17 = (Integer)var2[0];
			var3 = ArchiveLoader.getScript(var17);
		}

		if (var3 != null) {
			Interpreter.Interpreter_intStackSize = 0;
			Interpreter.Interpreter_stringStackSize = 0;
			var17 = -1;
			int[] var5 = var3.opcodes;
			int[] var6 = var3.intOperands;
			byte var7 = -1;
			Interpreter.Interpreter_frameDepth = 0;
			Interpreter.field1074 = false;

			try {
				int var10;
				try {
					UserComparator1.Interpreter_intLocals = new int[var3.localIntCount];
					int var8 = 0;
					UserComparator1.Interpreter_stringLocals = new String[var3.localStringCount];
					int var9 = 0;

					int var11;
					String var18;
					for (var10 = 1; var10 < var2.length; ++var10) {
						if (var2[var10] instanceof Integer) {
							var11 = (Integer)var2[var10];
							if (var11 == -2147483647) {
								var11 = var0.mouseX;
							}

							if (var11 == -2147483646) {
								var11 = var0.mouseY;
							}

							if (var11 == -2147483645) {
								var11 = var0.widget != null ? var0.widget.id : -1;
							}

							if (var11 == -2147483644) {
								var11 = var0.opIndex;
							}

							if (var11 == -2147483643) {
								var11 = var0.widget != null ? var0.widget.childIndex : -1;
							}

							if (var11 == -2147483642) {
								var11 = var0.dragTarget != null ? var0.dragTarget.id : -1;
							}

							if (var11 == -2147483641) {
								var11 = var0.dragTarget != null ? var0.dragTarget.childIndex : -1;
							}

							if (var11 == -2147483640) {
								var11 = var0.keyTyped;
							}

							if (var11 == -2147483639) {
								var11 = var0.keyPressed;
							}

							UserComparator1.Interpreter_intLocals[var8++] = var11;
						} else if (var2[var10] instanceof String) {
							var18 = (String)var2[var10];
							if (var18.equals("event_opbase")) {
								var18 = var0.targetName;
							}

							UserComparator1.Interpreter_stringLocals[var9++] = var18;
						}
					}

					var10 = 0;
					Interpreter.field1064 = var0.field555;

					while (true) {
						++var10;
						if (var10 > var1) {
							throw new RuntimeException();
						}

						++var17;
						int var29 = var5[var17];
						int var20;
						if (var29 >= 100) {
							boolean var32;
							if (var3.intOperands[var17] == 1) {
								var32 = true;
							} else {
								var32 = false;
							}

							var20 = TileItemPile.method2701(var29, var3, var32);
							switch(var20) {
							case 0:
								return;
							case 1:
							default:
								break;
							case 2:
								throw new IllegalStateException();
							}
						} else if (var29 == 0) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6[var17];
						} else if (var29 == ScriptOpcodes.GET_VARP) {
							var11 = var6[var17];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Varps.Varps_main[var11];
						} else if (var29 == ScriptOpcodes.SET_VARP) {
							var11 = var6[var17];
							Varps.Varps_main[var11] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							ObjectSound.method1837(var11);
						} else if (var29 == ScriptOpcodes.SCONST) {
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.stringOperands[var17];
						} else if (var29 == ScriptOpcodes.JUMP) {
							var17 += var6[var17];
						} else if (var29 == ScriptOpcodes.IF_ICMPNE) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPEQ) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPLT) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPGT) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.RETURN) {
							if (Interpreter.Interpreter_frameDepth == 0) {
								return;
							}

							ScriptFrame var34 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
							var3 = var34.script;
							var5 = var3.opcodes;
							var6 = var3.intOperands;
							var17 = var34.pc;
							UserComparator1.Interpreter_intLocals = var34.intLocals;
							UserComparator1.Interpreter_stringLocals = var34.stringLocals;
						} else if (var29 == ScriptOpcodes.GET_VARBIT) {
							var11 = var6[var17];
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class208.getVarbit(var11);
						} else if (var29 == ScriptOpcodes.SET_VARBIT) {
							var11 = var6[var17];
							MouseHandler.method1040(var11, Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
						} else if (var29 == ScriptOpcodes.IF_ICMPLE) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPGE) {
							Interpreter.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.ILOAD) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = UserComparator1.Interpreter_intLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.ISTORE) {
							UserComparator1.Interpreter_intLocals[var6[var17]] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						} else if (var29 == ScriptOpcodes.SLOAD) {
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = UserComparator1.Interpreter_stringLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.SSTORE) {
							UserComparator1.Interpreter_stringLocals[var6[var17]] = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
						} else if (var29 == ScriptOpcodes.JOIN_STRING) {
							var11 = var6[var17];
							Interpreter.Interpreter_stringStackSize -= var11;
							String var31 = GrandExchangeOfferWorldComparator.method74(Interpreter.Interpreter_stringStack, Interpreter.Interpreter_stringStackSize, var11);
							Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var31;
						} else if (var29 == ScriptOpcodes.POP_INT) {
							--Interpreter.Interpreter_intStackSize;
						} else if (var29 == ScriptOpcodes.POP_STRING) {
							--Interpreter.Interpreter_stringStackSize;
						} else {
							int var15;
							if (var29 != ScriptOpcodes.INVOKE) {
								if (var29 == ScriptOpcodes.GET_VARC_INT) {
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = KeyHandler.varcs.getInt(var6[var17]);
								} else if (var29 == ScriptOpcodes.SET_VARC_INT) {
									KeyHandler.varcs.setInt(var6[var17], Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
								} else if (var29 == ScriptOpcodes.DEFINE_ARRAY) {
									var11 = var6[var17] >> 16;
									var20 = var6[var17] & 65535;
									int var21 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
									if (var21 < 0 || var21 > 5000) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_arrayLengths[var11] = var21;
									byte var22 = -1;
									if (var20 == 105) {
										var22 = 0;
									}

									for (var15 = 0; var15 < var21; ++var15) {
										Interpreter.Interpreter_arrays[var11][var15] = var22;
									}
								} else if (var29 == ScriptOpcodes.GET_ARRAY_INT) {
									var11 = var6[var17];
									var20 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
									if (var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var11][var20];
								} else if (var29 == ScriptOpcodes.SET_ARRAY_INT) {
									var11 = var6[var17];
									Interpreter.Interpreter_intStackSize -= 2;
									var20 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
									if (var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_arrays[var11][var20] = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
								} else if (var29 == ScriptOpcodes.GET_VARC_STRING_OLD) {
									var18 = KeyHandler.varcs.getStringOld(var6[var17]);
									if (var18 == null) {
										var18 = "null";
									}

									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING_OLD) {
									KeyHandler.varcs.setStringOld(var6[var17], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
								} else if (var29 == ScriptOpcodes.GET_VARC_STRING) {
									var18 = KeyHandler.varcs.getString(var6[var17]);
									Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING) {
									KeyHandler.varcs.setString(var6[var17], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
								} else {
									if (var29 != ScriptOpcodes.SWITCH) {
										throw new IllegalStateException();
									}

									IterableNodeHashTable var33 = var3.switches[var6[var17]];
									IntegerNode var30 = (IntegerNode)var33.get((long)Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
									if (var30 != null) {
										var17 += var30.integer;
									}
								}
							} else {
								var11 = var6[var17];
								Script var12 = ArchiveLoader.getScript(var11);
								int[] var13 = new int[var12.localIntCount];
								String[] var14 = new String[var12.localStringCount];

								for (var15 = 0; var15 < var12.intArgumentCount; ++var15) {
									var13[var15] = Interpreter.Interpreter_intStack[var15 + (Interpreter.Interpreter_intStackSize - var12.intArgumentCount)];
								}

								for (var15 = 0; var15 < var12.stringArgumentCount; ++var15) {
									var14[var15] = Interpreter.Interpreter_stringStack[var15 + (Interpreter.Interpreter_stringStackSize - var12.stringArgumentCount)];
								}

								Interpreter.Interpreter_intStackSize -= var12.intArgumentCount;
								Interpreter.Interpreter_stringStackSize -= var12.stringArgumentCount;
								ScriptFrame var19 = new ScriptFrame();
								var19.script = var3;
								var19.pc = var17;
								var19.intLocals = UserComparator1.Interpreter_intLocals;
								var19.stringLocals = UserComparator1.Interpreter_stringLocals;
								Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var19;
								var3 = var12;
								var5 = var12.opcodes;
								var6 = var12.intOperands;
								var17 = -1;
								UserComparator1.Interpreter_intLocals = var13;
								UserComparator1.Interpreter_stringLocals = var14;
							}
						}
					}
				} catch (Exception var27) {
					StringBuilder var24 = new StringBuilder(30);
					var24.append("").append(var3.key).append(" ");

					for (var10 = Interpreter.Interpreter_frameDepth - 1; var10 >= 0; --var10) {
						var24.append("").append(Interpreter.Interpreter_frames[var10].script.key).append(" ");
					}

					var24.append("").append(var7);
					class3.RunException_sendStackTrace(var24.toString(), var27);
				}
			} finally {
				if (Interpreter.field1074) {
					Interpreter.field1072 = true;
					ParamDefinition.method4424();
					Interpreter.field1072 = false;
					Interpreter.field1074 = false;
				}

			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lky;IB)V",
		garbageValue = "-54"
	)
	public static void method295(Buffer var0, int var1) {
		if (JagexCache.JagexCache_randomDat != null) {
			try {
				JagexCache.JagexCache_randomDat.seek(0L);
				JagexCache.JagexCache_randomDat.write(var0.array, var1, 24);
			} catch (Exception var3) {
			}
		}

	}

	@ObfuscatedName("fp")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-60"
	)
	static final void method294() {
		int var0 = GraphicsObject.field1079 * 128 + 64;
		int var1 = class3.field24 * 128 + 64;
		int var2 = GrandExchangeOfferTotalQuantityComparator.getTileHeight(var0, var1, ItemContainer.plane) - WorldMapSection0.field129;
		if (WallDecoration.cameraX < var0) {
			WallDecoration.cameraX = (var0 - WallDecoration.cameraX) * WorldMapSection2.field191 / 1000 + WallDecoration.cameraX + WorldMapSectionType.field142;
			if (WallDecoration.cameraX > var0) {
				WallDecoration.cameraX = var0;
			}
		}

		if (WallDecoration.cameraX > var0) {
			WallDecoration.cameraX -= WorldMapSection2.field191 * (WallDecoration.cameraX - var0) / 1000 + WorldMapSectionType.field142;
			if (WallDecoration.cameraX < var0) {
				WallDecoration.cameraX = var0;
			}
		}

		if (Coord.cameraY < var2) {
			Coord.cameraY = (var2 - Coord.cameraY) * WorldMapSection2.field191 / 1000 + Coord.cameraY + WorldMapSectionType.field142;
			if (Coord.cameraY > var2) {
				Coord.cameraY = var2;
			}
		}

		if (Coord.cameraY > var2) {
			Coord.cameraY -= WorldMapSection2.field191 * (Coord.cameraY - var2) / 1000 + WorldMapSectionType.field142;
			if (Coord.cameraY < var2) {
				Coord.cameraY = var2;
			}
		}

		if (UserComparator7.cameraZ < var1) {
			UserComparator7.cameraZ = (var1 - UserComparator7.cameraZ) * WorldMapSection2.field191 / 1000 + UserComparator7.cameraZ + WorldMapSectionType.field142;
			if (UserComparator7.cameraZ > var1) {
				UserComparator7.cameraZ = var1;
			}
		}

		if (UserComparator7.cameraZ > var1) {
			UserComparator7.cameraZ -= WorldMapSection2.field191 * (UserComparator7.cameraZ - var1) / 1000 + WorldMapSectionType.field142;
			if (UserComparator7.cameraZ < var1) {
				UserComparator7.cameraZ = var1;
			}
		}

		var0 = WorldMapSection2.field190 * 16384 + 64;
		var1 = UrlRequest.field1932 * 128 + 64;
		var2 = GrandExchangeOfferTotalQuantityComparator.getTileHeight(var0, var1, ItemContainer.plane) - GameShell.field446;
		int var3 = var0 - WallDecoration.cameraX;
		int var4 = var2 - Coord.cameraY;
		int var5 = var1 - UserComparator7.cameraZ;
		int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
		int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
		int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
		if (var7 < 128) {
			var7 = 128;
		}

		if (var7 > 383) {
			var7 = 383;
		}

		if (class43.cameraPitch < var7) {
			class43.cameraPitch = (var7 - class43.cameraPitch) * Player.field605 / 1000 + class43.cameraPitch + GrandExchangeOfferWorldComparator.field34;
			if (class43.cameraPitch > var7) {
				class43.cameraPitch = var7;
			}
		}

		if (class43.cameraPitch > var7) {
			class43.cameraPitch -= Player.field605 * (class43.cameraPitch - var7) / 1000 + GrandExchangeOfferWorldComparator.field34;
			if (class43.cameraPitch < var7) {
				class43.cameraPitch = var7;
			}
		}

		int var9 = var8 - class40.cameraYaw;
		if (var9 > 1024) {
			var9 -= 2048;
		}

		if (var9 < -1024) {
			var9 += 2048;
		}

		if (var9 > 0) {
			class40.cameraYaw = var9 * Player.field605 / 1000 + class40.cameraYaw + GrandExchangeOfferWorldComparator.field34;
			class40.cameraYaw &= 2047;
		}

		if (var9 < 0) {
			class40.cameraYaw -= GrandExchangeOfferWorldComparator.field34 + -var9 * Player.field605 / 1000;
			class40.cameraYaw &= 2047;
		}

		int var10 = var8 - class40.cameraYaw;
		if (var10 > 1024) {
			var10 -= 2048;
		}

		if (var10 < -1024) {
			var10 += 2048;
		}

		if (var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
			class40.cameraYaw = var8;
		}

	}
}
