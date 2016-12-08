import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class45 {
   @ObfuscatedName("k")
   static int[] field897 = new int[2048];
   @ObfuscatedName("b")
   static byte[] field898 = new byte[2048];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1503180149
   )
   static int field900 = 0;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = -766812287
   )
   static int field901;
   @ObfuscatedName("l")
   static int[] field902 = new int[2048];
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -287206071
   )
   static int field903 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 751041611
   )
   static int field904 = 0;
   @ObfuscatedName("u")
   static int[] field905 = new int[2048];
   @ObfuscatedName("z")
   static int[] field906 = new int[2048];
   @ObfuscatedName("ba")
   static class184 field907;
   @ObfuscatedName("f")
   static int[] field909 = new int[2048];
   @ObfuscatedName("p")
   static Buffer field910 = new Buffer(new byte[5000]);
   @ObfuscatedName("w")
   static int[] field912;
   @ObfuscatedName("y")
   static int[] field913 = new int[2048];
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -410749105
   )
   protected static int field914;
   @ObfuscatedName("aq")
   static class184 field915;
   @ObfuscatedName("g")
   static byte[] field916 = new byte[2048];
   @ObfuscatedName("h")
   static Buffer[] field917 = new Buffer[2048];

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-272898922"
   )
   static void method802() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;I)V",
      garbageValue = "-344872707"
   )
   static final void method820(Region var0, CollisionData[] var1) {
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
                     var1[var5].method2213(var3, var4);
                  }
               }
            }
         }
      }

      class10.field98 += (int)(Math.random() * 5.0D) - 2;
      if(class10.field98 < -8) {
         class10.field98 = -8;
      }

      if(class10.field98 > 8) {
         class10.field98 = 8;
      }

      class10.field99 += (int)(Math.random() * 5.0D) - 2;
      if(class10.field99 < -16) {
         class10.field99 = -16;
      }

      if(class10.field99 > 16) {
         class10.field99 = 16;
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
      int var43;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = class10.field80[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class10.tileHeights[var2][var12 + 1][var11] - class10.tileHeights[var2][var12 - 1][var11];
               var14 = class10.tileHeights[var2][var12][1 + var11] - class10.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + 65536 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var43 = (var14 << 8) / var15;
               var19 = (-10 * var17 + var16 * -50 + var43 * -50) / var10 + 96;
               var20 = (var42[var12][var11 - 1] >> 2) + (var42[1 + var12][var11] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12][1 + var11] >> 3) + (var42[var12][var11] >> 1);
               class10.field86[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class146.field2032[var11] = 0;
            class10.field104[var11] = 0;
            class10.field88[var11] = 0;
            class10.field84[var11] = 0;
            class10.field90[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class10.field83[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     var16 = var14 - 1;
                     class191 var44 = (class191)class191.field2817.get((long)var16);
                     class191 var45;
                     if(var44 != null) {
                        var45 = var44;
                     } else {
                        byte[] var18 = class0.field3.method3203(1, var16);
                        var44 = new class191();
                        if(var18 != null) {
                           var44.method3391(new Buffer(var18), var16);
                        }

                        var44.method3390();
                        class191.field2817.put(var44, (long)var16);
                        var45 = var44;
                     }

                     class146.field2032[var12] += var45.field2810;
                     class10.field104[var12] += var45.field2812;
                     class10.field88[var12] += var45.field2809;
                     class10.field84[var12] += var45.field2808;
                     ++class10.field90[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class10.field83[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     var17 = var15 - 1;
                     class191 var50 = (class191)class191.field2817.get((long)var17);
                     class191 var47;
                     if(null != var50) {
                        var47 = var50;
                     } else {
                        byte[] var48 = class0.field3.method3203(1, var17);
                        var50 = new class191();
                        if(var48 != null) {
                           var50.method3391(new Buffer(var48), var17);
                        }

                        var50.method3390();
                        class191.field2817.put(var50, (long)var17);
                        var47 = var50;
                     }

                     class146.field2032[var12] -= var47.field2810;
                     class10.field104[var12] -= var47.field2812;
                     class10.field88[var12] -= var47.field2809;
                     class10.field84[var12] -= var47.field2808;
                     --class10.field90[var12];
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
                  var43 = var17 + 5;
                  if(var43 >= 0 && var43 < 104) {
                     var12 += class146.field2032[var43];
                     var13 += class10.field104[var43];
                     var14 += class10.field88[var43];
                     var15 += class10.field84[var43];
                     var16 += class10.field90[var43];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class146.field2032[var19];
                     var13 -= class10.field104[var19];
                     var14 -= class10.field88[var19];
                     var15 -= class10.field84[var19];
                     var16 -= class10.field90[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field314 || (class10.tileSettings[0][var11][var17] & 2) != 0 || (class10.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class10.field94) {
                        class10.field94 = var2;
                     }

                     var20 = class10.field83[var2][var11][var17] & 255;
                     int var21 = class204.field3072[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class10.tileHeights[var2][var11][var17];
                        int var23 = class10.tileHeights[var2][1 + var11][var17];
                        int var24 = class10.tileHeights[var2][1 + var11][var17 + 1];
                        int var25 = class10.tileHeights[var2][var11][var17 + 1];
                        int var26 = class10.field86[var11][var17];
                        int var27 = class10.field86[var11 + 1][var17];
                        int var28 = class10.field86[1 + var11][var17 + 1];
                        int var29 = class10.field86[var11][1 + var17];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = 256 * var12 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class189.method3365(var32, var33, var34);
                           var32 = var32 + class10.field98 & 255;
                           var34 += class10.field99;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class189.method3365(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var51 = true;
                           if(var20 == 0 && class183.field2737[var2][var11][var17] != 0) {
                              var51 = false;
                           }

                           if(var21 > 0 && !class94.method1867(var21 - 1).field3042) {
                              var51 = false;
                           }

                           if(var51 && var22 == var23 && var22 == var24 && var25 == var22) {
                              DecorativeObject.field1596[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class84.colorPalette[Buffer.method2911(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method1671(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, Buffer.method2911(var30, var26), Buffer.method2911(var30, var27), Buffer.method2911(var30, var28), Buffer.method2911(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = 1 + class183.field2737[var2][var11][var17];
                           byte var52 = class10.field82[var2][var11][var17];
                           class200 var35 = class94.method1867(var21 - 1);
                           int var36 = var35.field3036;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class84.field1442.vmethod1853(var36);
                              var37 = -1;
                           } else if(var35.field3035 == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class189.method3365(var35.field3037, var35.field3040, var35.field3041);
                              var39 = class10.field98 + var35.field3037 & 255;
                              var40 = class10.field99 + var35.field3041;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class189.method3365(var39, var35.field3040, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class84.colorPalette[Sequence.method3677(var38, 96)];
                           }

                           if(var35.field3034 != -1) {
                              var40 = var35.field3033 + class10.field98 & 255;
                              int var41 = class10.field99 + var35.field3038;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class189.method3365(var40, var35.field3043, var41);
                              var39 = class84.colorPalette[Sequence.method3677(var38, 96)];
                           }

                           var0.method1671(var2, var11, var17, var33, var52, var36, var22, var23, var24, var25, Buffer.method2911(var30, var26), Buffer.method2911(var30, var27), Buffer.method2911(var30, var28), Buffer.method2911(var30, var29), Sequence.method3677(var37, var26), Sequence.method3677(var37, var27), Sequence.method3677(var37, var28), Sequence.method3677(var37, var29), var32, var39);
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

               var0.method1670(var2, var12, var11, var17);
            }
         }

         class10.field83[var2] = null;
         class204.field3072[var2] = null;
         class183.field2737[var2] = null;
         class10.field82[var2] = null;
         class10.field80[var2] = null;
      }

      var0.method1697(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class10.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method1668(var2, var3);
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
                  short var49;
                  if((DecorativeObject.field1596[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (DecorativeObject.field1596[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (DecorativeObject.field1596[var6][var8][1 + var10] & var2) != 0) {
                        ++var10;
                     }

                     label566:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((DecorativeObject.field1596[var11 - 1][var8][var13] & var2) == 0) {
                              break label566;
                           }
                        }

                        --var11;
                     }

                     label555:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((DecorativeObject.field1596[var12 + 1][var8][var13] & var2) == 0) {
                              break label555;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + var12 - var11) * (var10 - var9 + 1);
                     if(var13 >= 8) {
                        var49 = 240;
                        var15 = class10.tileHeights[var12][var8][var9] - var49;
                        var16 = class10.tileHeights[var11][var8][var9];
                        Region.method1669(var5, 1, var8 * 128, var8 * 128, 128 * var9, 128 * var10 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var43 = var9; var43 <= var10; ++var43) {
                              DecorativeObject.field1596[var17][var8][var43] &= ~var2;
                           }
                        }
                     }
                  }

                  if((DecorativeObject.field1596[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (DecorativeObject.field1596[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (DecorativeObject.field1596[var6][1 + var10][var7] & var3) != 0) {
                        ++var10;
                     }

                     label619:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((DecorativeObject.field1596[var11 - 1][var13][var7] & var3) == 0) {
                              break label619;
                           }
                        }

                        --var11;
                     }

                     label608:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((DecorativeObject.field1596[1 + var12][var13][var7] & var3) == 0) {
                              break label608;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (1 + var12 - var11);
                     if(var13 >= 8) {
                        var49 = 240;
                        var15 = class10.tileHeights[var12][var9][var7] - var49;
                        var16 = class10.tileHeights[var11][var9][var7];
                        Region.method1669(var5, 2, 128 * var9, 128 + 128 * var10, 128 * var7, 128 * var7, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var43 = var9; var43 <= var10; ++var43) {
                              DecorativeObject.field1596[var17][var43][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((DecorativeObject.field1596[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (DecorativeObject.field1596[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (DecorativeObject.field1596[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label672:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((DecorativeObject.field1596[var6][var9 - 1][var13] & var4) == 0) {
                              break label672;
                           }
                        }

                        --var9;
                     }

                     label661:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((DecorativeObject.field1596[var6][1 + var10][var13] & var4) == 0) {
                              break label661;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var13 = class10.tileHeights[var6][var9][var11];
                        Region.method1669(var5, 4, 128 * var9, 128 * var10 + 128, 128 * var11, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              DecorativeObject.field1596[var6][var14][var15] &= ~var4;
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
