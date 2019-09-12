import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
@Implements("FontName")
public class FontName {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	@Export("FontName_plain11")
	public static final FontName FontName_plain11;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	@Export("FontName_plain12")
	public static final FontName FontName_plain12;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	@Export("FontName_bold12")
	public static final FontName FontName_bold12;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	@Export("FontName_verdana11")
	public static final FontName FontName_verdana11;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	@Export("FontName_verdana13")
	public static final FontName FontName_verdana13;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lkn;"
	)
	@Export("FontName_verdana15")
	public static final FontName FontName_verdana15;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ldm;"
	)
	@Export("soundSystem")
	static SoundSystem soundSystem;
	@ObfuscatedName("dv")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive10")
	static Archive archive10;
	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	@Export("redHintArrowSprite")
	static Sprite redHintArrowSprite;
	@ObfuscatedName("j")
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

	@ObfuscatedName("c")
	public static final int method5287(double var0, double var2, double var4) {
		double var6 = var4;
		double var8 = var4;
		double var10 = var4;
		if (0.0D != var2) {
			double var12;
			if (var4 < 0.5D) {
				var12 = (var2 + 1.0D) * var4;
			} else {
				var12 = var2 + var4 - var2 * var4;
			}

			double var14 = var4 * 2.0D - var12;
			double var16 = 0.3333333333333333D + var0;
			if (var16 > 1.0D) {
				--var16;
			}

			double var20 = var0 - 0.3333333333333333D;
			if (var20 < 0.0D) {
				++var20;
			}

			if (var16 * 6.0D < 1.0D) {
				var6 = var14 + var16 * (var12 - var14) * 6.0D;
			} else if (var16 * 2.0D < 1.0D) {
				var6 = var12;
			} else if (3.0D * var16 < 2.0D) {
				var6 = 6.0D * (0.6666666666666666D - var16) * (var12 - var14) + var14;
			} else {
				var6 = var14;
			}

			if (6.0D * var0 < 1.0D) {
				var8 = var0 * 6.0D * (var12 - var14) + var14;
			} else if (2.0D * var0 < 1.0D) {
				var8 = var12;
			} else if (3.0D * var0 < 2.0D) {
				var8 = (var12 - var14) * (0.6666666666666666D - var0) * 6.0D + var14;
			} else {
				var8 = var14;
			}

			if (6.0D * var20 < 1.0D) {
				var10 = var14 + var20 * (var12 - var14) * 6.0D;
			} else if (var20 * 2.0D < 1.0D) {
				var10 = var12;
			} else if (3.0D * var20 < 2.0D) {
				var10 = var14 + (0.6666666666666666D - var20) * (var12 - var14) * 6.0D;
			} else {
				var10 = var14;
			}
		}

		int var22 = (int)(256.0D * var6);
		int var13 = (int)(256.0D * var8);
		int var23 = (int)(var10 * 256.0D);
		int var15 = var23 + (var13 << 8) + (var22 << 16);
		return var15;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)[Lkn;",
		garbageValue = "-1831558082"
	)
	public static FontName[] method5288() {
		return new FontName[]{FontName_verdana13, FontName_plain11, FontName_verdana11, FontName_verdana15, FontName_plain12, FontName_bold12};
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)Lia;",
		garbageValue = "1426575141"
	)
	@Export("getNpcDefinition")
	public static NPCDefinition getNpcDefinition(int var0) {
		NPCDefinition var1 = (NPCDefinition)NPCDefinition.NpcDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = NPCDefinition.NpcDefinition_archive.takeFile(9, var0);
			var1 = new NPCDefinition();
			var1.id = var0;
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			NPCDefinition.NpcDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;II)Z",
		garbageValue = "-1001272425"
	)
	static boolean method5292(String var0, int var1) {
		return ReflectionCheck.method2261(var0, var1, "openjs");
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lbn;I)V",
		garbageValue = "76683988"
	)
	static void method5284(GameShell var0) {
		int var4;
		if (Login.worldSelectOpen) {
			while (true) {
				if (!AbstractUserComparator.isKeyDown()) {
					if (MouseHandler.MouseHandler_lastButton != 1 && (WorldMapSection1.mouseCam || MouseHandler.MouseHandler_lastButton != 4)) {
						break;
					}

					int var1 = Login.xPadding + 280;
					if (MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var1 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class30.changeWorldSelectSorting(0, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var1 + 15 && MouseHandler.MouseHandler_lastPressedX <= var1 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class30.changeWorldSelectSorting(0, 1);
						break;
					}

					int var2 = Login.xPadding + 390;
					if (MouseHandler.MouseHandler_lastPressedX >= var2 && MouseHandler.MouseHandler_lastPressedX <= var2 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class30.changeWorldSelectSorting(1, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var2 + 15 && MouseHandler.MouseHandler_lastPressedX <= var2 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class30.changeWorldSelectSorting(1, 1);
						break;
					}

					int var17 = Login.xPadding + 500;
					if (MouseHandler.MouseHandler_lastPressedX >= var17 && MouseHandler.MouseHandler_lastPressedX <= var17 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class30.changeWorldSelectSorting(2, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var17 + 15 && MouseHandler.MouseHandler_lastPressedX <= var17 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class30.changeWorldSelectSorting(2, 1);
						break;
					}

					var4 = Login.xPadding + 610;
					if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class30.changeWorldSelectSorting(3, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						class30.changeWorldSelectSorting(3, 1);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
						GrandExchangeOfferOwnWorldComparator.method1232();
						break;
					}

					if (Login.hoveredWorldIndex != -1) {
						World var5 = World.World_worlds[Login.hoveredWorldIndex];
						ReflectionCheck.changeWorld(var5);
						GrandExchangeOfferOwnWorldComparator.method1232();
					} else {
						if (Login.worldSelectPage > 0 && class2.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= class2.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= GameShell.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= GameShell.canvasHeight / 2 + 50) {
							--Login.worldSelectPage;
						}

						if (Login.worldSelectPage < Login.worldSelectPagesCount && WorldMapRectangle.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= GraphicsDefaults.canvasWidth - WorldMapRectangle.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= GraphicsDefaults.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= GameShell.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= GameShell.canvasHeight / 2 + 50) {
							++Login.worldSelectPage;
						}
					}
					break;
				}

				if (class43.field361 == 13) {
					GrandExchangeOfferOwnWorldComparator.method1232();
					break;
				}

				if (class43.field361 == 96) {
					if (Login.worldSelectPage > 0 && class2.worldSelectLeftSprite != null) {
						--Login.worldSelectPage;
					}
				} else if (class43.field361 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && WorldMapRectangle.worldSelectRightSprite != null) {
					++Login.worldSelectPage;
				}
			}

		} else {
			if ((MouseHandler.MouseHandler_lastButton == 1 || !WorldMapSection1.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
				Actor.clientPreferences.titleMusicDisabled = !Actor.clientPreferences.titleMusicDisabled;
				class296.savePreferences();
				if (!Actor.clientPreferences.titleMusicDisabled) {
					UserComparator7.method3376(WorldMapDecoration.archive6, "scape main", "", 255, false);
				} else {
					class197.midiPcmStream.clear();
					class197.field2376 = 1;
					class197.musicTrackArchive = null;
				}
			}

			if (Client.gameState != 5) {
				if (-1L == Login.field1162) {
					Login.field1162 = SoundCache.method2480() + 1000L;
				}

				long var12 = SoundCache.method2480();
				boolean var3;
				if (Client.archiveLoaders != null && Client.archiveLoaderArchive < Client.archiveLoaders.size()) {
					while (true) {
						if (Client.archiveLoaderArchive >= Client.archiveLoaders.size()) {
							var3 = true;
							break;
						}

						ArchiveLoader var16 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoaderArchive);
						if (!var16.isLoaded()) {
							var3 = false;
							break;
						}

						++Client.archiveLoaderArchive;
					}
				} else {
					var3 = true;
				}

				if (var3 && Login.field1164 == -1L) {
					Login.field1164 = var12;
					if (Login.field1164 > Login.field1162) {
						Login.field1162 = Login.field1164;
					}
				}

				if (Client.gameState == 10 || Client.gameState == 11) {
					if (class43.clientLanguage == Language.Language_EN) {
						if (MouseHandler.MouseHandler_lastButton == 1 || !WorldMapSection1.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
							var4 = Login.xPadding + 5;
							short var14 = 463;
							byte var6 = 100;
							byte var7 = 35;
							if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + var6 && MouseHandler.MouseHandler_lastPressedY >= var14 && MouseHandler.MouseHandler_lastPressedY <= var7 + var14) {
								if (ClientPacket.loadWorlds()) {
									Login.worldSelectOpen = true;
									Login.worldSelectPage = 0;
									Login.worldSelectPagesCount = 0;
								}

								return;
							}
						}

						if (RouteStrategy.World_request != null && ClientPacket.loadWorlds()) {
							Login.worldSelectOpen = true;
							Login.worldSelectPage = 0;
							Login.worldSelectPagesCount = 0;
						}
					}

					var4 = MouseHandler.MouseHandler_lastButton;
					int var25 = MouseHandler.MouseHandler_lastPressedX;
					int var18 = MouseHandler.MouseHandler_lastPressedY;
					if (var4 == 0) {
						var25 = MouseHandler.MouseHandler_x;
						var18 = MouseHandler.MouseHandler_y;
					}

					if (!WorldMapSection1.mouseCam && var4 == 4) {
						var4 = 1;
					}

					int var8;
					short var9;
					if (Login.loginIndex == 0) {
						boolean var19 = false;

						while (AbstractUserComparator.isKeyDown()) {
							if (class43.field361 == 84) {
								var19 = true;
							}
						}

						var8 = VarcInt.loginBoxCenter - 80;
						var9 = 291;
						if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
							WorldMapIcon_0.openURL(GrandExchangeEvents.method67("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
						}

						var8 = VarcInt.loginBoxCenter + 80;
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
								WorldMapID.method520(false);
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
								if (var4 == 1 && var18 >= var20 - 12 && var18 < var20 + 2) {
									Login.currentLoginField = 0;
								}

								var20 += 15;
								if (var4 == 1 && var18 >= var20 - 12 && var18 < var20 + 2) {
									Login.currentLoginField = 1;
								}

								var20 += 15;
								var21 = 361;
								if (MusicPatchNode2.field2369 != null) {
									var8 = MusicPatchNode2.field2369.highX / 2;
									if (var4 == 1 && var25 >= MusicPatchNode2.field2369.lowX - var8 && var25 <= var8 + MusicPatchNode2.field2369.lowX && var18 >= var21 - 15 && var18 < var21) {
										switch(Login.field1161) {
										case 1:
											Canvas.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
											Login.loginIndex = 5;
											return;
										case 2:
											WorldMapIcon_0.openURL("https://support.runescape.com/hc/en-gb", true, false);
										}
									}
								}

								var8 = VarcInt.loginBoxCenter - 80;
								var9 = 321;
								if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
									Login.Login_username = Login.Login_username.trim();
									if (Login.Login_username.length() == 0) {
										Canvas.setLoginResponseString("", "Please enter your username/email address.", "");
										return;
									}

									if (Login.Login_password.length() == 0) {
										Canvas.setLoginResponseString("", "Please enter your password.", "");
										return;
									}

									Canvas.setLoginResponseString("", "Connecting to server...", "");
									PacketWriter.method2238(false);
									WorldMapIcon_0.updateGameState(20);
									return;
								}

								var8 = Login.loginBoxX + 180 + 80;
								if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
									Login.loginIndex = 0;
									Login.Login_username = "";
									Login.Login_password = "";
									class222.field2729 = 0;
									class81.otp = "";
									Login.field1183 = true;
								}

								var8 = VarcInt.loginBoxCenter + -117;
								var9 = 277;
								Login.field1169 = var25 >= var8 && var25 < var8 + class4.field17 && var18 >= var9 && var18 < var9 + class267.field3524;
								if (var4 == 1 && Login.field1169) {
									Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
									if (!Client.Login_isUsernameRemembered && Actor.clientPreferences.rememberedUsername != null) {
										Actor.clientPreferences.rememberedUsername = null;
										class296.savePreferences();
									}
								}

								var8 = VarcInt.loginBoxCenter + 24;
								var9 = 277;
								Login.field1170 = var25 >= var8 && var25 < var8 + class4.field17 && var18 >= var9 && var18 < var9 + class267.field3524;
								if (var4 == 1 && Login.field1170) {
									Actor.clientPreferences.hideUsername = !Actor.clientPreferences.hideUsername;
									if (!Actor.clientPreferences.hideUsername) {
										Login.Login_username = "";
										Actor.clientPreferences.rememberedUsername = null;
										if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
											Login.currentLoginField = 1;
										} else {
											Login.currentLoginField = 0;
										}
									}

									class296.savePreferences();
								}

								while (true) {
									while (AbstractUserComparator.isKeyDown()) {
										var10 = false;

										for (var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var11) {
											if (WorldMapIcon_0.field126 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var11)) {
												var10 = true;
												break;
											}
										}

										if (class43.field361 == 13) {
											Login.loginIndex = 0;
											Login.Login_username = "";
											Login.Login_password = "";
											class222.field2729 = 0;
											class81.otp = "";
											Login.field1183 = true;
										} else if (Login.currentLoginField == 0) {
											if (class43.field361 == 85 && Login.Login_username.length() > 0) {
												Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
											}

											if (class43.field361 == 84 || class43.field361 == 80) {
												Login.currentLoginField = 1;
											}

											if (var10 && Login.Login_username.length() < 320) {
												Login.Login_username = Login.Login_username + WorldMapIcon_0.field126;
											}
										} else if (Login.currentLoginField == 1) {
											if (class43.field361 == 85 && Login.Login_password.length() > 0) {
												Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
											}

											if (class43.field361 == 84 || class43.field361 == 80) {
												Login.currentLoginField = 0;
											}

											if (class43.field361 == 84) {
												Login.Login_username = Login.Login_username.trim();
												if (Login.Login_username.length() == 0) {
													Canvas.setLoginResponseString("", "Please enter your username/email address.", "");
													return;
												}

												if (Login.Login_password.length() == 0) {
													Canvas.setLoginResponseString("", "Please enter your password.", "");
													return;
												}

												Canvas.setLoginResponseString("", "Connecting to server...", "");
												PacketWriter.method2238(false);
												WorldMapIcon_0.updateGameState(20);
												return;
											}

											if (var10 && Login.Login_password.length() < 20) {
												Login.Login_password = Login.Login_password + WorldMapIcon_0.field126;
											}
										}
									}

									return;
								}
							} else if (Login.loginIndex == 3) {
								var20 = Login.loginBoxX + 180;
								var22 = 276;
								if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
									WorldMapID.method520(false);
								}

								var20 = Login.loginBoxX + 180;
								var22 = 326;
								if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
									Canvas.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
									Login.loginIndex = 5;
									return;
								}
							} else {
								int var24;
								if (Login.loginIndex == 4) {
									var20 = Login.loginBoxX + 180 - 80;
									var22 = 321;
									if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										class81.otp.trim();
										if (class81.otp.length() != 6) {
											Canvas.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
											return;
										}

										class222.field2729 = Integer.parseInt(class81.otp);
										class81.otp = "";
										PacketWriter.method2238(true);
										Canvas.setLoginResponseString("", "Connecting to server...", "");
										WorldMapIcon_0.updateGameState(20);
										return;
									}

									if (var4 == 1 && var25 >= Login.loginBoxX + 180 - 9 && var25 <= Login.loginBoxX + 180 + 130 && var18 >= 263 && var18 <= 296) {
										Login.field1183 = !Login.field1183;
									}

									if (var4 == 1 && var25 >= Login.loginBoxX + 180 - 34 && var25 <= Login.loginBoxX + 34 + 180 && var18 >= 351 && var18 <= 363) {
										WorldMapIcon_0.openURL(GrandExchangeEvents.method67("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
									}

									var20 = Login.loginBoxX + 180 + 80;
									if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										Login.loginIndex = 0;
										Login.Login_username = "";
										Login.Login_password = "";
										class222.field2729 = 0;
										class81.otp = "";
									}

									while (AbstractUserComparator.isKeyDown()) {
										boolean var23 = false;

										for (var24 = 0; var24 < "1234567890".length(); ++var24) {
											if (WorldMapIcon_0.field126 == "1234567890".charAt(var24)) {
												var23 = true;
												break;
											}
										}

										if (class43.field361 == 13) {
											Login.loginIndex = 0;
											Login.Login_username = "";
											Login.Login_password = "";
											class222.field2729 = 0;
											class81.otp = "";
										} else {
											if (class43.field361 == 85 && class81.otp.length() > 0) {
												class81.otp = class81.otp.substring(0, class81.otp.length() - 1);
											}

											if (class43.field361 == 84) {
												class81.otp.trim();
												if (class81.otp.length() != 6) {
													Canvas.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
													return;
												}

												class222.field2729 = Integer.parseInt(class81.otp);
												class81.otp = "";
												PacketWriter.method2238(true);
												Canvas.setLoginResponseString("", "Connecting to server...", "");
												WorldMapIcon_0.updateGameState(20);
												return;
											}

											if (var23 && class81.otp.length() < 6) {
												class81.otp = class81.otp + WorldMapIcon_0.field126;
											}
										}
									}
								} else if (Login.loginIndex == 5) {
									var20 = Login.loginBoxX + 180 - 80;
									var22 = 321;
									if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										WorldMapDecorationType.method4099();
										return;
									}

									var20 = Login.loginBoxX + 180 + 80;
									if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										WorldMapID.method520(true);
									}

									var9 = 361;
									if (class51.field411 != null) {
										var24 = class51.field411.highX / 2;
										if (var4 == 1 && var25 >= class51.field411.lowX - var24 && var25 <= var24 + class51.field411.lowX && var18 >= var9 - 15 && var18 < var9) {
											WorldMapIcon_0.openURL(GrandExchangeEvents.method67("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
										}
									}

									while (AbstractUserComparator.isKeyDown()) {
										var10 = false;

										for (var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var11) {
											if (WorldMapIcon_0.field126 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var11)) {
												var10 = true;
												break;
											}
										}

										if (class43.field361 == 13) {
											WorldMapID.method520(true);
										} else {
											if (class43.field361 == 85 && Login.Login_username.length() > 0) {
												Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
											}

											if (class43.field361 == 84) {
												WorldMapDecorationType.method4099();
												return;
											}

											if (var10 && Login.Login_username.length() < 320) {
												Login.Login_username = Login.Login_username + WorldMapIcon_0.field126;
											}
										}
									}
								} else if (Login.loginIndex == 6) {
									while (true) {
										do {
											if (!AbstractUserComparator.isKeyDown()) {
												var21 = 321;
												if (var4 == 1 && var18 >= var21 - 20 && var18 <= var21 + 20) {
													WorldMapID.method520(true);
												}

												return;
											}
										} while(class43.field361 != 84 && class43.field361 != 13);

										WorldMapID.method520(true);
									}
								} else if (Login.loginIndex == 7) {
									var20 = Login.loginBoxX + 180 - 80;
									var22 = 321;
									if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										WorldMapIcon_0.openURL(GrandExchangeEvents.method67("secure", true) + "m=dob/set_dob.ws", true, false);
										Canvas.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
										Login.loginIndex = 6;
										return;
									}

									var20 = Login.loginBoxX + 180 + 80;
									if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										WorldMapID.method520(true);
									}
								} else if (Login.loginIndex == 8) {
									var20 = Login.loginBoxX + 180 - 80;
									var22 = 321;
									if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										WorldMapIcon_0.openURL("https://www.jagex.com/terms/privacy/#eight", true, false);
										Canvas.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
										Login.loginIndex = 6;
										return;
									}

									var20 = Login.loginBoxX + 180 + 80;
									if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										WorldMapID.method520(true);
									}
								} else if (Login.loginIndex == 12) {
									String var15 = "";
									switch(Login.field1156) {
									case 0:
										var15 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
										break;
									case 1:
										var15 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
										break;
									default:
										WorldMapID.method520(false);
									}

									var8 = Login.loginBoxX + 180;
									var9 = 276;
									if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
										WorldMapIcon_0.openURL(var15, true, false);
										Canvas.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
										Login.loginIndex = 6;
										return;
									}

									var8 = Login.loginBoxX + 180;
									var9 = 326;
									if (var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
										WorldMapID.method520(false);
									}
								} else if (Login.loginIndex == 24) {
									var20 = Login.loginBoxX + 180;
									var22 = 301;
									if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
										WorldMapID.method520(false);
									}
								}
							}
						} else {
							while (AbstractUserComparator.isKeyDown()) {
								if (class43.field361 == 84) {
									WorldMapID.method520(false);
								} else if (class43.field361 == 13) {
									Login.loginIndex = 0;
								}
							}

							var20 = VarcInt.loginBoxCenter - 80;
							var22 = 321;
							if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
								WorldMapID.method520(false);
							}

							var20 = VarcInt.loginBoxCenter + 80;
							if (var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
								Login.loginIndex = 0;
							}
						}
					}

				}
			}
		}
	}

	@ObfuscatedName("hw")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
		garbageValue = "-1882548128"
	)
	@Export("insertMenuItemNoShift")
	public static final void insertMenuItemNoShift(String var0, String var1, int var2, int var3, int var4, int var5) {
		Decimator.insertMenuItem(var0, var1, var2, var3, var4, var5, false);
	}

	@ObfuscatedName("ku")
	@ObfuscatedSignature(
		signature = "(Lhy;I)Lhy;",
		garbageValue = "1031312756"
	)
	static Widget method5290(Widget var0) {
		int var1 = ScriptFrame.method1086(class60.getWidgetClickMask(var0));
		if (var1 == 0) {
			return null;
		} else {
			for (int var2 = 0; var2 < var1; ++var2) {
				var0 = Player.getWidget(var0.parentId);
				if (var0 == null) {
					return null;
				}
			}

			return var0;
		}
	}
}
