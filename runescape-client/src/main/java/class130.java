import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eg")
public class class130 extends Node {
   @ObfuscatedName("x")
   int[] field1884;
   @ObfuscatedName("f")
   int field1885;
   @ObfuscatedName("c")
   int[] field1887;
   @ObfuscatedName("z")
   int[] field1888;
   @ObfuscatedName("h")
   int[] field1889;
   @ObfuscatedName("g")
   int[] field1890;
   @ObfuscatedName("e")
   int field1891;
   @ObfuscatedName("o")
   int field1892;
   @ObfuscatedName("m")
   boolean field1893;
   @ObfuscatedName("a")
   boolean field1894;
   @ObfuscatedName("y")
   static int[] field1895;

   @ObfuscatedName("n")
   boolean method2498(double var1, int var3, IndexDataBase var4) {
      int var5;
      for(var5 = 0; var5 < this.field1887.length; ++var5) {
         if(var4.method4133(this.field1887[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1884 = new int[var5];

      for(int var6 = 0; var6 < this.field1887.length; ++var6) {
         int var8 = this.field1887[var6];
         ModIcon var7;
         if(!Varbit.method4449(var4, var8)) {
            var7 = null;
         } else {
            var7 = GameEngine.method967();
         }

         var7.method5063();
         byte[] var10 = var7.pixels;
         int[] var11 = var7.palette;
         int var12 = this.field1890[var6];
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
            var11[var13] = class136.method2653(var11[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1888[var6 - 1];
         }

         if(var13 == 0) {
            if(var7.originalWidth == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1884[var14] = var11[var10[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1884[var14++] = var11[var10[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1884[var14++] = var11[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
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

   class130(Buffer var1) {
      this.field1894 = false;
      this.field1885 = var1.readUnsignedShort();
      this.field1893 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.field1887 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1887[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1888 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1888[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1889 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1889[var3] = var1.readUnsignedByte();
            }
         }

         this.field1890 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1890[var3] = var1.readInt();
         }

         this.field1891 = var1.readUnsignedByte();
         this.field1892 = var1.readUnsignedByte();
         this.field1884 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("p")
   void method2501() {
      this.field1884 = null;
   }

   @ObfuscatedName("i")
   void method2502(int var1) {
      if(this.field1884 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int[] var6;
         int var7;
         int var10;
         if(this.field1891 == 1 || this.field1891 == 3) {
            if(field1895 == null || field1895.length < this.field1884.length) {
               field1895 = new int[this.field1884.length];
            }

            if(this.field1884.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1884.length;
            var4 = var2 * var1 * this.field1892;
            var5 = var3 - 1;
            if(this.field1891 == 1) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; ++var10) {
               var7 = var10 + var4 & var5;
               field1895[var10] = this.field1884[var7];
            }

            var6 = this.field1884;
            this.field1884 = field1895;
            field1895 = var6;
         }

         if(this.field1891 == 2 || this.field1891 == 4) {
            if(field1895 == null || field1895.length < this.field1884.length) {
               field1895 = new int[this.field1884.length];
            }

            if(this.field1884.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1884.length;
            var4 = var1 * this.field1892;
            var5 = var2 - 1;
            if(this.field1891 == 2) {
               var4 = -var4;
            }

            for(var10 = 0; var10 < var3; var10 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var10 + var7;
                  int var9 = var10 + (var7 + var4 & var5);
                  field1895[var8] = this.field1884[var9];
               }
            }

            var6 = this.field1884;
            this.field1884 = field1895;
            field1895 = var6;
         }

      }
   }
}
