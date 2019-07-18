import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("VarbitDefinition")
public class VarbitDefinition extends DualNode {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("VarbitDefinition_archive")
	public static AbstractArchive VarbitDefinition_archive;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("VarbitDefinition_cached")
	public static EvictingDualNodeHashTable VarbitDefinition_cached;
	@ObfuscatedName("s")
	@Export("BZip2Decompressor_block")
	static int[] BZip2Decompressor_block;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 30212683
	)
	@Export("baseVar")
	public int baseVar;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1456133489
	)
	@Export("startBit")
	public int startBit;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1287867035
	)
	@Export("endBit")
	public int endBit;

	static {
		VarbitDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "-1936267259"
	)
	@Export("decode")
	public void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkf;II)V",
		garbageValue = "611768322"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 1) {
			this.baseVar = var1.readUnsignedShort();
			this.startBit = var1.readUnsignedByte();
			this.endBit = var1.readUnsignedByte();
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;II)I",
		garbageValue = "508851632"
	)
	@Export("parseIntCustomRadix")
	public static int parseIntCustomRadix(CharSequence var0, int var1) {
		return WorldMapSection1.parseIntCustomRadix(var0, var1, true);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lbz;I)V",
		garbageValue = "-442455221"
	)
	static void method4484(GameShell var0) {
		int var3;
		int var15;
		if (Login.worldSelectOpen) {
			while (true) {
				if (!class218.method4109()) {
					if (MouseHandler.MouseHandler_lastButton != 1 && (DevicePcmPlayerProvider.mouseCam || MouseHandler.MouseHandler_lastButton != 4)) {
						break;
					}

					int var1 = Login.xPadding + 280;
					if (MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var1 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class192.changeWorldSelectSorting(0, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var1 + 15 && MouseHandler.MouseHandler_lastPressedX <= var1 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class192.changeWorldSelectSorting(0, 1);
						break;
					}

					int var2 = Login.xPadding + 390;
					if (MouseHandler.MouseHandler_lastPressedX >= var2 && MouseHandler.MouseHandler_lastPressedX <= var2 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class192.changeWorldSelectSorting(1, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var2 + 15 && MouseHandler.MouseHandler_lastPressedX <= var2 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class192.changeWorldSelectSorting(1, 1);
						break;
					}

					var3 = Login.xPadding + 500;
					if (MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var3 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class192.changeWorldSelectSorting(2, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var3 + 15 && MouseHandler.MouseHandler_lastPressedX <= var3 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class192.changeWorldSelectSorting(2, 1);
						break;
					}

					var15 = Login.xPadding + 610;
					if (MouseHandler.MouseHandler_lastPressedX >= var15 && MouseHandler.MouseHandler_lastPressedX <= var15 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class192.changeWorldSelectSorting(3, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var15 + 15 && MouseHandler.MouseHandler_lastPressedX <= var15 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class192.changeWorldSelectSorting(3, 1);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
						Login.worldSelectOpen = false;
						GrandExchangeOfferWorldComparator.leftTitleSprite.drawAt(Login.xPadding, 0);
						NPC.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
						GroundItem.logoSprite.drawAt(Login.xPadding + 382 - GroundItem.logoSprite.subWidth / 2, 18);
						break;
					}

					if (Login.hoveredWorldIndex != -1) {
						World var13 = World.worlds[Login.hoveredWorldIndex];
						MusicPatchPcmStream.changeWorld(var13);
						Login.worldSelectOpen = false;
						GrandExchangeOfferWorldComparator.leftTitleSprite.drawAt(Login.xPadding, 0);
						NPC.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
						GroundItem.logoSprite.drawAt(Login.xPadding + 382 - GroundItem.logoSprite.subWidth / 2, 18);
					} else {
						if (Login.worldSelectPage > 0 && Login.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= Login.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= ParamDefinition.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= ParamDefinition.canvasHeight / 2 + 50) {
							--Login.worldSelectPage;
						}

						if (Login.worldSelectPage < Login.worldSelectPagesCount && NPCDefinition.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= GrandExchangeEvent.canvasWidth - NPCDefinition.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= GrandExchangeEvent.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= ParamDefinition.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= ParamDefinition.canvasHeight / 2 + 50) {
							++Login.worldSelectPage;
						}
					}
					break;
				}

				if (ReflectionCheck.field1338 == 13) {
					Login.worldSelectOpen = false;
					GrandExchangeOfferWorldComparator.leftTitleSprite.drawAt(Login.xPadding, 0);
					NPC.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
					GroundItem.logoSprite.drawAt(Login.xPadding + 382 - GroundItem.logoSprite.subWidth / 2, 18);
					break;
				}

				if (ReflectionCheck.field1338 == 96) {
					if (Login.worldSelectPage > 0 && Login.worldSelectLeftSprite != null) {
						--Login.worldSelectPage;
					}
				} else if (ReflectionCheck.field1338 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && NPCDefinition.worldSelectRightSprite != null) {
					++Login.worldSelectPage;
				}
			}

		} else {
			if ((MouseHandler.MouseHandler_lastButton == 1 || !DevicePcmPlayerProvider.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
				WorldMapLabelSize.clientPreferences.titleMusicDisabled = !WorldMapLabelSize.clientPreferences.titleMusicDisabled;
				ReflectionCheck.savePreferences();
				if (!WorldMapLabelSize.clientPreferences.titleMusicDisabled) {
					TextureProvider.method2761(WorldMapRegion.archive6, "scape main", "", 255, false);
				} else {
					NetSocket.method3553();
				}
			}

			if (Client.gameState != 5) {
				if (Login.field1193 == -1L) {
					Login.field1193 = DirectByteArrayCopier.currentTimeMs() + 1000L;
				}

				long var11 = DirectByteArrayCopier.currentTimeMs();
				if (class190.method3667() && -1L == Login.field1211) {
					Login.field1211 = var11;
					if (Login.field1211 > Login.field1193) {
						Login.field1193 = Login.field1211;
					}
				}

				if (Client.gameState == 10 || Client.gameState == 11) {
					if (class190.field2348 == ScriptFrame.field528) {
						if (MouseHandler.MouseHandler_lastButton == 1 || !DevicePcmPlayerProvider.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
							var3 = Login.xPadding + 5;
							short var4 = 463;
							byte var5 = 100;
							byte var6 = 35;
							if (MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var3 + var5 && MouseHandler.MouseHandler_lastPressedY >= var4 && MouseHandler.MouseHandler_lastPressedY <= var6 + var4) {
								ChatChannel.method2214();
								return;
							}
						}

						if (World.field1027 != null) {
							ChatChannel.method2214();
						}
					}

					var3 = MouseHandler.MouseHandler_lastButton;
					var15 = MouseHandler.MouseHandler_lastPressedX;
					int var16 = MouseHandler.MouseHandler_lastPressedY;
					if (var3 == 0) {
						var15 = MouseHandler.MouseHandler_x;
						var16 = MouseHandler.MouseHandler_y;
					}

					if (!DevicePcmPlayerProvider.mouseCam && var3 == 4) {
						var3 = 1;
					}

					int var7;
					short var8;
					if (Login.loginIndex == 0) {
						boolean var17 = false;

						while (class218.method4109()) {
							if (ReflectionCheck.field1338 == 84) {
								var17 = true;
							}
						}

						var7 = ScriptEvent.loginBoxCenter - 80;
						var8 = 291;
						if (var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var16 >= var8 - 20 && var16 <= var8 + 20) {
							GrandExchangeOfferWorldComparator.openURL(class190.method3666("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
						}

						var7 = ScriptEvent.loginBoxCenter + 80;
						if (var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var16 >= var8 - 20 && var16 <= var8 + 20 || var17) {
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
								FaceNormal.method3266(false);
							}
						}
					} else {
						int var18;
						short var20;
						if (Login.loginIndex != 1) {
							boolean var9;
							int var10;
							short var19;
							if (Login.loginIndex == 2) {
								var19 = 201;
								var18 = var19 + 52;
								if (var3 == 1 && var16 >= var18 - 12 && var16 < var18 + 2) {
									Login.currentLoginField = 0;
								}

								var18 += 15;
								if (var3 == 1 && var16 >= var18 - 12 && var16 < var18 + 2) {
									Login.currentLoginField = 1;
								}

								var18 += 15;
								var19 = 361;
								if (class96.field1325 != null) {
									var7 = class96.field1325.highX / 2;
									if (var3 == 1 && var15 >= class96.field1325.lowX - var7 && var15 <= var7 + class96.field1325.lowX && var16 >= var19 - 15 && var16 < var19) {
										switch(Login.field1212) {
										case 1:
											class268.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
											Login.loginIndex = 5;
											return;
										case 2:
											GrandExchangeOfferWorldComparator.openURL("https://support.runescape.com/hc/en-gb", true, false);
										}
									}
								}

								var7 = ScriptEvent.loginBoxCenter - 80;
								var8 = 321;
								if (var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var16 >= var8 - 20 && var16 <= var8 + 20) {
									Login.Login_username = Login.Login_username.trim();
									if (Login.Login_username.length() == 0) {
										class268.setLoginResponseString("", "Please enter your username/email address.", "");
										return;
									}

									if (Login.Login_password.length() == 0) {
										class268.setLoginResponseString("", "Please enter your password.", "");
										return;
									}

									class268.setLoginResponseString("", "Connecting to server...", "");
									GrandExchangeOffer.method99(false);
									class96.updateGameState(20);
									return;
								}

								var7 = Login.loginBoxX + 180 + 80;
								if (var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var16 >= var8 - 20 && var16 <= var8 + 20) {
									Login.loginIndex = 0;
									Login.Login_username = "";
									Login.Login_password = "";
									GrandExchangeOffer.field65 = 0;
									WorldMapManager.otp = "";
									Login.field1201 = true;
								}

								var7 = ScriptEvent.loginBoxCenter + -117;
								var8 = 277;
								Login.field1199 = var15 >= var7 && var15 < var7 + class237.field3191 && var16 >= var8 && var16 < var8 + WorldMapDecoration.field212;
								if (var3 == 1 && Login.field1199) {
									Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
									if (!Client.Login_isUsernameRemembered && WorldMapLabelSize.clientPreferences.rememberedUsername != null) {
										WorldMapLabelSize.clientPreferences.rememberedUsername = null;
										ReflectionCheck.savePreferences();
									}
								}

								var7 = ScriptEvent.loginBoxCenter + 24;
								var8 = 277;
								Login.field1184 = var15 >= var7 && var15 < var7 + class237.field3191 && var16 >= var8 && var16 < var8 + WorldMapDecoration.field212;
								if (var3 == 1 && Login.field1184) {
									WorldMapLabelSize.clientPreferences.hideUsername = !WorldMapLabelSize.clientPreferences.hideUsername;
									if (!WorldMapLabelSize.clientPreferences.hideUsername) {
										Login.Login_username = "";
										WorldMapLabelSize.clientPreferences.rememberedUsername = null;
										if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
											Login.currentLoginField = 1;
										} else {
											Login.currentLoginField = 0;
										}
									}

									ReflectionCheck.savePreferences();
								}

								while (true) {
									while (class218.method4109()) {
										var9 = false;

										for (var10 = 0; var10 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var10) {
											if (Calendar.field2508 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var10)) {
												var9 = true;
												break;
											}
										}

										if (ReflectionCheck.field1338 == 13) {
											Login.loginIndex = 0;
											Login.Login_username = "";
											Login.Login_password = "";
											GrandExchangeOffer.field65 = 0;
											WorldMapManager.otp = "";
											Login.field1201 = true;
										} else if (Login.currentLoginField == 0) {
											if (ReflectionCheck.field1338 == 85 && Login.Login_username.length() > 0) {
												Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
											}

											if (ReflectionCheck.field1338 == 84 || ReflectionCheck.field1338 == 80) {
												Login.currentLoginField = 1;
											}

											if (var9 && Login.Login_username.length() < 320) {
												Login.Login_username = Login.Login_username + Calendar.field2508;
											}
										} else if (Login.currentLoginField == 1) {
											if (ReflectionCheck.field1338 == 85 && Login.Login_password.length() > 0) {
												Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
											}

											if (ReflectionCheck.field1338 == 84 || ReflectionCheck.field1338 == 80) {
												Login.currentLoginField = 0;
											}

											if (ReflectionCheck.field1338 == 84) {
												Login.Login_username = Login.Login_username.trim();
												if (Login.Login_username.length() == 0) {
													class268.setLoginResponseString("", "Please enter your username/email address.", "");
													return;
												}

												if (Login.Login_password.length() == 0) {
													class268.setLoginResponseString("", "Please enter your password.", "");
													return;
												}

												class268.setLoginResponseString("", "Connecting to server...", "");
												GrandExchangeOffer.method99(false);
												class96.updateGameState(20);
												return;
											}

											if (var9 && Login.Login_password.length() < 20) {
												Login.Login_password = Login.Login_password + Calendar.field2508;
											}
										}
									}

									return;
								}
							} else if (Login.loginIndex == 3) {
								var18 = Login.loginBoxX + 180;
								var20 = 276;
								if (var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
									FaceNormal.method3266(false);
								}

								var18 = Login.loginBoxX + 180;
								var20 = 326;
								if (var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
									class268.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
									Login.loginIndex = 5;
									return;
								}
							} else {
								int var22;
								if (Login.loginIndex == 4) {
									var18 = Login.loginBoxX + 180 - 80;
									var20 = 321;
									if (var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
										WorldMapManager.otp.trim();
										if (WorldMapManager.otp.length() != 6) {
											class268.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
											return;
										}

										GrandExchangeOffer.field65 = Integer.parseInt(WorldMapManager.otp);
										WorldMapManager.otp = "";
										GrandExchangeOffer.method99(true);
										class268.setLoginResponseString("", "Connecting to server...", "");
										class96.updateGameState(20);
										return;
									}

									if (var3 == 1 && var15 >= Login.loginBoxX + 180 - 9 && var15 <= Login.loginBoxX + 180 + 130 && var16 >= 263 && var16 <= 296) {
										Login.field1201 = !Login.field1201;
									}

									if (var3 == 1 && var15 >= Login.loginBoxX + 180 - 34 && var15 <= Login.loginBoxX + 34 + 180 && var16 >= 351 && var16 <= 363) {
										GrandExchangeOfferWorldComparator.openURL(class190.method3666("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
									}

									var18 = Login.loginBoxX + 180 + 80;
									if (var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
										Login.loginIndex = 0;
										Login.Login_username = "";
										Login.Login_password = "";
										GrandExchangeOffer.field65 = 0;
										WorldMapManager.otp = "";
									}

									while (class218.method4109()) {
										boolean var21 = false;

										for (var22 = 0; var22 < "1234567890".length(); ++var22) {
											if (Calendar.field2508 == "1234567890".charAt(var22)) {
												var21 = true;
												break;
											}
										}

										if (ReflectionCheck.field1338 == 13) {
											Login.loginIndex = 0;
											Login.Login_username = "";
											Login.Login_password = "";
											GrandExchangeOffer.field65 = 0;
											WorldMapManager.otp = "";
										} else {
											if (ReflectionCheck.field1338 == 85 && WorldMapManager.otp.length() > 0) {
												WorldMapManager.otp = WorldMapManager.otp.substring(0, WorldMapManager.otp.length() - 1);
											}

											if (ReflectionCheck.field1338 == 84) {
												WorldMapManager.otp.trim();
												if (WorldMapManager.otp.length() != 6) {
													class268.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
													return;
												}

												GrandExchangeOffer.field65 = Integer.parseInt(WorldMapManager.otp);
												WorldMapManager.otp = "";
												GrandExchangeOffer.method99(true);
												class268.setLoginResponseString("", "Connecting to server...", "");
												class96.updateGameState(20);
												return;
											}

											if (var21 && WorldMapManager.otp.length() < 6) {
												WorldMapManager.otp = WorldMapManager.otp + Calendar.field2508;
											}
										}
									}
								} else if (Login.loginIndex == 5) {
									var18 = Login.loginBoxX + 180 - 80;
									var20 = 321;
									if (var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
										UserComparator10.method3406();
										return;
									}

									var18 = Login.loginBoxX + 180 + 80;
									if (var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
										FaceNormal.method3266(true);
									}

									var8 = 361;
									if (WorldMapAreaData.field332 != null) {
										var22 = WorldMapAreaData.field332.highX / 2;
										if (var3 == 1 && var15 >= WorldMapAreaData.field332.lowX - var22 && var15 <= var22 + WorldMapAreaData.field332.lowX && var16 >= var8 - 15 && var16 < var8) {
											GrandExchangeOfferWorldComparator.openURL(class190.method3666("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
										}
									}

									while (class218.method4109()) {
										var9 = false;

										for (var10 = 0; var10 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var10) {
											if (Calendar.field2508 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var10)) {
												var9 = true;
												break;
											}
										}

										if (ReflectionCheck.field1338 == 13) {
											FaceNormal.method3266(true);
										} else {
											if (ReflectionCheck.field1338 == 85 && Login.Login_username.length() > 0) {
												Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
											}

											if (ReflectionCheck.field1338 == 84) {
												UserComparator10.method3406();
												return;
											}

											if (var9 && Login.Login_username.length() < 320) {
												Login.Login_username = Login.Login_username + Calendar.field2508;
											}
										}
									}
								} else if (Login.loginIndex == 6) {
									while (true) {
										do {
											if (!class218.method4109()) {
												var19 = 321;
												if (var3 == 1 && var16 >= var19 - 20 && var16 <= var19 + 20) {
													FaceNormal.method3266(true);
												}

												return;
											}
										} while(ReflectionCheck.field1338 != 84 && ReflectionCheck.field1338 != 13);

										FaceNormal.method3266(true);
									}
								} else if (Login.loginIndex == 7) {
									var18 = Login.loginBoxX + 180 - 80;
									var20 = 321;
									if (var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
										GrandExchangeOfferWorldComparator.openURL(class190.method3666("secure", true) + "m=dob/set_dob.ws", true, false);
										class268.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
										Login.loginIndex = 6;
										return;
									}

									var18 = Login.loginBoxX + 180 + 80;
									if (var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
										FaceNormal.method3266(true);
									}
								} else if (Login.loginIndex == 8) {
									var18 = Login.loginBoxX + 180 - 80;
									var20 = 321;
									if (var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
										GrandExchangeOfferWorldComparator.openURL("https://www.jagex.com/terms/privacy/#eight", true, false);
										class268.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
										Login.loginIndex = 6;
										return;
									}

									var18 = Login.loginBoxX + 180 + 80;
									if (var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
										FaceNormal.method3266(true);
									}
								} else if (Login.loginIndex == 12) {
									String var14 = "";
									switch(Login.field1182) {
									case 0:
										var14 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
										break;
									case 1:
										var14 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
										break;
									default:
										FaceNormal.method3266(false);
									}

									var7 = Login.loginBoxX + 180;
									var8 = 276;
									if (var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var16 >= var8 - 20 && var16 <= var8 + 20) {
										GrandExchangeOfferWorldComparator.openURL(var14, true, false);
										class268.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
										Login.loginIndex = 6;
										return;
									}

									var7 = Login.loginBoxX + 180;
									var8 = 326;
									if (var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var16 >= var8 - 20 && var16 <= var8 + 20) {
										FaceNormal.method3266(false);
									}
								} else if (Login.loginIndex == 24) {
									var18 = Login.loginBoxX + 180;
									var20 = 301;
									if (var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
										FaceNormal.method3266(false);
									}
								}
							}
						} else {
							while (class218.method4109()) {
								if (ReflectionCheck.field1338 == 84) {
									FaceNormal.method3266(false);
								} else if (ReflectionCheck.field1338 == 13) {
									Login.loginIndex = 0;
								}
							}

							var18 = ScriptEvent.loginBoxCenter - 80;
							var20 = 321;
							if (var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
								FaceNormal.method3266(false);
							}

							var18 = ScriptEvent.loginBoxCenter + 80;
							if (var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
								Login.loginIndex = 0;
							}
						}
					}

				}
			}
		}
	}
}
