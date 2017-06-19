import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ez")
public class class130 extends Node {
   @ObfuscatedName("f")
   int[] field1873;
   @ObfuscatedName("w")
   int field1875;
   @ObfuscatedName("z")
   boolean field1876;
   @ObfuscatedName("i")
   int[] field1878;
   @ObfuscatedName("j")
   int[] field1879;
   @ObfuscatedName("c")
   int[] field1880;
   @ObfuscatedName("o")
   int field1881;
   @ObfuscatedName("q")
   int field1882;
   @ObfuscatedName("n")
   int[] field1883;
   @ObfuscatedName("a")
   boolean field1884;
   @ObfuscatedName("g")
   static int[] field1885;

   @ObfuscatedName("m")
   void method2379() {
      this.field1883 = null;
   }

   @ObfuscatedName("p")
   boolean method2382(double var1, int var3, IndexDataBase var4) {
      int var5;
      for(var5 = 0; var5 < this.field1879.length; ++var5) {
         if(var4.method4003(this.field1879[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1883 = new int[var5];

      for(int var6 = 0; var6 < this.field1879.length; ++var6) {
         ModIcon var7 = class265.method4726(var4, this.field1879[var6]);
         var7.method4911();
         byte[] var8 = var7.pixels;
         int[] var9 = var7.palette;
         int var10 = this.field1880[var6];
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
               if(var14 >> 8 == (var14 & '\uffff')) {
                  var14 &= 255;
                  var9[var13] = var11 * var14 >> 8 & 16711935 | var12 * var14 & '\uff00';
               }
            }
         }

         for(var11 = 0; var11 < var9.length; ++var11) {
            var9[var11] = class136.method2500(var9[var11], var1);
         }

         if(var6 == 0) {
            var11 = 0;
         } else {
            var11 = this.field1878[var6 - 1];
         }

         if(var11 == 0) {
            if(var3 == var7.originalWidth) {
               for(var12 = 0; var12 < var5; ++var12) {
                  this.field1883[var12] = var9[var8[var12] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1883[var12++] = var9[var8[(var13 >> 1 << 6) + (var14 >> 1)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var12 = 0;

               for(var13 = 0; var13 < var3; ++var13) {
                  for(var14 = 0; var14 < var3; ++var14) {
                     this.field1883[var12++] = var9[var8[(var13 << 1 << 7) + (var14 << 1)] & 255];
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

   @ObfuscatedName("e")
   void method2385(int var1) {
      if(this.field1883 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var8;
         if(this.field1881 == 1 || this.field1881 == 3) {
            if(field1885 == null || field1885.length < this.field1883.length) {
               field1885 = new int[this.field1883.length];
            }

            if(this.field1883.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1883.length;
            var4 = var2 * var1 * this.field1882;
            var5 = var3 - 1;
            if(this.field1881 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var4 + var6 & var5;
               field1885[var6] = this.field1883[var7];
            }

            var8 = this.field1883;
            this.field1883 = field1885;
            field1885 = var8;
         }

         if(this.field1881 == 2 || this.field1881 == 4) {
            if(field1885 == null || field1885.length < this.field1883.length) {
               field1885 = new int[this.field1883.length];
            }

            if(this.field1883.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1883.length;
            var4 = this.field1882 * var1;
            var5 = var2 - 1;
            if(this.field1881 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var9 = var7 + var6;
                  int var10 = (var7 + var4 & var5) + var6;
                  field1885[var9] = this.field1883[var10];
               }
            }

            var8 = this.field1883;
            this.field1883 = field1885;
            field1885 = var8;
         }
      }

   }

   class130(Buffer var1) {
      this.field1884 = false;
      this.field1875 = var1.readUnsignedShort();
      this.field1876 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.field1879 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1879[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1878 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1878[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1873 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1873[var3] = var1.readUnsignedByte();
            }
         }

         this.field1880 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1880[var3] = var1.readInt();
         }

         this.field1881 = var1.readUnsignedByte();
         this.field1882 = var1.readUnsignedByte();
         this.field1883 = null;
      } else {
         throw new RuntimeException();
      }
   }
}
