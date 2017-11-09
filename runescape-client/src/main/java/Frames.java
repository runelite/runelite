import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lee;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Lik;Lik;IZ)V",
      garbageValue = "0"
   )
   public Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.fileCount(var3);
      this.skeletons = new Frame[var6];
      int[] var7 = var1.getChilds(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.getFront(); var12 != null; var12 = (FrameMap)var5.getNext()) {
            if(var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.getChild(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.addFront(var10);
         }

         this.skeletons[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "6828"
   )
   public boolean method2980(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lbn;I)V",
      garbageValue = "1752266838"
   )
   static void method2979(GameEngine var0) {
      if(class91.worldSelectShown) {
         class20.method173(var0);
      } else {
         if((MouseInput.field713 == 1 || !Item.field1399 && MouseInput.field713 == 4) && MouseInput.field714 >= class91.field1332 + 765 - 50 && MouseInput.field715 >= 453) {
            Buffer.preferences.muted = !Buffer.preferences.muted;
            class169.method3187();
            if(!Buffer.preferences.muted) {
               class9.method53(class21.indexTrack1, "scape main", "", 255, false);
            } else {
               ItemLayer.method2521();
            }
         }

         if(Client.gameState != 5) {
            ++class91.field1366;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.languageId == 0) {
                  if(MouseInput.field713 == 1 || !Item.field1399 && MouseInput.field713 == 4) {
                     var1 = class91.field1332 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(MouseInput.field714 >= var1 && MouseInput.field714 <= var3 + var1 && MouseInput.field715 >= var2 && MouseInput.field715 <= var2 + var4) {
                        if(class8.loadWorlds()) {
                           class91.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(class72.listFetcher != null && class8.loadWorlds()) {
                     class91.worldSelectShown = true;
                  }
               }

               var1 = MouseInput.field713;
               int var9 = MouseInput.field714;
               int var10 = MouseInput.field715;
               if(var1 == 0) {
                  var9 = MouseInput.field704;
                  var10 = MouseInput.field708;
               }

               if(!Item.field1399 && var1 == 4) {
                  var1 = 1;
               }

               int var5;
               short var6;
               if(class91.loginIndex == 0) {
                  boolean var11 = false;

                  while(class51.method839()) {
                     if(CombatInfoListHolder.field1289 == 84) {
                        var11 = true;
                     }
                  }

                  var5 = class233.field3209 - 80;
                  var6 = 291;
                  if(var1 == 1 && var9 >= var5 - 75 && var9 <= var5 + 75 && var10 >= var6 - 20 && var10 <= var6 + 20) {
                     class139.method2967(class24.method198("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var5 = class233.field3209 + 80;
                  if(var1 == 1 && var9 >= var5 - 75 && var9 <= var5 + 75 && var10 >= var6 - 20 && var10 <= var6 + 20 || var11) {
                     if((Client.flags & 33554432) != 0) {
                        class91.field1351 = "";
                        class91.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class91.loginMessage2 = "Your normal account will not be affected.";
                        class91.loginMessage3 = "";
                        class91.loginIndex = 1;
                        class72.method1183();
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class91.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class91.loginMessage2 = "Players can attack each other almost everywhere";
                           class91.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class91.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class91.loginMessage2 = "Players can attack each other";
                           class91.loginMessage3 = "almost everywhere.";
                        }

                        class91.field1351 = "Warning!";
                        class91.loginIndex = 1;
                        class72.method1183();
                     } else if((Client.flags & 1024) != 0) {
                        class91.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class91.loginMessage2 = "The Protect Item prayer will";
                        class91.loginMessage3 = "not work on this world.";
                        class91.field1351 = "Warning!";
                        class91.loginIndex = 1;
                        class72.method1183();
                     } else {
                        WorldMapType1.method288(false);
                     }
                  }
               } else {
                  int var12;
                  short var14;
                  if(class91.loginIndex != 1) {
                     short var13;
                     if(class91.loginIndex == 2) {
                        var13 = 201;
                        var12 = var13 + 52;
                        if(var1 == 1 && var10 >= var12 - 12 && var10 < var12 + 2) {
                           class91.field1350 = 0;
                        }

                        var12 += 15;
                        if(var1 == 1 && var10 >= var12 - 12 && var10 < var12 + 2) {
                           class91.field1350 = 1;
                        }

                        var12 += 15;
                        var13 = 361;
                        if(var1 == 1 && var10 >= var13 - 15 && var10 < var13) {
                           class8.method43("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class91.loginIndex = 5;
                           return;
                        }

                        var5 = class233.field3209 - 80;
                        var6 = 321;
                        if(var1 == 1 && var9 >= var5 - 75 && var9 <= var5 + 75 && var10 >= var6 - 20 && var10 <= var6 + 20) {
                           class91.username = class91.username.trim();
                           if(class91.username.length() == 0) {
                              class8.method43("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class91.password.length() == 0) {
                              class8.method43("", "Please enter your password.", "");
                              return;
                           }

                           class8.method43("", "Connecting to server...", "");
                           Permission.method4256(false);
                           class287.setGameState(20);
                           return;
                        }

                        var5 = class91.loginWindowX + 180 + 80;
                        if(var1 == 1 && var9 >= var5 - 75 && var9 <= var5 + 75 && var10 >= var6 - 20 && var10 <= var6 + 20) {
                           class91.loginIndex = 0;
                           class91.username = "";
                           class91.password = "";
                           class96.field1429 = 0;
                           class268.field3685 = "";
                           class91.field1338 = true;
                        }

                        var5 = class233.field3209 + -117;
                        var6 = 277;
                        class91.field1359 = var9 >= var5 && var9 < var5 + class44.field561 && var10 >= var6 && var10 < var6 + class91.field1358;
                        if(var1 == 1 && class91.field1359) {
                           class91.field1357 = !class91.field1357;
                           if(!class91.field1357 && Buffer.preferences.field1231 != null) {
                              Buffer.preferences.field1231 = null;
                              class169.method3187();
                           }
                        }

                        var5 = class233.field3209 + 24;
                        var6 = 277;
                        class91.field1360 = var9 >= var5 && var9 < var5 + class44.field561 && var10 >= var6 && var10 < var6 + class91.field1358;
                        if(var1 == 1 && class91.field1360) {
                           Buffer.preferences.field1232 = !Buffer.preferences.field1232;
                           if(!Buffer.preferences.field1232) {
                              class91.username = "";
                              Buffer.preferences.field1231 = null;
                              class72.method1183();
                           }

                           class169.method3187();
                        }

                        while(true) {
                           while(class51.method839()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class285.field3792 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(CombatInfoListHolder.field1289 == 13) {
                                 class91.loginIndex = 0;
                                 class91.username = "";
                                 class91.password = "";
                                 class96.field1429 = 0;
                                 class268.field3685 = "";
                                 class91.field1338 = true;
                              } else if(class91.field1350 == 0) {
                                 if(CombatInfoListHolder.field1289 == 85 && class91.username.length() > 0) {
                                    class91.username = class91.username.substring(0, class91.username.length() - 1);
                                 }

                                 if(CombatInfoListHolder.field1289 == 84 || CombatInfoListHolder.field1289 == 80) {
                                    class91.field1350 = 1;
                                 }

                                 if(var7 && class91.username.length() < 320) {
                                    class91.username = class91.username + class285.field3792;
                                 }
                              } else if(class91.field1350 == 1) {
                                 if(CombatInfoListHolder.field1289 == 85 && class91.password.length() > 0) {
                                    class91.password = class91.password.substring(0, class91.password.length() - 1);
                                 }

                                 if(CombatInfoListHolder.field1289 == 84 || CombatInfoListHolder.field1289 == 80) {
                                    class91.field1350 = 0;
                                 }

                                 if(CombatInfoListHolder.field1289 == 84) {
                                    class91.username = class91.username.trim();
                                    if(class91.username.length() == 0) {
                                       class8.method43("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class91.password.length() == 0) {
                                       class8.method43("", "Please enter your password.", "");
                                       return;
                                    }

                                    class8.method43("", "Connecting to server...", "");
                                    Permission.method4256(false);
                                    class287.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class91.password.length() < 20) {
                                    class91.password = class91.password + class285.field3792;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class91.loginIndex == 3) {
                        var12 = class91.loginWindowX + 180;
                        var14 = 276;
                        if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                           WorldMapType1.method288(false);
                        }

                        var12 = class91.loginWindowX + 180;
                        var14 = 326;
                        if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                           class8.method43("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class91.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var15;
                        int var16;
                        if(class91.loginIndex == 4) {
                           var12 = class91.loginWindowX + 180 - 80;
                           var14 = 321;
                           if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                              class268.field3685.trim();
                              if(class268.field3685.length() != 6) {
                                 class8.method43("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class96.field1429 = Integer.parseInt(class268.field3685);
                              class268.field3685 = "";
                              Permission.method4256(true);
                              class8.method43("", "Connecting to server...", "");
                              class287.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var9 >= class91.loginWindowX + 180 - 9 && var9 <= class91.loginWindowX + 180 + 130 && var10 >= 263 && var10 <= 296) {
                              class91.field1338 = !class91.field1338;
                           }

                           if(var1 == 1 && var9 >= class91.loginWindowX + 180 - 34 && var9 <= class91.loginWindowX + 34 + 180 && var10 >= 351 && var10 <= 363) {
                              class139.method2967(class24.method198("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var12 = class91.loginWindowX + 180 + 80;
                           if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                              class91.loginIndex = 0;
                              class91.username = "";
                              class91.password = "";
                              class96.field1429 = 0;
                              class268.field3685 = "";
                           }

                           while(class51.method839()) {
                              var15 = false;

                              for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                                 if(class285.field3792 == "1234567890".charAt(var16)) {
                                    var15 = true;
                                    break;
                                 }
                              }

                              if(CombatInfoListHolder.field1289 == 13) {
                                 class91.loginIndex = 0;
                                 class91.username = "";
                                 class91.password = "";
                                 class96.field1429 = 0;
                                 class268.field3685 = "";
                              } else {
                                 if(CombatInfoListHolder.field1289 == 85 && class268.field3685.length() > 0) {
                                    class268.field3685 = class268.field3685.substring(0, class268.field3685.length() - 1);
                                 }

                                 if(CombatInfoListHolder.field1289 == 84) {
                                    class268.field3685.trim();
                                    if(class268.field3685.length() != 6) {
                                       class8.method43("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class96.field1429 = Integer.parseInt(class268.field3685);
                                    class268.field3685 = "";
                                    Permission.method4256(true);
                                    class8.method43("", "Connecting to server...", "");
                                    class287.setGameState(20);
                                    return;
                                 }

                                 if(var15 && class268.field3685.length() < 6) {
                                    class268.field3685 = class268.field3685 + class285.field3792;
                                 }
                              }
                           }
                        } else if(class91.loginIndex == 5) {
                           var12 = class91.loginWindowX + 180 - 80;
                           var14 = 321;
                           if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                              CombatInfoListHolder.method1762();
                              return;
                           }

                           var12 = class91.loginWindowX + 180 + 80;
                           if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                              WorldMapType1.method288(true);
                           }

                           while(class51.method839()) {
                              var15 = false;

                              for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                                 if(class285.field3792 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                    var15 = true;
                                    break;
                                 }
                              }

                              if(CombatInfoListHolder.field1289 == 13) {
                                 WorldMapType1.method288(true);
                              } else {
                                 if(CombatInfoListHolder.field1289 == 85 && class91.username.length() > 0) {
                                    class91.username = class91.username.substring(0, class91.username.length() - 1);
                                 }

                                 if(CombatInfoListHolder.field1289 == 84) {
                                    CombatInfoListHolder.method1762();
                                    return;
                                 }

                                 if(var15 && class91.username.length() < 320) {
                                    class91.username = class91.username + class285.field3792;
                                 }
                              }
                           }
                        } else if(class91.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class51.method839()) {
                                    var13 = 321;
                                    if(var1 == 1 && var10 >= var13 - 20 && var10 <= var13 + 20) {
                                       WorldMapType1.method288(true);
                                    }

                                    return;
                                 }
                              } while(CombatInfoListHolder.field1289 != 84 && CombatInfoListHolder.field1289 != 13);

                              WorldMapType1.method288(true);
                           }
                        }
                     }
                  } else {
                     while(class51.method839()) {
                        if(CombatInfoListHolder.field1289 == 84) {
                           WorldMapType1.method288(false);
                        } else if(CombatInfoListHolder.field1289 == 13) {
                           class91.loginIndex = 0;
                        }
                     }

                     var12 = class233.field3209 - 80;
                     var14 = 321;
                     if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                        WorldMapType1.method288(false);
                     }

                     var12 = class233.field3209 + 80;
                     if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                        class91.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Lcd;",
      garbageValue = "-70"
   )
   static World method2978() {
      World.field1216 = 0;
      return ItemComposition.method4799();
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(Lbp;ZI)V",
      garbageValue = "936009061"
   )
   static final void method2984(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      int var5;
      if(var1 && var2 != -1 && class8.validInterfaces[var2]) {
         class46.widgetIndex.method4292(var2);
         if(class243.widgets[var2] != null) {
            boolean var6 = true;

            for(var5 = 0; var5 < class243.widgets[var2].length; ++var5) {
               if(class243.widgets[var2][var5] != null) {
                  if(class243.widgets[var2][var5].type != 2) {
                     class243.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               class243.widgets[var2] = null;
            }

            class8.validInterfaces[var2] = false;
         }
      }

      for(IntegerNode var4 = (IntegerNode)Client.widgetFlags.method3721(); var4 != null; var4 = (IntegerNode)Client.widgetFlags.method3728()) {
         if((long)var2 == (var4.hash >> 48 & 65535L)) {
            var4.unlink();
         }
      }

      Widget var7 = PendingSpawn.method1612(var3);
      if(var7 != null) {
         WorldMapData.method394(var7);
      }

      class171.method3208();
      if(Client.widgetRoot != -1) {
         var5 = Client.widgetRoot;
         if(CombatInfoListHolder.loadWidget(var5)) {
            class158.method3085(class243.widgets[var5], 1);
         }
      }

   }
}
