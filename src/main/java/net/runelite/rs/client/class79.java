import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cx")
public class class79 extends class203 {
   @ObfuscatedName("s")
   public static int field1422 = 0;
   @ObfuscatedName("u")
   public static int field1423;
   @ObfuscatedName("g")
   public static int field1424;
   @ObfuscatedName("y")
   public static int field1425 = 0;
   @ObfuscatedName("q")
   public static int[] field1426;
   @ObfuscatedName("d")
   protected static int field1427 = 0;
   @ObfuscatedName("z")
   protected static int field1428 = 0;

   @ObfuscatedName("ct")
   public static void method1768(int[] var0, int var1, int var2) {
      field1426 = var0;
      field1423 = var1;
      field1424 = var2;
      method1778(0, 0, var1, var2);
   }

   @ObfuscatedName("cj")
   public static void method1769() {
      field1427 = 0;
      field1425 = 0;
      field1428 = field1423;
      field1422 = field1424;
   }

   @ObfuscatedName("du")
   public static void method1771(int var0, int var1, int var2, int[] var3, int[] var4) {
      int var5 = var0 + var1 * field1423;

      for(var1 = 0; var1 < var3.length; ++var1) {
         int var6 = var5 + var3[var1];

         for(var0 = -var4[var1]; var0 < 0; ++var0) {
            field1426[var6++] = var2;
         }

         var5 += field1423;
      }

   }

   @ObfuscatedName("ca")
   public static void method1772(int[] var0) {
      var0[0] = field1427;
      var0[1] = field1425;
      var0[2] = field1428;
      var0[3] = field1422;
   }

   @ObfuscatedName("dt")
   static void method1773(int var0, int var1, int var2, int var3, int var4) {
      if(var0 >= field1427 && var0 < field1428) {
         if(var1 < field1425) {
            var2 -= field1425 - var1;
            var1 = field1425;
         }

         if(var1 + var2 > field1422) {
            var2 = field1422 - var1;
         }

         int var5 = 256 - var4;
         int var6 = (var3 >> 16 & 255) * var4;
         int var7 = (var3 >> 8 & 255) * var4;
         int var8 = (var3 & 255) * var4;
         int var12 = var0 + var1 * field1423;

         for(int var13 = 0; var13 < var2; ++var13) {
            int var9 = (field1426[var12] >> 16 & 255) * var5;
            int var10 = (field1426[var12] >> 8 & 255) * var5;
            int var11 = (field1426[var12] & 255) * var5;
            int var14 = (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8) + (var8 + var11 >> 8);
            field1426[var12] = var14;
            var12 += field1423;
         }

      }
   }

   @ObfuscatedName("cf")
   public static void method1774() {
      int var0 = 0;

      int var1;
      for(var1 = field1423 * field1424 - 7; var0 < var1; field1426[var0++] = 0) {
         field1426[var0++] = 0;
         field1426[var0++] = 0;
         field1426[var0++] = 0;
         field1426[var0++] = 0;
         field1426[var0++] = 0;
         field1426[var0++] = 0;
         field1426[var0++] = 0;
      }

      for(var1 += 7; var0 < var1; field1426[var0++] = 0) {
         ;
      }

   }

   @ObfuscatedName("ck")
   public static void method1776(int var0, int var1, int var2, int var3, int var4) {
      if(var0 < field1427) {
         var2 -= field1427 - var0;
         var0 = field1427;
      }

      if(var1 < field1425) {
         var3 -= field1425 - var1;
         var1 = field1425;
      }

      if(var0 + var2 > field1428) {
         var2 = field1428 - var0;
      }

      if(var1 + var3 > field1422) {
         var3 = field1422 - var1;
      }

      int var5 = field1423 - var2;
      int var6 = var0 + var1 * field1423;

      for(int var7 = -var3; var7 < 0; ++var7) {
         for(int var8 = -var2; var8 < 0; ++var8) {
            field1426[var6++] = var4;
         }

         var6 += var5;
      }

   }

   @ObfuscatedName("cc")
   public static void method1777(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 0;
      int var7 = 65536 / var3;
      if(var0 < field1427) {
         var2 -= field1427 - var0;
         var0 = field1427;
      }

      if(var1 < field1425) {
         var6 += (field1425 - var1) * var7;
         var3 -= field1425 - var1;
         var1 = field1425;
      }

      if(var0 + var2 > field1428) {
         var2 = field1428 - var0;
      }

      if(var1 + var3 > field1422) {
         var3 = field1422 - var1;
      }

      int var8 = field1423 - var2;
      int var9 = var0 + var1 * field1423;

      for(int var10 = -var3; var10 < 0; ++var10) {
         int var11 = 65536 - var6 >> 8;
         int var12 = var6 >> 8;
         int var13 = ((var4 & 16711935) * var11 + (var5 & 16711935) * var12 & -16711936) + ((var4 & '\uff00') * var11 + (var5 & '\uff00') * var12 & 16711680) >>> 8;

         for(int var14 = -var2; var14 < 0; ++var14) {
            field1426[var9++] = var13;
         }

         var9 += var8;
         var6 += var7;
      }

   }

   @ObfuscatedName("cy")
   public static void method1778(int var0, int var1, int var2, int var3) {
      if(var0 < 0) {
         var0 = 0;
      }

      if(var1 < 0) {
         var1 = 0;
      }

      if(var2 > field1423) {
         var2 = field1423;
      }

      if(var3 > field1424) {
         var3 = field1424;
      }

      field1427 = var0;
      field1425 = var1;
      field1428 = var2;
      field1422 = var3;
   }

   @ObfuscatedName("cw")
   public static void method1779(int var0, int var1, int var2, int var3, int var4, int var5) {
      method1781(var0, var1, var2, var4, var5);
      method1781(var0, var1 + var3 - 1, var2, var4, var5);
      if(var3 >= 3) {
         method1773(var0, var1 + 1, var3 - 2, var4, var5);
         method1773(var0 + var2 - 1, var1 + 1, var3 - 2, var4, var5);
      }

   }

   @ObfuscatedName("dd")
   public static void method1780(int var0, int var1, int var2, int var3) {
      if(var1 >= field1425 && var1 < field1422) {
         if(var0 < field1427) {
            var2 -= field1427 - var0;
            var0 = field1427;
         }

         if(var0 + var2 > field1428) {
            var2 = field1428 - var0;
         }

         int var4 = var0 + var1 * field1423;

         for(int var5 = 0; var5 < var2; ++var5) {
            field1426[var4 + var5] = var3;
         }

      }
   }

   @ObfuscatedName("dn")
   static void method1781(int var0, int var1, int var2, int var3, int var4) {
      if(var1 >= field1425 && var1 < field1422) {
         if(var0 < field1427) {
            var2 -= field1427 - var0;
            var0 = field1427;
         }

         if(var0 + var2 > field1428) {
            var2 = field1428 - var0;
         }

         int var5 = 256 - var4;
         int var6 = (var3 >> 16 & 255) * var4;
         int var7 = (var3 >> 8 & 255) * var4;
         int var8 = (var3 & 255) * var4;
         int var12 = var0 + var1 * field1423;

         for(int var13 = 0; var13 < var2; ++var13) {
            int var9 = (field1426[var12] >> 16 & 255) * var5;
            int var10 = (field1426[var12] >> 8 & 255) * var5;
            int var11 = (field1426[var12] & 255) * var5;
            int var14 = (var6 + var9 >> 8 << 16) + (var7 + var10 >> 8 << 8) + (var8 + var11 >> 8);
            field1426[var12++] = var14;
         }

      }
   }

   @ObfuscatedName("ci")
   public static void method1783(int var0, int var1, int var2, int var3) {
      if(field1427 < var0) {
         field1427 = var0;
      }

      if(field1425 < var1) {
         field1425 = var1;
      }

      if(field1428 > var2) {
         field1428 = var2;
      }

      if(field1422 > var3) {
         field1422 = var3;
      }

   }

   @ObfuscatedName("dr")
   public static void method1784(int var0, int var1, int var2, int var3, int var4) {
      var2 -= var0;
      var3 -= var1;
      if(var3 == 0) {
         if(var2 >= 0) {
            method1780(var0, var1, var2 + 1, var4);
         } else {
            method1780(var0 + var2, var1, -var2 + 1, var4);
         }

      } else if(var2 == 0) {
         if(var3 >= 0) {
            method1790(var0, var1, var3 + 1, var4);
         } else {
            method1790(var0, var1 + var3, -var3 + 1, var4);
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
            if(var0 < field1427) {
               var1 += var5 * (field1427 - var0);
               var0 = field1427;
            }

            if(var2 >= field1428) {
               var2 = field1428 - 1;
            }

            while(var0 <= var2) {
               var6 = var1 >> 16;
               if(var6 >= field1425 && var6 < field1422) {
                  field1426[var0 + var6 * field1423] = var4;
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
            if(var1 < field1425) {
               var0 += var5 * (field1425 - var1);
               var1 = field1425;
            }

            if(var3 >= field1422) {
               var3 = field1422 - 1;
            }

            while(var1 <= var3) {
               var6 = var0 >> 16;
               if(var6 >= field1427 && var6 < field1428) {
                  field1426[var6 + var1 * field1423] = var4;
               }

               var0 += var5;
               ++var1;
            }
         }

      }
   }

   @ObfuscatedName("dv")
   public static void method1790(int var0, int var1, int var2, int var3) {
      if(var0 >= field1427 && var0 < field1428) {
         if(var1 < field1425) {
            var2 -= field1425 - var1;
            var1 = field1425;
         }

         if(var1 + var2 > field1422) {
            var2 = field1422 - var1;
         }

         int var4 = var0 + var1 * field1423;

         for(int var5 = 0; var5 < var2; ++var5) {
            field1426[var4 + var5 * field1423] = var3;
         }

      }
   }

   @ObfuscatedName("cz")
   public static void method1795(int[] var0) {
      field1427 = var0[0];
      field1425 = var0[1];
      field1428 = var0[2];
      field1422 = var0[3];
   }

   @ObfuscatedName("cs")
   public static void method1813(int var0, int var1, int var2, int var3, int var4) {
      method1780(var0, var1, var2, var4);
      method1780(var0, var1 + var3 - 1, var2, var4);
      method1790(var0, var1, var3, var4);
      method1790(var0 + var2 - 1, var1, var3, var4);
   }

   @ObfuscatedName("cb")
   public static void method1818(int var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 < field1427) {
         var2 -= field1427 - var0;
         var0 = field1427;
      }

      if(var1 < field1425) {
         var3 -= field1425 - var1;
         var1 = field1425;
      }

      if(var0 + var2 > field1428) {
         var2 = field1428 - var0;
      }

      if(var1 + var3 > field1422) {
         var3 = field1422 - var1;
      }

      var4 = ((var4 & 16711935) * var5 >> 8 & 16711935) + ((var4 & '\uff00') * var5 >> 8 & '\uff00');
      int var6 = 256 - var5;
      int var7 = field1423 - var2;
      int var8 = var0 + var1 * field1423;

      for(int var9 = 0; var9 < var3; ++var9) {
         for(int var10 = -var2; var10 < 0; ++var10) {
            int var11 = field1426[var8];
            var11 = ((var11 & 16711935) * var6 >> 8 & 16711935) + ((var11 & '\uff00') * var6 >> 8 & '\uff00');
            field1426[var8++] = var4 + var11;
         }

         var8 += var7;
      }

   }
}
