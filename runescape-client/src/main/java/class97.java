import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public class class97 implements class165 {
   @ObfuscatedName("y")
   public static final class97 field1623 = new class97(2, 1);
   @ObfuscatedName("o")
   public static final class97 field1624 = new class97(3, 2);
   @ObfuscatedName("r")
   public static final class97 field1625 = new class97(0, 3);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -190836497
   )
   public final int field1626;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 826365691
   )
   final int field1627;
   @ObfuscatedName("k")
   public static final class97 field1628 = new class97(1, 0);
   @ObfuscatedName("re")
   protected static boolean field1630;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2076412649
   )
   public static int field1631;

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass145;I)V",
      garbageValue = "2142053324"
   )
   static final void method1911(int var0, int var1, int var2, int var3, SpritePixels var4, class145 var5) {
      if(var4 != null) {
         int var6 = Client.mapScale + Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class84.field1428[var6];
            int var9 = class84.field1452[var6];
            var8 = 256 * var8 / (256 + Client.mapScaleDelta);
            var9 = var9 * 256 / (256 + Client.mapScaleDelta);
            int var10 = var8 * var3 + var2 * var9 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method4114(var5.field2007 / 2 + var10 - var4.maxWidth / 2, var5.field2004 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2007, var5.field2004, var5.field2006, var5.field2003);
            } else {
               var4.method4121(var10 + var0 + var5.field2007 / 2 - var4.maxWidth / 2, var1 + var5.field2004 / 2 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;B)V",
      garbageValue = "-82"
   )
   static final void method1912(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class11.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class11.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2241(var3, var4);
                  }
               }
            }
         }
      }

      class11.field102 += (int)(Math.random() * 5.0D) - 2;
      if(class11.field102 < -8) {
         class11.field102 = -8;
      }

      if(class11.field102 > 8) {
         class11.field102 = 8;
      }

      class11.field108 += (int)(Math.random() * 5.0D) - 2;
      if(class11.field108 < -16) {
         class11.field108 = -16;
      }

      if(class11.field108 > 16) {
         class11.field108 = 16;
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
         byte[][] var44 = class39.field798[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class11.tileHeights[var2][1 + var12][var11] - class11.tileHeights[var2][var12 - 1][var11];
               var14 = class11.tileHeights[var2][var12][1 + var11] - class11.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var14 * var14 + 65536 + var13 * var13));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (-50 * var18 + var16 * -50 + var17 * -10) / var10 + 96;
               var20 = (var44[var12][var11] >> 1) + (var44[var12 - 1][var11] >> 2) + (var44[1 + var12][var11] >> 3) + (var44[var12][var11 - 1] >> 2) + (var44[var12][var11 + 1] >> 3);
               class215.field3153[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class48.field933[var11] = 0;
            class11.field100[var11] = 0;
            Ignore.field206[var11] = 0;
            class7.field62[var11] = 0;
            class47.field929[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = 5 + var11;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class11.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     var16 = var14 - 1;
                     FloorUnderlayDefinition var45 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field2794.get((long)var16);
                     FloorUnderlayDefinition var47;
                     if(var45 != null) {
                        var47 = var45;
                     } else {
                        byte[] var46 = FloorUnderlayDefinition.field2792.getConfigData(1, var16);
                        var45 = new FloorUnderlayDefinition();
                        if(var46 != null) {
                           var45.method3487(new Buffer(var46), var16);
                        }

                        var45.method3476();
                        FloorUnderlayDefinition.field2794.put(var45, (long)var16);
                        var47 = var45;
                     }

                     class48.field933[var12] += var47.field2791;
                     class11.field100[var12] += var47.field2789;
                     Ignore.field206[var12] += var47.field2788;
                     class7.field62[var12] += var47.field2796;
                     ++class47.field929[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class11.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     var17 = var15 - 1;
                     FloorUnderlayDefinition var56 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field2794.get((long)var17);
                     FloorUnderlayDefinition var50;
                     if(var56 != null) {
                        var50 = var56;
                     } else {
                        byte[] var49 = FloorUnderlayDefinition.field2792.getConfigData(1, var17);
                        var56 = new FloorUnderlayDefinition();
                        if(var49 != null) {
                           var56.method3487(new Buffer(var49), var17);
                        }

                        var56.method3476();
                        FloorUnderlayDefinition.field2794.put(var56, (long)var17);
                        var50 = var56;
                     }

                     class48.field933[var12] -= var50.field2791;
                     class11.field100[var12] -= var50.field2789;
                     Ignore.field206[var12] -= var50.field2788;
                     class7.field62[var12] -= var50.field2796;
                     --class47.field929[var12];
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
                     var12 += class48.field933[var18];
                     var13 += class11.field100[var18];
                     var14 += Ignore.field206[var18];
                     var15 += class7.field62[var18];
                     var16 += class47.field929[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class48.field933[var19];
                     var13 -= class11.field100[var19];
                     var14 -= Ignore.field206[var19];
                     var15 -= class7.field62[var19];
                     var16 -= class47.field929[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field278 || (class11.tileSettings[0][var11][var17] & 2) != 0 || (class11.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class11.field115) {
                        class11.field115 = var2;
                     }

                     var20 = class11.underlayIds[var2][var11][var17] & 255;
                     int var21 = class11.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class11.tileHeights[var2][var11][var17];
                        int var23 = class11.tileHeights[var2][1 + var11][var17];
                        int var24 = class11.tileHeights[var2][var11 + 1][1 + var17];
                        int var25 = class11.tileHeights[var2][var11][1 + var17];
                        int var26 = class215.field3153[var11][var17];
                        int var27 = class215.field3153[1 + var11][var17];
                        int var28 = class215.field3153[var11 + 1][1 + var17];
                        int var29 = class215.field3153[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        int var34;
                        if(var20 > 0) {
                           var32 = 256 * var12 / var15;
                           var33 = var13 / var16;
                           var34 = var14 / var16;
                           var30 = class9.method121(var32, var33, var34);
                           var32 = class11.field102 + var32 & 255;
                           var34 += class11.field108;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class9.method121(var32, var33, var34);
                        }

                        Overlay var35;
                        if(var2 > 0) {
                           boolean var54 = true;
                           if(var20 == 0 && class189.overlayPaths[var2][var11][var17] != 0) {
                              var54 = false;
                           }

                           if(var21 > 0) {
                              var34 = var21 - 1;
                              var35 = (Overlay)Overlay.field3020.get((long)var34);
                              Overlay var51;
                              if(null != var35) {
                                 var51 = var35;
                              } else {
                                 byte[] var36 = Overlay.field3030.getConfigData(4, var34);
                                 var35 = new Overlay();
                                 if(var36 != null) {
                                    var35.method3739(new Buffer(var36), var34);
                                 }

                                 var35.method3735();
                                 Overlay.field3020.put(var35, (long)var34);
                                 var51 = var35;
                              }

                              if(!var51.isHidden) {
                                 var54 = false;
                              }
                           }

                           if(var54 && var22 == var23 && var24 == var22 && var25 == var22) {
                              class7.field55[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class84.colorPalette[Projectile.method803(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method1712(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, Projectile.method803(var30, var26), Projectile.method803(var30, var27), Projectile.method803(var30, var28), Projectile.method803(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = 1 + class189.overlayPaths[var2][var11][var17];
                           byte var55 = class11.overlayRotations[var2][var11][var17];
                           int var48 = var21 - 1;
                           Overlay var37 = (Overlay)Overlay.field3020.get((long)var48);
                           if(var37 != null) {
                              var35 = var37;
                           } else {
                              byte[] var38 = Overlay.field3030.getConfigData(4, var48);
                              var37 = new Overlay();
                              if(null != var38) {
                                 var37.method3739(new Buffer(var38), var48);
                              }

                              var37.method3735();
                              Overlay.field3020.put(var37, (long)var48);
                              var35 = var37;
                           }

                           int var52 = var35.texture;
                           int var39;
                           int var40;
                           int var41;
                           int var42;
                           if(var52 >= 0) {
                              var40 = class84.field1448.vmethod1888(var52);
                              var39 = -1;
                           } else if(var35.color == 16711935) {
                              var39 = -2;
                              var52 = -1;
                              var40 = -2;
                           } else {
                              var39 = class9.method121(var35.hue, var35.saturation, var35.lightness);
                              var41 = class11.field102 + var35.hue & 255;
                              var42 = class11.field108 + var35.lightness;
                              if(var42 < 0) {
                                 var42 = 0;
                              } else if(var42 > 255) {
                                 var42 = 255;
                              }

                              var40 = class9.method121(var41, var35.saturation, var42);
                           }

                           var41 = 0;
                           if(var40 != -2) {
                              var41 = class84.colorPalette[class202.method3781(var40, 96)];
                           }

                           if(var35.field3024 != -1) {
                              var42 = var35.field3019 + class11.field102 & 255;
                              int var43 = var35.field3029 + class11.field108;
                              if(var43 < 0) {
                                 var43 = 0;
                              } else if(var43 > 255) {
                                 var43 = 255;
                              }

                              var40 = class9.method121(var42, var35.field3028, var43);
                              var41 = class84.colorPalette[class202.method3781(var40, 96)];
                           }

                           var0.method1712(var2, var11, var17, var33, var55, var52, var22, var23, var24, var25, Projectile.method803(var30, var26), Projectile.method803(var30, var27), Projectile.method803(var30, var28), Projectile.method803(var30, var29), class202.method3781(var39, var26), class202.method3781(var39, var27), class202.method3781(var39, var28), class202.method3781(var39, var29), var32, var41);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.method1768(var2, var12, var11, class6.method97(var2, var12, var11));
            }
         }

         class11.underlayIds[var2] = null;
         class11.overlayIds[var2] = null;
         class189.overlayPaths[var2] = null;
         class11.overlayRotations[var2] = null;
         class39.field798[var2] = null;
      }

      var0.method1738(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class11.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method1862(var2, var3);
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
                  short var53;
                  if((class7.field55[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class7.field55[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class7.field55[var6][var8][1 + var10] & var2) != 0) {
                        ++var10;
                     }

                     label573:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class7.field55[var11 - 1][var8][var13] & var2) == 0) {
                              break label573;
                           }
                        }

                        --var11;
                     }

                     label562:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class7.field55[var12 + 1][var8][var13] & var2) == 0) {
                              break label562;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if(var13 >= 8) {
                        var53 = 240;
                        var15 = class11.tileHeights[var12][var8][var9] - var53;
                        var16 = class11.tileHeights[var11][var8][var9];
                        Region.method1747(var5, 1, var8 * 128, var8 * 128, 128 * var9, 128 * var10 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class7.field55[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class7.field55[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class7.field55[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class7.field55[var6][1 + var10][var7] & var3) != 0) {
                        ++var10;
                     }

                     label626:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class7.field55[var11 - 1][var13][var7] & var3) == 0) {
                              break label626;
                           }
                        }

                        --var11;
                     }

                     label615:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class7.field55[1 + var12][var13][var7] & var3) == 0) {
                              break label615;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + var12 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var53 = 240;
                        var15 = class11.tileHeights[var12][var9][var7] - var53;
                        var16 = class11.tileHeights[var11][var9][var7];
                        Region.method1747(var5, 2, var9 * 128, 128 + 128 * var10, 128 * var7, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class7.field55[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class7.field55[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class7.field55[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class7.field55[var6][var8][1 + var12] & var4) != 0) {
                        ++var12;
                     }

                     label679:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class7.field55[var6][var9 - 1][var13] & var4) == 0) {
                              break label679;
                           }
                        }

                        --var9;
                     }

                     label668:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class7.field55[var6][var10 + 1][var13] & var4) == 0) {
                              break label668;
                           }
                        }

                        ++var10;
                     }

                     if((1 + (var12 - var11)) * (var10 - var9 + 1) >= 4) {
                        var13 = class11.tileHeights[var6][var9][var11];
                        Region.method1747(var5, 4, 128 * var9, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class7.field55[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-505678853"
   )
   public int vmethod4057() {
      return this.field1627;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class97(int var1, int var2) {
      this.field1626 = var1;
      this.field1627 = var2;
   }
}
