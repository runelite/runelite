import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class36 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   static final class36 field522;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   static final class36 field524;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 677831097
   )
   final int field523;

   static {
      field522 = new class36(0);
      field524 = new class36(1);
   }

   class36(int var1) {
      this.field523 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "751789724"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Leb;IIIIB)V",
      garbageValue = "27"
   )
   public static final void method489(Model var0, int var1, int var2, int var3, int var4) {
      class7.field247.method3660(new class10(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfd;IB)V",
      garbageValue = "2"
   )
   static final void method487(PacketBuffer var0, int var1) {
      int var2 = var0.offset;
      class94.field1486 = 0;
      int var3 = 0;
      var0.bitAccess();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class94.playerIndexesCount; ++var4) {
         var5 = class94.field1480[var4];
         if((class94.field1476[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class94.field1476[var5] = (byte)(class94.field1476[var5] | 2);
            } else {
               var6 = var0.getBits(1);
               if(var6 == 0) {
                  var3 = KeyFocusListener.method785(var0);
                  class94.field1476[var5] = (byte)(class94.field1476[var5] | 2);
               } else {
                  class88.decodeMovement(var0, var5);
               }
            }
         }
      }

      var0.byteAccess();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var4 = 0; var4 < class94.playerIndexesCount; ++var4) {
            var5 = class94.field1480[var4];
            if((class94.field1476[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class94.field1476[var5] = (byte)(class94.field1476[var5] | 2);
               } else {
                  var6 = var0.getBits(1);
                  if(var6 == 0) {
                     var3 = KeyFocusListener.method785(var0);
                     class94.field1476[var5] = (byte)(class94.field1476[var5] | 2);
                  } else {
                     class88.decodeMovement(var0, var5);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var4 = 0; var4 < class94.field1474; ++var4) {
               var5 = class94.field1482[var4];
               if((class94.field1476[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class94.field1476[var5] = (byte)(class94.field1476[var5] | 2);
                  } else {
                     var6 = var0.getBits(1);
                     if(var6 == 0) {
                        var3 = KeyFocusListener.method785(var0);
                        class94.field1476[var5] = (byte)(class94.field1476[var5] | 2);
                     } else if(RSSocket.decodeRegionHash(var0, var5)) {
                        class94.field1476[var5] = (byte)(class94.field1476[var5] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var4 = 0; var4 < class94.field1474; ++var4) {
                  var5 = class94.field1482[var4];
                  if((class94.field1476[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class94.field1476[var5] = (byte)(class94.field1476[var5] | 2);
                     } else {
                        var6 = var0.getBits(1);
                        if(var6 == 0) {
                           var3 = KeyFocusListener.method785(var0);
                           class94.field1476[var5] = (byte)(class94.field1476[var5] | 2);
                        } else if(RSSocket.decodeRegionHash(var0, var5)) {
                           class94.field1476[var5] = (byte)(class94.field1476[var5] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class94.playerIndexesCount = 0;
                  class94.field1474 = 0;

                  for(var4 = 1; var4 < 2048; ++var4) {
                     class94.field1476[var4] = (byte)(class94.field1476[var4] >> 1);
                     Player var7 = Client.cachedPlayers[var4];
                     if(var7 != null) {
                        class94.field1480[++class94.playerIndexesCount - 1] = var4;
                     } else {
                        class94.field1482[++class94.field1474 - 1] = var4;
                     }
                  }

                  class60.method1065(var0);
                  if(var0.offset - var2 != var1) {
                     throw new RuntimeException(var0.offset - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lem;[Lfq;I)V",
      garbageValue = "-131080087"
   )
   static final void method490(Region var0, CollisionData[] var1) {
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
                     var1[var5].method3112(var3, var4);
                  }
               }
            }
         }
      }

      class61.field776 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field776 < -8) {
         class61.field776 = -8;
      }

      if(class61.field776 > 8) {
         class61.field776 = 8;
      }

      class61.field777 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field777 < -16) {
         class61.field777 = -16;
      }

      if(class61.field777 > 16) {
         class61.field777 = 16;
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
         byte[][] var42 = class174.field2411[var2];
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
               var19 = 96 + (var16 * -50 + var18 * -50 + var17 * -10) / var10;
               var20 = (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11 + 1] >> 3) + (var42[var12][var11] >> 1);
               class60.field762[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class170.blendedHue[var11] = 0;
            class35.blendedSaturation[var11] = 0;
            class10.field262[var11] = 0;
            class61.field769[var11] = 0;
            Huffman.field2332[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class61.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = class72.method1166(var14 - 1);
                     class170.blendedHue[var12] += var43.hue;
                     class35.blendedSaturation[var12] += var43.saturation;
                     class10.field262[var12] += var43.lightness;
                     class61.field769[var12] += var43.hueMultiplier;
                     ++Huffman.field2332[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class61.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = class72.method1166(var15 - 1);
                     class170.blendedHue[var12] -= var44.hue;
                     class35.blendedSaturation[var12] -= var44.saturation;
                     class10.field262[var12] -= var44.lightness;
                     class61.field769[var12] -= var44.hueMultiplier;
                     --Huffman.field2332[var12];
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
                     var12 += class170.blendedHue[var18];
                     var13 += class35.blendedSaturation[var18];
                     var14 += class10.field262[var18];
                     var15 += class61.field769[var18];
                     var16 += Huffman.field2332[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class170.blendedHue[var19];
                     var13 -= class35.blendedSaturation[var19];
                     var14 -= class10.field262[var19];
                     var15 -= class61.field769[var19];
                     var16 -= Huffman.field2332[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.lowMemory || (class61.tileSettings[0][var11][var17] & 2) != 0 || (class61.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class61.field773) {
                        class61.field773 = var2;
                     }

                     var20 = class61.underlayIds[var2][var11][var17] & 255;
                     int var21 = class61.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class61.tileHeights[var2][var11][var17];
                        int var23 = class61.tileHeights[var2][var11 + 1][var17];
                        int var24 = class61.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class61.tileHeights[var2][var11][var17 + 1];
                        int var26 = class60.field762[var11][var17];
                        int var27 = class60.field762[var11 + 1][var17];
                        int var28 = class60.field762[var11 + 1][var17 + 1];
                        int var29 = class60.field762[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = SceneTilePaint.method2753(var32, var33, var34);
                           var32 = var32 + class61.field776 & 255;
                           var34 += class61.field777;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = SceneTilePaint.method2753(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var47 = true;
                           if(var20 == 0 && class277.overlayPaths[var2][var11][var17] != 0) {
                              var47 = false;
                           }

                           if(var21 > 0 && !class43.method626(var21 - 1).isHidden) {
                              var47 = false;
                           }

                           if(var47 && var23 == var22 && var22 == var24 && var25 == var22) {
                              class168.field2350[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = Graphics3D.colorPalette[class147.method2980(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class147.method2980(var30, var26), class147.method2980(var30, var27), class147.method2980(var30, var28), class147.method2980(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class277.overlayPaths[var2][var11][var17] + 1;
                           byte var48 = class61.overlayRotations[var2][var11][var17];
                           Overlay var35 = class43.method626(var21 - 1);
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
                              var37 = SceneTilePaint.method2753(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class61.field776 & 255;
                              var40 = var35.lightness + class61.field777;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = SceneTilePaint.method2753(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = Graphics3D.colorPalette[ChatLineBuffer.adjustHSLListness0(var38, 96)];
                           }

                           if(var35.otherRgbColor != -1) {
                              var40 = var35.otherHue + class61.field776 & 255;
                              int var41 = var35.otherLightness + class61.field777;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = SceneTilePaint.method2753(var40, var35.otherSaturation, var41);
                              var39 = Graphics3D.colorPalette[ChatLineBuffer.adjustHSLListness0(var38, 96)];
                           }

                           var0.addTile(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, class147.method2980(var30, var26), class147.method2980(var30, var27), class147.method2980(var30, var28), class147.method2980(var30, var29), ChatLineBuffer.adjustHSLListness0(var37, var26), ChatLineBuffer.adjustHSLListness0(var37, var27), ChatLineBuffer.adjustHSLListness0(var37, var28), ChatLineBuffer.adjustHSLListness0(var37, var29), var32, var39);
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

         class61.underlayIds[var2] = null;
         class61.overlayIds[var2] = null;
         class277.overlayPaths[var2] = null;
         class61.overlayRotations[var2] = null;
         class174.field2411[var2] = null;
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
                  if((class168.field2350[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class168.field2350[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class168.field2350[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label476:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class168.field2350[var11 - 1][var8][var13] & var2) == 0) {
                              break label476;
                           }
                        }

                        --var11;
                     }

                     label465:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class168.field2350[var12 + 1][var8][var13] & var2) == 0) {
                              break label465;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class61.tileHeights[var12][var8][var9] - var46;
                        var16 = class61.tileHeights[var11][var8][var9];
                        Region.addOcclude(var5, 1, var8 * 128, var8 * 128, var9 * 128, 128 + var10 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class168.field2350[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class168.field2350[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class168.field2350[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class168.field2350[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label529:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class168.field2350[var11 - 1][var13][var7] & var3) == 0) {
                              break label529;
                           }
                        }

                        --var11;
                     }

                     label518:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if(0 == (class168.field2350[var12 + 1][var13][var7] & var3)) {
                              break label518;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class61.tileHeights[var12][var9][var7] - var46;
                        var16 = class61.tileHeights[var11][var9][var7];
                        Region.addOcclude(var5, 2, var9 * 128, 128 + var10 * 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class168.field2350[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class168.field2350[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class168.field2350[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class168.field2350[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label582:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class168.field2350[var6][var9 - 1][var13] & var4) == 0) {
                              break label582;
                           }
                        }

                        --var9;
                     }

                     label571:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class168.field2350[var6][var10 + 1][var13] & var4) == 0) {
                              break label571;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var13 = class61.tileHeights[var6][var9][var11];
                        Region.addOcclude(var5, 4, var9 * 128, 128 + var10 * 128, var11 * 128, 128 + var12 * 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class168.field2350[var6][var14][var15] &= ~var4;
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
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "1285881737"
   )
   static long method491(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }
}
