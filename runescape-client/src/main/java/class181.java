import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class181 extends CacheableNode {
   @ObfuscatedName("i")
   public byte field2702;
   @ObfuscatedName("b")
   public class184 field2703;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2024485435
   )
   public int field2704;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1716941657"
   )
   public static int method3344(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;B)V",
      garbageValue = "-12"
   )
   static final void method3345(Region var0, CollisionData[] var1) {
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
                     var1[var5].method2319(var3, var4);
                  }
               }
            }
         }
      }

      class10.field101 += (int)(Math.random() * 5.0D) - 2;
      if(class10.field101 < -8) {
         class10.field101 = -8;
      }

      if(class10.field101 > 8) {
         class10.field101 = 8;
      }

      class10.field102 += (int)(Math.random() * 5.0D) - 2;
      if(class10.field102 < -16) {
         class10.field102 = -16;
      }

      if(class10.field102 > 16) {
         class10.field102 = 16;
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
         byte[][] var42 = Item.field884[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = 768 * var9 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class10.tileHeights[var2][var12 + 1][var11] - class10.tileHeights[var2][var12 - 1][var11];
               var14 = class10.tileHeights[var2][var12][1 + var11] - class10.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + 65536 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (-50 * var18 + var16 * -50 + var17 * -10) / var10 + 96;
               var20 = (var42[var12][var11] >> 1) + (var42[var12][1 + var11] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11 - 1] >> 2);
               class183.field2729[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class85.field1444[var11] = 0;
            class142.field1996[var11] = 0;
            class47.field928[var11] = 0;
            class10.field95[var11] = 0;
            class16.field175[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = 5 + var11;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class10.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = Ignore.method209(var14 - 1);
                     class85.field1444[var12] += var43.field2813;
                     class142.field1996[var12] += var43.field2814;
                     class47.field928[var12] += var43.field2810;
                     class10.field95[var12] += var43.field2811;
                     ++class16.field175[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class10.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = Ignore.method209(var15 - 1);
                     class85.field1444[var12] -= var44.field2813;
                     class142.field1996[var12] -= var44.field2814;
                     class47.field928[var12] -= var44.field2810;
                     class10.field95[var12] -= var44.field2811;
                     --class16.field175[var12];
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
                     var12 += class85.field1444[var18];
                     var13 += class142.field1996[var18];
                     var14 += class47.field928[var18];
                     var15 += class10.field95[var18];
                     var16 += class16.field175[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class85.field1444[var19];
                     var13 -= class142.field1996[var19];
                     var14 -= class47.field928[var19];
                     var15 -= class10.field95[var19];
                     var16 -= class16.field175[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field404 || (class10.tileSettings[0][var11][var17] & 2) != 0 || (class10.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class10.field109) {
                        class10.field109 = var2;
                     }

                     var20 = class10.underlayIds[var2][var11][var17] & 255;
                     int var21 = class10.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class10.tileHeights[var2][var11][var17];
                        int var23 = class10.tileHeights[var2][var11 + 1][var17];
                        int var24 = class10.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class10.tileHeights[var2][var11][var17 + 1];
                        int var26 = class183.field2729[var11][var17];
                        int var27 = class183.field2729[1 + var11][var17];
                        int var28 = class183.field2729[1 + var11][var17 + 1];
                        int var29 = class183.field2729[var11][1 + var17];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        int var34;
                        if(var20 > 0) {
                           var32 = 256 * var12 / var15;
                           var33 = var13 / var16;
                           var34 = var14 / var16;
                           var30 = class175.method3327(var32, var33, var34);
                           var32 = var32 + class10.field101 & 255;
                           var34 += class10.field102;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class175.method3327(var32, var33, var34);
                        }

                        Overlay var35;
                        if(var2 > 0) {
                           boolean var49 = true;
                           if(var20 == 0 && class10.overlayPaths[var2][var11][var17] != 0) {
                              var49 = false;
                           }

                           if(var21 > 0) {
                              var34 = var21 - 1;
                              var35 = (Overlay)Overlay.field3053.get((long)var34);
                              Overlay var45;
                              if(null != var35) {
                                 var45 = var35;
                              } else {
                                 byte[] var46 = Overlay.field3051.getConfigData(4, var34);
                                 var35 = new Overlay();
                                 if(var46 != null) {
                                    var35.method3848(new Buffer(var46), var34);
                                 }

                                 var35.method3836();
                                 Overlay.field3053.put(var35, (long)var34);
                                 var45 = var35;
                              }

                              if(!var45.isHidden) {
                                 var49 = false;
                              }
                           }

                           if(var49 && var23 == var22 && var24 == var22 && var25 == var22) {
                              class149.field2027[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class84.colorPalette[class140.method2682(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method1761(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class140.method2682(var30, var26), class140.method2682(var30, var27), class140.method2682(var30, var28), class140.method2682(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = 1 + class10.overlayPaths[var2][var11][var17];
                           byte var50 = class10.overlayRotations[var2][var11][var17];
                           var35 = class25.method616(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class84.field1415.vmethod1968(var36);
                              var37 = -1;
                           } else if(var35.color == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class175.method3327(var35.hue, var35.saturation, var35.lightness);
                              var39 = class10.field101 + var35.hue & 255;
                              var40 = var35.lightness + class10.field102;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class175.method3327(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class84.colorPalette[class63.method1217(var38, 96)];
                           }

                           if(var35.field3050 != -1) {
                              var40 = var35.field3054 + class10.field101 & 255;
                              int var41 = class10.field102 + var35.field3052;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class175.method3327(var40, var35.field3055, var41);
                              var39 = class84.colorPalette[class63.method1217(var38, 96)];
                           }

                           var0.method1761(var2, var11, var17, var33, var50, var36, var22, var23, var24, var25, class140.method2682(var30, var26), class140.method2682(var30, var27), class140.method2682(var30, var28), class140.method2682(var30, var29), class63.method1217(var37, var26), class63.method1217(var37, var27), class63.method1217(var37, var28), class63.method1217(var37, var29), var32, var39);
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

               var0.method1760(var2, var12, var11, var17);
            }
         }

         class10.underlayIds[var2] = null;
         class10.overlayIds[var2] = null;
         class10.overlayPaths[var2] = null;
         class10.overlayRotations[var2] = null;
         Item.field884[var2] = null;
      }

      var0.method1787(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class10.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method1820(var2, var3);
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
                  short var48;
                  if((class149.field2027[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class149.field2027[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class149.field2027[var6][var8][1 + var10] & var2) != 0) {
                        ++var10;
                     }

                     label540:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class149.field2027[var11 - 1][var8][var13] & var2) == 0) {
                              break label540;
                           }
                        }

                        --var11;
                     }

                     label529:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class149.field2027[1 + var12][var8][var13] & var2) == 0) {
                              break label529;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (1 + var12 - var11);
                     if(var13 >= 8) {
                        var48 = 240;
                        var15 = class10.tileHeights[var12][var8][var9] - var48;
                        var16 = class10.tileHeights[var11][var8][var9];
                        Region.method1759(var5, 1, var8 * 128, var8 * 128, var9 * 128, 128 + 128 * var10, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class149.field2027[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class149.field2027[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class149.field2027[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class149.field2027[var6][1 + var10][var7] & var3) != 0) {
                        ++var10;
                     }

                     label593:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class149.field2027[var11 - 1][var13][var7] & var3) == 0) {
                              break label593;
                           }
                        }

                        --var11;
                     }

                     label582:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class149.field2027[var12 + 1][var13][var7] & var3) == 0) {
                              break label582;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + var12 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var48 = 240;
                        var15 = class10.tileHeights[var12][var9][var7] - var48;
                        var16 = class10.tileHeights[var11][var9][var7];
                        Region.method1759(var5, 2, var9 * 128, 128 + var10 * 128, 128 * var7, 128 * var7, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class149.field2027[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class149.field2027[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class149.field2027[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class149.field2027[var6][var8][1 + var12] & var4) != 0) {
                        ++var12;
                     }

                     label646:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class149.field2027[var6][var9 - 1][var13] & var4) == 0) {
                              break label646;
                           }
                        }

                        --var9;
                     }

                     label635:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class149.field2027[var6][1 + var10][var13] & var4) == 0) {
                              break label635;
                           }
                        }

                        ++var10;
                     }

                     if((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
                        var13 = class10.tileHeights[var6][var9][var11];
                        Region.method1759(var5, 4, 128 * var9, 128 + var10 * 128, 128 * var11, 128 + var12 * 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class149.field2027[var6][var14][var15] &= ~var4;
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
