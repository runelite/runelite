import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("g")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1945507889
   )
   @Export("y")
   int y;
   @ObfuscatedName("q")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -121331845
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("v")
   @Export("top")
   Renderable top;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 644847143
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 217616687
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1506914611
   )
   @Export("height")
   int height;
   @ObfuscatedName("ap")
   @Export("authCode")
   static String authCode;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "-1416179403"
   )
   static void method2439(GameEngine var0) {
      int var1;
      int var10;
      int var11;
      int var13;
      if(class92.worldSelectShown) {
         if(class59.field727 == 1 || !class149.field2178 && class59.field727 == 4) {
            var1 = class92.field1416 + 280;
            if(class59.field717 >= var1 && class59.field717 <= var1 + 14 && class59.field729 >= 4 && class59.field729 <= 18) {
               class35.method495(0, 0);
            } else if(class59.field717 >= var1 + 15 && class59.field717 <= var1 + 80 && class59.field729 >= 4 && class59.field729 <= 18) {
               class35.method495(0, 1);
            } else {
               var10 = class92.field1416 + 390;
               if(class59.field717 >= var10 && class59.field717 <= var10 + 14 && class59.field729 >= 4 && class59.field729 <= 18) {
                  class35.method495(1, 0);
               } else if(class59.field717 >= var10 + 15 && class59.field717 <= var10 + 80 && class59.field729 >= 4 && class59.field729 <= 18) {
                  class35.method495(1, 1);
               } else {
                  var11 = class92.field1416 + 500;
                  if(class59.field717 >= var11 && class59.field717 <= var11 + 14 && class59.field729 >= 4 && class59.field729 <= 18) {
                     class35.method495(2, 0);
                  } else if(class59.field717 >= var11 + 15 && class59.field717 <= var11 + 80 && class59.field729 >= 4 && class59.field729 <= 18) {
                     class35.method495(2, 1);
                  } else {
                     var13 = class92.field1416 + 610;
                     if(class59.field717 >= var13 && class59.field717 <= var13 + 14 && class59.field729 >= 4 && class59.field729 <= 18) {
                        class35.method495(3, 0);
                     } else if(class59.field717 >= var13 + 15 && class59.field717 <= var13 + 80 && class59.field729 >= 4 && class59.field729 <= 18) {
                        class35.method495(3, 1);
                     } else if(class59.field717 >= class92.field1416 + 708 && class59.field729 >= 4 && class59.field717 <= class92.field1416 + 708 + 50 && class59.field729 <= 20) {
                        class92.worldSelectShown = false;
                        class92.field1429.method5130(class92.field1416, 0);
                        class269.field3672.method5130(class92.field1416 + 382, 0);
                        class268.field3670.method5101(class92.field1416 + 382 - class268.field3670.originalWidth / 2, 18);
                     } else if(class92.field1446 != -1) {
                        World var9 = World.worldList[class92.field1446];
                        class87.method1738(var9);
                        class92.worldSelectShown = false;
                        class92.field1429.method5130(class92.field1416, 0);
                        class269.field3672.method5130(class92.field1416 + 382, 0);
                        class268.field3670.method5101(class92.field1416 + 382 - class268.field3670.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class59.field727 == 1 || !class149.field2178 && class59.field727 == 4) && class59.field717 >= class92.field1416 + 765 - 50 && class59.field729 >= 453) {
            class134.field1989.field1285 = !class134.field1989.field1285;
            GroundObject.method2523();
            if(!class134.field1989.field1285) {
               TextureProvider.method2414(class44.indexTrack1, "scape main", "", 255, false);
            } else {
               class36.field501.method3801();
               class203.field2498 = 1;
               Varbit.field3380 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class92.field1445;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.field896 == 0) {
                  if(class59.field727 == 1 || !class149.field2178 && class59.field727 == 4) {
                     var1 = class92.field1416 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class59.field717 >= var1 && class59.field717 <= var1 + var3 && class59.field729 >= var2 && class59.field729 <= var4 + var2) {
                        class17.method121();
                        return;
                     }
                  }

                  if(World.worldServersDownload != null) {
                     class17.method121();
                  }
               }

               var1 = class59.field727;
               var10 = class59.field717;
               var11 = class59.field729;
               if(!class149.field2178 && var1 == 4) {
                  var1 = 1;
               }

               int var5;
               short var6;
               if(class92.loginIndex == 0) {
                  boolean var12 = false;

                  while(class14.method69()) {
                     if(class50.field625 == 84) {
                        var12 = true;
                     }
                  }

                  var5 = class92.loginWindowX + 180 - 80;
                  var6 = 291;
                  if(var1 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                     class11.method47(class26.method179("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var5 = class92.loginWindowX + 180 + 80;
                  if(var1 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20 || var12) {
                     if((Client.flags & 33554432) != 0) {
                        class92.field1428 = "";
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

                        class92.field1428 = "Warning!";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class92.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class92.loginMessage2 = "The Protect Item prayer will";
                        class92.loginMessage3 = "not work on this world.";
                        class92.field1428 = "Warning!";
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
                  short var15;
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
                           Buffer.method3383("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }

                        var5 = class92.loginWindowX + 180 - 80;
                        var6 = 321;
                        if(var1 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class92.username = class92.username.trim();
                           if(class92.username.length() == 0) {
                              Buffer.method3383("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class92.password.length() == 0) {
                              Buffer.method3383("", "Please enter your password.", "");
                              return;
                           }

                           Buffer.method3383("", "Connecting to server...", "");
                           class92.field1436 = class134.field1989.preferences.containsKey(Integer.valueOf(class228.method4154(class92.username)))?class149.field2181:class149.field2179;
                           class12.setGameState(20);
                           return;
                        }

                        var5 = class92.loginWindowX + 180 + 80;
                        if(var1 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class92.loginIndex = 0;
                           class92.username = "";
                           class92.password = "";
                           class175.authCodeForLogin = 0;
                           authCode = "";
                           class92.field1440 = true;
                        }

                        while(true) {
                           while(class14.method69()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class22.field341 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(class50.field625 == 13) {
                                 class92.loginIndex = 0;
                                 class92.username = "";
                                 class92.password = "";
                                 class175.authCodeForLogin = 0;
                                 authCode = "";
                                 class92.field1440 = true;
                              } else if(class92.loginIndex2 == 0) {
                                 if(class50.field625 == 85 && class92.username.length() > 0) {
                                    class92.username = class92.username.substring(0, class92.username.length() - 1);
                                 }

                                 if(class50.field625 == 84 || class50.field625 == 80) {
                                    class92.loginIndex2 = 1;
                                 }

                                 if(var7 && class92.username.length() < 320) {
                                    class92.username = class92.username + class22.field341;
                                 }
                              } else if(class92.loginIndex2 == 1) {
                                 if(class50.field625 == 85 && class92.password.length() > 0) {
                                    class92.password = class92.password.substring(0, class92.password.length() - 1);
                                 }

                                 if(class50.field625 == 84 || class50.field625 == 80) {
                                    class92.loginIndex2 = 0;
                                 }

                                 if(class50.field625 == 84) {
                                    class92.username = class92.username.trim();
                                    if(class92.username.length() == 0) {
                                       Buffer.method3383("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class92.password.length() == 0) {
                                       Buffer.method3383("", "Please enter your password.", "");
                                       return;
                                    }

                                    Buffer.method3383("", "Connecting to server...", "");
                                    class92.field1436 = class134.field1989.preferences.containsKey(Integer.valueOf(class228.method4154(class92.username)))?class149.field2181:class149.field2179;
                                    class12.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class92.password.length() < 20) {
                                    class92.password = class92.password + class22.field341;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class92.loginIndex == 3) {
                        var13 = class92.loginWindowX + 180;
                        var15 = 276;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        }

                        var13 = class92.loginWindowX + 180;
                        var15 = 326;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                           Buffer.method3383("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var16;
                        int var17;
                        if(class92.loginIndex == 4) {
                           var13 = class92.loginWindowX + 180 - 80;
                           var15 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                              authCode.trim();
                              if(authCode.length() != 6) {
                                 Buffer.method3383("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class175.authCodeForLogin = Integer.parseInt(authCode);
                              authCode = "";
                              class92.field1436 = class92.field1440?class149.field2186:class149.field2180;
                              Buffer.method3383("", "Connecting to server...", "");
                              class12.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var10 >= class92.loginWindowX + 180 - 9 && var10 <= class92.loginWindowX + 180 + 130 && var11 >= 263 && var11 <= 296) {
                              class92.field1440 = !class92.field1440;
                           }

                           if(var1 == 1 && var10 >= class92.loginWindowX + 180 - 34 && var10 <= class92.loginWindowX + 180 + 34 && var11 >= 351 && var11 <= 363) {
                              class11.method47(class26.method179("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var13 = class92.loginWindowX + 180 + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                              class92.loginIndex = 0;
                              class92.username = "";
                              class92.password = "";
                              class175.authCodeForLogin = 0;
                              authCode = "";
                           }

                           while(class14.method69()) {
                              var16 = false;

                              for(var17 = 0; var17 < "1234567890".length(); ++var17) {
                                 if(class22.field341 == "1234567890".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(class50.field625 == 13) {
                                 class92.loginIndex = 0;
                                 class92.username = "";
                                 class92.password = "";
                                 class175.authCodeForLogin = 0;
                                 authCode = "";
                              } else {
                                 if(class50.field625 == 85 && authCode.length() > 0) {
                                    authCode = authCode.substring(0, authCode.length() - 1);
                                 }

                                 if(class50.field625 == 84) {
                                    authCode.trim();
                                    if(authCode.length() != 6) {
                                       Buffer.method3383("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class175.authCodeForLogin = Integer.parseInt(authCode);
                                    authCode = "";
                                    class92.field1436 = class92.field1440?class149.field2186:class149.field2180;
                                    Buffer.method3383("", "Connecting to server...", "");
                                    class12.setGameState(20);
                                    return;
                                 }

                                 if(var16 && authCode.length() < 6) {
                                    authCode = authCode + class22.field341;
                                 }
                              }
                           }
                        } else if(class92.loginIndex == 5) {
                           var13 = class92.loginWindowX + 180 - 80;
                           var15 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                              class77.method1521();
                              return;
                           }

                           var13 = class92.loginWindowX + 180 + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                              class92.loginMessage1 = "";
                              class92.loginMessage2 = "Enter your username/email & password.";
                              class92.loginMessage3 = "";
                              class92.loginIndex = 2;
                              class92.loginIndex2 = 0;
                              class92.password = "";
                           }

                           while(class14.method69()) {
                              var16 = false;

                              for(var17 = 0; var17 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var17) {
                                 if(class22.field341 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(class50.field625 == 13) {
                                 class92.loginMessage1 = "";
                                 class92.loginMessage2 = "Enter your username/email & password.";
                                 class92.loginMessage3 = "";
                                 class92.loginIndex = 2;
                                 class92.loginIndex2 = 0;
                                 class92.password = "";
                              } else {
                                 if(class50.field625 == 85 && class92.username.length() > 0) {
                                    class92.username = class92.username.substring(0, class92.username.length() - 1);
                                 }

                                 if(class50.field625 == 84) {
                                    class77.method1521();
                                    return;
                                 }

                                 if(var16 && class92.username.length() < 320) {
                                    class92.username = class92.username + class22.field341;
                                 }
                              }
                           }
                        } else if(class92.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class14.method69()) {
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
                              } while(class50.field625 != 84 && class50.field625 != 13);

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
                     while(class14.method69()) {
                        if(class50.field625 == 84) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        } else if(class50.field625 == 13) {
                           class92.loginIndex = 0;
                        }
                     }

                     var13 = class92.loginWindowX + 180 - 80;
                     var15 = 321;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                        class92.loginMessage1 = "";
                        class92.loginMessage2 = "Enter your username/email & password.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 2;
                        class92.loginIndex2 = 0;
                     }

                     var13 = class92.loginWindowX + 180 + 80;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                        class92.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass231;",
      garbageValue = "-420725109"
   )
   public static class231 method2440(int var0) {
      class231[] var1 = new class231[]{class231.field3180, class231.field3173, class231.field3175, class231.field3179};
      class231[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class231 var4 = var2[var3];
         if(var0 == var4.field3177) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)Ljava/lang/String;",
      garbageValue = "-4"
   )
   public static String method2441(Buffer var0) {
      return class146.method2935(var0, 32767);
   }
}
