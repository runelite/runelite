import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class25 {
   @ObfuscatedName("og")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   @Export("minimapSprite")
   static SpritePixels minimapSprite;
   @ObfuscatedName("bj")
   @Export("sessionToken")
   static String sessionToken;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2036459069
   )
   int field378;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   Coordinates field374;

   @ObfuscatedSignature(
      signature = "(ILic;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field378 = var1;
      this.field374 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "43"
   )
   public static final boolean method190() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field640 == KeyFocusListener.field642) {
            return false;
         } else {
            AbstractSoundSystem.field1569 = KeyFocusListener.field631[KeyFocusListener.field640];
            class22.field351 = KeyFocusListener.field643[KeyFocusListener.field640];
            KeyFocusListener.field640 = KeyFocusListener.field640 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lec;[Lfb;I)V",
      garbageValue = "1419072471"
   )
   static final void method191(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class62.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class62.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method3431(var3, var4);
                  }
               }
            }
         }
      }

      class62.field742 += (int)(Math.random() * 5.0D) - 2;
      if(class62.field742 < -8) {
         class62.field742 = -8;
      }

      if(class62.field742 > 8) {
         class62.field742 = 8;
      }

      class62.field750 += (int)(Math.random() * 5.0D) - 2;
      if(class62.field750 < -16) {
         class62.field750 = -16;
      }

      if(class62.field750 > 16) {
         class62.field750 = 16;
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
         byte[][] var42 = class62.field740[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class62.tileHeights[var2][var12 + 1][var11] - class62.tileHeights[var2][var12 - 1][var11];
               var14 = class62.tileHeights[var2][var12][var11 + 1] - class62.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + var14 * var14 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var16 * -50 + var18 * -50 + var17 * -10) / var10 + 96;
               var20 = (var42[var12][var11 + 1] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11] >> 1);
               class62.field741[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class19.field327[var11] = 0;
            class318.field3919[var11] = 0;
            UnitPriceComparator.field321[var11] = 0;
            class29.field430[var11] = 0;
            UnitPriceComparator.field316[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = UrlRequest.field2107[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = InvType.getUnderlayDefinition(var14 - 1);
                     class19.field327[var12] += var43.hue;
                     class318.field3919[var12] += var43.saturation;
                     UnitPriceComparator.field321[var12] += var43.lightness;
                     class29.field430[var12] += var43.hueMultiplier;
                     ++UnitPriceComparator.field316[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = UrlRequest.field2107[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = InvType.getUnderlayDefinition(var15 - 1);
                     class19.field327[var12] -= var44.hue;
                     class318.field3919[var12] -= var44.saturation;
                     UnitPriceComparator.field321[var12] -= var44.lightness;
                     class29.field430[var12] -= var44.hueMultiplier;
                     --UnitPriceComparator.field316[var12];
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
                     var12 += class19.field327[var18];
                     var13 += class318.field3919[var18];
                     var14 += UnitPriceComparator.field321[var18];
                     var15 += class29.field430[var18];
                     var16 += UnitPriceComparator.field316[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class19.field327[var19];
                     var13 -= class318.field3919[var19];
                     var14 -= UnitPriceComparator.field321[var19];
                     var15 -= class29.field430[var19];
                     var16 -= UnitPriceComparator.field316[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.lowMemory || (class62.tileSettings[0][var11][var17] & 2) != 0 || (class62.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class62.field736) {
                        class62.field736 = var2;
                     }

                     var20 = UrlRequest.field2107[var2][var11][var17] & 255;
                     int var21 = class62.field744[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class62.tileHeights[var2][var11][var17];
                        int var23 = class62.tileHeights[var2][var11 + 1][var17];
                        int var24 = class62.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class62.tileHeights[var2][var11][var17 + 1];
                        int var26 = class62.field741[var11][var17];
                        int var27 = class62.field741[var11 + 1][var17];
                        int var28 = class62.field741[var11 + 1][var17 + 1];
                        int var29 = class62.field741[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = method192(var32, var33, var34);
                           var32 = var32 + class62.field742 & 255;
                           var34 += class62.field750;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = method192(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var47 = true;
                           if(var20 == 0 && class62.field734[var2][var11][var17] != 0) {
                              var47 = false;
                           }

                           if(var21 > 0 && !class57.getOverlayDefinition(var21 - 1).isHidden) {
                              var47 = false;
                           }

                           if(var47 && var22 == var23 && var22 == var24 && var22 == var25) {
                              class62.field738[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = Graphics3D.colorPalette[CombatInfo1.method1651(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, CombatInfo1.method1651(var30, var26), CombatInfo1.method1651(var30, var27), CombatInfo1.method1651(var30, var28), CombatInfo1.method1651(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class62.field734[var2][var11][var17] + 1;
                           byte var48 = class62.field739[var2][var11][var17];
                           Overlay var35 = class57.getOverlayDefinition(var21 - 1);
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
                              var37 = method192(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class62.field742 & 255;
                              var40 = var35.lightness + class62.field750;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = method192(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = Graphics3D.colorPalette[SoundTaskDataProvider.adjustHSLListness0(var38, 96)];
                           }

                           if(var35.otherRgbColor != -1) {
                              var40 = var35.otherHue + class62.field742 & 255;
                              int var41 = var35.otherLightness + class62.field750;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = method192(var40, var35.otherSaturation, var41);
                              var39 = Graphics3D.colorPalette[SoundTaskDataProvider.adjustHSLListness0(var38, 96)];
                           }

                           var0.addTile(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, CombatInfo1.method1651(var30, var26), CombatInfo1.method1651(var30, var27), CombatInfo1.method1651(var30, var28), CombatInfo1.method1651(var30, var29), SoundTaskDataProvider.adjustHSLListness0(var37, var26), SoundTaskDataProvider.adjustHSLListness0(var37, var27), SoundTaskDataProvider.adjustHSLListness0(var37, var28), SoundTaskDataProvider.adjustHSLListness0(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((class62.tileSettings[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && (class62.tileSettings[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.setPhysicalLevel(var2, var12, var11, var17);
            }
         }

         UrlRequest.field2107[var2] = null;
         class62.field744[var2] = null;
         class62.field734[var2] = null;
         class62.field739[var2] = null;
         class62.field740[var2] = null;
      }

      var0.applyLighting(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class62.tileSettings[1][var2][var3] & 2) == 2) {
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
                  short var46;
                  if((class62.field738[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class62.field738[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class62.field738[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label464:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class62.field738[var11 - 1][var8][var13] & var2) == 0) {
                              break label464;
                           }
                        }

                        --var11;
                     }

                     label453:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class62.field738[var12 + 1][var8][var13] & var2) == 0) {
                              break label453;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class62.tileHeights[var12][var8][var9] - var46;
                        var16 = class62.tileHeights[var11][var8][var9];
                        Region.addOcclude(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class62.field738[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class62.field738[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class62.field738[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class62.field738[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label517:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class62.field738[var11 - 1][var13][var7] & var3) == 0) {
                              break label517;
                           }
                        }

                        --var11;
                     }

                     label506:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class62.field738[var12 + 1][var13][var7] & var3) == 0) {
                              break label506;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class62.tileHeights[var12][var9][var7] - var46;
                        var16 = class62.tileHeights[var11][var9][var7];
                        Region.addOcclude(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class62.field738[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class62.field738[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class62.field738[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class62.field738[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label570:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class62.field738[var6][var9 - 1][var13] & var4) == 0) {
                              break label570;
                           }
                        }

                        --var9;
                     }

                     label559:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class62.field738[var6][var10 + 1][var13] & var4) == 0) {
                              break label559;
                           }
                        }

                        ++var10;
                     }

                     if((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
                        var13 = class62.tileHeights[var6][var9][var11];
                        Region.addOcclude(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class62.field738[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-76"
   )
   static final int method192(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
