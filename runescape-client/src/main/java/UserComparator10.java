import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
@Implements("UserComparator10")
public class UserComparator10 extends AbstractUserComparator {
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("soundEffectsArchive")
	static AbstractArchive soundEffectsArchive;
	@ObfuscatedName("c")
	@Export("reversed")
	final boolean reversed;

	public UserComparator10(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lje;Lje;I)I",
		garbageValue = "1802952011"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world && var2.world == Client.worldId) {
			return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1451340880"
	)
	public static void method3476() {
		synchronized(MouseHandler.MouseHandler_instance) {
			MouseHandler.MouseHandler_currentButton = MouseHandler.MouseHandler_currentButtonVolatile;
			MouseHandler.MouseHandler_x = MouseHandler.MouseHandler_xVolatile;
			MouseHandler.MouseHandler_y = MouseHandler.MouseHandler_yVolatile;
			MouseHandler.MouseHandler_millis = MouseHandler.MouseHandler_lastMovedVolatile;
			MouseHandler.MouseHandler_lastButton = MouseHandler.MouseHandler_lastButtonVolatile;
			MouseHandler.MouseHandler_lastPressedX = MouseHandler.MouseHandler_lastPressedXVolatile;
			MouseHandler.MouseHandler_lastPressedY = MouseHandler.MouseHandler_lastPressedYVolatile;
			MouseHandler.MouseHandler_lastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillisVolatile;
			MouseHandler.MouseHandler_lastButtonVolatile = 0;
		}
	}

	@ObfuscatedName("hr")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
		garbageValue = "-2121954499"
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
			var8 = TilePaint.getPacketBufferNode(ClientPacket.field2267, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5787(class65.selectedItemSlot);
			var8.packetBuffer.writeShortLE(MusicPatch.selectedItemId);
			var8.packetBuffer.writeIntME(var3);
			var8.packetBuffer.method5604(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntME(Language.baseY * 64 + var1);
			var8.packetBuffer.method5623(FriendSystem.selectedItemWidget);
			var8.packetBuffer.writeShortLE(Messages.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 2) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = TilePaint.getPacketBufferNode(ClientPacket.field2223, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5624(FontName.selectedSpellWidget);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.writeShort(Client.selectedSpellChildIndex);
			var8.packetBuffer.method5604(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(Language.baseY * 64 + var1);
			var8.packetBuffer.writeShortLE(Messages.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 3) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = TilePaint.getPacketBufferNode(ClientPacket.field2236, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5602(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShortLE(Language.baseY * 64 + var1);
			var8.packetBuffer.writeShortLE(var3);
			var8.packetBuffer.method5787(Messages.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 4) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = TilePaint.getPacketBufferNode(ClientPacket.field2244, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(Messages.baseX * 64 + var0);
			var8.packetBuffer.method5603(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.writeShort(Language.baseY * 64 + var1);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 5) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = TilePaint.getPacketBufferNode(ClientPacket.field2299, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShortLE(var3);
			var8.packetBuffer.method5602(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5787(Messages.baseX * 64 + var0);
			var8.packetBuffer.writeShortLE(Language.baseY * 64 + var1);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 6) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = TilePaint.getPacketBufferNode(ClientPacket.field2294, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5787(Messages.baseX * 64 + var0);
			var8.packetBuffer.method5787(Language.baseY * 64 + var1);
			var8.packetBuffer.method5603(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShortLE(var3);
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
					var9 = TilePaint.getPacketBufferNode(ClientPacket.field2206, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5602(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5787(var3);
					var9.packetBuffer.writeInt(FriendSystem.selectedItemWidget);
					var9.packetBuffer.writeIntME(class65.selectedItemSlot);
					var9.packetBuffer.writeIntME(MusicPatch.selectedItemId);
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
					var9 = TilePaint.getPacketBufferNode(ClientPacket.field2217, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5787(Client.selectedSpellChildIndex);
					var9.packetBuffer.method5787(var3);
					var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5622(FontName.selectedSpellWidget);
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
					var9 = TilePaint.getPacketBufferNode(ClientPacket.field2279, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5787(var3);
					var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = TilePaint.getPacketBufferNode(ClientPacket.field2211, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeIntME(var3);
					var9.packetBuffer.method5604(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = TilePaint.getPacketBufferNode(ClientPacket.field2238, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeShort(var3);
					var9.packetBuffer.method5604(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = TilePaint.getPacketBufferNode(ClientPacket.field2239, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5604(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5787(var3);
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
					var9 = TilePaint.getPacketBufferNode(ClientPacket.field2230, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5603(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
						var9 = TilePaint.getPacketBufferNode(ClientPacket.field2290, Client.packetWriter.isaacCipher);
						var9.packetBuffer.writeShort(MusicPatch.selectedItemId);
						var9.packetBuffer.method5603(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var9.packetBuffer.writeIntME(class65.selectedItemSlot);
						var9.packetBuffer.method5624(FriendSystem.selectedItemWidget);
						var9.packetBuffer.method5787(var3);
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
						var9 = TilePaint.getPacketBufferNode(ClientPacket.field2220, Client.packetWriter.isaacCipher);
						var9.packetBuffer.writeShort(Client.selectedSpellChildIndex);
						var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var9.packetBuffer.method5623(FontName.selectedSpellWidget);
						var9.packetBuffer.method5787(var3);
						Client.packetWriter.addNode(var9);
					}
				} else if (var2 == 16) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = TilePaint.getPacketBufferNode(ClientPacket.field2272, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeIntME(Language.baseY * 64 + var1);
					var8.packetBuffer.writeIntME(Messages.baseX * 64 + var0);
					var8.packetBuffer.method5624(FriendSystem.selectedItemWidget);
					var8.packetBuffer.writeShort(class65.selectedItemSlot);
					var8.packetBuffer.writeIntME(MusicPatch.selectedItemId);
					var8.packetBuffer.method5604(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeIntME(var3);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 17) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = TilePaint.getPacketBufferNode(ClientPacket.field2262, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5623(FontName.selectedSpellWidget);
					var8.packetBuffer.writeShort(Language.baseY * 64 + var1);
					var8.packetBuffer.method5787(Messages.baseX * 64 + var0);
					var8.packetBuffer.method5787(var3);
					var8.packetBuffer.method5787(Client.selectedSpellChildIndex);
					var8.packetBuffer.method5604(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 18) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = TilePaint.getPacketBufferNode(ClientPacket.field2231, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5787(Messages.baseX * 64 + var0);
					var8.packetBuffer.writeShort(var3);
					var8.packetBuffer.method5603(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShortLE(Language.baseY * 64 + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 19) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = TilePaint.getPacketBufferNode(ClientPacket.field2297, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortLE(Messages.baseX * 64 + var0);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5787(var3);
					var8.packetBuffer.writeShortLE(Language.baseY * 64 + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 20) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = TilePaint.getPacketBufferNode(ClientPacket.field2224, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortLE(Messages.baseX * 64 + var0);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5787(var3);
					var8.packetBuffer.writeShortLE(Language.baseY * 64 + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 21) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = TilePaint.getPacketBufferNode(ClientPacket.field2227, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortLE(Language.baseY * 64 + var1);
					var8.packetBuffer.writeShortLE(var3);
					var8.packetBuffer.method5602(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeIntME(Messages.baseX * 64 + var0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 22) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = TilePaint.getPacketBufferNode(ClientPacket.field2301, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5787(Messages.baseX * 64 + var0);
					var8.packetBuffer.writeIntME(var3);
					var8.packetBuffer.method5603(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeIntME(Language.baseY * 64 + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 23) {
					if (Client.isMenuOpen) {
						ServerBuild.scene.setViewportWalking();
					} else {
						ServerBuild.scene.menuOpen(Clock.Client_plane, var0, var1, true);
					}
				} else {
					PacketBufferNode var12;
					Widget var16;
					if (var2 == 24) {
						var16 = Varps.getWidget(var1);
						boolean var11 = true;
						if (var16.contentType > 0) {
							var11 = BufferedSink.method5915(var16);
						}

						if (var11) {
							var12 = TilePaint.getPacketBufferNode(ClientPacket.field2225, Client.packetWriter.isaacCipher);
							var12.packetBuffer.writeInt(var1);
							Client.packetWriter.addNode(var12);
						}
					} else {
						if (var2 == 25) {
							var16 = SpriteMask.getWidgetChild(var1, var0);
							if (var16 != null) {
								WorldMapManager.Widget_runOnTargetLeave();
								MusicPatchNode.selectSpell(var1, var0, class83.method2108(WorldMapIcon_0.getWidgetClickMask(var16)), var16.itemId);
								Client.isItemSelected = 0;
								Client.selectedSpellActionName = PcmPlayer.method2542(var16);
								if (Client.selectedSpellActionName == null) {
									Client.selectedSpellActionName = "null";
								}

								if (var16.isIf3) {
									Client.selectedSpellName = var16.dataText + PacketWriter.colorStartTag(16777215);
								} else {
									Client.selectedSpellName = PacketWriter.colorStartTag(65280) + var16.spellName + PacketWriter.colorStartTag(16777215);
								}
							}

							return;
						}

						if (var2 == 26) {
							KeyHandler.method848();
						} else {
							int var10;
							Widget var14;
							if (var2 == 28) {
								var8 = TilePaint.getPacketBufferNode(ClientPacket.field2225, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = Varps.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var10 = var14.cs1Instructions[0][1];
									Varps.Varps_main[var10] = 1 - Varps.Varps_main[var10];
									ServerPacket.changeGameOptions(var10);
								}
							} else if (var2 == 29) {
								var8 = TilePaint.getPacketBufferNode(ClientPacket.field2225, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = Varps.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var10 = var14.cs1Instructions[0][1];
									if (Varps.Varps_main[var10] != var14.cs1ComparisonValues[0]) {
										Varps.Varps_main[var10] = var14.cs1ComparisonValues[0];
										ServerPacket.changeGameOptions(var10);
									}
								}
							} else if (var2 == 30) {
								if (Client.meslayerContinueWidget == null) {
									WorldMapAreaData.resumePauseWidget(var1, var0);
									Client.meslayerContinueWidget = SpriteMask.getWidgetChild(var1, var0);
									NPCDefinition.invalidateWidget(Client.meslayerContinueWidget);
								}
							} else if (var2 == 31) {
								var8 = TilePaint.getPacketBufferNode(ClientPacket.field2232, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5787(MusicPatch.selectedItemId);
								var8.packetBuffer.method5787(class65.selectedItemSlot);
								var8.packetBuffer.method5624(var1);
								var8.packetBuffer.method5787(var0);
								var8.packetBuffer.writeIntME(var3);
								var8.packetBuffer.method5622(FriendSystem.selectedItemWidget);
								Client.packetWriter.addNode(var8);
								Client.field751 = 0;
								Skeleton.field1793 = Varps.getWidget(var1);
								Client.field752 = var0;
							} else if (var2 == 32) {
								var8 = TilePaint.getPacketBufferNode(ClientPacket.field2250, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeShortLE(var0);
								var8.packetBuffer.method5787(var3);
								var8.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
								var8.packetBuffer.method5622(var1);
								var8.packetBuffer.method5622(FontName.selectedSpellWidget);
								Client.packetWriter.addNode(var8);
								Client.field751 = 0;
								Skeleton.field1793 = Varps.getWidget(var1);
								Client.field752 = var0;
							} else if (var2 == 33) {
								var8 = TilePaint.getPacketBufferNode(ClientPacket.field2291, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntME(var0);
								var8.packetBuffer.writeInt(var1);
								var8.packetBuffer.writeIntME(var3);
								Client.packetWriter.addNode(var8);
								Client.field751 = 0;
								Skeleton.field1793 = Varps.getWidget(var1);
								Client.field752 = var0;
							} else if (var2 == 34) {
								var8 = TilePaint.getPacketBufferNode(ClientPacket.field2302, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5787(var3);
								var8.packetBuffer.writeIntME(var0);
								var8.packetBuffer.method5622(var1);
								Client.packetWriter.addNode(var8);
								Client.field751 = 0;
								Skeleton.field1793 = Varps.getWidget(var1);
								Client.field752 = var0;
							} else if (var2 == 35) {
								var8 = TilePaint.getPacketBufferNode(ClientPacket.field2259, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5787(var0);
								var8.packetBuffer.writeIntME(var3);
								var8.packetBuffer.method5623(var1);
								Client.packetWriter.addNode(var8);
								Client.field751 = 0;
								Skeleton.field1793 = Varps.getWidget(var1);
								Client.field752 = var0;
							} else if (var2 == 36) {
								var8 = TilePaint.getPacketBufferNode(ClientPacket.field2248, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5622(var1);
								var8.packetBuffer.writeShortLE(var0);
								var8.packetBuffer.writeShortLE(var3);
								Client.packetWriter.addNode(var8);
								Client.field751 = 0;
								Skeleton.field1793 = Varps.getWidget(var1);
								Client.field752 = var0;
							} else if (var2 == 37) {
								var8 = TilePaint.getPacketBufferNode(ClientPacket.field2226, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5624(var1);
								var8.packetBuffer.writeShortLE(var3);
								var8.packetBuffer.method5787(var0);
								Client.packetWriter.addNode(var8);
								Client.field751 = 0;
								Skeleton.field1793 = Varps.getWidget(var1);
								Client.field752 = var0;
							} else {
								if (var2 == 38) {
									WorldMapManager.Widget_runOnTargetLeave();
									var16 = Varps.getWidget(var1);
									Client.isItemSelected = 1;
									class65.selectedItemSlot = var0;
									FriendSystem.selectedItemWidget = var1;
									MusicPatch.selectedItemId = var3;
									NPCDefinition.invalidateWidget(var16);
									Client.selectedItemName = PacketWriter.colorStartTag(16748608) + HealthBarDefinition.ItemDefinition_get(var3).name + PacketWriter.colorStartTag(16777215);
									if (Client.selectedItemName == null) {
										Client.selectedItemName = "null";
									}

									return;
								}

								if (var2 == 39) {
									var8 = TilePaint.getPacketBufferNode(ClientPacket.field2253, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeIntME(var3);
									var8.packetBuffer.writeShortLE(var0);
									var8.packetBuffer.method5622(var1);
									Client.packetWriter.addNode(var8);
									Client.field751 = 0;
									Skeleton.field1793 = Varps.getWidget(var1);
									Client.field752 = var0;
								} else if (var2 == 40) {
									var8 = TilePaint.getPacketBufferNode(ClientPacket.field2268, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5623(var1);
									var8.packetBuffer.writeIntME(var3);
									var8.packetBuffer.writeShortLE(var0);
									Client.packetWriter.addNode(var8);
									Client.field751 = 0;
									Skeleton.field1793 = Varps.getWidget(var1);
									Client.field752 = var0;
								} else if (var2 == 41) {
									var8 = TilePaint.getPacketBufferNode(ClientPacket.field2269, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5624(var1);
									var8.packetBuffer.method5787(var0);
									var8.packetBuffer.method5787(var3);
									Client.packetWriter.addNode(var8);
									Client.field751 = 0;
									Skeleton.field1793 = Varps.getWidget(var1);
									Client.field752 = var0;
								} else if (var2 == 42) {
									var8 = TilePaint.getPacketBufferNode(ClientPacket.field2215, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeShortLE(var3);
									var8.packetBuffer.method5622(var1);
									var8.packetBuffer.writeShort(var0);
									Client.packetWriter.addNode(var8);
									Client.field751 = 0;
									Skeleton.field1793 = Varps.getWidget(var1);
									Client.field752 = var0;
								} else if (var2 == 43) {
									var8 = TilePaint.getPacketBufferNode(ClientPacket.field2261, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5787(var0);
									var8.packetBuffer.writeShortLE(var3);
									var8.packetBuffer.method5624(var1);
									Client.packetWriter.addNode(var8);
									Client.field751 = 0;
									Skeleton.field1793 = Varps.getWidget(var1);
									Client.field752 = var0;
								} else if (var2 == 44) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = TilePaint.getPacketBufferNode(ClientPacket.field2282, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeShort(var3);
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
										var9 = TilePaint.getPacketBufferNode(ClientPacket.field2296, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5787(var3);
										var9.packetBuffer.method5602(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = TilePaint.getPacketBufferNode(ClientPacket.field2300, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5787(var3);
										var9.packetBuffer.method5602(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = TilePaint.getPacketBufferNode(ClientPacket.field2216, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeShortLE(var3);
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
										var9 = TilePaint.getPacketBufferNode(ClientPacket.field2281, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5787(var3);
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
										var9 = TilePaint.getPacketBufferNode(ClientPacket.field2221, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5787(var3);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = TilePaint.getPacketBufferNode(ClientPacket.field2266, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5787(var3);
										var9.packetBuffer.method5602(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = TilePaint.getPacketBufferNode(ClientPacket.field2243, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5603(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5787(var3);
										Client.packetWriter.addNode(var9);
									}
								} else {
									label982: {
										if (var2 != 57) {
											if (var2 == 58) {
												var16 = SpriteMask.getWidgetChild(var1, var0);
												if (var16 != null) {
													var9 = TilePaint.getPacketBufferNode(ClientPacket.field2264, Client.packetWriter.isaacCipher);
													var9.packetBuffer.method5787(Client.field802);
													var9.packetBuffer.writeShortLE(var0);
													var9.packetBuffer.method5623(var1);
													var9.packetBuffer.writeShortLE(var16.itemId);
													var9.packetBuffer.method5623(FontName.selectedSpellWidget);
													var9.packetBuffer.writeShort(Client.selectedSpellChildIndex);
													Client.packetWriter.addNode(var9);
												}
												break label982;
											}

											if (var2 == 1001) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												Client.destinationX = var0;
												Client.destinationY = var1;
												var8 = TilePaint.getPacketBufferNode(ClientPacket.field2292, Client.packetWriter.isaacCipher);
												var8.packetBuffer.method5604(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
												var8.packetBuffer.writeShortLE(Messages.baseX * 64 + var0);
												var8.packetBuffer.writeIntME(var3);
												var8.packetBuffer.writeShort(Language.baseY * 64 + var1);
												Client.packetWriter.addNode(var8);
												break label982;
											}

											if (var2 == 1002) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = TilePaint.getPacketBufferNode(ClientPacket.field2228, Client.packetWriter.isaacCipher);
												var8.packetBuffer.writeShortLE(var3);
												Client.packetWriter.addNode(var8);
												break label982;
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
														var12 = TilePaint.getPacketBufferNode(ClientPacket.field2258, Client.packetWriter.isaacCipher);
														var12.packetBuffer.writeIntME(var17.id);
														Client.packetWriter.addNode(var12);
													}
												}
												break label982;
											}

											if (var2 == 1004) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = TilePaint.getPacketBufferNode(ClientPacket.field2246, Client.packetWriter.isaacCipher);
												var8.packetBuffer.writeShort(var3);
												Client.packetWriter.addNode(var8);
												break label982;
											}

											if (var2 == 1005) {
												var16 = Varps.getWidget(var1);
												if (var16 != null && var16.itemQuantities[var0] >= 100000) {
													ClientPreferences.addGameMessage(27, "", var16.itemQuantities[var0] + " x " + HealthBarDefinition.ItemDefinition_get(var3).name);
												} else {
													var9 = TilePaint.getPacketBufferNode(ClientPacket.field2246, Client.packetWriter.isaacCipher);
													var9.packetBuffer.writeShort(var3);
													Client.packetWriter.addNode(var9);
												}

												Client.field751 = 0;
												Skeleton.field1793 = Varps.getWidget(var1);
												Client.field752 = var0;
												break label982;
											}

											if (var2 != 1007) {
												if (var2 == 1009 || var2 == 1008 || var2 == 1011 || var2 == 1010 || var2 == 1012) {
													WorldMapIcon_0.worldMap.worldMapMenuAction(var2, var3, new Coord(var0), new Coord(var1));
												}
												break label982;
											}
										}

										var16 = SpriteMask.getWidgetChild(var1, var0);
										if (var16 != null) {
											NPC.widgetDefaultMenuAction(var3, var1, var0, var16.itemId, var5);
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
			NPCDefinition.invalidateWidget(Varps.getWidget(FriendSystem.selectedItemWidget));
		}

		if (Client.isSpellSelected) {
			WorldMapManager.Widget_runOnTargetLeave();
		}

		if (Skeleton.field1793 != null && Client.field751 == 0) {
			NPCDefinition.invalidateWidget(Skeleton.field1793);
		}

	}
}
