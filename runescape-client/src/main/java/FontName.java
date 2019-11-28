import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
@Implements("FontName")
public class FontName {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lka;"
	)
	@Export("FontName_plain11")
	public static final FontName FontName_plain11;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lka;"
	)
	@Export("FontName_plain12")
	public static final FontName FontName_plain12;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lka;"
	)
	@Export("FontName_bold12")
	public static final FontName FontName_bold12;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lka;"
	)
	@Export("FontName_verdana11")
	public static final FontName FontName_verdana11;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lka;"
	)
	@Export("FontName_verdana13")
	public static final FontName FontName_verdana13;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lka;"
	)
	@Export("FontName_verdana15")
	public static final FontName FontName_verdana15;
	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		signature = "[Lln;"
	)
	@Export("headIconPkSprites")
	static Sprite[] headIconPkSprites;
	@ObfuscatedName("h")
	@Export("name")
	String name;

	static {
		FontName_plain11 = new FontName("p11_full");
		FontName_plain12 = new FontName("p12_full");
		FontName_bold12 = new FontName("b12_full");
		FontName_verdana11 = new FontName("verdana_11pt_regular");
		FontName_verdana13 = new FontName("verdana_13pt_regular");
		FontName_verdana15 = new FontName("verdana_15pt_regular");
	}

	FontName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;ZB)[B",
		garbageValue = "-6"
	)
	@Export("serialize")
	public static byte[] serialize(Object var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0 instanceof byte[]) {
			byte[] var3 = (byte[])((byte[])var0);
			return var1 ? ObjectSound.method1935(var3) : var3;
		} else if (var0 instanceof AbstractByteArrayCopier) {
			AbstractByteArrayCopier var2 = (AbstractByteArrayCopier)var0;
			return var2.get();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/CharSequence;IIS)Ljava/lang/String;",
		garbageValue = "11835"
	)
	public static String method5425(CharSequence[] var0, int var1, int var2) {
		if (var2 == 0) {
			return "";
		} else if (var2 == 1) {
			CharSequence var3 = var0[var1];
			return var3 == null ? "null" : var3.toString();
		} else {
			int var8 = var2 + var1;
			int var4 = 0;

			for (int var5 = var1; var5 < var8; ++var5) {
				CharSequence var6 = var0[var5];
				if (var6 == null) {
					var4 += 4;
				} else {
					var4 += var6.length();
				}
			}

			StringBuilder var9 = new StringBuilder(var4);

			for (int var10 = var1; var10 < var8; ++var10) {
				CharSequence var7 = var0[var10];
				if (var7 == null) {
					var9.append("null");
				} else {
					var9.append(var7);
				}
			}

			return var9.toString();
		}
	}

	@ObfuscatedName("gw")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1549507676"
	)
	static void method5427() {
		if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
			Varcs.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
		}

	}

	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-310614097"
	)
	static final void method5426(int var0, int var1, int var2, int var3) {
		Client.overheadTextCount = 0;
		boolean var4 = false;
		int var5 = -1;
		int var6 = -1;
		int var7 = Players.Players_count;
		int[] var8 = Players.Players_indices;

		int var9;
		for (var9 = 0; var9 < var7 + Client.npcCount; ++var9) {
			Object var10;
			if (var9 < var7) {
				var10 = Client.players[var8[var9]];
				if (var8[var9] == Client.combatTargetPlayerIndex) {
					var4 = true;
					var5 = var9;
					continue;
				}

				if (var10 == class215.localPlayer) {
					var6 = var9;
					continue;
				}
			} else {
				var10 = Client.npcs[Client.npcIndices[var9 - var7]];
			}

			class80.drawActor2d((Actor)var10, var9, var0, var1, var2, var3);
		}

		if (Client.renderSelf && var6 != -1) {
			class80.drawActor2d(class215.localPlayer, var6, var0, var1, var2, var3);
		}

		if (var4) {
			class80.drawActor2d(Client.players[Client.combatTargetPlayerIndex], var5, var0, var1, var2, var3);
		}

		for (var9 = 0; var9 < Client.overheadTextCount; ++var9) {
			int var19 = Client.overheadTextXs[var9];
			int var11 = Client.overheadTextYs[var9];
			int var12 = Client.overheadTextXOffsets[var9];
			int var13 = Client.overheadTextAscents[var9];
			boolean var14 = true;

			while (var14) {
				var14 = false;

				for (int var15 = 0; var15 < var9; ++var15) {
					if (var11 + 2 > Client.overheadTextYs[var15] - Client.overheadTextAscents[var15] && var11 - var13 < Client.overheadTextYs[var15] + 2 && var19 - var12 < Client.overheadTextXOffsets[var15] + Client.overheadTextXs[var15] && var19 + var12 > Client.overheadTextXs[var15] - Client.overheadTextXOffsets[var15] && Client.overheadTextYs[var15] - Client.overheadTextAscents[var15] < var11) {
						var11 = Client.overheadTextYs[var15] - Client.overheadTextAscents[var15];
						var14 = true;
					}
				}
			}

			Client.viewportTempX = Client.overheadTextXs[var9];
			Client.viewportTempY = Client.overheadTextYs[var9] = var11;
			String var20 = Client.overheadText[var9];
			if (Client.chatEffects == 0) {
				int var16 = 16776960;
				if (Client.overheadTextColors[var9] < 6) {
					var16 = Client.field857[Client.overheadTextColors[var9]];
				}

				if (Client.overheadTextColors[var9] == 6) {
					var16 = Client.viewportDrawCount % 20 < 10 ? 16711680 : 16776960;
				}

				if (Client.overheadTextColors[var9] == 7) {
					var16 = Client.viewportDrawCount % 20 < 10 ? 255 : '\uffff';
				}

				if (Client.overheadTextColors[var9] == 8) {
					var16 = Client.viewportDrawCount % 20 < 10 ? '뀀' : 8454016;
				}

				int var17;
				if (Client.overheadTextColors[var9] == 9) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					if (var17 < 50) {
						var16 = var17 * 1280 + 16711680;
					} else if (var17 < 100) {
						var16 = 16776960 - (var17 - 50) * 327680;
					} else if (var17 < 150) {
						var16 = (var17 - 100) * 5 + 65280;
					}
				}

				if (Client.overheadTextColors[var9] == 10) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					if (var17 < 50) {
						var16 = var17 * 5 + 16711680;
					} else if (var17 < 100) {
						var16 = 16711935 - (var17 - 50) * 327680;
					} else if (var17 < 150) {
						var16 = (var17 - 100) * 327680 + 255 - (var17 - 100) * 5;
					}
				}

				if (Client.overheadTextColors[var9] == 11) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					if (var17 < 50) {
						var16 = 16777215 - var17 * 327685;
					} else if (var17 < 100) {
						var16 = (var17 - 50) * 327685 + 65280;
					} else if (var17 < 150) {
						var16 = 16777215 - (var17 - 100) * 327680;
					}
				}

				if (Client.overheadTextEffects[var9] == 0) {
					JagexCache.fontBold12.drawCentered(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0);
				}

				if (Client.overheadTextEffects[var9] == 1) {
					JagexCache.fontBold12.drawCenteredWave(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var9] == 2) {
					JagexCache.fontBold12.drawCenteredWave2(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var9] == 3) {
					JagexCache.fontBold12.drawCenteredShake(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount, 150 - Client.overheadTextCyclesRemaining[var9]);
				}

				if (Client.overheadTextEffects[var9] == 4) {
					var17 = (150 - Client.overheadTextCyclesRemaining[var9]) * (JagexCache.fontBold12.stringWidth(var20) + 100) / 150;
					Rasterizer2D.Rasterizer2D_expandClip(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
					JagexCache.fontBold12.draw(var20, var0 + Client.viewportTempX + 50 - var17, Client.viewportTempY + var1, var16, 0);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}

				if (Client.overheadTextEffects[var9] == 5) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					int var18 = 0;
					if (var17 < 25) {
						var18 = var17 - 25;
					} else if (var17 > 125) {
						var18 = var17 - 125;
					}

					Rasterizer2D.Rasterizer2D_expandClip(var0, Client.viewportTempY + var1 - JagexCache.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
					JagexCache.fontBold12.drawCentered(var20, var0 + Client.viewportTempX, var18 + Client.viewportTempY + var1, var16, 0);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}
			} else {
				JagexCache.fontBold12.drawCentered(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
			}
		}

	}
}
