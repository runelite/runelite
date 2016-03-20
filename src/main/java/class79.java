import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cs")
public class class79 extends class203 {
   @ObfuscatedName("u")
   public static int field1409 = 0;
   @ObfuscatedName("i")
   public static int[] field1410;
   @ObfuscatedName("z")
   public static int field1411;
   @ObfuscatedName("v")
   public static int field1412;
   @ObfuscatedName("t")
   public static int field1413 = 0;
   @ObfuscatedName("b")
   protected static int field1414 = 0;
   @ObfuscatedName("c")
   protected static int field1415 = 0;

   @ObfuscatedName("cy")
   public static void method1822(int[] var0, int var1, int var2) {
      field1410 = var0;
      field1412 = var1;
      field1411 = var2;
      method1852(0, 0, var1, var2);
   }

   @ObfuscatedName("cn")
   public static void method1825(int var0, int var1, int var2, int var3) {
      if(field1414 < var0) {
         field1414 = var0;
      }

      if(field1409 < var1) {
         field1409 = var1;
      }

      if(field1415 > var2) {
         field1415 = var2;
      }

      if(field1413 > var3) {
         field1413 = var3;
      }

   }

   @ObfuscatedName("ch")
   public static void method1826(int[] var0) {
      var0[0] = field1414;
      var0[1] = field1409;
      var0[2] = field1415;
      var0[3] = field1413;
   }

   @ObfuscatedName("cw")
   public static void method1829(int var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 < field1414) {
         var2 -= field1414 - var0;
         var0 = field1414;
      }

      if(var1 < field1409) {
         var3 -= field1409 - var1;
         var1 = field1409;
      }

      if(var0 + var2 > field1415) {
         var2 = field1415 - var0;
      }

      if(var1 + var3 > field1413) {
         var3 = field1413 - var1;
      }

      var4 = ((var4 & 16711935) * var5 >> 8 & 16711935) + ((var4 & '\uff00') * var5 >> 8 & '\uff00');
      int var6 = 256 - var5;
      int var7 = field1412 - var2;
      int var8 = var0 + var1 * field1412;

      for(int var9 = 0; var9 < var3; ++var9) {
         for(int var10 = -var2; var10 < 0; ++var10) {
            int var11 = field1410[var8];
            var11 = ((var11 & 16711935) * var6 >> 8 & 16711935) + ((var11 & '\uff00') * var6 >> 8 & '\uff00');
            field1410[var8++] = var4 + var11;
         }

         var8 += var7;
      }

   }

   @ObfuscatedName("ce")
   public static void method1830(int var0, int var1, int var2, int var3, int var4) {
      if(var0 < field1414) {
         var2 -= field1414 - var0;
         var0 = field1414;
      }

      if(var1 < field1409) {
         var3 -= field1409 - var1;
         var1 = field1409;
      }

      if(var0 + var2 > field1415) {
         var2 = field1415 - var0;
      }

      if(var1 + var3 > field1413) {
         var3 = field1413 - var1;
      }

      int var5 = field1412 - var2;
      int var6 = var0 + var1 * field1412;

      for(int var7 = -var3; var7 < 0; ++var7) {
         for(int var8 = -var2; var8 < 0; ++var8) {
            field1410[var6++] = var4;
         }

         var6 += var5;
      }

   }

   @ObfuscatedName("dn")
   public static void method1831(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 0;
      int var7 = 65536 / var3;
      if(var0 < field1414) {
         var2 -= field1414 - var0;
         var0 = field1414;
      }

      if(var1 < field1409) {
         var6 += (field1409 - var1) * var7;
         var3 -= field1409 - var1;
         var1 = field1409;
      }

      if(var0 + var2 > field1415) {
         var2 = field1415 - var0;
      }

      if(var1 + var3 > field1413) {
         var3 = field1413 - var1;
      }

      int var8 = field1412 - var2;
      int var9 = var0 + var1 * field1412;

      for(int var10 = -var3; var10 < 0; ++var10) {
         int var11 = 65536 - var6 >> 8;
         int var12 = var6 >> 8;
         int var13 = ((var4 & 16711935) * var11 + (var5 & 16711935) * var12 & -16711936) + ((var4 & '\uff00') * var11 + (var5 & '\uff00') * var12 & 16711680) >>> 8;

         for(int var14 = -var2; var14 < 0; ++var14) {
            field1410[var9++] = var13;
         }

         var9 += var8;
         var6 += var7;
      }

   }

   @ObfuscatedName("dd")
   public static void method1833(int var0, int var1, int var2, int var3, int var4, int var5) {
      method1835(var0, var1, var2, var4, var5);
      method1835(var0, var1 + var3 - 1, var2, var4, var5);
      if(var3 >= 3) {
         method1866(var0, var1 + 1, var3 - 2, var4, var5);
         method1866(var0 + var2 - 1, var1 + 1, var3 - 2, var4, var5);
      }

   }

   @ObfuscatedName("da")
   static void method1835(int var0, int var1, int var2, int var3, int var4) {
      if(var1 >= field1409 && var1 < field1413) {
         if(var0 < field1414) {
            var2 -= field1414 - var0;
            var0 = field1414;
         }

         if(var0 + var2 > field1415) {
            var2 = field1415 - var0;
         }

         int var5 = 256 - var4;
         int var6 = (var3 >> 16 & 255) * var4;
         int var7 = (var3 >> 8 & 255) * var4;
         int var8 = (var3 & 255) * var4;
         int var12 = var0 + var1 * field1412;

         for(int var13 = 0; var13 < var2; ++var13) {
            int var9 = (field1410[var12] >> 16 & 255) * var5;
            int var10 = (field1410[var12] >> 8 & 255) * var5;
            int var11 = (field1410[var12] & 255) * var5;
            int var14 = (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8) + (var8 + var11 >> 8);
            field1410[var12++] = var14;
         }

      }
   }

   @ObfuscatedName("du")
   public static void method1838(int var0, int var1, int var2, int var3, int var4) {
      var2 -= var0;
      var3 -= var1;
      if(var3 == 0) {
         if(var2 >= 0) {
            method1864(var0, var1, var2 + 1, var4);
         } else {
            method1864(var0 + var2, var1, -var2 + 1, var4);
         }

      } else if(var2 == 0) {
         if(var3 >= 0) {
            method1862(var0, var1, var3 + 1, var4);
         } else {
            method1862(var0, var1 + var3, -var3 + 1, var4);
         }

      } else {
         if(var2 + var3 < 0) {
            var0 += var2;
            var2 = -var2;
            var1 += var3;
            var3 = -var3;
         }

         int var5;
         int var6;
         if(var2 > var3) {
            var1 <<= 16;
            var1 += '耀';
            var3 <<= 16;
            var5 = (int)Math.floor((double)var3 / (double)var2 + 0.5D);
            var2 += var0;
            if(var0 < field1414) {
               var1 += var5 * (field1414 - var0);
               var0 = field1414;
            }

            if(var2 >= field1415) {
               var2 = field1415 - 1;
            }

            while(var0 <= var2) {
               var6 = var1 >> 16;
               if(var6 >= field1409 && var6 < field1413) {
                  field1410[var0 + var6 * field1412] = var4;
               }

               var1 += var5;
               ++var0;
            }
         } else {
            var0 <<= 16;
            var0 += '耀';
            var2 <<= 16;
            var5 = (int)Math.floor((double)var2 / (double)var3 + 0.5D);
            var3 += var1;
            if(var1 < field1409) {
               var0 += var5 * (field1409 - var1);
               var1 = field1409;
            }

            if(var3 >= field1413) {
               var3 = field1413 - 1;
            }

            while(var1 <= var3) {
               var6 = var0 >> 16;
               if(var6 >= field1414 && var6 < field1415) {
                  field1410[var6 + var1 * field1412] = var4;
               }

               var0 += var5;
               ++var1;
            }
         }

      }
   }

   @ObfuscatedName("do")
   public static void method1839(int var0, int var1, int var2, int[] var3, int[] var4) {
      int var5 = var0 + var1 * field1412;

      for(var1 = 0; var1 < var3.length; ++var1) {
         int var6 = var5 + var3[var1];

         for(var0 = -var4[var1]; var0 < 0; ++var0) {
            field1410[var6++] = var2;
         }

         var5 += field1412;
      }

   }

   @ObfuscatedName("co")
   public static void method1852(int var0, int var1, int var2, int var3) {
      if(var0 < 0) {
         var0 = 0;
      }

      if(var1 < 0) {
         var1 = 0;
      }

      if(var2 > field1412) {
         var2 = field1412;
      }

      if(var3 > field1411) {
         var3 = field1411;
      }

      field1414 = var0;
      field1409 = var1;
      field1415 = var2;
      field1413 = var3;
   }

   @ObfuscatedName("di")
   public static void method1853(int var0, int var1, int var2, int var3, int var4) {
      method1864(var0, var1, var2, var4);
      method1864(var0, var1 + var3 - 1, var2, var4);
      method1862(var0, var1, var3, var4);
      method1862(var0 + var2 - 1, var1, var3, var4);
   }

   @ObfuscatedName("dh")
   public static void method1862(int var0, int var1, int var2, int var3) {
      if(var0 >= field1414 && var0 < field1415) {
         if(var1 < field1409) {
            var2 -= field1409 - var1;
            var1 = field1409;
         }

         if(var1 + var2 > field1413) {
            var2 = field1413 - var1;
         }

         int var4 = var0 + var1 * field1412;

         for(int var5 = 0; var5 < var2; ++var5) {
            field1410[var4 + var5 * field1412] = var3;
         }

      }
   }

   @ObfuscatedName("dl")
   public static void method1864(int var0, int var1, int var2, int var3) {
      if(var1 >= field1409 && var1 < field1413) {
         if(var0 < field1414) {
            var2 -= field1414 - var0;
            var0 = field1414;
         }

         if(var0 + var2 > field1415) {
            var2 = field1415 - var0;
         }

         int var4 = var0 + var1 * field1412;

         for(int var5 = 0; var5 < var2; ++var5) {
            field1410[var4 + var5] = var3;
         }

      }
   }

   @ObfuscatedName("de")
   static void method1866(int var0, int var1, int var2, int var3, int var4) {
      if(var0 >= field1414 && var0 < field1415) {
         if(var1 < field1409) {
            var2 -= field1409 - var1;
            var1 = field1409;
         }

         if(var1 + var2 > field1413) {
            var2 = field1413 - var1;
         }

         int var5 = 256 - var4;
         int var6 = (var3 >> 16 & 255) * var4;
         int var7 = (var3 >> 8 & 255) * var4;
         int var8 = (var3 & 255) * var4;
         int var12 = var0 + var1 * field1412;

         for(int var13 = 0; var13 < var2; ++var13) {
            int var9 = (field1410[var12] >> 16 & 255) * var5;
            int var10 = (field1410[var12] >> 8 & 255) * var5;
            int var11 = (field1410[var12] & 255) * var5;
            int var14 = (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8) + (var8 + var11 >> 8);
            field1410[var12] = var14;
            var12 += field1412;
         }

      }
   }

   @ObfuscatedName("cg")
   public static void method1870() {
      int var0 = 0;

      int var1;
      for(var1 = field1412 * field1411 - 7; var0 < var1; field1410[var0++] = 0) {
         field1410[var0++] = 0;
         field1410[var0++] = 0;
         field1410[var0++] = 0;
         field1410[var0++] = 0;
         field1410[var0++] = 0;
         field1410[var0++] = 0;
         field1410[var0++] = 0;
      }

      for(var1 += 7; var0 < var1; field1410[var0++] = 0) {
         ;
      }

   }

   @ObfuscatedName("cf")
   public static void method1873() {
      field1414 = 0;
      field1409 = 0;
      field1415 = field1412;
      field1413 = field1411;
   }

   @ObfuscatedName("cd")
   public static void method1877(int[] var0) {
      field1414 = var0[0];
      field1409 = var0[1];
      field1415 = var0[2];
      field1413 = var0[3];
   }
}
