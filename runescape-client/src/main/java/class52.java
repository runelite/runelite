import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bb")
public class class52 {
   @ObfuscatedName("j")
   int[] field979;
   @ObfuscatedName("y")
   int field980;
   @ObfuscatedName("o")
   int[] field981;
   @ObfuscatedName("r")
   int[] field982;
   @ObfuscatedName("w")
   float[][] field983;
   @ObfuscatedName("k")
   int field984;

   class52() {
      class54.method1006(24);
      this.field984 = class54.method1006(16);
      this.field980 = class54.method1006(24);
      this.field981 = new int[this.field980];
      boolean var1 = class54.method996() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class54.method1006(5) + 1; var2 < this.field980; ++var3) {
            int var4 = class54.method1006(class104.method1989(this.field980 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field981[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class54.method996() != 0;

         for(var3 = 0; var3 < this.field980; ++var3) {
            if(var14 && class54.method996() == 0) {
               this.field981[var3] = 0;
            } else {
               this.field981[var3] = class54.method1006(5) + 1;
            }
         }
      }

      this.method968();
      var2 = class54.method1006(4);
      if(var2 > 0) {
         float var15 = class54.method1004(class54.method1006(32));
         float var16 = class54.method1004(class54.method1006(32));
         var5 = class54.method1006(4) + 1;
         boolean var6 = class54.method996() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method967(this.field980, this.field984);
         } else {
            var7 = this.field980 * this.field984;
         }

         this.field982 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field982[var8] = class54.method1006(var5);
         }

         this.field983 = new float[this.field980][this.field984];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field980; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field984; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field982[var12] * var16 + var15 + var9;
                  this.field983[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field980; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field984;

               for(var11 = 0; var11 < this.field984; ++var11) {
                  float var17 = (float)this.field982[var10] * var16 + var15 + var9;
                  this.field983[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   int method963() {
      int var1;
      for(var1 = 0; this.field979[var1] >= 0; var1 = class54.method996() != 0?this.field979[var1]:var1 + 1) {
         ;
      }

      return ~this.field979[var1];
   }

   @ObfuscatedName("r")
   float[] method964() {
      return this.field983[this.method963()];
   }

   @ObfuscatedName("k")
   static int method967(int var0, int var1) {
      int var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1;

      while(true) {
         int var4 = var2;
         int var5 = var1;

         int var6;
         for(var6 = 1; var5 > 1; var5 >>= 1) {
            if((var5 & 1) != 0) {
               var6 *= var4;
            }

            var4 *= var4;
         }

         int var3;
         if(var5 == 1) {
            var3 = var4 * var6;
         } else {
            var3 = var6;
         }

         if(var3 <= var0) {
            return var2;
         }

         --var2;
      }
   }

   @ObfuscatedName("y")
   void method968() {
      int[] var1 = new int[this.field980];
      int[] var11 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field980; ++var3) {
         var4 = this.field981[var3];
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

      this.field979 = new int[8];
      int var2 = 0;

      for(var3 = 0; var3 < this.field980; ++var3) {
         var4 = this.field981[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field979[var6] == 0) {
                     this.field979[var6] = var2;
                  }

                  var6 = this.field979[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field979.length) {
                  int[] var12 = new int[this.field979.length * 2];

                  for(var10 = 0; var10 < this.field979.length; ++var10) {
                     var12[var10] = this.field979[var10];
                  }

                  this.field979 = var12;
               }

               var8 >>>= 1;
            }

            this.field979[var6] = ~var3;
            if(var6 >= var2) {
               var2 = var6 + 1;
            }
         }
      }

   }
}
