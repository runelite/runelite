import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
@Implements("LoginPacket")
public class LoginPacket implements class181 {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	public static final LoginPacket field2289;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	static final LoginPacket field2288;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	public static final LoginPacket field2287;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	public static final LoginPacket field2290;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lge;"
	)
	static final LoginPacket field2291;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "[Lge;"
	)
	@Export("LoginPacket_indexedValues")
	static final LoginPacket[] LoginPacket_indexedValues;
	@ObfuscatedName("ff")
	@ObfuscatedSignature(
		signature = "Lfv;"
	)
	@Export("socketTask")
	static Task socketTask;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1737377539
	)
	@Export("id")
	public final int id;

	static {
		field2289 = new LoginPacket(14, 0);
		field2288 = new LoginPacket(15, 4);
		field2287 = new LoginPacket(16, -2);
		field2290 = new LoginPacket(18, -2);
		field2291 = new LoginPacket(27, 0);
		LoginPacket_indexedValues = new LoginPacket[32];
		LoginPacket[] var0 = class192.method3649();

		for (int var1 = 0; var1 < var0.length; ++var1) {
			LoginPacket_indexedValues[var0[var1].id] = var0[var1];
		}

	}

	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "0"
	)
	LoginPacket(int var1, int var2) {
		this.id = var1;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(II)Lcu;",
		garbageValue = "-1747084073"
	)
	@Export("getScript")
	static Script getScript(int var0) {
		Script var1 = (Script)Script.Script_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = GrandExchangeOfferOwnWorldComparator.archive12.takeFile(var0, 0);
			if (var2 == null) {
				return null;
			} else {
				var1 = class3.newScript(var2);
				Script.Script_cached.put(var1, (long)var0);
				return var1;
			}
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lbh;S)V",
		garbageValue = "21228"
	)
	@Export("doCycleTitle")
	static void doCycleTitle(GameShell var0) {
		if (Login.worldSelectOpen) {
			while (DynamicObject.isKeyDown()) {
				if (SecureRandomFuture.field1230 == 13) {
					Coord.closeWorldSelect();
					return;
				} else if (SecureRandomFuture.field1230 == 96) {
					if (Login.worldSelectPage > 0) {
						if (WorldMapIcon_0.worldSelectLeftSprite != null) {
							--Login.worldSelectPage;
						}
					}
				} else if (SecureRandomFuture.field1230 == 97) {
					if (Login.worldSelectPage < Login.worldSelectPagesCount) {
						if (HealthBar.worldSelectRightSprite != null) {
							++Login.worldSelectPage;
						}
					}
				}
			}

			if (MouseHandler.MouseHandler_lastButton != 1 && (WorldMapIcon_1.mouseCam || MouseHandler.MouseHandler_lastButton != 4)) {
				return;
			}

			int var1 = Login.xPadding + 280;
			if (MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var1 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class192.changeWorldSelectSorting(0, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var1 + 15 && MouseHandler.MouseHandler_lastPressedX <= var1 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class192.changeWorldSelectSorting(0, 1);
				return;
			}

			int var2 = Login.xPadding + 390;
			if (MouseHandler.MouseHandler_lastPressedX >= var2 && MouseHandler.MouseHandler_lastPressedX <= var2 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class192.changeWorldSelectSorting(1, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var2 + 15 && MouseHandler.MouseHandler_lastPressedX <= var2 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class192.changeWorldSelectSorting(1, 1);
				return;
			}

			int var17 = Login.xPadding + 500;
			if (MouseHandler.MouseHandler_lastPressedX >= var17 && MouseHandler.MouseHandler_lastPressedX <= var17 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class192.changeWorldSelectSorting(2, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var17 + 15 && MouseHandler.MouseHandler_lastPressedX <= var17 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class192.changeWorldSelectSorting(2, 1);
				return;
			}

			int var4 = Login.xPadding + 610;
			if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class192.changeWorldSelectSorting(3, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class192.changeWorldSelectSorting(3, 1);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
				Coord.closeWorldSelect();
				return;
			}

			if (Login.hoveredWorldIndex != -1) {
				World var5 = World.World_worlds[Login.hoveredWorldIndex];
				class4.changeWorld(var5);
				Coord.closeWorldSelect();
				return;
			}

			if (Login.worldSelectPage > 0 && WorldMapIcon_0.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= WorldMapIcon_0.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= WallDecoration.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= WallDecoration.canvasHeight / 2 + 50) {
				--Login.worldSelectPage;
			}

			if (Login.worldSelectPage < Login.worldSelectPagesCount && HealthBar.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= FloorDecoration.canvasWidth - HealthBar.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= FloorDecoration.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= WallDecoration.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= WallDecoration.canvasHeight / 2 + 50) {
				++Login.worldSelectPage;
			}
			return;
		}

		if ((MouseHandler.MouseHandler_lastButton == 1 || !WorldMapIcon_1.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
			AbstractArchive.clientPreferences.titleMusicDisabled = !AbstractArchive.clientPreferences.titleMusicDisabled;
			Language.savePreferences();
			if (!AbstractArchive.clientPreferences.titleMusicDisabled) {
				UserComparator4.method3349(class225.archive6, "scape main", "", 255, false);
			} else {
				VertexNormal.method2960();
			}
		}

		if (Client.gameState == 5) {
			return;
		}

		if (Login.field1181 == -1L) {
			Login.field1181 = class30.currentTimeMillis() + 1000L;
		}

		long var12 = class30.currentTimeMillis();
		boolean var3;
		if (Client.archiveLoaders == null || Client.archiveLoadersDone >= Client.archiveLoaders.size()) {
			var3 = true;
		} else {
			while (true) {
				if (Client.archiveLoadersDone >= Client.archiveLoaders.size()) {
					var3 = true;
					break;
				}

				ArchiveLoader var15 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoadersDone);
				if (!var15.isLoaded()) {
					var3 = false;
					break;
				}

				++Client.archiveLoadersDone;
			}
		}

		if (var3 && Login.field1177 == -1L) {
			Login.field1177 = var12;
			if (Login.field1177 > Login.field1181) {
				Login.field1181 = Login.field1177;
			}
		}

		if (Client.gameState != 10 && Client.gameState != 11) {
			return;
		}
		if (WorldMapLabelSize.clientLanguage == Language.Language_EN) {
			if (MouseHandler.MouseHandler_lastButton == 1 || !WorldMapIcon_1.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
				int var4 = Login.xPadding + 5;
				short var14 = 463;
				byte var6 = 100;
				byte var7 = 35;
				if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var6 + var4 && MouseHandler.MouseHandler_lastPressedY >= var14 && MouseHandler.MouseHandler_lastPressedY <= var14 + var7) {
					if (BufferedNetSocket.loadWorlds()) {
						Login.worldSelectOpen = true;
						Login.worldSelectPage = 0;
						Login.worldSelectPagesCount = 0;
					}

					return;
				}
			}

			if (class51.World_request != null && BufferedNetSocket.loadWorlds()) {
				Login.worldSelectOpen = true;
				Login.worldSelectPage = 0;
				Login.worldSelectPagesCount = 0;
			}
		}

		int var4 = MouseHandler.MouseHandler_lastButton;
		int var25 = MouseHandler.MouseHandler_lastPressedX;
		int var18 = MouseHandler.MouseHandler_lastPressedY;
		if (var4 == 0) {
			var25 = MouseHandler.MouseHandler_x;
			var18 = MouseHandler.MouseHandler_y;
		}

		if (!WorldMapIcon_1.mouseCam && var4 == 4) {
			var4 = 1;
		}

		if (Login.loginIndex == 0) {
			boolean var19 = false;

			while (DynamicObject.isKeyDown()) {
				if (SecureRandomFuture.field1230 == 84) {
					var19 = true;
				}
			}

			int var8 = GrandExchangeOfferUnitPriceComparator.loginBoxCenter - 80;
			short var9 = 291;
			if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
				ArchiveDiskActionHandler.openURL(FaceNormal.method3229("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
			}

			var8 = GrandExchangeOfferUnitPriceComparator.loginBoxCenter + 80;
			if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20 || var19) {
				if ((Client.worldProperties & 33554432) != 0) {
					Login.Login_response0 = "";
					Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
					Login.Login_response2 = "Your normal account will not be affected.";
					Login.Login_response3 = "";
					Login.loginIndex = 1;
					if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
						Login.currentLoginField = 1;
					} else {
						Login.currentLoginField = 0;
					}
				} else if ((Client.worldProperties & 4) != 0) {
					if ((Client.worldProperties & 1024) != 0) {
						Login.Login_response1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
						Login.Login_response2 = "Players can attack each other almost everywhere";
						Login.Login_response3 = "and the Protect Item prayer won't work.";
					} else {
						Login.Login_response1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
						Login.Login_response2 = "Players can attack each other";
						Login.Login_response3 = "almost everywhere.";
					}

					Login.Login_response0 = "Warning!";
					Login.loginIndex = 1;
					if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
						Login.currentLoginField = 1;
					} else {
						Login.currentLoginField = 0;
					}
				} else if ((Client.worldProperties & 1024) != 0) {
					Login.Login_response1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
					Login.Login_response2 = "The Protect Item prayer will";
					Login.Login_response3 = "not work on this world.";
					Login.Login_response0 = "Warning!";
					Login.loginIndex = 1;
					if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
						Login.currentLoginField = 1;
					} else {
						Login.currentLoginField = 0;
					}
				} else {
					TilePaint.Login_promptCredentials(false);
				}
			}
		} else if (Login.loginIndex == 1) {
			while (DynamicObject.isKeyDown()) {
				if (SecureRandomFuture.field1230 == 84) {
					TilePaint.Login_promptCredentials(false);
				} else if (SecureRandomFuture.field1230 == 13) {
					Login.loginIndex = 0;
				}
			}

			int var20 = GrandExchangeOfferUnitPriceComparator.loginBoxCenter - 80;
			short var22 = 321;
			if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
				TilePaint.Login_promptCredentials(false);
			}

			var20 = GrandExchangeOfferUnitPriceComparator.loginBoxCenter + 80;
			if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
				Login.loginIndex = 0;
			}
		} else if (Login.loginIndex == 2) {
			short var21 = 201;
			int var20 = var21 + 52;
			if (var4 == 1 && var18 >= var20 - 12 && var18 < var20 + 2) {
				Login.currentLoginField = 0;
			}

			var20 += 15;
			if (var4 == 1 && var18 >= var20 - 12 && var18 < var20 + 2) {
				Login.currentLoginField = 1;
			}

			var20 += 15;
			var21 = 361;
			if (LoginScreenAnimation.field1032 != null) {
				int var8 = LoginScreenAnimation.field1032.highX / 2;
				if (var4 == 1 && var25 >= LoginScreenAnimation.field1032.lowX - var8 && var25 <= var8 + LoginScreenAnimation.field1032.lowX && var18 >= var21 - 15 && var18 < var21) {
					switch (Login.field1171) {
						case 1:
							PlayerType.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
							Login.loginIndex = 5;
							return;
						case 2:
							ArchiveDiskActionHandler.openURL("https://support.runescape.com/hc/en-gb", true, false);
					}
				}
			}

			int var8 = GrandExchangeOfferUnitPriceComparator.loginBoxCenter - 80;
			short var9 = 321;
			if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
				Login.Login_username = Login.Login_username.trim();
				if (Login.Login_username.length() == 0) {
					PlayerType.setLoginResponseString("", "Please enter your username/email address.", "");
					return;
				}

				if (Login.Login_password.length() == 0) {
					PlayerType.setLoginResponseString("", "Please enter your password.", "");
					return;
				}

				PlayerType.setLoginResponseString("", "Connecting to server...", "");
				PlayerType.method4104(false);
				MouseRecorder.updateGameState(20);
				return;
			}

			var8 = Login.loginBoxX + 180 + 80;
			if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
				Login.loginIndex = 0;
				Login.Login_username = "";
				Login.Login_password = "";
				class185.field2305 = 0;
				DesktopPlatformInfoProvider.otp = "";
				Login.field1183 = true;
			}

			var8 = GrandExchangeOfferUnitPriceComparator.loginBoxCenter + -117;
			var9 = 277;
			Login.field1176 = var25 >= var8 && var25 < var8 + class83.field1145 && var18 >= var9 && var18 < var9 + WorldMapCacheName.field286;
			if (var4 == 1 && Login.field1176) {
				Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
				if (!Client.Login_isUsernameRemembered && AbstractArchive.clientPreferences.rememberedUsername != null) {
					AbstractArchive.clientPreferences.rememberedUsername = null;
					Language.savePreferences();
				}
			}

			var8 = GrandExchangeOfferUnitPriceComparator.loginBoxCenter + 24;
			var9 = 277;
			Login.field1192 = var25 >= var8 && var25 < var8 + class83.field1145 && var18 >= var9 && var18 < var9 + WorldMapCacheName.field286;
			if (var4 == 1 && Login.field1192) {
				AbstractArchive.clientPreferences.hideUsername = !AbstractArchive.clientPreferences.hideUsername;
				if (!AbstractArchive.clientPreferences.hideUsername) {
					Login.Login_username = "";
					AbstractArchive.clientPreferences.rememberedUsername = null;
					if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
						Login.currentLoginField = 1;
					} else {
						Login.currentLoginField = 0;
					}
				}

				Language.savePreferences();
			}

			while (DynamicObject.isKeyDown()) {
				boolean var10 = false;

				for (int var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var11) {
					if (KeyHandler.field381 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var11)) {
						var10 = true;
						break;
					}
				}

				if (SecureRandomFuture.field1230 == 13) {
					Login.loginIndex = 0;
					Login.Login_username = "";
					Login.Login_password = "";
					class185.field2305 = 0;
					DesktopPlatformInfoProvider.otp = "";
					Login.field1183 = true;
				} else if (Login.currentLoginField == 0) {
					if (SecureRandomFuture.field1230 == 85 && Login.Login_username.length() > 0) {
						Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
					}

					if (SecureRandomFuture.field1230 == 84 || SecureRandomFuture.field1230 == 80) {
						Login.currentLoginField = 1;
					}

					if (var10 && Login.Login_username.length() < 320) {
						Login.Login_username = Login.Login_username + KeyHandler.field381;
					}
				} else if (Login.currentLoginField == 1) {
					if (SecureRandomFuture.field1230 == 85 && Login.Login_password.length() > 0) {
						Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
					}

					if (SecureRandomFuture.field1230 == 84 || SecureRandomFuture.field1230 == 80) {
						Login.currentLoginField = 0;
					}

					if (SecureRandomFuture.field1230 == 84) {
						Login.Login_username = Login.Login_username.trim();
						if (Login.Login_username.length() == 0) {
							PlayerType.setLoginResponseString("", "Please enter your username/email address.", "");
							return;
						}

						if (Login.Login_password.length() == 0) {
							PlayerType.setLoginResponseString("", "Please enter your password.", "");
							return;
						}

						PlayerType.setLoginResponseString("", "Connecting to server...", "");
						PlayerType.method4104(false);
						MouseRecorder.updateGameState(20);
						return;
					}

					if (var10 && Login.Login_password.length() < 20) {
						Login.Login_password = Login.Login_password + KeyHandler.field381;
					}
				}
			}
		} else if (Login.loginIndex == 3) {
			int var20 = Login.loginBoxX + 180;
			short var22 = 276;
			if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
				TilePaint.Login_promptCredentials(false);
			}

			var20 = Login.loginBoxX + 180;
			var22 = 326;
			if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
				PlayerType.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
				Login.loginIndex = 5;
			}
		} else if (Login.loginIndex == 4) {
			int var20 = Login.loginBoxX + 180 - 80;
			short var22 = 321;
			if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
				DesktopPlatformInfoProvider.otp.trim();
				if (DesktopPlatformInfoProvider.otp.length() != 6) {
					PlayerType.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
					return;
				}

				class185.field2305 = Integer.parseInt(DesktopPlatformInfoProvider.otp);
				DesktopPlatformInfoProvider.otp = "";
				PlayerType.method4104(true);
				PlayerType.setLoginResponseString("", "Connecting to server...", "");
				MouseRecorder.updateGameState(20);
				return;
			}

			if (var4 == 1 && var25 >= Login.loginBoxX + 180 - 9 && var25 <= Login.loginBoxX + 180 + 130 && var18 >= 263 && var18 <= 296) {
				Login.field1183 = !Login.field1183;
			}

			if (var4 == 1 && var25 >= Login.loginBoxX + 180 - 34 && var25 <= Login.loginBoxX + 34 + 180 && var18 >= 351 && var18 <= 363) {
				ArchiveDiskActionHandler.openURL(FaceNormal.method3229("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
			}

			var20 = Login.loginBoxX + 180 + 80;
			if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
				Login.loginIndex = 0;
				Login.Login_username = "";
				Login.Login_password = "";
				class185.field2305 = 0;
				DesktopPlatformInfoProvider.otp = "";
			}

			while (DynamicObject.isKeyDown()) {
				boolean var23 = false;

				for (int var24 = 0; var24 < "1234567890".length(); ++var24) {
					if (KeyHandler.field381 == "1234567890".charAt(var24)) {
						var23 = true;
						break;
					}
				}

				if (SecureRandomFuture.field1230 == 13) {
					Login.loginIndex = 0;
					Login.Login_username = "";
					Login.Login_password = "";
					class185.field2305 = 0;
					DesktopPlatformInfoProvider.otp = "";
				} else {
					if (SecureRandomFuture.field1230 == 85 && DesktopPlatformInfoProvider.otp.length() > 0) {
						DesktopPlatformInfoProvider.otp = DesktopPlatformInfoProvider.otp.substring(0, DesktopPlatformInfoProvider.otp.length() - 1);
					}

					if (SecureRandomFuture.field1230 == 84) {
						DesktopPlatformInfoProvider.otp.trim();
						if (DesktopPlatformInfoProvider.otp.length() != 6) {
							PlayerType.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
							return;
						}

						class185.field2305 = Integer.parseInt(DesktopPlatformInfoProvider.otp);
						DesktopPlatformInfoProvider.otp = "";
						PlayerType.method4104(true);
						PlayerType.setLoginResponseString("", "Connecting to server...", "");
						MouseRecorder.updateGameState(20);
						return;
					}

					if (var23 && DesktopPlatformInfoProvider.otp.length() < 6) {
						DesktopPlatformInfoProvider.otp = DesktopPlatformInfoProvider.otp + KeyHandler.field381;
					}
				}
			}
		} else if (Login.loginIndex == 5) {
			int var20 = Login.loginBoxX + 180 - 80;
			short var22 = 321;
			if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
				GrandExchangeOfferAgeComparator.method167();
				return;
			}

			var20 = Login.loginBoxX + 180 + 80;
			if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
				TilePaint.Login_promptCredentials(true);
			}

			short var9 = 361;
			if (class162.field1988 != null) {
				int var24 = class162.field1988.highX / 2;
				if (var4 == 1 && var25 >= class162.field1988.lowX - var24 && var25 <= var24 + class162.field1988.lowX && var18 >= var9 - 15 && var18 < var9) {
					ArchiveDiskActionHandler.openURL(FaceNormal.method3229("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
				}
			}

			while (DynamicObject.isKeyDown()) {
				boolean var10 = false;

				for (int var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var11) {
					if (KeyHandler.field381 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var11)) {
						var10 = true;
						break;
					}
				}

				if (SecureRandomFuture.field1230 == 13) {
					TilePaint.Login_promptCredentials(true);
				} else {
					if (SecureRandomFuture.field1230 == 85 && Login.Login_username.length() > 0) {
						Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
					}

					if (SecureRandomFuture.field1230 == 84) {
						GrandExchangeOfferAgeComparator.method167();
						return;
					}

					if (var10 && Login.Login_username.length() < 320) {
						Login.Login_username = Login.Login_username + KeyHandler.field381;
					}
				}
			}
		} else if (Login.loginIndex == 6) {
			while (DynamicObject.isKeyDown()) {
				if (SecureRandomFuture.field1230 == 84 || SecureRandomFuture.field1230 == 13) {
					TilePaint.Login_promptCredentials(true);
				}
			}

			short var21 = 321;
			if (var4 == 1 && var18 >= var21 - 20 && var18 <= var21 + 20){
				TilePaint.Login_promptCredentials(true);
			}
		} else if (Login.loginIndex == 7) {
			int var20 = Login.loginBoxX + 180 - 80;
			short var22 = 321;
			if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
				ArchiveDiskActionHandler.openURL(FaceNormal.method3229("secure", true) + "m=dob/set_dob.ws", true, false);
				PlayerType.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
				Login.loginIndex = 6;
				return;
			}

			var20 = Login.loginBoxX + 180 + 80;
			if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
				TilePaint.Login_promptCredentials(true);
			}
		} else if (Login.loginIndex == 8) {
			int var20 = Login.loginBoxX + 180 - 80;
			short var22 = 321;
			if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
				ArchiveDiskActionHandler.openURL("https://www.jagex.com/terms/privacy/#eight", true, false);
				PlayerType.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
				Login.loginIndex = 6;
				return;
			}

			var20 = Login.loginBoxX + 180 + 80;
			if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
				TilePaint.Login_promptCredentials(true);
			}
		} else if (Login.loginIndex == 12) {
			String var16 = "";
			switch (Login.field1174) {
				case 0:
					var16 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
					break;
				case 1:
					var16 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
					break;
				default:
					TilePaint.Login_promptCredentials(false);
			}

			int var8 = Login.loginBoxX + 180;
			short var9 = 276;
			if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
				ArchiveDiskActionHandler.openURL(var16, true, false);
				PlayerType.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
				Login.loginIndex = 6;
				return;
			}

			var8 = Login.loginBoxX + 180;
			var9 = 326;
			if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
				TilePaint.Login_promptCredentials(false);
			}
		} else if (Login.loginIndex == 24) {
			int var20 = Login.loginBoxX + 180;
			short var22 = 301;
			if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
				TilePaint.Login_promptCredentials(false);
			}
		}
	}

	@ObfuscatedName("fi")
	@ObfuscatedSignature(
		signature = "(Lbi;III)V",
		garbageValue = "1912035221"
	)
	@Export("performPlayerAnimation")
	static void performPlayerAnimation(Player var0, int var1, int var2) {
		if (var0.sequence == var1 && var1 != -1) {
			int var3 = GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var1).field3517;
			if (var3 == 1) {
				var0.sequenceFrame = 0;
				var0.sequenceFrameCycle = 0;
				var0.sequenceDelay = var2;
				var0.field965 = 0;
			}

			if (var3 == 2) {
				var0.field965 = 0;
			}
		} else if (var1 == -1 || var0.sequence == -1 || GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var1).field3511 >= GrandExchangeOfferUnitPriceComparator.SequenceDefinition_get(var0.sequence).field3511) {
			var0.sequence = var1;
			var0.sequenceFrame = 0;
			var0.sequenceFrameCycle = 0;
			var0.sequenceDelay = var2;
			var0.field965 = 0;
			var0.field988 = var0.pathLength;
		}

	}
}
