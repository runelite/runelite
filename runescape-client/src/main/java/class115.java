import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dq")
public class class115 {
   @ObfuscatedName("j")
   int[] field1673;
   @ObfuscatedName("z")
   int field1674;
   @ObfuscatedName("e")
   int field1675;
   @ObfuscatedName("t")
   int field1676;
   @ObfuscatedName("w")
   int field1677;
   @ObfuscatedName("m")
   int field1678;
   @ObfuscatedName("p")
   int field1679;

   class115() {
      this.field1679 = class106.method1874(16);
      this.field1678 = class106.method1874(24);
      this.field1675 = class106.method1874(24);
      this.field1676 = class106.method1874(24) + 1;
      this.field1677 = class106.method1874(6) + 1;
      this.field1674 = class106.method1874(8);
      int[] var1 = new int[this.field1677];

      int var2;
      for(var2 = 0; var2 < this.field1677; ++var2) {
         int var3 = 0;
         int var4 = class106.method1874(3);
         boolean var5 = class106.method1850() != 0;
         if(var5) {
            var3 = class106.method1874(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field1673 = new int[this.field1677 * 8];

      for(var2 = 0; var2 < this.field1677 * 8; ++var2) {
         this.field1673[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0?class106.method1874(8):-1;
      }

   }

   @ObfuscatedName("p")
   void method2016(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if(!var3) {
         var4 = class106.field1581[this.field1674].field1562;
         int var5 = this.field1675 - this.field1678;
         int var6 = var5 / this.field1676;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if(var8 == 0) {
                  var10 = class106.field1581[this.field1674].method1824();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if(var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field1677;
                     }

                     var10 /= this.field1677;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field1673[var11 * 8 + var8];
                  if(var12 >= 0) {
                     int var13 = this.field1678 + var9 * this.field1676;
                     class104 var14 = class106.field1581[var12];
                     int var15;
                     if(this.field1679 == 0) {
                        var15 = this.field1676 / var14.field1562;

                        for(int var16 = 0; var16 < var15; ++var16) {
                           float[] var17 = var14.method1835();

                           for(int var18 = 0; var18 < var14.field1562; ++var18) {
                              var1[var13 + var16 + var18 * var15] += var17[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field1676) {
                           float[] var19 = var14.method1835();

                           for(int var20 = 0; var20 < var14.field1562; ++var20) {
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
