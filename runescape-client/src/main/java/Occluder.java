import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("Occluder")
public final class Occluder {
	@ObfuscatedName("ix")
	@ObfuscatedGetter(
		intValue = 1520705785
	)
	@Export("selectedItemWidget")
	static int selectedItemWidget;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -2004521327
	)
	@Export("minTileX")
	int minTileX;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1674295637
	)
	@Export("maxTileX")
	int maxTileX;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1042040177
	)
	@Export("minTileY")
	int minTileY;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1841371547
	)
	@Export("maxTileY")
	int maxTileY;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 261600229
	)
	@Export("type")
	int type;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -471906197
	)
	@Export("minX")
	int minX;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1905687081
	)
	@Export("maxX")
	int maxX;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -528006911
	)
	@Export("minZ")
	int minZ;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1092367399
	)
	@Export("maxZ")
	int maxZ;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1309728231
	)
	@Export("minY")
	int minY;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1242772351
	)
	@Export("maxY")
	int maxY;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 574320151
	)
	int field1877;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1784945639
	)
	int field1878;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -894832855
	)
	int field1879;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -350981301
	)
	int field1880;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -186008605
	)
	int field1881;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 512854933
	)
	int field1875;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -503970767
	)
	int field1872;

	Occluder() {
	}

	@ObfuscatedName("ka")
	@ObfuscatedSignature(
		signature = "(Lha;IIIB)V",
		garbageValue = "1"
	)
	@Export("drawMinimap")
	static final void drawMinimap(Widget var0, int var1, int var2, int var3) {
		WorldMapLabel.playPcmPlayers();
		SpriteMask var4 = var0.getSpriteMask(false);
		if (var4 != null) {
			Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height);
			if (Client.minimapState != 2 && Client.minimapState != 5) {
				int var5 = Client.camAngleY & 2047;
				int var6 = Message.localPlayer.x / 32 + 48;
				int var7 = 464 - Message.localPlayer.y / 32;
				Language.sceneMinimapSprite.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths);

				int var8;
				int var9;
				int var10;
				for (var8 = 0; var8 < Client.mapIconCount; ++var8) {
					var9 = Client.mapIconXs[var8] * 4 + 2 - Message.localPlayer.x / 32;
					var10 = Client.mapIconYs[var8] * 4 + 2 - Message.localPlayer.y / 32;
					GrandExchangeOfferNameComparator.drawSpriteOnMinimap(var1, var2, var9, var10, Client.mapIcons[var8], var4);
				}

				int var11;
				int var12;
				for (var8 = 0; var8 < 104; ++var8) {
					for (var9 = 0; var9 < 104; ++var9) {
						NodeDeque var15 = Client.groundItems[UrlRequest.Client_plane][var8][var9];
						if (var15 != null) {
							var11 = var8 * 4 + 2 - Message.localPlayer.x / 32;
							var12 = var9 * 4 + 2 - Message.localPlayer.y / 32;
							GrandExchangeOfferNameComparator.drawSpriteOnMinimap(var1, var2, var11, var12, WorldMapLabel.mapDotSprites[0], var4);
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
							var11 = var16.x / 32 - Message.localPlayer.x / 32;
							var12 = var16.y / 32 - Message.localPlayer.y / 32;
							GrandExchangeOfferNameComparator.drawSpriteOnMinimap(var1, var2, var11, var12, WorldMapLabel.mapDotSprites[1], var4);
						}
					}
				}

				var8 = Players.Players_count;
				int[] var19 = Players.Players_indices;

				for (var10 = 0; var10 < var8; ++var10) {
					Player var17 = Client.players[var19[var10]];
					if (var17 != null && var17.isVisible() && !var17.isHidden && var17 != Message.localPlayer) {
						var12 = var17.x / 32 - Message.localPlayer.x / 32;
						int var13 = var17.y / 32 - Message.localPlayer.y / 32;
						boolean var14 = false;
						if (Message.localPlayer.team != 0 && var17.team != 0 && var17.team == Message.localPlayer.team) {
							var14 = true;
						}

						if (var17.isFriend()) {
							GrandExchangeOfferNameComparator.drawSpriteOnMinimap(var1, var2, var12, var13, WorldMapLabel.mapDotSprites[3], var4);
						} else if (var14) {
							GrandExchangeOfferNameComparator.drawSpriteOnMinimap(var1, var2, var12, var13, WorldMapLabel.mapDotSprites[4], var4);
						} else if (var17.isClanMember()) {
							GrandExchangeOfferNameComparator.drawSpriteOnMinimap(var1, var2, var12, var13, WorldMapLabel.mapDotSprites[5], var4);
						} else {
							GrandExchangeOfferNameComparator.drawSpriteOnMinimap(var1, var2, var12, var13, WorldMapLabel.mapDotSprites[2], var4);
						}
					}
				}

				if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
					if (Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
						NPC var20 = Client.npcs[Client.hintArrowNpcIndex];
						if (var20 != null) {
							var11 = var20.x / 32 - Message.localPlayer.x / 32;
							var12 = var20.y / 32 - Message.localPlayer.y / 32;
							InvDefinition.worldToMinimap(var1, var2, var11, var12, Varps.mapMarkerSprites[1], var4);
						}
					}

					if (Client.hintArrowType == 2) {
						var10 = Client.hintArrowX * 4 - MusicPatchPcmStream.baseX * 256 + 2 - Message.localPlayer.x / 32;
						var11 = Client.hintArrowY * 4 - ScriptEvent.baseY * 256 + 2 - Message.localPlayer.y / 32;
						InvDefinition.worldToMinimap(var1, var2, var10, var11, Varps.mapMarkerSprites[1], var4);
					}

					if (Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) {
						Player var21 = Client.players[Client.hintArrowPlayerIndex];
						if (var21 != null) {
							var11 = var21.x / 32 - Message.localPlayer.x / 32;
							var12 = var21.y / 32 - Message.localPlayer.y / 32;
							InvDefinition.worldToMinimap(var1, var2, var11, var12, Varps.mapMarkerSprites[1], var4);
						}
					}
				}

				if (Client.destinationX != 0) {
					var10 = Client.destinationX * 4 + 2 - Message.localPlayer.x / 32;
					var11 = Client.destinationY * 4 + 2 - Message.localPlayer.y / 32;
					GrandExchangeOfferNameComparator.drawSpriteOnMinimap(var1, var2, var10, var11, Varps.mapMarkerSprites[0], var4);
				}

				if (!Message.localPlayer.isHidden) {
					Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
				}
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

			Client.field834[var3] = true;
		}
	}
}
