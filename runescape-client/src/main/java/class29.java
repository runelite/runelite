import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public final class class29 {
   @ObfuscatedName("fl")
   @Export("region")
   static Region region;
   // $FF: synthetic field
   final class41 this$0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -515939039
   )
   int field417;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 126890519
   )
   int field412;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1351124103
   )
   int field414;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1308811183
   )
   int field413;

   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "-276361538"
   )
   static void method239(GameEngine var0) {
      int var1;
      int var10;
      int var11;
      int var13;
      if(class92.worldSelectShown) {
         if(MouseInput.field728 == 1 || !class33.field461 && MouseInput.field728 == 4) {
            var1 = class92.field1436 + 280;
            if(MouseInput.field735 >= var1 && MouseInput.field735 <= var1 + 14 && MouseInput.field730 >= 4 && MouseInput.field730 <= 18) {
               method240(0, 0);
            } else if(MouseInput.field735 >= var1 + 15 && MouseInput.field735 <= var1 + 80 && MouseInput.field730 >= 4 && MouseInput.field730 <= 18) {
               method240(0, 1);
            } else {
               var10 = class92.field1436 + 390;
               if(MouseInput.field735 >= var10 && MouseInput.field735 <= var10 + 14 && MouseInput.field730 >= 4 && MouseInput.field730 <= 18) {
                  method240(1, 0);
               } else if(MouseInput.field735 >= var10 + 15 && MouseInput.field735 <= var10 + 80 && MouseInput.field730 >= 4 && MouseInput.field730 <= 18) {
                  method240(1, 1);
               } else {
                  var11 = class92.field1436 + 500;
                  if(MouseInput.field735 >= var11 && MouseInput.field735 <= var11 + 14 && MouseInput.field730 >= 4 && MouseInput.field730 <= 18) {
                     method240(2, 0);
                  } else if(MouseInput.field735 >= var11 + 15 && MouseInput.field735 <= var11 + 80 && MouseInput.field730 >= 4 && MouseInput.field730 <= 18) {
                     method240(2, 1);
                  } else {
                     var13 = class92.field1436 + 610;
                     if(MouseInput.field735 >= var13 && MouseInput.field735 <= var13 + 14 && MouseInput.field730 >= 4 && MouseInput.field730 <= 18) {
                        method240(3, 0);
                     } else if(MouseInput.field735 >= var13 + 15 && MouseInput.field735 <= var13 + 80 && MouseInput.field730 >= 4 && MouseInput.field730 <= 18) {
                        method240(3, 1);
                     } else if(MouseInput.field735 >= class92.field1436 + 708 && MouseInput.field730 >= 4 && MouseInput.field735 <= class92.field1436 + 708 + 50 && MouseInput.field730 <= 20) {
                        class92.worldSelectShown = false;
                        XItemContainer.field781.method4981(class92.field1436, 0);
                        class8.field245.method4981(class92.field1436 + 382, 0);
                        class157.logoSprite.method4952(class92.field1436 + 382 - class157.logoSprite.originalWidth / 2, 18);
                     } else if(class92.field1448 != -1) {
                        World var5 = World.worldList[class92.field1448];
                        class31.method276(var5);
                        class92.worldSelectShown = false;
                        XItemContainer.field781.method4981(class92.field1436, 0);
                        class8.field245.method4981(class92.field1436 + 382, 0);
                        class157.logoSprite.method4952(class92.field1436 + 382 - class157.logoSprite.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((MouseInput.field728 == 1 || !class33.field461 && MouseInput.field728 == 4) && MouseInput.field735 >= class92.field1436 + 765 - 50 && MouseInput.field730 >= 453) {
            class23.preferences.muted = !class23.preferences.muted;
            PendingSpawn.method1475();
            if(!class23.preferences.muted) {
               FileOnDisk.method2367(class182.indexTrack1, "scape main", "", 255, false);
            } else {
               class203.field2500.method3703();
               class203.field2501 = 1;
               class203.field2502 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class92.field1429;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.languageId == 0) {
                  if(MouseInput.field728 == 1 || !class33.field461 && MouseInput.field728 == 4) {
                     var1 = class92.field1436 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(MouseInput.field735 >= var1 && MouseInput.field735 <= var1 + var3 && MouseInput.field730 >= var2 && MouseInput.field730 <= var4 + var2) {
                        World.method1560();
                        return;
                     }
                  }

                  if(class112.worldServersDownload != null) {
                     World.method1560();
                  }
               }

               var1 = MouseInput.field728;
               var10 = MouseInput.field735;
               var11 = MouseInput.field730;
               if(!class33.field461 && var1 == 4) {
                  var1 = 1;
               }

               short var6;
               int var9;
               if(class92.loginIndex == 0) {
                  boolean var12 = false;

                  while(class112.method2078()) {
                     if(KeyFocusListener.field627 == 84) {
                        var12 = true;
                     }
                  }

                  var9 = class92.loginWindowX + 180 - 80;
                  var6 = 291;
                  if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                     class36.method485(WidgetNode.method1089("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var9 = class92.loginWindowX + 180 + 80;
                  if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20 || var12) {
                     if((Client.flags & 33554432) != 0) {
                        class92.field1434 = "";
                        class92.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class92.loginMessage2 = "Your normal account will not be affected.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class92.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class92.loginMessage2 = "Players can attack each other almost everywhere";
                           class92.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class92.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class92.loginMessage2 = "Players can attack each other";
                           class92.loginMessage3 = "almost everywhere.";
                        }

                        class92.field1434 = "Warning!";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class92.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class92.loginMessage2 = "The Protect Item prayer will";
                        class92.loginMessage3 = "not work on this world.";
                        class92.field1434 = "Warning!";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else {
                        class92.loginMessage1 = "";
                        class92.loginMessage2 = "Enter your username/email & password.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 2;
                        class92.loginIndex2 = 0;
                     }
                  }
               } else {
                  short var17;
                  if(class92.loginIndex != 1) {
                     short var14;
                     if(class92.loginIndex == 2) {
                        var14 = 231;
                        var13 = var14 + 30;
                        if(var1 == 1 && var11 >= var13 - 15 && var11 < var13) {
                           class92.loginIndex2 = 0;
                        }

                        var13 += 15;
                        if(var1 == 1 && var11 >= var13 - 15 && var11 < var13) {
                           class92.loginIndex2 = 1;
                        }

                        var13 += 15;
                        var14 = 361;
                        if(var1 == 1 && var11 >= var14 - 15 && var11 < var14) {
                           class2.method6("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }

                        var9 = class92.loginWindowX + 180 - 80;
                        var6 = 321;
                        if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class92.username = class92.username.trim();
                           if(class92.username.length() == 0) {
                              class2.method6("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class92.password.length() == 0) {
                              class2.method6("", "Please enter your password.", "");
                              return;
                           }

                           class2.method6("", "Connecting to server...", "");
                           class92.field1430 = class23.preferences.preferences.containsKey(Integer.valueOf(class232.method4077(class92.username)))?class149.field2194:class149.field2189;
                           WorldMapType2.setGameState(20);
                           return;
                        }

                        var9 = class92.loginWindowX + 180 + 80;
                        if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class92.loginIndex = 0;
                           class92.username = "";
                           class92.password = "";
                           class3.authCodeForLogin = 0;
                           WallObject.authCode = "";
                           class92.field1446 = true;
                        }

                        while(true) {
                           while(class112.method2078()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class203.field2510 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(KeyFocusListener.field627 == 13) {
                                 class92.loginIndex = 0;
                                 class92.username = "";
                                 class92.password = "";
                                 class3.authCodeForLogin = 0;
                                 WallObject.authCode = "";
                                 class92.field1446 = true;
                              } else if(class92.loginIndex2 == 0) {
                                 if(KeyFocusListener.field627 == 85 && class92.username.length() > 0) {
                                    class92.username = class92.username.substring(0, class92.username.length() - 1);
                                 }

                                 if(KeyFocusListener.field627 == 84 || KeyFocusListener.field627 == 80) {
                                    class92.loginIndex2 = 1;
                                 }

                                 if(var7 && class92.username.length() < 320) {
                                    class92.username = class92.username + class203.field2510;
                                 }
                              } else if(class92.loginIndex2 == 1) {
                                 if(KeyFocusListener.field627 == 85 && class92.password.length() > 0) {
                                    class92.password = class92.password.substring(0, class92.password.length() - 1);
                                 }

                                 if(KeyFocusListener.field627 == 84 || KeyFocusListener.field627 == 80) {
                                    class92.loginIndex2 = 0;
                                 }

                                 if(KeyFocusListener.field627 == 84) {
                                    class92.username = class92.username.trim();
                                    if(class92.username.length() == 0) {
                                       class2.method6("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class92.password.length() == 0) {
                                       class2.method6("", "Please enter your password.", "");
                                       return;
                                    }

                                    class2.method6("", "Connecting to server...", "");
                                    class92.field1430 = class23.preferences.preferences.containsKey(Integer.valueOf(class232.method4077(class92.username)))?class149.field2194:class149.field2189;
                                    WorldMapType2.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class92.password.length() < 20) {
                                    class92.password = class92.password + class203.field2510;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class92.loginIndex == 3) {
                        var13 = class92.loginWindowX + 180;
                        var17 = 276;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        }

                        var13 = class92.loginWindowX + 180;
                        var17 = 326;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                           class2.method6("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var15;
                        int var16;
                        if(class92.loginIndex == 4) {
                           var13 = class92.loginWindowX + 180 - 80;
                           var17 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              WallObject.authCode.trim();
                              if(WallObject.authCode.length() != 6) {
                                 class2.method6("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class3.authCodeForLogin = Integer.parseInt(WallObject.authCode);
                              WallObject.authCode = "";
                              class92.field1430 = class92.field1446?class149.field2190:class149.field2192;
                              class2.method6("", "Connecting to server...", "");
                              WorldMapType2.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var10 >= class92.loginWindowX + 180 - 9 && var10 <= class92.loginWindowX + 180 + 130 && var11 >= 263 && var11 <= 296) {
                              class92.field1446 = !class92.field1446;
                           }

                           if(var1 == 1 && var10 >= class92.loginWindowX + 180 - 34 && var10 <= 180 + class92.loginWindowX + 34 && var11 >= 351 && var11 <= 363) {
                              class36.method485(WidgetNode.method1089("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var13 = class92.loginWindowX + 180 + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              class92.loginIndex = 0;
                              class92.username = "";
                              class92.password = "";
                              class3.authCodeForLogin = 0;
                              WallObject.authCode = "";
                           }

                           while(class112.method2078()) {
                              var15 = false;

                              for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                                 if(class203.field2510 == "1234567890".charAt(var16)) {
                                    var15 = true;
                                    break;
                                 }
                              }

                              if(KeyFocusListener.field627 == 13) {
                                 class92.loginIndex = 0;
                                 class92.username = "";
                                 class92.password = "";
                                 class3.authCodeForLogin = 0;
                                 WallObject.authCode = "";
                              } else {
                                 if(KeyFocusListener.field627 == 85 && WallObject.authCode.length() > 0) {
                                    WallObject.authCode = WallObject.authCode.substring(0, WallObject.authCode.length() - 1);
                                 }

                                 if(KeyFocusListener.field627 == 84) {
                                    WallObject.authCode.trim();
                                    if(WallObject.authCode.length() != 6) {
                                       class2.method6("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class3.authCodeForLogin = Integer.parseInt(WallObject.authCode);
                                    WallObject.authCode = "";
                                    class92.field1430 = class92.field1446?class149.field2190:class149.field2192;
                                    class2.method6("", "Connecting to server...", "");
                                    WorldMapType2.setGameState(20);
                                    return;
                                 }

                                 if(var15 && WallObject.authCode.length() < 6) {
                                    WallObject.authCode = WallObject.authCode + class203.field2510;
                                 }
                              }
                           }
                        } else if(class92.loginIndex == 5) {
                           var13 = class92.loginWindowX + 180 - 80;
                           var17 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              class87.method1681();
                              return;
                           }

                           var13 = class92.loginWindowX + 180 + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              class92.loginMessage1 = "";
                              class92.loginMessage2 = "Enter your username/email & password.";
                              class92.loginMessage3 = "";
                              class92.loginIndex = 2;
                              class92.loginIndex2 = 0;
                              class92.password = "";
                           }

                           while(class112.method2078()) {
                              var15 = false;

                              for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                                 if(class203.field2510 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                    var15 = true;
                                    break;
                                 }
                              }

                              if(KeyFocusListener.field627 == 13) {
                                 class92.loginMessage1 = "";
                                 class92.loginMessage2 = "Enter your username/email & password.";
                                 class92.loginMessage3 = "";
                                 class92.loginIndex = 2;
                                 class92.loginIndex2 = 0;
                                 class92.password = "";
                              } else {
                                 if(KeyFocusListener.field627 == 85 && class92.username.length() > 0) {
                                    class92.username = class92.username.substring(0, class92.username.length() - 1);
                                 }

                                 if(KeyFocusListener.field627 == 84) {
                                    class87.method1681();
                                    return;
                                 }

                                 if(var15 && class92.username.length() < 320) {
                                    class92.username = class92.username + class203.field2510;
                                 }
                              }
                           }
                        } else if(class92.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class112.method2078()) {
                                    var14 = 321;
                                    if(var1 == 1 && var11 >= var14 - 20 && var11 <= var14 + 20) {
                                       class92.loginMessage1 = "";
                                       class92.loginMessage2 = "Enter your username/email & password.";
                                       class92.loginMessage3 = "";
                                       class92.loginIndex = 2;
                                       class92.loginIndex2 = 0;
                                       class92.password = "";
                                    }

                                    return;
                                 }
                              } while(KeyFocusListener.field627 != 84 && KeyFocusListener.field627 != 13);

                              class92.loginMessage1 = "";
                              class92.loginMessage2 = "Enter your username/email & password.";
                              class92.loginMessage3 = "";
                              class92.loginIndex = 2;
                              class92.loginIndex2 = 0;
                              class92.password = "";
                           }
                        }
                     }
                  } else {
                     while(class112.method2078()) {
                        if(KeyFocusListener.field627 == 84) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        } else if(KeyFocusListener.field627 == 13) {
                           class92.loginIndex = 0;
                        }
                     }

                     var13 = class92.loginWindowX + 180 - 80;
                     var17 = 321;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                        class92.loginMessage1 = "";
                        class92.loginMessage2 = "Enter your username/email & password.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 2;
                        class92.loginIndex2 = 0;
                     }

                     var13 = class92.loginWindowX + 180 + 80;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                        class92.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-76"
   )
   static void method240(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1303[var5] != var0) {
            var2[var4] = World.field1303[var5];
            var3[var4] = World.field1288[var5];
            ++var4;
         }
      }

      World.field1303 = var2;
      World.field1288 = var3;
      PacketBuffer.method3403(World.worldList, 0, World.worldList.length - 1, World.field1303, World.field1288);
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "-116828835"
   )
   static final void method238(class66 var0) {
      if(Script.localPlayer.x >> 7 == Client.destinationX && Script.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      int var1 = class96.field1499;
      int[] var2 = class96.field1492;
      int var3 = var1;
      if(class66.field809 == var0 || class66.field808 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class66.field809 == var0) {
            var5 = Script.localPlayer;
            var6 = Script.localPlayer.field870 << 14;
         } else if(class66.field808 == var0) {
            var5 = Client.cachedPlayers[Client.field925];
            var6 = Client.field925 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class66.field811 == var0 && var2[var4] == Client.field925) {
               continue;
            }
         }

         if(var5 != null && var5.hasConfig() && !var5.hidden) {
            var5.field869 = false;
            if((Client.lowMemory && var1 > 50 || var1 > 200) && class66.field809 != var0 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field869 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.field878 && Client.gameCycle < var5.field884) {
                  var5.field869 = false;
                  var5.field886 = Actor.getTileHeight(var5.x, var5.y, class45.plane);
                  region.method2678(class45.plane, var5.x, var5.y, var5.field886, 60, var5, var5.angle, var6, var5.field882, var5.field883, var5.field867, var5.field885);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field1009[var7][var8] == Client.field1010) {
                        continue;
                     }

                     Client.field1009[var7][var8] = Client.field1010;
                  }

                  var5.field886 = Actor.getTileHeight(var5.x, var5.y, class45.plane);
                  region.method2677(class45.plane, var5.x, var5.y, var5.field886, 60, var5, var5.angle, var6, var5.field1217);
               }
            }
         }
      }

   }
}
