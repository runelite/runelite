import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
public class class73 {
   @ObfuscatedName("p")
   int[] field1358;
   @ObfuscatedName("s")
   int field1359;
   @ObfuscatedName("j")
   int field1360;
   @ObfuscatedName("x")
   int[] field1361;
   @ObfuscatedName("d")
   float[][] field1362;
   @ObfuscatedName("u")
   int[] field1363;

   class73() {
      class70.method1515(24);
      this.field1359 = class70.method1515(16);
      this.field1360 = class70.method1515(24);
      this.field1358 = new int[this.field1360];
      boolean var1 = class70.method1535() != 0;
      int var2;
      int var3;
      int var4;
      if(var1) {
         var2 = 0;

         for(var3 = class70.method1515(5) + 1; var2 < this.field1360; ++var3) {
            int var5 = class70.method1515(class175.method3430(this.field1360 - var2));

            for(var4 = 0; var4 < var5; ++var4) {
               this.field1358[var2++] = var3;
            }
         }
      } else {
         boolean var15 = class70.method1535() != 0;

         for(var3 = 0; var3 < this.field1360; ++var3) {
            if(var15 && class70.method1535() == 0) {
               this.field1358[var3] = 0;
            } else {
               this.field1358[var3] = class70.method1515(5) + 1;
            }
         }
      }

      this.method1555();
      var2 = class70.method1515(4);
      if(var2 > 0) {
         float var16 = class70.method1527(class70.method1515(32));
         float var6 = class70.method1527(class70.method1515(32));
         var4 = class70.method1515(4) + 1;
         boolean var7 = class70.method1535() != 0;
         int var8;
         if(var2 == 1) {
            var8 = method1561(this.field1360, this.field1359);
         } else {
            var8 = this.field1360 * this.field1359;
         }

         this.field1361 = new int[var8];

         int var9;
         for(var9 = 0; var9 < var8; ++var9) {
            this.field1361[var9] = class70.method1515(var4);
         }

         this.field1362 = new float[this.field1360][this.field1359];
         float var10;
         int var11;
         int var12;
         if(var2 == 1) {
            for(var9 = 0; var9 < this.field1360; ++var9) {
               var10 = 0.0F;
               var11 = 1;

               for(var12 = 0; var12 < this.field1359; ++var12) {
                  int var13 = var9 / var11 % var8;
                  float var14 = (float)this.field1361[var13] * var6 + var16 + var10;
                  this.field1362[var9][var12] = var14;
                  if(var7) {
                     var10 = var14;
                  }

                  var11 *= var8;
               }
            }
         } else {
            for(var9 = 0; var9 < this.field1360; ++var9) {
               var10 = 0.0F;
               var11 = var9 * this.field1359;

               for(var12 = 0; var12 < this.field1359; ++var12) {
                  float var17 = (float)this.field1361[var11] * var6 + var16 + var10;
                  this.field1362[var9][var12] = var17;
                  if(var7) {
                     var10 = var17;
                  }

                  ++var11;
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   void method1555() {
      int[] var1 = new int[this.field1360];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 0; var3 < this.field1360; ++var3) {
         var4 = this.field1358[var3];
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

      this.field1363 = new int[8];
      var10 = 0;

      for(var3 = 0; var3 < this.field1360; ++var3) {
         var4 = this.field1358[var3];
         if(var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if((var5 & var8) != 0) {
                  if(this.field1363[var6] == 0) {
                     this.field1363[var6] = var10;
                  }

                  var6 = this.field1363[var6];
               } else {
                  ++var6;
               }

               if(var6 >= this.field1363.length) {
                  int[] var11 = new int[this.field1363.length * 2];

                  for(var9 = 0; var9 < this.field1363.length; ++var9) {
                     var11[var9] = this.field1363[var9];
                  }

                  this.field1363 = var11;
               }

               var8 >>>= 1;
            }

            this.field1363[var6] = ~var3;
            if(var6 >= var10) {
               var10 = var6 + 1;
            }
         }
      }

   }

   @ObfuscatedName("p")
   int method1556() {
      int var1;
      for(var1 = 0; this.field1363[var1] >= 0; var1 = class70.method1535() != 0?this.field1363[var1]:var1 + 1) {
         ;
      }

      return ~this.field1363[var1];
   }

   @ObfuscatedName("x")
   float[] method1557() {
      return this.field1362[this.method1556()];
   }

   @ObfuscatedName("s")
   static int method1561(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; class26.method619(var2, var1) > var0; --var2) {
         ;
      }

      return var2;
   }
}
