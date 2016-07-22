import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public final class class92 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1065488095
   )
   int field1623;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1321306277
   )
   int field1624;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1984194171
   )
   int field1626;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 832241903
   )
   int field1627;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -188932279
   )
   int field1628;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -358501469
   )
   int field1629;
   @ObfuscatedName("l")
   boolean field1630 = true;

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "127"
   )
   static final void method2161(int var0) {
      if(var0 >= 0) {
         int var1 = client.field294[var0];
         int var2 = client.field414[var0];
         int var3 = client.field415[var0];
         int var4 = client.field322[var0];
         String var5 = client.field417[var0];
         String var6 = client.field328[var0];
         class35.method729(var1, var2, var3, var4, var5, var6, class143.field2220, class143.field2222);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILclass110;Lclass111;Z[I[II)I",
      garbageValue = "77261212"
   )
   public static int method2162(int var0, int var1, int var2, class110 var3, class111 var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class109.field1936[var8][var9] = 0;
            class109.field1930[var8][var9] = 99999999;
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
         var28 = class16.method182(var0, var1, var3, var4);
      } else if(var2 == 2) {
         var10 = var0;
         var11 = var1;
         byte var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class109.field1936[var12][var13] = 99;
         class109.field1930[var12][var13] = 0;
         byte var16 = 0;
         var17 = 0;
         class109.field1933[var16] = var0;
         var33 = var16 + 1;
         class109.field1927[var16] = var1;
         int[][] var18 = var4.field1954;

         boolean var29;
         while(true) {
            if(var33 == var17) {
               class109.field1934 = var10;
               class109.field1932 = var11;
               var29 = false;
               break;
            }

            var10 = class109.field1933[var17];
            var11 = class109.field1927[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.field1951;
            var20 = var11 - var4.field1952;
            if(var3.vmethod2446(2, var10, var11, var4)) {
               class109.field1934 = var10;
               class109.field1932 = var11;
               var29 = true;
               break;
            }

            var21 = 1 + class109.field1930[var30][var31];
            if(var30 > 0 && class109.field1936[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][1 + var20] & 19136824) == 0) {
               class109.field1933[var33] = var10 - 1;
               class109.field1927[var33] = var11;
               var33 = var33 + 1 & 4095;
               class109.field1936[var30 - 1][var31] = 2;
               class109.field1930[var30 - 1][var31] = var21;
            }

            if(var30 < 126 && class109.field1936[var30 + 1][var31] == 0 && (var18[2 + var19][var20] & 19136899) == 0 && (var18[2 + var19][var20 + 1] & 19136992) == 0) {
               class109.field1933[var33] = 1 + var10;
               class109.field1927[var33] = var11;
               var33 = var33 + 1 & 4095;
               class109.field1936[1 + var30][var31] = 8;
               class109.field1930[1 + var30][var31] = var21;
            }

            if(var31 > 0 && class109.field1936[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[1 + var19][var20 - 1] & 19136899) == 0) {
               class109.field1933[var33] = var10;
               class109.field1927[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class109.field1936[var30][var31 - 1] = 1;
               class109.field1930[var30][var31 - 1] = var21;
            }

            if(var31 < 126 && class109.field1936[var30][var31 + 1] == 0 && (var18[var19][2 + var20] & 19136824) == 0 && (var18[var19 + 1][2 + var20] & 19136992) == 0) {
               class109.field1933[var33] = var10;
               class109.field1927[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class109.field1936[var30][var31 + 1] = 4;
               class109.field1930[var30][1 + var31] = var21;
            }

            if(var30 > 0 && var31 > 0 && class109.field1936[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
               class109.field1933[var33] = var10 - 1;
               class109.field1927[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class109.field1936[var30 - 1][var31 - 1] = 3;
               class109.field1930[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 126 && var31 > 0 && class109.field1936[1 + var30][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136911) == 0 && (var18[2 + var19][var20 - 1] & 19136899) == 0 && (var18[var19 + 2][var20] & 19136995) == 0) {
               class109.field1933[var33] = var10 + 1;
               class109.field1927[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class109.field1936[1 + var30][var31 - 1] = 9;
               class109.field1930[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 126 && class109.field1936[var30 - 1][1 + var31] == 0 && (var18[var19 - 1][1 + var20] & 19136830) == 0 && (var18[var19 - 1][2 + var20] & 19136824) == 0 && (var18[var19][2 + var20] & 19137016) == 0) {
               class109.field1933[var33] = var10 - 1;
               class109.field1927[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class109.field1936[var30 - 1][1 + var31] = 6;
               class109.field1930[var30 - 1][1 + var31] = var21;
            }

            if(var30 < 126 && var31 < 126 && class109.field1936[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][2 + var20] & 19137016) == 0 && (var18[2 + var19][var20 + 2] & 19136992) == 0 && (var18[var19 + 2][1 + var20] & 19136995) == 0) {
               class109.field1933[var33] = 1 + var10;
               class109.field1927[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class109.field1936[var30 + 1][var31 + 1] = 12;
               class109.field1930[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else {
         var28 = class25.method595(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class109.field1934;
      var30 = class109.field1932;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field1940;
         var17 = var3.field1938;
         int var27 = var3.field1939;
         var19 = var3.field1941;

         for(var20 = var33 - var32; var20 <= var32 + var33; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class109.field1930[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var27 + var33 - 1) {
                     var24 = var20 - (var27 + var33 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var26 == var31 && class109.field1930[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class109.field1930[var22][var23];
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
         class109.field1933[var13] = var11;
         var31 = var13 + 1;
         class109.field1927[var13] = var30;

         for(var14 = var15 = class109.field1936[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class109.field1936[var11 - var9][var30 - var10]) {
            if(var14 != var15) {
               var15 = var14;
               class109.field1933[var31] = var11;
               class109.field1927[var31++] = var30;
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
            var6[var33] = class109.field1933[var31];
            var7[var33++] = class109.field1927[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1765922826"
   )
   static final void method2163(boolean var0) {
      class20.method553();
      ++client.field362;
      if(client.field362 >= 50 || var0) {
         client.field362 = 0;
         if(!client.field324 && null != class38.field829) {
            client.field313.method2797(132);

            try {
               class38.field829.method3045(client.field313.field2047, 0, client.field313.field2045);
               client.field313.field2045 = 0;
            } catch (IOException var2) {
               client.field324 = true;
            }
         }

      }
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class92(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1629 = var1;
      this.field1624 = var2;
      this.field1628 = var3;
      this.field1626 = var4;
      this.field1623 = var5;
      this.field1627 = var6;
      this.field1630 = var7;
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)V",
      garbageValue = "-1240346946"
   )
   static void method2164(class176 var0) {
      if(var0.field2927 == client.field474) {
         client.field460[var0.field2813] = true;
      }

   }
}
