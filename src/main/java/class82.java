import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ci")
public class class82 extends class207 {
   @ObfuscatedName("y")
   int field1429;
   @ObfuscatedName("e")
   boolean field1430;
   @ObfuscatedName("l")
   int field1431;
   @ObfuscatedName("m")
   int[] field1432;
   @ObfuscatedName("g")
   int[] field1433;
   @ObfuscatedName("n")
   int[] field1434;
   @ObfuscatedName("z")
   static int[] field1435;
   @ObfuscatedName("h")
   int field1436;
   @ObfuscatedName("i")
   int[] field1437;
   @ObfuscatedName("v")
   boolean field1438 = false;
   @ObfuscatedName("j")
   int[] field1439;

   class82(class118 var1) {
      this.field1429 = var1.method2514();
      this.field1430 = var1.method2579() == 1;
      int var2 = var1.method2579();
      if(var2 >= 1 && var2 <= 4) {
         this.field1433 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1433[var3] = var1.method2514();
         }

         if(var2 > 1) {
            this.field1432 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1432[var3] = var1.method2579();
            }
         }

         if(var2 > 1) {
            this.field1439 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1439[var3] = var1.method2579();
            }
         }

         this.field1434 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1434[var3] = var1.method2517();
         }

         this.field1431 = var1.method2579();
         this.field1436 = var1.method2579();
         this.field1437 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   void method1902() {
      this.field1437 = null;
   }

   @ObfuscatedName("f")
   void method1904(int var1) {
      if(this.field1437 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1431 == 1 || this.field1431 == 3) {
            if(field1435 == null || field1435.length < this.field1437.length) {
               field1435 = new int[this.field1437.length];
            }

            if(this.field1437.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1437.length;
            var4 = var2 * var1 * this.field1436;
            var5 = var3 - 1;
            if(this.field1431 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1435[var6] = this.field1437[var7];
            }

            var10 = this.field1437;
            this.field1437 = field1435;
            field1435 = var10;
         }

         if(this.field1431 == 2 || this.field1431 == 4) {
            if(field1435 == null || field1435.length < this.field1437.length) {
               field1435 = new int[this.field1437.length];
            }

            if(this.field1437.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1437.length;
            var4 = var1 * this.field1436;
            var5 = var2 - 1;
            if(this.field1431 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1435[var8] = this.field1437[var9];
               }
            }

            var10 = this.field1437;
            this.field1437 = field1435;
            field1435 = var10;
         }

      }
   }

   @ObfuscatedName("a")
   boolean method1905(double var1, int var3, class166 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1433.length; ++var5) {
         if(var4.method3270(this.field1433[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1437 = new int[var5];

      for(int var6 = 0; var6 < this.field1433.length; ++var6) {
         int var8 = this.field1433[var6];
         class80 var7;
         if(!class0.method3(var4, var8)) {
            var7 = null;
         } else {
            var7 = class92.method2178();
         }

         var7.method1891();
         byte[] var10 = var7.field1423;
         int[] var11 = var7.field1420;
         int var12 = this.field1434[var6];
         if((var12 & -16777216) == 16777216) {
            ;
         }

         if((var12 & -16777216) == 33554432) {
            ;
         }

         int var13;
         int var14;
         int var15;
         int var16;
         if((var12 & -16777216) == 50331648) {
            var13 = var12 & 16711935;
            var14 = var12 >> 8 & 255;

            for(var15 = 0; var15 < var11.length; ++var15) {
               var16 = var11[var15];
               if((var16 & '\uffff') == var16 >> 8) {
                  var16 &= 255;
                  var11[var15] = var13 * var16 >> 8 & 16711935 | var14 * var16 & '\uff00';
               }
            }
         }

         for(var13 = 0; var13 < var11.length; ++var13) {
            var11[var13] = class90.method2109(var11[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1432[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var7.field1418 == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1437[var14] = var11[var10[var14] & 255];
               }
            } else if(var7.field1418 == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1437[var14++] = var11[var10[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.field1418 != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1437[var14++] = var11[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
                  }
               }
            }
         }

         if(var13 == 1) {
            ;
         }

         if(var13 == 2) {
            ;
         }

         if(var13 == 3) {
            ;
         }
      }

      return true;
   }
}
