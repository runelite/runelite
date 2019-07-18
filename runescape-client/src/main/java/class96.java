import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cv")
public class class96 {
	@ObfuscatedName("qm")
	@ObfuscatedGetter(
		intValue = 164873785
	)
	static int field1327;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("reflectionChecks")
	static IterableNodeDeque reflectionChecks;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	static Bounds field1325;

	static {
		reflectionChecks = new IterableNodeDeque();
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lbb;II)V",
		garbageValue = "-806238798"
	)
	@Export("runScript")
	static void runScript(ScriptEvent var0, int var1) {
		Object[] var2 = var0.args;
		Script var3;
		int var17;
		if (PacketBufferNode.isWorldMapEvent(var0.type)) {
			WorldMapIcon_0.worldMapEvent = (WorldMapEvent)var2[0];
			WorldMapElement var4 = class222.getWorldMapElement(WorldMapIcon_0.worldMapEvent.mapElement);
			var3 = ObjectSound.getWorldMapScript(var0.type, var4.objectId, var4.category);
		} else {
			var17 = (Integer)var2[0];
			var3 = ViewportMouse.getScript(var17);
		}

		if (var3 != null) {
			HealthBarUpdate.Interpreter_intStackSize = 0;
			Skills.Interpreter_stringStackSize = 0;
			var17 = -1;
			int[] var5 = var3.opcodes;
			int[] var6 = var3.intOperands;
			byte var7 = -1;
			Interpreter.Interpreter_frameDepth = 0;
			Interpreter.field1104 = false;

			try {
				int var10;
				try {
					Interpreter.Interpreter_intLocals = new int[var3.localIntCount];
					int var8 = 0;
					GZipDecompressor.Interpreter_stringLocals = new String[var3.localStringCount];
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

							Interpreter.Interpreter_intLocals[var8++] = var11;
						} else if (var2[var10] instanceof String) {
							var18 = (String)var2[var10];
							if (var18.equals("event_opbase")) {
								var18 = var0.targetName;
							}

							GZipDecompressor.Interpreter_stringLocals[var9++] = var18;
						}
					}

					var10 = 0;
					Interpreter.field1106 = var0.field583;

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

							var20 = NPC.method1977(var29, var3, var32);
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
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var6[var17];
						} else if (var29 == ScriptOpcodes.GET_VARP) {
							var11 = var6[var17];
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Varps.Varps_main[var11];
						} else if (var29 == ScriptOpcodes.SET_VARP) {
							var11 = var6[var17];
							Varps.Varps_main[var11] = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
							GrandExchangeOfferUnitPriceComparator.method124(var11);
						} else if (var29 == ScriptOpcodes.SCONST) {
							Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var3.stringOperands[var17];
						} else if (var29 == ScriptOpcodes.JUMP) {
							var17 += var6[var17];
						} else if (var29 == ScriptOpcodes.IF_ICMPNE) {
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPEQ) {
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPLT) {
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPGT) {
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1]) {
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
							Interpreter.Interpreter_intLocals = var34.intLocals;
							GZipDecompressor.Interpreter_stringLocals = var34.stringLocals;
						} else if (var29 == ScriptOpcodes.GET_VARBIT) {
							var11 = var6[var17];
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = GrandExchangeOfferOwnWorldComparator.getVarbit(var11);
						} else if (var29 == ScriptOpcodes.SET_VARBIT) {
							var11 = var6[var17];
							NetSocket.method3554(var11, Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize]);
						} else if (var29 == ScriptOpcodes.IF_ICMPLE) {
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPGE) {
							HealthBarUpdate.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.ILOAD) {
							Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Interpreter.Interpreter_intLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.ISTORE) {
							Interpreter.Interpreter_intLocals[var6[var17]] = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						} else if (var29 == ScriptOpcodes.SLOAD) {
							Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = GZipDecompressor.Interpreter_stringLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.SSTORE) {
							GZipDecompressor.Interpreter_stringLocals[var6[var17]] = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
						} else if (var29 == ScriptOpcodes.JOIN_STRING) {
							var11 = var6[var17];
							Skills.Interpreter_stringStackSize -= var11;
							String var31 = Timer.method5015(Interpreter.Interpreter_stringStack, Skills.Interpreter_stringStackSize, var11);
							Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var31;
						} else if (var29 == ScriptOpcodes.POP_INT) {
							--HealthBarUpdate.Interpreter_intStackSize;
						} else if (var29 == ScriptOpcodes.POP_STRING) {
							--Skills.Interpreter_stringStackSize;
						} else {
							int var15;
							if (var29 != ScriptOpcodes.INVOKE) {
								if (var29 == ScriptOpcodes.GET_VARC_INT) {
									Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Clock.varcs.getInt(var6[var17]);
								} else if (var29 == ScriptOpcodes.SET_VARC_INT) {
									Clock.varcs.setInt(var6[var17], Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize]);
								} else if (var29 == ScriptOpcodes.DEFINE_ARRAY) {
									var11 = var6[var17] >> 16;
									var20 = var6[var17] & 65535;
									int var21 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
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
									var20 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
									if (var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var11][var20];
								} else if (var29 == ScriptOpcodes.SET_ARRAY_INT) {
									var11 = var6[var17];
									HealthBarUpdate.Interpreter_intStackSize -= 2;
									var20 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
									if (var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_arrays[var11][var20] = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
								} else if (var29 == ScriptOpcodes.GET_VARC_STRING_OLD) {
									var18 = Clock.varcs.getStringOld(var6[var17]);
									if (var18 == null) {
										var18 = "null";
									}

									Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING_OLD) {
									Clock.varcs.setStringOld(var6[var17], Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize]);
								} else if (var29 == ScriptOpcodes.GET_VARC_STRING) {
									var18 = Clock.varcs.getString(var6[var17]);
									Interpreter.Interpreter_stringStack[++Skills.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING) {
									Clock.varcs.setString(var6[var17], Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize]);
								} else {
									if (var29 != ScriptOpcodes.SWITCH) {
										throw new IllegalStateException();
									}

									IterableNodeHashTable var33 = var3.switches[var6[var17]];
									IntegerNode var30 = (IntegerNode)var33.get((long)Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize]);
									if (var30 != null) {
										var17 += var30.integer;
									}
								}
							} else {
								var11 = var6[var17];
								Script var12 = ViewportMouse.getScript(var11);
								int[] var13 = new int[var12.localIntCount];
								String[] var14 = new String[var12.localStringCount];

								for (var15 = 0; var15 < var12.intArgumentCount; ++var15) {
									var13[var15] = Interpreter.Interpreter_intStack[var15 + (HealthBarUpdate.Interpreter_intStackSize - var12.intArgumentCount)];
								}

								for (var15 = 0; var15 < var12.stringArgumentCount; ++var15) {
									var14[var15] = Interpreter.Interpreter_stringStack[var15 + (Skills.Interpreter_stringStackSize - var12.stringArgumentCount)];
								}

								HealthBarUpdate.Interpreter_intStackSize -= var12.intArgumentCount;
								Skills.Interpreter_stringStackSize -= var12.stringArgumentCount;
								ScriptFrame var19 = new ScriptFrame();
								var19.script = var3;
								var19.pc = var17;
								var19.intLocals = Interpreter.Interpreter_intLocals;
								var19.stringLocals = GZipDecompressor.Interpreter_stringLocals;
								Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var19;
								var3 = var12;
								var5 = var12.opcodes;
								var6 = var12.intOperands;
								var17 = -1;
								Interpreter.Interpreter_intLocals = var13;
								GZipDecompressor.Interpreter_stringLocals = var14;
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
					HitSplatDefinition.sendStackTrace(var24.toString(), var27);
				}
			} finally {
				if (Interpreter.field1104) {
					Interpreter.field1105 = true;
					GrandExchangeEvent.method73();
					Interpreter.field1105 = false;
					Interpreter.field1104 = false;
				}

			}
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-2113880295"
	)
	public static boolean method2266(int var0) {
		return (var0 >> 21 & 1) != 0;
	}

	@ObfuscatedName("ei")
	@ObfuscatedSignature(
		signature = "(IS)V",
		garbageValue = "-12345"
	)
	@Export("updateGameState")
	static void updateGameState(int var0) {
		if (var0 != Client.gameState) {
			if (Client.gameState == 0) {
				WorldMapSprite.client.method885();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45) {
				Client.loginState = 0;
				Client.field687 = 0;
				Client.field688 = 0;
				Client.timer.method4996(var0);
				if (var0 != 20) {
					GrandExchangeOffer.method99(false);
				}
			}

			if (var0 != 20 && var0 != 40 && class269.field3563 != null) {
				class269.field3563.close();
				class269.field3563 = null;
			}

			if (Client.gameState == 25) {
				Client.field709 = 0;
				Client.field705 = 0;
				Client.field706 = 1;
				Client.field707 = 0;
				Client.field896 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					BufferedSource.method5892(WorldMapLabelSize.archive10, Client.archive8, true, Client.gameState == 11 ? 4 : 0);
				} else if (var0 == 11) {
					BufferedSource.method5892(WorldMapLabelSize.archive10, Client.archive8, false, 4);
				} else if (Login.field1179) {
					Login.titleboxSprite = null;
					VarpDefinition.titlebuttonSprite = null;
					Login.runesSprite = null;
					GrandExchangeOfferWorldComparator.leftTitleSprite = null;
					NPC.rightTitleSprite = null;
					GroundItem.logoSprite = null;
					Login.title_muteSprite = null;
					Login.options_buttons_0Sprite = null;
					Decimator.options_buttons_2Sprite = null;
					WorldMapID.worldSelectBackSprites = null;
					SecureRandomCallable.worldSelectFlagSprites = null;
					class225.worldSelectArrows = null;
					FriendSystem.worldSelectStars = null;
					class30.field264 = null;
					Ignored.loginScreenRunesAnimation.method1720();
					class40.method729(2);
					if (NetCache.NetCache_socket != null) {
						try {
							Buffer var1 = new Buffer(4);
							var1.writeByte(2);
							var1.writeMedium(0);
							NetCache.NetCache_socket.write(var1.array, 0, 4);
						} catch (IOException var4) {
							try {
								NetCache.NetCache_socket.close();
							} catch (Exception var3) {
							}

							++NetCache.NetCache_ioExceptions;
							NetCache.NetCache_socket = null;
						}
					}

					Login.field1179 = false;
				}
			} else {
				BufferedSource.method5892(WorldMapLabelSize.archive10, Client.archive8, true, 0);
			}

			Client.gameState = var0;
		}
	}
}
