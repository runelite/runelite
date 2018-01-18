import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public final class class81 extends Node {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static Deque field1247;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1554118553
   )
   int field1242;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 746712709
   )
   int field1252;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   ObjectComposition field1255;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1278063469
   )
   int field1243;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -245154993
   )
   int field1241;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -825632049
   )
   int field1254;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1580438429
   )
   int field1246;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -416763919
   )
   int field1244;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -2142499043
   )
   int field1248;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   class116 field1249;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1895524607
   )
   int field1251;
   @ObfuscatedName("p")
   int[] field1245;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 604612909
   )
   int field1253;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   class116 field1250;

   static {
      field1247 = new Deque();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1458529588"
   )
   void method1641() {
      int var1 = this.field1248;
      ObjectComposition var2 = this.field1255.getImpostor();
      if(var2 != null) {
         this.field1248 = var2.ambientSoundId;
         this.field1244 = var2.int4 * 128;
         this.field1254 = var2.int5;
         this.field1251 = var2.int6;
         this.field1245 = var2.field3569;
      } else {
         this.field1248 = -1;
         this.field1244 = 0;
         this.field1254 = 0;
         this.field1251 = 0;
         this.field1245 = null;
      }

      if(var1 != this.field1248 && this.field1249 != null) {
         class89.field1328.method1924(this.field1249);
         this.field1249 = null;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lbd;B)V",
      garbageValue = "79"
   )
   static void method1640(GameEngine var0) {
      if(class91.worldSelectShown) {
         BoundingBox.method44(var0);
      } else {
         if((MouseInput.mouseLastButton == 1 || !class45.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) && MouseInput.mouseLastPressedX >= class91.field1336 + 765 - 50 && MouseInput.mouseLastPressedY >= 453) {
            class222.preferences.muted = !class222.preferences.muted;
            World.method1616();
            if(!class222.preferences.muted) {
               Tile.method2570(Size.indexTrack1, "scape main", "", 255, false);
            } else {
               class214.field2630.method3904();
               class214.field2631 = 1;
               class214.field2632 = null;
            }
         }

         if(Client.gameState != 5) {
            ++class91.field1366;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.languageId == 0) {
                  if(MouseInput.mouseLastButton == 1 || !class45.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
                     var1 = class91.field1336 + 5;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var3 + var1 && MouseInput.mouseLastPressedY >= var2 && MouseInput.mouseLastPressedY <= var4 + var2) {
                        class86.method1727();
                        return;
                     }
                  }

                  if(class37.listFetcher != null) {
                     class86.method1727();
                  }
               }

               var1 = MouseInput.mouseLastButton;
               int var10 = MouseInput.mouseLastPressedX;
               int var11 = MouseInput.mouseLastPressedY;
               if(var1 == 0) {
                  var10 = MouseInput.mouseLastX;
                  var11 = MouseInput.mouseLastY;
               }

               if(!class45.middleMouseMovesCamera && var1 == 4) {
                  var1 = 1;
               }

               int var5;
               short var6;
               if(class91.loginIndex == 0) {
                  boolean var12 = false;

                  while(WorldMapData.method343()) {
                     if(TextureProvider.field1683 == 84) {
                        var12 = true;
                     }
                  }

                  var5 = class91.field1344 - 80;
                  var6 = 291;
                  if(var1 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                     GameObject.method2964(Actor.method1573("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var5 = class91.field1344 + 80;
                  if(var1 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20 || var12) {
                     if((Client.flags & 33554432) != 0) {
                        class91.Login_response0 = "";
                        class91.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class91.loginMessage2 = "Your normal account will not be affected.";
                        class91.loginMessage3 = "";
                        class91.loginIndex = 1;
                        class48.method713();
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
                        class48.method713();
                     } else if((Client.flags & 1024) != 0) {
                        class91.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class91.loginMessage2 = "The Protect Item prayer will";
                        class91.loginMessage3 = "not work on this world.";
                        class91.Login_response0 = "Warning!";
                        class91.loginIndex = 1;
                        class48.method713();
                     } else {
                        class44.method615(false);
                     }
                  }
               } else {
                  int var13;
                  short var15;
                  if(class91.loginIndex != 1) {
                     short var14;
                     if(class91.loginIndex == 2) {
                        var14 = 201;
                        var13 = var14 + 52;
                        if(var1 == 1 && var11 >= var13 - 12 && var11 < var13 + 2) {
                           class91.field1347 = 0;
                        }

                        var13 += 15;
                        if(var1 == 1 && var11 >= var13 - 12 && var11 < var13 + 2) {
                           class91.field1347 = 1;
                        }

                        var13 += 15;
                        var14 = 361;
                        if(var1 == 1 && var11 >= var14 - 15 && var11 < var14) {
                           ClanMember.method1170("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class91.loginIndex = 5;
                           return;
                        }

                        var5 = class91.field1344 - 80;
                        var6 = 321;
                        if(var1 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class91.username = class91.username.trim();
                           if(class91.username.length() == 0) {
                              ClanMember.method1170("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class91.password.length() == 0) {
                              ClanMember.method1170("", "Please enter your password.", "");
                              return;
                           }

                           ClanMember.method1170("", "Connecting to server...", "");
                           class48.method722(false);
                           ClanMember.setGameState(20);
                           return;
                        }

                        var5 = class91.loginWindowX + 180 + 80;
                        if(var1 == 1 && var10 >= var5 - 75 && var10 <= var5 + 75 && var11 >= var6 - 20 && var11 <= var6 + 20) {
                           class91.loginIndex = 0;
                           class91.username = "";
                           class91.password = "";
                           class249.field3363 = 0;
                           IndexStoreActionHandler.field3327 = "";
                           class91.field1367 = true;
                        }

                        var5 = class91.field1344 + -117;
                        var6 = 277;
                        class91.field1335 = var10 >= var5 && var10 < var5 + FileSystem.field3301 && var11 >= var6 && var11 < var6 + class153.field2128;
                        if(var1 == 1 && class91.field1335) {
                           class91.Login_isUsernameRemembered = !class91.Login_isUsernameRemembered;
                           if(!class91.Login_isUsernameRemembered && class222.preferences.rememberedUsername != null) {
                              class222.preferences.rememberedUsername = null;
                              World.method1616();
                           }
                        }

                        var5 = class91.field1344 + 24;
                        var6 = 277;
                        class91.field1363 = var10 >= var5 && var10 < var5 + FileSystem.field3301 && var11 >= var6 && var11 < var6 + class153.field2128;
                        if(var1 == 1 && class91.field1363) {
                           class222.preferences.hideUsername = !class222.preferences.hideUsername;
                           if(!class222.preferences.hideUsername) {
                              class91.username = "";
                              class222.preferences.rememberedUsername = null;
                              class48.method713();
                           }

                           World.method1616();
                        }

                        while(true) {
                           while(WorldMapData.method343()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class37.field491 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(TextureProvider.field1683 == 13) {
                                 class91.loginIndex = 0;
                                 class91.username = "";
                                 class91.password = "";
                                 class249.field3363 = 0;
                                 IndexStoreActionHandler.field3327 = "";
                                 class91.field1367 = true;
                              } else if(class91.field1347 == 0) {
                                 if(TextureProvider.field1683 == 85 && class91.username.length() > 0) {
                                    class91.username = class91.username.substring(0, class91.username.length() - 1);
                                 }

                                 if(TextureProvider.field1683 == 84 || TextureProvider.field1683 == 80) {
                                    class91.field1347 = 1;
                                 }

                                 if(var7 && class91.username.length() < 320) {
                                    class91.username = class91.username + class37.field491;
                                 }
                              } else if(class91.field1347 == 1) {
                                 if(TextureProvider.field1683 == 85 && class91.password.length() > 0) {
                                    class91.password = class91.password.substring(0, class91.password.length() - 1);
                                 }

                                 if(TextureProvider.field1683 == 84 || TextureProvider.field1683 == 80) {
                                    class91.field1347 = 0;
                                 }

                                 if(TextureProvider.field1683 == 84) {
                                    class91.username = class91.username.trim();
                                    if(class91.username.length() == 0) {
                                       ClanMember.method1170("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class91.password.length() == 0) {
                                       ClanMember.method1170("", "Please enter your password.", "");
                                       return;
                                    }

                                    ClanMember.method1170("", "Connecting to server...", "");
                                    class48.method722(false);
                                    ClanMember.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class91.password.length() < 20) {
                                    class91.password = class91.password + class37.field491;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class91.loginIndex == 3) {
                        var13 = class91.loginWindowX + 180;
                        var15 = 276;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                           class44.method615(false);
                        }

                        var13 = class91.loginWindowX + 180;
                        var15 = 326;
                        if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                           ClanMember.method1170("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class91.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var16;
                        int var17;
                        if(class91.loginIndex == 4) {
                           var13 = class91.loginWindowX + 180 - 80;
                           var15 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                              IndexStoreActionHandler.field3327.trim();
                              if(IndexStoreActionHandler.field3327.length() != 6) {
                                 ClanMember.method1170("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class249.field3363 = Integer.parseInt(IndexStoreActionHandler.field3327);
                              IndexStoreActionHandler.field3327 = "";
                              class48.method722(true);
                              ClanMember.method1170("", "Connecting to server...", "");
                              ClanMember.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var10 >= class91.loginWindowX + 180 - 9 && var10 <= class91.loginWindowX + 180 + 130 && var11 >= 263 && var11 <= 296) {
                              class91.field1367 = !class91.field1367;
                           }

                           if(var1 == 1 && var10 >= class91.loginWindowX + 180 - 34 && var10 <= class91.loginWindowX + 34 + 180 && var11 >= 351 && var11 <= 363) {
                              String var9 = Actor.method1573("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                              class40.method537(var9, true, "openjs", false);
                           }

                           var13 = class91.loginWindowX + 180 + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                              class91.loginIndex = 0;
                              class91.username = "";
                              class91.password = "";
                              class249.field3363 = 0;
                              IndexStoreActionHandler.field3327 = "";
                           }

                           while(WorldMapData.method343()) {
                              var16 = false;

                              for(var17 = 0; var17 < "1234567890".length(); ++var17) {
                                 if(class37.field491 == "1234567890".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(TextureProvider.field1683 == 13) {
                                 class91.loginIndex = 0;
                                 class91.username = "";
                                 class91.password = "";
                                 class249.field3363 = 0;
                                 IndexStoreActionHandler.field3327 = "";
                              } else {
                                 if(TextureProvider.field1683 == 85 && IndexStoreActionHandler.field3327.length() > 0) {
                                    IndexStoreActionHandler.field3327 = IndexStoreActionHandler.field3327.substring(0, IndexStoreActionHandler.field3327.length() - 1);
                                 }

                                 if(TextureProvider.field1683 == 84) {
                                    IndexStoreActionHandler.field3327.trim();
                                    if(IndexStoreActionHandler.field3327.length() != 6) {
                                       ClanMember.method1170("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class249.field3363 = Integer.parseInt(IndexStoreActionHandler.field3327);
                                    IndexStoreActionHandler.field3327 = "";
                                    class48.method722(true);
                                    ClanMember.method1170("", "Connecting to server...", "");
                                    ClanMember.setGameState(20);
                                    return;
                                 }

                                 if(var16 && IndexStoreActionHandler.field3327.length() < 6) {
                                    IndexStoreActionHandler.field3327 = IndexStoreActionHandler.field3327 + class37.field491;
                                 }
                              }
                           }
                        } else if(class91.loginIndex == 5) {
                           var13 = class91.loginWindowX + 180 - 80;
                           var15 = 321;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                              class36.method489();
                              return;
                           }

                           var13 = class91.loginWindowX + 180 + 80;
                           if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                              class44.method615(true);
                           }

                           while(WorldMapData.method343()) {
                              var16 = false;

                              for(var17 = 0; var17 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var17) {
                                 if(class37.field491 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(TextureProvider.field1683 == 13) {
                                 class44.method615(true);
                              } else {
                                 if(TextureProvider.field1683 == 85 && class91.username.length() > 0) {
                                    class91.username = class91.username.substring(0, class91.username.length() - 1);
                                 }

                                 if(TextureProvider.field1683 == 84) {
                                    class36.method489();
                                    return;
                                 }

                                 if(var16 && class91.username.length() < 320) {
                                    class91.username = class91.username + class37.field491;
                                 }
                              }
                           }
                        } else if(class91.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!WorldMapData.method343()) {
                                    var14 = 321;
                                    if(var1 == 1 && var11 >= var14 - 20 && var11 <= var14 + 20) {
                                       class44.method615(true);
                                    }

                                    return;
                                 }
                              } while(TextureProvider.field1683 != 84 && TextureProvider.field1683 != 13);

                              class44.method615(true);
                           }
                        }
                     }
                  } else {
                     while(WorldMapData.method343()) {
                        if(TextureProvider.field1683 == 84) {
                           class44.method615(false);
                        } else if(TextureProvider.field1683 == 13) {
                           class91.loginIndex = 0;
                        }
                     }

                     var13 = class91.field1344 - 80;
                     var15 = 321;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                        class44.method615(false);
                     }

                     var13 = class91.field1344 + 80;
                     if(var1 == 1 && var10 >= var13 - 75 && var10 <= var13 + 75 && var11 >= var15 - 20 && var11 <= var15 + 20) {
                        class91.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(ZLgr;I)V",
      garbageValue = "-863630362"
   )
   @Hook("onNpcUpdate")
   @Export("updateNpcs")
   static final void updateNpcs(boolean var0, PacketBuffer var1) {
      while(true) {
         if(var1.bitsAvail(Client.field915.packetLength) >= 27) {
            int var2 = var1.getBits(15);
            if(var2 != 32767) {
               boolean var3 = false;
               if(Client.cachedNPCs[var2] == null) {
                  Client.cachedNPCs[var2] = new NPC();
                  var3 = true;
               }

               NPC var4 = Client.cachedNPCs[var2];
               Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
               var4.npcCycle = Client.gameCycle;
               int var5;
               if(var0) {
                  var5 = var1.getBits(8);
                  if(var5 > 127) {
                     var5 -= 256;
                  }
               } else {
                  var5 = var1.getBits(5);
                  if(var5 > 15) {
                     var5 -= 32;
                  }
               }

               int var6;
               if(var0) {
                  var6 = var1.getBits(8);
                  if(var6 > 127) {
                     var6 -= 256;
                  }
               } else {
                  var6 = var1.getBits(5);
                  if(var6 > 15) {
                     var6 -= 32;
                  }
               }

               int var7 = var1.getBits(1);
               var4.composition = class45.getNpcDefinition(var1.getBits(14));
               int var8 = var1.getBits(1);
               if(var8 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               }

               int var9 = Client.field943[var1.getBits(3)];
               if(var3) {
                  var4.orientation = var4.angle = var9;
               }

               var4.field1153 = var4.composition.field3667;
               var4.field1202 = var4.composition.field3662;
               if(var4.field1202 == 0) {
                  var4.angle = 0;
               }

               var4.field1168 = var4.composition.field3659;
               var4.field1158 = var4.composition.field3646;
               var4.field1175 = var4.composition.field3645;
               var4.field1160 = var4.composition.field3657;
               var4.idlePoseAnimation = var4.composition.field3642;
               var4.field1156 = var4.composition.field3643;
               var4.field1173 = var4.composition.field3644;
               var4.method1710(GrandExchangeOffer.localPlayer.pathX[0] + var6, GrandExchangeOffer.localPlayer.pathY[0] + var5, var7 == 1);
               continue;
            }
         }

         var1.byteAccess();
         return;
      }
   }
}
