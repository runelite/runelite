import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bn")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
	@ObfuscatedName("x")
	@Export("isRunning")
	boolean isRunning;
	@ObfuscatedName("m")
	@Export("lock")
	Object lock;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1833503611
	)
	@Export("index")
	int index;
	@ObfuscatedName("d")
	@Export("xs")
	int[] xs;
	@ObfuscatedName("w")
	@Export("ys")
	int[] ys;
	@ObfuscatedName("v")
	@Export("millis")
	long[] millis;

	MouseRecorder() {
		this.isRunning = true;
		this.lock = new Object();
		this.index = 0;
		this.xs = new int[500];
		this.ys = new int[500];
		this.millis = new long[500];
	}

	public void run() {
		for (; this.isRunning; class169.method3541(50L)) {
			synchronized(this.lock) {
				if (this.index < 500) {
					this.xs[this.index] = MouseHandler.MouseHandler_x;
					this.ys[this.index] = MouseHandler.MouseHandler_y;
					this.millis[this.index] = MouseHandler.MouseHandler_millis;
					++this.index;
				}
			}
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lkx;Lkx;Lkx;I)V",
		garbageValue = "684092055"
	)
	@Export("drawTitle")
	static void drawTitle(Font var0, Font var1, Font var2) {
		Login.xPadding = (WorldMapLabel.canvasWidth - 765) / 2;
		Login.loginBoxX = Login.xPadding + 202;
		PacketWriter.loginBoxCenter = Login.loginBoxX + 180;
		int var6;
		int var8;
		int var9;
		int var11;
		boolean var15;
		int var17;
		byte var23;
		int var24;
		int var47;
		int var49;
		if (Login.worldSelectOpen) {
			if (class69.worldSelectBackSprites == null) {
				class69.worldSelectBackSprites = FloorUnderlayDefinition.method4507(class228.archive8, "sl_back", "");
			}

			Archive var33;
			int var36;
			IndexedSprite[] var37;
			if (GrandExchangeEvent.worldSelectFlagSprites == null) {
				var33 = class228.archive8;
				var36 = var33.getGroupId("sl_flags");
				var6 = var33.getFileId(var36, "");
				if (!UserComparator7.method3516(var33, var36, var6)) {
					var37 = null;
				} else {
					var37 = Skills.method4214();
				}

				GrandExchangeEvent.worldSelectFlagSprites = var37;
			}

			if (WorldMapDecoration.worldSelectArrows == null) {
				var33 = class228.archive8;
				var36 = var33.getGroupId("sl_arrows");
				var6 = var33.getFileId(var36, "");
				if (!UserComparator7.method3516(var33, var36, var6)) {
					var37 = null;
				} else {
					var37 = Skills.method4214();
				}

				WorldMapDecoration.worldSelectArrows = var37;
			}

			if (class348.worldSelectStars == null) {
				var33 = class228.archive8;
				var36 = var33.getGroupId("sl_stars");
				var6 = var33.getFileId(var36, "");
				if (!UserComparator7.method3516(var33, var36, var6)) {
					var37 = null;
				} else {
					var37 = Skills.method4214();
				}

				class348.worldSelectStars = var37;
			}

			if (class92.worldSelectLeftSprite == null) {
				class92.worldSelectLeftSprite = class7.SpriteBuffer_getIndexedSpriteByName(class228.archive8, "leftarrow", "");
			}

			if (StructDefinition.worldSelectRightSprite == null) {
				StructDefinition.worldSelectRightSprite = class7.SpriteBuffer_getIndexedSpriteByName(class228.archive8, "rightarrow", "");
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
			var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
			if (class348.worldSelectStars != null) {
				class348.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
				var1.draw("Members only world", Login.xPadding + 152, 10, 16777215, -1);
				class348.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
				var1.draw("Free world", Login.xPadding + 152, 21, 16777215, -1);
			}

			if (WorldMapDecoration.worldSelectArrows != null) {
				var47 = Login.xPadding + 280;
				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 0) {
					WorldMapDecoration.worldSelectArrows[2].drawAt(var47, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[0].drawAt(var47, 4);
				}

				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 1) {
					WorldMapDecoration.worldSelectArrows[3].drawAt(var47 + 15, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[1].drawAt(var47 + 15, 4);
				}

				var0.draw("World", var47 + 32, 17, 16777215, -1);
				var24 = Login.xPadding + 390;
				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 0) {
					WorldMapDecoration.worldSelectArrows[2].drawAt(var24, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[0].drawAt(var24, 4);
				}

				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 1) {
					WorldMapDecoration.worldSelectArrows[3].drawAt(var24 + 15, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[1].drawAt(var24 + 15, 4);
				}

				var0.draw("Players", var24 + 32, 17, 16777215, -1);
				var36 = Login.xPadding + 500;
				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 0) {
					WorldMapDecoration.worldSelectArrows[2].drawAt(var36, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[0].drawAt(var36, 4);
				}

				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 1) {
					WorldMapDecoration.worldSelectArrows[3].drawAt(var36 + 15, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[1].drawAt(var36 + 15, 4);
				}

				var0.draw("Location", var36 + 32, 17, 16777215, -1);
				var6 = Login.xPadding + 610;
				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 0) {
					WorldMapDecoration.worldSelectArrows[2].drawAt(var6, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[0].drawAt(var6, 4);
				}

				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 1) {
					WorldMapDecoration.worldSelectArrows[3].drawAt(var6 + 15, 4);
				} else {
					WorldMapDecoration.worldSelectArrows[1].drawAt(var6 + 15, 4);
				}

				var0.draw("Type", var6 + 32, 17, 16777215, -1);
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
			var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
			Login.hoveredWorldIndex = -1;
			if (class69.worldSelectBackSprites != null) {
				var23 = 88;
				byte var50 = 19;
				var36 = 765 / (var23 + 1) - 1;
				var6 = 480 / (var50 + 1);

				do {
					var49 = var6;
					var8 = var36;
					if (var6 * (var36 - 1) >= World.World_count) {
						--var36;
					}

					if (var36 * (var6 - 1) >= World.World_count) {
						--var6;
					}

					if (var36 * (var6 - 1) >= World.World_count) {
						--var6;
					}
				} while(var6 != var49 || var36 != var8);

				var49 = (765 - var36 * var23) / (var36 + 1);
				if (var49 > 5) {
					var49 = 5;
				}

				var8 = (480 - var50 * var6) / (var6 + 1);
				if (var8 > 5) {
					var8 = 5;
				}

				var9 = (765 - var36 * var23 - var49 * (var36 - 1)) / 2;
				int var29 = (480 - var6 * var50 - var8 * (var6 - 1)) / 2;
				var11 = (var6 + World.World_count - 1) / var6;
				Login.worldSelectPagesCount = var11 - var36;
				if (class92.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
					class92.worldSelectLeftSprite.drawAt(8, Varps.canvasHeight / 2 - class92.worldSelectLeftSprite.subHeight / 2);
				}

				if (StructDefinition.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
					StructDefinition.worldSelectRightSprite.drawAt(WorldMapLabel.canvasWidth - StructDefinition.worldSelectRightSprite.subWidth - 8, Varps.canvasHeight / 2 - StructDefinition.worldSelectRightSprite.subHeight / 2);
				}

				int var42 = var29 + 23;
				int var13 = var9 + Login.xPadding;
				int var14 = 0;
				var15 = false;
				int var43 = Login.worldSelectPage;

				for (var17 = var43 * var6; var17 < World.World_count && var43 - Login.worldSelectPage < var36; ++var17) {
					World var30 = UserComparator2.World_worlds[var17];
					boolean var19 = true;
					String var20 = Integer.toString(var30.population);
					if (var30.population == -1) {
						var20 = "OFF";
						var19 = false;
					} else if (var30.population > 1980) {
						var20 = "FULL";
						var19 = false;
					}

					int var22 = 0;
					byte var21;
					if (var30.isBeta()) {
						if (var30.isMembersOnly()) {
							var21 = 7;
						} else {
							var21 = 6;
						}
					} else if (var30.isDeadman()) {
						var22 = 16711680;
						if (var30.isMembersOnly()) {
							var21 = 5;
						} else {
							var21 = 4;
						}
					} else if (var30.method1879()) {
						if (var30.isMembersOnly()) {
							var21 = 9;
						} else {
							var21 = 8;
						}
					} else if (var30.isPvp()) {
						if (var30.isMembersOnly()) {
							var21 = 3;
						} else {
							var21 = 2;
						}
					} else if (var30.isMembersOnly()) {
						var21 = 1;
					} else {
						var21 = 0;
					}

					if (MouseHandler.MouseHandler_x >= var13 && MouseHandler.MouseHandler_y >= var42 && MouseHandler.MouseHandler_x < var23 + var13 && MouseHandler.MouseHandler_y < var50 + var42 && var19) {
						Login.hoveredWorldIndex = var17;
						class69.worldSelectBackSprites[var21].drawTransOverlayAt(var13, var42, 128, 16777215);
						var15 = true;
					} else {
						class69.worldSelectBackSprites[var21].drawAt(var13, var42);
					}

					if (GrandExchangeEvent.worldSelectFlagSprites != null) {
						GrandExchangeEvent.worldSelectFlagSprites[(var30.isMembersOnly() ? 8 : 0) + var30.location].drawAt(var13 + 29, var42);
					}

					var0.drawCentered(Integer.toString(var30.id), var13 + 15, var50 / 2 + var42 + 5, var22, -1);
					var1.drawCentered(var20, var13 + 60, var50 / 2 + var42 + 5, 268435455, -1);
					var42 = var42 + var8 + var50;
					++var14;
					if (var14 >= var6) {
						var42 = var29 + 23;
						var13 = var13 + var49 + var23;
						var14 = 0;
						++var43;
					}
				}

				if (var15) {
					var17 = var1.stringWidth(UserComparator2.World_worlds[Login.hoveredWorldIndex].activity) + 6;
					int var44 = var1.ascent + 8;
					int var45 = MouseHandler.MouseHandler_y + 25;
					if (var45 + var44 > 480) {
						var45 = MouseHandler.MouseHandler_y - 25 - var44;
					}

					Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var17 / 2, var45, var17, var44, 16777120);
					Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var17 / 2, var45, var17, var44, 0);
					var1.drawCentered(UserComparator2.World_worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var45 + var1.ascent + 4, 0, -1);
				}
			}

			class206.rasterProvider.drawFull(0, 0);
		} else {
			Login.leftTitleSprite.drawAt(Login.xPadding, 0);
			DirectByteArrayCopier.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			class3.logoSprite.drawAt(Login.xPadding + 382 - class3.logoSprite.subWidth / 2, 18);
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

			String var7;
			char[] var10;
			String var25;
			String var27;
			short var46;
			short var48;
			if (Client.gameState == 20) {
				ModelData0.titleboxSprite.drawAt(Login.loginBoxX + 180 - ModelData0.titleboxSprite.subWidth / 2, 271 - ModelData0.titleboxSprite.subHeight / 2);
				var46 = 201;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var46, 16776960, 0);
				var47 = var46 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var47, 16776960, 0);
				var47 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var47, 16776960, 0);
				var47 += 15;
				var47 += 7;
				if (Login.loginIndex != 4) {
					var0.draw("Login: ", Login.loginBoxX + 180 - 110, var47, 16777215, 0);
					var48 = 200;

					for (var25 = ClanChat.method5318(); var0.stringWidth(var25) > var48; var25 = var25.substring(0, var25.length() - 1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var25), Login.loginBoxX + 180 - 70, var47, 16777215, 0);
					var47 += 15;
					var7 = Login.Login_password;
					var9 = var7.length();
					var10 = new char[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						var10[var11] = '*';
					}

					var27 = new String(var10);

					for (var27 = var27; var0.stringWidth(var27) > var48; var27 = var27.substring(1)) {
					}

					var0.draw("Password: " + var27, Login.loginBoxX + 180 - 108, var47, 16777215, 0);
					var47 += 15;
				}
			}

			if (Client.gameState == 10 || Client.gameState == 11) {
				ModelData0.titleboxSprite.drawAt(Login.loginBoxX, 171);
				short var5;
				if (Login.loginIndex == 0) {
					var46 = 251;
					var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var46, 16776960, 0);
					var47 = var46 + 30;
					var24 = Login.loginBoxX + 180 - 80;
					var5 = 291;
					GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawLines("New User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
					var24 = Login.loginBoxX + 180 + 80;
					GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawLines("Existing User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				} else if (Login.loginIndex == 1) {
					var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
					var46 = 236;
					var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var46, 16777215, 0);
					var47 = var46 + 15;
					var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var47, 16777215, 0);
					var47 += 15;
					var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var47, 16777215, 0);
					var47 += 15;
					var24 = Login.loginBoxX + 180 - 80;
					var5 = 321;
					GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawCentered("Continue", var24, var5 + 5, 16777215, 0);
					var24 = Login.loginBoxX + 180 + 80;
					GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawCentered("Cancel", var24, var5 + 5, 16777215, 0);
				} else {
					IndexedSprite var39;
					if (Login.loginIndex == 2) {
						var46 = 201;
						var0.drawCentered(Login.Login_response1, PacketWriter.loginBoxCenter, var46, 16776960, 0);
						var47 = var46 + 15;
						var0.drawCentered(Login.Login_response2, PacketWriter.loginBoxCenter, var47, 16776960, 0);
						var47 += 15;
						var0.drawCentered(Login.Login_response3, PacketWriter.loginBoxCenter, var47, 16776960, 0);
						var47 += 15;
						var47 += 7;
						var0.draw("Login: ", PacketWriter.loginBoxCenter - 110, var47, 16777215, 0);
						var48 = 200;

						for (var25 = ClanChat.method5318(); var0.stringWidth(var25) > var48; var25 = var25.substring(1)) {
						}

						var0.draw(AbstractFont.escapeBrackets(var25) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? class297.colorStartTag(16776960) + "|" : ""), PacketWriter.loginBoxCenter - 70, var47, 16777215, 0);
						var47 += 15;
						var7 = Login.Login_password;
						var9 = var7.length();
						var10 = new char[var9];

						for (var11 = 0; var11 < var9; ++var11) {
							var10[var11] = '*';
						}

						var27 = new String(var10);

						for (var27 = var27; var0.stringWidth(var27) > var48; var27 = var27.substring(1)) {
						}

						var0.draw("Password: " + var27 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? class297.colorStartTag(16776960) + "|" : ""), PacketWriter.loginBoxCenter - 108, var47, 16777215, 0);
						var47 += 15;
						var46 = 277;
						var9 = PacketWriter.loginBoxCenter + -117;
						boolean var40 = Client.Login_isUsernameRemembered;
						boolean var12 = Login.field1207;
						var39 = var40 ? (var12 ? Login.field1195 : Login.options_buttons_2Sprite) : (var12 ? WorldMapLabelSize.field160 : class4.options_buttons_0Sprite);
						var39.drawAt(var9, var46);
						var9 = var9 + var39.subWidth + 5;
						var1.draw("Remember username", var9, var46 + 13, 16776960, 0);
						var9 = PacketWriter.loginBoxCenter + 24;
						var15 = GrandExchangeOfferOwnWorldComparator.clientPreferences.hideUsername;
						boolean var16 = Login.field1212;
						IndexedSprite var32 = var15 ? (var16 ? Login.field1195 : Login.options_buttons_2Sprite) : (var16 ? WorldMapLabelSize.field160 : class4.options_buttons_0Sprite);
						var32.drawAt(var9, var46);
						var9 = var9 + var32.subWidth + 5;
						var1.draw("Hide username", var9, var46 + 13, 16776960, 0);
						var47 = var46 + 15;
						var17 = PacketWriter.loginBoxCenter - 80;
						short var18 = 321;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var17 - 73, var18 - 20);
						var0.drawCentered("Login", var17, var18 + 5, 16777215, 0);
						var17 = PacketWriter.loginBoxCenter + 80;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var17 - 73, var18 - 20);
						var0.drawCentered("Cancel", var17, var18 + 5, 16777215, 0);
						var46 = 357;
						switch(Login.field1218) {
						case 2:
							Message.field633 = "Having trouble logging in?";
							break;
						default:
							Message.field633 = "Can't login? Click here.";
						}

						class41.field315 = new Bounds(PacketWriter.loginBoxCenter, var46, var1.stringWidth(Message.field633), 11);
						MusicPatchPcmStream.field2495 = new Bounds(PacketWriter.loginBoxCenter, var46, var1.stringWidth("Still having trouble logging in?"), 11);
						var1.drawCentered(Message.field633, PacketWriter.loginBoxCenter, var46, 16777215, 0);
					} else if (Login.loginIndex == 3) {
						var46 = 201;
						var0.drawCentered("Invalid credentials.", Login.loginBoxX + 180, var46, 16776960, 0);
						var47 = var46 + 20;
						var1.drawCentered("For accounts created after 24th November 2010, please use your", Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var1.drawCentered("email address to login. Otherwise please login with your username.", Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var24 = Login.loginBoxX + 180;
						var5 = 276;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var2.drawCentered("Try again", var24, var5 + 5, 16777215, 0);
						var24 = Login.loginBoxX + 180;
						var5 = 326;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var2.drawCentered("Forgotten password?", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 4) {
						var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
						var46 = 236;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var46, 16777215, 0);
						var47 = var46 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var47, 16777215, 0);
						var47 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var47, 16777215, 0);
						var47 += 15;
						var25 = "PIN: ";
						var7 = MilliClock.otp;
						var9 = var7.length();
						var10 = new char[var9];

						for (var11 = 0; var11 < var9; ++var11) {
							var10[var11] = '*';
						}

						var27 = new String(var10);
						var0.draw(var25 + var27 + (Client.cycle % 40 < 20 ? class297.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var47, 16777215, 0);
						var47 -= 8;
						var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var47, 16776960, 0);
						var47 += 15;
						var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var47, 16776960, 0);
						var8 = 180 + Login.loginBoxX - 9 + var0.stringWidth("for 30 days: ") + 15;
						var9 = var47 - var0.ascent;
						if (Login.field1214) {
							var39 = Login.options_buttons_2Sprite;
						} else {
							var39 = class4.options_buttons_0Sprite;
						}

						var39.drawAt(var8, var9);
						var47 += 15;
						var11 = Login.loginBoxX + 180 - 80;
						short var41 = 321;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var11 - 73, var41 - 20);
						var0.drawCentered("Continue", var11, var41 + 5, 16777215, 0);
						var11 = Login.loginBoxX + 180 + 80;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var11 - 73, var41 - 20);
						var0.drawCentered("Cancel", var11, var41 + 5, 16777215, 0);
						var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var41 + 36, 255, 0);
					} else if (Login.loginIndex == 5) {
						var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
						var46 = 221;
						var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var46, 16776960, 0);
						var47 = var46 + 15;
						var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var47 += 14;
						var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var47, 16777215, 0);
						var48 = 174;

						for (var25 = ClanChat.method5318(); var0.stringWidth(var25) > var48; var25 = var25.substring(1)) {
						}

						var0.draw(AbstractFont.escapeBrackets(var25) + (Client.cycle % 40 < 20 ? class297.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var47, 16777215, 0);
						var47 += 15;
						var6 = Login.loginBoxX + 180 - 80;
						short var26 = 321;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var6 - 73, var26 - 20);
						var0.drawCentered("Recover", var6, var26 + 5, 16777215, 0);
						var6 = Login.loginBoxX + 180 + 80;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var6 - 73, var26 - 20);
						var0.drawCentered("Back", var6, var26 + 5, 16777215, 0);
						var26 = 356;
						var1.drawCentered("Still having trouble logging in?", PacketWriter.loginBoxCenter, var26, 268435455, 0);
					} else if (Login.loginIndex == 6) {
						var46 = 201;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var46, 16776960, 0);
						var47 = var46 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var24 = Login.loginBoxX + 180;
						var5 = 321;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 7) {
						var46 = 216;
						var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var46, 16776960, 0);
						var47 = var46 + 15;
						var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var24 = Login.loginBoxX + 180 - 80;
						var5 = 321;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Set Date of Birth", var24, var5 + 5, 16777215, 0);
						var24 = Login.loginBoxX + 180 + 80;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 8) {
						var46 = 216;
						var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var46, 16776960, 0);
						var47 = var46 + 15;
						var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var24 = Login.loginBoxX + 180 - 80;
						var5 = 321;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Privacy Policy", var24, var5 + 5, 16777215, 0);
						var24 = Login.loginBoxX + 180 + 80;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 12) {
						var46 = 201;
						String var4 = "";
						var25 = "";
						String var28 = "";
						switch(Login.field1201) {
						case 0:
							var4 = "Your account has been disabled.";
							var25 = Strings.field2811;
							var28 = "";
							break;
						case 1:
							var4 = "Account locked as we suspect it has been stolen.";
							var25 = Strings.field2914;
							var28 = "";
							break;
						default:
							ObjectDefinition.Login_promptCredentials(false);
						}

						var0.drawCentered(var4, Login.loginBoxX + 180, var46, 16776960, 0);
						var47 = var46 + 15;
						var2.drawCentered(var25, Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var2.drawCentered(var28, Login.loginBoxX + 180, var47, 16776960, 0);
						var47 += 15;
						var49 = Login.loginBoxX + 180;
						short var38 = 276;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var49 - 73, var38 - 20);
						var0.drawCentered("Support Page", var49, var38 + 5, 16777215, 0);
						var49 = Login.loginBoxX + 180;
						var38 = 326;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var49 - 73, var38 - 20);
						var0.drawCentered("Back", var49, var38 + 5, 16777215, 0);
					} else if (Login.loginIndex == 24) {
						var46 = 221;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var46, 16777215, 0);
						var47 = var46 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var47, 16777215, 0);
						var47 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var47, 16777215, 0);
						var47 += 15;
						var24 = Login.loginBoxX + 180;
						var5 = 301;
						GrandExchangeOfferOwnWorldComparator.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Ok", var24, var5 + 5, 16777215, 0);
					}
				}
			}

			if (Client.gameState >= 10) {
				int[] var3 = new int[4];
				Rasterizer2D.Rasterizer2D_getClipArray(var3);
				Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, Varps.canvasHeight);
				MilliClock.loginScreenRunesAnimation.draw(Login.xPadding - 22, Client.cycle);
				MilliClock.loginScreenRunesAnimation.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
				Rasterizer2D.Rasterizer2D_setClipArray(var3);
			}

			ArchiveDisk.title_muteSprite[GrandExchangeOfferOwnWorldComparator.clientPreferences.titleMusicDisabled ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
			if (Client.gameState > 5 && Language.Language_EN == IgnoreList.clientLanguage) {
				if (ItemContainer.field572 != null) {
					var47 = Login.xPadding + 5;
					var48 = 463;
					byte var35 = 100;
					byte var34 = 35;
					ItemContainer.field572.drawAt(var47, var48);
					var0.drawCentered("World" + " " + Client.worldId, var35 / 2 + var47, var34 / 2 + var48 - 2, 16777215, 0);
					if (LoginPacket.World_request != null) {
						var1.drawCentered("Loading...", var35 / 2 + var47, var34 / 2 + var48 + 12, 16777215, 0);
					} else {
						var1.drawCentered("Click to switch", var35 / 2 + var47, var34 / 2 + var48 + 12, 16777215, 0);
					}
				} else {
					ItemContainer.field572 = class7.SpriteBuffer_getIndexedSpriteByName(class228.archive8, "sl_button", "");
				}
			}

		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1787965087"
	)
	static int method1290(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.VIEWPORT_SETFOV) {
			Interpreter.Interpreter_intStackSize -= 2;
			Client.field931 = (short)class278.method5039(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
			if (Client.field931 <= 0) {
				Client.field931 = 256;
			}

			Client.field932 = (short)class278.method5039(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			if (Client.field932 <= 0) {
				Client.field932 = 256;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_SETZOOM) {
			Interpreter.Interpreter_intStackSize -= 2;
			Client.zoomHeight = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			if (Client.zoomHeight <= 0) {
				Client.zoomHeight = 256;
			}

			Client.zoomWidth = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (Client.zoomWidth <= 0) {
				Client.zoomWidth = 320;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_CLAMPFOV) {
			Interpreter.Interpreter_intStackSize -= 4;
			Client.field935 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			if (Client.field935 <= 0) {
				Client.field935 = 1;
			}

			Client.field748 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (Client.field748 <= 0) {
				Client.field748 = 32767;
			} else if (Client.field748 < Client.field935) {
				Client.field748 = Client.field935;
			}

			Client.field937 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			if (Client.field937 <= 0) {
				Client.field937 = 1;
			}

			Client.field938 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			if (Client.field938 <= 0) {
				Client.field938 = 32767;
			} else if (Client.field938 < Client.field937) {
				Client.field938 = Client.field937;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETEFFECTIVESIZE) {
			if (Client.viewportWidget != null) {
				class204.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.viewportWidth;
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.viewportHeight;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETZOOM) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.zoomHeight;
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.zoomWidth;
			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETFOV) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Actor.method1860(Client.field931);
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Actor.method1860(Client.field932);
			return 1;
		} else if (var0 == 6220) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6221) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6222) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapLabel.canvasWidth;
			return 1;
		} else if (var0 == 6223) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Varps.canvasHeight;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ew")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1951274332"
	)
	@Export("updateGameState")
	static void updateGameState(int var0) {
		if (var0 != Client.gameState) {
			if (Client.gameState == 0) {
				WorldMapSection1.client.method1025();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45) {
				Client.loginState = 0;
				Client.field712 = 0;
				Client.field713 = 0;
				Client.timer.method5044(var0);
				if (var0 != 20) {
					GraphicsObject.method2122(false);
				}
			}

			if (var0 != 20 && var0 != 40 && UrlRequester.field1960 != null) {
				UrlRequester.field1960.close();
				UrlRequester.field1960 = null;
			}

			if (Client.gameState == 25) {
				Client.field899 = 0;
				Client.field818 = 0;
				Client.field921 = 1;
				Client.field734 = 0;
				Client.field735 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					class299.method5349(PlayerAppearance.archive10, class228.archive8, true, Client.gameState == 11 ? 4 : 0);
				} else if (var0 == 11) {
					class299.method5349(PlayerAppearance.archive10, class228.archive8, false, 4);
				} else {
					Calendar.method4032();
				}
			} else {
				class299.method5349(PlayerAppearance.archive10, class228.archive8, true, 0);
			}

			Client.gameState = var0;
		}
	}
}
