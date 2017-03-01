import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ci")
public class class79 extends Node {
   @ObfuscatedName("y")
   int field1312;
   @ObfuscatedName("s")
   int field1313;
   @ObfuscatedName("j")
   int[] field1314;
   @ObfuscatedName("o")
   boolean field1315 = false;
   @ObfuscatedName("p")
   boolean field1317;
   @ObfuscatedName("m")
   int[] field1319;
   @ObfuscatedName("a")
   int[] field1320;
   @ObfuscatedName("i")
   int[] field1321;
   @ObfuscatedName("k")
   int field1323;
   @ObfuscatedName("f")
   int[] field1324;
   @ObfuscatedName("q")
   static int[] field1326;

   @ObfuscatedName("x")
   boolean method1628(double var1, int var3, class182 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1314.length; ++var5) {
         if(var4.method3362(this.field1314[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1324 = new int[var5];

      for(int var6 = 0; var6 < this.field1314.length; ++var6) {
         int var8 = this.field1314[var6];
         byte[] var10 = var4.method3360(var8);
         boolean var9;
         if(null == var10) {
            var9 = false;
         } else {
            class112.method2186(var10);
            var9 = true;
         }

         ModIcon var7;
         if(!var9) {
            var7 = null;
         } else {
            ModIcon var11 = new ModIcon();
            var11.width = class225.field3234;
            var11.originalHeight = class0.field2;
            var11.offsetX = class225.field3236[0];
            var11.offsetY = class145.field2013[0];
            var11.originalWidth = class186.field2775[0];
            var11.height = class225.field3235[0];
            var11.palette = class225.field3237;
            var11.pixels = Ignore.field211[0];
            WallObject.method1986();
            var7 = var11;
         }

         var7.method4113();
         var10 = var7.pixels;
         int[] var18 = var7.palette;
         int var12 = this.field1321[var6];
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

            for(var15 = 0; var15 < var18.length; ++var15) {
               var16 = var18[var15];
               if((var16 & '\uffff') == var16 >> 8) {
                  var16 &= 255;
                  var18[var15] = var13 * var16 >> 8 & 16711935 | var14 * var16 & '\uff00';
               }
            }
         }

         for(var13 = 0; var13 < var18.length; ++var13) {
            var18[var13] = class84.method1730(var18[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1319[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var7.originalWidth == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1324[var14] = var18[var10[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1324[var14++] = var18[var10[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1324[var14++] = var18[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
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
   void method1630(int var1) {
      if(this.field1324 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1313 == 1 || this.field1313 == 3) {
            if(field1326 == null || field1326.length < this.field1324.length) {
               field1326 = new int[this.field1324.length];
            }

            if(this.field1324.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1324.length;
            var4 = var2 * var1 * this.field1323;
            var5 = var3 - 1;
            if(this.field1313 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1326[var6] = this.field1324[var7];
            }

            var10 = this.field1324;
            this.field1324 = field1326;
            field1326 = var10;
         }

         if(this.field1313 == 2 || this.field1313 == 4) {
            if(field1326 == null || field1326.length < this.field1324.length) {
               field1326 = new int[this.field1324.length];
            }

            if(this.field1324.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1324.length;
            var4 = var1 * this.field1323;
            var5 = var2 - 1;
            if(this.field1313 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1326[var8] = this.field1324[var9];
               }
            }

            var10 = this.field1324;
            this.field1324 = field1326;
            field1326 = var10;
         }

      }
   }

   class79(Buffer var1) {
      this.field1312 = var1.readUnsignedShort();
      this.field1317 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.field1314 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1314[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1319 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1319[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1320 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1320[var3] = var1.readUnsignedByte();
            }
         }

         this.field1321 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1321[var3] = var1.readInt();
         }

         this.field1313 = var1.readUnsignedByte();
         this.field1323 = var1.readUnsignedByte();
         this.field1324 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("n")
   void method1635() {
      this.field1324 = null;
   }
}
