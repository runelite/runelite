import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
final class class5 implements class0 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IS)Lin;",
      garbageValue = "29463"
   )
   @Export("getUnderlayDefinition")
   public static FloorUnderlayDefinition getUnderlayDefinition(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "812658144"
   )
   static void method22(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1173[var5] != var0) {
            var2[var4] = World.field1173[var5];
            var3[var4] = World.field1171[var5];
            ++var4;
         }
      }

      World.field1173 = var2;
      World.field1171 = var3;
      ScriptEvent.method1081(class89.worldList, 0, class89.worldList.length - 1, World.field1173, World.field1171);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lbn;B)V",
      garbageValue = "-67"
   )
   static void method24(GameEngine var0) {
      int var2;
      int var3;
      int var4;
      if(class89.worldSelectShown) {
         if(MouseInput.mouseLastButton == 1 || !Client.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
            int var1 = class89.field1301 + 280;
            if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var1 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
               method22(0, 0);
            } else if(MouseInput.mouseLastPressedX >= var1 + 15 && MouseInput.mouseLastPressedX <= var1 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
               method22(0, 1);
            } else {
               var2 = class89.field1301 + 390;
               if(MouseInput.mouseLastPressedX >= var2 && MouseInput.mouseLastPressedX <= var2 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                  method22(1, 0);
               } else if(MouseInput.mouseLastPressedX >= var2 + 15 && MouseInput.mouseLastPressedX <= var2 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                  method22(1, 1);
               } else {
                  var3 = class89.field1301 + 500;
                  if(MouseInput.mouseLastPressedX >= var3 && MouseInput.mouseLastPressedX <= var3 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                     method22(2, 0);
                  } else if(MouseInput.mouseLastPressedX >= var3 + 15 && MouseInput.mouseLastPressedX <= var3 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                     method22(2, 1);
                  } else {
                     var4 = class89.field1301 + 610;
                     if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var4 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        method22(3, 0);
                     } else if(MouseInput.mouseLastPressedX >= var4 + 15 && MouseInput.mouseLastPressedX <= var4 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
                        method22(3, 1);
                     } else if(MouseInput.mouseLastPressedX >= class89.field1301 + 708 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedX <= class89.field1301 + 708 + 50 && MouseInput.mouseLastPressedY <= 20) {
                        class89.worldSelectShown = false;
                        class89.field1316.method5534(class89.field1301, 0);
                        class295.field3780.method5534(class89.field1301 + 382, 0);
                        class7.logoSprite.method5504(class89.field1301 + 382 - class7.logoSprite.originalWidth / 2, 18);
                     } else if(class89.field1335 != -1) {
                        World var5 = class89.worldList[class89.field1335];
                        LoginPacket.method3293(var5);
                        class89.worldSelectShown = false;
                        class89.field1316.method5534(class89.field1301, 0);
                        class295.field3780.method5534(class89.field1301 + 382, 0);
                        class7.logoSprite.method5504(class89.field1301 + 382 - class7.logoSprite.originalWidth / 2, 18);
                     }
                  }
               }
            }
         }

      } else {
         if((MouseInput.mouseLastButton == 1 || !Client.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= class89.field1301 + 765 - 50 && MouseInput.mouseLastPressedY >= 453) {
            class221.preferences.muted = !class221.preferences.muted;
            class70.method1121();
            if(!class221.preferences.muted) {
               IndexData var12 = class148.indexTrack1;
               var2 = var12.getFile("scape main");
               var3 = var12.getChild(var2, "");
               class163.method3202(var12, var2, var3, 255, false);
            } else {
               class214.field2595.method3962();
               class214.field2596 = 1;
               Item.field1369 = null;
            }
         }

         if(Client.gameState != 5) {
            if(class89.field1336 == -1L) {
               class89.field1336 = ScriptVarType.currentTimeMs() + 1000L;
            }

            long var13 = ScriptVarType.currentTimeMs();
            boolean var19;
            if(Client.field1075 != null && Client.field1031 < Client.field1075.size()) {
               while(true) {
                  if(Client.field1031 >= Client.field1075.size()) {
                     var19 = true;
                     break;
                  }

                  class63 var16 = (class63)Client.field1075.get(Client.field1031);
                  if(!var16.method1052()) {
                     var19 = false;
                     break;
                  }

                  ++Client.field1031;
               }
            } else {
               var19 = true;
            }

            if(var19 && class89.field1337 == -1L) {
               class89.field1337 = var13;
               if(class89.field1337 > class89.field1336) {
                  class89.field1336 = class89.field1337;
               }
            }

            ++class89.field1334;
            if(Client.gameState == 10 || Client.gameState == 11) {
               if(Client.languageId == 0) {
                  if(MouseInput.mouseLastButton == 1 || !Client.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
                     var4 = class89.field1301 + 5;
                     short var15 = 463;
                     byte var6 = 100;
                     byte var7 = 35;
                     if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var6 + var4 && MouseInput.mouseLastPressedY >= var15 && MouseInput.mouseLastPressedY <= var15 + var7) {
                        BoundingBox3D.method70();
                        return;
                     }
                  }

                  if(class238.listFetcher != null) {
                     BoundingBox3D.method70();
                  }
               }

               var4 = MouseInput.mouseLastButton;
               int var26 = MouseInput.mouseLastPressedX;
               int var20 = MouseInput.mouseLastPressedY;
               if(var4 == 0) {
                  var26 = MouseInput.mouseLastX;
                  var20 = MouseInput.mouseLastY;
               }

               if(!Client.middleMouseMovesCamera && var4 == 4) {
                  var4 = 1;
               }

               int var8;
               short var9;
               if(class89.loginIndex == 0) {
                  boolean var21 = false;

                  while(Varbit.method4683()) {
                     if(WorldMapData.field427 == 84) {
                        var21 = true;
                     }
                  }

                  var8 = class89.field1307 - 80;
                  var9 = 291;
                  if(var4 == 1 && var26 >= var8 - 75 && var26 <= var8 + 75 && var20 >= var9 - 20 && var20 <= var9 + 20) {
                     String var10 = ISAACCipher.method3697("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                     class18.method153(var10, true, "openjs", false);
                  }

                  var8 = class89.field1307 + 80;
                  if(var4 == 1 && var26 >= var8 - 75 && var26 <= var8 + 75 && var20 >= var9 - 20 && var20 <= var9 + 20 || var21) {
                     if((Client.flags & 33554432) != 0) {
                        class89.Login_response0 = "";
                        class89.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class89.loginMessage2 = "Your normal account will not be affected.";
                        class89.loginMessage3 = "";
                        class89.loginIndex = 1;
                        class41.method571();
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
                        class41.method571();
                     } else if((Client.flags & 1024) != 0) {
                        class89.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class89.loginMessage2 = "The Protect Item prayer will";
                        class89.loginMessage3 = "not work on this world.";
                        class89.Login_response0 = "Warning!";
                        class89.loginIndex = 1;
                        class41.method571();
                     } else {
                        class163.method3185(false);
                     }
                  }
               } else {
                  int var22;
                  short var24;
                  if(class89.loginIndex != 1) {
                     short var23;
                     if(class89.loginIndex == 2) {
                        var23 = 201;
                        var22 = var23 + 52;
                        if(var4 == 1 && var20 >= var22 - 12 && var20 < var22 + 2) {
                           class89.field1300 = 0;
                        }

                        var22 += 15;
                        if(var4 == 1 && var20 >= var22 - 12 && var20 < var22 + 2) {
                           class89.field1300 = 1;
                        }

                        var22 += 15;
                        var23 = 361;
                        if(var4 == 1 && var20 >= var23 - 15 && var20 < var23) {
                           PacketNode.method3314("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class89.loginIndex = 5;
                           return;
                        }

                        var8 = class89.field1307 - 80;
                        var9 = 321;
                        if(var4 == 1 && var26 >= var8 - 75 && var26 <= var8 + 75 && var20 >= var9 - 20 && var20 <= var9 + 20) {
                           class89.username = class89.username.trim();
                           if(class89.username.length() == 0) {
                              PacketNode.method3314("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class89.password.length() == 0) {
                              PacketNode.method3314("", "Please enter your password.", "");
                              return;
                           }

                           PacketNode.method3314("", "Connecting to server...", "");
                           class179.method3376(false);
                           setGameState(20);
                           return;
                        }

                        var8 = class89.loginWindowX + 180 + 80;
                        if(var4 == 1 && var26 >= var8 - 75 && var26 <= var8 + 75 && var20 >= var9 - 20 && var20 <= var9 + 20) {
                           class89.loginIndex = 0;
                           class89.username = "";
                           class89.password = "";
                           Ignore.field3689 = 0;
                           Client.field1032 = "";
                           class89.field1329 = true;
                        }

                        var8 = class89.field1307 + -117;
                        var9 = 277;
                        class89.field1327 = var26 >= var8 && var26 < var8 + class219.field2680 && var20 >= var9 && var20 < var9 + BoundingBox3DDrawMode.field253;
                        if(var4 == 1 && class89.field1327) {
                           class89.Login_isUsernameRemembered = !class89.Login_isUsernameRemembered;
                           if(!class89.Login_isUsernameRemembered && class221.preferences.rememberedUsername != null) {
                              class221.preferences.rememberedUsername = null;
                              class70.method1121();
                           }
                        }

                        var8 = class89.field1307 + 24;
                        var9 = 277;
                        class89.field1328 = var26 >= var8 && var26 < var8 + class219.field2680 && var20 >= var9 && var20 < var9 + BoundingBox3DDrawMode.field253;
                        if(var4 == 1 && class89.field1328) {
                           class221.preferences.hideUsername = !class221.preferences.hideUsername;
                           if(!class221.preferences.hideUsername) {
                              class89.username = "";
                              class221.preferences.rememberedUsername = null;
                              class41.method571();
                           }

                           class70.method1121();
                        }

                        while(true) {
                           while(Varbit.method4683()) {
                              boolean var17 = false;

                              for(int var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var11) {
                                 if(class63.field722 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var11)) {
                                    var17 = true;
                                    break;
                                 }
                              }

                              if(WorldMapData.field427 == 13) {
                                 class89.loginIndex = 0;
                                 class89.username = "";
                                 class89.password = "";
                                 Ignore.field3689 = 0;
                                 Client.field1032 = "";
                                 class89.field1329 = true;
                              } else if(class89.field1300 == 0) {
                                 if(WorldMapData.field427 == 85 && class89.username.length() > 0) {
                                    class89.username = class89.username.substring(0, class89.username.length() - 1);
                                 }

                                 if(WorldMapData.field427 == 84 || WorldMapData.field427 == 80) {
                                    class89.field1300 = 1;
                                 }

                                 if(var17 && class89.username.length() < 320) {
                                    class89.username = class89.username + class63.field722;
                                 }
                              } else if(class89.field1300 == 1) {
                                 if(WorldMapData.field427 == 85 && class89.password.length() > 0) {
                                    class89.password = class89.password.substring(0, class89.password.length() - 1);
                                 }

                                 if(WorldMapData.field427 == 84 || WorldMapData.field427 == 80) {
                                    class89.field1300 = 0;
                                 }

                                 if(WorldMapData.field427 == 84) {
                                    class89.username = class89.username.trim();
                                    if(class89.username.length() == 0) {
                                       PacketNode.method3314("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class89.password.length() == 0) {
                                       PacketNode.method3314("", "Please enter your password.", "");
                                       return;
                                    }

                                    PacketNode.method3314("", "Connecting to server...", "");
                                    class179.method3376(false);
                                    setGameState(20);
                                    return;
                                 }

                                 if(var17 && class89.password.length() < 20) {
                                    class89.password = class89.password + class63.field722;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class89.loginIndex == 3) {
                        var22 = class89.loginWindowX + 180;
                        var24 = 276;
                        if(var4 == 1 && var26 >= var22 - 75 && var26 <= var22 + 75 && var20 >= var24 - 20 && var20 <= var24 + 20) {
                           class163.method3185(false);
                        }

                        var22 = class89.loginWindowX + 180;
                        var24 = 326;
                        if(var4 == 1 && var26 >= var22 - 75 && var26 <= var22 + 75 && var20 >= var24 - 20 && var20 <= var24 + 20) {
                           PacketNode.method3314("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class89.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var25;
                        int var27;
                        if(class89.loginIndex == 4) {
                           var22 = class89.loginWindowX + 180 - 80;
                           var24 = 321;
                           if(var4 == 1 && var26 >= var22 - 75 && var26 <= var22 + 75 && var20 >= var24 - 20 && var20 <= var24 + 20) {
                              Client.field1032.trim();
                              if(Client.field1032.length() != 6) {
                                 PacketNode.method3314("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              Ignore.field3689 = Integer.parseInt(Client.field1032);
                              Client.field1032 = "";
                              class179.method3376(true);
                              PacketNode.method3314("", "Connecting to server...", "");
                              setGameState(20);
                              return;
                           }

                           if(var4 == 1 && var26 >= class89.loginWindowX + 180 - 9 && var26 <= class89.loginWindowX + 180 + 130 && var20 >= 263 && var20 <= 296) {
                              class89.field1329 = !class89.field1329;
                           }

                           if(var4 == 1 && var26 >= class89.loginWindowX + 180 - 34 && var26 <= class89.loginWindowX + 34 + 180 && var20 >= 351 && var20 <= 363) {
                              String var18 = ISAACCipher.method3697("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                              class18.method153(var18, true, "openjs", false);
                           }

                           var22 = class89.loginWindowX + 180 + 80;
                           if(var4 == 1 && var26 >= var22 - 75 && var26 <= var22 + 75 && var20 >= var24 - 20 && var20 <= var24 + 20) {
                              class89.loginIndex = 0;
                              class89.username = "";
                              class89.password = "";
                              Ignore.field3689 = 0;
                              Client.field1032 = "";
                           }

                           while(Varbit.method4683()) {
                              var25 = false;

                              for(var27 = 0; var27 < "1234567890".length(); ++var27) {
                                 if(class63.field722 == "1234567890".charAt(var27)) {
                                    var25 = true;
                                    break;
                                 }
                              }

                              if(WorldMapData.field427 == 13) {
                                 class89.loginIndex = 0;
                                 class89.username = "";
                                 class89.password = "";
                                 Ignore.field3689 = 0;
                                 Client.field1032 = "";
                              } else {
                                 if(WorldMapData.field427 == 85 && Client.field1032.length() > 0) {
                                    Client.field1032 = Client.field1032.substring(0, Client.field1032.length() - 1);
                                 }

                                 if(WorldMapData.field427 == 84) {
                                    Client.field1032.trim();
                                    if(Client.field1032.length() != 6) {
                                       PacketNode.method3314("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    Ignore.field3689 = Integer.parseInt(Client.field1032);
                                    Client.field1032 = "";
                                    class179.method3376(true);
                                    PacketNode.method3314("", "Connecting to server...", "");
                                    setGameState(20);
                                    return;
                                 }

                                 if(var25 && Client.field1032.length() < 6) {
                                    Client.field1032 = Client.field1032 + class63.field722;
                                 }
                              }
                           }
                        } else if(class89.loginIndex == 5) {
                           var22 = class89.loginWindowX + 180 - 80;
                           var24 = 321;
                           if(var4 == 1 && var26 >= var22 - 75 && var26 <= var22 + 75 && var20 >= var24 - 20 && var20 <= var24 + 20) {
                              class23.method178();
                              return;
                           }

                           var22 = class89.loginWindowX + 180 + 80;
                           if(var4 == 1 && var26 >= var22 - 75 && var26 <= var22 + 75 && var20 >= var24 - 20 && var20 <= var24 + 20) {
                              class163.method3185(true);
                           }

                           while(Varbit.method4683()) {
                              var25 = false;

                              for(var27 = 0; var27 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var27) {
                                 if(class63.field722 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var27)) {
                                    var25 = true;
                                    break;
                                 }
                              }

                              if(WorldMapData.field427 == 13) {
                                 class163.method3185(true);
                              } else {
                                 if(WorldMapData.field427 == 85 && class89.username.length() > 0) {
                                    class89.username = class89.username.substring(0, class89.username.length() - 1);
                                 }

                                 if(WorldMapData.field427 == 84) {
                                    class23.method178();
                                    return;
                                 }

                                 if(var25 && class89.username.length() < 320) {
                                    class89.username = class89.username + class63.field722;
                                 }
                              }
                           }
                        } else if(class89.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!Varbit.method4683()) {
                                    var23 = 321;
                                    if(var4 == 1 && var20 >= var23 - 20 && var20 <= var23 + 20) {
                                       class163.method3185(true);
                                    }

                                    return;
                                 }
                              } while(WorldMapData.field427 != 84 && WorldMapData.field427 != 13);

                              class163.method3185(true);
                           }
                        }
                     }
                  } else {
                     while(Varbit.method4683()) {
                        if(WorldMapData.field427 == 84) {
                           class163.method3185(false);
                        } else if(WorldMapData.field427 == 13) {
                           class89.loginIndex = 0;
                        }
                     }

                     var22 = class89.field1307 - 80;
                     var24 = 321;
                     if(var4 == 1 && var26 >= var22 - 75 && var26 <= var22 + 75 && var20 >= var24 - 20 && var20 <= var24 + 20) {
                        class163.method3185(false);
                     }

                     var22 = class89.field1307 + 80;
                     if(var4 == 1 && var26 >= var22 - 75 && var26 <= var22 + 75 && var20 >= var24 - 20 && var20 <= var24 + 20) {
                        class89.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1018876239"
   )
   static final void method23(String var0) {
      class63.method1054("Please remove " + var0 + " from your ignore list first");
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILcd;ZB)I",
      garbageValue = "121"
   )
   static int method19(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class80.intStack[++class80.intStackSize - 1] = Client.publicChatMode;
         return 1;
      } else if(var0 == 5001) {
         class80.intStackSize -= 3;
         Client.publicChatMode = class80.intStack[class80.intStackSize];
         class31.field415 = CollisionData.method3285(class80.intStack[class80.intStackSize + 1]);
         if(class31.field415 == null) {
            class31.field415 = class301.field3832;
         }

         Client.field975 = class80.intStack[class80.intStackSize + 2];
         PacketNode var26 = class35.method501(ClientPacket.field2294, Client.field867.field1439);
         var26.packetBuffer.putByte(Client.publicChatMode);
         var26.packetBuffer.putByte(class31.field415.field3829);
         var26.packetBuffer.putByte(Client.field975);
         Client.field867.method2021(var26);
         return 1;
      } else {
         String var3;
         int var4;
         int var5;
         if(var0 == 5002) {
            var3 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
            class80.intStackSize -= 2;
            var4 = class80.intStack[class80.intStackSize];
            var5 = class80.intStack[class80.intStackSize + 1];
            PacketNode var20 = class35.method501(ClientPacket.field2301, Client.field867.field1439);
            var20.packetBuffer.putByte(ContextMenuRow.getLength(var3) + 2);
            var20.packetBuffer.putString(var3);
            var20.packetBuffer.putByte(var4 - 1);
            var20.packetBuffer.putByte(var5);
            Client.field867.method2021(var20);
            return 1;
         } else {
            int var13;
            if(var0 == 5003) {
               class80.intStackSize -= 2;
               var13 = class80.intStack[class80.intStackSize];
               var4 = class80.intStack[class80.intStackSize + 1];
               ChatLineBuffer var6 = (ChatLineBuffer)class94.chatLineMap.get(Integer.valueOf(var13));
               MessageNode var22 = var6.getMessage(var4);
               if(var22 != null) {
                  class80.intStack[++class80.intStackSize - 1] = var22.id;
                  class80.intStack[++class80.intStackSize - 1] = var22.tick;
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var22.name != null?var22.name:"";
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var22.sender != null?var22.sender:"";
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var22.value != null?var22.value:"";
                  class80.intStack[++class80.intStackSize - 1] = var22.method1091()?1:(var22.method1116()?2:0);
               } else {
                  class80.intStack[++class80.intStackSize - 1] = -1;
                  class80.intStack[++class80.intStackSize - 1] = 0;
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 5004) {
               var13 = class80.intStack[--class80.intStackSize];
               MessageNode var25 = (MessageNode)class94.messages.get((long)var13);
               if(var25 != null) {
                  class80.intStack[++class80.intStackSize - 1] = var25.type;
                  class80.intStack[++class80.intStackSize - 1] = var25.tick;
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var25.name != null?var25.name:"";
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var25.sender != null?var25.sender:"";
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var25.value != null?var25.value:"";
                  class80.intStack[++class80.intStackSize - 1] = var25.method1091()?1:(var25.method1116()?2:0);
               } else {
                  class80.intStack[++class80.intStackSize - 1] = -1;
                  class80.intStack[++class80.intStackSize - 1] = 0;
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = "";
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 5005) {
               if(class31.field415 == null) {
                  class80.intStack[++class80.intStackSize - 1] = -1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = class31.field415.field3829;
               }

               return 1;
            } else if(var0 == 5008) {
               var3 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
               var4 = class80.intStack[--class80.intStackSize];
               String var21 = var3.toLowerCase();
               byte var27 = 0;
               if(var21.startsWith("yellow:")) {
                  var27 = 0;
                  var3 = var3.substring("yellow:".length());
               } else if(var21.startsWith("red:")) {
                  var27 = 1;
                  var3 = var3.substring("red:".length());
               } else if(var21.startsWith("green:")) {
                  var27 = 2;
                  var3 = var3.substring("green:".length());
               } else if(var21.startsWith("cyan:")) {
                  var27 = 3;
                  var3 = var3.substring("cyan:".length());
               } else if(var21.startsWith("purple:")) {
                  var27 = 4;
                  var3 = var3.substring("purple:".length());
               } else if(var21.startsWith("white:")) {
                  var27 = 5;
                  var3 = var3.substring("white:".length());
               } else if(var21.startsWith("flash1:")) {
                  var27 = 6;
                  var3 = var3.substring("flash1:".length());
               } else if(var21.startsWith("flash2:")) {
                  var27 = 7;
                  var3 = var3.substring("flash2:".length());
               } else if(var21.startsWith("flash3:")) {
                  var27 = 8;
                  var3 = var3.substring("flash3:".length());
               } else if(var21.startsWith("glow1:")) {
                  var27 = 9;
                  var3 = var3.substring("glow1:".length());
               } else if(var21.startsWith("glow2:")) {
                  var27 = 10;
                  var3 = var3.substring("glow2:".length());
               } else if(var21.startsWith("glow3:")) {
                  var27 = 11;
                  var3 = var3.substring("glow3:".length());
               } else if(Client.languageId != 0) {
                  if(var21.startsWith("yellow:")) {
                     var27 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var21.startsWith("red:")) {
                     var27 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var21.startsWith("green:")) {
                     var27 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var21.startsWith("cyan:")) {
                     var27 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var21.startsWith("purple:")) {
                     var27 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var21.startsWith("white:")) {
                     var27 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var21.startsWith("flash1:")) {
                     var27 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var21.startsWith("flash2:")) {
                     var27 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var21.startsWith("flash3:")) {
                     var27 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var21.startsWith("glow1:")) {
                     var27 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var21.startsWith("glow2:")) {
                     var27 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var21.startsWith("glow3:")) {
                     var27 = 11;
                     var3 = var3.substring("glow3:".length());
                  }
               }

               var21 = var3.toLowerCase();
               byte var7 = 0;
               if(var21.startsWith("wave:")) {
                  var7 = 1;
                  var3 = var3.substring("wave:".length());
               } else if(var21.startsWith("wave2:")) {
                  var7 = 2;
                  var3 = var3.substring("wave2:".length());
               } else if(var21.startsWith("shake:")) {
                  var7 = 3;
                  var3 = var3.substring("shake:".length());
               } else if(var21.startsWith("scroll:")) {
                  var7 = 4;
                  var3 = var3.substring("scroll:".length());
               } else if(var21.startsWith("slide:")) {
                  var7 = 5;
                  var3 = var3.substring("slide:".length());
               } else if(Client.languageId != 0) {
                  if(var21.startsWith("wave:")) {
                     var7 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var21.startsWith("wave2:")) {
                     var7 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var21.startsWith("shake:")) {
                     var7 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var21.startsWith("scroll:")) {
                     var7 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var21.startsWith("slide:")) {
                     var7 = 5;
                     var3 = var3.substring("slide:".length());
                  }
               }

               PacketNode var8 = class35.method501(ClientPacket.field2299, Client.field867.field1439);
               var8.packetBuffer.putByte(0);
               int var9 = var8.packetBuffer.offset;
               var8.packetBuffer.putByte(var4);
               var8.packetBuffer.putByte(var27);
               var8.packetBuffer.putByte(var7);
               PacketBuffer var10 = var8.packetBuffer;
               int var11 = var10.offset;
               byte[] var12 = class150.method3043(var3);
               var10.putShortSmart(var12.length);
               var10.offset += class288.huffman.compress(var12, 0, var12.length, var10.payload, var10.offset);
               var8.packetBuffer.method3402(var8.packetBuffer.offset - var9);
               Client.field867.method2021(var8);
               return 1;
            } else {
               int var16;
               if(var0 == 5009) {
                  WorldComparator.scriptStringStackSize -= 2;
                  var3 = class80.scriptStringStack[WorldComparator.scriptStringStackSize];
                  String var24 = class80.scriptStringStack[WorldComparator.scriptStringStackSize + 1];
                  PacketNode var14 = class35.method501(ClientPacket.field2341, Client.field867.field1439);
                  var14.packetBuffer.putShort(0);
                  var16 = var14.packetBuffer.offset;
                  var14.packetBuffer.putString(var3);
                  PacketBuffer var28 = var14.packetBuffer;
                  int var18 = var28.offset;
                  byte[] var19 = class150.method3043(var24);
                  var28.putShortSmart(var19.length);
                  var28.offset += class288.huffman.compress(var19, 0, var19.length, var28.payload, var28.offset);
                  var14.packetBuffer.method3492(var14.packetBuffer.offset - var16);
                  Client.field867.method2021(var14);
                  return 1;
               } else if(var0 != 5015) {
                  if(var0 == 5016) {
                     class80.intStack[++class80.intStackSize - 1] = Client.field975;
                     return 1;
                  } else if(var0 == 5017) {
                     var13 = class80.intStack[--class80.intStackSize];
                     int[] var23 = class80.intStack;
                     var5 = ++class80.intStackSize - 1;
                     ChatLineBuffer var17 = (ChatLineBuffer)class94.chatLineMap.get(Integer.valueOf(var13));
                     if(var17 == null) {
                        var16 = 0;
                     } else {
                        var16 = var17.size();
                     }

                     var23[var5] = var16;
                     return 1;
                  } else if(var0 == 5018) {
                     var13 = class80.intStack[--class80.intStackSize];
                     class80.intStack[++class80.intStackSize - 1] = FriendManager.method1733(var13);
                     return 1;
                  } else if(var0 == 5019) {
                     var13 = class80.intStack[--class80.intStackSize];
                     class80.intStack[++class80.intStackSize - 1] = class216.method4077(var13);
                     return 1;
                  } else if(var0 == 5020) {
                     var3 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize];
                     if(var3.equalsIgnoreCase("toggleroof")) {
                        class221.preferences.hideRoofs = !class221.preferences.hideRoofs;
                        class70.method1121();
                        if(class221.preferences.hideRoofs) {
                           class240.sendGameMessage(99, "", "Roofs are now all hidden");
                        } else {
                           class240.sendGameMessage(99, "", "Roofs will only be removed selectively");
                        }
                     }

                     if(var3.equalsIgnoreCase("displayfps")) {
                        Client.displayFps = !Client.displayFps;
                     }

                     if(Client.rights >= 2) {
                        if(var3.equalsIgnoreCase("aabb")) {
                           if(!class7.drawBoundingBoxes3D) {
                              class7.drawBoundingBoxes3D = true;
                              class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ALWAYS;
                           } else if(class7.boundingBox3DDrawMode == BoundingBox3DDrawMode.ALWAYS) {
                              class7.drawBoundingBoxes3D = true;
                              class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
                           } else {
                              class7.drawBoundingBoxes3D = false;
                           }
                        }

                        if(var3.equalsIgnoreCase("fpson")) {
                           Client.displayFps = true;
                        }

                        if(var3.equalsIgnoreCase("fpsoff")) {
                           Client.displayFps = false;
                        }

                        if(var3.equalsIgnoreCase("gc")) {
                           System.gc();
                        }

                        if(var3.equalsIgnoreCase("clientdrop")) {
                           UnitPriceComparator.method138();
                        }

                        if(var3.equalsIgnoreCase("cs")) {
                           class240.sendGameMessage(99, "", "" + Client.field870);
                        }

                        if(var3.equalsIgnoreCase("errortest") && Client.socketType == 2) {
                           throw new RuntimeException();
                        }
                     }

                     PacketNode var15 = class35.method501(ClientPacket.field2350, Client.field867.field1439);
                     var15.packetBuffer.putByte(var3.length() + 1);
                     var15.packetBuffer.putString(var3);
                     Client.field867.method2021(var15);
                     return 1;
                  } else if(var0 == 5021) {
                     Client.field857 = class80.scriptStringStack[--WorldComparator.scriptStringStackSize].toLowerCase().trim();
                     return 1;
                  } else if(var0 == 5022) {
                     class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = Client.field857;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  if(class36.localPlayer != null && class36.localPlayer.name != null) {
                     var3 = class36.localPlayer.name.getName();
                  } else {
                     var3 = "";
                  }

                  class80.scriptStringStack[++WorldComparator.scriptStringStackSize - 1] = var3;
                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2147184124"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class37.clientInstance.method852();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field1078 = 0;
            Client.field843 = 0;
            Client.field1076.method5340(var0);
            if(var0 != 20) {
               class179.method3376(false);
            }
         }

         if(var0 != 20 && var0 != 40 && class28.field387 != null) {
            class28.field387.vmethod3186();
            class28.field387 = null;
         }

         if(Client.gameState == 25) {
            Client.field877 = 0;
            Client.field873 = 0;
            Client.field874 = 1;
            Client.field875 = 0;
            Client.field1068 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class185.method3624(Client.indexCache10, Tile.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class185.method3624(Client.indexCache10, Tile.indexSprites, false, 4);
            } else {
               class70.method1123();
            }
         } else {
            class185.method3624(Client.indexCache10, Tile.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-236890289"
   )
   static void method18(int var0) {
      if(var0 == -3) {
         PacketNode.method3314("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         PacketNode.method3314("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         PacketNode.method3314("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class89.loginIndex = 3;
      } else if(var0 == 4) {
         PacketNode.method3314("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         PacketNode.method3314("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         PacketNode.method3314("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         PacketNode.method3314("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         PacketNode.method3314("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         PacketNode.method3314("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         PacketNode.method3314("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         PacketNode.method3314("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         PacketNode.method3314("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         PacketNode.method3314("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         PacketNode.method3314("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         PacketNode.method3314("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         PacketNode.method3314("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         PacketNode.method3314("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         PacketNode.method3314("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         PacketNode.method3314("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         PacketNode.method3314("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         PacketNode.method3314("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         PacketNode.method3314("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         PacketNode.method3314("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         PacketNode.method3314("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         PacketNode.method3314("", "Service unavailable.", "");
      } else if(var0 == 31) {
         PacketNode.method3314("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         PacketNode.method3314("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         PacketNode.method3314("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         PacketNode.method3314("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         PacketNode.method3314("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            PacketNode.method3314("Enter the 6-digit code generated by your", "authenticator app.", "");
            setGameState(11);
            return;
         }

         if(var0 == 57) {
            PacketNode.method3314("The code you entered was incorrect.", "Please try again.", "");
            setGameState(11);
            return;
         }

         PacketNode.method3314("Unexpected server response", "Please try using a different world.", "");
      }

      setGameState(10);
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-774394451"
   )
   static final String method25(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
