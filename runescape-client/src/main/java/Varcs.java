import java.io.EOFException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cj")
@Implements("Varcs")
public class Varcs {
	@ObfuscatedName("b")
	@Export("intsPersistence")
	boolean[] intsPersistence;
	@ObfuscatedName("g")
	@Export("map")
	Map map;
	@ObfuscatedName("z")
	@Export("strings")
	String[] strings;
	@ObfuscatedName("p")
	@Export("unwrittenChanges")
	boolean unwrittenChanges;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		longValue = 1873182540653835357L
	)
	long field1267;

	Varcs() {
		this.unwrittenChanges = false;
		int var1 = class288.archive2.getGroupFileCount(19);
		this.map = new HashMap();
		this.intsPersistence = new boolean[var1];

		int var2;
		for (var2 = 0; var2 < var1; ++var2) {
			VarcInt var3 = class40.method778(var2);
			this.intsPersistence[var2] = var3.persist;
		}

		var2 = 0;
		if (class288.archive2.method4355(15)) {
			var2 = class288.archive2.getGroupFileCount(15);
		}

		this.strings = new String[var2];
		this.read();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1927566504"
	)
	@Export("setInt")
	void setInt(int var1, int var2) {
		this.map.put(var1, var2);
		if (this.intsPersistence[var1]) {
			this.unwrittenChanges = true;
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1918389063"
	)
	@Export("getInt")
	int getInt(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof Integer ? (Integer)var2 : -1;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;I)V",
		garbageValue = "1529993264"
	)
	@Export("setString")
	void setString(int var1, String var2) {
		this.map.put(var1, var2);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-2052988602"
	)
	@Export("getString")
	String getString(int var1) {
		Object var2 = this.map.get(var1);
		return var2 instanceof String ? (String)var2 : "";
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;B)V",
		garbageValue = "-38"
	)
	@Export("setStringOld")
	void setStringOld(int var1, String var2) {
		this.strings[var1] = var2;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "-34"
	)
	@Export("getStringOld")
	String getStringOld(int var1) {
		return this.strings[var1];
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "996581962"
	)
	@Export("clearTransient")
	void clearTransient() {
		int var1;
		for (var1 = 0; var1 < this.intsPersistence.length; ++var1) {
			if (!this.intsPersistence[var1]) {
				this.map.remove(var1);
			}
		}

		for (var1 = 0; var1 < this.strings.length; ++var1) {
			this.strings[var1] = null;
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(ZB)Lmd;",
		garbageValue = "59"
	)
	@Export("getPreferencesFile")
	AccessFile getPreferencesFile(boolean var1) {
		return class191.getPreferencesFile("2", UserComparator8.field1973.name, var1);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1542947318"
	)
	@Export("write")
	void write() {
		AccessFile var1 = this.getPreferencesFile(true);

		try {
			int var2 = 3;
			int var3 = 0;
			Iterator var4 = this.map.entrySet().iterator();

			while (var4.hasNext()) {
				Entry var5 = (Entry)var4.next();
				int var6 = (Integer)var5.getKey();
				if (this.intsPersistence[var6]) {
					Object var7 = var5.getValue();
					var2 += 3;
					if (var7 instanceof Integer) {
						var2 += 4;
					} else if (var7 instanceof String) {
						var2 += class173.stringCp1252NullTerminatedByteSize((String)var7);
					}

					++var3;
				}
			}

			Buffer var27 = new Buffer(var2);
			var27.writeByte(2);
			var27.writeShort(var3);
			Iterator var28 = this.map.entrySet().iterator();

			label148:
			while (true) {
				Entry var16;
				int var17;
				do {
					if (!var28.hasNext()) {
						var1.write(var27.array, 0, var27.offset);
						break label148;
					}

					var16 = (Entry)var28.next();
					var17 = (Integer)var16.getKey();
				} while(!this.intsPersistence[var17]);

				var27.writeShort(var17);
				Object var8 = var16.getValue();
				Class var10 = var8.getClass();
				class3[] var11 = class3.method45();
				int var12 = 0;

				class3 var9;
				while (true) {
					if (var12 >= var11.length) {
						var9 = null;
						break;
					}

					class3 var13 = var11[var12];
					if (var10 == var13.field16) {
						var9 = var13;
						break;
					}

					++var12;
				}

				var27.writeByte(var9.field19);
				class3.method37(var8, var27);
			}
		} catch (Exception var25) {
		} finally {
			try {
				var1.close();
			} catch (Exception var24) {
			}

		}

		this.unwrittenChanges = false;
		this.field1267 = TaskHandler.currentTimeMillis();
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-21829"
	)
	@Export("read")
	void read() {
		AccessFile var1 = this.getPreferencesFile(false);

		label224: {
			try {
				byte[] var2 = new byte[(int)var1.length()];

				int var4;
				for (int var3 = 0; var3 < var2.length; var3 += var4) {
					var4 = var1.read(var2, var3, var2.length - var3);
					if (var4 == -1) {
						throw new EOFException();
					}
				}

				Buffer var14 = new Buffer(var2);
				if (var14.array.length - var14.offset < 1) {
					return;
				}

				int var15 = var14.readUnsignedByte();
				if (var15 >= 0 && var15 <= 2) {
					int var7;
					int var8;
					int var9;
					int var16;
					if (var15 >= 2) {
						var16 = var14.readUnsignedShort();
						var7 = 0;

						while (true) {
							if (var7 >= var16) {
								break label224;
							}

							var8 = var14.readUnsignedShort();
							var9 = var14.readUnsignedByte();
							class3 var10 = (class3)CollisionMap.findEnumerated(class3.method45(), var9);
							Object var11 = var10.method40(var14);
							if (this.intsPersistence[var8]) {
								this.map.put(var8, var11);
							}

							++var7;
						}
					} else {
						var16 = var14.readUnsignedShort();

						for (var7 = 0; var7 < var16; ++var7) {
							var8 = var14.readUnsignedShort();
							var9 = var14.readInt();
							if (this.intsPersistence[var8]) {
								this.map.put(var8, var9);
							}
						}

						var7 = var14.readUnsignedShort();
						var8 = 0;

						while (true) {
							if (var8 >= var7) {
								break label224;
							}

							var14.readUnsignedShort();
							var14.readStringCp1252NullTerminated();
							++var8;
						}
					}
				}
			} catch (Exception var25) {
				break label224;
			} finally {
				try {
					var1.close();
				} catch (Exception var24) {
				}

			}

			return;
		}

		this.unwrittenChanges = false;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1047394064"
	)
	@Export("tryWrite")
	void tryWrite() {
		if (this.unwrittenChanges && this.field1267 < TaskHandler.currentTimeMillis() - 60000L) {
			this.write();
		}

	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "229746516"
	)
	@Export("hasUnwrittenChanges")
	boolean hasUnwrittenChanges() {
		return this.unwrittenChanges;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IS)Lis;",
		garbageValue = "200"
	)
	@Export("WorldMapElement_get")
	public static WorldMapElement WorldMapElement_get(int var0) {
		return var0 >= 0 && var0 < WorldMapElement.WorldMapElement_cached.length && WorldMapElement.WorldMapElement_cached[var0] != null ? WorldMapElement.WorldMapElement_cached[var0] : new WorldMapElement(var0);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)Lgx;",
		garbageValue = "2098158571"
	)
	public static PacketBufferNode method2221() {
		PacketBufferNode var0 = StudioGame.method4225();
		var0.clientPacket = null;
		var0.clientPacketLength = 0;
		var0.packetBuffer = new PacketBuffer(5000);
		return var0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "898966718"
	)
	@Export("isAlphaNumeric")
	public static boolean isAlphaNumeric(char var0) {
		return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ILci;ZI)I",
		garbageValue = "2145599306"
	)
	static int method2201(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = Language.getWidget(Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? Interpreter.field1090 : class188.field2352;
		}

		String var4 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
		int[] var5 = null;
		if (var4.length() > 0 && var4.charAt(var4.length() - 1) == 'Y') {
			int var6 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
			if (var6 > 0) {
				for (var5 = new int[var6]; var6-- > 0; var5[var6] = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize]) {
				}
			}

			var4 = var4.substring(0, var4.length() - 1);
		}

		Object[] var8 = new Object[var4.length() + 1];

		int var7;
		for (var7 = var8.length - 1; var7 >= 1; --var7) {
			if (var4.charAt(var7 - 1) == 's') {
				var8[var7] = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
			} else {
				var8[var7] = new Integer(Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize]);
			}
		}

		var7 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
		if (var7 != -1) {
			var8[0] = new Integer(var7);
		} else {
			var8 = null;
		}

		if (var0 == ScriptOpcodes.CC_SETONCLICK) {
			var3.onClick = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONHOLD) {
			var3.onHold = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONRELEASE) {
			var3.onRelease = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMOUSEOVER) {
			var3.onMouseOver = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMOUSELEAVE) {
			var3.onMouseLeave = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONDRAG) {
			var3.onDrag = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONTARGETLEAVE) {
			var3.onTargetLeave = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONVARTRANSMIT) {
			var3.onVarTransmit = var8;
			var3.varTransmitTriggers = var5;
		} else if (var0 == ScriptOpcodes.CC_SETONTIMER) {
			var3.onTimer = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONOP) {
			var3.onOp = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONDRAGCOMPLETE) {
			var3.onDragComplete = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONCLICKREPEAT) {
			var3.onClickRepeat = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMOUSEREPEAT) {
			var3.onMouseRepeat = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONINVTRANSMIT) {
			var3.onInvTransmit = var8;
			var3.invTransmitTriggers = var5;
		} else if (var0 == ScriptOpcodes.CC_SETONSTATTRANSMIT) {
			var3.onStatTransmit = var8;
			var3.statTransmitTriggers = var5;
		} else if (var0 == ScriptOpcodes.CC_SETONTARGETENTER) {
			var3.onTargetEnter = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONSCROLLWHEEL) {
			var3.onScroll = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONCHATTRANSMIT) {
			var3.onChatTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONKEY) {
			var3.onKey = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONFRIENDTRANSMIT) {
			var3.onFriendTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONCLANTRANSMIT) {
			var3.onClanTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONMISCTRANSMIT) {
			var3.onMiscTransmit = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONDIALOGABORT) {
			var3.onDialogAbort = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONSUBCHANGE) {
			var3.onSubChange = var8;
		} else if (var0 == ScriptOpcodes.CC_SETONSTOCKTRANSMIT) {
			var3.onStockTransmit = var8;
		} else if (var0 == 1426) {
			var3.field2689 = var8;
		} else {
			if (var0 != ScriptOpcodes.CC_SETONRESIZE) {
				return 2;
			}

			var3.onResize = var8;
		}

		var3.hasListener = true;
		return 1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILci;ZB)I",
		garbageValue = "-3"
	)
	static int method2220(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? Interpreter.field1090 : class188.field2352;
		if (var0 == ScriptOpcodes.CC_GETSCROLLX) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETSCROLLY) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETTEXT) {
			Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3.text;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETSCROLLWIDTH) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.scrollWidth;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETSCROLLHEIGHT) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.scrollHeight;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELZOOM) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.modelZoom;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_X) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.modelAngleX;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_Z) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.modelAngleZ;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELANGLE_Y) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.modelAngleY;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETTRANSTOP) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.transparencyTop;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETTRANSBOT) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.transparencyBot;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETCOLOUR) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.color;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETFILLCOLOUR) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.color2;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETFILLMODE) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETMODELTRANSPARENT) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		signature = "(ILci;ZB)I",
		garbageValue = "-27"
	)
	static int method2194(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.LOGOUT) {
			Client.logoutTimer = 250;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ga")
	@ObfuscatedSignature(
		signature = "(Lbg;ZI)V",
		garbageValue = "-1731011436"
	)
	@Export("addPlayerToScene")
	static void addPlayerToScene(Player var0, boolean var1) {
		if (var0 != null && var0.isVisible() && !var0.isHidden) {
			var0.isUnanimated = false;
			if ((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && var0.readySequence == var0.movementSequence) {
				var0.isUnanimated = true;
			}

			int var2 = var0.x >> 7;
			int var3 = var0.y >> 7;
			if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
				long var4 = MouseHandler.calculateTag(0, 0, 0, false, var0.index);
				if (var0.model0 != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) {
					var0.isUnanimated = false;
					var0.tileHeight = class195.getTileHeight(var0.x, var0.y, ClientPacket.Client_plane);
					var0.playerCycle = Client.cycle;
					class2.scene.addNullableObject(ClientPacket.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.field618, var0.field620, var0.field621, var0.field622);
				} else {
					if ((var0.x & 127) == 64 && (var0.y & 127) == 64) {
						if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
							return;
						}

						Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
					}

					var0.tileHeight = class195.getTileHeight(var0.x, var0.y, ClientPacket.Client_plane);
					var0.playerCycle = Client.cycle;
					class2.scene.drawEntity(ClientPacket.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.isWalking);
				}
			}
		}

	}

	@ObfuscatedName("ig")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "-19"
	)
	@Export("addSceneMenuOptions")
	static final void addSceneMenuOptions(int var0, int var1, int var2, int var3) {
		if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
			WorldMapSprite.insertMenuItemNoShift("Walk here", "", 23, 0, var0 - var2, var1 - var3);
		}

		long var4 = -1L;
		long var6 = -1L;
		int var8 = 0;

		while (true) {
			int var10 = ViewportMouse.ViewportMouse_entityCount;
			if (var8 >= var10) {
				if (-1L != var4) {
					var8 = (int)(var4 >>> 0 & 127L);
					var10 = WorldMapSectionType.method271(var4);
					Player var11 = Client.players[Client.combatTargetPlayerIndex];
					Entity.addPlayerToMenu(var11, Client.combatTargetPlayerIndex, var8, var10);
				}

				return;
			}

			long var25 = SoundCache.method2531(var8);
			if (var25 != var6) {
				label333: {
					var6 = var25;
					int var13 = HealthBarUpdate.ViewportMouse_unpackX(var8);
					int var14 = GrandExchangeOfferUnitPriceComparator.method143(var8);
					long var17 = ViewportMouse.ViewportMouse_entityTags[var8];
					int var16 = (int)(var17 >>> 14 & 3L);
					int var27 = ItemContainer.Entity_unpackID(ViewportMouse.ViewportMouse_entityTags[var8]);
					int var18 = var27;
					if (var16 == 2 && class2.scene.getObjectFlags(ClientPacket.Client_plane, var13, var14, var25) >= 0) {
						ObjectDefinition var19 = Occluder.getObjectDefinition(var27);
						if (var19.transforms != null) {
							var19 = var19.transform();
						}

						if (var19 == null) {
							break label333;
						}

						if (Client.isItemSelected == 1) {
							WorldMapSprite.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + class222.colorStartTag(65535) + var19.name, 1, var27, var13, var14);
						} else if (Client.isSpellSelected) {
							if ((Actor.selectedSpellFlags & 4) == 4) {
								WorldMapSprite.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + class222.colorStartTag(65535) + var19.name, 2, var27, var13, var14);
							}
						} else {
							String[] var28 = var19.actions;
							if (var28 != null) {
								for (int var31 = 4; var31 >= 0; --var31) {
									if (var28[var31] != null) {
										short var22 = 0;
										if (var31 == 0) {
											var22 = 3;
										}

										if (var31 == 1) {
											var22 = 4;
										}

										if (var31 == 2) {
											var22 = 5;
										}

										if (var31 == 3) {
											var22 = 6;
										}

										if (var31 == 4) {
											var22 = 1001;
										}

										WorldMapSprite.insertMenuItemNoShift(var28[var31], class222.colorStartTag(65535) + var19.name, var22, var18, var13, var14);
									}
								}
							}

							WorldMapSprite.insertMenuItemNoShift("Examine", class222.colorStartTag(65535) + var19.name, 1002, var19.id, var13, var14);
						}
					}

					int var20;
					NPC var21;
					Player var23;
					int[] var35;
					int var37;
					if (var16 == 1) {
						NPC var32 = Client.npcs[var18];
						if (var32 == null) {
							break label333;
						}

						if (var32.definition.size == 1 && (var32.x & 127) == 64 && (var32.y & 127) == 64) {
							for (var20 = 0; var20 < Client.npcCount; ++var20) {
								var21 = Client.npcs[Client.npcIndices[var20]];
								if (var21 != null && var21 != var32 && var21.definition.size == 1 && var21.x == var32.x && var32.y == var21.y) {
									LoginPacket.addNpcToMenu(var21.definition, Client.npcIndices[var20], var13, var14);
								}
							}

							var20 = Players.Players_count;
							var35 = Players.Players_indices;

							for (var37 = 0; var37 < var20; ++var37) {
								var23 = Client.players[var35[var37]];
								if (var23 != null && var23.x == var32.x && var23.y == var32.y) {
									Entity.addPlayerToMenu(var23, var35[var37], var13, var14);
								}
							}
						}

						LoginPacket.addNpcToMenu(var32.definition, var18, var13, var14);
					}

					if (var16 == 0) {
						Player var33 = Client.players[var18];
						if (var33 == null) {
							break label333;
						}

						if ((var33.x & 127) == 64 && (var33.y & 127) == 64) {
							for (var20 = 0; var20 < Client.npcCount; ++var20) {
								var21 = Client.npcs[Client.npcIndices[var20]];
								if (var21 != null && var21.definition.size == 1 && var33.x == var21.x && var21.y == var33.y) {
									LoginPacket.addNpcToMenu(var21.definition, Client.npcIndices[var20], var13, var14);
								}
							}

							var20 = Players.Players_count;
							var35 = Players.Players_indices;

							for (var37 = 0; var37 < var20; ++var37) {
								var23 = Client.players[var35[var37]];
								if (var23 != null && var33 != var23 && var33.x == var23.x && var23.y == var33.y) {
									Entity.addPlayerToMenu(var23, var35[var37], var13, var14);
								}
							}
						}

						if (var18 != Client.combatTargetPlayerIndex) {
							Entity.addPlayerToMenu(var33, var18, var13, var14);
						} else {
							var4 = var25;
						}
					}

					if (var16 == 3) {
						NodeDeque var34 = Client.groundItems[ClientPacket.Client_plane][var13][var14];
						if (var34 != null) {
							for (TileItem var38 = (TileItem)var34.first(); var38 != null; var38 = (TileItem)var34.next()) {
								ItemDefinition var36 = Interpreter.ItemDefinition_get(var38.id);
								if (Client.isItemSelected == 1) {
									WorldMapSprite.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + class222.colorStartTag(16748608) + var36.name, 16, var38.id, var13, var14);
								} else if (Client.isSpellSelected) {
									if ((Actor.selectedSpellFlags & 1) == 1) {
										WorldMapSprite.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + class222.colorStartTag(16748608) + var36.name, 17, var38.id, var13, var14);
									}
								} else {
									String[] var29 = var36.groundActions;

									for (int var30 = 4; var30 >= 0; --var30) {
										if (var29 != null && var29[var30] != null) {
											byte var24 = 0;
											if (var30 == 0) {
												var24 = 18;
											}

											if (var30 == 1) {
												var24 = 19;
											}

											if (var30 == 2) {
												var24 = 20;
											}

											if (var30 == 3) {
												var24 = 21;
											}

											if (var30 == 4) {
												var24 = 22;
											}

											WorldMapSprite.insertMenuItemNoShift(var29[var30], class222.colorStartTag(16748608) + var36.name, var24, var38.id, var13, var14);
										} else if (var30 == 2) {
											WorldMapSprite.insertMenuItemNoShift("Take", class222.colorStartTag(16748608) + var36.name, 20, var38.id, var13, var14);
										}
									}

									WorldMapSprite.insertMenuItemNoShift("Examine", class222.colorStartTag(16748608) + var36.name, 1004, var38.id, var13, var14);
								}
							}
						}
					}
				}
			}

			++var8;
		}
	}
}
