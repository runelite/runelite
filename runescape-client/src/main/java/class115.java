import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("df")
public class class115 {
   @ObfuscatedName("r")
   int field1685;
   @ObfuscatedName("i")
   int field1686;
   @ObfuscatedName("a")
   int field1687;
   @ObfuscatedName("t")
   int field1688;
   @ObfuscatedName("s")
   int field1689;
   @ObfuscatedName("w")
   int field1690;
   @ObfuscatedName("v")
   int[] field1691;

   class115() {
      this.field1686 = class106.method1973(16);
      this.field1690 = class106.method1973(24);
      this.field1687 = class106.method1973(24);
      this.field1688 = class106.method1973(24) + 1;
      this.field1689 = class106.method1973(6) + 1;
      this.field1685 = class106.method1973(8);
      int[] var1 = new int[this.field1689];

      int var2;
      for(var2 = 0; var2 < this.field1689; ++var2) {
         int var3 = 0;
         int var4 = class106.method1973(3);
         boolean var5 = class106.method1958() != 0;
         if(var5) {
            var3 = class106.method1973(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1691 = new int[this.field1689 * 8];

      for(var2 = 0; var2 < this.field1689 * 8; ++var2) {
         this.field1691[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class106.method1973(8):-1;
      }

   }

   @ObfuscatedName("i")
   void method2108(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class106.field1613[this.field1685].field1585;
         int var5 = this.field1687 - this.field1690;
         int var6 = var5 / this.field1688;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class106.field1613[this.field1685].method1937();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var11 + var9 < var6) {
                        var7[var11 + var9] = var10 % this.field1689;
                     }

                     var10 /= this.field1689;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1691[var8 + var11 * 8];
                  if(var12 >= 0) {
                     int var13 = this.field1690 + this.field1688 * var9;
                     class104 var14 = class106.field1613[var12];
                     int var15;
                     if(this.field1686 == 0) {
                        var15 = this.field1688 / var14.field1585;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var17 = var14.method1933();

                           for(int var18 = 0; var18 < var14.field1585; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var17[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1688) {
                           float[] var19 = var14.method1933();

                           for(int var20 = 0; var20 < var14.field1585; ++var20) {
                              var1[var13 + var15] += var19[var20];
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
