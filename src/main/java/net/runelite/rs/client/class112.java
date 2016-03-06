package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dl")
public class class112 {
   @ObfuscatedName("l")
   byte[] field1961;
   @ObfuscatedName("j")
   int[] field1962;
   @ObfuscatedName("a")
   int[] field1963;

   @ObfuscatedName("dk")
   static void method2390(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class51.field1115; ++var4) {
         class51 var5 = class22.method581(var4);
         if((!var1 || var5.field1159) && var5.field1152 == -1 && var5.field1121.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class213.field3145 = -1;
               class15.field224 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class15.field224 = var2;
      class36.field798 = 0;
      class213.field3145 = var3;
      String[] var8 = new String[class213.field3145];

      for(int var9 = 0; var9 < class213.field3145; ++var9) {
         var8[var9] = class22.method581(var2[var9]).field1121;
      }

      class11.method135(var8, class15.field224);
   }

   @ObfuscatedName("j")
   public int method2391(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field1962[var8];
         byte var10 = this.field1961[var8];
         if(var10 == 0) {
            throw new RuntimeException("");
         }

         int var11 = var7 >> 3;
         int var12 = var7 & 7;
         var6 &= -var12 >> 31;
         int var13 = (var12 + var10 - 1 >> 3) + var11;
         var12 += 24;
         var4[var11] = (byte)(var6 |= var9 >>> var12);
         if(var11 < var13) {
            ++var11;
            var12 -= 8;
            var4[var11] = (byte)(var6 = var9 >>> var12);
            if(var11 < var13) {
               ++var11;
               var12 -= 8;
               var4[var11] = (byte)(var6 = var9 >>> var12);
               if(var11 < var13) {
                  ++var11;
                  var12 -= 8;
                  var4[var11] = (byte)(var6 = var9 >>> var12);
                  if(var11 < var13) {
                     ++var11;
                     var12 -= 8;
                     var4[var11] = (byte)(var6 = var9 << -var12);
                  }
               }
            }
         }

         var7 += var10;
      }

      return (var7 + 7 >> 3) - var5;
   }

   @ObfuscatedName("l")
   public int method2392(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(0 == var5) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field1963[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field1963[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 64)) {
               var6 = this.field1963[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1963[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field1963[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1963[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 16)) {
               var6 = this.field1963[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1963[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 8)) {
               var6 = this.field1963[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1963[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 4)) {
               var6 = this.field1963[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1963[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field1963[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1963[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field1963[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1963[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return var7 + 1 - var2;
      }
   }

   public class112(byte[] var1) {
      int var2 = var1.length;
      this.field1962 = new int[var2];
      this.field1961 = var1;
      int[] var3 = new int[33];
      this.field1963 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field1962[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if(var8 != var11) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if(0 != (var11 & var12)) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = var6 + 1; var10 <= 32; ++var10) {
               if(var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.field1963[var10] == 0) {
                     this.field1963[var10] = var4;
                  }

                  var10 = this.field1963[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field1963.length) {
                  int[] var13 = new int[2 * this.field1963.length];

                  for(int var14 = 0; var14 < this.field1963.length; ++var14) {
                     var13[var14] = this.field1963[var14];
                  }

                  this.field1963 = var13;
               }

               var12 >>>= 1;
            }

            this.field1963[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }
}
