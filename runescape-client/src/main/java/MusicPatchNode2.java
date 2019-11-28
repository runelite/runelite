import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("gl")
@Implements("MusicPatchNode2")
public class MusicPatchNode2 {
	@ObfuscatedName("u")
	byte[] field2404;
	@ObfuscatedName("f")
	byte[] field2399;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 961983705
	)
	int field2400;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1534544583
	)
	int field2398;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1071717921
	)
	int field2407;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -461234171
	)
	int field2403;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1881467047
	)
	int field2401;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 972491085
	)
	int field2405;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 381719823
	)
	int field2402;

	MusicPatchNode2() {
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1982714060"
	)
	public static void method3750() {
		if (KeyHandler.KeyHandler_instance != null) {
			synchronized(KeyHandler.KeyHandler_instance) {
				KeyHandler.KeyHandler_instance = null;
			}
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-847322953"
	)
	@Export("Messages_getHistorySize")
	static int Messages_getHistorySize(int var0) {
		ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var1 == null ? 0 : var1.size();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(ILci;ZI)I",
		garbageValue = "1322591078"
	)
	static int method3747(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.CHAT_GETFILTER_PUBLIC) {
			Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = Client.publicChatMode;
			return 1;
		} else if (var0 == ScriptOpcodes.CHAT_SETFILTER) {
			GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 3;
			Client.publicChatMode = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
			MusicPatchNode.privateChatMode = User.method5131(Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1]);
			if (MusicPatchNode.privateChatMode == null) {
				MusicPatchNode.privateChatMode = PrivateChatMode.field3792;
			}

			Client.tradeChatMode = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 2];
			PacketBufferNode var18 = ModelData0.getPacketBufferNode(ClientPacket.field2270, Client.packetWriter.isaacCipher);
			var18.packetBuffer.writeByte(Client.publicChatMode);
			var18.packetBuffer.writeByte(MusicPatchNode.privateChatMode.field3795);
			var18.packetBuffer.writeByte(Client.tradeChatMode);
			Client.packetWriter.addNode(var18);
			return 1;
		} else {
			String var3;
			int var4;
			if (var0 == ScriptOpcodes.CHAT_SENDABUSEREPORT) {
				var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
				GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
				int var5 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1];
				PacketBufferNode var6 = ModelData0.getPacketBufferNode(ClientPacket.field2312, Client.packetWriter.isaacCipher);
				var6.packetBuffer.writeByte(class173.stringCp1252NullTerminatedByteSize(var3) + 2);
				var6.packetBuffer.writeStringCp1252NullTerminated(var3);
				var6.packetBuffer.writeByte(var4 - 1);
				var6.packetBuffer.writeByte(var5);
				Client.packetWriter.addNode(var6);
				return 1;
			} else {
				int var10;
				if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYTYPEANDLINE) {
					GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize -= 2;
					var10 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize + 1];
					Message var15 = class197.Messages_getByChannelAndID(var10, var4);
					if (var15 != null) {
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var15.count;
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var15.cycle;
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var15.sender != null ? var15.sender : "";
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var15.prefix != null ? var15.prefix : "";
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var15.text != null ? var15.text : "";
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var15.isFromFriend() ? 1 : (var15.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYUID) {
					var10 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
					Message var16 = class286.Messages_getMessage(var10);
					if (var16 != null) {
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var16.type;
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var16.cycle;
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var16.sender != null ? var16.sender : "";
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var16.prefix != null ? var16.prefix : "";
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var16.text != null ? var16.text : "";
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = var16.isFromFriend() ? 1 : (var16.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETFILTER_PRIVATE) {
					if (MusicPatchNode.privateChatMode == null) {
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = MusicPatchNode.privateChatMode.field3795;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPUBLIC) {
					var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
					String var14 = var3.toLowerCase();
					byte var17 = 0;
					if (var14.startsWith("yellow:")) {
						var17 = 0;
						var3 = var3.substring("yellow:".length());
					} else if (var14.startsWith("red:")) {
						var17 = 1;
						var3 = var3.substring("red:".length());
					} else if (var14.startsWith("green:")) {
						var17 = 2;
						var3 = var3.substring("green:".length());
					} else if (var14.startsWith("cyan:")) {
						var17 = 3;
						var3 = var3.substring("cyan:".length());
					} else if (var14.startsWith("purple:")) {
						var17 = 4;
						var3 = var3.substring("purple:".length());
					} else if (var14.startsWith("white:")) {
						var17 = 5;
						var3 = var3.substring("white:".length());
					} else if (var14.startsWith("flash1:")) {
						var17 = 6;
						var3 = var3.substring("flash1:".length());
					} else if (var14.startsWith("flash2:")) {
						var17 = 7;
						var3 = var3.substring("flash2:".length());
					} else if (var14.startsWith("flash3:")) {
						var17 = 8;
						var3 = var3.substring("flash3:".length());
					} else if (var14.startsWith("glow1:")) {
						var17 = 9;
						var3 = var3.substring("glow1:".length());
					} else if (var14.startsWith("glow2:")) {
						var17 = 10;
						var3 = var3.substring("glow2:".length());
					} else if (var14.startsWith("glow3:")) {
						var17 = 11;
						var3 = var3.substring("glow3:".length());
					} else if (VarbitDefinition.clientLanguage != Language.Language_EN) {
						if (var14.startsWith("yellow:")) {
							var17 = 0;
							var3 = var3.substring("yellow:".length());
						} else if (var14.startsWith("red:")) {
							var17 = 1;
							var3 = var3.substring("red:".length());
						} else if (var14.startsWith("green:")) {
							var17 = 2;
							var3 = var3.substring("green:".length());
						} else if (var14.startsWith("cyan:")) {
							var17 = 3;
							var3 = var3.substring("cyan:".length());
						} else if (var14.startsWith("purple:")) {
							var17 = 4;
							var3 = var3.substring("purple:".length());
						} else if (var14.startsWith("white:")) {
							var17 = 5;
							var3 = var3.substring("white:".length());
						} else if (var14.startsWith("flash1:")) {
							var17 = 6;
							var3 = var3.substring("flash1:".length());
						} else if (var14.startsWith("flash2:")) {
							var17 = 7;
							var3 = var3.substring("flash2:".length());
						} else if (var14.startsWith("flash3:")) {
							var17 = 8;
							var3 = var3.substring("flash3:".length());
						} else if (var14.startsWith("glow1:")) {
							var17 = 9;
							var3 = var3.substring("glow1:".length());
						} else if (var14.startsWith("glow2:")) {
							var17 = 10;
							var3 = var3.substring("glow2:".length());
						} else if (var14.startsWith("glow3:")) {
							var17 = 11;
							var3 = var3.substring("glow3:".length());
						}
					}

					var14 = var3.toLowerCase();
					byte var7 = 0;
					if (var14.startsWith("wave:")) {
						var7 = 1;
						var3 = var3.substring("wave:".length());
					} else if (var14.startsWith("wave2:")) {
						var7 = 2;
						var3 = var3.substring("wave2:".length());
					} else if (var14.startsWith("shake:")) {
						var7 = 3;
						var3 = var3.substring("shake:".length());
					} else if (var14.startsWith("scroll:")) {
						var7 = 4;
						var3 = var3.substring("scroll:".length());
					} else if (var14.startsWith("slide:")) {
						var7 = 5;
						var3 = var3.substring("slide:".length());
					} else if (VarbitDefinition.clientLanguage != Language.Language_EN) {
						if (var14.startsWith("wave:")) {
							var7 = 1;
							var3 = var3.substring("wave:".length());
						} else if (var14.startsWith("wave2:")) {
							var7 = 2;
							var3 = var3.substring("wave2:".length());
						} else if (var14.startsWith("shake:")) {
							var7 = 3;
							var3 = var3.substring("shake:".length());
						} else if (var14.startsWith("scroll:")) {
							var7 = 4;
							var3 = var3.substring("scroll:".length());
						} else if (var14.startsWith("slide:")) {
							var7 = 5;
							var3 = var3.substring("slide:".length());
						}
					}

					PacketBufferNode var8 = ModelData0.getPacketBufferNode(ClientPacket.field2305, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(0);
					int var9 = var8.packetBuffer.offset;
					var8.packetBuffer.writeByte(var4);
					var8.packetBuffer.writeByte(var17);
					var8.packetBuffer.writeByte(var7);
					class289.method5388(var8.packetBuffer, var3);
					var8.packetBuffer.writeLengthByte(var8.packetBuffer.offset - var9);
					Client.packetWriter.addNode(var8);
					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPRIVATE) {
					class43.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize];
					String var12 = Interpreter.Interpreter_stringStack[class43.Interpreter_stringStackSize + 1];
					PacketBufferNode var11 = ModelData0.getPacketBufferNode(ClientPacket.field2229, Client.packetWriter.isaacCipher);
					var11.packetBuffer.writeShort(0);
					int var13 = var11.packetBuffer.offset;
					var11.packetBuffer.writeStringCp1252NullTerminated(var3);
					class289.method5388(var11.packetBuffer, var12);
					var11.packetBuffer.writeLengthShort(var11.packetBuffer.offset - var13);
					Client.packetWriter.addNode(var11);
					return 1;
				} else if (var0 != ScriptOpcodes.CHAT_PLAYERNAME) {
					if (var0 == ScriptOpcodes.CHAT_GETFILTER_TRADE) {
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = Client.tradeChatMode;
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETHISTORYLENGTH) {
						var10 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = Messages_getHistorySize(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETNEXTUID) {
						var10 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = class40.Messages_getNextChatID(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETPREVUID) {
						var10 = Interpreter.Interpreter_intStack[--GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++GrandExchangeOfferTotalQuantityComparator.Interpreter_intStackSize - 1] = CollisionMap.Messages_getLastChatID(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.DOCHEAT) {
						var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
						class13.doCheat(var3);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_SETMESSAGEFILTER) {
						Client.field860 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize].toLowerCase().trim();
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETMESSAGEFILTER) {
						Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = Client.field860;
						return 1;
					} else if (var0 == ScriptOpcodes.DEBUGMES) {
						var3 = Interpreter.Interpreter_stringStack[--class43.Interpreter_stringStackSize];
						System.out.println(var3);
						return 1;
					} else {
						return 2;
					}
				} else {
					if (class215.localPlayer != null && class215.localPlayer.username != null) {
						var3 = class215.localPlayer.username.getName();
					} else {
						var3 = "";
					}

					Interpreter.Interpreter_stringStack[++class43.Interpreter_stringStackSize - 1] = var3;
					return 1;
				}
			}
		}
	}

	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		signature = "(Lhl;IIII)V",
		garbageValue = "1306895592"
	)
	@Export("drawMinimap")
	static final void drawMinimap(Widget var0, int var1, int var2, int var3) {
		Tiles.playPcmPlayers();
		SpriteMask var4 = var0.getSpriteMask(false);
		if (var4 != null) {
			Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height);
			if (Client.minimapState != 2 && Client.minimapState != 5) {
				int var5 = Client.camAngleY & 2047;
				int var6 = class215.localPlayer.x / 32 + 48;
				int var7 = 464 - class215.localPlayer.y / 32;
				Interpreter.sceneMinimapSprite.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths);

				int var8;
				int var9;
				int var10;
				for (var8 = 0; var8 < Client.mapIconCount; ++var8) {
					var9 = Client.mapIconXs[var8] * 4 + 2 - class215.localPlayer.x / 32;
					var10 = Client.mapIconYs[var8] * 4 + 2 - class215.localPlayer.y / 32;
					class185.drawSpriteOnMinimap(var1, var2, var9, var10, Client.mapIcons[var8], var4);
				}

				int var11;
				int var12;
				for (var8 = 0; var8 < 104; ++var8) {
					for (var9 = 0; var9 < 104; ++var9) {
						NodeDeque var15 = Client.groundItems[ClientPacket.Client_plane][var8][var9];
						if (var15 != null) {
							var11 = var8 * 4 + 2 - class215.localPlayer.x / 32;
							var12 = var9 * 4 + 2 - class215.localPlayer.y / 32;
							class185.drawSpriteOnMinimap(var1, var2, var11, var12, WorldMapData_0.mapDotSprites[0], var4);
						}
					}
				}

				for (var8 = 0; var8 < Client.npcCount; ++var8) {
					NPC var16 = Client.npcs[Client.npcIndices[var8]];
					if (var16 != null && var16.isVisible()) {
						NPCDefinition var18 = var16.definition;
						if (var18 != null && var18.transforms != null) {
							var18 = var18.transform();
						}

						if (var18 != null && var18.drawMapDot && var18.isInteractable) {
							var11 = var16.x / 32 - class215.localPlayer.x / 32;
							var12 = var16.y / 32 - class215.localPlayer.y / 32;
							class185.drawSpriteOnMinimap(var1, var2, var11, var12, WorldMapData_0.mapDotSprites[1], var4);
						}
					}
				}

				var8 = Players.Players_count;
				int[] var19 = Players.Players_indices;

				for (var10 = 0; var10 < var8; ++var10) {
					Player var17 = Client.players[var19[var10]];
					if (var17 != null && var17.isVisible() && !var17.isHidden && var17 != class215.localPlayer) {
						var12 = var17.x / 32 - class215.localPlayer.x / 32;
						int var13 = var17.y / 32 - class215.localPlayer.y / 32;
						boolean var14 = false;
						if (class215.localPlayer.team != 0 && var17.team != 0 && var17.team == class215.localPlayer.team) {
							var14 = true;
						}

						if (var17.isFriend()) {
							class185.drawSpriteOnMinimap(var1, var2, var12, var13, WorldMapData_0.mapDotSprites[3], var4);
						} else if (var14) {
							class185.drawSpriteOnMinimap(var1, var2, var12, var13, WorldMapData_0.mapDotSprites[4], var4);
						} else if (var17.isClanMember()) {
							class185.drawSpriteOnMinimap(var1, var2, var12, var13, WorldMapData_0.mapDotSprites[5], var4);
						} else {
							class185.drawSpriteOnMinimap(var1, var2, var12, var13, WorldMapData_0.mapDotSprites[2], var4);
						}
					}
				}

				if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
					if (Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
						NPC var20 = Client.npcs[Client.hintArrowNpcIndex];
						if (var20 != null) {
							var11 = var20.x / 32 - class215.localPlayer.x / 32;
							var12 = var20.y / 32 - class215.localPlayer.y / 32;
							WorldMapIcon_0.worldToMinimap(var1, var2, var11, var12, AttackOption.mapMarkerSprites[1], var4);
						}
					}

					if (Client.hintArrowType == 2) {
						var10 = Client.hintArrowX * 4 - class51.baseX * 256 + 2 - class215.localPlayer.x / 32;
						var11 = Client.hintArrowY * 4 - VarcInt.baseY * 256 + 2 - class215.localPlayer.y / 32;
						WorldMapIcon_0.worldToMinimap(var1, var2, var10, var11, AttackOption.mapMarkerSprites[1], var4);
					}

					if (Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) {
						Player var21 = Client.players[Client.hintArrowPlayerIndex];
						if (var21 != null) {
							var11 = var21.x / 32 - class215.localPlayer.x / 32;
							var12 = var21.y / 32 - class215.localPlayer.y / 32;
							WorldMapIcon_0.worldToMinimap(var1, var2, var11, var12, AttackOption.mapMarkerSprites[1], var4);
						}
					}
				}

				if (Client.destinationX != 0) {
					var10 = Client.destinationX * 4 + 2 - class215.localPlayer.x / 32;
					var11 = Client.destinationY * 4 + 2 - class215.localPlayer.y / 32;
					class185.drawSpriteOnMinimap(var1, var2, var10, var11, AttackOption.mapMarkerSprites[0], var4);
				}

				if (!class215.localPlayer.isHidden) {
					Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
				}
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

			Client.field837[var3] = true;
		}
	}
}
