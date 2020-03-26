import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
@Implements("AbstractByteArrayCopier")
public abstract class AbstractByteArrayCopier {
	AbstractByteArrayCopier() {
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)[B",
		garbageValue = "1422436059"
	)
	@Export("get")
	abstract byte[] get();

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "([BB)V",
		garbageValue = "0"
	)
	@Export("set")
	public abstract void set(byte[] var1);

	@ObfuscatedName("gv")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZI)V",
		garbageValue = "-411552883"
	)
	@Export("drawLoadingMessage")
	static final void drawLoadingMessage(String var0, boolean var1) {
		if (Client.showLoadingMessages) {
			byte var2 = 4;
			int var3 = var2 + 6;
			int var4 = var2 + 6;
			int var5 = WorldMapData_0.fontPlain12.lineWidth(var0, 250);
			int var6 = WorldMapData_0.fontPlain12.lineCount(var0, 250) * 13;
			Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var5 + var2 + var2, var2 + var2 + var6, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
			WorldMapData_0.fontPlain12.drawLines(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
			int var7 = var3 - var2;
			int var8 = var4 - var2;
			int var9 = var2 + var5 + var2;
			int var10 = var2 + var6 + var2;

			for (int var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
				if (Client.rootWidgetWidths[var11] + Client.rootWidgetXs[var11] > var7 && Client.rootWidgetXs[var11] < var9 + var7 && Client.rootWidgetHeights[var11] + Client.rootWidgetYs[var11] > var8 && Client.rootWidgetYs[var11] < var10 + var8) {
					Client.field679[var11] = true;
				}
			}

			if (var1) {
				class206.rasterProvider.drawFull(0, 0);
			} else {
				class49.method848(var3, var4, var5, var6);
			}

		}
	}

	@ObfuscatedName("hn")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1582432822"
	)
	static void method4023() {
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
	}

	@ObfuscatedName("ij")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
		garbageValue = "2048227519"
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
			var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2240, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5610(Client.selectedItemSlot);
			var8.packetBuffer.writeShortLE(WorldMapSection2.selectedItemWidget);
			var8.packetBuffer.method5609(class89.baseY + var1);
			var8.packetBuffer.method5609(var0 + class69.baseX);
			var8.packetBuffer.method5609(var3);
			var8.packetBuffer.method5609(FaceNormal.selectedItemId);
			var8.packetBuffer.method5727(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 2) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2252, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(Client.selectedSpellChildIndex);
			var8.packetBuffer.writeInt(class7.selectedSpellWidget);
			var8.packetBuffer.method5610(var3);
			var8.packetBuffer.method5609(class89.baseY + var1);
			var8.packetBuffer.method5602(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5609(var0 + class69.baseX);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 3) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2221, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5602(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntME(var0 + class69.baseX);
			var8.packetBuffer.method5609(var3);
			var8.packetBuffer.method5609(class89.baseY + var1);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 4) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2243, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.writeIntME(var0 + class69.baseX);
			var8.packetBuffer.writeIntME(class89.baseY + var1);
			var8.packetBuffer.method5724(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 5) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2296, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5610(var0 + class69.baseX);
			var8.packetBuffer.writeIntME(class89.baseY + var1);
			var8.packetBuffer.method5727(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5610(var3);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 6) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2288, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5610(var3);
			var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(var0 + class69.baseX);
			var8.packetBuffer.method5609(class89.baseY + var1);
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
					var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2237, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeShort(Client.selectedItemSlot);
					var9.packetBuffer.writeShort(FaceNormal.selectedItemId);
					var9.packetBuffer.writeInt(WorldMapSection2.selectedItemWidget);
					var9.packetBuffer.method5727(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5609(var3);
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
					var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2271, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5602(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeInt(class7.selectedSpellWidget);
					var9.packetBuffer.writeShort(Client.selectedSpellChildIndex);
					var9.packetBuffer.writeShort(var3);
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
					var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2263, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5609(var3);
					var9.packetBuffer.method5724(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2211, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeShort(var3);
					var9.packetBuffer.method5724(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2277, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5610(var3);
					var9.packetBuffer.method5724(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2219, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5602(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5609(var3);
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
					var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2303, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeShort(var3);
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
						var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2225, Client.packetWriter.isaacCipher);
						var9.packetBuffer.method5610(FaceNormal.selectedItemId);
						var9.packetBuffer.method5610(var3);
						var9.packetBuffer.method5727(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var9.packetBuffer.writeIntME(Client.selectedItemSlot);
						var9.packetBuffer.writeInt(WorldMapSection2.selectedItemWidget);
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
						var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2300, Client.packetWriter.isaacCipher);
						var9.packetBuffer.writeShort(var3);
						var9.packetBuffer.method5617(class7.selectedSpellWidget);
						var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var9.packetBuffer.method5610(Client.selectedSpellChildIndex);
						Client.packetWriter.addNode(var9);
					}
				} else if (var2 == 16) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2302, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5610(FaceNormal.selectedItemId);
					var8.packetBuffer.writeIntME(var3);
					var8.packetBuffer.method5724(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShortLE(WorldMapSection2.selectedItemWidget);
					var8.packetBuffer.writeIntME(var0 + class69.baseX);
					var8.packetBuffer.writeIntME(Client.selectedItemSlot);
					var8.packetBuffer.method5609(class89.baseY + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 17) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2233, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5724(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5609(var3);
					var8.packetBuffer.writeIntME(Client.selectedSpellChildIndex);
					var8.packetBuffer.writeShort(class89.baseY + var1);
					var8.packetBuffer.method5617(class7.selectedSpellWidget);
					var8.packetBuffer.writeIntME(var0 + class69.baseX);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 18) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2287, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeIntME(var3);
					var8.packetBuffer.writeIntME(var0 + class69.baseX);
					var8.packetBuffer.method5609(class89.baseY + var1);
					var8.packetBuffer.method5724(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 19) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2286, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShort(class89.baseY + var1);
					var8.packetBuffer.method5610(var0 + class69.baseX);
					var8.packetBuffer.method5727(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShort(var3);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 20) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2275, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5609(var0 + class69.baseX);
					var8.packetBuffer.method5610(class89.baseY + var1);
					var8.packetBuffer.writeIntME(var3);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 21) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2227, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5609(var3);
					var8.packetBuffer.method5609(var0 + class69.baseX);
					var8.packetBuffer.method5610(class89.baseY + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 22) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2235, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShort(var3);
					var8.packetBuffer.method5610(class89.baseY + var1);
					var8.packetBuffer.method5727(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5610(var0 + class69.baseX);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 23) {
					if (Client.isMenuOpen) {
						GrandExchangeOfferWorldComparator.scene.setViewportWalking();
					} else {
						GrandExchangeOfferWorldComparator.scene.menuOpen(ScriptEvent.Client_plane, var0, var1, true);
					}
				} else {
					PacketBufferNode var10;
					Widget var16;
					if (var2 == 24) {
						var16 = MusicPatchNode.getWidget(var1);
						boolean var11 = true;
						if (var16.contentType > 0) {
							var11 = WorldMapSectionType.method344(var16);
						}

						if (var11) {
							var10 = FaceNormal.getPacketBufferNode(ClientPacket.field2231, Client.packetWriter.isaacCipher);
							var10.packetBuffer.writeInt(var1);
							Client.packetWriter.addNode(var10);
						}
					} else {
						if (var2 == 25) {
							var16 = GrandExchangeOfferUnitPriceComparator.getWidgetChild(var1, var0);
							if (var16 != null) {
								GrandExchangeOffer.Widget_runOnTargetLeave();
								WorldMapData_1.selectSpell(var1, var0, WorldMapRectangle.method388(ScriptEvent.getWidgetClickMask(var16)), var16.itemId);
								Client.isItemSelected = 0;
								Client.selectedSpellActionName = PrivateChatMode.method5965(var16);
								if (Client.selectedSpellActionName == null) {
									Client.selectedSpellActionName = "null";
								}

								if (var16.isIf3) {
									Client.selectedSpellName = var16.dataText + class297.colorStartTag(16777215);
								} else {
									Client.selectedSpellName = class297.colorStartTag(65280) + var16.spellName + class297.colorStartTag(16777215);
								}
							}

							return;
						}

						if (var2 == 26) {
							class227.method4184();
						} else {
							int var12;
							Widget var14;
							if (var2 == 28) {
								var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2231, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = MusicPatchNode.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var12 = var14.cs1Instructions[0][1];
									Varps.Varps_main[var12] = 1 - Varps.Varps_main[var12];
									class22.changeGameOptions(var12);
								}
							} else if (var2 == 29) {
								var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2231, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = MusicPatchNode.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var12 = var14.cs1Instructions[0][1];
									if (Varps.Varps_main[var12] != var14.cs1ComparisonValues[0]) {
										Varps.Varps_main[var12] = var14.cs1ComparisonValues[0];
										class22.changeGameOptions(var12);
									}
								}
							} else if (var2 == 30) {
								if (Client.meslayerContinueWidget == null) {
									class58.resumePauseWidget(var1, var0);
									Client.meslayerContinueWidget = GrandExchangeOfferUnitPriceComparator.getWidgetChild(var1, var0);
									ItemContainer.invalidateWidget(Client.meslayerContinueWidget);
								}
							} else if (var2 == 31) {
								var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2305, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeShortLE(var1);
								var8.packetBuffer.writeIntME(Client.selectedItemSlot);
								var8.packetBuffer.method5644(WorldMapSection2.selectedItemWidget);
								var8.packetBuffer.method5610(var0);
								var8.packetBuffer.writeShort(var3);
								var8.packetBuffer.method5610(FaceNormal.selectedItemId);
								Client.packetWriter.addNode(var8);
								Client.field786 = 0;
								WorldMapID.field307 = MusicPatchNode.getWidget(var1);
								Client.field880 = var0;
							} else if (var2 == 32) {
								var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2228, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5609(Client.selectedSpellChildIndex);
								var8.packetBuffer.method5644(class7.selectedSpellWidget);
								var8.packetBuffer.method5610(var3);
								var8.packetBuffer.method5610(var0);
								var8.packetBuffer.method5644(var1);
								Client.packetWriter.addNode(var8);
								Client.field786 = 0;
								WorldMapID.field307 = MusicPatchNode.getWidget(var1);
								Client.field880 = var0;
							} else if (var2 == 33) {
								var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2292, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5609(var3);
								var8.packetBuffer.method5617(var1);
								var8.packetBuffer.writeShort(var0);
								Client.packetWriter.addNode(var8);
								Client.field786 = 0;
								WorldMapID.field307 = MusicPatchNode.getWidget(var1);
								Client.field880 = var0;
							} else if (var2 == 34) {
								var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2265, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								var8.packetBuffer.method5610(var3);
								var8.packetBuffer.writeIntME(var0);
								Client.packetWriter.addNode(var8);
								Client.field786 = 0;
								WorldMapID.field307 = MusicPatchNode.getWidget(var1);
								Client.field880 = var0;
							} else if (var2 == 35) {
								var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2268, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								var8.packetBuffer.method5609(var3);
								var8.packetBuffer.writeShort(var0);
								Client.packetWriter.addNode(var8);
								Client.field786 = 0;
								WorldMapID.field307 = MusicPatchNode.getWidget(var1);
								Client.field880 = var0;
							} else if (var2 == 36) {
								var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2208, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5609(var0);
								var8.packetBuffer.method5617(var1);
								var8.packetBuffer.method5609(var3);
								Client.packetWriter.addNode(var8);
								Client.field786 = 0;
								WorldMapID.field307 = MusicPatchNode.getWidget(var1);
								Client.field880 = var0;
							} else if (var2 == 37) {
								var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2244, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntME(var0);
								var8.packetBuffer.method5644(var1);
								var8.packetBuffer.method5610(var3);
								Client.packetWriter.addNode(var8);
								Client.field786 = 0;
								WorldMapID.field307 = MusicPatchNode.getWidget(var1);
								Client.field880 = var0;
							} else {
								if (var2 == 38) {
									GrandExchangeOffer.Widget_runOnTargetLeave();
									var16 = MusicPatchNode.getWidget(var1);
									Client.isItemSelected = 1;
									Client.selectedItemSlot = var0;
									WorldMapSection2.selectedItemWidget = var1;
									FaceNormal.selectedItemId = var3;
									ItemContainer.invalidateWidget(var16);
									Client.selectedItemName = class297.colorStartTag(16748608) + AbstractWorldMapData.ItemDefinition_get(var3).name + class297.colorStartTag(16777215);
									if (Client.selectedItemName == null) {
										Client.selectedItemName = "null";
									}

									return;
								}

								if (var2 == 39) {
									var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2258, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeShort(var3);
									var8.packetBuffer.method5609(var0);
									var8.packetBuffer.method5617(var1);
									Client.packetWriter.addNode(var8);
									Client.field786 = 0;
									WorldMapID.field307 = MusicPatchNode.getWidget(var1);
									Client.field880 = var0;
								} else if (var2 == 40) {
									var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2276, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeShortLE(var1);
									var8.packetBuffer.writeIntME(var3);
									var8.packetBuffer.writeShort(var0);
									Client.packetWriter.addNode(var8);
									Client.field786 = 0;
									WorldMapID.field307 = MusicPatchNode.getWidget(var1);
									Client.field880 = var0;
								} else if (var2 == 41) {
									var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2285, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5609(var0);
									var8.packetBuffer.method5644(var1);
									var8.packetBuffer.writeShort(var3);
									Client.packetWriter.addNode(var8);
									Client.field786 = 0;
									WorldMapID.field307 = MusicPatchNode.getWidget(var1);
									Client.field880 = var0;
								} else if (var2 == 42) {
									var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2299, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeInt(var1);
									var8.packetBuffer.method5610(var0);
									var8.packetBuffer.method5610(var3);
									Client.packetWriter.addNode(var8);
									Client.field786 = 0;
									WorldMapID.field307 = MusicPatchNode.getWidget(var1);
									Client.field880 = var0;
								} else if (var2 == 43) {
									var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2238, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeIntME(var0);
									var8.packetBuffer.method5617(var1);
									var8.packetBuffer.writeIntME(var3);
									Client.packetWriter.addNode(var8);
									Client.field786 = 0;
									WorldMapID.field307 = MusicPatchNode.getWidget(var1);
									Client.field880 = var0;
								} else if (var2 == 44) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2267, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeIntME(var3);
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
										var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2232, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5610(var3);
										var9.packetBuffer.method5727(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2266, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5727(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2282, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeShort(var3);
										var9.packetBuffer.method5602(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2254, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5727(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeShort(var3);
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
										var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2250, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5724(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeIntME(var3);
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
										var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2301, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeShort(var3);
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
										var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2247, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeShort(var3);
										Client.packetWriter.addNode(var9);
									}
								} else {
									label662: {
										if (var2 != 57) {
											if (var2 == 58) {
												var16 = GrandExchangeOfferUnitPriceComparator.getWidgetChild(var1, var0);
												if (var16 != null) {
													var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2272, Client.packetWriter.isaacCipher);
													var9.packetBuffer.method5610(Client.field837);
													var9.packetBuffer.method5610(Client.selectedSpellChildIndex);
													var9.packetBuffer.writeIntME(var0);
													var9.packetBuffer.method5609(var16.itemId);
													var9.packetBuffer.writeInt(class7.selectedSpellWidget);
													var9.packetBuffer.method5644(var1);
													Client.packetWriter.addNode(var9);
												}
												break label662;
											}

											if (var2 == 1001) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												Client.destinationX = var0;
												Client.destinationY = var1;
												var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2274, Client.packetWriter.isaacCipher);
												var8.packetBuffer.writeIntME(var3);
												var8.packetBuffer.method5609(var0 + class69.baseX);
												var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
												var8.packetBuffer.writeShort(class89.baseY + var1);
												Client.packetWriter.addNode(var8);
												break label662;
											}

											if (var2 == 1002) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2284, Client.packetWriter.isaacCipher);
												var8.packetBuffer.method5610(var3);
												Client.packetWriter.addNode(var8);
												break label662;
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
														var10 = FaceNormal.getPacketBufferNode(ClientPacket.field2242, Client.packetWriter.isaacCipher);
														var10.packetBuffer.writeIntME(var17.id);
														Client.packetWriter.addNode(var10);
													}
												}
												break label662;
											}

											if (var2 == 1004) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = FaceNormal.getPacketBufferNode(ClientPacket.field2294, Client.packetWriter.isaacCipher);
												var8.packetBuffer.method5610(var3);
												Client.packetWriter.addNode(var8);
												break label662;
											}

											if (var2 == 1005) {
												var16 = MusicPatchNode.getWidget(var1);
												if (var16 != null && var16.itemQuantities[var0] >= 100000) {
													Skeleton.addGameMessage(27, "", var16.itemQuantities[var0] + " x " + AbstractWorldMapData.ItemDefinition_get(var3).name);
												} else {
													var9 = FaceNormal.getPacketBufferNode(ClientPacket.field2294, Client.packetWriter.isaacCipher);
													var9.packetBuffer.method5610(var3);
													Client.packetWriter.addNode(var9);
												}

												Client.field786 = 0;
												WorldMapID.field307 = MusicPatchNode.getWidget(var1);
												Client.field880 = var0;
												break label662;
											}

											if (var2 != 1007) {
												if (var2 == 1009 || var2 == 1011 || var2 == 1010 || var2 == 1008 || var2 == 1012) {
													GrandExchangeOfferAgeComparator.worldMap.worldMapMenuAction(var2, var3, new Coord(var0), new Coord(var1));
												}
												break label662;
											}
										}

										var16 = GrandExchangeOfferUnitPriceComparator.getWidgetChild(var1, var0);
										if (var16 != null) {
											ClientPacket.widgetDefaultMenuAction(var3, var1, var0, var16.itemId, var5);
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
			ItemContainer.invalidateWidget(MusicPatchNode.getWidget(WorldMapSection2.selectedItemWidget));
		}

		if (Client.isSpellSelected) {
			GrandExchangeOffer.Widget_runOnTargetLeave();
		}

		if (WorldMapID.field307 != null && Client.field786 == 0) {
			ItemContainer.invalidateWidget(WorldMapID.field307);
		}

	}
}
