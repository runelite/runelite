import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ci")
public class class83 extends class208 {
   @ObfuscatedName("f")
   int[] field1443;
   @ObfuscatedName("z")
   int field1447;
   @ObfuscatedName("r")
   boolean field1448;
   @ObfuscatedName("y")
   int field1449;
   @ObfuscatedName("d")
   int[] field1450;
   @ObfuscatedName("s")
   int[] field1451;
   @ObfuscatedName("l")
   int[] field1452;
   @ObfuscatedName("p")
   int field1453;
   @ObfuscatedName("b")
   static int[] field1454;
   @ObfuscatedName("k")
   int[] field1455;
   @ObfuscatedName("o")
   boolean field1456 = false;

   @ObfuscatedName("t")
   boolean method1847(double var1, int var3, class167 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1443.length; ++var5) {
         if(var4.method3291(this.field1443[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1455 = new int[var5];

      for(int var6 = 0; var6 < this.field1443.length; ++var6) {
         class80 var7 = class104.method2250(var4, this.field1443[var6]);
         var7.method1820();
         byte[] var8 = var7.field1428;
         int[] var9 = var7.field1423;
         int var10 = this.field1452[var6];
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
            var9[var11] = class91.method2057(var9[var11], var1);
         }

         if(var6 == 0) {
            var11 = 0;
         } else {
            var11 = this.field1451[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var11 == 0) {
            if(var7.field1424 == var3) {
               for(var12 = 0; var12 < var5; ++var12) {
                  this.field1455[var12] = var9[var8[var12] & 255];
               }
            } else if(var7.field1424 == 64 && var3 == 128) {
               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1455[var12++] = var9[var8[(var14 >> 1) + (var13 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.field1424 != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1455[var12++] = var9[var8[(var14 << 1) + (var13 << 1 << 7)] & 255];
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

   @ObfuscatedName("i")
   void method1848() {
      this.field1455 = null;
   }

   @ObfuscatedName("g")
   void method1849(int var1) {
      if(this.field1455 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int[] var6;
         int var7;
         int var10;
         if(this.field1449 == 1 || this.field1449 == 3) {
            if(field1454 == null || field1454.length < this.field1455.length) {
               field1454 = new int[this.field1455.length];
            }

            if(this.field1455.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1455.length;
            var4 = var2 * var1 * this.field1453;
            var5 = var3 - 1;
            if(this.field1449 == 1) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; ++var10) {
               var7 = var10 + var4 & var5;
               field1454[var10] = this.field1455[var7];
            }

            var6 = this.field1455;
            this.field1455 = field1454;
            field1454 = var6;
         }

         if(this.field1449 == 2 || this.field1449 == 4) {
            if(field1454 == null || field1454.length < this.field1455.length) {
               field1454 = new int[this.field1455.length];
            }

            if(this.field1455.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1455.length;
            var4 = var1 * this.field1453;
            var5 = var2 - 1;
            if(this.field1449 == 2) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; var10 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var10 + var7;
                  int var9 = var10 + (var7 + var4 & var5);
                  field1454[var8] = this.field1455[var9];
               }
            }

            var6 = this.field1455;
            this.field1455 = field1454;
            field1454 = var6;
         }

      }
   }

   class83(class119 var1) {
      this.field1447 = var1.method2470();
      this.field1448 = var1.method2494() == 1;
      int var2 = var1.method2494();
      if(var2 >= 1 && var2 <= 4) {
         this.field1443 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1443[var3] = var1.method2470();
         }

         if(var2 > 1) {
            this.field1451 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1451[var3] = var1.method2494();
            }
         }

         if(var2 > 1) {
            this.field1450 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1450[var3] = var1.method2494();
            }
         }

         this.field1452 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1452[var3] = var1.method2505();
         }

         this.field1449 = var1.method2494();
         this.field1453 = var1.method2494();
         this.field1455 = null;
      } else {
         throw new RuntimeException();
      }
   }
}
