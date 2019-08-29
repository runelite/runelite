import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("WorldMapDecoration")
public class WorldMapDecoration {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lhz;"
	)
	@Export("musicTrackArchive")
	public static AbstractArchive musicTrackArchive;
	@ObfuscatedName("q")
	@Export("Widget_loadedInterfaces")
	static boolean[] Widget_loadedInterfaces;
	@ObfuscatedName("dn")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive5")
	static Archive archive5;
	@ObfuscatedName("dq")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive9")
	static Archive archive9;
	@ObfuscatedName("lx")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	static Widget field198;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1098374609
	)
	@Export("objectDefinitionId")
	final int objectDefinitionId;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1500543801
	)
	@Export("decoration")
	final int decoration;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1821120363
	)
	@Export("rotation")
	final int rotation;

	WorldMapDecoration(int var1, int var2, int var3) {
		this.objectDefinitionId = var1;
		this.decoration = var2;
		this.rotation = var3;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)[Lgt;",
		garbageValue = "17"
	)
	public static class185[] method327() {
		return new class185[]{class185.field2301, class185.field2306, class185.field2298, class185.field2299, class185.field2300, class185.field2304, class185.field2302, class185.field2297, class185.field2303, class185.field2305};
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lbw;B)V",
		garbageValue = "2"
	)
	static void method326(GameShell var0) {
		if (Login.worldSelectOpen) {
			MusicPatchNode.method3772(var0);
		} else {
			if ((MouseHandler.MouseHandler_lastButton == 1 || !FriendSystem.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
				GrandExchangeOffer.clientPreferences.titleMusicDisabled = !GrandExchangeOffer.clientPreferences.titleMusicDisabled;
				GrandExchangeOfferAgeComparator.savePreferences();
				if (!GrandExchangeOffer.clientPreferences.titleMusicDisabled) {
					Archive var1 = GrandExchangeEvent.archive6;
					int var2 = var1.getGroupId("scape main");
					int var3 = var1.getFileId(var2, "");
					PacketBufferNode.method3574(var1, var2, var3, 255, false);
				} else {
					class197.midiPcmStream.clear();
					class197.field2378 = 1;
					musicTrackArchive = null;
				}
			}

			if (Client.gameState != 5) {
				if (Login.field1179 == -1L) {
					Login.field1179 = SequenceDefinition.method4686() + 1000L;
				}

				long var12 = SequenceDefinition.method4686();
				boolean var16;
				if (Client.archiveLoaders != null && Client.archiveLoaderArchive < Client.archiveLoaders.size()) {
					while (true) {
						if (Client.archiveLoaderArchive >= Client.archiveLoaders.size()) {
							var16 = true;
							break;
						}

						ArchiveLoader var4 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoaderArchive);
						if (!var4.isLoaded()) {
							var16 = false;
							break;
						}

						++Client.archiveLoaderArchive;
					}
				} else {
					var16 = true;
				}

				if (var16 && Login.field1150 == -1L) {
					Login.field1150 = var12;
					if (Login.field1150 > Login.field1179) {
						Login.field1179 = Login.field1150;
					}
				}

				if (Client.gameState == 10 || Client.gameState == 11) {
					int var14;
					if (class60.clientLanguage == Language.Language_EN) {
						if (MouseHandler.MouseHandler_lastButton == 1 || !FriendSystem.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
							var14 = Login.xPadding + 5;
							short var5 = 463;
							byte var6 = 100;
							byte var7 = 35;
							if (MouseHandler.MouseHandler_lastPressedX >= var14 && MouseHandler.MouseHandler_lastPressedX <= var14 + var6 && MouseHandler.MouseHandler_lastPressedY >= var5 && MouseHandler.MouseHandler_lastPressedY <= var5 + var7) {
								UserComparator7.openWorldSelect();
								return;
							}
						}

						if (IgnoreList.World_request != null) {
							UserComparator7.openWorldSelect();
						}
					}

					var14 = MouseHandler.MouseHandler_lastButton;
					int var17 = MouseHandler.MouseHandler_lastPressedX;
					int var18 = MouseHandler.MouseHandler_lastPressedY;
					if (var14 == 0) {
						var17 = MouseHandler.MouseHandler_x;
						var18 = MouseHandler.MouseHandler_y;
					}

					if (!FriendSystem.mouseCam && var14 == 4) {
						var14 = 1;
					}

					int var8;
					short var9;
					if (Login.loginIndex == 0) {
						boolean var19 = false;

						while (FontName.isKeyDown()) {
							if (ReflectionCheck.field1307 == 84) {
								var19 = true;
							}
						}

						var8 = Login.loginBoxCenter - 80;
						var9 = 291;
						if (var14 == 1 && var17 >= var8 - 75 && var17 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
							GameObject.openURL(RouteStrategy.method3534("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
						}

						var8 = Login.loginBoxCenter + 80;
						if (var14 == 1 && var17 >= var8 - 75 && var17 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20 || var19) {
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
								GZipDecompressor.method6390(false);
							}
						}
					} else {
						int var20;
						short var22;
						if (Login.loginIndex != 1) {
							boolean var10;
							int var11;
							short var21;
							if (Login.loginIndex == 2) {
								var21 = 201;
								var20 = var21 + 52;
								if (var14 == 1 && var18 >= var20 - 12 && var18 < var20 + 2) {
									Login.currentLoginField = 0;
								}

								var20 += 15;
								if (var14 == 1 && var18 >= var20 - 12 && var18 < var20 + 2) {
									Login.currentLoginField = 1;
								}

								var20 += 15;
								var21 = 361;
								if (Decimator.field1443 != null) {
									var8 = Decimator.field1443.highX / 2;
									if (var14 == 1 && var17 >= Decimator.field1443.lowX - var8 && var17 <= var8 + Decimator.field1443.lowX && var18 >= var21 - 15 && var18 < var21) {
										switch(Login.field1161) {
										case 1:
											GrandExchangeOfferOwnWorldComparator.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
											Login.loginIndex = 5;
											return;
										case 2:
											GameObject.openURL("https://support.runescape.com/hc/en-gb", true, false);
										}
									}
								}

								var8 = Login.loginBoxCenter - 80;
								var9 = 321;
								if (var14 == 1 && var17 >= var8 - 75 && var17 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
									Login.Login_username = Login.Login_username.trim();
									if (Login.Login_username.length() == 0) {
										GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Please enter your username/email address.", "");
										return;
									}

									if (Login.Login_password.length() == 0) {
										GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Please enter your password.", "");
										return;
									}

									GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Connecting to server...", "");
									WorldMapArea.method358(false);
									FloorDecoration.updateGameState(20);
									return;
								}

								var8 = Login.loginBoxX + 180 + 80;
								if (var14 == 1 && var17 >= var8 - 75 && var17 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
									Login.loginIndex = 0;
									Login.Login_username = "";
									Login.Login_password = "";
									SecureRandomCallable.field500 = 0;
									WorldMapSection1.otp = "";
									Login.field1171 = true;
								}

								var8 = Login.loginBoxCenter + -117;
								var9 = 277;
								Login.field1169 = var17 >= var8 && var17 < var8 + UserComparator8.field1957 && var18 >= var9 && var18 < var9 + class173.field2079;
								if (var14 == 1 && Login.field1169) {
									Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
									if (!Client.Login_isUsernameRemembered && GrandExchangeOffer.clientPreferences.rememberedUsername != null) {
										GrandExchangeOffer.clientPreferences.rememberedUsername = null;
										GrandExchangeOfferAgeComparator.savePreferences();
									}
								}

								var8 = Login.loginBoxCenter + 24;
								var9 = 277;
								Login.field1170 = var17 >= var8 && var17 < var8 + UserComparator8.field1957 && var18 >= var9 && var18 < var9 + class173.field2079;
								if (var14 == 1 && Login.field1170) {
									GrandExchangeOffer.clientPreferences.hideUsername = !GrandExchangeOffer.clientPreferences.hideUsername;
									if (!GrandExchangeOffer.clientPreferences.hideUsername) {
										Login.Login_username = "";
										GrandExchangeOffer.clientPreferences.rememberedUsername = null;
										if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
											Login.currentLoginField = 1;
										} else {
											Login.currentLoginField = 0;
										}
									}

									GrandExchangeOfferAgeComparator.savePreferences();
								}

								while (true) {
									while (FontName.isKeyDown()) {
										var10 = false;

										for (var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var11) {
											if (SpriteMask.field2499 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var11)) {
												var10 = true;
												break;
											}
										}

										if (ReflectionCheck.field1307 == 13) {
											Login.loginIndex = 0;
											Login.Login_username = "";
											Login.Login_password = "";
											SecureRandomCallable.field500 = 0;
											WorldMapSection1.otp = "";
											Login.field1171 = true;
										} else if (Login.currentLoginField == 0) {
											if (ReflectionCheck.field1307 == 85 && Login.Login_username.length() > 0) {
												Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
											}

											if (ReflectionCheck.field1307 == 84 || ReflectionCheck.field1307 == 80) {
												Login.currentLoginField = 1;
											}

											if (var10 && Login.Login_username.length() < 320) {
												Login.Login_username = Login.Login_username + SpriteMask.field2499;
											}
										} else if (Login.currentLoginField == 1) {
											if (ReflectionCheck.field1307 == 85 && Login.Login_password.length() > 0) {
												Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
											}

											if (ReflectionCheck.field1307 == 84 || ReflectionCheck.field1307 == 80) {
												Login.currentLoginField = 0;
											}

											if (ReflectionCheck.field1307 == 84) {
												Login.Login_username = Login.Login_username.trim();
												if (Login.Login_username.length() == 0) {
													GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Please enter your username/email address.", "");
													return;
												}

												if (Login.Login_password.length() == 0) {
													GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Please enter your password.", "");
													return;
												}

												GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Connecting to server...", "");
												WorldMapArea.method358(false);
												FloorDecoration.updateGameState(20);
												return;
											}

											if (var10 && Login.Login_password.length() < 20) {
												Login.Login_password = Login.Login_password + SpriteMask.field2499;
											}
										}
									}

									return;
								}
							} else if (Login.loginIndex == 3) {
								var20 = Login.loginBoxX + 180;
								var22 = 276;
								if (var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
									GZipDecompressor.method6390(false);
								}

								var20 = Login.loginBoxX + 180;
								var22 = 326;
								if (var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
									GrandExchangeOfferOwnWorldComparator.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
									Login.loginIndex = 5;
									return;
								}
							} else {
								int var24;
								if (Login.loginIndex == 4) {
									var20 = Login.loginBoxX + 180 - 80;
									var22 = 321;
									if (var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										WorldMapSection1.otp.trim();
										if (WorldMapSection1.otp.length() != 6) {
											GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
											return;
										}

										SecureRandomCallable.field500 = Integer.parseInt(WorldMapSection1.otp);
										WorldMapSection1.otp = "";
										WorldMapArea.method358(true);
										GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Connecting to server...", "");
										FloorDecoration.updateGameState(20);
										return;
									}

									if (var14 == 1 && var17 >= Login.loginBoxX + 180 - 9 && var17 <= Login.loginBoxX + 180 + 130 && var18 >= 263 && var18 <= 296) {
										Login.field1171 = !Login.field1171;
									}

									if (var14 == 1 && var17 >= Login.loginBoxX + 180 - 34 && var17 <= Login.loginBoxX + 34 + 180 && var18 >= 351 && var18 <= 363) {
										GameObject.openURL(RouteStrategy.method3534("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
									}

									var20 = Login.loginBoxX + 180 + 80;
									if (var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										Login.loginIndex = 0;
										Login.Login_username = "";
										Login.Login_password = "";
										SecureRandomCallable.field500 = 0;
										WorldMapSection1.otp = "";
									}

									while (FontName.isKeyDown()) {
										boolean var23 = false;

										for (var24 = 0; var24 < "1234567890".length(); ++var24) {
											if (SpriteMask.field2499 == "1234567890".charAt(var24)) {
												var23 = true;
												break;
											}
										}

										if (ReflectionCheck.field1307 == 13) {
											Login.loginIndex = 0;
											Login.Login_username = "";
											Login.Login_password = "";
											SecureRandomCallable.field500 = 0;
											WorldMapSection1.otp = "";
										} else {
											if (ReflectionCheck.field1307 == 85 && WorldMapSection1.otp.length() > 0) {
												WorldMapSection1.otp = WorldMapSection1.otp.substring(0, WorldMapSection1.otp.length() - 1);
											}

											if (ReflectionCheck.field1307 == 84) {
												WorldMapSection1.otp.trim();
												if (WorldMapSection1.otp.length() != 6) {
													GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
													return;
												}

												SecureRandomCallable.field500 = Integer.parseInt(WorldMapSection1.otp);
												WorldMapSection1.otp = "";
												WorldMapArea.method358(true);
												GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Connecting to server...", "");
												FloorDecoration.updateGameState(20);
												return;
											}

											if (var23 && WorldMapSection1.otp.length() < 6) {
												WorldMapSection1.otp = WorldMapSection1.otp + SpriteMask.field2499;
											}
										}
									}
								} else if (Login.loginIndex == 5) {
									var20 = Login.loginBoxX + 180 - 80;
									var22 = 321;
									if (var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										ItemContainer.method1118();
										return;
									}

									var20 = Login.loginBoxX + 180 + 80;
									if (var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										GZipDecompressor.method6390(true);
									}

									var9 = 361;
									if (MusicPatchPcmStream.field2466 != null) {
										var24 = MusicPatchPcmStream.field2466.highX / 2;
										if (var14 == 1 && var17 >= MusicPatchPcmStream.field2466.lowX - var24 && var17 <= var24 + MusicPatchPcmStream.field2466.lowX && var18 >= var9 - 15 && var18 < var9) {
											GameObject.openURL(RouteStrategy.method3534("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
										}
									}

									while (FontName.isKeyDown()) {
										var10 = false;

										for (var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var11) {
											if (SpriteMask.field2499 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var11)) {
												var10 = true;
												break;
											}
										}

										if (ReflectionCheck.field1307 == 13) {
											GZipDecompressor.method6390(true);
										} else {
											if (ReflectionCheck.field1307 == 85 && Login.Login_username.length() > 0) {
												Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
											}

											if (ReflectionCheck.field1307 == 84) {
												ItemContainer.method1118();
												return;
											}

											if (var10 && Login.Login_username.length() < 320) {
												Login.Login_username = Login.Login_username + SpriteMask.field2499;
											}
										}
									}
								} else if (Login.loginIndex == 6) {
									while (true) {
										do {
											if (!FontName.isKeyDown()) {
												var21 = 321;
												if (var14 == 1 && var18 >= var21 - 20 && var18 <= var21 + 20) {
													GZipDecompressor.method6390(true);
												}

												return;
											}
										} while(ReflectionCheck.field1307 != 84 && ReflectionCheck.field1307 != 13);

										GZipDecompressor.method6390(true);
									}
								} else if (Login.loginIndex == 7) {
									var20 = Login.loginBoxX + 180 - 80;
									var22 = 321;
									if (var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										GameObject.openURL(RouteStrategy.method3534("secure", true) + "m=dob/set_dob.ws", true, false);
										GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
										Login.loginIndex = 6;
										return;
									}

									var20 = Login.loginBoxX + 180 + 80;
									if (var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										GZipDecompressor.method6390(true);
									}
								} else if (Login.loginIndex == 8) {
									var20 = Login.loginBoxX + 180 - 80;
									var22 = 321;
									if (var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										GameObject.openURL("https://www.jagex.com/terms/privacy/#eight", true, false);
										GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
										Login.loginIndex = 6;
										return;
									}

									var20 = Login.loginBoxX + 180 + 80;
									if (var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										GZipDecompressor.method6390(true);
									}
								} else if (Login.loginIndex == 12) {
									String var15 = "";
									switch(Login.field1160) {
									case 0:
										var15 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
										break;
									case 1:
										var15 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
										break;
									default:
										GZipDecompressor.method6390(false);
									}

									var8 = Login.loginBoxX + 180;
									var9 = 276;
									if (var14 == 1 && var17 >= var8 - 75 && var17 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
										GameObject.openURL(var15, true, false);
										GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
										Login.loginIndex = 6;
										return;
									}

									var8 = Login.loginBoxX + 180;
									var9 = 326;
									if (var14 == 1 && var17 >= var8 - 75 && var17 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
										GZipDecompressor.method6390(false);
									}
								} else if (Login.loginIndex == 24) {
									var20 = Login.loginBoxX + 180;
									var22 = 301;
									if (var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										GZipDecompressor.method6390(false);
									}
								}
							}
						} else {
							while (FontName.isKeyDown()) {
								if (ReflectionCheck.field1307 == 84) {
									GZipDecompressor.method6390(false);
								} else if (ReflectionCheck.field1307 == 13) {
									Login.loginIndex = 0;
								}
							}

							var20 = Login.loginBoxCenter - 80;
							var22 = 321;
							if (var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
								GZipDecompressor.method6390(false);
							}

							var20 = Login.loginBoxCenter + 80;
							if (var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
								Login.loginIndex = 0;
							}
						}
					}

				}
			}
		}
	}
}
