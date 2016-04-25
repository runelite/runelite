import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cf")
public class class83 extends class208 {
   @ObfuscatedName("i")
   int[] field1426;
   @ObfuscatedName("d")
   boolean field1427 = false;
   @ObfuscatedName("x")
   int field1428;
   @ObfuscatedName("e")
   boolean field1429;
   @ObfuscatedName("c")
   int[] field1431;
   @ObfuscatedName("n")
   int[] field1432;
   @ObfuscatedName("u")
   int field1433;
   @ObfuscatedName("l")
   int[] field1434;
   @ObfuscatedName("r")
   int field1435;
   @ObfuscatedName("a")
   int[] field1436;
   @ObfuscatedName("p")
   static int[] field1438;

   @ObfuscatedName("j")
   boolean method1882(double var1, int var3, class167 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1426.length; ++var5) {
         if(var4.method3224(this.field1426[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1436 = new int[var5];

      for(int var6 = 0; var6 < this.field1426.length; ++var6) {
         class80 var7 = class51.method1068(var4, this.field1426[var6]);
         var7.method1857();
         byte[] var8 = var7.field1402;
         int[] var9 = var7.field1405;
         int var10 = this.field1434[var6];
         if((var10 & -16777216) == 16777216) {
            ;
         }

         if((var10 & -16777216) == 33554432) {
            ;
         }

         int var11;
         int var12;
         int var13;
         int var14;
         if((var10 & -16777216) == 50331648) {
            var11 = var10 & 16711935;
            var12 = var10 >> 8 & 255;

            for(var13 = 0; var13 < var9.length; ++var13) {
               var14 = var9[var13];
               if((var14 & '\uffff') == var14 >> 8) {
                  var14 &= 255;
                  var9[var13] = var11 * var14 >> 8 & 16711935 | var12 * var14 & '\uff00';
               }
            }
         }

         for(var11 = 0; var11 < var9.length; ++var11) {
            var9[var11] = class91.method2094(var9[var11], var1);
         }

         if(var6 == 0) {
            var11 = 0;
         } else {
            var11 = this.field1431[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var11 == 0) {
            if(var7.field1403 == var3) {
               for(var12 = 0; var12 < var5; ++var12) {
                  this.field1436[var12] = var9[var8[var12] & 255];
               }
            } else if(var7.field1403 == 64 && var3 == 128) {
               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1436[var12++] = var9[var8[(var14 >> 1) + (var13 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.field1403 != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1436[var12++] = var9[var8[(var14 << 1) + (var13 << 1 << 7)] & 255];
                  }
               }
            }
         }

         if(var11 == 1) {
            ;
         }

         if(var11 == 2) {
            ;
         }

         if(var11 == 3) {
            ;
         }
      }

      return true;
   }

   @ObfuscatedName("h")
   void method1884() {
      this.field1436 = null;
   }

   @ObfuscatedName("m")
   void method1885(int var1) {
      if(this.field1436 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1433 == 1 || this.field1433 == 3) {
            if(field1438 == null || field1438.length < this.field1436.length) {
               field1438 = new int[this.field1436.length];
            }

            if(this.field1436.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1436.length;
            var4 = var2 * var1 * this.field1435;
            var5 = var3 - 1;
            if(this.field1433 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1438[var6] = this.field1436[var7];
            }

            var10 = this.field1436;
            this.field1436 = field1438;
            field1438 = var10;
         }

         if(this.field1433 == 2 || this.field1433 == 4) {
            if(field1438 == null || field1438.length < this.field1436.length) {
               field1438 = new int[this.field1436.length];
            }

            if(this.field1436.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1436.length;
            var4 = var1 * this.field1435;
            var5 = var2 - 1;
            if(this.field1433 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1438[var8] = this.field1436[var9];
               }
            }

            var10 = this.field1436;
            this.field1436 = field1438;
            field1438 = var10;
         }

      }
   }

   class83(class119 var1) {
      this.field1428 = var1.method2502();
      this.field1429 = var1.method2500() == 1;
      int var2 = var1.method2500();
      if(var2 >= 1 && var2 <= 4) {
         this.field1426 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1426[var3] = var1.method2502();
         }

         if(var2 > 1) {
            this.field1431 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1431[var3] = var1.method2500();
            }
         }

         if(var2 > 1) {
            this.field1432 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1432[var3] = var1.method2500();
            }
         }

         this.field1434 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1434[var3] = var1.method2505();
         }

         this.field1433 = var1.method2500();
         this.field1435 = var1.method2500();
         this.field1436 = null;
      } else {
         throw new RuntimeException();
      }
   }
}
