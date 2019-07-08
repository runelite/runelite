import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bs")
public final class class54 {
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -1247107945
   )
   static int field1161;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1587830917"
   )
   static int method1086(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return ModelData0.NetCache_currentResponse != null && var2 == ModelData0.NetCache_currentResponse.key ? WorldMapRectangle.NetCache_responseArchiveBuffer.index * 99 / (WorldMapRectangle.NetCache_responseArchiveBuffer.array.length - ModelData0.NetCache_currentResponse.padding) + 1 : 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public static boolean method1090(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lba;I)V",
      garbageValue = "-603753561"
   )
   static void method1092(GameShell var0) {
      int var1;
      int var2;
      if (!Login.worldSelectOpen) {
         if ((MouseHandler.MouseHandler_lastButton == 1 || !AbstractRasterProvider.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
            ReflectionCheck.clientPreferences.titleMusicDisabled = !ReflectionCheck.clientPreferences.titleMusicDisabled;
            WorldMapSection3.savePreferences();
            if (!ReflectionCheck.clientPreferences.titleMusicDisabled) {
               class204.method4011(UserComparator3.archive6, "scape main", "", 255, false);
            } else {
               class214.midiPcmStream.clear();
               class214.field1129 = 1;
               class214.field1130 = null;
            }
         }

         if (Client.gameState != 5) {
            if (-1L == Login.field471) {
               Login.field471 = class203.currentTimeMs() + 1000L;
            }

            long var15 = class203.currentTimeMs();
            if (AbstractArchive.method4585() && -1L == Login.field472) {
               Login.field472 = var15;
               if (Login.field472 > Login.field471) {
                  Login.field471 = Login.field472;
               }
            }

            if (Client.gameState == 10 || Client.gameState == 11) {
               if (Client.language == 0) {
                  if (MouseHandler.MouseHandler_lastButton == 1 || !AbstractRasterProvider.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
                     var1 = Login.xPadding + 5;
                     short var16 = 463;
                     byte var6 = 100;
                     byte var7 = 35;
                     if (MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var1 + var6 && MouseHandler.MouseHandler_lastPressedY >= var16 && MouseHandler.MouseHandler_lastPressedY <= var7 + var16) {
                        if (ClientParameter.loadWorlds()) {
                           Login.worldSelectOpen = true;
                           Login.worldSelectPage = 0;
                           Login.worldSelectPagesCount = 0;
                        }

                        return;
                     }
                  }

                  if (FriendLoginUpdate.field356 != null && ClientParameter.loadWorlds()) {
                     Login.worldSelectOpen = true;
                     Login.worldSelectPage = 0;
                     Login.worldSelectPagesCount = 0;
                  }
               }

               var1 = MouseHandler.MouseHandler_lastButton;
               var2 = MouseHandler.MouseHandler_lastPressedX;
               int var17 = MouseHandler.MouseHandler_lastPressedY;
               if (var1 == 0) {
                  var2 = MouseHandler.MouseHandler_x;
                  var17 = MouseHandler.MouseHandler_y;
               }

               if (!AbstractRasterProvider.mouseCam && var1 == 4) {
                  var1 = 1;
               }

               int var18;
               short var19;
               if (Login.loginIndex == 0) {
                  boolean var8 = false;

                  while (Decimator.method2490()) {
                     if (ArchiveDiskAction.field411 == 84) {
                        var8 = true;
                     }
                  }

                  var18 = Varps.loginBoxCenter - 80;
                  var19 = 291;
                  if (var1 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var17 >= var19 - 20 && var17 <= var19 + 20) {
                     WorldMapCacheName.openURL(Message.method1227("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var18 = Varps.loginBoxCenter + 80;
                  if (var1 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var17 >= var19 - 20 && var17 <= var19 + 20 || var8) {
                     if ((Client.worldProperties & 33554432) != 0) {
                        Login.Login_response0 = "";
                        Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        Login.Login_response2 = "Your normal account will not be affected.";
                        Login.Login_response3 = "";
                        Login.loginIndex = 1;
                        class196.method3740();
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
                        class196.method3740();
                     } else if ((Client.worldProperties & 1024) != 0) {
                        Login.Login_response1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        Login.Login_response2 = "The Protect Item prayer will";
                        Login.Login_response3 = "not work on this world.";
                        Login.Login_response0 = "Warning!";
                        Login.loginIndex = 1;
                        class196.method3740();
                     } else {
                        MouseHandler.method1084(false);
                     }
                  }
               } else {
                  int var9;
                  short var20;
                  if (Login.loginIndex != 1) {
                     boolean var10;
                     int var11;
                     short var12;
                     if (Login.loginIndex == 2) {
                        var12 = 201;
                        var9 = var12 + 52;
                        if (var1 == 1 && var17 >= var9 - 12 && var17 < var9 + 2) {
                           Login.currentLoginField = 0;
                        }

                        var9 += 15;
                        if (var1 == 1 && var17 >= var9 - 12 && var17 < var9 + 2) {
                           Login.currentLoginField = 1;
                        }

                        var9 += 15;
                        var12 = 361;
                        if (TilePaint.field907 != null) {
                           var18 = TilePaint.field907.field43 / 2;
                           if (var1 == 1 && var2 >= TilePaint.field907.field41 - var18 && var2 <= var18 + TilePaint.field907.field41 && var17 >= var12 - 15 && var17 < var12) {
                              switch(Login.field467) {
                              case 1:
                                 method1089("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                 Login.loginIndex = 5;
                                 return;
                              case 2:
                                 WorldMapCacheName.openURL("https://support.runescape.com/hc/en-gb", true, false);
                              }
                           }
                        }

                        var18 = Varps.loginBoxCenter - 80;
                        var19 = 321;
                        if (var1 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var17 >= var19 - 20 && var17 <= var19 + 20) {
                           Login.Login_username = Login.Login_username.trim();
                           if (Login.Login_username.length() == 0) {
                              method1089("", "Please enter your username/email address.", "");
                              return;
                           }

                           if (Login.Login_password.length() == 0) {
                              method1089("", "Please enter your password.", "");
                              return;
                           }

                           method1089("", "Connecting to server...", "");
                           class15.method184(false);
                           GameShell.updateGameState(20);
                           return;
                        }

                        var18 = Login.loginBoxX + 180 + 80;
                        if (var1 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var17 >= var19 - 20 && var17 <= var19 + 20) {
                           Login.loginIndex = 0;
                           Login.Login_username = "";
                           Login.Login_password = "";
                           class13.otpInt = 0;
                           Login.otp = "";
                           Login.field470 = true;
                        }

                        var18 = Varps.loginBoxCenter + -117;
                        var19 = 277;
                        Login.field468 = var2 >= var18 && var2 < var18 + class168.optionButtonSpriteSubWidth && var17 >= var19 && var17 < var19 + GroundItemPile.optionButtonSpriteSubHeight;
                        if (var1 == 1 && Login.field468) {
                           Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
                           if (!Client.Login_isUsernameRemembered && ReflectionCheck.clientPreferences.rememberedUsername != null) {
                              ReflectionCheck.clientPreferences.rememberedUsername = null;
                              WorldMapSection3.savePreferences();
                           }
                        }

                        var18 = Varps.loginBoxCenter + 24;
                        var19 = 277;
                        Login.field469 = var2 >= var18 && var2 < var18 + class168.optionButtonSpriteSubWidth && var17 >= var19 && var17 < var19 + GroundItemPile.optionButtonSpriteSubHeight;
                        if (var1 == 1 && Login.field469) {
                           ReflectionCheck.clientPreferences.hideUsername = !ReflectionCheck.clientPreferences.hideUsername;
                           if (!ReflectionCheck.clientPreferences.hideUsername) {
                              Login.Login_username = "";
                              ReflectionCheck.clientPreferences.rememberedUsername = null;
                              class196.method3740();
                           }

                           WorldMapSection3.savePreferences();
                        }

                        while (true) {
                           while (Decimator.method2490()) {
                              var10 = false;

                              for (var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var11) {
                                 if (GzipDecompressor.field378 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var11)) {
                                    var10 = true;
                                    break;
                                 }
                              }

                              if (ArchiveDiskAction.field411 == 13) {
                                 Login.loginIndex = 0;
                                 Login.Login_username = "";
                                 Login.Login_password = "";
                                 class13.otpInt = 0;
                                 Login.otp = "";
                                 Login.field470 = true;
                              } else if (Login.currentLoginField == 0) {
                                 if (ArchiveDiskAction.field411 == 85 && Login.Login_username.length() > 0) {
                                    Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                 }

                                 if (ArchiveDiskAction.field411 == 84 || ArchiveDiskAction.field411 == 80) {
                                    Login.currentLoginField = 1;
                                 }

                                 if (var10 && Login.Login_username.length() < 320) {
                                    Login.Login_username = Login.Login_username + GzipDecompressor.field378;
                                 }
                              } else if (Login.currentLoginField == 1) {
                                 if (ArchiveDiskAction.field411 == 85 && Login.Login_password.length() > 0) {
                                    Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
                                 }

                                 if (ArchiveDiskAction.field411 == 84 || ArchiveDiskAction.field411 == 80) {
                                    Login.currentLoginField = 0;
                                 }

                                 if (ArchiveDiskAction.field411 == 84) {
                                    Login.Login_username = Login.Login_username.trim();
                                    if (Login.Login_username.length() == 0) {
                                       method1089("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if (Login.Login_password.length() == 0) {
                                       method1089("", "Please enter your password.", "");
                                       return;
                                    }

                                    method1089("", "Connecting to server...", "");
                                    class15.method184(false);
                                    GameShell.updateGameState(20);
                                    return;
                                 }

                                 if (var10 && Login.Login_password.length() < 20) {
                                    Login.Login_password = Login.Login_password + GzipDecompressor.field378;
                                 }
                              }
                           }

                           return;
                        }
                     }

                     if (Login.loginIndex == 3) {
                        var9 = Login.loginBoxX + 180;
                        var20 = 276;
                        if (var1 == 1 && var2 >= var9 - 75 && var2 <= var9 + 75 && var17 >= var20 - 20 && var17 <= var20 + 20) {
                           MouseHandler.method1084(false);
                        }

                        var9 = Login.loginBoxX + 180;
                        var20 = 326;
                        if (var1 == 1 && var2 >= var9 - 75 && var2 <= var9 + 75 && var17 >= var20 - 20 && var17 <= var20 + 20) {
                           method1089("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           Login.loginIndex = 5;
                           return;
                        }
                     } else {
                        int var13;
                        if (Login.loginIndex == 4) {
                           var9 = Login.loginBoxX + 180 - 80;
                           var20 = 321;
                           if (var1 == 1 && var2 >= var9 - 75 && var2 <= var9 + 75 && var17 >= var20 - 20 && var17 <= var20 + 20) {
                              Login.otp.trim();
                              if (Login.otp.length() != 6) {
                                 method1089("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class13.otpInt = Integer.parseInt(Login.otp);
                              Login.otp = "";
                              class15.method184(true);
                              method1089("", "Connecting to server...", "");
                              GameShell.updateGameState(20);
                              return;
                           }

                           if (var1 == 1 && var2 >= Login.loginBoxX + 180 - 9 && var2 <= Login.loginBoxX + 180 + 130 && var17 >= 263 && var17 <= 296) {
                              Login.field470 = !Login.field470;
                           }

                           if (var1 == 1 && var2 >= Login.loginBoxX + 180 - 34 && var2 <= Login.loginBoxX + 34 + 180 && var17 >= 351 && var17 <= 363) {
                              WorldMapCacheName.openURL(Message.method1227("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var9 = Login.loginBoxX + 180 + 80;
                           if (var1 == 1 && var2 >= var9 - 75 && var2 <= var9 + 75 && var17 >= var20 - 20 && var17 <= var20 + 20) {
                              Login.loginIndex = 0;
                              Login.Login_username = "";
                              Login.Login_password = "";
                              class13.otpInt = 0;
                              Login.otp = "";
                           }

                           while (Decimator.method2490()) {
                              boolean var14 = false;

                              for (var13 = 0; var13 < "1234567890".length(); ++var13) {
                                 if (GzipDecompressor.field378 == "1234567890".charAt(var13)) {
                                    var14 = true;
                                    break;
                                 }
                              }

                              if (ArchiveDiskAction.field411 == 13) {
                                 Login.loginIndex = 0;
                                 Login.Login_username = "";
                                 Login.Login_password = "";
                                 class13.otpInt = 0;
                                 Login.otp = "";
                              } else {
                                 if (ArchiveDiskAction.field411 == 85 && Login.otp.length() > 0) {
                                    Login.otp = Login.otp.substring(0, Login.otp.length() - 1);
                                 }

                                 if (ArchiveDiskAction.field411 == 84) {
                                    Login.otp.trim();
                                    if (Login.otp.length() != 6) {
                                       method1089("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class13.otpInt = Integer.parseInt(Login.otp);
                                    Login.otp = "";
                                    class15.method184(true);
                                    method1089("", "Connecting to server...", "");
                                    GameShell.updateGameState(20);
                                    return;
                                 }

                                 if (var14 && Login.otp.length() < 6) {
                                    Login.otp = Login.otp + GzipDecompressor.field378;
                                 }
                              }
                           }
                        } else if (Login.loginIndex == 5) {
                           var9 = Login.loginBoxX + 180 - 80;
                           var20 = 321;
                           if (var1 == 1 && var2 >= var9 - 75 && var2 <= var9 + 75 && var17 >= var20 - 20 && var17 <= var20 + 20) {
                              NPCDefinition.method5162();
                              return;
                           }

                           var9 = Login.loginBoxX + 180 + 80;
                           if (var1 == 1 && var2 >= var9 - 75 && var2 <= var9 + 75 && var17 >= var20 - 20 && var17 <= var20 + 20) {
                              MouseHandler.method1084(true);
                           }

                           var19 = 361;
                           if (UrlRequester.field930 != null) {
                              var13 = UrlRequester.field930.field43 / 2;
                              if (var1 == 1 && var2 >= UrlRequester.field930.field41 - var13 && var2 <= var13 + UrlRequester.field930.field41 && var17 >= var19 - 15 && var17 < var19) {
                                 WorldMapCacheName.openURL(Message.method1227("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
                              }
                           }

                           while (Decimator.method2490()) {
                              var10 = false;

                              for (var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var11) {
                                 if (GzipDecompressor.field378 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var11)) {
                                    var10 = true;
                                    break;
                                 }
                              }

                              if (ArchiveDiskAction.field411 == 13) {
                                 MouseHandler.method1084(true);
                              } else {
                                 if (ArchiveDiskAction.field411 == 85 && Login.Login_username.length() > 0) {
                                    Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                 }

                                 if (ArchiveDiskAction.field411 == 84) {
                                    NPCDefinition.method5162();
                                    return;
                                 }

                                 if (var10 && Login.Login_username.length() < 320) {
                                    Login.Login_username = Login.Login_username + GzipDecompressor.field378;
                                 }
                              }
                           }
                        } else {
                           if (Login.loginIndex == 6) {
                              while (true) {
                                 do {
                                    if (!Decimator.method2490()) {
                                       var12 = 321;
                                       if (var1 == 1 && var17 >= var12 - 20 && var17 <= var12 + 20) {
                                          MouseHandler.method1084(true);
                                       }

                                       return;
                                    }
                                 } while(ArchiveDiskAction.field411 != 84 && ArchiveDiskAction.field411 != 13);

                                 MouseHandler.method1084(true);
                              }
                           }

                           if (Login.loginIndex == 7) {
                              var9 = Login.loginBoxX + 180 - 80;
                              var20 = 321;
                              if (var1 == 1 && var2 >= var9 - 75 && var2 <= var9 + 75 && var17 >= var20 - 20 && var17 <= var20 + 20) {
                                 WorldMapCacheName.openURL(Message.method1227("secure", true) + "m=dob/set_dob.ws", true, false);
                                 method1089("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                 Login.loginIndex = 6;
                                 return;
                              }

                              var9 = Login.loginBoxX + 180 + 80;
                              if (var1 == 1 && var2 >= var9 - 75 && var2 <= var9 + 75 && var17 >= var20 - 20 && var17 <= var20 + 20) {
                                 MouseHandler.method1084(true);
                              }
                           } else if (Login.loginIndex == 8) {
                              var9 = Login.loginBoxX + 180 - 80;
                              var20 = 321;
                              if (var1 == 1 && var2 >= var9 - 75 && var2 <= var9 + 75 && var17 >= var20 - 20 && var17 <= var20 + 20) {
                                 WorldMapCacheName.openURL("https://www.jagex.com/terms/privacy/#eight", true, false);
                                 method1089("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                 Login.loginIndex = 6;
                                 return;
                              }

                              var9 = Login.loginBoxX + 180 + 80;
                              if (var1 == 1 && var2 >= var9 - 75 && var2 <= var9 + 75 && var17 >= var20 - 20 && var17 <= var20 + 20) {
                                 MouseHandler.method1084(true);
                              }
                           } else if (Login.loginIndex == 12) {
                              String var21 = "";
                              switch(Login.field466) {
                              case 0:
                                 var21 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
                                 break;
                              case 1:
                                 var21 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
                                 break;
                              default:
                                 MouseHandler.method1084(false);
                              }

                              var18 = Login.loginBoxX + 180;
                              var19 = 276;
                              if (var1 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var17 >= var19 - 20 && var17 <= var19 + 20) {
                                 WorldMapCacheName.openURL(var21, true, false);
                                 method1089("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                                 Login.loginIndex = 6;
                                 return;
                              }

                              var18 = Login.loginBoxX + 180;
                              var19 = 326;
                              if (var1 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var17 >= var19 - 20 && var17 <= var19 + 20) {
                                 MouseHandler.method1084(false);
                              }
                           }
                        }
                     }
                  } else {
                     while (Decimator.method2490()) {
                        if (ArchiveDiskAction.field411 == 84) {
                           MouseHandler.method1084(false);
                        } else if (ArchiveDiskAction.field411 == 13) {
                           Login.loginIndex = 0;
                        }
                     }

                     var9 = Varps.loginBoxCenter - 80;
                     var20 = 321;
                     if (var1 == 1 && var2 >= var9 - 75 && var2 <= var9 + 75 && var17 >= var20 - 20 && var17 <= var20 + 20) {
                        MouseHandler.method1084(false);
                     }

                     var9 = Varps.loginBoxCenter + 80;
                     if (var1 == 1 && var2 >= var9 - 75 && var2 <= var9 + 75 && var17 >= var20 - 20 && var17 <= var20 + 20) {
                        Login.loginIndex = 0;
                     }
                  }
               }
            }
         }
      } else {
         while (true) {
            if (!Decimator.method2490()) {
               if (MouseHandler.MouseHandler_lastButton == 1 || !AbstractRasterProvider.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
                  int var3 = Login.xPadding + 280;
                  if (MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var3 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                     Interpreter.changeWorldSelectSorting(0, 0);
                  } else if (MouseHandler.MouseHandler_lastPressedX >= var3 + 15 && MouseHandler.MouseHandler_lastPressedX <= var3 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                     Interpreter.changeWorldSelectSorting(0, 1);
                  } else {
                     int var4 = Login.xPadding + 390;
                     if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                        Interpreter.changeWorldSelectSorting(1, 0);
                     } else if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                        Interpreter.changeWorldSelectSorting(1, 1);
                     } else {
                        var1 = Login.xPadding + 500;
                        if (MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var1 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                           Interpreter.changeWorldSelectSorting(2, 0);
                        } else if (MouseHandler.MouseHandler_lastPressedX >= var1 + 15 && MouseHandler.MouseHandler_lastPressedX <= var1 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                           Interpreter.changeWorldSelectSorting(2, 1);
                        } else {
                           var2 = Login.xPadding + 610;
                           if (MouseHandler.MouseHandler_lastPressedX >= var2 && MouseHandler.MouseHandler_lastPressedX <= var2 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                              Interpreter.changeWorldSelectSorting(3, 0);
                           } else if (MouseHandler.MouseHandler_lastPressedX >= var2 + 15 && MouseHandler.MouseHandler_lastPressedX <= var2 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                              Interpreter.changeWorldSelectSorting(3, 1);
                           } else if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
                              FontName.closeWorldSelect();
                           } else if (Login.hoveredWorldIndex != -1) {
                              World var5 = ItemContainer.worlds[Login.hoveredWorldIndex];
                              class31.changeWorld(var5);
                              FontName.closeWorldSelect();
                           } else {
                              if (Login.worldSelectPage > 0 && SecureRandomFuture.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= SecureRandomFuture.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= Huffman.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= Huffman.canvasHeight / 2 + 50) {
                                 --Login.worldSelectPage;
                              }

                              if (Login.worldSelectPage < Login.worldSelectPagesCount && NetSocket.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= SoundCache.canvasWidth - NetSocket.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= SoundCache.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= Huffman.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= Huffman.canvasHeight / 2 + 50) {
                                 ++Login.worldSelectPage;
                              }
                           }
                        }
                     }
                  }
               }
               break;
            }

            if (ArchiveDiskAction.field411 == 13) {
               FontName.closeWorldSelect();
               break;
            }

            if (ArchiveDiskAction.field411 == 96) {
               if (Login.worldSelectPage > 0 && SecureRandomFuture.worldSelectLeftSprite != null) {
                  --Login.worldSelectPage;
               }
            } else if (ArchiveDiskAction.field411 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && NetSocket.worldSelectRightSprite != null) {
               ++Login.worldSelectPage;
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-14"
   )
   static void method1089(String var0, String var1, String var2) {
      Login.Login_response1 = var0;
      Login.Login_response2 = var1;
      Login.Login_response3 = var2;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "571260142"
   )
   static int method1093(int var0, Script var1, boolean var2) {
      int var3;
      if (var0 == 6600) {
         var3 = SoundSystem.plane;
         int var13 = (Canvas.localPlayer.x >> 7) + class50.baseX;
         int var16 = (Canvas.localPlayer.y >> 7) + GraphicsObject.baseY;
         BufferedFile.worldMap().method366(var3, var13, var16, true);
         return 1;
      } else {
         WorldMapArea var4;
         if (var0 == ScriptOpcodes.WORLDMAP_GETMAPNAME) {
            var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            String var14 = "";
            var4 = BufferedFile.worldMap().getMapArea(var3);
            if (var4 != null) {
               var14 = var4.name();
            }

            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var14;
            return 1;
         } else if (var0 == ScriptOpcodes.WORLDMAP_SETMAP) {
            var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            BufferedFile.worldMap().setCurrentMapAreaId(var3);
            return 1;
         } else if (var0 == ScriptOpcodes.WORLDMAP_GETZOOM) {
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = BufferedFile.worldMap().getZoomLevel();
            return 1;
         } else if (var0 == ScriptOpcodes.WORLDMAP_SETZOOM) {
            var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
            BufferedFile.worldMap().setZoomLevel(var3);
            return 1;
         } else if (var0 == ScriptOpcodes.WORLDMAP_ISLOADED) {
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = BufferedFile.worldMap().isCacheLoaded() ? 1 : 0;
            return 1;
         } else {
            Coord var5;
            if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD) {
               var5 = new Coord(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
               BufferedFile.worldMap().setWorldMapPositionTarget(var5.x, var5.y);
               return 1;
            } else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTODISPLAYCOORD_INSTANT) {
               var5 = new Coord(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
               BufferedFile.worldMap().setWorldMapPositionTargetInstant(var5.x, var5.y);
               return 1;
            } else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD) {
               var5 = new Coord(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
               BufferedFile.worldMap().jumpToSourceCoord(var5.plane, var5.x, var5.y);
               return 1;
            } else if (var0 == ScriptOpcodes.WORLDMAP_JUMPTOSOURCECOORD_INSTANT) {
               var5 = new Coord(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
               BufferedFile.worldMap().jumpToSourceCoordInstant(var5.plane, var5.x, var5.y);
               return 1;
            } else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYPOSITION) {
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = BufferedFile.worldMap().getDisplayX();
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = BufferedFile.worldMap().getDisplayY();
               return 1;
            } else {
               WorldMapArea var6;
               if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGORIGIN) {
                  var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                  var6 = BufferedFile.worldMap().getMapArea(var3);
                  if (var6 == null) {
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var6.origin().packed();
                  }

                  return 1;
               } else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGSIZE) {
                  var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                  var6 = BufferedFile.worldMap().getMapArea(var3);
                  if (var6 == null) {
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = (var6.maxX() - var6.minX() + 1) * 64;
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = (var6.maxY() - var6.minY() + 1) * 64;
                  }

                  return 1;
               } else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGBOUNDS) {
                  var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                  var6 = BufferedFile.worldMap().getMapArea(var3);
                  if (var6 == null) {
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var6.minX() * 64;
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var6.minY() * 64;
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var6.maxX() * 64 + 64 - 1;
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var6.maxY() * 64 + 64 - 1;
                  }

                  return 1;
               } else if (var0 == ScriptOpcodes.WORLDMAP_GETCONFIGZOOM) {
                  var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                  var6 = BufferedFile.worldMap().getMapArea(var3);
                  if (var6 == null) {
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var6.zoom();
                  }

                  return 1;
               } else if (var0 == 6615) {
                  var5 = BufferedFile.worldMap().getDisplayCoord();
                  if (var5 == null) {
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var5.x;
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var5.y;
                  }

                  return 1;
               } else if (var0 == ScriptOpcodes.WORLDMAP_GETCURRENTMAP) {
                  Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = BufferedFile.worldMap().currentMapAreaId();
                  return 1;
               } else if (var0 == ScriptOpcodes.WORLDMAP_GETDISPLAYCOORD) {
                  var5 = new Coord(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
                  var6 = BufferedFile.worldMap().getCurrentMapArea();
                  if (var6 == null) {
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var15 = var6.position(var5.plane, var5.x, var5.y);
                     if (var15 == null) {
                        Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                        Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                     } else {
                        Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var15[0];
                        Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var15[1];
                     }

                     return 1;
                  }
               } else {
                  Coord var7;
                  if (var0 == 6618) {
                     var5 = new Coord(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
                     var6 = BufferedFile.worldMap().getCurrentMapArea();
                     if (var6 == null) {
                        Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                        Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var7 = var6.coord(var5.x, var5.y);
                        if (var7 == null) {
                           Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                        } else {
                           Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var7.packed();
                        }

                        return 1;
                     }
                  } else {
                     Coord var8;
                     if (var0 == 6619) {
                        RouteStrategy.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
                        var8 = new Coord(Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1]);
                        GrandExchangeOfferTotalQuantityComparator.method96(var3, var8, false);
                        return 1;
                     } else if (var0 == 6620) {
                        RouteStrategy.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
                        var8 = new Coord(Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1]);
                        GrandExchangeOfferTotalQuantityComparator.method96(var3, var8, true);
                        return 1;
                     } else if (var0 == ScriptOpcodes.WORLDMAP_COORDINMAP) {
                        RouteStrategy.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
                        var8 = new Coord(Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1]);
                        var4 = BufferedFile.worldMap().getMapArea(var3);
                        if (var4 == null) {
                           Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
                           return 1;
                        } else {
                           Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var4.containsCoord(var8.plane, var8.x, var8.y) ? 1 : 0;
                           return 1;
                        }
                     } else if (var0 == ScriptOpcodes.WORLDMAP_GETSIZE) {
                        Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = BufferedFile.worldMap().getDisplayWith();
                        Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = BufferedFile.worldMap().getDisplayHeight();
                        return 1;
                     } else if (var0 == 6623) {
                        var5 = new Coord(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
                        var6 = BufferedFile.worldMap().mapAreaAtCoord(var5.plane, var5.x, var5.y);
                        if (var6 == null) {
                           Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                        } else {
                           Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var6.id();
                        }

                        return 1;
                     } else if (var0 == 6624) {
                        BufferedFile.worldMap().method379(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
                        return 1;
                     } else if (var0 == 6625) {
                        BufferedFile.worldMap().method380();
                        return 1;
                     } else if (var0 == 6626) {
                        BufferedFile.worldMap().method381(Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize]);
                        return 1;
                     } else if (var0 == 6627) {
                        BufferedFile.worldMap().method382();
                        return 1;
                     } else {
                        boolean var9;
                        if (var0 == ScriptOpcodes.WORLDMAP_PERPETUALFLASH) {
                           var9 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                           BufferedFile.worldMap().setPerpetualFlash(var9);
                           return 1;
                        } else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENT) {
                           var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                           BufferedFile.worldMap().flashElement(var3);
                           return 1;
                        } else if (var0 == ScriptOpcodes.WORLDMAP_FLASHELEMENTCATEGORY) {
                           var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                           BufferedFile.worldMap().flashCategory(var3);
                           return 1;
                        } else if (var0 == ScriptOpcodes.WORLDMAP_STOPCURRENTFLASHES) {
                           BufferedFile.worldMap().stopCurrentFlashes();
                           return 1;
                        } else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTS) {
                           var9 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize] == 1;
                           BufferedFile.worldMap().setElementsEnabled(var9);
                           return 1;
                        } else {
                           boolean var10;
                           if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENT) {
                              RouteStrategy.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
                              var10 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1] == 1;
                              BufferedFile.worldMap().disableElement(var3, var10);
                              return 1;
                           } else if (var0 == ScriptOpcodes.WORLDMAP_DISABLEELEMENTCATEGORY) {
                              RouteStrategy.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
                              var10 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1] == 1;
                              BufferedFile.worldMap().disableCategory(var3, var10);
                              return 1;
                           } else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTS) {
                              Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = BufferedFile.worldMap().getElementsEnabled() ? 1 : 0;
                              return 1;
                           } else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENT) {
                              var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                              Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = BufferedFile.worldMap().isElementDisabled(var3) ? 1 : 0;
                              return 1;
                           } else if (var0 == ScriptOpcodes.WORLDMAP_GETDISABLEELEMENTCATEGORY) {
                              var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                              Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = BufferedFile.worldMap().isCategoryDisabled(var3) ? 1 : 0;
                              return 1;
                           } else if (var0 == 6638) {
                              RouteStrategy.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
                              var8 = new Coord(Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1]);
                              var7 = BufferedFile.worldMap().method385(var3, var8);
                              if (var7 == null) {
                                 Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                              } else {
                                 Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var7.packed();
                              }

                              return 1;
                           } else {
                              AbstractWorldMapIcon var11;
                              if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_START) {
                                 var11 = BufferedFile.worldMap().iconStart();
                                 if (var11 == null) {
                                    Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                                    Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                                 } else {
                                    Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var11.getElement();
                                    Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var11.coord2.packed();
                                 }

                                 return 1;
                              } else if (var0 == ScriptOpcodes.WORLDMAP_LISTELEMENT_NEXT) {
                                 var11 = BufferedFile.worldMap().iconNext();
                                 if (var11 == null) {
                                    Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                                    Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                                 } else {
                                    Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var11.getElement();
                                    Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var11.coord2.packed();
                                 }

                                 return 1;
                              } else {
                                 WorldMapElement var12;
                                 if (var0 == ScriptOpcodes.MEC_TEXT) {
                                    var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                                    var12 = ViewportMouse.getWorldMapElement(var3);
                                    if (var12.name == null) {
                                       Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                                    } else {
                                       Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var12.name;
                                    }

                                    return 1;
                                 } else if (var0 == ScriptOpcodes.MEC_TEXTSIZE) {
                                    var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                                    var12 = ViewportMouse.getWorldMapElement(var3);
                                    Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var12.textSize;
                                    return 1;
                                 } else if (var0 == ScriptOpcodes.MEC_CATEGORY) {
                                    var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                                    var12 = ViewportMouse.getWorldMapElement(var3);
                                    if (var12 == null) {
                                       Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                                    } else {
                                       Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var12.category;
                                    }

                                    return 1;
                                 } else if (var0 == ScriptOpcodes.MEC_SPRITE) {
                                    var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
                                    var12 = ViewportMouse.getWorldMapElement(var3);
                                    if (var12 == null) {
                                       Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = -1;
                                    } else {
                                       Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var12.sprite1;
                                    }

                                    return 1;
                                 } else if (var0 == 6697) {
                                    Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = class15.worldMapEvent.mapElement;
                                    return 1;
                                 } else if (var0 == 6698) {
                                    Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = class15.worldMapEvent.coord1.packed();
                                    return 1;
                                 } else if (var0 == 6699) {
                                    Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = class15.worldMapEvent.coord2.packed();
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
            }
         }
      }
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-9841"
   )
   static final void method1091() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      if (Client.oculusOrbState == 0) {
         var0 = Canvas.localPlayer.x;
         var1 = Canvas.localPlayer.y;
         if (MouseHandler.oculusOrbFocalPointX - var0 < -500 || MouseHandler.oculusOrbFocalPointX - var0 > 500 || ScriptEvent.oculusOrbFocalPointY - var1 < -500 || ScriptEvent.oculusOrbFocalPointY - var1 > 500) {
            MouseHandler.oculusOrbFocalPointX = var0;
            ScriptEvent.oculusOrbFocalPointY = var1;
         }

         if (var0 != MouseHandler.oculusOrbFocalPointX) {
            MouseHandler.oculusOrbFocalPointX += (var0 - MouseHandler.oculusOrbFocalPointX) / 16;
         }

         if (var1 != ScriptEvent.oculusOrbFocalPointY) {
            ScriptEvent.oculusOrbFocalPointY += (var1 - ScriptEvent.oculusOrbFocalPointY) / 16;
         }

         var2 = MouseHandler.oculusOrbFocalPointX >> 7;
         var3 = ScriptEvent.oculusOrbFocalPointY >> 7;
         var4 = class32.getTileHeight(MouseHandler.oculusOrbFocalPointX, ScriptEvent.oculusOrbFocalPointY, SoundSystem.plane);
         var5 = 0;
         int var6;
         if (var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
            for (var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
               for (int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
                  int var8 = SoundSystem.plane;
                  if (var8 < 3 && (Tiles.Tiles_renderFlags[1][var6][var7] & 2) == 2) {
                     ++var8;
                  }

                  int var9 = var4 - Tiles.Tiles_heights[var8][var6][var7];
                  if (var9 > var5) {
                     var5 = var9;
                  }
               }
            }
         }

         var6 = var5 * 192;
         if (var6 > 98048) {
            var6 = 98048;
         }

         if (var6 < 32768) {
            var6 = 32768;
         }

         if (var6 > Client.field202) {
            Client.field202 += (var6 - Client.field202) / 24;
         } else if (var6 < Client.field202) {
            Client.field202 += (var6 - Client.field202) / 80;
         }

         MouseRecorder.field566 = class32.getTileHeight(Canvas.localPlayer.x, Canvas.localPlayer.y, SoundSystem.plane) - Client.camFollowHeight;
      } else if (Client.oculusOrbState == 1) {
         if (Client.field199 && Canvas.localPlayer != null) {
            var0 = Canvas.localPlayer.pathX[0];
            var1 = Canvas.localPlayer.pathY[0];
            if (var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
               MouseHandler.oculusOrbFocalPointX = Canvas.localPlayer.x;
               var2 = class32.getTileHeight(Canvas.localPlayer.x, Canvas.localPlayer.y, SoundSystem.plane) - Client.camFollowHeight;
               if (var2 < MouseRecorder.field566) {
                  MouseRecorder.field566 = var2;
               }

               ScriptEvent.oculusOrbFocalPointY = Canvas.localPlayer.y;
               Client.field199 = false;
            }
         }

         short var11 = -1;
         if (KeyHandler.KeyHandler_pressedKeys[33]) {
            var11 = 0;
         } else if (KeyHandler.KeyHandler_pressedKeys[49]) {
            var11 = 1024;
         }

         if (KeyHandler.KeyHandler_pressedKeys[48]) {
            if (var11 == 0) {
               var11 = 1792;
            } else if (var11 == 1024) {
               var11 = 1280;
            } else {
               var11 = 1536;
            }
         } else if (KeyHandler.KeyHandler_pressedKeys[50]) {
            if (var11 == 0) {
               var11 = 256;
            } else if (var11 == 1024) {
               var11 = 768;
            } else {
               var11 = 512;
            }
         }

         byte var10 = 0;
         if (KeyHandler.KeyHandler_pressedKeys[35]) {
            var10 = -1;
         } else if (KeyHandler.KeyHandler_pressedKeys[51]) {
            var10 = 1;
         }

         var2 = 0;
         if (var11 >= 0 || var10 != 0) {
            var2 = KeyHandler.KeyHandler_pressedKeys[81] ? Client.oculusOrbSlowedSpeed : Client.oculusOrbNormalSpeed;
            var2 *= 16;
            Client.field195 = var11;
            Client.field196 = var10;
         }

         if (Client.field194 < var2) {
            Client.field194 += var2 / 8;
            if (Client.field194 > var2) {
               Client.field194 = var2;
            }
         } else if (Client.field194 > var2) {
            Client.field194 = Client.field194 * 9 / 10;
         }

         if (Client.field194 > 0) {
            var3 = Client.field194 / 16;
            if (Client.field195 >= 0) {
               var0 = Client.field195 - MusicPatchNode.cameraYaw & 2047;
               var4 = Rasterizer3D.Rasterizer3D_sine[var0];
               var5 = Rasterizer3D.Rasterizer3D_cosine[var0];
               MouseHandler.oculusOrbFocalPointX += var3 * var4 / 65536;
               ScriptEvent.oculusOrbFocalPointY += var3 * var5 / 65536;
            }

            if (Client.field196 != 0) {
               MouseRecorder.field566 += var3 * Client.field196;
               if (MouseRecorder.field566 > 0) {
                  MouseRecorder.field566 = 0;
               }
            }
         } else {
            Client.field195 = -1;
            Client.field196 = -1;
         }

         if (KeyHandler.KeyHandler_pressedKeys[13]) {
            Client.packetWriter.method241(Interpreter.method1915(ClientPacket.field259, Client.packetWriter.isaacCipher));
            Client.oculusOrbState = 0;
         }
      }

      if (MouseHandler.MouseHandler_currentButton == 4 && AbstractRasterProvider.mouseCam) {
         var0 = MouseHandler.MouseHandler_y - Client.field193;
         Client.field191 = var0 * 2;
         Client.field193 = var0 != -1 && var0 != 1 ? (MouseHandler.MouseHandler_y + Client.field193) / 2 : MouseHandler.MouseHandler_y;
         var1 = Client.field192 - MouseHandler.MouseHandler_x;
         Client.field190 = var1 * 2;
         Client.field192 = var1 != -1 && var1 != 1 ? (Client.field192 + MouseHandler.MouseHandler_x) / 2 : MouseHandler.MouseHandler_x;
      } else {
         if (KeyHandler.KeyHandler_pressedKeys[96]) {
            Client.field190 += (-24 - Client.field190) / 2;
         } else if (KeyHandler.KeyHandler_pressedKeys[97]) {
            Client.field190 += (24 - Client.field190) / 2;
         } else {
            Client.field190 /= 2;
         }

         if (KeyHandler.KeyHandler_pressedKeys[98]) {
            Client.field191 += (12 - Client.field191) / 2;
         } else if (KeyHandler.KeyHandler_pressedKeys[99]) {
            Client.field191 += (-12 - Client.field191) / 2;
         } else {
            Client.field191 /= 2;
         }

         Client.field193 = MouseHandler.MouseHandler_y;
         Client.field192 = MouseHandler.MouseHandler_x;
      }

      Client.camAngleY = Client.field190 / 2 + Client.camAngleY & 2047;
      Client.camAngleX += Client.field191 / 2;
      if (Client.camAngleX < 128) {
         Client.camAngleX = 128;
      }

      if (Client.camAngleX > 383) {
         Client.camAngleX = 383;
      }

   }
}
