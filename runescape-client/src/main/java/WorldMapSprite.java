import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("WorldMapSprite")
public final class WorldMapSprite {
	@ObfuscatedName("n")
	@Export("tileColors")
	final int[] tileColors;

	WorldMapSprite() {
		this.tileColors = new int[4096];
	}

	WorldMapSprite(int[] var1) {
		this.tileColors = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IIS)I",
		garbageValue = "-9220"
	)
	@Export("getTileColor")
	final int getTileColor(int var1, int var2) {
		return this.tileColors[var2 * 64 + var1];
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-104"
	)
	@Export("getVarbit")
	public static int getVarbit(int var0) {
		VarbitDefinition var2 = (VarbitDefinition)VarbitDefinition.VarbitDefinition_cached.get((long)var0);
		VarbitDefinition var1;
		if (var2 != null) {
			var1 = var2;
		} else {
			byte[] var7 = VarbitDefinition.VarbitDefinition_archive.takeFile(14, var0);
			var2 = new VarbitDefinition();
			if (var7 != null) {
				var2.decode(new Buffer(var7));
			}

			VarbitDefinition.VarbitDefinition_cached.put(var2, (long)var0);
			var1 = var2;
		}

		int var3 = var1.baseVar;
		int var4 = var1.startBit;
		int var5 = var1.endBit;
		int var6 = Varps.Varps_masks[var5 - var4];
		return Varps.Varps_main[var3] >> var4 & var6;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;ZII)V",
		garbageValue = "257961128"
	)
	static void method435(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
		if (Login.field1160) {
			if (var3 == 4) {
				Login.loginIndex = 4;
			}

		} else {
			Login.loginIndex = var3;
			Rasterizer2D.Rasterizer2D_clear();
			byte[] var4 = var0.takeFileByNames("title.jpg", "");
			WorldMapID.leftTitleSprite = class40.convertJpgToSprite(var4);
			class51.rightTitleSprite = WorldMapID.leftTitleSprite.mirrorHorizontally();
			if ((Client.worldProperties & 536870912) != 0) {
				FontName.logoSprite = WorldMapRectangle.SpriteBuffer_getIndexedSpriteByName(var1, "logo_deadman_mode", "");
			} else {
				FontName.logoSprite = WorldMapRectangle.SpriteBuffer_getIndexedSpriteByName(var1, "logo", "");
			}

			class32.titleboxSprite = WorldMapRectangle.SpriteBuffer_getIndexedSpriteByName(var1, "titlebox", "");
			AbstractRasterProvider.titlebuttonSprite = WorldMapRectangle.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton", "");
			Login.runesSprite = WorldMapIcon_0.method222(var1, "runes", "");
			UserComparator7.title_muteSprite = WorldMapIcon_0.method222(var1, "title_mute", "");
			class195.options_buttons_0Sprite = WorldMapRectangle.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,0", "");
			ClientPreferences.field1046 = WorldMapRectangle.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,4", "");
			class42.options_buttons_2Sprite = WorldMapRectangle.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,2", "");
			Login.field1163 = WorldMapRectangle.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,6", "");
			class83.field1145 = class195.options_buttons_0Sprite.subWidth;
			WorldMapCacheName.field286 = class195.options_buttons_0Sprite.subHeight;
			BufferedSink.loginScreenRunesAnimation = new LoginScreenAnimation(Login.runesSprite);
			if (var2) {
				Login.Login_username = "";
				Login.Login_password = "";
			}

			class185.field2305 = 0;
			DesktopPlatformInfoProvider.otp = "";
			Login.field1183 = true;
			Login.worldSelectOpen = false;
			if (!AbstractArchive.clientPreferences.titleMusicDisabled) {
				WorldMapData_0.method194(2, class225.archive6, "scape main", "", 255, false);
			} else {
				class197.field2386 = 1;
				class197.musicTrackArchive = null;
				class188.musicTrackGroupId = -1;
				class49.musicTrackFileId = -1;
				TileItem.field1223 = 0;
				WorldMapSectionType.musicTrackBoolean = false;
				MusicPatchNode2.field2382 = 2;
			}

			DirectByteArrayCopier.method3924(false);
			Login.field1160 = true;
			Login.xPadding = (FloorDecoration.canvasWidth - 765) / 2;
			Login.loginBoxX = Login.xPadding + 202;
			GrandExchangeOfferUnitPriceComparator.loginBoxCenter = Login.loginBoxX + 180;
			WorldMapID.leftTitleSprite.drawAt(Login.xPadding, 0);
			class51.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			FontName.logoSprite.drawAt(Login.xPadding + 382 - FontName.logoSprite.subWidth / 2, 18);
		}
	}

	@ObfuscatedName("fx")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZB)V",
		garbageValue = "-87"
	)
	@Export("drawLoadingMessage")
	static final void drawLoadingMessage(String var0, boolean var1) {
		if (Client.showLoadingMessages) {
			byte var2 = 4;
			int var3 = var2 + 6;
			int var4 = var2 + 6;
			int var5 = GraphicsDefaults.fontPlain12.lineWidth(var0, 250);
			int var6 = GraphicsDefaults.fontPlain12.lineCount(var0, 250) * 13;
			Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
			GraphicsDefaults.fontPlain12.drawLines(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
			int var7 = var3 - var2;
			int var8 = var4 - var2;
			int var9 = var5 + var2 + var2;
			int var10 = var2 + var6 + var2;

			int var11;
			for (var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
				if (Client.rootWidgetXs[var11] + Client.rootWidgetWidths[var11] > var7 && Client.rootWidgetXs[var11] < var9 + var7 && Client.rootWidgetHeights[var11] + Client.rootWidgetYs[var11] > var8 && Client.rootWidgetYs[var11] < var8 + var10) {
					Client.field841[var11] = true;
				}
			}

			if (var1) {
				class42.rasterProvider.drawFull(0, 0);
			} else {
				var11 = var3;
				int var12 = var4;
				int var13 = var5;
				int var14 = var6;

				for (int var15 = 0; var15 < Client.rootWidgetCount; ++var15) {
					if (Client.rootWidgetXs[var15] + Client.rootWidgetWidths[var15] > var11 && Client.rootWidgetXs[var15] < var11 + var13 && Client.rootWidgetYs[var15] + Client.rootWidgetHeights[var15] > var12 && Client.rootWidgetYs[var15] < var14 + var12) {
						Client.field842[var15] = true;
					}
				}
			}

		}
	}

	@ObfuscatedName("in")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-240794843"
	)
	@Export("getTapToDrop")
	static boolean getTapToDrop() {
		return Client.tapToDrop;
	}
}
