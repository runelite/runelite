import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class23 {
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -321630203
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("ch")
   @Export("indexModels")
   static IndexData indexModels;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;I)V",
      garbageValue = "2044695309"
   )
   static final void method191(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class61.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class61.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method3019(var3, var4);
                  }
               }
            }
         }
      }

      class61.field750 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field750 < -8) {
         class61.field750 = -8;
      }

      if(class61.field750 > 8) {
         class61.field750 = 8;
      }

      class61.field735 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field735 < -16) {
         class61.field735 = -16;
      }

      if(class61.field735 > 16) {
         class61.field735 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = class10.field261[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class61.tileHeights[var2][var12 + 1][var11] - class61.tileHeights[var2][var12 - 1][var11];
               var14 = class61.tileHeights[var2][var12][var11 + 1] - class61.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var14 * var14 + var13 * var13 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var16 * -50 + var17 * -10 + var18 * -50) / var10 + 96;
               var20 = (var42[var12][var11] >> 1) + (var42[var12 - 1][var11] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11 - 1] >> 2) + (var42[var12][var11 + 1] >> 3);
               class61.field740[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class157.field2263[var11] = 0;
            class61.field741[var11] = 0;
            class61.field742[var11] = 0;
            class43.field569[var11] = 0;
            class61.field743[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class234.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = class162.method3053(var14 - 1);
                     class157.field2263[var12] += var43.field3346;
                     class61.field741[var12] += var43.field3347;
                     class61.field742[var12] += var43.field3348;
                     class43.field569[var12] += var43.field3349;
                     ++class61.field743[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class234.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = class162.method3053(var15 - 1);
                     class157.field2263[var12] -= var44.field3346;
                     class61.field741[var12] -= var44.field3347;
                     class61.field742[var12] -= var44.field3348;
                     class43.field569[var12] -= var44.field3349;
                     --class61.field743[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class157.field2263[var18];
                     var13 += class61.field741[var18];
                     var14 += class61.field742[var18];
                     var15 += class43.field569[var18];
                     var16 += class61.field743[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class157.field2263[var19];
                     var13 -= class61.field741[var19];
                     var14 -= class61.field742[var19];
                     var15 -= class43.field569[var19];
                     var16 -= class61.field743[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field918 || (class61.tileSettings[0][var11][var17] & 2) != 0 || (class61.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class61.field737) {
                        class61.field737 = var2;
                     }

                     var20 = class234.underlayIds[var2][var11][var17] & 255;
                     int var21 = class61.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class61.tileHeights[var2][var11][var17];
                        int var23 = class61.tileHeights[var2][var11 + 1][var17];
                        int var24 = class61.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class61.tileHeights[var2][var11][var17 + 1];
                        int var26 = class61.field740[var11][var17];
                        int var27 = class61.field740[var11 + 1][var17];
                        int var28 = class61.field740[var11 + 1][var17 + 1];
                        int var29 = class61.field740[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class73.method1091(var32, var33, var34);
                           var32 = var32 + class61.field750 & 255;
                           var34 += class61.field735;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class73.method1091(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var46 = true;
                           if(var20 == 0 && class21.overlayPaths[var2][var11][var17] != 0) {
                              var46 = false;
                           }

                           if(var21 > 0 && !class5.method17(var21 - 1).isHidden) {
                              var46 = false;
                           }

                           if(var46 && var23 == var22 && var24 == var22 && var25 == var22) {
                              class51.field643[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class136.colorPalette[class15.method114(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method2680(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class15.method114(var30, var26), class15.method114(var30, var27), class15.method114(var30, var28), class15.method114(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class21.overlayPaths[var2][var11][var17] + 1;
                           byte var47 = class61.overlayRotations[var2][var11][var17];
                           Overlay var35 = class5.method17(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class136.field2039.vmethod2887(var36);
                              var37 = -1;
                           } else if(var35.color == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class73.method1091(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class61.field750 & 255;
                              var40 = class61.field735 + var35.lightness;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class73.method1091(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class136.colorPalette[class46.method664(var38, 96)];
                           }

                           if(var35.field3600 != -1) {
                              var40 = var35.field3604 + class61.field750 & 255;
                              int var41 = class61.field735 + var35.field3606;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class73.method1091(var40, var35.field3605, var41);
                              var39 = class136.colorPalette[class46.method664(var38, 96)];
                           }

                           var0.method2680(var2, var11, var17, var33, var47, var36, var22, var23, var24, var25, class15.method114(var30, var26), class15.method114(var30, var27), class15.method114(var30, var28), class15.method114(var30, var29), class46.method664(var37, var26), class46.method664(var37, var27), class46.method664(var37, var28), class46.method664(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.method2679(var2, var12, var11, class31.method287(var2, var12, var11));
            }
         }

         class234.underlayIds[var2] = null;
         class61.overlayIds[var2] = null;
         class21.overlayPaths[var2] = null;
         class61.overlayRotations[var2] = null;
         class10.field261[var2] = null;
      }

      var0.method2706(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class61.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method2677(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if(var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var45;
                  if((class51.field643[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class51.field643[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class51.field643[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label511:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class51.field643[var11 - 1][var8][var13] & var2) == 0) {
                              break label511;
                           }
                        }

                        --var11;
                     }

                     label500:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class51.field643[var12 + 1][var8][var13] & var2) == 0) {
                              break label500;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var8][var9] - var45;
                        var16 = class61.tileHeights[var11][var8][var9];
                        Region.method2715(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class51.field643[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class51.field643[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class51.field643[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class51.field643[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label564:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class51.field643[var11 - 1][var13][var7] & var3) == 0) {
                              break label564;
                           }
                        }

                        --var11;
                     }

                     label553:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class51.field643[var12 + 1][var13][var7] & var3) == 0) {
                              break label553;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var9][var7] - var45;
                        var16 = class61.tileHeights[var11][var9][var7];
                        Region.method2715(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class51.field643[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class51.field643[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class51.field643[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class51.field643[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label617:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class51.field643[var6][var9 - 1][var13] & var4) == 0) {
                              break label617;
                           }
                        }

                        --var9;
                     }

                     label606:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class51.field643[var6][var10 + 1][var13] & var4) == 0) {
                              break label606;
                           }
                        }

                        ++var10;
                     }

                     if((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
                        var13 = class61.tileHeights[var6][var9][var11];
                        Region.method2715(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class51.field643[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-120061598"
   )
   static void method192(int var0, int var1) {
      class89 var2 = class91.field1409;
      class34.menuAction(var2.field1402, var2.field1397, var2.field1398, var2.field1401, var2.field1400, var2.field1400, var0, var1);
      class91.field1409 = null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)LWorld;",
      garbageValue = "-12"
   )
   static World method193() {
      World.field1311 = 0;
      World var0;
      if(World.field1311 < World.field1297) {
         var0 = World.worldList[++World.field1311 - 1];
      } else {
         var0 = null;
      }

      return var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-1995716730"
   )
   static final void method194(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field918 || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field737) {
            class61.field737 = var0;
         }

         ObjectComposition var8 = class61.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.sizeX;
            var10 = var8.sizeY;
         } else {
            var9 = var8.sizeY;
            var10 = var8.sizeX;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = var1 + (var9 + 1 >> 1);
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var2 + var10 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = (var10 + 1 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class61.tileHeights[var0];
         int var16 = var15[var11][var13] + var15[var12][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = var1 + (var2 << 7) + (var3 << 14) + 1073741824;
         if(var8.field3464 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field3482 == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method4551()) {
            class82 var21 = new class82();
            var21.field1323 = var0;
            var21.field1322 = var1 * 128;
            var21.field1326 = var2 * 128;
            var22 = var8.sizeX;
            var23 = var8.sizeY;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.sizeY;
               var23 = var8.sizeX;
            }

            var21.field1327 = (var22 + var1) * 128;
            var21.field1334 = (var2 + var23) * 128;
            var21.field1329 = var8.ambientSoundId;
            var21.field1328 = var8.field3487 * 128;
            var21.field1331 = var8.field3488;
            var21.field1332 = var8.field3489;
            var21.field1333 = var8.field3479;
            if(var8.impostorIds != null) {
               var21.field1336 = var8;
               var21.method1576();
            }

            class82.field1325.method3634(var21);
            if(var21.field1333 != null) {
               var21.field1324 = var21.field1331 + (int)(Math.random() * (double)(var21.field1332 - var21.field1331));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.field918 || var8.field3464 != 0 || var8.field3459 == 1 || var8.field3476) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method4562(22, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var30, var19, var20);
               if(var8.field3459 == 1 && var7 != null) {
                  var7.method3037(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method4562(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method2685(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class51.field643[var0][var1][var2] |= 2340;
               }

               if(var8.field3459 != 0 && var7 != null) {
                  var7.method3018(var1, var2, var9, var10, var8.field3460);
               }

            } else if(var5 == 0) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method4562(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method2683(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field744[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.field3456) {
                     class10.field261[var0][var1][var2] = 50;
                     class10.field261[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.clipped) {
                     class51.field643[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.field3456) {
                     class10.field261[var0][var1][var2 + 1] = 50;
                     class10.field261[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.clipped) {
                     class51.field643[var0][var1][var2 + 1] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.field3456) {
                     class10.field261[var0][var1 + 1][var2] = 50;
                     class10.field261[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.clipped) {
                     class51.field643[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.field3456) {
                     class10.field261[var0][var1][var2] = 50;
                     class10.field261[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.clipped) {
                     class51.field643[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.field3459 != 0 && var7 != null) {
                  var7.method3020(var1, var2, var5, var4, var8.field3460);
               }

               if(var8.field3466 != 16) {
                  var6.method2850(var0, var1, var2, var8.field3466);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.method4562(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method2683(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field745[var4], 0, var19, var20);
               if(var8.field3456) {
                  if(var4 == 0) {
                     class10.field261[var0][var1][var2 + 1] = 50;
                  } else if(var4 == 1) {
                     class10.field261[var0][var1 + 1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class10.field261[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class10.field261[var0][var1][var2] = 50;
                  }
               }

               if(var8.field3459 != 0 && var7 != null) {
                  var7.method3020(var1, var2, var5, var4, var8.field3460);
               }

            } else {
               int var26;
               Object var27;
               if(var5 == 2) {
                  var26 = var4 + 1 & 3;
                  Object var28;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.method4562(2, var4 + 4, var15, var17, var16, var18);
                     var27 = var8.method4562(2, var26, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var27 = new DynamicObject(var3, 2, var26, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2683(var0, var1, var2, var16, (Renderable)var28, (Renderable)var27, class61.field744[var4], class61.field744[var26], var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class51.field643[var0][var1][var2] |= 585;
                        class51.field643[var0][var1][var2 + 1] |= 1170;
                     } else if(var4 == 1) {
                        class51.field643[var0][var1][var2 + 1] |= 1170;
                        class51.field643[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class51.field643[var0][var1 + 1][var2] |= 585;
                        class51.field643[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class51.field643[var0][var1][var2] |= 1170;
                        class51.field643[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.field3459 != 0 && var7 != null) {
                     var7.method3020(var1, var2, var5, var4, var8.field3460);
                  }

                  if(var8.field3466 != 16) {
                     var6.method2850(var0, var1, var2, var8.field3466);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method4562(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2683(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field745[var4], 0, var19, var20);
                  if(var8.field3456) {
                     if(var4 == 0) {
                        class10.field261[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class10.field261[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class10.field261[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class10.field261[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field3459 != 0 && var7 != null) {
                     var7.method3020(var1, var2, var5, var4, var8.field3460);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method4562(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2685(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.field3459 != 0 && var7 != null) {
                     var7.method3018(var1, var2, var9, var10, var8.field3460);
                  }

                  if(var8.field3466 != 16) {
                     var6.method2850(var0, var1, var2, var8.field3466);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method4562(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2684(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class61.field744[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var26 = 16;
                  var22 = var6.method2701(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = class61.getObjectDefinition(var22 >> 14 & 32767).field3466;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var27 = var8.method4562(4, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2684(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class61.field744[var4], 0, var26 * class61.field746[var4], class61.field752[var4] * var26, var19, var20);
               } else if(var5 == 6) {
                  var26 = 8;
                  var22 = var6.method2701(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = class61.getObjectDefinition(var22 >> 14 & 32767).field3466 / 2;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var27 = var8.method4562(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var27 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2684(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, 256, var4, var26 * class61.field738[var4], var26 * class61.field749[var4], var19, var20);
               } else if(var5 == 7) {
                  var22 = var4 + 2 & 3;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.method4562(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2684(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var26 = 8;
                  var22 = var6.method2701(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = class61.getObjectDefinition(var22 >> 14 & 32767).field3466 / 2;
                  }

                  int var25 = var4 + 2 & 3;
                  Object var29;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var27 = var8.method4562(4, var4 + 4, var15, var17, var16, var18);
                     var29 = var8.method4562(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var27 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var29 = new DynamicObject(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2684(var0, var1, var2, var16, (Renderable)var27, (Renderable)var29, 256, var4, var26 * class61.field738[var4], class61.field749[var4] * var26, var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.method4562(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(var30 != null && var6.method2685(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.field3456) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method2517() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class10.field261[var0][var1 + var23][var2 + var24]) {
                        class10.field261[var0][var1 + var23][var24 + var2] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.field3459 != 0 && var7 != null) {
               var7.method3018(var1, var2, var9, var10, var8.field3460);
            }

         }
      }
   }
}
