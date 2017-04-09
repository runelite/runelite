import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bc")
public class class52 {
   @ObfuscatedName("h")
   int[] field1000;
   @ObfuscatedName("i")
   int field1001;
   @ObfuscatedName("u")
   int[] field1002;
   @ObfuscatedName("f")
   int field1003;
   @ObfuscatedName("r")
   float[][] field1004;
   @ObfuscatedName("o")
   int[] field1005;

   class52() {
      class54.method1021(24);
      this.field1003 = class54.method1021(16);
      this.field1001 = class54.method1021(24);
      this.field1002 = new int[this.field1001];
      boolean var1 = class54.method1020() != 0;
      int var2;
      int var3;
      int var4;
      if(var1) {
         var2 = 0;

         for(var3 = class54.method1021(5) + 1; var2 < this.field1001; ++var3) {
            int var5 = class54.method1021(RSCanvas.method2131(this.field1001 - var2));

            for(var4 = 0; var4 < var5; ++var4) {
               this.field1002[var2++] = var3;
            }
         }
      } else {
         boolean var15 = class54.method1020() != 0;

         for(var3 = 0; var3 < this.field1001; ++var3) {
            if(var15 && class54.method1020() == 0) {
               this.field1002[var3] = 0;
            } else {
               this.field1002[var3] = class54.method1021(5) + 1;
            }
         }
      }

      this.method987();
      var2 = class54.method1021(4);
      if(var2 > 0) {
         float var16 = class54.method1024(class54.method1021(32));
         float var6 = class54.method1024(class54.method1021(32));
         var4 = class54.method1021(4) + 1;
         boolean var7 = class54.method1020() != 0;
         int var8;
         if(var2 == 1) {
            var8 = method991(this.field1001, this.field1003);
         } else {
            var8 = this.field1001 * this.field1003;
         }

         this.field1000 = new int[var8];

         int var9;
         for(var9 = 0; var9 < var8; ++var9) {
            this.field1000[var9] = class54.method1021(var4);
         }

         this.field1004 = new float[this.field1001][this.field1003];
         float var10;
         int var11;
         int var12;
         if(var2 == 1) {
            for(var9 = 0; var9 < this.field1001; ++var9) {
               var10 = 0.0F;
               var11 = 1;

               for(var12 = 0; var12 < this.field1003; ++var12) {
                  int var13 = var9 / var11 % var8;
                  float var14 = (float)this.field1000[var13] * var6 + var16 + var10;
                  this.field1004[var9][var12] = var14;
                  if(var7) {
                     var10 = var14;
                  }

                  var11 *= var8;
               }
            }
         } else {
            for(var9 = 0; var9 < this.field1001; ++var9) {
               var10 = 0.0F;
               var11 = var9 * this.field1003;

               for(var12 = 0; var12 < this.field1003; ++var12) {
                  float var17 = (float)this.field1000[var11] * var6 + var16 + var10;
                  this.field1004[var9][var12] = var17;
                  if(var7) {
                     var10 = var17;
                  }

                  ++var11;
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   void method987() {
      int[] var1 = new int[this.field1001];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 0; var3 < this.field1001; ++var3) {
         var4 = this.field1002[var3];
         if(var4 != 0) {
            var5 = 1 << 32 - var4;
            var6 = var2[var4];
            var1[var3] = var6;
            if((var6 & var5) != 0) {
               var7 = var2[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var10 = var2[var8];
                  if(var10 != var6) {
                     break;
                  }

                  var9 = 1 << 32 - var8;
                  if((var10 & var9) != 0) {
                     var2[var8] = var2[var8 - 1];
                     break;
                  }

                  var2[var8] = var10 | var9;
               }
            }

            var2[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; ++var8) {
               var10 = var2[var8];
               if(var10 == var6) {
                  var2[var8] = var7;
               }
            }
         }
      }

      this.field1005 = new int[8];
      var10 = 0;

      for(var3 = 0; var3 < this.field1001; ++var3) {
         var4 = this.field1002[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1005[var6] == 0) {
                     this.field1005[var6] = var10;
                  }

                  var6 = this.field1005[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1005.length) {
                  int[] var11 = new int[this.field1005.length * 2];

                  for(var9 = 0; var9 < this.field1005.length; ++var9) {
                     var11[var9] = this.field1005[var9];
                  }

                  this.field1005 = var11;
               }

               var8 >>>= 1;
            }

            this.field1005[var6] = ~var3;
            if(var6 >= var10) {
               var10 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("u")
   int method988() {
      int var1;
      for(var1 = 0; this.field1005[var1] >= 0; var1 = class54.method1020() != 0?this.field1005[var1]:var1 + 1) {
         ;
      }

      return ~this.field1005[var1];
   }

   @ObfuscatedName("f")
   static int method991(int var0, int var1) {
      int var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1;

      while(true) {
         int var3 = var2;
         int var4 = var1;

         int var5;
         for(var5 = 1; var4 > 1; var4 >>= 1) {
            if((var4 & 1) != 0) {
               var5 *= var3;
            }

            var3 *= var3;
         }

         int var6;
         if(var4 == 1) {
            var6 = var5 * var3;
         } else {
            var6 = var5;
         }

         if(var6 <= var0) {
            return var2;
         }

         --var2;
      }
   }

   @ObfuscatedName("r")
   float[] method997() {
      return this.field1004[this.method988()];
   }
}
