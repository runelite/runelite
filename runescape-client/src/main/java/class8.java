import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public final class class8 extends class9 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1832570355
   )
   final int field238;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2075388765
   )
   final int field239;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -782541741
   )
   final int field240;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2101886775
   )
   final int field241;
   @ObfuscatedName("eg")
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("rb")
   @ObfuscatedGetter(
      intValue = 974119355
   )
   static int field244;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 37558955
   )
   final int field245;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = 1379126569
   )
   @Export("menuX")
   static int menuX;

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1513100173"
   )
   static final void method45(boolean var0) {
      Client.field950 = 0;
      Client.field954 = 0;
      class98.method1816();
      class10.method65(var0);
      class149.method2910();

      int var1;
      for(var1 = 0; var1 < Client.field950; ++var1) {
         int var2 = Client.field1039[var1];
         if(Client.cachedNPCs[var2].field1261 != Client.gameCycle) {
            Client.cachedNPCs[var2].composition = null;
            Client.cachedNPCs[var2] = null;
         }
      }

      if(Client.packetLength != Client.secretPacketBuffer2.offset) {
         throw new RuntimeException(Client.secretPacketBuffer2.offset + "," + Client.packetLength);
      } else {
         for(var1 = 0; var1 < Client.field952; ++var1) {
            if(Client.cachedNPCs[Client.npcIndices[var1]] == null) {
               throw new RuntimeException(var1 + "," + Client.field952);
            }
         }

      }
   }

   class8(int var1, int var2, int var3, int var4, int var5) {
      this.field238 = var1;
      this.field245 = var2;
      this.field239 = var3;
      this.field240 = var4;
      this.field241 = var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1699185912"
   )
   final void vmethod62() {
      Rasterizer2D.method4976(this.field238 + Rasterizer2D.field3754, Rasterizer2D.drawingAreaTop + this.field245, this.field239 - this.field238, this.field240 - this.field245, this.field241);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "110207629"
   )
   static void method51(GameEngine var0) {
      if(class92.worldSelectShown) {
         class66.method1061(var0);
      } else {
         if((class59.field713 == 1 || !ItemLayer.field1798 && class59.field713 == 4) && class59.field723 >= class92.field1417 + 765 - 50 && class59.field724 >= 453) {
            class66.field801.field1316 = !class66.field801.field1316;
            WorldMapType3.method232();
            if(!class66.field801.field1316) {
               class9.method59(class54.indexTrack1, "scape main", "", 255, false);
            } else {
               class203.field2517.method3728();
               class203.field2515 = 1;
               class203.field2516 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class92.field1451;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.field919 == 0) {
                  if(class59.field713 == 1 || !ItemLayer.field1798 && class59.field713 == 4) {
                     var1 = class92.field1417 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class59.field723 >= var1 && class59.field723 <= var1 + var3 && class59.field724 >= var2 && class59.field724 <= var2 + var4) {
                        if(class40.loadWorlds()) {
                           class92.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(class64.worldServersDownload != null && class40.loadWorlds()) {
                     class92.worldSelectShown = true;
                  }
               }

               var1 = class59.field713;
               int var11 = class59.field723;
               int var12 = class59.field724;
               if(!ItemLayer.field1798 && var1 == 4) {
                  var1 = 1;
               }

               int var5;
               short var6;
               if(class92.loginIndex == 0) {
                  boolean var13 = false;

                  while(class25.method206()) {
                     if(class82.field1337 == 84) {
                        var13 = true;
                     }
                  }

                  var5 = class92.loginWindowX + 180 - 80;
                  var6 = 291;
                  if(var1 == 1 && var11 >= var5 - 75 && var11 <= var5 + 75 && var12 >= var6 - 20 && var12 <= var6 + 20) {
                     String var7 = class39.method542("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                     class7.method44(var7, true, "openjs", false);
                  }

                  var5 = class92.loginWindowX + 180 + 80;
                  if(var1 == 1 && var11 >= var5 - 75 && var11 <= var5 + 75 && var12 >= var6 - 20 && var12 <= var6 + 20 || var13) {
                     if((Client.flags & 33554432) != 0) {
                        class92.field1435 = "";
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

                        class92.field1435 = "Warning!";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class92.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class92.loginMessage2 = "The Protect Item prayer will";
                        class92.loginMessage3 = "not work on this world.";
                        class92.field1435 = "Warning!";
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
                  int var14;
                  short var16;
                  if(class92.loginIndex != 1) {
                     short var15;
                     if(class92.loginIndex == 2) {
                        var15 = 231;
                        var14 = var15 + 30;
                        if(var1 == 1 && var12 >= var14 - 15 && var12 < var14) {
                           class92.loginIndex2 = 0;
                        }

                        var14 += 15;
                        if(var1 == 1 && var12 >= var14 - 15 && var12 < var14) {
                           class92.loginIndex2 = 1;
                        }

                        var14 += 15;
                        var15 = 361;
                        if(var1 == 1 && var12 >= var15 - 15 && var12 < var15) {
                           class15.method115("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }

                        var5 = class92.loginWindowX + 180 - 80;
                        var6 = 321;
                        if(var1 == 1 && var11 >= var5 - 75 && var11 <= var5 + 75 && var12 >= var6 - 20 && var12 <= var6 + 20) {
                           class92.username = class92.username.trim();
                           if(class92.username.length() == 0) {
                              class15.method115("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class92.password.length() == 0) {
                              class15.method115("", "Please enter your password.", "");
                              return;
                           }

                           class15.method115("", "Connecting to server...", "");
                           class92.field1441 = class66.field801.preferences.containsKey(Integer.valueOf(DynamicObject.method1843(class92.username)))?class149.field2212:class149.field2208;
                           class3.setGameState(20);
                           return;
                        }

                        var5 = class92.loginWindowX + 180 + 80;
                        if(var1 == 1 && var11 >= var5 - 75 && var11 <= var5 + 75 && var12 >= var6 - 20 && var12 <= var6 + 20) {
                           class92.loginIndex = 0;
                           class92.username = "";
                           class92.password = "";
                           class175.authCodeForLogin = 0;
                           XItemContainer.authCode = "";
                           class92.field1442 = true;
                        }

                        while(true) {
                           while(class25.method206()) {
                              boolean var9 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class39.field535 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var9 = true;
                                    break;
                                 }
                              }

                              if(class82.field1337 == 13) {
                                 class92.loginIndex = 0;
                                 class92.username = "";
                                 class92.password = "";
                                 class175.authCodeForLogin = 0;
                                 XItemContainer.authCode = "";
                                 class92.field1442 = true;
                              } else if(class92.loginIndex2 == 0) {
                                 if(class82.field1337 == 85 && class92.username.length() > 0) {
                                    class92.username = class92.username.substring(0, class92.username.length() - 1);
                                 }

                                 if(class82.field1337 == 84 || class82.field1337 == 80) {
                                    class92.loginIndex2 = 1;
                                 }

                                 if(var9 && class92.username.length() < 320) {
                                    class92.username = class92.username + class39.field535;
                                 }
                              } else if(class92.loginIndex2 == 1) {
                                 if(class82.field1337 == 85 && class92.password.length() > 0) {
                                    class92.password = class92.password.substring(0, class92.password.length() - 1);
                                 }

                                 if(class82.field1337 == 84 || class82.field1337 == 80) {
                                    class92.loginIndex2 = 0;
                                 }

                                 if(class82.field1337 == 84) {
                                    class92.username = class92.username.trim();
                                    if(class92.username.length() == 0) {
                                       class15.method115("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class92.password.length() == 0) {
                                       class15.method115("", "Please enter your password.", "");
                                       return;
                                    }

                                    class15.method115("", "Connecting to server...", "");
                                    class92.field1441 = class66.field801.preferences.containsKey(Integer.valueOf(DynamicObject.method1843(class92.username)))?class149.field2212:class149.field2208;
                                    class3.setGameState(20);
                                    return;
                                 }

                                 if(var9 && class92.password.length() < 20) {
                                    class92.password = class92.password + class39.field535;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class92.loginIndex == 3) {
                        var14 = class92.loginWindowX + 180;
                        var16 = 276;
                        if(var1 == 1 && var11 >= var14 - 75 && var11 <= var14 + 75 && var12 >= var16 - 20 && var12 <= var16 + 20) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        }

                        var14 = class92.loginWindowX + 180;
                        var16 = 326;
                        if(var1 == 1 && var11 >= var14 - 75 && var11 <= var14 + 75 && var12 >= var16 - 20 && var12 <= var16 + 20) {
                           class15.method115("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var17;
                        int var18;
                        if(class92.loginIndex == 4) {
                           var14 = class92.loginWindowX + 180 - 80;
                           var16 = 321;
                           if(var1 == 1 && var11 >= var14 - 75 && var11 <= var14 + 75 && var12 >= var16 - 20 && var12 <= var16 + 20) {
                              XItemContainer.authCode.trim();
                              if(XItemContainer.authCode.length() != 6) {
                                 class15.method115("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class175.authCodeForLogin = Integer.parseInt(XItemContainer.authCode);
                              XItemContainer.authCode = "";
                              class92.field1441 = class92.field1442?class149.field2207:class149.field2209;
                              class15.method115("", "Connecting to server...", "");
                              class3.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var11 >= class92.loginWindowX + 180 - 9 && var11 <= class92.loginWindowX + 180 + 130 && var12 >= 263 && var12 <= 296) {
                              class92.field1442 = !class92.field1442;
                           }

                           if(var1 == 1 && var11 >= class92.loginWindowX + 180 - 34 && var11 <= class92.loginWindowX + 180 + 34 && var12 >= 351 && var12 <= 363) {
                              String var10 = class39.method542("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                              class7.method44(var10, true, "openjs", false);
                           }

                           var14 = class92.loginWindowX + 180 + 80;
                           if(var1 == 1 && var11 >= var14 - 75 && var11 <= var14 + 75 && var12 >= var16 - 20 && var12 <= var16 + 20) {
                              class92.loginIndex = 0;
                              class92.username = "";
                              class92.password = "";
                              class175.authCodeForLogin = 0;
                              XItemContainer.authCode = "";
                           }

                           while(class25.method206()) {
                              var17 = false;

                              for(var18 = 0; var18 < "1234567890".length(); ++var18) {
                                 if(class39.field535 == "1234567890".charAt(var18)) {
                                    var17 = true;
                                    break;
                                 }
                              }

                              if(class82.field1337 == 13) {
                                 class92.loginIndex = 0;
                                 class92.username = "";
                                 class92.password = "";
                                 class175.authCodeForLogin = 0;
                                 XItemContainer.authCode = "";
                              } else {
                                 if(class82.field1337 == 85 && XItemContainer.authCode.length() > 0) {
                                    XItemContainer.authCode = XItemContainer.authCode.substring(0, XItemContainer.authCode.length() - 1);
                                 }

                                 if(class82.field1337 == 84) {
                                    XItemContainer.authCode.trim();
                                    if(XItemContainer.authCode.length() != 6) {
                                       class15.method115("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class175.authCodeForLogin = Integer.parseInt(XItemContainer.authCode);
                                    XItemContainer.authCode = "";
                                    class92.field1441 = class92.field1442?class149.field2207:class149.field2209;
                                    class15.method115("", "Connecting to server...", "");
                                    class3.setGameState(20);
                                    return;
                                 }

                                 if(var17 && XItemContainer.authCode.length() < 6) {
                                    XItemContainer.authCode = XItemContainer.authCode + class39.field535;
                                 }
                              }
                           }
                        } else if(class92.loginIndex == 5) {
                           var14 = class92.loginWindowX + 180 - 80;
                           var16 = 321;
                           if(var1 == 1 && var11 >= var14 - 75 && var11 <= var14 + 75 && var12 >= var16 - 20 && var12 <= var16 + 20) {
                              class12.method83();
                              return;
                           }

                           var14 = class92.loginWindowX + 180 + 80;
                           if(var1 == 1 && var11 >= var14 - 75 && var11 <= var14 + 75 && var12 >= var16 - 20 && var12 <= var16 + 20) {
                              class92.loginMessage1 = "";
                              class92.loginMessage2 = "Enter your username/email & password.";
                              class92.loginMessage3 = "";
                              class92.loginIndex = 2;
                              class92.loginIndex2 = 0;
                              class92.password = "";
                           }

                           while(class25.method206()) {
                              var17 = false;

                              for(var18 = 0; var18 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var18) {
                                 if(class39.field535 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var18)) {
                                    var17 = true;
                                    break;
                                 }
                              }

                              if(class82.field1337 == 13) {
                                 class92.loginMessage1 = "";
                                 class92.loginMessage2 = "Enter your username/email & password.";
                                 class92.loginMessage3 = "";
                                 class92.loginIndex = 2;
                                 class92.loginIndex2 = 0;
                                 class92.password = "";
                              } else {
                                 if(class82.field1337 == 85 && class92.username.length() > 0) {
                                    class92.username = class92.username.substring(0, class92.username.length() - 1);
                                 }

                                 if(class82.field1337 == 84) {
                                    class12.method83();
                                    return;
                                 }

                                 if(var17 && class92.username.length() < 320) {
                                    class92.username = class92.username + class39.field535;
                                 }
                              }
                           }
                        } else if(class92.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class25.method206()) {
                                    var15 = 321;
                                    if(var1 == 1 && var12 >= var15 - 20 && var12 <= var15 + 20) {
                                       class92.loginMessage1 = "";
                                       class92.loginMessage2 = "Enter your username/email & password.";
                                       class92.loginMessage3 = "";
                                       class92.loginIndex = 2;
                                       class92.loginIndex2 = 0;
                                       class92.password = "";
                                    }

                                    return;
                                 }
                              } while(class82.field1337 != 84 && class82.field1337 != 13);

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
                     while(class25.method206()) {
                        if(class82.field1337 == 84) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        } else if(class82.field1337 == 13) {
                           class92.loginIndex = 0;
                        }
                     }

                     var14 = class92.loginWindowX + 180 - 80;
                     var16 = 321;
                     if(var1 == 1 && var11 >= var14 - 75 && var11 <= var14 + 75 && var12 >= var16 - 20 && var12 <= var16 + 20) {
                        class92.loginMessage1 = "";
                        class92.loginMessage2 = "Enter your username/email & password.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 2;
                        class92.loginIndex2 = 0;
                     }

                     var14 = class92.loginWindowX + 180 + 80;
                     if(var1 == 1 && var11 >= var14 - 75 && var11 <= var14 + 75 && var12 >= var16 - 20 && var12 <= var16 + 20) {
                        class92.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IZB)Ljava/lang/String;",
      garbageValue = "81"
   )
   public static String method52(int var0, boolean var1) {
      return var1 && var0 >= 0?class116.method2116(var0, 10, var1):Integer.toString(var0);
   }
}
