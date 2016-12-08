import java.io.File;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
final class class3 implements Comparator {
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = 436401915
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("bm")
   static ModIcon[] field26;

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "88"
   )
   static void method30() {
      if(Client.field439) {
         Widget var0 = class138.method2419(class155.field2128, Client.field385);
         if(var0 != null && null != var0.field2251) {
            class18 var1 = new class18();
            var1.field193 = var0;
            var1.field203 = var0.field2251;
            class13.method165(var1);
         }

         Client.field439 = false;
         class97.method1886(var0);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "942780077"
   )
   int method31(class2 var1, class2 var2) {
      return var1.field19.totalQuantity < var2.field19.totalQuantity?-1:(var2.field19.totalQuantity == var1.field19.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1795740969"
   )
   static final void method33() {
      class200.field3044.reset();
      class191.field2817.reset();
      KitDefinition.field2820.reset();
      ObjectComposition.field2892.reset();
      ObjectComposition.field2912.reset();
      ObjectComposition.field2894.reset();
      ObjectComposition.field2916.reset();
      class63.method1143();
      class170.method3174();
      class170.method3172();
      class31.method649();
      class178.method3192();
      class187.field2780.reset();
      class26.method570();
      XItemContainer.method163();
      PlayerComposition.field2187.reset();
      Widget.field2201.reset();
      Widget.field2260.reset();
      Widget.field2219.reset();
      Widget.field2230.reset();
      ((TextureProvider)class84.field1442).method1411();
      class48.field946.reset();
      class45.field915.method3252();
      class18.field192.method3252();
      class9.field75.method3252();
      class103.field1665.method3252();
      ChatLineBuffer.field970.method3252();
      class119.field1864.method3252();
      class217.field3168.method3252();
      class206.field3086.method3252();
      class13.field142.method3252();
      class25.field587.method3252();
      Friend.field160.method3252();
      CombatInfo2.field2844.method3252();
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "-2036230896"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class219.method3893(var2, var3, var4, var5);
      class84.method1604();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(null != var10 && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.field455)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field487] = var6 + var10.relativeX;
               Client.widgetPositionY[Client.field487] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field487] = var10.width;
               Client.widgetBoundsHeight[Client.field487] = var10.height;
               var11 = ++Client.field487 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2339 = Client.gameCycle;
            if(!var10.field2204 || !class8.method90(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field558 == -1) {
                        Client.field558 = var10.textureId;
                        Client.field559 = var10.field2243;
                     }

                     if(Client.field495.isFemale) {
                        var10.textureId = Client.field558;
                     } else {
                        var10.textureId = Client.field559;
                     }
                  } else if(var12 == 325) {
                     if(Client.field558 == -1) {
                        Client.field558 = var10.textureId;
                        Client.field559 = var10.field2243;
                     }

                     if(Client.field495.isFemale) {
                        var10.textureId = Client.field559;
                     } else {
                        var10.textureId = Client.field558;
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

               var12 = var10.relativeX + var6;
               int var13 = var7 + var10.relativeY;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field455) {
                  if(var1 != -1412584499 && !var10.field2285) {
                     class38.field806 = var0;
                     class164.field2163 = var6;
                     class10.field101 = var7;
                     continue;
                  }

                  if(Client.field468 && Client.field388) {
                     var15 = class115.field1814;
                     var16 = class115.field1821;
                     var15 -= Client.field459;
                     var16 -= Client.field460;
                     if(var15 < Client.field463) {
                        var15 = Client.field463;
                     }

                     if(var15 + var10.width > Client.field463 + Client.field435.width) {
                        var15 = Client.field435.width + Client.field463 - var10.width;
                     }

                     if(var16 < Client.field464) {
                        var16 = Client.field464;
                     }

                     if(var16 + var10.height > Client.field435.height + Client.field464) {
                        var16 = Client.field464 + Client.field435.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2285) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var22;
               int var38;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var38 = var10.width + var12;
                  var22 = var13 + var10.height;
                  if(var38 < var12) {
                     var19 = var38;
                     var38 = var12;
                  }

                  if(var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var38;
                  ++var22;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var38 < var4?var38:var4;
                  var18 = var22 < var5?var22:var5;
               } else {
                  var19 = var10.width + var12;
                  var20 = var10.height + var13;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2204 || var15 < var17 && var16 < var18) {
                  int var29;
                  int var30;
                  int var31;
                  int var32;
                  int var34;
                  int var36;
                  int var37;
                  int var40;
                  int var41;
                  int var42;
                  int var44;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field475) {
                           var13 += 15;
                           class33.field757.method3786("Fps:" + GameEngine.field1782, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var67 = Runtime.getRuntime();
                           var20 = (int)((var67.totalMemory() - var67.freeMemory()) / 1024L);
                           var38 = 16776960;
                           if(var20 > '耀' && Client.field314) {
                              var38 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field314) {
                              var38 = 16711680;
                           }

                           class33.field757.method3786("Mem:" + var20 + "k", var12 + var10.width, var13, var38, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     NPC var54;
                     Player var56;
                     if(var10.contentType == 1337) {
                        Client.field504 = var12;
                        Client.field501 = var13;
                        var38 = var10.width;
                        var22 = var10.height;
                        ++Client.field391;
                        DecorativeObject.method1874(class15.field168);
                        boolean var65 = false;
                        if(Client.field416 >= 0) {
                           var37 = class45.field900;
                           int[] var57 = class45.field902;

                           for(var41 = 0; var41 < var37; ++var41) {
                              if(Client.field416 == var57[var41]) {
                                 var65 = true;
                                 break;
                              }
                           }
                        }

                        if(var65) {
                           DecorativeObject.method1874(class15.field167);
                        }

                        class140.method2569(true);
                        DecorativeObject.method1874(var65?class15.field166:class15.field165);
                        class140.method2569(false);

                        for(Projectile var55 = (Projectile)Client.projectiles.method2349(); var55 != null; var55 = (Projectile)Client.projectiles.method2351()) {
                           if(class63.plane == var55.floor && Client.gameCycle <= var55.field869) {
                              if(Client.gameCycle >= var55.startTime) {
                                 if(var55.interacting > 0) {
                                    var54 = Client.cachedNPCs[var55.interacting - 1];
                                    if(var54 != null && var54.x >= 0 && var54.x < 13312 && var54.y >= 0 && var54.y < 13312) {
                                       var55.method766(var54.x, var54.y, ChatLineBuffer.method896(var54.x, var54.y, var55.floor) - var55.field867, Client.gameCycle);
                                    }
                                 }

                                 if(var55.interacting < 0) {
                                    var41 = -var55.interacting - 1;
                                    if(Client.localInteractingIndex == var41) {
                                       var56 = class5.localPlayer;
                                    } else {
                                       var56 = Client.cachedPlayers[var41];
                                    }

                                    if(null != var56 && var56.x >= 0 && var56.x < 13312 && var56.y >= 0 && var56.y < 13312) {
                                       var55.method766(var56.x, var56.y, ChatLineBuffer.method896(var56.x, var56.y, var55.floor) - var55.field867, Client.gameCycle);
                                    }
                                 }

                                 var55.method767(Client.field363);
                                 class159.region.method1677(class63.plane, (int)var55.x, (int)var55.velocityZ, (int)var55.z, 60, var55, var55.field882, -1, false);
                              }
                           } else {
                              var55.unlink();
                           }
                        }

                        class60.method1121();
                        class202.method3707(var12, var13, var38, var22, true);
                        var19 = Client.field546;
                        var20 = Client.field547;
                        var38 = Client.camera2;
                        var22 = Client.camera3;
                        class219.method3893(var19, var20, var38 + var19, var22 + var20);
                        class84.method1604();
                        if(!Client.field554) {
                           var37 = Client.field370;
                           if(Client.field379 / 256 > var37) {
                              var37 = Client.field379 / 256;
                           }

                           if(Client.field533[4] && Client.field535[4] + 128 > var37) {
                              var37 = Client.field535[4] + 128;
                           }

                           var40 = Client.mapAngle + Client.field365 & 2047;
                           class110.method2025(PlayerComposition.field2190, ChatLineBuffer.method896(class5.localPlayer.x, class5.localPlayer.y, class63.plane) - Client.field321, class114.field1803, var37, var40, 600 + var37 * 3);
                        }

                        if(!Client.field554) {
                           var37 = class94.method1870();
                        } else {
                           var37 = class159.method2979();
                        }

                        var40 = class110.cameraX;
                        var41 = class189.cameraZ;
                        var42 = class16.cameraY;
                        var44 = WidgetNode.cameraPitch;
                        var29 = class60.cameraYaw;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(Client.field533[var30]) {
                              var31 = (int)(Math.random() * (double)(1 + Client.field534[var30] * 2) - (double)Client.field534[var30] + Math.sin((double)Client.field367[var30] / 100.0D * (double)Client.field537[var30]) * (double)Client.field535[var30]);
                              if(var30 == 0) {
                                 class110.cameraX += var31;
                              }

                              if(var30 == 1) {
                                 class189.cameraZ += var31;
                              }

                              if(var30 == 2) {
                                 class16.cameraY += var31;
                              }

                              if(var30 == 3) {
                                 class60.cameraYaw = var31 + class60.cameraYaw & 2047;
                              }

                              if(var30 == 4) {
                                 WidgetNode.cameraPitch += var31;
                                 if(WidgetNode.cameraPitch < 128) {
                                    WidgetNode.cameraPitch = 128;
                                 }

                                 if(WidgetNode.cameraPitch > 383) {
                                    WidgetNode.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var30 = class115.field1814;
                        var31 = class115.field1821;
                        if(class115.field1820 != 0) {
                           var30 = class115.field1823;
                           var31 = class115.field1825;
                        }

                        if(var30 >= var19 && var30 < var38 + var19 && var31 >= var20 && var31 < var22 + var20) {
                           Model.field1403 = true;
                           Model.field1406 = 0;
                           Model.field1359 = var30 - var19;
                           Model.field1395 = var31 - var20;
                        } else {
                           Model.field1403 = false;
                           Model.field1406 = 0;
                        }

                        class183.method3292();
                        class219.method3899(var19, var20, var38, var22, 0);
                        class183.method3292();
                        var32 = class84.field1441;
                        class84.field1441 = Client.scale;
                        class159.region.method1704(class110.cameraX, class189.cameraZ, class16.cameraY, WidgetNode.cameraPitch, class60.cameraYaw, var37);
                        class84.field1441 = var32;
                        class183.method3292();
                        class159.region.method1680();
                        class7.method85(var19, var20, var38, var22);
                        class217.method3875(var19, var20);
                        ((TextureProvider)class84.field1442).method1410(Client.field363);
                        Friend.method173(var19, var20, var38, var22);
                        class110.cameraX = var40;
                        class189.cameraZ = var41;
                        class16.cameraY = var42;
                        WidgetNode.cameraPitch = var44;
                        class60.cameraYaw = var29;
                        if(Client.field297) {
                           byte var61 = 0;
                           var34 = var61 + class185.field2761 + class185.field2765;
                           if(var34 == 0) {
                              Client.field297 = false;
                           }
                        }

                        if(Client.field297) {
                           class219.method3899(var19, var20, var38, var22, 0);
                           DecorativeObject.method1875("Loading - please wait.", false);
                        }

                        Client.field308[var10.boundsIndex] = true;
                        class219.method3893(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1338) {
                        class183.method3292();
                        class164 var66 = var10.method3114(false);
                        if(var66 != null) {
                           class219.method3893(var12, var13, var12 + var66.field2164, var66.field2165 + var13);
                           if(Client.field520 != 2 && Client.field520 != 5) {
                              var20 = Client.mapAngle + Client.mapScale & 2047;
                              var38 = 48 + class5.localPlayer.x / 32;
                              var22 = 464 - class5.localPlayer.y / 32;
                              class154.field2118.method4059(var12, var13, var66.field2164, var66.field2165, var38, var22, var20, Client.mapScaleDelta + 256, var66.field2162, var66.field2168);

                              for(var36 = 0; var36 < Client.field377; ++var36) {
                                 var37 = 2 + Client.field423[var36] * 4 - class5.localPlayer.x / 32;
                                 var40 = 2 + 4 * Client.field474[var36] - class5.localPlayer.y / 32;
                                 FaceNormal.method1845(var12, var13, var37, var40, Client.field517[var36], var66);
                              }

                              var36 = 0;

                              while(true) {
                                 if(var36 >= 104) {
                                    for(var36 = 0; var36 < Client.field492; ++var36) {
                                       NPC var51 = Client.cachedNPCs[Client.field327[var36]];
                                       if(null != var51 && var51.vmethod702()) {
                                          NPCComposition var49 = var51.composition;
                                          if(null != var49 && null != var49.field3023) {
                                             var49 = var49.method3643();
                                          }

                                          if(null != var49 && var49.isMinimapVisible && var49.field2993) {
                                             var41 = var51.x / 32 - class5.localPlayer.x / 32;
                                             var42 = var51.y / 32 - class5.localPlayer.y / 32;
                                             FaceNormal.method1845(var12, var13, var41, var42, class160.field2142[1], var66);
                                          }
                                       }
                                    }

                                    var36 = class45.field900;
                                    int[] var53 = class45.field902;

                                    for(var40 = 0; var40 < var36; ++var40) {
                                       Player var26 = Client.cachedPlayers[var53[var40]];
                                       if(var26 != null && var26.vmethod702() && !var26.field268 && class5.localPlayer != var26) {
                                          var42 = var26.x / 32 - class5.localPlayer.x / 32;
                                          var44 = var26.y / 32 - class5.localPlayer.y / 32;
                                          boolean var60 = false;
                                          if(class155.method2934(var26.name, true)) {
                                             var60 = true;
                                          }

                                          boolean var58 = false;

                                          for(var31 = 0; var31 < class177.field2678; ++var31) {
                                             if(var26.name.equals(class110.clanMembers[var31].username)) {
                                                var58 = true;
                                                break;
                                             }
                                          }

                                          boolean var59 = false;
                                          if(class5.localPlayer.team != 0 && var26.team != 0 && var26.team == class5.localPlayer.team) {
                                             var59 = true;
                                          }

                                          if(var60) {
                                             FaceNormal.method1845(var12, var13, var42, var44, class160.field2142[3], var66);
                                          } else if(var59) {
                                             FaceNormal.method1845(var12, var13, var42, var44, class160.field2142[4], var66);
                                          } else if(var58) {
                                             FaceNormal.method1845(var12, var13, var42, var44, class160.field2142[5], var66);
                                          } else {
                                             FaceNormal.method1845(var12, var13, var42, var44, class160.field2142[2], var66);
                                          }
                                       }
                                    }

                                    if(Client.field306 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field306 == 1 && Client.field307 >= 0 && Client.field307 < Client.cachedNPCs.length) {
                                          var54 = Client.cachedNPCs[Client.field307];
                                          if(null != var54) {
                                             var41 = var54.x / 32 - class5.localPlayer.x / 32;
                                             var42 = var54.y / 32 - class5.localPlayer.y / 32;
                                             ObjectComposition.method3547(var12, var13, var41, var42, Player.field274[1], var66);
                                          }
                                       }

                                       if(Client.field306 == 2) {
                                          var40 = Client.field333 * 4 - class107.baseX * 4 + 2 - class5.localPlayer.x / 32;
                                          var41 = 2 + (Client.field364 * 4 - XClanMember.baseY * 4) - class5.localPlayer.y / 32;
                                          ObjectComposition.method3547(var12, var13, var40, var41, Player.field274[1], var66);
                                       }

                                       if(Client.field306 == 10 && Client.field357 >= 0 && Client.field357 < Client.cachedPlayers.length) {
                                          var56 = Client.cachedPlayers[Client.field357];
                                          if(var56 != null) {
                                             var41 = var56.x / 32 - class5.localPlayer.x / 32;
                                             var42 = var56.y / 32 - class5.localPlayer.y / 32;
                                             ObjectComposition.method3547(var12, var13, var41, var42, Player.field274[1], var66);
                                          }
                                       }
                                    }

                                    if(Client.flagX != 0) {
                                       var40 = Client.flagX * 4 + 2 - class5.localPlayer.x / 32;
                                       var41 = 2 + Client.flagY * 4 - class5.localPlayer.y / 32;
                                       FaceNormal.method1845(var12, var13, var40, var41, Player.field274[0], var66);
                                    }

                                    if(!class5.localPlayer.field268) {
                                       class219.method3899(var66.field2164 / 2 + var12 - 1, var13 + var66.field2165 / 2 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var37 = 0; var37 < 104; ++var37) {
                                    Deque var25 = Client.groundItemDeque[class63.plane][var36][var37];
                                    if(null != var25) {
                                       var41 = 2 + 4 * var36 - class5.localPlayer.x / 32;
                                       var42 = 2 + 4 * var37 - class5.localPlayer.y / 32;
                                       FaceNormal.method1845(var12, var13, var41, var42, class160.field2142[0], var66);
                                    }
                                 }

                                 ++var36;
                              }
                           } else {
                              class219.method3921(var12, var13, 0, var66.field2162, var66.field2168);
                           }

                           Client.field490[var11] = true;
                        }

                        class219.method3893(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        class11.method148(var10, var12, var13, var11);
                        class219.method3893(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.field2204 && class8.method90(var10) && class22.field245 != var10) {
                        continue;
                     }

                     if(!var10.field2204) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     if(null != var10.children) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var39 = (WidgetNode)Client.componentTable.method2299((long)var10.id);
                     if(var39 != null) {
                        class26.method566(var39.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class219.method3893(var2, var3, var4, var5);
                     class84.method1604();
                  }

                  if(Client.isResized || Client.field491[var11] || Client.field496 > 1) {
                     if(var10.type == 0 && !var10.field2204 && var10.scrollHeight > var10.height) {
                        class175.method3181(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2215; ++var20) {
                              for(var38 = 0; var38 < var10.field2218; ++var38) {
                                 var22 = (32 + var10.field2273) * var38 + var12;
                                 var36 = var13 + (32 + var10.field2200) * var20;
                                 if(var19 < 20) {
                                    var22 += var10.field2275[var19];
                                    var36 += var10.field2315[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(null != var10.field2225 && var19 < 20) {
                                       SpritePixels var50 = var10.method3116(var19);
                                       if(var50 != null) {
                                          var50.method4048(var22, var36);
                                       } else if(Widget.field2269) {
                                          class97.method1886(var10);
                                       }
                                    }
                                 } else {
                                    boolean var64 = false;
                                    boolean var68 = false;
                                    var41 = var10.itemIds[var19] - 1;
                                    if(var22 + 32 > var2 && var22 < var4 && 32 + var36 > var3 && var36 < var5 || CombatInfo1.field669 == var10 && var19 == Client.field400) {
                                       SpritePixels var27;
                                       if(Client.field437 == 1 && var19 == class138.field1925 && class22.field244 == var10.id) {
                                          var27 = DecorativeObject.createSprite(var41, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var27 = DecorativeObject.createSprite(var41, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var27 != null) {
                                          if(var10 == CombatInfo1.field669 && var19 == Client.field400) {
                                             var37 = class115.field1814 - Client.field431;
                                             var40 = class115.field1821 - Client.field387;
                                             if(var37 < 5 && var37 > -5) {
                                                var37 = 0;
                                             }

                                             if(var40 < 5 && var40 > -5) {
                                                var40 = 0;
                                             }

                                             if(Client.field405 < 5) {
                                                var37 = 0;
                                                var40 = 0;
                                             }

                                             var27.method4054(var22 + var37, var40 + var36, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                if(var40 + var36 < class219.field3171 && var28.scrollY > 0) {
                                                   var29 = Client.field363 * (class219.field3171 - var36 - var40) / 3;
                                                   if(var29 > Client.field363 * 10) {
                                                      var29 = Client.field363 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field387 += var29;
                                                   class97.method1886(var28);
                                                }

                                                if(32 + var36 + var40 > class219.field3173 && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = Client.field363 * (var40 + var36 + 32 - class219.field3173) / 3;
                                                   if(var29 > Client.field363 * 10) {
                                                      var29 = Client.field363 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field387 -= var29;
                                                   class97.method1886(var28);
                                                }
                                             }
                                          } else if(Ignore.field209 == var10 && Client.field399 == var19) {
                                             var27.method4054(var22, var36, 128);
                                          } else {
                                             var27.method4048(var22, var36);
                                          }
                                       } else {
                                          class97.method1886(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(Player.method229(var10)) {
                              var19 = var10.field2233;
                              if(var10 == class22.field245 && var10.field2235 != 0) {
                                 var19 = var10.field2235;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(class22.field245 == var10 && var10.field2234 != 0) {
                                 var19 = var10.field2234;
                              }
                           }

                           if(var10.field2300) {
                              switch(var10.field2241.field3187) {
                              case 1:
                                 class219.method3900(var12, var13, var10.width, var10.height, var10.textColor, var10.field2233, 256 - (var10.opacity & 255), 256 - (var10.field2199 & 255));
                                 break;
                              case 2:
                                 class219.method3925(var12, var13, var10.width, var10.height, var10.textColor, var10.field2233, 256 - (var10.opacity & 255), 256 - (var10.field2199 & 255));
                                 break;
                              case 3:
                                 class219.method3902(var12, var13, var10.width, var10.height, var10.textColor, var10.field2233, 256 - (var10.opacity & 255), 256 - (var10.field2199 & 255));
                                 break;
                              case 4:
                                 class219.method3903(var12, var13, var10.width, var10.height, var10.textColor, var10.field2233, 256 - (var10.opacity & 255), 256 - (var10.field2199 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class219.method3899(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    class219.method3898(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class219.method3905(var12, var13, var10.width, var10.height, var19);
                           } else {
                              class219.method3906(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           class208 var62;
                           if(var10.type == 4) {
                              var62 = var10.method3112();
                              if(var62 == null) {
                                 if(Widget.field2269) {
                                    class97.method1886(var10);
                                 }
                              } else {
                                 String var48 = var10.text;
                                 if(Player.method229(var10)) {
                                    var20 = var10.field2233;
                                    if(class22.field245 == var10 && var10.field2235 != 0) {
                                       var20 = var10.field2235;
                                    }

                                    if(var10.field2268.length() > 0) {
                                       var48 = var10.field2268;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(class22.field245 == var10 && var10.field2234 != 0) {
                                       var20 = var10.field2234;
                                    }
                                 }

                                 if(var10.field2204 && var10.item != -1) {
                                    ItemComposition var69 = class137.getItemDefinition(var10.item);
                                    var48 = var69.name;
                                    if(null == var48) {
                                       var48 = "null";
                                    }

                                    if((var69.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var48 = class16.method182(16748608) + var48 + "</col>" + " " + 'x' + class72.method1383(var10.stackSize);
                                    }
                                 }

                                 if(Client.field448 == var10) {
                                    Object var10000 = null;
                                    var48 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.field2204) {
                                    var48 = class159.method2980(var48, var10);
                                 }

                                 var62.method3827(var48, var12, var13, var10.width, var10.height, var20, var10.field2205?0:-1, var10.field2270, var10.field2271, var10.field2210);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var63;
                              if(!var10.field2204) {
                                 var63 = var10.method3111(Player.method229(var10));
                                 if(null != var63) {
                                    var63.method4048(var12, var13);
                                 } else if(Widget.field2269) {
                                    class97.method1886(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var63 = DecorativeObject.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2211, false);
                                 } else {
                                    var63 = var10.method3111(false);
                                 }

                                 if(null == var63) {
                                    if(Widget.field2269) {
                                       class97.method1886(var10);
                                    }
                                 } else {
                                    var20 = var63.field3208;
                                    var38 = var63.field3209;
                                    if(!var10.field2245) {
                                       var22 = var10.width * 4096 / var20;
                                       if(var10.field2244 != 0) {
                                          var63.method4083(var10.width / 2 + var12, var10.height / 2 + var13, var10.field2244, var22);
                                       } else if(var14 != 0) {
                                          var63.method4051(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var38 == var10.height) {
                                          var63.method4048(var12, var13);
                                       } else {
                                          var63.method4050(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       class219.method3894(var12, var13, var10.width + var12, var10.height + var13);
                                       var22 = (var10.width + (var20 - 1)) / var20;
                                       var36 = (var10.height + (var38 - 1)) / var38;

                                       for(var37 = 0; var37 < var22; ++var37) {
                                          for(var40 = 0; var40 < var36; ++var40) {
                                             if(var10.field2244 != 0) {
                                                var63.method4083(var20 / 2 + var37 * var20 + var12, var38 / 2 + var40 * var38 + var13, var10.field2244, 4096);
                                             } else if(var14 != 0) {
                                                var63.method4054(var12 + var37 * var20, var40 * var38 + var13, 256 - (var14 & 255));
                                             } else {
                                                var63.method4048(var20 * var37 + var12, var13 + var38 * var40);
                                             }
                                          }
                                       }

                                       class219.method3893(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var23;
                              if(var10.type == 6) {
                                 boolean var46 = Player.method229(var10);
                                 if(var46) {
                                    var20 = var10.field2240;
                                 } else {
                                    var20 = var10.field2254;
                                 }

                                 Model var45 = null;
                                 var22 = 0;
                                 if(var10.item != -1) {
                                    var23 = class137.getItemDefinition(var10.item);
                                    if(var23 != null) {
                                       var23 = var23.method3561(var10.stackSize);
                                       var45 = var23.getModel(1);
                                       if(var45 != null) {
                                          var45.method1521();
                                          var22 = var45.modelHeight / 2;
                                       } else {
                                          class97.method1886(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var45 = Client.field495.method3067((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var45 = class5.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var45 = var10.method3113((Sequence)null, -1, var46, class5.localPlayer.composition);
                                    if(var45 == null && Widget.field2269) {
                                       class97.method1886(var10);
                                    }
                                 } else {
                                    Sequence var52 = class31.getAnimation(var20);
                                    var45 = var10.method3113(var52, var10.field2329, var46, class5.localPlayer.composition);
                                    if(var45 == null && Widget.field2269) {
                                       class97.method1886(var10);
                                    }
                                 }

                                 class84.method1602(var12 + var10.width / 2, var13 + var10.height / 2);
                                 var36 = var10.field2261 * class84.field1435[var10.rotationX] >> 16;
                                 var37 = var10.field2261 * class84.field1446[var10.rotationX] >> 16;
                                 if(var45 != null) {
                                    if(!var10.field2204) {
                                       var45.method1538(0, var10.rotationZ, 0, var10.rotationX, 0, var36, var37);
                                    } else {
                                       var45.method1521();
                                       if(var10.field2341) {
                                          var45.method1539(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2291, var22 + var36 + var10.field2257, var37 + var10.field2257, var10.field2261);
                                       } else {
                                          var45.method1538(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2291, var22 + var36 + var10.field2257, var37 + var10.field2257);
                                       }
                                    }
                                 }

                                 class84.method1610();
                              } else {
                                 if(var10.type == 7) {
                                    var62 = var10.method3112();
                                    if(var62 == null) {
                                       if(Widget.field2269) {
                                          class97.method1886(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var38 = 0; var38 < var10.field2215; ++var38) {
                                       for(var22 = 0; var22 < var10.field2218; ++var22) {
                                          if(var10.itemIds[var20] > 0) {
                                             var23 = class137.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var24;
                                             if(var23.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var24 = class16.method182(16748608) + var23.name + "</col>";
                                             } else {
                                                var24 = class16.method182(16748608) + var23.name + "</col>" + " " + 'x' + class72.method1383(var10.itemQuantities[var20]);
                                             }

                                             var40 = var22 * (115 + var10.field2273) + var12;
                                             var41 = (12 + var10.field2200) * var38 + var13;
                                             if(var10.field2270 == 0) {
                                                var62.method3784(var24, var40, var41, var10.textColor, var10.field2205?0:-1);
                                             } else if(var10.field2270 == 1) {
                                                var62.method3787(var24, var10.width / 2 + var40, var41, var10.textColor, var10.field2205?0:-1);
                                             } else {
                                                var62.method3786(var24, var40 + var10.width - 1, var41, var10.textColor, var10.field2205?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && class72.field1192 == var10 && Client.field512 == Client.field436) {
                                    var19 = 0;
                                    var20 = 0;
                                    class208 var21 = class33.field757;
                                    String var43 = var10.text;

                                    String var47;
                                    for(var43 = class159.method2980(var43, var10); var43.length() > 0; var20 += 1 + var21.field3102) {
                                       var37 = var43.indexOf("<br>");
                                       if(var37 != -1) {
                                          var47 = var43.substring(0, var37);
                                          var43 = var43.substring(4 + var37);
                                       } else {
                                          var47 = var43;
                                          var43 = "";
                                       }

                                       var40 = var21.method3774(var47);
                                       if(var40 > var19) {
                                          var19 = var40;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var37 = var10.width + var12 - 5 - var19;
                                    var40 = var13 + var10.height + 5;
                                    if(var37 < 5 + var12) {
                                       var37 = var12 + 5;
                                    }

                                    if(var37 + var19 > var4) {
                                       var37 = var4 - var19;
                                    }

                                    if(var20 + var40 > var5) {
                                       var40 = var5 - var20;
                                    }

                                    class219.method3899(var37, var40, var19, var20, 16777120);
                                    class219.method3905(var37, var40, var19, var20, 0);
                                    var43 = var10.text;
                                    var41 = 2 + var21.field3102 + var40;

                                    for(var43 = class159.method2980(var43, var10); var43.length() > 0; var41 += var21.field3102 + 1) {
                                       var42 = var43.indexOf("<br>");
                                       if(var42 != -1) {
                                          var47 = var43.substring(0, var42);
                                          var43 = var43.substring(var42 + 4);
                                       } else {
                                          var47 = var43;
                                          var43 = "";
                                       }

                                       var21.method3784(var47, 3 + var37, var41, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2311 == 1) {
                                       if(var10.field2220) {
                                          var19 = var12;
                                          var20 = var13 + var10.height;
                                          var38 = var12 + var10.width;
                                          var22 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var38 = var12 + var10.width;
                                          var22 = var10.height + var13;
                                       }

                                       class219.method3911(var19, var20, var38, var22, var10.textColor);
                                    } else {
                                       var19 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var38 = var19;
                                       if(var19 < var20) {
                                          var38 = var20;
                                       }

                                       if(var38 != 0) {
                                          var22 = (var10.width << 16) / var38;
                                          var36 = (var10.height << 16) / var38;
                                          if(var36 <= var22) {
                                             var22 = -var22;
                                          } else {
                                             var36 = -var36;
                                          }

                                          var37 = var10.field2311 * var36 >> 17;
                                          var40 = var10.field2311 * var36 + 1 >> 17;
                                          var41 = var22 * var10.field2311 >> 17;
                                          var42 = var10.field2311 * var22 + 1 >> 17;
                                          var44 = var12 + var37;
                                          var29 = var12 - var40;
                                          var30 = var10.width + var12 - var40;
                                          var31 = var12 + var10.width + var37;
                                          var32 = var41 + var13;
                                          int var33 = var13 - var42;
                                          var34 = var10.height + var13 - var42;
                                          int var35 = var41 + var10.height + var13;
                                          class84.setRasterClippingEnabled(var44, var29, var30);
                                          class84.rasterFlat(var32, var33, var34, var44, var29, var30, var10.textColor);
                                          class84.setRasterClippingEnabled(var44, var30, var31);
                                          class84.rasterFlat(var32, var34, var35, var44, var30, var31, var10.textColor);
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

   public int compare(Object var1, Object var2) {
      return this.method31((class2)var1, (class2)var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "302101455"
   )
   static void method39(File var0) {
      class107.field1731 = var0;
      if(!class107.field1731.exists()) {
         throw new RuntimeException("");
      } else {
         class107.field1737 = true;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass184;IIIBZB)V",
      garbageValue = "17"
   )
   static void method40(class184 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class181 var8 = (class181)class185.field2773.method2299(var6);
      if(var8 == null) {
         var8 = (class181)class185.field2758.method2299(var6);
         if(null == var8) {
            var8 = (class181)class185.field2759.method2299(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method2380();
                  class185.field2773.method2291(var8, var6);
                  --class185.field2764;
                  ++class185.field2765;
               }

            } else {
               if(!var5) {
                  var8 = (class181)class185.field2766.method2299(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class181();
               var8.field2708 = var0;
               var8.field2709 = var3;
               var8.field2710 = var4;
               if(var5) {
                  class185.field2773.method2291(var8, var6);
                  ++class185.field2765;
               } else {
                  class185.field2762.method2241(var8);
                  class185.field2759.method2291(var8, var6);
                  ++class185.field2764;
               }

            }
         }
      }
   }
}
