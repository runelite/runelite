import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public class class113 {
   @ObfuscatedName("j")
   int[] field1941;
   @ObfuscatedName("m")
   int[] field1942;
   @ObfuscatedName("h")
   byte[] field1943;
   @ObfuscatedName("z")
   static boolean field1944;

   public class113(byte[] var1) {
      int var2 = var1.length;
      this.field1941 = new int[var2];
      this.field1943 = var1;
      int[] var3 = new int[33];
      this.field1942 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field1941[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if(0 != (var8 & var7)) {
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

            for(var10 = 1 + var6; var10 <= 32; ++var10) {
               if(var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(0 == this.field1942[var10]) {
                     this.field1942[var10] = var4;
                  }

                  var10 = this.field1942[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field1942.length) {
                  int[] var13 = new int[this.field1942.length * 2];

                  for(int var14 = 0; var14 < this.field1942.length; ++var14) {
                     var13[var14] = this.field1942[var14];
                  }

                  this.field1942 = var13;
               }

               var12 >>>= 1;
            }

            this.field1942[var10] = ~var5;
            if(var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI[BIIS)I",
      garbageValue = "0"
   )
   public int method2425(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field1942[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field1942[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field1942[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1942[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 32)) {
               var6 = this.field1942[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1942[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field1942[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1942[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 8)) {
               var6 = this.field1942[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1942[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field1942[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1942[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 2)) {
               var6 = this.field1942[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1942[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if(0 != (var8 & 1)) {
               var6 = this.field1942[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field1942[var6]) < 0) {
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BII[BII)I",
      garbageValue = "0"
   )
   public int method2431(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field1941[var8];
         byte var10 = this.field1943[var8];
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

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIIIIS)V",
      garbageValue = "10809"
   )
   static final void method2432(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class35.field771.method2034(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class35.field771.method2072(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class25.field621.field1392;
         var11 = 24624 + 4 * var1 + (103 - var2) * 2048;
         var12 = var5 >> 14 & 32767;
         class40 var13 = class85.method1903(var12);
         if(var13.field934 != -1) {
            class80 var14 = class9.field158[var13.field934];
            if(null != var14) {
               int var15 = (var13.field920 * 4 - var14.field1403) / 2;
               int var16 = (var13.field921 * 4 - var14.field1401) / 2;
               var14.method1867(var15 + var1 * 4 + 48, (104 - var2 - var13.field921) * 4 + 48 + var16);
            }
         } else {
            if(var8 == 0 || 2 == var8) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[2 + var11] = var9;
                  var10[3 + var11] = var9;
               } else if(2 == var7) {
                  var10[var11 + 3] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[1024 + 3 + var11] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[1536 + var11 + 2] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }

            if(var8 == 3) {
               if(0 == var7) {
                  var10[var11] = var9;
               } else if(1 == var7) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var11 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(2 == var8) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[1536 + var11] = var9;
               } else if(0 == var7) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[2 + var11] = var9;
                  var10[var11 + 3] = var9;
               } else if(1 == var7) {
                  var10[var11 + 3] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[3 + var11 + 1024] = var9;
                  var10[1536 + var11 + 3] = var9;
               } else if(2 == var7) {
                  var10[1536 + var11] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[1536 + var11 + 2] = var9;
                  var10[3 + 1536 + var11] = var9;
               }
            }
         }
      }

      var5 = class35.field771.method1933(var0, var1, var2);
      if(0 != var5) {
         var6 = class35.field771.method2072(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         class40 var19 = class85.method1903(var9);
         int var23;
         if(-1 != var19.field934) {
            class80 var21 = class9.field158[var19.field934];
            if(var21 != null) {
               var12 = (var19.field920 * 4 - var21.field1403) / 2;
               var23 = (var19.field921 * 4 - var21.field1401) / 2;
               var21.method1867(var12 + 48 + var1 * 4, var23 + 48 + 4 * (104 - var2 - var19.field921));
            }
         } else if(9 == var8) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class25.field621.field1392;
            var23 = var1 * 4 + 24624 + 2048 * (103 - var2);
            if(0 != var7 && var7 != 2) {
               var22[var23] = var11;
               var22[var23 + 512 + 1] = var11;
               var22[var23 + 1024 + 2] = var11;
               var22[3 + var23 + 1536] = var11;
            } else {
               var22[1536 + var23] = var11;
               var22[1 + 1024 + var23] = var11;
               var22[2 + var23 + 512] = var11;
               var22[3 + var23] = var11;
            }
         }
      }

      var5 = class35.field771.method1934(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         class40 var17 = class85.method1903(var6);
         if(-1 != var17.field934) {
            class80 var18 = class9.field158[var17.field934];
            if(null != var18) {
               var9 = (var17.field920 * 4 - var18.field1403) / 2;
               int var20 = (var17.field921 * 4 - var18.field1401) / 2;
               var18.method1867(var1 * 4 + 48 + var9, var20 + 48 + (104 - var2 - var17.field921) * 4);
            }
         }
      }

   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Lclass173;I)Ljava/lang/String;",
      garbageValue = "-267635635"
   )
   static String method2433(String var0, class173 var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = class45.method945(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var7 = "";
            if(class12.field189 != null) {
               var7 = class9.method130(class12.field189.field2197);
               if(null != class12.field189.field2194) {
                  var7 = (String)class12.field189.field2194;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }
}
