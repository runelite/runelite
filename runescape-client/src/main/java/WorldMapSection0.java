import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("r")
@Implements("WorldMapSection0")
public class WorldMapSection0 implements WorldMapSection {
	@ObfuscatedName("nk")
	@ObfuscatedGetter(
		intValue = 1085609153
	)
	static int field138;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1571530289
	)
	@Export("oldZ")
	int oldZ;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -533649473
	)
	@Export("newZ")
	int newZ;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1995731449
	)
	@Export("oldX")
	int oldX;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 1062766317
	)
	@Export("oldY")
	int oldY;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 808366011
	)
	@Export("newX")
	int newX;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1027119805
	)
	@Export("newY")
	int newY;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1967666529
	)
	@Export("oldChunkXLow")
	int oldChunkXLow;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1161504373
	)
	@Export("oldChunkYLow")
	int oldChunkYLow;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1572226723
	)
	@Export("oldChunkXHigh")
	int oldChunkXHigh;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 487863769
	)
	@Export("oldChunkYHigh")
	int oldChunkYHigh;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -997364423
	)
	@Export("newChunkXLow")
	int newChunkXLow;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 743905469
	)
	@Export("newChunkYLow")
	int newChunkYLow;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1996633981
	)
	@Export("newChunkXHigh")
	int newChunkXHigh;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -2013114443
	)
	@Export("newChunkYHigh")
	int newChunkYHigh;

	WorldMapSection0() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lag;S)V",
		garbageValue = "32767"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.newX) {
			var1.regionLowX = this.newX;
		}

		if (var1.regionHighX < this.newX) {
			var1.regionHighX = this.newX;
		}

		if (var1.regionLowY > this.newY) {
			var1.regionLowY = this.newY;
		}

		if (var1.regionHighY < this.newY) {
			var1.regionHighY = this.newY;
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "950167825"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.oldZ && var1 < this.newZ + this.oldZ) {
			return var2 >= (this.oldX << 6) + (this.oldChunkXLow << 3) && var2 <= (this.oldX << 6) + (this.oldChunkXHigh << 3) + 7 && var3 >= (this.oldY << 6) + (this.oldChunkYLow << 3) && var3 <= (this.oldY << 6) + (this.oldChunkYHigh << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1510325414"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.newX << 6) + (this.newChunkXLow << 3) && var1 <= (this.newX << 6) + (this.newChunkXHigh << 3) + 7 && var2 >= (this.newY << 6) + (this.newChunkYLow << 3) && var2 <= (this.newY << 6) + (this.newChunkYHigh << 3) + 7;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "-771447481"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.newX * 64 - this.oldX * 64 + var2 + (this.newChunkXLow * 8 - this.oldChunkXLow * 8), var3 + (this.newY * 64 - this.oldY * 64) + (this.newChunkYLow * 8 - this.oldChunkYLow * 8)};
			return var4;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(IIB)Lhj;",
		garbageValue = "0"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.oldX * 64 - this.newX * 64 + (this.oldChunkXLow * 8 - this.newChunkXLow * 8) + var1;
			int var4 = this.oldY * 64 - this.newY * 64 + var2 + (this.oldChunkYLow * 8 - this.newChunkYLow * 8);
			return new Coord(this.oldZ, var3, var4);
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "1954302512"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.oldZ = var1.readUnsignedByte();
		this.newZ = var1.readUnsignedByte();
		this.oldX = var1.readUnsignedShort();
		this.oldChunkXLow = var1.readUnsignedByte();
		this.oldChunkXHigh = var1.readUnsignedByte();
		this.oldY = var1.readUnsignedShort();
		this.oldChunkYLow = var1.readUnsignedByte();
		this.oldChunkYHigh = var1.readUnsignedByte();
		this.newX = var1.readUnsignedShort();
		this.newChunkXLow = var1.readUnsignedByte();
		this.newChunkXHigh = var1.readUnsignedByte();
		this.newY = var1.readUnsignedShort();
		this.newChunkYLow = var1.readUnsignedByte();
		this.newChunkYHigh = var1.readUnsignedByte();
		this.postRead();
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2040631149"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkt;I)V",
		garbageValue = "-2023027273"
	)
	@Export("performReflectionCheck")
	public static void performReflectionCheck(PacketBuffer var0) {
		ReflectionCheck var1 = (ReflectionCheck)class96.reflectionChecks.last();
		if (var1 != null) {
			int var2 = var0.offset;
			var0.writeInt(var1.id);

			for (int var3 = 0; var3 < var1.size; ++var3) {
				if (var1.creationErrors[var3] != 0) {
					var0.writeByte(var1.creationErrors[var3]);
				} else {
					try {
						int var4 = var1.operations[var3];
						Field var5;
						int var6;
						if (var4 == 0) {
							var5 = var1.fields[var3];
							var6 = Reflection.getInt(var5, (Object)null);
							var0.writeByte(0);
							var0.writeInt(var6);
						} else if (var4 == 1) {
							var5 = var1.fields[var3];
							Reflection.setInt(var5, (Object)null, var1.intReplaceValues[var3]);
							var0.writeByte(0);
						} else if (var4 == 2) {
							var5 = var1.fields[var3];
							var6 = var5.getModifiers();
							var0.writeByte(0);
							var0.writeInt(var6);
						}

						Method var25;
						if (var4 != 3) {
							if (var4 == 4) {
								var25 = var1.methods[var3];
								var6 = var25.getModifiers();
								var0.writeByte(0);
								var0.writeInt(var6);
							}
						} else {
							var25 = var1.methods[var3];
							byte[][] var10 = var1.arguments[var3];
							Object[] var7 = new Object[var10.length];

							for (int var8 = 0; var8 < var10.length; ++var8) {
								ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
								var7[var8] = var9.readObject();
							}

							Object var11 = Reflection.invoke(var25, (Object)null, var7);
							if (var11 == null) {
								var0.writeByte(0);
							} else if (var11 instanceof Number) {
								var0.writeByte(1);
								var0.writeLong(((Number)var11).longValue());
							} else if (var11 instanceof String) {
								var0.writeByte(2);
								var0.writeStringCp1252NullTerminated((String)var11);
							} else {
								var0.writeByte(4);
							}
						}
					} catch (ClassNotFoundException var13) {
						var0.writeByte(-10);
					} catch (InvalidClassException var14) {
						var0.writeByte(-11);
					} catch (StreamCorruptedException var15) {
						var0.writeByte(-12);
					} catch (OptionalDataException var16) {
						var0.writeByte(-13);
					} catch (IllegalAccessException var17) {
						var0.writeByte(-14);
					} catch (IllegalArgumentException var18) {
						var0.writeByte(-15);
					} catch (InvocationTargetException var19) {
						var0.writeByte(-16);
					} catch (SecurityException var20) {
						var0.writeByte(-17);
					} catch (IOException var21) {
						var0.writeByte(-18);
					} catch (NullPointerException var22) {
						var0.writeByte(-19);
					} catch (Exception var23) {
						var0.writeByte(-20);
					} catch (Throwable var24) {
						var0.writeByte(-21);
					}
				}
			}

			var0.writeCrc(var2);
			var1.remove();
		}
	}

	@ObfuscatedName("ia")
	@ObfuscatedSignature(
		signature = "(Lhy;III)V",
		garbageValue = "-2015033366"
	)
	static final void method217(Widget var0, int var1, int var2) {
		if (var0.buttonType == 1) {
			FontName.insertMenuItemNoShift(var0.buttonText, "", 24, 0, 0, var0.id);
		}

		String var3;
		if (var0.buttonType == 2 && !Client.isSpellSelected) {
			var3 = class16.method165(var0);
			if (var3 != null) {
				FontName.insertMenuItemNoShift(var3, UserComparator7.colorStartTag(65280) + var0.spellName, 25, 0, -1, var0.id);
			}
		}

		if (var0.buttonType == 3) {
			FontName.insertMenuItemNoShift("Close", "", 26, 0, 0, var0.id);
		}

		if (var0.buttonType == 4) {
			FontName.insertMenuItemNoShift(var0.buttonText, "", 28, 0, 0, var0.id);
		}

		if (var0.buttonType == 5) {
			FontName.insertMenuItemNoShift(var0.buttonText, "", 29, 0, 0, var0.id);
		}

		if (var0.buttonType == 6 && Client.meslayerContinueWidget == null) {
			FontName.insertMenuItemNoShift(var0.buttonText, "", 30, 0, -1, var0.id);
		}

		int var4;
		int var5;
		int var15;
		if (var0.type == 2) {
			var15 = 0;

			for (var4 = 0; var4 < var0.height; ++var4) {
				for (var5 = 0; var5 < var0.width; ++var5) {
					int var6 = (var0.paddingX + 32) * var5;
					int var7 = (var0.paddingY + 32) * var4;
					if (var15 < 20) {
						var6 += var0.inventoryXOffsets[var15];
						var7 += var0.inventoryYOffsets[var15];
					}

					if (var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
						Client.dragItemSlotDestination = var15;
						World.field996 = var0;
						if (var0.itemIds[var15] > 0) {
							ItemDefinition var8 = Player.ItemDefinition_get(var0.itemIds[var15] - 1);
							if (Client.isItemSelected == 1 && MilliClock.method3432(class60.getWidgetClickMask(var0))) {
								if (var0.id != MusicPatchPcmStream.selectedItemWidget || var15 != ModelData0.selectedItemSlot) {
									FontName.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + UserComparator7.colorStartTag(16748608) + var8.name, 31, var8.id, var15, var0.id);
								}
							} else if (Client.isSpellSelected && MilliClock.method3432(class60.getWidgetClickMask(var0))) {
								if ((BuddyRankComparator.selectedSpellFlags & 16) == 16) {
									FontName.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + UserComparator7.colorStartTag(16748608) + var8.name, 32, var8.id, var15, var0.id);
								}
							} else {
								String[] var9 = var8.inventoryActions;
								int var10 = -1;
								boolean var11;
								if (Client.shiftClickDrop) {
									var11 = Client.tapToDrop || KeyHandler.KeyHandler_pressedKeys[81];
									if (var11) {
										var10 = var8.getShiftClickIndex();
									}
								}

								if (MilliClock.method3432(class60.getWidgetClickMask(var0))) {
									for (int var20 = 4; var20 >= 3; --var20) {
										if (var10 != var20) {
											ScriptEvent.addWidgetItemMenuItem(var0, var8, var15, var20, false);
										}
									}
								}

								int var12 = class60.getWidgetClickMask(var0);
								var11 = (var12 >> 31 & 1) != 0;
								if (var11) {
									FontName.insertMenuItemNoShift("Use", UserComparator7.colorStartTag(16748608) + var8.name, 38, var8.id, var15, var0.id);
								}

								Object var10000 = null;
								int var13;
								if (MilliClock.method3432(class60.getWidgetClickMask(var0))) {
									for (var13 = 2; var13 >= 0; --var13) {
										if (var10 != var13) {
											ScriptEvent.addWidgetItemMenuItem(var0, var8, var15, var13, false);
										}
									}

									if (var10 >= 0) {
										ScriptEvent.addWidgetItemMenuItem(var0, var8, var15, var10, true);
									}
								}

								var9 = var0.itemActions;
								if (var9 != null) {
									for (var13 = 4; var13 >= 0; --var13) {
										if (var9[var13] != null) {
											byte var14 = 0;
											if (var13 == 0) {
												var14 = 39;
											}

											if (var13 == 1) {
												var14 = 40;
											}

											if (var13 == 2) {
												var14 = 41;
											}

											if (var13 == 3) {
												var14 = 42;
											}

											if (var13 == 4) {
												var14 = 43;
											}

											FontName.insertMenuItemNoShift(var9[var13], UserComparator7.colorStartTag(16748608) + var8.name, var14, var8.id, var15, var0.id);
										}
									}
								}

								FontName.insertMenuItemNoShift("Examine", UserComparator7.colorStartTag(16748608) + var8.name, 1005, var8.id, var15, var0.id);
							}
						}
					}

					++var15;
				}
			}
		}

		if (var0.isIf3) {
			if (Client.isSpellSelected) {
				var4 = class60.getWidgetClickMask(var0);
				boolean var21 = (var4 >> 21 & 1) != 0;
				if (var21 && (BuddyRankComparator.selectedSpellFlags & 32) == 32) {
					FontName.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + var0.dataText, 58, 0, var0.childIndex, var0.id);
				}
			} else {
				for (var15 = 9; var15 >= 5; --var15) {
					String var16;
					if (!class210.method3951(class60.getWidgetClickMask(var0), var15) && var0.onOp == null) {
						var16 = null;
					} else if (var0.actions != null && var0.actions.length > var15 && var0.actions[var15] != null && var0.actions[var15].trim().length() != 0) {
						var16 = var0.actions[var15];
					} else {
						var16 = null;
					}

					if (var16 != null) {
						FontName.insertMenuItemNoShift(var16, var0.dataText, 1007, var15 + 1, var0.childIndex, var0.id);
					}
				}

				var3 = class16.method165(var0);
				if (var3 != null) {
					FontName.insertMenuItemNoShift(var3, var0.dataText, 25, 0, var0.childIndex, var0.id);
				}

				for (var4 = 4; var4 >= 0; --var4) {
					String var17;
					if (!class210.method3951(class60.getWidgetClickMask(var0), var4) && var0.onOp == null) {
						var17 = null;
					} else if (var0.actions != null && var0.actions.length > var4 && var0.actions[var4] != null && var0.actions[var4].trim().length() != 0) {
						var17 = var0.actions[var4];
					} else {
						var17 = null;
					}

					if (var17 != null) {
						Decimator.insertMenuItem(var17, var0.dataText, 57, var4 + 1, var0.childIndex, var0.id, var0.field2680);
					}
				}

				var5 = class60.getWidgetClickMask(var0);
				boolean var19 = (var5 & 1) != 0;
				if (var19) {
					FontName.insertMenuItemNoShift("Continue", "", 30, 0, var0.childIndex, var0.id);
				}
			}
		}

	}

	@ObfuscatedName("jv")
	@ObfuscatedSignature(
		signature = "(IS)Z",
		garbageValue = "250"
	)
	static boolean method216(int var0) {
		for (int var1 = 0; var1 < Client.field844; ++var1) {
			if (Client.field846[var1] == var0) {
				return true;
			}
		}

		return false;
	}
}
