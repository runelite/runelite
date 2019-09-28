import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("ClientPreferences")
public class ClientPreferences {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1035730115
	)
	@Export("ClientPreferences_optionCount")
	static int ClientPreferences_optionCount;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("Widget_spritesArchive")
	static AbstractArchive Widget_spritesArchive;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	static IndexedSprite field1046;
	@ObfuscatedName("v")
	@Export("roofsHidden")
	boolean roofsHidden;
	@ObfuscatedName("u")
	@Export("titleMusicDisabled")
	boolean titleMusicDisabled;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1970428567
	)
	@Export("windowMode")
	int windowMode;
	@ObfuscatedName("p")
	@Export("rememberedUsername")
	String rememberedUsername;
	@ObfuscatedName("q")
	@Export("hideUsername")
	boolean hideUsername;
	@ObfuscatedName("m")
	@Export("parameters")
	LinkedHashMap parameters;

	static {
		ClientPreferences_optionCount = 6;
	}

	ClientPreferences() {
		this.windowMode = 1;
		this.rememberedUsername = null;
		this.hideUsername = false;
		this.parameters = new LinkedHashMap();
		this.method1851(true);
	}

	@ObfuscatedSignature(
		signature = "(Lkl;)V"
	)
	ClientPreferences(Buffer var1) {
		this.windowMode = 1;
		this.rememberedUsername = null;
		this.hideUsername = false;
		this.parameters = new LinkedHashMap();
		if (var1 != null && var1.array != null) {
			int var2 = var1.readUnsignedByte();
			if (var2 >= 0 && var2 <= ClientPreferences_optionCount) {
				if (var1.readUnsignedByte() == 1) {
					this.roofsHidden = true;
				}

				if (var2 > 1) {
					this.titleMusicDisabled = var1.readUnsignedByte() == 1;
				}

				if (var2 > 3) {
					this.windowMode = var1.readUnsignedByte();
				}

				if (var2 > 2) {
					int var3 = var1.readUnsignedByte();

					for (int var4 = 0; var4 < var3; ++var4) {
						int var5 = var1.readInt();
						int var6 = var1.readInt();
						this.parameters.put(var5, var6);
					}
				}

				if (var2 > 4) {
					this.rememberedUsername = var1.readStringCp1252NullTerminatedOrNull();
				}

				if (var2 > 5) {
					this.hideUsername = var1.readBoolean();
				}
			} else {
				this.method1851(true);
			}
		} else {
			this.method1851(true);
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "864937253"
	)
	void method1851(boolean var1) {
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Lkl;",
		garbageValue = "-630561096"
	)
	@Export("toBuffer")
	Buffer toBuffer() {
		Buffer var1 = new Buffer(100);
		var1.writeByte(ClientPreferences_optionCount);
		var1.writeByte(this.roofsHidden ? 1 : 0);
		var1.writeByte(this.titleMusicDisabled ? 1 : 0);
		var1.writeByte(this.windowMode);
		var1.writeByte(this.parameters.size());
		Iterator var2 = this.parameters.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			var1.writeInt((Integer)var3.getKey());
			var1.writeInt((Integer)var3.getValue());
		}

		var1.writeStringCp1252NullTerminated(this.rememberedUsername != null ? this.rememberedUsername : "");
		var1.writeBoolean(this.hideUsername);
		return var1;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-70"
	)
	static void method1861() {
		Players.Players_count = 0;

		for (int var0 = 0; var0 < 2048; ++var0) {
			Players.field1236[var0] = null;
			Players.field1235[var0] = 1;
		}

	}

	@ObfuscatedName("jb")
	@ObfuscatedSignature(
		signature = "(Lho;IIII)V",
		garbageValue = "1173230125"
	)
	@Export("drawMinimap")
	static final void drawMinimap(Widget var0, int var1, int var2, int var3) {
		WorldMapID.playPcmPlayers();
		SpriteMask var4 = var0.getSpriteMask(false);
		if (var4 != null) {
			Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height);
			if (Client.minimapState != 2 && Client.minimapState != 5) {
				int var5 = Client.camAngleY & 2047;
				int var6 = class223.localPlayer.x / 32 + 48;
				int var7 = 464 - class223.localPlayer.y / 32;
				ObjectSound.sceneMinimapSprite.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths);

				int var8;
				int var9;
				int var10;
				for (var8 = 0; var8 < Client.mapIconCount; ++var8) {
					var9 = Client.mapIconXs[var8] * 4 + 2 - class223.localPlayer.x / 32;
					var10 = Client.mapIconYs[var8] * 4 + 2 - class223.localPlayer.y / 32;
					class208.drawSpriteOnMinimap(var1, var2, var9, var10, Client.mapIcons[var8], var4);
				}

				int var11;
				int var12;
				for (var8 = 0; var8 < 104; ++var8) {
					for (var9 = 0; var9 < 104; ++var9) {
						NodeDeque var15 = Client.groundItems[WorldMapRectangle.plane][var8][var9];
						if (var15 != null) {
							var11 = var8 * 4 + 2 - class223.localPlayer.x / 32;
							var12 = var9 * 4 + 2 - class223.localPlayer.y / 32;
							class208.drawSpriteOnMinimap(var1, var2, var11, var12, class13.mapDotSprites[0], var4);
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
							var11 = var16.x / 32 - class223.localPlayer.x / 32;
							var12 = var16.y / 32 - class223.localPlayer.y / 32;
							class208.drawSpriteOnMinimap(var1, var2, var11, var12, class13.mapDotSprites[1], var4);
						}
					}
				}

				var8 = Players.Players_count;
				int[] var19 = Players.Players_indices;

				for (var10 = 0; var10 < var8; ++var10) {
					Player var17 = Client.players[var19[var10]];
					if (var17 != null && var17.isVisible() && !var17.isHidden && var17 != class223.localPlayer) {
						var12 = var17.x / 32 - class223.localPlayer.x / 32;
						int var13 = var17.y / 32 - class223.localPlayer.y / 32;
						boolean var14 = false;
						if (class223.localPlayer.team != 0 && var17.team != 0 && var17.team == class223.localPlayer.team) {
							var14 = true;
						}

						if (var17.isFriend()) {
							class208.drawSpriteOnMinimap(var1, var2, var12, var13, class13.mapDotSprites[3], var4);
						} else if (var14) {
							class208.drawSpriteOnMinimap(var1, var2, var12, var13, class13.mapDotSprites[4], var4);
						} else if (var17.isClanMember()) {
							class208.drawSpriteOnMinimap(var1, var2, var12, var13, class13.mapDotSprites[5], var4);
						} else {
							class208.drawSpriteOnMinimap(var1, var2, var12, var13, class13.mapDotSprites[2], var4);
						}
					}
				}

				if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
					if (Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
						NPC var20 = Client.npcs[Client.hintArrowNpcIndex];
						if (var20 != null) {
							var11 = var20.x / 32 - class223.localPlayer.x / 32;
							var12 = var20.y / 32 - class223.localPlayer.y / 32;
							FloorDecoration.worldToMinimap(var1, var2, var11, var12, GameObject.mapMarkerSprites[1], var4);
						}
					}

					if (Client.hintArrowType == 2) {
						var10 = Client.hintArrowX * 4 - class223.baseX * 256 + 2 - class223.localPlayer.x / 32;
						var11 = Client.hintArrowY * 4 - class286.baseY * 256 + 2 - class223.localPlayer.y / 32;
						FloorDecoration.worldToMinimap(var1, var2, var10, var11, GameObject.mapMarkerSprites[1], var4);
					}

					if (Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) {
						Player var21 = Client.players[Client.hintArrowPlayerIndex];
						if (var21 != null) {
							var11 = var21.x / 32 - class223.localPlayer.x / 32;
							var12 = var21.y / 32 - class223.localPlayer.y / 32;
							FloorDecoration.worldToMinimap(var1, var2, var11, var12, GameObject.mapMarkerSprites[1], var4);
						}
					}
				}

				if (Client.destinationX != 0) {
					var10 = Client.destinationX * 4 + 2 - class223.localPlayer.x / 32;
					var11 = Client.destinationY * 4 + 2 - class223.localPlayer.y / 32;
					class208.drawSpriteOnMinimap(var1, var2, var10, var11, GameObject.mapMarkerSprites[0], var4);
				}

				if (!class223.localPlayer.isHidden) {
					Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
				}
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

			Client.field842[var3] = true;
		}
	}
}
