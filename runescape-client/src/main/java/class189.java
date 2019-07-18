import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class189 {
	@ObfuscatedName("c")
	@Export("ByteArrayPool_arrays")
	public static byte[][][] ByteArrayPool_arrays;

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Lke;Lke;Lke;B)V",
		garbageValue = "49"
	)
	@Export("drawTitle")
	static void drawTitle(Font var0, Font var1, Font var2) {
		Login.xPadding = (GrandExchangeEvent.canvasWidth - 765) / 2;
		Login.loginBoxX = Login.xPadding + 202;
		ScriptEvent.loginBoxCenter = Login.loginBoxX + 180;
		if (Login.worldSelectOpen) {
			class188.method3643(var0, var1);
		} else {
			GrandExchangeOfferWorldComparator.leftTitleSprite.drawAt(Login.xPadding, 0);
			NPC.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			GroundItem.logoSprite.drawAt(Login.xPadding + 382 - GroundItem.logoSprite.subWidth / 2, 18);
			int var4;
			if (Client.gameState == 0 || Client.gameState == 5) {
				byte var3 = 20;
				var0.drawCentered("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var3, 16777215, -1);
				var4 = 253 - var3;
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 152, var4, 304, 34, 9179409);
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 151, var4 + 1, 302, 32, 0);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150, var4 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.Login_loadingPercent * 3 + (Login.loginBoxX + 180 - 150), var4 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
				var0.drawCentered(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var3, 16777215, -1);
			}

			String var5;
			String var6;
			short var22;
			int var23;
			short var24;
			if (Client.gameState == 20) {
				Login.titleboxSprite.drawAt(Login.loginBoxX + 180 - Login.titleboxSprite.subWidth / 2, 271 - Login.titleboxSprite.subHeight / 2);
				var22 = 201;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16776960, 0);
				var23 = var22 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16776960, 0);
				var23 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16776960, 0);
				var23 += 15;
				var23 += 7;
				if (Login.loginIndex != 4) {
					var0.draw("Login: ", Login.loginBoxX + 180 - 110, var23, 16777215, 0);
					var24 = 200;
					var5 = WorldMapLabelSize.clientPreferences.hideUsername ? ClientPacket.method3612(Login.Login_username) : Login.Login_username;

					for (var6 = var5; var0.stringWidth(var6) > var24; var6 = var6.substring(0, var6.length() - 1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var6), Login.loginBoxX + 180 - 70, var23, 16777215, 0);
					var23 += 15;
					var0.draw("Password: " + ClientPacket.method3612(Login.Login_password), Login.loginBoxX + 180 - 108, var23, 16777215, 0);
					var23 += 15;
				}
			}

			if (Client.gameState == 10 || Client.gameState == 11) {
				Login.titleboxSprite.drawAt(Login.loginBoxX, 171);
				short var17;
				if (Login.loginIndex == 0) {
					var22 = 251;
					var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var22, 16776960, 0);
					var23 = var22 + 30;
					var4 = Login.loginBoxX + 180 - 80;
					var17 = 291;
					VarpDefinition.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
					var0.drawLines("New User", var4 - 73, var17 - 20, 144, 40, 16777215, 0, 1, 1, 0);
					var4 = Login.loginBoxX + 180 + 80;
					VarpDefinition.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
					var0.drawLines("Existing User", var4 - 73, var17 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				} else if (Login.loginIndex == 1) {
					var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
					var22 = 236;
					var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16777215, 0);
					var23 = var22 + 15;
					var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16777215, 0);
					var23 += 15;
					var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16777215, 0);
					var23 += 15;
					var4 = Login.loginBoxX + 180 - 80;
					var17 = 321;
					VarpDefinition.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
					var0.drawCentered("Continue", var4, var17 + 5, 16777215, 0);
					var4 = Login.loginBoxX + 180 + 80;
					VarpDefinition.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
					var0.drawCentered("Cancel", var4, var17 + 5, 16777215, 0);
				} else {
					int var7;
					if (Login.loginIndex == 2) {
						var22 = 201;
						var0.drawCentered(Login.Login_response1, ScriptEvent.loginBoxCenter, var22, 16776960, 0);
						var23 = var22 + 15;
						var0.drawCentered(Login.Login_response2, ScriptEvent.loginBoxCenter, var23, 16776960, 0);
						var23 += 15;
						var0.drawCentered(Login.Login_response3, ScriptEvent.loginBoxCenter, var23, 16776960, 0);
						var23 += 15;
						var23 += 7;
						var0.draw("Login: ", ScriptEvent.loginBoxCenter - 110, var23, 16777215, 0);
						var24 = 200;
						var5 = WorldMapLabelSize.clientPreferences.hideUsername ? ClientPacket.method3612(Login.Login_username) : Login.Login_username;

						for (var6 = var5; var0.stringWidth(var6) > var24; var6 = var6.substring(1)) {
						}

						var0.draw(AbstractFont.escapeBrackets(var6) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? ClientPreferences.colorStartTag(16776960) + "|" : ""), ScriptEvent.loginBoxCenter - 70, var23, 16777215, 0);
						var23 += 15;
						var0.draw("Password: " + ClientPacket.method3612(Login.Login_password) + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? ClientPreferences.colorStartTag(16776960) + "|" : ""), ScriptEvent.loginBoxCenter - 108, var23, 16777215, 0);
						var23 += 15;
						var22 = 277;
						var7 = ScriptEvent.loginBoxCenter + -117;
						boolean var9 = Client.Login_isUsernameRemembered;
						boolean var10 = Login.field1199;
						IndexedSprite var8 = var9 ? (var10 ? Login.field1185 : Decimator.options_buttons_2Sprite) : (var10 ? Message.field606 : Login.options_buttons_0Sprite);
						var8.drawAt(var7, var22);
						var7 = var7 + var8.subWidth + 5;
						var1.draw("Remember username", var7, var22 + 13, 16776960, 0);
						var7 = ScriptEvent.loginBoxCenter + 24;
						boolean var13 = WorldMapLabelSize.clientPreferences.hideUsername;
						boolean var14 = Login.field1184;
						IndexedSprite var12 = var13 ? (var14 ? Login.field1185 : Decimator.options_buttons_2Sprite) : (var14 ? Message.field606 : Login.options_buttons_0Sprite);
						var12.drawAt(var7, var22);
						var7 = var7 + var12.subWidth + 5;
						var1.draw("Hide username", var7, var22 + 13, 16776960, 0);
						var23 = var22 + 15;
						int var15 = ScriptEvent.loginBoxCenter - 80;
						short var16 = 321;
						VarpDefinition.titlebuttonSprite.drawAt(var15 - 73, var16 - 20);
						var0.drawCentered("Login", var15, var16 + 5, 16777215, 0);
						var15 = ScriptEvent.loginBoxCenter + 80;
						VarpDefinition.titlebuttonSprite.drawAt(var15 - 73, var16 - 20);
						var0.drawCentered("Cancel", var15, var16 + 5, 16777215, 0);
						var22 = 357;
						switch(Login.field1212) {
						case 2:
							UserComparator5.field1986 = "Having trouble logging in?";
							break;
						default:
							UserComparator5.field1986 = "Can't login? Click here.";
						}

						class96.field1325 = new Bounds(ScriptEvent.loginBoxCenter, var22, var1.stringWidth(UserComparator5.field1986), 11);
						WorldMapAreaData.field332 = new Bounds(ScriptEvent.loginBoxCenter, var22, var1.stringWidth("Still having trouble logging in?"), 11);
						var1.drawCentered(UserComparator5.field1986, ScriptEvent.loginBoxCenter, var22, 16777215, 0);
					} else if (Login.loginIndex == 3) {
						var22 = 201;
						var0.drawCentered("Invalid credentials.", Login.loginBoxX + 180, var22, 16776960, 0);
						var23 = var22 + 20;
						var1.drawCentered("For accounts created after 24th November 2010, please use your", Login.loginBoxX + 180, var23, 16776960, 0);
						var23 += 15;
						var1.drawCentered("email address to login. Otherwise please login with your username.", Login.loginBoxX + 180, var23, 16776960, 0);
						var23 += 15;
						var4 = Login.loginBoxX + 180;
						var17 = 276;
						VarpDefinition.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
						var2.drawCentered("Try again", var4, var17 + 5, 16777215, 0);
						var4 = Login.loginBoxX + 180;
						var17 = 326;
						VarpDefinition.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
						var2.drawCentered("Forgotten password?", var4, var17 + 5, 16777215, 0);
					} else {
						short var20;
						if (Login.loginIndex == 4) {
							var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
							var22 = 236;
							var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16777215, 0);
							var23 = var22 + 15;
							var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16777215, 0);
							var23 += 15;
							var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16777215, 0);
							var23 += 15;
							var0.draw("PIN: " + ClientPacket.method3612(WorldMapManager.otp) + (Client.cycle % 40 < 20 ? ClientPreferences.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var23, 16777215, 0);
							var23 -= 8;
							var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var23, 16776960, 0);
							var23 += 15;
							var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var23, 16776960, 0);
							var4 = Login.loginBoxX + 180 - 9 + var0.stringWidth("for 30 days: ") + 15;
							int var26 = var23 - var0.ascent;
							IndexedSprite var25;
							if (Login.field1201) {
								var25 = Decimator.options_buttons_2Sprite;
							} else {
								var25 = Login.options_buttons_0Sprite;
							}

							var25.drawAt(var4, var26);
							var23 += 15;
							var7 = Login.loginBoxX + 180 - 80;
							var20 = 321;
							VarpDefinition.titlebuttonSprite.drawAt(var7 - 73, var20 - 20);
							var0.drawCentered("Continue", var7, var20 + 5, 16777215, 0);
							var7 = Login.loginBoxX + 180 + 80;
							VarpDefinition.titlebuttonSprite.drawAt(var7 - 73, var20 - 20);
							var0.drawCentered("Cancel", var7, var20 + 5, 16777215, 0);
							var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var20 + 36, 255, 0);
						} else if (Login.loginIndex == 5) {
							var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
							var22 = 221;
							var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16776960, 0);
							var23 = var22 + 15;
							var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16776960, 0);
							var23 += 15;
							var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16776960, 0);
							var23 += 15;
							var23 += 14;
							var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var23, 16777215, 0);
							var24 = 174;
							var5 = WorldMapLabelSize.clientPreferences.hideUsername ? ClientPacket.method3612(Login.Login_username) : Login.Login_username;

							for (var6 = var5; var0.stringWidth(var6) > var24; var6 = var6.substring(1)) {
							}

							var0.draw(AbstractFont.escapeBrackets(var6) + (Client.cycle % 40 < 20 ? ClientPreferences.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var23, 16777215, 0);
							var23 += 15;
							var7 = Login.loginBoxX + 180 - 80;
							var20 = 321;
							VarpDefinition.titlebuttonSprite.drawAt(var7 - 73, var20 - 20);
							var0.drawCentered("Recover", var7, var20 + 5, 16777215, 0);
							var7 = Login.loginBoxX + 180 + 80;
							VarpDefinition.titlebuttonSprite.drawAt(var7 - 73, var20 - 20);
							var0.drawCentered("Back", var7, var20 + 5, 16777215, 0);
							var20 = 356;
							var1.drawCentered("Still having trouble logging in?", ScriptEvent.loginBoxCenter, var20, 268435455, 0);
						} else if (Login.loginIndex == 6) {
							var22 = 201;
							var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16776960, 0);
							var23 = var22 + 15;
							var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16776960, 0);
							var23 += 15;
							var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16776960, 0);
							var23 += 15;
							var4 = Login.loginBoxX + 180;
							var17 = 321;
							VarpDefinition.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
							var0.drawCentered("Back", var4, var17 + 5, 16777215, 0);
						} else if (Login.loginIndex == 7) {
							var22 = 216;
							var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var22, 16776960, 0);
							var23 = var22 + 15;
							var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var23, 16776960, 0);
							var23 += 15;
							var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var23, 16776960, 0);
							var23 += 15;
							var4 = Login.loginBoxX + 180 - 80;
							var17 = 321;
							VarpDefinition.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
							var0.drawCentered("Set Date of Birth", var4, var17 + 5, 16777215, 0);
							var4 = Login.loginBoxX + 180 + 80;
							VarpDefinition.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
							var0.drawCentered("Back", var4, var17 + 5, 16777215, 0);
						} else if (Login.loginIndex == 8) {
							var22 = 216;
							var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var22, 16776960, 0);
							var23 = var22 + 15;
							var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var23, 16776960, 0);
							var23 += 15;
							var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var23, 16776960, 0);
							var23 += 15;
							var4 = Login.loginBoxX + 180 - 80;
							var17 = 321;
							VarpDefinition.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
							var0.drawCentered("Privacy Policy", var4, var17 + 5, 16777215, 0);
							var4 = Login.loginBoxX + 180 + 80;
							VarpDefinition.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
							var0.drawCentered("Back", var4, var17 + 5, 16777215, 0);
						} else if (Login.loginIndex == 12) {
							var22 = 201;
							String var21 = "";
							var5 = "";
							var6 = "";
							switch(Login.field1182) {
							case 0:
								var21 = "Your account has been disabled.";
								var5 = Strings.field2811;
								var6 = "";
								break;
							case 1:
								var21 = "Account locked as we suspect it has been stolen.";
								var5 = Strings.field2961;
								var6 = "";
								break;
							default:
								FaceNormal.method3266(false);
							}

							var0.drawCentered(var21, Login.loginBoxX + 180, var22, 16776960, 0);
							var23 = var22 + 15;
							var2.drawCentered(var5, Login.loginBoxX + 180, var23, 16776960, 0);
							var23 += 15;
							var2.drawCentered(var6, Login.loginBoxX + 180, var23, 16776960, 0);
							var23 += 15;
							var7 = Login.loginBoxX + 180;
							var20 = 276;
							VarpDefinition.titlebuttonSprite.drawAt(var7 - 73, var20 - 20);
							var0.drawCentered("Support Page", var7, var20 + 5, 16777215, 0);
							var7 = Login.loginBoxX + 180;
							var20 = 326;
							VarpDefinition.titlebuttonSprite.drawAt(var7 - 73, var20 - 20);
							var0.drawCentered("Back", var7, var20 + 5, 16777215, 0);
						} else if (Login.loginIndex == 24) {
							var22 = 221;
							var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var22, 16777215, 0);
							var23 = var22 + 15;
							var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var23, 16777215, 0);
							var23 += 15;
							var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var23, 16777215, 0);
							var23 += 15;
							var4 = Login.loginBoxX + 180;
							var17 = 301;
							VarpDefinition.titlebuttonSprite.drawAt(var4 - 73, var17 - 20);
							var0.drawCentered("Ok", var4, var17 + 5, 16777215, 0);
						}
					}
				}
			}

			if (Client.gameState >= 10) {
				int[] var18 = new int[4];
				Rasterizer2D.Rasterizer2D_getClipArray(var18);
				Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, ParamDefinition.canvasHeight);
				Ignored.loginScreenRunesAnimation.draw(Login.xPadding - 22, Client.cycle);
				Ignored.loginScreenRunesAnimation.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
				Rasterizer2D.Rasterizer2D_setClipArray(var18);
			}

			Login.title_muteSprite[WorldMapLabelSize.clientPreferences.titleMusicDisabled ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
			if (Client.gameState > 5 && ScriptFrame.field528 == class190.field2348) {
				if (class30.field264 != null) {
					var23 = Login.xPadding + 5;
					var24 = 463;
					byte var27 = 100;
					byte var19 = 35;
					class30.field264.drawAt(var23, var24);
					var0.drawCentered("World" + " " + Client.worldId, var27 / 2 + var23, var19 / 2 + var24 - 2, 16777215, 0);
					if (World.field1027 != null) {
						var1.drawCentered("Loading...", var27 / 2 + var23, var19 / 2 + var24 + 12, 16777215, 0);
					} else {
						var1.drawCentered("Click to switch", var27 / 2 + var23, var19 / 2 + var24 + 12, 16777215, 0);
					}
				} else {
					class30.field264 = class215.loadIndexedSpriteByName(Client.archive8, "sl_button", "");
				}
			}

		}
	}
}
