import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ak")
@Implements("WorldMapData_1")
public class WorldMapData_1 extends AbstractWorldMapData {
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -947867455
	)
	@Export("chunkXLow")
	int chunkXLow;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -35118865
	)
	@Export("chunkYLow")
	int chunkYLow;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -622760109
	)
	@Export("chunkX")
	int chunkX;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 332325747
	)
	@Export("chunkY")
	int chunkY;

	WorldMapData_1() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "-1217403817"
	)
	@Export("init")
	void init(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		if (var2 != WorldMapID.field264.value) {
			throw new IllegalStateException("");
		} else {
			super.minPlane = var1.readUnsignedByte();
			super.planes = var1.readUnsignedByte();
			super.regionXLow = var1.readUnsignedShort() * 4096;
			super.regionYLow = var1.readUnsignedShort() * 4096;
			this.chunkXLow = var1.readUnsignedByte();
			this.chunkYLow = var1.readUnsignedByte();
			super.regionX = var1.readUnsignedShort();
			super.regionY = var1.readUnsignedShort();
			this.chunkX = var1.readUnsignedByte();
			this.chunkY = var1.readUnsignedByte();
			super.groupId = var1.method5623();
			super.fileId = var1.method5623();
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "-1969615810"
	)
	@Export("readGeography")
	void readGeography(Buffer var1) {
		super.planes = Math.min(super.planes, 4);
		super.floorUnderlayIds = new short[1][64][64];
		super.floorOverlayIds = new short[super.planes][64][64];
		super.field163 = new byte[super.planes][64][64];
		super.field159 = new byte[super.planes][64][64];
		super.decorations = new WorldMapDecoration[super.planes][64][64][];
		int var2 = var1.readUnsignedByte();
		if (var2 != class30.field254.value) {
			throw new IllegalStateException("");
		} else {
			int var3 = var1.readUnsignedByte();
			int var4 = var1.readUnsignedByte();
			int var5 = var1.readUnsignedByte();
			int var6 = var1.readUnsignedByte();
			if (var3 == super.regionX && var4 == super.regionY && var5 == this.chunkX && var6 == this.chunkY) {
				for (int var7 = 0; var7 < 8; ++var7) {
					for (int var8 = 0; var8 < 8; ++var8) {
						this.readTile(var7 + this.chunkX * 8, var8 + this.chunkY * 8, var1);
					}
				}

			} else {
				throw new IllegalStateException("");
			}
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-42087770"
	)
	@Export("getChunkXLow")
	int getChunkXLow() {
		return this.chunkXLow;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-194521742"
	)
	@Export("getChunkYLow")
	int getChunkYLow() {
		return this.chunkYLow;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "123"
	)
	@Export("getChunkX")
	int getChunkX() {
		return this.chunkX;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "10"
	)
	@Export("getChunkY")
	int getChunkY() {
		return this.chunkY;
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof WorldMapData_1)) {
			return false;
		} else {
			WorldMapData_1 var2 = (WorldMapData_1)var1;
			if (super.regionX == var2.regionX && super.regionY == var2.regionY) {
				return this.chunkX == var2.chunkX && this.chunkY == var2.chunkY;
			} else {
				return false;
			}
		}
	}

	public int hashCode() {
		return super.regionX | super.regionY << 8 | this.chunkX << 16 | this.chunkY << 24;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "10"
	)
	public static void method703(int var0, int var1) {
		VarbitDefinition var2 = Language.method3627(var0);
		int var3 = var2.baseVar;
		int var4 = var2.startBit;
		int var5 = var2.endBit;
		int var6 = Varps.Varps_masks[var5 - var4];
		if (var1 < 0 || var1 > var6) {
			var1 = 0;
		}

		var6 <<= var4;
		Varps.Varps_main[var3] = Varps.Varps_main[var3] & ~var6 | var1 << var4 & var6;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkz;II)V",
		garbageValue = "-891659032"
	)
	@Export("readReflectionCheck")
	public static void readReflectionCheck(Buffer var0, int var1) {
		ReflectionCheck var2 = new ReflectionCheck();
		var2.size = var0.readUnsignedByte();
		var2.id = var0.readInt();
		var2.operations = new int[var2.size];
		var2.creationErrors = new int[var2.size];
		var2.fields = new Field[var2.size];
		var2.intReplaceValues = new int[var2.size];
		var2.methods = new Method[var2.size];
		var2.arguments = new byte[var2.size][][];

		for (int var3 = 0; var3 < var2.size; ++var3) {
			try {
				int var4 = var0.readUnsignedByte();
				String var5;
				String var6;
				int var7;
				if (var4 != 0 && var4 != 1 && var4 != 2) {
					if (var4 == 3 || var4 == 4) {
						var5 = var0.readStringCp1252NullTerminated();
						var6 = var0.readStringCp1252NullTerminated();
						var7 = var0.readUnsignedByte();
						String[] var8 = new String[var7];

						for (int var9 = 0; var9 < var7; ++var9) {
							var8[var9] = var0.readStringCp1252NullTerminated();
						}

						String var20 = var0.readStringCp1252NullTerminated();
						byte[][] var10 = new byte[var7][];
						int var12;
						if (var4 == 3) {
							for (int var11 = 0; var11 < var7; ++var11) {
								var12 = var0.readInt();
								var10[var11] = new byte[var12];
								var0.readBytes(var10[var11], 0, var12);
							}
						}

						var2.operations[var3] = var4;
						Class[] var21 = new Class[var7];

						for (var12 = 0; var12 < var7; ++var12) {
							var21[var12] = Projectile.loadClassFromDescriptor(var8[var12]);
						}

						Class var22 = Projectile.loadClassFromDescriptor(var20);
						if (Projectile.loadClassFromDescriptor(var5).getClassLoader() == null) {
							throw new SecurityException();
						}

						Method[] var13 = Projectile.loadClassFromDescriptor(var5).getDeclaredMethods();
						Method[] var14 = var13;

						for (int var15 = 0; var15 < var14.length; ++var15) {
							Method var16 = var14[var15];
							if (Reflection.getMethodName(var16).equals(var6)) {
								Class[] var17 = Reflection.getParameterTypes(var16);
								if (var17.length == var21.length) {
									boolean var18 = true;

									for (int var19 = 0; var19 < var21.length; ++var19) {
										if (var21[var19] != var17[var19]) {
											var18 = false;
											break;
										}
									}

									if (var18 && var22 == var16.getReturnType()) {
										var2.methods[var3] = var16;
									}
								}
							}
						}

						var2.arguments[var3] = var10;
					}
				} else {
					var5 = var0.readStringCp1252NullTerminated();
					var6 = var0.readStringCp1252NullTerminated();
					var7 = 0;
					if (var4 == 1) {
						var7 = var0.readInt();
					}

					var2.operations[var3] = var4;
					var2.intReplaceValues[var3] = var7;
					if (Projectile.loadClassFromDescriptor(var5).getClassLoader() == null) {
						throw new SecurityException();
					}

					var2.fields[var3] = Reflection.findField(Projectile.loadClassFromDescriptor(var5), var6);
				}
			} catch (ClassNotFoundException var24) {
				var2.creationErrors[var3] = -1;
			} catch (SecurityException var25) {
				var2.creationErrors[var3] = -2;
			} catch (NullPointerException var26) {
				var2.creationErrors[var3] = -3;
			} catch (Exception var27) {
				var2.creationErrors[var3] = -4;
			} catch (Throwable var28) {
				var2.creationErrors[var3] = -5;
			}
		}

		class96.reflectionChecks.addFirst(var2);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(ILcu;ZS)I",
		garbageValue = "10127"
	)
	static int method705(int var0, Script var1, boolean var2) {
		boolean var3 = true;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = Player.getWidget(Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize]);
			var3 = false;
		} else {
			var4 = var2 ? UserComparator9.field1941 : MidiPcmStream.field2410;
		}

		int var11;
		if (var0 == ScriptOpcodes.CC_SETOP) {
			var11 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] - 1;
			if (var11 >= 0 && var11 <= 9) {
				var4.setAction(var11, Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize]);
				return 1;
			} else {
				--TextureProvider.Interpreter_stringStackSize;
				return 1;
			}
		} else {
			int var6;
			if (var0 == ScriptOpcodes.CC_SETDRAGGABLE) {
				class160.Interpreter_intStackSize -= 2;
				var11 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
				var6 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
				var4.parent = class49.getWidgetChild(var11, var6);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETDRAGGABLEBEHAVIOR) {
				var4.isScrollBar = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETDRAGDEADZONE) {
				var4.dragZoneSize = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETDRAGDEADTIME) {
				var4.dragThreshold = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETOPBASE) {
				var4.dataText = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTARGETVERB) {
				var4.spellActionName = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_CLEAROPS) {
				var4.actions = null;
				return 1;
			} else if (var0 == 1308) {
				var4.field2680 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
				return 1;
			} else {
				int var7;
				byte[] var9;
				if (var0 != ScriptOpcodes.CC_SETOPKEY) {
					byte var5;
					if (var0 == ScriptOpcodes.CC_SETOPTKEY) {
						class160.Interpreter_intStackSize -= 2;
						var5 = 10;
						var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize]};
						byte[] var10 = new byte[]{(byte)Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]};
						WorldMapIcon_0.Widget_setKey(var4, var5, var9, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_SETOPKEYRATE) {
						class160.Interpreter_intStackSize -= 3;
						var11 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize] - 1;
						var6 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
						var7 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 2];
						if (var11 >= 0 && var11 <= 9) {
							GrandExchangeOfferAgeComparator.Widget_setKeyRate(var4, var11, var6, var7);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == ScriptOpcodes.CC_SETOPTKEYRATE) {
						var5 = 10;
						var6 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						GrandExchangeOfferAgeComparator.Widget_setKeyRate(var4, var5, var6, var7);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_SETOPKEYIGNOREHELD) {
						--class160.Interpreter_intStackSize;
						var11 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize] - 1;
						if (var11 >= 0 && var11 <= 9) {
							ReflectionCheck.Widget_setKeyIgnoreHeld(var4, var11);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == ScriptOpcodes.CC_SETOPTKEYIGNOREHELD) {
						var5 = 10;
						ReflectionCheck.Widget_setKeyIgnoreHeld(var4, var5);
						return 1;
					} else {
						return 2;
					}
				} else {
					byte[] var8 = null;
					var9 = null;
					if (var3) {
						class160.Interpreter_intStackSize -= 10;

						for (var7 = 0; var7 < 10 && Interpreter.Interpreter_intStack[var7 + class160.Interpreter_intStackSize] >= 0; var7 += 2) {
						}

						if (var7 > 0) {
							var8 = new byte[var7 / 2];
							var9 = new byte[var7 / 2];

							for (var7 -= 2; var7 >= 0; var7 -= 2) {
								var8[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + class160.Interpreter_intStackSize];
								var9[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + class160.Interpreter_intStackSize + 1];
							}
						}
					} else {
						class160.Interpreter_intStackSize -= 2;
						var8 = new byte[]{(byte)Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize]};
						var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]};
					}

					var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] - 1;
					if (var7 >= 0 && var7 <= 9) {
						WorldMapIcon_0.Widget_setKey(var4, var7, var8, var9);
						return 1;
					} else {
						throw new RuntimeException();
					}
				}
			}
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "112"
	)
	static int method702(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.FRIEND_COUNT) {
			if (class218.friendSystem.field1034 == 0) {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -2;
			} else if (class218.friendSystem.field1034 == 1) {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
			} else {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class218.friendSystem.friendsList.getSize();
			}

			return 1;
		} else {
			int var3;
			if (var0 == ScriptOpcodes.FRIEND_GETNAME) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				if (class218.friendSystem.method1825() && var3 >= 0 && var3 < class218.friendSystem.friendsList.getSize()) {
					Friend var8 = (Friend)class218.friendSystem.friendsList.get(var3);
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var8.getName();
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var8.getPreviousName();
				} else {
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.FRIEND_GETWORLD) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				if (class218.friendSystem.method1825() && var3 >= 0 && var3 < class218.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = ((Buddy)class218.friendSystem.friendsList.get(var3)).world;
				} else {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else if (var0 == ScriptOpcodes.FRIEND_GETRANK) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				if (class218.friendSystem.method1825() && var3 >= 0 && var3 < class218.friendSystem.friendsList.getSize()) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = ((Buddy)class218.friendSystem.friendsList.get(var3)).rank;
				} else {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			} else {
				String var5;
				if (var0 == ScriptOpcodes.FRIEND_SETRANK) {
					var5 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
					int var6 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					ByteArrayPool.method5750(var5, var6);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_ADD) {
					var5 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
					class218.friendSystem.addFriend(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_DEL) {
					var5 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
					class218.friendSystem.removeFriend(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_ADD) {
					var5 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
					class218.friendSystem.addIgnore(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_DEL) {
					var5 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
					class218.friendSystem.removeIgnore(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.FRIEND_TEST) {
					var5 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
					var5 = GrandExchangeEvents.method68(var5);
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class218.friendSystem.isFriended(new Username(var5, class4.loginType), false) ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATDISPLAYNAME) {
					if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = GrandExchangeOfferUnitPriceComparator.clanChat.name;
					} else {
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATCOUNT) {
					if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.clanChat.getSize();
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERNAME) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					if (GrandExchangeOfferUnitPriceComparator.clanChat != null && var3 < GrandExchangeOfferUnitPriceComparator.clanChat.getSize()) {
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = GrandExchangeOfferUnitPriceComparator.clanChat.get(var3).getUsername().getName();
					} else {
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERWORLD) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					if (GrandExchangeOfferUnitPriceComparator.clanChat != null && var3 < GrandExchangeOfferUnitPriceComparator.clanChat.getSize()) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = ((Buddy)GrandExchangeOfferUnitPriceComparator.clanChat.get(var3)).getWorld();
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATUSERRANK) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					if (GrandExchangeOfferUnitPriceComparator.clanChat != null && var3 < GrandExchangeOfferUnitPriceComparator.clanChat.getSize()) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = ((Buddy)GrandExchangeOfferUnitPriceComparator.clanChat.get(var3)).rank;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATMINKICK) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.clanChat != null ? GrandExchangeOfferUnitPriceComparator.clanChat.minKick : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_KICKUSER) {
					var5 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
					class197.clanKickUser(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATRANK) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.clanChat != null ? GrandExchangeOfferUnitPriceComparator.clanChat.rank : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_JOINCHAT) {
					var5 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
					WorldMapID.Clan_joinChat(var5);
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_LEAVECHAT) {
					class51.Clan_leaveChat();
					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_COUNT) {
					if (!class218.friendSystem.method1825()) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class218.friendSystem.ignoreList.getSize();
					}

					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_GETNAME) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					if (class218.friendSystem.method1825() && var3 >= 0 && var3 < class218.friendSystem.ignoreList.getSize()) {
						Ignored var4 = (Ignored)class218.friendSystem.ignoreList.get(var3);
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var4.getName();
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var4.getPreviousName();
					} else {
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.IGNORE_TEST) {
					var5 = Interpreter.Interpreter_stringStack[--TextureProvider.Interpreter_stringStackSize];
					var5 = GrandExchangeEvents.method68(var5);
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = class218.friendSystem.isIgnored(new Username(var5, class4.loginType)) ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_ISSELF) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					if (GrandExchangeOfferUnitPriceComparator.clanChat != null && var3 < GrandExchangeOfferUnitPriceComparator.clanChat.getSize() && GrandExchangeOfferUnitPriceComparator.clanChat.get(var3).getUsername().equals(Varps.localPlayer.username)) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_GETCHATOWNERNAME) {
					if (GrandExchangeOfferUnitPriceComparator.clanChat != null && GrandExchangeOfferUnitPriceComparator.clanChat.owner != null) {
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = GrandExchangeOfferUnitPriceComparator.clanChat.owner;
					} else {
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CLAN_ISFRIEND) {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					if (GrandExchangeOfferUnitPriceComparator.clanChat != null && var3 < GrandExchangeOfferUnitPriceComparator.clanChat.getSize() && ((ClanMate)GrandExchangeOfferUnitPriceComparator.clanChat.get(var3)).isFriend()) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 != ScriptOpcodes.CLAN_ISIGNORE) {
					if (var0 == 3628) {
						class218.friendSystem.friendsList.removeComparator();
						return 1;
					} else {
						boolean var7;
						if (var0 == 3629) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							class218.friendSystem.friendsList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3630) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							class218.friendSystem.friendsList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3631) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							class218.friendSystem.friendsList.addComparator(new UserComparator3(var7));
							return 1;
						} else if (var0 == 3632) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							class218.friendSystem.friendsList.addComparator(new UserComparator4(var7));
							return 1;
						} else if (var0 == 3633) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							class218.friendSystem.friendsList.addComparator(new UserComparator5(var7));
							return 1;
						} else if (var0 == 3634) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							class218.friendSystem.friendsList.addComparator(new UserComparator6(var7));
							return 1;
						} else if (var0 == 3635) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							class218.friendSystem.friendsList.addComparator(new UserComparator7(var7));
							return 1;
						} else if (var0 == 3636) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							class218.friendSystem.friendsList.addComparator(new UserComparator8(var7));
							return 1;
						} else if (var0 == 3637) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							class218.friendSystem.friendsList.addComparator(new UserComparator9(var7));
							return 1;
						} else if (var0 == 3638) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							class218.friendSystem.friendsList.addComparator(new UserComparator10(var7));
							return 1;
						} else if (var0 == 3639) {
							class218.friendSystem.friendsList.sort();
							return 1;
						} else if (var0 == 3640) {
							class218.friendSystem.ignoreList.removeComparator();
							return 1;
						} else if (var0 == 3641) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							class218.friendSystem.ignoreList.addComparator(new UserComparator1(var7));
							return 1;
						} else if (var0 == 3642) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							class218.friendSystem.ignoreList.addComparator(new UserComparator2(var7));
							return 1;
						} else if (var0 == 3643) {
							class218.friendSystem.ignoreList.sort();
							return 1;
						} else if (var0 == 3644) {
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.removeComparator();
							}

							return 1;
						} else if (var0 == 3645) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.addComparator(new UserComparator1(var7));
							}

							return 1;
						} else if (var0 == 3646) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.addComparator(new UserComparator2(var7));
							}

							return 1;
						} else if (var0 == 3647) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.addComparator(new UserComparator3(var7));
							}

							return 1;
						} else if (var0 == 3648) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.addComparator(new UserComparator4(var7));
							}

							return 1;
						} else if (var0 == 3649) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.addComparator(new UserComparator5(var7));
							}

							return 1;
						} else if (var0 == 3650) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.addComparator(new UserComparator6(var7));
							}

							return 1;
						} else if (var0 == 3651) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.addComparator(new UserComparator7(var7));
							}

							return 1;
						} else if (var0 == 3652) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.addComparator(new UserComparator8(var7));
							}

							return 1;
						} else if (var0 == 3653) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.addComparator(new UserComparator9(var7));
							}

							return 1;
						} else if (var0 == 3654) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.addComparator(new UserComparator10(var7));
							}

							return 1;
						} else if (var0 == 3655) {
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.sort();
							}

							return 1;
						} else if (var0 == 3656) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							class218.friendSystem.friendsList.addComparator(new BuddyRankComparator(var7));
							return 1;
						} else if (var0 == 3657) {
							var7 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
							if (GrandExchangeOfferUnitPriceComparator.clanChat != null) {
								GrandExchangeOfferUnitPriceComparator.clanChat.addComparator(new BuddyRankComparator(var7));
							}

							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
					if (GrandExchangeOfferUnitPriceComparator.clanChat != null && var3 < GrandExchangeOfferUnitPriceComparator.clanChat.getSize() && ((ClanMate)GrandExchangeOfferUnitPriceComparator.clanChat.get(var3)).isIgnored()) {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("fe")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1914093616"
	)
	@Export("playSong")
	static void playSong(int var0) {
		if (var0 == -1 && !Client.field746) {
			class226.method4108();
		} else if (var0 != -1 && var0 != Client.field857 && Client.field638 != 0 && !Client.field746) {
			Archive var1 = WorldMapDecoration.archive6;
			int var2 = Client.field638;
			class197.field2376 = 1;
			class197.musicTrackArchive = var1;
			class197.musicTrackGroupId = var0;
			class197.musicTrackFileId = 0;
			Canvas.field395 = var2;
			MouseRecorder.musicTrackBoolean = false;
			ModelData0.field1833 = 2;
		}

		Client.field857 = var0;
	}
}
