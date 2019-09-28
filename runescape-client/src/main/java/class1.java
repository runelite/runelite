import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
final class class1 implements class0 {
	@ObfuscatedName("dr")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive0")
	static Archive archive0;

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkl;B)V",
		garbageValue = "0"
	)
	public void vmethod64(Object var1, Buffer var2) {
		this.method13((Integer)var1, var2);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;B)Ljava/lang/Object;",
		garbageValue = "-93"
	)
	public Object vmethod55(Buffer var1) {
		return var1.readInt();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Integer;Lkl;I)V",
		garbageValue = "-1770008879"
	)
	void method13(Integer var1, Buffer var2) {
		var2.writeInt(var1);
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(ZZI)I",
		garbageValue = "1419553069"
	)
	public static int method5(boolean var0, boolean var1) {
		byte var2 = 0;
		int var3 = var2 + NetCache.NetCache_pendingPriorityWritesCount + NetCache.NetCache_pendingPriorityResponsesCount;
		return var3;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "16"
	)
	public static void method16(boolean var0) {
		if (var0 != class162.ItemDefinition_inMembersWorld) {
			InterfaceParent.method1193();
			class162.ItemDefinition_inMembersWorld = var0;
		}

	}

	@ObfuscatedName("hh")
	@ObfuscatedSignature(
		signature = "(IIIIIIII)V",
		garbageValue = "557524614"
	)
	@Export("addPendingSpawnToScene")
	static final void addPendingSpawnToScene(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
			if (Client.isLowDetail && var0 != WorldMapRectangle.plane) {
				return;
			}

			long var7 = 0L;
			boolean var9 = true;
			boolean var10 = false;
			boolean var11 = false;
			if (var1 == 0) {
				var7 = PacketWriter.scene.getBoundaryObjectTag(var0, var2, var3);
			}

			if (var1 == 1) {
				var7 = PacketWriter.scene.getWallDecorationTag(var0, var2, var3);
			}

			if (var1 == 2) {
				var7 = PacketWriter.scene.getGameObjectTag(var0, var2, var3);
			}

			if (var1 == 3) {
				var7 = PacketWriter.scene.getFloorDecorationTag(var0, var2, var3);
			}

			int var12;
			if (0L != var7) {
				var12 = PacketWriter.scene.getObjectFlags(var0, var2, var3, var7);
				int var14 = class81.Entity_unpackID(var7);
				int var15 = var12 & 31;
				int var16 = var12 >> 6 & 3;
				ObjectDefinition var13;
				if (var1 == 0) {
					PacketWriter.scene.removeBoundaryObject(var0, var2, var3);
					var13 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var14);
					if (var13.interactType != 0) {
						Client.collisionMaps[var0].method3514(var2, var3, var15, var16, var13.boolean1);
					}
				}

				if (var1 == 1) {
					PacketWriter.scene.removeWallDecoration(var0, var2, var3);
				}

				if (var1 == 2) {
					PacketWriter.scene.removeGameObject(var0, var2, var3);
					var13 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var14);
					if (var2 + var13.sizeX > 103 || var3 + var13.sizeX > 103 || var2 + var13.sizeY > 103 || var3 + var13.sizeY > 103) {
						return;
					}

					if (var13.interactType != 0) {
						Client.collisionMaps[var0].setFlagOffNonSquare(var2, var3, var13.sizeX, var13.sizeY, var16, var13.boolean1);
					}
				}

				if (var1 == 3) {
					PacketWriter.scene.removeFloorDecoration(var0, var2, var3);
					var13 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var14);
					if (var13.interactType == 1) {
						Client.collisionMaps[var0].method3517(var2, var3);
					}
				}
			}

			if (var4 >= 0) {
				var12 = var0;
				if (var0 < 3 && (Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var12 = var0 + 1;
				}

				class3.method50(var0, var12, var2, var3, var4, var5, var6, PacketWriter.scene, Client.collisionMaps[var0]);
			}
		}

	}

	@ObfuscatedName("hl")
	@ObfuscatedSignature(
		signature = "(Lbi;IIBI)V",
		garbageValue = "916902326"
	)
	static final void method14(Player var0, int var1, int var2, byte var3) {
		int var4 = var0.pathX[0];
		int var5 = var0.pathY[0];
		int var6 = var0.transformedSize();
		if (var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
			if (var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
				int var9 = var0.transformedSize();
				Client.field909.approxDestinationX = var1;
				Client.field909.approxDestinationY = var2;
				Client.field909.approxDestinationSizeX = 1;
				Client.field909.approxDestinationSizeY = 1;
				class65 var10 = Client.field909;
				int var11 = class192.method3646(var4, var5, var9, var10, Client.collisionMaps[var0.plane], true, Client.field910, Client.field911);
				if (var11 >= 1) {
					for (int var12 = 0; var12 < var11 - 1; ++var12) {
						var0.method1263(Client.field910[var12], Client.field911[var12], var3);
					}

				}
			}
		}
	}

	@ObfuscatedName("kt")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "2"
	)
	static void method15() {
		if (Client.field879 && class223.localPlayer != null) {
			int var0 = class223.localPlayer.pathX[0];
			int var1 = class223.localPlayer.pathY[0];
			if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
				return;
			}

			ObjectSound.oculusOrbFocalPointX = class223.localPlayer.x;
			int var2 = MusicPatchPcmStream.getTileHeight(class223.localPlayer.x, class223.localPlayer.y, WorldMapRectangle.plane) - Client.camFollowHeight;
			if (var2 < ModelData0.field1840) {
				ModelData0.field1840 = var2;
			}

			class14.oculusOrbFocalPointY = class223.localPlayer.y;
			Client.field879 = false;
		}

	}
}
