import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("by")
public class class52 {
   @ObfuscatedName("x")
   int field989;
   @ObfuscatedName("n")
   int field990;
   @ObfuscatedName("p")
   int[] field991;
   @ObfuscatedName("g")
   int[] field992;
   @ObfuscatedName("y")
   float[][] field993;
   @ObfuscatedName("v")
   int[] field994;

   class52() {
      class54.method1070(24);
      this.field989 = class54.method1070(16);
      this.field990 = class54.method1070(24);
      this.field992 = new int[this.field990];
      boolean var1 = class54.method1090() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class54.method1070(5) + 1; var2 < this.field990; ++var3) {
            int var4 = class54.method1070(Player.method237(this.field990 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field992[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class54.method1090() != 0;

         for(var3 = 0; var3 < this.field990; ++var3) {
            if(var14 && class54.method1090() == 0) {
               this.field992[var3] = 0;
            } else {
               this.field992[var3] = class54.method1070(5) + 1;
            }
         }
      }

      this.method1055();
      var2 = class54.method1070(4);
      if(var2 > 0) {
         float var15 = class54.method1077(class54.method1070(32));
         float var16 = class54.method1077(class54.method1070(32));
         var5 = class54.method1070(4) + 1;
         boolean var6 = class54.method1090() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method1053(this.field990, this.field989);
         } else {
            var7 = this.field990 * this.field989;
         }

         this.field994 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field994[var8] = class54.method1070(var5);
         }

         this.field993 = new float[this.field990][this.field989];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field990; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field989; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field994[var12] * var16 + var15 + var9;
                  this.field993[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field990; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field989;

               for(var11 = 0; var11 < this.field989; ++var11) {
                  float var17 = (float)this.field994[var10] * var16 + var15 + var9;
                  this.field993[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   int method1040() {
      int var1;
      for(var1 = 0; this.field991[var1] >= 0; var1 = class54.method1090() != 0?this.field991[var1]:var1 + 1) {
         ;
      }

      return ~this.field991[var1];
   }

   @ObfuscatedName("v")
   float[] method1043() {
      return this.field993[this.method1040()];
   }

   @ObfuscatedName("x")
   static int method1053(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; class159.method3151(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }

   @ObfuscatedName("n")
   void method1055() {
      int[] var1 = new int[this.field990];
      int[] var11 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field990; ++var3) {
         var4 = this.field992[var3];
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

      this.field991 = new int[8];
      int var2 = 0;

      for(var3 = 0; var3 < this.field990; ++var3) {
         var4 = this.field992[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field991[var6] == 0) {
                     this.field991[var6] = var2;
                  }

                  var6 = this.field991[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field991.length) {
                  int[] var12 = new int[this.field991.length * 2];

                  for(var10 = 0; var10 < this.field991.length; ++var10) {
                     var12[var10] = this.field991[var10];
                  }

                  this.field991 = var12;
               }

               var8 >>>= 1;
            }

            this.field991[var6] = ~var3;
            if(var6 >= var2) {
               var2 = var6 + 1;
            }
         }
      }

   }
}
