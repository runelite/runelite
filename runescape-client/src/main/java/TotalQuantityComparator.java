import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("TotalQuantityComparator")
final class TotalQuantityComparator implements Comparator {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;I)I",
      garbageValue = "-39397794"
   )
   int method106(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity?-1:(var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method106((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1264538177"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lbf;I)V",
      garbageValue = "-645482054"
   )
   static void method108(GameEngine var0) {
      if(class90.worldSelectShown) {
         Buffer.method3738(var0);
      } else {
         int var3;
         if((MouseInput.mouseLastButton == 1 || !WorldMapData.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= class90.field1338 + 765 - 50 && MouseInput.mouseLastPressedY >= 453) {
            class46.preferences.muted = !class46.preferences.muted;
            class46.method694();
            if(!class46.preferences.muted) {
               IndexData var1 = class1.indexTrack1;
               int var2 = var1.getFile("scape main");
               var3 = var1.getChild(var2, "");
               class95.method2007(var1, var2, var3, 255, false);
            } else {
               class229.field2679.method4150();
               class229.field2680 = 1;
               class61.field714 = null;
            }
         }

         if(Client.gameState != 5) {
            if(-1L == class90.field1373) {
               class90.field1373 = ScriptVarType.method28() + 1000L;
            }

            long var11 = ScriptVarType.method28();
            if(method98() && class90.field1359 == -1L) {
               class90.field1359 = var11;
               if(class90.field1359 > class90.field1373) {
                  class90.field1373 = class90.field1359;
               }
            }

            ++class90.field1351;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.languageId == 0) {
                  if(MouseInput.mouseLastButton == 1 || !WorldMapData.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
                     var3 = class90.field1338 + 5;
                     short var4 = 463;
                     byte var5 = 100;
                     byte var6 = 35;
                     if(MouseInput.mouseLastPressedX >= var3 && MouseInput.mouseLastPressedX <= var5 + var3 && MouseInput.mouseLastPressedY >= var4 && MouseInput.mouseLastPressedY <= var6 + var4) {
                        if(class265.loadWorlds()) {
                           class90.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(class21.listFetcher != null && class265.loadWorlds()) {
                     class90.worldSelectShown = true;
                  }
               }

               var3 = MouseInput.mouseLastButton;
               int var18 = MouseInput.mouseLastPressedX;
               int var19 = MouseInput.mouseLastPressedY;
               if(var3 == 0) {
                  var18 = MouseInput.mouseLastX;
                  var19 = MouseInput.mouseLastY;
               }

               if(!WorldMapData.middleMouseMovesCamera && var3 == 4) {
                  var3 = 1;
               }

               int var7;
               short var8;
               if(class90.loginIndex == 0) {
                  boolean var20 = false;

                  while(WorldMapRegion.method519()) {
                     if(Tile.currentPressedKey == 84) {
                        var20 = true;
                     }
                  }

                  var7 = GameCanvas.field630 - 80;
                  var8 = 291;
                  if(var3 == 1 && var18 >= var7 - 75 && var18 <= var7 + 75 && var19 >= var8 - 20 && var19 <= var8 + 20) {
                     label839: {
                        String var9 = ClientPacket.method3421("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                           try {
                              Desktop.getDesktop().browse(new URI(var9));
                              break label839;
                           } catch (Exception var17) {
                              ;
                           }
                        }

                        if(class57.field646.startsWith("win")) {
                           ItemLayer.method2580(var9, 0);
                        } else if(class57.field646.startsWith("mac")) {
                           WorldMapType2.method553(var9, 1, "openjs");
                        } else {
                           ItemLayer.method2580(var9, 2);
                        }
                     }
                  }

                  var7 = GameCanvas.field630 + 80;
                  if(var3 == 1 && var18 >= var7 - 75 && var18 <= var7 + 75 && var19 >= var8 - 20 && var19 <= var8 + 20 || var20) {
                     if((Client.flags & 33554432) != 0) {
                        class90.Login_response0 = "";
                        class90.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class90.loginMessage2 = "Your normal account will not be affected.";
                        class90.loginMessage3 = "";
                        class90.loginIndex = 1;
                        class25.method200();
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
                        class25.method200();
                     } else if((Client.flags & 1024) != 0) {
                        class90.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class90.loginMessage2 = "The Protect Item prayer will";
                        class90.loginMessage3 = "not work on this world.";
                        class90.Login_response0 = "Warning!";
                        class90.loginIndex = 1;
                        class25.method200();
                     } else {
                        AbstractByteBuffer.method3767(false);
                     }
                  }
               } else {
                  int var21;
                  short var23;
                  if(class90.loginIndex != 1) {
                     short var22;
                     if(class90.loginIndex == 2) {
                        var22 = 201;
                        var21 = var22 + 52;
                        if(var3 == 1 && var19 >= var21 - 12 && var19 < var21 + 2) {
                           class90.field1367 = 0;
                        }

                        var21 += 15;
                        if(var3 == 1 && var19 >= var21 - 12 && var19 < var21 + 2) {
                           class90.field1367 = 1;
                        }

                        var21 += 15;
                        var22 = 361;
                        if(var3 == 1 && var19 >= var22 - 15 && var19 < var22) {
                           class33.method385("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }

                        var7 = GameCanvas.field630 - 80;
                        var8 = 321;
                        if(var3 == 1 && var18 >= var7 - 75 && var18 <= var7 + 75 && var19 >= var8 - 20 && var19 <= var8 + 20) {
                           class90.username = class90.username.trim();
                           if(class90.username.length() == 0) {
                              class33.method385("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class90.password.length() == 0) {
                              class33.method385("", "Please enter your password.", "");
                              return;
                           }

                           class33.method385("", "Connecting to server...", "");
                           class61.method1058(false);
                           MapIconReference.setGameState(20);
                           return;
                        }

                        var7 = class90.loginWindowX + 180 + 80;
                        if(var3 == 1 && var18 >= var7 - 75 && var18 <= var7 + 75 && var19 >= var8 - 20 && var19 <= var8 + 20) {
                           class90.loginIndex = 0;
                           class90.username = "";
                           class90.password = "";
                           PendingSpawn.field1145 = 0;
                           MapCacheArchiveNames.field520 = "";
                           class90.field1344 = true;
                        }

                        var7 = GameCanvas.field630 + -117;
                        var8 = 277;
                        class90.field1364 = var18 >= var7 && var18 < var7 + class90.field1363 && var19 >= var8 && var19 < var8 + WorldMapType1.field415;
                        if(var3 == 1 && class90.field1364) {
                           class90.Login_isUsernameRemembered = !class90.Login_isUsernameRemembered;
                           if(!class90.Login_isUsernameRemembered && class46.preferences.rememberedUsername != null) {
                              class46.preferences.rememberedUsername = null;
                              class46.method694();
                           }
                        }

                        var7 = GameCanvas.field630 + 24;
                        var8 = 277;
                        class90.field1340 = var18 >= var7 && var18 < var7 + class90.field1363 && var19 >= var8 && var19 < var8 + WorldMapType1.field415;
                        if(var3 == 1 && class90.field1340) {
                           class46.preferences.hideUsername = !class46.preferences.hideUsername;
                           if(!class46.preferences.hideUsername) {
                              class90.username = "";
                              class46.preferences.rememberedUsername = null;
                              class25.method200();
                           }

                           class46.method694();
                        }

                        while(true) {
                           while(WorldMapRegion.method519()) {
                              boolean var13 = false;

                              for(int var14 = 0; var14 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var14) {
                                 if(BuildType.currentTypedKey == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var14)) {
                                    var13 = true;
                                    break;
                                 }
                              }

                              if(Tile.currentPressedKey == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 PendingSpawn.field1145 = 0;
                                 MapCacheArchiveNames.field520 = "";
                                 class90.field1344 = true;
                              } else if(class90.field1367 == 0) {
                                 if(Tile.currentPressedKey == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(Tile.currentPressedKey == 84 || Tile.currentPressedKey == 80) {
                                    class90.field1367 = 1;
                                 }

                                 if(var13 && class90.username.length() < 320) {
                                    class90.username = class90.username + BuildType.currentTypedKey;
                                 }
                              } else if(class90.field1367 == 1) {
                                 if(Tile.currentPressedKey == 85 && class90.password.length() > 0) {
                                    class90.password = class90.password.substring(0, class90.password.length() - 1);
                                 }

                                 if(Tile.currentPressedKey == 84 || Tile.currentPressedKey == 80) {
                                    class90.field1367 = 0;
                                 }

                                 if(Tile.currentPressedKey == 84) {
                                    class90.username = class90.username.trim();
                                    if(class90.username.length() == 0) {
                                       class33.method385("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class90.password.length() == 0) {
                                       class33.method385("", "Please enter your password.", "");
                                       return;
                                    }

                                    class33.method385("", "Connecting to server...", "");
                                    class61.method1058(false);
                                    MapIconReference.setGameState(20);
                                    return;
                                 }

                                 if(var13 && class90.password.length() < 20) {
                                    class90.password = class90.password + BuildType.currentTypedKey;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class90.loginIndex == 3) {
                        var21 = class90.loginWindowX + 180;
                        var23 = 276;
                        if(var3 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                           AbstractByteBuffer.method3767(false);
                        }

                        var21 = class90.loginWindowX + 180;
                        var23 = 326;
                        if(var3 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                           class33.method385("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var24;
                        int var25;
                        if(class90.loginIndex == 4) {
                           var21 = class90.loginWindowX + 180 - 80;
                           var23 = 321;
                           if(var3 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                              MapCacheArchiveNames.field520.trim();
                              if(MapCacheArchiveNames.field520.length() != 6) {
                                 class33.method385("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              PendingSpawn.field1145 = Integer.parseInt(MapCacheArchiveNames.field520);
                              MapCacheArchiveNames.field520 = "";
                              class61.method1058(true);
                              class33.method385("", "Connecting to server...", "");
                              MapIconReference.setGameState(20);
                              return;
                           }

                           if(var3 == 1 && var18 >= class90.loginWindowX + 180 - 9 && var18 <= class90.loginWindowX + 180 + 130 && var19 >= 263 && var19 <= 296) {
                              class90.field1344 = !class90.field1344;
                           }

                           if(var3 == 1 && var18 >= class90.loginWindowX + 180 - 34 && var18 <= class90.loginWindowX + 34 + 180 && var19 >= 351 && var19 <= 363) {
                              label852: {
                                 String var15 = ClientPacket.method3421("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                                 if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                    try {
                                       Desktop.getDesktop().browse(new URI(var15));
                                       break label852;
                                    } catch (Exception var16) {
                                       ;
                                    }
                                 }

                                 if(class57.field646.startsWith("win")) {
                                    ItemLayer.method2580(var15, 0);
                                 } else if(class57.field646.startsWith("mac")) {
                                    WorldMapType2.method553(var15, 1, "openjs");
                                 } else {
                                    ItemLayer.method2580(var15, 2);
                                 }
                              }
                           }

                           var21 = class90.loginWindowX + 180 + 80;
                           if(var3 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                              class90.loginIndex = 0;
                              class90.username = "";
                              class90.password = "";
                              PendingSpawn.field1145 = 0;
                              MapCacheArchiveNames.field520 = "";
                           }

                           while(WorldMapRegion.method519()) {
                              var24 = false;

                              for(var25 = 0; var25 < "1234567890".length(); ++var25) {
                                 if(BuildType.currentTypedKey == "1234567890".charAt(var25)) {
                                    var24 = true;
                                    break;
                                 }
                              }

                              if(Tile.currentPressedKey == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 PendingSpawn.field1145 = 0;
                                 MapCacheArchiveNames.field520 = "";
                              } else {
                                 if(Tile.currentPressedKey == 85 && MapCacheArchiveNames.field520.length() > 0) {
                                    MapCacheArchiveNames.field520 = MapCacheArchiveNames.field520.substring(0, MapCacheArchiveNames.field520.length() - 1);
                                 }

                                 if(Tile.currentPressedKey == 84) {
                                    MapCacheArchiveNames.field520.trim();
                                    if(MapCacheArchiveNames.field520.length() != 6) {
                                       class33.method385("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    PendingSpawn.field1145 = Integer.parseInt(MapCacheArchiveNames.field520);
                                    MapCacheArchiveNames.field520 = "";
                                    class61.method1058(true);
                                    class33.method385("", "Connecting to server...", "");
                                    MapIconReference.setGameState(20);
                                    return;
                                 }

                                 if(var24 && MapCacheArchiveNames.field520.length() < 6) {
                                    MapCacheArchiveNames.field520 = MapCacheArchiveNames.field520 + BuildType.currentTypedKey;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 5) {
                           var21 = class90.loginWindowX + 180 - 80;
                           var23 = 321;
                           if(var3 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                              class278.method4922();
                              return;
                           }

                           var21 = class90.loginWindowX + 180 + 80;
                           if(var3 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                              AbstractByteBuffer.method3767(true);
                           }

                           while(WorldMapRegion.method519()) {
                              var24 = false;

                              for(var25 = 0; var25 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var25) {
                                 if(BuildType.currentTypedKey == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var25)) {
                                    var24 = true;
                                    break;
                                 }
                              }

                              if(Tile.currentPressedKey == 13) {
                                 AbstractByteBuffer.method3767(true);
                              } else {
                                 if(Tile.currentPressedKey == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(Tile.currentPressedKey == 84) {
                                    class278.method4922();
                                    return;
                                 }

                                 if(var24 && class90.username.length() < 320) {
                                    class90.username = class90.username + BuildType.currentTypedKey;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!WorldMapRegion.method519()) {
                                    var22 = 321;
                                    if(var3 == 1 && var19 >= var22 - 20 && var19 <= var22 + 20) {
                                       AbstractByteBuffer.method3767(true);
                                    }

                                    return;
                                 }
                              } while(Tile.currentPressedKey != 84 && Tile.currentPressedKey != 13);

                              AbstractByteBuffer.method3767(true);
                           }
                        }
                     }
                  } else {
                     while(WorldMapRegion.method519()) {
                        if(Tile.currentPressedKey == 84) {
                           AbstractByteBuffer.method3767(false);
                        } else if(Tile.currentPressedKey == 13) {
                           class90.loginIndex = 0;
                        }
                     }

                     var21 = GameCanvas.field630 - 80;
                     var23 = 321;
                     if(var3 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                        AbstractByteBuffer.method3767(false);
                     }

                     var21 = GameCanvas.field630 + 80;
                     if(var3 == 1 && var18 >= var21 - 75 && var18 <= var21 + 75 && var19 >= var23 - 20 && var19 <= var23 + 20) {
                        class90.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2021010123"
   )
   static boolean method98() {
      if(Client.field1125 != null && Client.field1126 < Client.field1125.size()) {
         while(Client.field1126 < Client.field1125.size()) {
            class64 var0 = (class64)Client.field1125.get(Client.field1126);
            if(!var0.method1089()) {
               return false;
            }

            ++Client.field1126;
         }

         return true;
      } else {
         return true;
      }
   }
}
