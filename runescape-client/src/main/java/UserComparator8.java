import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("UserComparator8")
public class UserComparator8 extends AbstractUserComparator {
	@ObfuscatedName("f")
	@Export("reversed")
	final boolean reversed;

	public UserComparator8(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljt;Ljt;I)I",
		garbageValue = "1853867406"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world) {
			if (var2.world != Client.worldId) {
				return this.reversed ? -1 : 1;
			}
		} else if (var2.world == Client.worldId) {
			return this.reversed ? 1 : -1;
		}

		return this.compareUser(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)[Liz;",
		garbageValue = "1856442222"
	)
	static HorizontalAlignment[] method3329() {
		return new HorizontalAlignment[]{HorizontalAlignment.field3425, HorizontalAlignment.field3424, HorizontalAlignment.HorizontalAlignment_centered};
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)Lim;",
		garbageValue = "1724528275"
	)
	@Export("VarpDefinition_get")
	public static VarpDefinition VarpDefinition_get(int var0) {
		VarpDefinition var1 = (VarpDefinition)VarpDefinition.VarpDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarpDefinition.VarpDefinition_archive.takeFile(16, var0);
			var1 = new VarpDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarpDefinition.VarpDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lbj;I)V",
		garbageValue = "1646849936"
	)
	@Export("doCycleTitle")
	static void doCycleTitle(GameShell var0) {
		if (Login.worldSelectOpen) {
			class191.method3638(var0);
		} else {
			if ((MouseHandler.MouseHandler_lastButton == 1 || !NetFileRequest.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
				Interpreter.clientPreferences.titleMusicDisabled = !Interpreter.clientPreferences.titleMusicDisabled;
				FriendSystem.savePreferences();
				if (!Interpreter.clientPreferences.titleMusicDisabled) {
					Archive var1 = GrandExchangeOfferWorldComparator.archive6;
					int var2 = var1.getGroupId("scape main");
					int var3 = var1.getFileId(var2, "");
					class173.playMusicTrack(var1, var2, var3, 255, false);
				} else {
					Actor.method1755();
				}
			}

			if (Client.gameState != 5) {
				if (Login.field1158 == -1L) {
					Login.field1158 = WorldMapID.currentTimeMillis() + 1000L;
				}

				long var33 = WorldMapID.currentTimeMillis();
				boolean var58;
				if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
					while (true) {
						if (Client.archiveLoadersDone >= Client.archiveLoaders.size()) {
							var58 = true;
							break;
						}

						ArchiveLoader var4 = (ArchiveLoader)Client.archiveLoaders.get(Client.archiveLoadersDone);
						if (!var4.isLoaded()) {
							var58 = false;
							break;
						}

						++Client.archiveLoadersDone;
					}
				} else {
					var58 = true;
				}

				if (var58 && Login.field1187 == -1L) {
					Login.field1187 = var33;
					if (Login.field1187 > Login.field1158) {
						Login.field1158 = Login.field1187;
					}
				}

				if (Client.gameState == 10 || Client.gameState == 11) {
					int var35;
					if (Language.Language_EN == Varps.clientLanguage) {
						if (MouseHandler.MouseHandler_lastButton == 1 || !NetFileRequest.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
							var35 = Login.xPadding + 5;
							short var5 = 463;
							byte var6 = 100;
							byte var7 = 35;
							if (MouseHandler.MouseHandler_lastPressedX >= var35 && MouseHandler.MouseHandler_lastPressedX <= var6 + var35 && MouseHandler.MouseHandler_lastPressedY >= var5 && MouseHandler.MouseHandler_lastPressedY <= var7 + var5) {
								class222.method4090();
								return;
							}
						}

						if (Login.World_request != null) {
							class222.method4090();
						}
					}

					var35 = MouseHandler.MouseHandler_lastButton;
					int var59 = MouseHandler.MouseHandler_lastPressedX;
					int var60 = MouseHandler.MouseHandler_lastPressedY;
					if (var35 == 0) {
						var59 = MouseHandler.MouseHandler_x;
						var60 = MouseHandler.MouseHandler_y;
					}

					if (!NetFileRequest.mouseCam && var35 == 4) {
						var35 = 1;
					}

					short var63;
					int var64;
					if (Login.loginIndex == 0) {
						boolean var66 = false;

						while (KeyHandler.isKeyDown()) {
							if (VertexNormal.field1732 == 84) {
								var66 = true;
							}
						}

						var64 = Script.loginBoxCenter - 80;
						var63 = 291;
						if (var35 == 1 && var59 >= var64 - 75 && var59 <= var64 + 75 && var60 >= var63 - 20 && var60 <= var63 + 20) {
							class13.openURL(NetFileRequest.method4121("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
						}

						var64 = Script.loginBoxCenter + 80;
						if (var35 == 1 && var59 >= var64 - 75 && var59 <= var64 + 75 && var60 >= var63 - 20 && var60 <= var63 + 20 || var66) {
							if ((Client.worldProperties & 33554432) != 0) {
								Login.Login_response0 = "";
								Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
								Login.Login_response2 = "Your normal account will not be affected.";
								Login.Login_response3 = "";
								Login.loginIndex = 1;
								WorldMapCacheName.method618();
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
								WorldMapCacheName.method618();
							} else if ((Client.worldProperties & 1024) != 0) {
								Login.Login_response1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
								Login.Login_response2 = "The Protect Item prayer will";
								Login.Login_response3 = "not work on this world.";
								Login.Login_response0 = "Warning!";
								Login.loginIndex = 1;
								WorldMapCacheName.method618();
							} else {
								ItemDefinition.Login_promptCredentials(false);
							}
						}
					} else {
						short var8;
						int var61;
						if (Login.loginIndex == 1) {
							while (true) {
								if (!KeyHandler.isKeyDown()) {
									var61 = Script.loginBoxCenter - 80;
									var8 = 321;
									if (var35 == 1 && var59 >= var61 - 75 && var59 <= var61 + 75 && var60 >= var8 - 20 && var60 <= var8 + 20) {
										ItemDefinition.Login_promptCredentials(false);
									}

									var61 = Script.loginBoxCenter + 80;
									if (var35 == 1 && var59 >= var61 - 75 && var59 <= var61 + 75 && var60 >= var8 - 20 && var60 <= var8 + 20) {
										Login.loginIndex = 0;
									}
									break;
								}

								if (VertexNormal.field1732 == 84) {
									ItemDefinition.Login_promptCredentials(false);
								} else if (VertexNormal.field1732 == 13) {
									Login.loginIndex = 0;
								}
							}
						} else {
							String var13;
							short var62;
							boolean var82;
							if (Login.loginIndex == 2) {
								var62 = 201;
								var61 = var62 + 52;
								if (var35 == 1 && var60 >= var61 - 12 && var60 < var61 + 2) {
									Login.currentLoginField = 0;
								}

								var61 += 15;
								if (var35 == 1 && var60 >= var61 - 12 && var60 < var61 + 2) {
									Login.currentLoginField = 1;
								}

								var61 += 15;
								var62 = 361;
								if (class267.field3521 != null) {
									var64 = class267.field3521.highX / 2;
									if (var35 == 1 && var59 >= class267.field3521.lowX - var64 && var59 <= var64 + class267.field3521.lowX && var60 >= var62 - 15 && var60 < var62) {
										switch(Login.field1181) {
										case 1:
											AbstractWorldMapData.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
											Login.loginIndex = 5;
											return;
										case 2:
											class13.openURL("https://support.runescape.com/hc/en-gb", true, false);
										}
									}
								}

								var64 = Script.loginBoxCenter - 80;
								var63 = 321;
								if (var35 == 1 && var59 >= var64 - 75 && var59 <= var64 + 75 && var60 >= var63 - 20 && var60 <= var63 + 20) {
									Login.Login_username = Login.Login_username.trim();
									if (Login.Login_username.length() == 0) {
										AbstractWorldMapData.setLoginResponseString("", "Please enter your username/email address.", "");
										return;
									}

									if (Login.Login_password.length() == 0) {
										AbstractWorldMapData.setLoginResponseString("", "Please enter your password.", "");
										return;
									}

									AbstractWorldMapData.setLoginResponseString("", "Connecting to server...", "");
									AbstractWorldMapIcon.method612(false);
									class195.updateGameState(20);
									return;
								}

								var64 = Login.loginBoxX + 180 + 80;
								if (var35 == 1 && var59 >= var64 - 75 && var59 <= var64 + 75 && var60 >= var63 - 20 && var60 <= var63 + 20) {
									Login.loginIndex = 0;
									Login.Login_username = "";
									Login.Login_password = "";
									class266.field3517 = 0;
									class80.otp = "";
									Login.field1178 = true;
								}

								var64 = Script.loginBoxCenter + -117;
								var63 = 277;
								Login.field1186 = var59 >= var64 && var59 < var64 + IgnoreList.field3579 && var60 >= var63 && var60 < var63 + MenuAction.field1133;
								if (var35 == 1 && Login.field1186) {
									Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
									if (!Client.Login_isUsernameRemembered && Interpreter.clientPreferences.rememberedUsername != null) {
										Interpreter.clientPreferences.rememberedUsername = null;
										FriendSystem.savePreferences();
									}
								}

								var64 = Script.loginBoxCenter + 24;
								var63 = 277;
								Login.field1182 = var59 >= var64 && var59 < var64 + IgnoreList.field3579 && var60 >= var63 && var60 < var63 + MenuAction.field1133;
								if (var35 == 1 && Login.field1182) {
									Interpreter.clientPreferences.hideUsername = !Interpreter.clientPreferences.hideUsername;
									if (!Interpreter.clientPreferences.hideUsername) {
										Login.Login_username = "";
										Interpreter.clientPreferences.rememberedUsername = null;
										WorldMapCacheName.method618();
									}

									FriendSystem.savePreferences();
								}

								while (true) {
									Transferable var11;
									int var67;
									do {
										while (true) {
											label1185:
											do {
												while (true) {
													while (KeyHandler.isKeyDown()) {
														if (VertexNormal.field1732 != 13) {
															if (Login.currentLoginField != 0) {
																continue label1185;
															}

															GrandExchangeEvents.method76(TileItemPile.field1521);
															if (VertexNormal.field1732 == 85 && Login.Login_username.length() > 0) {
																Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
															}

															if (VertexNormal.field1732 == 84 || VertexNormal.field1732 == 80) {
																Login.currentLoginField = 1;
															}

															if (class227.method4102(TileItemPile.field1521) && Login.Login_username.length() < 320) {
																Login.Login_username = Login.Login_username + TileItemPile.field1521;
															}
														} else {
															Login.loginIndex = 0;
															Login.Login_username = "";
															Login.Login_password = "";
															class266.field3517 = 0;
															class80.otp = "";
															Login.field1178 = true;
														}
													}

													return;
												}
											} while(Login.currentLoginField != 1);

											if (VertexNormal.field1732 == 85 && Login.Login_password.length() > 0) {
												Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
											} else if (VertexNormal.field1732 == 84 || VertexNormal.field1732 == 80) {
												Login.currentLoginField = 0;
												if (VertexNormal.field1732 == 84) {
													Login.Login_username = Login.Login_username.trim();
													if (Login.Login_username.length() == 0) {
														AbstractWorldMapData.setLoginResponseString("", "Please enter your username/email address.", "");
														return;
													}

													if (Login.Login_password.length() == 0) {
														AbstractWorldMapData.setLoginResponseString("", "Please enter your password.", "");
														return;
													}

													AbstractWorldMapData.setLoginResponseString("", "Connecting to server...", "");
													AbstractWorldMapIcon.method612(false);
													class195.updateGameState(20);
													return;
												}
											}

											if ((KeyHandler.KeyHandler_pressedKeys[82] || KeyHandler.KeyHandler_pressedKeys[87]) && VertexNormal.field1732 == 67) {
												Clipboard var10 = Toolkit.getDefaultToolkit().getSystemClipboard();
												var11 = var10.getContents(class206.client);
												var67 = 20 - Login.Login_password.length();
												break;
											}

											char var81 = TileItemPile.field1521;
											if (var81 >= ' ' && var81 < 127 || var81 > 127 && var81 < 160 || var81 > 160 && var81 <= 255) {
												var82 = true;
											} else {
												label1386: {
													if (var81 != 0) {
														char[] var38 = class287.cp1252AsciiExtension;

														for (int var39 = 0; var39 < var38.length; ++var39) {
															char var69 = var38[var39];
															if (var69 == var81) {
																var82 = true;
																break label1386;
															}
														}
													}

													var82 = false;
												}
											}

											if (var82 && class227.method4102(TileItemPile.field1521) && Login.Login_password.length() < 20) {
												Login.Login_password = Login.Login_password + TileItemPile.field1521;
											}
										}
									} while(var67 <= 0);

									try {
										var13 = (String)var11.getTransferData(DataFlavor.stringFlavor);
										int var71 = Math.min(var67, var13.length());

										for (int var15 = 0; var15 < var71; ++var15) {
											if (!class179.method3581(var13.charAt(var15)) || !class227.method4102(var13.charAt(var15))) {
												Login.loginIndex = 3;
												return;
											}
										}

										Login.Login_password = Login.Login_password + var13.substring(0, var71);
									} catch (UnsupportedFlavorException var56) {
									} catch (IOException var57) {
									}
								}
							} else if (Login.loginIndex == 3) {
								var61 = Login.loginBoxX + 180;
								var8 = 276;
								if (var35 == 1 && var59 >= var61 - 75 && var59 <= var61 + 75 && var60 >= var8 - 20 && var60 <= var8 + 20) {
									ItemDefinition.Login_promptCredentials(false);
								}

								var61 = Login.loginBoxX + 180;
								var8 = 326;
								if (var35 == 1 && var59 >= var61 - 75 && var59 <= var61 + 75 && var60 >= var8 - 20 && var60 <= var8 + 20) {
									AbstractWorldMapData.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
									Login.loginIndex = 5;
									return;
								}
							} else {
								int var37;
								if (Login.loginIndex == 4) {
									var61 = Login.loginBoxX + 180 - 80;
									var8 = 321;
									if (var35 == 1 && var59 >= var61 - 75 && var59 <= var61 + 75 && var60 >= var8 - 20 && var60 <= var8 + 20) {
										class80.otp.trim();
										if (class80.otp.length() != 6) {
											AbstractWorldMapData.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
											return;
										}

										class266.field3517 = Integer.parseInt(class80.otp);
										class80.otp = "";
										AbstractWorldMapIcon.method612(true);
										AbstractWorldMapData.setLoginResponseString("", "Connecting to server...", "");
										class195.updateGameState(20);
										return;
									}

									if (var35 == 1 && var59 >= Login.loginBoxX + 180 - 9 && var59 <= Login.loginBoxX + 180 + 130 && var60 >= 263 && var60 <= 296) {
										Login.field1178 = !Login.field1178;
									}

									if (var35 == 1 && var59 >= Login.loginBoxX + 180 - 34 && var59 <= Login.loginBoxX + 34 + 180 && var60 >= 351 && var60 <= 363) {
										class13.openURL(NetFileRequest.method4121("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
									}

									var61 = Login.loginBoxX + 180 + 80;
									if (var35 == 1 && var59 >= var61 - 75 && var59 <= var61 + 75 && var60 >= var8 - 20 && var60 <= var8 + 20) {
										Login.loginIndex = 0;
										Login.Login_username = "";
										Login.Login_password = "";
										class266.field3517 = 0;
										class80.otp = "";
									}

									while (KeyHandler.isKeyDown()) {
										boolean var9 = false;

										for (var37 = 0; var37 < "1234567890".length(); ++var37) {
											if (TileItemPile.field1521 == "1234567890".charAt(var37)) {
												var9 = true;
												break;
											}
										}

										if (VertexNormal.field1732 == 13) {
											Login.loginIndex = 0;
											Login.Login_username = "";
											Login.Login_password = "";
											class266.field3517 = 0;
											class80.otp = "";
										} else {
											if (VertexNormal.field1732 == 85 && class80.otp.length() > 0) {
												class80.otp = class80.otp.substring(0, class80.otp.length() - 1);
											}

											if (VertexNormal.field1732 == 84) {
												class80.otp.trim();
												if (class80.otp.length() != 6) {
													AbstractWorldMapData.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
													return;
												}

												class266.field3517 = Integer.parseInt(class80.otp);
												class80.otp = "";
												AbstractWorldMapIcon.method612(true);
												AbstractWorldMapData.setLoginResponseString("", "Connecting to server...", "");
												class195.updateGameState(20);
												return;
											}

											if (var9 && class80.otp.length() < 6) {
												class80.otp = class80.otp + TileItemPile.field1521;
											}
										}
									}
								} else if (Login.loginIndex == 5) {
									var61 = Login.loginBoxX + 180 - 80;
									var8 = 321;
									String var23;
									if (var35 == 1 && var59 >= var61 - 75 && var59 <= var61 + 75 && var60 >= var8 - 20 && var60 <= var8 + 20) {
										Login.Login_username = Login.Login_username.trim();
										if (Login.Login_username.length() == 0) {
											AbstractWorldMapData.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
										} else {
											long var40 = ArchiveLoader.method1156();
											byte var65;
											if (var40 == 0L) {
												var65 = 5;
											} else {
												var13 = Login.Login_username;
												Random var42 = new Random();
												Buffer var83 = new Buffer(128);
												Buffer var68 = new Buffer(128);
												int[] var70 = new int[]{var42.nextInt(), var42.nextInt(), (int)(var40 >> 32), (int)var40};
												var83.writeByte(10);

												int var18;
												for (var18 = 0; var18 < 4; ++var18) {
													var83.writeInt(var42.nextInt());
												}

												var83.writeInt(var70[0]);
												var83.writeInt(var70[1]);
												var83.writeLong(var40);
												var83.writeLong(0L);

												for (var18 = 0; var18 < 4; ++var18) {
													var83.writeInt(var42.nextInt());
												}

												var83.encryptRsa(class80.field1109, class80.field1112);
												var68.writeByte(10);

												for (var18 = 0; var18 < 3; ++var18) {
													var68.writeInt(var42.nextInt());
												}

												var68.writeLong(var42.nextLong());
												var68.writeLongMedium(var42.nextLong());
												if (Client.randomDatData != null) {
													var68.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
												} else {
													byte[] var84 = MenuAction.method2068();
													var68.writeBytes(var84, 0, var84.length);
												}

												var68.writeLong(var42.nextLong());
												var68.encryptRsa(class80.field1109, class80.field1112);
												var18 = ViewportMouse.stringCp1252NullTerminatedByteSize(var13);
												if (var18 % 8 != 0) {
													var18 += 8 - var18 % 8;
												}

												Buffer var72 = new Buffer(var18);
												var72.writeStringCp1252NullTerminated(var13);
												var72.offset = var18;
												var72.xteaEncryptAll(var70);
												Buffer var73 = new Buffer(var72.offset + var68.offset + var83.offset + 5);
												var73.writeByte(2);
												var73.writeByte(var83.offset);
												var73.writeBytes(var83.array, 0, var83.offset);
												var73.writeByte(var68.offset);
												var73.writeBytes(var68.array, 0, var68.offset);
												var73.writeShort(var72.offset);
												var73.writeBytes(var72.array, 0, var72.offset);
												byte[] var75 = var73.array;
												String var74 = Language.method3636(var75, 0, var75.length);
												var23 = var74;

												byte var12;
												try {
													URL var76 = new URL(NetFileRequest.method4121("services", false) + "m=accountappeal/login.ws");
													URLConnection var77 = var76.openConnection();
													var77.setDoInput(true);
													var77.setDoOutput(true);
													var77.setConnectTimeout(5000);
													OutputStreamWriter var78 = new OutputStreamWriter(var77.getOutputStream());
													var78.write("data2=" + UserComparator5.method3352(var23) + "&dest=" + UserComparator5.method3352("passwordchoice.ws"));
													var78.flush();
													InputStream var79 = var77.getInputStream();
													var73 = new Buffer(new byte[1000]);

													while (true) {
														int var28 = var79.read(var73.array, var73.offset, 1000 - var73.offset);
														if (var28 == -1) {
															var78.close();
															var79.close();
															String var85 = new String(var73.array);
															if (var85.startsWith("OFFLINE")) {
																var12 = 4;
															} else if (var85.startsWith("WRONG")) {
																var12 = 7;
															} else if (var85.startsWith("RELOAD")) {
																var12 = 3;
															} else if (var85.startsWith("Not permitted for social network accounts.")) {
																var12 = 6;
															} else {
																var73.xteaDecryptAll(var70);

																while (var73.offset > 0 && var73.array[var73.offset - 1] == 0) {
																	--var73.offset;
																}

																var85 = new String(var73.array, 0, var73.offset);
																boolean var29;
																if (var85 == null) {
																	var29 = false;
																} else {
																	label1361: {
																		try {
																			new URL(var85);
																		} catch (MalformedURLException var52) {
																			var29 = false;
																			break label1361;
																		}

																		var29 = true;
																	}
																}

																if (var29) {
																	class13.openURL(var85, true, false);
																	var12 = 2;
																} else {
																	var12 = 5;
																}
															}
															break;
														}

														var73.offset += var28;
														if (var73.offset >= 1000) {
															var12 = 5;
															break;
														}
													}
												} catch (Throwable var53) {
													var53.printStackTrace();
													var12 = 5;
												}

												var65 = var12;
											}

											switch(var65) {
											case 2:
												AbstractWorldMapData.setLoginResponseString(Strings.field2834, Strings.field3014, Strings.field3015);
												Login.loginIndex = 6;
												break;
											case 3:
												AbstractWorldMapData.setLoginResponseString("", "Error connecting to server.", "");
												break;
											case 4:
												AbstractWorldMapData.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
												break;
											case 5:
												AbstractWorldMapData.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
												break;
											case 6:
												AbstractWorldMapData.setLoginResponseString("", "Error connecting to server.", "");
												break;
											case 7:
												AbstractWorldMapData.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
											}
										}

										return;
									}

									var61 = Login.loginBoxX + 180 + 80;
									if (var35 == 1 && var59 >= var61 - 75 && var59 <= var61 + 75 && var60 >= var8 - 20 && var60 <= var8 + 20) {
										ItemDefinition.Login_promptCredentials(true);
									}

									var63 = 361;
									if (class197.field2397 != null) {
										var37 = class197.field2397.highX / 2;
										if (var35 == 1 && var59 >= class197.field2397.lowX - var37 && var59 <= var37 + class197.field2397.lowX && var60 >= var63 - 15 && var60 < var63) {
											class13.openURL(NetFileRequest.method4121("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
										}
									}

									while (KeyHandler.isKeyDown()) {
										var82 = false;

										for (int var36 = 0; var36 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var36) {
											if (TileItemPile.field1521 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var36)) {
												var82 = true;
												break;
											}
										}

										if (VertexNormal.field1732 == 13) {
											ItemDefinition.Login_promptCredentials(true);
										} else {
											if (VertexNormal.field1732 == 85 && Login.Login_username.length() > 0) {
												Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
											}

											if (VertexNormal.field1732 == 84) {
												Login.Login_username = Login.Login_username.trim();
												if (Login.Login_username.length() == 0) {
													AbstractWorldMapData.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
												} else {
													long var46 = ArchiveLoader.method1156();
													byte var80;
													if (var46 == 0L) {
														var80 = 5;
													} else {
														String var43 = Login.Login_username;
														Random var16 = new Random();
														Buffer var17 = new Buffer(128);
														Buffer var44 = new Buffer(128);
														int[] var19 = new int[]{var16.nextInt(), var16.nextInt(), (int)(var46 >> 32), (int)var46};
														var17.writeByte(10);

														int var48;
														for (var48 = 0; var48 < 4; ++var48) {
															var17.writeInt(var16.nextInt());
														}

														var17.writeInt(var19[0]);
														var17.writeInt(var19[1]);
														var17.writeLong(var46);
														var17.writeLong(0L);

														for (var48 = 0; var48 < 4; ++var48) {
															var17.writeInt(var16.nextInt());
														}

														var17.encryptRsa(class80.field1109, class80.field1112);
														var44.writeByte(10);

														for (var48 = 0; var48 < 3; ++var48) {
															var44.writeInt(var16.nextInt());
														}

														var44.writeLong(var16.nextLong());
														var44.writeLongMedium(var16.nextLong());
														if (Client.randomDatData != null) {
															var44.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
														} else {
															byte[] var20 = MenuAction.method2068();
															var44.writeBytes(var20, 0, var20.length);
														}

														var44.writeLong(var16.nextLong());
														var44.encryptRsa(class80.field1109, class80.field1112);
														var48 = ViewportMouse.stringCp1252NullTerminatedByteSize(var43);
														if (var48 % 8 != 0) {
															var48 += 8 - var48 % 8;
														}

														Buffer var21 = new Buffer(var48);
														var21.writeStringCp1252NullTerminated(var43);
														var21.offset = var48;
														var21.xteaEncryptAll(var19);
														Buffer var22 = new Buffer(var21.offset + var44.offset + var17.offset + 5);
														var22.writeByte(2);
														var22.writeByte(var17.offset);
														var22.writeBytes(var17.array, 0, var17.offset);
														var22.writeByte(var44.offset);
														var22.writeBytes(var44.array, 0, var44.offset);
														var22.writeShort(var21.offset);
														var22.writeBytes(var21.array, 0, var21.offset);
														byte[] var24 = var22.array;
														var23 = Language.method3636(var24, 0, var24.length);
														String var25 = var23;

														byte var14;
														try {
															URL var26 = new URL(NetFileRequest.method4121("services", false) + "m=accountappeal/login.ws");
															URLConnection var27 = var26.openConnection();
															var27.setDoInput(true);
															var27.setDoOutput(true);
															var27.setConnectTimeout(5000);
															OutputStreamWriter var45 = new OutputStreamWriter(var27.getOutputStream());
															var45.write("data2=" + UserComparator5.method3352(var25) + "&dest=" + UserComparator5.method3352("passwordchoice.ws"));
															var45.flush();
															InputStream var49 = var27.getInputStream();
															var22 = new Buffer(new byte[1000]);

															while (true) {
																int var50 = var49.read(var22.array, var22.offset, 1000 - var22.offset);
																if (var50 == -1) {
																	var45.close();
																	var49.close();
																	String var30 = new String(var22.array);
																	if (var30.startsWith("OFFLINE")) {
																		var14 = 4;
																	} else if (var30.startsWith("WRONG")) {
																		var14 = 7;
																	} else if (var30.startsWith("RELOAD")) {
																		var14 = 3;
																	} else if (var30.startsWith("Not permitted for social network accounts.")) {
																		var14 = 6;
																	} else {
																		var22.xteaDecryptAll(var19);

																		while (var22.offset > 0 && var22.array[var22.offset - 1] == 0) {
																			--var22.offset;
																		}

																		var30 = new String(var22.array, 0, var22.offset);
																		boolean var31;
																		if (var30 == null) {
																			var31 = false;
																		} else {
																			label1363: {
																				try {
																					new URL(var30);
																				} catch (MalformedURLException var54) {
																					var31 = false;
																					break label1363;
																				}

																				var31 = true;
																			}
																		}

																		if (var31) {
																			class13.openURL(var30, true, false);
																			var14 = 2;
																		} else {
																			var14 = 5;
																		}
																	}
																	break;
																}

																var22.offset += var50;
																if (var22.offset >= 1000) {
																	var14 = 5;
																	break;
																}
															}
														} catch (Throwable var55) {
															var55.printStackTrace();
															var14 = 5;
														}

														var80 = var14;
													}

													switch(var80) {
													case 2:
														AbstractWorldMapData.setLoginResponseString(Strings.field2834, Strings.field3014, Strings.field3015);
														Login.loginIndex = 6;
														break;
													case 3:
														AbstractWorldMapData.setLoginResponseString("", "Error connecting to server.", "");
														break;
													case 4:
														AbstractWorldMapData.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
														break;
													case 5:
														AbstractWorldMapData.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
														break;
													case 6:
														AbstractWorldMapData.setLoginResponseString("", "Error connecting to server.", "");
														break;
													case 7:
														AbstractWorldMapData.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
													}
												}

												return;
											}

											if (var82 && Login.Login_username.length() < 320) {
												Login.Login_username = Login.Login_username + TileItemPile.field1521;
											}
										}
									}
								} else if (Login.loginIndex != 6) {
									if (Login.loginIndex == 7) {
										var61 = Login.loginBoxX + 180 - 80;
										var8 = 321;
										if (var35 == 1 && var59 >= var61 - 75 && var59 <= var61 + 75 && var60 >= var8 - 20 && var60 <= var8 + 20) {
											class13.openURL(NetFileRequest.method4121("secure", true) + "m=dob/set_dob.ws", true, false);
											AbstractWorldMapData.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											Login.loginIndex = 6;
											return;
										}

										var61 = Login.loginBoxX + 180 + 80;
										if (var35 == 1 && var59 >= var61 - 75 && var59 <= var61 + 75 && var60 >= var8 - 20 && var60 <= var8 + 20) {
											ItemDefinition.Login_promptCredentials(true);
										}
									} else if (Login.loginIndex == 8) {
										var61 = Login.loginBoxX + 180 - 80;
										var8 = 321;
										if (var35 == 1 && var59 >= var61 - 75 && var59 <= var61 + 75 && var60 >= var8 - 20 && var60 <= var8 + 20) {
											class13.openURL("https://www.jagex.com/terms/privacy/#eight", true, false);
											AbstractWorldMapData.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											Login.loginIndex = 6;
											return;
										}

										var61 = Login.loginBoxX + 180 + 80;
										if (var35 == 1 && var59 >= var61 - 75 && var59 <= var61 + 75 && var60 >= var8 - 20 && var60 <= var8 + 20) {
											ItemDefinition.Login_promptCredentials(true);
										}
									} else if (Login.loginIndex == 12) {
										String var51 = "";
										switch(Login.field1167) {
										case 0:
											var51 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
											break;
										case 1:
											var51 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
											break;
										default:
											ItemDefinition.Login_promptCredentials(false);
										}

										var64 = Login.loginBoxX + 180;
										var63 = 276;
										if (var35 == 1 && var59 >= var64 - 75 && var59 <= var64 + 75 && var60 >= var63 - 20 && var60 <= var63 + 20) {
											class13.openURL(var51, true, false);
											AbstractWorldMapData.setLoginResponseString("", "Page has opened in a new window.", "(Please check your popup blocker.)");
											Login.loginIndex = 6;
											return;
										}

										var64 = Login.loginBoxX + 180;
										var63 = 326;
										if (var35 == 1 && var59 >= var64 - 75 && var59 <= var64 + 75 && var60 >= var63 - 20 && var60 <= var63 + 20) {
											ItemDefinition.Login_promptCredentials(false);
										}
									} else if (Login.loginIndex == 24) {
										var61 = Login.loginBoxX + 180;
										var8 = 301;
										if (var35 == 1 && var59 >= var61 - 75 && var59 <= var61 + 75 && var60 >= var8 - 20 && var60 <= var8 + 20) {
											ItemDefinition.Login_promptCredentials(false);
										}
									}
								} else {
									while (true) {
										do {
											if (!KeyHandler.isKeyDown()) {
												var62 = 321;
												if (var35 == 1 && var60 >= var62 - 20 && var60 <= var62 + 20) {
													ItemDefinition.Login_promptCredentials(true);
												}

												return;
											}
										} while(VertexNormal.field1732 != 84 && VertexNormal.field1732 != 13);

										ItemDefinition.Login_promptCredentials(true);
									}
								}
							}
						}
					}

				}
			}
		}
	}

	@ObfuscatedName("hb")
	@ObfuscatedSignature(
		signature = "(IIZS)V",
		garbageValue = "16128"
	)
	static final void method3327(int var0, int var1, boolean var2) {
		if (!var2 || var0 != GrandExchangeOfferTotalQuantityComparator.field47 || ClanMate.field3567 != var1) {
			GrandExchangeOfferTotalQuantityComparator.field47 = var0;
			ClanMate.field3567 = var1;
			class195.updateGameState(25);
			class1.drawLoadingMessage("Loading - please wait.", true);
			int var3 = MusicPatchPcmStream.baseX * 64;
			int var4 = ScriptEvent.baseY * 64;
			MusicPatchPcmStream.baseX = (var0 - 6) * 8;
			ScriptEvent.baseY = (var1 - 6) * 8;
			int var5 = MusicPatchPcmStream.baseX * 64 - var3;
			int var6 = ScriptEvent.baseY * 64 - var4;
			var3 = MusicPatchPcmStream.baseX * 64;
			var4 = ScriptEvent.baseY * 64;

			int var7;
			int var9;
			int[] var10000;
			for (var7 = 0; var7 < 32768; ++var7) {
				NPC var8 = Client.npcs[var7];
				if (var8 != null) {
					for (var9 = 0; var9 < 10; ++var9) {
						var10000 = var8.pathX;
						var10000[var9] -= var5;
						var10000 = var8.pathY;
						var10000[var9] -= var6;
					}

					var8.x -= var5 * 128;
					var8.y -= var6 * 128;
				}
			}

			for (var7 = 0; var7 < 2048; ++var7) {
				Player var21 = Client.players[var7];
				if (var21 != null) {
					for (var9 = 0; var9 < 10; ++var9) {
						var10000 = var21.pathX;
						var10000[var9] -= var5;
						var10000 = var21.pathY;
						var10000[var9] -= var6;
					}

					var21.x -= var5 * 128;
					var21.y -= var6 * 128;
				}
			}

			byte var20 = 0;
			byte var18 = 104;
			byte var22 = 1;
			if (var5 < 0) {
				var20 = 103;
				var18 = -1;
				var22 = -1;
			}

			byte var10 = 0;
			byte var11 = 104;
			byte var12 = 1;
			if (var6 < 0) {
				var10 = 103;
				var11 = -1;
				var12 = -1;
			}

			int var14;
			for (int var13 = var20; var18 != var13; var13 += var22) {
				for (var14 = var10; var14 != var11; var14 += var12) {
					int var15 = var13 + var5;
					int var16 = var6 + var14;

					for (int var17 = 0; var17 < 4; ++var17) {
						if (var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
							Client.groundItems[var17][var13][var14] = Client.groundItems[var17][var15][var16];
						} else {
							Client.groundItems[var17][var13][var14] = null;
						}
					}
				}
			}

			for (PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.last(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.previous()) {
				var19.x -= var5;
				var19.y -= var6;
				if (var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
					var19.remove();
				}
			}

			if (Client.destinationX != 0) {
				Client.destinationX -= var5;
				Client.destinationY -= var6;
			}

			Client.soundEffectCount = 0;
			Client.isCameraLocked = false;
			MusicPatchNode2.cameraX -= var5 << 7;
			UserComparator9.cameraZ -= var6 << 7;
			WorldMapSectionType.oculusOrbFocalPointX -= var5 << 7;
			Language.oculusOrbFocalPointY -= var6 << 7;
			Client.field853 = -1;
			Client.graphicsObjects.clear();
			Client.projectiles.clear();

			for (var14 = 0; var14 < 4; ++var14) {
				Client.collisionMaps[var14].clear();
			}

		}
	}
}
