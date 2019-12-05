import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class32 {
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	@Export("NetCache_responseArchiveBuffer")
	static Buffer NetCache_responseArchiveBuffer;

	@ObfuscatedName("hf")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
		garbageValue = "64"
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
			var8 = ModelData0.getPacketBufferNode(ClientPacket.field2244, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(class51.baseX * 64 + var0);
			var8.packetBuffer.method5628(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShortLE(class43.selectedItemSlot);
			var8.packetBuffer.method5636(HealthBarUpdate.selectedItemId);
			var8.packetBuffer.method5648(class1.selectedItemWidget);
			var8.packetBuffer.writeShortLE(var3);
			var8.packetBuffer.writeShort(VarcInt.baseY * 64 + var1);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 2) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = ModelData0.getPacketBufferNode(ClientPacket.field2263, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5636(Client.selectedSpellChildIndex);
			var8.packetBuffer.method5613(var3);
			var8.packetBuffer.method5613(VarcInt.baseY * 64 + var1);
			var8.packetBuffer.writeInt(WorldMapAreaData.selectedSpellWidget);
			var8.packetBuffer.method5628(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShortLE(class51.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 3) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = ModelData0.getPacketBufferNode(ClientPacket.field2226, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShortLE(VarcInt.baseY * 64 + var1);
			var8.packetBuffer.writeShortLE(class51.baseX * 64 + var0);
			var8.packetBuffer.method5598(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShortLE(var3);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 4) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = ModelData0.getPacketBufferNode(ClientPacket.field2297, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5628(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5636(VarcInt.baseY * 64 + var1);
			var8.packetBuffer.method5636(var3);
			var8.packetBuffer.writeShort(class51.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 5) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = ModelData0.getPacketBufferNode(ClientPacket.field2237, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5613(VarcInt.baseY * 64 + var1);
			var8.packetBuffer.method5613(var3);
			var8.packetBuffer.method5636(class51.baseX * 64 + var0);
			var8.packetBuffer.method5598(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 6) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = ModelData0.getPacketBufferNode(ClientPacket.field2252, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntME(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShortLE(VarcInt.baseY * 64 + var1);
			var8.packetBuffer.method5636(var3);
			var8.packetBuffer.method5613(class51.baseX * 64 + var0);
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
					var9 = ModelData0.getPacketBufferNode(ClientPacket.field2316, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeInt(class1.selectedItemWidget);
					var9.packetBuffer.writeIntME(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5636(HealthBarUpdate.selectedItemId);
					var9.packetBuffer.method5613(var3);
					var9.packetBuffer.method5613(class43.selectedItemSlot);
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
					var9 = ModelData0.getPacketBufferNode(ClientPacket.field2300, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeInt(WorldMapAreaData.selectedSpellWidget);
					var9.packetBuffer.method5636(Client.selectedSpellChildIndex);
					var9.packetBuffer.method5598(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5613(var3);
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
					var9 = ModelData0.getPacketBufferNode(ClientPacket.field2255, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5636(var3);
					var9.packetBuffer.writeIntME(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = ModelData0.getPacketBufferNode(ClientPacket.field2245, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeShortLE(var3);
					var9.packetBuffer.method5598(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = ModelData0.getPacketBufferNode(ClientPacket.field2308, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5613(var3);
					var9.packetBuffer.method5628(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = ModelData0.getPacketBufferNode(ClientPacket.field2243, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5628(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeShortLE(var3);
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
					var9 = ModelData0.getPacketBufferNode(ClientPacket.field2257, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5598(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5613(var3);
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
						var9 = ModelData0.getPacketBufferNode(ClientPacket.field2286, Client.packetWriter.isaacCipher);
						var9.packetBuffer.method5636(HealthBarUpdate.selectedItemId);
						var9.packetBuffer.writeIntME(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var9.packetBuffer.writeInt(class1.selectedItemWidget);
						var9.packetBuffer.writeShortLE(var3);
						var9.packetBuffer.method5613(class43.selectedItemSlot);
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
						var9 = ModelData0.getPacketBufferNode(ClientPacket.field2225, Client.packetWriter.isaacCipher);
						var9.packetBuffer.method5613(var3);
						var9.packetBuffer.method5811(WorldMapAreaData.selectedSpellWidget);
						var9.packetBuffer.method5628(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var9.packetBuffer.method5613(Client.selectedSpellChildIndex);
						Client.packetWriter.addNode(var9);
					}
				} else if (var2 == 16) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = ModelData0.getPacketBufferNode(ClientPacket.field2284, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5613(class43.selectedItemSlot);
					var8.packetBuffer.writeShortLE(class51.baseX * 64 + var0);
					var8.packetBuffer.method5811(class1.selectedItemWidget);
					var8.packetBuffer.writeShort(VarcInt.baseY * 64 + var1);
					var8.packetBuffer.method5628(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShortLE(HealthBarUpdate.selectedItemId);
					var8.packetBuffer.method5613(var3);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 17) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = ModelData0.getPacketBufferNode(ClientPacket.field2254, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5613(class51.baseX * 64 + var0);
					var8.packetBuffer.method5598(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShort(VarcInt.baseY * 64 + var1);
					var8.packetBuffer.writeShortLE(var3);
					var8.packetBuffer.method5648(WorldMapAreaData.selectedSpellWidget);
					var8.packetBuffer.method5636(Client.selectedSpellChildIndex);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 18) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = ModelData0.getPacketBufferNode(ClientPacket.field2236, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5598(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5636(var3);
					var8.packetBuffer.writeShort(VarcInt.baseY * 64 + var1);
					var8.packetBuffer.method5636(class51.baseX * 64 + var0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 19) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = ModelData0.getPacketBufferNode(ClientPacket.field2227, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortLE(class51.baseX * 64 + var0);
					var8.packetBuffer.method5598(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5636(var3);
					var8.packetBuffer.writeShort(VarcInt.baseY * 64 + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 20) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = ModelData0.getPacketBufferNode(ClientPacket.field2233, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5613(var3);
					var8.packetBuffer.method5613(VarcInt.baseY * 64 + var1);
					var8.packetBuffer.writeShortLE(class51.baseX * 64 + var0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 21) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = ModelData0.getPacketBufferNode(ClientPacket.field2264, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5613(VarcInt.baseY * 64 + var1);
					var8.packetBuffer.writeIntME(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShort(var3);
					var8.packetBuffer.method5613(class51.baseX * 64 + var0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 22) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = ModelData0.getPacketBufferNode(ClientPacket.field2220, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortLE(VarcInt.baseY * 64 + var1);
					var8.packetBuffer.writeIntME(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5613(var3);
					var8.packetBuffer.writeShort(class51.baseX * 64 + var0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 23) {
					if (Client.isMenuOpen) {
						class2.scene.setViewportWalking();
					} else {
						class2.scene.menuOpen(ClientPacket.Client_plane, var0, var1, true);
					}
				} else {
					PacketBufferNode var10;
					Widget var16;
					if (var2 == 24) {
						var16 = Language.getWidget(var1);
						boolean var11 = true;
						if (var16.contentType > 0) {
							var11 = WorldMapID.method567(var16);
						}

						if (var11) {
							var10 = ModelData0.getPacketBufferNode(ClientPacket.field2274, Client.packetWriter.isaacCipher);
							var10.packetBuffer.writeInt(var1);
							Client.packetWriter.addNode(var10);
						}
					} else {
						if (var2 == 25) {
							var16 = UserComparator3.getWidgetChild(var1, var0);
							if (var16 != null) {
								Actor.Widget_runOnTargetLeave();
								TextureProvider.selectSpell(var1, var0, Client.method1655(MenuAction.getWidgetClickMask(var16)), var16.itemId);
								Client.isItemSelected = 0;
								Client.selectedSpellActionName = LoginPacket.method3662(var16);
								if (Client.selectedSpellActionName == null) {
									Client.selectedSpellActionName = "null";
								}

								if (var16.isIf3) {
									Client.selectedSpellName = var16.dataText + class222.colorStartTag(16777215);
								} else {
									Client.selectedSpellName = class222.colorStartTag(65280) + var16.spellName + class222.colorStartTag(16777215);
								}
							}

							return;
						}

						if (var2 == 26) {
							Actor.method1756();
						} else {
							int var12;
							Widget var14;
							if (var2 == 28) {
								var8 = ModelData0.getPacketBufferNode(ClientPacket.field2274, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = Language.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var12 = var14.cs1Instructions[0][1];
									Varps.Varps_main[var12] = 1 - Varps.Varps_main[var12];
									ObjectDefinition.changeGameOptions(var12);
								}
							} else if (var2 == 29) {
								var8 = ModelData0.getPacketBufferNode(ClientPacket.field2274, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = Language.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var12 = var14.cs1Instructions[0][1];
									if (Varps.Varps_main[var12] != var14.cs1ComparisonValues[0]) {
										Varps.Varps_main[var12] = var14.cs1ComparisonValues[0];
										ObjectDefinition.changeGameOptions(var12);
									}
								}
							} else if (var2 == 30) {
								if (Client.meslayerContinueWidget == null) {
									WorldMapCacheName.resumePauseWidget(var1, var0);
									Client.meslayerContinueWidget = UserComparator3.getWidgetChild(var1, var0);
									ScriptEvent.invalidateWidget(Client.meslayerContinueWidget);
								}
							} else if (var2 == 31) {
								var8 = ModelData0.getPacketBufferNode(ClientPacket.field2248, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeShortLE(var3);
								var8.packetBuffer.writeShortLE(class43.selectedItemSlot);
								var8.packetBuffer.method5811(var1);
								var8.packetBuffer.writeInt(class1.selectedItemWidget);
								var8.packetBuffer.method5613(HealthBarUpdate.selectedItemId);
								var8.packetBuffer.method5613(var0);
								Client.packetWriter.addNode(var8);
								Client.field664 = 0;
								class51.field432 = Language.getWidget(var1);
								Client.field749 = var0;
							} else if (var2 == 32) {
								var8 = ModelData0.getPacketBufferNode(ClientPacket.field2269, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								var8.packetBuffer.writeInt(WorldMapAreaData.selectedSpellWidget);
								var8.packetBuffer.method5613(var0);
								var8.packetBuffer.method5613(var3);
								var8.packetBuffer.writeShort(Client.selectedSpellChildIndex);
								Client.packetWriter.addNode(var8);
								Client.field664 = 0;
								class51.field432 = Language.getWidget(var1);
								Client.field749 = var0;
							} else if (var2 == 33) {
								var8 = ModelData0.getPacketBufferNode(ClientPacket.field2279, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5636(var3);
								var8.packetBuffer.method5613(var0);
								var8.packetBuffer.method5647(var1);
								Client.packetWriter.addNode(var8);
								Client.field664 = 0;
								class51.field432 = Language.getWidget(var1);
								Client.field749 = var0;
							} else if (var2 == 34) {
								var8 = ModelData0.getPacketBufferNode(ClientPacket.field2294, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeShort(var0);
								var8.packetBuffer.writeShort(var3);
								var8.packetBuffer.method5648(var1);
								Client.packetWriter.addNode(var8);
								Client.field664 = 0;
								class51.field432 = Language.getWidget(var1);
								Client.field749 = var0;
							} else if (var2 == 35) {
								var8 = ModelData0.getPacketBufferNode(ClientPacket.field2222, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeShort(var0);
								var8.packetBuffer.writeShort(var3);
								var8.packetBuffer.method5647(var1);
								Client.packetWriter.addNode(var8);
								Client.field664 = 0;
								class51.field432 = Language.getWidget(var1);
								Client.field749 = var0;
							} else if (var2 == 36) {
								var8 = ModelData0.getPacketBufferNode(ClientPacket.field2235, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5811(var1);
								var8.packetBuffer.writeShortLE(var0);
								var8.packetBuffer.writeShortLE(var3);
								Client.packetWriter.addNode(var8);
								Client.field664 = 0;
								class51.field432 = Language.getWidget(var1);
								Client.field749 = var0;
							} else if (var2 == 37) {
								var8 = ModelData0.getPacketBufferNode(ClientPacket.field2250, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5613(var3);
								var8.packetBuffer.method5648(var1);
								var8.packetBuffer.method5613(var0);
								Client.packetWriter.addNode(var8);
								Client.field664 = 0;
								class51.field432 = Language.getWidget(var1);
								Client.field749 = var0;
							} else {
								if (var2 == 38) {
									Actor.Widget_runOnTargetLeave();
									var16 = Language.getWidget(var1);
									Client.isItemSelected = 1;
									class43.selectedItemSlot = var0;
									class1.selectedItemWidget = var1;
									HealthBarUpdate.selectedItemId = var3;
									ScriptEvent.invalidateWidget(var16);
									Client.selectedItemName = class222.colorStartTag(16748608) + Interpreter.ItemDefinition_get(var3).name + class222.colorStartTag(16777215);
									if (Client.selectedItemName == null) {
										Client.selectedItemName = "null";
									}

									return;
								}

								if (var2 == 39) {
									var8 = ModelData0.getPacketBufferNode(ClientPacket.field2303, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeShortLE(var0);
									var8.packetBuffer.method5613(var3);
									var8.packetBuffer.method5811(var1);
									Client.packetWriter.addNode(var8);
									Client.field664 = 0;
									class51.field432 = Language.getWidget(var1);
									Client.field749 = var0;
								} else if (var2 == 40) {
									var8 = ModelData0.getPacketBufferNode(ClientPacket.field2310, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5613(var3);
									var8.packetBuffer.writeInt(var1);
									var8.packetBuffer.writeShortLE(var0);
									Client.packetWriter.addNode(var8);
									Client.field664 = 0;
									class51.field432 = Language.getWidget(var1);
									Client.field749 = var0;
								} else if (var2 == 41) {
									var8 = ModelData0.getPacketBufferNode(ClientPacket.field2315, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeShortLE(var3);
									var8.packetBuffer.writeShort(var0);
									var8.packetBuffer.method5647(var1);
									Client.packetWriter.addNode(var8);
									Client.field664 = 0;
									class51.field432 = Language.getWidget(var1);
									Client.field749 = var0;
								} else if (var2 == 42) {
									var8 = ModelData0.getPacketBufferNode(ClientPacket.field2253, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5811(var1);
									var8.packetBuffer.method5636(var0);
									var8.packetBuffer.method5613(var3);
									Client.packetWriter.addNode(var8);
									Client.field664 = 0;
									class51.field432 = Language.getWidget(var1);
									Client.field749 = var0;
								} else if (var2 == 43) {
									var8 = ModelData0.getPacketBufferNode(ClientPacket.field2317, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5613(var3);
									var8.packetBuffer.writeShortLE(var0);
									var8.packetBuffer.method5811(var1);
									Client.packetWriter.addNode(var8);
									Client.field664 = 0;
									class51.field432 = Language.getWidget(var1);
									Client.field749 = var0;
								} else if (var2 == 44) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = ModelData0.getPacketBufferNode(ClientPacket.field2231, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5598(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5613(var3);
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
										var9 = ModelData0.getPacketBufferNode(ClientPacket.field2238, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5598(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeShortLE(var3);
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
										var9 = ModelData0.getPacketBufferNode(ClientPacket.field2261, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = ModelData0.getPacketBufferNode(ClientPacket.field2267, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5613(var3);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = ModelData0.getPacketBufferNode(ClientPacket.field2265, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeShortLE(var3);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = ModelData0.getPacketBufferNode(ClientPacket.field2241, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5628(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5636(var3);
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
										var9 = ModelData0.getPacketBufferNode(ClientPacket.field2251, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeShort(var3);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = ModelData0.getPacketBufferNode(ClientPacket.field2242, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeShort(var3);
										Client.packetWriter.addNode(var9);
									}
								} else {
									label894: {
										if (var2 != 57) {
											if (var2 == 58) {
												var16 = UserComparator3.getWidgetChild(var1, var0);
												if (var16 != null) {
													var9 = ModelData0.getPacketBufferNode(ClientPacket.field2232, Client.packetWriter.isaacCipher);
													var9.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
													var9.packetBuffer.writeShort(Client.field799);
													var9.packetBuffer.method5636(var16.itemId);
													var9.packetBuffer.method5647(WorldMapAreaData.selectedSpellWidget);
													var9.packetBuffer.method5636(var0);
													var9.packetBuffer.method5811(var1);
													Client.packetWriter.addNode(var9);
												}
												break label894;
											}

											if (var2 == 1001) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												Client.destinationX = var0;
												Client.destinationY = var1;
												var8 = ModelData0.getPacketBufferNode(ClientPacket.field2292, Client.packetWriter.isaacCipher);
												var8.packetBuffer.method5598(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
												var8.packetBuffer.method5613(VarcInt.baseY * 64 + var1);
												var8.packetBuffer.method5636(class51.baseX * 64 + var0);
												var8.packetBuffer.method5613(var3);
												Client.packetWriter.addNode(var8);
												break label894;
											}

											if (var2 == 1002) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = ModelData0.getPacketBufferNode(ClientPacket.field2304, Client.packetWriter.isaacCipher);
												var8.packetBuffer.writeShort(var3);
												Client.packetWriter.addNode(var8);
												break label894;
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
														var10 = ModelData0.getPacketBufferNode(ClientPacket.field2288, Client.packetWriter.isaacCipher);
														var10.packetBuffer.writeShort(var17.id);
														Client.packetWriter.addNode(var10);
													}
												}
												break label894;
											}

											if (var2 == 1004) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = ModelData0.getPacketBufferNode(ClientPacket.field2293, Client.packetWriter.isaacCipher);
												var8.packetBuffer.method5636(var3);
												Client.packetWriter.addNode(var8);
												break label894;
											}

											if (var2 == 1005) {
												var16 = Language.getWidget(var1);
												if (var16 != null && var16.itemQuantities[var0] >= 100000) {
													GrandExchangeOfferAgeComparator.addGameMessage(27, "", var16.itemQuantities[var0] + " x " + Interpreter.ItemDefinition_get(var3).name);
												} else {
													var9 = ModelData0.getPacketBufferNode(ClientPacket.field2293, Client.packetWriter.isaacCipher);
													var9.packetBuffer.method5636(var3);
													Client.packetWriter.addNode(var9);
												}

												Client.field664 = 0;
												class51.field432 = Language.getWidget(var1);
												Client.field749 = var0;
												break label894;
											}

											if (var2 != 1007) {
												if (var2 == 1010 || var2 == 1009 || var2 == 1008 || var2 == 1011 || var2 == 1012) {
													WorldMapRegion.worldMap.worldMapMenuAction(var2, var3, new Coord(var0), new Coord(var1));
												}
												break label894;
											}
										}

										var16 = UserComparator3.getWidgetChild(var1, var0);
										if (var16 != null) {
											WorldMapData_1.widgetDefaultMenuAction(var3, var1, var0, var16.itemId, var5);
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
			ScriptEvent.invalidateWidget(Language.getWidget(class1.selectedItemWidget));
		}

		if (Client.isSpellSelected) {
			Actor.Widget_runOnTargetLeave();
		}

		if (class51.field432 != null && Client.field664 == 0) {
			ScriptEvent.invalidateWidget(class51.field432);
		}

	}

	@ObfuscatedName("kb")
	@ObfuscatedSignature(
		signature = "(Lkg;II)V",
		garbageValue = "-847322953"
	)
	static void method570(Buffer var0, int var1) {
		class226.method4200(var0.array, var1);
		GrandExchangeEvent.method86(var0, var1);
	}
}
