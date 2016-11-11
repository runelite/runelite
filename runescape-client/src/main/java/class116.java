import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public class class116 {
   @ObfuscatedName("e")
   int[] field2009;
   @ObfuscatedName("i")
   int[] field2010;
   @ObfuscatedName("h")
   byte[] field2011;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = 446908265
   )
   protected static int field2012;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = 2088124511
   )
   protected static int field2014;
   @ObfuscatedName("bs")
   static class171 field2015;
   @ObfuscatedName("aa")
   static class149 field2016;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BII[BIB)I",
      garbageValue = "5"
   )
   public int method2467(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var6 = 0;
      int var7 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var8 = var1[var2] & 255;
         int var9 = this.field2010[var8];
         byte var10 = this.field2011[var8];
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

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1752478740"
   )
   static final void method2468(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class16.method191(var0, var1, class173.plane) - var2;
         var0 -= ChatLineBuffer.cameraX;
         var3 -= class28.cameraZ;
         var1 -= class35.cameraY;
         int var4 = class94.field1623[class22.cameraPitch];
         int var5 = class94.field1642[class22.cameraPitch];
         int var6 = class94.field1623[class168.cameraYaw];
         int var7 = class94.field1642[class168.cameraYaw];
         int var8 = var1 * var6 + var7 * var0 >> 16;
         var1 = var1 * var7 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var3 * var4 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.field445 = var0 * Client.scale / var1 + Client.camera2 / 2;
            Client.field418 = Client.camera3 / 2 + var8 * Client.scale / var1;
         } else {
            Client.field445 = -1;
            Client.field418 = -1;
         }

      } else {
         Client.field445 = -1;
         Client.field418 = -1;
      }
   }

   public class116(byte[] var1) {
      int var2 = var1.length;
      this.field2010 = new int[var2];
      this.field2011 = var1;
      int[] var3 = new int[33];
      this.field2009 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if(var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field2010[var5] = var8;
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

            for(var10 = 1 + var6; var10 <= 32; ++var10) {
               if(var3[var10] == var8) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if((var8 & var12) != 0) {
                  if(this.field2009[var10] == 0) {
                     this.field2009[var10] = var4;
                  }

                  var10 = this.field2009[var10];
               } else {
                  ++var10;
               }

               if(var10 >= this.field2009.length) {
                  int[] var13 = new int[this.field2009.length * 2];

                  for(int var14 = 0; var14 < this.field2009.length; ++var14) {
                     var13[var14] = this.field2009[var14];
                  }

                  this.field2009 = var13;
               }

               var12 >>>= 1;
            }

            this.field2009[var10] = ~var5;
            if(var10 >= var4) {
               var4 = var10 + 1;
            }
         }
      }

   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "921688506"
   )
   static void method2478() {
      if(Client.field455) {
         Widget var0 = class136.method2889(WidgetNode.field65, Client.field456);
         if(var0 != null && var0.field2910 != null) {
            class0 var1 = new class0();
            var1.field13 = var0;
            var1.field8 = var0.field2910;
            class12.method155(var1);
         }

         Client.field455 = false;
         class32.method673(var0);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI[BIII)I",
      garbageValue = "1768743927"
   )
   public int method2479(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if(var5 == 0) {
         return 0;
      } else {
         int var6 = 0;
         var5 += var4;
         int var7 = var2;

         while(true) {
            byte var8 = var1[var7];
            if(var8 < 0) {
               var6 = this.field2009[var6];
            } else {
               ++var6;
            }

            int var9;
            if((var9 = this.field2009[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 64) != 0) {
               var6 = this.field2009[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2009[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 32) != 0) {
               var6 = this.field2009[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2009[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 16) != 0) {
               var6 = this.field2009[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2009[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 8) != 0) {
               var6 = this.field2009[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2009[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 4) != 0) {
               var6 = this.field2009[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2009[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 2) != 0) {
               var6 = this.field2009[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2009[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            if((var8 & 1) != 0) {
               var6 = this.field2009[var6];
            } else {
               ++var6;
            }

            if((var9 = this.field2009[var6]) < 0) {
               var3[var4++] = (byte)(~var9);
               if(var4 >= var5) {
                  break;
               }

               var6 = 0;
            }

            ++var7;
         }

         return 1 + var7 - var2;
      }
   }
}
