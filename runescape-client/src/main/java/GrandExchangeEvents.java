import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("e")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
	@ObfuscatedName("nn")
	@ObfuscatedGetter(
		intValue = -1329032007
	)
	static int field31;
	@ObfuscatedName("i")
	@Export("GrandExchangeEvents_ageComparator")
	public static Comparator GrandExchangeEvents_ageComparator;
	@ObfuscatedName("y")
	@Export("GrandExchangeEvents_priceComparator")
	public static Comparator GrandExchangeEvents_priceComparator;
	@ObfuscatedName("w")
	@Export("GrandExchangeEvents_nameComparator")
	public static Comparator GrandExchangeEvents_nameComparator;
	@ObfuscatedName("p")
	@Export("GrandExchangeEvents_quantityComparator")
	public static Comparator GrandExchangeEvents_quantityComparator;
	@ObfuscatedName("f")
	@Export("events")
	public final List events;

	static {
		GrandExchangeEvents_ageComparator = new GrandExchangeOfferAgeComparator();
		new GrandExchangeOfferWorldComparator();
		GrandExchangeEvents_priceComparator = new GrandExchangeOfferUnitPriceComparator();
		GrandExchangeEvents_nameComparator = new GrandExchangeOfferNameComparator();
		GrandExchangeEvents_quantityComparator = new GrandExchangeOfferTotalQuantityComparator();
	}

	@ObfuscatedSignature(
		signature = "(Lkq;Z)V",
		garbageValue = "1"
	)
	public GrandExchangeEvents(Buffer var1, boolean var2) {
		int var3 = var1.readUnsignedShort();
		boolean var4 = var1.readUnsignedByte() == 1;
		byte var5;
		if (var4) {
			var5 = 1;
		} else {
			var5 = 0;
		}

		int var6 = var1.readUnsignedShort();
		this.events = new ArrayList(var6);

		for (int var7 = 0; var7 < var6; ++var7) {
			this.events.add(new GrandExchangeEvent(var1, var5, var3));
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;ZB)V",
		garbageValue = "30"
	)
	@Export("sort")
	public void sort(Comparator var1, boolean var2) {
		if (var2) {
			Collections.sort(this.events, var1);
		} else {
			Collections.sort(this.events, Collections.reverseOrder(var1));
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lbm;II)V",
		garbageValue = "-1987798280"
	)
	@Export("runScript")
	static void runScript(ScriptEvent var0, int var1) {
		Object[] var2 = var0.args;
		Script var3;
		int var17;
		if (HorizontalAlignment.isWorldMapEvent(var0.type)) {
			WorldMapLabel.worldMapEvent = (WorldMapEvent)var2[0];
			WorldMapElement var4 = GrandExchangeOfferUnitPriceComparator.WorldMapElement_get(WorldMapLabel.worldMapEvent.mapElement);
			var3 = class16.getWorldMapScript(var0.type, var4.objectId, var4.category);
		} else {
			var17 = (Integer)var2[0];
			var3 = SecureRandomCallable.getScript(var17);
		}

		if (var3 != null) {
			class188.Interpreter_intStackSize = 0;
			class65.Interpreter_stringStackSize = 0;
			var17 = -1;
			int[] var5 = var3.opcodes;
			int[] var6 = var3.intOperands;
			byte var7 = -1;
			Interpreter.Interpreter_frameDepth = 0;
			Interpreter.field1077 = false;

			try {
				int var10;
				try {
					Interpreter.Interpreter_intLocals = new int[var3.localIntCount];
					int var8 = 0;
					class247.Interpreter_stringLocals = new String[var3.localStringCount];
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

							class247.Interpreter_stringLocals[var9++] = var18;
						}
					}

					var10 = 0;
					Interpreter.field1079 = var0.field557;

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

							var20 = Frames.method3281(var29, var3, var32);
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
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var6[var17];
						} else if (var29 == ScriptOpcodes.GET_VARP) {
							var11 = var6[var17];
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Varps.Varps_main[var11];
						} else if (var29 == ScriptOpcodes.SET_VARP) {
							var11 = var6[var17];
							Varps.Varps_main[var11] = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
							BufferedSink.changeGameOptions(var11);
						} else if (var29 == ScriptOpcodes.SCONST) {
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3.stringOperands[var17];
						} else if (var29 == ScriptOpcodes.JUMP) {
							var17 += var6[var17];
						} else if (var29 == ScriptOpcodes.IF_ICMPNE) {
							class188.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPEQ) {
							class188.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPLT) {
							class188.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPGT) {
							class188.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]) {
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
							class247.Interpreter_stringLocals = var34.stringLocals;
						} else if (var29 == ScriptOpcodes.GET_VARBIT) {
							var11 = var6[var17];
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = GameShell.getVarbit(var11);
						} else if (var29 == ScriptOpcodes.SET_VARBIT) {
							var11 = var6[var17];
							ChatChannel.method2259(var11, Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
						} else if (var29 == ScriptOpcodes.IF_ICMPLE) {
							class188.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.IF_ICMPGE) {
							class188.Interpreter_intStackSize -= 2;
							if (Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1]) {
								var17 += var6[var17];
							}
						} else if (var29 == ScriptOpcodes.ILOAD) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Interpreter.Interpreter_intLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.ISTORE) {
							Interpreter.Interpreter_intLocals[var6[var17]] = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						} else if (var29 == ScriptOpcodes.SLOAD) {
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = class247.Interpreter_stringLocals[var6[var17]];
						} else if (var29 == ScriptOpcodes.SSTORE) {
							class247.Interpreter_stringLocals[var6[var17]] = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
						} else if (var29 == ScriptOpcodes.JOIN_STRING) {
							var11 = var6[var17];
							class65.Interpreter_stringStackSize -= var11;
							String var31 = User.method5086(Interpreter.Interpreter_stringStack, class65.Interpreter_stringStackSize, var11);
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var31;
						} else if (var29 == ScriptOpcodes.POP_INT) {
							--class188.Interpreter_intStackSize;
						} else if (var29 == ScriptOpcodes.POP_STRING) {
							--class65.Interpreter_stringStackSize;
						} else {
							int var15;
							if (var29 != ScriptOpcodes.INVOKE) {
								if (var29 == ScriptOpcodes.GET_VARC_INT) {
									Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = MilliClock.varcs.getInt(var6[var17]);
								} else if (var29 == ScriptOpcodes.SET_VARC_INT) {
									MilliClock.varcs.setInt(var6[var17], Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
								} else if (var29 == ScriptOpcodes.DEFINE_ARRAY) {
									var11 = var6[var17] >> 16;
									var20 = var6[var17] & 65535;
									int var21 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
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
									var20 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
									if (var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var11][var20];
								} else if (var29 == ScriptOpcodes.SET_ARRAY_INT) {
									var11 = var6[var17];
									class188.Interpreter_intStackSize -= 2;
									var20 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
									if (var20 < 0 || var20 >= Interpreter.Interpreter_arrayLengths[var11]) {
										throw new RuntimeException();
									}

									Interpreter.Interpreter_arrays[var11][var20] = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
								} else if (var29 == ScriptOpcodes.GET_VARC_STRING_OLD) {
									var18 = MilliClock.varcs.getStringOld(var6[var17]);
									if (var18 == null) {
										var18 = "null";
									}

									Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING_OLD) {
									MilliClock.varcs.setStringOld(var6[var17], Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize]);
								} else if (var29 == ScriptOpcodes.GET_VARC_STRING) {
									var18 = MilliClock.varcs.getString(var6[var17]);
									Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var18;
								} else if (var29 == ScriptOpcodes.SET_VARC_STRING) {
									MilliClock.varcs.setString(var6[var17], Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize]);
								} else {
									if (var29 != ScriptOpcodes.SWITCH) {
										throw new IllegalStateException();
									}

									IterableNodeHashTable var33 = var3.switches[var6[var17]];
									IntegerNode var30 = (IntegerNode)var33.get((long)Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize]);
									if (var30 != null) {
										var17 += var30.integer;
									}
								}
							} else {
								var11 = var6[var17];
								Script var12 = SecureRandomCallable.getScript(var11);
								int[] var13 = new int[var12.localIntCount];
								String[] var14 = new String[var12.localStringCount];

								for (var15 = 0; var15 < var12.intArgumentCount; ++var15) {
									var13[var15] = Interpreter.Interpreter_intStack[var15 + (class188.Interpreter_intStackSize - var12.intArgumentCount)];
								}

								for (var15 = 0; var15 < var12.stringArgumentCount; ++var15) {
									var14[var15] = Interpreter.Interpreter_stringStack[var15 + (class65.Interpreter_stringStackSize - var12.stringArgumentCount)];
								}

								class188.Interpreter_intStackSize -= var12.intArgumentCount;
								class65.Interpreter_stringStackSize -= var12.stringArgumentCount;
								ScriptFrame var19 = new ScriptFrame();
								var19.script = var3;
								var19.pc = var17;
								var19.intLocals = Interpreter.Interpreter_intLocals;
								var19.stringLocals = class247.Interpreter_stringLocals;
								Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var19;
								var3 = var12;
								var5 = var12.opcodes;
								var6 = var12.intOperands;
								var17 = -1;
								Interpreter.Interpreter_intLocals = var13;
								class247.Interpreter_stringLocals = var14;
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
					DesktopPlatformInfoProvider.RunException_sendStackTrace(var24.toString(), var27);
				}
			} finally {
				if (Interpreter.field1077) {
					Interpreter.field1078 = true;
					Clock.method3488();
					Interpreter.field1078 = false;
					Interpreter.field1077 = false;
				}

			}
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-146870643"
	)
	@Export("ItemContainer_getCount")
	static int ItemContainer_getCount(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return 0;
		} else {
			return var1 >= 0 && var1 < var2.quantities.length ? var2.quantities[var1] : 0;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(CB)Z",
		garbageValue = "0"
	)
	static boolean method76(char var0) {
		for (int var1 = 0; var1 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var1) {
			if (var0 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var1)) {
				return true;
			}
		}

		return false;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "1983355550"
	)
	static int method72(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == ScriptOpcodes.ADD) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var4 + var3;
			return 1;
		} else if (var0 == ScriptOpcodes.SUB) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3 - var4;
			return 1;
		} else if (var0 == ScriptOpcodes.MULTIPLY) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3 * var4;
			return 1;
		} else if (var0 == ScriptOpcodes.DIV) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3 / var4;
			return 1;
		} else if (var0 == ScriptOpcodes.RANDOM) {
			var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)var3);
			return 1;
		} else if (var0 == ScriptOpcodes.RANDOMINC) {
			var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
			return 1;
		} else if (var0 == ScriptOpcodes.INTERPOLATE) {
			class188.Interpreter_intStackSize -= 5;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 2];
			int var6 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 3];
			int var7 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 4];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
			return 1;
		} else if (var0 == ScriptOpcodes.ADDPERCENT) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3 + var4 * var3 / 100;
			return 1;
		} else if (var0 == ScriptOpcodes.SETBIT) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3 | 1 << var4;
			return 1;
		} else if (var0 == ScriptOpcodes.CLEARBIT) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3 & -1 - (1 << var4);
			return 1;
		} else if (var0 == ScriptOpcodes.TESTBIT) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.MOD) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3 % var4;
			return 1;
		} else if (var0 == ScriptOpcodes.POW) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			if (var3 == 0) {
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
			} else {
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.INVPOW) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			if (var3 == 0) {
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
				return 1;
			} else {
				switch(var4) {
				case 0:
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Integer.MAX_VALUE;
					break;
				case 1:
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3;
					break;
				case 2:
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = (int)Math.sqrt((double)var3);
					break;
				case 3:
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = (int)Math.cbrt((double)var3);
					break;
				case 4:
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
					break;
				default:
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
				}

				return 1;
			}
		} else if (var0 == ScriptOpcodes.AND) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3 & var4;
			return 1;
		} else if (var0 == ScriptOpcodes.OR) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3 | var4;
			return 1;
		} else if (var0 == ScriptOpcodes.SCALE) {
			class188.Interpreter_intStackSize -= 3;
			long var9 = (long)Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			long var11 = (long)Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			long var13 = (long)Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 2];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = (int)(var13 * var9 / var11);
			return 1;
		} else {
			return 2;
		}
	}
}
