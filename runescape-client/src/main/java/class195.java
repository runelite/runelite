import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class195 {
   @ObfuscatedName("pk")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1539378329
   )
   static int field2557;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2079114113
   )
   static int field2560;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2031092855
   )
   static int field2554;
   @ObfuscatedName("a")
   static byte[][] field2555;
   @ObfuscatedName("l")
   static byte[][] field2552;
   @ObfuscatedName("b")
   static byte[][] field2553;
   @ObfuscatedName("x")
   public static int[] field2558;
   @ObfuscatedName("p")
   public static byte[][][] field2559;

   static {
      field2557 = 0;
      field2560 = 0;
      field2554 = 0;
      field2555 = new byte[1000][];
      field2552 = new byte[250][];
      field2553 = new byte[50][];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IZI)[B",
      garbageValue = "-410474534"
   )
   static synchronized byte[] method3764(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(field2557 > 0) {
         var2 = field2555[--field2557];
         field2555[field2557] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(field2560 > 0) {
         var2 = field2552[--field2560];
         field2552[field2560] = null;
         return var2;
      }

      if(var0 != 30000) {
         if(var0 < 30000) {
            ;
         }
      } else if(field2554 > 0) {
         var2 = field2553[--field2554];
         field2553[field2554] = null;
         return var2;
      }

      if(field2559 != null) {
         for(int var4 = 0; var4 < CombatInfo1.field1202.length; ++var4) {
            if(CombatInfo1.field1202[var4] != var0) {
               if(var0 < CombatInfo1.field1202[var4]) {
                  ;
               }
            } else if(field2558[var4] > 0) {
               byte[] var3 = field2559[var4][--field2558[var4]];
               field2559[var4][field2558[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lbh;B)V",
      garbageValue = "2"
   )
   static void method3768(GameEngine var0) {
      int var14;
      if(class90.worldSelectShown) {
         if(MouseInput.mouseLastButton == 1 || !class153.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
            int var1 = class90.field1323 + 280;
            if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var1 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
               PendingSpawn.method1648(0, 0);
            } else if(MouseInput.mouseLastPressedX >= var1 + 15 && MouseInput.mouseLastPressedX <= var1 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
               PendingSpawn.method1648(0, 1);
            } else {
               int var2 = class90.field1323 + 390;
               if(MouseInput.mouseLastPressedX >= var2 && MouseInput.mouseLastPressedX <= var2 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                  PendingSpawn.method1648(1, 0);
               } else if(MouseInput.mouseLastPressedX >= var2 + 15 && MouseInput.mouseLastPressedX <= var2 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                  PendingSpawn.method1648(1, 1);
               } else {
                  int var16 = class90.field1323 + 500;
                  if(MouseInput.mouseLastPressedX >= var16 && MouseInput.mouseLastPressedX <= var16 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                     PendingSpawn.method1648(2, 0);
                  } else if(MouseInput.mouseLastPressedX >= var16 + 15 && MouseInput.mouseLastPressedX <= var16 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                     PendingSpawn.method1648(2, 1);
                  } else {
                     var14 = class90.field1323 + 610;
                     if(MouseInput.mouseLastPressedX >= var14 && MouseInput.mouseLastPressedX <= var14 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        PendingSpawn.method1648(3, 0);
                     } else if(MouseInput.mouseLastPressedX >= var14 + 15 && MouseInput.mouseLastPressedX <= var14 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        PendingSpawn.method1648(3, 1);
                     } else if(MouseInput.mouseLastPressedX >= class90.field1323 + 708 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedX <= class90.field1323 + 708 + 50 && MouseInput.mouseLastPressedY <= 20) {
                        class90.worldSelectShown = false;
                        Item.field1387.method5830(class90.field1323, 0);
                        class237.field2773.method5830(class90.field1323 + 382, 0);
                        class252.logoSprite.method5806(class90.field1323 + 382 - class252.logoSprite.originalWidth / 2, 18);
                     } else if(class90.field1322 != -1) {
                        World var15 = World.worldList[class90.field1322];
                        class45.changeWorld(var15);
                        class90.worldSelectShown = false;
                        Item.field1387.method5830(class90.field1323, 0);
                        class237.field2773.method5830(class90.field1323 + 382, 0);
                        class252.logoSprite.method5806(class90.field1323 + 382 - class252.logoSprite.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((MouseInput.mouseLastButton == 1 || !class153.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= class90.field1323 + 765 - 50 && MouseInput.mouseLastPressedY >= 453) {
            MapIcon.preferences.muted = !MapIcon.preferences.muted;
            class37.method538();
            if(!MapIcon.preferences.muted) {
               class183.method3434(Varbit.indexTrack1, "scape main", "", 255, false);
            } else {
               ScriptState.method1124();
            }
         }

         if(Client.gameState != 5) {
            if(-1L == class90.field1356) {
               class90.field1356 = WorldMapRegion.method465() + 1000L;
            }

            long var12 = WorldMapRegion.method465();
            boolean var3;
            if(Client.field1023 != null && Client.field1116 < Client.field1023.size()) {
               while(true) {
                  if(Client.field1116 >= Client.field1023.size()) {
                     var3 = true;
                     break;
                  }

                  class64 var4 = (class64)Client.field1023.get(Client.field1116);
                  if(!var4.method1129()) {
                     var3 = false;
                     break;
                  }

                  ++Client.field1116;
               }
            } else {
               var3 = true;
            }

            if(var3 && class90.field1357 == -1L) {
               class90.field1357 = var12;
               if(class90.field1357 > class90.field1356) {
                  class90.field1356 = class90.field1357;
               }
            }

            ++class90.field1336;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.languageId == 0) {
                  if(MouseInput.mouseLastButton == 1 || !class153.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
                     var14 = class90.field1323 + 5;
                     short var5 = 463;
                     byte var6 = 100;
                     byte var7 = 35;
                     if(MouseInput.mouseLastPressedX >= var14 && MouseInput.mouseLastPressedX <= var6 + var14 && MouseInput.mouseLastPressedY >= var5 && MouseInput.mouseLastPressedY <= var7 + var5) {
                        if(class155.loadWorlds()) {
                           class90.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(World.listFetcher != null && class155.loadWorlds()) {
                     class90.worldSelectShown = true;
                  }
               }

               var14 = MouseInput.mouseLastButton;
               int var17 = MouseInput.mouseLastPressedX;
               int var18 = MouseInput.mouseLastPressedY;
               if(var14 == 0) {
                  var17 = MouseInput.mouseLastX;
                  var18 = MouseInput.mouseLastY;
               }

               if(!class153.middleMouseMovesCamera && var14 == 4) {
                  var14 = 1;
               }

               int var8;
               short var9;
               if(class90.loginIndex == 0) {
                  boolean var19 = false;

                  while(class290.method5196()) {
                     if(class85.field1295 == 84) {
                        var19 = true;
                     }
                  }

                  var8 = Coordinates.field2778 - 80;
                  var9 = 291;
                  if(var14 == 1 && var17 >= var8 - 75 && var17 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
                     MouseInput.method1090(ClanMember.method5226("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var8 = Coordinates.field2778 + 80;
                  if(var14 == 1 && var17 >= var8 - 75 && var17 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20 || var19) {
                     if((Client.flags & 33554432) != 0) {
                        class90.Login_response0 = "";
                        class90.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class90.loginMessage2 = "Your normal account will not be affected.";
                        class90.loginMessage3 = "";
                        class90.loginIndex = 1;
                        if(class90.Login_isUsernameRemembered && class90.username != null && class90.username.length() > 0) {
                           class90.field1351 = 1;
                        } else {
                           class90.field1351 = 0;
                        }
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class90.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class90.loginMessage2 = "Players can attack each other almost everywhere";
                           class90.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class90.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class90.loginMessage2 = "Players can attack each other";
                           class90.loginMessage3 = "almost everywhere.";
                        }

                        class90.Login_response0 = "Warning!";
                        class90.loginIndex = 1;
                        if(class90.Login_isUsernameRemembered && class90.username != null && class90.username.length() > 0) {
                           class90.field1351 = 1;
                        } else {
                           class90.field1351 = 0;
                        }
                     } else if((Client.flags & 1024) != 0) {
                        class90.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class90.loginMessage2 = "The Protect Item prayer will";
                        class90.loginMessage3 = "not work on this world.";
                        class90.Login_response0 = "Warning!";
                        class90.loginIndex = 1;
                        if(class90.Login_isUsernameRemembered && class90.username != null && class90.username.length() > 0) {
                           class90.field1351 = 1;
                        } else {
                           class90.field1351 = 0;
                        }
                     } else {
                        class47.method752(false);
                     }
                  }
               } else {
                  int var20;
                  short var22;
                  if(class90.loginIndex != 1) {
                     short var21;
                     if(class90.loginIndex == 2) {
                        var21 = 201;
                        var20 = var21 + 52;
                        if(var14 == 1 && var18 >= var20 - 12 && var18 < var20 + 2) {
                           class90.field1351 = 0;
                        }

                        var20 += 15;
                        if(var14 == 1 && var18 >= var20 - 12 && var18 < var20 + 2) {
                           class90.field1351 = 1;
                        }

                        var20 += 15;
                        var21 = 361;
                        if(var14 == 1 && var18 >= var21 - 15 && var18 < var21) {
                           class93.method1974("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }

                        var8 = Coordinates.field2778 - 80;
                        var9 = 321;
                        if(var14 == 1 && var17 >= var8 - 75 && var17 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
                           class90.username = class90.username.trim();
                           if(class90.username.length() == 0) {
                              class93.method1974("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class90.password.length() == 0) {
                              class93.method1974("", "Please enter your password.", "");
                              return;
                           }

                           class93.method1974("", "Connecting to server...", "");
                           Player.method1218(false);
                           class20.setGameState(20);
                           return;
                        }

                        var8 = class90.loginWindowX + 180 + 80;
                        if(var14 == 1 && var17 >= var8 - 75 && var17 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
                           class90.loginIndex = 0;
                           class90.username = "";
                           class90.password = "";
                           class80.field1251 = 0;
                           Coordinates.field2779 = "";
                           class90.field1350 = true;
                        }

                        var8 = Coordinates.field2778 + -117;
                        var9 = 277;
                        class90.field1348 = var17 >= var8 && var17 < var8 + class7.field221 && var18 >= var9 && var18 < var9 + class279.field3554;
                        if(var14 == 1 && class90.field1348) {
                           class90.Login_isUsernameRemembered = !class90.Login_isUsernameRemembered;
                           if(!class90.Login_isUsernameRemembered && MapIcon.preferences.rememberedUsername != null) {
                              MapIcon.preferences.rememberedUsername = null;
                              class37.method538();
                           }
                        }

                        var8 = Coordinates.field2778 + 24;
                        var9 = 277;
                        class90.field1327 = var17 >= var8 && var17 < var8 + class7.field221 && var18 >= var9 && var18 < var9 + class279.field3554;
                        if(var14 == 1 && class90.field1327) {
                           MapIcon.preferences.hideUsername = !MapIcon.preferences.hideUsername;
                           if(!MapIcon.preferences.hideUsername) {
                              class90.username = "";
                              MapIcon.preferences.rememberedUsername = null;
                              if(class90.Login_isUsernameRemembered && class90.username != null && class90.username.length() > 0) {
                                 class90.field1351 = 1;
                              } else {
                                 class90.field1351 = 0;
                              }
                           }

                           class37.method538();
                        }

                        while(true) {
                           while(class290.method5196()) {
                              boolean var10 = false;

                              for(int var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var11) {
                                 if(Size.field341 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var11)) {
                                    var10 = true;
                                    break;
                                 }
                              }

                              if(class85.field1295 == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 class80.field1251 = 0;
                                 Coordinates.field2779 = "";
                                 class90.field1350 = true;
                              } else if(class90.field1351 == 0) {
                                 if(class85.field1295 == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(class85.field1295 == 84 || class85.field1295 == 80) {
                                    class90.field1351 = 1;
                                 }

                                 if(var10 && class90.username.length() < 320) {
                                    class90.username = class90.username + Size.field341;
                                 }
                              } else if(class90.field1351 == 1) {
                                 if(class85.field1295 == 85 && class90.password.length() > 0) {
                                    class90.password = class90.password.substring(0, class90.password.length() - 1);
                                 }

                                 if(class85.field1295 == 84 || class85.field1295 == 80) {
                                    class90.field1351 = 0;
                                 }

                                 if(class85.field1295 == 84) {
                                    class90.username = class90.username.trim();
                                    if(class90.username.length() == 0) {
                                       class93.method1974("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class90.password.length() == 0) {
                                       class93.method1974("", "Please enter your password.", "");
                                       return;
                                    }

                                    class93.method1974("", "Connecting to server...", "");
                                    Player.method1218(false);
                                    class20.setGameState(20);
                                    return;
                                 }

                                 if(var10 && class90.password.length() < 20) {
                                    class90.password = class90.password + Size.field341;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class90.loginIndex == 3) {
                        var20 = class90.loginWindowX + 180;
                        var22 = 276;
                        if(var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                           class47.method752(false);
                        }

                        var20 = class90.loginWindowX + 180;
                        var22 = 326;
                        if(var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                           class93.method1974("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var23;
                        int var24;
                        if(class90.loginIndex == 4) {
                           var20 = class90.loginWindowX + 180 - 80;
                           var22 = 321;
                           if(var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                              Coordinates.field2779.trim();
                              if(Coordinates.field2779.length() != 6) {
                                 class93.method1974("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class80.field1251 = Integer.parseInt(Coordinates.field2779);
                              Coordinates.field2779 = "";
                              Player.method1218(true);
                              class93.method1974("", "Connecting to server...", "");
                              class20.setGameState(20);
                              return;
                           }

                           if(var14 == 1 && var17 >= class90.loginWindowX + 180 - 9 && var17 <= class90.loginWindowX + 180 + 130 && var18 >= 263 && var18 <= 296) {
                              class90.field1350 = !class90.field1350;
                           }

                           if(var14 == 1 && var17 >= class90.loginWindowX + 180 - 34 && var17 <= class90.loginWindowX + 34 + 180 && var18 >= 351 && var18 <= 363) {
                              MouseInput.method1090(ClanMember.method5226("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var20 = class90.loginWindowX + 180 + 80;
                           if(var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                              class90.loginIndex = 0;
                              class90.username = "";
                              class90.password = "";
                              class80.field1251 = 0;
                              Coordinates.field2779 = "";
                           }

                           while(class290.method5196()) {
                              var23 = false;

                              for(var24 = 0; var24 < "1234567890".length(); ++var24) {
                                 if(Size.field341 == "1234567890".charAt(var24)) {
                                    var23 = true;
                                    break;
                                 }
                              }

                              if(class85.field1295 == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 class80.field1251 = 0;
                                 Coordinates.field2779 = "";
                              } else {
                                 if(class85.field1295 == 85 && Coordinates.field2779.length() > 0) {
                                    Coordinates.field2779 = Coordinates.field2779.substring(0, Coordinates.field2779.length() - 1);
                                 }

                                 if(class85.field1295 == 84) {
                                    Coordinates.field2779.trim();
                                    if(Coordinates.field2779.length() != 6) {
                                       class93.method1974("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class80.field1251 = Integer.parseInt(Coordinates.field2779);
                                    Coordinates.field2779 = "";
                                    Player.method1218(true);
                                    class93.method1974("", "Connecting to server...", "");
                                    class20.setGameState(20);
                                    return;
                                 }

                                 if(var23 && Coordinates.field2779.length() < 6) {
                                    Coordinates.field2779 = Coordinates.field2779 + Size.field341;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 5) {
                           var20 = class90.loginWindowX + 180 - 80;
                           var22 = 321;
                           if(var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                              GroundObject.method2672();
                              return;
                           }

                           var20 = class90.loginWindowX + 180 + 80;
                           if(var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                              class47.method752(true);
                           }

                           while(class290.method5196()) {
                              var23 = false;

                              for(var24 = 0; var24 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var24) {
                                 if(Size.field341 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var24)) {
                                    var23 = true;
                                    break;
                                 }
                              }

                              if(class85.field1295 == 13) {
                                 class47.method752(true);
                              } else {
                                 if(class85.field1295 == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(class85.field1295 == 84) {
                                    GroundObject.method2672();
                                    return;
                                 }

                                 if(var23 && class90.username.length() < 320) {
                                    class90.username = class90.username + Size.field341;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class290.method5196()) {
                                    var21 = 321;
                                    if(var14 == 1 && var18 >= var21 - 20 && var18 <= var21 + 20) {
                                       class47.method752(true);
                                    }

                                    return;
                                 }
                              } while(class85.field1295 != 84 && class85.field1295 != 13);

                              class47.method752(true);
                           }
                        }
                     }
                  } else {
                     while(class290.method5196()) {
                        if(class85.field1295 == 84) {
                           class47.method752(false);
                        } else if(class85.field1295 == 13) {
                           class90.loginIndex = 0;
                        }
                     }

                     var20 = Coordinates.field2778 - 80;
                     var22 = 321;
                     if(var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                        class47.method752(false);
                     }

                     var20 = Coordinates.field2778 + 80;
                     if(var14 == 1 && var17 >= var20 - 75 && var17 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                        class90.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-2023146657"
   )
   static void method3774(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < GrandExchangeOffer.field284; ++var4) {
         ItemComposition var5 = class81.getItemDefinition(var4);
         if((!var1 || var5.isTradable) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               SoundTask.field1569 = -1;
               class49.field576 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class49.field576 = var2;
      BoundingBox3D.field250 = 0;
      SoundTask.field1569 = var3;
      String[] var8 = new String[SoundTask.field1569];

      for(int var9 = 0; var9 < SoundTask.field1569; ++var9) {
         var8[var9] = class81.getItemDefinition(var2[var9]).name;
      }

      short[] var10 = class49.field576;
      NPC.method1904(var8, var10, 0, var8.length - 1);
   }
}
