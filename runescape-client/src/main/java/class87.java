import java.awt.Component;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class87 {
   @ObfuscatedName("p")
   static int[] field1355;
   @ObfuscatedName("g")
   static final BigInteger field1358;
   @ObfuscatedName("l")
   public static short[] field1363;
   @ObfuscatedName("v")
   static final BigInteger field1367;

   static {
      field1358 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1367 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "1505040482"
   )
   static void method1737(Component var0) {
      var0.removeMouseListener(class59.mouse);
      var0.removeMouseMotionListener(class59.mouse);
      var0.removeFocusListener(class59.mouse);
      class59.field720 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "1893079859"
   )
   static void method1738(World var0) {
      if(var0.method1549() != Client.isMembers) {
         Client.isMembers = var0.method1549();
         boolean var1 = var0.method1549();
         if(class231.isMembersWorld != var1) {
            ItemComposition.field3485.reset();
            ItemComposition.itemModelCache.reset();
            ItemComposition.itemSpriteCache.reset();
            class231.isMembersWorld = var1;
         }
      }

      Item.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class22.field340 = Client.field926 == 0?'ꩊ':var0.id + '鱀';
      class149.field2183 = Client.field926 == 0?443:var0.id + '썐';
      ChatMessages.field1510 = class22.field340;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;I)V",
      garbageValue = "-1599923077"
   )
   static final void method1739(Region var0, CollisionData[] var1) {
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
                     var1[var5].method3075(var3, var4);
                  }
               }
            }
         }
      }

      class61.field758 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field758 < -8) {
         class61.field758 = -8;
      }

      if(class61.field758 > 8) {
         class61.field758 = 8;
      }

      class61.field756 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field756 < -16) {
         class61.field756 = -16;
      }

      if(class61.field756 > 16) {
         class61.field756 = 16;
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
         byte[][] var42 = class18.field315[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class61.tileHeights[var2][var12 + 1][var11] - class61.tileHeights[var2][var12 - 1][var11];
               var14 = class61.tileHeights[var2][var12][var11 + 1] - class61.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + 65536 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var18 * -50 + var16 * -50 + var17 * -10) / var10 + 96;
               var20 = (var42[var12][var11] >> 1) + (var42[var12][var11 + 1] >> 3) + (var42[var12][var11 - 1] >> 2) + (var42[var12 - 1][var11] >> 2) + (var42[var12 + 1][var11] >> 3);
               class61.field746[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class89.field1387[var11] = 0;
            class51.field650[var11] = 0;
            class249.field3371[var11] = 0;
            class11.field264[var11] = 0;
            class61.field745[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class90.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = class238.method4335(var14 - 1);
                     class89.field1387[var12] += var43.field3332;
                     class51.field650[var12] += var43.field3329;
                     class249.field3371[var12] += var43.field3330;
                     class11.field264[var12] += var43.field3333;
                     ++class61.field745[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class90.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = class238.method4335(var15 - 1);
                     class89.field1387[var12] -= var44.field3332;
                     class51.field650[var12] -= var44.field3329;
                     class249.field3371[var12] -= var44.field3330;
                     class11.field264[var12] -= var44.field3333;
                     --class61.field745[var12];
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
                     var12 += class89.field1387[var18];
                     var13 += class51.field650[var18];
                     var14 += class249.field3371[var18];
                     var15 += class11.field264[var18];
                     var16 += class61.field745[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class89.field1387[var19];
                     var13 -= class51.field650[var19];
                     var14 -= class249.field3371[var19];
                     var15 -= class11.field264[var19];
                     var16 -= class61.field745[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field895 || (class61.tileSettings[0][var11][var17] & 2) != 0 || (class61.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class61.field752) {
                        class61.field752 = var2;
                     }

                     var20 = class90.underlayIds[var2][var11][var17] & 255;
                     int var21 = class61.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class61.tileHeights[var2][var11][var17];
                        int var23 = class61.tileHeights[var2][var11 + 1][var17];
                        int var24 = class61.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class61.tileHeights[var2][var11][var17 + 1];
                        int var26 = class61.field746[var11][var17];
                        int var27 = class61.field746[var11 + 1][var17];
                        int var28 = class61.field746[var11 + 1][var17 + 1];
                        int var29 = class61.field746[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class8.method31(var32, var33, var34);
                           var32 = class61.field758 + var32 & 255;
                           var34 += class61.field756;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class8.method31(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var46 = true;
                           if(var20 == 0 && class61.overlayPaths[var2][var11][var17] != 0) {
                              var46 = false;
                           }

                           if(var21 > 0 && !class96.method1819(var21 - 1).isHidden) {
                              var46 = false;
                           }

                           if(var46 && var22 == var23 && var22 == var24 && var25 == var22) {
                              class61.field754[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class136.colorPalette[class12.method49(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method2793(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class12.method49(var30, var26), class12.method49(var30, var27), class12.method49(var30, var28), class12.method49(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class61.overlayPaths[var2][var11][var17] + 1;
                           byte var47 = class61.overlayRotations[var2][var11][var17];
                           Overlay var35 = class96.method1819(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class136.field2017.vmethod2918(var36);
                              var37 = -1;
                           } else if(var35.color == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class8.method31(var35.hue, var35.saturation, var35.lightness);
                              var39 = class61.field758 + var35.hue & 255;
                              var40 = var35.lightness + class61.field756;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class8.method31(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class136.colorPalette[class21.method150(var38, 96)];
                           }

                           if(var35.field3580 != -1) {
                              var40 = class61.field758 + var35.field3585 & 255;
                              int var41 = class61.field756 + var35.field3591;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class8.method31(var40, var35.field3589, var41);
                              var39 = class136.colorPalette[class21.method150(var38, 96)];
                           }

                           var0.method2793(var2, var11, var17, var33, var47, var36, var22, var23, var24, var25, class12.method49(var30, var26), class12.method49(var30, var27), class12.method49(var30, var28), class12.method49(var30, var29), class21.method150(var37, var26), class21.method150(var37, var27), class21.method150(var37, var28), class21.method150(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.method2827(var2, var12, var11, class261.method4790(var2, var12, var11));
            }
         }

         class90.underlayIds[var2] = null;
         class61.overlayIds[var2] = null;
         class61.overlayPaths[var2] = null;
         class61.overlayRotations[var2] = null;
         class18.field315[var2] = null;
      }

      var0.method2738(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class61.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method2889(var2, var3);
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
                  if((class61.field754[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class61.field754[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class61.field754[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label508:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class61.field754[var11 - 1][var8][var13] & var2) == 0) {
                              break label508;
                           }
                        }

                        --var11;
                     }

                     label497:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class61.field754[var12 + 1][var8][var13] & var2) == 0) {
                              break label497;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var8][var9] - var45;
                        var16 = class61.tileHeights[var11][var8][var9];
                        Region.method2712(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class61.field754[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class61.field754[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class61.field754[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class61.field754[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label561:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class61.field754[var11 - 1][var13][var7] & var3) == 0) {
                              break label561;
                           }
                        }

                        --var11;
                     }

                     label550:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class61.field754[var12 + 1][var13][var7] & var3) == 0) {
                              break label550;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var9][var7] - var45;
                        var16 = class61.tileHeights[var11][var9][var7];
                        Region.method2712(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class61.field754[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class61.field754[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class61.field754[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class61.field754[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label614:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class61.field754[var6][var9 - 1][var13] & var4) == 0) {
                              break label614;
                           }
                        }

                        --var9;
                     }

                     label603:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class61.field754[var6][var10 + 1][var13] & var4) == 0) {
                              break label603;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var13 = class61.tileHeights[var6][var9][var11];
                        Region.method2712(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class61.field754[var6][var14][var15] &= ~var4;
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
