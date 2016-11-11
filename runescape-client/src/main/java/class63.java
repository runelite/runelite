import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bj")
public class class63 {
   @ObfuscatedName("g")
   int field1276 = class73.method1567(24) + 1;
   @ObfuscatedName("h")
   int field1277 = class73.method1567(24);
   @ObfuscatedName("i")
   int field1278 = class73.method1567(16);
   @ObfuscatedName("e")
   int field1279 = class73.method1567(24);
   @ObfuscatedName("n")
   int field1280 = class73.method1567(6) + 1;
   @ObfuscatedName("u")
   int field1281 = class73.method1567(8);
   @ObfuscatedName("d")
   int[] field1282;

   class63() {
      int[] var1 = new int[this.field1280];

      int var2;
      for(var2 = 0; var2 < this.field1280; ++var2) {
         int var3 = 0;
         int var4 = class73.method1567(3);
         boolean var5 = class73.method1566() != 0;
         if(var5) {
            var3 = class73.method1567(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1282 = new int[this.field1280 * 8];

      for(var2 = 0; var2 < this.field1280 * 8; ++var2) {
         this.field1282[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class73.method1567(8):-1;
      }

   }

   @ObfuscatedName("i")
   void method1315(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class73.field1352[this.field1281].field1414;
         int var5 = this.field1279 - this.field1277;
         int var6 = var5 / this.field1276;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class73.field1352[this.field1281].method1616();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1280;
                     }

                     var10 /= this.field1280;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1282[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1277 + var9 * this.field1276;
                     class76 var14 = class73.field1352[var12];
                     int var15;
                     if(this.field1278 == 0) {
                        var15 = this.field1276 / var14.field1414;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method1617();

                           for(int var18 = 0; var18 < var14.field1414; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1276) {
                           float[] var16 = var14.method1617();

                           for(int var17 = 0; var17 < var14.field1414; ++var17) {
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
}
