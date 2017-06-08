import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("do")
public class class115 {
   @ObfuscatedName("n")
   int field1680;
   @ObfuscatedName("j")
   int field1681;
   @ObfuscatedName("i")
   int field1682;
   @ObfuscatedName("c")
   int[] field1683;
   @ObfuscatedName("f")
   int field1684;
   @ObfuscatedName("m")
   int field1685;
   @ObfuscatedName("p")
   int field1686;

   class115() {
      this.field1680 = class106.method1936(16);
      this.field1686 = class106.method1936(24);
      this.field1682 = class106.method1936(24);
      this.field1681 = class106.method1936(24) + 1;
      this.field1684 = class106.method1936(6) + 1;
      this.field1685 = class106.method1936(8);
      int[] var1 = new int[this.field1684];

      int var2;
      for(var2 = 0; var2 < this.field1684; ++var2) {
         int var3 = 0;
         int var4 = class106.method1936(3);
         boolean var5 = class106.method1935() != 0;
         if(var5) {
            var3 = class106.method1936(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1683 = new int[this.field1684 * 8];

      for(var2 = 0; var2 < this.field1684 * 8; ++var2) {
         this.field1683[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class106.method1936(8):-1;
      }

   }

   @ObfuscatedName("n")
   void method2104(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class106.field1592[this.field1685].field1570;
         int var5 = this.field1682 - this.field1686;
         int var6 = var5 / this.field1681;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class106.field1592[this.field1685].method1902();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1684;
                     }

                     var10 /= this.field1684;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1683[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1686 + var9 * this.field1681;
                     class104 var14 = class106.field1592[var12];
                     int var15;
                     if(this.field1680 == 0) {
                        var15 = this.field1681 / var14.field1570;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var19 = var14.method1905();

                           for(int var18 = 0; var18 < var14.field1570; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var19[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1681) {
                           float[] var20 = var14.method1905();

                           for(int var17 = 0; var17 < var14.field1570; ++var17) {
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
}
