import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("World")
public class World {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1347725587
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 254044185
   )
   static int field1291;
   @ObfuscatedName("l")
   static int[] field1292;
   @ObfuscatedName("w")
   static int[] field1293;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lch;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -204431663
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1146109373
   )
   @Export("index")
   int index;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 301161915
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -119224763
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @Export("address")
   String address;
   @ObfuscatedName("r")
   @Export("activity")
   String activity;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1558672497
   )
   @Export("location")
   int location;

   static {
      worldCount = 0;
      field1291 = 0;
      field1292 = new int[]{1, 1, 1, 1};
      field1293 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-3"
   )
   boolean method1579() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "128"
   )
   boolean method1560() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2116679583"
   )
   boolean method1559() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-3"
   )
   boolean method1557() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "469393721"
   )
   boolean method1558() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "375343847"
   )
   boolean method1556() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lbh;I)V",
      garbageValue = "-355981593"
   )
   static void method1581(GameEngine var0) {
      if(class93.worldSelectShown) {
         WorldMapType2.method553(var0);
      } else {
         if((MouseInput.field740 == 1 || !XGrandExchangeOffer.field302 && MouseInput.field740 == 4) && MouseInput.field741 >= class93.field1434 + 765 - 50 && MouseInput.field742 >= 453) {
            class3.preferences.muted = !class3.preferences.muted;
            class33.method372();
            if(!class3.preferences.muted) {
               class48.method768(class253.indexTrack1, "scape main", "", 255, false);
            } else {
               class204.field2501.method3758();
               class204.field2507 = 1;
               class204.field2502 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class93.field1433;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.languageId == 0) {
                  if(MouseInput.field740 == 1 || !XGrandExchangeOffer.field302 && MouseInput.field740 == 4) {
                     var1 = class93.field1434 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(MouseInput.field741 >= var1 && MouseInput.field741 <= var3 + var1 && MouseInput.field742 >= var2 && MouseInput.field742 <= var4 + var2) {
                        if(Ignore.loadWorlds()) {
                           class93.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(class67.listFetcher != null && Ignore.loadWorlds()) {
                     class93.worldSelectShown = true;
                  }
               }

               var1 = MouseInput.field740;
               int var10 = MouseInput.field741;
               int var11 = MouseInput.field742;
               if(!XGrandExchangeOffer.field302 && var1 == 4) {
                  var1 = 1;
               }

               int var5;
               short var6;
               if(class93.loginIndex == 0) {
                  boolean var12 = false;

                  while(XClanMember.method1207()) {
                     if(class48.field625 == 84) {
                        var12 = true;
                     }
                  }

                  var5 = class93.loginWindowX + 180 - 80;
                  var6 = 291;
                  if(var1 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                     String var7 = CombatInfo1.method1553("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                     class12.method70(var7, true, "openjs", false);
                  }

                  var5 = class93.loginWindowX + 180 + 80;
                  if(var1 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20 || var12) {
                     if((Client.flags & 33554432) != 0) {
                        class93.field1452 = "";
                        class93.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class93.loginMessage2 = "Your normal account will not be affected.";
                        class93.loginMessage3 = "";
                        class93.loginIndex = 1;
                        class93.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class93.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class93.loginMessage2 = "Players can attack each other almost everywhere";
                           class93.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class93.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class93.loginMessage2 = "Players can attack each other";
                           class93.loginMessage3 = "almost everywhere.";
                        }

                        class93.field1452 = "Warning!";
                        class93.loginIndex = 1;
                        class93.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class93.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class93.loginMessage2 = "The Protect Item prayer will";
                        class93.loginMessage3 = "not work on this world.";
                        class93.field1452 = "Warning!";
                        class93.loginIndex = 1;
                        class93.loginIndex2 = 0;
                     } else {
                        class93.loginMessage1 = "";
                        class93.loginMessage2 = "Enter your username/email & password.";
                        class93.loginMessage3 = "";
                        class93.loginIndex = 2;
                        class93.loginIndex2 = 0;
                     }
                  }
               } else {
                  int var13;
                  short var15;
                  if(class93.loginIndex != 1) {
                     short var14;
                     if(class93.loginIndex == 2) {
                        var14 = 231;
                        var13 = var14 + 30;
                        if(var1 == 1 && var11 >= var13 - 15 && var11 < var13) {
                           class93.loginIndex2 = 0;
                        }

                        var13 += 15;
                        if(var1 == 1 && var11 >= var13 - 15 && var11 < var13) {
                           class93.loginIndex2 = 1;
                        }

                        var13 += 15;
                        var14 = 361;
                        if(var1 == 1 && var11 >= var14 - 15 && var11 < var14) {
                           class69.method1159("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class93.loginIndex = 5;
                           return;
                        }

                        var5 = class93.loginWindowX + 180 - 80;
                        var6 = 321;
                        if(var1 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class93.username = class93.username.trim();
                           if(class93.username.length() == 0) {
                              class69.method1159("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class93.password.length() == 0) {
                              class69.method1159("", "Please enter your password.", "");
                              return;
                           }

                           class69.method1159("", "Connecting to server...", "");
                           class93.field1443 = class3.preferences.preferences.containsKey(Integer.valueOf(FaceNormal.method2897(class93.username)))?class150.field2202:class150.field2201;
                           MouseInput.setGameState(20);
                           return;
                        }

                        var5 = class93.loginWindowX + 180 + 80;
                        if(var1 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class93.loginIndex = 0;
                           class93.username = "";
                           class93.password = "";
                           ClassInfo.authCodeForLogin = 0;
                           Preferences.authCode = "";
                           class93.field1435 = true;
                        }

                        while(true) {
                           while(XClanMember.method1207()) {
                              boolean var9 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class221.field2807 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var9 = true;
                                    break;
                                 }
                              }

                              if(class48.field625 == 13) {
                                 class93.loginIndex = 0;
                                 class93.username = "";
                                 class93.password = "";
                                 ClassInfo.authCodeForLogin = 0;
                                 Preferences.authCode = "";
                                 class93.field1435 = true;
                              } else if(class93.loginIndex2 == 0) {
                                 if(class48.field625 == 85 && class93.username.length() > 0) {
                                    class93.username = class93.username.substring(0, class93.username.length() - 1);
                                 }

                                 if(class48.field625 == 84 || class48.field625 == 80) {
                                    class93.loginIndex2 = 1;
                                 }

                                 if(var9 && class93.username.length() < 320) {
                                    class93.username = class93.username + class221.field2807;
                                 }
                              } else if(class93.loginIndex2 == 1) {
                                 if(class48.field625 == 85 && class93.password.length() > 0) {
                                    class93.password = class93.password.substring(0, class93.password.length() - 1);
                                 }

                                 if(class48.field625 == 84 || class48.field625 == 80) {
                                    class93.loginIndex2 = 0;
                                 }

                                 if(class48.field625 == 84) {
                                    class93.username = class93.username.trim();
                                    if(class93.username.length() == 0) {
                                       class69.method1159("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class93.password.length() == 0) {
                                       class69.method1159("", "Please enter your password.", "");
                                       return;
                                    }

                                    class69.method1159("", "Connecting to server...", "");
                                    class93.field1443 = class3.preferences.preferences.containsKey(Integer.valueOf(FaceNormal.method2897(class93.username)))?class150.field2202:class150.field2201;
                                    MouseInput.setGameState(20);
                                    return;
                                 }

                                 if(var9 && class93.password.length() < 20) {
                                    class93.password = class93.password + class221.field2807;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class93.loginIndex == 3) {
                        var13 = class93.loginWindowX + 180;
                        var15 = 276;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                           class93.loginMessage1 = "";
                           class93.loginMessage2 = "Enter your username/email & password.";
                           class93.loginMessage3 = "";
                           class93.loginIndex = 2;
                           class93.loginIndex2 = 0;
                        }

                        var13 = class93.loginWindowX + 180;
                        var15 = 326;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                           class69.method1159("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class93.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var16;
                        int var17;
                        if(class93.loginIndex == 4) {
                           var13 = class93.loginWindowX + 180 - 80;
                           var15 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                              Preferences.authCode.trim();
                              if(Preferences.authCode.length() != 6) {
                                 class69.method1159("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              ClassInfo.authCodeForLogin = Integer.parseInt(Preferences.authCode);
                              Preferences.authCode = "";
                              class93.field1443 = class93.field1435?class150.field2203:class150.field2204;
                              class69.method1159("", "Connecting to server...", "");
                              MouseInput.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var10 >= class93.loginWindowX + 180 - 9 && var10 <= class93.loginWindowX + 180 + 130 && var11 >= 263 && var11 <= 296) {
                              class93.field1435 = !class93.field1435;
                           }

                           if(var1 == 1 && var10 >= class93.loginWindowX + 180 - 34 && var10 <= class93.loginWindowX + 34 + 180 && var11 >= 351 && var11 <= 363) {
                              class31.method292(CombatInfo1.method1553("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var13 = class93.loginWindowX + 180 + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                              class93.loginIndex = 0;
                              class93.username = "";
                              class93.password = "";
                              ClassInfo.authCodeForLogin = 0;
                              Preferences.authCode = "";
                           }

                           while(XClanMember.method1207()) {
                              var16 = false;

                              for(var17 = 0; var17 < "1234567890".length(); ++var17) {
                                 if(class221.field2807 == "1234567890".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(class48.field625 == 13) {
                                 class93.loginIndex = 0;
                                 class93.username = "";
                                 class93.password = "";
                                 ClassInfo.authCodeForLogin = 0;
                                 Preferences.authCode = "";
                              } else {
                                 if(class48.field625 == 85 && Preferences.authCode.length() > 0) {
                                    Preferences.authCode = Preferences.authCode.substring(0, Preferences.authCode.length() - 1);
                                 }

                                 if(class48.field625 == 84) {
                                    Preferences.authCode.trim();
                                    if(Preferences.authCode.length() != 6) {
                                       class69.method1159("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    ClassInfo.authCodeForLogin = Integer.parseInt(Preferences.authCode);
                                    Preferences.authCode = "";
                                    class93.field1443 = class93.field1435?class150.field2203:class150.field2204;
                                    class69.method1159("", "Connecting to server...", "");
                                    MouseInput.setGameState(20);
                                    return;
                                 }

                                 if(var16 && Preferences.authCode.length() < 6) {
                                    Preferences.authCode = Preferences.authCode + class221.field2807;
                                 }
                              }
                           }
                        } else if(class93.loginIndex == 5) {
                           var13 = class93.loginWindowX + 180 - 80;
                           var15 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                              class84.method1639();
                              return;
                           }

                           var13 = class93.loginWindowX + 180 + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                              class93.loginMessage1 = "";
                              class93.loginMessage2 = "Enter your username/email & password.";
                              class93.loginMessage3 = "";
                              class93.loginIndex = 2;
                              class93.loginIndex2 = 0;
                              class93.password = "";
                           }

                           while(XClanMember.method1207()) {
                              var16 = false;

                              for(var17 = 0; var17 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var17) {
                                 if(class221.field2807 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(class48.field625 == 13) {
                                 class93.loginMessage1 = "";
                                 class93.loginMessage2 = "Enter your username/email & password.";
                                 class93.loginMessage3 = "";
                                 class93.loginIndex = 2;
                                 class93.loginIndex2 = 0;
                                 class93.password = "";
                              } else {
                                 if(class48.field625 == 85 && class93.username.length() > 0) {
                                    class93.username = class93.username.substring(0, class93.username.length() - 1);
                                 }

                                 if(class48.field625 == 84) {
                                    class84.method1639();
                                    return;
                                 }

                                 if(var16 && class93.username.length() < 320) {
                                    class93.username = class93.username + class221.field2807;
                                 }
                              }
                           }
                        } else if(class93.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!XClanMember.method1207()) {
                                    var14 = 321;
                                    if(var1 == 1 && var11 >= var14 - 20 && var11 <= var14 + 20) {
                                       class93.loginMessage1 = "";
                                       class93.loginMessage2 = "Enter your username/email & password.";
                                       class93.loginMessage3 = "";
                                       class93.loginIndex = 2;
                                       class93.loginIndex2 = 0;
                                       class93.password = "";
                                    }

                                    return;
                                 }
                              } while(class48.field625 != 84 && class48.field625 != 13);

                              class93.loginMessage1 = "";
                              class93.loginMessage2 = "Enter your username/email & password.";
                              class93.loginMessage3 = "";
                              class93.loginIndex = 2;
                              class93.loginIndex2 = 0;
                              class93.password = "";
                           }
                        }
                     }
                  } else {
                     while(XClanMember.method1207()) {
                        if(class48.field625 == 84) {
                           class93.loginMessage1 = "";
                           class93.loginMessage2 = "Enter your username/email & password.";
                           class93.loginMessage3 = "";
                           class93.loginIndex = 2;
                           class93.loginIndex2 = 0;
                        } else if(class48.field625 == 13) {
                           class93.loginIndex = 0;
                        }
                     }

                     var13 = class93.loginWindowX + 180 - 80;
                     var15 = 321;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                        class93.loginMessage1 = "";
                        class93.loginMessage2 = "Enter your username/email & password.";
                        class93.loginMessage3 = "";
                        class93.loginIndex = 2;
                        class93.loginIndex2 = 0;
                     }

                     var13 = class93.loginWindowX + 180 + 80;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                        class93.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-102"
   )
   public static void method1587() {
      try {
         class156.field2257.method2372();

         for(int var0 = 0; var0 < class156.field2247; ++var0) {
            ISAACCipher.field2429[var0].method2372();
         }

         class156.field2253.method2372();
         class156.field2249.method2372();
      } catch (Exception var2) {
         ;
      }

   }
}
