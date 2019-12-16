import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("ax")
@Implements("DevicePcmPlayerProvider")
public class DevicePcmPlayerProvider implements class97 {
	@ObfuscatedName("aq")
	static String field391;

	DevicePcmPlayerProvider() {
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Lcw;",
		garbageValue = "479224621"
	)
	@Export("player")
	public PcmPlayer player() {
		return new DevicePcmPlayer();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;ZII)V",
		garbageValue = "808644232"
	)
	static void method841(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
		if (Login.field1173) {
			if (var3 == 4) {
				Login.loginIndex = 4;
			}

		} else {
			Login.loginIndex = var3;
			Rasterizer2D.Rasterizer2D_clear();
			byte[] var4 = var0.takeFileByNames("title.jpg", "");
			UrlRequest.leftTitleSprite = GrandExchangeOfferTotalQuantityComparator.convertJpgToSprite(var4);
			ScriptFrame.rightTitleSprite = UrlRequest.leftTitleSprite.mirrorHorizontally();
			if ((Client.worldProperties & 536870912) != 0) {
				Login.logoSprite = Canvas.SpriteBuffer_getIndexedSpriteByName(var1, "logo_deadman_mode", "");
			} else if ((Client.worldProperties & 1073741824) != 0) {
				Login.logoSprite = Canvas.SpriteBuffer_getIndexedSpriteByName(var1, "logo_seasonal_mode", "");
			} else {
				Login.logoSprite = Canvas.SpriteBuffer_getIndexedSpriteByName(var1, "logo", "");
			}

			Login.titleboxSprite = Canvas.SpriteBuffer_getIndexedSpriteByName(var1, "titlebox", "");
			Login.titlebuttonSprite = Canvas.SpriteBuffer_getIndexedSpriteByName(var1, "titlebutton", "");
			Login.runesSprite = class195.method3667(var1, "runes", "");
			class30.title_muteSprite = class195.method3667(var1, "title_mute", "");
			class218.options_buttons_0Sprite = Canvas.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,0", "");
			GrandExchangeOffer.field64 = Canvas.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,4", "");
			Login.options_buttons_2Sprite = Canvas.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,2", "");
			Login.field1162 = Canvas.SpriteBuffer_getIndexedSpriteByName(var1, "options_radio_buttons,6", "");
			IgnoreList.field3579 = class218.options_buttons_0Sprite.subWidth;
			MenuAction.field1133 = class218.options_buttons_0Sprite.subHeight;
			StructDefinition.loginScreenRunesAnimation = new LoginScreenAnimation(Login.runesSprite);
			if (var2) {
				Login.Login_username = "";
				Login.Login_password = "";
			}

			class266.field3517 = 0;
			class80.otp = "";
			Login.field1178 = true;
			Login.worldSelectOpen = false;
			if (!Interpreter.clientPreferences.titleMusicDisabled) {
				WorldMapCacheName.method616(2, GrandExchangeOfferWorldComparator.archive6, "scape main", "", 255, false);
			} else {
				BoundaryObject.method3273(2);
			}

			BuddyRankComparator.method3362(false);
			Login.field1173 = true;
			Login.xPadding = (GrandExchangeOfferTotalQuantityComparator.canvasWidth - 765) / 2;
			Login.loginBoxX = Login.xPadding + 202;
			Script.loginBoxCenter = Login.loginBoxX + 180;
			UrlRequest.leftTitleSprite.drawAt(Login.xPadding, 0);
			ScriptFrame.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;Lhz;Lhz;B)V",
		garbageValue = "0"
	)
	public static void method842(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, AbstractArchive var3) {
		FriendLoginUpdate.Widget_archive = var0;
		Widget.Widget_modelsArchive = var1;
		BoundaryObject.Widget_spritesArchive = var2;
		MilliClock.Widget_fontsArchive = var3;
		UserComparator7.Widget_interfaceComponents = new Widget[FriendLoginUpdate.Widget_archive.getGroupCount()][];
		Widget.Widget_loadedInterfaces = new boolean[FriendLoginUpdate.Widget_archive.getGroupCount()];
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "1220009444"
	)
	static int method840(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		int var6;
		if (var0 == ScriptOpcodes.ENUM_STRING) {
			class188.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			EnumDefinition var5 = World.getEnum(var3);
			if (var5.outputType != 's') {
			}

			for (var6 = 0; var6 < var5.outputCount; ++var6) {
				if (var4 == var5.keys[var6]) {
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var5.strVals[var6];
					var5 = null;
					break;
				}
			}

			if (var5 != null) {
				Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var5.defaultStr;
			}

			return 1;
		} else if (var0 != ScriptOpcodes.ENUM) {
			if (var0 == ScriptOpcodes.ENUM_GETOUTPUTCOUNT) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				EnumDefinition var10 = World.getEnum(var3);
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var10.size();
				return 1;
			} else {
				return 2;
			}
		} else {
			class188.Interpreter_intStackSize -= 4;
			var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
			int var9 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 2];
			var6 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 3];
			EnumDefinition var7 = World.getEnum(var9);
			if (var3 == var7.inputType && var4 == var7.outputType) {
				for (int var8 = 0; var8 < var7.outputCount; ++var8) {
					if (var6 == var7.keys[var8]) {
						if (var4 == 115) {
							Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var7.strVals[var8];
						} else {
							Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var7.intVals[var8];
						}

						var7 = null;
						break;
					}
				}

				if (var7 != null) {
					if (var4 == 115) {
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var7.defaultStr;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var7.defaultInt;
					}
				}

				return 1;
			} else {
				if (var4 == 115) {
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "null";
				} else {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = 0;
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("iv")
	@ObfuscatedSignature(
		signature = "(IIIIIIB)V",
		garbageValue = "89"
	)
	static final void method839(int var0, int var1, int var2, int var3, int var4, int var5) {
		int var6 = var2 - var0;
		int var7 = var3 - var1;
		int var8 = var6 >= 0 ? var6 : -var6;
		int var9 = var7 >= 0 ? var7 : -var7;
		int var10 = var8;
		if (var8 < var9) {
			var10 = var9;
		}

		if (var10 != 0) {
			int var11 = (var6 << 16) / var10;
			int var12 = (var7 << 16) / var10;
			if (var12 <= var11) {
				var11 = -var11;
			} else {
				var12 = -var12;
			}

			int var13 = var5 * var12 >> 17;
			int var14 = var5 * var12 + 1 >> 17;
			int var15 = var5 * var11 >> 17;
			int var16 = var5 * var11 + 1 >> 17;
			var0 -= Rasterizer2D.Rasterizer2D_xClipStart;
			var1 -= Rasterizer2D.Rasterizer2D_yClipStart;
			int var17 = var0 + var13;
			int var18 = var0 - var14;
			int var19 = var0 + var6 - var14;
			int var20 = var0 + var13 + var6;
			int var21 = var15 + var1;
			int var22 = var1 - var16;
			int var23 = var7 + var1 - var16;
			int var24 = var7 + var15 + var1;
			Rasterizer3D.method3078(var17, var18, var19);
			Rasterizer3D.method3008(var21, var22, var23, var17, var18, var19, var4);
			Rasterizer3D.method3078(var17, var19, var20);
			Rasterizer3D.method3008(var21, var23, var24, var17, var19, var20, var4);
		}
	}
}
