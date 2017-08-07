import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("GraphicsObject")
public final class GraphicsObject extends Renderable {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -830262421
   )
   @Export("id")
   int id;
   @ObfuscatedName("u")
   @Export("finished")
   boolean finished;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1518959889
   )
   int field1350;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 371416595
   )
   int field1352;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   Sequence field1348;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -398596431
   )
   @Export("level")
   int level;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -959706489
   )
   @Export("x")
   int x;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 168781773
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -388014503
   )
   @Export("height")
   int height;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -67150293
   )
   @Export("startCycle")
   int startCycle;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field1352 = 0;
      this.field1350 = 0;
      this.finished = false;
      this.id = var1;
      this.level = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.startCycle = var7 + var6;
      int var8 = GameEngine.getSpotAnimType(this.id).field3331;
      if(var8 != -1) {
         this.finished = false;
         this.field1348 = Ignore.getAnimation(var8);
      } else {
         this.finished = true;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lew;",
      garbageValue = "-2113451941"
   )
   protected final Model getModel() {
      Spotanim var1 = GameEngine.getSpotAnimType(this.id);
      Model var2;
      if(!this.finished) {
         var2 = var1.method4337(this.field1352);
      } else {
         var2 = var1.method4337(-1);
      }

      return var2 == null?null:var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1097043746"
   )
   final void method1687(int var1) {
      if(!this.finished) {
         this.field1350 += var1;

         while(this.field1350 > this.field1348.frameLenghts[this.field1352]) {
            this.field1350 -= this.field1348.frameLenghts[this.field1352];
            ++this.field1352;
            if(this.field1352 >= this.field1348.frameIDs.length) {
               this.finished = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lfv;",
      garbageValue = "1587967020"
   )
   public static Timer method1693() {
      try {
         return new NanoTimer();
      } catch (Throwable var1) {
         return new MilliTimer();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lbp;B)V",
      garbageValue = "-127"
   )
   static void method1692(GameEngine var0) {
      int var1;
      int var2;
      int var3;
      int var14;
      if(class93.worldSelectShown) {
         if(MouseInput.field734 == 1 || !class51.field645 && MouseInput.field734 == 4) {
            var1 = class93.field1424 + 280;
            if(MouseInput.field725 >= var1 && MouseInput.field725 <= var1 + 14 && MouseInput.field726 >= 4 && MouseInput.field726 <= 18) {
               class223.method4075(0, 0);
            } else if(MouseInput.field725 >= var1 + 15 && MouseInput.field725 <= var1 + 80 && MouseInput.field726 >= 4 && MouseInput.field726 <= 18) {
               class223.method4075(0, 1);
            } else {
               var2 = class93.field1424 + 390;
               if(MouseInput.field725 >= var2 && MouseInput.field725 <= var2 + 14 && MouseInput.field726 >= 4 && MouseInput.field726 <= 18) {
                  class223.method4075(1, 0);
               } else if(MouseInput.field725 >= var2 + 15 && MouseInput.field725 <= var2 + 80 && MouseInput.field726 >= 4 && MouseInput.field726 <= 18) {
                  class223.method4075(1, 1);
               } else {
                  var3 = class93.field1424 + 500;
                  if(MouseInput.field725 >= var3 && MouseInput.field725 <= var3 + 14 && MouseInput.field726 >= 4 && MouseInput.field726 <= 18) {
                     class223.method4075(2, 0);
                  } else if(MouseInput.field725 >= var3 + 15 && MouseInput.field725 <= var3 + 80 && MouseInput.field726 >= 4 && MouseInput.field726 <= 18) {
                     class223.method4075(2, 1);
                  } else {
                     var14 = class93.field1424 + 610;
                     if(MouseInput.field725 >= var14 && MouseInput.field725 <= var14 + 14 && MouseInput.field726 >= 4 && MouseInput.field726 <= 18) {
                        class223.method4075(3, 0);
                     } else if(MouseInput.field725 >= var14 + 15 && MouseInput.field725 <= var14 + 80 && MouseInput.field726 >= 4 && MouseInput.field726 <= 18) {
                        class223.method4075(3, 1);
                     } else if(MouseInput.field725 >= class93.field1424 + 708 && MouseInput.field726 >= 4 && MouseInput.field725 <= class93.field1424 + 708 + 50 && MouseInput.field726 <= 20) {
                        class93.worldSelectShown = false;
                        class93.field1419.method5098(class93.field1424, 0);
                        class83.field1322.method5098(class93.field1424 + 382, 0);
                        Ignore.logoSprite.method5068(class93.field1424 + 382 - Ignore.logoSprite.originalWidth / 2, 18);
                     } else if(class93.field1449 != -1) {
                        World var5 = class51.worldList[class93.field1449];
                        class60.method1019(var5);
                        class93.worldSelectShown = false;
                        class93.field1419.method5098(class93.field1424, 0);
                        class83.field1322.method5098(class93.field1424 + 382, 0);
                        Ignore.logoSprite.method5068(class93.field1424 + 382 - Ignore.logoSprite.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((MouseInput.field734 == 1 || !class51.field645 && MouseInput.field734 == 4) && MouseInput.field725 >= class93.field1424 + 765 - 50 && MouseInput.field726 >= 453) {
            MilliTimer.preferences.muted = !MilliTimer.preferences.muted;
            Projectile.method1782();
            if(!MilliTimer.preferences.muted) {
               IndexData var9 = class244.indexTrack1;
               var2 = var9.getFile("scape main");
               var3 = var9.getChild(var2, "");
               WorldMapType1.method276(var9, var2, var3, 255, false);
            } else {
               class204.field2486.method3738();
               class204.field2487 = 1;
               class204.field2488 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class93.field1426;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.languageId == 0) {
                  if(MouseInput.field734 == 1 || !class51.field645 && MouseInput.field734 == 4) {
                     var1 = class93.field1424 + 5;
                     short var11 = 463;
                     byte var12 = 100;
                     byte var4 = 35;
                     if(MouseInput.field725 >= var1 && MouseInput.field725 <= var12 + var1 && MouseInput.field726 >= var11 && MouseInput.field726 <= var4 + var11) {
                        if(Signlink.loadWorlds()) {
                           class93.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(World.listFetcher != null && Signlink.loadWorlds()) {
                     class93.worldSelectShown = true;
                  }
               }

               var1 = MouseInput.field734;
               var2 = MouseInput.field725;
               var3 = MouseInput.field726;
               if(!class51.field645 && var1 == 4) {
                  var1 = 1;
               }

               short var6;
               int var10;
               if(class93.loginIndex == 0) {
                  boolean var13 = false;

                  while(WorldMapType1.method279()) {
                     if(Coordinates.field2589 == 84) {
                        var13 = true;
                     }
                  }

                  var10 = class93.loginWindowX + 180 - 80;
                  var6 = 291;
                  if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                     class9.method46(class89.method1733("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var10 = class93.loginWindowX + 180 + 80;
                  if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20 || var13) {
                     if((Client.flags & 33554432) != 0) {
                        class93.field1448 = "";
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

                        class93.field1448 = "Warning!";
                        class93.loginIndex = 1;
                        class93.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class93.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class93.loginMessage2 = "The Protect Item prayer will";
                        class93.loginMessage3 = "not work on this world.";
                        class93.field1448 = "Warning!";
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
                  short var18;
                  if(class93.loginIndex != 1) {
                     short var15;
                     if(class93.loginIndex == 2) {
                        var15 = 231;
                        var14 = var15 + 30;
                        if(var1 == 1 && var3 >= var14 - 15 && var3 < var14) {
                           class93.loginIndex2 = 0;
                        }

                        var14 += 15;
                        if(var1 == 1 && var3 >= var14 - 15 && var3 < var14) {
                           class93.loginIndex2 = 1;
                        }

                        var14 += 15;
                        var15 = 361;
                        if(var1 == 1 && var3 >= var15 - 15 && var3 < var15) {
                           class19.method154("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class93.loginIndex = 5;
                           return;
                        }

                        var10 = class93.loginWindowX + 180 - 80;
                        var6 = 321;
                        if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                           class93.username = class93.username.trim();
                           if(class93.username.length() == 0) {
                              class19.method154("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class93.password.length() == 0) {
                              class19.method154("", "Please enter your password.", "");
                              return;
                           }

                           class19.method154("", "Connecting to server...", "");
                           class93.field1447 = MilliTimer.preferences.preferences.containsKey(Integer.valueOf(class245.method4332(class93.username)))?class150.field2185:class150.field2184;
                           WorldMapType1.setGameState(20);
                           return;
                        }

                        var10 = class93.loginWindowX + 180 + 80;
                        if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                           class93.loginIndex = 0;
                           class93.username = "";
                           class93.password = "";
                           class47.authCodeForLogin = 0;
                           class47.authCode = "";
                           class93.field1443 = true;
                        }

                        while(true) {
                           while(WorldMapType1.method279()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(World.field1292 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(Coordinates.field2589 == 13) {
                                 class93.loginIndex = 0;
                                 class93.username = "";
                                 class93.password = "";
                                 class47.authCodeForLogin = 0;
                                 class47.authCode = "";
                                 class93.field1443 = true;
                              } else if(class93.loginIndex2 == 0) {
                                 if(Coordinates.field2589 == 85 && class93.username.length() > 0) {
                                    class93.username = class93.username.substring(0, class93.username.length() - 1);
                                 }

                                 if(Coordinates.field2589 == 84 || Coordinates.field2589 == 80) {
                                    class93.loginIndex2 = 1;
                                 }

                                 if(var7 && class93.username.length() < 320) {
                                    class93.username = class93.username + World.field1292;
                                 }
                              } else if(class93.loginIndex2 == 1) {
                                 if(Coordinates.field2589 == 85 && class93.password.length() > 0) {
                                    class93.password = class93.password.substring(0, class93.password.length() - 1);
                                 }

                                 if(Coordinates.field2589 == 84 || Coordinates.field2589 == 80) {
                                    class93.loginIndex2 = 0;
                                 }

                                 if(Coordinates.field2589 == 84) {
                                    class93.username = class93.username.trim();
                                    if(class93.username.length() == 0) {
                                       class19.method154("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class93.password.length() == 0) {
                                       class19.method154("", "Please enter your password.", "");
                                       return;
                                    }

                                    class19.method154("", "Connecting to server...", "");
                                    class93.field1447 = MilliTimer.preferences.preferences.containsKey(Integer.valueOf(class245.method4332(class93.username)))?class150.field2185:class150.field2184;
                                    WorldMapType1.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class93.password.length() < 20) {
                                    class93.password = class93.password + World.field1292;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class93.loginIndex == 3) {
                        var14 = class93.loginWindowX + 180;
                        var18 = 276;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                           class93.loginMessage1 = "";
                           class93.loginMessage2 = "Enter your username/email & password.";
                           class93.loginMessage3 = "";
                           class93.loginIndex = 2;
                           class93.loginIndex2 = 0;
                        }

                        var14 = class93.loginWindowX + 180;
                        var18 = 326;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                           class19.method154("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class93.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var16;
                        int var17;
                        if(class93.loginIndex == 4) {
                           var14 = class93.loginWindowX + 180 - 80;
                           var18 = 321;
                           if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                              class47.authCode.trim();
                              if(class47.authCode.length() != 6) {
                                 class19.method154("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class47.authCodeForLogin = Integer.parseInt(class47.authCode);
                              class47.authCode = "";
                              class93.field1447 = class93.field1443?class150.field2181:class150.field2183;
                              class19.method154("", "Connecting to server...", "");
                              WorldMapType1.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var2 >= class93.loginWindowX + 180 - 9 && var2 <= class93.loginWindowX + 180 + 130 && var3 >= 263 && var3 <= 296) {
                              class93.field1443 = !class93.field1443;
                           }

                           if(var1 == 1 && var2 >= class93.loginWindowX + 180 - 34 && var2 <= class93.loginWindowX + 34 + 180 && var3 >= 351 && var3 <= 363) {
                              class9.method46(class89.method1733("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var14 = class93.loginWindowX + 180 + 80;
                           if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                              class93.loginIndex = 0;
                              class93.username = "";
                              class93.password = "";
                              class47.authCodeForLogin = 0;
                              class47.authCode = "";
                           }

                           while(WorldMapType1.method279()) {
                              var16 = false;

                              for(var17 = 0; var17 < "1234567890".length(); ++var17) {
                                 if(World.field1292 == "1234567890".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(Coordinates.field2589 == 13) {
                                 class93.loginIndex = 0;
                                 class93.username = "";
                                 class93.password = "";
                                 class47.authCodeForLogin = 0;
                                 class47.authCode = "";
                              } else {
                                 if(Coordinates.field2589 == 85 && class47.authCode.length() > 0) {
                                    class47.authCode = class47.authCode.substring(0, class47.authCode.length() - 1);
                                 }

                                 if(Coordinates.field2589 == 84) {
                                    class47.authCode.trim();
                                    if(class47.authCode.length() != 6) {
                                       class19.method154("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class47.authCodeForLogin = Integer.parseInt(class47.authCode);
                                    class47.authCode = "";
                                    class93.field1447 = class93.field1443?class150.field2181:class150.field2183;
                                    class19.method154("", "Connecting to server...", "");
                                    WorldMapType1.setGameState(20);
                                    return;
                                 }

                                 if(var16 && class47.authCode.length() < 6) {
                                    class47.authCode = class47.authCode + World.field1292;
                                 }
                              }
                           }
                        } else if(class93.loginIndex == 5) {
                           var14 = class93.loginWindowX + 180 - 80;
                           var18 = 321;
                           if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                              WidgetNode.method1094();
                              return;
                           }

                           var14 = class93.loginWindowX + 180 + 80;
                           if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                              class93.loginMessage1 = "";
                              class93.loginMessage2 = "Enter your username/email & password.";
                              class93.loginMessage3 = "";
                              class93.loginIndex = 2;
                              class93.loginIndex2 = 0;
                              class93.password = "";
                           }

                           while(WorldMapType1.method279()) {
                              var16 = false;

                              for(var17 = 0; var17 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var17) {
                                 if(World.field1292 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(Coordinates.field2589 == 13) {
                                 class93.loginMessage1 = "";
                                 class93.loginMessage2 = "Enter your username/email & password.";
                                 class93.loginMessage3 = "";
                                 class93.loginIndex = 2;
                                 class93.loginIndex2 = 0;
                                 class93.password = "";
                              } else {
                                 if(Coordinates.field2589 == 85 && class93.username.length() > 0) {
                                    class93.username = class93.username.substring(0, class93.username.length() - 1);
                                 }

                                 if(Coordinates.field2589 == 84) {
                                    WidgetNode.method1094();
                                    return;
                                 }

                                 if(var16 && class93.username.length() < 320) {
                                    class93.username = class93.username + World.field1292;
                                 }
                              }
                           }
                        } else if(class93.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!WorldMapType1.method279()) {
                                    var15 = 321;
                                    if(var1 == 1 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                                       class93.loginMessage1 = "";
                                       class93.loginMessage2 = "Enter your username/email & password.";
                                       class93.loginMessage3 = "";
                                       class93.loginIndex = 2;
                                       class93.loginIndex2 = 0;
                                       class93.password = "";
                                    }

                                    return;
                                 }
                              } while(Coordinates.field2589 != 84 && Coordinates.field2589 != 13);

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
                     while(WorldMapType1.method279()) {
                        if(Coordinates.field2589 == 84) {
                           class93.loginMessage1 = "";
                           class93.loginMessage2 = "Enter your username/email & password.";
                           class93.loginMessage3 = "";
                           class93.loginIndex = 2;
                           class93.loginIndex2 = 0;
                        } else if(Coordinates.field2589 == 13) {
                           class93.loginIndex = 0;
                        }
                     }

                     var14 = class93.loginWindowX + 180 - 80;
                     var18 = 321;
                     if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                        class93.loginMessage1 = "";
                        class93.loginMessage2 = "Enter your username/email & password.";
                        class93.loginMessage3 = "";
                        class93.loginIndex = 2;
                        class93.loginIndex2 = 0;
                     }

                     var14 = class93.loginWindowX + 180 + 80;
                     if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                        class93.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-14"
   )
   public static void method1689() {
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1774223090"
   )
   public static void method1694(int var0) {
      if(class204.field2487 != 0) {
         class204.field2490 = var0;
      } else {
         class204.field2486.method3729(var0);
      }

   }
}
