import java.awt.Canvas;
import java.awt.Color;
import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public class class107 {
   @ObfuscatedName("i")
   static File field1752;
   @ObfuscatedName("f")
   static boolean field1753 = false;
   @ObfuscatedName("u")
   static Hashtable field1754 = new Hashtable(16);

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "-669060499"
   )
   static final void method2077(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapScale + Client.mapAngle & 2047;
         int var8 = class84.field1475[var7];
         int var9 = class84.field1469[var7];
         var8 = var8 * 256 / (256 + Client.mapScaleDelta);
         var9 = var9 * 256 / (256 + Client.mapScaleDelta);
         int var10 = var8 * var3 + var9 * var2 >> 16;
         int var11 = var9 * var3 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class180.field2718.method4168(94 + var0 + var14 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class183.method3409(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;I)V",
      garbageValue = "1016419821"
   )
   static final void method2082(Region var0, CollisionData[] var1) {
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

      class10.field88 += (int)(Math.random() * 5.0D) - 2;
      if(class10.field88 < -8) {
         class10.field88 = -8;
      }

      if(class10.field88 > 8) {
         class10.field88 = 8;
      }

      class10.field97 += (int)(Math.random() * 5.0D) - 2;
      if(class10.field97 < -16) {
         class10.field97 = -16;
      }

      if(class10.field97 > 16) {
         class10.field97 = 16;
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
         byte[][] var42 = Ignore.field219[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class10.tileHeights[var2][var12 + 1][var11] - class10.tileHeights[var2][var12 - 1][var11];
               var14 = class10.tileHeights[var2][var12][1 + var11] - class10.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(65536 + var13 * var13 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var16 * -50 + var17 * -10 + -50 * var18) / var10 + 96;
               var20 = (var42[var12][var11] >> 1) + (var42[var12][var11 + 1] >> 3) + (var42[var12][var11 - 1] >> 2) + (var42[var12 - 1][var11] >> 2) + (var42[var12 + 1][var11] >> 3);
               CombatInfo1.field688[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class10.field94[var11] = 0;
            class30.field712[var11] = 0;
            class1.field9[var11] = 0;
            class0.field2[var11] = 0;
            ClassInfo.field3243[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class10.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = ISAACCipher.method3133(var14 - 1);
                     class10.field94[var12] += var43.field2823;
                     class30.field712[var12] += var43.field2820;
                     class1.field9[var12] += var43.field2825;
                     class0.field2[var12] += var43.field2826;
                     ++ClassInfo.field3243[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class10.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = ISAACCipher.method3133(var15 - 1);
                     class10.field94[var12] -= var44.field2823;
                     class30.field712[var12] -= var44.field2820;
                     class1.field9[var12] -= var44.field2825;
                     class0.field2[var12] -= var44.field2826;
                     --ClassInfo.field3243[var12];
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
                  var18 = 5 + var17;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class10.field94[var18];
                     var13 += class30.field712[var18];
                     var14 += class1.field9[var18];
                     var15 += class0.field2[var18];
                     var16 += ClassInfo.field3243[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class10.field94[var19];
                     var13 -= class30.field712[var19];
                     var14 -= class1.field9[var19];
                     var15 -= class0.field2[var19];
                     var16 -= ClassInfo.field3243[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field306 || (class10.tileSettings[0][var11][var17] & 2) != 0 || (class10.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class10.field86) {
                        class10.field86 = var2;
                     }

                     var20 = class10.underlayIds[var2][var11][var17] & 255;
                     int var21 = class0.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class10.tileHeights[var2][var11][var17];
                        int var23 = class10.tileHeights[var2][1 + var11][var17];
                        int var24 = class10.tileHeights[var2][1 + var11][1 + var17];
                        int var25 = class10.tileHeights[var2][var11][1 + var17];
                        int var26 = CombatInfo1.field688[var11][var17];
                        int var27 = CombatInfo1.field688[var11 + 1][var17];
                        int var28 = CombatInfo1.field688[1 + var11][var17 + 1];
                        int var29 = CombatInfo1.field688[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class63.method1187(var32, var33, var34);
                           var32 = class10.field88 + var32 & 255;
                           var34 += class10.field97;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class63.method1187(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var47 = true;
                           if(var20 == 0 && class3.overlayPaths[var2][var11][var17] != 0) {
                              var47 = false;
                           }

                           if(var21 > 0 && !class164.method3192(var21 - 1).isHidden) {
                              var47 = false;
                           }

                           if(var47 && var22 == var23 && var24 == var22 && var25 == var22) {
                              class162.field2166[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class84.colorPalette[Script.method921(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method1746(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, Script.method921(var30, var26), Script.method921(var30, var27), Script.method921(var30, var28), Script.method921(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = 1 + class3.overlayPaths[var2][var11][var17];
                           byte var48 = class109.overlayRotations[var2][var11][var17];
                           Overlay var35 = class164.method3192(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class84.field1472.vmethod1942(var36);
                              var37 = -1;
                           } else if(var35.color == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class63.method1187(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class10.field88 & 255;
                              var40 = var35.lightness + class10.field97;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class63.method1187(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class84.colorPalette[Tile.method1581(var38, 96)];
                           }

                           if(var35.field3044 != -1) {
                              var40 = var35.field3051 + class10.field88 & 255;
                              int var41 = var35.field3053 + class10.field97;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class63.method1187(var40, var35.field3052, var41);
                              var39 = class84.colorPalette[Tile.method1581(var38, 96)];
                           }

                           var0.method1746(var2, var11, var17, var33, var48, var36, var22, var23, var24, var25, Script.method921(var30, var26), Script.method921(var30, var27), Script.method921(var30, var28), Script.method921(var30, var29), Tile.method1581(var37, var26), Tile.method1581(var37, var27), Tile.method1581(var37, var28), Tile.method1581(var37, var29), var32, var39);
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

               var0.method1740(var2, var12, var11, var17);
            }
         }

         class10.underlayIds[var2] = null;
         class0.overlayIds[var2] = null;
         class3.overlayPaths[var2] = null;
         class109.overlayRotations[var2] = null;
         Ignore.field219[var2] = null;
      }

      var0.method1750(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class10.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method1738(var2, var3);
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
                  if((class162.field2166[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class162.field2166[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class162.field2166[var6][var8][1 + var10] & var2) != 0) {
                        ++var10;
                     }

                     label517:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class162.field2166[var11 - 1][var8][var13] & var2) == 0) {
                              break label517;
                           }
                        }

                        --var11;
                     }

                     label506:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class162.field2166[1 + var12][var8][var13] & var2) == 0) {
                              break label506;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (1 + var12 - var11);
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class10.tileHeights[var12][var8][var9] - var46;
                        var16 = class10.tileHeights[var11][var8][var9];
                        Region.method1739(var5, 1, var8 * 128, 128 * var8, var9 * 128, 128 + 128 * var10, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class162.field2166[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class162.field2166[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class162.field2166[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class162.field2166[var6][1 + var10][var7] & var3) != 0) {
                        ++var10;
                     }

                     label570:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class162.field2166[var11 - 1][var13][var7] & var3) == 0) {
                              break label570;
                           }
                        }

                        --var11;
                     }

                     label559:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class162.field2166[var12 + 1][var13][var7] & var3) == 0) {
                              break label559;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var46 = 240;
                        var15 = class10.tileHeights[var12][var9][var7] - var46;
                        var16 = class10.tileHeights[var11][var9][var7];
                        Region.method1739(var5, 2, 128 * var9, 128 + 128 * var10, 128 * var7, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class162.field2166[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class162.field2166[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class162.field2166[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class162.field2166[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label623:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class162.field2166[var6][var9 - 1][var13] & var4) == 0) {
                              break label623;
                           }
                        }

                        --var9;
                     }

                     label612:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class162.field2166[var6][var10 + 1][var13] & var4) == 0) {
                              break label612;
                           }
                        }

                        ++var10;
                     }

                     if((1 + (var12 - var11)) * (1 + (var10 - var9)) >= 4) {
                        var13 = class10.tileHeights[var6][var9][var11];
                        Region.method1739(var5, 4, var9 * 128, 128 * var10 + 128, 128 * var11, 128 + 128 * var12, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class162.field2166[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1062615995"
   )
   static final void method2083() {
      if(Client.field355 > 0) {
         WallObject.method1930();
      } else {
         GameObject.setGameState(40);
         class157.field2139 = class20.field233;
         class20.field233 = null;
      }
   }

   class107() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;B)V",
      garbageValue = "127"
   )
   public static void method2084(class182 var0, class182 var1, class182 var2) {
      Sequence.field3061 = var0;
      Sequence.field3078 = var1;
      class5.field55 = var2;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method2085() {
      class33.method717(Projectile.canvas);
      class152.method2848(Projectile.canvas);
      if(null != WallObject.field1574) {
         WallObject.field1574.vmethod2143(Projectile.canvas);
      }

      Client.field433.method2196();
      Projectile.canvas.setBackground(Color.black);
      Canvas var0 = Projectile.canvas;
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class105.keyboard);
      var0.addFocusListener(class105.keyboard);
      VertexNormal.method1668(Projectile.canvas);
      if(null != WallObject.field1574) {
         WallObject.field1574.vmethod2134(Projectile.canvas);
      }

      if(Client.widgetRoot != -1) {
         int var1 = Client.widgetRoot;
         int var2 = class32.field755;
         int var3 = class168.field2207;
         if(Ignore.method178(var1)) {
            class65.method1205(Widget.widgets[var1], -1, var2, var3, false);
         }
      }

      GameEngine.field1797 = true;
   }
}
