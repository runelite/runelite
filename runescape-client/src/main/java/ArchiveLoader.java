import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bn")
@Implements("ArchiveLoader")
public class ArchiveLoader {
	@ObfuscatedName("rz")
	@ObfuscatedSignature(
		signature = "Lbf;"
	)
	@Export("friendSystem")
	public static FriendSystem friendSystem;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive")
	final Archive archive;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -637612403
	)
	@Export("groupCount")
	final int groupCount;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1413706037
	)
	@Export("loadedCount")
	int loadedCount;

	@ObfuscatedSignature(
		signature = "(Liu;Ljava/lang/String;)V"
	)
	ArchiveLoader(Archive var1, String var2) {
		this.loadedCount = 0;
		this.archive = var1;
		this.groupCount = var1.getGroupCount();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-30"
	)
	@Export("isLoaded")
	boolean isLoaded() {
		this.loadedCount = 0;

		for (int var1 = 0; var1 < this.groupCount; ++var1) {
			if (!this.archive.method4268(var1) || this.archive.method4267(var1)) {
				++this.loadedCount;
			}
		}

		return this.loadedCount >= this.groupCount;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;Lhp;Lga;B)Z",
		garbageValue = "14"
	)
	@Export("setAudioArchives")
	public static boolean setAudioArchives(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, MidiPcmStream var3) {
		class197.musicPatchesArchive = var0;
		class197.musicSamplesArchive = var1;
		class197.soundEffectsArchive = var2;
		Interpreter.midiPcmStream = var3;
		return true;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(ILcx;ZB)I",
		garbageValue = "65"
	)
	static int method1100(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = class80.getWidget(Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? Interpreter.field1111 : Calendar.field2507;
		}

		if (var0 == ScriptOpcodes.CC_CALLONRESIZE) {
			if (Interpreter.field1106 >= 10) {
				throw new RuntimeException();
			} else if (var3.onResize == null) {
				return 0;
			} else {
				ScriptEvent var4 = new ScriptEvent();
				var4.widget = var3;
				var4.args = var3.onResize;
				var4.field583 = Interpreter.field1106 + 1;
				Client.scriptEvents.addFirst(var4);
				return 1;
			}
		} else {
			return 2;
		}
	}

	@ObfuscatedName("jk")
	@ObfuscatedSignature(
		signature = "(Lhj;I)Lhj;",
		garbageValue = "1227786783"
	)
	static Widget method1099(Widget var0) {
		Widget var2 = var0;
		int var3 = class32.method545(class268.getWidgetClickMask(var0));
		Widget var1;
		if (var3 == 0) {
			var1 = null;
		} else {
			int var4 = 0;

			while (true) {
				if (var4 >= var3) {
					var1 = var2;
					break;
				}

				var2 = class80.getWidget(var2.parentId);
				if (var2 == null) {
					var1 = null;
					break;
				}

				++var4;
			}
		}

		Widget var5 = var1;
		if (var1 == null) {
			var5 = var0.parent;
		}

		return var5;
	}

	@ObfuscatedName("ja")
	@ObfuscatedSignature(
		signature = "(Lhj;IIIB)V",
		garbageValue = "94"
	)
	@Export("drawMinimap")
	static final void drawMinimap(Widget var0, int var1, int var2, int var3) {
		class186.playPcmPlayers();
		SpriteMask var4 = var0.getSpriteMask(false);
		if (var4 != null) {
			Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height);
			if (Client.minimapState != 2 && Client.minimapState != 5) {
				int var5 = Client.camAngleY & 2047;
				int var6 = Client.localPlayer.x / 32 + 48;
				int var7 = 464 - Client.localPlayer.y / 32;
				RouteStrategy.sceneMinimapSprite.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths);

				int var8;
				int var9;
				int var10;
				for (var8 = 0; var8 < Client.mapIconCount; ++var8) {
					var9 = Client.mapIconXs[var8] * 4 + 2 - Client.localPlayer.x / 32;
					var10 = Client.mapIconYs[var8] * 4 + 2 - Client.localPlayer.y / 32;
					Interpreter.drawSpriteOnMinimap(var1, var2, var9, var10, Client.mapIcons[var8], var4);
				}

				int var11;
				int var12;
				for (var8 = 0; var8 < 104; ++var8) {
					for (var9 = 0; var9 < 104; ++var9) {
						NodeDeque var15 = Client.groundItems[class42.plane][var8][var9];
						if (var15 != null) {
							var11 = var8 * 4 + 2 - Client.localPlayer.x / 32;
							var12 = var9 * 4 + 2 - Client.localPlayer.y / 32;
							Interpreter.drawSpriteOnMinimap(var1, var2, var11, var12, Skills.mapDotSprites[0], var4);
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
							var11 = var16.x / 32 - Client.localPlayer.x / 32;
							var12 = var16.y / 32 - Client.localPlayer.y / 32;
							Interpreter.drawSpriteOnMinimap(var1, var2, var11, var12, Skills.mapDotSprites[1], var4);
						}
					}
				}

				var8 = Players.Players_count;
				int[] var19 = Players.Players_indices;

				for (var10 = 0; var10 < var8; ++var10) {
					Player var17 = Client.players[var19[var10]];
					if (var17 != null && var17.isVisible() && !var17.isHidden && var17 != Client.localPlayer) {
						var12 = var17.x / 32 - Client.localPlayer.x / 32;
						int var13 = var17.y / 32 - Client.localPlayer.y / 32;
						boolean var14 = false;
						if (Client.localPlayer.team != 0 && var17.team != 0 && var17.team == Client.localPlayer.team) {
							var14 = true;
						}

						if (var17.isFriend()) {
							Interpreter.drawSpriteOnMinimap(var1, var2, var12, var13, Skills.mapDotSprites[3], var4);
						} else if (var14) {
							Interpreter.drawSpriteOnMinimap(var1, var2, var12, var13, Skills.mapDotSprites[4], var4);
						} else if (var17.isClanMember()) {
							Interpreter.drawSpriteOnMinimap(var1, var2, var12, var13, Skills.mapDotSprites[5], var4);
						} else {
							Interpreter.drawSpriteOnMinimap(var1, var2, var12, var13, Skills.mapDotSprites[2], var4);
						}
					}
				}

				if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
					if (Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
						NPC var20 = Client.npcs[Client.hintArrowNpcIndex];
						if (var20 != null) {
							var11 = var20.x / 32 - Client.localPlayer.x / 32;
							var12 = var20.y / 32 - Client.localPlayer.y / 32;
							Canvas.worldToMinimap(var1, var2, var11, var12, WorldMapData_1.mapMarkerSprites[1], var4);
						}
					}

					if (Client.hintArrowType == 2) {
						var10 = Client.hintArrowX * 4 - MusicPatchNode2.baseX * 256 + 2 - Client.localPlayer.x / 32;
						var11 = Client.hintArrowY * 4 - class1.baseY * 256 + 2 - Client.localPlayer.y / 32;
						Canvas.worldToMinimap(var1, var2, var10, var11, WorldMapData_1.mapMarkerSprites[1], var4);
					}

					if (Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) {
						Player var21 = Client.players[Client.hintArrowPlayerIndex];
						if (var21 != null) {
							var11 = var21.x / 32 - Client.localPlayer.x / 32;
							var12 = var21.y / 32 - Client.localPlayer.y / 32;
							Canvas.worldToMinimap(var1, var2, var11, var12, WorldMapData_1.mapMarkerSprites[1], var4);
						}
					}
				}

				if (Client.destinationX != 0) {
					var10 = Client.destinationX * 4 + 2 - Client.localPlayer.x / 32;
					var11 = Client.destinationY * 4 + 2 - Client.localPlayer.y / 32;
					Interpreter.drawSpriteOnMinimap(var1, var2, var10, var11, WorldMapData_1.mapMarkerSprites[0], var4);
				}

				if (!Client.localPlayer.isHidden) {
					Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
				}
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

			Client.field861[var3] = true;
		}
	}
}
