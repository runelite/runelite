import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class42 implements WorldMapSection {
	@ObfuscatedName("sy")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	@Export("platformInfo")
	static PlatformInfo platformInfo;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 876812837
	)
	int field355;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -533343471
	)
	int field350;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1956244031
	)
	int field349;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1105762903
	)
	int field358;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -199863857
	)
	int field351;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1075817101
	)
	int field352;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1187703403
	)
	int field348;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1352980527
	)
	int field354;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -197811131
	)
	int field347;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 305542163
	)
	int field356;

	class42() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Laa;I)V",
		garbageValue = "515570621"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field351) {
			var1.regionLowX = this.field351;
		}

		if (var1.regionHighX < this.field351) {
			var1.regionHighX = this.field351;
		}

		if (var1.regionLowY > this.field352) {
			var1.regionLowY = this.field352;
		}

		if (var1.regionHighY < this.field352) {
			var1.regionHighY = this.field352;
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "2033433479"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field355 && var1 < this.field355 + this.field350) {
			return var2 >= (this.field349 << 6) + (this.field348 << 3) && var2 <= (this.field349 << 6) + (this.field348 << 3) + 7 && var3 >= (this.field358 << 6) + (this.field354 << 3) && var3 <= (this.field358 << 6) + (this.field354 << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "-66"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field351 << 6) + (this.field347 << 3) && var1 <= (this.field351 << 6) + (this.field347 << 3) + 7 && var2 >= (this.field352 << 6) + (this.field356 << 3) && var2 <= (this.field352 << 6) + (this.field356 << 3) + 7;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1684413985"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field351 * 64 - this.field349 * 64 + var2 + (this.field347 * 8 - this.field348 * 8), var3 + (this.field352 * 64 - this.field358 * 64) + (this.field356 * 8 - this.field354 * 8)};
			return var4;
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIB)Lht;",
		garbageValue = "21"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field349 * 64 - this.field351 * 64 + (this.field348 * 8 - this.field347 * 8) + var1;
			int var4 = this.field358 * 64 - this.field352 * 64 + var2 + (this.field354 * 8 - this.field356 * 8);
			return new Coord(this.field355, var3, var4);
		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lkq;B)V",
		garbageValue = "74"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.field355 = var1.readUnsignedByte();
		this.field350 = var1.readUnsignedByte();
		this.field349 = var1.readUnsignedShort();
		this.field348 = var1.readUnsignedByte();
		this.field358 = var1.readUnsignedShort();
		this.field354 = var1.readUnsignedByte();
		this.field351 = var1.readUnsignedShort();
		this.field347 = var1.readUnsignedByte();
		this.field352 = var1.readUnsignedShort();
		this.field356 = var1.readUnsignedByte();
		this.method771();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "794869852"
	)
	void method771() {
	}

	@ObfuscatedName("i")
	public static boolean method790(long var0) {
		boolean var2 = var0 != 0L;
		if (var2) {
			boolean var3 = (int)(var0 >>> 16 & 1L) == 1;
			var2 = !var3;
		}

		return var2;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1817896162"
	)
	public static boolean method792() {
		return class197.field2392 != 0 ? true : GZipDecompressor.midiPcmStream.isReady();
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lko;Lko;S)V",
		garbageValue = "-12122"
	)
	static void method781(Font var0, Font var1) {
		if (Calendar.worldSelectBackSprites == null) {
			Calendar.worldSelectBackSprites = class80.method2058(class3.archive8, "sl_back", "");
		}

		if (AbstractWorldMapIcon.worldSelectFlagSprites == null) {
			AbstractWorldMapIcon.worldSelectFlagSprites = class195.method3667(class3.archive8, "sl_flags", "");
		}

		if (Message.worldSelectArrows == null) {
			Message.worldSelectArrows = class195.method3667(class3.archive8, "sl_arrows", "");
		}

		if (SpotAnimationDefinition.worldSelectStars == null) {
			SpotAnimationDefinition.worldSelectStars = class195.method3667(class3.archive8, "sl_stars", "");
		}

		if (GrandExchangeEvent.worldSelectLeftSprite == null) {
			GrandExchangeEvent.worldSelectLeftSprite = Canvas.SpriteBuffer_getIndexedSpriteByName(class3.archive8, "leftarrow", "");
		}

		if (UserList.worldSelectRightSprite == null) {
			UserList.worldSelectRightSprite = Canvas.SpriteBuffer_getIndexedSpriteByName(class3.archive8, "rightarrow", "");
		}

		Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
		Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
		Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
		var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
		if (SpotAnimationDefinition.worldSelectStars != null) {
			SpotAnimationDefinition.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
			var1.draw("Members only world", Login.xPadding + 152, 10, 16777215, -1);
			SpotAnimationDefinition.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
			var1.draw("Free world", Login.xPadding + 152, 21, 16777215, -1);
		}

		int var4;
		int var5;
		if (Message.worldSelectArrows != null) {
			int var2 = Login.xPadding + 280;
			if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 0) {
				Message.worldSelectArrows[2].drawAt(var2, 4);
			} else {
				Message.worldSelectArrows[0].drawAt(var2, 4);
			}

			if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 1) {
				Message.worldSelectArrows[3].drawAt(var2 + 15, 4);
			} else {
				Message.worldSelectArrows[1].drawAt(var2 + 15, 4);
			}

			var0.draw("World", var2 + 32, 17, 16777215, -1);
			int var3 = Login.xPadding + 390;
			if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 0) {
				Message.worldSelectArrows[2].drawAt(var3, 4);
			} else {
				Message.worldSelectArrows[0].drawAt(var3, 4);
			}

			if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 1) {
				Message.worldSelectArrows[3].drawAt(var3 + 15, 4);
			} else {
				Message.worldSelectArrows[1].drawAt(var3 + 15, 4);
			}

			var0.draw("Players", var3 + 32, 17, 16777215, -1);
			var4 = Login.xPadding + 500;
			if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 0) {
				Message.worldSelectArrows[2].drawAt(var4, 4);
			} else {
				Message.worldSelectArrows[0].drawAt(var4, 4);
			}

			if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 1) {
				Message.worldSelectArrows[3].drawAt(var4 + 15, 4);
			} else {
				Message.worldSelectArrows[1].drawAt(var4 + 15, 4);
			}

			var0.draw("Location", var4 + 32, 17, 16777215, -1);
			var5 = Login.xPadding + 610;
			if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 0) {
				Message.worldSelectArrows[2].drawAt(var5, 4);
			} else {
				Message.worldSelectArrows[0].drawAt(var5, 4);
			}

			if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 1) {
				Message.worldSelectArrows[3].drawAt(var5 + 15, 4);
			} else {
				Message.worldSelectArrows[1].drawAt(var5 + 15, 4);
			}

			var0.draw("Type", var5 + 32, 17, 16777215, -1);
		}

		Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
		var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
		Login.hoveredWorldIndex = -1;
		if (Calendar.worldSelectBackSprites != null) {
			byte var23 = 88;
			byte var24 = 19;
			var4 = 765 / (var23 + 1) - 1;
			var5 = 480 / (var24 + 1);

			int var6;
			int var7;
			do {
				var6 = var5;
				var7 = var4;
				if (var5 * (var4 - 1) >= World.World_count) {
					--var4;
				}

				if (var4 * (var5 - 1) >= World.World_count) {
					--var5;
				}

				if (var4 * (var5 - 1) >= World.World_count) {
					--var5;
				}
			} while(var6 != var5 || var7 != var4);

			var6 = (765 - var23 * var4) / (var4 + 1);
			if (var6 > 5) {
				var6 = 5;
			}

			var7 = (480 - var24 * var5) / (var5 + 1);
			if (var7 > 5) {
				var7 = 5;
			}

			int var8 = (765 - var4 * var23 - var6 * (var4 - 1)) / 2;
			int var9 = (480 - var24 * var5 - var7 * (var5 - 1)) / 2;
			int var10 = (var5 + World.World_count - 1) / var5;
			Login.worldSelectPagesCount = var10 - var4;
			if (GrandExchangeEvent.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
				GrandExchangeEvent.worldSelectLeftSprite.drawAt(8, AttackOption.canvasHeight / 2 - GrandExchangeEvent.worldSelectLeftSprite.subHeight / 2);
			}

			if (UserList.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
				UserList.worldSelectRightSprite.drawAt(GrandExchangeOfferTotalQuantityComparator.canvasWidth - UserList.worldSelectRightSprite.subWidth - 8, AttackOption.canvasHeight / 2 - UserList.worldSelectRightSprite.subHeight / 2);
			}

			int var11 = var9 + 23;
			int var12 = var8 + Login.xPadding;
			int var13 = 0;
			boolean var14 = false;
			int var15 = Login.worldSelectPage;

			int var16;
			for (var16 = var5 * var15; var16 < World.World_count && var15 - Login.worldSelectPage < var4; ++var16) {
				World var22 = class162.World_worlds[var16];
				boolean var18 = true;
				String var19 = Integer.toString(var22.population);
				if (var22.population == -1) {
					var19 = "OFF";
					var18 = false;
				} else if (var22.population > 1980) {
					var19 = "FULL";
					var18 = false;
				}

				int var21 = 0;
				byte var20;
				if (var22.isBeta()) {
					if (var22.isMembersOnly()) {
						var20 = 7;
					} else {
						var20 = 6;
					}
				} else if (var22.isDeadman()) {
					var21 = 16711680;
					if (var22.isMembersOnly()) {
						var20 = 5;
					} else {
						var20 = 4;
					}
				} else if (var22.method1775()) {
					if (var22.isMembersOnly()) {
						var20 = 9;
					} else {
						var20 = 8;
					}
				} else if (var22.isPvp()) {
					if (var22.isMembersOnly()) {
						var20 = 3;
					} else {
						var20 = 2;
					}
				} else if (var22.isMembersOnly()) {
					var20 = 1;
				} else {
					var20 = 0;
				}

				if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var11 && MouseHandler.MouseHandler_x < var12 + var23 && MouseHandler.MouseHandler_y < var24 + var11 && var18) {
					Login.hoveredWorldIndex = var16;
					Calendar.worldSelectBackSprites[var20].drawTransOverlayAt(var12, var11, 128, 16777215);
					var14 = true;
				} else {
					Calendar.worldSelectBackSprites[var20].drawAt(var12, var11);
				}

				if (AbstractWorldMapIcon.worldSelectFlagSprites != null) {
					AbstractWorldMapIcon.worldSelectFlagSprites[(var22.isMembersOnly() ? 8 : 0) + var22.location].drawAt(var12 + 29, var11);
				}

				var0.drawCentered(Integer.toString(var22.id), var12 + 15, var24 / 2 + var11 + 5, var21, -1);
				var1.drawCentered(var19, var12 + 60, var24 / 2 + var11 + 5, 268435455, -1);
				var11 = var11 + var24 + var7;
				++var13;
				if (var13 >= var5) {
					var11 = var9 + 23;
					var12 = var12 + var6 + var23;
					var13 = 0;
					++var15;
				}
			}

			if (var14) {
				var16 = var1.stringWidth(class162.World_worlds[Login.hoveredWorldIndex].activity) + 6;
				int var17 = var1.ascent + 8;
				int var25 = MouseHandler.MouseHandler_y + 25;
				if (var25 + var17 > 480) {
					var25 = MouseHandler.MouseHandler_y - 25 - var17;
				}

				Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var16 / 2, var25, var16, var17, 16777120);
				Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var16 / 2, var25, var16, var17, 0);
				var1.drawCentered(class162.World_worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var25 + var1.ascent + 4, 0, -1);
			}
		}

		IgnoreList.rasterProvider.drawFull(0, 0);
	}

	@ObfuscatedName("ju")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "283959833"
	)
	@Export("getTapToDrop")
	static boolean getTapToDrop() {
		return Client.tapToDrop;
	}
}
