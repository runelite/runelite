import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class22 extends class28 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfr;Lfr;I)V",
      garbageValue = "-1208465165"
   )
   void method171(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field485.field480) {
         throw new IllegalStateException("");
      } else {
         super.field389 = var2.readUnsignedByte();
         super.field383 = var2.readUnsignedByte();
         super.field391 = var2.readUnsignedShort();
         super.field379 = var2.readUnsignedShort();
         super.field385 = var2.readUnsignedShort();
         super.field381 = var2.readUnsignedShort();
         super.field383 = Math.min(super.field383, 4);
         super.field384 = new short[1][64][64];
         super.field386 = new short[super.field383][64][64];
         super.field378 = new byte[super.field383][64][64];
         super.field387 = new byte[super.field383][64][64];
         super.field388 = new class31[super.field383][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field477.field474) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field385 && var5 == super.field381) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method221(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return super.field385 | super.field381 << 8;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field385 == super.field385 && var2.field381 == super.field381;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;Lid;I)V",
      garbageValue = "-27679416"
   )
   public static void method179(IndexDataBase var0, IndexDataBase var1) {
      NPCComposition.NpcDefinition_indexCache = var0;
      NPCComposition.NpcDefinition_modelIndexCache = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lbs;I)V",
      garbageValue = "-2017228085"
   )
   static void method173(GameEngine var0) {
      if(class91.worldSelectShown) {
         class1.method1(var0);
      } else {
         if((MouseInput.mouseLastButton == 1 || !Client.field956 && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= class91.field1354 + 765 - 50 && MouseInput.mouseLastPressedY >= 453) {
            RSCanvas.preferences.muted = !RSCanvas.preferences.muted;
            class64.method1103();
            if(!RSCanvas.preferences.muted) {
               SoundTaskDataProvider.method777(RSCanvas.indexTrack1, "scape main", "", 255, false);
            } else {
               Ignore.method1126();
            }
         }

         if(Client.gameState != 5) {
            ++class91.field1368;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.languageId == 0) {
                  if(MouseInput.mouseLastButton == 1 || !Client.field956 && MouseInput.mouseLastButton == 4) {
                     var1 = class91.field1354 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var3 + var1 && MouseInput.mouseLastPressedY >= var2 && MouseInput.mouseLastPressedY <= var2 + var4) {
                        if(class46.loadWorlds()) {
                           class91.worldSelectShown = true;
                        }

                        return;
                     }
                  }

                  if(ScriptState.listFetcher != null && class46.loadWorlds()) {
                     class91.worldSelectShown = true;
                  }
               }

               var1 = MouseInput.mouseLastButton;
               int var9 = MouseInput.mouseLastPressedX;
               int var10 = MouseInput.mouseLastPressedY;
               if(var1 == 0) {
                  var9 = MouseInput.field703;
                  var10 = MouseInput.field715 * 10625923;
               }

               if(!Client.field956 && var1 == 4) {
                  var1 = 1;
               }

               int var5;
               short var6;
               if(class91.loginIndex == 0) {
                  boolean var11 = false;

                  while(ScriptEvent.method1123()) {
                     if(class35.field473 == 84) {
                        var11 = true;
                     }
                  }

                  var5 = class91.field1348 - 80;
                  var6 = 291;
                  if(var1 == 1 && var9 >= var5 - 75 && var9 <= var5 + 75 && var10 >= var6 - 20 && var10 <= var6 + 20) {
                     MessageNode.method1132(ScriptState.method1090("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var5 = class91.field1348 + 80;
                  if(var1 == 1 && var9 >= var5 - 75 && var9 <= var5 + 75 && var10 >= var6 - 20 && var10 <= var6 + 20 || var11) {
                     if((Client.flags & 33554432) != 0) {
                        class91.Login_response0 = "";
                        class91.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class91.loginMessage2 = "Your normal account will not be affected.";
                        class91.loginMessage3 = "";
                        class91.loginIndex = 1;
                        class72.method1144();
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

                        class91.Login_response0 = "Warning!";
                        class91.loginIndex = 1;
                        class72.method1144();
                     } else if((Client.flags & 1024) != 0) {
                        class91.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class91.loginMessage2 = "The Protect Item prayer will";
                        class91.loginMessage3 = "not work on this world.";
                        class91.Login_response0 = "Warning!";
                        class91.loginIndex = 1;
                        class72.method1144();
                     } else {
                        class264.method4818(false);
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
                           class91.field1339 = 0;
                        }

                        var12 += 15;
                        if(var1 == 1 && var10 >= var12 - 12 && var10 < var12 + 2) {
                           class91.field1339 = 1;
                        }

                        var12 += 15;
                        var13 = 361;
                        if(var1 == 1 && var10 >= var13 - 15 && var10 < var13) {
                           NPC.method1749("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class91.loginIndex = 5;
                           return;
                        }

                        var5 = class91.field1348 - 80;
                        var6 = 321;
                        if(var1 == 1 && var9 >= var5 - 75 && var9 <= var5 + 75 && var10 >= var6 - 20 && var10 <= var6 + 20) {
                           class91.username = class91.username.trim();
                           if(class91.username.length() == 0) {
                              NPC.method1749("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class91.password.length() == 0) {
                              NPC.method1749("", "Please enter your password.", "");
                              return;
                           }

                           NPC.method1749("", "Connecting to server...", "");
                           ScriptVarType.method28(false);
                           WorldComparator.setGameState(20);
                           return;
                        }

                        var5 = class91.loginWindowX + 180 + 80;
                        if(var1 == 1 && var9 >= var5 - 75 && var9 <= var5 + 75 && var10 >= var6 - 20 && var10 <= var6 + 20) {
                           class91.loginIndex = 0;
                           class91.username = "";
                           class91.password = "";
                           class28.field390 = 0;
                           class28.field393 = "";
                           class91.field1369 = true;
                        }

                        var5 = class91.field1348 + -117;
                        var6 = 277;
                        class91.field1364 = var9 >= var5 && var9 < var5 + class61.field737 && var10 >= var6 && var10 < var6 + class28.field392;
                        if(var1 == 1 && class91.field1364) {
                           class91.Login_isUsernameRemembered = !class91.Login_isUsernameRemembered;
                           if(!class91.Login_isUsernameRemembered && RSCanvas.preferences.rememberedUsername != null) {
                              RSCanvas.preferences.rememberedUsername = null;
                              class64.method1103();
                           }
                        }

                        var5 = class91.field1348 + 24;
                        var6 = 277;
                        class91.field1360 = var9 >= var5 && var9 < var5 + class61.field737 && var10 >= var6 && var10 < var6 + class28.field392;
                        if(var1 == 1 && class91.field1360) {
                           RSCanvas.preferences.hideUsername = !RSCanvas.preferences.hideUsername;
                           if(!RSCanvas.preferences.hideUsername) {
                              class91.username = "";
                              RSCanvas.preferences.rememberedUsername = null;
                              class72.method1144();
                           }

                           class64.method1103();
                        }

                        while(true) {
                           while(ScriptEvent.method1123()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class20.field320 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(class35.field473 == 13) {
                                 class91.loginIndex = 0;
                                 class91.username = "";
                                 class91.password = "";
                                 class28.field390 = 0;
                                 class28.field393 = "";
                                 class91.field1369 = true;
                              } else if(class91.field1339 == 0) {
                                 if(class35.field473 == 85 && class91.username.length() > 0) {
                                    class91.username = class91.username.substring(0, class91.username.length() - 1);
                                 }

                                 if(class35.field473 == 84 || class35.field473 == 80) {
                                    class91.field1339 = 1;
                                 }

                                 if(var7 && class91.username.length() < 320) {
                                    class91.username = class91.username + class20.field320;
                                 }
                              } else if(class91.field1339 == 1) {
                                 if(class35.field473 == 85 && class91.password.length() > 0) {
                                    class91.password = class91.password.substring(0, class91.password.length() - 1);
                                 }

                                 if(class35.field473 == 84 || class35.field473 == 80) {
                                    class91.field1339 = 0;
                                 }

                                 if(class35.field473 == 84) {
                                    class91.username = class91.username.trim();
                                    if(class91.username.length() == 0) {
                                       NPC.method1749("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class91.password.length() == 0) {
                                       NPC.method1749("", "Please enter your password.", "");
                                       return;
                                    }

                                    NPC.method1749("", "Connecting to server...", "");
                                    ScriptVarType.method28(false);
                                    WorldComparator.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class91.password.length() < 20) {
                                    class91.password = class91.password + class20.field320;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class91.loginIndex == 3) {
                        var12 = class91.loginWindowX + 180;
                        var14 = 276;
                        if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                           class264.method4818(false);
                        }

                        var12 = class91.loginWindowX + 180;
                        var14 = 326;
                        if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                           NPC.method1749("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
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
                              class28.field393.trim();
                              if(class28.field393.length() != 6) {
                                 NPC.method1749("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class28.field390 = Integer.parseInt(class28.field393);
                              class28.field393 = "";
                              ScriptVarType.method28(true);
                              NPC.method1749("", "Connecting to server...", "");
                              WorldComparator.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var9 >= class91.loginWindowX + 180 - 9 && var9 <= class91.loginWindowX + 180 + 130 && var10 >= 263 && var10 <= 296) {
                              class91.field1369 = !class91.field1369;
                           }

                           if(var1 == 1 && var9 >= class91.loginWindowX + 180 - 34 && var9 <= class91.loginWindowX + 34 + 180 && var10 >= 351 && var10 <= 363) {
                              MessageNode.method1132(ScriptState.method1090("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var12 = class91.loginWindowX + 180 + 80;
                           if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                              class91.loginIndex = 0;
                              class91.username = "";
                              class91.password = "";
                              class28.field390 = 0;
                              class28.field393 = "";
                           }

                           while(ScriptEvent.method1123()) {
                              var15 = false;

                              for(var16 = 0; var16 < "1234567890".length(); ++var16) {
                                 if(class20.field320 == "1234567890".charAt(var16)) {
                                    var15 = true;
                                    break;
                                 }
                              }

                              if(class35.field473 == 13) {
                                 class91.loginIndex = 0;
                                 class91.username = "";
                                 class91.password = "";
                                 class28.field390 = 0;
                                 class28.field393 = "";
                              } else {
                                 if(class35.field473 == 85 && class28.field393.length() > 0) {
                                    class28.field393 = class28.field393.substring(0, class28.field393.length() - 1);
                                 }

                                 if(class35.field473 == 84) {
                                    class28.field393.trim();
                                    if(class28.field393.length() != 6) {
                                       NPC.method1749("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class28.field390 = Integer.parseInt(class28.field393);
                                    class28.field393 = "";
                                    ScriptVarType.method28(true);
                                    NPC.method1749("", "Connecting to server...", "");
                                    WorldComparator.setGameState(20);
                                    return;
                                 }

                                 if(var15 && class28.field393.length() < 6) {
                                    class28.field393 = class28.field393 + class20.field320;
                                 }
                              }
                           }
                        } else if(class91.loginIndex == 5) {
                           var12 = class91.loginWindowX + 180 - 80;
                           var14 = 321;
                           if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                              class25.method188();
                              return;
                           }

                           var12 = class91.loginWindowX + 180 + 80;
                           if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                              class264.method4818(true);
                           }

                           while(ScriptEvent.method1123()) {
                              var15 = false;

                              for(var16 = 0; var16 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var16) {
                                 if(class20.field320 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var16)) {
                                    var15 = true;
                                    break;
                                 }
                              }

                              if(class35.field473 == 13) {
                                 class264.method4818(true);
                              } else {
                                 if(class35.field473 == 85 && class91.username.length() > 0) {
                                    class91.username = class91.username.substring(0, class91.username.length() - 1);
                                 }

                                 if(class35.field473 == 84) {
                                    class25.method188();
                                    return;
                                 }

                                 if(var15 && class91.username.length() < 320) {
                                    class91.username = class91.username + class20.field320;
                                 }
                              }
                           }
                        } else if(class91.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!ScriptEvent.method1123()) {
                                    var13 = 321;
                                    if(var1 == 1 && var10 >= var13 - 20 && var10 <= var13 + 20) {
                                       class264.method4818(true);
                                    }

                                    return;
                                 }
                              } while(class35.field473 != 84 && class35.field473 != 13);

                              class264.method4818(true);
                           }
                        }
                     }
                  } else {
                     while(ScriptEvent.method1123()) {
                        if(class35.field473 == 84) {
                           class264.method4818(false);
                        } else if(class35.field473 == 13) {
                           class91.loginIndex = 0;
                        }
                     }

                     var12 = class91.field1348 - 80;
                     var14 = 321;
                     if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                        class264.method4818(false);
                     }

                     var12 = class91.field1348 + 80;
                     if(var1 == 1 && var9 >= var12 - 75 && var9 <= var12 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                        class91.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }
}
