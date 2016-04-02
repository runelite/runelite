import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cf")
public class class83 extends class208 {
   @ObfuscatedName("g")
   int[] field1414;
   @ObfuscatedName("a")
   int[] field1415;
   @ObfuscatedName("p")
   int field1417;
   @ObfuscatedName("h")
   boolean field1418;
   @ObfuscatedName("j")
   static int[] field1419;
   @ObfuscatedName("r")
   int[] field1421;
   @ObfuscatedName("k")
   int[] field1422;
   @ObfuscatedName("m")
   int field1423;
   @ObfuscatedName("n")
   int field1424;
   @ObfuscatedName("y")
   int[] field1425;
   @ObfuscatedName("i")
   boolean field1426 = false;

   @ObfuscatedName("w")
   void method1908() {
      this.field1425 = null;
   }

   @ObfuscatedName("e")
   boolean method1909(double var1, int var3, class167 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1414.length; ++var5) {
         if(var4.method3262(this.field1414[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1425 = new int[var5];

      for(int var6 = 0; var6 < this.field1414.length; ++var6) {
         int var8 = this.field1414[var6];
         byte[] var10 = var4.method3260(var8);
         boolean var9;
         if(null == var10) {
            var9 = false;
         } else {
            class121.method2747(var10);
            var9 = true;
         }

         class80 var7;
         if(!var9) {
            var7 = null;
         } else {
            class80 var11 = new class80();
            var11.field1395 = class76.field1356;
            var11.field1392 = class76.field1354;
            var11.field1393 = class76.field1357[0];
            var11.field1394 = class84.field1437[0];
            var11.field1390 = class5.field86[0];
            var11.field1391 = class76.field1355[0];
            var11.field1396 = class215.field3152;
            var11.field1389 = class76.field1352[0];
            class30.method670();
            var7 = var11;
         }

         var7.method1870();
         var10 = var7.field1389;
         int[] var17 = var7.field1396;
         int var12 = this.field1422[var6];
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

            for(var15 = 0; var15 < var17.length; ++var15) {
               var16 = var17[var15];
               if((var16 & '\uffff') == var16 >> 8) {
                  var16 &= 255;
                  var17[var15] = var13 * var16 >> 8 & 16711935 | var14 * var16 & '\uff00';
               }
            }
         }

         for(var13 = 0; var13 < var17.length; ++var13) {
            var17[var13] = class91.method2111(var17[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1415[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var7.field1390 == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1425[var14] = var17[var10[var14] & 255];
               }
            } else if(var7.field1390 == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1425[var14++] = var17[var10[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.field1390 != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1425[var14++] = var17[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
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

   @ObfuscatedName("f")
   void method1911(int var1) {
      if(this.field1425 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1423 == 1 || this.field1423 == 3) {
            if(field1419 == null || field1419.length < this.field1425.length) {
               field1419 = new int[this.field1425.length];
            }

            if(this.field1425.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1425.length;
            var4 = var2 * var1 * this.field1424;
            var5 = var3 - 1;
            if(this.field1423 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1419[var6] = this.field1425[var7];
            }

            var10 = this.field1425;
            this.field1425 = field1419;
            field1419 = var10;
         }

         if(this.field1423 == 2 || this.field1423 == 4) {
            if(field1419 == null || field1419.length < this.field1425.length) {
               field1419 = new int[this.field1425.length];
            }

            if(this.field1425.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1425.length;
            var4 = var1 * this.field1424;
            var5 = var2 - 1;
            if(this.field1423 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1419[var8] = this.field1425[var9];
               }
            }

            var10 = this.field1425;
            this.field1425 = field1419;
            field1419 = var10;
         }

      }
   }

   class83(class119 var1) {
      this.field1417 = var1.method2700();
      this.field1418 = var1.method2523() == 1;
      int var2 = var1.method2523();
      if(var2 >= 1 && var2 <= 4) {
         this.field1414 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1414[var3] = var1.method2700();
         }

         if(var2 > 1) {
            this.field1415 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1415[var3] = var1.method2523();
            }
         }

         if(var2 > 1) {
            this.field1421 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1421[var3] = var1.method2523();
            }
         }

         this.field1422 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1422[var3] = var1.method2528();
         }

         this.field1423 = var1.method2523();
         this.field1424 = var1.method2523();
         this.field1425 = null;
      } else {
         throw new RuntimeException();
      }
   }
}
