import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1186740837
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1140641629
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1635046961
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1682092439
   )
   int field1559;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -885421701
   )
   int field1560 = 0;
   @ObfuscatedName("u")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 290186863
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("h")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("bi")
   @Export("host")
   static String host;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 839604869
   )
   int field1567;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIILclass119;LCollisionData;Z[I[IS)I",
      garbageValue = "23375"
   )
   public static int method1950(int var0, int var1, int var2, class119 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class118.field1852[var8][var9] = 0;
            class118.field1849[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var13;
      int var14;
      int var15;
      int var17;
      int var19;
      int var20;
      int var21;
      boolean var28;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var28 = class16.method204(var0, var1, var3, var4);
      } else if(var2 == 2) {
         var10 = var0;
         var11 = var1;
         byte var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class118.field1852[var12][var13] = 99;
         class118.field1849[var12][var13] = 0;
         byte var16 = 0;
         var17 = 0;
         class118.field1846[var16] = var0;
         var33 = var16 + 1;
         class118.field1853[var16] = var1;
         int[][] var27 = var4.flags;

         boolean var29;
         while(true) {
            if(var17 == var33) {
               class118.field1850 = var10;
               class180.field2689 = var11;
               var29 = false;
               break;
            }

            var10 = class118.field1846[var17];
            var11 = class118.field1853[var17];
            var17 = 1 + var17 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod2329(2, var10, var11, var4)) {
               class118.field1850 = var10;
               class180.field2689 = var11;
               var29 = true;
               break;
            }

            var21 = class118.field1849[var30][var31] + 1;
            if(var30 > 0 && class118.field1852[var30 - 1][var31] == 0 && (var27[var19 - 1][var20] & 19136782) == 0 && (var27[var19 - 1][1 + var20] & 19136824) == 0) {
               class118.field1846[var33] = var10 - 1;
               class118.field1853[var33] = var11;
               var33 = 1 + var33 & 4095;
               class118.field1852[var30 - 1][var31] = 2;
               class118.field1849[var30 - 1][var31] = var21;
            }

            if(var30 < 126 && class118.field1852[var30 + 1][var31] == 0 && (var27[var19 + 2][var20] & 19136899) == 0 && (var27[var19 + 2][1 + var20] & 19136992) == 0) {
               class118.field1846[var33] = 1 + var10;
               class118.field1853[var33] = var11;
               var33 = 1 + var33 & 4095;
               class118.field1852[var30 + 1][var31] = 8;
               class118.field1849[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class118.field1852[var30][var31 - 1] == 0 && (var27[var19][var20 - 1] & 19136782) == 0 && (var27[var19 + 1][var20 - 1] & 19136899) == 0) {
               class118.field1846[var33] = var10;
               class118.field1853[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class118.field1852[var30][var31 - 1] = 1;
               class118.field1849[var30][var31 - 1] = var21;
            }

            if(var31 < 126 && class118.field1852[var30][var31 + 1] == 0 && (var27[var19][var20 + 2] & 19136824) == 0 && (var27[1 + var19][2 + var20] & 19136992) == 0) {
               class118.field1846[var33] = var10;
               class118.field1853[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class118.field1852[var30][1 + var31] = 4;
               class118.field1849[var30][1 + var31] = var21;
            }

            if(var30 > 0 && var31 > 0 && class118.field1852[var30 - 1][var31 - 1] == 0 && (var27[var19 - 1][var20] & 19136830) == 0 && (var27[var19 - 1][var20 - 1] & 19136782) == 0 && (var27[var19][var20 - 1] & 19136911) == 0) {
               class118.field1846[var33] = var10 - 1;
               class118.field1853[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1852[var30 - 1][var31 - 1] = 3;
               class118.field1849[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 126 && var31 > 0 && class118.field1852[var30 + 1][var31 - 1] == 0 && (var27[1 + var19][var20 - 1] & 19136911) == 0 && (var27[2 + var19][var20 - 1] & 19136899) == 0 && (var27[var19 + 2][var20] & 19136995) == 0) {
               class118.field1846[var33] = var10 + 1;
               class118.field1853[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1852[var30 + 1][var31 - 1] = 9;
               class118.field1849[1 + var30][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 126 && class118.field1852[var30 - 1][var31 + 1] == 0 && (var27[var19 - 1][var20 + 1] & 19136830) == 0 && (var27[var19 - 1][2 + var20] & 19136824) == 0 && (var27[var19][var20 + 2] & 19137016) == 0) {
               class118.field1846[var33] = var10 - 1;
               class118.field1853[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class118.field1852[var30 - 1][var31 + 1] = 6;
               class118.field1849[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 126 && var31 < 126 && class118.field1852[1 + var30][var31 + 1] == 0 && (var27[1 + var19][2 + var20] & 19137016) == 0 && (var27[2 + var19][2 + var20] & 19136992) == 0 && (var27[2 + var19][1 + var20] & 19136995) == 0) {
               class118.field1846[var33] = 1 + var10;
               class118.field1853[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class118.field1852[var30 + 1][1 + var31] = 12;
               class118.field1849[1 + var30][1 + var31] = var21;
            }
         }

         var28 = var29;
      } else {
         var28 = class143.method2747(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class118.field1850;
      var30 = class180.field2689;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field1859;
         var17 = var3.field1858;
         int var18 = var3.field1860;
         var19 = var3.field1861;

         for(var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class118.field1849[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var18 + var33 - 1) {
                     var24 = var20 - (var33 + var18 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var19 + var17 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var31 == var26 && class118.field1849[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class118.field1849[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var11 == var0 && var1 == var30) {
         return 0;
      } else {
         var13 = 0;
         class118.field1846[var13] = var11;
         var31 = var13 + 1;
         class118.field1853[var13] = var30;

         for(var14 = var15 = class118.field1852[var11 - var9][var30 - var10]; var0 != var11 || var1 != var30; var14 = class118.field1852[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class118.field1846[var31] = var11;
               class118.field1853[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class118.field1846[var31];
            var7[var33++] = class118.field1853[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;I)V",
      garbageValue = "1653637519"
   )
   static final void method1951(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class10.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class10.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2303(var3, var4);
                  }
               }
            }
         }
      }

      class10.field105 += (int)(Math.random() * 5.0D) - 2;
      if(class10.field105 < -8) {
         class10.field105 = -8;
      }

      if(class10.field105 > 8) {
         class10.field105 = 8;
      }

      class10.field121 += (int)(Math.random() * 5.0D) - 2;
      if(class10.field121 < -16) {
         class10.field121 = -16;
      }

      if(class10.field121 > 16) {
         class10.field121 = 16;
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
         byte[][] var42 = class10.field111[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class10.tileHeights[var2][1 + var12][var11] - class10.tileHeights[var2][var12 - 1][var11];
               var14 = class10.tileHeights[var2][var12][1 + var11] - class10.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var14 * var14 + 65536 + var13 * var13));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (-50 * var18 + -10 * var17 + var16 * -50) / var10 + 96;
               var20 = (var42[var12][var11] >> 1) + (var42[var12][var11 - 1] >> 2) + (var42[1 + var12][var11] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12][1 + var11] >> 3);
               class10.field112[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class10.field119[var11] = 0;
            class195.field2860[var11] = 0;
            Frames.field1582[var11] = 0;
            class6.field67[var11] = 0;
            class10.field106[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = 5 + var11;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class10.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var44 = class22.method239(var14 - 1);
                     class10.field119[var12] += var44.field2810;
                     class195.field2860[var12] += var44.field2805;
                     Frames.field1582[var12] += var44.field2804;
                     class6.field67[var12] += var44.field2807;
                     ++class10.field106[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class10.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var43 = class22.method239(var15 - 1);
                     class10.field119[var12] -= var43.field2810;
                     class195.field2860[var12] -= var43.field2805;
                     Frames.field1582[var12] -= var43.field2804;
                     class6.field67[var12] -= var43.field2807;
                     --class10.field106[var12];
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
                  var18 = 5 + var17;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class10.field119[var18];
                     var13 += class195.field2860[var18];
                     var14 += Frames.field1582[var18];
                     var15 += class6.field67[var18];
                     var16 += class10.field106[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class10.field119[var19];
                     var13 -= class195.field2860[var19];
                     var14 -= Frames.field1582[var19];
                     var15 -= class6.field67[var19];
                     var16 -= class10.field106[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field439 || (class10.tileSettings[0][var11][var17] & 2) != 0 || (class10.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class10.field107) {
                        class10.field107 = var2;
                     }

                     var20 = class10.underlayIds[var2][var11][var17] & 255;
                     int var21 = class10.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class10.tileHeights[var2][var11][var17];
                        int var23 = class10.tileHeights[var2][1 + var11][var17];
                        int var24 = class10.tileHeights[var2][1 + var11][1 + var17];
                        int var25 = class10.tileHeights[var2][var11][1 + var17];
                        int var26 = class10.field112[var11][var17];
                        int var27 = class10.field112[1 + var11][var17];
                        int var28 = class10.field112[var11 + 1][var17 + 1];
                        int var29 = class10.field112[var11][1 + var17];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = 256 * var12 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class162.method3122(var32, var33, var34);
                           var32 = class10.field105 + var32 & 255;
                           var34 += class10.field121;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class162.method3122(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var47 = true;
                           if(var20 == 0 && class10.overlayPaths[var2][var11][var17] != 0) {
                              var47 = false;
                           }

                           if(var21 > 0 && !class142.method2711(var21 - 1).isHidden) {
                              var47 = false;
                           }

                           if(var47 && var23 == var22 && var24 == var22 && var25 == var22) {
                              XClanMember.field300[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class84.colorPalette[World.method672(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method1759(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, World.method672(var30, var26), World.method672(var30, var27), World.method672(var30, var28), World.method672(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class10.overlayPaths[var2][var11][var17] + 1;
                           byte var48 = class172.overlayRotations[var2][var11][var17];
                           Overlay var35 = class142.method2711(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class84.field1458.vmethod1965(var36);
                              var37 = -1;
                           } else if(var35.color == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class162.method3122(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class10.field105 & 255;
                              var40 = class10.field121 + var35.lightness;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class162.method3122(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class84.colorPalette[Actor.method622(var38, 96)];
                           }

                           if(var35.field3045 != -1) {
                              var40 = class10.field105 + var35.field3049 & 255;
                              int var41 = class10.field121 + var35.field3041;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class162.method3122(var40, var35.field3051, var41);
                              var39 = class84.colorPalette[Actor.method622(var38, 96)];
                           }

                           var0.method1759(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, World.method672(var30, var26), World.method672(var30, var27), World.method672(var30, var28), World.method672(var30, var29), Actor.method622(var37, var26), Actor.method622(var37, var27), Actor.method622(var37, var28), Actor.method622(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((class10.tileSettings[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && (class10.tileSettings[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.method1758(var2, var12, var11, var17);
            }
         }

         class10.underlayIds[var2] = null;
         class10.overlayIds[var2] = null;
         class10.overlayPaths[var2] = null;
         class172.overlayRotations[var2] = null;
         class10.field111[var2] = null;
      }

      var0.method1796(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class10.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method1780(var2, var3);
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
                  short var46;
                  if((XClanMember.field300[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (XClanMember.field300[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (XClanMember.field300[var6][var8][1 + var10] & var2) != 0) {
                        ++var10;
                     }

                     label523:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((XClanMember.field300[var11 - 1][var8][var13] & var2) == 0) {
                              break label523;
                           }
                        }

                        --var11;
                     }

                     label512:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((XClanMember.field300[var12 + 1][var8][var13] & var2) == 0) {
                              break label512;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + (var10 - var9)) * (1 + var12 - var11);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class10.tileHeights[var12][var8][var9] - var46;
                        var16 = class10.tileHeights[var11][var8][var9];
                        Region.method1757(var5, 1, var8 * 128, 128 * var8, var9 * 128, 128 * var10 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              XClanMember.field300[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((XClanMember.field300[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (XClanMember.field300[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (XClanMember.field300[var6][1 + var10][var7] & var3) != 0) {
                        ++var10;
                     }

                     label576:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((XClanMember.field300[var11 - 1][var13][var7] & var3) == 0) {
                              break label576;
                           }
                        }

                        --var11;
                     }

                     label565:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((XClanMember.field300[var12 + 1][var13][var7] & var3) == 0) {
                              break label565;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class10.tileHeights[var12][var9][var7] - var46;
                        var16 = class10.tileHeights[var11][var9][var7];
                        Region.method1757(var5, 2, 128 * var9, 128 * var10 + 128, 128 * var7, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              XClanMember.field300[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((XClanMember.field300[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (XClanMember.field300[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (XClanMember.field300[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label629:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((XClanMember.field300[var6][var9 - 1][var13] & var4) == 0) {
                              break label629;
                           }
                        }

                        --var9;
                     }

                     label618:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((XClanMember.field300[var6][var10 + 1][var13] & var4) == 0) {
                              break label618;
                           }
                        }

                        ++var10;
                     }

                     if((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
                        var13 = class10.tileHeights[var6][var9][var11];
                        Region.method1757(var5, 4, var9 * 128, var10 * 128 + 128, 128 * var11, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              XClanMember.field300[var6][var14][var15] &= ~var4;
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
