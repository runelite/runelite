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
   @Export("__m")
   long[] __m;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1940981129
   )
   @Export("__f")
   int __f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1217137493
   )
   @Export("__q")
   int __q;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -8372744267470318611L
   )
   @Export("__w")
   long __w;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 250272357
   )
   @Export("__o")
   int __o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 576555527
   )
   @Export("__u")
   int __u;

   public MilliClock() {
      this.__m = new long[10];
      this.__f = 256;
      this.__q = 1;
      this.__o = 0;
      this.__w = class203.currentTimeMs();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.__m[var1] = this.__w;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   public void mark() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.__m[var1] = 0L;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-126803683"
   )
   public int wait(int var1, int var2) {
      int var3 = this.__f;
      int var4 = this.__q;
      this.__f = 300;
      this.__q = 1;
      this.__w = class203.currentTimeMs();
      if(0L == this.__m[this.__u]) {
         this.__f = var3;
         this.__q = var4;
      } else if(this.__w > this.__m[this.__u]) {
         this.__f = (int)((long)(var1 * 2560) / (this.__w - this.__m[this.__u]));
      }

      if(this.__f < 25) {
         this.__f = 25;
      }

      if(this.__f > 256) {
         this.__f = 256;
         this.__q = (int)((long)var1 - (this.__w - this.__m[this.__u]) / 10L);
      }

      if(this.__q > var1) {
         this.__q = var1;
      }

      this.__m[this.__u] = this.__w;
      this.__u = (this.__u + 1) % 10;
      int var5;
      if(this.__q > 1) {
         for(var5 = 0; var5 < 10; ++var5) {
            if(this.__m[var5] != 0L) {
               this.__m[var5] += (long)this.__q;
            }
         }
      }

      if(this.__q < var2) {
         this.__q = var2;
      }

      class203.method4010((long)this.__q);

      for(var5 = 0; this.__o < 256; this.__o += this.__f) {
         ++var5;
      }

      this.__o &= 255;
      return var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([Lbt;II[I[II)V",
      garbageValue = "-1374398116"
   )
   static void method3400(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].population;
                     var12 = var8.population;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].__e_144()?1:0;
                     var12 = var8.__e_144()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].population;
                     var12 = var8.population;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].__e_144()?1:0;
                     var12 = var8.__e_144()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
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
