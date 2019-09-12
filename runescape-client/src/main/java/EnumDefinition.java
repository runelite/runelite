import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("EnumDefinition")
public class EnumDefinition extends DualNode {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("EnumDefinition_archive")
	public static AbstractArchive EnumDefinition_archive;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Let;"
	)
	@Export("EnumDefinition_cached")
	static EvictingDualNodeHashTable EnumDefinition_cached;
	@ObfuscatedName("t")
	@Export("inputType")
	public char inputType;
	@ObfuscatedName("g")
	@Export("outputType")
	public char outputType;
	@ObfuscatedName("l")
	@Export("defaultStr")
	public String defaultStr;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 951352389
	)
	@Export("defaultInt")
	public int defaultInt;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1261756863
	)
	@Export("outputCount")
	public int outputCount;
	@ObfuscatedName("v")
	@Export("keys")
	public int[] keys;
	@ObfuscatedName("d")
	@Export("intVals")
	public int[] intVals;
	@ObfuscatedName("z")
	@Export("strVals")
	public String[] strVals;

	static {
		EnumDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	EnumDefinition() {
		this.defaultStr = "null";
		this.outputCount = 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkz;I)V",
		garbageValue = "13618271"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkz;II)V",
		garbageValue = "700010175"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.inputType = (char)var1.readUnsignedByte();
		} else if (var2 == 2) {
			this.outputType = (char)var1.readUnsignedByte();
		} else if (var2 == 3) {
			this.defaultStr = var1.readStringCp1252NullTerminated();
		} else if (var2 == 4) {
			this.defaultInt = var1.readInt();
		} else {
			int var3;
			if (var2 == 5) {
				this.outputCount = var1.readUnsignedShort();
				this.keys = new int[this.outputCount];
				this.strVals = new String[this.outputCount];

				for (var3 = 0; var3 < this.outputCount; ++var3) {
					this.keys[var3] = var1.readInt();
					this.strVals[var3] = var1.readStringCp1252NullTerminated();
				}
			} else if (var2 == 6) {
				this.outputCount = var1.readUnsignedShort();
				this.keys = new int[this.outputCount];
				this.intVals = new int[this.outputCount];

				for (var3 = 0; var3 < this.outputCount; ++var3) {
					this.keys[var3] = var1.readInt();
					this.intVals[var3] = var1.readInt();
				}
			}
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1670298878"
	)
	@Export("size")
	public int size() {
		return this.outputCount;
	}

	@ObfuscatedName("gy")
	@ObfuscatedSignature(
		signature = "(IIIIII)V",
		garbageValue = "-509894007"
	)
	@Export("drawObject")
	static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
		long var5 = WorldMapIcon_1.scene.getBoundaryObjectTag(var0, var1, var2);
		int var7;
		int var8;
		int var9;
		int var10;
		int var14;
		int var26;
		if (0L != var5) {
			var7 = WorldMapIcon_1.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = var3;
			boolean var12 = var5 != 0L;
			if (var12) {
				boolean var13 = (int)(var5 >>> 16 & 1L) == 1;
				var12 = !var13;
			}

			if (var12) {
				var10 = var4;
			}

			int[] var19 = class60.sceneMinimapSprite.pixels;
			var26 = var1 * 4 + (103 - var2) * 2048 + 24624;
			var14 = SecureRandomFuture.Entity_unpackID(var5);
			ObjectDefinition var15 = WallDecoration.getObjectDefinition(var14);
			if (var15.mapSceneId != -1) {
				IndexedSprite var16 = class287.mapSceneSprites[var15.mapSceneId];
				if (var16 != null) {
					int var17 = (var15.sizeX * 4 - var16.subWidth) / 2;
					int var18 = (var15.sizeY * 4 - var16.subHeight) / 2;
					var16.drawAt(var17 + var1 * 4 + 48, var18 + (104 - var2 - var15.sizeY) * 4 + 48);
				}
			} else {
				if (var9 == 0 || var9 == 2) {
					if (var8 == 0) {
						var19[var26] = var10;
						var19[var26 + 512] = var10;
						var19[var26 + 1024] = var10;
						var19[var26 + 1536] = var10;
					} else if (var8 == 1) {
						var19[var26] = var10;
						var19[var26 + 1] = var10;
						var19[var26 + 2] = var10;
						var19[var26 + 3] = var10;
					} else if (var8 == 2) {
						var19[var26 + 3] = var10;
						var19[var26 + 512 + 3] = var10;
						var19[var26 + 1024 + 3] = var10;
						var19[var26 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var19[var26 + 1536] = var10;
						var19[var26 + 1536 + 1] = var10;
						var19[var26 + 1536 + 2] = var10;
						var19[var26 + 1536 + 3] = var10;
					}
				}

				if (var9 == 3) {
					if (var8 == 0) {
						var19[var26] = var10;
					} else if (var8 == 1) {
						var19[var26 + 3] = var10;
					} else if (var8 == 2) {
						var19[var26 + 1536 + 3] = var10;
					} else if (var8 == 3) {
						var19[var26 + 1536] = var10;
					}
				}

				if (var9 == 2) {
					if (var8 == 3) {
						var19[var26] = var10;
						var19[var26 + 512] = var10;
						var19[var26 + 1024] = var10;
						var19[var26 + 1536] = var10;
					} else if (var8 == 0) {
						var19[var26] = var10;
						var19[var26 + 1] = var10;
						var19[var26 + 2] = var10;
						var19[var26 + 3] = var10;
					} else if (var8 == 1) {
						var19[var26 + 3] = var10;
						var19[var26 + 512 + 3] = var10;
						var19[var26 + 1024 + 3] = var10;
						var19[var26 + 1536 + 3] = var10;
					} else if (var8 == 2) {
						var19[var26 + 1536] = var10;
						var19[var26 + 1536 + 1] = var10;
						var19[var26 + 1536 + 2] = var10;
						var19[var26 + 1536 + 3] = var10;
					}
				}
			}
		}

		var5 = WorldMapIcon_1.scene.getGameObjectTag(var0, var1, var2);
		if (0L != var5) {
			var7 = WorldMapIcon_1.scene.getObjectFlags(var0, var1, var2, var5);
			var8 = var7 >> 6 & 3;
			var9 = var7 & 31;
			var10 = SecureRandomFuture.Entity_unpackID(var5);
			ObjectDefinition var20 = WallDecoration.getObjectDefinition(var10);
			if (var20.mapSceneId != -1) {
				IndexedSprite var28 = class287.mapSceneSprites[var20.mapSceneId];
				if (var28 != null) {
					var26 = (var20.sizeX * 4 - var28.subWidth) / 2;
					var14 = (var20.sizeY * 4 - var28.subHeight) / 2;
					var28.drawAt(var26 + var1 * 4 + 48, (104 - var2 - var20.sizeY) * 4 + var14 + 48);
				}
			} else if (var9 == 9) {
				int var25 = 15658734;
				boolean var27 = var5 != 0L;
				if (var27) {
					boolean var23 = (int)(var5 >>> 16 & 1L) == 1;
					var27 = !var23;
				}

				if (var27) {
					var25 = 15597568;
				}

				int[] var24 = class60.sceneMinimapSprite.pixels;
				int var29 = var1 * 4 + (103 - var2) * 2048 + 24624;
				if (var8 != 0 && var8 != 2) {
					var24[var29] = var25;
					var24[var29 + 1 + 512] = var25;
					var24[var29 + 1024 + 2] = var25;
					var24[var29 + 1536 + 3] = var25;
				} else {
					var24[var29 + 1536] = var25;
					var24[var29 + 1 + 1024] = var25;
					var24[var29 + 512 + 2] = var25;
					var24[var29 + 3] = var25;
				}
			}
		}

		var5 = WorldMapIcon_1.scene.getFloorDecorationTag(var0, var1, var2);
		if (0L != var5) {
			var7 = SecureRandomFuture.Entity_unpackID(var5);
			ObjectDefinition var21 = WallDecoration.getObjectDefinition(var7);
			if (var21.mapSceneId != -1) {
				IndexedSprite var22 = class287.mapSceneSprites[var21.mapSceneId];
				if (var22 != null) {
					var10 = (var21.sizeX * 4 - var22.subWidth) / 2;
					int var11 = (var21.sizeY * 4 - var22.subHeight) / 2;
					var22.drawAt(var1 * 4 + var10 + 48, (104 - var2 - var21.sizeY) * 4 + var11 + 48);
				}
			}
		}

	}

	@ObfuscatedName("hb")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
		garbageValue = "1334769437"
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
			var8 = MenuAction.getPacketBufferNode(ClientPacket.field2244, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5491(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(DevicePcmPlayerProvider.selectedItemId);
			var8.packetBuffer.method5502(var3);
			var8.packetBuffer.writeIntME(class4.baseX * 64 + var0);
			var8.packetBuffer.method5500(ModelData0.selectedItemSlot);
			var8.packetBuffer.writeInt(MusicPatchPcmStream.selectedItemWidget);
			var8.packetBuffer.method5502(ScriptEvent.baseY + var1);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 2) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = MenuAction.getPacketBufferNode(ClientPacket.field2196, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntLE16(class83.field1138);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.method5500(ScriptEvent.baseY + var1);
			var8.packetBuffer.method5566(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntME(Client.field687);
			var8.packetBuffer.writeIntME(class4.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 3) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = MenuAction.getPacketBufferNode(ClientPacket.field2221, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5491(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5500(ScriptEvent.baseY + var1);
			var8.packetBuffer.writeShort(class4.baseX * 64 + var0);
			var8.packetBuffer.method5502(var3);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 4) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = MenuAction.getPacketBufferNode(ClientPacket.field2253, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntME(ScriptEvent.baseY + var1);
			var8.packetBuffer.method5502(var3);
			var8.packetBuffer.method5500(class4.baseX * 64 + var0);
			var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 5) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = MenuAction.getPacketBufferNode(ClientPacket.field2226, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5491(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntME(ScriptEvent.baseY + var1);
			var8.packetBuffer.writeIntME(var3);
			var8.packetBuffer.method5500(class4.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 6) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = MenuAction.getPacketBufferNode(ClientPacket.field2227, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5502(var3);
			var8.packetBuffer.writeIntME(ScriptEvent.baseY + var1);
			var8.packetBuffer.method5493(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntME(class4.baseX * 64 + var0);
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
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2225, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeInt(MusicPatchPcmStream.selectedItemWidget);
					var9.packetBuffer.method5493(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5500(ModelData0.selectedItemSlot);
					var9.packetBuffer.method5502(DevicePcmPlayerProvider.selectedItemId);
					var9.packetBuffer.method5500(var3);
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
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2280, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5502(Client.field687);
					var9.packetBuffer.writeIntLE16(class83.field1138);
					var9.packetBuffer.method5500(var3);
					var9.packetBuffer.method5493(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2214, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeShort(var3);
					var9.packetBuffer.method5493(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2286, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5566(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeShort(var3);
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
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2240, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5491(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeIntME(var3);
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
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2220, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5502(var3);
					var9.packetBuffer.method5491(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2275, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5493(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5500(var3);
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
						var9 = MenuAction.getPacketBufferNode(ClientPacket.field2210, Client.packetWriter.isaacCipher);
						var9.packetBuffer.method5491(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var9.packetBuffer.method5502(ModelData0.selectedItemSlot);
						var9.packetBuffer.method5500(DevicePcmPlayerProvider.selectedItemId);
						var9.packetBuffer.writeIntLE16(MusicPatchPcmStream.selectedItemWidget);
						var9.packetBuffer.writeShort(var3);
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
						var9 = MenuAction.getPacketBufferNode(ClientPacket.field2194, Client.packetWriter.isaacCipher);
						var9.packetBuffer.writeIntLE(class83.field1138);
						var9.packetBuffer.writeShort(var3);
						var9.packetBuffer.method5500(Client.field687);
						var9.packetBuffer.method5566(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						Client.packetWriter.addNode(var9);
					}
				} else if (var2 == 16) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2238, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShort(class4.baseX * 64 + var0);
					var8.packetBuffer.method5502(var3);
					var8.packetBuffer.method5502(DevicePcmPlayerProvider.selectedItemId);
					var8.packetBuffer.writeShort(ScriptEvent.baseY + var1);
					var8.packetBuffer.writeInt(MusicPatchPcmStream.selectedItemWidget);
					var8.packetBuffer.method5500(ModelData0.selectedItemSlot);
					var8.packetBuffer.method5493(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 17) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2233, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeIntLE(class83.field1138);
					var8.packetBuffer.writeShort(Client.field687);
					var8.packetBuffer.method5500(ScriptEvent.baseY + var1);
					var8.packetBuffer.method5500(var3);
					var8.packetBuffer.method5500(class4.baseX * 64 + var0);
					var8.packetBuffer.method5491(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 18) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2186, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShort(var3);
					var8.packetBuffer.method5502(ScriptEvent.baseY + var1);
					var8.packetBuffer.method5566(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5500(class4.baseX * 64 + var0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 19) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2259, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeIntME(class4.baseX * 64 + var0);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5500(var3);
					var8.packetBuffer.method5502(ScriptEvent.baseY + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 20) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2198, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeIntME(ScriptEvent.baseY + var1);
					var8.packetBuffer.method5500(var3);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5502(class4.baseX * 64 + var0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 21) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2206, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5493(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5502(class4.baseX * 64 + var0);
					var8.packetBuffer.method5502(var3);
					var8.packetBuffer.writeShort(ScriptEvent.baseY + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 22) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2188, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeIntME(var3);
					var8.packetBuffer.method5500(class4.baseX * 64 + var0);
					var8.packetBuffer.method5566(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5500(ScriptEvent.baseY + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 23) {
					if (Client.isMenuOpen) {
						WorldMapIcon_1.scene.setViewportWalking();
					} else {
						WorldMapIcon_1.scene.menuOpen(MouseRecorder.plane, var0, var1, true);
					}
				} else {
					PacketBufferNode var11;
					Widget var16;
					if (var2 == 24) {
						var16 = Player.getWidget(var1);
						boolean var12 = true;
						if (var16.contentType > 0) {
							var12 = class49.method825(var16);
						}

						if (var12) {
							var11 = MenuAction.getPacketBufferNode(ClientPacket.field2283, Client.packetWriter.isaacCipher);
							var11.packetBuffer.writeInt(var1);
							Client.packetWriter.addNode(var11);
						}
					} else {
						if (var2 == 25) {
							var16 = class49.getWidgetChild(var1, var0);
							if (var16 != null) {
								FloorDecoration.Widget_runOnTargetLeave();
								Player.method1196(var1, var0, WorldMapElement.method4390(class60.getWidgetClickMask(var16)), var16.itemId);
								Client.isItemSelected = 0;
								Client.selectedSpellActionName = class16.method165(var16);
								if (Client.selectedSpellActionName == null) {
									Client.selectedSpellActionName = "null";
								}

								if (var16.isIf3) {
									Client.selectedSpellName = var16.dataText + UserComparator7.colorStartTag(16777215);
								} else {
									Client.selectedSpellName = UserComparator7.colorStartTag(65280) + var16.spellName + UserComparator7.colorStartTag(16777215);
								}
							}

							return;
						}

						if (var2 == 26) {
							GrandExchangeEvent.method73();
						} else {
							int var10;
							Widget var14;
							if (var2 == 28) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2283, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = Player.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var10 = var14.cs1Instructions[0][1];
									Varps.Varps_main[var10] = 1 - Varps.Varps_main[var10];
									Players.method2123(var10);
								}
							} else if (var2 == 29) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2283, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = Player.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var10 = var14.cs1Instructions[0][1];
									if (Varps.Varps_main[var10] != var14.cs1ComparisonValues[0]) {
										Varps.Varps_main[var10] = var14.cs1ComparisonValues[0];
										Players.method2123(var10);
									}
								}
							} else if (var2 == 30) {
								if (Client.meslayerContinueWidget == null) {
									WorldMapSection1.resumePauseWidget(var1, var0);
									Client.meslayerContinueWidget = class49.getWidgetChild(var1, var0);
									WorldMapID.invalidateWidget(Client.meslayerContinueWidget);
								}
							} else if (var2 == 31) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2260, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntME(var3);
								var8.packetBuffer.writeInt(MusicPatchPcmStream.selectedItemWidget);
								var8.packetBuffer.method5500(ModelData0.selectedItemSlot);
								var8.packetBuffer.writeIntME(var0);
								var8.packetBuffer.writeShortLE(var1);
								var8.packetBuffer.method5502(DevicePcmPlayerProvider.selectedItemId);
								Client.packetWriter.addNode(var8);
								Client.field727 = 0;
								Entity.field1835 = Player.getWidget(var1);
								Client.field728 = var0;
							} else if (var2 == 32) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2219, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeShort(Client.field687);
								var8.packetBuffer.method5500(var0);
								var8.packetBuffer.writeShortLE(var1);
								var8.packetBuffer.method5500(var3);
								var8.packetBuffer.writeIntLE16(class83.field1138);
								Client.packetWriter.addNode(var8);
								Client.field727 = 0;
								Entity.field1835 = Player.getWidget(var1);
								Client.field728 = var0;
							} else if (var2 == 33) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2256, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntME(var3);
								var8.packetBuffer.writeIntME(var0);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								Client.field727 = 0;
								Entity.field1835 = Player.getWidget(var1);
								Client.field728 = var0;
							} else if (var2 == 34) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2192, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5500(var3);
								var8.packetBuffer.writeIntME(var0);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								Client.field727 = 0;
								Entity.field1835 = Player.getWidget(var1);
								Client.field728 = var0;
							} else if (var2 == 35) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2261, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntLE(var1);
								var8.packetBuffer.method5502(var3);
								var8.packetBuffer.method5500(var0);
								Client.packetWriter.addNode(var8);
								Client.field727 = 0;
								Entity.field1835 = Player.getWidget(var1);
								Client.field728 = var0;
							} else if (var2 == 36) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2264, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntME(var0);
								var8.packetBuffer.writeShortLE(var1);
								var8.packetBuffer.method5502(var3);
								Client.packetWriter.addNode(var8);
								Client.field727 = 0;
								Entity.field1835 = Player.getWidget(var1);
								Client.field728 = var0;
							} else if (var2 == 37) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2277, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntME(var0);
								var8.packetBuffer.writeShortLE(var1);
								var8.packetBuffer.writeShort(var3);
								Client.packetWriter.addNode(var8);
								Client.field727 = 0;
								Entity.field1835 = Player.getWidget(var1);
								Client.field728 = var0;
							} else {
								if (var2 == 38) {
									FloorDecoration.Widget_runOnTargetLeave();
									var16 = Player.getWidget(var1);
									Client.isItemSelected = 1;
									ModelData0.selectedItemSlot = var0;
									MusicPatchPcmStream.selectedItemWidget = var1;
									DevicePcmPlayerProvider.selectedItemId = var3;
									WorldMapID.invalidateWidget(var16);
									Client.selectedItemName = UserComparator7.colorStartTag(16748608) + Player.ItemDefinition_get(var3).name + UserComparator7.colorStartTag(16777215);
									if (Client.selectedItemName == null) {
										Client.selectedItemName = "null";
									}

									return;
								}

								if (var2 == 39) {
									var8 = MenuAction.getPacketBufferNode(ClientPacket.field2234, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeIntLE16(var1);
									var8.packetBuffer.method5500(var0);
									var8.packetBuffer.method5502(var3);
									Client.packetWriter.addNode(var8);
									Client.field727 = 0;
									Entity.field1835 = Player.getWidget(var1);
									Client.field728 = var0;
								} else if (var2 == 40) {
									var8 = MenuAction.getPacketBufferNode(ClientPacket.field2269, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeShortLE(var1);
									var8.packetBuffer.method5500(var0);
									var8.packetBuffer.method5500(var3);
									Client.packetWriter.addNode(var8);
									Client.field727 = 0;
									Entity.field1835 = Player.getWidget(var1);
									Client.field728 = var0;
								} else if (var2 == 41) {
									var8 = MenuAction.getPacketBufferNode(ClientPacket.field2282, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeIntLE(var1);
									var8.packetBuffer.method5500(var3);
									var8.packetBuffer.writeShort(var0);
									Client.packetWriter.addNode(var8);
									Client.field727 = 0;
									Entity.field1835 = Player.getWidget(var1);
									Client.field728 = var0;
								} else if (var2 == 42) {
									var8 = MenuAction.getPacketBufferNode(ClientPacket.field2203, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5500(var0);
									var8.packetBuffer.writeIntLE16(var1);
									var8.packetBuffer.writeShort(var3);
									Client.packetWriter.addNode(var8);
									Client.field727 = 0;
									Entity.field1835 = Player.getWidget(var1);
									Client.field728 = var0;
								} else if (var2 == 43) {
									var8 = MenuAction.getPacketBufferNode(ClientPacket.field2243, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5500(var0);
									var8.packetBuffer.writeIntME(var3);
									var8.packetBuffer.writeInt(var1);
									Client.packetWriter.addNode(var8);
									Client.field727 = 0;
									Entity.field1835 = Player.getWidget(var1);
									Client.field728 = var0;
								} else if (var2 == 44) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2237, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5500(var3);
										var9.packetBuffer.method5566(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2215, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2204, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5500(var3);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2248, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5500(var3);
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
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2212, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5502(var3);
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
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2250, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5502(var3);
										var9.packetBuffer.method5491(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2268, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5491(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5500(var3);
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
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2211, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5500(var3);
										var9.packetBuffer.method5566(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										Client.packetWriter.addNode(var9);
									}
								} else {
									label642: {
										if (var2 != 57) {
											if (var2 == 58) {
												var16 = class49.getWidgetChild(var1, var0);
												if (var16 != null) {
													var9 = MenuAction.getPacketBufferNode(ClientPacket.field2229, Client.packetWriter.isaacCipher);
													var9.packetBuffer.writeShortLE(class83.field1138);
													var9.packetBuffer.writeIntME(Client.field687);
													var9.packetBuffer.writeIntLE(var1);
													var9.packetBuffer.writeShort(var0);
													var9.packetBuffer.writeIntME(Client.field648);
													var9.packetBuffer.writeShort(var16.itemId);
													Client.packetWriter.addNode(var9);
												}
												break label642;
											}

											if (var2 == 1001) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												Client.destinationX = var0;
												Client.destinationY = var1;
												var8 = MenuAction.getPacketBufferNode(ClientPacket.field2209, Client.packetWriter.isaacCipher);
												var8.packetBuffer.writeIntME(ScriptEvent.baseY + var1);
												var8.packetBuffer.writeShort(var3);
												var8.packetBuffer.method5500(class4.baseX * 64 + var0);
												var8.packetBuffer.method5493(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
												Client.packetWriter.addNode(var8);
												break label642;
											}

											if (var2 == 1002) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = MenuAction.getPacketBufferNode(ClientPacket.field2232, Client.packetWriter.isaacCipher);
												var8.packetBuffer.writeIntME(var3);
												Client.packetWriter.addNode(var8);
												break label642;
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
														var11 = MenuAction.getPacketBufferNode(ClientPacket.field2230, Client.packetWriter.isaacCipher);
														var11.packetBuffer.method5500(var17.id);
														Client.packetWriter.addNode(var11);
													}
												}
												break label642;
											}

											if (var2 == 1004) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = MenuAction.getPacketBufferNode(ClientPacket.field2205, Client.packetWriter.isaacCipher);
												var8.packetBuffer.method5500(var3);
												Client.packetWriter.addNode(var8);
												break label642;
											}

											if (var2 == 1005) {
												var16 = Player.getWidget(var1);
												if (var16 != null && var16.itemQuantities[var0] >= 100000) {
													WorldMapCacheName.addGameMessage(27, "", var16.itemQuantities[var0] + " x " + Player.ItemDefinition_get(var3).name);
												} else {
													var9 = MenuAction.getPacketBufferNode(ClientPacket.field2205, Client.packetWriter.isaacCipher);
													var9.packetBuffer.method5500(var3);
													Client.packetWriter.addNode(var9);
												}

												Client.field727 = 0;
												Entity.field1835 = Player.getWidget(var1);
												Client.field728 = var0;
												break label642;
											}

											if (var2 != 1007) {
												if (var2 == 1010 || var2 == 1008 || var2 == 1009 || var2 == 1011 || var2 == 1012) {
													GrandExchangeOfferUnitPriceComparator.worldMap.menuAction(var2, var3, new Coord(var0), new Coord(var1));
												}
												break label642;
											}
										}

										var16 = class49.getWidgetChild(var1, var0);
										if (var16 != null) {
											TileItem.method2093(var3, var1, var0, var16.itemId, var5);
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
			WorldMapID.invalidateWidget(Player.getWidget(MusicPatchPcmStream.selectedItemWidget));
		}

		if (Client.isSpellSelected) {
			FloorDecoration.Widget_runOnTargetLeave();
		}

		if (Entity.field1835 != null && Client.field727 == 0) {
			WorldMapID.invalidateWidget(Entity.field1835);
		}

	}
}
