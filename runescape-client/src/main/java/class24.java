import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class24 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   static final class24 field222;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   static final class24 field217;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Llc;"
   )
   static SpritePixels field224;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = -2015070493
   )
   static int field220;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -942512239
   )
   final int field219;

   static {
      field222 = new class24(0);
      field217 = new class24(1);
   }

   class24(int var1) {
      this.field219 = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ldt;[Lfm;I)V",
      garbageValue = "-1918380857"
   )
   static final void method457(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class50.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class50.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method3437(var3, var4);
                  }
               }
            }
         }
      }

      class50.field462 += (int)(Math.random() * 5.0D) - 2;
      if(class50.field462 < -8) {
         class50.field462 = -8;
      }

      if(class50.field462 > 8) {
         class50.field462 = 8;
      }

      class50.field461 += (int)(Math.random() * 5.0D) - 2;
      if(class50.field461 < -16) {
         class50.field461 = -16;
      }

      if(class50.field461 > 16) {
         class50.field461 = 16;
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
         byte[][] var42 = class50.field449[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class50.tileHeights[var2][var12 + 1][var11] - class50.tileHeights[var2][var12 - 1][var11];
               var14 = class50.tileHeights[var2][var12][var11 + 1] - class50.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + var14 * var14 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var16 * -50 + var18 * -50 + var17 * -10) / var10 + 96;
               var20 = (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11 + 1] >> 3) + (var42[var12][var11] >> 1);
               WorldMapDecoration.field162[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class50.floorHues[var11] = 0;
            Size.floorSaturations[var11] = 0;
            class50.field451[var11] = 0;
            MapIconReference.floorMultiplier[var11] = 0;
            class50.field452[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class50.tileUnderlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = UrlRequester.getUnderlayDefinition(var14 - 1);
                     class50.floorHues[var12] += var43.hue;
                     Size.floorSaturations[var12] += var43.saturation;
                     class50.field451[var12] += var43.lightness;
                     MapIconReference.floorMultiplier[var12] += var43.hueMultiplier;
                     ++class50.field452[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class50.tileUnderlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var45 = UrlRequester.getUnderlayDefinition(var15 - 1);
                     class50.floorHues[var12] -= var45.hue;
                     Size.floorSaturations[var12] -= var45.saturation;
                     class50.field451[var12] -= var45.lightness;
                     MapIconReference.floorMultiplier[var12] -= var45.hueMultiplier;
                     --class50.field452[var12];
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
                     var12 += class50.floorHues[var18];
                     var13 += Size.floorSaturations[var18];
                     var14 += class50.field451[var18];
                     var15 += MapIconReference.floorMultiplier[var18];
                     var16 += class50.field452[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class50.floorHues[var19];
                     var13 -= Size.floorSaturations[var19];
                     var14 -= class50.field451[var19];
                     var15 -= MapIconReference.floorMultiplier[var19];
                     var16 -= class50.field452[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.lowMemory || (class50.tileSettings[0][var11][var17] & 2) != 0 || (class50.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class50.field446) {
                        class50.field446 = var2;
                     }

                     var20 = class50.tileUnderlayIds[var2][var11][var17] & 255;
                     int var21 = class139.tileOverlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class50.tileHeights[var2][var11][var17];
                        int var23 = class50.tileHeights[var2][var11 + 1][var17];
                        int var24 = class50.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class50.tileHeights[var2][var11][var17 + 1];
                        int var26 = WorldMapDecoration.field162[var11][var17];
                        int var27 = WorldMapDecoration.field162[var11 + 1][var17];
                        int var28 = WorldMapDecoration.field162[var11 + 1][var17 + 1];
                        int var29 = WorldMapDecoration.field162[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class158.method3315(var32, var33, var34);
                           var32 = var32 + class50.field462 & 255;
                           var34 += class50.field461;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class158.method3315(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var47 = true;
                           if(var20 == 0 && NPC.tileOverlayPath[var2][var11][var17] != 0) {
                              var47 = false;
                           }

                           if(var21 > 0 && !class148.getOverlayDefinition(var21 - 1).isHidden) {
                              var47 = false;
                           }

                           if(var47 && var23 == var22 && var22 == var24 && var22 == var25) {
                              MouseRecorder.field534[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = Graphics3D.colorPalette[class16.method185(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class16.method185(var30, var26), class16.method185(var30, var27), class16.method185(var30, var28), class16.method185(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = NPC.tileOverlayPath[var2][var11][var17] + 1;
                           byte var48 = class50.overlayRotations[var2][var11][var17];
                           Overlay var35 = class148.getOverlayDefinition(var21 - 1);
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
                              var37 = class158.method3315(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class50.field462 & 255;
                              var40 = var35.lightness + class50.field461;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class158.method3315(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = Graphics3D.colorPalette[KeyFocusListener.adjustHSLListness0(var38, 96)];
                           }

                           if(var35.otherRgbColor != -1) {
                              var40 = var35.otherHue + class50.field462 & 255;
                              int var41 = var35.otherLightness + class50.field461;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class158.method3315(var40, var35.otherSaturation, var41);
                              var39 = Graphics3D.colorPalette[KeyFocusListener.adjustHSLListness0(var38, 96)];
                           }

                           var0.addTile(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, class16.method185(var30, var26), class16.method185(var30, var27), class16.method185(var30, var28), class16.method185(var30, var29), KeyFocusListener.adjustHSLListness0(var37, var26), KeyFocusListener.adjustHSLListness0(var37, var27), KeyFocusListener.adjustHSLListness0(var37, var28), KeyFocusListener.adjustHSLListness0(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((class50.tileSettings[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && (class50.tileSettings[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.setPhysicalLevel(var2, var12, var11, var17);
            }
         }

         class50.tileUnderlayIds[var2] = null;
         class139.tileOverlayIds[var2] = null;
         NPC.tileOverlayPath[var2] = null;
         class50.overlayRotations[var2] = null;
         class50.field449[var2] = null;
      }

      var0.applyLighting(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class50.tileSettings[1][var2][var3] & 2) == 2) {
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
                  if((MouseRecorder.field534[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (MouseRecorder.field534[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (MouseRecorder.field534[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label476:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((MouseRecorder.field534[var11 - 1][var8][var13] & var2) == 0) {
                              break label476;
                           }
                        }

                        --var11;
                     }

                     label465:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((MouseRecorder.field534[var12 + 1][var8][var13] & var2) == 0) {
                              break label465;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class50.tileHeights[var12][var8][var9] - var46;
                        var16 = class50.tileHeights[var11][var8][var9];
                        Region.addOcclude(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              MouseRecorder.field534[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((MouseRecorder.field534[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (MouseRecorder.field534[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (MouseRecorder.field534[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label529:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((MouseRecorder.field534[var11 - 1][var13][var7] & var3) == 0) {
                              break label529;
                           }
                        }

                        --var11;
                     }

                     label518:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((MouseRecorder.field534[var12 + 1][var13][var7] & var3) == 0) {
                              break label518;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class50.tileHeights[var12][var9][var7] - var46;
                        var16 = class50.tileHeights[var11][var9][var7];
                        Region.addOcclude(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              MouseRecorder.field534[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((MouseRecorder.field534[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (MouseRecorder.field534[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (MouseRecorder.field534[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label582:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((MouseRecorder.field534[var6][var9 - 1][var13] & var4) == 0) {
                              break label582;
                           }
                        }

                        --var9;
                     }

                     label571:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((MouseRecorder.field534[var6][var10 + 1][var13] & var4) == 0) {
                              break label571;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var13 = class50.tileHeights[var6][var9][var11];
                        Region.addOcclude(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              MouseRecorder.field534[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "2"
   )
   public static final void method460(int var0, int var1) {
      class120.Viewport_mouseX = var0;
      class120.Viewport_mouseY = var1;
      class120.Viewport_containsMouse = true;
      class120.Viewport_entityCountAtMouse = 0;
      class120.Viewport_false0 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-499931776"
   )
   public static void method462() {
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lic;",
      garbageValue = "-1721943618"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class155.dat2File != null) {
         var4 = new IndexFile(var0, class155.dat2File, class155.idxFiles[var0], 1000000);
      }

      return new IndexData(var4, World.indexStore255, var0, var1, var2, var3);
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   static final void method458() {
      int var0 = class81.playerIndexesCount;
      int[] var1 = class81.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            class68.method1747(var3, 1);
         }
      }

   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1978186516"
   )
   static final void method459(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != class192.plane) {
            return;
         }

         long var7 = 0L;
         boolean var9 = true;
         boolean var10 = false;
         boolean var11 = false;
         if(var1 == 0) {
            var7 = ScriptEvent.region.method2927(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = ScriptEvent.region.method2928(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = ScriptEvent.region.method3045(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = ScriptEvent.region.method2930(var0, var2, var3);
         }

         int var12;
         if(0L != var7) {
            var12 = ScriptEvent.region.method2931(var0, var2, var3, var7);
            int var39 = class8.method93(var7);
            int var40 = var12 & 31;
            int var41 = var12 >> 6 & 3;
            ObjectComposition var13;
            if(var1 == 0) {
               ScriptEvent.region.method2954(var0, var2, var3);
               var13 = SoundTaskDataProvider.getObjectDefinition(var39);
               if(var13.clipType != 0) {
                  Client.collisionMaps[var0].method3419(var2, var3, var40, var41, var13.blocksProjectile);
               }
            }

            if(var1 == 1) {
               ScriptEvent.region.method2919(var0, var2, var3);
            }

            if(var1 == 2) {
               ScriptEvent.region.method3013(var0, var2, var3);
               var13 = SoundTaskDataProvider.getObjectDefinition(var39);
               if(var2 + var13.width > 103 || var3 + var13.width > 103 || var2 + var13.length > 103 || var3 + var13.length > 103) {
                  return;
               }

               if(var13.clipType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var13.width, var13.length, var41, var13.blocksProjectile);
               }
            }

            if(var1 == 3) {
               ScriptEvent.region.method2921(var0, var2, var3);
               var13 = SoundTaskDataProvider.getObjectDefinition(var39);
               if(var13.clipType == 1) {
                  Client.collisionMaps[var0].method3434(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var12 = var0;
            if(var0 < 3 && (class50.tileSettings[1][var2][var3] & 2) == 2) {
               var12 = var0 + 1;
            }

            Region var42 = ScriptEvent.region;
            CollisionData var14 = Client.collisionMaps[var0];
            ObjectComposition var15 = SoundTaskDataProvider.getObjectDefinition(var4);
            int var16;
            int var17;
            if(var5 != 1 && var5 != 3) {
               var16 = var15.width;
               var17 = var15.length;
            } else {
               var16 = var15.length;
               var17 = var15.width;
            }

            int var18;
            int var19;
            if(var16 + var2 <= 104) {
               var18 = (var16 >> 1) + var2;
               var19 = var2 + (var16 + 1 >> 1);
            } else {
               var18 = var2;
               var19 = var2 + 1;
            }

            int var20;
            int var21;
            if(var3 + var17 <= 104) {
               var20 = var3 + (var17 >> 1);
               var21 = var3 + (var17 + 1 >> 1);
            } else {
               var20 = var3;
               var21 = var3 + 1;
            }

            int[][] var22 = class50.tileHeights[var12];
            int var23 = var22[var19][var21] + var22[var18][var20] + var22[var19][var20] + var22[var18][var21] >> 2;
            int var24 = (var2 << 7) + (var16 << 6);
            int var25 = (var3 << 7) + (var17 << 6);
            long var26 = class59.method1129(var2, var3, 2, var15.int1 == 0, var4);
            int var28 = (var5 << 6) + var6;
            if(var15.supportItems == 1) {
               var28 += 256;
            }

            Object var29;
            if(var6 == 22) {
               if(var15.animationId == -1 && var15.impostorIds == null) {
                  var29 = var15.method5052(22, var5, var22, var24, var23, var25);
               } else {
                  var29 = new DynamicObject(var4, 22, var5, var12, var2, var3, var15.animationId, true, (Renderable)null);
               }

               var42.groundObjectSpawned(var0, var2, var3, var23, (Renderable)var29, var26, var28);
               if(var15.clipType == 1) {
                  var14.method3424(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var15.animationId == -1 && var15.impostorIds == null) {
                     var29 = var15.method5052(var6, var5, var22, var24, var23, var25);
                  } else {
                     var29 = new DynamicObject(var4, var6, var5, var12, var2, var3, var15.animationId, true, (Renderable)null);
                  }

                  var42.method2911(var0, var2, var3, var23, 1, 1, (Renderable)var29, 0, var26, var28);
                  if(var15.clipType != 0) {
                     var14.addObject(var2, var3, var16, var17, var15.blocksProjectile);
                  }
               } else if(var6 == 0) {
                  if(var15.animationId == -1 && var15.impostorIds == null) {
                     var29 = var15.method5052(0, var5, var22, var24, var23, var25);
                  } else {
                     var29 = new DynamicObject(var4, 0, var5, var12, var2, var3, var15.animationId, true, (Renderable)null);
                  }

                  var42.addBoundary(var0, var2, var3, var23, (Renderable)var29, (Renderable)null, class50.field454[var5], 0, var26, var28);
                  if(var15.clipType != 0) {
                     var14.removeWall(var2, var3, var6, var5, var15.blocksProjectile);
                  }
               } else if(var6 == 1) {
                  if(var15.animationId == -1 && var15.impostorIds == null) {
                     var29 = var15.method5052(1, var5, var22, var24, var23, var25);
                  } else {
                     var29 = new DynamicObject(var4, 1, var5, var12, var2, var3, var15.animationId, true, (Renderable)null);
                  }

                  var42.addBoundary(var0, var2, var3, var23, (Renderable)var29, (Renderable)null, class50.field453[var5], 0, var26, var28);
                  if(var15.clipType != 0) {
                     var14.removeWall(var2, var3, var6, var5, var15.blocksProjectile);
                  }
               } else {
                  int var35;
                  if(var6 == 2) {
                     var35 = var5 + 1 & 3;
                     Object var30;
                     Object var31;
                     if(var15.animationId == -1 && var15.impostorIds == null) {
                        var30 = var15.method5052(2, var5 + 4, var22, var24, var23, var25);
                        var31 = var15.method5052(2, var35, var22, var24, var23, var25);
                     } else {
                        var30 = new DynamicObject(var4, 2, var5 + 4, var12, var2, var3, var15.animationId, true, (Renderable)null);
                        var31 = new DynamicObject(var4, 2, var35, var12, var2, var3, var15.animationId, true, (Renderable)null);
                     }

                     var42.addBoundary(var0, var2, var3, var23, (Renderable)var30, (Renderable)var31, class50.field454[var5], class50.field454[var35], var26, var28);
                     if(var15.clipType != 0) {
                        var14.removeWall(var2, var3, var6, var5, var15.blocksProjectile);
                     }
                  } else if(var6 == 3) {
                     if(var15.animationId == -1 && var15.impostorIds == null) {
                        var29 = var15.method5052(3, var5, var22, var24, var23, var25);
                     } else {
                        var29 = new DynamicObject(var4, 3, var5, var12, var2, var3, var15.animationId, true, (Renderable)null);
                     }

                     var42.addBoundary(var0, var2, var3, var23, (Renderable)var29, (Renderable)null, class50.field453[var5], 0, var26, var28);
                     if(var15.clipType != 0) {
                        var14.removeWall(var2, var3, var6, var5, var15.blocksProjectile);
                     }
                  } else if(var6 == 9) {
                     if(var15.animationId == -1 && var15.impostorIds == null) {
                        var29 = var15.method5052(var6, var5, var22, var24, var23, var25);
                     } else {
                        var29 = new DynamicObject(var4, var6, var5, var12, var2, var3, var15.animationId, true, (Renderable)null);
                     }

                     var42.method2911(var0, var2, var3, var23, 1, 1, (Renderable)var29, 0, var26, var28);
                     if(var15.clipType != 0) {
                        var14.addObject(var2, var3, var16, var17, var15.blocksProjectile);
                     }
                  } else if(var6 == 4) {
                     if(var15.animationId == -1 && var15.impostorIds == null) {
                        var29 = var15.method5052(4, var5, var22, var24, var23, var25);
                     } else {
                        var29 = new DynamicObject(var4, 4, var5, var12, var2, var3, var15.animationId, true, (Renderable)null);
                     }

                     var42.addBoundaryDecoration(var0, var2, var3, var23, (Renderable)var29, (Renderable)null, class50.field454[var5], 0, 0, 0, var26, var28);
                  } else {
                     Object var32;
                     long var36;
                     if(var6 == 5) {
                        var35 = 16;
                        var36 = var42.method2927(var0, var2, var3);
                        if(0L != var36) {
                           var35 = SoundTaskDataProvider.getObjectDefinition(class8.method93(var36)).decorDisplacement;
                        }

                        if(var15.animationId == -1 && var15.impostorIds == null) {
                           var32 = var15.method5052(4, var5, var22, var24, var23, var25);
                        } else {
                           var32 = new DynamicObject(var4, 4, var5, var12, var2, var3, var15.animationId, true, (Renderable)null);
                        }

                        var42.addBoundaryDecoration(var0, var2, var3, var23, (Renderable)var32, (Renderable)null, class50.field454[var5], 0, var35 * class50.field456[var5], var35 * class50.field457[var5], var26, var28);
                     } else if(var6 == 6) {
                        var35 = 8;
                        var36 = var42.method2927(var0, var2, var3);
                        if(0L != var36) {
                           var35 = SoundTaskDataProvider.getObjectDefinition(class8.method93(var36)).decorDisplacement / 2;
                        }

                        if(var15.animationId == -1 && var15.impostorIds == null) {
                           var32 = var15.method5052(4, var5 + 4, var22, var24, var23, var25);
                        } else {
                           var32 = new DynamicObject(var4, 4, var5 + 4, var12, var2, var3, var15.animationId, true, (Renderable)null);
                        }

                        var42.addBoundaryDecoration(var0, var2, var3, var23, (Renderable)var32, (Renderable)null, 256, var5, var35 * class50.field458[var5], var35 * class50.field459[var5], var26, var28);
                     } else if(var6 == 7) {
                        int var38 = var5 + 2 & 3;
                        if(var15.animationId == -1 && var15.impostorIds == null) {
                           var29 = var15.method5052(4, var38 + 4, var22, var24, var23, var25);
                        } else {
                           var29 = new DynamicObject(var4, 4, var38 + 4, var12, var2, var3, var15.animationId, true, (Renderable)null);
                        }

                        var42.addBoundaryDecoration(var0, var2, var3, var23, (Renderable)var29, (Renderable)null, 256, var38, 0, 0, var26, var28);
                     } else if(var6 == 8) {
                        var35 = 8;
                        var36 = var42.method2927(var0, var2, var3);
                        if(0L != var36) {
                           var35 = SoundTaskDataProvider.getObjectDefinition(class8.method93(var36)).decorDisplacement / 2;
                        }

                        int var34 = var5 + 2 & 3;
                        Object var33;
                        if(var15.animationId == -1 && var15.impostorIds == null) {
                           var32 = var15.method5052(4, var5 + 4, var22, var24, var23, var25);
                           var33 = var15.method5052(4, var34 + 4, var22, var24, var23, var25);
                        } else {
                           var32 = new DynamicObject(var4, 4, var5 + 4, var12, var2, var3, var15.animationId, true, (Renderable)null);
                           var33 = new DynamicObject(var4, 4, var34 + 4, var12, var2, var3, var15.animationId, true, (Renderable)null);
                        }

                        var42.addBoundaryDecoration(var0, var2, var3, var23, (Renderable)var32, (Renderable)var33, 256, var5, var35 * class50.field458[var5], var35 * class50.field459[var5], var26, var28);
                     }
                  }
               }
            } else {
               if(var15.animationId == -1 && var15.impostorIds == null) {
                  var29 = var15.method5052(10, var5, var22, var24, var23, var25);
               } else {
                  var29 = new DynamicObject(var4, 10, var5, var12, var2, var3, var15.animationId, true, (Renderable)null);
               }

               if(var29 != null) {
                  var42.method2911(var0, var2, var3, var23, var16, var17, (Renderable)var29, var6 == 11?256:0, var26, var28);
               }

               if(var15.clipType != 0) {
                  var14.addObject(var2, var3, var16, var17, var15.blocksProjectile);
               }
            }
         }
      }

   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   static void method463(int var0, int var1) {
      int var2 = WidgetNode.fontBold12.getTextWidth("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         var4 = WidgetNode.fontBold12.getTextWidth(class234.method4595(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      var4 = var0 - var2 / 2;
      if(var4 + var2 > class9.canvasWidth) {
         var4 = class9.canvasWidth - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var1 + var3 > class37.canvasHeight) {
         var5 = class37.canvasHeight - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      class35.menuX = var4;
      class59.menuY = var5;
      class139.field1897 = var2;
      class137.field1888 = Client.menuOptionCount * 15 + 22;
   }
}
