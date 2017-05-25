import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eu")
public class class130 extends Node {
   @ObfuscatedName("t")
   int[] field1859;
   @ObfuscatedName("p")
   int[] field1861;
   @ObfuscatedName("g")
   int field1863;
   @ObfuscatedName("v")
   boolean field1864;
   @ObfuscatedName("o")
   static int[] field1865;
   @ObfuscatedName("l")
   int[] field1867;
   @ObfuscatedName("a")
   int[] field1868;
   @ObfuscatedName("r")
   int field1869;
   @ObfuscatedName("k")
   int field1870;
   @ObfuscatedName("x")
   boolean field1872;
   @ObfuscatedName("b")
   int[] field1873;

   class130(Buffer var1) {
      this.field1872 = false;
      this.field1863 = var1.readUnsignedShort();
      this.field1864 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.field1859 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1859[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1861 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1861[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1867 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1867[var3] = var1.readUnsignedByte();
            }
         }

         this.field1868 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1868[var3] = var1.readInt();
         }

         this.field1870 = var1.readUnsignedByte();
         this.field1869 = var1.readUnsignedByte();
         this.field1873 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   boolean method2525(double var1, int var3, IndexDataBase var4) {
      int var5;
      for(var5 = 0; var5 < this.field1859.length; ++var5) {
         if(var4.method4181(this.field1859[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1873 = new int[var5];

      for(int var6 = 0; var6 < this.field1859.length; ++var6) {
         int var8 = this.field1859[var6];
         byte[] var10 = var4.method4180(var8);
         boolean var9;
         if(var10 == null) {
            var9 = false;
         } else {
            class43.method638(var10);
            var9 = true;
         }

         ModIcon var7;
         if(!var9) {
            var7 = null;
         } else {
            var7 = class71.method1122();
         }

         var7.method5111();
         var10 = var7.pixels;
         int[] var11 = var7.palette;
         int var12 = this.field1868[var6];
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
            var11[var13] = class136.method2629(var11[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1861[var6 - 1];
         }

         if(var13 == 0) {
            if(var7.originalWidth == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1873[var14] = var11[var10[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1873[var14++] = var11[var10[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1873[var14++] = var11[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
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

   @ObfuscatedName("u")
   void method2526(int var1) {
      if(this.field1873 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1870 == 1 || this.field1870 == 3) {
            if(field1865 == null || field1865.length < this.field1873.length) {
               field1865 = new int[this.field1873.length];
            }

            if(this.field1873.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1873.length;
            var4 = var2 * var1 * this.field1869;
            var5 = var3 - 1;
            if(this.field1870 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1865[var6] = this.field1873[var7];
            }

            var10 = this.field1873;
            this.field1873 = field1865;
            field1865 = var10;
         }

         if(this.field1870 == 2 || this.field1870 == 4) {
            if(field1865 == null || field1865.length < this.field1873.length) {
               field1865 = new int[this.field1873.length];
            }

            if(this.field1873.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1873.length;
            var4 = var1 * this.field1869;
            var5 = var2 - 1;
            if(this.field1870 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1865[var8] = this.field1873[var9];
               }
            }

            var10 = this.field1873;
            this.field1873 = field1865;
            field1865 = var10;
         }

      }
   }

   @ObfuscatedName("h")
   void method2529() {
      this.field1873 = null;
   }
}
