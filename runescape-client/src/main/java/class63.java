import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bh")
public class class63 {
   @ObfuscatedName("n")
   int field1269 = class73.method1584(24);
   @ObfuscatedName("e")
   int field1270 = class73.method1584(24);
   @ObfuscatedName("v")
   int field1271 = class73.method1584(6) + 1;
   @ObfuscatedName("t")
   int field1272 = class73.method1584(24) + 1;
   @ObfuscatedName("f")
   int field1273 = class73.method1584(16);
   @ObfuscatedName("b")
   int field1274 = class73.method1584(8);
   @ObfuscatedName("m")
   int[] field1275;

   class63() {
      int[] var1 = new int[this.field1271];

      int var2;
      for(var2 = 0; var2 < this.field1271; ++var2) {
         int var3 = 0;
         int var4 = class73.method1584(3);
         boolean var5 = class73.method1581() != 0;
         if(var5) {
            var3 = class73.method1584(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1275 = new int[this.field1271 * 8];

      for(var2 = 0; var2 < this.field1271 * 8; ++var2) {
         this.field1275[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class73.method1584(8):-1;
      }

   }

   @ObfuscatedName("f")
   void method1320(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class73.field1366[this.field1274].field1406;
         int var5 = this.field1269 - this.field1270;
         int var6 = var5 / this.field1272;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class73.field1366[this.field1274].method1631();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1271;
                     }

                     var10 /= this.field1271;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1275[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1270 + var9 * this.field1272;
                     class76 var14 = class73.field1366[var12];
                     int var15;
                     if(this.field1273 == 0) {
                        var15 = this.field1272 / var14.field1406;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var20 = var14.method1632();

                           for(int var18 = 0; var18 < var14.field1406; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1272) {
                           float[] var19 = var14.method1632();

                           for(int var17 = 0; var17 < var14.field1406; ++var17) {
                              var1[var13 + var15] += var19[var17];
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
}
