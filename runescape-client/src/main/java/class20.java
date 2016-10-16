import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class20 extends Node {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1363061497
   )
   int field553;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1860906599
   )
   int field554;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1997950397
   )
   int field555;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1530345621
   )
   int field556;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 1408899897
   )
   static int field558;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1164465339"
   )
   public static boolean method532(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1558175147"
   )
   void method533(int var1, int var2, int var3, int var4) {
      this.field556 = var1;
      this.field554 = var2;
      this.field555 = var3;
      this.field553 = var4;
   }

   class20(int var1, int var2, int var3, int var4) {
      this.field556 = var1;
      this.field554 = var2;
      this.field555 = var3;
      this.field553 = var4;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1570888823"
   )
   static void method536(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field633[var5]) {
            var2[var4] = World.field633[var5];
            var3[var4] = World.field632[var5];
            ++var4;
         }
      }

      World.field633 = var2;
      World.field632 = var3;
      method537(World.worldList, 0, World.worldList.length - 1, World.field633, World.field632);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "1564777885"
   )
   static void method537(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method607()?1:0;
                     var12 = var8.method607()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method607()?1:0;
                     var12 = var8.method607()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method537(var0, var1, var6, var3, var4);
         method537(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LGameEngine;B)V",
      garbageValue = "-25"
   )
   static void method538(GameEngine var0) {
      int var1;
      int var10;
      int var11;
      int var12;
      if(class33.worldSelectShown) {
         if(class143.field2198 == 1 || !class18.field245 && class143.field2198 == 4) {
            var1 = class33.field715 + 280;
            if(class143.field2188 >= var1 && class143.field2188 <= 14 + var1 && class143.field2196 >= 4 && class143.field2196 <= 18) {
               method536(0, 0);
            } else if(class143.field2188 >= var1 + 15 && class143.field2188 <= var1 + 80 && class143.field2196 >= 4 && class143.field2196 <= 18) {
               method536(0, 1);
            } else {
               var10 = 390 + class33.field715;
               if(class143.field2188 >= var10 && class143.field2188 <= var10 + 14 && class143.field2196 >= 4 && class143.field2196 <= 18) {
                  method536(1, 0);
               } else if(class143.field2188 >= 15 + var10 && class143.field2188 <= var10 + 80 && class143.field2196 >= 4 && class143.field2196 <= 18) {
                  method536(1, 1);
               } else {
                  var11 = class33.field715 + 500;
                  if(class143.field2188 >= var11 && class143.field2188 <= 14 + var11 && class143.field2196 >= 4 && class143.field2196 <= 18) {
                     method536(2, 0);
                  } else if(class143.field2188 >= var11 + 15 && class143.field2188 <= var11 + 80 && class143.field2196 >= 4 && class143.field2196 <= 18) {
                     method536(2, 1);
                  } else {
                     var12 = class33.field715 + 610;
                     if(class143.field2188 >= var12 && class143.field2188 <= var12 + 14 && class143.field2196 >= 4 && class143.field2196 <= 18) {
                        method536(3, 0);
                     } else if(class143.field2188 >= 15 + var12 && class143.field2188 <= 80 + var12 && class143.field2196 >= 4 && class143.field2196 <= 18) {
                        method536(3, 1);
                     } else if(class143.field2188 >= 708 + class33.field715 && class143.field2196 >= 4 && class143.field2188 <= class33.field715 + 708 + 50 && class143.field2196 <= 20) {
                        class33.worldSelectShown = false;
                        class33.field725.method1710(class33.field715, 0);
                        class129.field2078.method1710(382 + class33.field715, 0);
                        class33.field704.method1871(382 + class33.field715 - class33.field704.originalWidth / 2, 18);
                     } else if(class33.field734 != -1) {
                        World var9 = World.worldList[class33.field734];
                        class22.selectWorld(var9);
                        class33.worldSelectShown = false;
                        class33.field725.method1710(class33.field715, 0);
                        class129.field2078.method1710(class33.field715 + 382, 0);
                        class33.field704.method1871(class33.field715 + 382 - class33.field704.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((class143.field2198 == 1 || !class18.field245 && class143.field2198 == 4) && class143.field2188 >= 765 + class33.field715 - 50 && class143.field2196 >= 453) {
            Sequence.field984.field124 = !Sequence.field984.field124;
            class129.method2815();
            if(!Sequence.field984.field124) {
               Item.method675(class47.field1024, "scape main", "", 255, false);
            } else {
               class186.field3007.method3587();
               class186.field3002 = 1;
               XItemContainer.field200 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class33.field716;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.field346 == 0) {
                  if(class143.field2198 == 1 || !class18.field245 && class143.field2198 == 4) {
                     var1 = 5 + class33.field715;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class143.field2188 >= var1 && class143.field2188 <= var3 + var1 && class143.field2196 >= var2 && class143.field2196 <= var4 + var2) {
                        class23.method577();
                        return;
                     }
                  }

                  if(null != ClassInfo.worldServersDownload) {
                     class23.method577();
                  }
               }

               var1 = class143.field2198;
               var10 = class143.field2188;
               var11 = class143.field2196;
               if(!class18.field245 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               if(class33.loginIndex == 0) {
                  var12 = class33.loginWindowX + 180 - 80;
                  var5 = 291;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                     class11.method152(Sequence.method911("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var12 = 80 + 180 + class33.loginWindowX;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                     if((Client.flags & 33554432) != 0) {
                        class33.field709 = "";
                        class33.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class33.loginMessage2 = "Your normal account will not be affected.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class33.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class33.loginMessage2 = "Players can attack each other almost everywhere";
                           class33.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class33.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class33.loginMessage2 = "Players can attack each other";
                           class33.loginMessage3 = "almost everywhere.";
                        }

                        class33.field709 = "Warning!";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class33.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class33.loginMessage2 = "The Protect Item prayer will";
                        class33.loginMessage3 = "not work on this world.";
                        class33.field709 = "Warning!";
                        class33.loginIndex = 1;
                        class33.loginIndex2 = 0;
                     } else {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     }
                  }
               } else if(class33.loginIndex != 1) {
                  short var13;
                  if(class33.loginIndex == 2) {
                     var13 = 231;
                     var12 = var13 + 30;
                     if(var1 == 1 && var11 >= var12 - 15 && var11 < var12) {
                        class33.loginIndex2 = 0;
                     }

                     var12 += 15;
                     if(var1 == 1 && var11 >= var12 - 15 && var11 < var12) {
                        class33.loginIndex2 = 1;
                     }

                     var12 += 15;
                     var13 = 361;
                     if(var1 == 1 && var11 >= var13 - 15 && var11 < var13) {
                        class79.method1681("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }

                     int var14 = 180 + class33.loginWindowX - 80;
                     short var6 = 321;
                     if(var1 == 1 && var10 >= var14 - 75 && var10 <= var14 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                        class33.username = class33.username.trim();
                        if(class33.username.length() == 0) {
                           class79.method1681("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class33.field726.length() == 0) {
                           class79.method1681("", "Please enter your password.", "");
                           return;
                        }

                        class79.method1681("", "Connecting to server...", "");
                        class33.field736 = Sequence.field984.field126.containsKey(Integer.valueOf(Renderable.method1905(class33.username)))?class162.field2648:class162.field2643;
                        class112.setGameState(20);
                        return;
                     }

                     var14 = 80 + 180 + class33.loginWindowX;
                     if(var1 == 1 && var10 >= var14 - 75 && var10 <= var14 + 75 && var11 >= var6 - 20 && var11 <= 20 + var6) {
                        class33.loginIndex = 0;
                        class33.username = "";
                        class33.field726 = "";
                        Tile.field1787 = 0;
                        class51.authCode = "";
                        class33.field728 = true;
                     }

                     while(true) {
                        while(class4.method44()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class130.field2084 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
                                 break;
                              }
                           }

                           if(class162.field2650 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field726 = "";
                              Tile.field1787 = 0;
                              class51.authCode = "";
                              class33.field728 = true;
                           } else if(class33.loginIndex2 == 0) {
                              if(class162.field2650 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(class162.field2650 == 84 || class162.field2650 == 80) {
                                 class33.loginIndex2 = 1;
                              }

                              if(var7 && class33.username.length() < 320) {
                                 class33.username = class33.username + class130.field2084;
                              }
                           } else if(class33.loginIndex2 == 1) {
                              if(class162.field2650 == 85 && class33.field726.length() > 0) {
                                 class33.field726 = class33.field726.substring(0, class33.field726.length() - 1);
                              }

                              if(class162.field2650 == 84 || class162.field2650 == 80) {
                                 class33.loginIndex2 = 0;
                              }

                              if(class162.field2650 == 84) {
                                 class33.username = class33.username.trim();
                                 if(class33.username.length() == 0) {
                                    class79.method1681("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class33.field726.length() == 0) {
                                    class79.method1681("", "Please enter your password.", "");
                                    return;
                                 }

                                 class79.method1681("", "Connecting to server...", "");
                                 class33.field736 = Sequence.field984.field126.containsKey(Integer.valueOf(Renderable.method1905(class33.username)))?class162.field2648:class162.field2643;
                                 class112.setGameState(20);
                                 return;
                              }

                              if(var7 && class33.field726.length() < 20) {
                                 class33.field726 = class33.field726 + class130.field2084;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class33.loginIndex == 3) {
                     var12 = class33.loginWindowX + 180;
                     var5 = 276;
                     if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     }

                     var12 = 180 + class33.loginWindowX;
                     var5 = 326;
                     if(var1 == 1 && var10 >= var12 - 75 && var10 <= var12 + 75 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                        class79.method1681("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class33.loginIndex = 5;
                        return;
                     }
                  } else {
                     boolean var15;
                     int var16;
                     if(class33.loginIndex == 4) {
                        var12 = class33.loginWindowX + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                           class51.authCode.trim();
                           if(class51.authCode.length() != 6) {
                              class79.method1681("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           Tile.field1787 = Integer.parseInt(class51.authCode);
                           class51.authCode = "";
                           class33.field736 = class33.field728?class162.field2644:class162.field2651;
                           class79.method1681("", "Connecting to server...", "");
                           class112.setGameState(20);
                           return;
                        }

                        if(var1 == 1 && var10 >= class33.loginWindowX + 180 - 9 && var10 <= 130 + 180 + class33.loginWindowX && var11 >= 263 && var11 <= 296) {
                           class33.field728 = !class33.field728;
                        }

                        if(var1 == 1 && var10 >= class33.loginWindowX + 180 - 34 && var10 <= 180 + class33.loginWindowX + 34 && var11 >= 351 && var11 <= 363) {
                           class11.method152(Sequence.method911("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                        }

                        var12 = class33.loginWindowX + 180 + 80;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                           class33.loginIndex = 0;
                           class33.username = "";
                           class33.field726 = "";
                           Tile.field1787 = 0;
                           class51.authCode = "";
                        }

                        while(class4.method44()) {
                           var15 = false;

                           for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                              if(class130.field2084 == "1234567890".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(class162.field2650 == 13) {
                              class33.loginIndex = 0;
                              class33.username = "";
                              class33.field726 = "";
                              Tile.field1787 = 0;
                              class51.authCode = "";
                           } else {
                              if(class162.field2650 == 85 && class51.authCode.length() > 0) {
                                 class51.authCode = class51.authCode.substring(0, class51.authCode.length() - 1);
                              }

                              if(class162.field2650 == 84) {
                                 class51.authCode.trim();
                                 if(class51.authCode.length() != 6) {
                                    class79.method1681("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 Tile.field1787 = Integer.parseInt(class51.authCode);
                                 class51.authCode = "";
                                 class33.field736 = class33.field728?class162.field2644:class162.field2651;
                                 class79.method1681("", "Connecting to server...", "");
                                 class112.setGameState(20);
                                 return;
                              }

                              if(var15 && class51.authCode.length() < 6) {
                                 class51.authCode = class51.authCode + class130.field2084;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 5) {
                        var12 = class33.loginWindowX + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                           class93.method2079();
                           return;
                        }

                        var12 = 80 + class33.loginWindowX + 180;
                        if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= 20 + var5) {
                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field726 = "";
                        }

                        while(class4.method44()) {
                           var15 = false;

                           for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                              if(class130.field2084 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                 var15 = true;
                                 break;
                              }
                           }

                           if(class162.field2650 == 13) {
                              class33.loginMessage1 = "";
                              class33.loginMessage2 = "Enter your username/email & password.";
                              class33.loginMessage3 = "";
                              class33.loginIndex = 2;
                              class33.loginIndex2 = 0;
                              class33.field726 = "";
                           } else {
                              if(class162.field2650 == 85 && class33.username.length() > 0) {
                                 class33.username = class33.username.substring(0, class33.username.length() - 1);
                              }

                              if(class162.field2650 == 84) {
                                 class93.method2079();
                                 return;
                              }

                              if(var15 && class33.username.length() < 320) {
                                 class33.username = class33.username + class130.field2084;
                              }
                           }
                        }
                     } else if(class33.loginIndex == 6) {
                        while(true) {
                           do {
                              if(!class4.method44()) {
                                 var13 = 321;
                                 if(var1 == 1 && var11 >= var13 - 20 && var11 <= 20 + var13) {
                                    class33.loginMessage1 = "";
                                    class33.loginMessage2 = "Enter your username/email & password.";
                                    class33.loginMessage3 = "";
                                    class33.loginIndex = 2;
                                    class33.loginIndex2 = 0;
                                    class33.field726 = "";
                                 }

                                 return;
                              }
                           } while(class162.field2650 != 84 && class162.field2650 != 13);

                           class33.loginMessage1 = "";
                           class33.loginMessage2 = "Enter your username/email & password.";
                           class33.loginMessage3 = "";
                           class33.loginIndex = 2;
                           class33.loginIndex2 = 0;
                           class33.field726 = "";
                        }
                     }
                  }
               } else {
                  while(class4.method44()) {
                     if(class162.field2650 == 84) {
                        class33.loginMessage1 = "";
                        class33.loginMessage2 = "Enter your username/email & password.";
                        class33.loginMessage3 = "";
                        class33.loginIndex = 2;
                        class33.loginIndex2 = 0;
                     } else if(class162.field2650 == 13) {
                        class33.loginIndex = 0;
                     }
                  }

                  var12 = 180 + class33.loginWindowX - 80;
                  var5 = 321;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                     class33.loginMessage1 = "";
                     class33.loginMessage2 = "Enter your username/email & password.";
                     class33.loginMessage3 = "";
                     class33.loginIndex = 2;
                     class33.loginIndex2 = 0;
                  }

                  var12 = 80 + 180 + class33.loginWindowX;
                  if(var1 == 1 && var10 >= var12 - 75 && var10 <= 75 + var12 && var11 >= var5 - 20 && var11 <= var5 + 20) {
                     class33.loginIndex = 0;
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1890066391"
   )
   static final void method539(int var0) {
      class130.method2821();
      class62.method1272();
      int var1 = class125.method2774(var0).field1199;
      if(var1 != 0) {
         int var2 = class179.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class94.method2086(0.9D);
               ((TextureProvider)class94.field1625).method2175(0.9D);
            }

            if(var2 == 2) {
               class94.method2086(0.8D);
               ((TextureProvider)class94.field1625).method2175(0.8D);
            }

            if(var2 == 3) {
               class94.method2086(0.7D);
               ((TextureProvider)class94.field1625).method2175(0.7D);
            }

            if(var2 == 4) {
               class94.method2086(0.6D);
               ((TextureProvider)class94.field1625).method2175(0.6D);
            }

            class133.method2826();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(Client.field424 != var3) {
               if(Client.field424 == 0 && Client.field506 != -1) {
                  class50.method1001(class47.field1024, Client.field506, 0, var3, false);
                  Client.field507 = false;
               } else if(var3 == 0) {
                  class186.field3007.method3587();
                  class186.field3002 = 1;
                  XItemContainer.field200 = null;
                  Client.field507 = false;
               } else {
                  class178.method3448(var3);
               }

               Client.field424 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field508 = 127;
            }

            if(var2 == 1) {
               Client.field508 = 96;
            }

            if(var2 == 2) {
               Client.field508 = 64;
            }

            if(var2 == 3) {
               Client.field508 = 32;
            }

            if(var2 == 4) {
               Client.field508 = 0;
            }
         }

         if(var1 == 5) {
            Client.field407 = var2;
         }

         if(var1 == 6) {
            Client.field430 = var2;
         }

         if(var1 == 9) {
            Client.field458 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field303 = 127;
            }

            if(var2 == 1) {
               Client.field303 = 96;
            }

            if(var2 == 2) {
               Client.field303 = 64;
            }

            if(var2 == 3) {
               Client.field303 = 32;
            }

            if(var2 == 4) {
               Client.field303 = 0;
            }
         }

         if(var1 == 17) {
            Client.field436 = var2 & '\uffff';
         }

         if(var1 == 18) {
            Client.field292 = (class21)SecondaryBufferProvider.method1646(class153.method3143(), var2);
            if(Client.field292 == null) {
               Client.field292 = class21.field562;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field399 = -1;
            } else {
               Client.field399 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            Client.field293 = (class21)SecondaryBufferProvider.method1646(class153.method3143(), var2);
            if(Client.field293 == null) {
               Client.field293 = class21.field562;
            }
         }

      }
   }
}
