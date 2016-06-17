import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cl")
public class class83 extends class208 {
   @ObfuscatedName("z")
   boolean field1408 = false;
   @ObfuscatedName("x")
   int field1411;
   @ObfuscatedName("y")
   boolean field1412;
   @ObfuscatedName("r")
   int[] field1413;
   @ObfuscatedName("p")
   int field1414;
   @ObfuscatedName("l")
   int[] field1415;
   @ObfuscatedName("u")
   int[] field1416;
   @ObfuscatedName("n")
   int field1418;
   @ObfuscatedName("w")
   int[] field1419;
   @ObfuscatedName("c")
   int[] field1420;
   @ObfuscatedName("k")
   static int[] field1421;

   @ObfuscatedName("b")
   boolean method1899(double var1, int var3, class167 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1413.length; ++var5) {
         if(var4.method3273(this.field1413[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1419 = new int[var5];

      for(int var6 = 0; var6 < this.field1413.length; ++var6) {
         int var8 = this.field1413[var6];
         class80 var7;
         if(!class143.method3041(var4, var8)) {
            var7 = null;
         } else {
            class80 var10 = new class80();
            var10.field1393 = class109.field1890;
            var10.field1388 = class76.field1351;
            var10.field1392 = class76.field1353[0];
            var10.field1395 = class131.field2048[0];
            var10.field1390 = class76.field1354[0];
            var10.field1391 = class28.field674[0];
            var10.field1389 = class8.field135;
            var10.field1394 = class76.field1355[0];
            class7.method95();
            var7 = var10;
         }

         var7.method1867();
         byte[] var17 = var7.field1394;
         int[] var11 = var7.field1389;
         int var12 = this.field1416[var6];
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
            var11[var13] = class91.method2100(var11[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1420[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var7.field1390 == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1419[var14] = var11[var17[var14] & 255];
               }
            } else if(var7.field1390 == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1419[var14++] = var11[var17[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.field1390 != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1419[var14++] = var11[var17[(var16 << 1) + (var15 << 1 << 7)] & 255];
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

   @ObfuscatedName("g")
   void method1900() {
      this.field1419 = null;
   }

   @ObfuscatedName("j")
   void method1901(int var1) {
      if(this.field1419 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1414 == 1 || this.field1414 == 3) {
            if(field1421 == null || field1421.length < this.field1419.length) {
               field1421 = new int[this.field1419.length];
            }

            if(this.field1419.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1419.length;
            var4 = var2 * var1 * this.field1418;
            var5 = var3 - 1;
            if(this.field1414 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1421[var6] = this.field1419[var7];
            }

            var10 = this.field1419;
            this.field1419 = field1421;
            field1421 = var10;
         }

         if(this.field1414 == 2 || this.field1414 == 4) {
            if(field1421 == null || field1421.length < this.field1419.length) {
               field1421 = new int[this.field1419.length];
            }

            if(this.field1419.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1419.length;
            var4 = var1 * this.field1418;
            var5 = var2 - 1;
            if(this.field1414 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1421[var8] = this.field1419[var9];
               }
            }

            var10 = this.field1419;
            this.field1419 = field1421;
            field1421 = var10;
         }

      }
   }

   class83(class119 var1) {
      this.field1411 = var1.method2516();
      this.field1412 = var1.method2514() == 1;
      int var2 = var1.method2514();
      if(var2 >= 1 && var2 <= 4) {
         this.field1413 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1413[var3] = var1.method2516();
         }

         if(var2 > 1) {
            this.field1420 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1420[var3] = var1.method2514();
            }
         }

         if(var2 > 1) {
            this.field1415 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1415[var3] = var1.method2514();
            }
         }

         this.field1416 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1416[var3] = var1.method2519();
         }

         this.field1414 = var1.method2514();
         this.field1418 = var1.method2514();
         this.field1419 = null;
      } else {
         throw new RuntimeException();
      }
   }
}
