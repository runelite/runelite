import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bn")
public class class52 {
   @ObfuscatedName("j")
   float[][] field999;
   @ObfuscatedName("d")
   int field1000;
   @ObfuscatedName("q")
   int field1001;
   @ObfuscatedName("p")
   int[] field1002;
   @ObfuscatedName("n")
   int[] field1003;
   @ObfuscatedName("h")
   int[] field1004;

   class52() {
      class54.method1051(24);
      this.field1001 = class54.method1051(16);
      this.field1000 = class54.method1051(24);
      this.field1004 = new int[this.field1000];
      boolean var1 = class54.method1050() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class54.method1051(5) + 1; var2 < this.field1000; ++var3) {
            int var4 = class54.method1051(class162.method3117(this.field1000 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field1004[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class54.method1050() != 0;

         for(var3 = 0; var3 < this.field1000; ++var3) {
            if(var14 && class54.method1050() == 0) {
               this.field1004[var3] = 0;
            } else {
               this.field1004[var3] = class54.method1051(5) + 1;
            }
         }
      }

      this.method1036();
      var2 = class54.method1051(4);
      if(var2 > 0) {
         float var15 = class54.method1081(class54.method1051(32));
         float var16 = class54.method1081(class54.method1051(32));
         var5 = class54.method1051(4) + 1;
         boolean var6 = class54.method1050() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1030(this.field1000, this.field1001);
         } else {
            var7 = this.field1000 * this.field1001;
         }

         this.field1002 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field1002[var8] = class54.method1051(var5);
         }

         this.field999 = new float[this.field1000][this.field1001];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field1000; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field1001; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field1002[var12] * var16 + var15 + var9;
                  this.field999[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field1000; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field1001;

               for(var11 = 0; var11 < this.field1001; ++var11) {
                  float var17 = (float)this.field1002[var10] * var16 + var15 + var9;
                  this.field999[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   int method1027() {
      int var1;
      for(var1 = 0; this.field1003[var1] >= 0; var1 = class54.method1050() != 0?this.field1003[var1]:var1 + 1) {
         ;
      }

      return ~this.field1003[var1];
   }

   @ObfuscatedName("q")
   static int method1030(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; ChatMessages.method947(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }

   @ObfuscatedName("p")
   float[] method1032() {
      return this.field999[this.method1027()];
   }

   @ObfuscatedName("d")
   void method1036() {
      int[] var1 = new int[this.field1000];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field1000; ++var3) {
         var4 = this.field1004[var3];
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

      this.field1003 = new int[8];
      int var12 = 0;

      for(var3 = 0; var3 < this.field1000; ++var3) {
         var4 = this.field1004[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1003[var6] == 0) {
                     this.field1003[var6] = var12;
                  }

                  var6 = this.field1003[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1003.length) {
                  int[] var11 = new int[this.field1003.length * 2];

                  for(var10 = 0; var10 < this.field1003.length; ++var10) {
                     var11[var10] = this.field1003[var10];
                  }

                  this.field1003 = var11;
               }

               var8 >>>= 1;
            }

            this.field1003[var6] = ~var3;
            if(var6 >= var12) {
               var12 = var6 + 1;
            }
         }
      }

   }
}
