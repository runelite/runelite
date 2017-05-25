import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public class class204 extends class119 {
   @ObfuscatedName("k")
   int[] field2506;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 376946961
   )
   int field2507;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1100365439
   )
   int field2508;
   @ObfuscatedName("q")
   int[] field2509;
   @ObfuscatedName("g")
   int[] field2510;
   @ObfuscatedName("v")
   int[] field2511;
   @ObfuscatedName("t")
   int[] field2512;
   @ObfuscatedName("p")
   int[] field2513;
   @ObfuscatedName("w")
   int[] field2514;
   @ObfuscatedName("az")
   boolean field2515;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      longValue = -7591417700525107067L
   )
   long field2516;
   @ObfuscatedName("r")
   int[] field2517;
   @ObfuscatedName("s")
   int[] field2518;
   @ObfuscatedName("l")
   int[] field2519;
   @ObfuscatedName("y")
   int[] field2520;
   @ObfuscatedName("i")
   XHashTable field2521;
   @ObfuscatedName("f")
   int[] field2522;
   @ObfuscatedName("ax")
   class208 field2523;
   @ObfuscatedName("z")
   class205[][] field2524;
   @ObfuscatedName("ay")
   class205[][] field2525;
   @ObfuscatedName("n")
   int[] field2526;
   @ObfuscatedName("c")
   int[] field2527;
   @ObfuscatedName("ah")
   class206 field2528;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1495876027
   )
   int field2529;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      longValue = -25234330110281353L
   )
   long field2530;
   @ObfuscatedName("a")
   int[] field2531;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 666952529
   )
   int field2532;
   @ObfuscatedName("cd")
   static class153 field2533;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1053654989"
   )
   synchronized void method3754(int var1) {
      this.field2507 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "78"
   )
   int method3755() {
      return this.field2507;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-953081028"
   )
   void method3756(int var1, int var2, int var3) {
      class205 var4 = this.field2524[var1][var2];
      if(var4 != null) {
         this.field2524[var1][var2] = null;
         if((this.field2518[var1] & 2) != 0) {
            for(class205 var5 = (class205)this.field2523.field2582.method3660(); var5 != null; var5 = (class205)this.field2523.field2582.method3661()) {
               if(var4.field2544 == var5.field2544 && var5.field2541 < 0 && var4 != var5) {
                  var4.field2541 = 0;
                  break;
               }
            }
         } else {
            var4.field2541 = 0;
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2023760555"
   )
   synchronized void method3758() {
      for(class207 var1 = (class207)this.field2521.method3606(); var1 != null; var1 = (class207)this.field2521.method3607()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LTrack1;ZS)V",
      garbageValue = "12919"
   )
   synchronized void method3759(Track1 var1, boolean var2) {
      this.method3801();
      this.field2528.method3896(var1.field2585);
      this.field2515 = var2;
      this.field2530 = 0L;
      int var3 = this.field2528.method3894();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2528.method3906(var4);
         this.field2528.method3898(var4);
         this.field2528.method3891(var4);
      }

      this.field2532 = this.field2528.method3911();
      this.field2529 = this.field2528.field2559[this.field2532];
      this.field2516 = this.field2528.method3902(this.field2529);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1059032149"
   )
   public synchronized void method3762(int var1, int var2) {
      this.method3856(var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-67"
   )
   void method3764(int var1, int var2) {
      if(var2 != this.field2513[var1]) {
         this.field2513[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2525[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "100"
   )
   void method3765(int var1, int var2, int var3) {
      this.method3756(var1, var2, 64);
      if((this.field2518[var1] & 2) != 0) {
         for(class205 var4 = (class205)this.field2523.field2582.method3666(); var4 != null; var4 = (class205)this.field2523.field2582.method3662()) {
            if(var4.field2544 == var1 && var4.field2541 < 0) {
               this.field2524[var1][var4.field2534] = null;
               this.field2524[var1][var2] = var4;
               int var5 = var4.field2539 + (var4.field2538 * var4.field2543 >> 12);
               var4.field2539 += var2 - var4.field2534 << 8;
               var4.field2543 = var5 - var4.field2539;
               var4.field2538 = 4096;
               var4.field2534 = var2;
               return;
            }
         }
      }

      class207 var9 = (class207)this.field2521.method3615((long)this.field2513[var1]);
      if(var9 != null) {
         class107 var8 = var9.field2570[var2];
         if(var8 != null) {
            class205 var6 = new class205();
            var6.field2544 = var1;
            var6.field2535 = var9;
            var6.field2537 = var8;
            var6.field2540 = var9.field2574[var2];
            var6.field2551 = var9.field2575[var2];
            var6.field2534 = var2;
            var6.field2536 = var9.field2572[var2] * var3 * var3 * var9.field2573 + 1024 >> 11;
            var6.field2542 = var9.field2577[var2] & 255;
            var6.field2539 = (var2 << 8) - (var9.field2571[var2] & 32767);
            var6.field2545 = 0;
            var6.field2546 = 0;
            var6.field2547 = 0;
            var6.field2541 = -1;
            var6.field2549 = 0;
            if(this.field2514[var1] == 0) {
               var6.field2552 = class117.method2271(var8, this.method3779(var6), this.method3780(var6), this.method3781(var6));
            } else {
               var6.field2552 = class117.method2271(var8, this.method3779(var6), 0, this.method3781(var6));
               this.method3858(var6, var9.field2571[var2] < 0);
            }

            if(var9.field2571[var2] < 0) {
               var6.field2552.method2160(-1);
            }

            if(var6.field2551 >= 0) {
               class205 var7 = this.field2525[var1][var6.field2551];
               if(var7 != null && var7.field2541 < 0) {
                  this.field2524[var1][var7.field2534] = null;
                  var7.field2541 = 0;
               }

               this.field2525[var1][var6.field2551] = var6;
            }

            this.field2523.field2582.method3655(var6);
            this.field2524[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "200214968"
   )
   void method3766() {
      this.method3771(-1);
      this.method3772(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2513[var1] = this.field2512[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2519[var1] = this.field2512[var1] & -128;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2004024895"
   )
   void method3768(int var1, int var2, int var3) {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "7"
   )
   void method3769(int var1, int var2) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-26"
   )
   void method3770(int var1, int var2) {
      this.field2531[var1] = var2;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "355181585"
   )
   void method3771(int var1) {
      for(class205 var2 = (class205)this.field2523.field2582.method3660(); var2 != null; var2 = (class205)this.field2523.field2582.method3661()) {
         if(var1 < 0 || var2.field2544 == var1) {
            if(var2.field2552 != null) {
               var2.field2552.method2170(class109.field1628 / 100);
               if(var2.field2552.method2174()) {
                  this.field2523.field2583.method1936(var2.field2552);
               }

               var2.method3886();
            }

            if(var2.field2541 < 0) {
               this.field2524[var2.field2544][var2.field2534] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "56"
   )
   void method3772(int var1) {
      if(var1 >= 0) {
         this.field2509[var1] = 12800;
         this.field2510[var1] = 8192;
         this.field2511[var1] = 16383;
         this.field2531[var1] = 8192;
         this.field2506[var1] = 0;
         this.field2517[var1] = 8192;
         this.method3775(var1);
         this.method3776(var1);
         this.field2518[var1] = 0;
         this.field2526[var1] = 32767;
         this.field2520[var1] = 256;
         this.field2514[var1] = 0;
         this.method3834(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3772(var1);
         }

      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-41611195"
   )
   void method3773(int var1) {
      for(class205 var2 = (class205)this.field2523.field2582.method3660(); var2 != null; var2 = (class205)this.field2523.field2582.method3661()) {
         if((var1 < 0 || var2.field2544 == var1) && var2.field2541 < 0) {
            this.field2524[var2.field2544][var2.field2534] = null;
            var2.field2541 = 0;
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-239927706"
   )
   void method3775(int var1) {
      if((this.field2518[var1] & 2) != 0) {
         for(class205 var2 = (class205)this.field2523.field2582.method3660(); var2 != null; var2 = (class205)this.field2523.field2582.method3661()) {
            if(var2.field2544 == var1 && this.field2524[var1][var2.field2534] == null && var2.field2541 < 0) {
               var2.field2541 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1787820012"
   )
   void method3776(int var1) {
      if((this.field2518[var1] & 4) != 0) {
         for(class205 var2 = (class205)this.field2523.field2582.method3660(); var2 != null; var2 = (class205)this.field2523.field2582.method3661()) {
            if(var1 == var2.field2544) {
               var2.field2554 = 0;
            }
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "128"
   )
   void method3777(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3756(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3765(var3, var4, var5);
         } else {
            this.method3756(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3768(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2519[var3] = (var5 << 14) + (this.field2519[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2519[var3] = (this.field2519[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 1) {
            this.field2506[var3] = (var5 << 7) + (this.field2506[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2506[var3] = (this.field2506[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field2517[var3] = (this.field2517[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field2517[var3] = (this.field2517[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field2509[var3] = (this.field2509[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field2509[var3] = (this.field2509[var3] & -128) + var5;
         }

         if(var4 == 10) {
            this.field2510[var3] = (this.field2510[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field2510[var3] = (this.field2510[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field2511[var3] = (var5 << 7) + (this.field2511[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2511[var3] = var5 + (this.field2511[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2518[var3] |= 1;
            } else {
               this.field2518[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2518[var3] |= 2;
            } else {
               this.method3775(var3);
               this.field2518[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2526[var3] = (this.field2526[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field2526[var3] = (this.field2526[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2526[var3] = (var5 << 7) + (this.field2526[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2526[var3] = (this.field2526[var3] & 16256) + 16384 + var5;
         }

         if(var4 == 120) {
            this.method3771(var3);
         }

         if(var4 == 121) {
            this.method3772(var3);
         }

         if(var4 == 123) {
            this.method3773(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2526[var3];
            if(var6 == 16384) {
               this.field2520[var3] = (this.field2520[var3] & -16257) + (var5 << 7);
            }
         }

         if(var4 == 38) {
            var6 = this.field2526[var3];
            if(var6 == 16384) {
               this.field2520[var3] = var5 + (this.field2520[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2514[var3] = (this.field2514[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 48) {
            this.field2514[var3] = var5 + (this.field2514[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2518[var3] |= 4;
            } else {
               this.method3776(var3);
               this.field2518[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3834(var3, (this.field2522[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method3834(var3, var5 + (this.field2522[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3764(var3, this.field2519[var3] + var4);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3769(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method3770(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3766();
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "-1105337628"
   )
   int method3779(class205 var1) {
      int var2 = var1.field2539 + (var1.field2543 * var1.field2538 >> 12);
      var2 += (this.field2531[var1.field2544] - 8192) * this.field2520[var1.field2544] >> 12;
      class202 var3 = var1.field2540;
      int var4;
      if(var3.field2493 > 0 && (var3.field2491 > 0 || this.field2506[var1.field2544] > 0)) {
         var4 = var3.field2491 << 2;
         int var5 = var3.field2494 << 1;
         if(var1.field2550 < var5) {
            var4 = var4 * var1.field2550 / var5;
         }

         var4 += this.field2506[var1.field2544] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2548 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2537.field1605 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class109.field1628 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "-513242618"
   )
   int method3780(class205 var1) {
      class202 var2 = var1.field2540;
      int var3 = this.field2511[var1.field2544] * this.field2509[var1.field2544] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var1.field2536 * var3 + 16384 >> 15;
      var3 = this.field2507 * var3 + 128 >> 8;
      if(var2.field2488 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field2545 * 1.953125E-5D * (double)var2.field2488) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2492 != null) {
         var4 = var1.field2546;
         var5 = var2.field2492[var1.field2547 + 1];
         if(var1.field2547 < var2.field2492.length - 2) {
            var6 = (var2.field2492[var1.field2547] & 255) << 8;
            var7 = (var2.field2492[var1.field2547 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2492[var1.field2547 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2541 > 0 && var2.field2487 != null) {
         var4 = var1.field2541;
         var5 = var2.field2487[var1.field2549 + 1];
         if(var1.field2549 < var2.field2487.length - 2) {
            var6 = (var2.field2487[var1.field2549] & 255) << 8;
            var7 = (var2.field2487[var1.field2549 + 2] & 255) << 8;
            var5 += (var2.field2487[var1.field2549 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "-1144899245"
   )
   int method3781(class205 var1) {
      int var2 = this.field2510[var1.field2544];
      return var2 < 8192?var1.field2542 * var2 + 32 >> 6:16384 - ((128 - var1.field2542) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("p")
   protected synchronized int vmethod3946() {
      return 0;
   }

   @ObfuscatedName("l")
   protected synchronized void vmethod3949(int[] var1, int var2, int var3) {
      if(this.field2528.method3890()) {
         int var4 = this.field2508 * this.field2528.field2556 / class109.field1628;

         do {
            long var5 = this.field2530 + (long)var3 * (long)var4;
            if(this.field2516 - var5 >= 0L) {
               this.field2530 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2516 - this.field2530) - 1L) / (long)var4);
            this.field2530 += (long)var7 * (long)var4;
            this.field2523.vmethod3949(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3877();
         } while(this.field2528.method3890());
      }

      this.field2523.vmethod3949(var1, var2, var3);
   }

   public class204() {
      this.field2507 = 256;
      this.field2508 = 1000000;
      this.field2509 = new int[16];
      this.field2510 = new int[16];
      this.field2511 = new int[16];
      this.field2512 = new int[16];
      this.field2513 = new int[16];
      this.field2519 = new int[16];
      this.field2531 = new int[16];
      this.field2506 = new int[16];
      this.field2517 = new int[16];
      this.field2518 = new int[16];
      this.field2526 = new int[16];
      this.field2520 = new int[16];
      this.field2514 = new int[16];
      this.field2522 = new int[16];
      this.field2527 = new int[16];
      this.field2524 = new class205[16][128];
      this.field2525 = new class205[16][128];
      this.field2528 = new class206();
      this.field2523 = new class208(this);
      this.field2521 = new XHashTable(128);
      this.method3766();
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass205;S)Z",
      garbageValue = "1123"
   )
   boolean method3787(class205 var1) {
      if(var1.field2552 == null) {
         if(var1.field2541 >= 0) {
            var1.unlink();
            if(var1.field2551 > 0 && var1 == this.field2525[var1.field2544][var1.field2551]) {
               this.field2525[var1.field2544][var1.field2551] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lclass205;[IIII)Z",
      garbageValue = "-2017744146"
   )
   boolean method3788(class205 var1, int[] var2, int var3, int var4) {
      var1.field2553 = class109.field1628 / 100;
      if(var1.field2541 < 0 || var1.field2552 != null && !var1.field2552.method2173()) {
         int var5 = var1.field2538;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2517[var1.field2544]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2538 = var5;
         }

         var1.field2552.method2171(this.method3779(var1));
         class202 var6 = var1.field2540;
         boolean var7 = false;
         ++var1.field2550;
         var1.field2548 += var6.field2493;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2534 - 60 << 8) + (var1.field2543 * var1.field2538 >> 12));
         if(var6.field2488 > 0) {
            if(var6.field2490 > 0) {
               var1.field2545 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2490 * var8) + 0.5D);
            } else {
               var1.field2545 += 128;
            }
         }

         if(var6.field2492 != null) {
            if(var6.field2489 > 0) {
               var1.field2546 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2489 * var8) + 0.5D);
            } else {
               var1.field2546 += 128;
            }

            while(var1.field2547 < var6.field2492.length - 2 && var1.field2546 > (var6.field2492[var1.field2547 + 2] & 255) << 8) {
               var1.field2547 += 2;
            }

            if(var6.field2492.length - 2 == var1.field2547 && var6.field2492[var1.field2547 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2541 >= 0 && var6.field2487 != null && (this.field2518[var1.field2544] & 1) == 0 && (var1.field2551 < 0 || this.field2525[var1.field2544][var1.field2551] != var1)) {
            if(var6.field2486 > 0) {
               var1.field2541 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2486 * var8) + 0.5D);
            } else {
               var1.field2541 += 128;
            }

            while(var1.field2549 < var6.field2487.length - 2 && var1.field2541 > (var6.field2487[var1.field2549 + 2] & 255) << 8) {
               var1.field2549 += 2;
            }

            if(var6.field2487.length - 2 == var1.field2549) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2552.method2170(var1.field2553);
            if(var2 != null) {
               var1.field2552.vmethod3949(var2, var3, var4);
            } else {
               var1.field2552.vmethod3969(var4);
            }

            if(var1.field2552.method2174()) {
               this.field2523.field2583.method1936(var1.field2552);
            }

            var1.method3886();
            if(var1.field2541 >= 0) {
               var1.unlink();
               if(var1.field2551 > 0 && this.field2525[var1.field2544][var1.field2551] == var1) {
                  this.field2525[var1.field2544][var1.field2551] = null;
               }
            }

            return true;
         } else {
            var1.field2552.method2205(var1.field2553, this.method3780(var1), this.method3781(var1));
            return false;
         }
      } else {
         var1.method3886();
         var1.unlink();
         if(var1.field2551 > 0 && var1 == this.field2525[var1.field2544][var1.field2551]) {
            this.field2525[var1.field2544][var1.field2551] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("t")
   protected synchronized class119 vmethod3945() {
      return null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   public synchronized void method3801() {
      this.field2528.method3930();
      this.method3766();
   }

   @ObfuscatedName("k")
   protected synchronized void vmethod3969(int var1) {
      if(this.field2528.method3890()) {
         int var2 = this.field2528.field2556 * this.field2508 / class109.field1628;

         do {
            long var3 = (long)var1 * (long)var2 + this.field2530;
            if(this.field2516 - var3 >= 0L) {
               this.field2530 = var3;
               break;
            }

            int var5 = (int)((this.field2516 - this.field2530 + (long)var2 - 1L) / (long)var2);
            this.field2530 += (long)var5 * (long)var2;
            this.field2523.vmethod3969(var5);
            var1 -= var5;
            this.method3877();
         } while(this.field2528.method3890());
      }

      this.field2523.vmethod3969(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1030718577"
   )
   synchronized void method3820() {
      for(class207 var1 = (class207)this.field2521.method3606(); var1 != null; var1 = (class207)this.field2521.method3607()) {
         var1.method3937();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-569280327"
   )
   synchronized boolean method3825() {
      return this.field2528.method3890();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1983019432"
   )
   void method3834(int var1, int var2) {
      this.field2522[var1] = var2;
      this.field2527[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LTrack1;LIndexDataBase;Lclass112;II)Z",
      garbageValue = "1012159919"
   )
   synchronized boolean method3849(Track1 var1, IndexDataBase var2, class112 var3, int var4) {
      var1.method3971();
      boolean var5 = true;
      Object var6 = null;
      int[] var10 = new int[]{var4};

      for(class199 var7 = (class199)var1.field2586.method3606(); var7 != null; var7 = (class199)var1.field2586.method3607()) {
         int var8 = (int)var7.hash;
         class207 var9 = (class207)this.field2521.method3615((long)var8);
         if(var9 == null) {
            var9 = Widget.method4097(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2521.method3617(var9, (long)var8);
         }

         if(!var9.method3936(var3, var7.field2481, var10)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3972();
      }

      return var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "51"
   )
   void method3856(int var1, int var2) {
      this.field2512[var1] = var2;
      this.field2519[var1] = var2 & -128;
      this.method3764(var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass205;ZI)V",
      garbageValue = "1713886167"
   )
   void method3858(class205 var1, boolean var2) {
      int var3 = var1.field2537.field1602.length;
      int var4;
      if(var2 && var1.field2537.field1601) {
         int var5 = var3 + var3 - var1.field2537.field1603;
         var4 = (int)((long)this.field2514[var1.field2544] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2552.method2166();
         }
      } else {
         var4 = (int)((long)this.field2514[var1.field2544] * (long)var3 >> 6);
      }

      var1.field2552.method2226(var4);
   }

   @ObfuscatedName("v")
   protected synchronized class119 vmethod3944() {
      return this.field2523;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1885761735"
   )
   void method3877() {
      int var1 = this.field2532;
      int var2 = this.field2529;

      long var3;
      for(var3 = this.field2516; var2 == this.field2529; var3 = this.field2528.method3902(var2)) {
         while(var2 == this.field2528.field2559[var1]) {
            this.field2528.method3906(var1);
            int var5 = this.field2528.method3899(var1);
            if(var5 == 1) {
               this.field2528.method3897();
               this.field2528.method3891(var1);
               if(this.field2528.method3904()) {
                  if(!this.field2515 || var2 == 0) {
                     this.method3766();
                     this.field2528.method3930();
                     return;
                  }

                  this.field2528.method3905(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3777(var5);
            }

            this.field2528.method3898(var1);
            this.field2528.method3891(var1);
         }

         var1 = this.field2528.method3911();
         var2 = this.field2528.field2559[var1];
      }

      this.field2532 = var1;
      this.field2529 = var2;
      this.field2516 = var3;
   }
}
