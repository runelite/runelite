import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class183 implements Runnable {
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = 103483249
   )
   static int field2727;
   @ObfuscatedName("d")
   static Deque field2728 = new Deque();
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -295402221
   )
   static int field2729 = 0;
   @ObfuscatedName("q")
   static Deque field2730 = new Deque();
   @ObfuscatedName("p")
   static Object field2732 = new Object();

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1569548313"
   )
   static final void method3382() {
      short var0 = 256;
      int var1;
      if(class41.field848 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field848 > 768) {
               class41.field847[var1] = class72.method1465(class211.field3128[var1], class31.field722[var1], 1024 - class41.field848);
            } else if(class41.field848 > 256) {
               class41.field847[var1] = class31.field722[var1];
            } else {
               class41.field847[var1] = class72.method1465(class31.field722[var1], class211.field3128[var1], 256 - class41.field848);
            }
         }
      } else if(class41.field849 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class41.field849 > 768) {
               class41.field847[var1] = class72.method1465(class211.field3128[var1], class5.field61[var1], 1024 - class41.field849);
            } else if(class41.field849 > 256) {
               class41.field847[var1] = class5.field61[var1];
            } else {
               class41.field847[var1] = class72.method1465(class5.field61[var1], class211.field3128[var1], 256 - class41.field849);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class41.field847[var1] = class211.field3128[var1];
         }
      }

      Rasterizer2D.method4031(class41.field839, 9, 128 + class41.field839, 7 + var0);
      class5.field60.method4171(class41.field839, 0);
      Rasterizer2D.method4058();
      var1 = 0;
      int var2 = CombatInfo1.bufferProvider.width * 9 + class41.field839;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class41.field846[var3] * (var0 - var3) / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class41.field872[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class41.field847[var7];
               var10 = CombatInfo1.bufferProvider.pixels[var2];
               CombatInfo1.bufferProvider.pixels[var2++] = (var9 * (var10 & 16711935) + (var7 & 16711935) * var8 & -16711936) + (var9 * (var10 & '\uff00') + (var7 & '\uff00') * var8 & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += CombatInfo1.bufferProvider.width + var5 - 128;
      }

      Rasterizer2D.method4031(class41.field839 + 765 - 128, 9, class41.field839 + 765, var0 + 7);
      XGrandExchangeOffer.field57.method4171(class41.field839 + 382, 0);
      Rasterizer2D.method4058();
      var1 = 0;
      var2 = 637 + 24 + CombatInfo1.bufferProvider.width * 9 + class41.field839;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = class41.field846[var3] * (var0 - var3) / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class41.field872[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class41.field847[var7];
               var10 = CombatInfo1.bufferProvider.pixels[var2];
               CombatInfo1.bufferProvider.pixels[var2++] = ((var7 & 16711935) * var8 + (var10 & 16711935) * var9 & -16711936) + (var8 * (var7 & '\uff00') + (var10 & '\uff00') * var9 & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += CombatInfo1.bufferProvider.width - var5 - var4;
      }

   }

   public void run() {
      try {
         while(true) {
            Deque var2 = field2730;
            class180 var1;
            synchronized(field2730) {
               var1 = (class180)field2730.method2458();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2701 == 0) {
                  var1.field2697.method2295((int)var1.hash, var1.field2696, var1.field2696.length);
                  var2 = field2730;
                  synchronized(field2730) {
                     var1.unlink();
                  }
               } else if(var1.field2701 == 1) {
                  var1.field2696 = var1.field2697.method2293((int)var1.hash);
                  var2 = field2730;
                  synchronized(field2730) {
                     field2728.method2453(var1);
                  }
               }

               var14 = field2732;
               synchronized(field2732) {
                  if(field2729 <= 1) {
                     field2729 = 0;
                     field2732.notifyAll();
                     return;
                  }

                  field2729 = 600;
               }
            } else {
               class115.method2292(100L);
               var14 = field2732;
               synchronized(field2732) {
                  if(field2729 <= 1) {
                     field2729 = 0;
                     field2732.notifyAll();
                     return;
                  }

                  --field2729;
               }
            }
         }
      } catch (Exception var13) {
         class37.method822((String)null, var13);
      }
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIIII)V",
      garbageValue = "98753972"
   )
   @Export("gameDraw")
   static final void gameDraw(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.method4031(var2, var3, var4, var5);
      class84.method1686();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if(var10 != null && (var1 == var10.parentId || var1 == -1412584499 && var10 == Client.field523)) {
            int var11;
            if(var8 == -1) {
               Client.widgetPositionX[Client.field489] = var6 + var10.relativeX;
               Client.widgetPositionY[Client.field489] = var7 + var10.relativeY;
               Client.widgetBoundsWidth[Client.field489] = var10.width;
               Client.widgetBoundsHeight[Client.field489] = var10.height;
               var11 = ++Client.field489 - 1;
            } else {
               var11 = var8;
            }

            var10.boundsIndex = var11;
            var10.field2337 = Client.gameCycle;
            if(!var10.hasScript || !VertexNormal.method1683(var10)) {
               if(var10.contentType > 0) {
                  Ignore.method201(var10);
               }

               int var12 = var6 + var10.relativeX;
               int var13 = var10.relativeY + var7;
               int var14 = var10.opacity;
               int var15;
               int var16;
               if(var10 == Client.field523) {
                  if(var1 != -1412584499 && !var10.field2283) {
                     class114.field1786 = var0;
                     class118.field1843 = var6;
                     class176.field2661 = var7;
                     continue;
                  }

                  if(Client.field492 && Client.field516) {
                     var15 = class115.field1792;
                     var16 = class115.field1799;
                     var15 -= Client.field480;
                     var16 -= Client.field369;
                     if(var15 < Client.field319) {
                        var15 = Client.field319;
                     }

                     if(var10.width + var15 > Client.field319 + Client.field530.width) {
                        var15 = Client.field530.width + Client.field319 - var10.width;
                     }

                     if(var16 < Client.field485) {
                        var16 = Client.field485;
                     }

                     if(var16 + var10.height > Client.field530.height + Client.field485) {
                        var16 = Client.field530.height + Client.field485 - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if(!var10.field2283) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var47;
               if(var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if(var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var12 + var10.width;
                  var47 = var13 + var10.height;
                  if(var21 < var12) {
                     var19 = var21;
                     var21 = var12;
                  }

                  if(var47 < var13) {
                     var20 = var47;
                     var47 = var13;
                  }

                  ++var21;
                  ++var47;
                  var15 = var19 > var2?var19:var2;
                  var16 = var20 > var3?var20:var3;
                  var17 = var21 < var4?var21:var4;
                  var18 = var47 < var5?var47:var5;
               } else {
                  var19 = var12 + var10.width;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2?var12:var2;
                  var16 = var13 > var3?var13:var3;
                  var17 = var19 < var4?var19:var4;
                  var18 = var20 < var5?var20:var5;
               }

               if(!var10.hasScript || var15 < var17 && var16 < var18) {
                  int var23;
                  int var24;
                  int var26;
                  int var27;
                  int var29;
                  int var30;
                  int var31;
                  int var32;
                  int var34;
                  int var35;
                  int var49;
                  int var52;
                  if(var10.contentType != 0) {
                     if(var10.contentType == 1336) {
                        if(Client.field321) {
                           var13 += 15;
                           class175.field2651.method3900("Fps:" + GameEngine.FPS, var10.width + var12, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var75 = Runtime.getRuntime();
                           var20 = (int)((var75.totalMemory() - var75.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if(var20 > '耀' && Client.field308) {
                              var21 = 16711680;
                           }

                           if(var20 > 65536 && !Client.field308) {
                              var21 = 16711680;
                           }

                           class175.field2651.method3900("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if(var10.contentType == 1337) {
                        Client.field454 = var12;
                        Client.field473 = var13;
                        var21 = var10.width;
                        var47 = var10.height;
                        ++Client.field409;
                        class155.method3041(class15.field177);
                        boolean var65 = false;
                        if(Client.field434 >= 0) {
                           var24 = class45.field921;
                           int[] var63 = class45.field931;

                           for(var26 = 0; var26 < var24; ++var26) {
                              if(var63[var26] == Client.field434) {
                                 var65 = true;
                                 break;
                              }
                           }
                        }

                        if(var65) {
                           class155.method3041(class15.field169);
                        }

                        class162.method3116(true);
                        class155.method3041(var65?class15.field171:class15.field170);
                        class162.method3116(false);
                        class38.method823();

                        for(class33 var81 = (class33)Client.field418.method2458(); null != var81; var81 = (class33)Client.field418.method2472()) {
                           if(var81.field773 == WallObject.plane && !var81.field768) {
                              if(Client.gameCycle >= var81.field762) {
                                 var81.method778(Client.field498);
                                 if(var81.field768) {
                                    var81.unlink();
                                 } else {
                                    Script.region.method1758(var81.field773, var81.field764, var81.field765, var81.field771, 60, var81, 0, -1, false);
                                 }
                              }
                           } else {
                              var81.unlink();
                           }
                        }

                        FileOnDisk.method1471(var12, var13, var21, var47, true);
                        var19 = Client.field567;
                        var20 = Client.field568;
                        var21 = Client.camera2;
                        var47 = Client.camera3;
                        Rasterizer2D.method4031(var19, var20, var19 + var21, var47 + var20);
                        class84.method1686();
                        if(!Client.field553) {
                           var24 = Client.field541;
                           if(Client.field397 / 256 > var24) {
                              var24 = Client.field397 / 256;
                           }

                           if(Client.field554[4] && 128 + Client.field527[4] > var24) {
                              var24 = 128 + Client.field527[4];
                           }

                           var49 = Client.field339 + Client.mapAngle & 2047;
                           class13.method172(class85.field1473, class2.method19(class36.localPlayer.x, class36.localPlayer.y, WallObject.plane) - Client.field394, class180.field2698, var24, var49, 600 + 3 * var24);
                        }

                        if(!Client.field553) {
                           var24 = class10.method136();
                        } else {
                           var24 = World.method671();
                        }

                        var49 = VertexNormal.cameraX;
                        var26 = class36.cameraZ;
                        var27 = class37.cameraY;
                        var52 = Actor.cameraPitch;
                        var29 = class26.cameraYaw;

                        for(var30 = 0; var30 < 5; ++var30) {
                           if(Client.field554[var30]) {
                              var31 = (int)(Math.random() * (double)(1 + 2 * Client.field327[var30]) - (double)Client.field327[var30] + Math.sin((double)Client.field558[var30] * ((double)Client.field311[var30] / 100.0D)) * (double)Client.field527[var30]);
                              if(var30 == 0) {
                                 VertexNormal.cameraX += var31;
                              }

                              if(var30 == 1) {
                                 class36.cameraZ += var31;
                              }

                              if(var30 == 2) {
                                 class37.cameraY += var31;
                              }

                              if(var30 == 3) {
                                 class26.cameraYaw = class26.cameraYaw + var31 & 2047;
                              }

                              if(var30 == 4) {
                                 Actor.cameraPitch += var31;
                                 if(Actor.cameraPitch < 128) {
                                    Actor.cameraPitch = 128;
                                 }

                                 if(Actor.cameraPitch > 383) {
                                    Actor.cameraPitch = 383;
                                 }
                              }
                           }
                        }

                        var30 = class115.field1792;
                        var31 = class115.field1799;
                        if(class115.field1804 != 0) {
                           var30 = class115.field1796;
                           var31 = class115.field1806;
                        }

                        if(var30 >= var19 && var30 < var19 + var21 && var31 >= var20 && var31 < var47 + var20) {
                           Model.field1428 = true;
                           Model.field1422 = 0;
                           Model.field1429 = var30 - var19;
                           Model.field1376 = var31 - var20;
                        } else {
                           Model.field1428 = false;
                           Model.field1422 = 0;
                        }

                        class7.method91();
                        Rasterizer2D.method4011(var19, var20, var21, var47, 0);
                        class7.method91();
                        var32 = class84.field1445;
                        class84.field1445 = Client.scale;
                        Script.region.method1788(VertexNormal.cameraX, class36.cameraZ, class37.cameraY, Actor.cameraPitch, class26.cameraYaw, var24);
                        class84.field1445 = var32;
                        class7.method91();
                        Script.region.method1761();
                        Client.field398 = 0;
                        boolean var69 = false;
                        var34 = -1;
                        var35 = class45.field921;
                        int[] var36 = class45.field931;

                        int var37;
                        for(var37 = 0; var37 < var35 + Client.field340; ++var37) {
                           Object var38;
                           if(var37 < var35) {
                              var38 = Client.cachedPlayers[var36[var37]];
                              if(Client.field434 == var36[var37]) {
                                 var69 = true;
                                 var34 = var37;
                                 continue;
                              }
                           } else {
                              var38 = Client.cachedNPCs[Client.field345[var37 - var35]];
                           }

                           class180.method3297((Actor)var38, var37, var19, var20, var21, var47);
                        }

                        if(var69) {
                           class180.method3297(Client.cachedPlayers[Client.field434], var34, var19, var20, var21, var47);
                        }

                        for(var37 = 0; var37 < Client.field398; ++var37) {
                           int var55 = Client.field400[var37];
                           int var39 = Client.field375[var37];
                           int var40 = Client.field403[var37];
                           int var41 = Client.field317[var37];
                           boolean var42 = true;

                           while(var42) {
                              var42 = false;

                              for(int var54 = 0; var54 < var37; ++var54) {
                                 if(var39 + 2 > Client.field375[var54] - Client.field317[var54] && var39 - var41 < 2 + Client.field375[var54] && var55 - var40 < Client.field403[var54] + Client.field400[var54] && var55 + var40 > Client.field400[var54] - Client.field403[var54] && Client.field375[var54] - Client.field317[var54] < var39) {
                                    var39 = Client.field375[var54] - Client.field317[var54];
                                    var42 = true;
                                 }
                              }
                           }

                           Client.field410 = Client.field400[var37];
                           Client.field411 = Client.field375[var37] = var39;
                           String var43 = Client.field407[var37];
                           if(Client.field338 == 0) {
                              int var44 = 16776960;
                              if(Client.field382[var37] < 6) {
                                 var44 = Client.field544[Client.field382[var37]];
                              }

                              if(Client.field382[var37] == 6) {
                                 var44 = Client.field409 % 20 < 10?16711680:16776960;
                              }

                              if(Client.field382[var37] == 7) {
                                 var44 = Client.field409 % 20 < 10?255:'\uffff';
                              }

                              if(Client.field382[var37] == 8) {
                                 var44 = Client.field409 % 20 < 10?'뀀':8454016;
                              }

                              int var45;
                              if(Client.field382[var37] == 9) {
                                 var45 = 150 - Client.field552[var37];
                                 if(var45 < 50) {
                                    var44 = 1280 * var45 + 16711680;
                                 } else if(var45 < 100) {
                                    var44 = 16776960 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = (var45 - 100) * 5 + '\uff00';
                                 }
                              }

                              if(Client.field382[var37] == 10) {
                                 var45 = 150 - Client.field552[var37];
                                 if(var45 < 50) {
                                    var44 = 5 * var45 + 16711680;
                                 } else if(var45 < 100) {
                                    var44 = 16711935 - (var45 - 50) * 327680;
                                 } else if(var45 < 150) {
                                    var44 = 255 + (var45 - 100) * 327680 - 5 * (var45 - 100);
                                 }
                              }

                              if(Client.field382[var37] == 11) {
                                 var45 = 150 - Client.field552[var37];
                                 if(var45 < 50) {
                                    var44 = 16777215 - var45 * 327685;
                                 } else if(var45 < 100) {
                                    var44 = '\uff00' + 327685 * (var45 - 50);
                                 } else if(var45 < 150) {
                                    var44 = 16777215 - (var45 - 100) * 327680;
                                 }
                              }

                              if(Client.field405[var37] == 0) {
                                 NPC.field786.method3901(var43, var19 + Client.field410, Client.field411 + var20, var44, 0);
                              }

                              if(Client.field405[var37] == 1) {
                                 NPC.field786.method3972(var43, var19 + Client.field410, Client.field411 + var20, var44, 0, Client.field409);
                              }

                              if(Client.field405[var37] == 2) {
                                 NPC.field786.method3904(var43, var19 + Client.field410, var20 + Client.field411, var44, 0, Client.field409);
                              }

                              if(Client.field405[var37] == 3) {
                                 NPC.field786.method3922(var43, Client.field410 + var19, Client.field411 + var20, var44, 0, Client.field409, 150 - Client.field552[var37]);
                              }

                              if(Client.field405[var37] == 4) {
                                 var45 = (150 - Client.field552[var37]) * (NPC.field786.method3921(var43) + 100) / 150;
                                 Rasterizer2D.method4006(Client.field410 + var19 - 50, var20, 50 + Client.field410 + var19, var20 + var47);
                                 NPC.field786.method3898(var43, var19 + Client.field410 + 50 - var45, Client.field411 + var20, var44, 0);
                                 Rasterizer2D.method4031(var19, var20, var21 + var19, var47 + var20);
                              }

                              if(Client.field405[var37] == 5) {
                                 var45 = 150 - Client.field552[var37];
                                 int var46 = 0;
                                 if(var45 < 25) {
                                    var46 = var45 - 25;
                                 } else if(var45 > 125) {
                                    var46 = var45 - 125;
                                 }

                                 Rasterizer2D.method4006(var19, var20 + Client.field411 - NPC.field786.field3105 - 1, var21 + var19, 5 + Client.field411 + var20);
                                 NPC.field786.method3901(var43, var19 + Client.field410, var20 + Client.field411 + var46, var44, 0);
                                 Rasterizer2D.method4031(var19, var20, var21 + var19, var47 + var20);
                              }
                           } else {
                              NPC.field786.method3901(var43, var19 + Client.field410, var20 + Client.field411, 16776960, 0);
                           }
                        }

                        if(Client.field551 == 2) {
                           class176.method3278(Client.field329 + (Client.field326 - class5.baseX << 7), (Client.field520 - XClanMember.baseY << 7) + Client.field330, Client.field328 * 2);
                           if(Client.field410 > -1 && Client.gameCycle % 20 < 10) {
                              class177.field2672[0].method4173(Client.field410 + var19 - 12, Client.field411 + var20 - 28);
                           }
                        }

                        ((TextureProvider)class84.field1465).method1492(Client.field498);
                        if(Client.field415 == 1) {
                           XGrandExchangeOffer.field56[Client.field414 / 100].method4173(Client.field412 - 8, Client.field413 - 8);
                        }

                        if(Client.field415 == 2) {
                           XGrandExchangeOffer.field56[Client.field414 / 100 + 4].method4173(Client.field412 - 8, Client.field413 - 8);
                        }

                        class26.method612();
                        VertexNormal.cameraX = var49;
                        class36.cameraZ = var26;
                        class37.cameraY = var27;
                        Actor.cameraPitch = var52;
                        class26.cameraYaw = var29;
                        if(Client.field373) {
                           byte var70 = 0;
                           var34 = var70 + class185.field2752 + class185.field2763;
                           if(var34 == 0) {
                              Client.field373 = false;
                           }
                        }

                        if(Client.field373) {
                           Rasterizer2D.method4011(var19, var20, var21, var47, 0);
                           Ignore.method203("Loading - please wait.", false);
                        }

                        Client.field510[var10.boundsIndex] = true;
                        Rasterizer2D.method4031(var2, var3, var4, var5);
                        continue;
                     }

                     class164 var73;
                     if(var10.contentType == 1338) {
                        class7.method91();
                        var73 = var10.method3219(false);
                        if(null != var73) {
                           Rasterizer2D.method4031(var12, var13, var73.field2156 + var12, var13 + var73.field2157);
                           if(Client.field564 != 2 && Client.field564 != 5) {
                              var20 = Client.mapAngle + Client.mapScale & 2047;
                              var21 = 48 + class36.localPlayer.x / 32;
                              var47 = 464 - class36.localPlayer.y / 32;
                              class16.field183.method4222(var12, var13, var73.field2156, var73.field2157, var21, var47, var20, 256 + Client.mapScaleDelta, var73.field2155, var73.field2154);

                              for(var23 = 0; var23 < Client.field512; ++var23) {
                                 var24 = Client.field536[var23] * 4 + 2 - class36.localPlayer.x / 32;
                                 var49 = 2 + Client.field537[var23] * 4 - class36.localPlayer.y / 32;
                                 Tile.method1610(var12, var13, var24, var49, Client.field538[var23], var73);
                              }

                              var23 = 0;

                              while(true) {
                                 if(var23 >= 104) {
                                    for(var23 = 0; var23 < Client.field340; ++var23) {
                                       NPC var79 = Client.cachedNPCs[Client.field345[var23]];
                                       if(var79 != null && var79.vmethod803()) {
                                          NPCComposition var60 = var79.composition;
                                          if(var60 != null && null != var60.configs) {
                                             var60 = var60.method3735();
                                          }

                                          if(null != var60 && var60.isMinimapVisible && var60.field3035) {
                                             var26 = var79.x / 32 - class36.localPlayer.x / 32;
                                             var27 = var79.y / 32 - class36.localPlayer.y / 32;
                                             Tile.method1610(var12, var13, var26, var27, ScriptState.field131[1], var73);
                                          }
                                       }
                                    }

                                    var23 = class45.field921;
                                    int[] var80 = class45.field931;

                                    for(var49 = 0; var49 < var23; ++var49) {
                                       Player var53 = Client.cachedPlayers[var80[var49]];
                                       if(var53 != null && var53.vmethod803() && !var53.field276 && class36.localPlayer != var53) {
                                          var27 = var53.x / 32 - class36.localPlayer.x / 32;
                                          var52 = var53.y / 32 - class36.localPlayer.y / 32;
                                          boolean var68 = false;
                                          if(class15.method183(var53.name, true)) {
                                             var68 = true;
                                          }

                                          boolean var66 = false;

                                          for(var31 = 0; var31 < Player.clanChatCount; ++var31) {
                                             if(var53.name.equals(class72.clanMembers[var31].username)) {
                                                var66 = true;
                                                break;
                                             }
                                          }

                                          boolean var67 = false;
                                          if(class36.localPlayer.team != 0 && var53.team != 0 && var53.team == class36.localPlayer.team) {
                                             var67 = true;
                                          }

                                          if(var68) {
                                             Tile.method1610(var12, var13, var27, var52, ScriptState.field131[3], var73);
                                          } else if(var67) {
                                             Tile.method1610(var12, var13, var27, var52, ScriptState.field131[4], var73);
                                          } else if(var66) {
                                             Tile.method1610(var12, var13, var27, var52, ScriptState.field131[5], var73);
                                          } else {
                                             Tile.method1610(var12, var13, var27, var52, ScriptState.field131[2], var73);
                                          }
                                       }
                                    }

                                    if(Client.field551 != 0 && Client.gameCycle % 20 < 10) {
                                       if(Client.field551 == 1 && Client.field324 >= 0 && Client.field324 < Client.cachedNPCs.length) {
                                          NPC var61 = Client.cachedNPCs[Client.field324];
                                          if(null != var61) {
                                             var26 = var61.x / 32 - class36.localPlayer.x / 32;
                                             var27 = var61.y / 32 - class36.localPlayer.y / 32;
                                             class104.method2055(var12, var13, var26, var27, World.field709[1], var73);
                                          }
                                       }

                                       if(Client.field551 == 2) {
                                          var49 = 2 + (Client.field326 * 4 - class5.baseX * 4) - class36.localPlayer.x / 32;
                                          var26 = Client.field520 * 4 - XClanMember.baseY * 4 + 2 - class36.localPlayer.y / 32;
                                          class104.method2055(var12, var13, var49, var26, World.field709[1], var73);
                                       }

                                       if(Client.field551 == 10 && Client.field325 >= 0 && Client.field325 < Client.cachedPlayers.length) {
                                          Player var62 = Client.cachedPlayers[Client.field325];
                                          if(null != var62) {
                                             var26 = var62.x / 32 - class36.localPlayer.x / 32;
                                             var27 = var62.y / 32 - class36.localPlayer.y / 32;
                                             class104.method2055(var12, var13, var26, var27, World.field709[1], var73);
                                          }
                                       }
                                    }

                                    if(Client.flagX != 0) {
                                       var49 = 2 + Client.flagX * 4 - class36.localPlayer.x / 32;
                                       var26 = Client.flagY * 4 + 2 - class36.localPlayer.y / 32;
                                       Tile.method1610(var12, var13, var49, var26, World.field709[0], var73);
                                    }

                                    if(!class36.localPlayer.field276) {
                                       Rasterizer2D.method4011(var73.field2156 / 2 + var12 - 1, var73.field2157 / 2 + var13 - 1, 3, 3, 16777215);
                                    }
                                    break;
                                 }

                                 for(var24 = 0; var24 < 104; ++var24) {
                                    Deque var25 = Client.groundItemDeque[WallObject.plane][var23][var24];
                                    if(null != var25) {
                                       var26 = 2 + var23 * 4 - class36.localPlayer.x / 32;
                                       var27 = 4 * var24 + 2 - class36.localPlayer.y / 32;
                                       Tile.method1610(var12, var13, var26, var27, ScriptState.field131[0], var73);
                                    }
                                 }

                                 ++var23;
                              }
                           } else {
                              Rasterizer2D.method4060(var12, var13, 0, var73.field2155, var73.field2154);
                           }

                           Client.field426[var11] = true;
                        }

                        Rasterizer2D.method4031(var2, var3, var4, var5);
                        continue;
                     }

                     if(var10.contentType == 1339) {
                        var73 = var10.method3219(false);
                        if(null != var73) {
                           if(Client.field564 < 3) {
                              class189.field2795.method4222(var12, var13, var73.field2156, var73.field2157, 25, 25, Client.mapAngle, 256, var73.field2155, var73.field2154);
                           } else {
                              Rasterizer2D.method4060(var12, var13, 0, var73.field2155, var73.field2154);
                           }
                        }

                        Rasterizer2D.method4031(var2, var3, var4, var5);
                        continue;
                     }
                  }

                  if(var10.type == 0) {
                     if(!var10.hasScript && VertexNormal.method1683(var10) && class114.field1787 != var10) {
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
                     if(null != var10.children) {
                        gameDraw(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     WidgetNode var48 = (WidgetNode)Client.componentTable.method2399((long)var10.id);
                     if(var48 != null) {
                        Ignore.method204(var48.id, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.method4031(var2, var3, var4, var5);
                     class84.method1686();
                  }

                  if(Client.isResized || Client.field487[var11] || Client.field517 > 1) {
                     if(var10.type == 0 && !var10.hasScript && var10.scrollHeight > var10.height) {
                        var19 = var10.width + var12;
                        var20 = var10.scrollY;
                        var21 = var10.height;
                        var47 = var10.scrollHeight;
                        Player.field284[0].method4122(var19, var13);
                        Player.field284[1].method4122(var19, var21 + var13 - 16);
                        Rasterizer2D.method4011(var19, 16 + var13, 16, var21 - 32, Client.field335);
                        var23 = var21 * (var21 - 32) / var47;
                        if(var23 < 8) {
                           var23 = 8;
                        }

                        var24 = var20 * (var21 - 32 - var23) / (var47 - var21);
                        Rasterizer2D.method4011(var19, 16 + var13 + var24, 16, var23, Client.field383);
                        Rasterizer2D.method4021(var19, var24 + var13 + 16, var23, Client.field404);
                        Rasterizer2D.method4021(1 + var19, var24 + var13 + 16, var23, Client.field404);
                        Rasterizer2D.method4019(var19, var13 + 16 + var24, 16, Client.field404);
                        Rasterizer2D.method4019(var19, var13 + 17 + var24, 16, Client.field404);
                        Rasterizer2D.method4021(var19 + 15, var13 + 16 + var24, var23, Client.field376);
                        Rasterizer2D.method4021(var19 + 14, var24 + 17 + var13, var23 - 1, Client.field376);
                        Rasterizer2D.method4019(var19, var24 + var13 + 15 + var23, 16, Client.field376);
                        Rasterizer2D.method4019(var19 + 1, 14 + var13 + var24 + var23, 15, Client.field376);
                     }

                     if(var10.type != 1) {
                        if(var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.field2297; ++var20) {
                              for(var21 = 0; var21 < var10.originalWidth; ++var21) {
                                 var47 = var12 + (var10.field2339 + 32) * var21;
                                 var23 = var20 * (32 + var10.field2272) + var13;
                                 if(var19 < 20) {
                                    var47 += var10.field2273[var19];
                                    var23 += var10.field2258[var19];
                                 }

                                 if(var10.itemIds[var19] <= 0) {
                                    if(null != var10.field2275 && var19 < 20) {
                                       SpritePixels var78 = var10.method3245(var19);
                                       if(var78 != null) {
                                          var78.method4173(var47, var23);
                                       } else if(Widget.field2261) {
                                          class174.method3276(var10);
                                       }
                                    }
                                 } else {
                                    boolean var64 = false;
                                    boolean var76 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if(32 + var47 > var2 && var47 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class0.field7 && Client.field402 == var19) {
                                       SpritePixels var57;
                                       if(Client.field458 == 1 && class33.field770 == var19 && class99.field1645 == var10.id) {
                                          var57 = class180.createSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var57 = class180.createSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if(var57 != null) {
                                          if(var10 == class0.field7 && var19 == Client.field402) {
                                             var24 = class115.field1792 - Client.field359;
                                             var49 = class115.field1799 - Client.field399;
                                             if(var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if(var49 < 5 && var49 > -5) {
                                                var49 = 0;
                                             }

                                             if(Client.field423 < 5) {
                                                var24 = 0;
                                                var49 = 0;
                                             }

                                             var57.method4241(var47 + var24, var49 + var23, 128);
                                             if(var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                if(var23 + var49 < Rasterizer2D.field3191 && var28.scrollY > 0) {
                                                   var29 = Client.field498 * (Rasterizer2D.field3191 - var23 - var49) / 3;
                                                   if(var29 > Client.field498 * 10) {
                                                      var29 = Client.field498 * 10;
                                                   }

                                                   if(var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.field399 += var29;
                                                   class174.method3276(var28);
                                                }

                                                if(var23 + var49 + 32 > Rasterizer2D.field3192 && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (32 + var23 + var49 - Rasterizer2D.field3192) * Client.field498 / 3;
                                                   if(var29 > Client.field498 * 10) {
                                                      var29 = Client.field498 * 10;
                                                   }

                                                   if(var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.field399 -= var29;
                                                   class174.method3276(var28);
                                                }
                                             }
                                          } else if(var10 == class41.field843 && var19 == Client.field444) {
                                             var57.method4241(var47, var23, 128);
                                          } else {
                                             var57.method4173(var47, var23);
                                          }
                                       } else {
                                          class174.method3276(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if(var10.type == 3) {
                           if(class178.method3289(var10)) {
                              var19 = var10.field2313;
                              if(var10 == class114.field1787 && var10.field2321 != 0) {
                                 var19 = var10.field2321;
                              }
                           } else {
                              var19 = var10.textColor;
                              if(var10 == class114.field1787 && var10.field2249 != 0) {
                                 var19 = var10.field2249;
                              }
                           }

                           if(var10.field2234) {
                              switch(var10.field2235.field3201) {
                              case 1:
                                 Rasterizer2D.method4012(var12, var13, var10.width, var10.height, var10.textColor, var10.field2313, 256 - (var10.opacity & 255), 256 - (var10.field2237 & 255));
                                 break;
                              case 2:
                                 Rasterizer2D.method4013(var12, var13, var10.width, var10.height, var10.textColor, var10.field2313, 256 - (var10.opacity & 255), 256 - (var10.field2237 & 255));
                                 break;
                              case 3:
                                 Rasterizer2D.method4004(var12, var13, var10.width, var10.height, var10.textColor, var10.field2313, 256 - (var10.opacity & 255), 256 - (var10.field2237 & 255));
                                 break;
                              case 4:
                                 Rasterizer2D.method4041(var12, var13, var10.width, var10.height, var10.textColor, var10.field2313, 256 - (var10.opacity & 255), 256 - (var10.field2237 & 255));
                                 break;
                              default:
                                 if(var14 == 0) {
                                    Rasterizer2D.method4011(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.method4005(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if(var14 == 0) {
                              Rasterizer2D.method4017(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.method4018(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else {
                           Font var71;
                           if(var10.type == 4) {
                              var71 = var10.method3250();
                              if(null == var71) {
                                 if(Widget.field2261) {
                                    class174.method3276(var10);
                                 }
                              } else {
                                 String var77 = var10.text;
                                 if(class178.method3289(var10)) {
                                    var20 = var10.field2313;
                                    if(var10 == class114.field1787 && var10.field2321 != 0) {
                                       var20 = var10.field2321;
                                    }

                                    if(var10.field2221.length() > 0) {
                                       var77 = var10.field2221;
                                    }
                                 } else {
                                    var20 = var10.textColor;
                                    if(var10 == class114.field1787 && var10.field2249 != 0) {
                                       var20 = var10.field2249;
                                    }
                                 }

                                 if(var10.hasScript && var10.item != -1) {
                                    ItemComposition var59 = class103.getItemDefinition(var10.item);
                                    var77 = var59.name;
                                    if(var77 == null) {
                                       var77 = "null";
                                    }

                                    if((var59.isStackable == 1 || var10.stackSize != 1) && var10.stackSize != -1) {
                                       var77 = class18.method199(16748608) + var77 + "</col>" + " " + 'x' + class185.method3423(var10.stackSize);
                                    }
                                 }

                                 if(Client.field469 == var10) {
                                    Object var10000 = null;
                                    var77 = "Please wait...";
                                    var20 = var10.textColor;
                                 }

                                 if(!var10.hasScript) {
                                    var77 = class149.method2800(var77, var10);
                                 }

                                 var71.method3902(var77, var12, var13, var10.width, var10.height, var20, var10.field2270?0:-1, var10.field2268, var10.field2269, var10.field2267);
                              }
                           } else if(var10.type == 5) {
                              SpritePixels var72;
                              if(!var10.hasScript) {
                                 var72 = var10.method3215(class178.method3289(var10));
                                 if(null != var72) {
                                    var72.method4173(var12, var13);
                                 } else if(Widget.field2261) {
                                    class174.method3276(var10);
                                 }
                              } else {
                                 if(var10.item != -1) {
                                    var72 = class180.createSprite(var10.item, var10.stackSize, var10.borderThickness, var10.sprite2, var10.field2263, false);
                                 } else {
                                    var72 = var10.method3215(false);
                                 }

                                 if(null == var72) {
                                    if(Widget.field2261) {
                                       class174.method3276(var10);
                                    }
                                 } else {
                                    var20 = var72.maxWidth;
                                    var21 = var72.maxHeight;
                                    if(!var10.field2243) {
                                       var47 = var10.width * 4096 / var20;
                                       if(var10.field2242 != 0) {
                                          var72.method4184(var10.width / 2 + var12, var10.height / 2 + var13, var10.field2242, var47);
                                       } else if(var14 != 0) {
                                          var72.method4189(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if(var10.width == var20 && var10.height == var21) {
                                          var72.method4173(var12, var13);
                                       } else {
                                          var72.method4175(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.method4006(var12, var13, var10.width + var12, var10.height + var13);
                                       var47 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var47; ++var24) {
                                          for(var49 = 0; var49 < var23; ++var49) {
                                             if(var10.field2242 != 0) {
                                                var72.method4184(var24 * var20 + var12 + var20 / 2, var13 + var49 * var21 + var21 / 2, var10.field2242, 4096);
                                             } else if(var14 != 0) {
                                                var72.method4241(var12 + var24 * var20, var21 * var49 + var13, 256 - (var14 & 255));
                                             } else {
                                                var72.method4173(var24 * var20 + var12, var13 + var49 * var21);
                                             }
                                          }
                                       }

                                       Rasterizer2D.method4031(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var56;
                              if(var10.type == 6) {
                                 boolean var58 = class178.method3289(var10);
                                 if(var58) {
                                    var20 = var10.field2253;
                                 } else {
                                    var20 = var10.field2230;
                                 }

                                 Model var74 = null;
                                 var47 = 0;
                                 if(var10.item != -1) {
                                    var56 = class103.getItemDefinition(var10.item);
                                    if(var56 != null) {
                                       var56 = var56.method3672(var10.stackSize);
                                       var74 = var56.getModel(1);
                                       if(var74 != null) {
                                          var74.method1647();
                                          var47 = var74.modelHeight / 2;
                                       } else {
                                          class174.method3276(var10);
                                       }
                                    }
                                 } else if(var10.modelType == 5) {
                                    if(var10.modelId == 0) {
                                       var74 = Client.field432.method3189((Sequence)null, -1, (Sequence)null, -1);
                                    } else {
                                       var74 = class36.localPlayer.getModel();
                                    }
                                 } else if(var20 == -1) {
                                    var74 = var10.method3218((Sequence)null, -1, var58, class36.localPlayer.composition);
                                    if(null == var74 && Widget.field2261) {
                                       class174.method3276(var10);
                                    }
                                 } else {
                                    Sequence var83 = class195.getAnimation(var20);
                                    var74 = var10.method3218(var83, var10.field2327, var58, class36.localPlayer.composition);
                                    if(var74 == null && Widget.field2261) {
                                       class174.method3276(var10);
                                    }
                                 }

                                 class84.method1712(var12 + var10.width / 2, var13 + var10.height / 2);
                                 var23 = var10.field2259 * class84.field1468[var10.rotationX] >> 16;
                                 var24 = class84.field1462[var10.rotationX] * var10.field2259 >> 16;
                                 if(var74 != null) {
                                    if(!var10.hasScript) {
                                       var74.method1629(0, var10.rotationZ, 0, var10.rotationX, 0, var23, var24);
                                    } else {
                                       var74.method1647();
                                       if(var10.field2262) {
                                          var74.method1630(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2254, var47 + var23 + var10.field2255, var24 + var10.field2255, var10.field2259);
                                       } else {
                                          var74.method1629(0, var10.rotationZ, var10.rotationY, var10.rotationX, var10.field2254, var47 + var23 + var10.field2255, var24 + var10.field2255);
                                       }
                                    }
                                 }

                                 class84.method1688();
                              } else {
                                 if(var10.type == 7) {
                                    var71 = var10.method3250();
                                    if(var71 == null) {
                                       if(Widget.field2261) {
                                          class174.method3276(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.field2297; ++var21) {
                                       for(var47 = 0; var47 < var10.originalWidth; ++var47) {
                                          if(var10.itemIds[var20] > 0) {
                                             var56 = class103.getItemDefinition(var10.itemIds[var20] - 1);
                                             String var51;
                                             if(var56.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var51 = class18.method199(16748608) + var56.name + "</col>";
                                             } else {
                                                var51 = class18.method199(16748608) + var56.name + "</col>" + " " + 'x' + class185.method3423(var10.itemQuantities[var20]);
                                             }

                                             var49 = (115 + var10.field2339) * var47 + var12;
                                             var26 = var21 * (var10.field2272 + 12) + var13;
                                             if(var10.field2268 == 0) {
                                                var71.method3898(var51, var49, var26, var10.textColor, var10.field2270?0:-1);
                                             } else if(var10.field2268 == 1) {
                                                var71.method3901(var51, var49 + var10.width / 2, var26, var10.textColor, var10.field2270?0:-1);
                                             } else {
                                                var71.method3900(var51, var49 + var10.width - 1, var26, var10.textColor, var10.field2270?0:-1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 if(var10.type == 8 && var10 == class171.field2344 && Client.field299 == Client.field584) {
                                    var19 = 0;
                                    var20 = 0;
                                    Font var50 = class175.field2651;
                                    String var22 = var10.text;

                                    String var82;
                                    for(var22 = class149.method2800(var22, var10); var22.length() > 0; var20 += var50.field3105 + 1) {
                                       var24 = var22.indexOf("<br>");
                                       if(var24 != -1) {
                                          var82 = var22.substring(0, var24);
                                          var22 = var22.substring(var24 + 4);
                                       } else {
                                          var82 = var22;
                                          var22 = "";
                                       }

                                       var49 = var50.method3921(var82);
                                       if(var49 > var19) {
                                          var19 = var49;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var10.width + var12 - 5 - var19;
                                    var49 = 5 + var13 + var10.height;
                                    if(var24 < 5 + var12) {
                                       var24 = var12 + 5;
                                    }

                                    if(var19 + var24 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if(var20 + var49 > var5) {
                                       var49 = var5 - var20;
                                    }

                                    Rasterizer2D.method4011(var24, var49, var19, var20, 16777120);
                                    Rasterizer2D.method4017(var24, var49, var19, var20, 0);
                                    var22 = var10.text;
                                    var26 = var50.field3105 + var49 + 2;

                                    for(var22 = class149.method2800(var22, var10); var22.length() > 0; var26 += 1 + var50.field3105) {
                                       var27 = var22.indexOf("<br>");
                                       if(var27 != -1) {
                                          var82 = var22.substring(0, var27);
                                          var22 = var22.substring(var27 + 4);
                                       } else {
                                          var82 = var22;
                                          var22 = "";
                                       }

                                       var50.method3898(var82, 3 + var24, var26, 0, -1);
                                    }
                                 }

                                 if(var10.type == 9) {
                                    if(var10.field2289 == 1) {
                                       if(var10.field2239) {
                                          var19 = var12;
                                          var20 = var13 + var10.height;
                                          var21 = var12 + var10.width;
                                          var47 = var13;
                                       } else {
                                          var19 = var12;
                                          var20 = var13;
                                          var21 = var12 + var10.width;
                                          var47 = var13 + var10.height;
                                       }

                                       Rasterizer2D.method4023(var19, var20, var21, var47, var10.textColor);
                                    } else {
                                       var19 = var10.width >= 0?var10.width:-var10.width;
                                       var20 = var10.height >= 0?var10.height:-var10.height;
                                       var21 = var19;
                                       if(var19 < var20) {
                                          var21 = var20;
                                       }

                                       if(var21 != 0) {
                                          var47 = (var10.width << 16) / var21;
                                          var23 = (var10.height << 16) / var21;
                                          if(var23 <= var47) {
                                             var47 = -var47;
                                          } else {
                                             var23 = -var23;
                                          }

                                          var24 = var10.field2289 * var23 >> 17;
                                          var49 = var23 * var10.field2289 + 1 >> 17;
                                          var26 = var10.field2289 * var47 >> 17;
                                          var27 = 1 + var47 * var10.field2289 >> 17;
                                          var52 = var12 + var24;
                                          var29 = var12 - var49;
                                          var30 = var10.width + var12 - var49;
                                          var31 = var12 + var10.width + var24;
                                          var32 = var13 + var26;
                                          int var33 = var13 - var27;
                                          var34 = var13 + var10.height - var27;
                                          var35 = var26 + var10.height + var13;
                                          class84.setRasterClippingEnabled(var52, var29, var30);
                                          class84.rasterFlat(var32, var33, var34, var52, var29, var30, var10.textColor);
                                          class84.setRasterClippingEnabled(var52, var30, var31);
                                          class84.rasterFlat(var32, var34, var35, var52, var30, var31, var10.textColor);
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass186;",
      garbageValue = "-1428609346"
   )
   public static class186 method3389(int var0) {
      class186 var1 = (class186)class186.field2770.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class186.field2772.getConfigData(5, var0);
         var1 = new class186();
         if(var2 != null) {
            var1.method3432(new Buffer(var2));
         }

         class186.field2770.put(var1, (long)var0);
         return var1;
      }
   }
}
