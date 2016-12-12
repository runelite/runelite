import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bq")
public class class52 {
   @ObfuscatedName("i")
   int field978;
   @ObfuscatedName("k")
   int[] field979;
   @ObfuscatedName("f")
   int[] field980;
   @ObfuscatedName("e")
   int field981;
   @ObfuscatedName("g")
   float[][] field982;
   @ObfuscatedName("n")
   int[] field983;

   @ObfuscatedName("e")
   void method923() {
      int[] var1 = new int[this.field981];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field981; ++var3) {
         var4 = this.field980[var3];
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

      this.field983 = new int[8];
      int var12 = 0;

      for(var3 = 0; var3 < this.field981; ++var3) {
         var4 = this.field980[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field983[var6] == 0) {
                     this.field983[var6] = var12;
                  }

                  var6 = this.field983[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field983.length) {
                  int[] var11 = new int[this.field983.length * 2];

                  for(var10 = 0; var10 < this.field983.length; ++var10) {
                     var11[var10] = this.field983[var10];
                  }

                  this.field983 = var11;
               }

               var8 >>>= 1;
            }

            this.field983[var6] = ~var3;
            if(var6 >= var12) {
               var12 = var6 + 1;
            }
         }
      }

   }

   class52() {
      class54.method953(24);
      this.field978 = class54.method953(16);
      this.field981 = class54.method953(24);
      this.field980 = new int[this.field981];
      boolean var1 = class54.method978() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class54.method953(5) + 1; var2 < this.field981; ++var3) {
            int var4 = class54.method953(class45.method801(this.field981 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field980[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class54.method978() != 0;

         for(var3 = 0; var3 < this.field981; ++var3) {
            if(var14 && class54.method978() == 0) {
               this.field980[var3] = 0;
            } else {
               this.field980[var3] = class54.method953(5) + 1;
            }
         }
      }

      this.method923();
      var2 = class54.method953(4);
      if(var2 > 0) {
         float var15 = class54.method954(class54.method953(32));
         float var16 = class54.method954(class54.method953(32));
         var5 = class54.method953(4) + 1;
         boolean var6 = class54.method978() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method935(this.field981, this.field978);
         } else {
            var7 = this.field981 * this.field978;
         }

         this.field979 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field979[var8] = class54.method953(var5);
         }

         this.field982 = new float[this.field981][this.field978];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field981; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field978; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field979[var12] * var16 + var15 + var9;
                  this.field982[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field981; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field978;

               for(var11 = 0; var11 < this.field978; ++var11) {
                  float var17 = (float)this.field979[var10] * var16 + var15 + var9;
                  this.field982[var8][var11] = var17;
                  if(var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   int method926() {
      int var1;
      for(var1 = 0; this.field983[var1] >= 0; var1 = class54.method978() != 0?this.field983[var1]:var1 + 1) {
         ;
      }

      return ~this.field983[var1];
   }

   @ObfuscatedName("k")
   float[] method933() {
      return this.field982[this.method926()];
   }

   @ObfuscatedName("i")
   static int method935(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; class16.method182(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }
}
