import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class204 extends class119 {
   @ObfuscatedName("q")
   int[] field2520;
   @ObfuscatedName("ao")
   class206 field2521;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -350997475
   )
   int field2522;
   @ObfuscatedName("j")
   int[] field2523;
   @ObfuscatedName("f")
   int[] field2524;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -717538111
   )
   int field2525;
   @ObfuscatedName("n")
   XHashTable field2526;
   @ObfuscatedName("c")
   int[] field2527;
   @ObfuscatedName("h")
   int[] field2528;
   @ObfuscatedName("g")
   int[] field2529;
   @ObfuscatedName("e")
   int[] field2530;
   @ObfuscatedName("o")
   int[] field2531;
   @ObfuscatedName("t")
   int[] field2532;
   @ObfuscatedName("w")
   int[] field2533;
   @ObfuscatedName("l")
   int[] field2534;
   @ObfuscatedName("m")
   int[] field2535;
   @ObfuscatedName("u")
   class205[][] field2536;
   @ObfuscatedName("d")
   int[] field2537;
   @ObfuscatedName("z")
   int[] field2538;
   @ObfuscatedName("ae")
   class205[][] field2539;
   @ObfuscatedName("k")
   int[] field2540;
   @ObfuscatedName("ad")
   boolean field2541;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -324205395
   )
   int field2542;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1463578553
   )
   int field2543;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      longValue = 3450284672504888075L
   )
   long field2544;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      longValue = 1819254370474824881L
   )
   long field2545;
   @ObfuscatedName("at")
   class208 field2546;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1717833667
   )
   static int field2548;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1469829187"
   )
   int method3710() {
      return this.field2522;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1830631891"
   )
   synchronized void method3713() {
      for(class207 var1 = (class207)this.field2526.method3548(); var1 != null; var1 = (class207)this.field2526.method3556()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LTrack1;ZB)V",
      garbageValue = "-79"
   )
   public synchronized void method3714(Track1 var1, boolean var2) {
      this.method3728();
      this.field2521.method3845(var1.field2602);
      this.field2541 = var2;
      this.field2544 = 0L;
      int var3 = this.field2521.method3848();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2521.method3872(var4);
         this.field2521.method3850(var4);
         this.field2521.method3886(var4);
      }

      this.field2542 = this.field2521.method3856();
      this.field2543 = this.field2521.field2576[this.field2542];
      this.field2545 = this.field2521.method3855(this.field2543);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "4"
   )
   void method3716(int var1, int var2, int var3) {
      this.method3722(var1, var2, 64);
      if((this.field2532[var1] & 2) != 0) {
         for(class205 var4 = (class205)this.field2546.field2594.method3629(); var4 != null; var4 = (class205)this.field2546.field2594.method3609()) {
            if(var1 == var4.field2551 && var4.field2563 < 0) {
               this.field2536[var1][var4.field2558] = null;
               this.field2536[var1][var2] = var4;
               int var5 = (var4.field2559 * var4.field2555 >> 12) + var4.field2557;
               var4.field2557 += var2 - var4.field2558 << 8;
               var4.field2555 = var5 - var4.field2557;
               var4.field2559 = 4096;
               var4.field2558 = var2;
               return;
            }
         }
      }

      class207 var9 = (class207)this.field2526.method3545((long)this.field2538[var1]);
      if(var9 != null) {
         class107 var8 = var9.field2585[var2];
         if(var8 != null) {
            class205 var6 = new class205();
            var6.field2551 = var1;
            var6.field2550 = var9;
            var6.field2556 = var8;
            var6.field2552 = var9.field2589[var2];
            var6.field2553 = var9.field2591[var2];
            var6.field2558 = var2;
            var6.field2564 = var9.field2588 * var3 * var3 * var9.field2590[var2] + 1024 >> 11;
            var6.field2554 = var9.field2587[var2] & 255;
            var6.field2557 = (var2 << 8) - (var9.field2586[var2] & 32767);
            var6.field2569 = 0;
            var6.field2561 = 0;
            var6.field2562 = 0;
            var6.field2563 = -1;
            var6.field2567 = 0;
            if(this.field2520[var1] == 0) {
               var6.field2560 = class117.method2122(var8, this.method3734(var6), this.method3735(var6), this.method3736(var6));
            } else {
               var6.field2560 = class117.method2122(var8, this.method3734(var6), 0, this.method3736(var6));
               this.method3721(var6, var9.field2586[var2] < 0);
            }

            if(var9.field2586[var2] < 0) {
               var6.field2560.method2124(-1);
            }

            if(var6.field2553 >= 0) {
               class205 var7 = this.field2539[var1][var6.field2553];
               if(var7 != null && var7.field2563 < 0) {
                  this.field2536[var1][var7.field2558] = null;
                  var7.field2563 = 0;
               }

               this.field2539[var1][var6.field2553] = var6;
            }

            this.field2546.field2594.method3634(var6);
            this.field2536[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1372901865"
   )
   public synchronized void method3717(int var1, int var2) {
      this.method3718(var1, var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-544512835"
   )
   void method3718(int var1, int var2) {
      this.field2527[var1] = var2;
      this.field2528[var1] = var2 & -128;
      this.method3778(var1, var2);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1797775597"
   )
   void method3720() {
      this.method3726(-1);
      this.method3727(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2538[var1] = this.field2527[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2528[var1] = this.field2527[var1] & -128;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass205;ZI)V",
      garbageValue = "-2035932027"
   )
   void method3721(class205 var1, boolean var2) {
      int var3 = var1.field2556.field1613.length;
      int var4;
      if(var2 && var1.field2556.field1616) {
         int var5 = var3 + var3 - var1.field2556.field1614;
         var4 = (int)((long)this.field2520[var1.field2551] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2560.method2264();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2520[var1.field2551] >> 6);
      }

      var1.field2560.method2130(var4);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1854427371"
   )
   void method3722(int var1, int var2, int var3) {
      class205 var4 = this.field2536[var1][var2];
      if(var4 != null) {
         this.field2536[var1][var2] = null;
         if((this.field2532[var1] & 2) != 0) {
            for(class205 var5 = (class205)this.field2546.field2594.method3622(); var5 != null; var5 = (class205)this.field2546.field2594.method3608()) {
               if(var5.field2551 == var4.field2551 && var5.field2563 < 0 && var5 != var4) {
                  var4.field2563 = 0;
                  break;
               }
            }
         } else {
            var4.field2563 = 0;
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "1"
   )
   void method3723(int var1, int var2, int var3) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-50"
   )
   void method3725(int var1, int var2) {
      this.field2529[var1] = var2;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "55"
   )
   void method3726(int var1) {
      for(class205 var2 = (class205)this.field2546.field2594.method3622(); var2 != null; var2 = (class205)this.field2546.field2594.method3608()) {
         if(var1 < 0 || var1 == var2.field2551) {
            if(var2.field2560 != null) {
               var2.field2560.method2135(class109.field1633 / 100);
               if(var2.field2560.method2132()) {
                  this.field2546.field2596.method1861(var2.field2560);
               }

               var2.method3841();
            }

            if(var2.field2563 < 0) {
               this.field2536[var2.field2551][var2.field2558] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2013740464"
   )
   void method3727(int var1) {
      if(var1 >= 0) {
         this.field2523[var1] = 12800;
         this.field2524[var1] = 8192;
         this.field2535[var1] = 16383;
         this.field2529[var1] = 8192;
         this.field2530[var1] = 0;
         this.field2531[var1] = 8192;
         this.method3759(var1);
         this.method3731(var1);
         this.field2532[var1] = 0;
         this.field2533[var1] = 32767;
         this.field2534[var1] = 256;
         this.field2520[var1] = 0;
         this.method3834(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3727(var1);
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-366797719"
   )
   public synchronized void method3728() {
      this.field2521.method3846();
      this.method3720();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "3"
   )
   void method3731(int var1) {
      if((this.field2532[var1] & 4) != 0) {
         for(class205 var2 = (class205)this.field2546.field2594.method3622(); var2 != null; var2 = (class205)this.field2546.field2594.method3608()) {
            if(var1 == var2.field2551) {
               var2.field2549 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-7810"
   )
   void method3732(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3722(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3716(var3, var4, var5);
         } else {
            this.method3722(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3723(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2528[var3] = (this.field2528[var3] & -2080769) + (var5 << 14);
         }

         if(var4 == 32) {
            this.field2528[var3] = (var5 << 7) + (this.field2528[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2530[var3] = (this.field2530[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 33) {
            this.field2530[var3] = var5 + (this.field2530[var3] & -128);
         }

         if(var4 == 5) {
            this.field2531[var3] = (var5 << 7) + (this.field2531[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2531[var3] = (this.field2531[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field2523[var3] = (this.field2523[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field2523[var3] = var5 + (this.field2523[var3] & -128);
         }

         if(var4 == 10) {
            this.field2524[var3] = (this.field2524[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field2524[var3] = (this.field2524[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field2535[var3] = (this.field2535[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 43) {
            this.field2535[var3] = var5 + (this.field2535[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2532[var3] |= 1;
            } else {
               this.field2532[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2532[var3] |= 2;
            } else {
               this.method3759(var3);
               this.field2532[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2533[var3] = (var5 << 7) + (this.field2533[var3] & 127);
         }

         if(var4 == 98) {
            this.field2533[var3] = var5 + (this.field2533[var3] & 16256);
         }

         if(var4 == 101) {
            this.field2533[var3] = (this.field2533[var3] & 127) + 16384 + (var5 << 7);
         }

         if(var4 == 100) {
            this.field2533[var3] = var5 + (this.field2533[var3] & 16256) + 16384;
         }

         if(var4 == 120) {
            this.method3726(var3);
         }

         if(var4 == 121) {
            this.method3727(var3);
         }

         if(var4 == 123) {
            this.method3837(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2533[var3];
            if(var6 == 16384) {
               this.field2534[var3] = (var5 << 7) + (this.field2534[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2533[var3];
            if(var6 == 16384) {
               this.field2534[var3] = var5 + (this.field2534[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2520[var3] = (this.field2520[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 48) {
            this.field2520[var3] = (this.field2520[var3] & -128) + var5;
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2532[var3] |= 4;
            } else {
               this.method3731(var3);
               this.field2532[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3834(var3, (this.field2540[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method3834(var3, var5 + (this.field2540[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3778(var3, var4 + this.field2528[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3811(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3725(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3720();
         }
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "-1347697046"
   )
   int method3734(class205 var1) {
      int var2 = var1.field2557 + (var1.field2555 * var1.field2559 >> 12);
      var2 += (this.field2529[var1.field2551] - 8192) * this.field2534[var1.field2551] >> 12;
      class202 var3 = var1.field2552;
      int var4;
      if(var3.field2509 > 0 && (var3.field2510 > 0 || this.field2530[var1.field2551] > 0)) {
         var4 = var3.field2510 << 2;
         int var5 = var3.field2502 << 1;
         if(var1.field2565 < var5) {
            var4 = var4 * var1.field2565 / var5;
         }

         var4 += this.field2530[var1.field2551] >> 7;
         double var6 = Math.sin((double)(var1.field2566 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2556.field1615 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class109.field1633 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "530266787"
   )
   int method3735(class205 var1) {
      class202 var2 = var1.field2552;
      int var3 = this.field2535[var1.field2551] * this.field2523[var1.field2551] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2564 + 16384 >> 15;
      var3 = var3 * this.field2522 + 128 >> 8;
      if(var2.field2508 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2508 * (double)var1.field2569 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2507 != null) {
         var4 = var1.field2561;
         var5 = var2.field2507[var1.field2562 + 1];
         if(var1.field2562 < var2.field2507.length - 2) {
            var6 = (var2.field2507[var1.field2562] & 255) << 8;
            var7 = (var2.field2507[var1.field2562 + 2] & 255) << 8;
            var5 += (var2.field2507[var1.field2562 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2563 > 0 && var2.field2503 != null) {
         var4 = var1.field2563;
         var5 = var2.field2503[var1.field2567 + 1];
         if(var1.field2567 < var2.field2503.length - 2) {
            var6 = (var2.field2503[var1.field2567] & 255) << 8;
            var7 = (var2.field2503[var1.field2567 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2503[var1.field2567 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lclass205;B)I",
      garbageValue = "-70"
   )
   int method3736(class205 var1) {
      int var2 = this.field2524[var1.field2551];
      return var2 < 8192?var2 * var1.field2554 + 32 >> 6:16384 - ((16384 - var2) * (128 - var1.field2554) + 32 >> 6);
   }

   @ObfuscatedName("m")
   protected synchronized class119 vmethod3906() {
      return this.field2546;
   }

   @ObfuscatedName("c")
   protected synchronized class119 vmethod3907() {
      return null;
   }

   @ObfuscatedName("z")
   protected synchronized int vmethod3908() {
      return 0;
   }

   @ObfuscatedName("h")
   protected synchronized void vmethod3909(int[] var1, int var2, int var3) {
      if(this.field2521.method3847()) {
         int var4 = this.field2521.field2571 * this.field2525 / class109.field1633;

         do {
            long var5 = (long)var4 * (long)var3 + this.field2544;
            if(this.field2545 - var5 >= 0L) {
               this.field2544 = var5;
               break;
            }

            int var7 = (int)((this.field2545 - this.field2544 + (long)var4 - 1L) / (long)var4);
            this.field2544 += (long)var4 * (long)var7;
            this.field2546.vmethod3909(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3742();
         } while(this.field2521.method3847());
      }

      this.field2546.vmethod3909(var1, var2, var3);
   }

   @ObfuscatedName("e")
   protected synchronized void vmethod3910(int var1) {
      if(this.field2521.method3847()) {
         int var2 = this.field2521.field2571 * this.field2525 / class109.field1633;

         do {
            long var3 = this.field2544 + (long)var2 * (long)var1;
            if(this.field2545 - var3 >= 0L) {
               this.field2544 = var3;
               break;
            }

            int var5 = (int)((this.field2545 - this.field2544 + (long)var2 - 1L) / (long)var2);
            this.field2544 += (long)var5 * (long)var2;
            this.field2546.vmethod3910(var5);
            var1 -= var5;
            this.method3742();
         } while(this.field2521.method3847());
      }

      this.field2546.vmethod3910(var1);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1861293029"
   )
   void method3742() {
      int var1 = this.field2542;
      int var2 = this.field2543;

      long var3;
      for(var3 = this.field2545; var2 == this.field2543; var3 = this.field2521.method3855(var2)) {
         while(this.field2521.field2576[var1] == var2) {
            this.field2521.method3872(var1);
            int var5 = this.field2521.method3854(var1);
            if(var5 == 1) {
               this.field2521.method3895();
               this.field2521.method3886(var1);
               if(this.field2521.method3857()) {
                  if(!this.field2541 || var2 == 0) {
                     this.method3720();
                     this.field2521.method3846();
                     return;
                  }

                  this.field2521.method3863(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3732(var5);
            }

            this.field2521.method3850(var1);
            this.field2521.method3886(var1);
         }

         var1 = this.field2521.method3856();
         var2 = this.field2521.field2576[var1];
      }

      this.field2542 = var1;
      this.field2543 = var2;
      this.field2545 = var3;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)Z",
      garbageValue = "539261080"
   )
   boolean method3743(class205 var1) {
      if(var1.field2560 == null) {
         if(var1.field2563 >= 0) {
            var1.unlink();
            if(var1.field2553 > 0 && var1 == this.field2539[var1.field2551][var1.field2553]) {
               this.field2539[var1.field2551][var1.field2553] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(Lclass205;[IIII)Z",
      garbageValue = "-1094200719"
   )
   boolean method3744(class205 var1, int[] var2, int var3, int var4) {
      var1.field2568 = class109.field1633 / 100;
      if(var1.field2563 < 0 || var1.field2560 != null && !var1.field2560.method2237()) {
         int var5 = var1.field2559;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2531[var1.field2551] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2559 = var5;
         }

         var1.field2560.method2266(this.method3734(var1));
         class202 var6 = var1.field2552;
         boolean var7 = false;
         ++var1.field2565;
         var1.field2566 += var6.field2509;
         double var8 = (double)((var1.field2558 - 60 << 8) + (var1.field2555 * var1.field2559 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2508 > 0) {
            if(var6.field2505 > 0) {
               var1.field2569 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2505 * var8) + 0.5D);
            } else {
               var1.field2569 += 128;
            }
         }

         if(var6.field2507 != null) {
            if(var6.field2504 > 0) {
               var1.field2561 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2504 * var8) + 0.5D);
            } else {
               var1.field2561 += 128;
            }

            while(var1.field2562 < var6.field2507.length - 2 && var1.field2561 > (var6.field2507[var1.field2562 + 2] & 255) << 8) {
               var1.field2562 += 2;
            }

            if(var1.field2562 == var6.field2507.length - 2 && var6.field2507[var1.field2562 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2563 >= 0 && var6.field2503 != null && (this.field2532[var1.field2551] & 1) == 0 && (var1.field2553 < 0 || this.field2539[var1.field2551][var1.field2553] != var1)) {
            if(var6.field2506 > 0) {
               var1.field2563 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2506 * var8) + 0.5D);
            } else {
               var1.field2563 += 128;
            }

            while(var1.field2567 < var6.field2503.length - 2 && var1.field2563 > (var6.field2503[var1.field2567 + 2] & 255) << 8) {
               var1.field2567 += 2;
            }

            if(var1.field2567 == var6.field2503.length - 2) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2560.method2135(var1.field2568);
            if(var2 != null) {
               var1.field2560.vmethod3909(var2, var3, var4);
            } else {
               var1.field2560.vmethod3910(var4);
            }

            if(var1.field2560.method2132()) {
               this.field2546.field2596.method1861(var1.field2560);
            }

            var1.method3841();
            if(var1.field2563 >= 0) {
               var1.unlink();
               if(var1.field2553 > 0 && var1 == this.field2539[var1.field2551][var1.field2553]) {
                  this.field2539[var1.field2551][var1.field2553] = null;
               }
            }

            return true;
         } else {
            var1.field2560.method2134(var1.field2568, this.method3735(var1), this.method3736(var1));
            return false;
         }
      } else {
         var1.method3841();
         var1.unlink();
         if(var1.field2553 > 0 && this.field2539[var1.field2551][var1.field2553] == var1) {
            this.field2539[var1.field2551][var1.field2553] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1449201107"
   )
   public synchronized void method3746() {
      for(class207 var1 = (class207)this.field2526.method3548(); var1 != null; var1 = (class207)this.field2526.method3556()) {
         var1.method3901();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-603170991"
   )
   synchronized boolean method3757() {
      return this.field2521.method3847();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2104007408"
   )
   void method3759(int var1) {
      if((this.field2532[var1] & 2) != 0) {
         for(class205 var2 = (class205)this.field2546.field2594.method3622(); var2 != null; var2 = (class205)this.field2546.field2594.method3608()) {
            if(var2.field2551 == var1 && this.field2536[var1][var2.field2558] == null && var2.field2563 < 0) {
               var2.field2563 = 0;
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1124661474"
   )
   public synchronized void method3773(int var1) {
      this.field2522 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LTrack1;LIndexDataBase;Lclass112;IS)Z",
      garbageValue = "256"
   )
   public synchronized boolean method3776(Track1 var1, IndexDataBase var2, class112 var3, int var4) {
      var1.method3931();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class199 var7 = (class199)var1.field2603.method3548(); var7 != null; var7 = (class199)var1.field2603.method3556()) {
         int var8 = (int)var7.hash;
         class207 var9 = (class207)this.field2526.method3545((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method4131(var8);
            class207 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class207(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field2526.method3546(var10, (long)var8);
         }

         if(!var9.method3900(var3, var7.field2497, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3930();
      }

      return var5;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1705152330"
   )
   void method3778(int var1, int var2) {
      if(this.field2538[var1] != var2) {
         this.field2538[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2539[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1227436721"
   )
   static final void method3788(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class61.region.method2701(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class61.region.method2770(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = TextureProvider.field1787.image;
         var11 = (103 - var2) * 2048 + var1 * 4 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = class61.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            ModIcon var14 = class73.field864[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method5066(var1 * 4 + 48 + var15, var16 + (104 - var2 - var13.sizeY) * 4 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 3 + 512] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 3 + 512] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class61.region.method2703(var0, var1, var2);
      if(var5 != 0) {
         var6 = class61.region.method2770(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class61.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            ModIcon var20 = class73.field864[var23.mapSceneId];
            if(var20 != null) {
               var12 = (var23.sizeX * 4 - var20.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var20.height) / 2;
               var20.method5066(var12 + var1 * 4 + 48, var18 + (104 - var2 - var23.sizeY) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var17 = TextureProvider.field1787.image;
            var18 = var1 * 4 + 24624 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var17[var18] = var11;
               var17[var18 + 512 + 1] = var11;
               var17[var18 + 1024 + 2] = var11;
               var17[var18 + 1536 + 3] = var11;
            } else {
               var17[var18 + 1536] = var11;
               var17[var18 + 1024 + 1] = var11;
               var17[var18 + 512 + 2] = var11;
               var17[var18 + 3] = var11;
            }
         }
      }

      var5 = class61.region.method2704(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var21 = class61.getObjectDefinition(var6);
         if(var21.mapSceneId != -1) {
            ModIcon var19 = class73.field864[var21.mapSceneId];
            if(var19 != null) {
               var9 = (var21.sizeX * 4 - var19.originalWidth) / 2;
               int var22 = (var21.sizeY * 4 - var19.height) / 2;
               var19.method5066(var9 + var1 * 4 + 48, var22 + (104 - var2 - var21.sizeY) * 4 + 48);
            }
         }
      }

   }

   public class204() {
      this.field2522 = 256;
      this.field2525 = 1000000;
      this.field2523 = new int[16];
      this.field2524 = new int[16];
      this.field2535 = new int[16];
      this.field2527 = new int[16];
      this.field2538 = new int[16];
      this.field2528 = new int[16];
      this.field2529 = new int[16];
      this.field2530 = new int[16];
      this.field2531 = new int[16];
      this.field2532 = new int[16];
      this.field2533 = new int[16];
      this.field2534 = new int[16];
      this.field2520 = new int[16];
      this.field2540 = new int[16];
      this.field2537 = new int[16];
      this.field2536 = new class205[16][128];
      this.field2539 = new class205[16][128];
      this.field2521 = new class206();
      this.field2546 = new class208(this);
      this.field2526 = new XHashTable(128);
      this.method3720();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;III)[LModIcon;",
      garbageValue = "-2040227940"
   )
   static ModIcon[] method3809(IndexDataBase var0, int var1, int var2) {
      return !class112.method2092(var0, var1, var2)?null:NPCComposition.method4666();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1001411573"
   )
   void method3811(int var1, int var2) {
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "57"
   )
   void method3834(int var1, int var2) {
      this.field2540[var1] = var2;
      this.field2537[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "863165377"
   )
   void method3837(int var1) {
      for(class205 var2 = (class205)this.field2546.field2594.method3622(); var2 != null; var2 = (class205)this.field2546.field2594.method3608()) {
         if((var1 < 0 || var2.field2551 == var1) && var2.field2563 < 0) {
            this.field2536[var2.field2551][var2.field2558] = null;
            var2.field2563 = 0;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass186;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "623617346"
   )
   static String method3838(class186 var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         class185 var3 = (class185)var0.method3493((long)var1);
         return var3 == null?var2:(String)var3.field2459;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "-1162564973"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3611.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = IndexFile.method3014(Sequence.field3608, Sequence.field3609, var0, false);
         if(var1 != null) {
            Sequence.field3611.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
