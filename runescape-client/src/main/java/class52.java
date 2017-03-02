import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("by")
public class class52 {
   @ObfuscatedName("h")
   int[] field964;
   @ObfuscatedName("l")
   int field965;
   @ObfuscatedName("b")
   int field966;
   @ObfuscatedName("i")
   int[] field967;
   @ObfuscatedName("k")
   float[][] field968;
   @ObfuscatedName("t")
   int[] field969;

   class52() {
      class54.method1062(24);
      this.field966 = class54.method1062(16);
      this.field965 = class54.method1062(24);
      this.field967 = new int[this.field965];
      boolean var1 = class54.method1065() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class54.method1062(5) + 1; var2 < this.field965; ++var3) {
            int var4 = class54.method1062(class154.method3076(this.field965 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field967[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class54.method1065() != 0;

         for(var3 = 0; var3 < this.field965; ++var3) {
            if(var14 && class54.method1065() == 0) {
               this.field967[var3] = 0;
            } else {
               this.field967[var3] = class54.method1062(5) + 1;
            }
         }
      }

      this.method1031();
      var2 = class54.method1062(4);
      if(var2 > 0) {
         float var15 = class54.method1059(class54.method1062(32));
         float var16 = class54.method1059(class54.method1062(32));
         var5 = class54.method1062(4) + 1;
         boolean var6 = class54.method1065() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1032(this.field965, this.field966);
         } else {
            var7 = this.field965 * this.field966;
         }

         this.field969 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field969[var8] = class54.method1062(var5);
         }

         this.field968 = new float[this.field965][this.field966];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field965; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field966; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field969[var12] * var16 + var15 + var9;
                  this.field968[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field965; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field966;

               for(var11 = 0; var11 < this.field966; ++var11) {
                  float var17 = (float)this.field969[var10] * var16 + var15 + var9;
                  this.field968[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   void method1031() {
      int[] var1 = new int[this.field965];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field965; ++var3) {
         var4 = this.field967[var3];
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

      this.field964 = new int[8];
      int var11 = 0;

      for(var3 = 0; var3 < this.field965; ++var3) {
         var4 = this.field967[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field964[var6] == 0) {
                     this.field964[var6] = var11;
                  }

                  var6 = this.field964[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field964.length) {
                  int[] var12 = new int[this.field964.length * 2];

                  for(var10 = 0; var10 < this.field964.length; ++var10) {
                     var12[var10] = this.field964[var10];
                  }

                  this.field964 = var12;
               }

               var8 >>>= 1;
            }

            this.field964[var6] = ~var3;
            if(var6 >= var11) {
               var11 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("b")
   static int method1032(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; FaceNormal.method1952(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }

   @ObfuscatedName("i")
   int method1033() {
      int var1;
      for(var1 = 0; this.field964[var1] >= 0; var1 = class54.method1065() != 0?this.field964[var1]:var1 + 1) {
         ;
      }

      return ~this.field964[var1];
   }

   @ObfuscatedName("t")
   float[] method1035() {
      return this.field968[this.method1033()];
   }
}
