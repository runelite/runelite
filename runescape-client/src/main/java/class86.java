import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ch")
public class class86 extends class211 {
   @ObfuscatedName("y")
   boolean field1515 = false;
   @ObfuscatedName("g")
   int field1516;
   @ObfuscatedName("l")
   boolean field1517;
   @ObfuscatedName("j")
   int[] field1518;
   @ObfuscatedName("r")
   int[] field1519;
   @ObfuscatedName("x")
   int[] field1520;
   @ObfuscatedName("k")
   int[] field1521;
   @ObfuscatedName("v")
   int field1522;
   @ObfuscatedName("h")
   int field1523;
   @ObfuscatedName("u")
   int[] field1524;
   @ObfuscatedName("p")
   static int[] field1526;

   @ObfuscatedName("m")
   boolean method1976(double var1, int var3, class170 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1518.length; ++var5) {
         if(var4.method3363(this.field1518[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1524 = new int[var5];

      for(int var6 = 0; var6 < this.field1518.length; ++var6) {
         int var8 = this.field1518[var6];
         class83 var7;
         if(!class4.method43(var4, var8)) {
            var7 = null;
         } else {
            var7 = class77.method1682();
         }

         var7.method1944();
         byte[] var10 = var7.field1494;
         int[] var11 = var7.field1495;
         int var12 = this.field1521[var6];
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
            var11[var13] = class94.method2173(var11[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1519[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var7.field1500 == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1524[var14] = var11[var10[var14] & 255];
               }
            } else if(var7.field1500 == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1524[var14++] = var11[var10[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.field1500 != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1524[var14++] = var11[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
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

   @ObfuscatedName("w")
   void method1977() {
      this.field1524 = null;
   }

   @ObfuscatedName("e")
   void method1978(int var1) {
      if(this.field1524 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1522 == 1 || this.field1522 == 3) {
            if(field1526 == null || field1526.length < this.field1524.length) {
               field1526 = new int[this.field1524.length];
            }

            if(this.field1524.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1524.length;
            var4 = var2 * var1 * this.field1523;
            var5 = var3 - 1;
            if(this.field1522 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1526[var6] = this.field1524[var7];
            }

            var10 = this.field1524;
            this.field1524 = field1526;
            field1526 = var10;
         }

         if(this.field1522 == 2 || this.field1522 == 4) {
            if(field1526 == null || field1526.length < this.field1524.length) {
               field1526 = new int[this.field1524.length];
            }

            if(this.field1524.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1524.length;
            var4 = var1 * this.field1523;
            var5 = var2 - 1;
            if(this.field1522 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1526[var8] = this.field1524[var9];
               }
            }

            var10 = this.field1524;
            this.field1524 = field1526;
            field1526 = var10;
         }

      }
   }

   class86(class122 var1) {
      this.field1516 = var1.method2706();
      this.field1517 = var1.method2556() == 1;
      int var2 = var1.method2556();
      if(var2 >= 1 && var2 <= 4) {
         this.field1518 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1518[var3] = var1.method2706();
         }

         if(var2 > 1) {
            this.field1519 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1519[var3] = var1.method2556();
            }
         }

         if(var2 > 1) {
            this.field1520 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1520[var3] = var1.method2556();
            }
         }

         this.field1521 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1521[var3] = var1.method2577();
         }

         this.field1522 = var1.method2556();
         this.field1523 = var1.method2556();
         this.field1524 = null;
      } else {
         throw new RuntimeException();
      }
   }
}
