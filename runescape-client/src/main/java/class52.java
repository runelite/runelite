import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bt")
public class class52 {
   @ObfuscatedName("f")
   int[] field975;
   @ObfuscatedName("c")
   int field976;
   @ObfuscatedName("h")
   int[] field977;
   @ObfuscatedName("s")
   int field978;
   @ObfuscatedName("a")
   float[][] field979;
   @ObfuscatedName("g")
   int[] field980;

   @ObfuscatedName("g")
   float[] method904() {
      return this.field979[this.method907()];
   }

   class52() {
      class54.method927(24);
      this.field978 = class54.method927(16);
      this.field976 = class54.method927(24);
      this.field975 = new int[this.field976];
      boolean var1 = class54.method926() != 0;
      int var2;
      int var3;
      int var5;
      if(var1) {
         var2 = 0;

         for(var3 = class54.method927(5) + 1; var2 < this.field976; ++var3) {
            int var4 = class54.method927(Projectile.method763(this.field976 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field975[var2++] = var3;
            }
         }
      } else {
         boolean var14 = class54.method926() != 0;

         for(var3 = 0; var3 < this.field976; ++var3) {
            if(var14 && class54.method926() == 0) {
               this.field975[var3] = 0;
            } else {
               this.field975[var3] = class54.method927(5) + 1;
            }
         }
      }

      this.method905();
      var2 = class54.method927(4);
      if(var2 > 0) {
         float var15 = class54.method937(class54.method927(32));
         float var16 = class54.method937(class54.method927(32));
         var5 = class54.method927(4) + 1;
         boolean var6 = class54.method926() != 0;
         int var7;
         if(var2 == 1) {
            var7 = method906(this.field976, this.field978);
         } else {
            var7 = this.field976 * this.field978;
         }

         this.field977 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field977[var8] = class54.method927(var5);
         }

         this.field979 = new float[this.field976][this.field978];
         float var9;
         int var10;
         int var11;
         if(var2 == 1) {
            for(var8 = 0; var8 < this.field976; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field978; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field977[var12] * var16 + var15 + var9;
                  this.field979[var8][var11] = var13;
                  if(var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field976; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field978;

               for(var11 = 0; var11 < this.field978; ++var11) {
                  float var17 = (float)this.field977[var10] * var16 + var15 + var9;
                  this.field979[var8][var11] = var17;
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
   void method905() {
      int[] var1 = new int[this.field976];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field976; ++var3) {
         var4 = this.field975[var3];
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

      this.field980 = new int[8];
      int var11 = 0;

      for(var3 = 0; var3 < this.field976; ++var3) {
         var4 = this.field975[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field980[var6] == 0) {
                     this.field980[var6] = var11;
                  }

                  var6 = this.field980[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field980.length) {
                  int[] var12 = new int[this.field980.length * 2];

                  for(var10 = 0; var10 < this.field980.length; ++var10) {
                     var12[var10] = this.field980[var10];
                  }

                  this.field980 = var12;
               }

               var8 >>>= 1;
            }

            this.field980[var6] = ~var3;
            if(var6 >= var11) {
               var11 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("s")
   static int method906(int var0, int var1) {
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

   @ObfuscatedName("f")
   int method907() {
      int var1;
      for(var1 = 0; this.field980[var1] >= 0; var1 = class54.method926() != 0?this.field980[var1]:var1 + 1) {
         ;
      }

      return ~this.field980[var1];
   }
}
