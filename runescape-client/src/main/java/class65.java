import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class65 extends RouteStrategy {
	@ObfuscatedName("rl")
	@ObfuscatedGetter(
		intValue = 502905585
	)
	static int field581;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("ItemDefinition_archive")
	static AbstractArchive ItemDefinition_archive;
	@ObfuscatedName("ht")
	static int field580;

	class65() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIILfj;I)Z",
		garbageValue = "2030512647"
	)
	@Export("hasArrived")
	protected boolean hasArrived(int var1, int var2, int var3, CollisionMap var4) {
		return var2 == super.approxDestinationX && var3 == super.approxDestinationY;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Llj;III)I",
		garbageValue = "1086795116"
	)
	static int method1177(IterableNodeHashTable var0, int var1, int var2) {
		if (var0 == null) {
			return var2;
		} else {
			IntegerNode var3 = (IntegerNode)var0.get((long)var1);
			return var3 == null ? var2 : var3.integer;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIIII)I",
		garbageValue = "1745774438"
	)
	static final int method1171(int var0, int var1, int var2, int var3) {
		int var4 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var2 * 1024 / var3] >> 1;
		return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
	}

	@ObfuscatedName("je")
	@ObfuscatedSignature(
		signature = "(Lhy;IIIB)V",
		garbageValue = "85"
	)
	@Export("drawMinimap")
	static final void drawMinimap(Widget var0, int var1, int var2, int var3) {
		ModelData0.playPcmPlayers();
		SpriteMask var4 = var0.getSpriteMask(false);
		if (var4 != null) {
			Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height);
			if (Client.minimapState != 2 && Client.minimapState != 5) {
				int var5 = Client.camAngleY & 2047;
				int var6 = Varps.localPlayer.x * -78439701 / 32 + 48;
				int var7 = 464 - Varps.localPlayer.y / 32;
				class60.sceneMinimapSprite.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths);

				int var8;
				int var9;
				int var10;
				for (var8 = 0; var8 < Client.mapIconCount; ++var8) {
					var9 = Client.mapIconXs[var8] * 4 + 2 - Varps.localPlayer.x * -78439701 / 32;
					var10 = Client.mapIconYs[var8] * 4 + 2 - Varps.localPlayer.y / 32;
					ChatChannel.drawSpriteOnMinimap(var1, var2, var9, var10, Client.mapIcons[var8], var4);
				}

				int var11;
				int var12;
				for (var8 = 0; var8 < 104; ++var8) {
					for (var9 = 0; var9 < 104; ++var9) {
						NodeDeque var15 = Client.groundItems[MouseRecorder.plane][var8][var9];
						if (var15 != null) {
							var11 = var8 * 4 + 2 - Varps.localPlayer.x * -78439701 / 32;
							var12 = var9 * 4 + 2 - Varps.localPlayer.y / 32;
							ChatChannel.drawSpriteOnMinimap(var1, var2, var11, var12, class42.mapDotSprites[0], var4);
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
							var11 = var16.x * -78439701 / 32 - Varps.localPlayer.x * -78439701 / 32;
							var12 = var16.y / 32 - Varps.localPlayer.y / 32;
							ChatChannel.drawSpriteOnMinimap(var1, var2, var11, var12, class42.mapDotSprites[1], var4);
						}
					}
				}

				var8 = Players.Players_count;
				int[] var19 = Players.Players_indices;

				for (var10 = 0; var10 < var8; ++var10) {
					Player var17 = Client.players[var19[var10]];
					if (var17 != null && var17.isVisible() && !var17.isHidden && var17 != Varps.localPlayer) {
						var12 = var17.x * -78439701 / 32 - Varps.localPlayer.x * -78439701 / 32;
						int var13 = var17.y / 32 - Varps.localPlayer.y / 32;
						boolean var14 = false;
						if (Varps.localPlayer.team != 0 && var17.team != 0 && var17.team == Varps.localPlayer.team) {
							var14 = true;
						}

						if (var17.isFriend()) {
							ChatChannel.drawSpriteOnMinimap(var1, var2, var12, var13, class42.mapDotSprites[3], var4);
						} else if (var14) {
							ChatChannel.drawSpriteOnMinimap(var1, var2, var12, var13, class42.mapDotSprites[4], var4);
						} else if (var17.isClanMember()) {
							ChatChannel.drawSpriteOnMinimap(var1, var2, var12, var13, class42.mapDotSprites[5], var4);
						} else {
							ChatChannel.drawSpriteOnMinimap(var1, var2, var12, var13, class42.mapDotSprites[2], var4);
						}
					}
				}

				if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
					if (Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
						NPC var20 = Client.npcs[Client.hintArrowNpcIndex];
						if (var20 != null) {
							var11 = var20.x * -78439701 / 32 - Varps.localPlayer.x * -78439701 / 32;
							var12 = var20.y / 32 - Varps.localPlayer.y / 32;
							AttackOption.worldToMinimap(var1, var2, var11, var12, WorldMapLabelSize.mapMarkerSprites[1], var4);
						}
					}

					if (Client.hintArrowType == 2) {
						var10 = Client.hintArrowX * 4 - class4.baseX * 256 + 2 - Varps.localPlayer.x * -78439701 / 32;
						var11 = Client.hintArrowY * 4 - ScriptEvent.baseY * 2082609860 + 2 - Varps.localPlayer.y / 32;
						AttackOption.worldToMinimap(var1, var2, var10, var11, WorldMapLabelSize.mapMarkerSprites[1], var4);
					}

					if (Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) {
						Player var21 = Client.players[Client.hintArrowPlayerIndex];
						if (var21 != null) {
							var11 = var21.x * -78439701 / 32 - Varps.localPlayer.x * -78439701 / 32;
							var12 = var21.y / 32 - Varps.localPlayer.y / 32;
							AttackOption.worldToMinimap(var1, var2, var11, var12, WorldMapLabelSize.mapMarkerSprites[1], var4);
						}
					}
				}

				if (Client.destinationX != 0) {
					var10 = Client.destinationX * 4 + 2 - Varps.localPlayer.x * -78439701 / 32;
					var11 = Client.destinationY * 4 + 2 - Varps.localPlayer.y / 32;
					ChatChannel.drawSpriteOnMinimap(var1, var2, var10, var11, WorldMapLabelSize.mapMarkerSprites[0], var4);
				}

				if (!Varps.localPlayer.isHidden) {
					Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
				}
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

			Client.field828[var3] = true;
		}
	}

	@ObfuscatedName("kg")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "96843493"
	)
	static final void method1176() {
		Client.field816 = Client.cycleCntr;
		InterfaceParent.ClanChat_inClanChat = true;
	}
}
