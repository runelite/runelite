import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cf")
public class class79 extends Node {
   @ObfuscatedName("o")
   int[] field1303;
   @ObfuscatedName("d")
   int field1304;
   @ObfuscatedName("k")
   boolean field1305;
   @ObfuscatedName("j")
   int[] field1306;
   @ObfuscatedName("h")
   int[] field1307;
   @ObfuscatedName("a")
   int[] field1309;
   @ObfuscatedName("c")
   int field1310;
   @ObfuscatedName("m")
   int field1311;
   @ObfuscatedName("s")
   int[] field1312;
   @ObfuscatedName("r")
   boolean field1313 = false;
   @ObfuscatedName("u")
   static int[] field1314;

   @ObfuscatedName("p")
   boolean method1541(double var1, int var3, class182 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1306.length; ++var5) {
         if(var4.method3337(this.field1306[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1307 = new int[var5];

      for(int var6 = 0; var6 < this.field1306.length; ++var6) {
         int var8 = this.field1306[var6];
         byte[] var10 = var4.method3292(var8);
         boolean var9;
         if(var10 == null) {
            var9 = false;
         } else {
            ItemLayer.method1455(var10);
            var9 = true;
         }

         ModIcon var7;
         if(!var9) {
            var7 = null;
         } else {
            var7 = class186.method3418();
         }

         var7.method4081();
         var10 = var7.pixels;
         int[] var11 = var7.palette;
         int var12 = this.field1309[var6];
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
            var11[var13] = class84.method1636(var11[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1312[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var7.originalWidth == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1307[var14] = var11[var10[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1307[var14++] = var11[var10[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1307[var14++] = var11[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
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
   void method1543() {
      this.field1307 = null;
   }

   @ObfuscatedName("x")
   void method1544(int var1) {
      if(this.field1307 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1310 == 1 || this.field1310 == 3) {
            if(field1314 == null || field1314.length < this.field1307.length) {
               field1314 = new int[this.field1307.length];
            }

            if(this.field1307.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1307.length;
            var4 = var2 * var1 * this.field1311;
            var5 = var3 - 1;
            if(this.field1310 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1314[var6] = this.field1307[var7];
            }

            var10 = this.field1307;
            this.field1307 = field1314;
            field1314 = var10;
         }

         if(this.field1310 == 2 || this.field1310 == 4) {
            if(field1314 == null || field1314.length < this.field1307.length) {
               field1314 = new int[this.field1307.length];
            }

            if(this.field1307.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1307.length;
            var4 = var1 * this.field1311;
            var5 = var2 - 1;
            if(this.field1310 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1314[var8] = this.field1307[var9];
               }
            }

            var10 = this.field1307;
            this.field1307 = field1314;
            field1314 = var10;
         }

      }
   }

   class79(Buffer var1) {
      this.field1304 = var1.readUnsignedShort();
      this.field1305 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.field1306 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1306[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1312 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1312[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1303 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1303[var3] = var1.readUnsignedByte();
            }
         }

         this.field1309 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1309[var3] = var1.method2819();
         }

         this.field1310 = var1.readUnsignedByte();
         this.field1311 = var1.readUnsignedByte();
         this.field1307 = null;
      } else {
         throw new RuntimeException();
      }
   }
}
