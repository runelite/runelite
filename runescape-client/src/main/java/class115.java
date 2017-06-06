import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dg")
public class class115 {
   @ObfuscatedName("h")
   int[] field1690;
   @ObfuscatedName("c")
   int field1691;
   @ObfuscatedName("v")
   int field1692;
   @ObfuscatedName("i")
   int field1693;
   @ObfuscatedName("b")
   int field1694;
   @ObfuscatedName("e")
   int field1695;
   @ObfuscatedName("y")
   int field1696;

   class115() {
      this.field1693 = class106.method1950(16);
      this.field1691 = class106.method1950(24);
      this.field1695 = class106.method1950(24);
      this.field1692 = class106.method1950(24) + 1;
      this.field1694 = class106.method1950(6) + 1;
      this.field1696 = class106.method1950(8);
      int[] var1 = new int[this.field1694];

      int var2;
      for(var2 = 0; var2 < this.field1694; ++var2) {
         int var3 = 0;
         int var4 = class106.method1950(3);
         boolean var5 = class106.method1949() != 0;
         if(var5) {
            var3 = class106.method1950(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1690 = new int[this.field1694 * 8];

      for(var2 = 0; var2 < this.field1694 * 8; ++var2) {
         this.field1690[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class106.method1950(8):-1;
      }

   }

   @ObfuscatedName("i")
   void method2089(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class106.field1597[this.field1696].field1580;
         int var5 = this.field1695 - this.field1691;
         int var6 = var5 / this.field1692;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class106.field1597[this.field1696].method1920();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1694;
                     }

                     var10 /= this.field1694;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1690[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1691 + var9 * this.field1692;
                     class104 var14 = class106.field1597[var12];
                     int var15;
                     if(this.field1693 == 0) {
                        var15 = this.field1692 / var14.field1580;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method1926();

                           for(int var18 = 0; var18 < var14.field1580; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1692) {
                           float[] var16 = var14.method1926();

                           for(int var17 = 0; var17 < var14.field1580; ++var17) {
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
