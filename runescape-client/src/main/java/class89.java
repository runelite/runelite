import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public final class class89 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1798248171
   )
   int field1558;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1256682015
   )
   int field1559;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -57700195
   )
   int field1560;
   @ObfuscatedName("co")
   static class143 field1561;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 444299519
   )
   int field1562;
   @ObfuscatedName("r")
   boolean field1563 = true;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -224609581
   )
   int field1564;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 1711189935
   )
   @Export("baseX")
   static int field1565;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1147269321
   )
   int field1568;
   @ObfuscatedName("pf")
   static short[] field1569;

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class89(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1568 = var1;
      this.field1559 = var2;
      this.field1560 = var3;
      this.field1564 = var4;
      this.field1562 = var5;
      this.field1558 = var6;
      this.field1563 = var7;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIILclass107;Lclass108;Z[I[IB)I",
      garbageValue = "1"
   )
   public static int method2046(int var0, int var1, int var2, class107 var3, class108 var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class106.field1873[var8][var9] = 0;
            class106.field1877[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var13;
      int var14;
      int var15;
      int var17;
      int var19;
      int var20;
      int var21;
      boolean var28;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var10 = var0;
         var11 = var1;
         byte var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class106.field1873[var12][var13] = 99;
         class106.field1877[var12][var13] = 0;
         byte var16 = 0;
         var17 = 0;
         class106.field1881[var16] = var0;
         var33 = var16 + 1;
         class106.field1876[var16] = var1;
         int[][] var18 = var4.field1906;

         boolean var29;
         while(true) {
            if(var17 == var33) {
               class10.field163 = var10;
               class106.field1875 = var11;
               var29 = false;
               break;
            }

            var10 = class106.field1881[var17];
            var11 = class106.field1876[var17];
            var17 = 1 + var17 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.field1907;
            var20 = var11 - var4.field1903;
            if(var3.vmethod2345(1, var10, var11, var4)) {
               class10.field163 = var10;
               class106.field1875 = var11;
               var29 = true;
               break;
            }

            var21 = class106.field1877[var30][var31] + 1;
            if(var30 > 0 && class106.field1873[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class106.field1881[var33] = var10 - 1;
               class106.field1876[var33] = var11;
               var33 = var33 + 1 & 4095;
               class106.field1873[var30 - 1][var31] = 2;
               class106.field1877[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class106.field1873[1 + var30][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class106.field1881[var33] = var10 + 1;
               class106.field1876[var33] = var11;
               var33 = var33 + 1 & 4095;
               class106.field1873[1 + var30][var31] = 8;
               class106.field1877[1 + var30][var31] = var21;
            }

            if(var31 > 0 && class106.field1873[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class106.field1881[var33] = var10;
               class106.field1876[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class106.field1873[var30][var31 - 1] = 1;
               class106.field1877[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class106.field1873[var30][1 + var31] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class106.field1881[var33] = var10;
               class106.field1876[var33] = 1 + var11;
               var33 = 1 + var33 & 4095;
               class106.field1873[var30][1 + var31] = 4;
               class106.field1877[var30][1 + var31] = var21;
            }

            if(var30 > 0 && var31 > 0 && class106.field1873[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class106.field1881[var33] = var10 - 1;
               class106.field1876[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class106.field1873[var30 - 1][var31 - 1] = 3;
               class106.field1877[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class106.field1873[var30 + 1][var31 - 1] == 0 && (var18[1 + var19][var20 - 1] & 19136899) == 0 && (var18[1 + var19][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class106.field1881[var33] = var10 + 1;
               class106.field1876[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class106.field1873[1 + var30][var31 - 1] = 9;
               class106.field1877[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class106.field1873[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class106.field1881[var33] = var10 - 1;
               class106.field1876[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class106.field1873[var30 - 1][var31 + 1] = 6;
               class106.field1877[var30 - 1][1 + var31] = var21;
            }

            if(var30 < 127 && var31 < 127 && class106.field1873[var30 + 1][1 + var31] == 0 && (var18[1 + var19][1 + var20] & 19136992) == 0 && (var18[1 + var19][var20] & 19136896) == 0 && (var18[var19][1 + var20] & 19136800) == 0) {
               class106.field1881[var33] = var10 + 1;
               class106.field1876[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class106.field1873[var30 + 1][var31 + 1] = 12;
               class106.field1877[1 + var30][1 + var31] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var28 = class99.method2156(var0, var1, var3, var4);
      } else {
         var28 = class11.method130(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class10.field163;
      var30 = class106.field1875;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field1883;
         var17 = var3.field1887;
         int var27 = var3.field1884;
         var19 = var3.field1889;

         for(var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class106.field1877[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var27 + var33 - 1) {
                     var24 = var20 - (var33 + var27 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var24 * var24 + var25 * var25;
                  if(var26 < var31 || var31 == var26 && class106.field1877[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class106.field1877[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var11 == var0 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class106.field1881[var13] = var11;
         var31 = var13 + 1;
         class106.field1876[var13] = var30;

         for(var14 = var15 = class106.field1873[var11 - var9][var30 - var10]; var0 != var11 || var1 != var30; var14 = class106.field1873[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class106.field1881[var31] = var11;
               class106.field1876[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class106.field1881[var31];
            var7[var33++] = class106.field1876[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1688518015"
   )
   static final void method2047() {
      if(client.field511 != class32.field754) {
         client.field511 = class32.field754;
         class137.method2900(class32.field754);
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1693143943"
   )
   static final boolean method2048(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = client.field392[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
