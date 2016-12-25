import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class20 implements Runnable {
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -2005543917
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("i")
   boolean field209 = true;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1973185631
   )
   int field210 = 0;
   @ObfuscatedName("k")
   int[] field211 = new int[500];
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = 640796557
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("bh")
   static ModIcon[] field216;
   @ObfuscatedName("e")
   Object field217 = new Object();
   @ObfuscatedName("mm")
   static byte field218;
   @ObfuscatedName("g")
   int[] field219 = new int[500];

   public void run() {
      for(; this.field209; class10.method149(50L)) {
         Object var1 = this.field217;
         synchronized(this.field217) {
            if(this.field210 < 500) {
               this.field211[this.field210] = class115.field1794;
               this.field219[this.field210] = class115.field1797;
               ++this.field210;
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)Z",
      garbageValue = "-1506"
   )
   static boolean method194(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1372525450"
   )
   static final void method197() {
      class94.method1890(Client.field511);
      ++class72.field1191;
      if(Client.field467 && Client.field464) {
         int var0 = class115.field1794;
         int var1 = class115.field1797;
         var0 -= Client.field461;
         var1 -= Client.field462;
         if(var0 < Client.field494) {
            var0 = Client.field494;
         }

         if(Client.field511.width + var0 > Client.field460.width + Client.field494) {
            var0 = Client.field460.width + Client.field494 - Client.field511.width;
         }

         if(var1 < Client.field329) {
            var1 = Client.field329;
         }

         if(var1 + Client.field511.height > Client.field460.height + Client.field329) {
            var1 = Client.field460.height + Client.field329 - Client.field511.height;
         }

         int var2 = var0 - Client.field468;
         int var3 = var1 - Client.field325;
         int var4 = Client.field511.field2306;
         if(class72.field1191 > Client.field511.field2285 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            Client.field470 = true;
         }

         int var5 = var0 - Client.field494 + Client.field460.scrollX;
         int var6 = Client.field460.scrollY + (var1 - Client.field329);
         class18 var7;
         if(Client.field511.field2318 != null && Client.field470) {
            var7 = new class18();
            var7.field187 = Client.field511;
            var7.field192 = var5;
            var7.field189 = var6;
            var7.field188 = Client.field511.field2318;
            Ignore.method191(var7);
         }

         if(class115.field1795 == 0) {
            if(Client.field470) {
               if(null != Client.field511.field2298) {
                  var7 = new class18();
                  var7.field187 = Client.field511;
                  var7.field192 = var5;
                  var7.field189 = var6;
                  var7.field196 = Client.field463;
                  var7.field188 = Client.field511.field2298;
                  Ignore.method191(var7);
               }

               if(null != Client.field463) {
                  Widget var8 = Client.field511;
                  int var9 = class3.method34(class143.method2647(var8));
                  Widget var14;
                  if(var9 == 0) {
                     var14 = null;
                  } else {
                     int var10 = 0;

                     while(true) {
                        if(var10 >= var9) {
                           var14 = var8;
                           break;
                        }

                        var8 = class191.method3433(var8.parentId);
                        if(null == var8) {
                           var14 = null;
                           break;
                        }

                        ++var10;
                     }
                  }

                  if(var14 != null) {
                     Client.field294.method2976(28);
                     Client.field294.method2804(Client.field511.id);
                     Client.field294.method2793(Client.field463.index);
                     Client.field294.method2893(Client.field463.id);
                     Client.field294.method2763(Client.field463.item);
                     Client.field294.method2793(Client.field511.item);
                     Client.field294.method2793(Client.field511.index);
                  }
               }
            } else if((Client.field426 == 1 || class7.method94(Client.menuOptionCount - 1)) && Client.menuOptionCount > 2) {
               class172.method3178(Client.field468 + Client.field461, Client.field462 + Client.field325);
            } else if(Client.menuOptionCount > 0) {
               int var12 = Client.field468 + Client.field461;
               int var13 = Client.field325 + Client.field462;
               class38 var11 = Player.field260;
               class185.menuAction(var11.field797, var11.field800, var11.field795, var11.field798, var11.field799, var11.field799, var12, var13);
               Player.field260 = null;
            }

            Client.field511 = null;
         }

      } else {
         if(class72.field1191 > 1) {
            Client.field511 = null;
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;I)V",
      garbageValue = "1971836586"
   )
   static final void method198(Region var0, CollisionData[] var1) {
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
                     var1[var5].method2213(var3, var4);
                  }
               }
            }
         }
      }

      class10.field100 += (int)(Math.random() * 5.0D) - 2;
      if(class10.field100 < -8) {
         class10.field100 = -8;
      }

      if(class10.field100 > 8) {
         class10.field100 = 8;
      }

      class10.field101 += (int)(Math.random() * 5.0D) - 2;
      if(class10.field101 < -16) {
         class10.field101 = -16;
      }

      if(class10.field101 > 16) {
         class10.field101 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var17;
      int var18;
      int var46;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var45 = class10.field92[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class10.tileHeights[var2][1 + var12][var11] - class10.tileHeights[var2][var12 - 1][var11];
               var14 = class10.tileHeights[var2][var12][1 + var11] - class10.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + 65536 + var14 * var14));
               var46 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = 96 + (var17 * -10 + -50 * var46 + var18 * -50) / var10;
               var20 = (var45[var12][var11 + 1] >> 3) + (var45[var12][var11 - 1] >> 2) + (var45[1 + var12][var11] >> 3) + (var45[var12 - 1][var11] >> 2) + (var45[var12][var11] >> 1);
               class7.field65[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class211.field3116[var11] = 0;
            WallObject.field1552[var11] = 0;
            CombatInfo1.field662[var11] = 0;
            class211.field3118[var11] = 0;
            ItemLayer.field1222[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = NPC.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     class191 var44 = class183.method3307(var14 - 1);
                     class211.field3116[var12] += var44.field2811;
                     WallObject.field1552[var12] += var44.field2812;
                     CombatInfo1.field662[var12] += var44.field2815;
                     class211.field3118[var12] += var44.field2808;
                     ++ItemLayer.field1222[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = NPC.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     class191 var16 = class183.method3307(var15 - 1);
                     class211.field3116[var12] -= var16.field2811;
                     WallObject.field1552[var12] -= var16.field2812;
                     CombatInfo1.field662[var12] -= var16.field2815;
                     class211.field3118[var12] -= var16.field2808;
                     --ItemLayer.field1222[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var46 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class211.field3116[var18];
                     var13 += WallObject.field1552[var18];
                     var14 += CombatInfo1.field662[var18];
                     var15 += class211.field3118[var18];
                     var46 += ItemLayer.field1222[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class211.field3116[var19];
                     var13 -= WallObject.field1552[var19];
                     var14 -= CombatInfo1.field662[var19];
                     var15 -= class211.field3118[var19];
                     var46 -= ItemLayer.field1222[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field289 || (class10.tileSettings[0][var11][var17] & 2) != 0 || (class10.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class10.field102) {
                        class10.field102 = var2;
                     }

                     var20 = NPC.underlayIds[var2][var11][var17] & 255;
                     int var21 = class11.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class10.tileHeights[var2][var11][var17];
                        int var23 = class10.tileHeights[var2][var11 + 1][var17];
                        int var24 = class10.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class10.tileHeights[var2][var11][var17 + 1];
                        int var26 = class7.field65[var11][var17];
                        int var27 = class7.field65[1 + var11][var17];
                        int var28 = class7.field65[1 + var11][var17 + 1];
                        int var29 = class7.field65[var11][1 + var17];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        int var34;
                        if(var20 > 0) {
                           var32 = 256 * var12 / var15;
                           var33 = var13 / var46;
                           var34 = var14 / var46;
                           var30 = class41.method762(var32, var33, var34);
                           var32 = var32 + class10.field100 & 255;
                           var34 += class10.field101;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class41.method762(var32, var33, var34);
                        }

                        class200 var35;
                        if(var2 > 0) {
                           boolean var51 = true;
                           if(var20 == 0 && class10.overlayPaths[var2][var11][var17] != 0) {
                              var51 = false;
                           }

                           if(var21 > 0) {
                              var34 = var21 - 1;
                              var35 = (class200)class200.field3045.get((long)var34);
                              class200 var48;
                              if(var35 != null) {
                                 var48 = var35;
                              } else {
                                 byte[] var47 = class200.field3037.method3211(4, var34);
                                 var35 = new class200();
                                 if(null != var47) {
                                    var35.method3662(new Buffer(var47), var34);
                                 }

                                 var35.method3672();
                                 class200.field3045.put(var35, (long)var34);
                                 var48 = var35;
                              }

                              if(!var48.field3039) {
                                 var51 = false;
                              }
                           }

                           if(var51 && var23 == var22 && var24 == var22 && var22 == var25) {
                              class10.field97[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class84.colorPalette[class8.method97(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method1696(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class8.method97(var30, var26), class8.method97(var30, var27), class8.method97(var30, var28), class8.method97(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class10.overlayPaths[var2][var11][var17] + 1;
                           byte var52 = class65.overlayRotations[var2][var11][var17];
                           int var36 = var21 - 1;
                           class200 var37 = (class200)class200.field3045.get((long)var36);
                           if(null != var37) {
                              var35 = var37;
                           } else {
                              byte[] var38 = class200.field3037.method3211(4, var36);
                              var37 = new class200();
                              if(null != var38) {
                                 var37.method3662(new Buffer(var38), var36);
                              }

                              var37.method3672();
                              class200.field3045.put(var37, (long)var36);
                              var35 = var37;
                           }

                           int var49 = var35.field3038;
                           int var39;
                           int var40;
                           int var41;
                           int var42;
                           if(var49 >= 0) {
                              var40 = class84.field1450.vmethod1872(var49);
                              var39 = -1;
                           } else if(var35.field3036 == 16711935) {
                              var39 = -2;
                              var49 = -1;
                              var40 = -2;
                           } else {
                              var39 = class41.method762(var35.field3041, var35.field3042, var35.field3043);
                              var41 = var35.field3041 + class10.field100 & 255;
                              var42 = var35.field3043 + class10.field101;
                              if(var42 < 0) {
                                 var42 = 0;
                              } else if(var42 > 255) {
                                 var42 = 255;
                              }

                              var40 = class41.method762(var41, var35.field3042, var42);
                           }

                           var41 = 0;
                           if(var40 != -2) {
                              var41 = class84.colorPalette[class37.method703(var40, 96)];
                           }

                           if(var35.field3040 != -1) {
                              var42 = class10.field100 + var35.field3044 & 255;
                              int var43 = class10.field101 + var35.field3046;
                              if(var43 < 0) {
                                 var43 = 0;
                              } else if(var43 > 255) {
                                 var43 = 255;
                              }

                              var40 = class41.method762(var42, var35.field3035, var43);
                              var41 = class84.colorPalette[class37.method703(var40, 96)];
                           }

                           var0.method1696(var2, var11, var17, var33, var52, var49, var22, var23, var24, var25, class8.method97(var30, var26), class8.method97(var30, var27), class8.method97(var30, var28), class8.method97(var30, var29), class37.method703(var39, var26), class37.method703(var39, var27), class37.method703(var39, var28), class37.method703(var39, var29), var32, var41);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.method1834(var2, var12, var11, class15.method173(var2, var12, var11));
            }
         }

         NPC.underlayIds[var2] = null;
         class11.overlayIds[var2] = null;
         class10.overlayPaths[var2] = null;
         class65.overlayRotations[var2] = null;
         class10.field92[var2] = null;
      }

      var0.method1722(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class10.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method1693(var2, var3);
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
                  short var50;
                  if((class10.field97[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class10.field97[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class10.field97[var6][var8][1 + var10] & var2) != 0) {
                        ++var10;
                     }

                     label554:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class10.field97[var11 - 1][var8][var13] & var2) == 0) {
                              break label554;
                           }
                        }

                        --var11;
                     }

                     label543:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class10.field97[1 + var12][var8][var13] & var2) == 0) {
                              break label543;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (1 + (var10 - var9));
                     if(var13 >= 8) {
                        var50 = 240;
                        var15 = class10.tileHeights[var12][var8][var9] - var50;
                        var46 = class10.tileHeights[var11][var8][var9];
                        Region.method1702(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var46);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class10.field97[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class10.field97[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class10.field97[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class10.field97[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label607:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class10.field97[var11 - 1][var13][var7] & var3) == 0) {
                              break label607;
                           }
                        }

                        --var11;
                     }

                     label596:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class10.field97[var12 + 1][var13][var7] & var3) == 0) {
                              break label596;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var50 = 240;
                        var15 = class10.tileHeights[var12][var9][var7] - var50;
                        var46 = class10.tileHeights[var11][var9][var7];
                        Region.method1702(var5, 2, var9 * 128, var10 * 128 + 128, 128 * var7, 128 * var7, var15, var46);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class10.field97[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class10.field97[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class10.field97[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class10.field97[var6][var8][1 + var12] & var4) != 0) {
                        ++var12;
                     }

                     label660:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class10.field97[var6][var9 - 1][var13] & var4) == 0) {
                              break label660;
                           }
                        }

                        --var9;
                     }

                     label649:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class10.field97[var6][var10 + 1][var13] & var4) == 0) {
                              break label649;
                           }
                        }

                        ++var10;
                     }

                     if((1 + (var12 - var11)) * (1 + (var10 - var9)) >= 4) {
                        var13 = class10.tileHeights[var6][var9][var11];
                        Region.method1702(var5, 4, var9 * 128, 128 + var10 * 128, 128 * var11, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class10.field97[var6][var14][var15] &= ~var4;
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
