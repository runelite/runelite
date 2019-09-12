import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
final class class1 implements class0 {
	@ObfuscatedName("h")
	@Export("Tiles_lightness")
	static int[] Tiles_lightness;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkz;B)V",
		garbageValue = "1"
	)
	public void vmethod42(Object var1, Buffer var2) {
		this.method6((Integer)var1, var2);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkz;S)Ljava/lang/Object;",
		garbageValue = "31810"
	)
	public Object vmethod41(Buffer var1) {
		return var1.readInt();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Integer;Lkz;I)V",
		garbageValue = "-1255666144"
	)
	void method6(Integer var1, Buffer var2) {
		var2.writeInt(var1);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "113"
	)
	static final void method9() {
		WorldMapSection2.method283("You can't add yourself to your own friend list");
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "517519928"
	)
	static int method17(int var0) {
		return (int)Math.pow(2.0D, (double)(7.0F + (float)var0 / 256.0F));
	}

	@ObfuscatedName("eg")
	@ObfuscatedSignature(
		signature = "(I)Lln;",
		garbageValue = "524880852"
	)
	@Export("getWorldMap")
	static WorldMap getWorldMap() {
		return GrandExchangeOfferUnitPriceComparator.worldMap;
	}

	@ObfuscatedName("fy")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1873727163"
	)
	static final void method14() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			Player var3 = Client.players[var1[var2]];
			if (var3 != null) {
				Tile.calculateActorPosition(var3, 1);
			}
		}

	}

	@ObfuscatedName("hc")
	@ObfuscatedSignature(
		signature = "(ZLkt;S)V",
		garbageValue = "399"
	)
	static final void method15(boolean var0, PacketBuffer var1) {
		while (true) {
			if (var1.bitsRemaining(Client.packetWriter.serverPacketLength) >= 27) {
				int var2 = var1.readBits(15);
				if (var2 != 32767) {
					boolean var3 = false;
					if (Client.npcs[var2] == null) {
						Client.npcs[var2] = new NPC();
						var3 = true;
					}

					NPC var4 = Client.npcs[var2];
					Client.npcIndices[++Client.npcCount - 1] = var2;
					var4.npcCycle = Client.cycle;
					int var5;
					if (var0) {
						var5 = var1.readBits(8);
						if (var5 > 127) {
							var5 -= 256;
						}
					} else {
						var5 = var1.readBits(5);
						if (var5 > 15) {
							var5 -= 32;
						}
					}

					int var6 = var1.readBits(1);
					int var7 = Client.defaultRotations[var1.readBits(3)];
					if (var3) {
						var4.orientation = var4.rotation = var7;
					}

					int var8 = var1.readBits(1);
					if (var8 == 1) {
						Client.field881[++Client.field666 - 1] = var2;
					}

					int var9;
					if (var0) {
						var9 = var1.readBits(8);
						if (var9 > 127) {
							var9 -= 256;
						}
					} else {
						var9 = var1.readBits(5);
						if (var9 > 15) {
							var9 -= 32;
						}
					}

					var4.definition = FontName.getNpcDefinition(var1.readBits(14));
					var4.size = var4.definition.size;
					var4.field953 = var4.definition.rotation;
					if (var4.field953 == 0) {
						var4.rotation = 0;
					}

					var4.walkSequence = var4.definition.walkSequence;
					var4.walkBackSequence = var4.definition.walkBackSequence;
					var4.walkLeftSequence = var4.definition.walkLeftSequence;
					var4.walkRightSequence = var4.definition.walkRightSequence;
					var4.readySequence = var4.definition.readySequence;
					var4.turnLeftSequence = var4.definition.turnLeftSequence;
					var4.turnRightSequence = var4.definition.turnRightSequence;
					var4.method2011(Varps.localPlayer.pathX[0] + var9, Varps.localPlayer.pathY[0] + var5, var6 == 1);
					continue;
				}
			}

			var1.exportIndex();
			return;
		}
	}

	@ObfuscatedName("iv")
	@ObfuscatedSignature(
		signature = "(Lhy;IIIIIIB)V",
		garbageValue = "-40"
	)
	static final void method16(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (Client.field712) {
			Client.alternativeScrollbarWidth = 32;
		} else {
			Client.alternativeScrollbarWidth = 0;
		}

		Client.field712 = false;
		int var7;
		if (MouseHandler.MouseHandler_currentButton == 1 || !WorldMapSection1.mouseCam && MouseHandler.MouseHandler_currentButton == 4) {
			if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
				var0.scrollY -= 4;
				WorldMapID.invalidateWidget(var0);
			} else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
				var0.scrollY += 4;
				WorldMapID.invalidateWidget(var0);
			} else if (var5 >= var1 - Client.alternativeScrollbarWidth && var5 < Client.alternativeScrollbarWidth + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
				var7 = var3 * (var3 - 32) / var4;
				if (var7 < 8) {
					var7 = 8;
				}

				int var8 = var6 - var2 - 16 - var7 / 2;
				int var9 = var3 - 32 - var7;
				var0.scrollY = var8 * (var4 - var3) / var9;
				WorldMapID.invalidateWidget(var0);
				Client.field712 = true;
			}
		}

		if (Client.mouseWheelRotation != 0) {
			var7 = var0.width;
			if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
				var0.scrollY += Client.mouseWheelRotation * 45;
				WorldMapID.invalidateWidget(var0);
			}
		}

	}
}
