import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
@Implements("BoundaryObject")
public final class BoundaryObject {
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "[Llq;"
	)
	@Export("title_muteSprite")
	static IndexedSprite[] title_muteSprite;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -557020941
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -308845337
	)
	@Export("x")
	int x;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -808193817
	)
	@Export("y")
	int y;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1993098605
	)
	@Export("orientationA")
	int orientationA;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1270638241
	)
	@Export("orientationB")
	int orientationB;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Len;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Len;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		longValue = 1081854748204039869L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1627431525
	)
	@Export("flags")
	int flags;

	BoundaryObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;ZII)V",
		garbageValue = "1558921351"
	)
	static void method3213(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
		if (Login.field1146) {
			if (var3 == 4) {
				Login.loginIndex = 4;
			}

		} else {
			Login.loginIndex = var3;
			Rasterizer2D.Rasterizer2D_clear();
			byte[] var4 = var0.takeFileByNames("title.jpg", "");
			Login.leftTitleSprite = WorldMapIcon_0.convertJpgToSprite(var4);
			Login.rightTitleSprite = Login.leftTitleSprite.mirrorHorizontally();
			if ((Client.worldProperties & 536870912) != 0) {
				class51.logoSprite = VertexNormal.SpriteBuffer_getIndexedSpriteByName(var1, "logo_deadman_mode", "");
			} else {
				class51.logoSprite = VertexNormal.SpriteBuffer_getIndexedSpriteByName(var1, "logo", "");
			}

			Login.titleboxSprite = VertexNormal.SpriteBuffer_getIndexedSpriteByName(var1, "titlebox", "");
			Login.titlebuttonSprite = VertexNormal.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton", "");
			int var6 = var1.getGroupId("runes");
			int var7 = var1.getFileId(var6, "");
			IndexedSprite[] var8;
			if (!World.SpriteBuffer_bufferFile(var1, var6, var7)) {
				var8 = null;
			} else {
				IndexedSprite[] var10 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

				for (int var11 = 0; var11 < class325.SpriteBuffer_spriteCount; ++var11) {
					IndexedSprite var12 = var10[var11] = new IndexedSprite();
					var12.width = GrandExchangeOfferUnitPriceComparator.SpriteBuffer_spriteWidth;
					var12.height = class325.SpriteBuffer_spriteHeight;
					var12.xOffset = class325.SpriteBuffer_xOffsets[var11];
					var12.yOffset = class325.SpriteBuffer_yOffsets[var11];
					var12.subWidth = class325.SpriteBuffer_spriteWidths[var11];
					var12.subHeight = class225.SpriteBuffer_spriteHeights[var11];
					var12.palette = class325.SpriteBuffer_spritePalette;
					var12.pixels = WorldMapSection1.SpriteBuffer_pixels[var11];
				}

				UserComparator7.SpriteBuffer_clear();
				var8 = var10;
			}

			ItemDefinition.runesSprite = var8;
			var7 = var1.getGroupId("title_mute");
			int var14 = var1.getFileId(var7, "");
			IndexedSprite[] var9;
			if (!World.SpriteBuffer_bufferFile(var1, var7, var14)) {
				var9 = null;
			} else {
				IndexedSprite[] var18 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

				for (int var19 = 0; var19 < class325.SpriteBuffer_spriteCount; ++var19) {
					IndexedSprite var13 = var18[var19] = new IndexedSprite();
					var13.width = GrandExchangeOfferUnitPriceComparator.SpriteBuffer_spriteWidth;
					var13.height = class325.SpriteBuffer_spriteHeight;
					var13.xOffset = class325.SpriteBuffer_xOffsets[var19];
					var13.yOffset = class325.SpriteBuffer_yOffsets[var19];
					var13.subWidth = class325.SpriteBuffer_spriteWidths[var19];
					var13.subHeight = class225.SpriteBuffer_spriteHeights[var19];
					var13.palette = class325.SpriteBuffer_spritePalette;
					var13.pixels = WorldMapSection1.SpriteBuffer_pixels[var19];
				}

				UserComparator7.SpriteBuffer_clear();
				var9 = var18;
			}

			title_muteSprite = var9;
			Login.options_buttons_0Sprite = VertexNormal.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,0", "");
			class83.field1136 = VertexNormal.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,4", "");
			Login.options_buttons_2Sprite = VertexNormal.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,2", "");
			class96.field1303 = VertexNormal.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,6", "");
			UserComparator8.field1957 = Login.options_buttons_0Sprite.subWidth;
			class173.field2079 = Login.options_buttons_0Sprite.subHeight;
			Bounds.loginScreenRunesAnimation = new LoginScreenAnimation(ItemDefinition.runesSprite);
			if (var2) {
				Login.Login_username = "";
				Login.Login_password = "";
			}

			SecureRandomCallable.field500 = 0;
			WorldMapSection1.otp = "";
			Login.field1171 = true;
			Login.worldSelectOpen = false;
			if (!GrandExchangeOffer.clientPreferences.titleMusicDisabled) {
				Archive var16 = GrandExchangeEvent.archive6;
				var14 = var16.getGroupId("scape main");
				int var17 = var16.getFileId(var14, "");
				Projectile.method2040(2, var16, var14, var17, 255, false);
			} else {
				DevicePcmPlayerProvider.method793(2);
			}

			NPC.method1977(false);
			Login.field1146 = true;
			Login.xPadding = (KitDefinition.canvasWidth - 765) / 2;
			Login.loginBoxX = Login.xPadding + 202;
			Login.loginBoxCenter = Login.loginBoxX + 180;
			Login.leftTitleSprite.drawAt(Login.xPadding, 0);
			Login.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			class51.logoSprite.drawAt(Login.xPadding + 382 - class51.logoSprite.subWidth / 2, 18);
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1412728541"
	)
	@Export("Messages_getHistorySize")
	static int Messages_getHistorySize(int var0) {
		ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var1 == null ? 0 : var1.size();
	}

	@ObfuscatedName("t")
	@Export("Entity_unpackID")
	public static int Entity_unpackID(long var0) {
		return (int)(var0 >>> 17 & 4294967295L);
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(IIIB)I",
		garbageValue = "64"
	)
	@Export("hslToRgb")
	static final int hslToRgb(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}

	@ObfuscatedName("hk")
	@ObfuscatedSignature(
		signature = "(ZLkx;B)V",
		garbageValue = "-77"
	)
	static final void method3216(boolean var0, PacketBuffer var1) {
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
						Client.field669[++Client.field861 - 1] = var2;
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

					var4.definition = ViewportMouse.getNpcDefinition(var1.readBits(14));
					var4.size = var4.definition.size * 64;
					var4.field971 = var4.definition.rotation;
					if (var4.field971 == 0) {
						var4.rotation = 0;
					}

					var4.walkSequence = var4.definition.walkSequence;
					var4.walkBackSequence = var4.definition.walkBackSequence;
					var4.walkLeftSequence = var4.definition.walkLeftSequence;
					var4.walkRightSequence = var4.definition.walkRightSequence;
					var4.readySequence = var4.definition.readySequence;
					var4.turnLeftSequence = var4.definition.turnLeftSequence;
					var4.turnRightSequence = var4.definition.turnRightSequence;
					var4.method1970(WorldMapIcon_1.localPlayer.pathX[0] + var5, WorldMapIcon_1.localPlayer.pathY[0] + var9, var6 == 1);
					continue;
				}
			}

			var1.exportIndex();
			return;
		}
	}

	@ObfuscatedName("ka")
	@ObfuscatedSignature(
		signature = "(IIIZI)V",
		garbageValue = "-1395440174"
	)
	public static void method3215(int var0, int var1, int var2, boolean var3) {
		PacketBufferNode var4 = MenuAction.getPacketBufferNode(ClientPacket.field2255, Client.packetWriter.isaacCipher);
		var4.packetBuffer.writeIntME(var3 ? Client.field705 : 0);
		var4.packetBuffer.writeShortLE(var1);
		var4.packetBuffer.method5545(var2);
		var4.packetBuffer.writeShort(var0);
		Client.packetWriter.addNode(var4);
	}
}
