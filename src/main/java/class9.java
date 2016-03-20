import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class9 {
   @ObfuscatedName("y")
   static final BigInteger field144 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 1481843447
   )
   static int field148;
   @ObfuscatedName("nj")
   static class74 field150;
   @ObfuscatedName("mk")
   @ObfuscatedGetter(
      intValue = 1721952555
   )
   static int field151;
   @ObfuscatedName("e")
   static final BigInteger field153 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("pe")
   static class159 field154;

   @ObfuscatedName("cg")
   static class172 method133(class172 var0) {
      class172 var2 = var0;
      int var4 = class101.method2294(var0);
      int var3 = var4 >> 17 & 7;
      int var5 = var3;
      class172 var1;
      if(var3 == 0) {
         var1 = null;
      } else {
         int var6 = 0;

         while(true) {
            if(var6 >= var5) {
               var1 = var2;
               break;
            }

            var2 = class92.method2180(var2.field2762);
            if(var2 == null) {
               var1 = null;
               break;
            }

            ++var6;
         }
      }

      class172 var7 = var1;
      if(null == var1) {
         var7 = var0.field2816;
      }

      return var7;
   }

   @ObfuscatedName("r")
   static void method136() {
      for(class23 var0 = (class23)class23.field606.method3860(); var0 != null; var0 = (class23)class23.field606.method3861()) {
         if(null != var0.field620) {
            var0.method582();
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILclass106;Lclass107;Z[I[IB)I",
      garbageValue = "1"
   )
   public static int method137(int var0, int var1, int var2, class106 var3, class107 var4, int[] var5, int[] var6) {
      int var8;
      for(int var7 = 0; var7 < 128; ++var7) {
         for(var8 = 0; var8 < 128; ++var8) {
            class105.field1854[var7][var8] = 0;
            class105.field1856[var7][var8] = 99999999;
         }
      }

      int var9;
      int var10;
      byte var12;
      int var13;
      int var14;
      int var16;
      int var18;
      int var19;
      int var20;
      boolean var26;
      int var28;
      int var29;
      int var31;
      if(var2 == 1) {
         var9 = var0;
         var10 = var1;
         byte var11 = 64;
         var12 = 64;
         var13 = var0 - var11;
         var14 = var1 - var12;
         class105.field1854[var11][var12] = 99;
         class105.field1856[var11][var12] = 0;
         byte var15 = 0;
         var16 = 0;
         class105.field1852[var15] = var0;
         var31 = var15 + 1;
         class105.field1860[var15] = var1;
         int[][] var17 = var4.field1888;

         boolean var27;
         while(true) {
            if(var16 == var31) {
               class105.field1857 = var9;
               class105.field1855 = var10;
               var27 = false;
               break;
            }

            var9 = class105.field1852[var16];
            var10 = class105.field1860[var16];
            var16 = var16 + 1 & 4095;
            var28 = var9 - var13;
            var29 = var10 - var14;
            var18 = var9 - var4.field1884;
            var19 = var10 - var4.field1885;
            if(var3.vmethod2388(var9, var10)) {
               class105.field1857 = var9;
               class105.field1855 = var10;
               var27 = true;
               break;
            }

            var20 = 1 + class105.field1856[var28][var29];
            if(var28 > 0 && 0 == class105.field1854[var28 - 1][var29] && (var17[var18 - 1][var19] & 19136776) == 0) {
               class105.field1852[var31] = var9 - 1;
               class105.field1860[var31] = var10;
               var31 = 1 + var31 & 4095;
               class105.field1854[var28 - 1][var29] = 2;
               class105.field1856[var28 - 1][var29] = var20;
            }

            if(var28 < 127 && 0 == class105.field1854[1 + var28][var29] && (var17[var18 + 1][var19] & 19136896) == 0) {
               class105.field1852[var31] = 1 + var9;
               class105.field1860[var31] = var10;
               var31 = var31 + 1 & 4095;
               class105.field1854[var28 + 1][var29] = 8;
               class105.field1856[var28 + 1][var29] = var20;
            }

            if(var29 > 0 && 0 == class105.field1854[var28][var29 - 1] && 0 == (var17[var18][var19 - 1] & 19136770)) {
               class105.field1852[var31] = var9;
               class105.field1860[var31] = var10 - 1;
               var31 = 1 + var31 & 4095;
               class105.field1854[var28][var29 - 1] = 1;
               class105.field1856[var28][var29 - 1] = var20;
            }

            if(var29 < 127 && class105.field1854[var28][1 + var29] == 0 && 0 == (var17[var18][var19 + 1] & 19136800)) {
               class105.field1852[var31] = var9;
               class105.field1860[var31] = 1 + var10;
               var31 = 1 + var31 & 4095;
               class105.field1854[var28][1 + var29] = 4;
               class105.field1856[var28][var29 + 1] = var20;
            }

            if(var28 > 0 && var29 > 0 && 0 == class105.field1854[var28 - 1][var29 - 1] && 0 == (var17[var18 - 1][var19 - 1] & 19136782) && 0 == (var17[var18 - 1][var19] & 19136776) && (var17[var18][var19 - 1] & 19136770) == 0) {
               class105.field1852[var31] = var9 - 1;
               class105.field1860[var31] = var10 - 1;
               var31 = 1 + var31 & 4095;
               class105.field1854[var28 - 1][var29 - 1] = 3;
               class105.field1856[var28 - 1][var29 - 1] = var20;
            }

            if(var28 < 127 && var29 > 0 && class105.field1854[1 + var28][var29 - 1] == 0 && 0 == (var17[1 + var18][var19 - 1] & 19136899) && (var17[var18 + 1][var19] & 19136896) == 0 && 0 == (var17[var18][var19 - 1] & 19136770)) {
               class105.field1852[var31] = var9 + 1;
               class105.field1860[var31] = var10 - 1;
               var31 = 1 + var31 & 4095;
               class105.field1854[var28 + 1][var29 - 1] = 9;
               class105.field1856[var28 + 1][var29 - 1] = var20;
            }

            if(var28 > 0 && var29 < 127 && 0 == class105.field1854[var28 - 1][var29 + 1] && (var17[var18 - 1][var19 + 1] & 19136824) == 0 && 0 == (var17[var18 - 1][var19] & 19136776) && 0 == (var17[var18][var19 + 1] & 19136800)) {
               class105.field1852[var31] = var9 - 1;
               class105.field1860[var31] = 1 + var10;
               var31 = var31 + 1 & 4095;
               class105.field1854[var28 - 1][1 + var29] = 6;
               class105.field1856[var28 - 1][var29 + 1] = var20;
            }

            if(var28 < 127 && var29 < 127 && 0 == class105.field1854[var28 + 1][var29 + 1] && 0 == (var17[var18 + 1][var19 + 1] & 19136992) && (var17[var18 + 1][var19] & 19136896) == 0 && (var17[var18][1 + var19] & 19136800) == 0) {
               class105.field1852[var31] = 1 + var9;
               class105.field1860[var31] = 1 + var10;
               var31 = 1 + var31 & 4095;
               class105.field1854[1 + var28][var29 + 1] = 12;
               class105.field1856[1 + var28][1 + var29] = var20;
            }
         }

         var26 = var27;
      } else if(2 == var2) {
         var26 = class16.method202(var0, var1, var3, var4);
      } else {
         var26 = class44.method928(var0, var1, var2, var3, var4);
      }

      var8 = var0 - 64;
      var9 = var1 - 64;
      var10 = class105.field1857;
      var28 = class105.field1855;
      if(!var26) {
         var29 = Integer.MAX_VALUE;
         var13 = Integer.MAX_VALUE;
         byte var30 = 10;
         var31 = var3.field1871;
         var16 = var3.field1864;
         int var32 = var3.field1866;
         var18 = var3.field1867;

         for(var19 = var31 - var30; var19 <= var31 + var30; ++var19) {
            for(var20 = var16 - var30; var20 <= var16 + var30; ++var20) {
               int var21 = var19 - var8;
               int var22 = var20 - var9;
               if(var21 >= 0 && var22 >= 0 && var21 < 128 && var22 < 128 && class105.field1856[var21][var22] < 100) {
                  int var23 = 0;
                  if(var19 < var31) {
                     var23 = var31 - var19;
                  } else if(var19 > var32 + var31 - 1) {
                     var23 = var19 - (var31 + var32 - 1);
                  }

                  int var24 = 0;
                  if(var20 < var16) {
                     var24 = var16 - var20;
                  } else if(var20 > var18 + var16 - 1) {
                     var24 = var20 - (var16 + var18 - 1);
                  }

                  int var25 = var23 * var23 + var24 * var24;
                  if(var25 < var29 || var25 == var29 && class105.field1856[var21][var22] < var13) {
                     var29 = var25;
                     var13 = class105.field1856[var21][var22];
                     var10 = var19;
                     var28 = var20;
                  }
               }
            }
         }

         if(var29 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var10 && var28 == var1) {
         return 0;
      } else {
         var12 = 0;
         class105.field1852[var12] = var10;
         var29 = var12 + 1;
         class105.field1860[var12] = var28;

         for(var13 = var14 = class105.field1854[var10 - var8][var28 - var9]; var10 != var0 || var1 != var28; var13 = class105.field1854[var10 - var8][var28 - var9]) {
            if(var14 != var13) {
               var14 = var13;
               class105.field1852[var29] = var10;
               class105.field1860[var29++] = var28;
            }

            if((var13 & 2) != 0) {
               ++var10;
            } else if(0 != (var13 & 8)) {
               --var10;
            }

            if(0 != (var13 & 1)) {
               ++var28;
            } else if(0 != (var13 & 4)) {
               --var28;
            }
         }

         var31 = 0;

         while(var29-- > 0) {
            var5[var31] = class105.field1852[var29];
            var6[var31++] = class105.field1860[var29];
            if(var31 >= var5.length) {
               break;
            }
         }

         return var31;
      }
   }

   @ObfuscatedName("aw")
   static final void method138(class37 var0) {
      int var1 = var0.field857 - client.field303;
      int var2 = var0.field816 * 64 + var0.field853 * 128;
      int var3 = var0.field816 * 64 + var0.field812 * 128;
      var0.field870 += (var2 - var0.field870) / var1;
      var0.field813 += (var3 - var0.field813) / var1;
      var0.field848 = 0;
      var0.field862 = var0.field824;
   }
}
