import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dz")
public class class115 {
   @ObfuscatedName("u")
   int field1663;
   @ObfuscatedName("h")
   int field1664;
   @ObfuscatedName("t")
   int[] field1665;
   @ObfuscatedName("q")
   int field1666;
   @ObfuscatedName("g")
   int field1667;
   @ObfuscatedName("v")
   int field1668;
   @ObfuscatedName("i")
   int field1669;

   @ObfuscatedName("i")
   void method2140(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class106.field1578[this.field1668].field1561;
         int var5 = this.field1663 - this.field1664;
         int var6 = var5 / this.field1666;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class106.field1578[this.field1668].method1950();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1667;
                     }

                     var10 /= this.field1667;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1665[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1664 + var9 * this.field1666;
                     class104 var14 = class106.field1578[var12];
                     int var15;
                     if(this.field1669 == 0) {
                        var15 = this.field1666 / var14.field1561;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var19 = var14.method1951();

                           for(int var18 = 0; var18 < var14.field1561; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var19[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1666) {
                           float[] var20 = var14.method1951();

                           for(int var17 = 0; var17 < var14.field1561; ++var17) {
                              var1[var13 + var15] += var20[var17];
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

   class115() {
      this.field1669 = class106.method1978(16);
      this.field1664 = class106.method1978(24);
      this.field1663 = class106.method1978(24);
      this.field1666 = class106.method1978(24) + 1;
      this.field1667 = class106.method1978(6) + 1;
      this.field1668 = class106.method1978(8);
      int[] var1 = new int[this.field1667];

      int var2;
      for(var2 = 0; var2 < this.field1667; ++var2) {
         int var3 = 0;
         int var4 = class106.method1978(3);
         boolean var5 = class106.method1977() != 0;
         if(var5) {
            var3 = class106.method1978(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1665 = new int[this.field1667 * 8];

      for(var2 = 0; var2 < this.field1667 * 8; ++var2) {
         this.field1665[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class106.method1978(8):-1;
      }

   }
}
