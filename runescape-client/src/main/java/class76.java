import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bq")
public class class76 {
   @ObfuscatedName("v")
   float[][] field1402;
   @ObfuscatedName("e")
   int field1403;
   @ObfuscatedName("n")
   int[] field1404;
   @ObfuscatedName("t")
   int[] field1405;
   @ObfuscatedName("f")
   int field1406;
   @ObfuscatedName("b")
   int[] field1407;

   class76() {
      class73.method1584(24);
      this.field1406 = class73.method1584(16);
      this.field1403 = class73.method1584(24);
      this.field1404 = new int[this.field1403];
      boolean var1 = class73.method1581() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class73.method1584(5) + 1; var2 < this.field1403; ++var3) {
            int var4 = class73.method1584(Projectile.method90(this.field1403 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1404[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class73.method1581() != 0;

         for(var3 = 0; var3 < this.field1403; ++var3) {
            if(var14 && class73.method1581() == 0) {
               this.field1404[var3] = 0;
            } else {
               this.field1404[var3] = class73.method1584(5) + 1;
            }
         }
      }

      this.method1642();
      var2 = class73.method1584(4);
      if(var2 > 0) {
         float var15 = class73.method1590(class73.method1584(32));
         float var16 = class73.method1590(class73.method1584(32));
         var5 = class73.method1584(4) + 1;
         boolean var6 = class73.method1581() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1635(this.field1403, this.field1406);
         } else {
            var7 = this.field1403 * this.field1406;
         }

         this.field1405 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1405[var8] = class73.method1584(var5);
         }

         this.field1402 = new float[this.field1403][this.field1406];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1403; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1406; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1405[var12] * var16 + var15 + var9;
                  this.field1402[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1403; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field1406;

               for(var11 = 0; var11 < this.field1406; ++var11) {
                  float var17 = (float)this.field1405[var10] * var16 + var15 + var9;
                  this.field1402[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   int method1631() {
      int var1;
      for(var1 = 0; this.field1407[var1] >= 0; var1 = class73.method1581() != 0?this.field1407[var1]:var1 + 1) {
         ;
      }

      return ~this.field1407[var1];
   }

   @ObfuscatedName("t")
   float[] method1632() {
      return this.field1402[this.method1631()];
   }

   @ObfuscatedName("f")
   static int method1635(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; class178.method3503(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }

   @ObfuscatedName("e")
   void method1642() {
      int[] var1 = new int[this.field1403];
      int[] var11 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1403; ++var3) {
         var4 = this.field1404[var3];
         if(var4 != 0) {
            var5 = 1 << 32 - var4;
            var6 = var11[var4];
            var1[var3] = var6;
            int var9;
            if((var6 & var5) != 0) {
               var7 = var11[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var9 = var11[var8];
                  if(var9 != var6) {
                     break;
                  }

                  var10 = 1 << 32 - var8;
                  if((var9 & var10) != 0) {
                     var11[var8] = var11[var8 - 1];
                     break;
                  }

                  var11[var8] = var9 | var10;
               }
            }

            var11[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; ++var8) {
               var9 = var11[var8];
               if(var9 == var6) {
                  var11[var8] = var7;
               }
            }
         }
      }

      this.field1407 = new int[8];
      int var2 = 0;

      for(var3 = 0; var3 < this.field1403; ++var3) {
         var4 = this.field1404[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1407[var6] == 0) {
                     this.field1407[var6] = var2;
                  }

                  var6 = this.field1407[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1407.length) {
                  int[] var12 = new int[this.field1407.length * 2];

                  for(var10 = 0; var10 < this.field1407.length; ++var10) {
                     var12[var10] = this.field1407[var10];
                  }

                  this.field1407 = var12;
               }

               var8 >>>= 1;
            }

            this.field1407[var6] = ~var3;
            if(var6 >= var2) {
               var2 = var6 + 1;
            }
         }
      }

   }
}
