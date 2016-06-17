import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
public class class73 {
   @ObfuscatedName("y")
   int[] field1328;
   @ObfuscatedName("b")
   int field1329;
   @ObfuscatedName("j")
   int[] field1330;
   @ObfuscatedName("d")
   int[] field1331;
   @ObfuscatedName("x")
   float[][] field1332;
   @ObfuscatedName("g")
   int field1333;

   @ObfuscatedName("d")
   float[] method1604() {
      return this.field1332[this.method1606()];
   }

   @ObfuscatedName("g")
   void method1605() {
      int[] var1 = new int[this.field1333];
      int[] var11 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1333; ++var3) {
         var4 = this.field1330[var3];
         if(var4 != 0) {
            var5 = 1 << 32 - var4;
            var6 = var11[var4];
            var1[var3] = var6;
            int var12;
            if((var6 & var5) != 0) {
               var7 = var11[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var12 = var11[var8];
                  if(var12 != var6) {
                     break;
                  }

                  var10 = 1 << 32 - var8;
                  if((var12 & var10) != 0) {
                     var11[var8] = var11[var8 - 1];
                     break;
                  }

                  var11[var8] = var12 | var10;
               }
            }

            var11[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; ++var8) {
               var12 = var11[var8];
               if(var12 == var6) {
                  var11[var8] = var7;
               }
            }
         }
      }

      this.field1328 = new int[8];
      int var2 = 0;

      for(var3 = 0; var3 < this.field1333; ++var3) {
         var4 = this.field1330[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1328[var6] == 0) {
                     this.field1328[var6] = var2;
                  }

                  var6 = this.field1328[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1328.length) {
                  int[] var9 = new int[this.field1328.length * 2];

                  for(var10 = 0; var10 < this.field1328.length; ++var10) {
                     var9[var10] = this.field1328[var10];
                  }

                  this.field1328 = var9;
               }

               var8 >>>= 1;
            }

            this.field1328[var6] = ~var3;
            if(var6 >= var2) {
               var2 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("j")
   int method1606() {
      int var1;
      for(var1 = 0; this.field1328[var1] >= 0; var1 = class70.method1546() != 0?this.field1328[var1]:var1 + 1) {
         ;
      }

      return ~this.field1328[var1];
   }

   class73() {
      class70.method1544(24);
      this.field1329 = class70.method1544(16);
      this.field1333 = class70.method1544(24);
      this.field1330 = new int[this.field1333];
      boolean var1 = class70.method1546() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class70.method1544(5) + 1; var2 < this.field1333; ++var3) {
            int var4 = class70.method1544(class39.method795(this.field1333 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1330[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class70.method1546() != 0;

         for(var3 = 0; var3 < this.field1333; ++var3) {
            if(var14 && class70.method1546() == 0) {
               this.field1330[var3] = 0;
            } else {
               this.field1330[var3] = class70.method1544(5) + 1;
            }
         }
      }

      this.method1605();
      var2 = class70.method1544(4);
      if(var2 > 0) {
         float var15 = class70.method1566(class70.method1544(32));
         float var16 = class70.method1566(class70.method1544(32));
         var5 = class70.method1544(4) + 1;
         boolean var6 = class70.method1546() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1616(this.field1333, this.field1329);
         } else {
            var7 = this.field1333 * this.field1329;
         }

         this.field1331 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1331[var8] = class70.method1544(var5);
         }

         this.field1332 = new float[this.field1333][this.field1329];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1333; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1329; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1331[var12] * var16 + var15 + var9;
                  this.field1332[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1333; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field1329;

               for(var11 = 0; var11 < this.field1329; ++var11) {
                  float var17 = (float)this.field1331[var10] * var16 + var15 + var9;
                  this.field1332[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("b")
   static int method1616(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; class84.method1910(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }
}
