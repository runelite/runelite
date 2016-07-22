import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ba")
public class class63 {
   @ObfuscatedName("j")
   int[] field1296;
   @ObfuscatedName("w")
   int field1297 = class73.method1618(24);
   @ObfuscatedName("e")
   int field1298 = class73.method1618(24);
   @ObfuscatedName("o")
   int field1299 = class73.method1618(24) + 1;
   @ObfuscatedName("g")
   int field1300 = class73.method1618(6) + 1;
   @ObfuscatedName("l")
   int field1301 = class73.method1618(8);
   @ObfuscatedName("m")
   int field1302 = class73.method1618(16);

   @ObfuscatedName("m")
   void method1353(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class73.field1372[this.field1301].field1435;
         int var5 = this.field1298 - this.field1297;
         int var6 = var5 / this.field1299;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class73.field1372[this.field1301].method1674();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1300;
                     }

                     var10 /= this.field1300;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1296[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1297 + var9 * this.field1299;
                     class76 var14 = class73.field1372[var12];
                     int var15;
                     if(this.field1302 == 0) {
                        var15 = this.field1299 / var14.field1435;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var17 = var14.method1668();

                           for(int var18 = 0; var18 < var14.field1435; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var17[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1299) {
                           float[] var20 = var14.method1668();

                           for(int var19 = 0; var19 < var14.field1435; ++var19) {
                              var1[var13 + var15] += var20[var19];
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

   class63() {
      int[] var1 = new int[this.field1300];

      int var2;
      for(var2 = 0; var2 < this.field1300; ++var2) {
         int var3 = 0;
         int var4 = class73.method1618(3);
         boolean var5 = class73.method1616() != 0;
         if(var5) {
            var3 = class73.method1618(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1296 = new int[this.field1300 * 8];

      for(var2 = 0; var2 < this.field1300 * 8; ++var2) {
         this.field1296[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class73.method1618(8):-1;
      }

   }
}
