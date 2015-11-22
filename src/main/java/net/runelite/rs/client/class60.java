package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bq")
public class class60 {
   @ObfuscatedName("h")
   int[] field1210;
   @ObfuscatedName("j")
   int field1211 = class70.method1556(16);
   @ObfuscatedName("f")
   int field1212 = class70.method1556(24);
   @ObfuscatedName("l")
   int field1213 = class70.method1556(24) + 1;
   @ObfuscatedName("u")
   int field1214 = class70.method1556(6) + 1;
   @ObfuscatedName("a")
   int field1215 = class70.method1556(8);
   @ObfuscatedName("m")
   int field1216 = class70.method1556(24);

   @ObfuscatedName("j")
   void method1310(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class70.field1303[this.field1215].field1344;
         int var5 = this.field1212 - this.field1216;
         int var6 = var5 / this.field1213;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class70.field1303[this.field1215].method1604();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1214;
                     }

                     var10 /= this.field1214;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1210[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1216 + var9 * this.field1213;
                     class73 var14 = class70.field1303[var12];
                     int var15;
                     if(this.field1211 == 0) {
                        var15 = this.field1213 / var14.field1344;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method1602();

                           for(int var18 = 0; var18 < var14.field1344; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1213) {
                           float[] var16 = var14.method1602();

                           for(int var17 = 0; var17 < var14.field1344; ++var17) {
                              var1[var13 + var15] += var16[var17];
                              ++var15;
                           }
                        }
                     }
                  }

                  ++var9;
                  if(var9 >= var6) {
                     break;
                  }
               }
            }
         }

      }
   }

   class60() {
      int[] var1 = new int[this.field1214];

      int var2;
      for(var2 = 0; var2 < this.field1214; ++var2) {
         int var3 = 0;
         int var4 = class70.method1556(3);
         boolean var5 = class70.method1554() != 0;
         if(var5) {
            var3 = class70.method1556(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1210 = new int[this.field1214 * 8];

      for(var2 = 0; var2 < this.field1214 * 8; ++var2) {
         this.field1210[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class70.method1556(8):-1;
      }

   }
}
