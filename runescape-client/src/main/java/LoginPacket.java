import java.awt.FontMetrics;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("LoginPacket")
public class LoginPacket implements class178 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   public static final LoginPacket field2436;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   static final LoginPacket field2437;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   public static final LoginPacket field2444;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfd;"
   )
   public static final LoginPacket field2439;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lfd;"
   )
   static final LoginPacket[] field2441;
   @ObfuscatedName("ah")
   static FontMetrics field2443;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1660687461
   )
   @Export("id")
   public final int id;

   static {
      field2436 = new LoginPacket(14, 0);
      field2437 = new LoginPacket(15, 4);
      field2444 = new LoginPacket(16, -2);
      field2439 = new LoginPacket(18, -2);
      field2441 = new LoginPacket[32];
      LoginPacket[] var0 = new LoginPacket[]{field2437, field2444, field2439, field2436};
      LoginPacket[] var1 = var0;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         field2441[var1[var2].id] = var1[var2];
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   LoginPacket(int var1, int var2) {
      this.id = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "594562729"
   )
   public static void method3434() {
      try {
         File var0 = new File(Occluder.userHome, "random.dat");
         int var2;
         if(var0.exists()) {
            class166.randomDat = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var1 = 0; var1 < class156.field2108.length; ++var1) {
               for(var2 = 0; var2 < GrandExchangeEvents.cacheLocations.length; ++var2) {
                  File var3 = new File(GrandExchangeEvents.cacheLocations[var2] + class156.field2108[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class166.randomDat = new CacheFile(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if(class166.randomDat == null) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class166.randomDat = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1839990096"
   )
   public static boolean method3438(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lbi;I)V",
      garbageValue = "1974089216"
   )
   static void method3436(GameEngine var0) {
      int var2;
      int var3;
      int var4;
      if(class89.worldSelectShown) {
         if(MouseInput.mouseLastButton == 1 || !Size.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
            int var1 = class89.field1324 + 280;
            if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var1 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
               class39.method559(0, 0);
            } else if(MouseInput.mouseLastPressedX >= var1 + 15 && MouseInput.mouseLastPressedX <= var1 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
               class39.method559(0, 1);
            } else {
               var2 = class89.field1324 + 390;
               if(MouseInput.mouseLastPressedX >= var2 && MouseInput.mouseLastPressedX <= var2 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                  class39.method559(1, 0);
               } else if(MouseInput.mouseLastPressedX >= var2 + 15 && MouseInput.mouseLastPressedX <= var2 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                  class39.method559(1, 1);
               } else {
                  var3 = class89.field1324 + 500;
                  if(MouseInput.mouseLastPressedX >= var3 && MouseInput.mouseLastPressedX <= var3 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                     class39.method559(2, 0);
                  } else if(MouseInput.mouseLastPressedX >= var3 + 15 && MouseInput.mouseLastPressedX <= var3 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                     class39.method559(2, 1);
                  } else {
                     var4 = class89.field1324 + 610;
                     if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var4 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        class39.method559(3, 0);
                     } else if(MouseInput.mouseLastPressedX >= var4 + 15 && MouseInput.mouseLastPressedX <= var4 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        class39.method559(3, 1);
                     } else if(MouseInput.mouseLastPressedX >= class89.field1324 + 708 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedX <= class89.field1324 + 708 + 50 && MouseInput.mouseLastPressedY <= 20) {
                        class89.worldSelectShown = false;
                        class234.field2759.method5809(class89.field1324, 0);
                        class305.field3806.method5809(class89.field1324 + 382, 0);
                        class89.logoSprite.method5783(class89.field1324 + 382 - class89.logoSprite.originalWidth / 2, 18);
                     } else if(class89.field1315 != -1) {
                        World var5 = World.worldList[class89.field1315];
                        class44.method656(var5);
                        class89.worldSelectShown = false;
                        class234.field2759.method5809(class89.field1324, 0);
                        class305.field3806.method5809(class89.field1324 + 382, 0);
                        class89.logoSprite.method5783(class89.field1324 + 382 - class89.logoSprite.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((MouseInput.mouseLastButton == 1 || !Size.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= class89.field1324 + 765 - 50 && MouseInput.mouseLastPressedY >= 453) {
            Client.preferences.muted = !Client.preferences.muted;
            VertexNormal.method2802();
            if(!Client.preferences.muted) {
               IndexData var12 = class155.indexTrack1;
               var2 = var12.getFile("scape main");
               var3 = var12.getChild(var2, "");
               class152.method3129(var12, var2, var3, 255, false);
            } else {
               class155.field2105.method4140();
               class223.field2646 = 1;
               Huffman.field2471 = null;
            }
         }

         if(Client.gameState != 5) {
            if(class89.field1332 == -1L) {
               class89.field1332 = class188.currentTimeMs() + 1000L;
            }

            long var13 = class188.currentTimeMs();
            boolean var17;
            if(Client.field932 != null && Client.field1075 < Client.field932.size()) {
               while(true) {
                  if(Client.field1075 >= Client.field932.size()) {
                     var17 = true;
                     break;
                  }

                  class63 var16 = (class63)Client.field932.get(Client.field1075);
                  if(!var16.method1106()) {
                     var17 = false;
                     break;
                  }

                  ++Client.field1075;
               }
            } else {
               var17 = true;
            }

            if(var17 && -1L == class89.field1333) {
               class89.field1333 = var13;
               if(class89.field1333 > class89.field1332) {
                  class89.field1332 = class89.field1333;
               }
            }

            ++class89.field1310;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.languageId == 0) {
                  if(MouseInput.mouseLastButton == 1 || !Size.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
                     var4 = class89.field1324 + 5;
                     short var15 = 463;
                     byte var6 = 100;
                     byte var7 = 35;
                     if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var6 + var4 && MouseInput.mouseLastPressedY >= var15 && MouseInput.mouseLastPressedY <= var15 + var7) {
                        if(Preferences.loadWorlds()) {
                           class89.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(World.listFetcher != null && Preferences.loadWorlds()) {
                     class89.worldSelectShown = true;
                  }
               }

               var4 = MouseInput.mouseLastButton;
               int var25 = MouseInput.mouseLastPressedX;
               int var18 = MouseInput.mouseLastPressedY;
               if(var4 == 0) {
                  var25 = MouseInput.mouseLastX;
                  var18 = MouseInput.mouseLastY;
               }

               if(!Size.middleMouseMovesCamera && var4 == 4) {
                  var4 = 1;
               }

               int var8;
               short var9;
               if(class89.loginIndex == 0) {
                  boolean var19 = false;

                  while(class46.method712()) {
                     if(Resampler.field1563 == 84) {
                        var19 = true;
                     }
                  }

                  var8 = class222.field2641 - 80;
                  var9 = 291;
                  if(var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
                     class176.method3424(ScriptEvent.method1136("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var8 = class222.field2641 + 80;
                  if(var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20 || var19) {
                     if((Client.flags & 33554432) != 0) {
                        class89.Login_response0 = "";
                        class89.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class89.loginMessage2 = "Your normal account will not be affected.";
                        class89.loginMessage3 = "";
                        class89.loginIndex = 1;
                        NPC.method1846();
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class89.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class89.loginMessage2 = "Players can attack each other almost everywhere";
                           class89.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class89.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class89.loginMessage2 = "Players can attack each other";
                           class89.loginMessage3 = "almost everywhere.";
                        }

                        class89.Login_response0 = "Warning!";
                        class89.loginIndex = 1;
                        NPC.method1846();
                     } else if((Client.flags & 1024) != 0) {
                        class89.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class89.loginMessage2 = "The Protect Item prayer will";
                        class89.loginMessage3 = "not work on this world.";
                        class89.Login_response0 = "Warning!";
                        class89.loginIndex = 1;
                        NPC.method1846();
                     } else {
                        class25.method202(false);
                     }
                  }
               } else {
                  int var20;
                  short var22;
                  if(class89.loginIndex != 1) {
                     short var21;
                     if(class89.loginIndex == 2) {
                        var21 = 201;
                        var20 = var21 + 52;
                        if(var4 == 1 && var18 >= var20 - 12 && var18 < var20 + 2) {
                           class89.field1331 = 0;
                        }

                        var20 += 15;
                        if(var4 == 1 && var18 >= var20 - 12 && var18 < var20 + 2) {
                           class89.field1331 = 1;
                        }

                        var20 += 15;
                        var21 = 361;
                        if(var4 == 1 && var18 >= var21 - 15 && var18 < var21) {
                           class194.method3794("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class89.loginIndex = 5;
                           return;
                        }

                        var8 = class222.field2641 - 80;
                        var9 = 321;
                        if(var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
                           class89.username = class89.username.trim();
                           if(class89.username.length() == 0) {
                              class194.method3794("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class89.password.length() == 0) {
                              class194.method3794("", "Please enter your password.", "");
                              return;
                           }

                           class194.method3794("", "Connecting to server...", "");
                           GrandExchangeEvent.method82(false);
                           WorldMapType1.setGameState(20);
                           return;
                        }

                        var8 = class89.loginWindowX + 180 + 80;
                        if(var4 == 1 && var25 >= var8 - 75 && var25 <= var8 + 75 && var18 >= var9 - 20 && var18 <= var9 + 20) {
                           class89.loginIndex = 0;
                           class89.username = "";
                           class89.password = "";
                           BoundingBox3DDrawMode.field253 = 0;
                           WidgetNode.field740 = "";
                           class89.field1312 = true;
                        }

                        var8 = class222.field2641 + -117;
                        var9 = 277;
                        class89.field1320 = var25 >= var8 && var25 < var8 + class194.field2550 && var18 >= var9 && var18 < var9 + Item.field1365;
                        if(var4 == 1 && class89.field1320) {
                           class89.Login_isUsernameRemembered = !class89.Login_isUsernameRemembered;
                           if(!class89.Login_isUsernameRemembered && Client.preferences.rememberedUsername != null) {
                              Client.preferences.rememberedUsername = null;
                              VertexNormal.method2802();
                           }
                        }

                        var8 = class222.field2641 + 24;
                        var9 = 277;
                        class89.field1325 = var25 >= var8 && var25 < var8 + class194.field2550 && var18 >= var9 && var18 < var9 + Item.field1365;
                        if(var4 == 1 && class89.field1325) {
                           Client.preferences.hideUsername = !Client.preferences.hideUsername;
                           if(!Client.preferences.hideUsername) {
                              class89.username = "";
                              Client.preferences.rememberedUsername = null;
                              NPC.method1846();
                           }

                           VertexNormal.method2802();
                        }

                        while(true) {
                           while(class46.method712()) {
                              boolean var10 = false;

                              for(int var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var11) {
                                 if(class5.field29 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var11)) {
                                    var10 = true;
                                    break;
                                 }
                              }

                              if(Resampler.field1563 == 13) {
                                 class89.loginIndex = 0;
                                 class89.username = "";
                                 class89.password = "";
                                 BoundingBox3DDrawMode.field253 = 0;
                                 WidgetNode.field740 = "";
                                 class89.field1312 = true;
                              } else if(class89.field1331 == 0) {
                                 if(Resampler.field1563 == 85 && class89.username.length() > 0) {
                                    class89.username = class89.username.substring(0, class89.username.length() - 1);
                                 }

                                 if(Resampler.field1563 == 84 || Resampler.field1563 == 80) {
                                    class89.field1331 = 1;
                                 }

                                 if(var10 && class89.username.length() < 320) {
                                    class89.username = class89.username + class5.field29;
                                 }
                              } else if(class89.field1331 == 1) {
                                 if(Resampler.field1563 == 85 && class89.password.length() > 0) {
                                    class89.password = class89.password.substring(0, class89.password.length() - 1);
                                 }

                                 if(Resampler.field1563 == 84 || Resampler.field1563 == 80) {
                                    class89.field1331 = 0;
                                 }

                                 if(Resampler.field1563 == 84) {
                                    class89.username = class89.username.trim();
                                    if(class89.username.length() == 0) {
                                       class194.method3794("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class89.password.length() == 0) {
                                       class194.method3794("", "Please enter your password.", "");
                                       return;
                                    }

                                    class194.method3794("", "Connecting to server...", "");
                                    GrandExchangeEvent.method82(false);
                                    WorldMapType1.setGameState(20);
                                    return;
                                 }

                                 if(var10 && class89.password.length() < 20) {
                                    class89.password = class89.password + class5.field29;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class89.loginIndex == 3) {
                        var20 = class89.loginWindowX + 180;
                        var22 = 276;
                        if(var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                           class25.method202(false);
                        }

                        var20 = class89.loginWindowX + 180;
                        var22 = 326;
                        if(var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                           class194.method3794("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class89.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var23;
                        int var24;
                        if(class89.loginIndex == 4) {
                           var20 = class89.loginWindowX + 180 - 80;
                           var22 = 321;
                           if(var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                              WidgetNode.field740.trim();
                              if(WidgetNode.field740.length() != 6) {
                                 class194.method3794("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              BoundingBox3DDrawMode.field253 = Integer.parseInt(WidgetNode.field740);
                              WidgetNode.field740 = "";
                              GrandExchangeEvent.method82(true);
                              class194.method3794("", "Connecting to server...", "");
                              WorldMapType1.setGameState(20);
                              return;
                           }

                           if(var4 == 1 && var25 >= class89.loginWindowX + 180 - 9 && var25 <= class89.loginWindowX + 180 + 130 && var18 >= 263 && var18 <= 296) {
                              class89.field1312 = !class89.field1312;
                           }

                           if(var4 == 1 && var25 >= class89.loginWindowX + 180 - 34 && var25 <= class89.loginWindowX + 34 + 180 && var18 >= 351 && var18 <= 363) {
                              class176.method3424(ScriptEvent.method1136("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var20 = class89.loginWindowX + 180 + 80;
                           if(var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                              class89.loginIndex = 0;
                              class89.username = "";
                              class89.password = "";
                              BoundingBox3DDrawMode.field253 = 0;
                              WidgetNode.field740 = "";
                           }

                           while(class46.method712()) {
                              var23 = false;

                              for(var24 = 0; var24 < "1234567890".length(); ++var24) {
                                 if(class5.field29 == "1234567890".charAt(var24)) {
                                    var23 = true;
                                    break;
                                 }
                              }

                              if(Resampler.field1563 == 13) {
                                 class89.loginIndex = 0;
                                 class89.username = "";
                                 class89.password = "";
                                 BoundingBox3DDrawMode.field253 = 0;
                                 WidgetNode.field740 = "";
                              } else {
                                 if(Resampler.field1563 == 85 && WidgetNode.field740.length() > 0) {
                                    WidgetNode.field740 = WidgetNode.field740.substring(0, WidgetNode.field740.length() - 1);
                                 }

                                 if(Resampler.field1563 == 84) {
                                    WidgetNode.field740.trim();
                                    if(WidgetNode.field740.length() != 6) {
                                       class194.method3794("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    BoundingBox3DDrawMode.field253 = Integer.parseInt(WidgetNode.field740);
                                    WidgetNode.field740 = "";
                                    GrandExchangeEvent.method82(true);
                                    class194.method3794("", "Connecting to server...", "");
                                    WorldMapType1.setGameState(20);
                                    return;
                                 }

                                 if(var23 && WidgetNode.field740.length() < 6) {
                                    WidgetNode.field740 = WidgetNode.field740 + class5.field29;
                                 }
                              }
                           }
                        } else if(class89.loginIndex == 5) {
                           var20 = class89.loginWindowX + 180 - 80;
                           var22 = 321;
                           if(var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                              class184.method3451();
                              return;
                           }

                           var20 = class89.loginWindowX + 180 + 80;
                           if(var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                              class25.method202(true);
                           }

                           while(class46.method712()) {
                              var23 = false;

                              for(var24 = 0; var24 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var24) {
                                 if(class5.field29 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var24)) {
                                    var23 = true;
                                    break;
                                 }
                              }

                              if(Resampler.field1563 == 13) {
                                 class25.method202(true);
                              } else {
                                 if(Resampler.field1563 == 85 && class89.username.length() > 0) {
                                    class89.username = class89.username.substring(0, class89.username.length() - 1);
                                 }

                                 if(Resampler.field1563 == 84) {
                                    class184.method3451();
                                    return;
                                 }

                                 if(var23 && class89.username.length() < 320) {
                                    class89.username = class89.username + class5.field29;
                                 }
                              }
                           }
                        } else if(class89.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class46.method712()) {
                                    var21 = 321;
                                    if(var4 == 1 && var18 >= var21 - 20 && var18 <= var21 + 20) {
                                       class25.method202(true);
                                    }

                                    return;
                                 }
                              } while(Resampler.field1563 != 84 && Resampler.field1563 != 13);

                              class25.method202(true);
                           }
                        }
                     }
                  } else {
                     while(class46.method712()) {
                        if(Resampler.field1563 == 84) {
                           class25.method202(false);
                        } else if(Resampler.field1563 == 13) {
                           class89.loginIndex = 0;
                        }
                     }

                     var20 = class222.field2641 - 80;
                     var22 = 321;
                     if(var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                        class25.method202(false);
                     }

                     var20 = class222.field2641 + 80;
                     if(var4 == 1 && var25 >= var20 - 75 && var25 <= var20 + 75 && var18 >= var22 - 20 && var18 <= var22 + 20) {
                        class89.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZZI)I",
      garbageValue = "-1888506008"
   )
   public static int method3437(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class258.NetCache_pendingPriorityResponsesCount + class258.NetCache_pendingPriorityWritesCount;
      return var3;
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(Ljd;IIII)V",
      garbageValue = "-1547753975"
   )
   static final void method3435(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.configs != null) {
            var0 = var0.transform();
         }

         if(var0 != null) {
            if(var0.field3660) {
               if(!var0.field3662 || Client.field996 == var1) {
                  String var4 = var0.name;
                  if(var0.combatLevel != 0) {
                     var4 = var4 + RunException.method3227(var0.combatLevel, OwnWorldComparator.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(var0.field3662 && Client.field950) {
                     class21.addMenuEntry("Examine", BoundingBox3D.getColTags(16776960) + var4, 1003, var1, var2, var3);
                  }

                  if(Client.itemSelectionState == 1) {
                     class21.addMenuEntry("Use", Client.lastSelectedItemName + " " + "->" + " " + BoundingBox3D.getColTags(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.spellSelected) {
                     if((Size.field340 & 2) == 2) {
                        class21.addMenuEntry(Client.field961, Client.field962 + " " + "->" + " " + BoundingBox3D.getColTags(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     int var5 = var0.field3662 && Client.field950?2000:0;
                     String[] var6 = var0.actions;
                     if(Client.numberMenuOptions) {
                        var6 = Item.prependIndices(var6);
                     }

                     int var7;
                     int var8;
                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && !var6[var7].equalsIgnoreCase("Attack")) {
                              var8 = 0;
                              if(var7 == 0) {
                                 var8 = var5 + 9;
                              }

                              if(var7 == 1) {
                                 var8 = var5 + 10;
                              }

                              if(var7 == 2) {
                                 var8 = var5 + 11;
                              }

                              if(var7 == 3) {
                                 var8 = var5 + 12;
                              }

                              if(var7 == 4) {
                                 var8 = var5 + 13;
                              }

                              class21.addMenuEntry(var6[var7], BoundingBox3D.getColTags(16776960) + var4, var8, var1, var2, var3);
                           }
                        }
                     }

                     if(var6 != null) {
                        for(var7 = 4; var7 >= 0; --var7) {
                           if(var6[var7] != null && var6[var7].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(Client.npcAttackOption != AttackOption.AttackOption_hidden) {
                                 if(AttackOption.AttackOption_alwaysRightClick == Client.npcAttackOption || AttackOption.AttackOption_dependsOnCombatLevels == Client.npcAttackOption && var0.combatLevel > OwnWorldComparator.localPlayer.combatLevel) {
                                    var9 = 2000;
                                 }

                                 var8 = 0;
                                 if(var7 == 0) {
                                    var8 = var9 + 9;
                                 }

                                 if(var7 == 1) {
                                    var8 = var9 + 10;
                                 }

                                 if(var7 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(var7 == 3) {
                                    var8 = var9 + 12;
                                 }

                                 if(var7 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 class21.addMenuEntry(var6[var7], BoundingBox3D.getColTags(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     if(!var0.field3662 || !Client.field950) {
                        class21.addMenuEntry("Examine", BoundingBox3D.getColTags(16776960) + var4, 1003, var1, var2, var3);
                     }
                  }

               }
            }
         }
      }
   }
}
