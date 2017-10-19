import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lel;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("u")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lef;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1618420425
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldg;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1477961363
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("h")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 873221939
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1994645605
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 736790635
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 336963789
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1811862291
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("bridge")
   Tile bridge;
   @ObfuscatedName("i")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -428256395
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("b")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 768265315
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1193946993
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 604911317
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.entityFlags = new int[5];
      this.flags = 0;
      this.renderLevel = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Ldw;",
      garbageValue = "838843435"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class155.field2237, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(DynamicObject.field1533 == 33) {
         var4 = "_rc";
      } else if(DynamicObject.field1533 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class33.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lbv;I)V",
      garbageValue = "400811717"
   )
   static void method2551(GameEngine var0) {
      int var1;
      int var10;
      int var11;
      int var13;
      if(class90.worldSelectShown) {
         if(MouseInput.field743 == 1 || !class7.field244 && MouseInput.field743 == 4) {
            var1 = class90.field1413 + 280;
            if(MouseInput.field757 >= var1 && MouseInput.field757 <= var1 + 14 && MouseInput.field758 >= 4 && MouseInput.field758 <= 18) {
               class64.method1082(0, 0);
            } else if(MouseInput.field757 >= var1 + 15 && MouseInput.field757 <= var1 + 80 && MouseInput.field758 >= 4 && MouseInput.field758 <= 18) {
               class64.method1082(0, 1);
            } else {
               var10 = class90.field1413 + 390;
               if(MouseInput.field757 >= var10 && MouseInput.field757 <= var10 + 14 && MouseInput.field758 >= 4 && MouseInput.field758 <= 18) {
                  class64.method1082(1, 0);
               } else if(MouseInput.field757 >= var10 + 15 && MouseInput.field757 <= var10 + 80 && MouseInput.field758 >= 4 && MouseInput.field758 <= 18) {
                  class64.method1082(1, 1);
               } else {
                  var11 = class90.field1413 + 500;
                  if(MouseInput.field757 >= var11 && MouseInput.field757 <= var11 + 14 && MouseInput.field758 >= 4 && MouseInput.field758 <= 18) {
                     class64.method1082(2, 0);
                  } else if(MouseInput.field757 >= var11 + 15 && MouseInput.field757 <= var11 + 80 && MouseInput.field758 >= 4 && MouseInput.field758 <= 18) {
                     class64.method1082(2, 1);
                  } else {
                     var13 = class90.field1413 + 610;
                     if(MouseInput.field757 >= var13 && MouseInput.field757 <= var13 + 14 && MouseInput.field758 >= 4 && MouseInput.field758 <= 18) {
                        class64.method1082(3, 0);
                     } else if(MouseInput.field757 >= var13 + 15 && MouseInput.field757 <= var13 + 80 && MouseInput.field758 >= 4 && MouseInput.field758 <= 18) {
                        class64.method1082(3, 1);
                     } else if(MouseInput.field757 >= class90.field1413 + 708 && MouseInput.field758 >= 4 && MouseInput.field757 <= class90.field1413 + 708 + 50 && MouseInput.field758 <= 20) {
                        class90.worldSelectShown = false;
                        class90.field1427.method5172(class90.field1413, 0);
                        class8.field250.method5172(class90.field1413 + 382, 0);
                        class29.logoSprite.method5147(class90.field1413 + 382 - class29.logoSprite.originalWidth / 2, 18);
                     } else if(class90.field1428 != -1) {
                        World var5 = class266.worldList[class90.field1428];
                        CombatInfoListHolder.method1686(var5);
                        class90.worldSelectShown = false;
                        class90.field1427.method5172(class90.field1413, 0);
                        class8.field250.method5172(class90.field1413 + 382, 0);
                        class29.logoSprite.method5147(class90.field1413 + 382 - class29.logoSprite.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((MouseInput.field743 == 1 || !class7.field244 && MouseInput.field743 == 4) && MouseInput.field757 >= class90.field1413 + 765 - 50 && MouseInput.field758 >= 453) {
            class70.preferences.muted = !class70.preferences.muted;
            WorldMapType3.method215();
            if(!class70.preferences.muted) {
               ScriptEvent.method1092(class37.indexTrack1, "scape main", "", 255, false);
            } else {
               class152.method2974();
            }
         }

         if(Client.gameState != 5) {
            ++class90.field1412;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.languageId == 0) {
                  if(MouseInput.field743 == 1 || !class7.field244 && MouseInput.field743 == 4) {
                     var1 = class90.field1413 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(MouseInput.field757 >= var1 && MouseInput.field757 <= var1 + var3 && MouseInput.field758 >= var2 && MouseInput.field758 <= var2 + var4) {
                        class46.method694();
                        return;
                     }
                  }

                  if(Ignore.listFetcher != null) {
                     class46.method694();
                  }
               }

               var1 = MouseInput.field743;
               var10 = MouseInput.field757;
               var11 = MouseInput.field758;
               if(var1 == 0) {
                  var10 = MouseInput.field756;
                  var11 = MouseInput.field741;
               }

               if(!class7.field244 && var1 == 4) {
                  var1 = 1;
               }

               short var6;
               int var9;
               if(class90.loginIndex == 0) {
                  boolean var12 = false;

                  while(class170.method3195()) {
                     if(class261.field3630 == 84) {
                        var12 = true;
                     }
                  }

                  var9 = class227.field3145 - 80;
                  var6 = 291;
                  if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                     class155.method2999(class12.method71("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var9 = class227.field3145 + 80;
                  if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20 || var12) {
                     if((Client.flags & 33554432) != 0) {
                        class90.field1442 = "";
                        class90.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class90.loginMessage2 = "Your normal account will not be affected.";
                        class90.loginMessage3 = "";
                        class90.loginIndex = 1;
                        Ignore.method1103();
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

                        class90.field1442 = "Warning!";
                        class90.loginIndex = 1;
                        Ignore.method1103();
                     } else if((Client.flags & 1024) != 0) {
                        class90.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class90.loginMessage2 = "The Protect Item prayer will";
                        class90.loginMessage3 = "not work on this world.";
                        class90.field1442 = "Warning!";
                        class90.loginIndex = 1;
                        Ignore.method1103();
                     } else {
                        class48.method719(false);
                     }
                  }
               } else {
                  short var17;
                  if(class90.loginIndex != 1) {
                     short var14;
                     if(class90.loginIndex == 2) {
                        var14 = 201;
                        var13 = var14 + 52;
                        if(var1 == 1 && var11 >= var13 - 12 && var11 < var13 + 2) {
                           class90.field1422 = 0;
                        }

                        var13 += 15;
                        if(var1 == 1 && var11 >= var13 - 12 && var11 < var13 + 2) {
                           class90.field1422 = 1;
                        }

                        var13 += 15;
                        var14 = 361;
                        if(var1 == 1 && var11 >= var14 - 15 && var11 < var14) {
                           class36.method481("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }

                        var9 = class227.field3145 - 80;
                        var6 = 321;
                        if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class90.username = class90.username.trim();
                           if(class90.username.length() == 0) {
                              class36.method481("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class90.password.length() == 0) {
                              class36.method481("", "Please enter your password.", "");
                              return;
                           }

                           class36.method481("", "Connecting to server...", "");
                           World.method1577(false);
                           class72.setGameState(20);
                           return;
                        }

                        var9 = class90.loginWindowX + 180 + 80;
                        if(var1 == 1 && var10 >= var9 - 75 && var10 <= var9 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class90.loginIndex = 0;
                           class90.username = "";
                           class90.password = "";
                           class41.field585 = 0;
                           DState.field2346 = "";
                           class90.field1438 = true;
                        }

                        var9 = class227.field3145 + -117;
                        var6 = 277;
                        class90.field1450 = var10 >= var9 && var10 < var9 + GZipDecompressor.field2325 && var11 >= var6 && var11 < var6 + class41.field586;
                        if(var1 == 1 && class90.field1450) {
                           class90.field1439 = !class90.field1439;
                           if(!class90.field1439 && class70.preferences.field1299 != null) {
                              class70.preferences.field1299 = null;
                              WorldMapType3.method215();
                           }
                        }

                        var9 = class227.field3145 + 24;
                        var6 = 277;
                        class90.field1441 = var10 >= var9 && var10 < var9 + GZipDecompressor.field2325 && var11 >= var6 && var11 < var6 + class41.field586;
                        if(var1 == 1 && class90.field1441) {
                           class70.preferences.field1305 = !class70.preferences.field1305;
                           if(!class70.preferences.field1305) {
                              class90.username = "";
                              class70.preferences.field1299 = null;
                              Ignore.method1103();
                           }

                           WorldMapType3.method215();
                        }

                        while(true) {
                           while(class170.method3195()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class47.field618 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(class261.field3630 == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 class41.field585 = 0;
                                 DState.field2346 = "";
                                 class90.field1438 = true;
                              } else if(class90.field1422 == 0) {
                                 if(class261.field3630 == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(class261.field3630 == 84 || class261.field3630 == 80) {
                                    class90.field1422 = 1;
                                 }

                                 if(var7 && class90.username.length() < 320) {
                                    class90.username = class90.username + class47.field618;
                                 }
                              } else if(class90.field1422 == 1) {
                                 if(class261.field3630 == 85 && class90.password.length() > 0) {
                                    class90.password = class90.password.substring(0, class90.password.length() - 1);
                                 }

                                 if(class261.field3630 == 84 || class261.field3630 == 80) {
                                    class90.field1422 = 0;
                                 }

                                 if(class261.field3630 == 84) {
                                    class90.username = class90.username.trim();
                                    if(class90.username.length() == 0) {
                                       class36.method481("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class90.password.length() == 0) {
                                       class36.method481("", "Please enter your password.", "");
                                       return;
                                    }

                                    class36.method481("", "Connecting to server...", "");
                                    World.method1577(false);
                                    class72.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class90.password.length() < 20) {
                                    class90.password = class90.password + class47.field618;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class90.loginIndex == 3) {
                        var13 = class90.loginWindowX + 180;
                        var17 = 276;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                           class48.method719(false);
                        }

                        var13 = class90.loginWindowX + 180;
                        var17 = 326;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                           class36.method481("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var15;
                        int var16;
                        if(class90.loginIndex == 4) {
                           var13 = class90.loginWindowX + 180 - 80;
                           var17 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              DState.field2346.trim();
                              if(DState.field2346.length() != 6) {
                                 class36.method481("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class41.field585 = Integer.parseInt(DState.field2346);
                              DState.field2346 = "";
                              World.method1577(true);
                              class36.method481("", "Connecting to server...", "");
                              class72.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var10 >= class90.loginWindowX + 180 - 9 && var10 <= class90.loginWindowX + 180 + 130 && var11 >= 263 && var11 <= 296) {
                              class90.field1438 = !class90.field1438;
                           }

                           if(var1 == 1 && var10 >= class90.loginWindowX + 180 - 34 && var10 <= class90.loginWindowX + 34 + 180 && var11 >= 351 && var11 <= 363) {
                              class155.method2999(class12.method71("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var13 = class90.loginWindowX + 180 + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              class90.loginIndex = 0;
                              class90.username = "";
                              class90.password = "";
                              class41.field585 = 0;
                              DState.field2346 = "";
                           }

                           while(class170.method3195()) {
                              var15 = false;

                              for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                                 if(class47.field618 == "1234567890".charAt(var16)) {
                                    var15 = true;
                                    break;
                                 }
                              }

                              if(class261.field3630 == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 class41.field585 = 0;
                                 DState.field2346 = "";
                              } else {
                                 if(class261.field3630 == 85 && DState.field2346.length() > 0) {
                                    DState.field2346 = DState.field2346.substring(0, DState.field2346.length() - 1);
                                 }

                                 if(class261.field3630 == 84) {
                                    DState.field2346.trim();
                                    if(DState.field2346.length() != 6) {
                                       class36.method481("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class41.field585 = Integer.parseInt(DState.field2346);
                                    DState.field2346 = "";
                                    World.method1577(true);
                                    class36.method481("", "Connecting to server...", "");
                                    class72.setGameState(20);
                                    return;
                                 }

                                 if(var15 && DState.field2346.length() < 6) {
                                    DState.field2346 = DState.field2346 + class47.field618;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 5) {
                           var13 = class90.loginWindowX + 180 - 80;
                           var17 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              class210.method4000();
                              return;
                           }

                           var13 = class90.loginWindowX + 180 + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                              class48.method719(true);
                           }

                           while(class170.method3195()) {
                              var15 = false;

                              for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                                 if(class47.field618 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                    var15 = true;
                                    break;
                                 }
                              }

                              if(class261.field3630 == 13) {
                                 class48.method719(true);
                              } else {
                                 if(class261.field3630 == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(class261.field3630 == 84) {
                                    class210.method4000();
                                    return;
                                 }

                                 if(var15 && class90.username.length() < 320) {
                                    class90.username = class90.username + class47.field618;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class170.method3195()) {
                                    var14 = 321;
                                    if(var1 == 1 && var11 >= var14 - 20 && var11 <= var14 + 20) {
                                       class48.method719(true);
                                    }

                                    return;
                                 }
                              } while(class261.field3630 != 84 && class261.field3630 != 13);

                              class48.method719(true);
                           }
                        }
                     }
                  } else {
                     while(class170.method3195()) {
                        if(class261.field3630 == 84) {
                           class48.method719(false);
                        } else if(class261.field3630 == 13) {
                           class90.loginIndex = 0;
                        }
                     }

                     var13 = class227.field3145 - 80;
                     var17 = 321;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                        class48.method719(false);
                     }

                     var13 = class227.field3145 + 80;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var17 - 20 && var11 <= var17 + 20) {
                        class90.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }
}
