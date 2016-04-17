import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public final class class5 {
   @ObfuscatedName("w")
   @Export("tileSettings")
   static byte[][][] field82 = new byte[4][104][104];
   @ObfuscatedName("l")
   static final int[] field83 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("y")
   static byte[][][] field84;
   @ObfuscatedName("k")
   static byte[][][] field85;
   @ObfuscatedName("m")
   static int[] field86;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 90439649
   )
   static int field87 = 99;
   @ObfuscatedName("j")
   static final int[] field88 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("h")
   static final int[] field89 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("s")
   static final int[] field90 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("f")
   static final int[] field91 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("b")
   static final int[] field92 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("hw")
   @Export("localPlayer")
   static class2 field93;
   @ObfuscatedName("a")
   @Export("tileHeights")
   static int[][][] field94 = new int[4][105][105];
   @ObfuscatedName("z")
   static int[] field95;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1061046715
   )
   static int field96 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1683809289
   )
   static int field102 = (int)(Math.random() * 33.0D) - 16;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-846261006"
   )
   static int method57(int var0, int var1) {
      class15 var2 = (class15)class15.field230.method3868((long)var0);
      return null == var2?-1:(var1 >= 0 && var1 < var2.field229.length?var2.field229[var1]:-1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILclass107;Lclass108;I)Z",
      garbageValue = "820338894"
   )
   static final boolean method70(int var0, int var1, int var2, class107 var3, class108 var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class106.field1860[var7][var8] = 99;
      class106.field1862[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class106.field1866[var11] = var0;
      int var20 = var11 + 1;
      class106.field1863[var11] = var1;
      int[][] var13 = var4.field1896;

      while(true) {
         label341:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label318:
                     do {
                        if(var12 == var20) {
                           class24.field635 = var5;
                           class50.field1107 = var6;
                           return false;
                        }

                        var5 = class106.field1866[var12];
                        var6 = class106.field1863[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.field1892;
                        var15 = var6 - var4.field1893;
                        if(var3.vmethod2480(var2, var5, var6, var4)) {
                           class24.field635 = var5;
                           class50.field1107 = var6;
                           return true;
                        }

                        var16 = 1 + class106.field1862[var18][var19];
                        if(var18 > 0 && class106.field1860[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1866[var20] = var5 - 1;
                                 class106.field1863[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class106.field1860[var18 - 1][var19] = 2;
                                 class106.field1862[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && 0 == class106.field1860[var18 + 1][var19] && (var13[var2 + var14][var15] & 19136899) == 0 && (var13[var2 + var14][var2 + var15 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1866[var20] = 1 + var5;
                                 class106.field1863[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1860[1 + var18][var19] = 8;
                                 class106.field1862[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && 0 == class106.field1860[var18][var19 - 1] && 0 == (var13[var14][var15 - 1] & 19136782) && 0 == (var13[var2 + var14 - 1][var15 - 1] & 19136899)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1866[var20] = var5;
                                 class106.field1863[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1860[var18][var19 - 1] = 1;
                                 class106.field1862[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class106.field1860[var18][var19 + 1] == 0 && 0 == (var13[var14][var15 + var2] & 19136824) && 0 == (var13[var2 + var14 - 1][var2 + var15] & 19136992)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class106.field1866[var20] = var5;
                                 class106.field1863[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class106.field1860[var18][var19 + 1] = 4;
                                 class106.field1862[var18][1 + var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class106.field1860[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class106.field1866[var20] = var5 - 1;
                                 class106.field1863[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class106.field1860[var18 - 1][var19 - 1] = 3;
                                 class106.field1862[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if(0 != (var13[var14 - 1][var15 - 1 + var17] & 19136830) || (var13[var14 - 1 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && 0 == class106.field1860[1 + var18][var19 - 1] && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class106.field1866[var20] = 1 + var5;
                                 class106.field1863[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class106.field1860[var18 + 1][var19 - 1] = 9;
                                 class106.field1862[1 + var18][var19 - 1] = var16;
                                 break;
                              }

                              if(0 != (var13[var14 + var2][var15 - 1 + var17] & 19136995) || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && 0 == class106.field1860[var18 - 1][1 + var19] && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if(0 != (var13[var14 - 1][var17 + var15] & 19136830) || (var13[var14 - 1 + var17][var15 + var2] & 19137016) != 0) {
                                 continue label318;
                              }
                           }

                           class106.field1866[var20] = var5 - 1;
                           class106.field1863[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class106.field1860[var18 - 1][1 + var19] = 6;
                           class106.field1862[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class106.field1860[var18 + 1][1 + var19] != 0);
            } while((var13[var14 + var2][var2 + var15] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if(0 != (var13[var17 + var14][var15 + var2] & 19137016) || (var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                  continue label341;
               }
            }

            class106.field1866[var20] = var5 + 1;
            class106.field1863[var20] = 1 + var6;
            var20 = var20 + 1 & 4095;
            class106.field1860[var18 + 1][var19 + 1] = 12;
            class106.field1862[1 + var18][1 + var19] = var16;
         }
      }
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2066367342"
   )
   static void method80() {
      for(int var0 = 0; var0 < client.field434; ++var0) {
         if(class34.method818(client.field437[var0])) {
            if(var0 < client.field434 - 1) {
               for(int var1 = var0; var1 < client.field434 - 1; ++var1) {
                  client.field439[var1] = client.field439[1 + var1];
                  client.field440[var1] = client.field440[var1 + 1];
                  client.field437[var1] = client.field437[var1 + 1];
                  client.field500[var1] = client.field500[1 + var1];
                  client.field435[var1] = client.field435[1 + var1];
                  client.field525[var1] = client.field525[1 + var1];
               }
            }

            --client.field434;
         }
      }

   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1702872931"
   )
   static void method113(int var0, int var1) {
      class85.method2006(class183.field2972, var0, var1);
      class183.field2972 = null;
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "-83"
   )
   static final void method114(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class9.method161(var0)) {
         class155.field2289 = null;
         class107.method2482(class173.field2886[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class155.field2289 != null) {
            class107.method2482(class155.field2289, -1412584499, var1, var2, var3, var4, class104.field1782, class175.field2904, var7);
            class155.field2289 = null;
         }

      } else {
         if(var7 != -1) {
            client.field323[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               client.field323[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "1645437465"
   )
   public static int method117(int var0, int var1, int var2, int var3, int var4, int var5) {
      if(1 == (var5 & 1)) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return 0 == var2?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-733327376"
   )
   static final void method118(int var0) {
      short var1 = 256;
      class31.field722 += 128 * var0;
      int var2;
      if(class31.field722 > class110.field1947.length) {
         class31.field722 -= class110.field1947.length;
         var2 = (int)(Math.random() * 12.0D);
         class31.method773(class31.field741[var2]);
      }

      var2 = 0;
      int var3 = 128 * var0;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = class26.field676[var2 + var3] - class110.field1947[class31.field722 + var2 & class110.field1947.length - 1] * var0 / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         class26.field676[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = 128 * var5;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               class26.field676[var7 + var6] = 255;
            } else {
               class26.field676[var7 + var6] = 0;
            }
         }
      }

      if(class31.field733 > 0) {
         class31.field733 -= var0 * 4;
      }

      if(class31.field734 > 0) {
         class31.field734 -= 4 * var0;
      }

      if(class31.field733 == 0 && class31.field734 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class31.field733 = 1024;
         }

         if(var5 == 1) {
            class31.field734 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class31.field731[var5] = class31.field731[var5 + var0];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class31.field731[var5] = (int)(Math.sin((double)class31.field738 / 14.0D) * 16.0D + Math.sin((double)class31.field738 / 15.0D) * 14.0D + Math.sin((double)class31.field738 / 16.0D) * 12.0D);
         ++class31.field738;
      }

      class31.field753 += var0;
      var5 = (var0 + (client.field306 & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class31.field753 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            class26.field676[(var8 << 7) + var7] = 192;
         }

         class31.field753 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var5 + var9 < 128) {
                  var7 += class26.field676[var8 + var9 + var5];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= class26.field676[var8 + var9 - (1 + var5)];
               }

               if(var9 >= 0) {
                  class15.field233[var9 + var8] = var7 / (1 + 2 * var5);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var5 + var8 < var1) {
                  var7 += class15.field233[var6 + var9 + var5 * 128];
               }

               if(var8 - (1 + var5) >= 0) {
                  var7 -= class15.field233[var9 + var6 - 128 * (var5 + 1)];
               }

               if(var8 >= 0) {
                  class26.field676[var9 + var6] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }
}
