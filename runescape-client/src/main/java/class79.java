import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cb")
public class class79 extends Node {
   @ObfuscatedName("g")
   int field1290;
   @ObfuscatedName("v")
   int[] field1293;
   @ObfuscatedName("t")
   int field1294;
   @ObfuscatedName("u")
   int[] field1296;
   @ObfuscatedName("z")
   int[] field1297;
   @ObfuscatedName("l")
   int[] field1298;
   @ObfuscatedName("s")
   boolean field1300 = false;
   @ObfuscatedName("w")
   int field1301;
   @ObfuscatedName("r")
   int[] field1302;
   @ObfuscatedName("p")
   boolean field1303;
   @ObfuscatedName("k")
   static int[] field1304;

   class79(Buffer var1) {
      this.field1294 = var1.readUnsignedShort();
      this.field1303 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.field1296 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1296[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1297 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1297[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1298 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1298[var3] = var1.readUnsignedByte();
            }
         }

         this.field1293 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1293[var3] = var1.readInt();
         }

         this.field1290 = var1.readUnsignedByte();
         this.field1301 = var1.readUnsignedByte();
         this.field1302 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("d")
   boolean method1555(double var1, int var3, IndexDataBase var4) {
      int var5;
      for(var5 = 0; var5 < this.field1296.length; ++var5) {
         if(var4.method3307(this.field1296[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1302 = new int[var5];

      for(int var6 = 0; var6 < this.field1296.length; ++var6) {
         int var8 = this.field1296[var6];
         byte[] var10 = var4.method3300(var8);
         boolean var9;
         if(var10 == null) {
            var9 = false;
         } else {
            class172.method3255(var10);
            var9 = true;
         }

         ModIcon var7;
         if(!var9) {
            var7 = null;
         } else {
            ModIcon var11 = new ModIcon();
            var11.width = class229.field3255;
            var11.originalHeight = class229.field3251;
            var11.offsetX = class199.field2877[0];
            var11.offsetY = class229.field3252[0];
            var11.originalWidth = class229.field3254[0];
            var11.height = class36.field772[0];
            var11.palette = class229.field3249;
            var11.pixels = class229.field3253[0];
            class199.field2877 = null;
            class229.field3252 = null;
            class229.field3254 = null;
            class36.field772 = null;
            class229.field3249 = null;
            class229.field3253 = null;
            var7 = var11;
         }

         var7.method4167();
         var10 = var7.pixels;
         int[] var18 = var7.palette;
         int var12 = this.field1293[var6];
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
            var18[var13] = class84.method1656(var18[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1297[var6 - 1];
         }

         if(var13 == 0) {
            if(var7.originalWidth == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1302[var14] = var18[var10[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1302[var14++] = var18[var10[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1302[var14++] = var18[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
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

   @ObfuscatedName("c")
   void method1556() {
      this.field1302 = null;
   }

   @ObfuscatedName("n")
   void method1559(int var1) {
      if(this.field1302 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int[] var6;
         int var7;
         int var10;
         if(this.field1290 == 1 || this.field1290 == 3) {
            if(field1304 == null || field1304.length < this.field1302.length) {
               field1304 = new int[this.field1302.length];
            }

            if(this.field1302.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1302.length;
            var4 = var2 * var1 * this.field1301;
            var5 = var3 - 1;
            if(this.field1290 == 1) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; ++var10) {
               var7 = var10 + var4 & var5;
               field1304[var10] = this.field1302[var7];
            }

            var6 = this.field1302;
            this.field1302 = field1304;
            field1304 = var6;
         }

         if(this.field1290 == 2 || this.field1290 == 4) {
            if(field1304 == null || field1304.length < this.field1302.length) {
               field1304 = new int[this.field1302.length];
            }

            if(this.field1302.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1302.length;
            var4 = var1 * this.field1301;
            var5 = var2 - 1;
            if(this.field1290 == 2) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; var10 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var10 + var7;
                  int var9 = var10 + (var7 + var4 & var5);
                  field1304[var8] = this.field1302[var9];
               }
            }

            var6 = this.field1302;
            this.field1302 = field1304;
            field1304 = var6;
         }

      }
   }
}
