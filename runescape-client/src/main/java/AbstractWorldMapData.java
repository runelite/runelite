import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("h")
@Implements("AbstractWorldMapData")
public abstract class AbstractWorldMapData {
	@ObfuscatedName("qa")
	@ObfuscatedGetter(
		intValue = 1014546432
	)
	static int field147;
	@ObfuscatedName("db")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive5")
	static Archive archive5;
	@ObfuscatedName("dm")
	@ObfuscatedSignature(
		signature = "Lif;"
	)
	@Export("archive18")
	static Archive archive18;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1789439424
	)
	@Export("regionXLow")
	int regionXLow;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 810971136
	)
	@Export("regionYLow")
	int regionYLow;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 826366773
	)
	@Export("regionX")
	int regionX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -20485777
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 185589827
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1464369351
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 2104808793
	)
	@Export("groupId")
	int groupId;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -299525603
	)
	@Export("fileId")
	int fileId;
	@ObfuscatedName("a")
	@Export("floorUnderlayIds")
	short[][][] floorUnderlayIds;
	@ObfuscatedName("d")
	@Export("floorOverlayIds")
	short[][][] floorOverlayIds;
	@ObfuscatedName("c")
	byte[][][] field150;
	@ObfuscatedName("o")
	byte[][][] field149;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "[[[[Lq;"
	)
	@Export("decorations")
	WorldMapDecoration[][][][] decorations;
	@ObfuscatedName("k")
	boolean field153;
	@ObfuscatedName("s")
	boolean field154;

	AbstractWorldMapData() {
		this.groupId = -1;
		this.fileId = -1;
		new LinkedList();
		this.field153 = false;
		this.field154 = false;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkq;I)V",
		garbageValue = "1425420215"
	)
	@Export("readGeography")
	abstract void readGeography(Buffer var1);

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "890560047"
	)
	@Export("isFullyLoaded")
	boolean isFullyLoaded() {
		return this.field153 && this.field154;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lhz;I)V",
		garbageValue = "-1774423787"
	)
	@Export("loadGeography")
	void loadGeography(AbstractArchive var1) {
		if (!this.isFullyLoaded()) {
			byte[] var2 = var1.takeFile(this.groupId, this.fileId);
			if (var2 != null) {
				this.readGeography(new Buffer(var2));
				this.field153 = true;
				this.field154 = true;
			}

		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1921381610"
	)
	@Export("reset")
	void reset() {
		this.floorUnderlayIds = null;
		this.floorOverlayIds = null;
		this.field150 = null;
		this.field149 = null;
		this.decorations = null;
		this.field153 = false;
		this.field154 = false;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IILkq;I)V",
		garbageValue = "-1827340514"
	)
	@Export("readTile")
	void readTile(int var1, int var2, Buffer var3) {
		int var4 = var3.readUnsignedByte();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method247(var1, var2, var3, var4);
			} else {
				this.method269(var1, var2, var3, var4);
			}

		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IILkq;II)V",
		garbageValue = "947555268"
	)
	void method247(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.floorOverlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		}

		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(IILkq;IB)V",
		garbageValue = "77"
	)
	void method269(int var1, int var2, Buffer var3, int var4) {
		int var5 = ((var4 & 24) >> 3) + 1;
		boolean var6 = (var4 & 2) != 0;
		boolean var7 = (var4 & 4) != 0;
		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		int var8;
		int var9;
		int var11;
		if (var6) {
			var8 = var3.readUnsignedByte();

			for (var9 = 0; var9 < var8; ++var9) {
				int var10 = var3.readUnsignedByte();
				if (var10 != 0) {
					this.floorOverlayIds[var9][var1][var2] = (short)var10;
					var11 = var3.readUnsignedByte();
					this.field150[var9][var1][var2] = (byte)(var11 >> 2);
					this.field149[var9][var1][var2] = (byte)(var11 & 3);
				}
			}
		}

		if (var7) {
			for (var8 = 0; var8 < var5; ++var8) {
				var9 = var3.readUnsignedByte();
				if (var9 != 0) {
					WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.method5560();
						int var13 = var3.readUnsignedByte();
						var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
					}
				}
			}
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "58"
	)
	@Export("getRegionX")
	int getRegionX() {
		return this.regionX;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "63"
	)
	@Export("getRegionY")
	int getRegionY() {
		return this.regionY;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
		garbageValue = "4"
	)
	@Export("setLoginResponseString")
	static void setLoginResponseString(String var0, String var1, String var2) {
		Login.Login_response1 = var0;
		Login.Login_response2 = var1;
		Login.Login_response3 = var2;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "357466702"
	)
	static int method272(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.WORLDLIST_FETCH) {
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = MouseRecorder.loadWorlds() ? 1 : 0;
			return 1;
		} else {
			World var3;
			if (var0 == ScriptOpcodes.WORLDLIST_START) {
				var3 = ChatChannel.worldListStart();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.WORLDLIST_NEXT) {
				var3 = Friend.getNextWorldListWorld();
				if (var3 != null) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.id;
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.properties;
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3.activity;
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.location;
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3.population;
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var3.host;
				} else {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else {
				World var4;
				int var5;
				int var7;
				if (var0 == ScriptOpcodes.WORLDLIST_SPECIFIC) {
					var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					var4 = null;

					for (var5 = 0; var5 < World.World_count; ++var5) {
						if (var7 == class162.World_worlds[var5].id) {
							var4 = class162.World_worlds[var5];
							break;
						}
					}

					if (var4 != null) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				} else if (var0 == ScriptOpcodes.WORLDLIST_SORT) {
					class188.Interpreter_intStackSize -= 4;
					var7 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
					boolean var10 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1] == 1;
					var5 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 2];
					boolean var6 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 3] == 1;
					Player.sortWorldList(var7, var10, var5, var6);
					return 1;
				} else if (var0 != ScriptOpcodes.GETWORLDINFO) {
					if (var0 == ScriptOpcodes.SETFOLLOWEROPSLOWPRIORITY) {
						Client.followerOpsLowPriority = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
						return 1;
					} else {
						int var8;
						ParamDefinition var9;
						if (var0 == ScriptOpcodes.NC_PARAM) {
							class188.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
							var9 = WorldMapIcon_1.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = AbstractUserComparator.getNpcDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = AbstractUserComparator.getNpcDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.LC_PARAM) {
							class188.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
							var9 = WorldMapIcon_1.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = Coord.getObjectDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Coord.getObjectDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.OC_PARAM) {
							class188.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
							var9 = WorldMapIcon_1.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = PacketBufferNode.ItemDefinition_get(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = PacketBufferNode.ItemDefinition_get(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.STRUCT_PARAM) {
							class188.Interpreter_intStackSize -= 2;
							var7 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
							var8 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
							var9 = WorldMapIcon_1.getParamDefinition(var8);
							if (var9.isString()) {
								Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = KitDefinition.StructDefinition_getStructDefinition(var7).getStringParam(var8, var9.defaultStr);
							} else {
								Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = KitDefinition.StructDefinition_getStructDefinition(var7).getIntParam(var8, var9.defaultInt);
							}

							return 1;
						} else if (var0 == ScriptOpcodes.ON_MOBILE) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.onMobile ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.CLIENTTYPE) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.clientType & 3;
							return 1;
						} else if (var0 == 6520) {
							return 1;
						} else if (var0 == ScriptOpcodes.MOBILE_KEYBOARDHIDE) {
							return 1;
						} else if (var0 == 6522) {
							--class65.Interpreter_stringStackSize;
							--class188.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 6523) {
							--class65.Interpreter_stringStackSize;
							--class188.Interpreter_intStackSize;
							return 1;
						} else if (var0 == ScriptOpcodes.BATTERYLEVEL) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else if (var0 == ScriptOpcodes.BATTERYCHARGING) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else if (var0 == ScriptOpcodes.WIFIAVAILABLE) {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 1;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					if (var7 >= 0 && var7 < World.World_count) {
						var4 = class162.World_worlds[var7];
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var4.id;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var4.properties;
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var4.activity;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var4.location;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var4.population;
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var4.host;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("ir")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
		garbageValue = "-803158058"
	)
	@Export("menuAction")
	static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
		if (var2 >= 2000) {
			var2 -= 2000;
		}

		PacketBufferNode var8;
		if (var2 == 1) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = class2.getPacketBufferNode(ClientPacket.field2228, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntME(MusicPatchPcmStream.baseX * 64 + var0);
			var8.packetBuffer.method5744(Occluder.selectedItemWidget);
			var8.packetBuffer.writeIntME(ScriptEvent.baseY * 64 + var1);
			var8.packetBuffer.method5746(var3);
			var8.packetBuffer.method5579(KeyHandler.selectedItemSlot);
			var8.packetBuffer.method5569(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5579(IsaacCipher.selectedItemId);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 2) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = class2.getPacketBufferNode(ClientPacket.field2199, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5579(var3);
			var8.packetBuffer.method5744(WorldMapDecoration.selectedSpellWidget);
			var8.packetBuffer.method5746(MusicPatchPcmStream.baseX * 64 + var0);
			var8.packetBuffer.writeShort(Client.selectedSpellChildIndex);
			var8.packetBuffer.method5579(ScriptEvent.baseY * 64 + var1);
			var8.packetBuffer.method5569(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 3) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = class2.getPacketBufferNode(ClientPacket.field2233, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5720(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntME(var3);
			var8.packetBuffer.method5579(ScriptEvent.baseY * 64 + var1);
			var8.packetBuffer.method5746(MusicPatchPcmStream.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 4) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = class2.getPacketBufferNode(ClientPacket.field2265, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5579(var3);
			var8.packetBuffer.method5696(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5579(ScriptEvent.baseY * 64 + var1);
			var8.packetBuffer.method5579(MusicPatchPcmStream.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 5) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = class2.getPacketBufferNode(ClientPacket.field2264, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntME(var3);
			var8.packetBuffer.method5696(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5746(ScriptEvent.baseY * 64 + var1);
			var8.packetBuffer.method5579(MusicPatchPcmStream.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 6) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = class2.getPacketBufferNode(ClientPacket.field2248, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5579(var3);
			var8.packetBuffer.writeIntME(MusicPatchPcmStream.baseX * 64 + var0);
			var8.packetBuffer.method5720(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5746(ScriptEvent.baseY * 64 + var1);
			Client.packetWriter.addNode(var8);
		} else {
			PacketBufferNode var9;
			NPC var13;
			if (var2 == 7) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = class2.getPacketBufferNode(ClientPacket.field2270, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeIntME(IsaacCipher.selectedItemId);
					var9.packetBuffer.writeIntME(KeyHandler.selectedItemSlot);
					var9.packetBuffer.method5744(Occluder.selectedItemWidget);
					var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5579(var3);
					Client.packetWriter.addNode(var9);
				}
			} else if (var2 == 8) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = class2.getPacketBufferNode(ClientPacket.field2213, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeShortLE(WorldMapDecoration.selectedSpellWidget);
					var9.packetBuffer.method5579(var3);
					var9.packetBuffer.method5746(Client.selectedSpellChildIndex);
					var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var9);
				}
			} else if (var2 == 9) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = class2.getPacketBufferNode(ClientPacket.field2208, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5569(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeIntME(var3);
					Client.packetWriter.addNode(var9);
				}
			} else if (var2 == 10) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = class2.getPacketBufferNode(ClientPacket.field2224, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5579(var3);
					var9.packetBuffer.method5569(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var9);
				}
			} else if (var2 == 11) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = class2.getPacketBufferNode(ClientPacket.field2256, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5579(var3);
					Client.packetWriter.addNode(var9);
				}
			} else if (var2 == 12) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = class2.getPacketBufferNode(ClientPacket.field2266, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5569(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeShort(var3);
					Client.packetWriter.addNode(var9);
				}
			} else if (var2 == 13) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = class2.getPacketBufferNode(ClientPacket.field2215, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5746(var3);
					var9.packetBuffer.method5720(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var9);
				}
			} else {
				Player var15;
				if (var2 == 14) {
					var15 = Client.players[var3];
					if (var15 != null) {
						Client.mouseCrossX = var6;
						Client.mouseCrossY = var7;
						Client.mouseCrossColor = 2;
						Client.mouseCrossState = 0;
						Client.destinationX = var0;
						Client.destinationY = var1;
						var9 = class2.getPacketBufferNode(ClientPacket.field2239, Client.packetWriter.isaacCipher);
						var9.packetBuffer.writeInt(Occluder.selectedItemWidget);
						var9.packetBuffer.method5720(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var9.packetBuffer.writeShort(KeyHandler.selectedItemSlot);
						var9.packetBuffer.writeIntME(IsaacCipher.selectedItemId);
						var9.packetBuffer.method5746(var3);
						Client.packetWriter.addNode(var9);
					}
				} else if (var2 == 15) {
					var15 = Client.players[var3];
					if (var15 != null) {
						Client.mouseCrossX = var6;
						Client.mouseCrossY = var7;
						Client.mouseCrossColor = 2;
						Client.mouseCrossState = 0;
						Client.destinationX = var0;
						Client.destinationY = var1;
						var9 = class2.getPacketBufferNode(ClientPacket.field2217, Client.packetWriter.isaacCipher);
						var9.packetBuffer.method5569(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var9.packetBuffer.method5746(var3);
						var9.packetBuffer.writeInt(WorldMapDecoration.selectedSpellWidget);
						var9.packetBuffer.writeIntME(Client.selectedSpellChildIndex);
						Client.packetWriter.addNode(var9);
					}
				} else if (var2 == 16) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = class2.getPacketBufferNode(ClientPacket.field2257, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5720(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShort(KeyHandler.selectedItemSlot);
					var8.packetBuffer.writeShortLE(Occluder.selectedItemWidget);
					var8.packetBuffer.method5746(IsaacCipher.selectedItemId);
					var8.packetBuffer.method5746(var3);
					var8.packetBuffer.method5746(ScriptEvent.baseY * 64 + var1);
					var8.packetBuffer.writeIntME(MusicPatchPcmStream.baseX * 64 + var0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 17) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = class2.getPacketBufferNode(ClientPacket.field2263, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeInt(WorldMapDecoration.selectedSpellWidget);
					var8.packetBuffer.writeIntME(ScriptEvent.baseY * 64 + var1);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5746(var3);
					var8.packetBuffer.method5746(MusicPatchPcmStream.baseX * 64 + var0);
					var8.packetBuffer.method5579(Client.selectedSpellChildIndex);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 18) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = class2.getPacketBufferNode(ClientPacket.field2201, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeIntME(var3);
					var8.packetBuffer.method5746(ScriptEvent.baseY * 64 + var1);
					var8.packetBuffer.method5720(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5579(MusicPatchPcmStream.baseX * 64 + var0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 19) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = class2.getPacketBufferNode(ClientPacket.field2189, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5720(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5746(ScriptEvent.baseY * 64 + var1);
					var8.packetBuffer.writeShort(MusicPatchPcmStream.baseX * 64 + var0);
					var8.packetBuffer.method5579(var3);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 20) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = class2.getPacketBufferNode(ClientPacket.field2272, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5579(MusicPatchPcmStream.baseX * 64 + var0);
					var8.packetBuffer.method5569(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeIntME(var3);
					var8.packetBuffer.method5746(ScriptEvent.baseY * 64 + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 21) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = class2.getPacketBufferNode(ClientPacket.field2243, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeIntME(MusicPatchPcmStream.baseX * 64 + var0);
					var8.packetBuffer.writeShort(var3);
					var8.packetBuffer.writeIntME(ScriptEvent.baseY * 64 + var1);
					var8.packetBuffer.method5696(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 22) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = class2.getPacketBufferNode(ClientPacket.field2258, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5746(ScriptEvent.baseY * 64 + var1);
					var8.packetBuffer.method5746(var3);
					var8.packetBuffer.method5696(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5746(MusicPatchPcmStream.baseX * 64 + var0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 23) {
					if (Client.isMenuOpen) {
						class14.scene.setViewportWalking();
					} else {
						class14.scene.menuOpen(UrlRequest.Client_plane, var0, var1, true);
					}
				} else {
					PacketBufferNode var10;
					Widget var16;
					if (var2 == 24) {
						var16 = Tile.getWidget(var1);
						boolean var12 = true;
						if (var16.contentType > 0) {
							var12 = GrandExchangeOfferNameComparator.method136(var16);
						}

						if (var12) {
							var10 = class2.getPacketBufferNode(ClientPacket.field2220, Client.packetWriter.isaacCipher);
							var10.packetBuffer.writeInt(var1);
							Client.packetWriter.addNode(var10);
						}
					} else {
						if (var2 == 25) {
							var16 = BZip2State.getWidgetChild(var1, var0);
							if (var16 != null) {
								GrandExchangeOfferUnitPriceComparator.Widget_runOnTargetLeave();
								WorldMapData_0.selectSpell(var1, var0, class14.method157(WorldMapSection0.getWidgetClickMask(var16)), var16.itemId);
								Client.isItemSelected = 0;
								Client.selectedSpellActionName = class60.method1167(var16);
								if (Client.selectedSpellActionName == null) {
									Client.selectedSpellActionName = "null";
								}

								if (var16.isIf3) {
									Client.selectedSpellName = var16.dataText + NPC.colorStartTag(16777215);
								} else {
									Client.selectedSpellName = NPC.colorStartTag(65280) + var16.spellName + NPC.colorStartTag(16777215);
								}
							}

							return;
						}

						if (var2 == 26) {
							Clock.method3488();
						} else {
							int var11;
							Widget var14;
							if (var2 == 28) {
								var8 = class2.getPacketBufferNode(ClientPacket.field2220, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = Tile.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var11 = var14.cs1Instructions[0][1];
									Varps.Varps_main[var11] = 1 - Varps.Varps_main[var11];
									BufferedSink.changeGameOptions(var11);
								}
							} else if (var2 == 29) {
								var8 = class2.getPacketBufferNode(ClientPacket.field2220, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = Tile.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var11 = var14.cs1Instructions[0][1];
									if (Varps.Varps_main[var11] != var14.cs1ComparisonValues[0]) {
										Varps.Varps_main[var11] = var14.cs1ComparisonValues[0];
										BufferedSink.changeGameOptions(var11);
									}
								}
							} else if (var2 == 30) {
								if (Client.meslayerContinueWidget == null) {
									WorldMapRectangle.resumePauseWidget(var1, var0);
									Client.meslayerContinueWidget = BZip2State.getWidgetChild(var1, var0);
									LoginPacket.invalidateWidget(Client.meslayerContinueWidget);
								}
							} else if (var2 == 31) {
								var8 = class2.getPacketBufferNode(ClientPacket.field2185, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5746(IsaacCipher.selectedItemId);
								var8.packetBuffer.method5587(Occluder.selectedItemWidget);
								var8.packetBuffer.writeIntME(KeyHandler.selectedItemSlot);
								var8.packetBuffer.method5587(var1);
								var8.packetBuffer.method5746(var3);
								var8.packetBuffer.method5579(var0);
								Client.packetWriter.addNode(var8);
								Client.field764 = 0;
								class192.field2372 = Tile.getWidget(var1);
								Client.field735 = var0;
							} else if (var2 == 32) {
								var8 = class2.getPacketBufferNode(ClientPacket.field2237, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5579(var0);
								var8.packetBuffer.method5744(WorldMapDecoration.selectedSpellWidget);
								var8.packetBuffer.writeIntME(var3);
								var8.packetBuffer.writeIntME(Client.selectedSpellChildIndex);
								var8.packetBuffer.method5587(var1);
								Client.packetWriter.addNode(var8);
								Client.field764 = 0;
								class192.field2372 = Tile.getWidget(var1);
								Client.field735 = var0;
							} else if (var2 == 33) {
								var8 = class2.getPacketBufferNode(ClientPacket.field2207, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5587(var1);
								var8.packetBuffer.writeIntME(var3);
								var8.packetBuffer.method5579(var0);
								Client.packetWriter.addNode(var8);
								Client.field764 = 0;
								class192.field2372 = Tile.getWidget(var1);
								Client.field735 = var0;
							} else if (var2 == 34) {
								var8 = class2.getPacketBufferNode(ClientPacket.field2261, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5746(var0);
								var8.packetBuffer.writeShort(var3);
								var8.packetBuffer.method5587(var1);
								Client.packetWriter.addNode(var8);
								Client.field764 = 0;
								class192.field2372 = Tile.getWidget(var1);
								Client.field735 = var0;
							} else if (var2 == 35) {
								var8 = class2.getPacketBufferNode(ClientPacket.field2197, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeShortLE(var1);
								var8.packetBuffer.method5579(var0);
								var8.packetBuffer.writeShort(var3);
								Client.packetWriter.addNode(var8);
								Client.field764 = 0;
								class192.field2372 = Tile.getWidget(var1);
								Client.field735 = var0;
							} else if (var2 == 36) {
								var8 = class2.getPacketBufferNode(ClientPacket.field2190, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5579(var3);
								var8.packetBuffer.writeShortLE(var1);
								var8.packetBuffer.writeShort(var0);
								Client.packetWriter.addNode(var8);
								Client.field764 = 0;
								class192.field2372 = Tile.getWidget(var1);
								Client.field735 = var0;
							} else if (var2 == 37) {
								var8 = class2.getPacketBufferNode(ClientPacket.field2227, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5746(var0);
								var8.packetBuffer.method5746(var3);
								var8.packetBuffer.method5587(var1);
								Client.packetWriter.addNode(var8);
								Client.field764 = 0;
								class192.field2372 = Tile.getWidget(var1);
								Client.field735 = var0;
							} else {
								if (var2 == 38) {
									GrandExchangeOfferUnitPriceComparator.Widget_runOnTargetLeave();
									var16 = Tile.getWidget(var1);
									Client.isItemSelected = 1;
									KeyHandler.selectedItemSlot = var0;
									Occluder.selectedItemWidget = var1;
									IsaacCipher.selectedItemId = var3;
									LoginPacket.invalidateWidget(var16);
									Client.selectedItemName = NPC.colorStartTag(16748608) + PacketBufferNode.ItemDefinition_get(var3).name + NPC.colorStartTag(16777215);
									if (Client.selectedItemName == null) {
										Client.selectedItemName = "null";
									}

									return;
								}

								if (var2 == 39) {
									var8 = class2.getPacketBufferNode(ClientPacket.field2196, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5744(var1);
									var8.packetBuffer.writeIntME(var0);
									var8.packetBuffer.writeIntME(var3);
									Client.packetWriter.addNode(var8);
									Client.field764 = 0;
									class192.field2372 = Tile.getWidget(var1);
									Client.field735 = var0;
								} else if (var2 == 40) {
									var8 = class2.getPacketBufferNode(ClientPacket.field2253, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5746(var0);
									var8.packetBuffer.method5587(var1);
									var8.packetBuffer.method5746(var3);
									Client.packetWriter.addNode(var8);
									Client.field764 = 0;
									class192.field2372 = Tile.getWidget(var1);
									Client.field735 = var0;
								} else if (var2 == 41) {
									var8 = class2.getPacketBufferNode(ClientPacket.field2247, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5746(var0);
									var8.packetBuffer.writeInt(var1);
									var8.packetBuffer.writeShort(var3);
									Client.packetWriter.addNode(var8);
									Client.field764 = 0;
									class192.field2372 = Tile.getWidget(var1);
									Client.field735 = var0;
								} else if (var2 == 42) {
									var8 = class2.getPacketBufferNode(ClientPacket.field2211, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5579(var3);
									var8.packetBuffer.writeShort(var0);
									var8.packetBuffer.writeInt(var1);
									Client.packetWriter.addNode(var8);
									Client.field764 = 0;
									class192.field2372 = Tile.getWidget(var1);
									Client.field735 = var0;
								} else if (var2 == 43) {
									var8 = class2.getPacketBufferNode(ClientPacket.field2181, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5587(var1);
									var8.packetBuffer.writeIntME(var0);
									var8.packetBuffer.writeShort(var3);
									Client.packetWriter.addNode(var8);
									Client.field764 = 0;
									class192.field2372 = Tile.getWidget(var1);
									Client.field735 = var0;
								} else if (var2 == 44) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = class2.getPacketBufferNode(ClientPacket.field2222, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5746(var3);
										var9.packetBuffer.method5569(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 45) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = class2.getPacketBufferNode(ClientPacket.field2250, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5696(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeIntME(var3);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 46) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = class2.getPacketBufferNode(ClientPacket.field2269, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5720(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeShort(var3);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 47) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = class2.getPacketBufferNode(ClientPacket.field2273, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5696(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeIntME(var3);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 48) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = class2.getPacketBufferNode(ClientPacket.field2267, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeShort(var3);
										var9.packetBuffer.method5720(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 49) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = class2.getPacketBufferNode(ClientPacket.field2214, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5720(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5579(var3);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 50) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = class2.getPacketBufferNode(ClientPacket.field2235, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5720(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5746(var3);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 51) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = class2.getPacketBufferNode(ClientPacket.field2203, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeShort(var3);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										Client.packetWriter.addNode(var9);
									}
								} else {
									label888: {
										if (var2 != 57) {
											if (var2 == 58) {
												var16 = BZip2State.getWidgetChild(var1, var0);
												if (var16 != null) {
													var9 = class2.getPacketBufferNode(ClientPacket.field2275, Client.packetWriter.isaacCipher);
													var9.packetBuffer.method5746(var0);
													var9.packetBuffer.writeShortLE(var1);
													var9.packetBuffer.method5579(Client.selectedSpellChildIndex);
													var9.packetBuffer.method5746(var16.itemId);
													var9.packetBuffer.method5746(Client.field785);
													var9.packetBuffer.method5744(WorldMapDecoration.selectedSpellWidget);
													Client.packetWriter.addNode(var9);
												}
												break label888;
											}

											if (var2 == 1001) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												Client.destinationX = var0;
												Client.destinationY = var1;
												var8 = class2.getPacketBufferNode(ClientPacket.field2230, Client.packetWriter.isaacCipher);
												var8.packetBuffer.method5746(var3);
												var8.packetBuffer.method5579(ScriptEvent.baseY * 64 + var1);
												var8.packetBuffer.writeShort(MusicPatchPcmStream.baseX * 64 + var0);
												var8.packetBuffer.method5720(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
												Client.packetWriter.addNode(var8);
												break label888;
											}

											if (var2 == 1002) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = class2.getPacketBufferNode(ClientPacket.field2184, Client.packetWriter.isaacCipher);
												var8.packetBuffer.writeIntME(var3);
												Client.packetWriter.addNode(var8);
												break label888;
											}

											if (var2 == 1003) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var13 = Client.npcs[var3];
												if (var13 != null) {
													NPCDefinition var17 = var13.definition;
													if (var17.transforms != null) {
														var17 = var17.transform();
													}

													if (var17 != null) {
														var10 = class2.getPacketBufferNode(ClientPacket.field2194, Client.packetWriter.isaacCipher);
														var10.packetBuffer.writeIntME(var17.id);
														Client.packetWriter.addNode(var10);
													}
												}
												break label888;
											}

											if (var2 == 1004) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = class2.getPacketBufferNode(ClientPacket.field2234, Client.packetWriter.isaacCipher);
												var8.packetBuffer.method5746(var3);
												Client.packetWriter.addNode(var8);
												break label888;
											}

											if (var2 == 1005) {
												var16 = Tile.getWidget(var1);
												if (var16 != null && var16.itemQuantities[var0] >= 100000) {
													class83.addGameMessage(27, "", var16.itemQuantities[var0] + " x " + PacketBufferNode.ItemDefinition_get(var3).name);
												} else {
													var9 = class2.getPacketBufferNode(ClientPacket.field2234, Client.packetWriter.isaacCipher);
													var9.packetBuffer.method5746(var3);
													Client.packetWriter.addNode(var9);
												}

												Client.field764 = 0;
												class192.field2372 = Tile.getWidget(var1);
												Client.field735 = var0;
												break label888;
											}

											if (var2 != 1007) {
												if (var2 == 1009 || var2 == 1011 || var2 == 1010 || var2 == 1008 || var2 == 1012) {
													GrandExchangeEvent.worldMap.worldMapMenuAction(var2, var3, new Coord(var0), new Coord(var1));
												}
												break label888;
											}
										}

										var16 = BZip2State.getWidgetChild(var1, var0);
										if (var16 != null) {
											KeyHandler.widgetDefaultMenuAction(var3, var1, var0, var16.itemId, var5);
										}
									}
								}
							}
						}
					}
				}
			}
		}

		if (Client.isItemSelected != 0) {
			Client.isItemSelected = 0;
			LoginPacket.invalidateWidget(Tile.getWidget(Occluder.selectedItemWidget));
		}

		if (Client.isSpellSelected) {
			GrandExchangeOfferUnitPriceComparator.Widget_runOnTargetLeave();
		}

		if (class192.field2372 != null && Client.field764 == 0) {
			LoginPacket.invalidateWidget(class192.field2372);
		}

	}

	@ObfuscatedName("jy")
	@ObfuscatedSignature(
		signature = "(Lha;III)V",
		garbageValue = "2081657202"
	)
	static final void method263(Widget var0, int var1, int var2) {
		if (var0.buttonType == 1) {
			class1.insertMenuItemNoShift(var0.buttonText, "", 24, 0, 0, var0.id);
		}

		String var3;
		if (var0.buttonType == 2 && !Client.isSpellSelected) {
			var3 = class60.method1167(var0);
			if (var3 != null) {
				class1.insertMenuItemNoShift(var3, NPC.colorStartTag(65280) + var0.spellName, 25, 0, -1, var0.id);
			}
		}

		if (var0.buttonType == 3) {
			class1.insertMenuItemNoShift("Close", "", 26, 0, 0, var0.id);
		}

		if (var0.buttonType == 4) {
			class1.insertMenuItemNoShift(var0.buttonText, "", 28, 0, 0, var0.id);
		}

		if (var0.buttonType == 5) {
			class1.insertMenuItemNoShift(var0.buttonText, "", 29, 0, 0, var0.id);
		}

		if (var0.buttonType == 6 && Client.meslayerContinueWidget == null) {
			class1.insertMenuItemNoShift(var0.buttonText, "", 30, 0, -1, var0.id);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		int var13;
		if (var0.type == 2) {
			var13 = 0;

			for (var4 = 0; var4 < var0.height; ++var4) {
				for (var5 = 0; var5 < var0.width; ++var5) {
					var6 = (var0.paddingX + 32) * var5;
					var7 = (var0.paddingY + 32) * var4;
					if (var13 < 20) {
						var6 += var0.inventoryXOffsets[var13];
						var7 += var0.inventoryYOffsets[var13];
					}

					if (var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < var7 + 32) {
						Client.dragItemSlotDestination = var13;
						WorldMapManager.field312 = var0;
						if (var0.itemIds[var13] > 0) {
							ItemDefinition var8 = PacketBufferNode.ItemDefinition_get(var0.itemIds[var13] - 1);
							if (Client.isItemSelected == 1 && class30.method542(WorldMapSection0.getWidgetClickMask(var0))) {
								if (var0.id != Occluder.selectedItemWidget || var13 != KeyHandler.selectedItemSlot) {
									class1.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + NPC.colorStartTag(16748608) + var8.name, 31, var8.id, var13, var0.id);
								}
							} else if (Client.isSpellSelected && class30.method542(WorldMapSection0.getWidgetClickMask(var0))) {
								if ((ReflectionCheck.selectedSpellFlags & 16) == 16) {
									class1.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + NPC.colorStartTag(16748608) + var8.name, 32, var8.id, var13, var0.id);
								}
							} else {
								String[] var9 = var8.inventoryActions;
								int var10 = -1;
								if (Client.shiftClickDrop && WorldMapDecoration.method326()) {
									var10 = var8.getShiftClickIndex();
								}

								int var11;
								if (class30.method542(WorldMapSection0.getWidgetClickMask(var0))) {
									for (var11 = 4; var11 >= 3; --var11) {
										if (var11 != var10) {
											class312.addWidgetItemMenuItem(var0, var8, var13, var11, false);
										}
									}
								}

								if (Varcs.method2195(WorldMapSection0.getWidgetClickMask(var0))) {
									class1.insertMenuItemNoShift("Use", NPC.colorStartTag(16748608) + var8.name, 38, var8.id, var13, var0.id);
								}

								if (class30.method542(WorldMapSection0.getWidgetClickMask(var0))) {
									for (var11 = 2; var11 >= 0; --var11) {
										if (var10 != var11) {
											class312.addWidgetItemMenuItem(var0, var8, var13, var11, false);
										}
									}

									if (var10 >= 0) {
										class312.addWidgetItemMenuItem(var0, var8, var13, var10, true);
									}
								}

								var9 = var0.itemActions;
								if (var9 != null) {
									for (var11 = 4; var11 >= 0; --var11) {
										if (var9[var11] != null) {
											byte var12 = 0;
											if (var11 == 0) {
												var12 = 39;
											}

											if (var11 == 1) {
												var12 = 40;
											}

											if (var11 == 2) {
												var12 = 41;
											}

											if (var11 == 3) {
												var12 = 42;
											}

											if (var11 == 4) {
												var12 = 43;
											}

											class1.insertMenuItemNoShift(var9[var11], NPC.colorStartTag(16748608) + var8.name, var12, var8.id, var13, var0.id);
										}
									}
								}

								class1.insertMenuItemNoShift("Examine", NPC.colorStartTag(16748608) + var8.name, 1005, var8.id, var13, var0.id);
							}
						}
					}

					++var13;
				}
			}
		}

		if (var0.isIf3) {
			if (Client.isSpellSelected) {
				if (Login.method2119(WorldMapSection0.getWidgetClickMask(var0)) && (ReflectionCheck.selectedSpellFlags & 32) == 32) {
					class1.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + var0.dataText, 58, 0, var0.childIndex, var0.id);
				}
			} else {
				for (var13 = 9; var13 >= 5; --var13) {
					var6 = WorldMapSection0.getWidgetClickMask(var0);
					boolean var18 = (var6 >> var13 + 1 & 1) != 0;
					String var14;
					if (!var18 && var0.onOp == null) {
						var14 = null;
					} else if (var0.actions != null && var0.actions.length > var13 && var0.actions[var13] != null && var0.actions[var13].trim().length() != 0) {
						var14 = var0.actions[var13];
					} else {
						var14 = null;
					}

					if (var14 != null) {
						class1.insertMenuItemNoShift(var14, var0.dataText, 1007, var13 + 1, var0.childIndex, var0.id);
					}
				}

				var3 = class60.method1167(var0);
				if (var3 != null) {
					class1.insertMenuItemNoShift(var3, var0.dataText, 25, 0, var0.childIndex, var0.id);
				}

				for (var4 = 4; var4 >= 0; --var4) {
					var7 = WorldMapSection0.getWidgetClickMask(var0);
					boolean var19 = (var7 >> var4 + 1 & 1) != 0;
					String var15;
					if (!var19 && var0.onOp == null) {
						var15 = null;
					} else if (var0.actions != null && var0.actions.length > var4 && var0.actions[var4] != null && var0.actions[var4].trim().length() != 0) {
						var15 = var0.actions[var4];
					} else {
						var15 = null;
					}

					if (var15 != null) {
						AbstractWorldMapIcon.insertMenuItem(var15, var0.dataText, 57, var4 + 1, var0.childIndex, var0.id, var0.field2602);
					}
				}

				var5 = WorldMapSection0.getWidgetClickMask(var0);
				boolean var17 = (var5 & 1) != 0;
				if (var17) {
					class1.insertMenuItemNoShift("Continue", "", 30, 0, var0.childIndex, var0.id);
				}
			}
		}

	}
}
