import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1337676609
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1978740677
   )
   @Export("hitpoints")
   int hitpoints;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1648534887
   )
   int field1209;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -758166215
   )
   @Export("level")
   int level;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1807380857
   )
   int field1206;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1705296339
   )
   @Export("type")
   int type;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1939443135
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -960555641
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1171203245
   )
   int field1210;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1368650421
   )
   @Export("id")
   int id;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1037812797
   )
   int field1214;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1403360003
   )
   @Export("orientation")
   int orientation;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Ljf;",
      garbageValue = "1312415876"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "328603127"
   )
   static final void method1521(int var0) {
      short var1 = 256;
      class93.field1464 += var0 * 128;
      int var2;
      if(class93.field1464 > class93.field1456.length) {
         class93.field1464 -= class93.field1456.length;
         var2 = (int)(Math.random() * 12.0D);
         class44.method654(class93.field1437[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = Ignore.field871[var2 + var3] - var0 * class93.field1456[var2 + class93.field1464 & class93.field1456.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         Ignore.field871[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               Ignore.field871[var6 + var7] = 255;
            } else {
               Ignore.field871[var6 + var7] = 0;
            }
         }
      }

      if(class93.field1441 > 0) {
         class93.field1441 -= var0 * 4;
      }

      if(class93.field1442 > 0) {
         class93.field1442 -= var0 * 4;
      }

      if(class93.field1441 == 0 && class93.field1442 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class93.field1441 = 1024;
         }

         if(var5 == 1) {
            class93.field1442 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class93.field1439[var5] = class93.field1439[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class93.field1439[var5] = (int)(Math.sin((double)class93.field1458 / 14.0D) * 16.0D + Math.sin((double)class93.field1458 / 15.0D) * 14.0D + Math.sin((double)class93.field1458 / 16.0D) * 12.0D);
         ++class93.field1458;
      }

      class93.field1438 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class93.field1438 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            Ignore.field871[var7 + (var8 << 7)] = 192;
         }

         class93.field1438 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += Ignore.field871[var5 + var9 + var8];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= Ignore.field871[var9 + var8 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  class93.field1444[var9 + var8] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var5 + var8 < var1) {
                  var7 += class93.field1444[var5 * 128 + var6 + var9];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= class93.field1444[var9 + var6 - 128 * (var5 + 1)];
               }

               if(var8 >= 0) {
                  Ignore.field871[var6 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lez;[Lfc;I)V",
      garbageValue = "-2147483643"
   )
   static final void method1523(Region var0, CollisionData[] var1) {
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
                     var1[var5].method3047(var3, var4);
                  }
               }
            }
         }
      }

      class61.field773 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field773 < -8) {
         class61.field773 = -8;
      }

      if(class61.field773 > 8) {
         class61.field773 = 8;
      }

      class61.field774 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field774 < -16) {
         class61.field774 = -16;
      }

      if(class61.field774 > 16) {
         class61.field774 = 16;
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
         byte[][] var42 = class61.field784[var2];
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
               var19 = 96 + (var16 * -50 + var17 * -10 + var18 * -50) / var10;
               var20 = (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11 + 1] >> 3) + (var42[var12][var11] >> 1);
               WorldMapType2.field530[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class61.blendedHue[var11] = 0;
            WorldMapType1.blendedSaturation[var11] = 0;
            class31.field456[var11] = 0;
            Huffman.field2325[var11] = 0;
            class51.field661[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class61.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = class60.method1071(var14 - 1);
                     class61.blendedHue[var12] += var43.hue;
                     WorldMapType1.blendedSaturation[var12] += var43.saturation;
                     class31.field456[var12] += var43.lightness;
                     Huffman.field2325[var12] += var43.hueMultiplier;
                     ++class51.field661[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class61.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = class60.method1071(var15 - 1);
                     class61.blendedHue[var12] -= var44.hue;
                     WorldMapType1.blendedSaturation[var12] -= var44.saturation;
                     class31.field456[var12] -= var44.lightness;
                     Huffman.field2325[var12] -= var44.hueMultiplier;
                     --class51.field661[var12];
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
                     var13 += WorldMapType1.blendedSaturation[var18];
                     var14 += class31.field456[var18];
                     var15 += Huffman.field2325[var18];
                     var16 += class51.field661[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class61.blendedHue[var19];
                     var13 -= WorldMapType1.blendedSaturation[var19];
                     var14 -= class31.field456[var19];
                     var15 -= Huffman.field2325[var19];
                     var16 -= class51.field661[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.lowMemory || (class61.tileSettings[0][var11][var17] & 2) != 0 || (class61.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class61.field761) {
                        class61.field761 = var2;
                     }

                     var20 = class61.underlayIds[var2][var11][var17] & 255;
                     int var21 = class61.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class61.tileHeights[var2][var11][var17];
                        int var23 = class61.tileHeights[var2][var11 + 1][var17];
                        int var24 = class61.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class61.tileHeights[var2][var11][var17 + 1];
                        int var26 = WorldMapType2.field530[var11][var17];
                        int var27 = WorldMapType2.field530[var11 + 1][var17];
                        int var28 = WorldMapType2.field530[var11 + 1][var17 + 1];
                        int var29 = WorldMapType2.field530[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = RSSocket.method3023(var32, var33, var34);
                           var32 = var32 + class61.field773 & 255;
                           var34 += class61.field774;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = RSSocket.method3023(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var47 = true;
                           if(var20 == 0 && class61.overlayPaths[var2][var11][var17] != 0) {
                              var47 = false;
                           }

                           if(var21 > 0 && !NPCComposition.method4664(var21 - 1).isHidden) {
                              var47 = false;
                           }

                           if(var47 && var22 == var23 && var24 == var22 && var22 == var25) {
                              class240.field3259[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = Graphics3D.colorPalette[class92.method1731(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class92.method1731(var30, var26), class92.method1731(var30, var27), class92.method1731(var30, var28), class92.method1731(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class61.overlayPaths[var2][var11][var17] + 1;
                           byte var48 = class61.overlayRotations[var2][var11][var17];
                           Overlay var35 = NPCComposition.method4664(var21 - 1);
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
                              var37 = RSSocket.method3023(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class61.field773 & 255;
                              var40 = var35.lightness + class61.field774;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = RSSocket.method3023(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = Graphics3D.colorPalette[class89.adjustHSLListness0(var38, 96)];
                           }

                           if(var35.otherRgbColor != -1) {
                              var40 = var35.otherHue + class61.field773 & 255;
                              int var41 = var35.otherLightness + class61.field774;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = RSSocket.method3023(var40, var35.otherSaturation, var41);
                              var39 = Graphics3D.colorPalette[class89.adjustHSLListness0(var38, 96)];
                           }

                           var0.addTile(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, class92.method1731(var30, var26), class92.method1731(var30, var27), class92.method1731(var30, var28), class92.method1731(var30, var29), class89.adjustHSLListness0(var37, var26), class89.adjustHSLListness0(var37, var27), class89.adjustHSLListness0(var37, var28), class89.adjustHSLListness0(var37, var29), var32, var39);
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
         class61.overlayPaths[var2] = null;
         class61.overlayRotations[var2] = null;
         class61.field784[var2] = null;
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
                  if((class240.field3259[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class240.field3259[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class240.field3259[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label484:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class240.field3259[var11 - 1][var8][var13] & var2) == 0) {
                              break label484;
                           }
                        }

                        --var11;
                     }

                     label473:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class240.field3259[var12 + 1][var8][var13] & var2) == 0) {
                              break label473;
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
                              class240.field3259[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class240.field3259[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class240.field3259[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && 0 != (class240.field3259[var6][var10 + 1][var7] & var3)) {
                        ++var10;
                     }

                     label537:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class240.field3259[var11 - 1][var13][var7] & var3) == 0) {
                              break label537;
                           }
                        }

                        --var11;
                     }

                     label526:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class240.field3259[var12 + 1][var13][var7] & var3) == 0) {
                              break label526;
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
                              class240.field3259[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class240.field3259[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class240.field3259[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class240.field3259[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label590:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class240.field3259[var6][var9 - 1][var13] & var4) == 0) {
                              break label590;
                           }
                        }

                        --var9;
                     }

                     label579:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if(0 == (class240.field3259[var6][var10 + 1][var13] & var4)) {
                              break label579;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var13 = class61.tileHeights[var6][var9][var11];
                        Region.addOcclude(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class240.field3259[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Ljp;",
      garbageValue = "-1575271735"
   )
   public static class284[] method1524() {
      return new class284[]{class284.field3754, class284.field3753, class284.field3752, class284.field3755, class284.field3757};
   }
}
