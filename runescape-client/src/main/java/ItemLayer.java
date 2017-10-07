import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 660876079
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1322711183
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1720504829
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1408158053
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 370591105
   )
   @Export("height")
   int height;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lbn;I)V",
      garbageValue = "1745044574"
   )
   static void method2496(GameEngine var0) {
      int var1;
      int var2;
      int var3;
      int var14;
      if(class90.worldSelectShown) {
         if(MouseInput.field741 == 1 || !class110.field1650 && MouseInput.field741 == 4) {
            var1 = class90.field1419 + 280;
            if(MouseInput.field752 >= var1 && MouseInput.field752 <= var1 + 14 && MouseInput.field753 >= 4 && MouseInput.field753 <= 18) {
               class46.method678(0, 0);
            } else if(MouseInput.field752 >= var1 + 15 && MouseInput.field752 <= var1 + 80 && MouseInput.field753 >= 4 && MouseInput.field753 <= 18) {
               class46.method678(0, 1);
            } else {
               var2 = class90.field1419 + 390;
               if(MouseInput.field752 >= var2 && MouseInput.field752 <= var2 + 14 && MouseInput.field753 >= 4 && MouseInput.field753 <= 18) {
                  class46.method678(1, 0);
               } else if(MouseInput.field752 >= var2 + 15 && MouseInput.field752 <= var2 + 80 && MouseInput.field753 >= 4 && MouseInput.field753 <= 18) {
                  class46.method678(1, 1);
               } else {
                  var3 = class90.field1419 + 500;
                  if(MouseInput.field752 >= var3 && MouseInput.field752 <= var3 + 14 && MouseInput.field753 >= 4 && MouseInput.field753 <= 18) {
                     class46.method678(2, 0);
                  } else if(MouseInput.field752 >= var3 + 15 && MouseInput.field752 <= var3 + 80 && MouseInput.field753 >= 4 && MouseInput.field753 <= 18) {
                     class46.method678(2, 1);
                  } else {
                     var14 = class90.field1419 + 610;
                     if(MouseInput.field752 >= var14 && MouseInput.field752 <= var14 + 14 && MouseInput.field753 >= 4 && MouseInput.field753 <= 18) {
                        class46.method678(3, 0);
                     } else if(MouseInput.field752 >= var14 + 15 && MouseInput.field752 <= var14 + 80 && MouseInput.field753 >= 4 && MouseInput.field753 <= 18) {
                        class46.method678(3, 1);
                     } else if(MouseInput.field752 >= class90.field1419 + 708 && MouseInput.field753 >= 4 && MouseInput.field752 <= class90.field1419 + 708 + 50 && MouseInput.field753 <= 20) {
                        class90.worldSelectShown = false;
                        class208.field2603.method5173(class90.field1419, 0);
                        ScriptState.field791.method5173(class90.field1419 + 382, 0);
                        class90.logoSprite.method5147(class90.field1419 + 382 - class90.logoSprite.originalWidth / 2, 18);
                     } else if(class90.field1429 != -1) {
                        World var5 = class138.worldList[class90.field1429];
                        class86.method1775(var5);
                        class90.worldSelectShown = false;
                        class208.field2603.method5173(class90.field1419, 0);
                        ScriptState.field791.method5173(class90.field1419 + 382, 0);
                        class90.logoSprite.method5147(class90.field1419 + 382 - class90.logoSprite.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((MouseInput.field741 == 1 || !class110.field1650 && MouseInput.field741 == 4) && MouseInput.field752 >= class90.field1419 + 765 - 50 && MouseInput.field753 >= 453) {
            class23.preferences.muted = !class23.preferences.muted;
            class10.method58();
            if(!class23.preferences.muted) {
               IndexData var9 = class268.indexTrack1;
               var2 = var9.getFile("scape main");
               var3 = var9.getChild(var2, "");
               IndexFile.method3094(var9, var2, var3, 255, false);
            } else {
               CombatInfoListHolder.method1750();
            }
         }

         if(Client.gameState != 5) {
            ++class90.field1413;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.languageId == 0) {
                  if(MouseInput.field741 == 1 || !class110.field1650 && MouseInput.field741 == 4) {
                     var1 = class90.field1419 + 5;
                     short var11 = 463;
                     byte var12 = 100;
                     byte var4 = 35;
                     if(MouseInput.field752 >= var1 && MouseInput.field752 <= var1 + var12 && MouseInput.field753 >= var11 && MouseInput.field753 <= var4 + var11) {
                        if(class12.loadWorlds()) {
                           class90.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(World.listFetcher != null && class12.loadWorlds()) {
                     class90.worldSelectShown = true;
                  }
               }

               var1 = MouseInput.field741;
               var2 = MouseInput.field752;
               var3 = MouseInput.field753;
               if(var1 == 0) {
                  var2 = MouseInput.field745;
                  var3 = MouseInput.field746;
               }

               if(!class110.field1650 && var1 == 4) {
                  var1 = 1;
               }

               short var6;
               int var10;
               if(class90.loginIndex == 0) {
                  boolean var13 = false;

                  while(class1.method0()) {
                     if(class94.field1491 == 84) {
                        var13 = true;
                     }
                  }

                  var10 = WorldMapType2.field539 - 80;
                  var6 = 291;
                  if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                     ClanMember.method1197(class44.method637("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var10 = WorldMapType2.field539 + 80;
                  if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20 || var13) {
                     if((Client.flags & 33554432) != 0) {
                        class90.field1428 = "";
                        class90.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class90.loginMessage2 = "Your normal account will not be affected.";
                        class90.loginMessage3 = "";
                        class90.loginIndex = 1;
                        class43.method622();
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

                        class90.field1428 = "Warning!";
                        class90.loginIndex = 1;
                        class43.method622();
                     } else if((Client.flags & 1024) != 0) {
                        class90.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class90.loginMessage2 = "The Protect Item prayer will";
                        class90.loginMessage3 = "not work on this world.";
                        class90.field1428 = "Warning!";
                        class90.loginIndex = 1;
                        class43.method622();
                     } else {
                        class46.method714(false);
                     }
                  }
               } else {
                  short var18;
                  if(class90.loginIndex != 1) {
                     short var15;
                     if(class90.loginIndex == 2) {
                        var15 = 201;
                        var14 = var15 + 52;
                        if(var1 == 1 && var3 >= var14 - 12 && var3 < var14 + 2) {
                           class90.field1439 = 0;
                        }

                        var14 += 15;
                        if(var1 == 1 && var3 >= var14 - 12 && var3 < var14 + 2) {
                           class90.field1439 = 1;
                        }

                        var14 += 15;
                        var15 = 361;
                        if(var1 == 1 && var3 >= var15 - 15 && var3 < var15) {
                           class1.method3("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }

                        var10 = WorldMapType2.field539 - 80;
                        var6 = 321;
                        if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                           class90.username = class90.username.trim();
                           if(class90.username.length() == 0) {
                              class1.method3("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class90.password.length() == 0) {
                              class1.method3("", "Please enter your password.", "");
                              return;
                           }

                           class1.method3("", "Connecting to server...", "");
                           class204.method3924(false);
                           FrameMap.setGameState(20);
                           return;
                        }

                        var10 = class90.loginWindowX + 180 + 80;
                        if(var1 == 1 && var2 >= var10 - 75 && var2 <= var10 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                           class90.loginIndex = 0;
                           class90.username = "";
                           class90.password = "";
                           FrameMap.field2042 = 0;
                           class90.field1437 = "";
                           class90.field1438 = true;
                        }

                        var10 = WorldMapType2.field539 + -117;
                        var6 = 277;
                        class90.field1435 = var2 >= var10 && var2 < var10 + CacheFile.field1750 && var3 >= var6 && var3 < var6 + Spotanim.field3336;
                        if(var1 == 1 && class90.field1435) {
                           class90.field1414 = !class90.field1414;
                           if(!class90.field1414 && class23.preferences.field1306 != null) {
                              class23.preferences.field1306 = null;
                              class10.method58();
                           }
                        }

                        var10 = WorldMapType2.field539 + 24;
                        var6 = 277;
                        class90.field1436 = var2 >= var10 && var2 < var10 + CacheFile.field1750 && var3 >= var6 && var3 < var6 + Spotanim.field3336;
                        if(var1 == 1 && class90.field1436) {
                           class23.preferences.field1304 = !class23.preferences.field1304;
                           if(!class23.preferences.field1304) {
                              class90.username = "";
                              class23.preferences.field1306 = null;
                              class43.method622();
                           }

                           class10.method58();
                        }

                        while(true) {
                           while(class1.method0()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(ChatLineBuffer.field1546 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(class94.field1491 == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 FrameMap.field2042 = 0;
                                 class90.field1437 = "";
                                 class90.field1438 = true;
                              } else if(class90.field1439 == 0) {
                                 if(class94.field1491 == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(class94.field1491 == 84 || class94.field1491 == 80) {
                                    class90.field1439 = 1;
                                 }

                                 if(var7 && class90.username.length() < 320) {
                                    class90.username = class90.username + ChatLineBuffer.field1546;
                                 }
                              } else if(class90.field1439 == 1) {
                                 if(class94.field1491 == 85 && class90.password.length() > 0) {
                                    class90.password = class90.password.substring(0, class90.password.length() - 1);
                                 }

                                 if(class94.field1491 == 84 || class94.field1491 == 80) {
                                    class90.field1439 = 0;
                                 }

                                 if(class94.field1491 == 84) {
                                    class90.username = class90.username.trim();
                                    if(class90.username.length() == 0) {
                                       class1.method3("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class90.password.length() == 0) {
                                       class1.method3("", "Please enter your password.", "");
                                       return;
                                    }

                                    class1.method3("", "Connecting to server...", "");
                                    class204.method3924(false);
                                    FrameMap.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class90.password.length() < 20) {
                                    class90.password = class90.password + ChatLineBuffer.field1546;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class90.loginIndex == 3) {
                        var14 = class90.loginWindowX + 180;
                        var18 = 276;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                           class46.method714(false);
                        }

                        var14 = class90.loginWindowX + 180;
                        var18 = 326;
                        if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                           class1.method3("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var16;
                        int var17;
                        if(class90.loginIndex == 4) {
                           var14 = class90.loginWindowX + 180 - 80;
                           var18 = 321;
                           if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                              class90.field1437.trim();
                              if(class90.field1437.length() != 6) {
                                 class1.method3("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              FrameMap.field2042 = Integer.parseInt(class90.field1437);
                              class90.field1437 = "";
                              class204.method3924(true);
                              class1.method3("", "Connecting to server...", "");
                              FrameMap.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var2 >= class90.loginWindowX + 180 - 9 && var2 <= class90.loginWindowX + 180 + 130 && var3 >= 263 && var3 <= 296) {
                              class90.field1438 = !class90.field1438;
                           }

                           if(var1 == 1 && var2 >= class90.loginWindowX + 180 - 34 && var2 <= class90.loginWindowX + 34 + 180 && var3 >= 351 && var3 <= 363) {
                              ClanMember.method1197(class44.method637("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var14 = class90.loginWindowX + 180 + 80;
                           if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                              class90.loginIndex = 0;
                              class90.username = "";
                              class90.password = "";
                              FrameMap.field2042 = 0;
                              class90.field1437 = "";
                           }

                           while(class1.method0()) {
                              var16 = false;

                              for(var17 = 0; var17 < "1234567890".length(); ++var17) {
                                 if(ChatLineBuffer.field1546 == "1234567890".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(class94.field1491 == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 FrameMap.field2042 = 0;
                                 class90.field1437 = "";
                              } else {
                                 if(class94.field1491 == 85 && class90.field1437.length() > 0) {
                                    class90.field1437 = class90.field1437.substring(0, class90.field1437.length() - 1);
                                 }

                                 if(class94.field1491 == 84) {
                                    class90.field1437.trim();
                                    if(class90.field1437.length() != 6) {
                                       class1.method3("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    FrameMap.field2042 = Integer.parseInt(class90.field1437);
                                    class90.field1437 = "";
                                    class204.method3924(true);
                                    class1.method3("", "Connecting to server...", "");
                                    FrameMap.setGameState(20);
                                    return;
                                 }

                                 if(var16 && class90.field1437.length() < 6) {
                                    class90.field1437 = class90.field1437 + ChatLineBuffer.field1546;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 5) {
                           var14 = class90.loginWindowX + 180 - 80;
                           var18 = 321;
                           if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                              CombatInfoListHolder.method1746();
                              return;
                           }

                           var14 = class90.loginWindowX + 180 + 80;
                           if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                              class46.method714(true);
                           }

                           while(class1.method0()) {
                              var16 = false;

                              for(var17 = 0; var17 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var17) {
                                 if(ChatLineBuffer.field1546 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(class94.field1491 == 13) {
                                 class46.method714(true);
                              } else {
                                 if(class94.field1491 == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(class94.field1491 == 84) {
                                    CombatInfoListHolder.method1746();
                                    return;
                                 }

                                 if(var16 && class90.username.length() < 320) {
                                    class90.username = class90.username + ChatLineBuffer.field1546;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!class1.method0()) {
                                    var15 = 321;
                                    if(var1 == 1 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                                       class46.method714(true);
                                    }

                                    return;
                                 }
                              } while(class94.field1491 != 84 && class94.field1491 != 13);

                              class46.method714(true);
                           }
                        }
                     }
                  } else {
                     while(class1.method0()) {
                        if(class94.field1491 == 84) {
                           class46.method714(false);
                        } else if(class94.field1491 == 13) {
                           class90.loginIndex = 0;
                        }
                     }

                     var14 = WorldMapType2.field539 - 80;
                     var18 = 321;
                     if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                        class46.method714(false);
                     }

                     var14 = WorldMapType2.field539 + 80;
                     if(var1 == 1 && var2 >= var14 - 75 && var2 <= var14 + 75 && var3 >= var18 - 20 && var3 <= var18 + 20) {
                        class90.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "817438820"
   )
   static void method2495() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3646(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3647()) {
         int var1 = var0.id;
         if(class93.loadWidget(var1)) {
            boolean var2 = true;
            Widget[] var3 = class177.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = PacketBuffer.method3528(var4);
               if(var5 != null) {
                  class25.method172(var5);
               }
            }
         }
      }

   }
}
