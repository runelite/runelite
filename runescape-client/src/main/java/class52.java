import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public class class52 {
   @ObfuscatedName("w")
   float[][] field969;
   @ObfuscatedName("d")
   int field970;
   @ObfuscatedName("m")
   int[] field971;
   @ObfuscatedName("h")
   int[] field972;
   @ObfuscatedName("n")
   int field973;
   @ObfuscatedName("r")
   int[] field974;

   @ObfuscatedName("d")
   void method952() {
      int[] var1 = new int[this.field970];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field970; ++var3) {
         var4 = this.field971[var3];
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

      this.field974 = new int[8];
      int var12 = 0;

      for(var3 = 0; var3 < this.field970; ++var3) {
         var4 = this.field971[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field974[var6] == 0) {
                     this.field974[var6] = var12;
                  }

                  var6 = this.field974[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field974.length) {
                  int[] var11 = new int[this.field974.length * 2];

                  for(var10 = 0; var10 < this.field974.length; ++var10) {
                     var11[var10] = this.field974[var10];
                  }

                  this.field974 = var11;
               }

               var8 >>>= 1;
            }

            this.field974[var6] = ~var3;
            if(var6 >= var12) {
               var12 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("h")
   float[] method953() {
      return this.field969[this.method954()];
   }

   @ObfuscatedName("m")
   int method954() {
      int var1;
      for(var1 = 0; this.field974[var1] >= 0; var1 = class54.method985() != 0?this.field974[var1]:var1 + 1) {
         ;
      }

      return ~this.field974[var1];
   }

   class52() {
      class54.method992(24);
      this.field973 = class54.method992(16);
      this.field970 = class54.method992(24);
      this.field971 = new int[this.field970];
      boolean var1 = class54.method985() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class54.method992(5) + 1; var2 < this.field970; ++var3) {
            int var4 = class54.method992(class112.method2145(this.field970 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field971[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class54.method985() != 0;

         for(var3 = 0; var3 < this.field970; ++var3) {
            if(var14 && class54.method985() == 0) {
               this.field971[var3] = 0;
            } else {
               this.field971[var3] = class54.method992(5) + 1;
            }
         }
      }

      this.method952();
      var2 = class54.method992(4);
      if(var2 > 0) {
         float var15 = class54.method1005(class54.method992(32));
         float var16 = class54.method1005(class54.method992(32));
         var5 = class54.method992(4) + 1;
         boolean var6 = class54.method985() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method962(this.field970, this.field973);
         } else {
            var7 = this.field970 * this.field973;
         }

         this.field972 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field972[var8] = class54.method992(var5);
         }

         this.field969 = new float[this.field970][this.field973];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field970; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field973; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field972[var12] * var16 + var15 + var9;
                  this.field969[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field970; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field973;

               for(var11 = 0; var11 < this.field973; ++var11) {
                  float var17 = (float)this.field972[var10] * var16 + var15 + var9;
                  this.field969[var8][var11] = var17;
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
   static int method962(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; class104.method2034(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }
}
