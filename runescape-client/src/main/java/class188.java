import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class188 {
	@ObfuscatedName("q")
	static int[] field2339;

	static {
		new Object();
		field2339 = new int[33];
		field2339[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field2339[var1] = var0 - 1;
			var0 += var0;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lke;Lke;B)V",
		garbageValue = "11"
	)
	static void method3643(Font var0, Font var1) {
		Archive var3;
		int var4;
		int var5;
		if (WorldMapID.worldSelectBackSprites == null) {
			var3 = Client.archive8;
			var4 = var3.getGroupId("sl_back");
			var5 = var3.getFileId(var4, "");
			Sprite[] var2 = TilePaint.method3062(var3, var4, var5);
			WorldMapID.worldSelectBackSprites = var2;
		}

		IndexedSprite[] var25;
		if (SecureRandomCallable.worldSelectFlagSprites == null) {
			var3 = Client.archive8;
			var4 = var3.getGroupId("sl_flags");
			var5 = var3.getFileId(var4, "");
			var25 = class289.method5281(var3, var4, var5);
			SecureRandomCallable.worldSelectFlagSprites = var25;
		}

		if (class225.worldSelectArrows == null) {
			var3 = Client.archive8;
			var4 = var3.getGroupId("sl_arrows");
			var5 = var3.getFileId(var4, "");
			var25 = class289.method5281(var3, var4, var5);
			class225.worldSelectArrows = var25;
		}

		if (FriendSystem.worldSelectStars == null) {
			var3 = Client.archive8;
			var4 = var3.getGroupId("sl_stars");
			var5 = var3.getFileId(var4, "");
			var25 = class289.method5281(var3, var4, var5);
			FriendSystem.worldSelectStars = var25;
		}

		if (Login.worldSelectLeftSprite == null) {
			Login.worldSelectLeftSprite = class215.loadIndexedSpriteByName(Client.archive8, "leftarrow", "");
		}

		if (NPCDefinition.worldSelectRightSprite == null) {
			NPCDefinition.worldSelectRightSprite = class215.loadIndexedSpriteByName(Client.archive8, "rightarrow", "");
		}

		Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
		Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
		Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
		var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
		if (FriendSystem.worldSelectStars != null) {
			FriendSystem.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
			var1.draw("Members only world", Login.xPadding + 152, 10, 16777215, -1);
			FriendSystem.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
			var1.draw("Free world", Login.xPadding + 152, 21, 16777215, -1);
		}

		if (class225.worldSelectArrows != null) {
			int var22 = Login.xPadding + 280;
			if (World.sortOption1[0] == 0 && World.sortOption2[0] == 0) {
				class225.worldSelectArrows[2].drawAt(var22, 4);
			} else {
				class225.worldSelectArrows[0].drawAt(var22, 4);
			}

			if (World.sortOption1[0] == 0 && World.sortOption2[0] == 1) {
				class225.worldSelectArrows[3].drawAt(var22 + 15, 4);
			} else {
				class225.worldSelectArrows[1].drawAt(var22 + 15, 4);
			}

			var0.draw("World", var22 + 32, 17, 16777215, -1);
			int var23 = Login.xPadding + 390;
			if (World.sortOption1[0] == 1 && World.sortOption2[0] == 0) {
				class225.worldSelectArrows[2].drawAt(var23, 4);
			} else {
				class225.worldSelectArrows[0].drawAt(var23, 4);
			}

			if (World.sortOption1[0] == 1 && World.sortOption2[0] == 1) {
				class225.worldSelectArrows[3].drawAt(var23 + 15, 4);
			} else {
				class225.worldSelectArrows[1].drawAt(var23 + 15, 4);
			}

			var0.draw("Players", var23 + 32, 17, 16777215, -1);
			var4 = Login.xPadding + 500;
			if (World.sortOption1[0] == 2 && World.sortOption2[0] == 0) {
				class225.worldSelectArrows[2].drawAt(var4, 4);
			} else {
				class225.worldSelectArrows[0].drawAt(var4, 4);
			}

			if (World.sortOption1[0] == 2 && World.sortOption2[0] == 1) {
				class225.worldSelectArrows[3].drawAt(var4 + 15, 4);
			} else {
				class225.worldSelectArrows[1].drawAt(var4 + 15, 4);
			}

			var0.draw("Location", var4 + 32, 17, 16777215, -1);
			var5 = Login.xPadding + 610;
			if (World.sortOption1[0] == 3 && World.sortOption2[0] == 0) {
				class225.worldSelectArrows[2].drawAt(var5, 4);
			} else {
				class225.worldSelectArrows[0].drawAt(var5, 4);
			}

			if (World.sortOption1[0] == 3 && World.sortOption2[0] == 1) {
				class225.worldSelectArrows[3].drawAt(var5 + 15, 4);
			} else {
				class225.worldSelectArrows[1].drawAt(var5 + 15, 4);
			}

			var0.draw("Type", var5 + 32, 17, 16777215, -1);
		}

		Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
		var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
		Login.hoveredWorldIndex = -1;
		if (WorldMapID.worldSelectBackSprites != null) {
			byte var27 = 88;
			byte var28 = 19;
			var4 = 765 / (var27 + 1) - 1;
			var5 = 480 / (var28 + 1);

			int var6;
			int var7;
			do {
				var6 = var5;
				var7 = var4;
				if (var5 * (var4 - 1) >= World.worldsCount) {
					--var4;
				}

				if (var4 * (var5 - 1) >= World.worldsCount) {
					--var5;
				}

				if (var4 * (var5 - 1) >= World.worldsCount) {
					--var5;
				}
			} while(var6 != var5 || var7 != var4);

			var6 = (765 - var4 * var27) / (var4 + 1);
			if (var6 > 5) {
				var6 = 5;
			}

			var7 = (480 - var5 * var28) / (var5 + 1);
			if (var7 > 5) {
				var7 = 5;
			}

			int var8 = (765 - var4 * var27 - var6 * (var4 - 1)) / 2;
			int var9 = (480 - var28 * var5 - var7 * (var5 - 1)) / 2;
			int var10 = (var5 + World.worldsCount - 1) / var5;
			Login.worldSelectPagesCount = var10 - var4;
			if (Login.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
				Login.worldSelectLeftSprite.drawAt(8, ParamDefinition.canvasHeight / 2 - Login.worldSelectLeftSprite.subHeight / 2);
			}

			if (NPCDefinition.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
				NPCDefinition.worldSelectRightSprite.drawAt(GrandExchangeEvent.canvasWidth - NPCDefinition.worldSelectRightSprite.subWidth - 8, ParamDefinition.canvasHeight / 2 - NPCDefinition.worldSelectRightSprite.subHeight / 2);
			}

			int var11 = var9 + 23;
			int var12 = var8 + Login.xPadding;
			int var13 = 0;
			boolean var14 = false;
			int var15 = Login.worldSelectPage;

			int var16;
			for (var16 = var5 * var15; var16 < World.worldsCount && var15 - Login.worldSelectPage < var4; ++var16) {
				World var24 = World.worlds[var16];
				boolean var18 = true;
				String var19 = Integer.toString(var24.population);
				if (var24.population == -1) {
					var19 = "OFF";
					var18 = false;
				} else if (var24.population > 1980) {
					var19 = "FULL";
					var18 = false;
				}

				int var21 = 0;
				byte var20;
				if (var24.isBeta()) {
					if (var24.isMembersOnly()) {
						var20 = 7;
					} else {
						var20 = 6;
					}
				} else if (var24.isDeadman()) {
					var21 = 16711680;
					if (var24.isMembersOnly()) {
						var20 = 5;
					} else {
						var20 = 4;
					}
				} else if (var24.isPvp()) {
					if (var24.isMembersOnly()) {
						var20 = 3;
					} else {
						var20 = 2;
					}
				} else if (var24.isMembersOnly()) {
					var20 = 1;
				} else {
					var20 = 0;
				}

				if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var11 && MouseHandler.MouseHandler_x < var27 + var12 && MouseHandler.MouseHandler_y < var11 + var28 && var18) {
					Login.hoveredWorldIndex = var16;
					WorldMapID.worldSelectBackSprites[var20].drawAtTransOverlay(var12, var11, 128, 16777215);
					var14 = true;
				} else {
					WorldMapID.worldSelectBackSprites[var20].drawAt(var12, var11);
				}

				if (SecureRandomCallable.worldSelectFlagSprites != null) {
					SecureRandomCallable.worldSelectFlagSprites[(var24.isMembersOnly() ? 8 : 0) + var24.location].drawAt(var12 + 29, var11);
				}

				var0.drawCentered(Integer.toString(var24.id), var12 + 15, var28 / 2 + var11 + 5, var21, -1);
				var1.drawCentered(var19, var12 + 60, var28 / 2 + var11 + 5, 268435455, -1);
				var11 = var11 + var7 + var28;
				++var13;
				if (var13 >= var5) {
					var11 = var9 + 23;
					var12 = var12 + var6 + var27;
					var13 = 0;
					++var15;
				}
			}

			if (var14) {
				var16 = var1.stringWidth(World.worlds[Login.hoveredWorldIndex].activity) + 6;
				int var17 = var1.ascent + 8;
				int var26 = MouseHandler.MouseHandler_y + 25;
				if (var17 + var26 > 480) {
					var26 = MouseHandler.MouseHandler_y - 25 - var17;
				}

				Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var16 / 2, var26, var16, var17, 16777120);
				Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var16 / 2, var26, var16, var17, 0);
				var1.drawCentered(World.worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var26 + var1.ascent + 4, 0, -1);
			}
		}

		MusicPatchPcmStream.rasterProvider.drawFull(0, 0);
	}

	@ObfuscatedName("hi")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
		garbageValue = "730328145"
	)
	@Export("insertMenuItemNoShift")
	public static final void insertMenuItemNoShift(String var0, String var1, int var2, int var3, int var4, int var5) {
		Entity.insertMenuItem(var0, var1, var2, var3, var4, var5, false);
	}

	@ObfuscatedName("ig")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "434520276"
	)
	static final String method3631(int var0) {
		String var1 = Integer.toString(var0);

		for (int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
			var1 = var1.substring(0, var2) + "," + var1.substring(var2);
		}

		if (var1.length() > 9) {
			return " " + ClientPreferences.colorStartTag(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>";
		} else {
			return var1.length() > 6 ? " " + ClientPreferences.colorStartTag(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>" : " " + ClientPreferences.colorStartTag(16776960) + var1 + "</col>";
		}
	}
}
