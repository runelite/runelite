import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
public final class class54 {
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -1247107945
   )
   @Export("__bs_nb")
   static int __bs_nb;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1587830917"
   )
   static int method1086(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return ModelData0.NetCache_currentResponse != null && var2 == ModelData0.NetCache_currentResponse.key?class22.NetCache_responseArchiveBuffer.index * 99 / (class22.NetCache_responseArchiveBuffer.array.length - ModelData0.NetCache_currentResponse.padding) + 1:0;
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
      int var3;
      int var15;
      if(Login.__cu_bk) {
         while(true) {
            if(!Decimator.method2490()) {
               if(MouseHandler.MouseHandler_lastButton != 1 && (AbstractRasterProvider.__lp_ca || MouseHandler.MouseHandler_lastButton != 4)) {
                  break;
               }

               int var1 = Login.__cu_q + 280;
               if(MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var1 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  Interpreter.method1975(0, 0);
                  break;
               }

               if(MouseHandler.MouseHandler_lastPressedX >= var1 + 15 && MouseHandler.MouseHandler_lastPressedX <= var1 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  Interpreter.method1975(0, 1);
                  break;
               }

               int var2 = Login.__cu_q + 390;
               if(MouseHandler.MouseHandler_lastPressedX >= var2 && MouseHandler.MouseHandler_lastPressedX <= var2 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  Interpreter.method1975(1, 0);
                  break;
               }

               if(MouseHandler.MouseHandler_lastPressedX >= var2 + 15 && MouseHandler.MouseHandler_lastPressedX <= var2 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  Interpreter.method1975(1, 1);
                  break;
               }

               var3 = Login.__cu_q + 500;
               if(MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var3 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  Interpreter.method1975(2, 0);
                  break;
               }

               if(MouseHandler.MouseHandler_lastPressedX >= var3 + 15 && MouseHandler.MouseHandler_lastPressedX <= var3 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  Interpreter.method1975(2, 1);
                  break;
               }

               var15 = Login.__cu_q + 610;
               if(MouseHandler.MouseHandler_lastPressedX >= var15 && MouseHandler.MouseHandler_lastPressedX <= var15 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  Interpreter.method1975(3, 0);
                  break;
               }

               if(MouseHandler.MouseHandler_lastPressedX >= var15 + 15 && MouseHandler.MouseHandler_lastPressedX <= var15 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
                  Interpreter.method1975(3, 1);
                  break;
               }

               if(MouseHandler.MouseHandler_lastPressedX >= Login.__cu_q + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.__cu_q + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
                  FontName.method5636();
                  break;
               }

               if(Login.__cu_bl != -1) {
                  World var13 = ItemContainer.worlds[Login.__cu_bl];
                  class31.changeWorld(var13);
                  FontName.method5636();
               } else {
                  if(Login.__cu_br > 0 && SecureRandomFuture.__cn_bu != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= SecureRandomFuture.__cn_bu.subWidth && MouseHandler.MouseHandler_lastPressedY >= Huffman.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= Huffman.canvasHeight / 2 + 50) {
                     --Login.__cu_br;
                  }

                  if(Login.__cu_br < Login.__cu_bj && NetSocket.__fb_bm != null && MouseHandler.MouseHandler_lastPressedX >= SoundCache.canvasWidth - NetSocket.__fb_bm.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= SoundCache.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= Huffman.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= Huffman.canvasHeight / 2 + 50) {
                     ++Login.__cu_br;
                  }
               }
               break;
            }

            if(IndexStoreAction.__ik_cn == 13) {
               FontName.method5636();
               break;
            }

            if(IndexStoreAction.__ik_cn == 96) {
               if(Login.__cu_br > 0 && SecureRandomFuture.__cn_bu != null) {
                  --Login.__cu_br;
               }
            } else if(IndexStoreAction.__ik_cn == 97 && Login.__cu_br < Login.__cu_bj && NetSocket.__fb_bm != null) {
               ++Login.__cu_br;
            }
         }

      } else {
         if((MouseHandler.MouseHandler_lastButton == 1 || !AbstractRasterProvider.__lp_ca && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.__cu_q + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
            ReflectionCheck.clientPreferences.titleMusicDisabled = !ReflectionCheck.clientPreferences.titleMusicDisabled;
            WorldMapSection0.method247();
            if(!ReflectionCheck.clientPreferences.titleMusicDisabled) {
               class204.method4011(UserComparator3.indexCache6, "scape main", "", 255, false);
            } else {
               class214.midiPcmStream.clear();
               class214.__hf_o = 1;
               class214.__hf_u = null;
            }
         }

         if(Client.gameState != 5) {
            if(-1L == Login.__cu_bi) {
               Login.__cu_bi = class203.currentTimeMs() + 1000L;
            }

            long var11 = class203.currentTimeMs();
            if(AbstractIndexCache.method4585() && -1L == Login.__cu_bz) {
               Login.__cu_bz = var11;
               if(Login.__cu_bz > Login.__cu_bi) {
                  Login.__cu_bi = Login.__cu_bz;
               }
            }

            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.language == 0) {
                  if(MouseHandler.MouseHandler_lastButton == 1 || !AbstractRasterProvider.__lp_ca && MouseHandler.MouseHandler_lastButton == 4) {
                     var3 = Login.__cu_q + 5;
                     short var4 = 463;
                     byte var5 = 100;
                     byte var6 = 35;
                     if(MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var3 + var5 && MouseHandler.MouseHandler_lastPressedY >= var4 && MouseHandler.MouseHandler_lastPressedY <= var6 + var4) {
                        if(ClientParameter.loadWorlds()) {
                           Login.__cu_bk = true;
                           Login.__cu_br = 0;
                           Login.__cu_bj = 0;
                        }

                        return;
                     }
                  }

                  if(FriendLoginUpdate.__kn_x != null && ClientParameter.loadWorlds()) {
                     Login.__cu_bk = true;
                     Login.__cu_br = 0;
                     Login.__cu_bj = 0;
                  }
               }

               var3 = MouseHandler.MouseHandler_lastButton;
               var15 = MouseHandler.MouseHandler_lastPressedX;
               int var16 = MouseHandler.MouseHandler_lastPressedY;
               if(var3 == 0) {
                  var15 = MouseHandler.MouseHandler_x;
                  var16 = MouseHandler.MouseHandler_y;
               }

               if(!AbstractRasterProvider.__lp_ca && var3 == 4) {
                  var3 = 1;
               }

               int var7;
               short var8;
               if(Login.loginIndex == 0) {
                  boolean var17 = false;

                  while(Decimator.method2490()) {
                     if(IndexStoreAction.__ik_cn == 84) {
                        var17 = true;
                     }
                  }

                  var7 = Varps.__hv_h - 80;
                  var8 = 291;
                  if(var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var16 >= var8 - 20 && var16 <= var8 + 20) {
                     WorldMapCacheName.method635(Message.method1227("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var7 = Varps.__hv_h + 80;
                  if(var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var16 >= var8 - 20 && var16 <= var8 + 20 || var17) {
                     if((Client.worldProperties & 33554432) != 0) {
                        Login.Login_response0 = "";
                        Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        Login.Login_response2 = "Your normal account will not be affected.";
                        Login.Login_response3 = "";
                        Login.loginIndex = 1;
                        class196.method3740();
                     } else if((Client.worldProperties & 4) != 0) {
                        if((Client.worldProperties & 1024) != 0) {
                           Login.Login_response1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           Login.Login_response2 = "Players can attack each other almost everywhere";
                           Login.Login_response3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           Login.Login_response1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           Login.Login_response2 = "Players can attack each other";
                           Login.Login_response3 = "almost everywhere.";
                        }

                        Login.Login_response0 = "Warning!";
                        Login.loginIndex = 1;
                        class196.method3740();
                     } else if((Client.worldProperties & 1024) != 0) {
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
                  int var18;
                  short var20;
                  if(Login.loginIndex != 1) {
                     boolean var9;
                     int var10;
                     short var19;
                     if(Login.loginIndex == 2) {
                        var19 = 201;
                        var18 = var19 + 52;
                        if(var3 == 1 && var16 >= var18 - 12 && var16 < var18 + 2) {
                           Login.currentLoginField = 0;
                        }

                        var18 += 15;
                        if(var3 == 1 && var16 >= var18 - 12 && var16 < var18 + 2) {
                           Login.currentLoginField = 1;
                        }

                        var18 += 15;
                        var19 = 361;
                        if(TilePaint.__eb_ah != null) {
                           var7 = TilePaint.__eb_ah.__q / 2;
                           if(var3 == 1 && var15 >= TilePaint.__eb_ah.__m - var7 && var15 <= var7 + TilePaint.__eb_ah.__m && var16 >= var19 - 15 && var16 < var19) {
                              switch(Login.__cu_ac) {
                              case 1:
                                 method1089("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                                 Login.loginIndex = 5;
                                 return;
                              case 2:
                                 WorldMapCacheName.method635("https://support.runescape.com/hc/en-gb", true, false);
                              }
                           }
                        }

                        var7 = Varps.__hv_h - 80;
                        var8 = 321;
                        if(var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var16 >= var8 - 20 && var16 <= var8 + 20) {
                           Login.Login_username = Login.Login_username.trim();
                           if(Login.Login_username.length() == 0) {
                              method1089("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(Login.Login_password.length() == 0) {
                              method1089("", "Please enter your password.", "");
                              return;
                           }

                           method1089("", "Connecting to server...", "");
                           class15.method184(false);
                           GameShell.updateGameState(20);
                           return;
                        }

                        var7 = Login.__cu_y + 180 + 80;
                        if(var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var16 >= var8 - 20 && var16 <= var8 + 20) {
                           Login.loginIndex = 0;
                           Login.Login_username = "";
                           Login.Login_password = "";
                           class13.__i_af = 0;
                           Login.otp = "";
                           Login.__cu_ba = true;
                        }

                        var7 = Varps.__hv_h + -117;
                        var8 = 277;
                        Login.__cu_aa = var15 >= var7 && var15 < var7 + class168.__fs_au && var16 >= var8 && var16 < var8 + GroundItemPile.__dr_ao;
                        if(var3 == 1 && Login.__cu_aa) {
                           Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
                           if(!Client.Login_isUsernameRemembered && ReflectionCheck.clientPreferences.rememberedUsername != null) {
                              ReflectionCheck.clientPreferences.rememberedUsername = null;
                              WorldMapSection0.method247();
                           }
                        }

                        var7 = Varps.__hv_h + 24;
                        var8 = 277;
                        Login.__cu_ax = var15 >= var7 && var15 < var7 + class168.__fs_au && var16 >= var8 && var16 < var8 + GroundItemPile.__dr_ao;
                        if(var3 == 1 && Login.__cu_ax) {
                           ReflectionCheck.clientPreferences.hideUsername = !ReflectionCheck.clientPreferences.hideUsername;
                           if(!ReflectionCheck.clientPreferences.hideUsername) {
                              Login.Login_username = "";
                              ReflectionCheck.clientPreferences.rememberedUsername = null;
                              class196.method3740();
                           }

                           WorldMapSection0.method247();
                        }

                        while(true) {
                           while(Decimator.method2490()) {
                              var9 = false;

                              for(var10 = 0; var10 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var10) {
                                 if(GzipDecompressor.__go_ck == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var10)) {
                                    var9 = true;
                                    break;
                                 }
                              }

                              if(IndexStoreAction.__ik_cn == 13) {
                                 Login.loginIndex = 0;
                                 Login.Login_username = "";
                                 Login.Login_password = "";
                                 class13.__i_af = 0;
                                 Login.otp = "";
                                 Login.__cu_ba = true;
                              } else if(Login.currentLoginField == 0) {
                                 if(IndexStoreAction.__ik_cn == 85 && Login.Login_username.length() > 0) {
                                    Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                 }

                                 if(IndexStoreAction.__ik_cn == 84 || IndexStoreAction.__ik_cn == 80) {
                                    Login.currentLoginField = 1;
                                 }

                                 if(var9 && Login.Login_username.length() < 320) {
                                    Login.Login_username = Login.Login_username + GzipDecompressor.__go_ck;
                                 }
                              } else if(Login.currentLoginField == 1) {
                                 if(IndexStoreAction.__ik_cn == 85 && Login.Login_password.length() > 0) {
                                    Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
                                 }

                                 if(IndexStoreAction.__ik_cn == 84 || IndexStoreAction.__ik_cn == 80) {
                                    Login.currentLoginField = 0;
                                 }

                                 if(IndexStoreAction.__ik_cn == 84) {
                                    Login.Login_username = Login.Login_username.trim();
                                    if(Login.Login_username.length() == 0) {
                                       method1089("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(Login.Login_password.length() == 0) {
                                       method1089("", "Please enter your password.", "");
                                       return;
                                    }

                                    method1089("", "Connecting to server...", "");
                                    class15.method184(false);
                                    GameShell.updateGameState(20);
                                    return;
                                 }

                                 if(var9 && Login.Login_password.length() < 20) {
                                    Login.Login_password = Login.Login_password + GzipDecompressor.__go_ck;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(Login.loginIndex == 3) {
                        var18 = Login.__cu_y + 180;
                        var20 = 276;
                        if(var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
                           MouseHandler.method1084(false);
                        }

                        var18 = Login.__cu_y + 180;
                        var20 = 326;
                        if(var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
                           method1089("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           Login.loginIndex = 5;
                           return;
                        }
                     } else {
                        int var22;
                        if(Login.loginIndex == 4) {
                           var18 = Login.__cu_y + 180 - 80;
                           var20 = 321;
                           if(var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
                              Login.otp.trim();
                              if(Login.otp.length() != 6) {
                                 method1089("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class13.__i_af = Integer.parseInt(Login.otp);
                              Login.otp = "";
                              class15.method184(true);
                              method1089("", "Connecting to server...", "");
                              GameShell.updateGameState(20);
                              return;
                           }

                           if(var3 == 1 && var15 >= Login.__cu_y + 180 - 9 && var15 <= Login.__cu_y + 180 + 130 && var16 >= 263 && var16 <= 296) {
                              Login.__cu_ba = !Login.__cu_ba;
                           }

                           if(var3 == 1 && var15 >= Login.__cu_y + 180 - 34 && var15 <= Login.__cu_y + 34 + 180 && var16 >= 351 && var16 <= 363) {
                              WorldMapCacheName.method635(Message.method1227("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var18 = Login.__cu_y + 180 + 80;
                           if(var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
                              Login.loginIndex = 0;
                              Login.Login_username = "";
                              Login.Login_password = "";
                              class13.__i_af = 0;
                              Login.otp = "";
                           }

                           while(Decimator.method2490()) {
                              boolean var21 = false;

                              for(var22 = 0; var22 < "1234567890".length(); ++var22) {
                                 if(GzipDecompressor.__go_ck == "1234567890".charAt(var22)) {
                                    var21 = true;
                                    break;
                                 }
                              }

                              if(IndexStoreAction.__ik_cn == 13) {
                                 Login.loginIndex = 0;
                                 Login.Login_username = "";
                                 Login.Login_password = "";
                                 class13.__i_af = 0;
                                 Login.otp = "";
                              } else {
                                 if(IndexStoreAction.__ik_cn == 85 && Login.otp.length() > 0) {
                                    Login.otp = Login.otp.substring(0, Login.otp.length() - 1);
                                 }

                                 if(IndexStoreAction.__ik_cn == 84) {
                                    Login.otp.trim();
                                    if(Login.otp.length() != 6) {
                                       method1089("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class13.__i_af = Integer.parseInt(Login.otp);
                                    Login.otp = "";
                                    class15.method184(true);
                                    method1089("", "Connecting to server...", "");
                                    GameShell.updateGameState(20);
                                    return;
                                 }

                                 if(var21 && Login.otp.length() < 6) {
                                    Login.otp = Login.otp + GzipDecompressor.__go_ck;
                                 }
                              }
                           }
                        } else if(Login.loginIndex == 5) {
                           var18 = Login.__cu_y + 180 - 80;
                           var20 = 321;
                           if(var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
                              NpcDefinition.method5162();
                              return;
                           }

                           var18 = Login.__cu_y + 180 + 80;
                           if(var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
                              MouseHandler.method1084(true);
                           }

                           var8 = 361;
                           if(UrlRequester.__eo_ak != null) {
                              var22 = UrlRequester.__eo_ak.__q / 2;
                              if(var3 == 1 && var15 >= UrlRequester.__eo_ak.__m - var22 && var15 <= var22 + UrlRequester.__eo_ak.__m && var16 >= var8 - 15 && var16 < var8) {
                                 WorldMapCacheName.method635(Message.method1227("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
                              }
                           }

                           while(Decimator.method2490()) {
                              var9 = false;

                              for(var10 = 0; var10 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var10) {
                                 if(GzipDecompressor.__go_ck == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var10)) {
                                    var9 = true;
                                    break;
                                 }
                              }

                              if(IndexStoreAction.__ik_cn == 13) {
                                 MouseHandler.method1084(true);
                              } else {
                                 if(IndexStoreAction.__ik_cn == 85 && Login.Login_username.length() > 0) {
                                    Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
                                 }

                                 if(IndexStoreAction.__ik_cn == 84) {
                                    NpcDefinition.method5162();
                                    return;
                                 }

                                 if(var9 && Login.Login_username.length() < 320) {
                                    Login.Login_username = Login.Login_username + GzipDecompressor.__go_ck;
                                 }
                              }
                           }
                        } else if(Login.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!Decimator.method2490()) {
                                    var19 = 321;
                                    if(var3 == 1 && var16 >= var19 - 20 && var16 <= var19 + 20) {
                                       MouseHandler.method1084(true);
                                    }

                                    return;
                                 }
                              } while(IndexStoreAction.__ik_cn != 84 && IndexStoreAction.__ik_cn != 13);

                              MouseHandler.method1084(true);
                           }
                        } else if(Login.loginIndex == 7) {
                           var18 = Login.__cu_y + 180 - 80;
                           var20 = 321;
                           if(var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
                              WorldMapCacheName.method635(Message.method1227("secure", true) + "m=dob/set_dob.ws", true, false);
                              method1089("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                              Login.loginIndex = 6;
                              return;
                           }

                           var18 = Login.__cu_y + 180 + 80;
                           if(var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
                              MouseHandler.method1084(true);
                           }
                        } else if(Login.loginIndex == 8) {
                           var18 = Login.__cu_y + 180 - 80;
                           var20 = 321;
                           if(var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
                              WorldMapCacheName.method635("https://www.jagex.com/terms/privacy/#eight", true, false);
                              method1089("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                              Login.loginIndex = 6;
                              return;
                           }

                           var18 = Login.__cu_y + 180 + 80;
                           if(var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
                              MouseHandler.method1084(true);
                           }
                        } else if(Login.loginIndex == 12) {
                           String var14 = "";
                           switch(Login.__cu_aj) {
                           case 0:
                              var14 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
                              break;
                           case 1:
                              var14 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
                              break;
                           default:
                              MouseHandler.method1084(false);
                           }

                           var7 = Login.__cu_y + 180;
                           var8 = 276;
                           if(var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var16 >= var8 - 20 && var16 <= var8 + 20) {
                              WorldMapCacheName.method635(var14, true, false);
                              method1089("", "Page has opened in a new window.", "(Please check your popup blocker.)");
                              Login.loginIndex = 6;
                              return;
                           }

                           var7 = Login.__cu_y + 180;
                           var8 = 326;
                           if(var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var16 >= var8 - 20 && var16 <= var8 + 20) {
                              MouseHandler.method1084(false);
                           }
                        }
                     }
                  } else {
                     while(Decimator.method2490()) {
                        if(IndexStoreAction.__ik_cn == 84) {
                           MouseHandler.method1084(false);
                        } else if(IndexStoreAction.__ik_cn == 13) {
                           Login.loginIndex = 0;
                        }
                     }

                     var18 = Varps.__hv_h - 80;
                     var20 = 321;
                     if(var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
                        MouseHandler.method1084(false);
                     }

                     var18 = Varps.__hv_h + 80;
                     if(var3 == 1 && var15 >= var18 - 75 && var15 <= var18 + 75 && var16 >= var20 - 20 && var16 <= var20 + 20) {
                        Login.loginIndex = 0;
                     }
                  }
               }

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
      if(var0 == 6600) {
         var3 = SoundSystem.plane;
         int var9 = (Canvas.localPlayer.x >> 7) + class50.baseX;
         int var5 = (Canvas.localPlayer.y >> 7) + GraphicsObject.baseY;
         BufferedFile.worldMap().__a_525(var3, var9, var5, true);
         return 1;
      } else {
         WorldMapArea var11;
         if(var0 == 6601) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            String var16 = "";
            var11 = BufferedFile.worldMap().getMapArea(var3);
            if(var11 != null) {
               var16 = var11.name();
            }

            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var16;
            return 1;
         } else if(var0 == 6602) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            BufferedFile.worldMap().setCurrentMapAreaId(var3);
            return 1;
         } else if(var0 == 6603) {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = BufferedFile.worldMap().getZoomLevel();
            return 1;
         } else if(var0 == 6604) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            BufferedFile.worldMap().setZoomLevel(var3);
            return 1;
         } else if(var0 == 6605) {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = BufferedFile.worldMap().isCacheLoaded()?1:0;
            return 1;
         } else {
            TileLocation var15;
            if(var0 == 6606) {
               var15 = new TileLocation(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
               BufferedFile.worldMap().setWorldMapPositionTarget(var15.x, var15.y);
               return 1;
            } else if(var0 == 6607) {
               var15 = new TileLocation(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
               BufferedFile.worldMap().__aw_531(var15.x, var15.y);
               return 1;
            } else if(var0 == 6608) {
               var15 = new TileLocation(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
               BufferedFile.worldMap().__al_532(var15.plane, var15.x, var15.y);
               return 1;
            } else if(var0 == 6609) {
               var15 = new TileLocation(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
               BufferedFile.worldMap().__ab_533(var15.plane, var15.x, var15.y);
               return 1;
            } else if(var0 == 6610) {
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = BufferedFile.worldMap().__ae_534();
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = BufferedFile.worldMap().__at_535();
               return 1;
            } else {
               WorldMapArea var13;
               if(var0 == 6611) {
                  var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var13 = BufferedFile.worldMap().getMapArea(var3);
                  if(var13 == null) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var13.origin().packed();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var13 = BufferedFile.worldMap().getMapArea(var3);
                  if(var13 == null) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = (var13.maxX() - var13.minX() + 1) * 64;
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = (var13.maxY() - var13.minY() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var13 = BufferedFile.worldMap().getMapArea(var3);
                  if(var13 == null) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var13.minX() * 64;
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var13.minY() * 64;
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var13.maxX() * 64 + 64 - 1;
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var13.maxY() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                  var13 = BufferedFile.worldMap().getMapArea(var3);
                  if(var13 == null) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var13.zoom();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var15 = BufferedFile.worldMap().__ad_536();
                  if(var15 == null) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var15.x;
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var15.y;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = BufferedFile.worldMap().currentMapAreaId();
                  return 1;
               } else if(var0 == 6617) {
                  var15 = new TileLocation(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
                  var13 = BufferedFile.worldMap().getCurrentMapArea();
                  if(var13 == null) {
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var14 = var13.position(var15.plane, var15.x, var15.y);
                     if(var14 == null) {
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                     } else {
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var14[0];
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var14[1];
                     }

                     return 1;
                  }
               } else {
                  TileLocation var7;
                  if(var0 == 6618) {
                     var15 = new TileLocation(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
                     var13 = BufferedFile.worldMap().getCurrentMapArea();
                     if(var13 == null) {
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var7 = var13.coord(var15.x, var15.y);
                        if(var7 == null) {
                           Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                        } else {
                           Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var7.packed();
                        }

                        return 1;
                     }
                  } else {
                     TileLocation var12;
                     if(var0 == 6619) {
                        class179.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                        var12 = new TileLocation(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]);
                        TotalQuantityComparator.method96(var3, var12, false);
                        return 1;
                     } else if(var0 == 6620) {
                        class179.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                        var12 = new TileLocation(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]);
                        TotalQuantityComparator.method96(var3, var12, true);
                        return 1;
                     } else if(var0 == 6621) {
                        class179.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                        var12 = new TileLocation(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]);
                        var11 = BufferedFile.worldMap().getMapArea(var3);
                        if(var11 == null) {
                           Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
                           return 1;
                        } else {
                           Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var11.containsCoord(var12.plane, var12.x, var12.y)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = BufferedFile.worldMap().__ap_537();
                        Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = BufferedFile.worldMap().__as_538();
                        return 1;
                     } else if(var0 == 6623) {
                        var15 = new TileLocation(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
                        var13 = BufferedFile.worldMap().mapAreaAtCoord(var15.plane, var15.x, var15.y);
                        if(var13 == null) {
                           Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                        } else {
                           Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var13.id();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        BufferedFile.worldMap().__am_539(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        BufferedFile.worldMap().__an_540();
                        return 1;
                     } else if(var0 == 6626) {
                        BufferedFile.worldMap().__az_541(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        BufferedFile.worldMap().__au_542();
                        return 1;
                     } else {
                        boolean var10;
                        if(var0 == 6628) {
                           var10 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                           BufferedFile.worldMap().perpetualFlash(var10);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                           BufferedFile.worldMap().flashElement(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                           BufferedFile.worldMap().flashCategory(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           BufferedFile.worldMap().stopCurrentFlashes();
                           return 1;
                        } else if(var0 == 6632) {
                           var10 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
                           BufferedFile.worldMap().setElementsEnabled(var10);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              class179.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                              var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1] == 1;
                              BufferedFile.worldMap().disableElement(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              class179.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                              var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1] == 1;
                              BufferedFile.worldMap().disableCategory(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = BufferedFile.worldMap().getElementsEnabled()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                              Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = BufferedFile.worldMap().isElementDisabled(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                              Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = BufferedFile.worldMap().isCategoryDisabled(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              class179.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
                              var12 = new TileLocation(Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1]);
                              var7 = BufferedFile.worldMap().__bc_545(var3, var12);
                              if(var7 == null) {
                                 Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                              } else {
                                 Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var7.packed();
                              }

                              return 1;
                           } else {
                              AbstractWorldMapIcon var8;
                              if(var0 == 6639) {
                                 var8 = BufferedFile.worldMap().iconStart();
                                 if(var8 == null) {
                                    Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                                    Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                                 } else {
                                    Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var8.__m_15();
                                    Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var8.coord2.packed();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var8 = BufferedFile.worldMap().iconNext();
                                 if(var8 == null) {
                                    Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                                    Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                                 } else {
                                    Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var8.__m_15();
                                    Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var8.coord2.packed();
                                 }

                                 return 1;
                              } else {
                                 WorldMapElement var6;
                                 if(var0 == 6693) {
                                    var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                                    var6 = ViewportMouse.getWorldMapElement(var3);
                                    if(var6.__l == null) {
                                       Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                                    } else {
                                       Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6.__l;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                                    var6 = ViewportMouse.getWorldMapElement(var3);
                                    Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var6.textSize;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                                    var6 = ViewportMouse.getWorldMapElement(var3);
                                    if(var6 == null) {
                                       Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                                    } else {
                                       Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var6.category;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
                                    var6 = ViewportMouse.getWorldMapElement(var3);
                                    if(var6 == null) {
                                       Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
                                    } else {
                                       Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var6.sprite1;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class15.worldMapEvent.mapElement;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class15.worldMapEvent.coord1.packed();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = class15.worldMapEvent.coord2.packed();
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
      if(Client.oculusOrbState == 0) {
         var0 = Canvas.localPlayer.x;
         var1 = Canvas.localPlayer.y;
         if(MouseHandler.oculusOrbFocalPointX - var0 < -500 || MouseHandler.oculusOrbFocalPointX - var0 > 500 || ScriptEvent.oculusOrbFocalPointY - var1 < -500 || ScriptEvent.oculusOrbFocalPointY - var1 > 500) {
            MouseHandler.oculusOrbFocalPointX = var0;
            ScriptEvent.oculusOrbFocalPointY = var1;
         }

         if(var0 != MouseHandler.oculusOrbFocalPointX) {
            MouseHandler.oculusOrbFocalPointX += (var0 - MouseHandler.oculusOrbFocalPointX) / 16;
         }

         if(var1 != ScriptEvent.oculusOrbFocalPointY) {
            ScriptEvent.oculusOrbFocalPointY += (var1 - ScriptEvent.oculusOrbFocalPointY) / 16;
         }

         var2 = MouseHandler.oculusOrbFocalPointX >> 7;
         var3 = ScriptEvent.oculusOrbFocalPointY >> 7;
         var4 = class32.getTileHeight(MouseHandler.oculusOrbFocalPointX, ScriptEvent.oculusOrbFocalPointY, SoundSystem.plane);
         var5 = 0;
         int var6;
         if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
            for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
               for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
                  int var8 = SoundSystem.plane;
                  if(var8 < 3 && (Tiles.Tiles_renderFlags[1][var6][var7] & 2) == 2) {
                     ++var8;
                  }

                  int var9 = var4 - Tiles.Tiles_heights[var8][var6][var7];
                  if(var9 > var5) {
                     var5 = var9;
                  }
               }
            }
         }

         var6 = var5 * 192;
         if(var6 > 98048) {
            var6 = 98048;
         }

         if(var6 < 32768) {
            var6 = 32768;
         }

         if(var6 > Client.__client_ik) {
            Client.__client_ik += (var6 - Client.__client_ik) / 24;
         } else if(var6 < Client.__client_ik) {
            Client.__client_ik += (var6 - Client.__client_ik) / 80;
         }

         MouseRecorder.__bu_hy = class32.getTileHeight(Canvas.localPlayer.x, Canvas.localPlayer.y, SoundSystem.plane) - Client.cameraFollowHeight;
      } else if(Client.oculusOrbState == 1) {
         if(Client.__client_ij && Canvas.localPlayer != null) {
            var0 = Canvas.localPlayer.pathX[0];
            var1 = Canvas.localPlayer.pathY[0];
            if(var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
               MouseHandler.oculusOrbFocalPointX = Canvas.localPlayer.x;
               var2 = class32.getTileHeight(Canvas.localPlayer.x, Canvas.localPlayer.y, SoundSystem.plane) - Client.cameraFollowHeight;
               if(var2 < MouseRecorder.__bu_hy) {
                  MouseRecorder.__bu_hy = var2;
               }

               ScriptEvent.oculusOrbFocalPointY = Canvas.localPlayer.y;
               Client.__client_ij = false;
            }
         }

         short var10 = -1;
         if(KeyHandler.KeyHandler_pressedKeys[33]) {
            var10 = 0;
         } else if(KeyHandler.KeyHandler_pressedKeys[49]) {
            var10 = 1024;
         }

         if(KeyHandler.KeyHandler_pressedKeys[48]) {
            if(var10 == 0) {
               var10 = 1792;
            } else if(var10 == 1024) {
               var10 = 1280;
            } else {
               var10 = 1536;
            }
         } else if(KeyHandler.KeyHandler_pressedKeys[50]) {
            if(var10 == 0) {
               var10 = 256;
            } else if(var10 == 1024) {
               var10 = 768;
            } else {
               var10 = 512;
            }
         }

         byte var11 = 0;
         if(KeyHandler.KeyHandler_pressedKeys[35]) {
            var11 = -1;
         } else if(KeyHandler.KeyHandler_pressedKeys[51]) {
            var11 = 1;
         }

         var2 = 0;
         if(var10 >= 0 || var11 != 0) {
            var2 = KeyHandler.KeyHandler_pressedKeys[81]?Client.__client_in:Client.oculusOrbNormalSpeed;
            var2 *= 16;
            Client.__client_hk = var10;
            Client.__client_if = var11;
         }

         if(Client.__client_hc < var2) {
            Client.__client_hc += var2 / 8;
            if(Client.__client_hc > var2) {
               Client.__client_hc = var2;
            }
         } else if(Client.__client_hc > var2) {
            Client.__client_hc = Client.__client_hc * 9 / 10;
         }

         if(Client.__client_hc > 0) {
            var3 = Client.__client_hc / 16;
            if(Client.__client_hk >= 0) {
               var0 = Client.__client_hk - MusicPatchNode.cameraYaw & 2047;
               var4 = Rasterizer3D.Rasterizer3D_sine[var0];
               var5 = Rasterizer3D.Rasterizer3D_cosine[var0];
               MouseHandler.oculusOrbFocalPointX += var3 * var4 / 65536;
               ScriptEvent.oculusOrbFocalPointY += var3 * var5 / 65536;
            }

            if(Client.__client_if != 0) {
               MouseRecorder.__bu_hy += var3 * Client.__client_if;
               if(MouseRecorder.__bu_hy > 0) {
                  MouseRecorder.__bu_hy = 0;
               }
            }
         } else {
            Client.__client_hk = -1;
            Client.__client_if = -1;
         }

         if(KeyHandler.KeyHandler_pressedKeys[13]) {
            Client.packetWriter.__q_167(Interpreter.method1915(ClientPacket.__gs_ab, Client.packetWriter.isaacCipher));
            Client.oculusOrbState = 0;
         }
      }

      if(MouseHandler.MouseHandler_currentButton == 4 && AbstractRasterProvider.__lp_ca) {
         var0 = MouseHandler.MouseHandler_y - Client.__client_ht;
         Client.__client_hu = var0 * 2;
         Client.__client_ht = var0 != -1 && var0 != 1?(MouseHandler.MouseHandler_y + Client.__client_ht) / 2:MouseHandler.MouseHandler_y;
         var1 = Client.__client_hi - MouseHandler.MouseHandler_x;
         Client.__client_hv = var1 * 2;
         Client.__client_hi = var1 != -1 && var1 != 1?(Client.__client_hi + MouseHandler.MouseHandler_x) / 2:MouseHandler.MouseHandler_x;
      } else {
         if(KeyHandler.KeyHandler_pressedKeys[96]) {
            Client.__client_hv += (-24 - Client.__client_hv) / 2;
         } else if(KeyHandler.KeyHandler_pressedKeys[97]) {
            Client.__client_hv += (24 - Client.__client_hv) / 2;
         } else {
            Client.__client_hv /= 2;
         }

         if(KeyHandler.KeyHandler_pressedKeys[98]) {
            Client.__client_hu += (12 - Client.__client_hu) / 2;
         } else if(KeyHandler.KeyHandler_pressedKeys[99]) {
            Client.__client_hu += (-12 - Client.__client_hu) / 2;
         } else {
            Client.__client_hu /= 2;
         }

         Client.__client_ht = MouseHandler.MouseHandler_y;
         Client.__client_hi = MouseHandler.MouseHandler_x;
      }

      Client.minimapOrientation = Client.__client_hv / 2 + Client.minimapOrientation & 2047;
      Client.cameraPitchTarget += Client.__client_hu / 2;
      if(Client.cameraPitchTarget < 128) {
         Client.cameraPitchTarget = 128;
      }

      if(Client.cameraPitchTarget > 383) {
         Client.cameraPitchTarget = 383;
      }

   }
}
