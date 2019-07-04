import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("MilliClock")
public class MilliClock extends Clock {
   @ObfuscatedName("qi")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   @Export("decimator")
   static Decimator decimator;
   @ObfuscatedName("m")
   long[] field517;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1940981129
   )
   int field518;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1217137493
   )
   int field519;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -8372744267470318611L
   )
   long field520;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 250272357
   )
   int field521;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 576555527
   )
   int field522;

   public MilliClock() {
      this.field517 = new long[10];
      this.field518 = 256;
      this.field519 = 1;
      this.field521 = 0;
      this.field520 = class203.currentTimeMs();

      for (int var1 = 0; var1 < 10; ++var1) {
         this.field517[var1] = this.field520;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   @Export("mark")
   public void mark() {
      for (int var1 = 0; var1 < 10; ++var1) {
         this.field517[var1] = 0L;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-126803683"
   )
   @Export("wait")
   public int wait(int var1, int var2) {
      int var3 = this.field518;
      int var4 = this.field519;
      this.field518 = 300;
      this.field519 = 1;
      this.field520 = class203.currentTimeMs();
      if (0L == this.field517[this.field522]) {
         this.field518 = var3;
         this.field519 = var4;
      } else if (this.field520 > this.field517[this.field522]) {
         this.field518 = (int)((long)(var1 * 2560) / (this.field520 - this.field517[this.field522]));
      }

      if (this.field518 < 25) {
         this.field518 = 25;
      }

      if (this.field518 > 256) {
         this.field518 = 256;
         this.field519 = (int)((long)var1 - (this.field520 - this.field517[this.field522]) / 10L);
      }

      if (this.field519 > var1) {
         this.field519 = var1;
      }

      this.field517[this.field522] = this.field520;
      this.field522 = (this.field522 + 1) % 10;
      int var5;
      if (this.field519 > 1) {
         for (var5 = 0; var5 < 10; ++var5) {
            if (this.field517[var5] != 0L) {
               long[] var10000 = this.field517;
               var10000[var5] += (long)this.field519;
            }
         }
      }

      if (this.field519 < var2) {
         this.field519 = var2;
      }

      class203.method4010((long)this.field519);

      for (var5 = 0; this.field521 < 256; this.field521 += this.field518) {
         ++var5;
      }

      this.field521 &= 255;
      return var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([Lbt;II[I[II)V",
      garbageValue = "-1374398116"
   )
   static void method3400(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if (var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while (var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for (var10 = 0; var10 < 4; ++var10) {
                  if (var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if (var3[var10] == 1) {
                     var11 = var0[var6].population;
                     var12 = var8.population;
                     if (var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if (var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if (var3[var10] == 3) {
                     var11 = var0[var6].isMembersOnly() ? 1 : 0;
                     var12 = var8.isMembersOnly() ? 1 : 0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if (var12 != var11) {
                     if ((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if (var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for (var10 = 0; var10 < 4; ++var10) {
                  if (var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if (var3[var10] == 1) {
                     var11 = var0[var5].population;
                     var12 = var8.population;
                     if (var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if (var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if (var3[var10] == 3) {
                     var11 = var0[var5].isMembersOnly() ? 1 : 0;
                     var12 = var8.isMembersOnly() ? 1 : 0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if (var11 != var12) {
                     if ((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if (var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if (var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method3400(var0, var1, var6, var3, var4);
         method3400(var0, var6 + 1, var2, var3, var4);
      }

   }
}
