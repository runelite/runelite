import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class45 extends class207 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1120155595
   )
   int field1033 = 0;
   @ObfuscatedName("l")
   static class170 field1034;
   @ObfuscatedName("r")
   public static class196 field1035 = new class196(64);
   @ObfuscatedName("e")
   public static class196 field1036 = new class196(30);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -803553263
   )
   int field1037;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1733633239
   )
   int field1038;
   @ObfuscatedName("g")
   static class170 field1039;
   @ObfuscatedName("u")
   short[] field1040;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -91231621
   )
   int field1041 = 128;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -674917835
   )
   public int field1042 = -1;
   @ObfuscatedName("m")
   short[] field1043;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1701214767
   )
   int field1044 = 128;
   @ObfuscatedName("n")
   short[] field1045;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 949013817
   )
   int field1046 = 0;
   @ObfuscatedName("b")
   short[] field1047;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 20963917
   )
   int field1048 = 0;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = -1650637493
   )
   protected static int field1050;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass27;Lclass27;IZS)I",
      garbageValue = "-16859"
   )
   static int method949(class27 var0, class27 var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.field669;
         int var5 = var1.field669;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.field672 - var1.field672:(var2 == 3?(var0.field680.equals("-")?(var1.field680.equals("-")?0:(var3?-1:1)):(var1.field680.equals("-")?(var3?1:-1):var0.field680.compareTo(var1.field680))):(var2 == 4?(var0.method635()?(var1.method635()?0:1):(var1.method635()?-1:0)):(var2 == 5?(var0.method633()?(var1.method633()?0:1):(var1.method633()?-1:0)):(var2 == 6?(var0.method634()?(var1.method634()?0:1):(var1.method634()?-1:0)):(var2 == 7?(var0.method632()?(var1.method632()?0:1):(var1.method632()?-1:0)):var0.field667 - var1.field667)))));
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "652004690"
   )
   void method951(class122 var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method960(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Lclass108;",
      garbageValue = "1306370646"
   )
   public final class108 method952(int var1) {
      class108 var2 = (class108)field1036.method3905((long)this.field1037);
      if(var2 == null) {
         class103 var3 = class103.method2369(field1039, this.field1038, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(this.field1040 != null) {
            for(var4 = 0; var4 < this.field1040.length; ++var4) {
               var3.method2305(this.field1040[var4], this.field1045[var4]);
            }
         }

         if(this.field1047 != null) {
            for(var4 = 0; var4 < this.field1047.length; ++var4) {
               var3.method2306(this.field1047[var4], this.field1043[var4]);
            }
         }

         var2 = var3.method2321(this.field1048 + 64, 850 + this.field1033, -30, -50, -30);
         field1036.method3907(var2, (long)this.field1037);
      }

      class108 var5;
      if(this.field1042 != -1 && var1 != -1) {
         var5 = class22.method585(this.field1042).method907(var2, var1);
      } else {
         var5 = var2.method2400(true);
      }

      if(this.field1044 != 128 || this.field1041 != 128) {
         var5.method2404(this.field1044, this.field1041, this.field1044);
      }

      if(this.field1046 != 0) {
         if(this.field1046 == 90) {
            var5.method2455();
         }

         if(this.field1046 == 180) {
            var5.method2455();
            var5.method2455();
         }

         if(this.field1046 == 270) {
            var5.method2455();
            var5.method2455();
            var5.method2455();
         }
      }

      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "-46"
   )
   void method960(class122 var1, int var2) {
      if(var2 == 1) {
         this.field1038 = var1.method2635();
      } else if(var2 == 2) {
         this.field1042 = var1.method2635();
      } else if(var2 == 4) {
         this.field1044 = var1.method2635();
      } else if(var2 == 5) {
         this.field1041 = var1.method2635();
      } else if(var2 == 6) {
         this.field1046 = var1.method2635();
      } else if(var2 == 7) {
         this.field1048 = var1.method2633();
      } else if(var2 == 8) {
         this.field1033 = var1.method2633();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2633();
            this.field1040 = new short[var3];
            this.field1045 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1040[var4] = (short)var1.method2635();
               this.field1045[var4] = (short)var1.method2635();
            }
         } else if(var2 == 41) {
            var3 = var1.method2633();
            this.field1047 = new short[var3];
            this.field1043 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1047[var4] = (short)var1.method2635();
               this.field1043[var4] = (short)var1.method2635();
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIILclass110;Lclass111;Z[I[II)I",
      garbageValue = "-2012157990"
   )
   public static int method967(int var0, int var1, int var2, class110 var3, class111 var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class109.field1941[var8][var9] = 0;
            class109.field1938[var8][var9] = 99999999;
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
         class109.field1941[var12][var13] = 99;
         class109.field1938[var12][var13] = 0;
         byte var16 = 0;
         var17 = 0;
         class109.field1935[var16] = var0;
         var33 = var16 + 1;
         class109.field1942[var16] = var1;
         int[][] var18 = var4.field1969;

         boolean var29;
         while(true) {
            if(var17 == var33) {
               class93.field1634 = var10;
               class109.field1937 = var11;
               var29 = false;
               break;
            }

            var10 = class109.field1935[var17];
            var11 = class109.field1942[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.field1965;
            var20 = var11 - var4.field1966;
            if(var3.vmethod2486(1, var10, var11, var4)) {
               class93.field1634 = var10;
               class109.field1937 = var11;
               var29 = true;
               break;
            }

            var21 = class109.field1938[var30][var31] + 1;
            if(var30 > 0 && class109.field1941[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class109.field1935[var33] = var10 - 1;
               class109.field1942[var33] = var11;
               var33 = var33 + 1 & 4095;
               class109.field1941[var30 - 1][var31] = 2;
               class109.field1938[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class109.field1941[1 + var30][var31] == 0 && (var18[1 + var19][var20] & 19136896) == 0) {
               class109.field1935[var33] = var10 + 1;
               class109.field1942[var33] = var11;
               var33 = 1 + var33 & 4095;
               class109.field1941[1 + var30][var31] = 8;
               class109.field1938[1 + var30][var31] = var21;
            }

            if(var31 > 0 && class109.field1941[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class109.field1935[var33] = var10;
               class109.field1942[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class109.field1941[var30][var31 - 1] = 1;
               class109.field1938[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class109.field1941[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class109.field1935[var33] = var10;
               class109.field1942[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class109.field1941[var30][var31 + 1] = 4;
               class109.field1938[var30][1 + var31] = var21;
            }

            if(var30 > 0 && var31 > 0 && class109.field1941[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class109.field1935[var33] = var10 - 1;
               class109.field1942[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class109.field1941[var30 - 1][var31 - 1] = 3;
               class109.field1938[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class109.field1941[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[1 + var19][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class109.field1935[var33] = 1 + var10;
               class109.field1942[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class109.field1941[var30 + 1][var31 - 1] = 9;
               class109.field1938[1 + var30][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class109.field1941[var30 - 1][1 + var31] == 0 && (var18[var19 - 1][1 + var20] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class109.field1935[var33] = var10 - 1;
               class109.field1942[var33] = 1 + var11;
               var33 = 1 + var33 & 4095;
               class109.field1941[var30 - 1][var31 + 1] = 6;
               class109.field1938[var30 - 1][1 + var31] = var21;
            }

            if(var30 < 127 && var31 < 127 && class109.field1941[var30 + 1][1 + var31] == 0 && (var18[var19 + 1][1 + var20] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class109.field1935[var33] = 1 + var10;
               class109.field1942[var33] = 1 + var11;
               var33 = 1 + var33 & 4095;
               class109.field1941[1 + var30][var31 + 1] = 12;
               class109.field1938[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var28 = class137.method3015(var0, var1, var3, var4);
      } else {
         var28 = class146.method3153(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class93.field1634;
      var30 = class109.field1937;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field1951;
         var17 = var3.field1948;
         int var27 = var3.field1949;
         var19 = var3.field1950;

         for(var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class109.field1938[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var33 + var27 - 1) {
                     var24 = var20 - (var33 + var27 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var19 + var17 - 1);
                  }

                  int var26 = var24 * var24 + var25 * var25;
                  if(var26 < var31 || var26 == var31 && class109.field1938[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class109.field1938[var22][var23];
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

      if(var0 == var11 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class109.field1935[var13] = var11;
         var31 = var13 + 1;
         class109.field1942[var13] = var30;

         for(var14 = var15 = class109.field1941[var11 - var9][var30 - var10]; var0 != var11 || var1 != var30; var14 = class109.field1941[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class109.field1935[var31] = var11;
               class109.field1942[var31++] = var30;
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
            var6[var33] = class109.field1935[var31];
            var7[var33++] = class109.field1942[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }
}
