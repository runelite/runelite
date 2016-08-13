import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
public class class63 {
   @ObfuscatedName("l")
   int field1293 = class73.method1668(16);
   @ObfuscatedName("g")
   int field1294 = class73.method1668(24);
   @ObfuscatedName("k")
   int[] field1295;
   @ObfuscatedName("e")
   int field1296 = class73.method1668(24) + 1;
   @ObfuscatedName("r")
   int field1297 = class73.method1668(24);
   @ObfuscatedName("s")
   int field1298 = class73.method1668(8);
   @ObfuscatedName("h")
   int field1299 = class73.method1668(6) + 1;

   class63() {
      int[] var1 = new int[this.field1299];

      int var2;
      for(var2 = 0; var2 < this.field1299; ++var2) {
         int var3 = 0;
         int var4 = class73.method1668(3);
         boolean var5 = class73.method1646() != 0;
         if(var5) {
            var3 = class73.method1668(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1295 = new int[this.field1299 * 8];

      for(var2 = 0; var2 < this.field1299 * 8; ++var2) {
         this.field1295[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class73.method1668(8):-1;
      }

   }

   @ObfuscatedName("l")
   void method1398(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class73.field1365[this.field1298].field1433;
         int var5 = this.field1297 - this.field1294;
         int var6 = var5 / this.field1296;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class73.field1365[this.field1298].method1695();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1299;
                     }

                     var10 /= this.field1299;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1295[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1294 + var9 * this.field1296;
                     class76 var14 = class73.field1365[var12];
                     int var15;
                     if(this.field1293 == 0) {
                        var15 = this.field1296 / var14.field1433;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method1687();

                           for(int var18 = 0; var18 < var14.field1433; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1296) {
                           float[] var16 = var14.method1687();

                           for(int var17 = 0; var17 < var14.field1433; ++var17) {
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
