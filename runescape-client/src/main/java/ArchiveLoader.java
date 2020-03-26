import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("ArchiveLoader")
public class ArchiveLoader {
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lih;"
	)
	@Export("archive")
	final Archive archive;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 216071601
	)
	@Export("groupCount")
	final int groupCount;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -189862787
	)
	@Export("loadedCount")
	int loadedCount;

	@ObfuscatedSignature(
		signature = "(Lih;Ljava/lang/String;)V"
	)
	ArchiveLoader(Archive var1, String var2) {
		this.loadedCount = 0;
		this.archive = var1;
		this.groupCount = var1.getGroupCount();
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "92028555"
	)
	@Export("isLoaded")
	boolean isLoaded() {
		this.loadedCount = 0;

		for (int var1 = 0; var1 < this.groupCount; ++var1) {
			if (!this.archive.method4353(var1) || this.archive.method4352(var1)) {
				++this.loadedCount;
			}
		}

		return this.loadedCount >= this.groupCount;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "527367819"
	)
	@Export("isCharPrintable")
	public static boolean isCharPrintable(char var0) {
		if (var0 >= ' ' && var0 <= '~') {
			return true;
		} else if (var0 >= 160 && var0 <= 255) {
			return true;
		} else {
			return var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "-66"
	)
	public static void method1254(boolean var0) {
		if (var0 != class169.ItemDefinition_inMembersWorld) {
			class257.method4558();
			class169.ItemDefinition_inMembersWorld = var0;
		}

	}

	@ObfuscatedName("km")
	@ObfuscatedSignature(
		signature = "(Lhe;IIII)V",
		garbageValue = "510029442"
	)
	@Export("drawMinimap")
	static final void drawMinimap(Widget var0, int var1, int var2, int var3) {
		ChatChannel.playPcmPlayers();
		SpriteMask var4 = var0.getSpriteMask(false);
		if (var4 != null) {
			Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height);
			if (Client.minimapState != 2 && Client.minimapState != 5) {
				int var5 = Client.camAngleY & 2047;
				int var6 = ByteArrayPool.localPlayer.x / 32 + 48;
				int var7 = 464 - ByteArrayPool.localPlayer.y / 32;
				ArchiveDisk.sceneMinimapSprite.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths);

				int var8;
				int var9;
				int var10;
				for (var8 = 0; var8 < Client.mapIconCount; ++var8) {
					var9 = Client.mapIconXs[var8] * 4 + 2 - ByteArrayPool.localPlayer.x / 32;
					var10 = Client.mapIconYs[var8] * 4 + 2 - ByteArrayPool.localPlayer.y / 32;
					ScriptEvent.drawSpriteOnMinimap(var1, var2, var9, var10, Client.mapIcons[var8], var4);
				}

				int var11;
				int var12;
				for (var8 = 0; var8 < 104; ++var8) {
					for (var9 = 0; var9 < 104; ++var9) {
						NodeDeque var15 = Client.groundItems[ScriptEvent.Client_plane][var8][var9];
						if (var15 != null) {
							var11 = var8 * 4 + 2 - ByteArrayPool.localPlayer.x / 32;
							var12 = var9 * 4 + 2 - ByteArrayPool.localPlayer.y / 32;
							ScriptEvent.drawSpriteOnMinimap(var1, var2, var11, var12, VarpDefinition.mapDotSprites[0], var4);
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
							var11 = var16.x / 32 - ByteArrayPool.localPlayer.x / 32;
							var12 = var16.y / 32 - ByteArrayPool.localPlayer.y / 32;
							ScriptEvent.drawSpriteOnMinimap(var1, var2, var11, var12, VarpDefinition.mapDotSprites[1], var4);
						}
					}
				}

				var8 = Players.Players_count;
				int[] var19 = Players.Players_indices;

				for (var10 = 0; var10 < var8; ++var10) {
					Player var17 = Client.players[var19[var10]];
					if (var17 != null && var17.isVisible() && !var17.isHidden && var17 != ByteArrayPool.localPlayer) {
						var12 = var17.x / 32 - ByteArrayPool.localPlayer.x / 32;
						int var13 = var17.y / 32 - ByteArrayPool.localPlayer.y / 32;
						boolean var14 = false;
						if (ByteArrayPool.localPlayer.team != 0 && var17.team != 0 && var17.team == ByteArrayPool.localPlayer.team) {
							var14 = true;
						}

						if (var17.isFriend()) {
							ScriptEvent.drawSpriteOnMinimap(var1, var2, var12, var13, VarpDefinition.mapDotSprites[3], var4);
						} else if (var14) {
							ScriptEvent.drawSpriteOnMinimap(var1, var2, var12, var13, VarpDefinition.mapDotSprites[4], var4);
						} else if (var17.isClanMember()) {
							ScriptEvent.drawSpriteOnMinimap(var1, var2, var12, var13, VarpDefinition.mapDotSprites[5], var4);
						} else {
							ScriptEvent.drawSpriteOnMinimap(var1, var2, var12, var13, VarpDefinition.mapDotSprites[2], var4);
						}
					}
				}

				if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
					if (Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
						NPC var20 = Client.npcs[Client.hintArrowNpcIndex];
						if (var20 != null) {
							var11 = var20.x / 32 - ByteArrayPool.localPlayer.x / 32;
							var12 = var20.y / 32 - ByteArrayPool.localPlayer.y / 32;
							class1.worldToMinimap(var1, var2, var11, var12, WorldMapAreaData.mapMarkerSprites[1], var4);
						}
					}

					if (Client.hintArrowType == 2) {
						var10 = Client.hintArrowX * 4 - class69.baseX * 4 + 2 - ByteArrayPool.localPlayer.x / 32;
						var11 = Client.hintArrowY * 4 - class89.baseY * 4 + 2 - ByteArrayPool.localPlayer.y / 32;
						class1.worldToMinimap(var1, var2, var10, var11, WorldMapAreaData.mapMarkerSprites[1], var4);
					}

					if (Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) {
						Player var21 = Client.players[Client.hintArrowPlayerIndex];
						if (var21 != null) {
							var11 = var21.x / 32 - ByteArrayPool.localPlayer.x / 32;
							var12 = var21.y / 32 - ByteArrayPool.localPlayer.y / 32;
							class1.worldToMinimap(var1, var2, var11, var12, WorldMapAreaData.mapMarkerSprites[1], var4);
						}
					}
				}

				if (Client.destinationX != 0) {
					var10 = Client.destinationX * 4 + 2 - ByteArrayPool.localPlayer.x / 32;
					var11 = Client.destinationY * 4 + 2 - ByteArrayPool.localPlayer.y / 32;
					ScriptEvent.drawSpriteOnMinimap(var1, var2, var10, var11, WorldMapAreaData.mapMarkerSprites[0], var4);
				}

				if (!ByteArrayPool.localPlayer.isHidden) {
					Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
				}
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

			Client.field886[var3] = true;
		}
	}
}
