import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1190020539
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -422763625
   )
   @Export("z")
   int z;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 844402227
   )
   @Export("x")
   int x;
   @ObfuscatedName("h")
   public static class182 field1574;
   @ObfuscatedName("kv")
   static class112 field1575;
   @ObfuscatedName("ot")
   @ObfuscatedGetter(
      intValue = 1676270433
   )
   static int field1578;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "45"
   )
   static final void method1952() {
      Region.field1488 = false;
      Client.field439 = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-247875861"
   )
   public static String method1953(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 65 && var7 <= 90) {
            var3 += (long)(var7 + 1 - 65);
         } else if(var7 >= 97 && var7 <= 122) {
            var3 += (long)(1 + var7 - 97);
         } else if(var7 >= 48 && var7 <= 57) {
            var3 += (long)(var7 + 27 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(var3 % 37L == 0L && 0L != var3) {
         var3 /= 37L;
      }

      String var8 = class167.method3196(var3);
      if(var8 == null) {
         var8 = "";
      }

      return var8;
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIIB)V",
      garbageValue = "-6"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method4016(var2, var3, var4, var5);
      class84.method1707();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var1 == var10.parentId || var1 == -1412584499 && var10 == Client.field486)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field311] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field311] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field311] = var10.width;
               Client.widgetBoundsHeight[Client.field311] = var10.height;
               var11 = ++Client.field311 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2318 = Client.gameCycle;
            if(!var10.hasScript || !class13.method195(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field367 == -1) {
                        Client.field367 = var10.textureId;
                        Client.field588 = var10.field2297 * -1;
                     }

                     if(Client.field576.isFemale) {
                        var10.textureId = Client.field367;
                     } else {
                        var10.textureId = Client.field588 * -1;
                     }
                  } else if(var12 == 325) {
                     if(Client.field367 == -1) {
                        Client.field367 = var10.textureId;
                        Client.field588 = var10.field2297 * -1;
                     }

                     if(Client.field576.isFemale) {
                        var10.textureId = Client.field588 * -1;
                     } else {
                        var10.textureId = Client.field367;
                     }
                  } else if(var12 == 327) {
                     var10.rotationX = 150;
                     var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 0;
                  } else if(var12 == 328) {
                     var10.rotationX = 150;
                     var10.rotationZ = (int)(Math.sin((double)Client.gameCycle / 40.0D) * 256.0D) & 2047;
                     var10.modelType = 5;
                     var10.modelId = 1;
                  }
               }

               var12 = var6 + var10.relativeX;
               int var13 = var10.relativeY + var7;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(Client.field486 == var10) {
                  if(var1 != -1412584499 && !var10.field2264) {
                     TextureProvider.field1213 = var0;
                     class32.field749 = var6;
                     class210.field3129 = var7;
                     continue;
                  }

                  if(Client.field398 && Client.field491) {
                     var15 = class115.field1807;
                     var16 = class115.field1801;
                     var15 -= Client.field526;
                     var16 -= Client.field470;
                     if(var15 < Client.field344) {
                        var15 = Client.field344;
                     }

                     if(var10.width + var15 > Client.field344 + Client.field487.width) {
                        var15 = Client.field487.width + Client.field344 - var10.width;
                     }

                     if(var16 < Client.field590) {
                        var16 = Client.field590;
                     }

                     if(var16 + var10.height > Client.field590 + Client.field487.height) {
                        var16 = Client.field590 + Client.field487.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2264) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var22;
               int var42;
               int var43;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var43 = var12;
                  var20 = var13;
                  var42 = var12 + var10.width;
                  var22 = var10.height + var13;
                  if(var42 < var12) {
                     var43 = var42;
                     var42 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var42;
                  ++var22;
                  var15 = var43 > var2?var43:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var42 < var4?var42:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var43 = var12 + var10.width;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var43 < var4?var43:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  int var23;
                  int var24;
                  int var25;
                  int var26;
                  int var27;
                  int var29;
                  int var30;
                  int var31;
                  int var32;
                  int var33;
                  int var34;
                  int var35;
                  int var46;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field392) {
                           var13 += 15;
                           class15.field185.method3883("Fps:" + GameEngine.FPS, var10.width + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var51 = Runtime.getRuntime();
                           var20 = (int)((var51.totalMemory() - var51.freeMemory()) / 1024L);
                           var42 = 16776960;
                           if(var20 > '耀' && Client.field439) {
                              var42 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field439) {
                              var42 = 16711680;
                           }

                           class15.field185.method3883("Mem:" + var20 + "k", var12 + var10.width, var13, var42, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field462 = var12;
                        Client.field467 = var13;
                        var42 = var10.width;
                        var22 = var10.height;
                        ++Client.field534;
                        class142.method2721(class15.field184);
                        boolean var55 = false;
                        if(Client.field407 >= 0) {
                           var24 = class45.field934;
                           int[] var72 = class45.field925;

                           for(var26 = 0; var26 < var24; ++var26) {
                              if(Client.field407 == var72[var26]) {
                                 var55 = true;
                                 break;
                              }
                           }
                        }

                        if(var55) {
                           class142.method2721(class15.field199);
                        }

                        class45.method914(true);
                        class142.method2721(var55?class15.field200:class15.field186);
                        class45.method914(false);
                        class41.method852();
                        class47.method966();
                        class40.method824(var12, var13, var42, var22, true);
                        var43 = Client.field575;
                        var20 = Client.field456;
                        var42 = Client.camera2;
                        var22 = Client.camera3;
                        Rasterizer2D.method4016(var43, var20, var43 + var42, var22 + var20);
                        class84.method1707();
                        if(!Client.field440) {
                           var24 = Client.field396;
                           if(Client.field503 / 256 > var24) {
                              var24 = Client.field503 / 256;
                           }

                           if(Client.field508[4] && Client.field564[4] + 128 > var24) {
                              var24 = 128 + Client.field564[4];
                           }

                           var25 = Client.field380 + Client.mapAngle & 2047;
                           var26 = SecondaryBufferProvider.field3215;
                           var27 = class1.method21(class22.localPlayer.x, class22.localPlayer.y, class31.plane) - Client.field402;
                           var46 = class40.field842;
                           var29 = 3 * var24 + 600;
                           var30 = 2048 - var24 & 2047;
                           var31 = 2048 - var25 & 2047;
                           var32 = 0;
                           var33 = 0;
                           var34 = var29;
                           int var36;
                           int var37;
                           if(var30 != 0) {
                              var35 = class84.field1441[var30];
                              var36 = class84.field1462[var30];
                              var37 = var36 * var33 - var29 * var35 >> 16;
                              var34 = var33 * var35 + var29 * var36 >> 16;
                              var33 = var37;
                           }

                           if(var31 != 0) {
                              var35 = class84.field1441[var31];
                              var36 = class84.field1462[var31];
                              var37 = var34 * var35 + var32 * var36 >> 16;
                              var34 = var34 * var36 - var35 * var32 >> 16;
                              var32 = var37;
                           }

                           class65.cameraX = var26 - var32;
                           class8.cameraZ = var27 - var33;
                           CombatInfoListHolder.cameraY = var46 - var34;
                           class25.cameraPitch = var24;
                           class108.cameraYaw = var25;
                        }

                        if(!Client.field440) {
                           var24 = class5.method78();
                        } else {
                           if(class8.field84.field717) {
                              var25 = class31.plane;
                           } else {
                              var26 = class1.method21(class65.cameraX, CombatInfoListHolder.cameraY, class31.plane);
                              if(var26 - class8.cameraZ < 800 && (class10.tileSettings[class31.plane][class65.cameraX >> 7][CombatInfoListHolder.cameraY >> 7] & 4) != 0) {
                                 var25 = class31.plane;
                              } else {
                                 var25 = 3;
                              }
                           }

                           var24 = var25;
                        }

                        var25 = class65.cameraX;
                        var26 = class8.cameraZ;
                        var27 = CombatInfoListHolder.cameraY;
                        var46 = class25.cameraPitch;
                        var29 = class108.cameraYaw;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(Client.field508[var30]) {
                              var31 = (int)(Math.random() * (double)(1 + 2 * Client.field563[var30]) - (double)Client.field563[var30] + Math.sin((double)Client.field566[var30] * ((double)Client.field354[var30] / 100.0D)) * (double)Client.field564[var30]);
                              if(var30 == 0) {
                                 class65.cameraX += var31;
                              }

                              if(var30 == 1) {
                                 class8.cameraZ += var31;
                              }

                              if(var30 == 2) {
                                 CombatInfoListHolder.cameraY += var31;
                              }

                              if(var30 == 3) {
                                 class108.cameraYaw = var31 + class108.cameraYaw & 2047;
                              }

                              if(var30 == 4) {
                                 class25.cameraPitch += var31;
                                 if(class25.cameraPitch < 128) {
                                    class25.cameraPitch = 128;
                                 }

                                 if(class25.cameraPitch > 383) {
                                    class25.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var30 = class115.field1807;
                        var31 = class115.field1801;
                        if(class115.field1813 != 0) {
                           var30 = class115.field1814;
                           var31 = class115.field1815;
                        }

                        if(var30 >= var43 && var30 < var42 + var43 && var31 >= var20 && var31 < var22 + var20) {
                           Model.field1419 = true;
                           Model.field1422 = 0;
                           Model.field1420 = var30 - var43;
                           Model.field1421 = var31 - var20;
                        } else {
                           Model.field1419 = false;
                           Model.field1422 = 0;
                        }

                        class47.method950();
                        Rasterizer2D.method4028(var43, var20, var42, var22, 0);
                        class47.method950();
                        var32 = class84.field1447;
                        class84.field1447 = Client.scale;
                        Friend.region.method1794(class65.cameraX, class8.cameraZ, CombatInfoListHolder.cameraY, class25.cameraPitch, class108.cameraYaw, var24);
                        class84.field1447 = var32;
                        class47.method950();
                        Friend.region.method1768();
                        class109.method2114(var43, var20, var42, var22);
                        if(Client.field458 == 2) {
                           class20.method223((Client.field331 - CombatInfoListHolder.baseX << 7) + Client.field334, Client.field335 + (Client.field332 - class3.baseY << 7), Client.field333 * 2);
                           if(Client.field355 > -1 && Client.gameCycle % 20 < 10) {
                              class15.field189[0].method4149(Client.field355 + var43 - 12, Client.field339 + var20 - 28);
                           }
                        }

                        ((TextureProvider)class84.field1458).method1500(Client.field328);
                        if(Client.field423 == 1) {
                           Client.field449[Client.field548 / 100].method4149(Client.field422 - 8, Client.field421 - 8);
                        }

                        if(Client.field423 == 2) {
                           Client.field449[4 + Client.field548 / 100].method4149(Client.field422 - 8, Client.field421 - 8);
                        }

                        class49.method979();
                        class65.cameraX = var25;
                        class8.cameraZ = var26;
                        CombatInfoListHolder.cameraY = var27;
                        class25.cameraPitch = var46;
                        class108.cameraYaw = var29;
                        if(Client.field318 && class178.method3283(true, false) == 0) {
                           Client.field318 = false;
                        }

                        if(Client.field318) {
                           Rasterizer2D.method4028(var43, var20, var42, var22, 0);
                           class22.method238("Loading - please wait.", false);
                        }

                        Client.field518[var10.boundsIndex] = true;
                        Rasterizer2D.method4016(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class47.method950();
                        class164 var49 = var10.method3213(false);
                        if(var49 != null) {
                           Rasterizer2D.method4016(var12, var13, var49.field2146 + var12, var13 + var49.field2150);
                           if(Client.field549 != 2 && Client.field549 != 5) {
                              var20 = Client.mapScale + Client.mapAngle & 2047;
                              var42 = class22.localPlayer.x / 32 + 48;
                              var22 = 464 - class22.localPlayer.y / 32;
                              Actor.field685.method4160(var12, var13, var49.field2146, var49.field2150, var42, var22, var20, Client.mapScaleDelta + 256, var49.field2141, var49.field2142);

                              for(var23 = 0; var23 < Client.field585; ++var23) {
                                 var24 = 2 + Client.field544[var23] * 4 - class22.localPlayer.x / 32;
                                 var25 = 2 + Client.field494[var23] * 4 - class22.localPlayer.y / 32;
                                 class105.method2087(var12, var13, var24, var25, Client.field546[var23], var49);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field351; ++var23) {
                                       NPC var63 = Client.cachedNPCs[Client.field570[var23]];
                                       if(null != var63 && var63.vmethod782()) {
                                          NPCComposition var67 = var63.composition;
                                          if(null != var67 && var67.configs != null) {
                                             var67 = var67.method3719();
                                          }

                                          if(var67 != null && var67.isMinimapVisible && var67.field3035) {
                                             var26 = var63.x / 32 - class22.localPlayer.x / 32;
                                             var27 = var63.y / 32 - class22.localPlayer.y / 32;
                                             class105.method2087(var12, var13, var26, var27, ItemLayer.field1223[1], var49);
                                          }
                                       }
                                    }

                                    var23 = class45.field934;
                                    int[] var64 = class45.field925;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       Player var61 = Client.cachedPlayers[var64[var25]];
                                       if(var61 != null && var61.vmethod782() && !var61.field290 && class22.localPlayer != var61) {
                                          var27 = var61.x / 32 - class22.localPlayer.x / 32;
                                          var46 = var61.y / 32 - class22.localPlayer.y / 32;
                                          boolean var59 = false;
                                          if(MessageNode.method228(var61.name, true)) {
                                             var59 = true;
                                          }

                                          boolean var57 = false;

                                          for(var31 = 0; var31 < class9.clanChatCount; ++var31) {
                                             if(var61.name.equals(class137.clanMembers[var31].username)) {
                                                var57 = true;
                                                break;
                                             }
                                          }

                                          boolean var58 = false;
                                          if(class22.localPlayer.team != 0 && var61.team != 0 && class22.localPlayer.team == var61.team) {
                                             var58 = true;
                                          }

                                          if(var59) {
                                             class105.method2087(var12, var13, var27, var46, ItemLayer.field1223[3], var49);
                                          } else if(var58) {
                                             class105.method2087(var12, var13, var27, var46, ItemLayer.field1223[4], var49);
                                          } else if(var57) {
                                             class105.method2087(var12, var13, var27, var46, ItemLayer.field1223[5], var49);
                                          } else {
                                             class105.method2087(var12, var13, var27, var46, ItemLayer.field1223[2], var49);
                                          }
                                       }
                                    }

                                    if(Client.field458 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field458 == 1 && Client.field329 >= 0 && Client.field329 < Client.cachedNPCs.length) {
                                          NPC var70 = Client.cachedNPCs[Client.field329];
                                          if(var70 != null) {
                                             var26 = var70.x / 32 - class22.localPlayer.x / 32;
                                             var27 = var70.y / 32 - class22.localPlayer.y / 32;
                                             class2.method32(var12, var13, var26, var27, class10.field129[1], var49);
                                          }
                                       }

                                       if(Client.field458 == 2) {
                                          var25 = Client.field331 * 4 - CombatInfoListHolder.baseX * 4 + 2 - class22.localPlayer.x / 32;
                                          var26 = Client.field332 * 4 - class3.baseY * 4 + 2 - class22.localPlayer.y / 32;
                                          class2.method32(var12, var13, var25, var26, class10.field129[1], var49);
                                       }

                                       if(Client.field458 == 10 && Client.field362 >= 0 && Client.field362 < Client.cachedPlayers.length) {
                                          Player var71 = Client.cachedPlayers[Client.field362];
                                          if(null != var71) {
                                             var26 = var71.x / 32 - class22.localPlayer.x / 32;
                                             var27 = var71.y / 32 - class22.localPlayer.y / 32;
                                             class2.method32(var12, var13, var26, var27, class10.field129[1], var49);
                                          }
                                       }
                                    }

                                    if(Client.flagX != 0) {
                                       var25 = 2 + Client.flagX * 4 - class22.localPlayer.x / 32;
                                       var26 = Client.flagY * 4 + 2 - class22.localPlayer.y / 32;
                                       class105.method2087(var12, var13, var25, var26, class10.field129[0], var49);
                                    }

                                    if(!class22.localPlayer.field290) {
                                       Rasterizer2D.method4028(var12 + var49.field2146 / 2 - 1, var49.field2150 / 2 + var13 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var66 = Client.groundItemDeque[class31.plane][var23][var24];
                                    if(null != var66) {
                                       var26 = 4 * var23 + 2 - class22.localPlayer.x / 32;
                                       var27 = 2 + 4 * var24 - class22.localPlayer.y / 32;
                                       class105.method2087(var12, var13, var26, var27, ItemLayer.field1223[0], var49);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              Rasterizer2D.method4063(var12, var13, 0, var49.field2141, var49.field2142);
                           }

                           Client.field488[var11] = true;
                        }

                        Rasterizer2D.method4016(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        RSSocket.method2133(var10, var12, var13, var11);
                        Rasterizer2D.method4016(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && class13.method195(var10) && class1.field16 != var10) {
                        continue;
                     }

                     if(!var10.hasScript) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     if(var10.children != null) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var19 = (WidgetNode)Client.componentTable.method2405((long)var10.id);
                     if(null != var19) {
                        class206.method3834(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.method4016(var2, var3, var4, var5);
                     class84.method1707();
                  }

                  if(Client.isResized || Client.field520[var11] || Client.field525 > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        CollisionData.method2308(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var43 = 0;

                           for(var20 = 0; var20 < var10.field2198; ++var20) {
                              for(var42 = 0; var42 < var10.originalWidth; ++var42) {
                                 var22 = (var10.field2189 + 32) * var42 + var12;
                                 var23 = (32 + var10.field2239) * var20 + var13;
                                 if(var43 < 20) {
                                    var22 += var10.field2302[var43];
                                    var23 += var10.field2255[var43];
                                 }

                                 if(var10.itemIds[var43] <= 0) {
                                    if(null != var10.field2177 && var43 < 20) {
                                       SpritePixels var62 = var10.method3206(var43);
                                       if(var62 != null) {
                                          var62.method4149(var22, var23);
                                       } else if(Widget.field2184) {
                                          class2.method36(var10);
                                       }
                                    }
                                 } else {
                                    boolean var53 = false;
                                    boolean var54 = false;
                                    var26 = var10.itemIds[var43] - 1;
                                    if(32 + var22 > var2 && var22 < var4 && 32 + var23 > var3 && var23 < var5 || CombatInfoListHolder.field784 == var10 && Client.field310 == var43) {
                                       SpritePixels var41;
                                       if(Client.field466 == 1 && var43 == class107.field1744 && var10.id == class49.field967) {
                                          var41 = GameEngine.createSprite(var26, var10.itemQuantities[var43], 2, 0, 2, false);
                                       } else {
                                          var41 = GameEngine.createSprite(var26, var10.itemQuantities[var43], 1, 3153952, 2, false);
                                       }

                                       if(var41 != null) {
                                          if(var10 == CombatInfoListHolder.field784 && var43 == Client.field310) {
                                             var24 = class115.field1807 - Client.field427;
                                             var25 = class115.field1801 - Client.field428;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field431 < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var41.method4165(var24 + var22, var25 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var56 = var0[var1 & '\uffff'];
                                                if(var23 + var25 < Rasterizer2D.field3191 && var56.scrollY > 0) {
                                                   var29 = Client.field328 * (Rasterizer2D.field3191 - var23 - var25) / 3;
                                                   if(var29 > Client.field328 * 10) {
                                                      var29 = Client.field328 * 10;
                                                   }

                                                   if(var29 > var56.scrollY) {
                                                      var29 = var56.scrollY;
                                                   }

                                                   var56.scrollY -= var29;
                                                   Client.field428 += var29;
                                                   class2.method36(var56);
                                                }

                                                if(var23 + var25 + 32 > Rasterizer2D.field3187 && var56.scrollY < var56.scrollHeight - var56.height) {
                                                   var29 = (32 + var23 + var25 - Rasterizer2D.field3187) * Client.field328 / 3;
                                                   if(var29 > Client.field328 * 10) {
                                                      var29 = Client.field328 * 10;
                                                   }

                                                   if(var29 > var56.scrollHeight - var56.height - var56.scrollY) {
                                                      var29 = var56.scrollHeight - var56.height - var56.scrollY;
                                                   }

                                                   var56.scrollY += var29;
                                                   Client.field428 -= var29;
                                                   class2.method36(var56);
                                                }
                                             }
                                          } else if(Tile.field1363 == var10 && Client.field406 == var43) {
                                             var41.method4165(var22, var23, 128);
                                          } else {
                                             var41.method4149(var22, var23);
                                          }
                                       } else {
                                          class2.method36(var10);
                                       }
                                    }
                                 }

                                 ++var43;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class18.method214(var10)) {
                              var43 = var10.field2212;
                              if(class1.field16 == var10 && var10.field2214 != 0) {
                                 var43 = var10.field2214;
                              }
                           } else {
                              var43 = var10.textColor;
                              if(var10 == class1.field16 && var10.field2223 != 0) {
                                 var43 = var10.field2223;
                              }
                           }

                           if(var10.field2215) {
                              switch(var10.field2194.field3205) {
                              case 1:
                                 Rasterizer2D.method4005(var12, var13, var10.width, var10.height, var10.textColor, var10.field2212, 256 - (var10.opacity & 255), 256 - (var10.field2218 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4006(var12, var13, var10.width, var10.height, var10.textColor, var10.field2212, 256 - (var10.opacity & 255), 256 - (var10.field2218 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4007(var12, var13, var10.width, var10.height, var10.textColor, var10.field2212, 256 - (var10.opacity & 255), 256 - (var10.field2218 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4008(var12, var13, var10.width, var10.height, var10.textColor, var10.field2212, 256 - (var10.opacity & 255), 256 - (var10.field2218 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4028(var12, var13, var10.width, var10.height, var43);
                                 } else {
                                    Rasterizer2D.method4003(var12, var13, var10.width, var10.height, var43, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method4010(var12, var13, var10.width, var10.height, var43);
                           } else {
                              Rasterizer2D.method4011(var12, var13, var10.width, var10.height, var43, 256 - (var14 & 255));
                           }
                        } else {
                           String var38;
                           String var39;
                           Font var47;
                           String var60;
                           if(var10.type == 4) {
                              var47 = var10.method3211();
                              if(null == var47) {
                                 if(Widget.field2184) {
                                    class2.method36(var10);
                                 }
                              } else {
                                 String var52 = var10.text;
                                 if(class18.method214(var10)) {
                                    var20 = var10.field2212;
                                    if(class1.field16 == var10 && var10.field2214 != 0) {
                                       var20 = var10.field2214;
                                    }

                                    if(var10.field2211.length() > 0) {
                                       var52 = var10.field2211;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class1.field16 && var10.field2223 != 0) {
                                       var20 = var10.field2223;
                                    }
                                 }

                                 StringBuilder var10000;
                                 if(var10.hasScript && var10.item != -1) {
                                    ItemComposition var69 = class154.getItemDefinition(var10.item);
                                    var52 = var69.name;
                                    if(var52 == null) {
                                       var52 = "null";
                                    }

                                    if((var69.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var60 = class116.method2288(16748608) + var52 + "</col>" + " " + 'x';
                                       var25 = var10.stackSize;
                                       var39 = Integer.toString(var25);

                                       for(var27 = var39.length() - 3; var27 > 0; var27 -= 3) {
                                          var39 = var39.substring(0, var27) + "," + var39.substring(var27);
                                       }

                                       Object var10001;
                                       if(var39.length() > 9) {
                                          var10000 = (new StringBuilder()).append(" ").append(class116.method2288('ﾀ')).append(var39.substring(0, var39.length() - 8));
                                          var10001 = null;
                                          var38 = var10000.append("M").append(" ").append(" (").append(var39).append(")").append("</col>").toString();
                                       } else if(var39.length() > 6) {
                                          var10000 = (new StringBuilder()).append(" ").append(class116.method2288(16777215)).append(var39.substring(0, var39.length() - 4));
                                          var10001 = null;
                                          var38 = var10000.append("K").append(" ").append(" (").append(var39).append(")").append("</col>").toString();
                                       } else {
                                          var38 = " " + class116.method2288(16776960) + var39 + "</col>";
                                       }

                                       var52 = var60 + var38;
                                    }
                                 }

                                 if(var10 == Client.field477) {
                                    var10000 = null;
                                    var52 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var52 = class148.method2795(var52, var10);
                                 }

                                 var47.method3916(var52, var12, var13, var10.width, var10.height, var20, var10.field2251?0:-1, var10.field2249, var10.field2250, var10.field2248);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var48;
                              if(!var10.hasScript) {
                                 var48 = var10.method3204(class18.method214(var10));
                                 if(null != var48) {
                                    var48.method4149(var12, var13);
                                 } else if(Widget.field2184) {
                                    class2.method36(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var48 = GameEngine.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2244, false);
                                 } else {
                                    var48 = var10.method3204(false);
                                 }

                                 if(null == var48) {
                                    if(Widget.field2184) {
                                       class2.method36(var10);
                                    }
                                 } else {
                                    var20 = var48.maxWidth;
                                    var42 = var48.maxHeight;
                                    if(!var10.field2224) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2300 != 0) {
                                          var48.method4162(var10.width / 2 + var12, var13 + var10.height / 2, var10.field2300, var22);
                                       } else if(var14 != 0) {
                                          var48.method4157(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var20 == var10.width && var10.height == var42) {
                                          var48.method4149(var12, var13);
                                       } else {
                                          var48.method4151(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method3999(var12, var13, var12 + var10.width, var10.height + var13);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var42 - 1 + var10.height) / var42;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2300 != 0) {
                                                var48.method4162(var20 / 2 + var12 + var20 * var24, var42 / 2 + var25 * var42 + var13, var10.field2300, 4096);
                                             } else if(var14 != 0) {
                                                var48.method4165(var20 * var24 + var12, var13 + var42 * var25, 256 - (var14 & 255));
                                             } else {
                                                var48.method4149(var20 * var24 + var12, var42 * var25 + var13);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method4016(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var40;
                              if(var10.type == 6) {
                                 boolean var68 = class18.method214(var10);
                                 if(var68) {
                                    var20 = var10.field2234;
                                 } else {
                                    var20 = var10.field2233;
                                 }

                                 Model var50 = null;
                                 var22 = 0;
                                 if(var10.item != -1) {
                                    var40 = class154.getItemDefinition(var10.item);
                                    if(null != var40) {
                                       var40 = var40.method3664(var10.stackSize);
                                       var50 = var40.getModel(1);
                                       if(var50 != null) {
                                          var50.method1617();
                                          var22 = var50.modelHeight / 2;
                                       } else {
                                          class2.method36(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var50 = Client.field576.method3166((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var50 = class22.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var50 = var10.method3212((Sequence)null, -1, var68, class22.localPlayer.composition);
                                    if(var50 == null && Widget.field2184) {
                                       class2.method36(var10);
                                    }
                                 } else {
                                    Sequence var65 = class168.getAnimation(var20);
                                    var50 = var10.method3212(var65, var10.field2308, var68, class22.localPlayer.composition);
                                    if(var50 == null && Widget.field2184) {
                                       class2.method36(var10);
                                    }
                                 }

                                 class84.method1697(var12 + var10.width / 2, var13 + var10.height / 2);
                                 var23 = var10.field2240 * class84.field1441[var10.rotationX] >> 16;
                                 var24 = var10.field2240 * class84.field1462[var10.rotationX] >> 16;
                                 if(var50 != null) {
                                    if(!var10.hasScript) {
                                       var50.method1629(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var50.method1617();
                                       if(var10.field2243) {
                                          var50.method1689(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2235, var22 + var23 + var10.field2236, var10.field2236 + var24, var10.field2240);
                                       } else {
                                          var50.method1629(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2235, var10.field2236 + var23 + var22, var24 + var10.field2236);
                                       }
                                    }
                                 }

                                 class84.method1696();
                              } else {
                                 if(var10.type == 7) {
                                    var47 = var10.method3211();
                                    if(var47 == null) {
                                       if(Widget.field2184) {
                                          class2.method36(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var42 = 0; var42 < var10.field2198; ++var42) {
                                       for(var22 = 0; var22 < var10.originalWidth; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var40 = class154.getItemDefinition(var10.itemIds[var20] - 1);
                                             if(var40.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var38 = class116.method2288(16748608) + var40.name + "</col>";
                                             } else {
                                                String var45 = class116.method2288(16748608) + var40.name + "</col>" + " " + 'x';
                                                var27 = var10.itemQuantities[var20];
                                                String var28 = Integer.toString(var27);

                                                for(var29 = var28.length() - 3; var29 > 0; var29 -= 3) {
                                                   var28 = var28.substring(0, var29) + "," + var28.substring(var29);
                                                }

                                                if(var28.length() > 9) {
                                                   var39 = " " + class116.method2288('ﾀ') + var28.substring(0, var28.length() - 8) + "M" + " " + " (" + var28 + ")" + "</col>";
                                                } else if(var28.length() > 6) {
                                                   var39 = " " + class116.method2288(16777215) + var28.substring(0, var28.length() - 4) + "K" + " " + " (" + var28 + ")" + "</col>";
                                                } else {
                                                   var39 = " " + class116.method2288(16776960) + var28 + "</col>";
                                                }

                                                var38 = var45 + var39;
                                             }

                                             var25 = (var10.field2189 + 115) * var22 + var12;
                                             var26 = var13 + (12 + var10.field2239) * var42;
                                             if(var10.field2249 == 0) {
                                                var47.method3881(var38, var25, var26, var10.textColor, var10.field2251?0:-1);
                                             } else if(var10.field2249 == 1) {
                                                var47.method3964(var38, var25 + var10.width / 2, var26, var10.textColor, var10.field2251?0:-1);
                                             } else {
                                                var47.method3883(var38, var25 + var10.width - 1, var26, var10.textColor, var10.field2251?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && FloorUnderlayDefinition.field2809 == var10 && Client.field465 == Client.field348) {
                                    var43 = 0;
                                    var20 = 0;
                                    Font var21 = class15.field185;
                                    String var44 = var10.text;

                                    for(var44 = class148.method2795(var44, var10); var44.length() > 0; var20 += var21.field3120 + 1) {
                                       var24 = var44.indexOf("<br>");
                                       if(var24 != -1) {
                                          var60 = var44.substring(0, var24);
                                          var44 = var44.substring(var24 + 4);
                                       } else {
                                          var60 = var44;
                                          var44 = "";
                                       }

                                       var25 = var21.method3876(var60);
                                       if(var25 > var43) {
                                          var43 = var25;
                                       }
                                    }

                                    var43 += 6;
                                    var20 += 7;
                                    var24 = var10.width + var12 - 5 - var43;
                                    var25 = var10.height + var13 + 5;
                                    if(var24 < 5 + var12) {
                                       var24 = var12 + 5;
                                    }

                                    if(var43 + var24 > var4) {
                                       var24 = var4 - var43;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.method4028(var24, var25, var43, var20, 16777120);
                                    Rasterizer2D.method4010(var24, var25, var43, var20, 0);
                                    var44 = var10.text;
                                    var26 = var25 + var21.field3120 + 2;

                                    for(var44 = class148.method2795(var44, var10); var44.length() > 0; var26 += var21.field3120 + 1) {
                                       var27 = var44.indexOf("<br>");
                                       if(var27 != -1) {
                                          var60 = var44.substring(0, var27);
                                          var44 = var44.substring(4 + var27);
                                       } else {
                                          var60 = var44;
                                          var44 = "";
                                       }

                                       var21.method3881(var60, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2202 == 1) {
                                       if(var10.field2220) {
                                          var43 = var12;
                                          var20 = var13 + var10.height;
                                          var42 = var12 + var10.width;
                                          var22 = var13;
                                       } else {
                                          var43 = var12;
                                          var20 = var13;
                                          var42 = var12 + var10.width;
                                          var22 = var13 + var10.height;
                                       }

                                       Rasterizer2D.method4025(var43, var20, var42, var22, var10.textColor);
                                    } else {
                                       var43 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var42 = var43;
                                       if(var43 < var20) {
                                          var42 = var20;
                                       }

                                       if(var42 != 0) {
                                          var22 = (var10.width << 16) / var42;
                                          var23 = (var10.height << 16) / var42;
                                          if(var23 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var23 * var10.field2202 >> 17;
                                          var25 = 1 + var23 * var10.field2202 >> 17;
                                          var26 = var22 * var10.field2202 >> 17;
                                          var27 = var10.field2202 * var22 + 1 >> 17;
                                          var46 = var12 + var24;
                                          var29 = var12 - var25;
                                          var30 = var10.width + var12 - var25;
                                          var31 = var24 + var12 + var10.width;
                                          var32 = var26 + var13;
                                          var33 = var13 - var27;
                                          var34 = var13 + var10.height - var27;
                                          var35 = var26 + var10.height + var13;
                                          class84.setRasterClippingEnabled(var46, var29, var30);
                                          class84.rasterFlat(var32, var33, var34, var46, var29, var30, var10.textColor);
                                          class84.setRasterClippingEnabled(var46, var30, var31);
                                          class84.rasterFlat(var32, var34, var35, var46, var30, var31, var10.textColor);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }
}
