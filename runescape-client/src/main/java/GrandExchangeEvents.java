import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
	@ObfuscatedName("t")
	@Export("GrandExchangeEvents_ageComparator")
	public static Comparator GrandExchangeEvents_ageComparator;
	@ObfuscatedName("o")
	@Export("GrandExchangeEvents_priceComparator")
	public static Comparator GrandExchangeEvents_priceComparator;
	@ObfuscatedName("e")
	@Export("GrandExchangeEvents_nameComparator")
	public static Comparator GrandExchangeEvents_nameComparator;
	@ObfuscatedName("i")
	@Export("GrandExchangeEvents_quantityComparator")
	public static Comparator GrandExchangeEvents_quantityComparator;
	@ObfuscatedName("c")
	@Export("events")
	public final List events;

	static {
		GrandExchangeEvents_ageComparator = new GrandExchangeOfferAgeComparator();
		new GrandExchangeOfferWorldComparator();
		GrandExchangeEvents_priceComparator = new GrandExchangeOfferUnitPriceComparator();
		GrandExchangeEvents_nameComparator = new GrandExchangeOfferNameComparator();
		GrandExchangeEvents_quantityComparator = new GrandExchangeOfferTotalQuantityComparator();
	}

	@ObfuscatedSignature(
		signature = "(Lkp;Z)V",
		garbageValue = "1"
	)
	public GrandExchangeEvents(Buffer var1, boolean var2) {
		int var3 = var1.readUnsignedShort();
		boolean var4 = var1.readUnsignedByte() == 1;
		byte var5;
		if (var4) {
			var5 = 1;
		} else {
			var5 = 0;
		}

		int var6 = var1.readUnsignedShort();
		this.events = new ArrayList(var6);

		for (int var7 = 0; var7 < var6; ++var7) {
			this.events.add(new GrandExchangeEvent(var1, var5, var3));
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Ljava/util/Comparator;ZI)V",
		garbageValue = "-221925974"
	)
	@Export("sort")
	public void sort(Comparator var1, boolean var2) {
		if (var2) {
			Collections.sort(this.events, var1);
		} else {
			Collections.sort(this.events, Collections.reverseOrder(var1));
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lbf;I)V",
		garbageValue = "-711075472"
	)
	@Export("doCycleTitle")
	static void doCycleTitle(GameShell var0) {
		if (Login.worldSelectOpen) {
			class208.method4019(var0);
		} else {
			if ((MouseHandler.MouseHandler_lastButton == 1 || !ArchiveLoader.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
				WorldMapSection2.clientPreferences.titleMusicDisabled = !WorldMapSection2.clientPreferences.titleMusicDisabled;
				WorldMapData_1.savePreferences();
				if (!WorldMapSection2.clientPreferences.titleMusicDisabled) {
					class162.method3523(MouseHandler.archive6, "scape main", "", 255, false);
				} else {
					class197.midiPcmStream.clear();
					class197.field2414 = 1;
					UserComparator5.musicTrackArchive = null;
				}
			}

			if (Client.gameState != 5) {
				if (-1L == Login.field1180) {
					Login.field1180 = WorldMapIcon_0.currentTimeMillis() + 1000L;
				}

				long var1 = WorldMapIcon_0.currentTimeMillis();
				if (AbstractRasterProvider.method6151() && Login.field1194 == -1L) {
					Login.field1194 = var1;
					if (Login.field1194 > Login.field1180) {
						Login.field1180 = Login.field1194;
					}
				}

				if (Client.gameState == 10 || Client.gameState == 11) {
					int var3;
					if (Language.Language_EN == FriendLoginUpdate.clientLanguage) {
						if (MouseHandler.MouseHandler_lastButton == 1 || !ArchiveLoader.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
							var3 = Login.xPadding + 5;
							short var4 = 463;
							byte var5 = 100;
							byte var6 = 35;
							if (MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var5 + var3 && MouseHandler.MouseHandler_lastPressedY >= var4 && MouseHandler.MouseHandler_lastPressedY <= var4 + var6) {
								World.method1762();
								return;
							}
						}

						if (World.World_request != null) {
							World.method1762();
						}
					}

					var3 = MouseHandler.MouseHandler_lastButton;
					int var20 = MouseHandler.MouseHandler_lastPressedX;
					int var21 = MouseHandler.MouseHandler_lastPressedY;
					if (var3 == 0) {
						var20 = MouseHandler.MouseHandler_x;
						var21 = MouseHandler.MouseHandler_y;
					}

					if (!ArchiveLoader.mouseCam && var3 == 4) {
						var3 = 1;
					}

					short var24;
					int var25;
					if (Login.loginIndex == 0) {
						boolean var26 = false;

						while (SoundSystem.isKeyDown()) {
							if (RouteStrategy.field2102 == 84) {
								var26 = true;
							}
						}

						var25 = class96.loginBoxCenter - 80;
						var24 = 291;
						if (var3 == 1 && var20 >= var25 - 75 && var20 <= var25 + 75 && var21 >= var24 - 20 && var21 <= var24 + 20) {
							class215.openURL(class42.method809("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
						}

						var25 = class96.loginBoxCenter + 80;
						if (var3 == 1 && var20 >= var25 - 75 && var20 <= var25 + 75 && var21 >= var24 - 20 && var21 <= var24 + 20 || var26) {
							if ((Client.worldProperties & 33554432) != 0) {
								Login.Login_response0 = "";
								Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
								Login.Login_response2 = "Your normal account will not be affected.";
								Login.Login_response3 = "";
								Login.loginIndex = 1;
								class81.method2099();
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
								class81.method2099();
							} else if ((Client.worldProperties & 1024) != 0) {
								Login.Login_response1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
								Login.Login_response2 = "The Protect Item prayer will";
								Login.Login_response3 = "not work on this world.";
								Login.Login_response0 = "Warning!";
								Login.loginIndex = 1;
								class81.method2099();
							} else {
								ViewportMouse.Login_promptCredentials(false);
							}
						}
					} else {
						short var7;
						int var22;
						if (Login.loginIndex == 1) {
							while (true) {
								if (!SoundSystem.isKeyDown()) {
									var22 = class96.loginBoxCenter - 80;
									var7 = 321;
									if (var3 == 1 && var20 >= var22 - 75 && var20 <= var22 + 75 && var21 >= var7 - 20 && var21 <= var7 + 20) {
										ViewportMouse.Login_promptCredentials(false);
									}

									var22 = class96.loginBoxCenter + 80;
									if (var3 == 1 && var20 >= var22 - 75 && var20 <= var22 + 75 && var21 >= var7 - 20 && var21 <= var7 + 20) {
										Login.loginIndex = 0;
									}
									break;
								}

								if (RouteStrategy.field2102 == 84) {
									ViewportMouse.Login_promptCredentials(false);
								} else if (RouteStrategy.field2102 == 13) {
									Login.loginIndex = 0;
								}
							}
						} else {
							short var23;
							if (Login.loginIndex == 2) {
								var23 = 201;
								var22 = var23 + 52;
								if (var3 == 1 && var21 >= var22 - 12 && var21 < var22 + 2) {
									Login.currentLoginField = 0;
								}

								var22 += 15;
								if (var3 == 1 && var21 >= var22 - 12 && var21 < var22 + 2) {
									Login.currentLoginField = 1;
								}

								var22 += 15;
								var23 = 361;
								if (Login.field1175 != null) {
									var25 = Login.field1175.highX / 2;
									if (var3 == 1 && var20 >= Login.field1175.lowX - var25 && var20 <= var25 + Login.field1175.lowX && var21 >= var23 - 15 && var21 < var23) {
										switch(Login.field1193) {
										case 1:
											Tiles.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
											Login.loginIndex = 5;
											return;
										case 2:
											class215.openURL("https://support.runescape.com/hc/en-gb", true, false);
										}
									}
								}

								var25 = class96.loginBoxCenter - 80;
								var24 = 321;
								if (var3 == 1 && var20 >= var25 - 75 && var20 <= var25 + 75 && var21 >= var24 - 20 && var21 <= var24 + 20) {
									Login.Login_username = Login.Login_username.trim();
									if (Login.Login_username.length() == 0) {
										Tiles.setLoginResponseString("", "Please enter your username/email address.", "");
										return;
									}

									if (Login.Login_password.length() == 0) {
										Tiles.setLoginResponseString("", "Please enter your password.", "");
										return;
									}

									Tiles.setLoginResponseString("", "Connecting to server...", "");
									UserComparator3.method3497(false);
									Projectile.updateGameState(20);
									return;
								}

								var25 = Login.loginBoxX + 180 + 80;
								if (var3 == 1 && var20 >= var25 - 75 && var20 <= var25 + 75 && var21 >= var24 - 20 && var21 <= var24 + 20) {
									Login.loginIndex = 0;
									Login.Login_username = "";
									Login.Login_password = "";
									Frames.field1885 = 0;
									LoginScreenAnimation.otp = "";
									Login.field1185 = true;
								}

								var25 = class96.loginBoxCenter + -117;
								var24 = 277;
								Login.field1183 = var20 >= var25 && var20 < var25 + class216.field2559 && var21 >= var24 && var21 < var24 + AbstractWorldMapData.field190;
								if (var3 == 1 && Login.field1183) {
									Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
									if (!Client.Login_isUsernameRemembered && WorldMapSection2.clientPreferences.rememberedUsername != null) {
										WorldMapSection2.clientPreferences.rememberedUsername = null;
										WorldMapData_1.savePreferences();
									}
								}

								var25 = class96.loginBoxCenter + 24;
								var24 = 277;
								Login.field1184 = var20 >= var25 && var20 < var25 + class216.field2559 && var21 >= var24 && var21 < var24 + AbstractWorldMapData.field190;
								if (var3 == 1 && Login.field1184) {
									WorldMapSection2.clientPreferences.hideUsername = !WorldMapSection2.clientPreferences.hideUsername;
									if (!WorldMapSection2.clientPreferences.hideUsername) {
										Login.Login_username = "";
										WorldMapSection2.clientPreferences.rememberedUsername = null;
										class81.method2099();
									}

									WorldMapData_1.savePreferences();
								}

								while (true) {
									Transferable var10;
									int var11;
									do {
										while (true) {
											label870:
											do {
												while (true) {
													while (SoundSystem.isKeyDown()) {
														if (RouteStrategy.field2102 != 13) {
															if (Login.currentLoginField != 0) {
																continue label870;
															}

															DirectByteArrayCopier.method4004(class51.field432);
															if (RouteStrategy.field2102 == 85 && Login.Login_username.length() > 0) {
																Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
															}

															if (RouteStrategy.field2102 == 84 || RouteStrategy.field2102 == 80) {
																Login.currentLoginField = 1;
															}

															if (class238.method4414(class51.field432) && Login.Login_username.length() < 320) {
																Login.Login_username = Login.Login_username + class51.field432;
															}
														} else {
															Login.loginIndex = 0;
															Login.Login_username = "";
															Login.Login_password = "";
															Frames.field1885 = 0;
															LoginScreenAnimation.otp = "";
															Login.field1185 = true;
														}
													}

													return;
												}
											} while(Login.currentLoginField != 1);

											if (RouteStrategy.field2102 == 85 && Login.Login_password.length() > 0) {
												Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
											} else if (RouteStrategy.field2102 == 84 || RouteStrategy.field2102 == 80) {
												Login.currentLoginField = 0;
												if (RouteStrategy.field2102 == 84) {
													Login.Login_username = Login.Login_username.trim();
													if (Login.Login_username.length() == 0) {
														Tiles.setLoginResponseString("", "Please enter your username/email address.", "");
														return;
													}

													if (Login.Login_password.length() == 0) {
														Tiles.setLoginResponseString("", "Please enter your password.", "");
														return;
													}

													Tiles.setLoginResponseString("", "Connecting to server...", "");
													UserComparator3.method3497(false);
													Projectile.updateGameState(20);
													return;
												}
											}

											if ((KeyHandler.KeyHandler_pressedKeys[82] || KeyHandler.KeyHandler_pressedKeys[87]) && RouteStrategy.field2102 == 67) {
												Clipboard var9 = Toolkit.getDefaultToolkit().getSystemClipboard();
												var10 = var9.getContents(Username.client);
												var11 = 20 - Login.Login_password.length();
												break;
											}

											if (BuddyRankComparator.method3510(class51.field432) && class238.method4414(class51.field432) && Login.Login_password.length() < 20) {
												Login.Login_password = Login.Login_password + class51.field432;
											}
										}
									} while(var11 <= 0);

									try {
										String var12 = (String)var10.getTransferData(DataFlavor.stringFlavor);
										int var13 = Math.min(var11, var12.length());

										for (int var14 = 0; var14 < var13; ++var14) {
											if (!BuddyRankComparator.method3510(var12.charAt(var14)) || !class238.method4414(var12.charAt(var14))) {
												Login.loginIndex = 3;
												return;
											}
										}

										Login.Login_password = Login.Login_password + var12.substring(0, var13);
									} catch (UnsupportedFlavorException var18) {
									} catch (IOException var19) {
									}
								}
							} else if (Login.loginIndex == 3) {
								var22 = Login.loginBoxX + 180;
								var7 = 276;
								if (var3 == 1 && var20 >= var22 - 75 && var20 <= var22 + 75 && var21 >= var7 - 20 && var21 <= var7 + 20) {
									ViewportMouse.Login_promptCredentials(false);
								}

								var22 = Login.loginBoxX + 180;
								var7 = 326;
								if (var3 == 1 && var20 >= var22 - 75 && var20 <= var22 + 75 && var21 >= var7 - 20 && var21 <= var7 + 20) {
									Tiles.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
									Login.loginIndex = 5;
									return;
								}
							} else {
								int var15;
								if (Login.loginIndex == 4) {
									var22 = Login.loginBoxX + 180 - 80;
									var7 = 321;
									if (var3 == 1 && var20 >= var22 - 75 && var20 <= var22 + 75 && var21 >= var7 - 20 && var21 <= var7 + 20) {
										LoginScreenAnimation.otp.trim();
										if (LoginScreenAnimation.otp.length() != 6) {
											Tiles.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
											return;
										}

										Frames.field1885 = Integer.parseInt(LoginScreenAnimation.otp);
										LoginScreenAnimation.otp = "";
										UserComparator3.method3497(true);
										Tiles.setLoginResponseString("", "Connecting to server...", "");
										Projectile.updateGameState(20);
										return;
									}

									if (var3 == 1 && var20 >= Login.loginBoxX + 180 - 9 && var20 <= Login.loginBoxX + 180 + 130 && var21 >= 263 && var21 <= 296) {
										Login.field1185 = !Login.field1185;
									}

									if (var3 == 1 && var20 >= Login.loginBoxX + 180 - 34 && var20 <= Login.loginBoxX + 34 + 180 && var21 >= 351 && var21 <= 363) {
										class215.openURL(class42.method809("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
									}

									var22 = Login.loginBoxX + 180 + 80;
									if (var3 == 1 && var20 >= var22 - 75 && var20 <= var22 + 75 && var21 >= var7 - 20 && var21 <= var7 + 20) {
										Login.loginIndex = 0;
										Login.Login_username = "";
										Login.Login_password = "";
										Frames.field1885 = 0;
										LoginScreenAnimation.otp = "";
									}

									while (SoundSystem.isKeyDown()) {
										boolean var8 = false;

										for (var15 = 0; var15 < "1234567890".length(); ++var15) {
											if (class51.field432 == "1234567890".charAt(var15)) {
												var8 = true;
												break;
											}
										}

										if (RouteStrategy.field2102 == 13) {
											Login.loginIndex = 0;
											Login.Login_username = "";
											Login.Login_password = "";
											Frames.field1885 = 0;
											LoginScreenAnimation.otp = "";
										} else {
											if (RouteStrategy.field2102 == 85 && LoginScreenAnimation.otp.length() > 0) {
												LoginScreenAnimation.otp = LoginScreenAnimation.otp.substring(0, LoginScreenAnimation.otp.length() - 1);
											}

											if (RouteStrategy.field2102 == 84) {
												LoginScreenAnimation.otp.trim();
												if (LoginScreenAnimation.otp.length() != 6) {
													Tiles.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
													return;
												}

												Frames.field1885 = Integer.parseInt(LoginScreenAnimation.otp);
												LoginScreenAnimation.otp = "";
												UserComparator3.method3497(true);
												Tiles.setLoginResponseString("", "Connecting to server...", "");
												Projectile.updateGameState(20);
												return;
											}

											if (var8 && LoginScreenAnimation.otp.length() < 6) {
												LoginScreenAnimation.otp = LoginScreenAnimation.otp + class51.field432;
											}
										}
									}
								} else if (Login.loginIndex == 5) {
									var22 = Login.loginBoxX + 180 - 80;
									var7 = 321;
									if (var3 == 1 && var20 >= var22 - 75 && var20 <= var22 + 75 && var21 >= var7 - 20 && var21 <= var7 + 20) {
										WorldMapSection2.method344();
										return;
									}

									var22 = Login.loginBoxX + 180 + 80;
									if (var3 == 1 && var20 >= var22 - 75 && var20 <= var22 + 75 && var21 >= var7 - 20 && var21 <= var7 + 20) {
										ViewportMouse.Login_promptCredentials(true);
									}

									var24 = 361;
									if (WorldMapCacheName.field315 != null) {
										var15 = WorldMapCacheName.field315.highX / 2;
										if (var3 == 1 && var20 >= WorldMapCacheName.field315.lowX - var15 && var20 <= var15 + WorldMapCacheName.field315.lowX && var21 >= var24 - 15 && var21 < var24) {
											class215.openURL(class42.method809("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
										}
									}

									while (SoundSystem.isKeyDown()) {
										boolean var27 = false;

										for (int var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var16) {
											if (class51.field432 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var16)) {
												var27 = true;
												break;
											}
										}

										if (RouteStrategy.field2102 == 13) {
											ViewportMouse.Login_promptCredentials(true);
										} else {
											if (RouteStrategy.field2102 == 85 && Login.Login_username.length() > 0) {
												Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
											}

											if (RouteStrategy.field2102 == 84) {
												WorldMapSection2.method344();
												return;
											}

											if (var27 && Login.Login_username.length() < 320) {
												Login.Login_username = Login.Login_username + class51.field432;
											}
										}
									}
								} else if (Login.loginIndex != 6) {
									if (Login.loginIndex == 7) {
										var22 = Login.loginBoxX + 180 - 80;
										var7 = 321;
										if (var3 == 1 && var20 >= var22 - 75 && var20 <= var22 + 75 && var21 >= var7 - 20 && var21 <= var7 + 20) {
											class215.openURL(class42.method809("secure", true) + "m=dob/set_dob.ws", true, false);
											Tiles.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											Login.loginIndex = 6;
											return;
										}

										var22 = Login.loginBoxX + 180 + 80;
										if (var3 == 1 && var20 >= var22 - 75 && var20 <= var22 + 75 && var21 >= var7 - 20 && var21 <= var7 + 20) {
											ViewportMouse.Login_promptCredentials(true);
										}
									} else if (Login.loginIndex == 8) {
										var22 = Login.loginBoxX + 180 - 80;
										var7 = 321;
										if (var3 == 1 && var20 >= var22 - 75 && var20 <= var22 + 75 && var21 >= var7 - 20 && var21 <= var7 + 20) {
											class215.openURL("https://www.jagex.com/terms/privacy", true, false);
											Tiles.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											Login.loginIndex = 6;
											return;
										}

										var22 = Login.loginBoxX + 180 + 80;
										if (var3 == 1 && var20 >= var22 - 75 && var20 <= var22 + 75 && var21 >= var7 - 20 && var21 <= var7 + 20) {
											ViewportMouse.Login_promptCredentials(true);
										}
									} else if (Login.loginIndex == 12) {
										String var17 = "";
										switch(Login.field1165) {
										case 0:
											var17 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
											break;
										case 1:
											var17 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
											break;
										default:
											ViewportMouse.Login_promptCredentials(false);
										}

										var25 = Login.loginBoxX + 180;
										var24 = 276;
										if (var3 == 1 && var20 >= var25 - 75 && var20 <= var25 + 75 && var21 >= var24 - 20 && var21 <= var24 + 20) {
											class215.openURL(var17, true, false);
											Tiles.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											Login.loginIndex = 6;
											return;
										}

										var25 = Login.loginBoxX + 180;
										var24 = 326;
										if (var3 == 1 && var20 >= var25 - 75 && var20 <= var25 + 75 && var21 >= var24 - 20 && var21 <= var24 + 20) {
											ViewportMouse.Login_promptCredentials(false);
										}
									} else if (Login.loginIndex == 24) {
										var22 = Login.loginBoxX + 180;
										var7 = 301;
										if (var3 == 1 && var20 >= var22 - 75 && var20 <= var22 + 75 && var21 >= var7 - 20 && var21 <= var7 + 20) {
											ViewportMouse.Login_promptCredentials(false);
										}
									}
								} else {
									while (true) {
										do {
											if (!SoundSystem.isKeyDown()) {
												var23 = 321;
												if (var3 == 1 && var21 >= var23 - 20 && var21 <= var23 + 20) {
													ViewportMouse.Login_promptCredentials(true);
												}

												return;
											}
										} while(RouteStrategy.field2102 != 84 && RouteStrategy.field2102 != 13);

										ViewportMouse.Login_promptCredentials(true);
									}
								}
							}
						}
					}

				}
			}
		}
	}

	@ObfuscatedName("m")
	@Export("Entity_unpackID")
	public static int Entity_unpackID(long var0) {
		return (int)(var0 >>> 17 & 4294967295L);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lbg;I)V",
		garbageValue = "-1842266265"
	)
	@Export("changeWorld")
	static void changeWorld(World var0) {
		if (var0.isMembersOnly() != Client.isMembersWorld) {
			Client.isMembersWorld = var0.isMembersOnly();
			WorldMapLabelSize.method197(var0.isMembersOnly());
		}

		NetSocket.worldHost = var0.host;
		Client.worldId = var0.id;
		Client.worldProperties = var0.properties;
		WorldMapLabelSize.port1 = Client.gameBuild == 0 ? 43594 : var0.id + 40000;
		Client.port2 = Client.gameBuild == 0 ? 443 : var0.id + 50000;
		WorldMapSection2.port3 = WorldMapLabelSize.port1;
	}

	@ObfuscatedName("jr")
	@ObfuscatedSignature(
		signature = "(Lhn;Lif;IIZI)V",
		garbageValue = "-1029339816"
	)
	@Export("addWidgetItemMenuItem")
	static final void addWidgetItemMenuItem(Widget var0, ItemDefinition var1, int var2, int var3, boolean var4) {
		String[] var5 = var1.inventoryActions;
		byte var6 = -1;
		String var7 = null;
		if (var5 != null && var5[var3] != null) {
			if (var3 == 0) {
				var6 = 33;
			} else if (var3 == 1) {
				var6 = 34;
			} else if (var3 == 2) {
				var6 = 35;
			} else if (var3 == 3) {
				var6 = 36;
			} else {
				var6 = 37;
			}

			var7 = var5[var3];
		} else if (var3 == 4) {
			var6 = 37;
			var7 = "Drop";
		}

		if (var6 != -1 && var7 != null) {
			class160.insertMenuItem(var7, PacketWriter.colorStartTag(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
		}

	}
}
