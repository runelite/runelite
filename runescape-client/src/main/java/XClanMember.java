import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("d")
   String field288;
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 1846407625
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -718974869
   )
   @Export("world")
   int world;
   @ObfuscatedName("m")
   static int[] field291;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      longValue = -1671425049694942999L
   )
   static long field292;
   @ObfuscatedName("q")
   @Export("username")
   String username;
   @ObfuscatedName("u")
   static Widget field297;
   @ObfuscatedName("p")
   @Export("rank")
   byte rank;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "1193514098"
   )
   static final void method251(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class10.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = -GroundObject.method1597(var4 + var2 + 932731, var3 + 556238 + var5) * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = 8 * -var8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 8 * var8;
               }
               break;
            }

            if(var7 <= 49) {
               class10.overlayIds[var1][var2][var3] = var0.readByte();
               class3.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class10.overlayRotations[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class10.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class10.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LGameEngine;B)V",
      garbageValue = "-104"
   )
   static void method252(GameEngine var0) {
      if(class41.worldSelectShown) {
         class156.method3053(var0);
      } else {
         int var2;
         int var3;
         if((class115.field1804 == 1 || !class15.field173 && class115.field1804 == 4) && class115.field1796 >= 765 + class41.field839 - 50 && class115.field1806 >= 453) {
            class184.field2735.field720 = !class184.field2735.field720;
            class99.method1996();
            if(!class184.field2735.field720) {
               class184 var9 = class11.field127;
               var2 = var9.method3335("scape main");
               var3 = var9.method3319(var2, "");
               class72.method1464(var9, var2, var3, 255, false);
            } else {
               class138.field1916.method2620();
               class138.field1919 = 1;
               class167.field2182 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class41.field838;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.field309 == 0) {
                  if(class115.field1804 == 1 || !class15.field173 && class115.field1804 == 4) {
                     var1 = 5 + class41.field839;
                     short var12 = 463;
                     byte var13 = 100;
                     byte var4 = 35;
                     if(class115.field1796 >= var1 && class115.field1796 <= var1 + var13 && class115.field1806 >= var12 && class115.field1806 <= var12 + var4) {
                        if(class189.loadWorlds()) {
                           class41.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(null != Ignore.worldServersDownload && class189.loadWorlds()) {
                     class41.worldSelectShown = true;
                  }
               }

               var1 = class115.field1804;
               var2 = class115.field1796;
               var3 = class115.field1806;
               if(!class15.field173 && var1 == 4) {
                  var1 = 1;
               }

               int var5;
               short var10;
               if(class41.loginIndex == 0) {
                  boolean var14 = false;

                  while(class162.method3118()) {
                     if(class7.field72 == 84) {
                        var14 = true;
                     }
                  }

                  var5 = class41.loginWindowX + 180 - 80;
                  var10 = 291;
                  if(var1 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var10 - 20 && var3 <= var10 + 20) {
                     String var11 = Item.method876("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                     TextureProvider.method1507(var11, true, "openjs", false);
                  }

                  var5 = 80 + 180 + class41.loginWindowX;
                  if(var1 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var10 - 20 && var3 <= 20 + var10 || var14) {
                     if((Client.flags & 33554432) != 0) {
                        class41.field859 = "";
                        class41.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class41.loginMessage2 = "Your normal account will not be affected.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class41.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other almost everywhere";
                           class41.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class41.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other";
                           class41.loginMessage3 = "almost everywhere.";
                        }

                        class41.field859 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class41.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class41.loginMessage2 = "The Protect Item prayer will";
                        class41.loginMessage3 = "not work on this world.";
                        class41.field859 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }
                  }
               } else {
                  int var15;
                  short var17;
                  if(class41.loginIndex != 1) {
                     short var16;
                     if(class41.loginIndex == 2) {
                        var16 = 231;
                        var15 = var16 + 30;
                        if(var1 == 1 && var3 >= var15 - 15 && var3 < var15) {
                           class41.loginIndex2 = 0;
                        }

                        var15 += 15;
                        if(var1 == 1 && var3 >= var15 - 15 && var3 < var15) {
                           class41.loginIndex2 = 1;
                        }

                        var15 += 15;
                        var16 = 361;
                        if(var1 == 1 && var3 >= var16 - 15 && var3 < var16) {
                           class138.method2536("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }

                        var5 = class41.loginWindowX + 180 - 80;
                        var10 = 321;
                        if(var1 == 1 && var2 >= var5 - 75 && var2 <= 75 + var5 && var3 >= var10 - 20 && var3 <= 20 + var10) {
                           class41.username = class41.username.trim();
                           if(class41.username.length() == 0) {
                              class138.method2536("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class41.field864.length() == 0) {
                              class138.method2536("", "Please enter your password.", "");
                              return;
                           }

                           class138.method2536("", "Connecting to server...", "");
                           class41.field865 = class184.field2735.field717.containsKey(Integer.valueOf(Player.method250(class41.username)))?class97.field1641:class97.field1634;
                           class8.setGameState(20);
                           return;
                        }

                        var5 = 80 + 180 + class41.loginWindowX;
                        if(var1 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var10 - 20 && var3 <= var10 + 20) {
                           class41.loginIndex = 0;
                           class41.username = "";
                           class41.field864 = "";
                           class105.field1728 = 0;
                           class30.authCode = "";
                           class41.field866 = true;
                        }

                        while(true) {
                           while(class162.method3118()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class33.field772 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(class7.field72 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.field864 = "";
                                 class105.field1728 = 0;
                                 class30.authCode = "";
                                 class41.field866 = true;
                              } else if(class41.loginIndex2 == 0) {
                                 if(class7.field72 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(class7.field72 == 84 || class7.field72 == 80) {
                                    class41.loginIndex2 = 1;
                                 }

                                 if(var7 && class41.username.length() < 320) {
                                    class41.username = class41.username + class33.field772;
                                 }
                              } else if(class41.loginIndex2 == 1) {
                                 if(class7.field72 == 85 && class41.field864.length() > 0) {
                                    class41.field864 = class41.field864.substring(0, class41.field864.length() - 1);
                                 }

                                 if(class7.field72 == 84 || class7.field72 == 80) {
                                    class41.loginIndex2 = 0;
                                 }

                                 if(class7.field72 == 84) {
                                    class41.username = class41.username.trim();
                                    if(class41.username.length() == 0) {
                                       class138.method2536("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class41.field864.length() == 0) {
                                       class138.method2536("", "Please enter your password.", "");
                                       return;
                                    }

                                    class138.method2536("", "Connecting to server...", "");
                                    class41.field865 = class184.field2735.field717.containsKey(Integer.valueOf(Player.method250(class41.username)))?class97.field1641:class97.field1634;
                                    class8.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class41.field864.length() < 20) {
                                    class41.field864 = class41.field864 + class33.field772;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class41.loginIndex == 3) {
                        var15 = 180 + class41.loginWindowX;
                        var17 = 276;
                        if(var1 == 1 && var2 >= var15 - 75 && var2 <= var15 + 75 && var3 >= var17 - 20 && var3 <= var17 + 20) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        }

                        var15 = 180 + class41.loginWindowX;
                        var17 = 326;
                        if(var1 == 1 && var2 >= var15 - 75 && var2 <= var15 + 75 && var3 >= var17 - 20 && var3 <= 20 + var17) {
                           class138.method2536("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }
                     } else {
                        int var18;
                        boolean var19;
                        if(class41.loginIndex == 4) {
                           var15 = 180 + class41.loginWindowX - 80;
                           var17 = 321;
                           if(var1 == 1 && var2 >= var15 - 75 && var2 <= 75 + var15 && var3 >= var17 - 20 && var3 <= 20 + var17) {
                              class30.authCode.trim();
                              if(class30.authCode.length() != 6) {
                                 class138.method2536("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class105.field1728 = Integer.parseInt(class30.authCode);
                              class30.authCode = "";
                              class41.field865 = class41.field866?class97.field1633:class97.field1636;
                              class138.method2536("", "Connecting to server...", "");
                              class8.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var2 >= class41.loginWindowX + 180 - 9 && var2 <= 130 + 180 + class41.loginWindowX && var3 >= 263 && var3 <= 296) {
                              class41.field866 = !class41.field866;
                           }

                           if(var1 == 1 && var2 >= 180 + class41.loginWindowX - 34 && var2 <= 180 + class41.loginWindowX + 34 && var3 >= 351 && var3 <= 363) {
                              String var6 = Item.method876("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                              TextureProvider.method1507(var6, true, "openjs", false);
                           }

                           var15 = 180 + class41.loginWindowX + 80;
                           if(var1 == 1 && var2 >= var15 - 75 && var2 <= 75 + var15 && var3 >= var17 - 20 && var3 <= var17 + 20) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.field864 = "";
                              class105.field1728 = 0;
                              class30.authCode = "";
                           }

                           while(class162.method3118()) {
                              var19 = false;

                              for(var18 = 0; var18 < "1234567890".length(); ++var18) {
                                 if(class33.field772 == "1234567890".charAt(var18)) {
                                    var19 = true;
                                    break;
                                 }
                              }

                              if(class7.field72 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.field864 = "";
                                 class105.field1728 = 0;
                                 class30.authCode = "";
                              } else {
                                 if(class7.field72 == 85 && class30.authCode.length() > 0) {
                                    class30.authCode = class30.authCode.substring(0, class30.authCode.length() - 1);
                                 }

                                 if(class7.field72 == 84) {
                                    class30.authCode.trim();
                                    if(class30.authCode.length() != 6) {
                                       class138.method2536("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class105.field1728 = Integer.parseInt(class30.authCode);
                                    class30.authCode = "";
                                    class41.field865 = class41.field866?class97.field1633:class97.field1636;
                                    class138.method2536("", "Connecting to server...", "");
                                    class8.setGameState(20);
                                    return;
                                 }

                                 if(var19 && class30.authCode.length() < 6) {
                                    class30.authCode = class30.authCode + class33.field772;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 5) {
                           var15 = 180 + class41.loginWindowX - 80;
                           var17 = 321;
                           if(var1 == 1 && var2 >= var15 - 75 && var2 <= 75 + var15 && var3 >= var17 - 20 && var3 <= var17 + 20) {
                              DecorativeObject.method1980();
                              return;
                           }

                           var15 = 80 + 180 + class41.loginWindowX;
                           if(var1 == 1 && var2 >= var15 - 75 && var2 <= 75 + var15 && var3 >= var17 - 20 && var3 <= var17 + 20) {
                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field864 = "";
                           }

                           while(class162.method3118()) {
                              var19 = false;

                              for(var18 = 0; var18 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var18) {
                                 if(class33.field772 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var18)) {
                                    var19 = true;
                                    break;
                                 }
                              }

                              if(class7.field72 == 13) {
                                 class41.loginMessage1 = "";
                                 class41.loginMessage2 = "Enter your username/email & password.";
                                 class41.loginMessage3 = "";
                                 class41.loginIndex = 2;
                                 class41.loginIndex2 = 0;
                                 class41.field864 = "";
                              } else {
                                 if(class7.field72 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(class7.field72 == 84) {
                                    DecorativeObject.method1980();
                                    return;
                                 }

                                 if(var19 && class41.username.length() < 320) {
                                    class41.username = class41.username + class33.field772;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class162.method3118()) {
                                    var16 = 321;
                                    if(var1 == 1 && var3 >= var16 - 20 && var3 <= 20 + var16) {
                                       class41.loginMessage1 = "";
                                       class41.loginMessage2 = "Enter your username/email & password.";
                                       class41.loginMessage3 = "";
                                       class41.loginIndex = 2;
                                       class41.loginIndex2 = 0;
                                       class41.field864 = "";
                                    }

                                    return;
                                 }
                              } while(class7.field72 != 84 && class7.field72 != 13);

                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.field864 = "";
                           }
                        }
                     }
                  } else {
                     while(class162.method3118()) {
                        if(class7.field72 == 84) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        } else if(class7.field72 == 13) {
                           class41.loginIndex = 0;
                        }
                     }

                     var15 = class41.loginWindowX + 180 - 80;
                     var17 = 321;
                     if(var1 == 1 && var2 >= var15 - 75 && var2 <= 75 + var15 && var3 >= var17 - 20 && var3 <= var17 + 20) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }

                     var15 = 180 + class41.loginWindowX + 80;
                     if(var1 == 1 && var2 >= var15 - 75 && var2 <= 75 + var15 && var3 >= var17 - 20 && var3 <= var17 + 20) {
                        class41.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "5740"
   )
   static final void method253() {
      Client.field348.method3073(152);
      Client.field348.method2918(0);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZB)I",
      garbageValue = "-34"
   )
   static int method254(int var0, Script var1, boolean var2) {
      byte var3;
      int var4;
      int var6;
      Widget var7;
      int var25;
      int var28;
      Widget var32;
      if(var0 < 1000) {
         if(var0 == 100) {
            class103.field1686 -= 3;
            var4 = class32.field747[class103.field1686];
            var28 = class32.field747[class103.field1686 + 1];
            var6 = class32.field747[2 + class103.field1686];
            if(var28 == 0) {
               throw new RuntimeException();
            }

            var7 = class179.method3296(var4);
            if(var7.children == null) {
               var7.children = new Widget[var6 + 1];
            }

            if(var7.children.length <= var6) {
               Widget[] var29 = new Widget[var6 + 1];

               for(var25 = 0; var25 < var7.children.length; ++var25) {
                  var29[var25] = var7.children[var25];
               }

               var7.children = var29;
            }

            if(var6 > 0 && var7.children[var6 - 1] == null) {
               throw new RuntimeException("" + (var6 - 1));
            }

            Widget var30 = new Widget();
            var30.type = var28;
            var30.parentId = var30.id = var7.id;
            var30.index = var6;
            var30.hasScript = true;
            var7.children[var6] = var30;
            if(var2) {
               XGrandExchangeOffer.field58 = var30;
            } else {
               field297 = var30;
            }

            class174.method3276(var7);
            var3 = 1;
         } else if(var0 == 101) {
            var32 = var2?XGrandExchangeOffer.field58:field297;
            Widget var39 = class179.method3296(var32.id);
            var39.children[var32.index] = null;
            class174.method3276(var39);
            var3 = 1;
         } else if(var0 == 102) {
            var32 = class179.method3296(class32.field747[--class103.field1686]);
            var32.children = null;
            class174.method3276(var32);
            var3 = 1;
         } else if(var0 == 200) {
            class103.field1686 -= 2;
            var4 = class32.field747[class103.field1686];
            var28 = class32.field747[1 + class103.field1686];
            Widget var40 = class57.method1157(var4, var28);
            if(null != var40 && var28 != -1) {
               class32.field747[++class103.field1686 - 1] = 1;
               if(var2) {
                  XGrandExchangeOffer.field58 = var40;
               } else {
                  field297 = var40;
               }
            } else {
               class32.field747[++class103.field1686 - 1] = 0;
            }

            var3 = 1;
         } else if(var0 == 201) {
            var32 = class179.method3296(class32.field747[--class103.field1686]);
            if(var32 != null) {
               class32.field747[++class103.field1686 - 1] = 1;
               if(var2) {
                  XGrandExchangeOffer.field58 = var32;
               } else {
                  field297 = var32;
               }
            } else {
               class32.field747[++class103.field1686 - 1] = 0;
            }

            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1100) {
         return class31.method708(var0, var1, var2);
      } else if(var0 < 1200) {
         return class181.method3299(var0, var1, var2);
      } else if(var0 < 1300) {
         return RSCanvas.method2139(var0, var1, var2);
      } else if(var0 < 1400) {
         return WidgetNode.method196(var0, var1, var2);
      } else if(var0 < 1500) {
         return class8.method95(var0, var1, var2);
      } else if(var0 < 1600) {
         var7 = var2?XGrandExchangeOffer.field58:field297;
         if(var0 == 1500) {
            class32.field747[++class103.field1686 - 1] = var7.relativeX;
            var3 = 1;
         } else if(var0 == 1501) {
            class32.field747[++class103.field1686 - 1] = var7.relativeY;
            var3 = 1;
         } else if(var0 == 1502) {
            class32.field747[++class103.field1686 - 1] = var7.width;
            var3 = 1;
         } else if(var0 == 1503) {
            class32.field747[++class103.field1686 - 1] = var7.height;
            var3 = 1;
         } else if(var0 == 1504) {
            class32.field747[++class103.field1686 - 1] = var7.isHidden?1:0;
            var3 = 1;
         } else if(var0 == 1505) {
            class32.field747[++class103.field1686 - 1] = var7.parentId;
            var3 = 1;
         } else {
            var3 = 2;
         }

         return var3;
      } else if(var0 < 1700) {
         return class101.method2019(var0, var1, var2);
      } else if(var0 < 1800) {
         return method256(var0, var1, var2);
      } else {
         int var24;
         int var33;
         int[] var35;
         if(var0 < 1900) {
            var32 = var2?XGrandExchangeOffer.field58:field297;
            if(var0 == 1800) {
               var35 = class32.field747;
               var6 = ++class103.field1686 - 1;
               var24 = class196.method3614(var32);
               var33 = var24 >> 11 & 63;
               var35[var6] = var33;
               var3 = 1;
            } else if(var0 == 1801) {
               var28 = class32.field747[--class103.field1686];
               --var28;
               if(var32.actions != null && var28 < var32.actions.length && var32.actions[var28] != null) {
                  class32.chatboxSegments[++class32.field749 - 1] = var32.actions[var28];
               } else {
                  class32.chatboxSegments[++class32.field749 - 1] = "";
               }

               var3 = 1;
            } else if(var0 == 1802) {
               if(null == var32.name) {
                  class32.chatboxSegments[++class32.field749 - 1] = "";
               } else {
                  class32.chatboxSegments[++class32.field749 - 1] = var32.name;
               }

               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2000) {
            return class85.method1744(var0, var1, var2);
         } else if(var0 < 2100) {
            return class31.method708(var0, var1, var2);
         } else if(var0 < 2200) {
            return class181.method3299(var0, var1, var2);
         } else if(var0 < 2300) {
            return RSCanvas.method2139(var0, var1, var2);
         } else if(var0 < 2400) {
            return WidgetNode.method196(var0, var1, var2);
         } else if(var0 < 2500) {
            return class8.method95(var0, var1, var2);
         } else if(var0 < 2600) {
            return class0.method2(var0, var1, var2);
         } else if(var0 < 2700) {
            return class165.method3167(var0, var1, var2);
         } else if(var0 < 2800) {
            if(var0 == 2700) {
               var32 = class179.method3296(class32.field747[--class103.field1686]);
               class32.field747[++class103.field1686 - 1] = var32.item;
               var3 = 1;
            } else if(var0 == 2701) {
               var32 = class179.method3296(class32.field747[--class103.field1686]);
               if(var32.item != -1) {
                  class32.field747[++class103.field1686 - 1] = var32.stackSize;
               } else {
                  class32.field747[++class103.field1686 - 1] = 0;
               }

               var3 = 1;
            } else if(var0 == 2702) {
               var4 = class32.field747[--class103.field1686];
               WidgetNode var37 = (WidgetNode)Client.componentTable.method2399((long)var4);
               if(var37 != null) {
                  class32.field747[++class103.field1686 - 1] = 1;
               } else {
                  class32.field747[++class103.field1686 - 1] = 0;
               }

               var3 = 1;
            } else if(var0 == 2706) {
               class32.field747[++class103.field1686 - 1] = Client.widgetRoot;
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 2900) {
            var32 = class179.method3296(class32.field747[--class103.field1686]);
            if(var0 == 2800) {
               var35 = class32.field747;
               var6 = ++class103.field1686 - 1;
               var24 = class196.method3614(var32);
               var33 = var24 >> 11 & 63;
               var35[var6] = var33;
               var3 = 1;
            } else if(var0 == 2801) {
               var28 = class32.field747[--class103.field1686];
               --var28;
               if(var32.actions != null && var28 < var32.actions.length && null != var32.actions[var28]) {
                  class32.chatboxSegments[++class32.field749 - 1] = var32.actions[var28];
               } else {
                  class32.chatboxSegments[++class32.field749 - 1] = "";
               }

               var3 = 1;
            } else if(var0 == 2802) {
               if(null == var32.name) {
                  class32.chatboxSegments[++class32.field749 - 1] = "";
               } else {
                  class32.chatboxSegments[++class32.field749 - 1] = var32.name;
               }

               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 3000) {
            return class85.method1744(var0, var1, var2);
         } else if(var0 < 3200) {
            return class5.method64(var0, var1, var2);
         } else if(var0 < 3300) {
            return class161.method3114(var0, var1, var2);
         } else if(var0 < 3400) {
            if(var0 == 3300) {
               class32.field747[++class103.field1686 - 1] = Client.gameCycle;
               var3 = 1;
            } else {
               XItemContainer var9;
               int[] var38;
               if(var0 == 3301) {
                  class103.field1686 -= 2;
                  var4 = class32.field747[class103.field1686];
                  var28 = class32.field747[class103.field1686 + 1];
                  var38 = class32.field747;
                  var33 = ++class103.field1686 - 1;
                  var9 = (XItemContainer)XItemContainer.itemContainers.method2399((long)var4);
                  if(var9 == null) {
                     var24 = -1;
                  } else if(var28 >= 0 && var28 < var9.itemIds.length) {
                     var24 = var9.itemIds[var28];
                  } else {
                     var24 = -1;
                  }

                  var38[var33] = var24;
                  var3 = 1;
               } else if(var0 == 3302) {
                  class103.field1686 -= 2;
                  var4 = class32.field747[class103.field1686];
                  var28 = class32.field747[1 + class103.field1686];
                  class32.field747[++class103.field1686 - 1] = TextureProvider.method1489(var4, var28);
                  var3 = 1;
               } else if(var0 == 3303) {
                  class103.field1686 -= 2;
                  var4 = class32.field747[class103.field1686];
                  var28 = class32.field747[class103.field1686 + 1];
                  class32.field747[++class103.field1686 - 1] = class57.method1159(var4, var28);
                  var3 = 1;
               } else if(var0 == 3304) {
                  var4 = class32.field747[--class103.field1686];
                  class32.field747[++class103.field1686 - 1] = class183.method3389(var4).field2774;
                  var3 = 1;
               } else if(var0 == 3305) {
                  var4 = class32.field747[--class103.field1686];
                  class32.field747[++class103.field1686 - 1] = Client.boostedSkillLevels[var4];
                  var3 = 1;
               } else if(var0 == 3306) {
                  var4 = class32.field747[--class103.field1686];
                  class32.field747[++class103.field1686 - 1] = Client.realSkillLevels[var4];
                  var3 = 1;
               } else if(var0 == 3307) {
                  var4 = class32.field747[--class103.field1686];
                  class32.field747[++class103.field1686 - 1] = Client.skillExperiences[var4];
                  var3 = 1;
               } else if(var0 == 3308) {
                  var4 = WallObject.plane;
                  var28 = class5.baseX + (class36.localPlayer.x >> 7);
                  var6 = baseY + (class36.localPlayer.y >> 7);
                  class32.field747[++class103.field1686 - 1] = (var28 << 14) + (var4 << 28) + var6;
                  var3 = 1;
               } else if(var0 == 3309) {
                  var4 = class32.field747[--class103.field1686];
                  class32.field747[++class103.field1686 - 1] = var4 >> 14 & 16383;
                  var3 = 1;
               } else if(var0 == 3310) {
                  var4 = class32.field747[--class103.field1686];
                  class32.field747[++class103.field1686 - 1] = var4 >> 28;
                  var3 = 1;
               } else if(var0 == 3311) {
                  var4 = class32.field747[--class103.field1686];
                  class32.field747[++class103.field1686 - 1] = var4 & 16383;
                  var3 = 1;
               } else if(var0 == 3312) {
                  class32.field747[++class103.field1686 - 1] = Client.isMembers?1:0;
                  var3 = 1;
               } else if(var0 == 3313) {
                  class103.field1686 -= 2;
                  var4 = class32.field747[class103.field1686] + '耀';
                  var28 = class32.field747[class103.field1686 + 1];
                  var38 = class32.field747;
                  var33 = ++class103.field1686 - 1;
                  var9 = (XItemContainer)XItemContainer.itemContainers.method2399((long)var4);
                  if(var9 == null) {
                     var24 = -1;
                  } else if(var28 >= 0 && var28 < var9.itemIds.length) {
                     var24 = var9.itemIds[var28];
                  } else {
                     var24 = -1;
                  }

                  var38[var33] = var24;
                  var3 = 1;
               } else if(var0 == 3314) {
                  class103.field1686 -= 2;
                  var4 = '耀' + class32.field747[class103.field1686];
                  var28 = class32.field747[1 + class103.field1686];
                  var38 = class32.field747;
                  var33 = ++class103.field1686 - 1;
                  var9 = (XItemContainer)XItemContainer.itemContainers.method2399((long)var4);
                  if(null == var9) {
                     var24 = 0;
                  } else if(var28 >= 0 && var28 < var9.stackSizes.length) {
                     var24 = var9.stackSizes[var28];
                  } else {
                     var24 = 0;
                  }

                  var38[var33] = var24;
                  var3 = 1;
               } else if(var0 == 3315) {
                  class103.field1686 -= 2;
                  var4 = class32.field747[class103.field1686] + '耀';
                  var28 = class32.field747[class103.field1686 + 1];
                  class32.field747[++class103.field1686 - 1] = class57.method1159(var4, var28);
                  var3 = 1;
               } else if(var0 == 3316) {
                  if(Client.field472 >= 2) {
                     class32.field747[++class103.field1686 - 1] = Client.field472;
                  } else {
                     class32.field747[++class103.field1686 - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 3317) {
                  class32.field747[++class103.field1686 - 1] = Client.field322;
                  var3 = 1;
               } else if(var0 == 3318) {
                  class32.field747[++class103.field1686 - 1] = Client.world;
                  var3 = 1;
               } else if(var0 == 3321) {
                  class32.field747[++class103.field1686 - 1] = Client.energy;
                  var3 = 1;
               } else if(var0 == 3322) {
                  class32.field747[++class103.field1686 - 1] = Client.weight;
                  var3 = 1;
               } else if(var0 == 3323) {
                  if(Client.field474) {
                     class32.field747[++class103.field1686 - 1] = 1;
                  } else {
                     class32.field747[++class103.field1686 - 1] = 0;
                  }

                  var3 = 1;
               } else if(var0 == 3324) {
                  class32.field747[++class103.field1686 - 1] = Client.flags;
                  var3 = 1;
               } else {
                  var3 = 2;
               }
            }

            return var3;
         } else if(var0 < 3500) {
            return class101.method2020(var0, var1, var2);
         } else if(var0 < 3700) {
            return class15.method180(var0, var1, var2);
         } else if(var0 < 4000) {
            return class2.method30(var0, var1, var2);
         } else if(var0 < 4100) {
            if(var0 == 4000) {
               class103.field1686 -= 2;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[class103.field1686 + 1];
               class32.field747[++class103.field1686 - 1] = var4 + var28;
               var3 = 1;
            } else if(var0 == 4001) {
               class103.field1686 -= 2;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[1 + class103.field1686];
               class32.field747[++class103.field1686 - 1] = var4 - var28;
               var3 = 1;
            } else if(var0 == 4002) {
               class103.field1686 -= 2;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[1 + class103.field1686];
               class32.field747[++class103.field1686 - 1] = var28 * var4;
               var3 = 1;
            } else if(var0 == 4003) {
               class103.field1686 -= 2;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[class103.field1686 + 1];
               class32.field747[++class103.field1686 - 1] = var4 / var28;
               var3 = 1;
            } else if(var0 == 4004) {
               var4 = class32.field747[--class103.field1686];
               class32.field747[++class103.field1686 - 1] = (int)(Math.random() * (double)var4);
               var3 = 1;
            } else if(var0 == 4005) {
               var4 = class32.field747[--class103.field1686];
               class32.field747[++class103.field1686 - 1] = (int)(Math.random() * (double)(var4 + 1));
               var3 = 1;
            } else if(var0 == 4006) {
               class103.field1686 -= 5;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[class103.field1686 + 1];
               var6 = class32.field747[2 + class103.field1686];
               var33 = class32.field747[class103.field1686 + 3];
               var24 = class32.field747[class103.field1686 + 4];
               class32.field747[++class103.field1686 - 1] = var4 + (var24 - var6) * (var28 - var4) / (var33 - var6);
               var3 = 1;
            } else if(var0 == 4007) {
               class103.field1686 -= 2;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[class103.field1686 + 1];
               class32.field747[++class103.field1686 - 1] = var4 * var28 / 100 + var4;
               var3 = 1;
            } else if(var0 == 4008) {
               class103.field1686 -= 2;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[class103.field1686 + 1];
               class32.field747[++class103.field1686 - 1] = var4 | 1 << var28;
               var3 = 1;
            } else if(var0 == 4009) {
               class103.field1686 -= 2;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[1 + class103.field1686];
               class32.field747[++class103.field1686 - 1] = var4 & -1 - (1 << var28);
               var3 = 1;
            } else if(var0 == 4010) {
               class103.field1686 -= 2;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[class103.field1686 + 1];
               class32.field747[++class103.field1686 - 1] = (var4 & 1 << var28) != 0?1:0;
               var3 = 1;
            } else if(var0 == 4011) {
               class103.field1686 -= 2;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[class103.field1686 + 1];
               class32.field747[++class103.field1686 - 1] = var4 % var28;
               var3 = 1;
            } else if(var0 == 4012) {
               class103.field1686 -= 2;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[class103.field1686 + 1];
               if(var4 == 0) {
                  class32.field747[++class103.field1686 - 1] = 0;
               } else {
                  class32.field747[++class103.field1686 - 1] = (int)Math.pow((double)var4, (double)var28);
               }

               var3 = 1;
            } else if(var0 == 4013) {
               class103.field1686 -= 2;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[1 + class103.field1686];
               if(var4 == 0) {
                  class32.field747[++class103.field1686 - 1] = 0;
               } else if(var28 == 0) {
                  class32.field747[++class103.field1686 - 1] = Integer.MAX_VALUE;
               } else {
                  class32.field747[++class103.field1686 - 1] = (int)Math.pow((double)var4, 1.0D / (double)var28);
               }

               var3 = 1;
            } else if(var0 == 4014) {
               class103.field1686 -= 2;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[1 + class103.field1686];
               class32.field747[++class103.field1686 - 1] = var4 & var28;
               var3 = 1;
            } else if(var0 == 4015) {
               class103.field1686 -= 2;
               var4 = class32.field747[class103.field1686];
               var28 = class32.field747[class103.field1686 + 1];
               class32.field747[++class103.field1686 - 1] = var4 | var28;
               var3 = 1;
            } else if(var0 == 4018) {
               class103.field1686 -= 3;
               long var18 = (long)class32.field747[class103.field1686];
               long var22 = (long)class32.field747[class103.field1686 + 1];
               long var20 = (long)class32.field747[2 + class103.field1686];
               class32.field747[++class103.field1686 - 1] = (int)(var18 * var20 / var22);
               var3 = 1;
            } else {
               var3 = 2;
            }

            return var3;
         } else if(var0 < 4200) {
            return class103.method2043(var0, var1, var2);
         } else {
            boolean var16;
            if(var0 < 4300) {
               if(var0 == 4200) {
                  var4 = class32.field747[--class103.field1686];
                  class32.chatboxSegments[++class32.field749 - 1] = class103.getItemDefinition(var4).name;
                  var3 = 1;
               } else {
                  ItemComposition var17;
                  if(var0 == 4201) {
                     class103.field1686 -= 2;
                     var4 = class32.field747[class103.field1686];
                     var28 = class32.field747[1 + class103.field1686];
                     var17 = class103.getItemDefinition(var4);
                     if(var28 >= 1 && var28 <= 5 && var17.groundActions[var28 - 1] != null) {
                        class32.chatboxSegments[++class32.field749 - 1] = var17.groundActions[var28 - 1];
                     } else {
                        class32.chatboxSegments[++class32.field749 - 1] = "";
                     }

                     var3 = 1;
                  } else if(var0 == 4202) {
                     class103.field1686 -= 2;
                     var4 = class32.field747[class103.field1686];
                     var28 = class32.field747[class103.field1686 + 1];
                     var17 = class103.getItemDefinition(var4);
                     if(var28 >= 1 && var28 <= 5 && var17.inventoryActions[var28 - 1] != null) {
                        class32.chatboxSegments[++class32.field749 - 1] = var17.inventoryActions[var28 - 1];
                     } else {
                        class32.chatboxSegments[++class32.field749 - 1] = "";
                     }

                     var3 = 1;
                  } else if(var0 == 4203) {
                     var4 = class32.field747[--class103.field1686];
                     class32.field747[++class103.field1686 - 1] = class103.getItemDefinition(var4).price;
                     var3 = 1;
                  } else if(var0 == 4204) {
                     var4 = class32.field747[--class103.field1686];
                     class32.field747[++class103.field1686 - 1] = class103.getItemDefinition(var4).isStackable == 1?1:0;
                     var3 = 1;
                  } else {
                     ItemComposition var34;
                     if(var0 == 4205) {
                        var4 = class32.field747[--class103.field1686];
                        var34 = class103.getItemDefinition(var4);
                        if(var34.notedTemplate == -1 && var34.note >= 0) {
                           class32.field747[++class103.field1686 - 1] = var34.note;
                        } else {
                           class32.field747[++class103.field1686 - 1] = var4;
                        }

                        var3 = 1;
                     } else if(var0 == 4206) {
                        var4 = class32.field747[--class103.field1686];
                        var34 = class103.getItemDefinition(var4);
                        if(var34.notedTemplate >= 0 && var34.note >= 0) {
                           class32.field747[++class103.field1686 - 1] = var34.note;
                        } else {
                           class32.field747[++class103.field1686 - 1] = var4;
                        }

                        var3 = 1;
                     } else if(var0 == 4207) {
                        var4 = class32.field747[--class103.field1686];
                        class32.field747[++class103.field1686 - 1] = class103.getItemDefinition(var4).isMembers?1:0;
                        var3 = 1;
                     } else if(var0 == 4208) {
                        var4 = class32.field747[--class103.field1686];
                        var34 = class103.getItemDefinition(var4);
                        if(var34.field2976 == -1 && var34.field3000 >= 0) {
                           class32.field747[++class103.field1686 - 1] = var34.field3000;
                        } else {
                           class32.field747[++class103.field1686 - 1] = var4;
                        }

                        var3 = 1;
                     } else if(var0 == 4209) {
                        var4 = class32.field747[--class103.field1686];
                        var34 = class103.getItemDefinition(var4);
                        if(var34.field2976 >= 0 && var34.field3000 >= 0) {
                           class32.field747[++class103.field1686 - 1] = var34.field3000;
                        } else {
                           class32.field747[++class103.field1686 - 1] = var4;
                        }

                        var3 = 1;
                     } else if(var0 == 4210) {
                        String var31 = class32.chatboxSegments[--class32.field749];
                        var28 = class32.field747[--class103.field1686];
                        var16 = var28 == 1;
                        String var36 = var31.toLowerCase();
                        short[] var8 = new short[16];
                        var25 = 0;
                        int var10 = 0;

                        while(true) {
                           if(var10 >= ItemComposition.field2960) {
                              class1.field14 = var8;
                              Overlay.field3051 = 0;
                              class18.field208 = var25;
                              String[] var26 = new String[class18.field208];

                              for(int var27 = 0; var27 < class18.field208; ++var27) {
                                 var26[var27] = class103.getItemDefinition(var8[var27]).name;
                              }

                              Frames.method1961(var26, class1.field14);
                              break;
                           }

                           ItemComposition var11 = class103.getItemDefinition(var10);
                           if((!var16 || var11.field2997) && var11.notedTemplate == -1 && var11.name.toLowerCase().indexOf(var36) != -1) {
                              if(var25 >= 250) {
                                 class18.field208 = -1;
                                 class1.field14 = null;
                                 break;
                              }

                              if(var25 >= var8.length) {
                                 short[] var12 = new short[var8.length * 2];

                                 for(int var13 = 0; var13 < var25; ++var13) {
                                    var12[var13] = var8[var13];
                                 }

                                 var8 = var12;
                              }

                              var8[var25++] = (short)var10;
                           }

                           ++var10;
                        }

                        class32.field747[++class103.field1686 - 1] = class18.field208;
                        var3 = 1;
                     } else if(var0 == 4211) {
                        if(null != class1.field14 && Overlay.field3051 < class18.field208) {
                           class32.field747[++class103.field1686 - 1] = class1.field14[++Overlay.field3051 - 1] & '\uffff';
                        } else {
                           class32.field747[++class103.field1686 - 1] = -1;
                        }

                        var3 = 1;
                     } else if(var0 == 4212) {
                        Overlay.field3051 = 0;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }
                  }
               }

               return var3;
            } else if(var0 < 5100) {
               return class8.method94(var0, var1, var2);
            } else if(var0 < 5400) {
               if(var0 == 5306) {
                  class32.field747[++class103.field1686 - 1] = class8.method97();
                  var3 = 1;
               } else if(var0 == 5307) {
                  var4 = class32.field747[--class103.field1686];
                  if(var4 == 1 || var4 == 2) {
                     class47.method966(var4);
                  }

                  var3 = 1;
               } else if(var0 == 5308) {
                  class32.field747[++class103.field1686 - 1] = class184.field2735.field716;
                  var3 = 1;
               } else if(var0 == 5309) {
                  var4 = class32.field747[--class103.field1686];
                  if(var4 == 1 || var4 == 2) {
                     class184.field2735.field716 = var4;
                     class99.method1996();
                  }

                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 5600) {
               if(var0 == 5504) {
                  class103.field1686 -= 2;
                  var33 = class32.field747[class103.field1686];
                  var24 = class32.field747[class103.field1686 + 1];
                  if(!Client.field553) {
                     Client.field541 = var33;
                     Client.mapAngle = var24;
                  }

                  var3 = 1;
               } else if(var0 == 5505) {
                  class32.field747[++class103.field1686 - 1] = Client.field541;
                  var3 = 1;
               } else if(var0 == 5506) {
                  class32.field747[++class103.field1686 - 1] = Client.mapAngle;
                  var3 = 1;
               } else if(var0 == 5530) {
                  var33 = class32.field747[--class103.field1686];
                  if(var33 < 0) {
                     var33 = 0;
                  }

                  Client.field394 = var33;
                  var3 = 1;
               } else if(var0 == 5531) {
                  class32.field747[++class103.field1686 - 1] = Client.field394;
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 5700) {
               if(var0 == 5630) {
                  Client.field358 = 250;
                  var3 = 1;
               } else {
                  var3 = 2;
               }

               return var3;
            } else if(var0 < 6300) {
               return class112.method2145(var0, var1, var2);
            } else if(var0 >= 6600) {
               return 2;
            } else {
               if(var0 == 6500) {
                  class32.field747[++class103.field1686 - 1] = class189.loadWorlds()?1:0;
                  var3 = 1;
               } else {
                  World var14;
                  if(var0 == 6501) {
                     World.field711 = 0;
                     var14 = class11.method148();
                     if(null != var14) {
                        class32.field747[++class103.field1686 - 1] = var14.id;
                        class32.field747[++class103.field1686 - 1] = var14.mask;
                        class32.chatboxSegments[++class32.field749 - 1] = var14.activity;
                        class32.field747[++class103.field1686 - 1] = var14.location;
                        class32.field747[++class103.field1686 - 1] = var14.playerCount;
                        class32.chatboxSegments[++class32.field749 - 1] = var14.address;
                     } else {
                        class32.field747[++class103.field1686 - 1] = -1;
                        class32.field747[++class103.field1686 - 1] = 0;
                        class32.chatboxSegments[++class32.field749 - 1] = "";
                        class32.field747[++class103.field1686 - 1] = 0;
                        class32.field747[++class103.field1686 - 1] = 0;
                        class32.chatboxSegments[++class32.field749 - 1] = "";
                     }

                     var3 = 1;
                  } else if(var0 == 6502) {
                     var14 = class11.method148();
                     if(null != var14) {
                        class32.field747[++class103.field1686 - 1] = var14.id;
                        class32.field747[++class103.field1686 - 1] = var14.mask;
                        class32.chatboxSegments[++class32.field749 - 1] = var14.activity;
                        class32.field747[++class103.field1686 - 1] = var14.location;
                        class32.field747[++class103.field1686 - 1] = var14.playerCount;
                        class32.chatboxSegments[++class32.field749 - 1] = var14.address;
                     } else {
                        class32.field747[++class103.field1686 - 1] = -1;
                        class32.field747[++class103.field1686 - 1] = 0;
                        class32.chatboxSegments[++class32.field749 - 1] = "";
                        class32.field747[++class103.field1686 - 1] = 0;
                        class32.field747[++class103.field1686 - 1] = 0;
                        class32.chatboxSegments[++class32.field749 - 1] = "";
                     }

                     var3 = 1;
                  } else {
                     World var15;
                     if(var0 == 6506) {
                        var4 = class32.field747[--class103.field1686];
                        var15 = null;

                        for(var6 = 0; var6 < World.field703; ++var6) {
                           if(var4 == World.worldList[var6].id) {
                              var15 = World.worldList[var6];
                              break;
                           }
                        }

                        if(null != var15) {
                           class32.field747[++class103.field1686 - 1] = var15.id;
                           class32.field747[++class103.field1686 - 1] = var15.mask;
                           class32.chatboxSegments[++class32.field749 - 1] = var15.activity;
                           class32.field747[++class103.field1686 - 1] = var15.location;
                           class32.field747[++class103.field1686 - 1] = var15.playerCount;
                           class32.chatboxSegments[++class32.field749 - 1] = var15.address;
                        } else {
                           class32.field747[++class103.field1686 - 1] = -1;
                           class32.field747[++class103.field1686 - 1] = 0;
                           class32.chatboxSegments[++class32.field749 - 1] = "";
                           class32.field747[++class103.field1686 - 1] = 0;
                           class32.field747[++class103.field1686 - 1] = 0;
                           class32.chatboxSegments[++class32.field749 - 1] = "";
                        }

                        var3 = 1;
                     } else if(var0 == 6507) {
                        class103.field1686 -= 4;
                        var4 = class32.field747[class103.field1686];
                        boolean var5 = class32.field747[1 + class103.field1686] == 1;
                        var6 = class32.field747[2 + class103.field1686];
                        var16 = class32.field747[3 + class103.field1686] == 1;
                        if(World.worldList != null) {
                           Client.method600(0, World.worldList.length - 1, var4, var5, var6, var16);
                        }

                        var3 = 1;
                     } else if(var0 == 6511) {
                        var4 = class32.field747[--class103.field1686];
                        if(var4 >= 0 && var4 < World.field703) {
                           var15 = World.worldList[var4];
                           class32.field747[++class103.field1686 - 1] = var15.id;
                           class32.field747[++class103.field1686 - 1] = var15.mask;
                           class32.chatboxSegments[++class32.field749 - 1] = var15.activity;
                           class32.field747[++class103.field1686 - 1] = var15.location;
                           class32.field747[++class103.field1686 - 1] = var15.playerCount;
                           class32.chatboxSegments[++class32.field749 - 1] = var15.address;
                        } else {
                           class32.field747[++class103.field1686 - 1] = -1;
                           class32.field747[++class103.field1686 - 1] = 0;
                           class32.chatboxSegments[++class32.field749 - 1] = "";
                           class32.field747[++class103.field1686 - 1] = 0;
                           class32.field747[++class103.field1686 - 1] = 0;
                           class32.chatboxSegments[++class32.field749 - 1] = "";
                        }

                        var3 = 1;
                     } else if(var0 == 6512) {
                        Client.field314 = class32.field747[--class103.field1686] == 1;
                        var3 = 1;
                     } else {
                        var3 = 2;
                     }
                  }
               }

               return var3;
            }
         }
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1302028284"
   )
   static final void method255() {
      Client.field350.method3072();
      int var0 = Client.field350.method3095(8);
      int var1;
      if(var0 < Client.field340) {
         for(var1 = var0; var1 < Client.field340; ++var1) {
            Client.field388[++Client.field428 - 1] = Client.field345[var1];
         }
      }

      if(var0 > Client.field340) {
         throw new RuntimeException("");
      } else {
         Client.field340 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.field345[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.field350.method3095(1);
            if(var4 == 0) {
               Client.field345[++Client.field340 - 1] = var2;
               var3.field672 = Client.gameCycle;
            } else {
               int var5 = Client.field350.method3095(2);
               if(var5 == 0) {
                  Client.field345[++Client.field340 - 1] = var2;
                  var3.field672 = Client.gameCycle;
                  Client.field347[++Client.field346 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.field345[++Client.field340 - 1] = var2;
                     var3.field672 = Client.gameCycle;
                     var6 = Client.field350.method3095(3);
                     var3.method805(var6, (byte)1);
                     var7 = Client.field350.method3095(1);
                     if(var7 == 1) {
                        Client.field347[++Client.field346 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.field345[++Client.field340 - 1] = var2;
                     var3.field672 = Client.gameCycle;
                     var6 = Client.field350.method3095(3);
                     var3.method805(var6, (byte)2);
                     var7 = Client.field350.method3095(3);
                     var3.method805(var7, (byte)2);
                     int var8 = Client.field350.method3095(1);
                     if(var8 == 1) {
                        Client.field347[++Client.field346 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field388[++Client.field428 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "-1297033578"
   )
   static int method256(int var0, Script var1, boolean var2) {
      Widget var3 = var2?XGrandExchangeOffer.field58:field297;
      if(var0 == 1700) {
         class32.field747[++class103.field1686 - 1] = var3.item;
         return 1;
      } else if(var0 == 1701) {
         if(var3.item != -1) {
            class32.field747[++class103.field1686 - 1] = var3.stackSize;
         } else {
            class32.field747[++class103.field1686 - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class32.field747[++class103.field1686 - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }
}
