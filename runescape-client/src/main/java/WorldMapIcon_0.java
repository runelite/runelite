import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("WorldMapIcon_0")
public class WorldMapIcon_0 extends AbstractWorldMapIcon {
	@ObfuscatedName("cm")
	public static char field126;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 948071377
	)
	@Export("element")
	final int element;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lao;"
	)
	@Export("label")
	final WorldMapLabel label;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -2038423021
	)
	@Export("subWidth")
	final int subWidth;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1663169023
	)
	@Export("subHeight")
	final int subHeight;

	@ObfuscatedSignature(
		signature = "(Lhj;Lhj;ILao;)V"
	)
	WorldMapIcon_0(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
		super(var1, var2);
		this.element = var3;
		this.label = var4;
		WorldMapElement var5 = WorldMapSection1.WorldMapElement_get(this.getElement());
		Sprite var6 = var5.getSpriteBool(false);
		if (var6 != null) {
			this.subWidth = var6.subWidth;
			this.subHeight = var6.subHeight;
		} else {
			this.subWidth = 0;
			this.subHeight = 0;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "861849893"
	)
	@Export("getElement")
	public int getElement() {
		return this.element;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Lao;",
		garbageValue = "1066707711"
	)
	@Export("getLabel")
	WorldMapLabel getLabel() {
		return this.label;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1386026878"
	)
	@Export("getSubWidth")
	int getSubWidth() {
		return this.subWidth;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "174908718"
	)
	@Export("getSubHeight")
	int getSubHeight() {
		return this.subHeight;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IIILfw;Lfj;Z[I[II)I",
		garbageValue = "-1532162381"
	)
	public static int method194(int var0, int var1, int var2, RouteStrategy var3, CollisionMap var4, boolean var5, int[] var6, int[] var7) {
		int var9;
		for (int var8 = 0; var8 < 128; ++var8) {
			for (var9 = 0; var9 < 128; ++var9) {
				class173.directions[var8][var9] = 0;
				class173.distances[var8][var9] = 99999999;
			}
		}

		int var10;
		int var11;
		byte var13;
		int var14;
		int var15;
		int var17;
		int var19;
		int var20;
		int var21;
		boolean var28;
		int var30;
		int var31;
		int var33;
		if (var2 == 1) {
			var10 = var0;
			var11 = var1;
			byte var12 = 64;
			var13 = 64;
			var14 = var0 - var12;
			var15 = var1 - var13;
			class173.directions[var12][var13] = 99;
			class173.distances[var12][var13] = 0;
			byte var16 = 0;
			var17 = 0;
			class173.bufferX[var16] = var0;
			var33 = var16 + 1;
			class173.bufferY[var16] = var1;
			int[][] var18 = var4.flags;

			boolean var29;
			while (true) {
				if (var33 == var17) {
					class173.field2063 = var10;
					class173.field2068 = var11;
					var29 = false;
					break;
				}

				var10 = class173.bufferX[var17];
				var11 = class173.bufferY[var17];
				var17 = var17 + 1 & 4095;
				var30 = var10 - var14;
				var31 = var11 - var15;
				var19 = var10 - var4.xInset;
				var20 = var11 - var4.yInset;
				if (var3.hasArrived(1, var10, var11, var4)) {
					class173.field2063 = var10;
					class173.field2068 = var11;
					var29 = true;
					break;
				}

				var21 = class173.distances[var30][var31] + 1;
				if (var30 > 0 && class173.directions[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
					class173.bufferX[var33] = var10 - 1;
					class173.bufferY[var33] = var11;
					var33 = var33 + 1 & 4095;
					class173.directions[var30 - 1][var31] = 2;
					class173.distances[var30 - 1][var31] = var21;
				}

				if (var30 < 127 && class173.directions[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
					class173.bufferX[var33] = var10 + 1;
					class173.bufferY[var33] = var11;
					var33 = var33 + 1 & 4095;
					class173.directions[var30 + 1][var31] = 8;
					class173.distances[var30 + 1][var31] = var21;
				}

				if (var31 > 0 && class173.directions[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
					class173.bufferX[var33] = var10;
					class173.bufferY[var33] = var11 - 1;
					var33 = var33 + 1 & 4095;
					class173.directions[var30][var31 - 1] = 1;
					class173.distances[var30][var31 - 1] = var21;
				}

				if (var31 < 127 && class173.directions[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
					class173.bufferX[var33] = var10;
					class173.bufferY[var33] = var11 + 1;
					var33 = var33 + 1 & 4095;
					class173.directions[var30][var31 + 1] = 4;
					class173.distances[var30][var31 + 1] = var21;
				}

				if (var30 > 0 && var31 > 0 && class173.directions[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
					class173.bufferX[var33] = var10 - 1;
					class173.bufferY[var33] = var11 - 1;
					var33 = var33 + 1 & 4095;
					class173.directions[var30 - 1][var31 - 1] = 3;
					class173.distances[var30 - 1][var31 - 1] = var21;
				}

				if (var30 < 127 && var31 > 0 && class173.directions[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
					class173.bufferX[var33] = var10 + 1;
					class173.bufferY[var33] = var11 - 1;
					var33 = var33 + 1 & 4095;
					class173.directions[var30 + 1][var31 - 1] = 9;
					class173.distances[var30 + 1][var31 - 1] = var21;
				}

				if (var30 > 0 && var31 < 127 && class173.directions[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
					class173.bufferX[var33] = var10 - 1;
					class173.bufferY[var33] = var11 + 1;
					var33 = var33 + 1 & 4095;
					class173.directions[var30 - 1][var31 + 1] = 6;
					class173.distances[var30 - 1][var31 + 1] = var21;
				}

				if (var30 < 127 && var31 < 127 && class173.directions[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
					class173.bufferX[var33] = var10 + 1;
					class173.bufferY[var33] = var11 + 1;
					var33 = var33 + 1 & 4095;
					class173.directions[var30 + 1][var31 + 1] = 12;
					class173.distances[var30 + 1][var31 + 1] = var21;
				}
			}

			var28 = var29;
		} else if (var2 == 2) {
			var28 = WorldMapArea.method315(var0, var1, var3, var4);
		} else {
			var28 = Strings.method4103(var0, var1, var2, var3, var4);
		}

		var9 = var0 - 64;
		var10 = var1 - 64;
		var11 = class173.field2063;
		var30 = class173.field2068;
		if (!var28) {
			var31 = Integer.MAX_VALUE;
			var14 = Integer.MAX_VALUE;
			byte var32 = 10;
			var33 = var3.approxDestinationX;
			var17 = var3.approxDestinationY;
			int var27 = var3.approxDestinationSizeX;
			var19 = var3.approxDestinationSizeY;

			for (var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
				for (var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
					int var22 = var20 - var9;
					int var23 = var21 - var10;
					if (var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class173.distances[var22][var23] < 100) {
						int var24 = 0;
						if (var20 < var33) {
							var24 = var33 - var20;
						} else if (var20 > var27 + var33 - 1) {
							var24 = var20 - (var27 + var33 - 1);
						}

						int var25 = 0;
						if (var21 < var17) {
							var25 = var17 - var21;
						} else if (var21 > var17 + var19 - 1) {
							var25 = var21 - (var19 + var17 - 1);
						}

						int var26 = var25 * var25 + var24 * var24;
						if (var26 < var31 || var31 == var26 && class173.distances[var22][var23] < var14) {
							var31 = var26;
							var14 = class173.distances[var22][var23];
							var11 = var20;
							var30 = var21;
						}
					}
				}
			}

			if (var31 == Integer.MAX_VALUE) {
				return -1;
			}
		}

		if (var0 == var11 && var30 == var1) {
			return 0;
		} else {
			var13 = 0;
			class173.bufferX[var13] = var11;
			var31 = var13 + 1;
			class173.bufferY[var13] = var30;

			for (var14 = var15 = class173.directions[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class173.directions[var11 - var9][var30 - var10]) {
				if (var14 != var15) {
					var15 = var14;
					class173.bufferX[var31] = var11;
					class173.bufferY[var31++] = var30;
				}

				if ((var14 & 2) != 0) {
					++var11;
				} else if ((var14 & 8) != 0) {
					--var11;
				}

				if ((var14 & 1) != 0) {
					++var30;
				} else if ((var14 & 4) != 0) {
					--var30;
				}
			}

			var33 = 0;

			while (var31-- > 0) {
				var6[var33] = class173.bufferX[var31];
				var7[var33++] = class173.bufferY[var31];
				if (var33 >= var6.length) {
					break;
				}
			}

			return var33;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZZI)V",
		garbageValue = "-1584053866"
	)
	@Export("openURL")
	public static void openURL(String var0, boolean var1, boolean var2) {
		class42.method754(var0, var1, "openjs", var2);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "651689176"
	)
	public static final void method174(int var0, int var1) {
		ViewportMouse.ViewportMouse_x = var0;
		ViewportMouse.ViewportMouse_y = var1;
		ViewportMouse.ViewportMouse_isInViewport = true;
		ViewportMouse.ViewportMouse_entityCount = 0;
		ViewportMouse.ViewportMouse_false0 = false;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;S)I",
		garbageValue = "23261"
	)
	public static int method195(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + var0.charAt(var3);
		}

		return var2;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Lhy;I[B[BI)V",
		garbageValue = "2116245618"
	)
	@Export("Widget_setKey")
	static final void Widget_setKey(Widget var0, int var1, byte[] var2, byte[] var3) {
		if (var0.field2671 == null) {
			if (var2 == null) {
				return;
			}

			var0.field2671 = new byte[11][];
			var0.field2614 = new byte[11][];
			var0.field2615 = new int[11];
			var0.field2616 = new int[11];
		}

		var0.field2671[var1] = var2;
		if (var2 != null) {
			var0.field2612 = true;
		} else {
			var0.field2612 = false;

			for (int var4 = 0; var4 < var0.field2671.length; ++var4) {
				if (var0.field2671[var4] != null) {
					var0.field2612 = true;
					break;
				}
			}
		}

		var0.field2614[var1] = var3;
	}

	@ObfuscatedName("es")
	@ObfuscatedSignature(
		signature = "(IB)V",
		garbageValue = "0"
	)
	@Export("updateGameState")
	static void updateGameState(int var0) {
		if (var0 != Client.gameState) {
			if (Client.gameState == 0) {
				Coord.client.method915();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45) {
				Client.loginState = 0;
				Client.field656 = 0;
				Client.field841 = 0;
				Client.timer.method4971(var0);
				if (var0 != 20) {
					PacketWriter.method2238(false);
				}
			}

			if (var0 != 20 && var0 != 40 && ArchiveLoader.field512 != null) {
				ArchiveLoader.field512.close();
				ArchiveLoader.field512 = null;
			}

			if (Client.gameState == 25) {
				Client.field678 = 0;
				Client.field674 = 0;
				Client.field851 = 1;
				Client.field676 = 0;
				Client.field872 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					VarpDefinition.method4354(FontName.archive10, WorldMapDecoration.archive8, true, Client.gameState == 11 ? 4 : 0);
				} else if (var0 == 11) {
					VarpDefinition.method4354(FontName.archive10, WorldMapDecoration.archive8, false, 4);
				} else if (Login.field1181) {
					Login.titleboxSprite = null;
					class191.titlebuttonSprite = null;
					UserComparator10.runesSprite = null;
					Login.leftTitleSprite = null;
					class191.rightTitleSprite = null;
					HealthBar.logoSprite = null;
					FileSystem.title_muteSprite = null;
					GrandExchangeOfferWorldComparator.options_buttons_0Sprite = null;
					Login.options_buttons_2Sprite = null;
					class162.worldSelectBackSprites = null;
					PlayerType.worldSelectFlagSprites = null;
					FileSystem.worldSelectArrows = null;
					class226.worldSelectStars = null;
					GrandExchangeOfferWorldComparator.field32 = null;
					UserComparator5.loginScreenRunesAnimation.method1795();
					WallDecoration.method3256(2);
					class173.method3575(true);
					Login.field1181 = false;
				}
			} else {
				VarpDefinition.method4354(FontName.archive10, WorldMapDecoration.archive8, true, 0);
			}

			Client.gameState = var0;
		}
	}

	@ObfuscatedName("ew")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-934752862"
	)
	static final void method196(int var0) {
		class40.method736();
		switch(var0) {
		case 1:
			Login.loginIndex = 24;
			Canvas.setLoginResponseString("", "You were disconnected from the server.", "");
			break;
		case 2:
			Login.loginIndex = 24;
			Canvas.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
		}

	}
}
