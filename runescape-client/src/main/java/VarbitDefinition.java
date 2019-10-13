import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("VarbitDefinition")
public class VarbitDefinition extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("VarbitDefinition_archive")
	public static AbstractArchive VarbitDefinition_archive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("VarbitDefinition_cached")
	public static EvictingDualNodeHashTable VarbitDefinition_cached;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -613999551
	)
	@Export("baseVar")
	public int baseVar;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1319012991
	)
	@Export("startBit")
	public int startBit;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 1338326949
	)
	@Export("endBit")
	public int endBit;

	static {
		VarbitDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "1106809134"
	)
	@Export("decode")
	public void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "1640448389"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.baseVar = var1.readUnsignedShort();
			this.startBit = var1.readUnsignedByte();
			this.endBit = var1.readUnsignedByte();
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkn;Lkn;Lkn;I)V",
		garbageValue = "937788655"
	)
	@Export("drawTitle")
	static void drawTitle(Font var0, Font var1, Font var2) {
		Login.xPadding = (FloorDecoration.canvasWidth - 765) / 2;
		Login.loginBoxX = Login.xPadding + 202;
		GrandExchangeOfferUnitPriceComparator.loginBoxCenter = Login.loginBoxX + 180;
		if (Login.worldSelectOpen) {
			if (ArchiveLoader.worldSelectBackSprites == null) {
				Archive var36 = GrandExchangeOfferAgeComparator.archive8;
				int var39 = var36.getGroupId("sl_back");
				int var37 = var36.getFileId(var39, "");
				Sprite[] var35 = Canvas.SpriteBuffer_getSpriteArray(var36, var39, var37);
				ArchiveLoader.worldSelectBackSprites = var35;
			}

			if (Language.worldSelectFlagSprites == null) {
				Language.worldSelectFlagSprites = WorldMapIcon_0.method222(GrandExchangeOfferAgeComparator.archive8, "sl_flags", "");
			}

			if (GrandExchangeOfferTotalQuantityComparator.worldSelectArrows == null) {
				GrandExchangeOfferTotalQuantityComparator.worldSelectArrows = WorldMapIcon_0.method222(GrandExchangeOfferAgeComparator.archive8, "sl_arrows", "");
			}

			if (Frames.worldSelectStars == null) {
				Frames.worldSelectStars = WorldMapIcon_0.method222(GrandExchangeOfferAgeComparator.archive8, "sl_stars", "");
			}

			if (WorldMapIcon_0.worldSelectLeftSprite == null) {
				WorldMapIcon_0.worldSelectLeftSprite = WorldMapRectangle.SpriteBuffer_getIndexedSpriteByName(GrandExchangeOfferAgeComparator.archive8, "leftarrow", "");
			}

			if (HealthBar.worldSelectRightSprite == null) {
				HealthBar.worldSelectRightSprite = WorldMapRectangle.SpriteBuffer_getIndexedSpriteByName(GrandExchangeOfferAgeComparator.archive8, "rightarrow", "");
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
			var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
			if (Frames.worldSelectStars != null) {
				Frames.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
				var1.draw("Members only world", Login.xPadding + 152, 10, 0xffffff, -1);
				Frames.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
				var1.draw("Free world", Login.xPadding + 152, 21, 0xffffff, -1);
			}

			if (GrandExchangeOfferTotalQuantityComparator.worldSelectArrows != null) {
				int var45 = Login.xPadding + 280;
				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 0) {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[2].drawAt(var45, 4);
				} else {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[0].drawAt(var45, 4);
				}

				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 1) {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[3].drawAt(var45 + 15, 4);
				} else {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[1].drawAt(var45 + 15, 4);
				}

				var0.draw("World", var45 + 32, 17, 0xffffff, -1);
				int var24 = Login.xPadding + 390;
				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 0) {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[2].drawAt(var24, 4);
				} else {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[0].drawAt(var24, 4);
				}

				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 1) {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[3].drawAt(var24 + 15, 4);
				} else {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[1].drawAt(var24 + 15, 4);
				}

				var0.draw("Players", var24 + 32, 17, 0xffffff, -1);
				int var39 = Login.xPadding + 500;
				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 0) {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[2].drawAt(var39, 4);
				} else {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[0].drawAt(var39, 4);
				}

				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 1) {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[3].drawAt(var39 + 15, 4);
				} else {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[1].drawAt(var39 + 15, 4);
				}

				var0.draw("Location", var39 + 32, 17, 0xffffff, -1);
				int var37 = Login.xPadding + 610;
				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 0) {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[2].drawAt(var37, 4);
				} else {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[0].drawAt(var37, 4);
				}

				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 1) {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[3].drawAt(var37 + 15, 4);
				} else {
					GrandExchangeOfferTotalQuantityComparator.worldSelectArrows[1].drawAt(var37 + 15, 4);
				}

				var0.draw("Type", var37 + 32, 17, 0xffffff, -1);
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
			var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 0xffffff, -1);
			Login.hoveredWorldIndex = -1;
			if (ArchiveLoader.worldSelectBackSprites != null) {
				byte var23 = 88;
				byte var50 = 19;
				int var39 = 765 / (var23 + 1) - 1;
				int var37 = 480 / (var50 + 1);

				int var28, var29;

				do {
					var28 = var37;
					var29 = var39;
					if (var37 * (var39 - 1) >= World.World_count) {
						--var39;
					}

					if (var39 * (var37 - 1) >= World.World_count) {
						--var37;
					}

					if (var39 * (var37 - 1) >= World.World_count) {
						--var37;
					}
				} while(var28 != var37 || var39 != var29);

				var28 = (765 - var39 * var23) / (var39 + 1);
				if (var28 > 5) {
					var28 = 5;
				}

				var29 = (480 - var50 * var37) / (var37 + 1);
				if (var29 > 5) {
					var29 = 5;
				}

				int var30 = (765 - var23 * var39 - var28 * (var39 - 1)) / 2;
				int var10 = (480 - var37 * var50 - var29 * (var37 - 1)) / 2;
				int var31 = (var37 + World.World_count - 1) / var37;
				Login.worldSelectPagesCount = var31 - var39;
				if (WorldMapIcon_0.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
					WorldMapIcon_0.worldSelectLeftSprite.drawAt(8, WallDecoration.canvasHeight / 2 - WorldMapIcon_0.worldSelectLeftSprite.subHeight / 2);
				}

				if (HealthBar.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
					HealthBar.worldSelectRightSprite.drawAt(FloorDecoration.canvasWidth - HealthBar.worldSelectRightSprite.subWidth - 8, WallDecoration.canvasHeight / 2 - HealthBar.worldSelectRightSprite.subHeight / 2);
				}

				int var12 = var10 + 23;
				int var32 = var30 + Login.xPadding;
				int var14 = 0;
				boolean var15 = false;
				int var16 = Login.worldSelectPage;

				int var17;
				for (var17 = var37 * var16; var17 < World.World_count && var16 - Login.worldSelectPage < var39; ++var17) {
					World var33 = World.World_worlds[var17];
					boolean var19 = true;
					String var20 = Integer.toString(var33.population);
					if (var33.population == -1) {
						var20 = "OFF";
						var19 = false;
					} else if (var33.population > 1980) {
						var20 = "FULL";
						var19 = false;
					}

					int var22 = 0;
					byte var21;
					if (var33.isBeta()) {
						if (var33.isMembersOnly()) {
							var21 = 7;
						} else {
							var21 = 6;
						}
					} else if (var33.isDeadman()) {
						var22 = 16711680;
						if (var33.isMembersOnly()) {
							var21 = 5;
						} else {
							var21 = 4;
						}
					} else if (var33.isPvp()) {
						if (var33.isMembersOnly()) {
							var21 = 3;
						} else {
							var21 = 2;
						}
					} else if (var33.isMembersOnly()) {
						var21 = 1;
					} else {
						var21 = 0;
					}

					if (MouseHandler.MouseHandler_x >= var32 && MouseHandler.MouseHandler_y >= var12 && MouseHandler.MouseHandler_x < var23 + var32 && MouseHandler.MouseHandler_y < var50 + var12 && var19) {
						Login.hoveredWorldIndex = var17;
						ArchiveLoader.worldSelectBackSprites[var21].drawTransOverlayAt(var32, var12, 128, 0xffffff);
						var15 = true;
					} else {
						ArchiveLoader.worldSelectBackSprites[var21].drawAt(var32, var12);
					}

					if (Language.worldSelectFlagSprites != null) {
						Language.worldSelectFlagSprites[(var33.isMembersOnly() ? 8 : 0) + var33.location].drawAt(var32 + 29, var12);
					}

					var0.drawCentered(Integer.toString(var33.id), var32 + 15, var50 / 2 + var12 + 5, var22, -1);
					var1.drawCentered(var20, var32 + 60, var50 / 2 + var12 + 5, 268435455, -1);
					var12 = var12 + var29 + var50;
					++var14;
					if (var14 >= var37) {
						var12 = var10 + 23;
						var32 = var32 + var23 + var28;
						var14 = 0;
						++var16;
					}
				}

				if (var15) {
					var17 = var1.stringWidth(World.World_worlds[Login.hoveredWorldIndex].activity) + 6;
					int var18 = var1.ascent + 8;
					int var43 = MouseHandler.MouseHandler_y + 25;
					if (var18 + var43 > 480) {
						var43 = MouseHandler.MouseHandler_y - 25 - var18;
					}

					Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var17 / 2, var43, var17, var18, 16777120);
					Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var17 / 2, var43, var17, var18, 0);
					var1.drawCentered(World.World_worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var43 + var1.ascent + 4, 0, -1);
				}
			}

			class42.rasterProvider.drawFull(0, 0);
			return;
		}

		WorldMapID.leftTitleSprite.drawAt(Login.xPadding, 0);
		class51.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
		FontName.logoSprite.drawAt(Login.xPadding + 382 - FontName.logoSprite.subWidth / 2, 18);
		if (Client.gameState == 0 || Client.gameState == 5) {
			byte var23 = 20;
			var0.drawCentered("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var23, 0xffffff, -1);
			int var24 = 253 - var23;
			Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 152, var24, 304, 34, 9179409);
			Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 151, var24 + 1, 302, 32, 0);
			Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150, var24 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
			Rasterizer2D.Rasterizer2D_fillRectangle(Login.Login_loadingPercent * 3 + (Login.loginBoxX + 180 - 150), var24 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
			var0.drawCentered(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var23, 0xffffff, -1);
		} else if (Client.gameState == 20) {
			class32.titleboxSprite.drawAt(Login.loginBoxX + 180 - class32.titleboxSprite.subWidth / 2, 271 - class32.titleboxSprite.subHeight / 2);
			short var44 = 201;
			var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var44, 16776960, 0);
			int var45 = var44 + 15;
			var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var45, 16776960, 0);
			var45 += 15;
			var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var45, 16776960, 0);
			var45 += 15;
			var45 += 7;
			if (Login.loginIndex != 4) {
				var0.draw("Login: ", Login.loginBoxX + 180 - 110, var45, 0xffffff, 0);
				short var46 = 200;
				String var25;
				if (!AbstractArchive.clientPreferences.hideUsername) {
					var25 = Login.Login_username;
				} else {
					String var8 = Login.Login_username;
					int var10 = var8.length();
					char[] var11 = new char[var10];

					for (int var12 = 0; var12 < var10; ++var12) {
						var11[var12] = '*';
					}

					String var9 = new String(var11);
					var25 = var9;
				}

				for (var25 = var25; var0.stringWidth(var25) > var46; var25 = var25.substring(0, var25.length() - 1)) {
				}

				var0.draw(AbstractFont.escapeBrackets(var25), Login.loginBoxX + 180 - 70, var45, 0xffffff, 0);
				var45 += 15;
				String var8 = "Password: ";
				String var27 = Login.Login_password;
				int var12 = var27.length();
				char[] var13 = new char[var12];

				for (int var14 = 0; var14 < var12; ++var14) {
					var13[var14] = '*';
				}

				String var40 = new String(var13);
				var0.draw(var8 + var40, Login.loginBoxX + 180 - 108, var45, 0xffffff, 0);
				var45 += 15;
			}
		} else if (Client.gameState == 10 || Client.gameState == 11) {
			class32.titleboxSprite.drawAt(Login.loginBoxX, 171);
			if (Login.loginIndex == 0) {
				short var44 = 251;
				var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var44, 16776960, 0);
				int var45 = var44 + 30;
				int var24 = Login.loginBoxX + 180 - 80;
				short var5 = 291;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
				var0.drawLines("New User", var24 - 73, var5 - 20, 144, 40, 0xffffff, 0, 1, 1, 0);
				var24 = Login.loginBoxX + 180 + 80;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
				var0.drawLines("Existing User", var24 - 73, var5 - 20, 144, 40, 0xffffff, 0, 1, 1, 0);
			} else if (Login.loginIndex == 1) {
				var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
				short var44 = 236;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var44, 0xffffff, 0);
				int var45 = var44 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var45, 0xffffff, 0);
				var45 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var45, 0xffffff, 0);
				var45 += 15;
				int var24 = Login.loginBoxX + 180 - 80;
				short var5 = 321;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
				var0.drawCentered("Continue", var24, var5 + 5, 0xffffff, 0);
				var24 = Login.loginBoxX + 180 + 80;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
				var0.drawCentered("Cancel", var24, var5 + 5, 0xffffff, 0);
			} else if (Login.loginIndex == 2) {
				short var44 = 201;
				var0.drawCentered(Login.Login_response1, GrandExchangeOfferUnitPriceComparator.loginBoxCenter, var44, 16776960, 0);
				int var45 = var44 + 15;
				var0.drawCentered(Login.Login_response2, GrandExchangeOfferUnitPriceComparator.loginBoxCenter, var45, 16776960, 0);
				var45 += 15;
				var0.drawCentered(Login.Login_response3, GrandExchangeOfferUnitPriceComparator.loginBoxCenter, var45, 16776960, 0);
				var45 += 15;
				var45 += 7;
				var0.draw("Login: ", GrandExchangeOfferUnitPriceComparator.loginBoxCenter - 110, var45, 0xffffff, 0);
				short var46 = 200;
				String var25;
				if (!AbstractArchive.clientPreferences.hideUsername) {
					var25 = Login.Login_username;
				} else {
					String var8 = Login.Login_username;
					int var10 = var8.length();
					char[] var11 = new char[var10];

					for (int var12 = 0; var12 < var10; ++var12) {
						var11[var12] = '*';
					}

					String var9 = new String(var11);
					var25 = var9;
				}

				for (var25 = var25; var0.stringWidth(var25) > var46; var25 = var25.substring(1)) {
				}

				var0.draw(AbstractFont.escapeBrackets(var25) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? World.colorStartTag(16776960) + "|" : ""), GrandExchangeOfferUnitPriceComparator.loginBoxCenter - 70, var45, 0xffffff, 0);
				var45 += 15;
				String var8 = "Password: ";
				String var27 = Login.Login_password;
				int var12 = var27.length();
				char[] var13 = new char[var12];

				for (int var14 = 0; var14 < var12; ++var14) {
					var13[var14] = '*';
				}

				String var40 = new String(var13);
				var0.draw(var8 + var40 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? World.colorStartTag(16776960) + "|" : ""), GrandExchangeOfferUnitPriceComparator.loginBoxCenter - 108, var45, 0xffffff, 0);
				var45 += 15;
				var44 = 277;
				int var31 = GrandExchangeOfferUnitPriceComparator.loginBoxCenter + -117;
				IndexedSprite var34 = ClientPacket.method3578(Client.Login_isUsernameRemembered, Login.field1176);
				var34.drawAt(var31, var44);
				var31 = var31 + var34.subWidth + 5;
				var1.draw("Remember username", var31, var44 + 13, 16776960, 0);
				var31 = GrandExchangeOfferUnitPriceComparator.loginBoxCenter + 24;
				var34 = ClientPacket.method3578(AbstractArchive.clientPreferences.hideUsername, Login.field1192);
				var34.drawAt(var31, var44);
				var31 = var31 + var34.subWidth + 5;
				var1.draw("Hide username", var31, var44 + 13, 16776960, 0);
				var45 = var44 + 15;
				int var32 = GrandExchangeOfferUnitPriceComparator.loginBoxCenter - 80;
				short var42 = 321;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var32 - 73, var42 - 20);
				var0.drawCentered("Login", var32, var42 + 5, 0xffffff, 0);
				var32 = GrandExchangeOfferUnitPriceComparator.loginBoxCenter + 80;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var32 - 73, var42 - 20);
				var0.drawCentered("Cancel", var32, var42 + 5, 0xffffff, 0);
				var44 = 357;
				switch(Login.field1171) {
				case 2:
					class3.field18 = "Having trouble logging in?";
					break;
				default:
					class3.field18 = "Can't login? Click here.";
				}

				LoginScreenAnimation.field1032 = new Bounds(GrandExchangeOfferUnitPriceComparator.loginBoxCenter, var44, var1.stringWidth(class3.field18), 11);
				class162.field1988 = new Bounds(GrandExchangeOfferUnitPriceComparator.loginBoxCenter, var44, var1.stringWidth("Still having trouble logging in?"), 11);
				var1.drawCentered(class3.field18, GrandExchangeOfferUnitPriceComparator.loginBoxCenter, var44, 0xffffff, 0);
			} else if (Login.loginIndex == 3) {
				short var44 = 201;
				var0.drawCentered("Invalid credentials.", Login.loginBoxX + 180, var44, 16776960, 0);
				int var45 = var44 + 20;
				var1.drawCentered("For accounts created after 24th November 2010, please use your", Login.loginBoxX + 180, var45, 16776960, 0);
				var45 += 15;
				var1.drawCentered("email address to login. Otherwise please login with your username.", Login.loginBoxX + 180, var45, 16776960, 0);
				var45 += 15;
				int var24 = Login.loginBoxX + 180;
				short var5 = 276;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
				var2.drawCentered("Try again", var24, var5 + 5, 0xffffff, 0);
				var24 = Login.loginBoxX + 180;
				var5 = 326;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
				var2.drawCentered("Forgotten password?", var24, var5 + 5, 0xffffff, 0);
			} else if (Login.loginIndex == 4) {
				var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
				short var44 = 236;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var44, 0xffffff, 0);
				int var45 = var44 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var45, 0xffffff, 0);
				var45 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var45, 0xffffff, 0);
				var45 += 15;
				String var26 = "PIN: ";
				String var7 = DesktopPlatformInfoProvider.otp;
				int var30 = var7.length();
				char[] var47 = new char[var30];

				for (int var31 = 0; var31 < var30; ++var31) {
					var47[var31] = '*';
				}

				String var8 = new String(var47);
				var0.draw(var26 + var8 + (Client.cycle % 40 < 20 ? World.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var45, 0xffffff, 0);
				var45 -= 8;
				var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var45, 16776960, 0);
				var45 += 15;
				var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var45, 16776960, 0);
				int var29 = Login.loginBoxX + 180 - 9 + var0.stringWidth("for 30 days: ") + 15;
				var30 = var45 - var0.ascent;
				IndexedSprite var48;
				if (Login.field1183) {
					var48 = class42.options_buttons_2Sprite;
				} else {
					var48 = class195.options_buttons_0Sprite;
				}

				var48.drawAt(var29, var30);
				var45 += 15;
				int var31 = Login.loginBoxX + 180 - 80;
				short var41 = 321;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var31 - 73, var41 - 20);
				var0.drawCentered("Continue", var31, var41 + 5, 0xffffff, 0);
				var31 = Login.loginBoxX + 180 + 80;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var31 - 73, var41 - 20);
				var0.drawCentered("Cancel", var31, var41 + 5, 0xffffff, 0);
				var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var41 + 36, 255, 0);
			} else if (Login.loginIndex == 5) {
				var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
				short var44 = 221;
				var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var44, 16776960, 0);
				int var45 = var44 + 15;
				var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var45, 16776960, 0);
				var45 += 15;
				var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var45, 16776960, 0);
				var45 += 15;
				var45 += 14;
				var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var45, 0xffffff, 0);
				short var46 = 174;
				String var25;
				if (!AbstractArchive.clientPreferences.hideUsername) {
					var25 = Login.Login_username;
				} else {
					String var8 = Login.Login_username;
					int var10 = var8.length();
					char[] var11 = new char[var10];

					for (int var12 = 0; var12 < var10; ++var12) {
						var11[var12] = '*';
					}

					String var9 = new String(var11);
					var25 = var9;
				}

				for (var25 = var25; var0.stringWidth(var25) > var46; var25 = var25.substring(1)) {
				}

				var0.draw(AbstractFont.escapeBrackets(var25) + (Client.cycle % 40 < 20 ? World.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var45, 0xffffff, 0);
				var45 += 15;
				int var28 = Login.loginBoxX + 180 - 80;
				short var49 = 321;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var28 - 73, var49 - 20);
				var0.drawCentered("Recover", var28, var49 + 5, 0xffffff, 0);
				var28 = Login.loginBoxX + 180 + 80;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var28 - 73, var49 - 20);
				var0.drawCentered("Back", var28, var49 + 5, 0xffffff, 0);
				var49 = 356;
				var1.drawCentered("Still having trouble logging in?", GrandExchangeOfferUnitPriceComparator.loginBoxCenter, var49, 268435455, 0);
			} else if (Login.loginIndex == 6) {
				short var44 = 201;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var44, 16776960, 0);
				int var45 = var44 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var45, 16776960, 0);
				var45 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var45, 16776960, 0);
				var45 += 15;
				int var24 = Login.loginBoxX + 180;
				short var5 = 321;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
				var0.drawCentered("Back", var24, var5 + 5, 0xffffff, 0);
			} else if (Login.loginIndex == 7) {
				short var44 = 216;
				var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var44, 16776960, 0);
				int var45 = var44 + 15;
				var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var45, 16776960, 0);
				var45 += 15;
				var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var45, 16776960, 0);
				var45 += 15;
				int var24 = Login.loginBoxX + 180 - 80;
				short var5 = 321;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
				var0.drawCentered("Set Date of Birth", var24, var5 + 5, 0xffffff, 0);
				var24 = Login.loginBoxX + 180 + 80;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
				var0.drawCentered("Back", var24, var5 + 5, 0xffffff, 0);
			} else if (Login.loginIndex == 8) {
				short var44 = 216;
				var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var44, 16776960, 0);
				int var45 = var44 + 15;
				var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var45, 16776960, 0);
				var45 += 15;
				var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var45, 16776960, 0);
				var45 += 15;
				int var24 = Login.loginBoxX + 180 - 80;
				short var5 = 321;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
				var0.drawCentered("Privacy Policy", var24, var5 + 5, 0xffffff, 0);
				var24 = Login.loginBoxX + 180 + 80;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
				var0.drawCentered("Back", var24, var5 + 5, 0xffffff, 0);
			} else if (Login.loginIndex == 12) {
				short var44 = 201;
				String var4 = "";
				String var26 = "";
				String var25 = "";
				switch (Login.field1174) {
					case 0:
						var4 = "Your account has been disabled.";
						var26 = Strings.field2793;
						var25 = "";
						break;
					case 1:
						var4 = "Account locked as we suspect it has been stolen.";
						var26 = Strings.field2783;
						var25 = "";
						break;
					default:
						TilePaint.Login_promptCredentials(false);
				}

				var0.drawCentered(var4, Login.loginBoxX + 180, var44, 16776960, 0);
				int var45 = var44 + 15;
				var2.drawCentered(var26, Login.loginBoxX + 180, var45, 16776960, 0);
				var45 += 15;
				var2.drawCentered(var25, Login.loginBoxX + 180, var45, 16776960, 0);
				var45 += 15;
				int var28 = Login.loginBoxX + 180;
				short var49 = 276;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var28 - 73, var49 - 20);
				var0.drawCentered("Support Page", var28, var49 + 5, 0xffffff, 0);
				var28 = Login.loginBoxX + 180;
				var49 = 326;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var28 - 73, var49 - 20);
				var0.drawCentered("Back", var28, var49 + 5, 0xffffff, 0);
			} else if (Login.loginIndex == 24) {
				short var44 = 221;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var44, 0xffffff, 0);
				int var45 = var44 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var45, 0xffffff, 0);
				var45 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var45, 0xffffff, 0);
				var45 += 15;
				int var24 = Login.loginBoxX + 180;
				short var5 = 301;
				AbstractRasterProvider.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
				var0.drawCentered("Ok", var24, var5 + 5, 0xffffff, 0);
			}
		}

		if (Client.gameState >= 10) {
			int[] var3 = new int[4];
			Rasterizer2D.Rasterizer2D_getClipArray(var3);
			Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, WallDecoration.canvasHeight);
			BufferedSink.loginScreenRunesAnimation.draw(Login.xPadding - 22, Client.cycle);
			BufferedSink.loginScreenRunesAnimation.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
			Rasterizer2D.Rasterizer2D_setClipArray(var3);
		}

		UserComparator7.title_muteSprite[AbstractArchive.clientPreferences.titleMusicDisabled ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
		if (Client.gameState > 5 && Language.Language_EN == WorldMapLabelSize.clientLanguage) {
			if (Skeleton.field1767 == null) {
				Skeleton.field1767 = WorldMapRectangle.SpriteBuffer_getIndexedSpriteByName(GrandExchangeOfferAgeComparator.archive8, "sl_button", "");
			} else {
				int var45 = Login.xPadding + 5;
				short var46 = 463;
				byte var38 = 100;
				byte var6 = 35;
				Skeleton.field1767.drawAt(var45, var46);
				var0.drawCentered("World" + " " + Client.worldId, var38 / 2 + var45, var6 / 2 + var46 - 2, 0xffffff, 0);
				if (class51.World_request != null) {
					var1.drawCentered("Loading...", var38 / 2 + var45, var6 / 2 + var46 + 12, 0xffffff, 0);
				} else {
					var1.drawCentered("Click to switch", var38 / 2 + var45, var6 / 2 + var46 + 12, 0xffffff, 0);
				}
			}
		}

	}
}
