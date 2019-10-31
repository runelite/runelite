import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("GrandExchangeOfferOwnWorldComparator")
public class GrandExchangeOfferOwnWorldComparator implements Comparator {
	@ObfuscatedName("gs")
	@Export("regions")
	static int[] regions;
	@ObfuscatedName("gb")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("mapMarkerSprites")
	static Sprite[] mapMarkerSprites;
	@ObfuscatedName("a")
	@Export("filterWorlds")
	boolean filterWorlds;

	GrandExchangeOfferOwnWorldComparator() {
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lo;Lo;B)I",
		garbageValue = "68"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		if (var2.world == var1.world) {
			return 0;
		} else {
			if (this.filterWorlds) {
				if (Client.worldId == var1.world) {
					return -1;
				}

				if (var2.world == Client.worldId) {
					return 1;
				}
			}

			return var1.world < var2.world ? -1 : 1;
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(II)Lid;",
		garbageValue = "-1586537881"
	)
	@Export("StructDefinition_getStructDefinition")
	public static StructDefinition StructDefinition_getStructDefinition(int var0) {
		StructDefinition var1 = (StructDefinition)StructDefinition.StructDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = StructDefinition.StructDefinition_archive.takeFile(34, var0);
			var1 = new StructDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			StructDefinition.StructDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "26"
	)
	static final boolean method1376() {
		return ViewportMouse.ViewportMouse_isInViewport;
	}

	@ObfuscatedName("io")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
		garbageValue = "1191285249"
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
			var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2249, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShortLE(Occluder.selectedItemId);
			var8.packetBuffer.method5643(UserComparator8.baseX * 64 + var0);
			var8.packetBuffer.writeInt(MidiPcmStream.selectedItemWidget);
			var8.packetBuffer.method5643(HealthBar.baseY * 64 + var1);
			var8.packetBuffer.method5644(MouseRecorder.selectedItemSlot);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 2) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2223, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShortLE(HealthBar.baseY * 64 + var1);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.writeShortLE(UserComparator8.baseX * 64 + var0);
			var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(Client.selectedSpellChildIndex);
			var8.packetBuffer.writeInt(Clock.selectedSpellWidget);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 3) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2270, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShortLE(UserComparator8.baseX * 64 + var0);
			var8.packetBuffer.writeShortLE(HealthBar.baseY * 64 + var1);
			var8.packetBuffer.method5643(var3);
			var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 4) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2278, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5644(UserComparator8.baseX * 64 + var0);
			var8.packetBuffer.method5634(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShortLE(var3);
			var8.packetBuffer.method5644(HealthBar.baseY * 64 + var1);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 5) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2192, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5636(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShortLE(UserComparator8.baseX * 64 + var0);
			var8.packetBuffer.writeShortLE(HealthBar.baseY * 64 + var1);
			var8.packetBuffer.writeShortLE(var3);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 6) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2240, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5643(UserComparator8.baseX * 64 + var0);
			var8.packetBuffer.method5643(var3);
			var8.packetBuffer.method5643(HealthBar.baseY * 64 + var1);
			var8.packetBuffer.method5635(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2233, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeShortLE(Occluder.selectedItemId);
					var9.packetBuffer.method5636(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeShortLE(var3);
					var9.packetBuffer.writeShortLE(MouseRecorder.selectedItemSlot);
					var9.packetBuffer.writeIntME(MidiPcmStream.selectedItemWidget);
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
					var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2217, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5643(var3);
					var9.packetBuffer.method5644(Client.selectedSpellChildIndex);
					var9.packetBuffer.method5655(Clock.selectedSpellWidget);
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
					var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2181, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5643(var3);
					var9.packetBuffer.method5636(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2272, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeShortLE(var3);
					var9.packetBuffer.method5635(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2282, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5643(var3);
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
					var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2268, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeShort(var3);
					var9.packetBuffer.method5636(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
					var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2188, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5635(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5644(var3);
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
						var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2206, Client.packetWriter.isaacCipher);
						var9.packetBuffer.method5644(var3);
						var9.packetBuffer.method5644(MouseRecorder.selectedItemSlot);
						var9.packetBuffer.writeInt(MidiPcmStream.selectedItemWidget);
						var9.packetBuffer.method5643(Occluder.selectedItemId);
						var9.packetBuffer.method5636(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
						var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2180, Client.packetWriter.isaacCipher);
						var9.packetBuffer.method5653(Clock.selectedSpellWidget);
						var9.packetBuffer.method5635(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var9.packetBuffer.writeShort(var3);
						var9.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
						Client.packetWriter.addNode(var9);
					}
				} else if (var2 == 16) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2184, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5643(var3);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5644(UserComparator8.baseX * 64 + var0);
					var8.packetBuffer.method5655(MidiPcmStream.selectedItemWidget);
					var8.packetBuffer.writeShort(HealthBar.baseY * 64 + var1);
					var8.packetBuffer.method5643(MouseRecorder.selectedItemSlot);
					var8.packetBuffer.method5643(Occluder.selectedItemId);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 17) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2254, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortLE(HealthBar.baseY * 64 + var1);
					var8.packetBuffer.method5643(UserComparator8.baseX * 64 + var0);
					var8.packetBuffer.method5634(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShortLE(var3);
					var8.packetBuffer.writeIntME(Clock.selectedSpellWidget);
					var8.packetBuffer.writeShort(Client.selectedSpellChildIndex);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 18) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2224, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5635(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShortLE(UserComparator8.baseX * 64 + var0);
					var8.packetBuffer.method5644(var3);
					var8.packetBuffer.writeShortLE(HealthBar.baseY * 64 + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 19) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2269, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5644(var3);
					var8.packetBuffer.method5644(UserComparator8.baseX * 64 + var0);
					var8.packetBuffer.writeShort(HealthBar.baseY * 64 + var1);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 20) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2244, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShort(var3);
					var8.packetBuffer.method5636(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShort(HealthBar.baseY * 64 + var1);
					var8.packetBuffer.method5643(UserComparator8.baseX * 64 + var0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 21) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2208, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5644(var3);
					var8.packetBuffer.method5644(UserComparator8.baseX * 64 + var0);
					var8.packetBuffer.method5644(HealthBar.baseY * 64 + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 22) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2200, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5644(UserComparator8.baseX * 64 + var0);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5643(HealthBar.baseY * 64 + var1);
					var8.packetBuffer.method5643(var3);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 23) {
					if (Client.isMenuOpen) {
						WorldMapArea.scene.setViewportWalking();
					} else {
						WorldMapArea.scene.menuOpen(Player.Client_plane, var0, var1, true);
					}
				} else {
					PacketBufferNode var11;
					Widget var16;
					if (var2 == 24) {
						var16 = PacketBufferNode.getWidget(var1);
						boolean var12 = true;
						if (var16.contentType > 0) {
							var12 = WorldMapIcon_0.method237(var16);
						}

						if (var12) {
							var11 = SoundSystem.getPacketBufferNode(ClientPacket.field2252, Client.packetWriter.isaacCipher);
							var11.packetBuffer.writeInt(var1);
							Client.packetWriter.addNode(var11);
						}
					} else {
						if (var2 == 25) {
							var16 = ArchiveLoader.getWidgetChild(var1, var0);
							if (var16 != null) {
								InterfaceParent.Widget_runOnTargetLeave();
								class51.selectSpell(var1, var0, UserComparator5.method3551(class195.getWidgetClickMask(var16)), var16.itemId);
								Client.isItemSelected = 0;
								Client.selectedSpellActionName = SoundCache.method2666(var16);
								if (Client.selectedSpellActionName == null) {
									Client.selectedSpellActionName = "null";
								}

								if (var16.isIf3) {
									Client.selectedSpellName = var16.dataText + AbstractArchive.colorStartTag(16777215);
								} else {
									Client.selectedSpellName = AbstractArchive.colorStartTag(65280) + var16.spellName + AbstractArchive.colorStartTag(16777215);
								}
							}

							return;
						}

						if (var2 == 26) {
							Skills.method4271();
						} else {
							int var10;
							Widget var14;
							if (var2 == 28) {
								var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2252, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = PacketBufferNode.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var10 = var14.cs1Instructions[0][1];
									Varps.Varps_main[var10] = 1 - Varps.Varps_main[var10];
									WorldMapDecoration.changeGameOptions(var10);
								}
							} else if (var2 == 29) {
								var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2252, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = PacketBufferNode.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var10 = var14.cs1Instructions[0][1];
									if (Varps.Varps_main[var10] != var14.cs1ComparisonValues[0]) {
										Varps.Varps_main[var10] = var14.cs1ComparisonValues[0];
										WorldMapDecoration.changeGameOptions(var10);
									}
								}
							} else if (var2 == 30) {
								if (Client.meslayerContinueWidget == null) {
									Tiles.resumePauseWidget(var1, var0);
									Client.meslayerContinueWidget = ArchiveLoader.getWidgetChild(var1, var0);
									GrandExchangeOfferAgeComparator.invalidateWidget(Client.meslayerContinueWidget);
								}
							} else if (var2 == 31) {
								var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2242, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5644(var3);
								var8.packetBuffer.writeShort(var0);
								var8.packetBuffer.method5643(MouseRecorder.selectedItemSlot);
								var8.packetBuffer.writeIntME(MidiPcmStream.selectedItemWidget);
								var8.packetBuffer.writeShortLE(Occluder.selectedItemId);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								Client.field753 = 0;
								Login.field1165 = PacketBufferNode.getWidget(var1);
								Client.field665 = var0;
							} else if (var2 == 32) {
								var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2241, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5653(Clock.selectedSpellWidget);
								var8.packetBuffer.writeShort(var3);
								var8.packetBuffer.writeInt(var1);
								var8.packetBuffer.method5643(var0);
								var8.packetBuffer.method5643(Client.selectedSpellChildIndex);
								Client.packetWriter.addNode(var8);
								Client.field753 = 0;
								Login.field1165 = PacketBufferNode.getWidget(var1);
								Client.field665 = var0;
							} else if (var2 == 33) {
								var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2260, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntME(var1);
								var8.packetBuffer.writeShortLE(var0);
								var8.packetBuffer.method5644(var3);
								Client.packetWriter.addNode(var8);
								Client.field753 = 0;
								Login.field1165 = PacketBufferNode.getWidget(var1);
								Client.field665 = var0;
							} else if (var2 == 34) {
								var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2237, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								var8.packetBuffer.writeShortLE(var3);
								var8.packetBuffer.method5644(var0);
								Client.packetWriter.addNode(var8);
								Client.field753 = 0;
								Login.field1165 = PacketBufferNode.getWidget(var1);
								Client.field665 = var0;
							} else if (var2 == 35) {
								var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2190, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeShort(var3);
								var8.packetBuffer.method5655(var1);
								var8.packetBuffer.method5644(var0);
								Client.packetWriter.addNode(var8);
								Client.field753 = 0;
								Login.field1165 = PacketBufferNode.getWidget(var1);
								Client.field665 = var0;
							} else if (var2 == 36) {
								var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2253, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntME(var1);
								var8.packetBuffer.method5643(var3);
								var8.packetBuffer.writeShort(var0);
								Client.packetWriter.addNode(var8);
								Client.field753 = 0;
								Login.field1165 = PacketBufferNode.getWidget(var1);
								Client.field665 = var0;
							} else if (var2 == 37) {
								var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2219, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntME(var1);
								var8.packetBuffer.method5643(var3);
								var8.packetBuffer.method5644(var0);
								Client.packetWriter.addNode(var8);
								Client.field753 = 0;
								Login.field1165 = PacketBufferNode.getWidget(var1);
								Client.field665 = var0;
							} else {
								if (var2 == 38) {
									InterfaceParent.Widget_runOnTargetLeave();
									var16 = PacketBufferNode.getWidget(var1);
									Client.isItemSelected = 1;
									MouseRecorder.selectedItemSlot = var0;
									MidiPcmStream.selectedItemWidget = var1;
									Occluder.selectedItemId = var3;
									GrandExchangeOfferAgeComparator.invalidateWidget(var16);
									Client.selectedItemName = AbstractArchive.colorStartTag(16748608) + class222.ItemDefinition_get(var3).name + AbstractArchive.colorStartTag(16777215);
									if (Client.selectedItemName == null) {
										Client.selectedItemName = "null";
									}

									return;
								}

								if (var2 == 39) {
									var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2196, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeShortLE(var3);
									var8.packetBuffer.writeShort(var0);
									var8.packetBuffer.method5655(var1);
									Client.packetWriter.addNode(var8);
									Client.field753 = 0;
									Login.field1165 = PacketBufferNode.getWidget(var1);
									Client.field665 = var0;
								} else if (var2 == 40) {
									var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2258, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeShort(var3);
									var8.packetBuffer.writeIntME(var1);
									var8.packetBuffer.writeShort(var0);
									Client.packetWriter.addNode(var8);
									Client.field753 = 0;
									Login.field1165 = PacketBufferNode.getWidget(var1);
									Client.field665 = var0;
								} else if (var2 == 41) {
									var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2194, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeShort(var0);
									var8.packetBuffer.method5655(var1);
									var8.packetBuffer.writeShortLE(var3);
									Client.packetWriter.addNode(var8);
									Client.field753 = 0;
									Login.field1165 = PacketBufferNode.getWidget(var1);
									Client.field665 = var0;
								} else if (var2 == 42) {
									var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2211, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5655(var1);
									var8.packetBuffer.writeShort(var0);
									var8.packetBuffer.writeShortLE(var3);
									Client.packetWriter.addNode(var8);
									Client.field753 = 0;
									Login.field1165 = PacketBufferNode.getWidget(var1);
									Client.field665 = var0;
								} else if (var2 == 43) {
									var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2215, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeShort(var3);
									var8.packetBuffer.writeIntME(var1);
									var8.packetBuffer.method5644(var0);
									Client.packetWriter.addNode(var8);
									Client.field753 = 0;
									Login.field1165 = PacketBufferNode.getWidget(var1);
									Client.field665 = var0;
								} else if (var2 == 44) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2193, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeShort(var3);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2234, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5636(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5643(var3);
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
										var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2225, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5634(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeShortLE(var3);
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
										var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2229, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeShortLE(var3);
										var9.packetBuffer.method5634(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
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
										var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2231, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5636(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5644(var3);
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
										var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2236, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5635(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeShort(var3);
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
										var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2251, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5643(var3);
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
										var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2235, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeShortLE(var3);
										var9.packetBuffer.method5635(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										Client.packetWriter.addNode(var9);
									}
								} else {
									label795: {
										if (var2 != 57) {
											if (var2 == 58) {
												var16 = ArchiveLoader.getWidgetChild(var1, var0);
												if (var16 != null) {
													var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2274, Client.packetWriter.isaacCipher);
													var9.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
													var9.packetBuffer.writeShortLE(var0);
													var9.packetBuffer.method5655(var1);
													var9.packetBuffer.writeShortLE(Client.field788);
													var9.packetBuffer.writeInt(Clock.selectedSpellWidget);
													var9.packetBuffer.method5643(var16.itemId);
													Client.packetWriter.addNode(var9);
												}
												break label795;
											}

											if (var2 == 1001) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												Client.destinationX = var0;
												Client.destinationY = var1;
												var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2214, Client.packetWriter.isaacCipher);
												var8.packetBuffer.method5635(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
												var8.packetBuffer.writeShortLE(HealthBar.baseY * 64 + var1);
												var8.packetBuffer.method5643(UserComparator8.baseX * 64 + var0);
												var8.packetBuffer.writeShortLE(var3);
												Client.packetWriter.addNode(var8);
												break label795;
											}

											if (var2 == 1002) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2222, Client.packetWriter.isaacCipher);
												var8.packetBuffer.method5643(var3);
												Client.packetWriter.addNode(var8);
												break label795;
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
														var11 = SoundSystem.getPacketBufferNode(ClientPacket.field2262, Client.packetWriter.isaacCipher);
														var11.packetBuffer.writeShort(var17.id);
														Client.packetWriter.addNode(var11);
													}
												}
												break label795;
											}

											if (var2 == 1004) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = SoundSystem.getPacketBufferNode(ClientPacket.field2198, Client.packetWriter.isaacCipher);
												var8.packetBuffer.method5643(var3);
												Client.packetWriter.addNode(var8);
												break label795;
											}

											if (var2 == 1005) {
												var16 = PacketBufferNode.getWidget(var1);
												if (var16 != null && var16.itemQuantities[var0] >= 100000) {
													class30.addGameMessage(27, "", var16.itemQuantities[var0] + " x " + class222.ItemDefinition_get(var3).name);
												} else {
													var9 = SoundSystem.getPacketBufferNode(ClientPacket.field2198, Client.packetWriter.isaacCipher);
													var9.packetBuffer.method5643(var3);
													Client.packetWriter.addNode(var9);
												}

												Client.field753 = 0;
												Login.field1165 = PacketBufferNode.getWidget(var1);
												Client.field665 = var0;
												break label795;
											}

											if (var2 != 1007) {
												if (var2 == 1011 || var2 == 1008 || var2 == 1010 || var2 == 1009 || var2 == 1012) {
													Login.worldMap.worldMapMenuAction(var2, var3, new Coord(var0), new Coord(var1));
												}
												break label795;
											}
										}

										var16 = ArchiveLoader.getWidgetChild(var1, var0);
										if (var16 != null) {
											class287.widgetDefaultMenuAction(var3, var1, var0, var16.itemId, var5);
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
			GrandExchangeOfferAgeComparator.invalidateWidget(PacketBufferNode.getWidget(MidiPcmStream.selectedItemWidget));
		}

		if (Client.isSpellSelected) {
			InterfaceParent.Widget_runOnTargetLeave();
		}

		if (Login.field1165 != null && Client.field753 == 0) {
			GrandExchangeOfferAgeComparator.invalidateWidget(Login.field1165);
		}

	}

	@ObfuscatedName("jn")
	@ObfuscatedSignature(
		signature = "(Lhi;IIIIIII)V",
		garbageValue = "-1682660629"
	)
	static final void method1389(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (Client.field698) {
			Client.alternativeScrollbarWidth = 32;
		} else {
			Client.alternativeScrollbarWidth = 0;
		}

		Client.field698 = false;
		int var7;
		if (MouseHandler.MouseHandler_currentButton == 1 || !WorldMapLabelSize.mouseCam && MouseHandler.MouseHandler_currentButton == 4) {
			if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
				var0.scrollY -= 4;
				GrandExchangeOfferAgeComparator.invalidateWidget(var0);
			} else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
				var0.scrollY += 4;
				GrandExchangeOfferAgeComparator.invalidateWidget(var0);
			} else if (var5 >= var1 - Client.alternativeScrollbarWidth && var5 < Client.alternativeScrollbarWidth + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
				var7 = var3 * (var3 - 32) / var4;
				if (var7 < 8) {
					var7 = 8;
				}

				int var8 = var6 - var2 - 16 - var7 / 2;
				int var9 = var3 - 32 - var7;
				var0.scrollY = var8 * (var4 - var3) / var9;
				GrandExchangeOfferAgeComparator.invalidateWidget(var0);
				Client.field698 = true;
			}
		}

		if (Client.mouseWheelRotation != 0) {
			var7 = var0.width;
			if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
				var0.scrollY += Client.mouseWheelRotation * 45;
				GrandExchangeOfferAgeComparator.invalidateWidget(var0);
			}
		}

	}

	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		signature = "(Lbq;ZI)V",
		garbageValue = "2014179335"
	)
	@Export("closeInterface")
	static final void closeInterface(InterfaceParent var0, boolean var1) {
		int var2 = var0.group;
		int var3 = (int)var0.key;
		var0.remove();
		if (var1) {
			PlayerAppearance.method4191(var2);
		}

		class197.method3844(var2);
		Widget var4 = PacketBufferNode.getWidget(var3);
		if (var4 != null) {
			GrandExchangeOfferAgeComparator.invalidateWidget(var4);
		}

		for (int var5 = 0; var5 < Client.menuOptionsCount; ++var5) {
			if (WorldMapIcon_1.method351(Client.menuOpcodes[var5])) {
				if (var5 < Client.menuOptionsCount - 1) {
					for (int var6 = var5; var6 < Client.menuOptionsCount - 1; ++var6) {
						Client.menuActions[var6] = Client.menuActions[var6 + 1];
						Client.menuTargets[var6] = Client.menuTargets[var6 + 1];
						Client.menuOpcodes[var6] = Client.menuOpcodes[var6 + 1];
						Client.menuIdentifiers[var6] = Client.menuIdentifiers[var6 + 1];
						Client.menuArguments1[var6] = Client.menuArguments1[var6 + 1];
						Client.menuArguments2[var6] = Client.menuArguments2[var6 + 1];
						Client.menuShiftClick[var6] = Client.menuShiftClick[var6 + 1];
					}
				}

				--var5;
				--Client.menuOptionsCount;
			}
		}

		class30.method603();
		if (Client.rootInterface != -1) {
			AttackOption.runIntfCloseListeners(Client.rootInterface, 1);
		}

	}
}
