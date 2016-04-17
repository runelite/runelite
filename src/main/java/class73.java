import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bs")
public class class73 {
   @ObfuscatedName("d")
   int[] field1365;
   @ObfuscatedName("w")
   int field1366;
   @ObfuscatedName("y")
   float[][] field1367;
   @ObfuscatedName("c")
   int[] field1368;
   @ObfuscatedName("a")
   int field1369;
   @ObfuscatedName("k")
   int[] field1370;

   class73() {
      class70.method1636(24);
      this.field1369 = class70.method1636(16);
      this.field1366 = class70.method1636(24);
      this.field1365 = new int[this.field1366];
      boolean var1 = class70.method1633() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class70.method1636(5) + 1; var2 < this.field1366; ++var3) {
            int var4 = class70.method1636(class38.method852(this.field1366 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1365[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class70.method1633() != 0;

         for(var3 = 0; var3 < this.field1366; ++var3) {
            if(var14 && class70.method1633() == 0) {
               this.field1365[var3] = 0;
            } else {
               this.field1365[var3] = class70.method1636(5) + 1;
            }
         }
      }

      this.method1678();
      var2 = class70.method1636(4);
      if(var2 > 0) {
         float var15 = class70.method1661(class70.method1636(32));
         float var16 = class70.method1661(class70.method1636(32));
         var5 = class70.method1636(4) + 1;
         boolean var6 = class70.method1633() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1681(this.field1366, this.field1369);
         } else {
            var7 = this.field1366 * this.field1369;
         }

         this.field1368 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1368[var8] = class70.method1636(var5);
         }

         this.field1367 = new float[this.field1366][this.field1369];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1366; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1369; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1368[var12] * var16 + var15 + var9;
                  this.field1367[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1366; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field1369;

               for(var11 = 0; var11 < this.field1369; ++var11) {
                  float var17 = (float)this.field1368[var10] * var16 + var15 + var9;
                  this.field1367[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   void method1678() {
      int[] var1 = new int[this.field1366];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1366; ++var3) {
         var4 = this.field1365[var3];
         if(var4 != 0) {
            var5 = 1 << 32 - var4;
            var6 = var2[var4];
            var1[var3] = var6;
            int var9;
            if((var6 & var5) != 0) {
               var7 = var2[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var9 = var2[var8];
                  if(var9 != var6) {
                     break;
                  }

                  var10 = 1 << 32 - var8;
                  if((var9 & var10) != 0) {
                     var2[var8] = var2[var8 - 1];
                     break;
                  }

                  var2[var8] = var9 | var10;
               }
            }

            var2[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; ++var8) {
               var9 = var2[var8];
               if(var9 == var6) {
                  var2[var8] = var7;
               }
            }
         }
      }

      this.field1370 = new int[8];
      int var11 = 0;

      for(var3 = 0; var3 < this.field1366; ++var3) {
         var4 = this.field1365[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1370[var6] == 0) {
                     this.field1370[var6] = var11;
                  }

                  var6 = this.field1370[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1370.length) {
                  int[] var12 = new int[this.field1370.length * 2];

                  for(var10 = 0; var10 < this.field1370.length; ++var10) {
                     var12[var10] = this.field1370[var10];
                  }

                  this.field1370 = var12;
               }

               var8 >>>= 1;
            }

            this.field1370[var6] = ~var3;
            if(var6 >= var11) {
               var11 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("d")
   int method1679() {
      int var1;
      for(var1 = 0; this.field1370[var1] >= 0; var1 = class70.method1633() != 0?this.field1370[var1]:var1 + 1) {
         ;
      }

      return ~this.field1370[var1];
   }

   @ObfuscatedName("a")
   static int method1681(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; class2.method47(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }

   @ObfuscatedName("c")
   float[] method1685() {
      return this.field1367[this.method1679()];
   }
}
