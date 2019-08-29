import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
@Implements("TileItemPile")
public final class TileItemPile {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1479767219
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1786599841
	)
	@Export("x")
	int x;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 2004816783
	)
	@Export("y")
	int y;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Len;"
	)
	@Export("first")
	Entity first;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Len;"
	)
	@Export("second")
	Entity second;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Len;"
	)
	@Export("third")
	Entity third;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		longValue = 8397822487422638179L
	)
	@Export("tag")
	long tag;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 299840789
	)
	@Export("height")
	int height;

	TileItemPile() {
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "-1592164881"
	)
	static int method2701(int var0, Script var1, boolean var2) {
		if (var0 < 1000) {
			return FriendSystem.method1831(var0, var1, var2);
		} else if (var0 < 1100) {
			return UserComparator10.method3345(var0, var1, var2);
		} else if (var0 < 1200) {
			return Canvas.method806(var0, var1, var2);
		} else if (var0 < 1300) {
			return GrandExchangeOffer.method123(var0, var1, var2);
		} else if (var0 < 1400) {
			return SecureRandomFuture.method2060(var0, var1, var2);
		} else if (var0 < 1500) {
			return NPC.method1968(var0, var1, var2);
		} else if (var0 < 1600) {
			return Players.method2063(var0, var1, var2);
		} else if (var0 < 1700) {
			return class312.method5788(var0, var1, var2);
		} else if (var0 < 1800) {
			return GraphicsObject.method1939(var0, var1, var2);
		} else if (var0 < 1900) {
			return class40.method728(var0, var1, var2);
		} else if (var0 < 2000) {
			return GrandExchangeOfferWorldComparator.method79(var0, var1, var2);
		} else if (var0 < 2100) {
			return UserComparator10.method3345(var0, var1, var2);
		} else if (var0 < 2200) {
			return Canvas.method806(var0, var1, var2);
		} else if (var0 < 2300) {
			return GrandExchangeOffer.method123(var0, var1, var2);
		} else if (var0 < 2400) {
			return SecureRandomFuture.method2060(var0, var1, var2);
		} else if (var0 < 2500) {
			return NPC.method1968(var0, var1, var2);
		} else if (var0 < 2600) {
			return GameShell.method1003(var0, var1, var2);
		} else if (var0 < 2700) {
			return class268.method4893(var0, var1, var2);
		} else if (var0 < 2800) {
			return GrandExchangeEvents.method84(var0, var1, var2);
		} else if (var0 < 2900) {
			return WorldMapSectionType.method240(var0, var1, var2);
		} else if (var0 < 3000) {
			return GrandExchangeOfferWorldComparator.method79(var0, var1, var2);
		} else if (var0 < 3200) {
			return WorldMapRegion.method464(var0, var1, var2);
		} else if (var0 < 3300) {
			return WorldMapIcon_0.method206(var0, var1, var2);
		} else if (var0 < 3400) {
			return PendingSpawn.method1660(var0, var1, var2);
		} else if (var0 < 3500) {
			return class286.method5166(var0, var1, var2);
		} else if (var0 < 3700) {
			return class192.method3616(var0, var1, var2);
		} else if (var0 < 4000) {
			return Message.method1172(var0, var1, var2);
		} else if (var0 < 4100) {
			return GrandExchangeOfferUnitPriceComparator.method136(var0, var1, var2);
		} else if (var0 < 4200) {
			return Message.method1174(var0, var1, var2);
		} else if (var0 < 4300) {
			return MouseHandler.method1043(var0, var1, var2);
		} else if (var0 < 5100) {
			return GrandExchangeOfferNameComparator.method150(var0, var1, var2);
		} else if (var0 < 5400) {
			return Player.method1224(var0, var1, var2);
		} else if (var0 < 5600) {
			return Skills.method4031(var0, var1, var2);
		} else if (var0 < 5700) {
			return Entity.method3210(var0, var1, var2);
		} else if (var0 < 6300) {
			return class49.method811(var0, var1, var2);
		} else if (var0 < 6600) {
			return WallDecoration.method3243(var0, var1, var2);
		} else {
			return var0 < 6700 ? InterfaceParent.method1126(var0, var1, var2) : 2;
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-508815789"
	)
	public static void method2700() {
		ItemDefinition.ItemDefinition_cached.clear();
		ItemDefinition.ItemDefinition_cachedModels.clear();
		ItemDefinition.ItemDefinition_cachedSprites.clear();
	}

	@ObfuscatedName("kj")
	@ObfuscatedSignature(
		signature = "(Lhp;IIII)V",
		garbageValue = "912146837"
	)
	@Export("drawMinimap")
	static final void drawMinimap(Widget var0, int var1, int var2, int var3) {
		WorldMapSectionType.playPcmPlayers();
		SpriteMask var4 = var0.getSpriteMask(false);
		if (var4 != null) {
			Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height);
			if (Client.minimapState != 2 && Client.minimapState != 5) {
				int var5 = Client.camAngleY & 2047;
				int var6 = WorldMapIcon_1.localPlayer.x / 32 + 48;
				int var7 = 464 - WorldMapIcon_1.localPlayer.y / 32;
				ParamDefinition.sceneMinimapSprite.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths);

				int var8;
				int var9;
				int var10;
				for (var8 = 0; var8 < Client.mapIconCount; ++var8) {
					var9 = Client.mapIconXs[var8] * 4 + 2 - WorldMapIcon_1.localPlayer.x / 32;
					var10 = Client.mapIconYs[var8] * 4 + 2 - WorldMapIcon_1.localPlayer.y / 32;
					class191.drawSpriteOnMinimap(var1, var2, var9, var10, Client.mapIcons[var8], var4);
				}

				int var11;
				int var12;
				for (var8 = 0; var8 < 104; ++var8) {
					for (var9 = 0; var9 < 104; ++var9) {
						NodeDeque var15 = Client.groundItems[ItemContainer.plane][var8][var9];
						if (var15 != null) {
							var11 = var8 * 4 + 2 - WorldMapIcon_1.localPlayer.x / 32;
							var12 = var9 * 4 + 2 - WorldMapIcon_1.localPlayer.y / 32;
							class191.drawSpriteOnMinimap(var1, var2, var11, var12, WorldMapLabel.mapDotSprites[0], var4);
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
							var11 = var16.x / 32 - WorldMapIcon_1.localPlayer.x / 32;
							var12 = var16.y / 32 - WorldMapIcon_1.localPlayer.y / 32;
							class191.drawSpriteOnMinimap(var1, var2, var11, var12, WorldMapLabel.mapDotSprites[1], var4);
						}
					}
				}

				var8 = Players.Players_count;
				int[] var19 = Players.Players_indices;

				for (var10 = 0; var10 < var8; ++var10) {
					Player var17 = Client.players[var19[var10]];
					if (var17 != null && var17.isVisible() && !var17.isHidden && var17 != WorldMapIcon_1.localPlayer) {
						var12 = var17.x / 32 - WorldMapIcon_1.localPlayer.x / 32;
						int var13 = var17.y / 32 - WorldMapIcon_1.localPlayer.y / 32;
						boolean var14 = false;
						if (WorldMapIcon_1.localPlayer.team != 0 && var17.team != 0 && var17.team == WorldMapIcon_1.localPlayer.team) {
							var14 = true;
						}

						if (var17.isFriend()) {
							class191.drawSpriteOnMinimap(var1, var2, var12, var13, WorldMapLabel.mapDotSprites[3], var4);
						} else if (var14) {
							class191.drawSpriteOnMinimap(var1, var2, var12, var13, WorldMapLabel.mapDotSprites[4], var4);
						} else if (var17.isClanMember()) {
							class191.drawSpriteOnMinimap(var1, var2, var12, var13, WorldMapLabel.mapDotSprites[5], var4);
						} else {
							class191.drawSpriteOnMinimap(var1, var2, var12, var13, WorldMapLabel.mapDotSprites[2], var4);
						}
					}
				}

				if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
					if (Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
						NPC var20 = Client.npcs[Client.hintArrowNpcIndex];
						if (var20 != null) {
							var11 = var20.x / 32 - WorldMapIcon_1.localPlayer.x / 32;
							var12 = var20.y / 32 - WorldMapIcon_1.localPlayer.y / 32;
							GrandExchangeOfferNameComparator.worldToMinimap(var1, var2, var11, var12, WorldMapSection1.mapMarkerSprites[1], var4);
						}
					}

					if (Client.hintArrowType == 2) {
						var10 = Client.hintArrowX * 4 - PacketWriter.baseX * 256 + 2 - WorldMapIcon_1.localPlayer.x / 32;
						var11 = Client.hintArrowY * 4 - RouteStrategy.baseY * 256 + 2 - WorldMapIcon_1.localPlayer.y / 32;
						GrandExchangeOfferNameComparator.worldToMinimap(var1, var2, var10, var11, WorldMapSection1.mapMarkerSprites[1], var4);
					}

					if (Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) {
						Player var21 = Client.players[Client.hintArrowPlayerIndex];
						if (var21 != null) {
							var11 = var21.x / 32 - WorldMapIcon_1.localPlayer.x / 32;
							var12 = var21.y / 32 - WorldMapIcon_1.localPlayer.y / 32;
							GrandExchangeOfferNameComparator.worldToMinimap(var1, var2, var11, var12, WorldMapSection1.mapMarkerSprites[1], var4);
						}
					}
				}

				if (Client.destinationX != 0) {
					var10 = Client.destinationX * 4 + 2 - WorldMapIcon_1.localPlayer.x / 32;
					var11 = Client.destinationY * 4 + 2 - WorldMapIcon_1.localPlayer.y / 32;
					class191.drawSpriteOnMinimap(var1, var2, var10, var11, WorldMapSection1.mapMarkerSprites[0], var4);
				}

				if (!WorldMapIcon_1.localPlayer.isHidden) {
					Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
				}
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

			Client.field829[var3] = true;
		}
	}
}
