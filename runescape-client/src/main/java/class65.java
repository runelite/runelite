import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class65 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 470330439
   )
   int field1104;
   @ObfuscatedName("g")
   int[][] field1106;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1144095553
   )
   static int field1107;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1746295191
   )
   int field1109;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1101815995"
   )
   int method1113(int var1) {
      if(this.field1106 != null) {
         var1 = (int)((long)this.field1109 * (long)var1 / (long)this.field1104);
      }

      return var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-731490809"
   )
   int method1116(int var1) {
      if(this.field1106 != null) {
         var1 = (int)((long)var1 * (long)this.field1109 / (long)this.field1104) + 6;
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1735262723"
   )
   byte[] method1118(byte[] var1) {
      if(this.field1106 != null) {
         int var2 = (int)((long)var1.length * (long)this.field1109 / (long)this.field1104) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1106[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var8[var9] * var7;
            }

            var5 += this.field1109;
            var9 = var5 / this.field1104;
            var4 += var9;
            var5 -= var9 * this.field1104;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = '耀' + var3[var6] >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   public class65(int var1, int var2) {
      if(var2 != var1) {
         int var4 = var1;
         int var5 = var2;
         if(var2 > var1) {
            var4 = var2;
            var5 = var1;
         }

         while(var5 != 0) {
            int var6 = var4 % var5;
            var4 = var5;
            var5 = var6;
         }

         var1 /= var4;
         var2 /= var4;
         this.field1104 = var1;
         this.field1109 = var2;
         this.field1106 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1106[var7];
            double var9 = 6.0D + (double)var7 / (double)var1;
            int var11 = (int)Math.floor(var9 - 7.0D + 1.0D);
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(var9 + 7.0D);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = ((double)var11 - var9) * 3.141592653589793D;
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
               var8[var11] = (int)Math.floor(65536.0D * var17 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "531892443"
   )
   public static int method1120(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "354856192"
   )
   static final void method1121(int var0) {
      int[] var1 = class63.field1094.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 24628 + 2048 * (103 - var3);

         for(var5 = 1; var5 < 103; ++var5) {
            if((class10.tileSettings[var0][var5][var3] & 24) == 0) {
               class0.region.method1673(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class10.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               class0.region.method1673(var1, var4, 512, 1 + var0, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class63.field1094.method3961();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class10.tileSettings[var0][var6][var5] & 24) == 0) {
               class110.method2025(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class10.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               class110.method2025(1 + var0, var6, var5, var3, var4);
            }
         }
      }

      Client.field331 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class0.region.method1668(class118.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class143.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var13 = Client.collisionMaps[class118.plane].flags;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var15 == 1 && var9 < 103 && var9 < 3 + var5 && (var13[1 + var9][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < var6 + 3 && (var13[var9][1 + var10] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field525[Client.field331] = class157.field2131[var8];
                  Client.field523[Client.field331] = var9;
                  Client.field524[Client.field331] = var10;
                  ++Client.field331;
               }
            }
         }
      }

      class57.bufferProvider.method3906();
   }
}
