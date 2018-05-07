import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class23 {
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = 1784959685
   )
   static int field354;
   @ObfuscatedName("ba")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("fx")
   @Export("landMapFileIds")
   static int[] landMapFileIds;
   @ObfuscatedName("me")
   @ObfuscatedGetter(
      intValue = 667536621
   )
   static int field352;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lbz;I)V",
      garbageValue = "805487262"
   )
   static void method181(GameEngine var0) {
      int var2;
      int var3;
      int var15;
      if(class90.worldSelectShown) {
         if(MouseInput.mouseLastButton == 1 || !Occluder.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
            int var1 = class90.field1336 + 280;
            if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var1 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
               class27.method222(0, 0);
            } else if(MouseInput.mouseLastPressedX >= var1 + 15 && MouseInput.mouseLastPressedX <= var1 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
               class27.method222(0, 1);
            } else {
               var2 = class90.field1336 + 390;
               if(MouseInput.mouseLastPressedX >= var2 && MouseInput.mouseLastPressedX <= var2 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                  class27.method222(1, 0);
               } else if(MouseInput.mouseLastPressedX >= var2 + 15 && MouseInput.mouseLastPressedX <= var2 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                  class27.method222(1, 1);
               } else {
                  var3 = class90.field1336 + 500;
                  if(MouseInput.mouseLastPressedX >= var3 && MouseInput.mouseLastPressedX <= var3 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                     class27.method222(2, 0);
                  } else if(MouseInput.mouseLastPressedX >= var3 + 15 && MouseInput.mouseLastPressedX <= var3 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                     class27.method222(2, 1);
                  } else {
                     var15 = class90.field1336 + 610;
                     if(MouseInput.mouseLastPressedX >= var15 && MouseInput.mouseLastPressedX <= var15 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        class27.method222(3, 0);
                     } else if(MouseInput.mouseLastPressedX >= var15 + 15 && MouseInput.mouseLastPressedX <= var15 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        class27.method222(3, 1);
                     } else if(MouseInput.mouseLastPressedX >= class90.field1336 + 708 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedX <= class90.field1336 + 708 + 50 && MouseInput.mouseLastPressedY <= 20) {
                        class90.worldSelectShown = false;
                        class90.field1359.method5915(class90.field1336, 0);
                        class90.field1340.method5915(class90.field1336 + 382, 0);
                        GrandExchangeOffer.logoSprite.method5898(class90.field1336 + 382 - GrandExchangeOffer.logoSprite.width / 2, 18);
                     } else if(class90.field1368 != -1) {
                        World var5 = class171.worldList[class90.field1368];
                        WorldMapType2.changeWorld(var5);
                        class90.worldSelectShown = false;
                        class90.field1359.method5915(class90.field1336, 0);
                        class90.field1340.method5915(class90.field1336 + 382, 0);
                        GrandExchangeOffer.logoSprite.method5898(class90.field1336 + 382 - GrandExchangeOffer.logoSprite.width / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((MouseInput.mouseLastButton == 1 || !Occluder.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= class90.field1336 + 765 - 50 && MouseInput.mouseLastPressedY >= 453) {
            Client.preferences.muted = !Client.preferences.muted;
            Widget.method4541();
            if(!Client.preferences.muted) {
               IndexData var11 = class7.indexTrack1;
               var2 = var11.getFile("scape main");
               var3 = var11.getChild(var2, "");
               MilliTimer.method3279(var11, var2, var3, 255, false);
            } else {
               class46.method684();
            }
         }

         if(Client.gameState != 5) {
            if(class90.field1361 == -1L) {
               class90.field1361 = class289.method5267() + 1000L;
            }

            long var12 = class289.method5267();
            if(class64.method1136() && -1L == class90.field1346) {
               class90.field1346 = var12;
               if(class90.field1346 > class90.field1361) {
                  class90.field1361 = class90.field1346;
               }
            }

            ++class90.field1370;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.languageId == 0) {
                  if(MouseInput.mouseLastButton == 1 || !Occluder.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
                     var3 = class90.field1336 + 5;
                     short var4 = 463;
                     byte var14 = 100;
                     byte var6 = 35;
                     if(MouseInput.mouseLastPressedX >= var3 && MouseInput.mouseLastPressedX <= var3 + var14 && MouseInput.mouseLastPressedY >= var4 && MouseInput.mouseLastPressedY <= var6 + var4) {
                        Buffer.method3604();
                        return;
                     }
                  }

                  if(Size.listFetcher != null) {
                     Buffer.method3604();
                  }
               }

               var3 = MouseInput.mouseLastButton;
               var15 = MouseInput.mouseLastPressedX;
               int var22 = MouseInput.mouseLastPressedY;
               if(var3 == 0) {
                  var15 = MouseInput.mouseLastX;
                  var22 = MouseInput.mouseLastY;
               }

               if(!Occluder.middleMouseMovesCamera && var3 == 4) {
                  var3 = 1;
               }

               int var7;
               short var8;
               if(class90.loginIndex == 0) {
                  boolean var16 = false;

                  while(IgnoreContainer.method5361()) {
                     if(class303.currentPressedKey == 84) {
                        var16 = true;
                     }
                  }

                  var7 = GrandExchangeEvent.field293 - 80;
                  var8 = 291;
                  if(var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var22 >= var8 - 20 && var22 <= var8 + 20) {
                     RunException.method3308(IndexData.method4789("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var7 = GrandExchangeEvent.field293 + 80;
                  if(var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var22 >= var8 - 20 && var22 <= var8 + 20 || var16) {
                     if((Client.flags & 33554432) != 0) {
                        class90.Login_response0 = "";
                        class90.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class90.loginMessage2 = "Your normal account will not be affected.";
                        class90.loginMessage3 = "";
                        class90.loginIndex = 1;
                        UrlRequest.method3183();
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
                        UrlRequest.method3183();
                     } else if((Client.flags & 1024) != 0) {
                        class90.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class90.loginMessage2 = "The Protect Item prayer will";
                        class90.loginMessage3 = "not work on this world.";
                        class90.Login_response0 = "Warning!";
                        class90.loginIndex = 1;
                        UrlRequest.method3183();
                     } else {
                        TotalQuantityComparator.method108(false);
                     }
                  }
               } else {
                  int var17;
                  short var19;
                  if(class90.loginIndex != 1) {
                     short var18;
                     if(class90.loginIndex == 2) {
                        var18 = 201;
                        var17 = var18 + 52;
                        if(var3 == 1 && var22 >= var17 - 12 && var22 < var17 + 2) {
                           class90.currentLoginField = 0;
                        }

                        var17 += 15;
                        if(var3 == 1 && var22 >= var17 - 12 && var22 < var17 + 2) {
                           class90.currentLoginField = 1;
                        }

                        var17 += 15;
                        var18 = 361;
                        if(var3 == 1 && var22 >= var18 - 15 && var22 < var18) {
                           VerticalAlignment.method4829("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }

                        var7 = GrandExchangeEvent.field293 - 80;
                        var8 = 321;
                        if(var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var22 >= var8 - 20 && var22 <= var8 + 20) {
                           class90.username = class90.username.trim();
                           if(class90.username.length() == 0) {
                              VerticalAlignment.method4829("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class90.password.length() == 0) {
                              VerticalAlignment.method4829("", "Please enter your password.", "");
                              return;
                           }

                           VerticalAlignment.method4829("", "Connecting to server...", "");
                           ScriptVarType.method25(false);
                           class55.setGameState(20);
                           return;
                        }

                        var7 = class90.loginWindowX + 180 + 80;
                        if(var3 == 1 && var15 >= var7 - 75 && var15 <= var7 + 75 && var22 >= var8 - 20 && var22 <= var8 + 20) {
                           class90.loginIndex = 0;
                           class90.username = "";
                           class90.password = "";
                           class21.field338 = 0;
                           WidgetNode.field767 = "";
                           class90.field1362 = true;
                        }

                        var7 = GrandExchangeEvent.field293 + -117;
                        var8 = 277;
                        class90.field1354 = var15 >= var7 && var15 < var7 + Buffer.field2571 && var22 >= var8 && var22 < var8 + WidgetNode.field770;
                        if(var3 == 1 && class90.field1354) {
                           class90.Login_isUsernameRemembered = !class90.Login_isUsernameRemembered;
                           if(!class90.Login_isUsernameRemembered && Client.preferences.rememberedUsername != null) {
                              Client.preferences.rememberedUsername = null;
                              Widget.method4541();
                           }
                        }

                        var7 = GrandExchangeEvent.field293 + 24;
                        var8 = 277;
                        class90.field1353 = var15 >= var7 && var15 < var7 + Buffer.field2571 && var22 >= var8 && var22 < var8 + WidgetNode.field770;
                        if(var3 == 1 && class90.field1353) {
                           Client.preferences.hideUsername = !Client.preferences.hideUsername;
                           if(!Client.preferences.hideUsername) {
                              class90.username = "";
                              Client.preferences.rememberedUsername = null;
                              UrlRequest.method3183();
                           }

                           Widget.method4541();
                        }

                        while(true) {
                           while(IgnoreContainer.method5361()) {
                              boolean var9 = false;

                              for(int var10 = 0; var10 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var10) {
                                 if(BoundingBox2D.currentTypedKey == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var10)) {
                                    var9 = true;
                                    break;
                                 }
                              }

                              if(class303.currentPressedKey == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 class21.field338 = 0;
                                 WidgetNode.field767 = "";
                                 class90.field1362 = true;
                              } else if(class90.currentLoginField == 0) {
                                 if(class303.currentPressedKey == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(class303.currentPressedKey == 84 || class303.currentPressedKey == 80) {
                                    class90.currentLoginField = 1;
                                 }

                                 if(var9 && class90.username.length() < 320) {
                                    class90.username = class90.username + BoundingBox2D.currentTypedKey;
                                 }
                              } else if(class90.currentLoginField == 1) {
                                 if(class303.currentPressedKey == 85 && class90.password.length() > 0) {
                                    class90.password = class90.password.substring(0, class90.password.length() - 1);
                                 }

                                 if(class303.currentPressedKey == 84 || class303.currentPressedKey == 80) {
                                    class90.currentLoginField = 0;
                                 }

                                 if(class303.currentPressedKey == 84) {
                                    class90.username = class90.username.trim();
                                    if(class90.username.length() == 0) {
                                       VerticalAlignment.method4829("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class90.password.length() == 0) {
                                       VerticalAlignment.method4829("", "Please enter your password.", "");
                                       return;
                                    }

                                    VerticalAlignment.method4829("", "Connecting to server...", "");
                                    ScriptVarType.method25(false);
                                    class55.setGameState(20);
                                    return;
                                 }

                                 if(var9 && class90.password.length() < 20) {
                                    class90.password = class90.password + BoundingBox2D.currentTypedKey;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class90.loginIndex == 3) {
                        var17 = class90.loginWindowX + 180;
                        var19 = 276;
                        if(var3 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
                           TotalQuantityComparator.method108(false);
                        }

                        var17 = class90.loginWindowX + 180;
                        var19 = 326;
                        if(var3 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
                           VerticalAlignment.method4829("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class90.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var20;
                        int var21;
                        if(class90.loginIndex == 4) {
                           var17 = class90.loginWindowX + 180 - 80;
                           var19 = 321;
                           if(var3 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
                              WidgetNode.field767.trim();
                              if(WidgetNode.field767.length() != 6) {
                                 VerticalAlignment.method4829("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class21.field338 = Integer.parseInt(WidgetNode.field767);
                              WidgetNode.field767 = "";
                              ScriptVarType.method25(true);
                              VerticalAlignment.method4829("", "Connecting to server...", "");
                              class55.setGameState(20);
                              return;
                           }

                           if(var3 == 1 && var15 >= class90.loginWindowX + 180 - 9 && var15 <= class90.loginWindowX + 180 + 130 && var22 >= 263 && var22 <= 296) {
                              class90.field1362 = !class90.field1362;
                           }

                           if(var3 == 1 && var15 >= class90.loginWindowX + 180 - 34 && var15 <= class90.loginWindowX + 34 + 180 && var22 >= 351 && var22 <= 363) {
                              RunException.method3308(IndexData.method4789("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var17 = class90.loginWindowX + 180 + 80;
                           if(var3 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
                              class90.loginIndex = 0;
                              class90.username = "";
                              class90.password = "";
                              class21.field338 = 0;
                              WidgetNode.field767 = "";
                           }

                           while(IgnoreContainer.method5361()) {
                              var20 = false;

                              for(var21 = 0; var21 < "1234567890".length(); ++var21) {
                                 if(BoundingBox2D.currentTypedKey == "1234567890".charAt(var21)) {
                                    var20 = true;
                                    break;
                                 }
                              }

                              if(class303.currentPressedKey == 13) {
                                 class90.loginIndex = 0;
                                 class90.username = "";
                                 class90.password = "";
                                 class21.field338 = 0;
                                 WidgetNode.field767 = "";
                              } else {
                                 if(class303.currentPressedKey == 85 && WidgetNode.field767.length() > 0) {
                                    WidgetNode.field767 = WidgetNode.field767.substring(0, WidgetNode.field767.length() - 1);
                                 }

                                 if(class303.currentPressedKey == 84) {
                                    WidgetNode.field767.trim();
                                    if(WidgetNode.field767.length() != 6) {
                                       VerticalAlignment.method4829("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class21.field338 = Integer.parseInt(WidgetNode.field767);
                                    WidgetNode.field767 = "";
                                    ScriptVarType.method25(true);
                                    VerticalAlignment.method4829("", "Connecting to server...", "");
                                    class55.setGameState(20);
                                    return;
                                 }

                                 if(var20 && WidgetNode.field767.length() < 6) {
                                    WidgetNode.field767 = WidgetNode.field767 + BoundingBox2D.currentTypedKey;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 5) {
                           var17 = class90.loginWindowX + 180 - 80;
                           var19 = 321;
                           if(var3 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
                              VarPlayerType.method4848();
                              return;
                           }

                           var17 = class90.loginWindowX + 180 + 80;
                           if(var3 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
                              TotalQuantityComparator.method108(true);
                           }

                           while(IgnoreContainer.method5361()) {
                              var20 = false;

                              for(var21 = 0; var21 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var21) {
                                 if(BoundingBox2D.currentTypedKey == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var21)) {
                                    var20 = true;
                                    break;
                                 }
                              }

                              if(class303.currentPressedKey == 13) {
                                 TotalQuantityComparator.method108(true);
                              } else {
                                 if(class303.currentPressedKey == 85 && class90.username.length() > 0) {
                                    class90.username = class90.username.substring(0, class90.username.length() - 1);
                                 }

                                 if(class303.currentPressedKey == 84) {
                                    VarPlayerType.method4848();
                                    return;
                                 }

                                 if(var20 && class90.username.length() < 320) {
                                    class90.username = class90.username + BoundingBox2D.currentTypedKey;
                                 }
                              }
                           }
                        } else if(class90.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!IgnoreContainer.method5361()) {
                                    var18 = 321;
                                    if(var3 == 1 && var22 >= var18 - 20 && var22 <= var18 + 20) {
                                       TotalQuantityComparator.method108(true);
                                    }

                                    return;
                                 }
                              } while(class303.currentPressedKey != 84 && class303.currentPressedKey != 13);

                              TotalQuantityComparator.method108(true);
                           }
                        }
                     }
                  } else {
                     while(IgnoreContainer.method5361()) {
                        if(class303.currentPressedKey == 84) {
                           TotalQuantityComparator.method108(false);
                        } else if(class303.currentPressedKey == 13) {
                           class90.loginIndex = 0;
                        }
                     }

                     var17 = GrandExchangeEvent.field293 - 80;
                     var19 = 321;
                     if(var3 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
                        TotalQuantityComparator.method108(false);
                     }

                     var17 = GrandExchangeEvent.field293 + 80;
                     if(var3 == 1 && var15 >= var17 - 75 && var15 <= var17 + 75 && var22 >= var19 - 20 && var22 <= var19 + 20) {
                        class90.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-634044909"
   )
   public static void method182() {
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
   }
}
