import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
final class class1 implements class0 {
	@ObfuscatedName("ou")
	@ObfuscatedSignature(
		signature = "Lcz;"
	)
	@Export("varcs")
	static Varcs varcs;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lhq;"
	)
	@Export("InvDefinition_archive")
	public static AbstractArchive InvDefinition_archive;
	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "Llx;"
	)
	@Export("compass")
	static Sprite compass;

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkc;B)V",
		garbageValue = "25"
	)
	public void vmethod89(Object var1, Buffer var2) {
		this.method12((Integer)var1, var2);
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lkc;I)Ljava/lang/Object;",
		garbageValue = "242985434"
	)
	public Object vmethod74(Buffer var1) {
		return var1.readInt();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Integer;Lkc;I)V",
		garbageValue = "1640474163"
	)
	void method12(Integer var1, Buffer var2) {
		var2.writeInt(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "646080011"
	)
	public static int method26() {
		return KeyHandler.KeyHandler_idleCycles;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)Lbk;",
		garbageValue = "1796263151"
	)
	@Export("getNextWorldListWorld")
	static World getNextWorldListWorld() {
		return World.World_listCount < World.World_count ? Username.World_worlds[++World.World_listCount - 1] : null;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lks;Lks;Lks;I)V",
		garbageValue = "-196875939"
	)
	@Export("drawTitle")
	static void drawTitle(Font var0, Font var1, Font var2) {
		Login.xPadding = (class286.canvasWidth - 765) / 2;
		Login.loginBoxX = Login.xPadding + 202;
		class192.loginBoxCenter = Login.loginBoxX + 180;
		if (Login.worldSelectOpen) {
			UrlRequester.method3430(var0, var1);
		} else {
			Login.leftTitleSprite.drawAt(Login.xPadding, 0);
			FontName.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			Tiles.logoSprite.drawAt(Login.xPadding + 382 - Tiles.logoSprite.subWidth / 2, 18);
			int var4;
			if (Client.gameState == 0 || Client.gameState == 5) {
				byte var3 = 20;
				var0.drawCentered("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var3, 16777215, -1);
				var4 = 253 - var3;
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 152, var4, 304, 34, 9179409);
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 151, var4 + 1, 302, 32, 0);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150, var4 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150 + Login.Login_loadingPercent * 3, var4 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
				var0.drawCentered(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var3, 16777215, -1);
			}

			String var5;
			String var7;
			String var8;
			int var9;
			char[] var10;
			int var11;
			short var25;
			int var26;
			short var27;
			if (Client.gameState == 20) {
				NPC.titleboxSprite.drawAt(Login.loginBoxX + 180 - NPC.titleboxSprite.subWidth / 2, 271 - NPC.titleboxSprite.subHeight / 2);
				var25 = 201;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var25, 16776960, 0);
				var26 = var25 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var26, 16776960, 0);
				var26 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var26, 16776960, 0);
				var26 += 15;
				var26 += 7;
				if (Login.loginIndex != 4) {
					var0.draw("Login: ", Login.loginBoxX + 180 - 110, var26, 16777215, 0);
					var27 = 200;

					for (var5 = ScriptEvent.method1277(); var0.stringWidth(var5) > var27; var5 = var5.substring(0, var5.length() - 1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var5), Login.loginBoxX + 180 - 70, var26, 16777215, 0);
					var26 += 15;
					var7 = Login.Login_password;
					var9 = var7.length();
					var10 = new char[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						var10[var11] = '*';
					}

					var8 = new String(var10);

					for (var8 = var8; var0.stringWidth(var8) > var27; var8 = var8.substring(1)) {
					}

					var0.draw("Password: " + var8, Login.loginBoxX + 180 - 108, var26, 16777215, 0);
					var26 += 15;
				}
			}

			if (Client.gameState == 10 || Client.gameState == 11) {
				NPC.titleboxSprite.drawAt(Login.loginBoxX, 171);
				short var19;
				if (Login.loginIndex == 0) {
					var25 = 251;
					var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var25, 16776960, 0);
					var26 = var25 + 30;
					var4 = Login.loginBoxX + 180 - 80;
					var19 = 291;
					UserComparator9.titlebuttonSprite.drawAt(var4 - 73, var19 - 20);
					var0.drawLines("New User", var4 - 73, var19 - 20, 144, 40, 16777215, 0, 1, 1, 0);
					var4 = Login.loginBoxX + 180 + 80;
					UserComparator9.titlebuttonSprite.drawAt(var4 - 73, var19 - 20);
					var0.drawLines("Existing User", var4 - 73, var19 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				} else if (Login.loginIndex == 1) {
					var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
					var25 = 236;
					var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var25, 16777215, 0);
					var26 = var25 + 15;
					var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var26, 16777215, 0);
					var26 += 15;
					var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var26, 16777215, 0);
					var26 += 15;
					var4 = Login.loginBoxX + 180 - 80;
					var19 = 321;
					UserComparator9.titlebuttonSprite.drawAt(var4 - 73, var19 - 20);
					var0.drawCentered("Continue", var4, var19 + 5, 16777215, 0);
					var4 = Login.loginBoxX + 180 + 80;
					UserComparator9.titlebuttonSprite.drawAt(var4 - 73, var19 - 20);
					var0.drawCentered("Cancel", var4, var19 + 5, 16777215, 0);
				} else {
					IndexedSprite var29;
					if (Login.loginIndex == 2) {
						var25 = 201;
						var0.drawCentered(Login.Login_response1, class192.loginBoxCenter, var25, 16776960, 0);
						var26 = var25 + 15;
						var0.drawCentered(Login.Login_response2, class192.loginBoxCenter, var26, 16776960, 0);
						var26 += 15;
						var0.drawCentered(Login.Login_response3, class192.loginBoxCenter, var26, 16776960, 0);
						var26 += 15;
						var26 += 7;
						var0.draw("Login: ", class192.loginBoxCenter - 110, var26, 16777215, 0);
						var27 = 200;

						for (var5 = ScriptEvent.method1277(); var0.stringWidth(var5) > var27; var5 = var5.substring(1)) {
						}

						var0.draw(AbstractFont.escapeBrackets(var5) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? AbstractArchive.colorStartTag(16776960) + "|" : ""), class192.loginBoxCenter - 70, var26, 16777215, 0);
						var26 += 15;
						var7 = Login.Login_password;
						var9 = var7.length();
						var10 = new char[var9];

						for (var11 = 0; var11 < var9; ++var11) {
							var10[var11] = '*';
						}

						var8 = new String(var10);

						for (var8 = var8; var0.stringWidth(var8) > var27; var8 = var8.substring(1)) {
						}

						var0.draw("Password: " + var8 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? AbstractArchive.colorStartTag(16776960) + "|" : ""), class192.loginBoxCenter - 108, var26, 16777215, 0);
						var26 += 15;
						var25 = 277;
						var9 = class192.loginBoxCenter + -117;
						boolean var30 = Client.Login_isUsernameRemembered;
						boolean var12 = Login.field1159;
						var29 = var30 ? (var12 ? class4.field23 : Login.options_buttons_2Sprite) : (var12 ? class51.field412 : UserComparator8.options_buttons_0Sprite);
						var29.drawAt(var9, var25);
						var9 = var9 + var29.subWidth + 5;
						var1.draw("Remember username", var9, var25 + 13, 16776960, 0);
						var9 = class192.loginBoxCenter + 24;
						boolean var15 = ScriptEvent.clientPreferences.hideUsername;
						boolean var16 = Login.field1175;
						IndexedSprite var14 = var15 ? (var16 ? class4.field23 : Login.options_buttons_2Sprite) : (var16 ? class51.field412 : UserComparator8.options_buttons_0Sprite);
						var14.drawAt(var9, var25);
						var9 = var9 + var14.subWidth + 5;
						var1.draw("Hide username", var9, var25 + 13, 16776960, 0);
						var26 = var25 + 15;
						int var17 = class192.loginBoxCenter - 80;
						short var18 = 321;
						UserComparator9.titlebuttonSprite.drawAt(var17 - 73, var18 - 20);
						var0.drawCentered("Login", var17, var18 + 5, 16777215, 0);
						var17 = class192.loginBoxCenter + 80;
						UserComparator9.titlebuttonSprite.drawAt(var17 - 73, var18 - 20);
						var0.drawCentered("Cancel", var17, var18 + 5, 16777215, 0);
						var25 = 357;
						switch(Login.field1166) {
						case 2:
							VarbitDefinition.field3288 = "Having trouble logging in?";
							break;
						default:
							VarbitDefinition.field3288 = "Can't login? Click here.";
						}

						WorldMapLabel.field225 = new Bounds(class192.loginBoxCenter, var25, var1.stringWidth(VarbitDefinition.field3288), 11);
						WorldMapManager.field319 = new Bounds(class192.loginBoxCenter, var25, var1.stringWidth("Still having trouble logging in?"), 11);
						var1.drawCentered(VarbitDefinition.field3288, class192.loginBoxCenter, var25, 16777215, 0);
					} else if (Login.loginIndex == 3) {
						var25 = 201;
						var0.drawCentered("Invalid credentials.", Login.loginBoxX + 180, var25, 16776960, 0);
						var26 = var25 + 20;
						var1.drawCentered("For accounts created after 24th November 2010, please use your", Login.loginBoxX + 180, var26, 16776960, 0);
						var26 += 15;
						var1.drawCentered("email address to login. Otherwise please login with your username.", Login.loginBoxX + 180, var26, 16776960, 0);
						var26 += 15;
						var4 = Login.loginBoxX + 180;
						var19 = 276;
						UserComparator9.titlebuttonSprite.drawAt(var4 - 73, var19 - 20);
						var2.drawCentered("Try again", var4, var19 + 5, 16777215, 0);
						var4 = Login.loginBoxX + 180;
						var19 = 326;
						UserComparator9.titlebuttonSprite.drawAt(var4 - 73, var19 - 20);
						var2.drawCentered("Forgotten password?", var4, var19 + 5, 16777215, 0);
					} else if (Login.loginIndex == 4) {
						var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
						var25 = 236;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var25, 16777215, 0);
						var26 = var25 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var26, 16777215, 0);
						var26 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var26, 16777215, 0);
						var26 += 15;
						var5 = "PIN: ";
						var7 = class268.otp;
						var9 = var7.length();
						var10 = new char[var9];

						for (var11 = 0; var11 < var9; ++var11) {
							var10[var11] = '*';
						}

						var8 = new String(var10);
						var0.draw(var5 + var8 + (Client.cycle % 40 < 20 ? AbstractArchive.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var26, 16777215, 0);
						var26 -= 8;
						var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var26, 16776960, 0);
						var26 += 15;
						var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var26, 16776960, 0);
						int var23 = Login.loginBoxX + 180 - 9 + var0.stringWidth("for 30 days: ") + 15;
						var9 = var26 - var0.ascent;
						if (Login.field1177) {
							var29 = Login.options_buttons_2Sprite;
						} else {
							var29 = UserComparator8.options_buttons_0Sprite;
						}

						var29.drawAt(var23, var9);
						var26 += 15;
						var11 = Login.loginBoxX + 180 - 80;
						short var31 = 321;
						UserComparator9.titlebuttonSprite.drawAt(var11 - 73, var31 - 20);
						var0.drawCentered("Continue", var11, var31 + 5, 16777215, 0);
						var11 = Login.loginBoxX + 180 + 80;
						UserComparator9.titlebuttonSprite.drawAt(var11 - 73, var31 - 20);
						var0.drawCentered("Cancel", var11, var31 + 5, 16777215, 0);
						var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var31 + 36, 255, 0);
					} else if (Login.loginIndex == 5) {
						var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
						var25 = 221;
						var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var25, 16776960, 0);
						var26 = var25 + 15;
						var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var26, 16776960, 0);
						var26 += 15;
						var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var26, 16776960, 0);
						var26 += 15;
						var26 += 14;
						var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var26, 16777215, 0);
						var27 = 174;

						for (var5 = ScriptEvent.method1277(); var0.stringWidth(var5) > var27; var5 = var5.substring(1)) {
						}

						var0.draw(AbstractFont.escapeBrackets(var5) + (Client.cycle % 40 < 20 ? AbstractArchive.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var26, 16777215, 0);
						var26 += 15;
						int var6 = Login.loginBoxX + 180 - 80;
						short var24 = 321;
						UserComparator9.titlebuttonSprite.drawAt(var6 - 73, var24 - 20);
						var0.drawCentered("Recover", var6, var24 + 5, 16777215, 0);
						var6 = Login.loginBoxX + 180 + 80;
						UserComparator9.titlebuttonSprite.drawAt(var6 - 73, var24 - 20);
						var0.drawCentered("Back", var6, var24 + 5, 16777215, 0);
						var24 = 356;
						var1.drawCentered("Still having trouble logging in?", class192.loginBoxCenter, var24, 268435455, 0);
					} else if (Login.loginIndex == 6) {
						var25 = 201;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var25, 16776960, 0);
						var26 = var25 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var26, 16776960, 0);
						var26 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var26, 16776960, 0);
						var26 += 15;
						var4 = Login.loginBoxX + 180;
						var19 = 321;
						UserComparator9.titlebuttonSprite.drawAt(var4 - 73, var19 - 20);
						var0.drawCentered("Back", var4, var19 + 5, 16777215, 0);
					} else if (Login.loginIndex == 7) {
						var25 = 216;
						var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var25, 16776960, 0);
						var26 = var25 + 15;
						var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var26, 16776960, 0);
						var26 += 15;
						var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var26, 16776960, 0);
						var26 += 15;
						var4 = Login.loginBoxX + 180 - 80;
						var19 = 321;
						UserComparator9.titlebuttonSprite.drawAt(var4 - 73, var19 - 20);
						var0.drawCentered("Set Date of Birth", var4, var19 + 5, 16777215, 0);
						var4 = Login.loginBoxX + 180 + 80;
						UserComparator9.titlebuttonSprite.drawAt(var4 - 73, var19 - 20);
						var0.drawCentered("Back", var4, var19 + 5, 16777215, 0);
					} else if (Login.loginIndex == 8) {
						var25 = 216;
						var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var25, 16776960, 0);
						var26 = var25 + 15;
						var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var26, 16776960, 0);
						var26 += 15;
						var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var26, 16776960, 0);
						var26 += 15;
						var4 = Login.loginBoxX + 180 - 80;
						var19 = 321;
						UserComparator9.titlebuttonSprite.drawAt(var4 - 73, var19 - 20);
						var0.drawCentered("Privacy Policy", var4, var19 + 5, 16777215, 0);
						var4 = Login.loginBoxX + 180 + 80;
						UserComparator9.titlebuttonSprite.drawAt(var4 - 73, var19 - 20);
						var0.drawCentered("Back", var4, var19 + 5, 16777215, 0);
					} else if (Login.loginIndex == 12) {
						var25 = 201;
						String var22 = "";
						var5 = "";
						String var21 = "";
						switch(Login.field1156) {
						case 0:
							var22 = "Your account has been disabled.";
							var5 = Strings.field2797;
							var21 = "";
							break;
						case 1:
							var22 = "Account locked as we suspect it has been stolen.";
							var5 = Strings.field3006;
							var21 = "";
							break;
						default:
							UserComparator3.Login_promptCredentials(false);
						}

						var0.drawCentered(var22, Login.loginBoxX + 180, var25, 16776960, 0);
						var26 = var25 + 15;
						var2.drawCentered(var5, Login.loginBoxX + 180, var26, 16776960, 0);
						var26 += 15;
						var2.drawCentered(var21, Login.loginBoxX + 180, var26, 16776960, 0);
						var26 += 15;
						int var34 = Login.loginBoxX + 180;
						short var33 = 276;
						UserComparator9.titlebuttonSprite.drawAt(var34 - 73, var33 - 20);
						var0.drawCentered("Support Page", var34, var33 + 5, 16777215, 0);
						var34 = Login.loginBoxX + 180;
						var33 = 326;
						UserComparator9.titlebuttonSprite.drawAt(var34 - 73, var33 - 20);
						var0.drawCentered("Back", var34, var33 + 5, 16777215, 0);
					} else if (Login.loginIndex == 24) {
						var25 = 221;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var25, 16777215, 0);
						var26 = var25 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var26, 16777215, 0);
						var26 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var26, 16777215, 0);
						var26 += 15;
						var4 = Login.loginBoxX + 180;
						var19 = 301;
						UserComparator9.titlebuttonSprite.drawAt(var4 - 73, var19 - 20);
						var0.drawCentered("Ok", var4, var19 + 5, 16777215, 0);
					}
				}
			}

			if (Client.gameState >= 10) {
				int[] var20 = new int[4];
				Rasterizer2D.Rasterizer2D_getClipArray(var20);
				Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, FloorUnderlayDefinition.canvasHeight);
				Login.loginScreenRunesAnimation.draw(Login.xPadding - 22, Client.cycle);
				Login.loginScreenRunesAnimation.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
				Rasterizer2D.Rasterizer2D_setClipArray(var20);
			}

			Decimator.title_muteSprite[ScriptEvent.clientPreferences.titleMusicDisabled ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
			if (Client.gameState > 5 && Language.Language_EN == WorldMapSection1.clientLanguage) {
				if (Message.field587 != null) {
					var26 = Login.xPadding + 5;
					var27 = 463;
					byte var32 = 100;
					byte var28 = 35;
					Message.field587.drawAt(var26, var27);
					var0.drawCentered("World" + " " + Client.worldId, var32 / 2 + var26, var28 / 2 + var27 - 2, 16777215, 0);
					if (class96.World_request != null) {
						var1.drawCentered("Loading...", var32 / 2 + var26, var28 / 2 + var27 + 12, 16777215, 0);
					} else {
						var1.drawCentered("Click to switch", var32 / 2 + var26, var28 / 2 + var27 + 12, 16777215, 0);
					}
				} else {
					Message.field587 = ClientPacket.SpriteBuffer_getIndexedSpriteByName(GrandExchangeOfferUnitPriceComparator.archive8, "sl_button", "");
				}
			}

		}
	}

	@ObfuscatedName("fx")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "12"
	)
	@Export("logOut")
	static final void logOut() {
		Client.packetWriter.close();
		FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
		Login.method2258();
		WorldMapCacheName.method682();
		ObjectDefinition.ObjectDefinition_cached.clear();
		ObjectDefinition.ObjectDefinition_cachedModelData.clear();
		ObjectDefinition.ObjectDefinition_cachedEntities.clear();
		ObjectDefinition.ObjectDefinition_cachedModels.clear();
		NPCDefinition.NpcDefinition_cached.clear();
		NPCDefinition.NpcDefinition_cachedModels.clear();
		FriendSystem.method2038();
		BuddyRankComparator.method3568();
		class81.method2207();
		VarbitDefinition.VarbitDefinition_cached.clear();
		WorldMapRectangle.method331();
		HitSplatDefinition.HitSplatDefinition_cached.clear();
		HitSplatDefinition.HitSplatDefinition_cachedSprites.clear();
		HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
		HealthBarDefinition.HealthBarDefinition_cached.clear();
		HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
		StructDefinition.StructDefinition_cached.clear();
		ParamDefinition.ParamDefinition_cached.clear();
		MusicPatchNode.method3973();
		DirectByteArrayCopier.method4101();
		Widget.Widget_cachedSprites.clear();
		Widget.Widget_cachedModels.clear();
		Widget.Widget_cachedFonts.clear();
		Widget.Widget_cachedSpriteMasks.clear();
		((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).clear();
		Script.Script_cached.clear();
		BuddyRankComparator.archive0.clearFiles();
		LoginPacket.archive1.clearFiles();
		SpriteMask.archive3.clearFiles();
		NetFileRequest.archive4.clearFiles();
		WorldMapRectangle.archive5.clearFiles();
		class216.archive6.clearFiles();
		Language.archive7.clearFiles();
		GrandExchangeOfferUnitPriceComparator.archive8.clearFiles();
		WorldMapSprite.archive9.clearFiles();
		WorldMapID.archive10.clearFiles();
		Decimator.archive11.clearFiles();
		Occluder.archive12.clearFiles();
		WorldMapArea.scene.clear();

		for (int var0 = 0; var0 < 4; ++var0) {
			Client.collisionMaps[var0].clear();
		}

		System.gc();
		class80.method2194(2);
		Client.currentTrackGroupId = -1;
		Client.field855 = false;
		GameShell.method1141();
		Tile.updateGameState(10);
	}
}
