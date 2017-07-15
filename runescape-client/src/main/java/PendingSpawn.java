import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = -443456639
   )
   static int field1203;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1424885109
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -291283243
   )
   @Export("hitpoints")
   int hitpoints;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2046213213
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 16188879
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -947870949
   )
   @Export("level")
   int level;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1789773199
   )
   int field1193;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 405246317
   )
   @Export("type")
   int type;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1029210717
   )
   @Export("id")
   int id;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1220338503
   )
   int field1195;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 716116329
   )
   int field1198;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1627870493
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1438863843
   )
   int field1201;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([LRSEnum;II)LRSEnum;",
      garbageValue = "1279462914"
   )
   @Export("forOrdinal")
   public static RSEnum forOrdinal(RSEnum[] var0, int var1) {
      RSEnum[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         RSEnum var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-381016358"
   )
   static void method1475() {
      FileOnDisk var0 = null;

      try {
         var0 = class152.getPreferencesFile("", Varcs.field1515.field3198, true);
         Buffer var1 = class23.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "-987515946"
   )
   public static void method1477(IndexDataBase var0) {
      InvType.field3281 = var0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;S)V",
      garbageValue = "128"
   )
   static final void method1476(Region var0, CollisionData[] var1) {
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
                     var1[var5].method3024(var3, var4);
                  }
               }
            }
         }
      }

      class61.field745 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field745 < -8) {
         class61.field745 = -8;
      }

      if(class61.field745 > 8) {
         class61.field745 = 8;
      }

      class61.field760 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field760 < -16) {
         class61.field760 = -16;
      }

      if(class61.field760 > 16) {
         class61.field760 = 16;
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
         byte[][] var42 = class61.field750[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class61.tileHeights[var2][var12 + 1][var11] - class61.tileHeights[var2][var12 - 1][var11];
               var14 = class61.tileHeights[var2][var12][var11 + 1] - class61.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(65536 + var13 * var13 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var17 * -10 + var16 * -50 + var18 * -50) / var10 + 96;
               var20 = (var42[var12][var11] >> 1) + (var42[var12 + 1][var11] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12][1 + var11] >> 3);
               FileRequest.field3211[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class61.blendedHue[var11] = 0;
            class98.blendedSaturation[var11] = 0;
            class10.field256[var11] = 0;
            class61.field763[var11] = 0;
            Varcs.field1508[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = Item.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = class116.method2104(var14 - 1);
                     class61.blendedHue[var12] += var43.hue;
                     class98.blendedSaturation[var12] += var43.saturation;
                     class10.field256[var12] += var43.lightness;
                     class61.field763[var12] += var43.hueMultiplier;
                     ++Varcs.field1508[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = Item.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = class116.method2104(var15 - 1);
                     class61.blendedHue[var12] -= var44.hue;
                     class98.blendedSaturation[var12] -= var44.saturation;
                     class10.field256[var12] -= var44.lightness;
                     class61.field763[var12] -= var44.hueMultiplier;
                     --Varcs.field1508[var12];
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
                     var12 += class61.blendedHue[var18];
                     var13 += class98.blendedSaturation[var18];
                     var14 += class10.field256[var18];
                     var15 += class61.field763[var18];
                     var16 += Varcs.field1508[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class61.blendedHue[var19];
                     var13 -= class98.blendedSaturation[var19];
                     var14 -= class10.field256[var19];
                     var15 -= class61.field763[var19];
                     var16 -= Varcs.field1508[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.lowMemory || (class61.tileSettings[0][var11][var17] & 2) != 0 || (class61.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class61.field747) {
                        class61.field747 = var2;
                     }

                     var20 = Item.underlayIds[var2][var11][var17] & 255;
                     int var21 = class61.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class61.tileHeights[var2][var11][var17];
                        int var23 = class61.tileHeights[var2][var11 + 1][var17];
                        int var24 = class61.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class61.tileHeights[var2][var11][var17 + 1];
                        int var26 = FileRequest.field3211[var11][var17];
                        int var27 = FileRequest.field3211[var11 + 1][var17];
                        int var28 = FileRequest.field3211[var11 + 1][var17 + 1];
                        int var29 = FileRequest.field3211[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = Player.hsl24to16(var32, var33, var34);
                           var32 = var32 + class61.field745 & 255;
                           var34 += class61.field760;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = Player.hsl24to16(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var46 = true;
                           if(var20 == 0 && class12.overlayPaths[var2][var11][var17] != 0) {
                              var46 = false;
                           }

                           if(var21 > 0 && !class243.method4269(var21 - 1).isHidden) {
                              var46 = false;
                           }

                           if(var46 && var22 == var23 && var22 == var24 && var25 == var22) {
                              class9.field249[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = Graphics3D.colorPalette[method1479(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, method1479(var30, var26), method1479(var30, var27), method1479(var30, var28), method1479(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class12.overlayPaths[var2][var11][var17] + 1;
                           byte var47 = class61.overlayRotations[var2][var11][var17];
                           Overlay var35 = class243.method4269(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = Graphics3D.textureLoader.getAverageTextureRGB(var36);
                              var37 = -1;
                           } else if(var35.color == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = Player.hsl24to16(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class61.field745 & 255;
                              var40 = var35.lightness + class61.field760;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = Player.hsl24to16(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = Graphics3D.colorPalette[class116.adjustHSLListness0(var38, 96)];
                           }

                           if(var35.otherRgbColor != -1) {
                              var40 = var35.otherHue + class61.field745 & 255;
                              int var41 = var35.otherLightness + class61.field760;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = Player.hsl24to16(var40, var35.otherSaturation, var41);
                              var39 = Graphics3D.colorPalette[class116.adjustHSLListness0(var38, 96)];
                           }

                           var0.addTile(var2, var11, var17, var33, var47, var36, var22, var23, var24, var25, method1479(var30, var26), method1479(var30, var27), method1479(var30, var28), method1479(var30, var29), class116.adjustHSLListness0(var37, var26), class116.adjustHSLListness0(var37, var27), class116.adjustHSLListness0(var37, var28), class116.adjustHSLListness0(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.setPhysicalLevel(var2, var12, var11, class33.method348(var2, var12, var11));
            }
         }

         Item.underlayIds[var2] = null;
         class61.overlayIds[var2] = null;
         class12.overlayPaths[var2] = null;
         class61.overlayRotations[var2] = null;
         class61.field750[var2] = null;
      }

      var0.applyLighting(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class61.tileSettings[1][var2][var3] & 2) == 2) {
               var0.setBridge(var2, var3);
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
                  if((class9.field249[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class9.field249[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class9.field249[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label464:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class9.field249[var11 - 1][var8][var13] & var2) == 0) {
                              break label464;
                           }
                        }

                        --var11;
                     }

                     label453:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class9.field249[var12 + 1][var8][var13] & var2) == 0) {
                              break label453;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var8][var9] - var45;
                        var16 = class61.tileHeights[var11][var8][var9];
                        Region.addOcclude(var5, 1, var8 * 128, var8 * 128, var9 * 128, 128 * var10 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class9.field249[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class9.field249[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class9.field249[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class9.field249[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label517:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class9.field249[var11 - 1][var13][var7] & var3) == 0) {
                              break label517;
                           }
                        }

                        --var11;
                     }

                     label506:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class9.field249[var12 + 1][var13][var7] & var3) == 0) {
                              break label506;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var9][var7] - var45;
                        var16 = class61.tileHeights[var11][var9][var7];
                        Region.addOcclude(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class9.field249[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class9.field249[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class9.field249[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class9.field249[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label570:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class9.field249[var6][var9 - 1][var13] & var4) == 0) {
                              break label570;
                           }
                        }

                        --var9;
                     }

                     label559:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class9.field249[var6][var10 + 1][var13] & var4) == 0) {
                              break label559;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var13 = class61.tileHeights[var6][var9][var11];
                        Region.addOcclude(var5, 4, var9 * 128, 128 * var10 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class9.field249[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   public static String method1478(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class268.field3672[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "106"
   )
   static final int method1479(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
