package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cb")
public class class79 extends class203 {
   @ObfuscatedName("y")
   protected static int field1400 = 0;
   @ObfuscatedName("z")
   public static int field1401;
   @ObfuscatedName("g")
   public static int field1402 = 0;
   @ObfuscatedName("r")
   public static int field1403 = 0;
   @ObfuscatedName("p")
   public static int field1404;
   @ObfuscatedName("n")
   protected static int field1405 = 0;
   @ObfuscatedName("e")
   public static int[] field1406;

   @ObfuscatedName("cc")
   public static void method1814(int[] var0, int var1, int var2) {
      field1406 = var0;
      field1401 = var1;
      field1404 = var2;
      method1816(0, 0, var1, var2);
   }

   @ObfuscatedName("db")
   public static void method1815(int var0, int var1, int var2, int var3, int var4) {
      method1831(var0, var1, var2, var4);
      method1831(var0, var1 + var3 - 1, var2, var4);
      method1855(var0, var1, var3, var4);
      method1855(var0 + var2 - 1, var1, var3, var4);
   }

   @ObfuscatedName("cn")
   public static void method1816(int var0, int var1, int var2, int var3) {
      if(var0 < 0) {
         var0 = 0;
      }

      if(var1 < 0) {
         var1 = 0;
      }

      if(var2 > field1401) {
         var2 = field1401;
      }

      if(var3 > field1404) {
         var3 = field1404;
      }

      field1405 = var0;
      field1403 = var1;
      field1400 = var2;
      field1402 = var3;
   }

   @ObfuscatedName("cy")
   public static void method1817(int var0, int var1, int var2, int var3) {
      if(field1405 < var0) {
         field1405 = var0;
      }

      if(field1403 < var1) {
         field1403 = var1;
      }

      if(field1400 > var2) {
         field1400 = var2;
      }

      if(field1402 > var3) {
         field1402 = var3;
      }

   }

   @ObfuscatedName("dv")
   public static void method1818(int var0, int var1, int var2, int[] var3, int[] var4) {
      int var5 = var0 + var1 * field1401;

      for(var1 = 0; var1 < var3.length; ++var1) {
         int var6 = var5 + var3[var1];

         for(var0 = -var4[var1]; var0 < 0; ++var0) {
            field1406[var6++] = var2;
         }

         var5 += field1401;
      }

   }

   @ObfuscatedName("da")
   public static void method1820(int var0, int var1, int var2, int var3, int var4) {
      if(var0 < field1405) {
         var2 -= field1405 - var0;
         var0 = field1405;
      }

      if(var1 < field1403) {
         var3 -= field1403 - var1;
         var1 = field1403;
      }

      if(var0 + var2 > field1400) {
         var2 = field1400 - var0;
      }

      if(var1 + var3 > field1402) {
         var3 = field1402 - var1;
      }

      int var5 = field1401 - var2;
      int var6 = var0 + var1 * field1401;

      for(int var7 = -var3; var7 < 0; ++var7) {
         for(int var8 = -var2; var8 < 0; ++var8) {
            field1406[var6++] = var4;
         }

         var6 += var5;
      }

   }

   @ObfuscatedName("ci")
   public static void method1821(int var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 < field1405) {
         var2 -= field1405 - var0;
         var0 = field1405;
      }

      if(var1 < field1403) {
         var3 -= field1403 - var1;
         var1 = field1403;
      }

      if(var0 + var2 > field1400) {
         var2 = field1400 - var0;
      }

      if(var1 + var3 > field1402) {
         var3 = field1402 - var1;
      }

      var4 = ((var4 & 16711935) * var5 >> 8 & 16711935) + ((var4 & '\uff00') * var5 >> 8 & '\uff00');
      int var6 = 256 - var5;
      int var7 = field1401 - var2;
      int var8 = var0 + var1 * field1401;

      for(int var9 = 0; var9 < var3; ++var9) {
         for(int var10 = -var2; var10 < 0; ++var10) {
            int var11 = field1406[var8];
            var11 = ((var11 & 16711935) * var6 >> 8 & 16711935) + ((var11 & '\uff00') * var6 >> 8 & '\uff00');
            field1406[var8++] = var4 + var11;
         }

         var8 += var7;
      }

   }

   @ObfuscatedName("dt")
   public static void method1823(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 0;
      int var7 = 65536 / var3;
      if(var0 < field1405) {
         var2 -= field1405 - var0;
         var0 = field1405;
      }

      if(var1 < field1403) {
         var6 += (field1403 - var1) * var7;
         var3 -= field1403 - var1;
         var1 = field1403;
      }

      if(var0 + var2 > field1400) {
         var2 = field1400 - var0;
      }

      if(var1 + var3 > field1402) {
         var3 = field1402 - var1;
      }

      int var8 = field1401 - var2;
      int var9 = var0 + var1 * field1401;

      for(int var10 = -var3; var10 < 0; ++var10) {
         int var11 = 65536 - var6 >> 8;
         int var12 = var6 >> 8;
         int var13 = ((var4 & 16711935) * var11 + (var5 & 16711935) * var12 & -16711936) + ((var4 & '\uff00') * var11 + (var5 & '\uff00') * var12 & 16711680) >>> 8;

         for(int var14 = -var2; var14 < 0; ++var14) {
            field1406[var9++] = var13;
         }

         var9 += var8;
         var6 += var7;
      }

   }

   @ObfuscatedName("dh")
   public static void method1825(int var0, int var1, int var2, int var3, int var4, int var5) {
      method1827(var0, var1, var2, var4, var5);
      method1827(var0, var1 + var3 - 1, var2, var4, var5);
      if(var3 >= 3) {
         method1829(var0, var1 + 1, var3 - 2, var4, var5);
         method1829(var0 + var2 - 1, var1 + 1, var3 - 2, var4, var5);
      }

   }

   @ObfuscatedName("dz")
   static void method1827(int var0, int var1, int var2, int var3, int var4) {
      if(var1 >= field1403 && var1 < field1402) {
         if(var0 < field1405) {
            var2 -= field1405 - var0;
            var0 = field1405;
         }

         if(var0 + var2 > field1400) {
            var2 = field1400 - var0;
         }

         int var5 = 256 - var4;
         int var6 = (var3 >> 16 & 255) * var4;
         int var7 = (var3 >> 8 & 255) * var4;
         int var8 = (var3 & 255) * var4;
         int var12 = var0 + var1 * field1401;

         for(int var13 = 0; var13 < var2; ++var13) {
            int var9 = (field1406[var12] >> 16 & 255) * var5;
            int var10 = (field1406[var12] >> 8 & 255) * var5;
            int var11 = (field1406[var12] & 255) * var5;
            int var14 = (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8) + (var8 + var11 >> 8);
            field1406[var12++] = var14;
         }

      }
   }

   @ObfuscatedName("cs")
   public static void method1828(int[] var0) {
      field1405 = var0[0];
      field1403 = var0[1];
      field1400 = var0[2];
      field1402 = var0[3];
   }

   @ObfuscatedName("dn")
   static void method1829(int var0, int var1, int var2, int var3, int var4) {
      if(var0 >= field1405 && var0 < field1400) {
         if(var1 < field1403) {
            var2 -= field1403 - var1;
            var1 = field1403;
         }

         if(var1 + var2 > field1402) {
            var2 = field1402 - var1;
         }

         int var5 = 256 - var4;
         int var6 = (var3 >> 16 & 255) * var4;
         int var7 = (var3 >> 8 & 255) * var4;
         int var8 = (var3 & 255) * var4;
         int var12 = var0 + var1 * field1401;

         for(int var13 = 0; var13 < var2; ++var13) {
            int var9 = (field1406[var12] >> 16 & 255) * var5;
            int var10 = (field1406[var12] >> 8 & 255) * var5;
            int var11 = (field1406[var12] & 255) * var5;
            int var14 = (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8) + (var8 + var11 >> 8);
            field1406[var12] = var14;
            var12 += field1401;
         }

      }
   }

   @ObfuscatedName("dl")
   public static void method1830(int var0, int var1, int var2, int var3, int var4) {
      var2 -= var0;
      var3 -= var1;
      if(var3 == 0) {
         if(var2 >= 0) {
            method1831(var0, var1, var2 + 1, var4);
         } else {
            method1831(var0 + var2, var1, -var2 + 1, var4);
         }

      } else if(var2 == 0) {
         if(var3 >= 0) {
            method1855(var0, var1, var3 + 1, var4);
         } else {
            method1855(var0, var1 + var3, -var3 + 1, var4);
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
            if(var0 < field1405) {
               var1 += var5 * (field1405 - var0);
               var0 = field1405;
            }

            if(var2 >= field1400) {
               var2 = field1400 - 1;
            }

            while(var0 <= var2) {
               var6 = var1 >> 16;
               if(var6 >= field1403 && var6 < field1402) {
                  field1406[var0 + var6 * field1401] = var4;
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
            if(var1 < field1403) {
               var0 += var5 * (field1403 - var1);
               var1 = field1403;
            }

            if(var3 >= field1402) {
               var3 = field1402 - 1;
            }

            while(var1 <= var3) {
               var6 = var0 >> 16;
               if(var6 >= field1405 && var6 < field1400) {
                  field1406[var6 + var1 * field1401] = var4;
               }

               var0 += var5;
               ++var1;
            }
         }

      }
   }

   @ObfuscatedName("do")
   public static void method1831(int var0, int var1, int var2, int var3) {
      if(var1 >= field1403 && var1 < field1402) {
         if(var0 < field1405) {
            var2 -= field1405 - var0;
            var0 = field1405;
         }

         if(var0 + var2 > field1400) {
            var2 = field1400 - var0;
         }

         int var4 = var0 + var1 * field1401;

         for(int var5 = 0; var5 < var2; ++var5) {
            field1406[var4 + var5] = var3;
         }

      }
   }

   @ObfuscatedName("cv")
   public static void method1848() {
      int var0 = 0;

      int var1;
      for(var1 = field1401 * field1404 - 7; var0 < var1; field1406[var0++] = 0) {
         field1406[var0++] = 0;
         field1406[var0++] = 0;
         field1406[var0++] = 0;
         field1406[var0++] = 0;
         field1406[var0++] = 0;
         field1406[var0++] = 0;
         field1406[var0++] = 0;
      }

      for(var1 += 7; var0 < var1; field1406[var0++] = 0) {
         ;
      }

   }

   @ObfuscatedName("dr")
   public static void method1855(int var0, int var1, int var2, int var3) {
      if(var0 >= field1405 && var0 < field1400) {
         if(var1 < field1403) {
            var2 -= field1403 - var1;
            var1 = field1403;
         }

         if(var1 + var2 > field1402) {
            var2 = field1402 - var1;
         }

         int var4 = var0 + var1 * field1401;

         for(int var5 = 0; var5 < var2; ++var5) {
            field1406[var4 + var5 * field1401] = var3;
         }

      }
   }

   @ObfuscatedName("cu")
   public static void method1858(int[] var0) {
      var0[0] = field1405;
      var0[1] = field1403;
      var0[2] = field1400;
      var0[3] = field1402;
   }

   @ObfuscatedName("ck")
   public static void method1875() {
      field1405 = 0;
      field1403 = 0;
      field1400 = field1401;
      field1402 = field1404;
   }
}
