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
         var8 = var8 * 256 / (Client.mapScaleDelta + 256);
         var9 = var9 * 256 / (Client.mapScaleDelta + 256);
         int var10 = var8 * var3 + var9 * var2 >> 16;
         int var11 = var9 * var3 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class180.field2718.method4168(var0 + 94 + var14 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
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

      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var18 = Ignore.field219[var2];
         var6 = (int)Math.sqrt(5100.0D);
         var7 = var6 * 768 >> 8;

         for(var8 = 1; var8 < 103; ++var8) {
            for(var9 = 1; var9 < 103; ++var9) {
               var10 = class10.tileHeights[var2][var9 + 1][var8] - class10.tileHeights[var2][var9 - 1][var8];
               var11 = class10.tileHeights[var2][var9][var8 + 1] - class10.tileHeights[var2][var9][var8 - 1];
               var12 = (int)Math.sqrt((double)(var10 * var10 + 65536 + var11 * var11));
               var13 = (var10 << 8) / var12;
               var14 = 65536 / var12;
               var15 = (var11 << 8) / var12;
               var16 = (var13 * -50 + var14 * -10 + var15 * -50) / var7 + 96;
               var17 = (var18[var9][var8] >> 1) + (var18[var9][var8 + 1] >> 3) + (var18[var9][var8 - 1] >> 2) + (var18[var9 - 1][var8] >> 2) + (var18[var9 + 1][var8] >> 3);
               CombatInfo1.field688[var9][var8] = var16 - var17;
            }
         }

         for(var8 = 0; var8 < 104; ++var8) {
            class10.field94[var8] = 0;
            Preferences.field712[var8] = 0;
            class1.field9[var8] = 0;
            class0.field2[var8] = 0;
            ClassInfo.field3243[var8] = 0;
         }

         for(var8 = -5; var8 < 109; ++var8) {
            for(var9 = 0; var9 < 104; ++var9) {
               var10 = var8 + 5;
               FloorUnderlayDefinition var19;
               if(var10 >= 0 && var10 < 104) {
                  var11 = class10.underlayIds[var2][var10][var9] & 255;
                  if(var11 > 0) {
                     var19 = ISAACCipher.method3133(var11 - 1);
                     class10.field94[var9] += var19.field2823;
                     Preferences.field712[var9] += var19.field2820;
                     class1.field9[var9] += var19.field2825;
                     class0.field2[var9] += var19.field2826;
                     ++ClassInfo.field3243[var9];
                  }
               }

               var11 = var8 - 5;
               if(var11 >= 0 && var11 < 104) {
                  var12 = class10.underlayIds[var2][var11][var9] & 255;
                  if(var12 > 0) {
                     var19 = ISAACCipher.method3133(var12 - 1);
                     class10.field94[var9] -= var19.field2823;
                     Preferences.field712[var9] -= var19.field2820;
                     class1.field9[var9] -= var19.field2825;
                     class0.field2[var9] -= var19.field2826;
                     --ClassInfo.field3243[var9];
                  }
               }
            }

            if(var8 >= 1 && var8 < 103) {
               var9 = 0;
               var10 = 0;
               var11 = 0;
               var12 = 0;
               var13 = 0;

               for(var14 = -5; var14 < 109; ++var14) {
                  var15 = var14 + 5;
                  if(var15 >= 0 && var15 < 104) {
                     var9 += class10.field94[var15];
                     var10 += Preferences.field712[var15];
                     var11 += class1.field9[var15];
                     var12 += class0.field2[var15];
                     var13 += ClassInfo.field3243[var15];
                  }

                  var16 = var14 - 5;
                  if(var16 >= 0 && var16 < 104) {
                     var9 -= class10.field94[var16];
                     var10 -= Preferences.field712[var16];
                     var11 -= class1.field9[var16];
                     var12 -= class0.field2[var16];
                     var13 -= ClassInfo.field3243[var16];
                  }

                  if(var14 >= 1 && var14 < 103 && (!Client.field306 || (class10.tileSettings[0][var8][var14] & 2) != 0 || (class10.tileSettings[var2][var8][var14] & 16) == 0)) {
                     if(var2 < class10.field86) {
                        class10.field86 = var2;
                     }

                     var17 = class10.underlayIds[var2][var8][var14] & 255;
                     int var41 = class0.overlayIds[var2][var8][var14] & 255;
                     if(var17 > 0 || var41 > 0) {
                        int var20 = class10.tileHeights[var2][var8][var14];
                        int var21 = class10.tileHeights[var2][var8 + 1][var14];
                        int var22 = class10.tileHeights[var2][var8 + 1][var14 + 1];
                        int var23 = class10.tileHeights[var2][var8][var14 + 1];
                        int var24 = CombatInfo1.field688[var8][var14];
                        int var25 = CombatInfo1.field688[var8 + 1][var14];
                        int var26 = CombatInfo1.field688[var8 + 1][var14 + 1];
                        int var27 = CombatInfo1.field688[var8][var14 + 1];
                        int var28 = -1;
                        int var29 = -1;
                        int var30;
                        int var31;
                        if(var17 > 0) {
                           var30 = var9 * 256 / var12;
                           var31 = var10 / var13;
                           int var32 = var11 / var13;
                           var28 = class63.method1187(var30, var31, var32);
                           var30 = class10.field88 + var30 & 255;
                           var32 += class10.field97;
                           if(var32 < 0) {
                              var32 = 0;
                           } else if(var32 > 255) {
                              var32 = 255;
                           }

                           var29 = class63.method1187(var30, var31, var32);
                        }

                        if(var2 > 0) {
                           boolean var43 = true;
                           if(var17 == 0 && class3.overlayPaths[var2][var8][var14] != 0) {
                              var43 = false;
                           }

                           if(var41 > 0 && !class164.method3192(var41 - 1).isHidden) {
                              var43 = false;
                           }

                           if(var43 && var20 == var21 && var22 == var20 && var23 == var20) {
                              class162.field2166[var2][var8][var14] |= 2340;
                           }
                        }

                        var30 = 0;
                        if(var29 != -1) {
                           var30 = class84.colorPalette[Script.method921(var29, 96)];
                        }

                        if(var41 == 0) {
                           var0.method1746(var2, var8, var14, 0, 0, -1, var20, var21, var22, var23, Script.method921(var28, var24), Script.method921(var28, var25), Script.method921(var28, var26), Script.method921(var28, var27), 0, 0, 0, 0, var30, 0);
                        } else {
                           var31 = class3.overlayPaths[var2][var8][var14] + 1;
                           byte var44 = class109.overlayRotations[var2][var8][var14];
                           Overlay var33 = class164.method3192(var41 - 1);
                           int var34 = var33.texture;
                           int var35;
                           int var36;
                           int var37;
                           int var38;
                           if(var34 >= 0) {
                              var36 = class84.field1472.vmethod1942(var34);
                              var35 = -1;
                           } else if(var33.color == 16711935) {
                              var35 = -2;
                              var34 = -1;
                              var36 = -2;
                           } else {
                              var35 = class63.method1187(var33.hue, var33.saturation, var33.lightness);
                              var37 = var33.hue + class10.field88 & 255;
                              var38 = var33.lightness + class10.field97;
                              if(var38 < 0) {
                                 var38 = 0;
                              } else if(var38 > 255) {
                                 var38 = 255;
                              }

                              var36 = class63.method1187(var37, var33.saturation, var38);
                           }

                           var37 = 0;
                           if(var36 != -2) {
                              var37 = class84.colorPalette[Tile.method1581(var36, 96)];
                           }

                           if(var33.field3044 != -1) {
                              var38 = var33.field3051 + class10.field88 & 255;
                              int var39 = var33.field3053 + class10.field97;
                              if(var39 < 0) {
                                 var39 = 0;
                              } else if(var39 > 255) {
                                 var39 = 255;
                              }

                              var36 = class63.method1187(var38, var33.field3052, var39);
                              var37 = class84.colorPalette[Tile.method1581(var36, 96)];
                           }

                           var0.method1746(var2, var8, var14, var31, var44, var34, var20, var21, var22, var23, Script.method921(var28, var24), Script.method921(var28, var25), Script.method921(var28, var26), Script.method921(var28, var27), Tile.method1581(var35, var24), Tile.method1581(var35, var25), Tile.method1581(var35, var26), Tile.method1581(var35, var27), var30, var37);
                        }
                     }
                  }
               }
            }
         }

         for(var8 = 1; var8 < 103; ++var8) {
            for(var9 = 1; var9 < 103; ++var9) {
               if((class10.tileSettings[var2][var9][var8] & 8) != 0) {
                  var14 = 0;
               } else if(var2 > 0 && (class10.tileSettings[1][var9][var8] & 2) != 0) {
                  var14 = var2 - 1;
               } else {
                  var14 = var2;
               }

               var0.method1740(var2, var9, var8, var14);
            }
         }

         class10.underlayIds[var2] = (byte[][])((byte[][])null);
         class0.overlayIds[var2] = (byte[][])((byte[][])null);
         class3.overlayPaths[var2] = (byte[][])((byte[][])null);
         class109.overlayRotations[var2] = (byte[][])((byte[][])null);
         Ignore.field219[var2] = (byte[][])((byte[][])null);
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

         for(int var40 = 0; var40 <= var5; ++var40) {
            for(var16 = 0; var16 <= 104; ++var16) {
               for(var17 = 0; var17 <= 104; ++var17) {
                  short var42;
                  if((class162.field2166[var40][var17][var16] & var2) != 0) {
                     var6 = var16;
                     var7 = var16;
                     var8 = var40;

                     for(var9 = var40; var6 > 0 && (class162.field2166[var40][var17][var6 - 1] & var2) != 0; --var6) {
                        ;
                     }

                     while(var7 < 104 && (class162.field2166[var40][var17][var7 + 1] & var2) != 0) {
                        ++var7;
                     }

                     label342:
                     while(var8 > 0) {
                        for(var10 = var6; var10 <= var7; ++var10) {
                           if((class162.field2166[var8 - 1][var17][var10] & var2) == 0) {
                              break label342;
                           }
                        }

                        --var8;
                     }

                     label331:
                     while(var9 < var5) {
                        for(var10 = var6; var10 <= var7; ++var10) {
                           if((class162.field2166[var9 + 1][var17][var10] & var2) == 0) {
                              break label331;
                           }
                        }

                        ++var9;
                     }

                     var10 = (var7 - var6 + 1) * (var9 + 1 - var8);
                     if(var10 >= 8) {
                        var42 = 240;
                        var12 = class10.tileHeights[var9][var17][var6] - var42;
                        var13 = class10.tileHeights[var8][var17][var6];
                        Region.method1739(var5, 1, var17 * 128, var17 * 128, var6 * 128, var7 * 128 + 128, var12, var13);

                        for(var14 = var8; var14 <= var9; ++var14) {
                           for(var15 = var6; var15 <= var7; ++var15) {
                              class162.field2166[var14][var17][var15] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class162.field2166[var40][var17][var16] & var3) != 0) {
                     var6 = var17;
                     var7 = var17;
                     var8 = var40;

                     for(var9 = var40; var6 > 0 && (class162.field2166[var40][var6 - 1][var16] & var3) != 0; --var6) {
                        ;
                     }

                     while(var7 < 104 && (class162.field2166[var40][var7 + 1][var16] & var3) != 0) {
                        ++var7;
                     }

                     label395:
                     while(var8 > 0) {
                        for(var10 = var6; var10 <= var7; ++var10) {
                           if((class162.field2166[var8 - 1][var10][var16] & var3) == 0) {
                              break label395;
                           }
                        }

                        --var8;
                     }

                     label384:
                     while(var9 < var5) {
                        for(var10 = var6; var10 <= var7; ++var10) {
                           if((class162.field2166[var9 + 1][var10][var16] & var3) == 0) {
                              break label384;
                           }
                        }

                        ++var9;
                     }

                     var10 = (var9 + 1 - var8) * (var7 - var6 + 1);
                     if(var10 >= 8) {
                        var42 = 240;
                        var12 = class10.tileHeights[var9][var6][var16] - var42;
                        var13 = class10.tileHeights[var8][var6][var16];
                        Region.method1739(var5, 2, var6 * 128, var7 * 128 + 128, var16 * 128, var16 * 128, var12, var13);

                        for(var14 = var8; var14 <= var9; ++var14) {
                           for(var15 = var6; var15 <= var7; ++var15) {
                              class162.field2166[var14][var15][var16] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class162.field2166[var40][var17][var16] & var4) != 0) {
                     var6 = var17;
                     var7 = var17;
                     var8 = var16;

                     for(var9 = var16; var8 > 0 && (class162.field2166[var40][var17][var8 - 1] & var4) != 0; --var8) {
                        ;
                     }

                     while(var9 < 104 && (class162.field2166[var40][var17][var9 + 1] & var4) != 0) {
                        ++var9;
                     }

                     label448:
                     while(var6 > 0) {
                        for(var10 = var8; var10 <= var9; ++var10) {
                           if((class162.field2166[var40][var6 - 1][var10] & var4) == 0) {
                              break label448;
                           }
                        }

                        --var6;
                     }

                     label437:
                     while(var7 < 104) {
                        for(var10 = var8; var10 <= var9; ++var10) {
                           if((class162.field2166[var40][var7 + 1][var10] & var4) == 0) {
                              break label437;
                           }
                        }

                        ++var7;
                     }

                     if((var9 - var8 + 1) * (var7 - var6 + 1) >= 4) {
                        var10 = class10.tileHeights[var40][var6][var8];
                        Region.method1739(var5, 4, var6 * 128, var7 * 128 + 128, var8 * 128, var9 * 128 + 128, var10, var10);

                        for(var11 = var6; var11 <= var7; ++var11) {
                           for(var12 = var8; var12 <= var9; ++var12) {
                              class162.field2166[var40][var11][var12] &= ~var4;
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
         class157.field2139 = class20.rssocket;
         class20.rssocket = null;
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
   public static void method2084(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2) {
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
      if(WallObject.field1574 != null) {
         WallObject.field1574.vmethod2143(Projectile.canvas);
      }

      Client.field433.method2196();
      Projectile.canvas.setBackground(Color.black);
      Canvas var0 = Projectile.canvas;
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class105.keyboard);
      var0.addFocusListener(class105.keyboard);
      VertexNormal.method1668(Projectile.canvas);
      if(WallObject.field1574 != null) {
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
