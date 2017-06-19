import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class7 {
   @ObfuscatedName("t")
   public static class11 field233;
   @ObfuscatedName("m")
   public static boolean field234;
   @ObfuscatedName("e")
   public static boolean field235;
   @ObfuscatedName("w")
   public static CombatInfoList field237;
   @ObfuscatedName("p")
   public static boolean field238;
   @ObfuscatedName("c")
   public static short[][] field240;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)[Lclass257;",
      garbageValue = "-21"
   )
   static class257[] method30() {
      return new class257[]{class257.field3549, class257.field3552, class257.field3550};
   }

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-14"
   )
   static final void method33() {
      CombatInfo2.method4279();
      FloorUnderlayDefinition.field3349.reset();
      Preferences.method1510();
      ObjectComposition.field3489.reset();
      ObjectComposition.field3453.reset();
      ObjectComposition.field3446.reset();
      ObjectComposition.field3441.reset();
      FaceNormal.method2764();
      ItemComposition.field3497.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
      Sequence.field3603.reset();
      Sequence.field3606.reset();
      Spotanim.field3331.reset();
      Spotanim.field3334.reset();
      Varbit.field3389.reset();
      class241.field3294.reset();
      class254.field3419.reset();
      class254.field3420.reset();
      class254.field3421.reset();
      CombatInfo2.field3377.reset();
      CombatInfo2.spriteCache.reset();
      class56.method770();
      class251.field3394.reset();
      Area.field3300.reset();
      PlayerComposition.field2632.reset();
      Widget.field2654.reset();
      Widget.field2649.reset();
      Widget.field2658.reset();
      Widget.field2643.reset();
      ((TextureProvider)class136.field2028).method2285();
      Script.field1533.reset();
      Client.indexInterfaces.method4009();
      Client.indexSoundEffects.method4009();
      class9.field255.method4009();
      class66.field799.method4009();
      class177.indexMaps.method4009();
      FaceNormal.indexTrack1.method4009();
      class4.indexModels.method4009();
      WorldMapType3.indexSprites.method4009();
      class17.indexTextures.method4009();
      FileOnDisk.field1763.method4009();
      class11.indexTrack2.method4009();
      class69.indexScripts.method4009();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1361192952"
   )
   public static final boolean method34() {
      class50 var0 = class50.keyboard;
      class50 var1 = class50.keyboard;
      class50 var2 = class50.keyboard;
      synchronized(class50.keyboard) {
         if(class50.field665 == class50.field658) {
            return false;
         } else {
            class146.field2171 = class50.field655[class50.field658];
            class24.field376 = class50.field654[class50.field658];
            class50.field658 = class50.field658 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LGameEngine;S)V",
      garbageValue = "-31911"
   )
   static void method35(GameEngine var0) {
      if(class92.worldSelectShown) {
         RSCanvas.method742(var0);
      } else {
         if((class59.field736 == 1 || !class221.field2845 && class59.field736 == 4) && class59.field737 >= class92.field1414 + 765 - 50 && class59.field732 >= 453) {
            Item.field1481.field1300 = !Item.field1481.field1300;
            class5.method16();
            if(!Item.field1481.field1300) {
               class181.method3329(FaceNormal.indexTrack1, "scape main", "", 255, false);
            } else {
               class203.field2516.method3579();
               class203.field2517 = 1;
               class203.field2518 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class92.field1427;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.field1120 == 0) {
                  if(class59.field736 == 1 || !class221.field2845 && class59.field736 == 4) {
                     var1 = class92.field1414 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class59.field737 >= var1 && class59.field737 <= var3 + var1 && class59.field732 >= var2 && class59.field732 <= var2 + var4) {
                        Item.method1668();
                        return;
                     }
                  }

                  if(World.worldServersDownload != null) {
                     Item.method1668();
                  }
               }

               var1 = class59.field736;
               int var11 = class59.field737;
               int var12 = class59.field732;
               if(!class221.field2845 && var1 == 4) {
                  var1 = 1;
               }

               int var5;
               short var13;
               if(class92.loginIndex == 0) {
                  boolean var6 = false;

                  while(method34()) {
                     if(class146.field2171 == 84) {
                        var6 = true;
                     }
                  }

                  var5 = class92.loginWindowX + 180 - 80;
                  var13 = 291;
                  if(var1 == 1 && var11 >= var5 - 75 && var11 <= var5 + 75 && var12 >= var13 - 20 && var12 <= var13 + 20) {
                     class20.method164(class73.method1066("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var5 = class92.loginWindowX + 180 + 80;
                  if(var1 == 1 && var11 >= var5 - 75 && var11 <= var5 + 75 && var12 >= var13 - 20 && var12 <= var13 + 20 || var6) {
                     if((Client.flags & 33554432) != 0) {
                        class92.field1444 = "";
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

                        class92.field1444 = "Warning!";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class92.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class92.loginMessage2 = "The Protect Item prayer will";
                        class92.loginMessage3 = "not work on this world.";
                        class92.field1444 = "Warning!";
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
                  int var7;
                  short var14;
                  if(class92.loginIndex != 1) {
                     short var8;
                     boolean var9;
                     int var10;
                     if(class92.loginIndex == 2) {
                        var8 = 231;
                        var7 = var8 + 30;
                        if(var1 == 1 && var12 >= var7 - 15 && var12 < var7) {
                           class92.loginIndex2 = 0;
                        }

                        var7 += 15;
                        if(var1 == 1 && var12 >= var7 - 15 && var12 < var7) {
                           class92.loginIndex2 = 1;
                        }

                        var7 += 15;
                        var8 = 361;
                        if(var1 == 1 && var12 >= var8 - 15 && var12 < var8) {
                           class47.method674("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }

                        var5 = class92.loginWindowX + 180 - 80;
                        var13 = 321;
                        if(var1 == 1 && var11 >= var5 - 75 && var11 <= var5 + 75 && var12 >= var13 - 20 && var12 <= var13 + 20) {
                           class92.username = class92.username.trim();
                           if(class92.username.length() == 0) {
                              class47.method674("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class92.password.length() == 0) {
                              class47.method674("", "Please enter your password.", "");
                              return;
                           }

                           class47.method674("", "Connecting to server...", "");
                           class92.field1438 = Item.field1481.preferences.containsKey(Integer.valueOf(class96.method1689(class92.username)))?class149.field2204:class149.field2206;
                           class23.setGameState(20);
                           return;
                        }

                        var5 = class92.loginWindowX + 180 + 80;
                        if(var1 == 1 && var11 >= var5 - 75 && var11 <= var5 + 75 && var12 >= var13 - 20 && var12 <= var13 + 20) {
                           class92.loginIndex = 0;
                           class92.username = "";
                           class92.password = "";
                           World.authCodeForLogin = 0;
                           class82.authCode = "";
                           class92.field1430 = true;
                        }

                        while(true) {
                           while(method34()) {
                              var9 = false;

                              for(var10 = 0; var10 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var10) {
                                 if(class24.field376 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var10)) {
                                    var9 = true;
                                    break;
                                 }
                              }

                              if(class146.field2171 == 13) {
                                 class92.loginIndex = 0;
                                 class92.username = "";
                                 class92.password = "";
                                 World.authCodeForLogin = 0;
                                 class82.authCode = "";
                                 class92.field1430 = true;
                              } else if(class92.loginIndex2 == 0) {
                                 if(class146.field2171 == 85 && class92.username.length() > 0) {
                                    class92.username = class92.username.substring(0, class92.username.length() - 1);
                                 }

                                 if(class146.field2171 == 84 || class146.field2171 == 80) {
                                    class92.loginIndex2 = 1;
                                 }

                                 if(var9 && class92.username.length() < 320) {
                                    class92.username = class92.username + class24.field376;
                                 }
                              } else if(class92.loginIndex2 == 1) {
                                 if(class146.field2171 == 85 && class92.password.length() > 0) {
                                    class92.password = class92.password.substring(0, class92.password.length() - 1);
                                 }

                                 if(class146.field2171 == 84 || class146.field2171 == 80) {
                                    class92.loginIndex2 = 0;
                                 }

                                 if(class146.field2171 == 84) {
                                    class92.username = class92.username.trim();
                                    if(class92.username.length() == 0) {
                                       class47.method674("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class92.password.length() == 0) {
                                       class47.method674("", "Please enter your password.", "");
                                       return;
                                    }

                                    class47.method674("", "Connecting to server...", "");
                                    class92.field1438 = Item.field1481.preferences.containsKey(Integer.valueOf(class96.method1689(class92.username)))?class149.field2204:class149.field2206;
                                    class23.setGameState(20);
                                    return;
                                 }

                                 if(var9 && class92.password.length() < 20) {
                                    class92.password = class92.password + class24.field376;
                                 }
                              }
                           }

                           return;
                        }
                     }

                     if(class92.loginIndex == 3) {
                        var7 = class92.loginWindowX + 180;
                        var14 = 276;
                        if(var1 == 1 && var11 >= var7 - 75 && var11 <= var7 + 75 && var12 >= var14 - 20 && var12 <= var14 + 20) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        }

                        var7 = class92.loginWindowX + 180;
                        var14 = 326;
                        if(var1 == 1 && var11 >= var7 - 75 && var11 <= var7 + 75 && var12 >= var14 - 20 && var12 <= var14 + 20) {
                           class47.method674("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }
                     } else if(class92.loginIndex == 4) {
                        var7 = class92.loginWindowX + 180 - 80;
                        var14 = 321;
                        if(var1 == 1 && var11 >= var7 - 75 && var11 <= var7 + 75 && var12 >= var14 - 20 && var12 <= var14 + 20) {
                           class82.authCode.trim();
                           if(class82.authCode.length() != 6) {
                              class47.method674("", "Please enter a 6-digit PIN.", "");
                              return;
                           }

                           World.authCodeForLogin = Integer.parseInt(class82.authCode);
                           class82.authCode = "";
                           class92.field1438 = class92.field1430?class149.field2205:class149.field2207;
                           class47.method674("", "Connecting to server...", "");
                           class23.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var11 >= class92.loginWindowX + 180 - 9 && var11 <= class92.loginWindowX + 180 + 130 && var12 >= 263 && var12 <= 296) {
                           class92.field1430 = !class92.field1430;
                        }

                        if(var1 == 1 && var11 >= class92.loginWindowX + 180 - 34 && var11 <= class92.loginWindowX + 180 + 34 && var12 >= 351 && var12 <= 363) {
                           class20.method164(class73.method1066("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var7 = class92.loginWindowX + 180 + 80;
                        if(var1 == 1 && var11 >= var7 - 75 && var11 <= var7 + 75 && var12 >= var14 - 20 && var12 <= var14 + 20) {
                           class92.loginIndex = 0;
                           class92.username = "";
                           class92.password = "";
                           World.authCodeForLogin = 0;
                           class82.authCode = "";
                        }

                        while(method34()) {
                           var9 = false;

                           for(var10 = 0; var10 < "1234567890".length(); ++var10) {
                              if(class24.field376 == "1234567890".charAt(var10)) {
                                 var9 = true;
                                 break;
                              }
                           }

                           if(class146.field2171 == 13) {
                              class92.loginIndex = 0;
                              class92.username = "";
                              class92.password = "";
                              World.authCodeForLogin = 0;
                              class82.authCode = "";
                           } else {
                              if(class146.field2171 == 85 && class82.authCode.length() > 0) {
                                 class82.authCode = class82.authCode.substring(0, class82.authCode.length() - 1);
                              }

                              if(class146.field2171 == 84) {
                                 class82.authCode.trim();
                                 if(class82.authCode.length() != 6) {
                                    class47.method674("", "Please enter a 6-digit PIN.", "");
                                    return;
                                 }

                                 World.authCodeForLogin = Integer.parseInt(class82.authCode);
                                 class82.authCode = "";
                                 class92.field1438 = class92.field1430?class149.field2205:class149.field2207;
                                 class47.method674("", "Connecting to server...", "");
                                 class23.setGameState(20);
                                 return;
                              }

                              if(var9 && class82.authCode.length() < 6) {
                                 class82.authCode = class82.authCode + class24.field376;
                              }
                           }
                        }
                     } else if(class92.loginIndex == 5) {
                        var7 = class92.loginWindowX + 180 - 80;
                        var14 = 321;
                        if(var1 == 1 && var11 >= var7 - 75 && var11 <= var7 + 75 && var12 >= var14 - 20 && var12 <= var14 + 20) {
                           class274.method4790();
                           return;
                        }

                        var7 = class92.loginWindowX + 180 + 80;
                        if(var1 == 1 && var11 >= var7 - 75 && var11 <= var7 + 75 && var12 >= var14 - 20 && var12 <= var14 + 20) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                           class92.password = "";
                        }

                        while(method34()) {
                           var9 = false;

                           for(var10 = 0; var10 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var10) {
                              if(class24.field376 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var10)) {
                                 var9 = true;
                                 break;
                              }
                           }

                           if(class146.field2171 == 13) {
                              class92.loginMessage1 = "";
                              class92.loginMessage2 = "Enter your username/email & password.";
                              class92.loginMessage3 = "";
                              class92.loginIndex = 2;
                              class92.loginIndex2 = 0;
                              class92.password = "";
                           } else {
                              if(class146.field2171 == 85 && class92.username.length() > 0) {
                                 class92.username = class92.username.substring(0, class92.username.length() - 1);
                              }

                              if(class146.field2171 == 84) {
                                 class274.method4790();
                                 return;
                              }

                              if(var9 && class92.username.length() < 320) {
                                 class92.username = class92.username + class24.field376;
                              }
                           }
                        }
                     } else if(class92.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!method34()) {
                                 var8 = 321;
                                 if(var1 == 1 && var12 >= var8 - 20 && var12 <= var8 + 20) {
                                    class92.loginMessage1 = "";
                                    class92.loginMessage2 = "Enter your username/email & password.";
                                    class92.loginMessage3 = "";
                                    class92.loginIndex = 2;
                                    class92.loginIndex2 = 0;
                                    class92.password = "";
                                 }

                                 return;
                              }
                           } while(class146.field2171 != 84 && class146.field2171 != 13);

                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                           class92.password = "";
                        }
                     }
                  } else {
                     while(method34()) {
                        if(class146.field2171 == 84) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        } else if(class146.field2171 == 13) {
                           class92.loginIndex = 0;
                        }
                     }

                     var7 = class92.loginWindowX + 180 - 80;
                     var14 = 321;
                     if(var1 == 1 && var11 >= var7 - 75 && var11 <= var7 + 75 && var12 >= var14 - 20 && var12 <= var14 + 20) {
                        class92.loginMessage1 = "";
                        class92.loginMessage2 = "Enter your username/email & password.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 2;
                        class92.loginIndex2 = 0;
                     }

                     var7 = class92.loginWindowX + 180 + 80;
                     if(var1 == 1 && var11 >= var7 - 75 && var11 <= var7 + 75 && var12 >= var14 - 20 && var12 <= var14 + 20) {
                        class92.loginIndex = 0;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1756258350"
   )
   public static void method36() {
      try {
         if(class203.field2517 == 1) {
            int var0 = class203.field2516.method3574();
            if(var0 > 0 && class203.field2516.method3675()) {
               var0 -= CollisionData.field2304;
               if(var0 < 0) {
                  var0 = 0;
               }

               class203.field2516.method3592(var0);
               return;
            }

            class203.field2516.method3579();
            class203.field2516.method3581();
            if(class203.field2518 != null) {
               class203.field2517 = 2;
            } else {
               class203.field2517 = 0;
            }

            class98.field1522 = null;
            class46.field604 = null;
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class203.field2516.method3579();
         class203.field2517 = 0;
         class98.field1522 = null;
         class46.field604 = null;
         class203.field2518 = null;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass103;I)V",
      garbageValue = "122965973"
   )
   public static final void method37(class103 var0) {
      class90.field1395 = var0;
   }

   static {
      field238 = false;
      field234 = false;
      field235 = false;
      field233 = class11.field274;
      field237 = new CombatInfoList();
   }
}
