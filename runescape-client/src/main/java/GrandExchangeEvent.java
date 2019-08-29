import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1320136717
	)
	static int field50;
	@ObfuscatedName("g")
	public static String[] field47;
	@ObfuscatedName("ad")
	@Export("garbageCollector")
	static GarbageCollectorMXBean garbageCollector;
	@ObfuscatedName("ds")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive6")
	static Archive archive6;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -997401899
	)
	@Export("world")
	public final int world;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		longValue = 3311995201519859273L
	)
	@Export("age")
	public final long age;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ld;"
	)
	@Export("grandExchangeOffer")
	public final GrandExchangeOffer grandExchangeOffer;
	@ObfuscatedName("k")
	@Export("offerName")
	String offerName;
	@ObfuscatedName("u")
	@Export("previousOfferName")
	String previousOfferName;

	@ObfuscatedSignature(
		signature = "(Lky;BI)V"
	)
	GrandExchangeEvent(Buffer var1, byte var2, int var3) {
		this.offerName = var1.readStringCp1252NullTerminated();
		this.previousOfferName = var1.readStringCp1252NullTerminated();
		this.world = var1.readUnsignedShort();
		this.age = var1.readLong();
		int var4 = var1.readInt();
		int var5 = var1.readInt();
		this.grandExchangeOffer = new GrandExchangeOffer();
		this.grandExchangeOffer.method108(2);
		this.grandExchangeOffer.method124(var2);
		this.grandExchangeOffer.unitPrice = var4;
		this.grandExchangeOffer.totalQuantity = var5;
		this.grandExchangeOffer.currentQuantity = 0;
		this.grandExchangeOffer.currentPrice = 0;
		this.grandExchangeOffer.id = var3;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-894568552"
	)
	@Export("getOfferName")
	public String getOfferName() {
		return this.offerName;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1580771980"
	)
	@Export("getPreviousOfferName")
	public String getPreviousOfferName() {
		return this.previousOfferName;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkb;Lkb;Lkb;B)V",
		garbageValue = "-43"
	)
	@Export("drawTitle")
	static void drawTitle(Font var0, Font var1, Font var2) {
		Login.xPadding = (KitDefinition.canvasWidth - 765) / 2;
		Login.loginBoxX = Login.xPadding + 202;
		Login.loginBoxCenter = Login.loginBoxX + 180;
		byte var23;
		int var24;
		int var27;
		int var35;
		int var46;
		if (Login.worldSelectOpen) {
			if (SoundCache.worldSelectBackSprites == null) {
				SoundCache.worldSelectBackSprites = class30.method535(class2.archive8, "sl_back", "");
			}

			IndexedSprite[] var7;
			IndexedSprite[] var29;
			IndexedSprite var30;
			Archive var33;
			int var34;
			int var39;
			if (class1.worldSelectFlagSprites == null) {
				var33 = class2.archive8;
				var35 = var33.getGroupId("sl_flags");
				var34 = var33.getFileId(var35, "");
				if (!World.SpriteBuffer_bufferFile(var33, var35, var34)) {
					var7 = null;
				} else {
					var29 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

					for (var39 = 0; var39 < class325.SpriteBuffer_spriteCount; ++var39) {
						var30 = var29[var39] = new IndexedSprite();
						var30.width = GrandExchangeOfferUnitPriceComparator.SpriteBuffer_spriteWidth;
						var30.height = class325.SpriteBuffer_spriteHeight;
						var30.xOffset = class325.SpriteBuffer_xOffsets[var39];
						var30.yOffset = class325.SpriteBuffer_yOffsets[var39];
						var30.subWidth = class325.SpriteBuffer_spriteWidths[var39];
						var30.subHeight = class225.SpriteBuffer_spriteHeights[var39];
						var30.palette = class325.SpriteBuffer_spritePalette;
						var30.pixels = WorldMapSection1.SpriteBuffer_pixels[var39];
					}

					UserComparator7.SpriteBuffer_clear();
					var7 = var29;
				}

				class1.worldSelectFlagSprites = var7;
			}

			if (Decimator.worldSelectArrows == null) {
				var33 = class2.archive8;
				var35 = var33.getGroupId("sl_arrows");
				var34 = var33.getFileId(var35, "");
				if (!World.SpriteBuffer_bufferFile(var33, var35, var34)) {
					var7 = null;
				} else {
					var29 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

					for (var39 = 0; var39 < class325.SpriteBuffer_spriteCount; ++var39) {
						var30 = var29[var39] = new IndexedSprite();
						var30.width = GrandExchangeOfferUnitPriceComparator.SpriteBuffer_spriteWidth;
						var30.height = class325.SpriteBuffer_spriteHeight;
						var30.xOffset = class325.SpriteBuffer_xOffsets[var39];
						var30.yOffset = class325.SpriteBuffer_yOffsets[var39];
						var30.subWidth = class325.SpriteBuffer_spriteWidths[var39];
						var30.subHeight = class225.SpriteBuffer_spriteHeights[var39];
						var30.palette = class325.SpriteBuffer_spritePalette;
						var30.pixels = WorldMapSection1.SpriteBuffer_pixels[var39];
					}

					UserComparator7.SpriteBuffer_clear();
					var7 = var29;
				}

				Decimator.worldSelectArrows = var7;
			}

			if (NetFileRequest.worldSelectStars == null) {
				var33 = class2.archive8;
				var35 = var33.getGroupId("sl_stars");
				var34 = var33.getFileId(var35, "");
				if (!World.SpriteBuffer_bufferFile(var33, var35, var34)) {
					var7 = null;
				} else {
					var29 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

					for (var39 = 0; var39 < class325.SpriteBuffer_spriteCount; ++var39) {
						var30 = var29[var39] = new IndexedSprite();
						var30.width = GrandExchangeOfferUnitPriceComparator.SpriteBuffer_spriteWidth;
						var30.height = class325.SpriteBuffer_spriteHeight;
						var30.xOffset = class325.SpriteBuffer_xOffsets[var39];
						var30.yOffset = class325.SpriteBuffer_yOffsets[var39];
						var30.subWidth = class325.SpriteBuffer_spriteWidths[var39];
						var30.subHeight = class225.SpriteBuffer_spriteHeights[var39];
						var30.palette = class325.SpriteBuffer_spritePalette;
						var30.pixels = WorldMapSection1.SpriteBuffer_pixels[var39];
					}

					UserComparator7.SpriteBuffer_clear();
					var7 = var29;
				}

				NetFileRequest.worldSelectStars = var7;
			}

			if (AbstractWorldMapIcon.worldSelectLeftSprite == null) {
				AbstractWorldMapIcon.worldSelectLeftSprite = VertexNormal.SpriteBuffer_getIndexedSpriteByName(class2.archive8, "leftarrow", "");
			}

			if (ClanChat.worldSelectRightSprite == null) {
				ClanChat.worldSelectRightSprite = VertexNormal.SpriteBuffer_getIndexedSpriteByName(class2.archive8, "rightarrow", "");
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
			var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
			if (NetFileRequest.worldSelectStars != null) {
				NetFileRequest.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
				var1.draw("Members only world", Login.xPadding + 152, 10, 16777215, -1);
				NetFileRequest.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
				var1.draw("Free world", Login.xPadding + 152, 21, 16777215, -1);
			}

			if (Decimator.worldSelectArrows != null) {
				var46 = Login.xPadding + 280;
				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 0) {
					Decimator.worldSelectArrows[2].drawAt(var46, 4);
				} else {
					Decimator.worldSelectArrows[0].drawAt(var46, 4);
				}

				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 1) {
					Decimator.worldSelectArrows[3].drawAt(var46 + 15, 4);
				} else {
					Decimator.worldSelectArrows[1].drawAt(var46 + 15, 4);
				}

				var0.draw("World", var46 + 32, 17, 16777215, -1);
				var24 = Login.xPadding + 390;
				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 0) {
					Decimator.worldSelectArrows[2].drawAt(var24, 4);
				} else {
					Decimator.worldSelectArrows[0].drawAt(var24, 4);
				}

				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 1) {
					Decimator.worldSelectArrows[3].drawAt(var24 + 15, 4);
				} else {
					Decimator.worldSelectArrows[1].drawAt(var24 + 15, 4);
				}

				var0.draw("Players", var24 + 32, 17, 16777215, -1);
				var35 = Login.xPadding + 500;
				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 0) {
					Decimator.worldSelectArrows[2].drawAt(var35, 4);
				} else {
					Decimator.worldSelectArrows[0].drawAt(var35, 4);
				}

				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 1) {
					Decimator.worldSelectArrows[3].drawAt(var35 + 15, 4);
				} else {
					Decimator.worldSelectArrows[1].drawAt(var35 + 15, 4);
				}

				var0.draw("Location", var35 + 32, 17, 16777215, -1);
				var34 = Login.xPadding + 610;
				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 0) {
					Decimator.worldSelectArrows[2].drawAt(var34, 4);
				} else {
					Decimator.worldSelectArrows[0].drawAt(var34, 4);
				}

				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 1) {
					Decimator.worldSelectArrows[3].drawAt(var34 + 15, 4);
				} else {
					Decimator.worldSelectArrows[1].drawAt(var34 + 15, 4);
				}

				var0.draw("Type", var34 + 32, 17, 16777215, -1);
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
			var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
			Login.hoveredWorldIndex = -1;
			if (SoundCache.worldSelectBackSprites != null) {
				var23 = 88;
				byte var49 = 19;
				var35 = 765 / (var23 + 1) - 1;
				var34 = 480 / (var49 + 1);

				int var38;
				do {
					var27 = var34;
					var38 = var35;
					if (var34 * (var35 - 1) >= World.World_count) {
						--var35;
					}

					if (var35 * (var34 - 1) >= World.World_count) {
						--var34;
					}

					if (var35 * (var34 - 1) >= World.World_count) {
						--var34;
					}
				} while(var27 != var34 || var35 != var38);

				var27 = (765 - var23 * var35) / (var35 + 1);
				if (var27 > 5) {
					var27 = 5;
				}

				var38 = (480 - var34 * var49) / (var34 + 1);
				if (var38 > 5) {
					var38 = 5;
				}

				int var37 = (765 - var35 * var23 - var27 * (var35 - 1)) / 2;
				var39 = (480 - var49 * var34 - var38 * (var34 - 1)) / 2;
				int var11 = (var34 + World.World_count - 1) / var34;
				Login.worldSelectPagesCount = var11 - var35;
				if (AbstractWorldMapIcon.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
					AbstractWorldMapIcon.worldSelectLeftSprite.drawAt(8, class30.canvasHeight / 2 - AbstractWorldMapIcon.worldSelectLeftSprite.subHeight / 2);
				}

				if (ClanChat.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
					ClanChat.worldSelectRightSprite.drawAt(KitDefinition.canvasWidth - ClanChat.worldSelectRightSprite.subWidth - 8, class30.canvasHeight / 2 - ClanChat.worldSelectRightSprite.subHeight / 2);
				}

				int var12 = var39 + 23;
				int var40 = var37 + Login.xPadding;
				int var41 = 0;
				boolean var42 = false;
				int var43 = Login.worldSelectPage;

				int var17;
				for (var17 = var34 * var43; var17 < World.World_count && var43 - Login.worldSelectPage < var35; ++var17) {
					World var28 = ChatChannel.World_worlds[var17];
					boolean var19 = true;
					String var20 = Integer.toString(var28.population);
					if (var28.population == -1) {
						var20 = "OFF";
						var19 = false;
					} else if (var28.population > 1980) {
						var20 = "FULL";
						var19 = false;
					}

					int var22 = 0;
					byte var21;
					if (var28.isBeta()) {
						if (var28.isMembersOnly()) {
							var21 = 7;
						} else {
							var21 = 6;
						}
					} else if (var28.isDeadman()) {
						var22 = 16711680;
						if (var28.isMembersOnly()) {
							var21 = 5;
						} else {
							var21 = 4;
						}
					} else if (var28.isPvp()) {
						if (var28.isMembersOnly()) {
							var21 = 3;
						} else {
							var21 = 2;
						}
					} else if (var28.isMembersOnly()) {
						var21 = 1;
					} else {
						var21 = 0;
					}

					if (MouseHandler.MouseHandler_x >= var40 && MouseHandler.MouseHandler_y >= var12 && MouseHandler.MouseHandler_x < var40 + var23 && MouseHandler.MouseHandler_y < var12 + var49 && var19) {
						Login.hoveredWorldIndex = var17;
						SoundCache.worldSelectBackSprites[var21].drawTransOverlayAt(var40, var12, 128, 16777215);
						var42 = true;
					} else {
						SoundCache.worldSelectBackSprites[var21].drawAt(var40, var12);
					}

					if (class1.worldSelectFlagSprites != null) {
						class1.worldSelectFlagSprites[(var28.isMembersOnly() ? 8 : 0) + var28.location].drawAt(var40 + 29, var12);
					}

					var0.drawCentered(Integer.toString(var28.id), var40 + 15, var49 / 2 + var12 + 5, var22, -1);
					var1.drawCentered(var20, var40 + 60, var49 / 2 + var12 + 5, 268435455, -1);
					var12 = var12 + var38 + var49;
					++var41;
					if (var41 >= var34) {
						var12 = var39 + 23;
						var40 = var40 + var23 + var27;
						var41 = 0;
						++var43;
					}
				}

				if (var42) {
					var17 = var1.stringWidth(ChatChannel.World_worlds[Login.hoveredWorldIndex].activity) + 6;
					int var18 = var1.ascent + 8;
					int var44 = MouseHandler.MouseHandler_y + 25;
					if (var18 + var44 > 480) {
						var44 = MouseHandler.MouseHandler_y - 25 - var18;
					}

					Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var17 / 2, var44, var17, var18, 16777120);
					Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var17 / 2, var44, var17, var18, 0);
					var1.drawCentered(ChatChannel.World_worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var44 + var1.ascent + 4, 0, -1);
				}
			}

			SpotAnimationDefinition.rasterProvider.drawFull(0, 0);
		} else {
			Login.leftTitleSprite.drawAt(Login.xPadding, 0);
			Login.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			class51.logoSprite.drawAt(Login.xPadding + 382 - class51.logoSprite.subWidth / 2, 18);
			if (Client.gameState == 0 || Client.gameState == 5) {
				var23 = 20;
				var0.drawCentered("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var23, 16777215, -1);
				var24 = 253 - var23;
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 152, var24, 304, 34, 9179409);
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 151, var24 + 1, 302, 32, 0);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150, var24 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150 + Login.Login_loadingPercent * 3, var24 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
				var0.drawCentered(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var23, 16777215, -1);
			}

			String var25;
			String var26;
			short var45;
			short var47;
			if (Client.gameState == 20) {
				Login.titleboxSprite.drawAt(Login.loginBoxX + 180 - Login.titleboxSprite.subWidth / 2, 271 - Login.titleboxSprite.subHeight / 2);
				var45 = 201;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var45, 16776960, 0);
				var46 = var45 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var46, 16776960, 0);
				var46 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var46, 16776960, 0);
				var46 += 15;
				var46 += 7;
				if (Login.loginIndex != 4) {
					var0.draw("Login: ", Login.loginBoxX + 180 - 110, var46, 16777215, 0);
					var47 = 200;
					var25 = GrandExchangeOffer.clientPreferences.hideUsername ? Huffman.method3903(Login.Login_username) : Login.Login_username;

					for (var26 = var25; var0.stringWidth(var26) > var47; var26 = var26.substring(0, var26.length() - 1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var26), Login.loginBoxX + 180 - 70, var46, 16777215, 0);
					var46 += 15;
					var0.draw("Password: " + Huffman.method3903(Login.Login_password), Login.loginBoxX + 180 - 108, var46, 16777215, 0);
					var46 += 15;
				}
			}

			if (Client.gameState == 10 || Client.gameState == 11) {
				Login.titleboxSprite.drawAt(Login.loginBoxX, 171);
				short var5;
				if (Login.loginIndex == 0) {
					var45 = 251;
					var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var45, 16776960, 0);
					var46 = var45 + 30;
					var24 = Login.loginBoxX + 180 - 80;
					var5 = 291;
					Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawLines("New User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
					var24 = Login.loginBoxX + 180 + 80;
					Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawLines("Existing User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				} else if (Login.loginIndex == 1) {
					var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
					var45 = 236;
					var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var45, 16777215, 0);
					var46 = var45 + 15;
					var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var46, 16777215, 0);
					var46 += 15;
					var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var46, 16777215, 0);
					var46 += 15;
					var24 = Login.loginBoxX + 180 - 80;
					var5 = 321;
					Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawCentered("Continue", var24, var5 + 5, 16777215, 0);
					var24 = Login.loginBoxX + 180 + 80;
					Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawCentered("Cancel", var24, var5 + 5, 16777215, 0);
				} else if (Login.loginIndex == 2) {
					var45 = 201;
					var0.drawCentered(Login.Login_response1, Login.loginBoxCenter, var45, 16776960, 0);
					var46 = var45 + 15;
					var0.drawCentered(Login.Login_response2, Login.loginBoxCenter, var46, 16776960, 0);
					var46 += 15;
					var0.drawCentered(Login.Login_response3, Login.loginBoxCenter, var46, 16776960, 0);
					var46 += 15;
					var46 += 7;
					var0.draw("Login: ", Login.loginBoxCenter - 110, var46, 16777215, 0);
					var47 = 200;
					var25 = GrandExchangeOffer.clientPreferences.hideUsername ? Huffman.method3903(Login.Login_username) : Login.Login_username;

					for (var26 = var25; var0.stringWidth(var26) > var47; var26 = var26.substring(1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var26) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? class16.colorStartTag(16776960) + "|" : ""), Login.loginBoxCenter - 70, var46, 16777215, 0);
					var46 += 15;
					var0.draw("Password: " + Huffman.method3903(Login.Login_password) + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? class16.colorStartTag(16776960) + "|" : ""), Login.loginBoxCenter - 108, var46, 16777215, 0);
					var46 += 15;
					var45 = 277;
					var27 = Login.loginBoxCenter + -117;
					boolean var9 = Client.Login_isUsernameRemembered;
					boolean var10 = Login.field1169;
					IndexedSprite var31 = var9 ? (var10 ? class96.field1303 : Login.options_buttons_2Sprite) : (var10 ? class83.field1136 : Login.options_buttons_0Sprite);
					var31.drawAt(var27, var45);
					var27 = var27 + var31.subWidth + 5;
					var1.draw("Remember username", var27, var45 + 13, 16776960, 0);
					var27 = Login.loginBoxCenter + 24;
					boolean var13 = GrandExchangeOffer.clientPreferences.hideUsername;
					boolean var14 = Login.field1170;
					IndexedSprite var32 = var13 ? (var14 ? class96.field1303 : Login.options_buttons_2Sprite) : (var14 ? class83.field1136 : Login.options_buttons_0Sprite);
					var32.drawAt(var27, var45);
					var27 = var27 + var32.subWidth + 5;
					var1.draw("Hide username", var27, var45 + 13, 16776960, 0);
					var46 = var45 + 15;
					int var15 = Login.loginBoxCenter - 80;
					short var16 = 321;
					Login.titlebuttonSprite.drawAt(var15 - 73, var16 - 20);
					var0.drawCentered("Login", var15, var16 + 5, 16777215, 0);
					var15 = Login.loginBoxCenter + 80;
					Login.titlebuttonSprite.drawAt(var15 - 73, var16 - 20);
					var0.drawCentered("Cancel", var15, var16 + 5, 16777215, 0);
					var45 = 357;
					switch(Login.field1161) {
					case 2:
						DynamicObject.field1268 = "Having trouble logging in?";
						break;
					default:
						DynamicObject.field1268 = "Can't login? Click here.";
					}

					Decimator.field1443 = new Bounds(Login.loginBoxCenter, var45, var1.stringWidth(DynamicObject.field1268), 11);
					MusicPatchPcmStream.field2466 = new Bounds(Login.loginBoxCenter, var45, var1.stringWidth("Still having trouble logging in?"), 11);
					var1.drawCentered(DynamicObject.field1268, Login.loginBoxCenter, var45, 16777215, 0);
				} else if (Login.loginIndex == 3) {
					var45 = 201;
					var0.drawCentered("Invalid credentials.", Login.loginBoxX + 180, var45, 16776960, 0);
					var46 = var45 + 20;
					var1.drawCentered("For accounts created after 24th November 2010, please use your", Login.loginBoxX + 180, var46, 16776960, 0);
					var46 += 15;
					var1.drawCentered("email address to login. Otherwise please login with your username.", Login.loginBoxX + 180, var46, 16776960, 0);
					var46 += 15;
					var24 = Login.loginBoxX + 180;
					var5 = 276;
					Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var2.drawCentered("Try again", var24, var5 + 5, 16777215, 0);
					var24 = Login.loginBoxX + 180;
					var5 = 326;
					Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var2.drawCentered("Forgotten password?", var24, var5 + 5, 16777215, 0);
				} else {
					short var8;
					if (Login.loginIndex == 4) {
						var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
						var45 = 236;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var45, 16777215, 0);
						var46 = var45 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var46, 16777215, 0);
						var46 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var46, 16777215, 0);
						var46 += 15;
						var0.draw("PIN: " + Huffman.method3903(WorldMapSection1.otp) + (Client.cycle % 40 < 20 ? class16.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var46, 16777215, 0);
						var46 -= 8;
						var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var46, 16776960, 0);
						var46 += 15;
						var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var46, 16776960, 0);
						var24 = 180 + Login.loginBoxX - 9 + var0.stringWidth("for 30 days: ") + 15;
						var35 = var46 - var0.ascent;
						IndexedSprite var48;
						if (Login.field1171) {
							var48 = Login.options_buttons_2Sprite;
						} else {
							var48 = Login.options_buttons_0Sprite;
						}

						var48.drawAt(var24, var35);
						var46 += 15;
						var27 = Login.loginBoxX + 180 - 80;
						var8 = 321;
						Login.titlebuttonSprite.drawAt(var27 - 73, var8 - 20);
						var0.drawCentered("Continue", var27, var8 + 5, 16777215, 0);
						var27 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var27 - 73, var8 - 20);
						var0.drawCentered("Cancel", var27, var8 + 5, 16777215, 0);
						var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var8 + 36, 255, 0);
					} else if (Login.loginIndex == 5) {
						var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
						var45 = 221;
						var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var45, 16776960, 0);
						var46 = var45 + 15;
						var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var46, 16776960, 0);
						var46 += 15;
						var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var46, 16776960, 0);
						var46 += 15;
						var46 += 14;
						var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var46, 16777215, 0);
						var47 = 174;
						var25 = GrandExchangeOffer.clientPreferences.hideUsername ? Huffman.method3903(Login.Login_username) : Login.Login_username;

						for (var26 = var25; var0.stringWidth(var26) > var47; var26 = var26.substring(1)) {
						}

						var0.draw(AbstractFont.escapeBrackets(var26) + (Client.cycle % 40 < 20 ? class16.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var46, 16777215, 0);
						var46 += 15;
						var27 = Login.loginBoxX + 180 - 80;
						var8 = 321;
						Login.titlebuttonSprite.drawAt(var27 - 73, var8 - 20);
						var0.drawCentered("Recover", var27, var8 + 5, 16777215, 0);
						var27 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var27 - 73, var8 - 20);
						var0.drawCentered("Back", var27, var8 + 5, 16777215, 0);
						var8 = 356;
						var1.drawCentered("Still having trouble logging in?", Login.loginBoxCenter, var8, 268435455, 0);
					} else if (Login.loginIndex == 6) {
						var45 = 201;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var45, 16776960, 0);
						var46 = var45 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var46, 16776960, 0);
						var46 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var46, 16776960, 0);
						var46 += 15;
						var24 = Login.loginBoxX + 180;
						var5 = 321;
						Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 7) {
						var45 = 216;
						var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var45, 16776960, 0);
						var46 = var45 + 15;
						var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var46, 16776960, 0);
						var46 += 15;
						var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var46, 16776960, 0);
						var46 += 15;
						var24 = Login.loginBoxX + 180 - 80;
						var5 = 321;
						Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Set Date of Birth", var24, var5 + 5, 16777215, 0);
						var24 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 8) {
						var45 = 216;
						var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var45, 16776960, 0);
						var46 = var45 + 15;
						var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var46, 16776960, 0);
						var46 += 15;
						var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var46, 16776960, 0);
						var46 += 15;
						var24 = Login.loginBoxX + 180 - 80;
						var5 = 321;
						Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Privacy Policy", var24, var5 + 5, 16777215, 0);
						var24 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 12) {
						var45 = 201;
						String var4 = "";
						var25 = "";
						var26 = "";
						switch(Login.field1160) {
						case 0:
							var4 = "Your account has been disabled.";
							var25 = Strings.field2992;
							var26 = "";
							break;
						case 1:
							var4 = "Account locked as we suspect it has been stolen.";
							var25 = Strings.field2831;
							var26 = "";
							break;
						default:
							GZipDecompressor.method6390(false);
						}

						var0.drawCentered(var4, Login.loginBoxX + 180, var45, 16776960, 0);
						var46 = var45 + 15;
						var2.drawCentered(var25, Login.loginBoxX + 180, var46, 16776960, 0);
						var46 += 15;
						var2.drawCentered(var26, Login.loginBoxX + 180, var46, 16776960, 0);
						var46 += 15;
						var27 = Login.loginBoxX + 180;
						var8 = 276;
						Login.titlebuttonSprite.drawAt(var27 - 73, var8 - 20);
						var0.drawCentered("Support Page", var27, var8 + 5, 16777215, 0);
						var27 = Login.loginBoxX + 180;
						var8 = 326;
						Login.titlebuttonSprite.drawAt(var27 - 73, var8 - 20);
						var0.drawCentered("Back", var27, var8 + 5, 16777215, 0);
					} else if (Login.loginIndex == 24) {
						var45 = 221;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var45, 16777215, 0);
						var46 = var45 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var46, 16777215, 0);
						var46 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var46, 16777215, 0);
						var46 += 15;
						var24 = Login.loginBoxX + 180;
						var5 = 301;
						Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Ok", var24, var5 + 5, 16777215, 0);
					}
				}
			}

			if (Client.gameState >= 10) {
				int[] var3 = new int[4];
				Rasterizer2D.Rasterizer2D_getClipArray(var3);
				Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, class30.canvasHeight);
				Bounds.loginScreenRunesAnimation.draw(Login.xPadding - 22, Client.cycle);
				Bounds.loginScreenRunesAnimation.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
				Rasterizer2D.Rasterizer2D_setClipArray(var3);
			}

			BoundaryObject.title_muteSprite[GrandExchangeOffer.clientPreferences.titleMusicDisabled ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
			if (Client.gameState > 5 && Language.Language_EN == class60.clientLanguage) {
				if (class195.field2368 != null) {
					var46 = Login.xPadding + 5;
					var47 = 463;
					byte var36 = 100;
					byte var6 = 35;
					class195.field2368.drawAt(var46, var47);
					var0.drawCentered("World" + " " + Client.worldId, var36 / 2 + var46, var6 / 2 + var47 - 2, 16777215, 0);
					if (IgnoreList.World_request != null) {
						var1.drawCentered("Loading...", var36 / 2 + var46, var6 / 2 + var47 + 12, 16777215, 0);
					} else {
						var1.drawCentered("Click to switch", var36 / 2 + var46, var6 / 2 + var47 + 12, 16777215, 0);
					}
				} else {
					class195.field2368 = VertexNormal.SpriteBuffer_getIndexedSpriteByName(class2.archive8, "sl_button", "");
				}
			}

		}
	}
}
