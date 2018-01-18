import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public abstract class class168 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -509292497
   )
   static int field2246;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -955653027
   )
   public int field2243;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 79136717
   )
   public int field2242;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -423750441
   )
   public int field2244;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1293370551
   )
   public int field2245;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIILfi;I)Z",
      garbageValue = "1264078136"
   )
   public abstract boolean vmethod3237(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Leh;[Lfi;I)V",
      garbageValue = "-345499967"
   )
   static final void method3242(Region var0, CollisionData[] var1) {
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
                     var1[var5].method3198(var3, var4);
                  }
               }
            }
         }
      }

      class61.field740 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field740 < -8) {
         class61.field740 = -8;
      }

      if(class61.field740 > 8) {
         class61.field740 = 8;
      }

      class61.field732 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field732 < -16) {
         class61.field732 = -16;
      }

      if(class61.field732 > 16) {
         class61.field732 = 16;
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
         byte[][] var42 = class115.field1595[var2];
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
               var19 = (var18 * -50 + var16 * -50 + var17 * -10) / var10 + 96;
               var20 = (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11 + 1] >> 3) + (var42[var12][var11] >> 1);
               class61.field730[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class60.field721[var11] = 0;
            class161.field2189[var11] = 0;
            class263.field3483[var11] = 0;
            WidgetNode.field788[var11] = 0;
            class54.field639[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class61.field734[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = class72.getUnderlayDefinition(var14 - 1);
                     class60.field721[var12] += var43.hue;
                     class161.field2189[var12] += var43.saturation;
                     class263.field3483[var12] += var43.lightness;
                     WidgetNode.field788[var12] += var43.hueMultiplier;
                     ++class54.field639[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class61.field734[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = class72.getUnderlayDefinition(var15 - 1);
                     class60.field721[var12] -= var44.hue;
                     class161.field2189[var12] -= var44.saturation;
                     class263.field3483[var12] -= var44.lightness;
                     WidgetNode.field788[var12] -= var44.hueMultiplier;
                     --class54.field639[var12];
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
                     var12 += class60.field721[var18];
                     var13 += class161.field2189[var18];
                     var14 += class263.field3483[var18];
                     var15 += WidgetNode.field788[var18];
                     var16 += class54.field639[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class60.field721[var19];
                     var13 -= class161.field2189[var19];
                     var14 -= class263.field3483[var19];
                     var15 -= WidgetNode.field788[var19];
                     var16 -= class54.field639[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.lowMemory || (class61.tileSettings[0][var11][var17] & 2) != 0 || (class61.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class61.field729) {
                        class61.field729 = var2;
                     }

                     var20 = class61.field734[var2][var11][var17] & 255;
                     int var21 = class61.field731[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class61.tileHeights[var2][var11][var17];
                        int var23 = class61.tileHeights[var2][var11 + 1][var17];
                        int var24 = class61.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class61.tileHeights[var2][var11][var17 + 1];
                        int var26 = class61.field730[var11][var17];
                        int var27 = class61.field730[var11 + 1][var17];
                        int var28 = class61.field730[var11 + 1][var17 + 1];
                        int var29 = class61.field730[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class188.method3600(var32, var33, var34);
                           var32 = var32 + class61.field740 & 255;
                           var34 += class61.field732;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class188.method3600(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var47 = true;
                           if(var20 == 0 && class61.field733[var2][var11][var17] != 0) {
                              var47 = false;
                           }

                           if(var21 > 0 && !class150.getOverlayDefinition(var21 - 1).isHidden) {
                              var47 = false;
                           }

                           if(var47 && var22 == var23 && var22 == var24 && var25 == var22) {
                              class161.field2183[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = Graphics3D.colorPalette[UrlRequest.method2984(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, UrlRequest.method2984(var30, var26), UrlRequest.method2984(var30, var27), UrlRequest.method2984(var30, var28), UrlRequest.method2984(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class61.field733[var2][var11][var17] + 1;
                           byte var48 = class37.field487[var2][var11][var17];
                           Overlay var35 = class150.getOverlayDefinition(var21 - 1);
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
                              var37 = class188.method3600(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class61.field740 & 255;
                              var40 = var35.lightness + class61.field732;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class188.method3600(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = Graphics3D.colorPalette[AbstractByteBuffer.adjustHSLListness0(var38, 96)];
                           }

                           if(var35.otherRgbColor != -1) {
                              var40 = var35.otherHue + class61.field740 & 255;
                              int var41 = var35.otherLightness + class61.field732;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class188.method3600(var40, var35.otherSaturation, var41);
                              var39 = Graphics3D.colorPalette[AbstractByteBuffer.adjustHSLListness0(var38, 96)];
                           }

                           var0.addTile(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, UrlRequest.method2984(var30, var26), UrlRequest.method2984(var30, var27), UrlRequest.method2984(var30, var28), UrlRequest.method2984(var30, var29), AbstractByteBuffer.adjustHSLListness0(var37, var26), AbstractByteBuffer.adjustHSLListness0(var37, var27), AbstractByteBuffer.adjustHSLListness0(var37, var28), AbstractByteBuffer.adjustHSLListness0(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((class61.tileSettings[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && (class61.tileSettings[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.setPhysicalLevel(var2, var12, var11, var17);
            }
         }

         class61.field734[var2] = null;
         class61.field731[var2] = null;
         class61.field733[var2] = null;
         class37.field487[var2] = null;
         class115.field1595[var2] = null;
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
                  short var46;
                  if((class161.field2183[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class161.field2183[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class161.field2183[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label457:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class161.field2183[var11 - 1][var8][var13] & var2) == 0) {
                              break label457;
                           }
                        }

                        --var11;
                     }

                     label446:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class161.field2183[var12 + 1][var8][var13] & var2) == 0) {
                              break label446;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class61.tileHeights[var12][var8][var9] - var46;
                        var16 = class61.tileHeights[var11][var8][var9];
                        Region.addOcclude(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class161.field2183[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class161.field2183[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class161.field2183[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class161.field2183[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label510:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class161.field2183[var11 - 1][var13][var7] & var3) == 0) {
                              break label510;
                           }
                        }

                        --var11;
                     }

                     label499:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class161.field2183[var12 + 1][var13][var7] & var3) == 0) {
                              break label499;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class61.tileHeights[var12][var9][var7] - var46;
                        var16 = class61.tileHeights[var11][var9][var7];
                        Region.addOcclude(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class161.field2183[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class161.field2183[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class161.field2183[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class161.field2183[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label563:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class161.field2183[var6][var9 - 1][var13] & var4) == 0) {
                              break label563;
                           }
                        }

                        --var9;
                     }

                     label552:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class161.field2183[var6][var10 + 1][var13] & var4) == 0) {
                              break label552;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var13 = class61.tileHeights[var6][var9][var11];
                        Region.addOcclude(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class161.field2183[var6][var14][var15] &= ~var4;
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
