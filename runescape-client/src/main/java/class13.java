import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class13 implements Runnable {
   @ObfuscatedName("n")
   int[] field209 = new int[500];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 916046417
   )
   int field211 = 0;
   @ObfuscatedName("g")
   int[] field212 = new int[500];
   @ObfuscatedName("i")
   boolean field213 = true;
   @ObfuscatedName("h")
   Object field216 = new Object();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-781997932"
   )
   public static String method159(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   public void run() {
      for(; this.field213; PlayerComposition.method3511(50L)) {
         Object var1 = this.field216;
         synchronized(this.field216) {
            if(this.field211 < 500) {
               this.field212[this.field211] = class143.field2204;
               this.field209[this.field211] = class143.field2206;
               ++this.field211;
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[Lclass21;",
      garbageValue = "584730795"
   )
   static class21[] method161() {
      return new class21[]{class21.field606, class21.field600, class21.field607, class21.field601};
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "84"
   )
   static final void method162() {
      int[] var0 = class34.field786;

      int var1;
      for(var1 = 0; var1 < class34.field779; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(null != var2 && var2.field847 > 0) {
            --var2.field847;
            if(var2.field847 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field341; ++var1) {
         int var4 = Client.field342[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(null != var3 && var3.field847 > 0) {
            --var3.field847;
            if(var3.field847 == 0) {
               var3.overhead = null;
            }
         }
      }

   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "151165378"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class82.method1831(var2, var3, var4, var5);
      class94.method2153();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var10.parentId == var1 || var1 == -1412584499 && Client.field473 == var10)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field425] = var10.relativeX + var6;
               Client.widgetPositionY[Client.field425] = var10.relativeY + var7;
               Client.widgetBoundsWidth[Client.field425] = var10.width;
               Client.widgetBoundsHeight[Client.field425] = var10.height;
               var11 = ++Client.field425 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2900 = Client.gameCycle;
            if(!var10.field2862 || !FaceNormal.method1940(var10)) {
               int var12;
               if(var10.contentType > 0) {
                  var12 = var10.contentType;
                  if(var12 == 324) {
                     if(Client.field573 == -1) {
                        Client.field573 = var10.textureId;
                        Client.field563 = var10.field2826;
                     }

                     if(Client.field574.isFemale) {
                        var10.textureId = Client.field573;
                     } else {
                        var10.textureId = Client.field563;
                     }
                  } else if(var12 == 325) {
                     if(Client.field573 == -1) {
                        Client.field573 = var10.textureId;
                        Client.field563 = var10.field2826;
                     }

                     if(Client.field574.isFemale) {
                        var10.textureId = Client.field563;
                     } else {
                        var10.textureId = Client.field573;
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
               int var13 = var10.relativeY + var7;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(Client.field473 == var10) {
                  if(var1 != -1412584499 && !var10.field2880) {
                     class128.field2088 = var0;
                     class228.field3263 = var6;
                     class157.field2335 = var7;
                     continue;
                  }

                  if(Client.field484 && Client.field478) {
                     var15 = class143.field2204;
                     var16 = class143.field2206;
                     var15 -= Client.field475;
                     var16 -= Client.field512;
                     if(var15 < Client.field479) {
                        var15 = Client.field479;
                     }

                     if(var15 + var10.width > Client.field479 + Client.field474.width) {
                        var15 = Client.field479 + Client.field474.width - var10.width;
                     }

                     if(var16 < Client.field324) {
                        var16 = Client.field324;
                     }

                     if(var10.height + var16 > Client.field474.height + Client.field324) {
                        var16 = Client.field474.height + Client.field324 - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2880) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var20;
               int var21;
               int var39;
               int var40;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var39 = var12;
                  var20 = var13;
                  var21 = var12 + var10.width;
                  var40 = var10.height + var13;
                  if(var21 < var12) {
                     var39 = var21;
                     var21 = var12;
                  }

                  if(var40 < var13) {
                     var20 = var40;
                     var40 = var13;
                  }

                  ++var21;
                  ++var40;
                  var15 = var39 > var2?var39:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var40 < var5?var40:var5;
               } else {
                  var39 = var12 + var10.width;
                  var20 = var10.height + var13;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var39 < var4?var39:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.field2862 || var15 < var17 && var16 < var18) {
                  int var23;
                  int var25;
                  int var26;
                  int var27;
                  int var28;
                  int var29;
                  int var30;
                  int var31;
                  int var32;
                  int var33;
                  int var34;
                  int var35;
                  int var44;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field316) {
                           var13 += 15;
                           class136.field2123.method4069("Fps:" + GameEngine.field2248, var10.width + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var50 = Runtime.getRuntime();
                           var20 = (int)((var50.totalMemory() - var50.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field304) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field304) {
                              var21 = 16711680;
                           }

                           class136.field2123.method4069("Mem:" + var20 + "k", var10.width + var12, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     NPC var63;
                     Player var64;
                     if(var10.contentType == 1337) {
                        Client.field449 = var12;
                        Client.field495 = var13;
                        var21 = var10.width;
                        var40 = var10.height;
                        ++Client.field407;
                        class181.method3507(class35.field799);
                        boolean var58 = false;
                        if(Client.field432 >= 0) {
                           var44 = class34.field779;
                           int[] var65 = class34.field786;

                           for(var26 = 0; var26 < var44; ++var26) {
                              if(var65[var26] == Client.field432) {
                                 var58 = true;
                                 break;
                              }
                           }
                        }

                        if(var58) {
                           class181.method3507(class35.field796);
                        }

                        class4.method56(true);
                        class181.method3507(var58?class35.field793:class35.field798);
                        class4.method56(false);

                        for(Projectile var55 = (Projectile)Client.projectiles.method3845(); null != var55; var55 = (Projectile)Client.projectiles.method3847()) {
                           if(class173.plane == var55.floor && Client.gameCycle <= var55.field118) {
                              if(Client.gameCycle >= var55.startTime) {
                                 if(var55.interacting > 0) {
                                    var63 = Client.cachedNPCs[var55.interacting - 1];
                                    if(var63 != null && var63.x >= 0 && var63.x < 13312 && var63.y >= 0 && var63.y < 13312) {
                                       var55.method97(var63.x, var63.y, class16.method191(var63.x, var63.y, var55.floor) - var55.field131, Client.gameCycle);
                                    }
                                 }

                                 if(var55.interacting < 0) {
                                    var26 = -var55.interacting - 1;
                                    if(var26 == Client.localInteractingIndex) {
                                       var64 = class138.localPlayer;
                                    } else {
                                       var64 = Client.cachedPlayers[var26];
                                    }

                                    if(null != var64 && var64.x >= 0 && var64.x < 13312 && var64.y >= 0 && var64.y < 13312) {
                                       var55.method97(var64.x, var64.y, class16.method191(var64.x, var64.y, var55.floor) - var55.field131, Client.gameCycle);
                                    }
                                 }

                                 var55.method90(Client.field420);
                                 class128.region.method1963(class173.plane, (int)var55.x, (int)var55.velocityZ, (int)var55.z, 60, var55, var55.field135, -1, false);
                              }
                           } else {
                              var55.unlink();
                           }
                        }

                        for(class31 var56 = (class31)Client.field436.method3845(); var56 != null; var56 = (class31)Client.field436.method3847()) {
                           if(class173.plane == var56.field716 && !var56.field715) {
                              if(Client.gameCycle >= var56.field730) {
                                 var56.method663(Client.field420);
                                 if(var56.field715) {
                                    var56.unlink();
                                 } else {
                                    class128.region.method1963(var56.field716, var56.field717, var56.field723, var56.field719, 60, var56, 0, -1, false);
                                 }
                              }
                           } else {
                              var56.unlink();
                           }
                        }

                        class153.method3179(var12, var13, var21, var40, true);
                        var39 = Client.field337;
                        var20 = Client.field564;
                        var21 = Client.camera2;
                        var40 = Client.camera3;
                        class82.method1831(var39, var20, var21 + var39, var20 + var40);
                        class94.method2153();
                        if(!Client.field548) {
                           var44 = Client.field386;
                           if(Client.field395 / 256 > var44) {
                              var44 = Client.field395 / 256;
                           }

                           if(Client.field520[4] && 128 + Client.field552[4] > var44) {
                              var44 = Client.field552[4] + 128;
                           }

                           var25 = Client.field498 + Client.mapAngle & 2047;
                           var26 = class9.field175;
                           var27 = class16.method191(class138.localPlayer.x, class138.localPlayer.y, class173.plane) - Client.field579;
                           var28 = class157.field2342;
                           var29 = var44 * 3 + 600;
                           var30 = 2048 - var44 & 2047;
                           var31 = 2048 - var25 & 2047;
                           var32 = 0;
                           var33 = 0;
                           var34 = var29;
                           int var36;
                           int var37;
                           if(var30 != 0) {
                              var35 = class94.field1623[var30];
                              var36 = class94.field1642[var30];
                              var37 = var33 * var36 - var35 * var29 >> 16;
                              var34 = var29 * var36 + var35 * var33 >> 16;
                              var33 = var37;
                           }

                           if(var31 != 0) {
                              var35 = class94.field1623[var31];
                              var36 = class94.field1642[var31];
                              var37 = var35 * var34 + var32 * var36 >> 16;
                              var34 = var34 * var36 - var32 * var35 >> 16;
                              var32 = var37;
                           }

                           ChatLineBuffer.cameraX = var26 - var32;
                           class28.cameraZ = var27 - var33;
                           class35.cameraY = var28 - var34;
                           class22.cameraPitch = var44;
                           class168.cameraYaw = var25;
                        }

                        if(!Client.field548) {
                           if(Player.field42.field154) {
                              var25 = class173.plane;
                           } else {
                              label1817: {
                                 var26 = 3;
                                 if(class22.cameraPitch < 310) {
                                    var27 = ChatLineBuffer.cameraX >> 7;
                                    var28 = class35.cameraY >> 7;
                                    var29 = class138.localPlayer.x >> 7;
                                    var30 = class138.localPlayer.y >> 7;
                                    if(var27 < 0 || var28 < 0 || var27 >= 104 || var28 >= 104) {
                                       var25 = class173.plane;
                                       break label1817;
                                    }

                                    if((class5.tileSettings[class173.plane][var27][var28] & 4) != 0) {
                                       var26 = class173.plane;
                                    }

                                    if(var29 > var27) {
                                       var31 = var29 - var27;
                                    } else {
                                       var31 = var27 - var29;
                                    }

                                    if(var30 > var28) {
                                       var32 = var30 - var28;
                                    } else {
                                       var32 = var28 - var30;
                                    }

                                    if(var31 > var32) {
                                       var33 = 65536 * var32 / var31;
                                       var34 = '耀';

                                       while(var29 != var27) {
                                          if(var27 < var29) {
                                             ++var27;
                                          } else if(var27 > var29) {
                                             --var27;
                                          }

                                          if((class5.tileSettings[class173.plane][var27][var28] & 4) != 0) {
                                             var26 = class173.plane;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var28 < var30) {
                                                ++var28;
                                             } else if(var28 > var30) {
                                                --var28;
                                             }

                                             if((class5.tileSettings[class173.plane][var27][var28] & 4) != 0) {
                                                var26 = class173.plane;
                                             }
                                          }
                                       }
                                    } else {
                                       var33 = 65536 * var31 / var32;
                                       var34 = '耀';

                                       while(var30 != var28) {
                                          if(var28 < var30) {
                                             ++var28;
                                          } else if(var28 > var30) {
                                             --var28;
                                          }

                                          if((class5.tileSettings[class173.plane][var27][var28] & 4) != 0) {
                                             var26 = class173.plane;
                                          }

                                          var34 += var33;
                                          if(var34 >= 65536) {
                                             var34 -= 65536;
                                             if(var27 < var29) {
                                                ++var27;
                                             } else if(var27 > var29) {
                                                --var27;
                                             }

                                             if((class5.tileSettings[class173.plane][var27][var28] & 4) != 0) {
                                                var26 = class173.plane;
                                             }
                                          }
                                       }
                                    }
                                 }

                                 if(class138.localPlayer.x >= 0 && class138.localPlayer.y >= 0 && class138.localPlayer.x < 13312 && class138.localPlayer.y < 13312) {
                                    if((class5.tileSettings[class173.plane][class138.localPlayer.x >> 7][class138.localPlayer.y >> 7] & 4) != 0) {
                                       var26 = class173.plane;
                                    }

                                    var25 = var26;
                                 } else {
                                    var25 = class173.plane;
                                 }
                              }
                           }

                           var44 = var25;
                        } else {
                           if(Player.field42.field154) {
                              var25 = class173.plane;
                           } else {
                              var26 = class16.method191(ChatLineBuffer.cameraX, class35.cameraY, class173.plane);
                              if(var26 - class28.cameraZ < 800 && (class5.tileSettings[class173.plane][ChatLineBuffer.cameraX >> 7][class35.cameraY >> 7] & 4) != 0) {
                                 var25 = class173.plane;
                              } else {
                                 var25 = 3;
                              }
                           }

                           var44 = var25;
                        }

                        var25 = ChatLineBuffer.cameraX;
                        var26 = class28.cameraZ;
                        var27 = class35.cameraY;
                        var28 = class22.cameraPitch;
                        var29 = class168.cameraYaw;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(Client.field520[var30]) {
                              var31 = (int)(Math.random() * (double)(1 + Client.field551[var30] * 2) - (double)Client.field551[var30] + Math.sin((double)Client.field553[var30] / 100.0D * (double)Client.field504[var30]) * (double)Client.field552[var30]);
                              if(var30 == 0) {
                                 ChatLineBuffer.cameraX += var31;
                              }

                              if(var30 == 1) {
                                 class28.cameraZ += var31;
                              }

                              if(var30 == 2) {
                                 class35.cameraY += var31;
                              }

                              if(var30 == 3) {
                                 class168.cameraYaw = var31 + class168.cameraYaw & 2047;
                              }

                              if(var30 == 4) {
                                 class22.cameraPitch += var31;
                                 if(class22.cameraPitch < 128) {
                                    class22.cameraPitch = 128;
                                 }

                                 if(class22.cameraPitch > 383) {
                                    class22.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var30 = class143.field2204;
                        var31 = class143.field2206;
                        if(class143.field2210 != 0) {
                           var30 = class143.field2211;
                           var31 = class143.field2212;
                        }

                        if(var30 >= var39 && var30 < var39 + var21 && var31 >= var20 && var31 < var20 + var40) {
                           Model.field1855 = true;
                           Model.field1868 = 0;
                           Model.field1911 = var30 - var39;
                           Model.field1864 = var31 - var20;
                        } else {
                           Model.field1855 = false;
                           Model.field1868 = 0;
                        }

                        class212.method3957();
                        class82.method1853(var39, var20, var21, var40, 0);
                        class212.method3957();
                        var32 = class94.field1628;
                        class94.field1628 = Client.scale;
                        class128.region.method2067(ChatLineBuffer.cameraX, class28.cameraZ, class35.cameraY, class22.cameraPitch, class168.cameraYaw, var44);
                        class94.field1628 = var32;
                        class212.method3957();
                        class128.region.method2061();
                        Player.method20(var39, var20, var21, var40);
                        Ignore.method102(var39, var20);
                        ((TextureProvider)class94.field1638).method2218(Client.field420);
                        PlayerComposition.method3540(var39, var20, var21, var40);
                        ChatLineBuffer.cameraX = var25;
                        class28.cameraZ = var26;
                        class35.cameraY = var27;
                        class22.cameraPitch = var28;
                        class168.cameraYaw = var29;
                        if(Client.field439 && class107.method2328(true, false) == 0) {
                           Client.field439 = false;
                        }

                        if(Client.field439) {
                           class82.method1853(var39, var20, var21, var40, 0);
                           class165.method3226("Loading - please wait.", false);
                        }

                        Client.field494[var10.boundsIndex] = true;
                        class82.method1831(var2, var3, var4, var5);
                        continue;
                     }

                     class178 var49;
                     if(var10.contentType == 1338) {
                        class212.method3957();
                        var49 = var10.method3462(false);
                        if(var49 != null) {
                           class82.method1831(var12, var13, var12 + var49.field2948, var49.field2947 + var13);
                           if(Client.field403 != 2 && Client.field403 != 5) {
                              var20 = Client.mapScale + Client.mapAngle & 2047;
                              var21 = 48 + class138.localPlayer.x / 32;
                              var40 = 464 - class138.localPlayer.y / 32;
                              class178.field2953.method1761(var12, var13, var49.field2948, var49.field2947, var21, var40, var20, Client.mapScaleDelta + 256, var49.field2951, var49.field2946);

                              for(var23 = 0; var23 < Client.field309; ++var23) {
                                 var44 = 2 + 4 * Client.field508[var23] - class138.localPlayer.x / 32;
                                 var25 = 2 + Client.field532[var23] * 4 - class138.localPlayer.y / 32;
                                 class18.method197(var12, var13, var44, var25, Client.field533[var23], var49);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field341; ++var23) {
                                       NPC var53 = Client.cachedNPCs[Client.field342[var23]];
                                       if(var53 != null && var53.vmethod783()) {
                                          NPCComposition var62 = var53.composition;
                                          if(var62 != null && null != var62.field938) {
                                             var62 = var62.method813();
                                          }

                                          if(null != var62 && var62.isMinimapVisible && var62.field937) {
                                             var26 = var53.x / 32 - class138.localPlayer.x / 32;
                                             var27 = var53.y / 32 - class138.localPlayer.y / 32;
                                             class18.method197(var12, var13, var26, var27, WallObject.field1588[1], var49);
                                          }
                                       }
                                    }

                                    var23 = class34.field779;
                                    int[] var54 = class34.field786;

                                    for(var25 = 0; var25 < var23; ++var25) {
                                       Player var42 = Client.cachedPlayers[var54[var25]];
                                       if(var42 != null && var42.vmethod783() && !var42.field45 && var42 != class138.localPlayer) {
                                          var27 = var42.x / 32 - class138.localPlayer.x / 32;
                                          var28 = var42.y / 32 - class138.localPlayer.y / 32;
                                          boolean var61 = false;
                                          if(class0.method0(var42.name, true)) {
                                             var61 = true;
                                          }

                                          boolean var59 = false;

                                          for(var31 = 0; var31 < class40.field896; ++var31) {
                                             if(var42.name.equals(class146.clanMembers[var31].username)) {
                                                var59 = true;
                                                break;
                                             }
                                          }

                                          boolean var60 = false;
                                          if(class138.localPlayer.team != 0 && var42.team != 0 && var42.team == class138.localPlayer.team) {
                                             var60 = true;
                                          }

                                          if(var61) {
                                             class18.method197(var12, var13, var27, var28, WallObject.field1588[3], var49);
                                          } else if(var60) {
                                             class18.method197(var12, var13, var27, var28, WallObject.field1588[4], var49);
                                          } else if(var59) {
                                             class18.method197(var12, var13, var27, var28, WallObject.field1588[5], var49);
                                          } else {
                                             class18.method197(var12, var13, var27, var28, WallObject.field1588[2], var49);
                                          }
                                       }
                                    }

                                    if(Client.field306 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field306 == 1 && Client.field319 >= 0 && Client.field319 < Client.cachedNPCs.length) {
                                          var63 = Client.cachedNPCs[Client.field319];
                                          if(var63 != null) {
                                             var26 = var63.x / 32 - class138.localPlayer.x / 32;
                                             var27 = var63.y / 32 - class138.localPlayer.y / 32;
                                             class32.method674(var12, var13, var26, var27, WidgetNode.field66[1], var49);
                                          }
                                       }

                                       if(Client.field306 == 2) {
                                          var25 = Client.field321 * 4 - class193.baseX * 4 + 2 - class138.localPlayer.x / 32;
                                          var26 = 2 + (Client.field529 * 4 - DecorativeObject.baseY * 4) - class138.localPlayer.y / 32;
                                          class32.method674(var12, var13, var25, var26, WidgetNode.field66[1], var49);
                                       }

                                       if(Client.field306 == 10 && Client.field320 >= 0 && Client.field320 < Client.cachedPlayers.length) {
                                          var64 = Client.cachedPlayers[Client.field320];
                                          if(null != var64) {
                                             var26 = var64.x / 32 - class138.localPlayer.x / 32;
                                             var27 = var64.y / 32 - class138.localPlayer.y / 32;
                                             class32.method674(var12, var13, var26, var27, WidgetNode.field66[1], var49);
                                          }
                                       }
                                    }

                                    if(Client.flagX != 0) {
                                       var25 = 2 + Client.flagX * 4 - class138.localPlayer.x / 32;
                                       var26 = 2 + Client.flagY * 4 - class138.localPlayer.y / 32;
                                       class18.method197(var12, var13, var25, var26, WidgetNode.field66[0], var49);
                                    }

                                    if(!class138.localPlayer.field45) {
                                       class82.method1853(var49.field2948 / 2 + var12 - 1, var49.field2947 / 2 + var13 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var44 = 0; var44 < 104; ++var44) {
                                    Deque var38 = Client.groundItemDeque[class173.plane][var23][var44];
                                    if(var38 != null) {
                                       var26 = 2 + 4 * var23 - class138.localPlayer.x / 32;
                                       var27 = var44 * 4 + 2 - class138.localPlayer.y / 32;
                                       class18.method197(var12, var13, var26, var27, WallObject.field1588[0], var49);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              class82.method1850(var12, var13, 0, var49.field2951, var49.field2946);
                           }

                           Client.field506[var11] = true;
                        }

                        class82.method1831(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        var49 = var10.method3462(false);
                        if(var49 != null) {
                           if(Client.field403 < 3) {
                              class51.field1107.method1761(var12, var13, var49.field2948, var49.field2947, 25, 25, Client.mapAngle, 256, var49.field2951, var49.field2946);
                           } else {
                              class82.method1850(var12, var13, 0, var49.field2951, var49.field2946);
                           }
                        }

                        class82.method1831(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.field2862 && FaceNormal.method1940(var10) && class53.field1153 != var10) {
                        continue;
                     }

                     if(!var10.field2862) {
                        if(var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if(var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     gameDraw(var0, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     if(var10.children != null) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.itemId, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var19 = (WidgetNode)Client.componentTable.method3812((long)var10.id);
                     if(null != var19) {
                        class225.method4056(var19.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     class82.method1831(var2, var3, var4, var5);
                     class94.method2153();
                  }

                  if(Client.isResized || Client.field507[var11] || Client.field402 > 1) {
                     if(var10.type == 0 && !var10.field2862 && var10.scrollHeight > var10.height) {
                        class1.method12(var10.width + var12, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var39 = 0;

                           for(var20 = 0; var20 < var10.field2814; ++var20) {
                              for(var21 = 0; var21 < var10.field2813; ++var21) {
                                 var40 = var12 + var21 * (32 + var10.field2868);
                                 var23 = var13 + (32 + var10.field2869) * var20;
                                 if(var39 < 20) {
                                    var40 += var10.field2836[var39];
                                    var23 += var10.field2871[var39];
                                 }

                                 if(var10.itemIds[var39] <= 0) {
                                    if(null != var10.field2872 && var39 < 20) {
                                       SpritePixels var52 = var10.method3430(var39);
                                       if(null != var52) {
                                          var52.method1810(var40, var23);
                                       } else if(Widget.field2800) {
                                          class32.method673(var10);
                                       }
                                    }
                                 } else {
                                    boolean var70 = false;
                                    boolean var57 = false;
                                    var26 = var10.itemIds[var39] - 1;
                                    if(32 + var40 > var2 && var40 < var4 && 32 + var23 > var3 && var23 < var5 || var10 == FrameMap.field1821 && var39 == Client.field416) {
                                       SpritePixels var46;
                                       if(Client.field453 == 1 && var39 == class24.field641 && RSCanvas.field2197 == var10.id) {
                                          var46 = class184.createSprite(var26, var10.itemQuantities[var39], 2, 0, 2, false);
                                       } else {
                                          var46 = class184.createSprite(var26, var10.itemQuantities[var39], 1, 3153952, 2, false);
                                       }

                                       if(null != var46) {
                                          if(FrameMap.field1821 == var10 && Client.field416 == var39) {
                                             var44 = class143.field2204 - Client.field417;
                                             var25 = class143.field2206 - Client.field392;
                                             if(var44 < 5 && var44 > -5) {
                                                var44 = 0;
                                             }

                                             if(var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if(Client.field423 < 5) {
                                                var44 = 0;
                                                var25 = 0;
                                             }

                                             var46.method1756(var44 + var40, var23 + var25, 128);
                                             if(var1 != -1) {
                                                Widget var41 = var0[var1 & '\uffff'];
                                                if(var25 + var23 < class82.field1466 && var41.scrollY > 0) {
                                                   var29 = Client.field420 * (class82.field1466 - var23 - var25) / 3;
                                                   if(var29 > Client.field420 * 10) {
                                                      var29 = Client.field420 * 10;
                                                   }

                                                   if(var29 > var41.scrollY) {
                                                      var29 = var41.scrollY;
                                                   }

                                                   var41.scrollY -= var29;
                                                   Client.field392 += var29;
                                                   class32.method673(var41);
                                                }

                                                if(var25 + var23 + 32 > class82.field1469 && var41.scrollY < var41.scrollHeight - var41.height) {
                                                   var29 = (var23 + var25 + 32 - class82.field1469) * Client.field420 / 3;
                                                   if(var29 > Client.field420 * 10) {
                                                      var29 = Client.field420 * 10;
                                                   }

                                                   if(var29 > var41.scrollHeight - var41.height - var41.scrollY) {
                                                      var29 = var41.scrollHeight - var41.height - var41.scrollY;
                                                   }

                                                   var41.scrollY += var29;
                                                   Client.field392 -= var29;
                                                   class32.method673(var41);
                                                }
                                             }
                                          } else if(var10 == Actor.field895 && Client.field415 == var39) {
                                             var46.method1756(var40, var23, 128);
                                          } else {
                                             var46.method1810(var40, var23);
                                          }
                                       } else {
                                          class32.method673(var10);
                                       }
                                    }
                                 }

                                 ++var39;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class172.method3401(var10)) {
                              var39 = var10.field2801;
                              if(class53.field1153 == var10 && var10.field2830 != 0) {
                                 var39 = var10.field2830;
                              }
                           } else {
                              var39 = var10.textColor;
                              if(class53.field1153 == var10 && var10.field2819 != 0) {
                                 var39 = var10.field2819;
                              }
                           }

                           if(var10.field2831) {
                              switch(var10.field2878.field1483) {
                              case 1:
                                 class82.method1838(var12, var13, var10.width, var10.height, var10.textColor, var10.field2801, 256 - (var10.opacity & 255), 256 - (var10.field2834 & 255));
                                 break;
                              case 2:
                                 class82.method1886(var12, var13, var10.width, var10.height, var10.textColor, var10.field2801, 256 - (var10.opacity & 255), 256 - (var10.field2834 & 255));
                                 break;
                              case 3:
                                 class82.method1840(var12, var13, var10.width, var10.height, var10.textColor, var10.field2801, 256 - (var10.opacity & 255), 256 - (var10.field2834 & 255));
                                 break;
                              case 4:
                                 class82.method1841(var12, var13, var10.width, var10.height, var10.textColor, var10.field2801, 256 - (var10.opacity & 255), 256 - (var10.field2834 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    class82.method1853(var12, var13, var10.width, var10.height, var39);
                                 } else {
                                    class82.method1836(var12, var13, var10.width, var10.height, var39, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              class82.method1856(var12, var13, var10.width, var10.height, var39);
                           } else {
                              class82.method1884(var12, var13, var10.width, var10.height, var39, 256 - (var14 & 255));
                           }
                        } else {
                           class227 var47;
                           if(var10.type == 4) {
                              var47 = var10.method3436();
                              if(var47 == null) {
                                 if(Widget.field2800) {
                                    class32.method673(var10);
                                 }
                              } else {
                                 String var69 = var10.text;
                                 if(class172.method3401(var10)) {
                                    var20 = var10.field2801;
                                    if(var10 == class53.field1153 && var10.field2830 != 0) {
                                       var20 = var10.field2830;
                                    }

                                    if(var10.field2863.length() > 0) {
                                       var69 = var10.field2863;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(class53.field1153 == var10 && var10.field2819 != 0) {
                                       var20 = var10.field2819;
                                    }
                                 }

                                 if(var10.field2862 && var10.item != -1) {
                                    ItemComposition var51 = class92.getItemDefinition(var10.item);
                                    var69 = var51.name;
                                    if(null == var69) {
                                       var69 = "null";
                                    }

                                    if((var51.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var69 = class137.method2909(16748608) + var69 + "</col>" + " " + 'x' + TextureProvider.method2220(var10.stackSize);
                                    }
                                 }

                                 if(var10 == Client.field464) {
                                    Object var10000 = null;
                                    var69 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.field2862) {
                                    var69 = class31.method670(var69, var10);
                                 }

                                 var47.method4071(var69, var12, var13, var10.width, var10.height, var20, var10.field2867?0:-1, var10.field2865, var10.field2866, var10.field2870);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var48;
                              if(!var10.field2862) {
                                 var48 = var10.method3431(class172.method3401(var10));
                                 if(var48 != null) {
                                    var48.method1810(var12, var13);
                                 } else if(Widget.field2800) {
                                    class32.method673(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var48 = class184.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2860, false);
                                 } else {
                                    var48 = var10.method3431(false);
                                 }

                                 if(var48 == null) {
                                    if(Widget.field2800) {
                                       class32.method673(var10);
                                    }
                                 } else {
                                    var20 = var48.field1453;
                                    var21 = var48.field1459;
                                    if(!var10.field2840) {
                                       var40 = var10.width * 4096 / var20;
                                       if(var10.field2843 != 0) {
                                          var48.method1763(var12 + var10.width / 2, var13 + var10.height / 2, var10.field2843, var40);
                                       } else if(var14 != 0) {
                                          var48.method1808(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var21 == var10.height) {
                                          var48.method1810(var12, var13);
                                       } else {
                                          var48.method1749(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       class82.method1828(var12, var13, var10.width + var12, var10.height + var13);
                                       var40 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var10.height + (var21 - 1)) / var21;

                                       for(var44 = 0; var44 < var40; ++var44) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if(var10.field2843 != 0) {
                                                var48.method1763(var12 + var44 * var20 + var20 / 2, var21 * var25 + var13 + var21 / 2, var10.field2843, 4096);
                                             } else if(var14 != 0) {
                                                var48.method1756(var12 + var20 * var44, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var48.method1810(var12 + var44 * var20, var21 * var25 + var13);
                                             }
                                          }
                                       }

                                       class82.method1831(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var45;
                              if(var10.type == 6) {
                                 boolean var66 = class172.method3401(var10);
                                 if(var66) {
                                    var20 = var10.field2850;
                                 } else {
                                    var20 = var10.field2828;
                                 }

                                 Model var67 = null;
                                 var40 = 0;
                                 if(var10.item != -1) {
                                    var45 = class92.getItemDefinition(var10.item);
                                    if(null != var45) {
                                       var45 = var45.method1122(var10.stackSize);
                                       var67 = var45.getModel(1);
                                       if(null != var67) {
                                          var67.method2335();
                                          var40 = var67.modelHeight / 2;
                                       } else {
                                          class32.method673(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var67 = Client.field574.method3518((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var67 = class138.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var67 = var10.method3434((Sequence)null, -1, var66, class138.localPlayer.composition);
                                    if(null == var67 && Widget.field2800) {
                                       class32.method673(var10);
                                    }
                                 } else {
                                    Sequence var71 = class192.getAnimation(var20);
                                    var67 = var10.method3434(var71, var10.field2934, var66, class138.localPlayer.composition);
                                    if(null == var67 && Widget.field2800) {
                                       class32.method673(var10);
                                    }
                                 }

                                 class94.method2146(var12 + var10.width / 2, var13 + var10.height / 2);
                                 var23 = class94.field1623[var10.rotationX] * var10.field2856 >> 16;
                                 var44 = class94.field1642[var10.rotationX] * var10.field2856 >> 16;
                                 if(var67 != null) {
                                    if(!var10.field2862) {
                                       var67.method2347(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var44);
                                    } else {
                                       var67.method2335();
                                       if(var10.field2859) {
                                          var67.method2348(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2913, var40 + var23 + var10.field2898, var10.field2898 + var44, var10.field2856);
                                       } else {
                                          var67.method2347(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2913, var10.field2898 + var40 + var23, var10.field2898 + var44);
                                       }
                                    }
                                 }

                                 class94.method2145();
                              } else {
                                 if(var10.type == 7) {
                                    var47 = var10.method3436();
                                    if(null == var47) {
                                       if(Widget.field2800) {
                                          class32.method673(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2814; ++var21) {
                                       for(var40 = 0; var40 < var10.field2813; ++var40) {
                                          if(var10.itemIds[var20] > 0) {
                                             var45 = class92.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var24;
                                             if(var45.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var24 = class137.method2909(16748608) + var45.name + "</col>";
                                             } else {
                                                var24 = class137.method2909(16748608) + var45.name + "</col>" + " " + 'x' + TextureProvider.method2220(var10.itemQuantities[var20]);
                                             }

                                             var25 = (115 + var10.field2868) * var40 + var12;
                                             var26 = var13 + var21 * (var10.field2869 + 12);
                                             if(var10.field2865 == 0) {
                                                var47.method4124(var24, var25, var26, var10.textColor, var10.field2867?0:-1);
                                             } else if(var10.field2865 == 1) {
                                                var47.method4070(var24, var10.width / 2 + var25, var26, var10.textColor, var10.field2867?0:-1);
                                             } else {
                                                var47.method4069(var24, var10.width + var25 - 1, var26, var10.textColor, var10.field2867?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == Friend.field267 && Client.field452 == Client.field360) {
                                    var39 = 0;
                                    var20 = 0;
                                    class227 var43 = class136.field2123;
                                    String var22 = var10.text;

                                    String var68;
                                    for(var22 = class31.method670(var22, var10); var22.length() > 0; var20 += 1 + var43.field3243) {
                                       var44 = var22.indexOf("<br>");
                                       if(var44 != -1) {
                                          var68 = var22.substring(0, var44);
                                          var22 = var22.substring(var44 + 4);
                                       } else {
                                          var68 = var22;
                                          var22 = "";
                                       }

                                       var25 = var43.method4062(var68);
                                       if(var25 > var39) {
                                          var39 = var25;
                                       }
                                    }

                                    var39 += 6;
                                    var20 += 7;
                                    var44 = var12 + var10.width - 5 - var39;
                                    var25 = var13 + var10.height + 5;
                                    if(var44 < var12 + 5) {
                                       var44 = var12 + 5;
                                    }

                                    if(var44 + var39 > var4) {
                                       var44 = var4 - var39;
                                    }

                                    if(var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    class82.method1853(var44, var25, var39, var20, 16777120);
                                    class82.method1856(var44, var25, var39, var20, 0);
                                    var22 = var10.text;
                                    var26 = 2 + var43.field3243 + var25;

                                    for(var22 = class31.method670(var22, var10); var22.length() > 0; var26 += 1 + var43.field3243) {
                                       var27 = var22.indexOf("<br>");
                                       if(var27 != -1) {
                                          var68 = var22.substring(0, var27);
                                          var22 = var22.substring(var27 + 4);
                                       } else {
                                          var68 = var22;
                                          var22 = "";
                                       }

                                       var43.method4124(var68, 3 + var44, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2835 == 1) {
                                       if(var10.field2839) {
                                          var39 = var12;
                                          var20 = var10.height + var13;
                                          var21 = var12 + var10.width;
                                          var40 = var13;
                                       } else {
                                          var39 = var12;
                                          var20 = var13;
                                          var21 = var10.width + var12;
                                          var40 = var10.height + var13;
                                       }

                                       class82.method1849(var39, var20, var21, var40, var10.textColor);
                                    } else {
                                       var39 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var21 = var39;
                                       if(var39 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var40 = (var10.width << 16) / var21;
                                          var23 = (var10.height << 16) / var21;
                                          if(var23 <= var40) {
                                             var40 = -var40;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var44 = var23 * var10.field2835 >> 17;
                                          var25 = 1 + var23 * var10.field2835 >> 17;
                                          var26 = var10.field2835 * var40 >> 17;
                                          var27 = 1 + var40 * var10.field2835 >> 17;
                                          var28 = var12 + var44;
                                          var29 = var12 - var25;
                                          var30 = var10.width + var12 - var25;
                                          var31 = var12 + var10.width + var44;
                                          var32 = var13 + var26;
                                          var33 = var13 - var27;
                                          var34 = var10.height + var13 - var27;
                                          var35 = var26 + var10.height + var13;
                                          class94.setRasterClippingEnabled(var28, var29, var30);
                                          class94.rasterFlat(var32, var33, var34, var28, var29, var30, var10.textColor);
                                          class94.setRasterClippingEnabled(var28, var30, var31);
                                          class94.rasterFlat(var32, var34, var35, var28, var30, var31, var10.textColor);
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "45"
   )
   static void method165() {
      class11.chatLineMap.clear();
      class11.field192.method3836();
      class11.field182.method3869();
      class11.field185 = 0;
   }
}
