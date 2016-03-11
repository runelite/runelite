import java.util.HashMap;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
public class class108 {
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 2000766799
   )
   static int field1910;
   @ObfuscatedName("br")
   static class167 field1915;

   static {
      new HashMap();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1855774929"
   )
   public static void method2375(int var0) {
      if(class182.field2957 != 0) {
         class75.field1388 = var0;
      } else {
         class182.field2954.method3549(var0);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "-47"
   )
   static final void method2377(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class107.field1906.method1901(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(0 != var5) {
         var6 = class107.field1906.method1983(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class42.field1002.field1412;
         var11 = (103 - var2) * 2048 + 24624 + 4 * var1;
         var12 = var5 >> 14 & 32767;
         class40 var13 = class48.method996(var12);
         if(-1 != var13.field946) {
            class80 var14 = class23.field613[var13.field946];
            if(var14 != null) {
               int var15 = (var13.field932 * 4 - var14.field1431) / 2;
               int var16 = (var13.field933 * 4 - var14.field1434) / 2;
               var14.method1838(var15 + 48 + 4 * var1, var16 + 48 + (104 - var2 - var13.field933) * 4);
            }
         } else {
            if(var8 == 0 || 2 == var8) {
               if(0 == var7) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(1 == var7) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(2 == var7) {
                  var10[var11 + 3] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(3 == var7) {
                  var10[var11 + 1536] = var9;
                  var10[1 + 1536 + var11] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[3 + var11 + 1536] = var9;
               }
            }

            if(var8 == 3) {
               if(0 == var7) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(2 == var7) {
                  var10[3 + var11 + 1536] = var9;
               } else if(3 == var7) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[1024 + var11] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[2 + 1536 + var11] = var9;
                  var10[1536 + var11 + 3] = var9;
               }
            }
         }
      }

      var5 = class107.field1906.method1935(var0, var1, var2);
      if(0 != var5) {
         var6 = class107.field1906.method1983(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class40 var19 = class48.method996(var9);
         int var23;
         if(-1 != var19.field946) {
            class80 var21 = class23.field613[var19.field946];
            if(null != var21) {
               var12 = (var19.field932 * 4 - var21.field1431) / 2;
               var23 = (var19.field933 * 4 - var21.field1434) / 2;
               var21.method1838(4 * var1 + 48 + var12, var23 + 48 + 4 * (104 - var2 - var19.field933));
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class42.field1002.field1412;
            var23 = 2048 * (103 - var2) + 24624 + var1 * 4;
            if(var7 != 0 && 2 != var7) {
               var22[var23] = var11;
               var22[1 + 512 + var23] = var11;
               var22[1024 + var23 + 2] = var11;
               var22[3 + 1536 + var23] = var11;
            } else {
               var22[var23 + 1536] = var11;
               var22[1 + var23 + 1024] = var11;
               var22[512 + var23 + 2] = var11;
               var22[3 + var23] = var11;
            }
         }
      }

      var5 = class107.field1906.method2010(var0, var1, var2);
      if(0 != var5) {
         var6 = var5 >> 14 & 32767;
         class40 var17 = class48.method996(var6);
         if(-1 != var17.field946) {
            class80 var18 = class23.field613[var17.field946];
            if(var18 != null) {
               var9 = (var17.field932 * 4 - var18.field1431) / 2;
               int var20 = (var17.field933 * 4 - var18.field1434) / 2;
               var18.method1838(48 + 4 * var1 + var9, 48 + (104 - var2 - var17.field933) * 4 + var20);
            }
         }
      }

   }

   @ObfuscatedName("f")
   static void method2378(class167 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class171 var8 = (class171)class170.field2723.method3744(var6);
      if(null == var8) {
         var8 = (class171)class170.field2735.method3744(var6);
         if(var8 == null) {
            var8 = (class171)class170.field2728.method3744(var6);
            if(null != var8) {
               if(var5) {
                  var8.method3835();
                  class170.field2723.method3746(var8, var6);
                  --class170.field2729;
                  ++class170.field2741;
               }

            } else {
               if(!var5) {
                  var8 = (class171)class170.field2730.method3744(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class171();
               var8.field2748 = var0;
               var8.field2743 = var3;
               var8.field2745 = var4;
               if(var5) {
                  class170.field2723.method3746(var8, var6);
                  ++class170.field2741;
               } else {
                  class170.field2727.method3814(var8);
                  class170.field2728.method3746(var8, var6);
                  ++class170.field2729;
               }

            }
         }
      }
   }

   @ObfuscatedName("l")
   public static void method2379(class166 var0, int var1, int var2, int var3, boolean var4) {
      class182.field2957 = 1;
      class182.field2955 = var0;
      class125.field2043 = var1;
      class7.field138 = var2;
      class75.field1388 = var3;
      class11.field182 = var4;
      class3.field62 = 10000;
   }
}
