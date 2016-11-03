import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class40 extends class210 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 462056481
   )
   int field889 = (int)(class169.method3276() / 1000L);
   @ObfuscatedName("f")
   short field890;
   @ObfuscatedName("q")
   String field891;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)[LModIcon;",
      garbageValue = "-1974563612"
   )
   static ModIcon[] method793(class170 var0, int var1, int var2) {
      if(!XClanMember.method604(var0, var1, var2)) {
         return null;
      } else {
         ModIcon[] var4 = new ModIcon[class79.field1441];

         for(int var5 = 0; var5 < class79.field1441; ++var5) {
            ModIcon var6 = var4[var5] = new ModIcon();
            var6.width = class79.field1436;
            var6.originalHeight = class79.field1437;
            var6.offsetX = class134.field2117[var5];
            var6.offsetY = class79.field1438[var5];
            var6.originalWidth = class79.field1439[var5];
            var6.height = ChatLineBuffer.field693[var5];
            var6.palette = class26.field634;
            var6.pixels = class110.field1936[var5];
         }

         NPC.method745();
         return var4;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;I)V",
      garbageValue = "-1882777353"
   )
   static final void method794(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class5.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class5.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method2451(var3, var4);
                  }
               }
            }
         }
      }

      class5.field89 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field89 < -8) {
         class5.field89 = -8;
      }

      if(class5.field89 > 8) {
         class5.field89 = 8;
      }

      class5.field90 += (int)(Math.random() * 5.0D) - 2;
      if(class5.field90 < -16) {
         class5.field90 = -16;
      }

      if(class5.field90 > 16) {
         class5.field90 = 16;
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
         byte[][] var42 = class53.field1155[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class5.tileHeights[var2][1 + var12][var11] - class5.tileHeights[var2][var12 - 1][var11];
               var14 = class5.tileHeights[var2][var12][1 + var11] - class5.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(65536 + var13 * var13 + var14 * var14));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = 96 + (-50 * var18 + -50 * var16 + -10 * var17) / var10;
               var20 = (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 + 1] >> 3) + (var42[var12][var11] >> 1);
               class232.field3278[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class5.field91[var11] = 0;
            class134.field2122[var11] = 0;
            class5.field87[var11] = 0;
            Ignore.field130[var11] = 0;
            class153.field2294[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class5.field78[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     var16 = var14 - 1;
                     class43 var44 = (class43)class43.field987.get((long)var16);
                     class43 var48;
                     if(var44 != null) {
                        var48 = var44;
                     } else {
                        byte[] var43 = class43.field999.method3305(1, var16);
                        var44 = new class43();
                        if(var43 != null) {
                           var44.method881(new Buffer(var43), var16);
                        }

                        var44.method884();
                        class43.field987.put(var44, (long)var16);
                        var48 = var44;
                     }

                     class5.field91[var12] += var48.field989;
                     class134.field2122[var12] += var48.field995;
                     class5.field87[var12] += var48.field990;
                     Ignore.field130[var12] += var48.field998;
                     ++class153.field2294[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class5.field78[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     var17 = var15 - 1;
                     class43 var52 = (class43)class43.field987.get((long)var17);
                     class43 var45;
                     if(var52 != null) {
                        var45 = var52;
                     } else {
                        byte[] var46 = class43.field999.method3305(1, var17);
                        var52 = new class43();
                        if(var46 != null) {
                           var52.method881(new Buffer(var46), var17);
                        }

                        var52.method884();
                        class43.field987.put(var52, (long)var17);
                        var45 = var52;
                     }

                     class5.field91[var12] -= var45.field989;
                     class134.field2122[var12] -= var45.field995;
                     class5.field87[var12] -= var45.field990;
                     Ignore.field130[var12] -= var45.field998;
                     --class153.field2294[var12];
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
                     var12 += class5.field91[var18];
                     var13 += class134.field2122[var18];
                     var14 += class5.field87[var18];
                     var15 += Ignore.field130[var18];
                     var16 += class153.field2294[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class5.field91[var19];
                     var13 -= class134.field2122[var19];
                     var14 -= class5.field87[var19];
                     var15 -= Ignore.field130[var19];
                     var16 -= class153.field2294[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field282 || (class5.tileSettings[0][var11][var17] & 2) != 0 || (class5.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class5.field77) {
                        class5.field77 = var2;
                     }

                     var20 = class5.field78[var2][var11][var17] & 255;
                     int var21 = class5.field75[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class5.tileHeights[var2][var11][var17];
                        int var23 = class5.tileHeights[var2][1 + var11][var17];
                        int var24 = class5.tileHeights[var2][1 + var11][var17 + 1];
                        int var25 = class5.tileHeights[var2][var11][1 + var17];
                        int var26 = class232.field3278[var11][var17];
                        int var27 = class232.field3278[1 + var11][var17];
                        int var28 = class232.field3278[1 + var11][var17 + 1];
                        int var29 = class232.field3278[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = 256 * var12 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class12.method145(var32, var33, var34);
                           var32 = var32 + class5.field89 & 255;
                           var34 += class5.field90;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class12.method145(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var50 = true;
                           if(var20 == 0 && class212.field3169[var2][var11][var17] != 0) {
                              var50 = false;
                           }

                           if(var21 > 0 && !GameEngine.method3129(var21 - 1).field1075) {
                              var50 = false;
                           }

                           if(var50 && var22 == var23 && var24 == var22 && var22 == var25) {
                              class5.field82[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class94.colorPalette[NPCComposition.method829(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method1966(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, NPCComposition.method829(var30, var26), NPCComposition.method829(var30, var27), NPCComposition.method829(var30, var28), NPCComposition.method829(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = 1 + class212.field3169[var2][var11][var17];
                           byte var51 = class13.field199[var2][var11][var17];
                           class48 var35 = GameEngine.method3129(var21 - 1);
                           int var36 = var35.field1073;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class94.field1647.vmethod2240(var36);
                              var37 = -1;
                           } else if(var35.field1082 == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class12.method145(var35.field1077, var35.field1078, var35.field1079);
                              var39 = var35.field1077 + class5.field89 & 255;
                              var40 = var35.field1079 + class5.field90;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class12.method145(var39, var35.field1078, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class94.colorPalette[WallObject.method2149(var38, 96)];
                           }

                           if(var35.field1074 != -1) {
                              var40 = var35.field1072 + class5.field89 & 255;
                              int var41 = var35.field1080 + class5.field90;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class12.method145(var40, var35.field1081, var41);
                              var39 = class94.colorPalette[WallObject.method2149(var38, 96)];
                           }

                           var0.method1966(var2, var11, var17, var33, var51, var36, var22, var23, var24, var25, NPCComposition.method829(var30, var26), NPCComposition.method829(var30, var27), NPCComposition.method829(var30, var28), NPCComposition.method829(var30, var29), WallObject.method2149(var37, var26), WallObject.method2149(var37, var27), WallObject.method2149(var37, var28), WallObject.method2149(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               if((class5.tileSettings[var2][var12][var11] & 8) != 0) {
                  var17 = 0;
               } else if(var2 > 0 && (class5.tileSettings[1][var12][var11] & 2) != 0) {
                  var17 = var2 - 1;
               } else {
                  var17 = var2;
               }

               var0.method1965(var2, var12, var11, var17);
            }
         }

         class5.field78[var2] = null;
         class5.field75[var2] = null;
         class212.field3169[var2] = null;
         class13.field199[var2] = null;
         class53.field1155[var2] = null;
      }

      var0.method2109(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class5.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method2072(var2, var3);
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
                  short var49;
                  if((class5.field82[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class5.field82[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class5.field82[var6][var8][1 + var10] & var2) != 0) {
                        ++var10;
                     }

                     label559:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class5.field82[var11 - 1][var8][var13] & var2) == 0) {
                              break label559;
                           }
                        }

                        --var11;
                     }

                     label548:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class5.field82[var12 + 1][var8][var13] & var2) == 0) {
                              break label548;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var49 = 240;
                        var15 = class5.tileHeights[var12][var8][var9] - var49;
                        var16 = class5.tileHeights[var11][var8][var9];
                        Region.method1964(var5, 1, 128 * var8, 128 * var8, 128 * var9, 128 + 128 * var10, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class5.field82[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class5.field82[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class5.field82[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class5.field82[var6][1 + var10][var7] & var3) != 0) {
                        ++var10;
                     }

                     label612:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class5.field82[var11 - 1][var13][var7] & var3) == 0) {
                              break label612;
                           }
                        }

                        --var11;
                     }

                     label601:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class5.field82[1 + var12][var13][var7] & var3) == 0) {
                              break label601;
                           }
                        }

                        ++var12;
                     }

                     var13 = (1 + var12 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var49 = 240;
                        var15 = class5.tileHeights[var12][var9][var7] - var49;
                        var16 = class5.tileHeights[var11][var9][var7];
                        Region.method1964(var5, 2, 128 * var9, var10 * 128 + 128, 128 * var7, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class5.field82[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class5.field82[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class5.field82[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class5.field82[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label665:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class5.field82[var6][var9 - 1][var13] & var4) == 0) {
                              break label665;
                           }
                        }

                        --var9;
                     }

                     label654:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class5.field82[var6][var10 + 1][var13] & var4) == 0) {
                              break label654;
                           }
                        }

                        ++var10;
                     }

                     if((var10 - var9 + 1) * (1 + (var12 - var11)) >= 4) {
                        var13 = class5.tileHeights[var6][var9][var11];
                        Region.method1964(var5, 4, var9 * 128, 128 + 128 * var10, 128 * var11, 128 * var12 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class5.field82[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)LSpritePixels;",
      garbageValue = "936075812"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(null != var8) {
            return var8;
         }
      }

      ItemComposition var9 = class22.getItemDefinition(var0);
      if(var1 > 1 && var9.field1215 != null) {
         int var10 = -1;

         for(int var21 = 0; var21 < 10; ++var21) {
            if(var1 >= var9.field1206[var21] && var9.field1206[var21] != 0) {
               var10 = var9.field1215[var21];
            }
         }

         if(var10 != -1) {
            var9 = class22.getItemDefinition(var10);
         }
      }

      Model var22 = var9.getModel(1);
      if(null == var22) {
         return null;
      } else {
         SpritePixels var11 = null;
         if(var9.field1177 != -1) {
            var11 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(null == var11) {
               return null;
            }
         } else if(var9.field1218 != -1) {
            var11 = createSprite(var9.field1203, var1, var2, var3, 0, false);
            if(null == var11) {
               return null;
            }
         } else if(var9.field1196 != -1) {
            var11 = createSprite(var9.field1216, var1, 0, 0, 0, false);
            if(var11 == null) {
               return null;
            }
         }

         int[] var12 = class82.graphicsPixels;
         int var13 = class82.graphicsPixelsWidth;
         int var14 = class82.graphicsPixelsHeight;
         int[] var15 = new int[4];
         class82.method1850(var15);
         var8 = new SpritePixels(36, 32);
         class82.setRasterBuffer(var8.image, 36, 32);
         class82.method1867();
         class94.method2158();
         class94.method2165(16, 16);
         class94.rasterGouraudLowRes = false;
         if(var9.field1196 != -1) {
            var11.method1760(0, 0);
         }

         int var16 = var9.field1182;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * class94.field1650[var9.field1183] >> 16;
         int var18 = class94.field1651[var9.field1183] * var16 >> 16;
         var22.method2366();
         var22.method2377(0, var9.field1184, var9.field1201, var9.field1183, var9.field1186, var17 + var22.modelHeight / 2 + var9.field1187, var9.field1187 + var18);
         if(var9.field1218 != -1) {
            var11.method1760(0, 0);
         }

         if(var2 >= 1) {
            var8.method1745(1);
         }

         if(var2 >= 2) {
            var8.method1745(16777215);
         }

         if(var3 != 0) {
            var8.method1806(var3);
         }

         class82.setRasterBuffer(var8.image, 36, 32);
         if(var9.field1177 != -1) {
            var11.method1760(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class227 var19 = class11.field170;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4118(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         class82.setRasterBuffer(var12, var13, var14);
         class82.method1837(var15);
         class94.method2158();
         class94.rasterGouraudLowRes = true;
         return var8;
      }
   }

   class40(String var1, int var2) {
      this.field891 = var1;
      this.field890 = (short)var2;
   }
}
