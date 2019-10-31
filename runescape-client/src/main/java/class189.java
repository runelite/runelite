import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("gf")
public class class189 {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 2129560759
	)
	@Export("musicTrackGroupId")
	public static int musicTrackGroupId;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -552919085
	)
	@Export("cacheGamebuild")
	static int cacheGamebuild;

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lbg;I)V",
		garbageValue = "-1848275879"
	)
	@Export("doCycleTitle")
	static void doCycleTitle(GameShell var0) {
		int var4;
		if (Login.worldSelectOpen) {
			while (true) {
				if (!class237.isKeyDown()) {
					if (MouseHandler.MouseHandler_lastButton != 1 && (WorldMapLabelSize.mouseCam || MouseHandler.MouseHandler_lastButton != 4)) {
						break;
					}

					int var1 = Login.xPadding + 280;
					if (MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var1 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						UrlRequester.changeWorldSelectSorting(0, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var1 + 15 && MouseHandler.MouseHandler_lastPressedX <= var1 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						UrlRequester.changeWorldSelectSorting(0, 1);
						break;
					}

					int var2 = Login.xPadding + 390;
					if (MouseHandler.MouseHandler_lastPressedX >= var2 && MouseHandler.MouseHandler_lastPressedX <= var2 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						UrlRequester.changeWorldSelectSorting(1, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var2 + 15 && MouseHandler.MouseHandler_lastPressedX <= var2 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						UrlRequester.changeWorldSelectSorting(1, 1);
						break;
					}

					int var25 = Login.xPadding + 500;
					if (MouseHandler.MouseHandler_lastPressedX >= var25 && MouseHandler.MouseHandler_lastPressedX <= var25 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						UrlRequester.changeWorldSelectSorting(2, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var25 + 15 && MouseHandler.MouseHandler_lastPressedX <= var25 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						UrlRequester.changeWorldSelectSorting(2, 1);
						break;
					}

					var4 = Login.xPadding + 610;
					if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						UrlRequester.changeWorldSelectSorting(3, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						UrlRequester.changeWorldSelectSorting(3, 1);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
						Login.worldSelectOpen = false;
						Login.leftTitleSprite.drawAt(Login.xPadding, 0);
						FontName.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
						Tiles.logoSprite.drawAt(Login.xPadding + 382 - Tiles.logoSprite.subWidth / 2, 18);
						break;
					}

					if (Login.hoveredWorldIndex != -1) {
						World var5 = Username.World_worlds[Login.hoveredWorldIndex];
						MouseRecorder.changeWorld(var5);
						Login.worldSelectOpen = false;
						Login.leftTitleSprite.drawAt(Login.xPadding, 0);
						FontName.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
						Tiles.logoSprite.drawAt(Login.xPadding + 382 - Tiles.logoSprite.subWidth / 2, 18);
					} else {
						if (Login.worldSelectPage > 0 && class288.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= class288.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= FloorUnderlayDefinition.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= FloorUnderlayDefinition.canvasHeight / 2 + 50) {
							--Login.worldSelectPage;
						}

						if (Login.worldSelectPage < Login.worldSelectPagesCount && WorldMapSection2.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= class286.canvasWidth - WorldMapSection2.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= class286.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= FloorUnderlayDefinition.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= FloorUnderlayDefinition.canvasHeight / 2 + 50) {
							++Login.worldSelectPage;
						}
					}
					break;
				}

				if (WorldMapLabel.field229 == 13) {
					Login.worldSelectOpen = false;
					Login.leftTitleSprite.drawAt(Login.xPadding, 0);
					FontName.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
					Tiles.logoSprite.drawAt(Login.xPadding + 382 - Tiles.logoSprite.subWidth / 2, 18);
					break;
				}

				if (WorldMapLabel.field229 == 96) {
					if (Login.worldSelectPage > 0 && class288.worldSelectLeftSprite != null) {
						--Login.worldSelectPage;
					}
				} else if (WorldMapLabel.field229 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && WorldMapSection2.worldSelectRightSprite != null) {
					++Login.worldSelectPage;
				}
			}

		} else {
			if ((MouseHandler.MouseHandler_lastButton == 1 || !WorldMapLabelSize.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
				ScriptEvent.clientPreferences.titleMusicDisabled = !ScriptEvent.clientPreferences.titleMusicDisabled;
				HitSplatDefinition.savePreferences();
				if (!ScriptEvent.clientPreferences.titleMusicDisabled) {
					WorldMapRectangle.method330(class216.archive6, "scape main", "", 255, false);
				} else {
					ReflectionCheck.method2438();
				}
			}

			if (Client.gameState != 5) {
				if (Login.field1185 == -1L) {
					Login.field1185 = PlayerAppearance.currentTimeMillis() + 1000L;
				}

				long var16 = PlayerAppearance.currentTimeMillis();
				boolean var3;
				if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
					while (true) {
						if (Client.archiveLoadersDone >= Client.archiveLoaders.size()) {
							var3 = true;
							break;
						}

						ArchiveLoader var18 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoadersDone);
						if (!var18.isLoaded()) {
							var3 = false;
							break;
						}

						++Client.archiveLoadersDone;
					}
				} else {
					var3 = true;
				}

				if (var3 && Login.field1186 == -1L) {
					Login.field1186 = var16;
					if (Login.field1186 > Login.field1185) {
						Login.field1185 = Login.field1186;
					}
				}

				if (Client.gameState == 10 || Client.gameState == 11) {
					if (WorldMapSection1.clientLanguage == Language.Language_EN) {
						if (MouseHandler.MouseHandler_lastButton == 1 || !WorldMapLabelSize.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
							var4 = Login.xPadding + 5;
							short var19 = 463;
							byte var6 = 100;
							byte var7 = 35;
							if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var6 + var4 && MouseHandler.MouseHandler_lastPressedY >= var19 && MouseHandler.MouseHandler_lastPressedY <= var19 + var7) {
								AttackOption.method2215();
								return;
							}
						}

						if (class96.World_request != null) {
							AttackOption.method2215();
						}
					}

					var4 = MouseHandler.MouseHandler_lastButton;
					int var32 = MouseHandler.MouseHandler_lastPressedX;
					int var26 = MouseHandler.MouseHandler_lastPressedY;
					if (var4 == 0) {
						var32 = MouseHandler.MouseHandler_x;
						var26 = MouseHandler.MouseHandler_y;
					}

					if (!WorldMapLabelSize.mouseCam && var4 == 4) {
						var4 = 1;
					}

					short var29;
					int var30;
					if (Login.loginIndex == 0) {
						boolean var31 = false;

						while (class237.isKeyDown()) {
							if (WorldMapLabel.field229 == 84) {
								var31 = true;
							}
						}

						var30 = class192.loginBoxCenter - 80;
						var29 = 291;
						if (var4 == 1 && var32 >= var30 - 75 && var32 <= var30 + 75 && var26 >= var29 - 20 && var26 <= var29 + 20) {
							class2.openURL(WorldMapElement.method4547("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
						}

						var30 = class192.loginBoxCenter + 80;
						if (var4 == 1 && var32 >= var30 - 75 && var32 <= var30 + 75 && var26 >= var29 - 20 && var26 <= var29 + 20 || var31) {
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
								UserComparator3.Login_promptCredentials(false);
							}
						}
					} else {
						short var8;
						int var27;
						if (Login.loginIndex == 1) {
							while (true) {
								if (!class237.isKeyDown()) {
									var27 = class192.loginBoxCenter - 80;
									var8 = 321;
									if (var4 == 1 && var32 >= var27 - 75 && var32 <= var27 + 75 && var26 >= var8 - 20 && var26 <= var8 + 20) {
										UserComparator3.Login_promptCredentials(false);
									}

									var27 = class192.loginBoxCenter + 80;
									if (var4 == 1 && var32 >= var27 - 75 && var32 <= var27 + 75 && var26 >= var8 - 20 && var26 <= var8 + 20) {
										Login.loginIndex = 0;
									}
									break;
								}

								if (WorldMapLabel.field229 == 84) {
									UserComparator3.Login_promptCredentials(false);
								} else if (WorldMapLabel.field229 == 13) {
									Login.loginIndex = 0;
								}
							}
						} else {
							short var28;
							if (Login.loginIndex == 2) {
								var28 = 201;
								var27 = var28 + 52;
								if (var4 == 1 && var26 >= var27 - 12 && var26 < var27 + 2) {
									Login.currentLoginField = 0;
								}

								var27 += 15;
								if (var4 == 1 && var26 >= var27 - 12 && var26 < var27 + 2) {
									Login.currentLoginField = 1;
								}

								var27 += 15;
								var28 = 361;
								if (WorldMapLabel.field225 != null) {
									var30 = WorldMapLabel.field225.highX / 2;
									if (var4 == 1 && var32 >= WorldMapLabel.field225.lowX - var30 && var32 <= var30 + WorldMapLabel.field225.lowX && var26 >= var28 - 15 && var26 < var28) {
										switch(Login.field1166) {
										case 1:
											GrandExchangeOffer.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
											Login.loginIndex = 5;
											return;
										case 2:
											class2.openURL("https://support.runescape.com/hc/en-gb", true, false);
										}
									}
								}

								var30 = class192.loginBoxCenter - 80;
								var29 = 321;
								if (var4 == 1 && var32 >= var30 - 75 && var32 <= var30 + 75 && var26 >= var29 - 20 && var26 <= var29 + 20) {
									Login.Login_username = Login.Login_username.trim();
									if (Login.Login_username.length() == 0) {
										GrandExchangeOffer.setLoginResponseString("", "Please enter your username/email address.", "");
										return;
									}

									if (Login.Login_password.length() == 0) {
										GrandExchangeOffer.setLoginResponseString("", "Please enter your password.", "");
										return;
									}

									GrandExchangeOffer.setLoginResponseString("", "Connecting to server...", "");
									WorldMapLabelSize.method235(false);
									Tile.updateGameState(20);
									return;
								}

								var30 = Login.loginBoxX + 180 + 80;
								if (var4 == 1 && var32 >= var30 - 75 && var32 <= var30 + 75 && var26 >= var29 - 20 && var26 <= var29 + 20) {
									Login.loginIndex = 0;
									Login.Login_username = "";
									Login.Login_password = "";
									Huffman.field2491 = 0;
									class268.otp = "";
									Login.field1177 = true;
								}

								var30 = class192.loginBoxCenter + -117;
								var29 = 277;
								Login.field1159 = var32 >= var30 && var32 < var30 + Login.field1174 && var26 >= var29 && var26 < var29 + Language.field2328;
								if (var4 == 1 && Login.field1159) {
									Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
									if (!Client.Login_isUsernameRemembered && ScriptEvent.clientPreferences.rememberedUsername != null) {
										ScriptEvent.clientPreferences.rememberedUsername = null;
										HitSplatDefinition.savePreferences();
									}
								}

								var30 = class192.loginBoxCenter + 24;
								var29 = 277;
								Login.field1175 = var32 >= var30 && var32 < var30 + Login.field1174 && var26 >= var29 && var26 < var29 + Language.field2328;
								if (var4 == 1 && Login.field1175) {
									ScriptEvent.clientPreferences.hideUsername = !ScriptEvent.clientPreferences.hideUsername;
									if (!ScriptEvent.clientPreferences.hideUsername) {
										Login.Login_username = "";
										ScriptEvent.clientPreferences.rememberedUsername = null;
										if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
											Login.currentLoginField = 1;
										} else {
											Login.currentLoginField = 0;
										}
									}

									HitSplatDefinition.savePreferences();
								}

								while (true) {
									Transferable var11;
									int var12;
									do {
										while (true) {
											label1121:
											do {
												while (true) {
													while (class237.isKeyDown()) {
														if (WorldMapLabel.field229 != 13) {
															if (Login.currentLoginField != 0) {
																continue label1121;
															}

															WorldMapAreaData.method755(DevicePcmPlayerProvider.field395);
															if (WorldMapLabel.field229 == 85 && Login.Login_username.length() > 0) {
																Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
															}

															if (WorldMapLabel.field229 == 84 || WorldMapLabel.field229 == 80) {
																Login.currentLoginField = 1;
															}

															if (AbstractWorldMapIcon.method679(DevicePcmPlayerProvider.field395) && Login.Login_username.length() < 320) {
																Login.Login_username = Login.Login_username + DevicePcmPlayerProvider.field395;
															}
														} else {
															Login.loginIndex = 0;
															Login.Login_username = "";
															Login.Login_password = "";
															Huffman.field2491 = 0;
															class268.otp = "";
															Login.field1177 = true;
														}
													}

													return;
												}
											} while(Login.currentLoginField != 1);

											if (WorldMapLabel.field229 == 85 && Login.Login_password.length() > 0) {
												Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
											} else if (WorldMapLabel.field229 == 84 || WorldMapLabel.field229 == 80) {
												Login.currentLoginField = 0;
												if (WorldMapLabel.field229 == 84) {
													Login.Login_username = Login.Login_username.trim();
													if (Login.Login_username.length() == 0) {
														GrandExchangeOffer.setLoginResponseString("", "Please enter your username/email address.", "");
														return;
													}

													if (Login.Login_password.length() == 0) {
														GrandExchangeOffer.setLoginResponseString("", "Please enter your password.", "");
														return;
													}

													GrandExchangeOffer.setLoginResponseString("", "Connecting to server...", "");
													WorldMapLabelSize.method235(false);
													Tile.updateGameState(20);
													return;
												}
											}

											if ((KeyHandler.KeyHandler_pressedKeys[82] || KeyHandler.KeyHandler_pressedKeys[87]) && WorldMapLabel.field229 == 67) {
												Clipboard var10 = Toolkit.getDefaultToolkit().getSystemClipboard();
												var11 = var10.getContents(WorldMapID.client);
												var12 = 20 - Login.Login_password.length();
												break;
											}

											if (PcmPlayer.method2639(DevicePcmPlayerProvider.field395) && AbstractWorldMapIcon.method679(DevicePcmPlayerProvider.field395) && Login.Login_password.length() < 20) {
												Login.Login_password = Login.Login_password + DevicePcmPlayerProvider.field395;
											}
										}
									} while(var12 <= 0);

									try {
										String var13 = (String)var11.getTransferData(DataFlavor.stringFlavor);
										int var14 = Math.min(var12, var13.length());

										for (int var15 = 0; var15 < var14; ++var15) {
											if (!PcmPlayer.method2639(var13.charAt(var15)) || !AbstractWorldMapIcon.method679(var13.charAt(var15))) {
												Login.loginIndex = 3;
												return;
											}
										}

										Login.Login_password = Login.Login_password + var13.substring(0, var14);
									} catch (UnsupportedFlavorException var23) {
									} catch (IOException var24) {
									}
								}
							} else if (Login.loginIndex == 3) {
								var27 = Login.loginBoxX + 180;
								var8 = 276;
								if (var4 == 1 && var32 >= var27 - 75 && var32 <= var27 + 75 && var26 >= var8 - 20 && var26 <= var8 + 20) {
									UserComparator3.Login_promptCredentials(false);
								}

								var27 = Login.loginBoxX + 180;
								var8 = 326;
								if (var4 == 1 && var32 >= var27 - 75 && var32 <= var27 + 75 && var26 >= var8 - 20 && var26 <= var8 + 20) {
									GrandExchangeOffer.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
									Login.loginIndex = 5;
									return;
								}
							} else {
								int var20;
								if (Login.loginIndex == 4) {
									var27 = Login.loginBoxX + 180 - 80;
									var8 = 321;
									if (var4 == 1 && var32 >= var27 - 75 && var32 <= var27 + 75 && var26 >= var8 - 20 && var26 <= var8 + 20) {
										class268.otp.trim();
										if (class268.otp.length() != 6) {
											GrandExchangeOffer.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
											return;
										}

										Huffman.field2491 = Integer.parseInt(class268.otp);
										class268.otp = "";
										WorldMapLabelSize.method235(true);
										GrandExchangeOffer.setLoginResponseString("", "Connecting to server...", "");
										Tile.updateGameState(20);
										return;
									}

									if (var4 == 1 && var32 >= Login.loginBoxX + 180 - 9 && var32 <= Login.loginBoxX + 180 + 130 && var26 >= 263 && var26 <= 296) {
										Login.field1177 = !Login.field1177;
									}

									if (var4 == 1 && var32 >= Login.loginBoxX + 180 - 34 && var32 <= Login.loginBoxX + 34 + 180 && var26 >= 351 && var26 <= 363) {
										class2.openURL(WorldMapElement.method4547("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
									}

									var27 = Login.loginBoxX + 180 + 80;
									if (var4 == 1 && var32 >= var27 - 75 && var32 <= var27 + 75 && var26 >= var8 - 20 && var26 <= var8 + 20) {
										Login.loginIndex = 0;
										Login.Login_username = "";
										Login.Login_password = "";
										Huffman.field2491 = 0;
										class268.otp = "";
									}

									while (class237.isKeyDown()) {
										boolean var9 = false;

										for (var20 = 0; var20 < "1234567890".length(); ++var20) {
											if (DevicePcmPlayerProvider.field395 == "1234567890".charAt(var20)) {
												var9 = true;
												break;
											}
										}

										if (WorldMapLabel.field229 == 13) {
											Login.loginIndex = 0;
											Login.Login_username = "";
											Login.Login_password = "";
											Huffman.field2491 = 0;
											class268.otp = "";
										} else {
											if (WorldMapLabel.field229 == 85 && class268.otp.length() > 0) {
												class268.otp = class268.otp.substring(0, class268.otp.length() - 1);
											}

											if (WorldMapLabel.field229 == 84) {
												class268.otp.trim();
												if (class268.otp.length() != 6) {
													GrandExchangeOffer.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
													return;
												}

												Huffman.field2491 = Integer.parseInt(class268.otp);
												class268.otp = "";
												WorldMapLabelSize.method235(true);
												GrandExchangeOffer.setLoginResponseString("", "Connecting to server...", "");
												Tile.updateGameState(20);
												return;
											}

											if (var9 && class268.otp.length() < 6) {
												class268.otp = class268.otp + DevicePcmPlayerProvider.field395;
											}
										}
									}
								} else if (Login.loginIndex == 5) {
									var27 = Login.loginBoxX + 180 - 80;
									var8 = 321;
									if (var4 == 1 && var32 >= var27 - 75 && var32 <= var27 + 75 && var26 >= var8 - 20 && var26 <= var8 + 20) {
										ClientPacket.method3764();
										return;
									}

									var27 = Login.loginBoxX + 180 + 80;
									if (var4 == 1 && var32 >= var27 - 75 && var32 <= var27 + 75 && var26 >= var8 - 20 && var26 <= var8 + 20) {
										UserComparator3.Login_promptCredentials(true);
									}

									var29 = 361;
									if (WorldMapManager.field319 != null) {
										var20 = WorldMapManager.field319.highX / 2;
										if (var4 == 1 && var32 >= WorldMapManager.field319.lowX - var20 && var32 <= var20 + WorldMapManager.field319.lowX && var26 >= var29 - 15 && var26 < var29) {
											class2.openURL(WorldMapElement.method4547("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
										}
									}

									while (class237.isKeyDown()) {
										boolean var33 = false;

										for (int var21 = 0; var21 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var21) {
											if (DevicePcmPlayerProvider.field395 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var21)) {
												var33 = true;
												break;
											}
										}

										if (WorldMapLabel.field229 == 13) {
											UserComparator3.Login_promptCredentials(true);
										} else {
											if (WorldMapLabel.field229 == 85 && Login.Login_username.length() > 0) {
												Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
											}

											if (WorldMapLabel.field229 == 84) {
												ClientPacket.method3764();
												return;
											}

											if (var33 && Login.Login_username.length() < 320) {
												Login.Login_username = Login.Login_username + DevicePcmPlayerProvider.field395;
											}
										}
									}
								} else if (Login.loginIndex != 6) {
									if (Login.loginIndex == 7) {
										var27 = Login.loginBoxX + 180 - 80;
										var8 = 321;
										if (var4 == 1 && var32 >= var27 - 75 && var32 <= var27 + 75 && var26 >= var8 - 20 && var26 <= var8 + 20) {
											class2.openURL(WorldMapElement.method4547("secure", true) + "m=dob/set_dob.ws", true, false);
											GrandExchangeOffer.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											Login.loginIndex = 6;
											return;
										}

										var27 = Login.loginBoxX + 180 + 80;
										if (var4 == 1 && var32 >= var27 - 75 && var32 <= var27 + 75 && var26 >= var8 - 20 && var26 <= var8 + 20) {
											UserComparator3.Login_promptCredentials(true);
										}
									} else if (Login.loginIndex == 8) {
										var27 = Login.loginBoxX + 180 - 80;
										var8 = 321;
										if (var4 == 1 && var32 >= var27 - 75 && var32 <= var27 + 75 && var26 >= var8 - 20 && var26 <= var8 + 20) {
											class2.openURL("https://www.jagex.com/terms/privacy/#eight", true, false);
											GrandExchangeOffer.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											Login.loginIndex = 6;
											return;
										}

										var27 = Login.loginBoxX + 180 + 80;
										if (var4 == 1 && var32 >= var27 - 75 && var32 <= var27 + 75 && var26 >= var8 - 20 && var26 <= var8 + 20) {
											UserComparator3.Login_promptCredentials(true);
										}
									} else if (Login.loginIndex == 12) {
										String var22 = "";
										switch(Login.field1156) {
										case 0:
											var22 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
											break;
										case 1:
											var22 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
											break;
										default:
											UserComparator3.Login_promptCredentials(false);
										}

										var30 = Login.loginBoxX + 180;
										var29 = 276;
										if (var4 == 1 && var32 >= var30 - 75 && var32 <= var30 + 75 && var26 >= var29 - 20 && var26 <= var29 + 20) {
											class2.openURL(var22, true, false);
											GrandExchangeOffer.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											Login.loginIndex = 6;
											return;
										}

										var30 = Login.loginBoxX + 180;
										var29 = 326;
										if (var4 == 1 && var32 >= var30 - 75 && var32 <= var30 + 75 && var26 >= var29 - 20 && var26 <= var29 + 20) {
											UserComparator3.Login_promptCredentials(false);
										}
									} else if (Login.loginIndex == 24) {
										var27 = Login.loginBoxX + 180;
										var8 = 301;
										if (var4 == 1 && var32 >= var27 - 75 && var32 <= var27 + 75 && var26 >= var8 - 20 && var26 <= var8 + 20) {
											UserComparator3.Login_promptCredentials(false);
										}
									}
								} else {
									while (true) {
										do {
											if (!class237.isKeyDown()) {
												var28 = 321;
												if (var4 == 1 && var26 >= var28 - 20 && var26 <= var28 + 20) {
													UserComparator3.Login_promptCredentials(true);
												}

												return;
											}
										} while(WorldMapLabel.field229 != 84 && WorldMapLabel.field229 != 13);

										UserComparator3.Login_promptCredentials(true);
									}
								}
							}
						}
					}

				}
			}
		}
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lkf;ILbj;IB)V",
		garbageValue = "-76"
	)
	static final void method3797(PacketBuffer var0, int var1, Player var2, int var3) {
		byte var4 = -1;
		int var5;
		int var8;
		int var9;
		int var12;
		if ((var3 & 128) != 0) {
			var5 = var0.method5648();
			PlayerType var6 = (PlayerType)WorldMapIcon_1.findEnumerated(class51.PlayerType_values(), var0.method5639());
			boolean var7 = var0.readUnsignedByte() == 1;
			var8 = var0.readUnsignedByte();
			var9 = var0.offset;
			if (var2.username != null && var2.appearance != null) {
				boolean var10 = false;
				if (var6.isUser && PacketWriter.friendSystem.isIgnored(var2.username)) {
					var10 = true;
				}

				if (!var10 && Client.field745 == 0 && !var2.isHidden) {
					Players.field1238.offset = 0;
					var0.method5702(Players.field1238.array, 0, var8);
					Players.field1238.offset = 0;
					String var11 = AbstractFont.escapeBrackets(class222.method4274(class4.method90(Players.field1238)));
					var2.overheadText = var11.trim();
					var2.overheadTextColor = var5 >> 8;
					var2.overheadTextEffect = var5 & 255;
					var2.overheadTextCyclesRemaining = 150;
					var2.isAutoChatting = var7;
					var2.field939 = var2 != class215.localPlayer && var6.isUser && "" != Client.field849 && var11.toLowerCase().indexOf(Client.field849) == -1;
					if (var6.isPrivileged) {
						var12 = var7 ? 91 : 1;
					} else {
						var12 = var7 ? 90 : 2;
					}

					if (var6.modIcon != -1) {
						class30.addGameMessage(var12, GrandExchangeEvent.method122(var6.modIcon) + var2.username.getName(), var11);
					} else {
						class30.addGameMessage(var12, var2.username.getName(), var11);
					}
				}
			}

			var0.offset = var9 + var8;
		}

		int var13;
		if ((var3 & 4) != 0) {
			var5 = var0.readUnsignedShort();
			if (var5 == 65535) {
				var5 = -1;
			}

			var13 = var0.method5697();
			MouseRecorder.performPlayerAnimation(var2, var5, var13);
		}

		if ((var3 & 16) != 0) {
			var2.overheadText = var0.readStringCp1252NullTerminated();
			if (var2.overheadText.charAt(0) == '~') {
				var2.overheadText = var2.overheadText.substring(1);
				class30.addGameMessage(2, var2.username.getName(), var2.overheadText);
			} else if (var2 == class215.localPlayer) {
				class30.addGameMessage(2, var2.username.getName(), var2.overheadText);
			}

			var2.isAutoChatting = false;
			var2.overheadTextColor = 0;
			var2.overheadTextEffect = 0;
			var2.overheadTextCyclesRemaining = 150;
		}

		if ((var3 & 2048) != 0) {
			Players.field1228[var1] = var0.method5640();
		}

		if ((var3 & 32) != 0) {
			var2.field934 = var0.method5648();
			if (var2.pathLength == 0) {
				var2.orientation = var2.field934;
				var2.field934 = -1;
			}
		}

		if ((var3 & 8) != 0) {
			var5 = var0.method5622();
			byte[] var16 = new byte[var5];
			Buffer var14 = new Buffer(var16);
			var0.readBytes(var16, 0, var5);
			Players.field1229[var1] = var14;
			var2.read(var14);
		}

		if ((var3 & 256) != 0) {
			var2.field966 = var0.method5640();
			var2.field979 = var0.method5640();
			var2.field967 = var0.method5640();
			var2.field969 = var0.method5671();
			var2.field925 = var0.readUnsignedShort() + Client.cycle;
			var2.field971 = var0.method5647() + Client.cycle;
			var2.field972 = var0.method5648();
			if (var2.field606) {
				var2.field966 += var2.tileX;
				var2.field979 += var2.tileY;
				var2.field967 += var2.tileX;
				var2.field969 += var2.tileY;
				var2.pathLength = 0;
			} else {
				var2.field966 += var2.pathX[0];
				var2.field979 += var2.pathY[0];
				var2.field967 += var2.pathX[0];
				var2.field969 += var2.pathY[0];
				var2.pathLength = 1;
			}

			var2.field983 = 0;
		}

		if ((var3 & 512) != 0) {
			var4 = var0.method5671();
		}

		if ((var3 & 64) != 0) {
			var2.targetIndex = var0.readUnsignedShort();
			if (var2.targetIndex == 65535) {
				var2.targetIndex = -1;
			}
		}

		if ((var3 & 1024) != 0) {
			var2.spotAnimation = var0.method5648();
			var5 = var0.readInt();
			var2.field965 = var5 >> 16;
			var2.field973 = (var5 & 65535) + Client.cycle;
			var2.spotAnimationFrame = 0;
			var2.spotAnimationFrameCycle = 0;
			if (var2.field973 > Client.cycle) {
				var2.spotAnimationFrame = -1;
			}

			if (var2.spotAnimation == 65535) {
				var2.spotAnimation = -1;
			}
		}

		if ((var3 & 1) != 0) {
			var5 = var0.readUnsignedByte();
			int var15;
			int var17;
			int var19;
			if (var5 > 0) {
				for (var13 = 0; var13 < var5; ++var13) {
					var8 = -1;
					var9 = -1;
					var19 = -1;
					var17 = var0.readUShortSmart();
					if (var17 == 32767) {
						var17 = var0.readUShortSmart();
						var9 = var0.readUShortSmart();
						var8 = var0.readUShortSmart();
						var19 = var0.readUShortSmart();
					} else if (var17 != 32766) {
						var9 = var0.readUShortSmart();
					} else {
						var17 = -1;
					}

					var15 = var0.readUShortSmart();
					var2.addHitSplat(var17, var9, var8, var19, Client.cycle, var15);
				}
			}

			var13 = var0.method5697();
			if (var13 > 0) {
				for (var17 = 0; var17 < var13; ++var17) {
					var8 = var0.readUShortSmart();
					var9 = var0.readUShortSmart();
					if (var9 != 32767) {
						var19 = var0.readUShortSmart();
						var15 = var0.method5622();
						var12 = var9 > 0 ? var0.method5697() : var15;
						var2.addHealthBar(var8, Client.cycle, var9, var19, var15, var12);
					} else {
						var2.removeHealthBar(var8);
					}
				}
			}
		}

		if ((var3 & 4096) != 0) {
			for (var5 = 0; var5 < 3; ++var5) {
				var2.actions[var5] = var0.readStringCp1252NullTerminated();
			}
		}

		if (var2.field606) {
			if (var4 == 127) {
				var2.resetPath(var2.tileX, var2.tileY);
			} else {
				byte var18;
				if (var4 != -1) {
					var18 = var4;
				} else {
					var18 = Players.field1228[var1];
				}

				var2.method1334(var2.tileX, var2.tileY, var18);
			}
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ILcj;ZI)I",
		garbageValue = "1197289797"
	)
	static int method3796(int var0, Script var1, boolean var2) {
		String var3;
		if (var0 == ScriptOpcodes.MES) {
			var3 = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
			class30.addGameMessage(0, "", var3);
			return 1;
		} else if (var0 == ScriptOpcodes.ANIM) {
			Interpreter.Interpreter_intStackSize -= 2;
			MouseRecorder.performPlayerAnimation(class215.localPlayer, Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			return 1;
		} else if (var0 == ScriptOpcodes.IF_CLOSE) {
			if (!Interpreter.field1076) {
				Interpreter.field1075 = true;
			}

			return 1;
		} else {
			int var10;
			if (var0 == ScriptOpcodes.RESUME_COUNTDIALOG) {
				var3 = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
				var10 = 0;
				if (AbstractWorldMapData.isNumber(var3)) {
					var10 = ClientPreferences.parseInt(var3);
				}

				PacketBufferNode var12 = SoundSystem.getPacketBufferNode(ClientPacket.field2221, Client.packetWriter.isaacCipher);
				var12.packetBuffer.writeInt(var10);
				Client.packetWriter.addNode(var12);
				return 1;
			} else {
				PacketBufferNode var14;
				if (var0 == ScriptOpcodes.RESUME_NAMEDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
					var14 = SoundSystem.getPacketBufferNode(ClientPacket.field2199, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else if (var0 == ScriptOpcodes.RESUME_STRINGDIALOG) {
					var3 = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
					var14 = SoundSystem.getPacketBufferNode(ClientPacket.field2255, Client.packetWriter.isaacCipher);
					var14.packetBuffer.writeByte(var3.length() + 1);
					var14.packetBuffer.writeStringCp1252NullTerminated(var3);
					Client.packetWriter.addNode(var14);
					return 1;
				} else {
					String var7;
					int var15;
					if (var0 == ScriptOpcodes.OPPLAYER) {
						var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
						Canvas.method934(var15, var7);
						return 1;
					} else if (var0 == ScriptOpcodes.IF_DRAGPICKUP) {
						Interpreter.Interpreter_intStackSize -= 3;
						var15 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						int var9 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
						Widget var13 = PacketBufferNode.getWidget(var9);
						class4.clickWidget(var13, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_DRAGPICKUP) {
						Interpreter.Interpreter_intStackSize -= 2;
						var15 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						Widget var11 = var2 ? class96.field1301 : ReflectionCheck.field1310;
						class4.clickWidget(var11, var15, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.MOUSECAM) {
						WorldMapLabelSize.mouseCam = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.GETREMOVEROOFS) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ScriptEvent.clientPreferences.roofsHidden ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETREMOVEROOFS) {
						ScriptEvent.clientPreferences.roofsHidden = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						HitSplatDefinition.savePreferences();
						return 1;
					} else if (var0 == ScriptOpcodes.OPENURL) {
						var3 = Interpreter.Interpreter_stringStack[--WorldMapDecoration.Interpreter_stringStackSize];
						boolean var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						class2.openURL(var3, var4, false);
						return 1;
					} else if (var0 == ScriptOpcodes.RESUME_OBJDIALOG) {
						var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var14 = SoundSystem.getPacketBufferNode(ClientPacket.field2179, Client.packetWriter.isaacCipher);
						var14.packetBuffer.writeShort(var15);
						Client.packetWriter.addNode(var14);
						return 1;
					} else if (var0 == ScriptOpcodes.BUG_REPORT) {
						var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						WorldMapDecoration.Interpreter_stringStackSize -= 2;
						var7 = Interpreter.Interpreter_stringStack[WorldMapDecoration.Interpreter_stringStackSize];
						String var5 = Interpreter.Interpreter_stringStack[WorldMapDecoration.Interpreter_stringStackSize + 1];
						if (var7.length() > 500) {
							return 1;
						} else if (var5.length() > 500) {
							return 1;
						} else {
							PacketBufferNode var6 = SoundSystem.getPacketBufferNode(ClientPacket.field2230, Client.packetWriter.isaacCipher);
							var6.packetBuffer.writeShort(1 + UserComparator6.stringCp1252NullTerminatedByteSize(var7) + UserComparator6.stringCp1252NullTerminatedByteSize(var5));
							var6.packetBuffer.writeStringCp1252NullTerminated(var7);
							var6.packetBuffer.writeStringCp1252NullTerminated(var5);
							var6.packetBuffer.method5635(var15);
							Client.packetWriter.addNode(var6);
							return 1;
						}
					} else if (var0 == ScriptOpcodes.SETSHIFTCLICKDROP) {
						Client.shiftClickDrop = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSEOVERTEXT) {
						Client.showMouseOverText = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.RENDERSELF) {
						Client.renderSelf = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == 3120) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 1;
						} else {
							Client.drawPlayerNames &= -2;
						}

						return 1;
					} else if (var0 == 3121) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 2;
						} else {
							Client.drawPlayerNames &= -3;
						}

						return 1;
					} else if (var0 == 3122) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 4;
						} else {
							Client.drawPlayerNames &= -5;
						}

						return 1;
					} else if (var0 == 3123) {
						if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
							Client.drawPlayerNames |= 8;
						} else {
							Client.drawPlayerNames &= -9;
						}

						return 1;
					} else if (var0 == 3124) {
						Client.drawPlayerNames = 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWMOUSECROSS) {
						Client.showMouseCross = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETSHOWLOADINGMESSAGES) {
						Client.showLoadingMessages = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
						return 1;
					} else if (var0 == ScriptOpcodes.SETTAPTODROP) {
						ReflectionCheck.setTapToDrop(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1);
						return 1;
					} else if (var0 == ScriptOpcodes.GETTAPTODROP) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapData_1.getTapToDrop() ? 1 : 0;
						return 1;
					} else if (var0 == ScriptOpcodes.SETOCULUSORBSPEED) {
						Interpreter.Interpreter_intStackSize -= 2;
						Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
						Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						return 1;
					} else if (var0 == 3130) {
						Interpreter.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3131) {
						--Interpreter.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.GETCANVASSIZE) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class286.canvasWidth;
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = FloorUnderlayDefinition.canvasHeight;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_SETFPS) {
						--Interpreter.Interpreter_intStackSize;
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORE) {
						return 1;
					} else if (var0 == ScriptOpcodes.MOBILE_OPENSTORECATEGORY) {
						Interpreter.Interpreter_intStackSize -= 2;
						return 1;
					} else if (var0 == 3136) {
						Client.field828 = 3;
						Client.field794 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3137) {
						Client.field828 = 2;
						Client.field794 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						return 1;
					} else if (var0 == 3138) {
						Client.field828 = 0;
						return 1;
					} else if (var0 == 3139) {
						Client.field828 = 1;
						return 1;
					} else if (var0 == 3140) {
						Client.field828 = 3;
						Client.field794 = var2 ? class96.field1301.id : ReflectionCheck.field1310.id;
						return 1;
					} else {
						boolean var8;
						if (var0 == ScriptOpcodes.SETHIDEUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							ScriptEvent.clientPreferences.hideUsername = var8;
							HitSplatDefinition.savePreferences();
							return 1;
						} else if (var0 == ScriptOpcodes.GETHIDEUSERNAME) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ScriptEvent.clientPreferences.hideUsername ? 1 : 0;
							return 1;
						} else if (var0 == ScriptOpcodes.SETREMEMBERUSERNAME) {
							var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							Client.Login_isUsernameRemembered = var8;
							if (!var8) {
								ScriptEvent.clientPreferences.rememberedUsername = "";
								HitSplatDefinition.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETREMEMBERUSERNAME) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
							return 1;
						} else if (var0 == 3145) {
							return 1;
						} else if (var0 == ScriptOpcodes.SETTITLEMUSICENABLED) {
							var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
							if (var8 == ScriptEvent.clientPreferences.titleMusicDisabled) {
								ScriptEvent.clientPreferences.titleMusicDisabled = !var8;
								HitSplatDefinition.savePreferences();
							}

							return 1;
						} else if (var0 == ScriptOpcodes.GETTITLEMUSICENABLED) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ScriptEvent.clientPreferences.titleMusicDisabled ? 0 : 1;
							return 1;
						} else if (var0 == 3148) {
							return 1;
						} else if (var0 == 3149) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3150) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3151) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3152) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3153) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
							return 1;
						} else if (var0 == 3154) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class14.method203();
							return 1;
						} else if (var0 == 3155) {
							--WorldMapDecoration.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3156) {
							return 1;
						} else if (var0 == 3157) {
							Interpreter.Interpreter_intStackSize -= 2;
							return 1;
						} else if (var0 == 3158) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3159) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3160) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3161) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3162) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3163) {
							--WorldMapDecoration.Interpreter_stringStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3164) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3165) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3166) {
							Interpreter.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3167) {
							Interpreter.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3168) {
							Interpreter.Interpreter_intStackSize -= 2;
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
							Interpreter.Interpreter_stringStack[++WorldMapDecoration.Interpreter_stringStackSize - 1] = "";
							return 1;
						} else if (var0 == 3169) {
							return 1;
						} else if (var0 == 3170) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3171) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3172) {
							--Interpreter.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3173) {
							--Interpreter.Interpreter_intStackSize;
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3174) {
							--Interpreter.Interpreter_intStackSize;
							return 1;
						} else if (var0 == 3175) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
							return 1;
						} else if (var0 == 3176) {
							return 1;
						} else if (var0 == 3177) {
							return 1;
						} else if (var0 == 3178) {
							--WorldMapDecoration.Interpreter_stringStackSize;
							return 1;
						} else if (var0 == 3179) {
							return 1;
						} else if (var0 == 3180) {
							--WorldMapDecoration.Interpreter_stringStackSize;
							return 1;
						} else {
							return 2;
						}
					}
				}
			}
		}
	}
}
