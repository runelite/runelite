import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class138 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1494021017
   )
   public static int field1921;
   @ObfuscatedName("f")
   public static class182 field1922;
   @ObfuscatedName("h")
   public static class139 field1923;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -1362659809
   )
   static int field1924;
   @ObfuscatedName("j")
   public static class181 field1925;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -458406989
   )
   public static int field1926;
   @ObfuscatedName("r")
   public static boolean field1927;
   @ObfuscatedName("n")
   public static class144 field1928;
   @ObfuscatedName("s")
   public static class182 field1931;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1392347651
   )
   public static int field1933 = 0;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass145;I)V",
      garbageValue = "-1045336369"
   )
   public static void method2405(class145 var0) {
      class210.field3121 = var0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "468341457"
   )
   static final int method2411(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class33.method670(var3, var5);
      int var8 = class33.method670(var3 + 1, var5);
      int var9 = class33.method670(var3, var5 + 1);
      int var10 = class33.method670(1 + var3, var5 + 1);
      int var11 = class37.method719(var7, var8, var4, var2);
      int var12 = class37.method719(var9, var10, var4, var2);
      return class37.method719(var11, var12, var6, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;I)V",
      garbageValue = "288692259"
   )
   static final void method2412(Region var0, CollisionData[] var1) {
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
                     var1[var5].method2204(var3, var4);
                  }
               }
            }
         }
      }

      class10.field99 += (int)(Math.random() * 5.0D) - 2;
      if(class10.field99 < -8) {
         class10.field99 = -8;
      }

      if(class10.field99 > 8) {
         class10.field99 = 8;
      }

      class10.field107 += (int)(Math.random() * 5.0D) - 2;
      if(class10.field107 < -16) {
         class10.field107 = -16;
      }

      if(class10.field107 > 16) {
         class10.field107 = 16;
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
         byte[][] var42 = class162.field2157[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = 768 * var9 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class10.tileHeights[var2][var12 + 1][var11] - class10.tileHeights[var2][var12 - 1][var11];
               var14 = class10.tileHeights[var2][var12][var11 + 1] - class10.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var14 * var14 + 65536 + var13 * var13));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = 96 + (var18 * -50 + -50 * var16 + -10 * var17) / var10;
               var20 = (var42[var12][var11] >> 1) + (var42[var12][1 + var11] >> 3) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12 - 1][var11] >> 2);
               class10.field93[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class16.field184[var11] = 0;
            class11.field116[var11] = 0;
            class37.field784[var11] = 0;
            class10.field97[var11] = 0;
            class170.field2349[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = 5 + var11;
               if(var13 >= 0 && var13 < 104) {
                  var14 = ChatLineBuffer.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = Client.method474(var14 - 1);
                     class16.field184[var12] += var43.field2819;
                     class11.field116[var12] += var43.field2815;
                     class37.field784[var12] += var43.field2816;
                     class10.field97[var12] += var43.field2817;
                     ++class170.field2349[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = ChatLineBuffer.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = Client.method474(var15 - 1);
                     class16.field184[var12] -= var44.field2819;
                     class11.field116[var12] -= var44.field2815;
                     class37.field784[var12] -= var44.field2816;
                     class10.field97[var12] -= var44.field2817;
                     --class170.field2349[var12];
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
                     var12 += class16.field184[var18];
                     var13 += class11.field116[var18];
                     var14 += class37.field784[var18];
                     var15 += class10.field97[var18];
                     var16 += class170.field2349[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class16.field184[var19];
                     var13 -= class11.field116[var19];
                     var14 -= class37.field784[var19];
                     var15 -= class10.field97[var19];
                     var16 -= class170.field2349[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field299 || (class10.tileSettings[0][var11][var17] & 2) != 0 || (class10.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class10.field91) {
                        class10.field91 = var2;
                     }

                     var20 = ChatLineBuffer.underlayIds[var2][var11][var17] & 255;
                     int var21 = class10.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class10.tileHeights[var2][var11][var17];
                        int var23 = class10.tileHeights[var2][var11 + 1][var17];
                        int var24 = class10.tileHeights[var2][1 + var11][var17 + 1];
                        int var25 = class10.tileHeights[var2][var11][var17 + 1];
                        int var26 = class10.field93[var11][var17];
                        int var27 = class10.field93[1 + var11][var17];
                        int var28 = class10.field93[1 + var11][1 + var17];
                        int var29 = class10.field93[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        int var34;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           var34 = var14 / var16;
                           var30 = class44.method783(var32, var33, var34);
                           var32 = class10.field99 + var32 & 255;
                           var34 += class10.field107;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class44.method783(var32, var33, var34);
                        }

                        Overlay var35;
                        if(var2 > 0) {
                           boolean var48 = true;
                           if(var20 == 0 && class20.overlayPaths[var2][var11][var17] != 0) {
                              var48 = false;
                           }

                           if(var21 > 0) {
                              var34 = var21 - 1;
                              var35 = (Overlay)Overlay.field3046.get((long)var34);
                              Overlay var46;
                              if(var35 != null) {
                                 var46 = var35;
                              } else {
                                 byte[] var36 = class32.field737.getConfigData(4, var34);
                                 var35 = new Overlay();
                                 if(null != var36) {
                                    var35.method3596(new Buffer(var36), var34);
                                 }

                                 var35.method3598();
                                 Overlay.field3046.put(var35, (long)var34);
                                 var46 = var35;
                              }

                              if(!var46.isHidden) {
                                 var48 = false;
                              }
                           }

                           if(var48 && var23 == var22 && var24 == var22 && var22 == var25) {
                              class161.field2152[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class84.colorPalette[class41.method755(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method1663(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class41.method755(var30, var26), class41.method755(var30, var27), class41.method755(var30, var28), class41.method755(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class20.overlayPaths[var2][var11][var17] + 1;
                           byte var49 = class10.overlayRotations[var2][var11][var17];
                           var35 = class94.method1860(var21 - 1);
                           int var45 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var45 >= 0) {
                              var38 = class84.field1438.vmethod1843(var45);
                              var37 = -1;
                           } else if(var35.color == 16711935) {
                              var37 = -2;
                              var45 = -1;
                              var38 = -2;
                           } else {
                              var37 = class44.method783(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class10.field99 & 255;
                              var40 = var35.lightness + class10.field107;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class44.method783(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class84.colorPalette[FrameMap.method1655(var38, 96)];
                           }

                           if(var35.field3044 != -1) {
                              var40 = class10.field99 + var35.field3043 & 255;
                              int var41 = var35.field3049 + class10.field107;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class44.method783(var40, var35.field3050, var41);
                              var39 = class84.colorPalette[FrameMap.method1655(var38, 96)];
                           }

                           var0.method1663(var2, var11, var17, var33, var49, var45, var22, var23, var24, var25, class41.method755(var30, var26), class41.method755(var30, var27), class41.method755(var30, var28), class41.method755(var30, var29), FrameMap.method1655(var37, var26), FrameMap.method1655(var37, var27), FrameMap.method1655(var37, var28), FrameMap.method1655(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.method1662(var2, var12, var11, class63.method1104(var2, var12, var11));
            }
         }

         ChatLineBuffer.underlayIds[var2] = null;
         class10.overlayIds[var2] = null;
         class20.overlayPaths[var2] = null;
         class10.overlayRotations[var2] = null;
         class162.field2157[var2] = null;
      }

      var0.method1689(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class10.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method1660(var2, var3);
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
                  short var47;
                  if((class161.field2152[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class161.field2152[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class161.field2152[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label533:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class161.field2152[var11 - 1][var8][var13] & var2) == 0) {
                              break label533;
                           }
                        }

                        --var11;
                     }

                     label522:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class161.field2152[1 + var12][var8][var13] & var2) == 0) {
                              break label522;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + (var10 - var9)) * (1 + var12 - var11);
                     if(var13 >= 8) {
                        var47 = 240;
                        var15 = class10.tileHeights[var12][var8][var9] - var47;
                        var16 = class10.tileHeights[var11][var8][var9];
                        Region.method1661(var5, 1, var8 * 128, 128 * var8, 128 * var9, 128 + var10 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class161.field2152[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class161.field2152[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class161.field2152[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class161.field2152[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label586:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class161.field2152[var11 - 1][var13][var7] & var3) == 0) {
                              break label586;
                           }
                        }

                        --var11;
                     }

                     label575:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class161.field2152[1 + var12][var13][var7] & var3) == 0) {
                              break label575;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (1 + var12 - var11);
                     if(var13 >= 8) {
                        var47 = 240;
                        var15 = class10.tileHeights[var12][var9][var7] - var47;
                        var16 = class10.tileHeights[var11][var9][var7];
                        Region.method1661(var5, 2, 128 * var9, 128 + 128 * var10, 128 * var7, 128 * var7, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class161.field2152[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class161.field2152[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class161.field2152[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class161.field2152[var6][var8][1 + var12] & var4) != 0) {
                        ++var12;
                     }

                     label639:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class161.field2152[var6][var9 - 1][var13] & var4) == 0) {
                              break label639;
                           }
                        }

                        --var9;
                     }

                     label628:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class161.field2152[var6][1 + var10][var13] & var4) == 0) {
                              break label628;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (1 + (var10 - var9)) >= 4) {
                        var13 = class10.tileHeights[var6][var9][var11];
                        Region.method1661(var5, 4, var9 * 128, 128 + var10 * 128, var11 * 128, 128 + var12 * 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class161.field2152[var6][var14][var15] &= ~var4;
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
