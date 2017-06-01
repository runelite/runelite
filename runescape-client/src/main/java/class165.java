import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class165 {
   @ObfuscatedName("c")
   byte[] field2339;
   @ObfuscatedName("e")
   int[] field2340;
   @ObfuscatedName("i")
   int[] field2342;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BII[BIB)I",
      garbageValue = "63"
   )
   public int method3073(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2342[var8];
         byte var10 = this.field2339[var8];
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

   public class165(byte[] var1) {
      int var2 = var1.length;
      this.field2342 = new int[var2];
      this.field2339 = var1;
      int[] var3 = new int[33];
      this.field2340 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2342[var5] = var8;
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
                  if(var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if((var11 & var12) != 0) {
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
                  if(this.field2340[var10] == 0) {
                     this.field2340[var10] = var4;
                  }

                  var10 = this.field2340[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2340.length) {
                  int[] var13 = new int[this.field2340.length * 2];

                  for(int var14 = 0; var14 < this.field2340.length; ++var14) {
                     var13[var14] = this.field2340[var14];
                  }

                  this.field2340 = var13;
               }

               var12 >>>= 1;
            }

            this.field2340[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "702949005"
   )
   public int method3077(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2340[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2340[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2340[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2340[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2340[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2340[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2340[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2340[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2340[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2340[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2340[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2340[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2340[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2340[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2340[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2340[var6]) < 0) {
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

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "14"
   )
   static final void method3078(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class76 var9 = null;

      for(class76 var10 = (class76)Client.field979.method3576(); var10 != null; var10 = (class76)Client.field979.method3578()) {
         if(var0 == var10.field1225 && var10.field1217 == var1 && var10.field1224 == var2 && var10.field1216 == var3) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class76();
         var9.field1225 = var0;
         var9.field1216 = var3;
         var9.field1217 = var1;
         var9.field1224 = var2;
         class67.method1083(var9);
         Client.field979.method3571(var9);
      }

      var9.field1227 = var4;
      var9.field1215 = var5;
      var9.field1223 = var6;
      var9.field1219 = var7;
      var9.field1226 = var8;
   }
}
