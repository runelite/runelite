import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bu")
public class class52 {
   @ObfuscatedName("c")
   int field967;
   @ObfuscatedName("p")
   int[] field968;
   @ObfuscatedName("n")
   int[] field969;
   @ObfuscatedName("q")
   int[] field970;
   @ObfuscatedName("t")
   float[][] field971;
   @ObfuscatedName("d")
   int field972;

   @ObfuscatedName("n")
   int method977() {
      int var1;
      for(var1 = 0; this.field968[var1] >= 0; var1 = class54.method1005() != 0?this.field968[var1]:var1 + 1) {
         ;
      }

      return ~this.field968[var1];
   }

   class52() {
      class54.method1004(24);
      this.field972 = class54.method1004(16);
      this.field967 = class54.method1004(24);
      this.field969 = new int[this.field967];
      boolean var1 = class54.method1005() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class54.method1004(5) + 1; var2 < this.field967; ++var3) {
            int var4 = class54.method1004(Friend.method183(this.field967 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field969[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class54.method1005() != 0;

         for(var3 = 0; var3 < this.field967; ++var3) {
            if(var14 && class54.method1005() == 0) {
               this.field969[var3] = 0;
            } else {
               this.field969[var3] = class54.method1004(5) + 1;
            }
         }
      }

      this.method978();
      var2 = class54.method1004(4);
      if(var2 > 0) {
         float var15 = class54.method1010(class54.method1004(32));
         float var16 = class54.method1010(class54.method1004(32));
         var5 = class54.method1004(4) + 1;
         boolean var6 = class54.method1005() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method987(this.field967, this.field972);
         } else {
            var7 = this.field967 * this.field972;
         }

         this.field970 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field970[var8] = class54.method1004(var5);
         }

         this.field971 = new float[this.field967][this.field972];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field967; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field972; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field970[var12] * var16 + var15 + var9;
                  this.field971[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field967; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field972;

               for(var11 = 0; var11 < this.field972; ++var11) {
                  float var17 = (float)this.field970[var10] * var16 + var15 + var9;
                  this.field971[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   void method978() {
      int[] var1 = new int[this.field967];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field967; ++var3) {
         var4 = this.field969[var3];
         if(var4 != 0) {
            var5 = 1 << 32 - var4;
            var6 = var2[var4];
            var1[var3] = var6;
            int var11;
            if((var6 & var5) != 0) {
               var7 = var2[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var11 = var2[var8];
                  if(var11 != var6) {
                     break;
                  }

                  var10 = 1 << 32 - var8;
                  if((var11 & var10) != 0) {
                     var2[var8] = var2[var8 - 1];
                     break;
                  }

                  var2[var8] = var11 | var10;
               }
            }

            var2[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; ++var8) {
               var11 = var2[var8];
               if(var11 == var6) {
                  var2[var8] = var7;
               }
            }
         }
      }

      this.field968 = new int[8];
      int var12 = 0;

      for(var3 = 0; var3 < this.field967; ++var3) {
         var4 = this.field969[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field968[var6] == 0) {
                     this.field968[var6] = var12;
                  }

                  var6 = this.field968[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field968.length) {
                  int[] var9 = new int[this.field968.length * 2];

                  for(var10 = 0; var10 < this.field968.length; ++var10) {
                     var9[var10] = this.field968[var10];
                  }

                  this.field968 = var9;
               }

               var8 >>>= 1;
            }

            this.field968[var6] = ~var3;
            if(var6 >= var12) {
               var12 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("q")
   float[] method980() {
      return this.field971[this.method977()];
   }

   @ObfuscatedName("d")
   static int method987(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; RSCanvas.method2097(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }
}
