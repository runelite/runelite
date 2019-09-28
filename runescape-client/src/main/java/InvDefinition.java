import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("InvDefinition")
public class InvDefinition extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("InvDefinition_archive")
	static AbstractArchive InvDefinition_archive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("InvDefinition_cached")
	static EvictingDualNodeHashTable InvDefinition_cached;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1122330625
	)
	@Export("size")
	public int size;

	static {
		InvDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	InvDefinition() {
		this.size = 0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "1971272201"
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

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "-57582576"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 2) {
			this.size = var1.readUnsignedShort();
		}

	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
		garbageValue = "1826014571"
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
			var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2230, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5476(class223.baseX * 64 + var0);
			var8.packetBuffer.writeShort(class286.baseY * 64 + var1);
			var8.packetBuffer.writeIntME(AbstractWorldMapData.selectedItemId);
			var8.packetBuffer.method5630(class2.selectedItemWidget);
			var8.packetBuffer.writeShort(DevicePcmPlayerProvider.selectedItemSlot);
			var8.packetBuffer.writeShortLE(var3);
			var8.packetBuffer.method5468(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 2) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2252, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeInt(AttackOption.selectedSpellWidget);
			var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(class286.baseY * 64 + var1);
			var8.packetBuffer.writeShortLE(var3);
			var8.packetBuffer.writeShort(class223.baseX * 64 + var0);
			var8.packetBuffer.writeIntME(Client.selectedSpellChildIndex);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 3) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2235, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5468(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.writeIntME(class286.baseY * 64 + var1);
			var8.packetBuffer.writeShortLE(class223.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 4) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2190, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShortLE(var3);
			var8.packetBuffer.writeShort(class223.baseX * 64 + var0);
			var8.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntME(class286.baseY * 64 + var1);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 5) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2226, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.writeIntME(class223.baseX * 64 + var0);
			var8.packetBuffer.writeShortLE(class286.baseY * 64 + var1);
			var8.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 6) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2266, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(class223.baseX * 64 + var0);
			var8.packetBuffer.method5468(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntME(var3);
			var8.packetBuffer.writeIntME(class286.baseY * 64 + var1);
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
					var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2195, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeIntLE16(class2.selectedItemWidget);
					var9.packetBuffer.writeShortLE(AbstractWorldMapData.selectedItemId);
					var9.packetBuffer.writeIntME(var3);
					var9.packetBuffer.writeShortLE(DevicePcmPlayerProvider.selectedItemSlot);
					var9.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2260, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5476(Client.selectedSpellChildIndex);
					var9.packetBuffer.method5476(var3);
					var9.packetBuffer.writeIntLE16(AttackOption.selectedSpellWidget);
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
					var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2273, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5476(var3);
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
					var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2280, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeIntME(var3);
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
					var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2219, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5476(var3);
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
					var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2263, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5476(var3);
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
					var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2221, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5476(var3);
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
						var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2243, Client.packetWriter.isaacCipher);
						var9.packetBuffer.writeShortLE(var3);
						var9.packetBuffer.method5630(class2.selectedItemWidget);
						var9.packetBuffer.writeShort(AbstractWorldMapData.selectedItemId);
						var9.packetBuffer.method5476(DevicePcmPlayerProvider.selectedItemSlot);
						var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
						var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2239, Client.packetWriter.isaacCipher);
						var9.packetBuffer.method5476(var3);
						var9.packetBuffer.writeIntME(Client.selectedSpellChildIndex);
						var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var9.packetBuffer.method5489(AttackOption.selectedSpellWidget);
						Client.packetWriter.addNode(var9);
					}
				} else if (var2 == 16) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2197, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortLE(var3);
					var8.packetBuffer.writeInt(class2.selectedItemWidget);
					var8.packetBuffer.writeIntME(DevicePcmPlayerProvider.selectedItemSlot);
					var8.packetBuffer.writeShortLE(class286.baseY * 64 + var1);
					var8.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeIntME(class223.baseX * 64 + var0);
					var8.packetBuffer.writeIntME(AbstractWorldMapData.selectedItemId);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 17) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2218, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeIntME(class286.baseY * 64 + var1);
					var8.packetBuffer.writeIntLE16(AttackOption.selectedSpellWidget);
					var8.packetBuffer.writeShortLE(var3);
					var8.packetBuffer.writeIntME(Client.selectedSpellChildIndex);
					var8.packetBuffer.method5476(class223.baseX * 64 + var0);
					var8.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 18) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2277, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5476(class286.baseY * 64 + var1);
					var8.packetBuffer.writeIntME(class223.baseX * 64 + var0);
					var8.packetBuffer.writeShortLE(var3);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 19) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2205, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeIntME(class223.baseX * 64 + var0);
					var8.packetBuffer.writeIntME(var3);
					var8.packetBuffer.writeIntME(class286.baseY * 64 + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 20) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2240, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5468(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShortLE(class223.baseX * 64 + var0);
					var8.packetBuffer.writeIntME(class286.baseY * 64 + var1);
					var8.packetBuffer.method5476(var3);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 21) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2265, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortLE(class223.baseX * 64 + var0);
					var8.packetBuffer.writeIntME(class286.baseY * 64 + var1);
					var8.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShort(var3);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 22) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2192, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5476(class223.baseX * 64 + var0);
					var8.packetBuffer.method5476(class286.baseY * 64 + var1);
					var8.packetBuffer.writeShortLE(var3);
					var8.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 23) {
					if (Client.isMenuOpen) {
						PacketWriter.scene.setViewportWalking();
					} else {
						PacketWriter.scene.menuOpen(WorldMapRectangle.plane, var0, var1, true);
					}
				} else {
					PacketBufferNode var10;
					Widget var16;
					if (var2 == 24) {
						var16 = Canvas.getWidget(var1);
						boolean var11 = true;
						if (var16.contentType > 0) {
							var11 = class43.method840(var16);
						}

						if (var11) {
							var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2261, Client.packetWriter.isaacCipher);
							var10.packetBuffer.writeInt(var1);
							Client.packetWriter.addNode(var10);
						}
					} else {
						if (var2 == 25) {
							var16 = GrandExchangeOfferWorldComparator.getWidgetChild(var1, var0);
							if (var16 != null) {
								class208.Widget_runOnTargetLeave();
								class32.selectSpell(var1, var0, class2.method30(class2.getWidgetClickMask(var16)), var16.itemId);
								Client.isItemSelected = 0;
								Client.selectedSpellActionName = VerticalAlignment.method4321(var16);
								if (Client.selectedSpellActionName == null) {
									Client.selectedSpellActionName = "null";
								}

								if (var16.isIf3) {
									Client.selectedSpellName = var16.dataText + World.colorStartTag(16777215);
								} else {
									Client.selectedSpellName = World.colorStartTag(65280) + var16.spellName + World.colorStartTag(16777215);
								}
							}

							return;
						}

						if (var2 == 26) {
							class51.method922();
						} else {
							int var12;
							Widget var14;
							if (var2 == 28) {
								var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2261, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = Canvas.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var12 = var14.cs1Instructions[0][1];
									Varps.Varps_main[var12] = 1 - Varps.Varps_main[var12];
									NetSocket.method3472(var12);
								}
							} else if (var2 == 29) {
								var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2261, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = Canvas.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var12 = var14.cs1Instructions[0][1];
									if (Varps.Varps_main[var12] != var14.cs1ComparisonValues[0]) {
										Varps.Varps_main[var12] = var14.cs1ComparisonValues[0];
										NetSocket.method3472(var12);
									}
								}
							} else if (var2 == 30) {
								if (Client.meslayerContinueWidget == null) {
									Clock.resumePauseWidget(var1, var0);
									Client.meslayerContinueWidget = GrandExchangeOfferWorldComparator.getWidgetChild(var1, var0);
									WorldMapSectionType.invalidateWidget(Client.meslayerContinueWidget);
								}
							} else if (var2 == 31) {
								var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2269, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5630(var1);
								var8.packetBuffer.writeShortLE(DevicePcmPlayerProvider.selectedItemSlot);
								var8.packetBuffer.writeInt(class2.selectedItemWidget);
								var8.packetBuffer.writeShort(AbstractWorldMapData.selectedItemId);
								var8.packetBuffer.writeShort(var0);
								var8.packetBuffer.writeShort(var3);
								Client.packetWriter.addNode(var8);
								Client.field750 = 0;
								GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(var1);
								Client.field743 = var0;
							} else if (var2 == 32) {
								var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2246, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
								var8.packetBuffer.method5476(var0);
								var8.packetBuffer.method5476(var3);
								var8.packetBuffer.method5630(var1);
								var8.packetBuffer.method5489(AttackOption.selectedSpellWidget);
								Client.packetWriter.addNode(var8);
								Client.field750 = 0;
								GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(var1);
								Client.field743 = var0;
							} else if (var2 == 33) {
								var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2211, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								var8.packetBuffer.method5476(var0);
								var8.packetBuffer.method5476(var3);
								Client.packetWriter.addNode(var8);
								Client.field750 = 0;
								GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(var1);
								Client.field743 = var0;
							} else if (var2 == 34) {
								var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2255, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								var8.packetBuffer.method5476(var0);
								var8.packetBuffer.writeIntME(var3);
								Client.packetWriter.addNode(var8);
								Client.field750 = 0;
								GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(var1);
								Client.field743 = var0;
							} else if (var2 == 35) {
								var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2189, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5476(var3);
								var8.packetBuffer.writeIntLE16(var1);
								var8.packetBuffer.writeShort(var0);
								Client.packetWriter.addNode(var8);
								Client.field750 = 0;
								GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(var1);
								Client.field743 = var0;
							} else if (var2 == 36) {
								var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2198, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeShortLE(var3);
								var8.packetBuffer.method5476(var0);
								var8.packetBuffer.method5630(var1);
								Client.packetWriter.addNode(var8);
								Client.field750 = 0;
								GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(var1);
								Client.field743 = var0;
							} else if (var2 == 37) {
								var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2247, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntME(var0);
								var8.packetBuffer.method5630(var1);
								var8.packetBuffer.writeIntME(var3);
								Client.packetWriter.addNode(var8);
								Client.field750 = 0;
								GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(var1);
								Client.field743 = var0;
							} else {
								if (var2 == 38) {
									class208.Widget_runOnTargetLeave();
									var16 = Canvas.getWidget(var1);
									Client.isItemSelected = 1;
									DevicePcmPlayerProvider.selectedItemSlot = var0;
									class2.selectedItemWidget = var1;
									AbstractWorldMapData.selectedItemId = var3;
									WorldMapSectionType.invalidateWidget(var16);
									Client.selectedItemName = World.colorStartTag(16748608) + Occluder.ItemDefinition_get(var3).name + World.colorStartTag(16777215);
									if (Client.selectedItemName == null) {
										Client.selectedItemName = "null";
									}

									return;
								}

								if (var2 == 39) {
									var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2217, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeIntME(var0);
									var8.packetBuffer.writeShort(var3);
									var8.packetBuffer.method5489(var1);
									Client.packetWriter.addNode(var8);
									Client.field750 = 0;
									GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(var1);
									Client.field743 = var0;
								} else if (var2 == 40) {
									var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2272, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5630(var1);
									var8.packetBuffer.writeIntME(var0);
									var8.packetBuffer.writeShortLE(var3);
									Client.packetWriter.addNode(var8);
									Client.field750 = 0;
									GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(var1);
									Client.field743 = var0;
								} else if (var2 == 41) {
									var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2250, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5476(var0);
									var8.packetBuffer.method5489(var1);
									var8.packetBuffer.method5476(var3);
									Client.packetWriter.addNode(var8);
									Client.field750 = 0;
									GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(var1);
									Client.field743 = var0;
								} else if (var2 == 42) {
									var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2259, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeShort(var3);
									var8.packetBuffer.writeShort(var0);
									var8.packetBuffer.method5630(var1);
									Client.packetWriter.addNode(var8);
									Client.field750 = 0;
									GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(var1);
									Client.field743 = var0;
								} else if (var2 == 43) {
									var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2282, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeShort(var3);
									var8.packetBuffer.method5489(var1);
									var8.packetBuffer.writeShort(var0);
									Client.packetWriter.addNode(var8);
									Client.field750 = 0;
									GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(var1);
									Client.field743 = var0;
								} else if (var2 == 44) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2231, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeIntME(var3);
										var9.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2227, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeShortLE(var3);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2206, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5476(var3);
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
										var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2271, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeShortLE(var3);
										var9.packetBuffer.method5468(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2242, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5468(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5476(var3);
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
										var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2214, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeShort(var3);
										var9.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2274, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5476(var3);
										var9.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2262, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeIntME(var3);
										Client.packetWriter.addNode(var9);
									}
								} else {
									label960: {
										if (var2 != 57) {
											if (var2 == 58) {
												var16 = GrandExchangeOfferWorldComparator.getWidgetChild(var1, var0);
												if (var16 != null) {
													var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2236, Client.packetWriter.isaacCipher);
													var9.packetBuffer.method5630(var1);
													var9.packetBuffer.writeShort(var16.itemId);
													var9.packetBuffer.writeIntLE16(AttackOption.selectedSpellWidget);
													var9.packetBuffer.writeShortLE(var0);
													var9.packetBuffer.writeIntME(Client.selectedSpellChildIndex);
													var9.packetBuffer.writeIntME(Client.field793);
													Client.packetWriter.addNode(var9);
												}
												break label960;
											}

											if (var2 == 1001) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												Client.destinationX = var0;
												Client.destinationY = var1;
												var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2234, Client.packetWriter.isaacCipher);
												var8.packetBuffer.writeShort(class286.baseY * 64 + var1);
												var8.packetBuffer.writeShort(class223.baseX * 64 + var0);
												var8.packetBuffer.writeShort(var3);
												var8.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
												Client.packetWriter.addNode(var8);
												break label960;
											}

											if (var2 == 1002) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2220, Client.packetWriter.isaacCipher);
												var8.packetBuffer.method5476(var3);
												Client.packetWriter.addNode(var8);
												break label960;
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
														var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2248, Client.packetWriter.isaacCipher);
														var10.packetBuffer.writeIntME(var17.id);
														Client.packetWriter.addNode(var10);
													}
												}
												break label960;
											}

											if (var2 == 1004) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2212, Client.packetWriter.isaacCipher);
												var8.packetBuffer.writeShort(var3);
												Client.packetWriter.addNode(var8);
												break label960;
											}

											if (var2 == 1005) {
												var16 = Canvas.getWidget(var1);
												if (var16 != null && var16.itemQuantities[var0] >= 100000) {
													class210.addGameMessage(27, "", var16.itemQuantities[var0] + " x " + Occluder.ItemDefinition_get(var3).name);
												} else {
													var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2212, Client.packetWriter.isaacCipher);
													var9.packetBuffer.writeShort(var3);
													Client.packetWriter.addNode(var9);
												}

												Client.field750 = 0;
												GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(var1);
												Client.field743 = var0;
												break label960;
											}

											if (var2 != 1007) {
												if (var2 == 1011 || var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1012) {
													Tiles.worldMap.menuAction(var2, var3, new Coord(var0), new Coord(var1));
												}
												break label960;
											}
										}

										var16 = GrandExchangeOfferWorldComparator.getWidgetChild(var1, var0);
										if (var16 != null) {
											WorldMapSection1.method605(var3, var1, var0, var16.itemId, var5);
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
			WorldMapSectionType.invalidateWidget(Canvas.getWidget(class2.selectedItemWidget));
		}

		if (Client.isSpellSelected) {
			class208.Widget_runOnTargetLeave();
		}

		if (GrandExchangeOfferOwnWorldComparator.field628 != null && Client.field750 == 0) {
			WorldMapSectionType.invalidateWidget(GrandExchangeOfferOwnWorldComparator.field628);
		}

	}

	@ObfuscatedName("ig")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lho;I)Ljava/lang/String;",
		garbageValue = "-1374184738"
	)
	static String method4335(String var0, Widget var1) {
		if (var0.indexOf("%") != -1) {
			for (int var2 = 1; var2 <= 5; ++var2) {
				while (true) {
					int var3 = var0.indexOf("%" + var2);
					if (var3 == -1) {
						break;
					}

					String var4 = var0.substring(0, var3);
					int var6 = class216.method4015(var1, var2 - 1);
					String var5;
					if (var6 < 999999999) {
						var5 = Integer.toString(var6);
					} else {
						var5 = "*";
					}

					var0 = var4 + var5 + var0.substring(var3 + 2);
				}
			}
		}

		return var0;
	}
}
