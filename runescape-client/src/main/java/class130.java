import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ee")
public class class130 extends Node {
   @ObfuscatedName("k")
   int[] field1879;
   @ObfuscatedName("s")
   int field1883;
   @ObfuscatedName("j")
   int[] field1884;
   @ObfuscatedName("v")
   int[] field1885;
   @ObfuscatedName("y")
   int[] field1886;
   @ObfuscatedName("c")
   static int[] field1887;
   @ObfuscatedName("e")
   int field1888;
   @ObfuscatedName("r")
   boolean field1889;
   @ObfuscatedName("l")
   boolean field1890;
   @ObfuscatedName("z")
   int[] field1891;
   @ObfuscatedName("o")
   int field1892;

   @ObfuscatedName("i")
   boolean method2475(double var1, int var3, IndexDataBase var4) {
      int var5;
      for(var5 = 0; var5 < this.field1885.length; ++var5) {
         if(var4.method4122(this.field1885[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1891 = new int[var5];

      for(int var6 = 0; var6 < this.field1885.length; ++var6) {
         int var8 = this.field1885[var6];
         ModIcon var7;
         if(!class95.method1783(var4, var8)) {
            var7 = null;
         } else {
            var7 = class268.method4861();
         }

         var7.method5022();
         byte[] var10 = var7.pixels;
         int[] var11 = var7.palette;
         int var12 = this.field1879[var6];
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
               if(var16 >> 8 == (var16 & '\uffff')) {
                  var16 &= 255;
                  var11[var15] = var13 * var16 >> 8 & 16711935 | var16 * var14 & '\uff00';
               }
            }
         }

         for(var13 = 0; var13 < var11.length; ++var13) {
            var11[var13] = class136.method2589(var11[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1886[var6 - 1];
         }

         if(var13 == 0) {
            if(var3 == var7.originalWidth) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1891[var14] = var11[var10[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1891[var14++] = var11[var10[(var15 >> 1 << 6) + (var16 >> 1)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1891[var14++] = var11[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
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
   void method2476() {
      this.field1891 = null;
   }

   @ObfuscatedName("a")
   void method2477(int var1) {
      if(this.field1891 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1888 == 1 || this.field1888 == 3) {
            if(field1887 == null || field1887.length < this.field1891.length) {
               field1887 = new int[this.field1891.length];
            }

            if(this.field1891.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1891.length;
            var4 = var2 * var1 * this.field1892;
            var5 = var3 - 1;
            if(this.field1888 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var4 + var6 & var5;
               field1887[var6] = this.field1891[var7];
            }

            var10 = this.field1891;
            this.field1891 = field1887;
            field1887 = var10;
         }

         if(this.field1888 == 2 || this.field1888 == 4) {
            if(field1887 == null || field1887.length < this.field1891.length) {
               field1887 = new int[this.field1891.length];
            }

            if(this.field1891.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1891.length;
            var4 = this.field1892 * var1;
            var5 = var2 - 1;
            if(this.field1888 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var7 + var6;
                  int var9 = (var7 + var4 & var5) + var6;
                  field1887[var8] = this.field1891[var9];
               }
            }

            var10 = this.field1891;
            this.field1891 = field1887;
            field1887 = var10;
         }

      }
   }

   class130(Buffer var1) {
      this.field1890 = false;
      this.field1883 = var1.readUnsignedShort();
      this.field1889 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.field1885 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1885[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1886 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1886[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1884 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1884[var3] = var1.readUnsignedByte();
            }
         }

         this.field1879 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1879[var3] = var1.readInt();
         }

         this.field1888 = var1.readUnsignedByte();
         this.field1892 = var1.readUnsignedByte();
         this.field1891 = null;
      } else {
         throw new RuntimeException();
      }
   }
}
