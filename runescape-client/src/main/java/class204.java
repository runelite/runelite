import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class204 extends class119 {
   @ObfuscatedName("a")
   int[] field2517;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2014695763
   )
   int field2518;
   @ObfuscatedName("v")
   int[] field2519;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      longValue = -2112564779740984265L
   )
   long field2520;
   @ObfuscatedName("y")
   int[] field2521;
   @ObfuscatedName("h")
   int[] field2522;
   @ObfuscatedName("x")
   int[] field2523;
   @ObfuscatedName("f")
   int[] field2524;
   @ObfuscatedName("n")
   int[] field2525;
   @ObfuscatedName("g")
   int[] field2526;
   @ObfuscatedName("o")
   int[] field2527;
   @ObfuscatedName("s")
   int[] field2529;
   @ObfuscatedName("w")
   int[] field2530;
   @ObfuscatedName("i")
   XHashTable field2531;
   @ObfuscatedName("p")
   int[] field2532;
   @ObfuscatedName("l")
   int[] field2533;
   @ObfuscatedName("b")
   int[] field2534;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -381988809
   )
   int field2535;
   @ObfuscatedName("ad")
   class205[][] field2536;
   @ObfuscatedName("ar")
   class206 field2537;
   @ObfuscatedName("an")
   boolean field2538;
   @ObfuscatedName("t")
   class205[][] field2539;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1147802987
   )
   int field2540;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1957913685
   )
   int field2541;
   @ObfuscatedName("u")
   int[] field2542;
   @ObfuscatedName("aw")
   class208 field2543;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      longValue = 6109058652895373519L
   )
   long field2544;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "7"
   )
   public synchronized void method3668(int var1) {
      this.field2535 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "16699093"
   )
   int method3669() {
      return this.field2535;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LTrack1;LIndexDataBase;Lclass112;II)Z",
      garbageValue = "1499614741"
   )
   public synchronized boolean method3670(Track1 var1, IndexDataBase var2, class112 var3, int var4) {
      var1.method3901();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class199 var7 = (class199)var1.field2598.method3518(); var7 != null; var7 = (class199)var1.field2598.method3524()) {
         int var8 = (int)var7.hash;
         class207 var9 = (class207)this.field2531.method3520((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method4115(var8);
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

            this.field2531.method3516(var10, (long)var8);
         }

         if(!var9.method3852(var3, var7.field2495, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3893();
      }

      return var5;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "63"
   )
   void method3671(int var1) {
      if((this.field2529[var1] & 2) != 0) {
         for(class205 var2 = (class205)this.field2543.field2594.method3576(); var2 != null; var2 = (class205)this.field2543.field2594.method3578()) {
            if(var2.field2560 == var1 && this.field2539[var1][var2.field2561] == null && var2.field2559 < 0) {
               var2.field2559 = 0;
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1662183138"
   )
   synchronized void method3672() {
      for(class207 var1 = (class207)this.field2531.method3518(); var1 != null; var1 = (class207)this.field2531.method3524()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LTrack1;ZI)V",
      garbageValue = "1691509446"
   )
   public synchronized void method3673(Track1 var1, boolean var2) {
      this.method3674();
      this.field2537.method3795(var1.field2599);
      this.field2538 = var2;
      this.field2520 = 0L;
      int var3 = this.field2537.method3796();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2537.method3834(var4);
         this.field2537.method3800(var4);
         this.field2537.method3817(var4);
      }

      this.field2541 = this.field2537.method3805();
      this.field2540 = this.field2537.field2569[this.field2541];
      this.field2544 = this.field2537.method3804(this.field2540);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   public synchronized void method3674() {
      this.field2537.method3835();
      this.method3780();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   public synchronized void method3676(int var1, int var2) {
      this.method3677(var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2091225728"
   )
   void method3677(int var1, int var2) {
      this.field2522[var1] = var2;
      this.field2524[var1] = var2 & -128;
      this.method3678(var1, var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-52271309"
   )
   void method3678(int var1, int var2) {
      if(this.field2523[var1] != var2) {
         this.field2523[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2536[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1412233400"
   )
   void method3679(int var1, int var2, int var3) {
      this.method3681(var1, var2, 64);
      if((this.field2529[var1] & 2) != 0) {
         for(class205 var4 = (class205)this.field2543.field2594.method3574(); var4 != null; var4 = (class205)this.field2543.field2594.method3582()) {
            if(var1 == var4.field2560 && var4.field2559 < 0) {
               this.field2539[var1][var4.field2561] = null;
               this.field2539[var1][var2] = var4;
               int var8 = (var4.field2555 * var4.field2548 >> 12) + var4.field2554;
               var4.field2554 += var2 - var4.field2561 << 8;
               var4.field2548 = var8 - var4.field2554;
               var4.field2555 = 4096;
               var4.field2561 = var2;
               return;
            }
         }
      }

      class207 var9 = (class207)this.field2531.method3520((long)this.field2523[var1]);
      if(var9 != null) {
         class107 var5 = var9.field2582[var2];
         if(var5 != null) {
            class205 var6 = new class205();
            var6.field2560 = var1;
            var6.field2562 = var9;
            var6.field2547 = var5;
            var6.field2546 = var9.field2585[var2];
            var6.field2549 = var9.field2591[var2];
            var6.field2561 = var2;
            var6.field2551 = var9.field2590 * var3 * var3 * var9.field2584[var2] + 1024 >> 11;
            var6.field2552 = var9.field2586[var2] & 255;
            var6.field2554 = (var2 << 8) - (var9.field2583[var2] & 32767);
            var6.field2545 = 0;
            var6.field2557 = 0;
            var6.field2558 = 0;
            var6.field2559 = -1;
            var6.field2556 = 0;
            if(this.field2532[var1] == 0) {
               var6.field2563 = class117.method2107(var5, this.method3693(var6), this.method3694(var6), this.method3695(var6));
            } else {
               var6.field2563 = class117.method2107(var5, this.method3693(var6), 0, this.method3695(var6));
               this.method3680(var6, var9.field2583[var2] < 0);
            }

            if(var9.field2583[var2] < 0) {
               var6.field2563.method2224(-1);
            }

            if(var6.field2549 >= 0) {
               class205 var7 = this.field2536[var1][var6.field2549];
               if(var7 != null && var7.field2559 < 0) {
                  this.field2539[var1][var7.field2561] = null;
                  var7.field2559 = 0;
               }

               this.field2536[var1][var6.field2549] = var6;
            }

            this.field2543.field2594.method3571(var6);
            this.field2539[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass205;ZI)V",
      garbageValue = "1652200318"
   )
   void method3680(class205 var1, boolean var2) {
      int var3 = var1.field2547.field1620.length;
      int var4;
      if(var2 && var1.field2547.field1624) {
         int var5 = var3 + var3 - var1.field2547.field1621;
         var4 = (int)((long)var5 * (long)this.field2532[var1.field2560] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2563.method2196();
         }
      } else {
         var4 = (int)((long)this.field2532[var1.field2560] * (long)var3 >> 6);
      }

      var1.field2563.method2115(var4);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2054897337"
   )
   void method3681(int var1, int var2, int var3) {
      class205 var4 = this.field2539[var1][var2];
      if(var4 != null) {
         this.field2539[var1][var2] = null;
         if((this.field2529[var1] & 2) != 0) {
            for(class205 var5 = (class205)this.field2543.field2594.method3576(); var5 != null; var5 = (class205)this.field2543.field2594.method3578()) {
               if(var4.field2560 == var5.field2560 && var5.field2559 < 0 && var4 != var5) {
                  var4.field2559 = 0;
                  break;
               }
            }
         } else {
            var4.field2559 = 0;
         }

      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "16"
   )
   void method3684(int var1, int var2) {
      this.field2525[var1] = var2;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-1"
   )
   void method3686(int var1) {
      if(var1 >= 0) {
         this.field2519[var1] = 12800;
         this.field2534[var1] = 8192;
         this.field2521[var1] = 16383;
         this.field2525[var1] = 8192;
         this.field2517[var1] = 0;
         this.field2527[var1] = 8192;
         this.method3671(var1);
         this.method3690(var1);
         this.field2529[var1] = 0;
         this.field2526[var1] = 32767;
         this.field2530[var1] = 256;
         this.field2532[var1] = 0;
         this.method3692(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3686(var1);
         }

      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-77009590"
   )
   void method3687(int var1) {
      for(class205 var2 = (class205)this.field2543.field2594.method3576(); var2 != null; var2 = (class205)this.field2543.field2594.method3578()) {
         if((var1 < 0 || var2.field2560 == var1) && var2.field2559 < 0) {
            this.field2539[var2.field2560][var2.field2561] = null;
            var2.field2559 = 0;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2060336392"
   )
   synchronized boolean method3689() {
      return this.field2537.method3838();
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-88"
   )
   void method3690(int var1) {
      if((this.field2529[var1] & 4) != 0) {
         for(class205 var2 = (class205)this.field2543.field2594.method3576(); var2 != null; var2 = (class205)this.field2543.field2594.method3578()) {
            if(var2.field2560 == var1) {
               var2.field2565 = 0;
            }
         }
      }

   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2079717355"
   )
   void method3692(int var1, int var2) {
      this.field2533[var1] = var2;
      this.field2542[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "495989381"
   )
   int method3693(class205 var1) {
      int var2 = (var1.field2548 * var1.field2555 >> 12) + var1.field2554;
      var2 += this.field2530[var1.field2560] * (this.field2525[var1.field2560] - 8192) >> 12;
      class202 var3 = var1.field2546;
      int var4;
      if(var3.field2507 > 0 && (var3.field2503 > 0 || this.field2517[var1.field2560] > 0)) {
         var4 = var3.field2503 << 2;
         int var5 = var3.field2508 << 1;
         if(var1.field2550 < var5) {
            var4 = var1.field2550 * var4 / var5;
         }

         var4 += this.field2517[var1.field2560] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2553 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2547.field1622 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class109.field1640 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "-209399052"
   )
   int method3694(class205 var1) {
      class202 var2 = var1.field2546;
      int var3 = this.field2521[var1.field2560] * this.field2519[var1.field2560] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2551 + 16384 >> 15;
      var3 = var3 * this.field2535 + 128 >> 8;
      if(var2.field2502 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2502 * 1.953125E-5D * (double)var1.field2545) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2500 != null) {
         var4 = var1.field2557;
         var5 = var2.field2500[var1.field2558 + 1];
         if(var1.field2558 < var2.field2500.length - 2) {
            var6 = (var2.field2500[var1.field2558] & 255) << 8;
            var7 = (var2.field2500[var1.field2558 + 2] & 255) << 8;
            var5 += (var2.field2500[var1.field2558 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2559 > 0 && var2.field2505 != null) {
         var4 = var1.field2559;
         var5 = var2.field2505[var1.field2556 + 1];
         if(var1.field2556 < var2.field2505.length - 2) {
            var6 = (var2.field2505[var1.field2556] & 255) << 8;
            var7 = (var2.field2505[var1.field2556 + 2] & 255) << 8;
            var5 += (var2.field2505[var1.field2556 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "-306716709"
   )
   int method3695(class205 var1) {
      int var2 = this.field2534[var1.field2560];
      return var2 < 8192?var2 * var1.field2552 + 32 >> 6:16384 - ((16384 - var2) * (128 - var1.field2552) + 32 >> 6);
   }

   @ObfuscatedName("y")
   protected synchronized class119 vmethod3858() {
      return this.field2543;
   }

   @ObfuscatedName("x")
   protected synchronized int vmethod3860() {
      return 0;
   }

   @ObfuscatedName("f")
   protected synchronized void vmethod3878(int[] var1, int var2, int var3) {
      if(this.field2537.method3838()) {
         int var4 = this.field2537.field2578 * this.field2518 / class109.field1640;

         do {
            long var5 = this.field2520 + (long)var4 * (long)var3;
            if(this.field2544 - var5 >= 0L) {
               this.field2520 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2544 - this.field2520) - 1L) / (long)var4);
            this.field2520 += (long)var7 * (long)var4;
            this.field2543.vmethod3878(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3770();
         } while(this.field2537.method3838());
      }

      this.field2543.vmethod3878(var1, var2, var3);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1401570082"
   )
   void method3700(int var1) {
      for(class205 var2 = (class205)this.field2543.field2594.method3576(); var2 != null; var2 = (class205)this.field2543.field2594.method3578()) {
         if(var1 < 0 || var1 == var2.field2560) {
            if(var2.field2563 != null) {
               var2.field2563.method2236(class109.field1640 / 100);
               if(var2.field2563.method2176()) {
                  this.field2543.field2596.method1884(var2.field2563);
               }

               var2.method3784();
            }

            if(var2.field2559 < 0) {
               this.field2539[var2.field2560][var2.field2561] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)Z",
      garbageValue = "-1994213957"
   )
   boolean method3702(class205 var1) {
      if(var1.field2563 == null) {
         if(var1.field2559 >= 0) {
            var1.unlink();
            if(var1.field2549 > 0 && this.field2536[var1.field2560][var1.field2549] == var1) {
               this.field2536[var1.field2560][var1.field2549] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(Lclass205;[IIII)Z",
      garbageValue = "-798878469"
   )
   boolean method3704(class205 var1, int[] var2, int var3, int var4) {
      var1.field2564 = class109.field1640 / 100;
      if(var1.field2559 < 0 || var1.field2563 != null && !var1.field2563.method2239()) {
         int var5 = var1.field2555;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2527[var1.field2560]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2555 = var5;
         }

         var1.field2563.method2121(this.method3693(var1));
         class202 var6 = var1.field2546;
         boolean var7 = false;
         ++var1.field2550;
         var1.field2553 += var6.field2507;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2561 - 60 << 8) + (var1.field2555 * var1.field2548 >> 12));
         if(var6.field2502 > 0) {
            if(var6.field2506 > 0) {
               var1.field2545 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2506) + 0.5D);
            } else {
               var1.field2545 += 128;
            }
         }

         if(var6.field2500 != null) {
            if(var6.field2501 > 0) {
               var1.field2557 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2501) + 0.5D);
            } else {
               var1.field2557 += 128;
            }

            while(var1.field2558 < var6.field2500.length - 2 && var1.field2557 > (var6.field2500[var1.field2558 + 2] & 255) << 8) {
               var1.field2558 += 2;
            }

            if(var6.field2500.length - 2 == var1.field2558 && var6.field2500[var1.field2558 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2559 >= 0 && var6.field2505 != null && (this.field2529[var1.field2560] & 1) == 0 && (var1.field2549 < 0 || this.field2536[var1.field2560][var1.field2549] != var1)) {
            if(var6.field2504 > 0) {
               var1.field2559 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2504 * var8) + 0.5D);
            } else {
               var1.field2559 += 128;
            }

            while(var1.field2556 < var6.field2505.length - 2 && var1.field2559 > (var6.field2505[var1.field2556 + 2] & 255) << 8) {
               var1.field2556 += 2;
            }

            if(var6.field2505.length - 2 == var1.field2556) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2563.method2236(var1.field2564);
            if(var2 != null) {
               var1.field2563.vmethod3878(var2, var3, var4);
            } else {
               var1.field2563.vmethod3862(var4);
            }

            if(var1.field2563.method2176()) {
               this.field2543.field2596.method1884(var1.field2563);
            }

            var1.method3784();
            if(var1.field2559 >= 0) {
               var1.unlink();
               if(var1.field2549 > 0 && var1 == this.field2536[var1.field2560][var1.field2549]) {
                  this.field2536[var1.field2560][var1.field2549] = null;
               }
            }

            return true;
         } else {
            var1.field2563.method2119(var1.field2564, this.method3694(var1), this.method3695(var1));
            return false;
         }
      } else {
         var1.method3784();
         var1.unlink();
         if(var1.field2549 > 0 && var1 == this.field2536[var1.field2560][var1.field2549]) {
            this.field2536[var1.field2560][var1.field2549] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "85"
   )
   void method3705(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3681(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3679(var3, var4, var5);
         } else {
            this.method3681(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3714(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2524[var3] = (var5 << 14) + (this.field2524[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2524[var3] = (var5 << 7) + (this.field2524[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2517[var3] = (var5 << 7) + (this.field2517[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2517[var3] = (this.field2517[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field2527[var3] = (var5 << 7) + (this.field2527[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2527[var3] = var5 + (this.field2527[var3] & -128);
         }

         if(var4 == 7) {
            this.field2519[var3] = (this.field2519[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 39) {
            this.field2519[var3] = var5 + (this.field2519[var3] & -128);
         }

         if(var4 == 10) {
            this.field2534[var3] = (this.field2534[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field2534[var3] = (this.field2534[var3] & -128) + var5;
         }

         if(var4 == 11) {
            this.field2521[var3] = (var5 << 7) + (this.field2521[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2521[var3] = var5 + (this.field2521[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2529[var3] |= 1;
            } else {
               this.field2529[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2529[var3] |= 2;
            } else {
               this.method3671(var3);
               this.field2529[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2526[var3] = (this.field2526[var3] & 127) + (var5 << 7);
         }

         if(var4 == 98) {
            this.field2526[var3] = var5 + (this.field2526[var3] & 16256);
         }

         if(var4 == 101) {
            this.field2526[var3] = (var5 << 7) + (this.field2526[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2526[var3] = var5 + (this.field2526[var3] & 16256) + 16384;
         }

         if(var4 == 120) {
            this.method3700(var3);
         }

         if(var4 == 121) {
            this.method3686(var3);
         }

         if(var4 == 123) {
            this.method3687(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2526[var3];
            if(var6 == 16384) {
               this.field2530[var3] = (this.field2530[var3] & -16257) + (var5 << 7);
            }
         }

         if(var4 == 38) {
            var6 = this.field2526[var3];
            if(var6 == 16384) {
               this.field2530[var3] = var5 + (this.field2530[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2532[var3] = (this.field2532[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 48) {
            this.field2532[var3] = (this.field2532[var3] & -128) + var5;
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2529[var3] |= 4;
            } else {
               this.method3690(var3);
               this.field2529[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3692(var3, (var5 << 7) + (this.field2533[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3692(var3, (this.field2533[var3] & -128) + var5);
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3678(var3, var4 + this.field2524[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3778(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 9 & 16256) + (var1 >> 8 & 127);
         this.method3684(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3780();
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1375405128"
   )
   public synchronized void method3707() {
      for(class207 var1 = (class207)this.field2531.method3518(); var1 != null; var1 = (class207)this.field2531.method3524()) {
         var1.method3853();
      }

   }

   public class204() {
      this.field2535 = 256;
      this.field2518 = 1000000;
      this.field2519 = new int[16];
      this.field2534 = new int[16];
      this.field2521 = new int[16];
      this.field2522 = new int[16];
      this.field2523 = new int[16];
      this.field2524 = new int[16];
      this.field2525 = new int[16];
      this.field2517 = new int[16];
      this.field2527 = new int[16];
      this.field2529 = new int[16];
      this.field2526 = new int[16];
      this.field2530 = new int[16];
      this.field2532 = new int[16];
      this.field2533 = new int[16];
      this.field2542 = new int[16];
      this.field2539 = new class205[16][128];
      this.field2536 = new class205[16][128];
      this.field2537 = new class206();
      this.field2543 = new class208(this);
      this.field2531 = new XHashTable(128);
      this.method3780();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "0"
   )
   void method3714(int var1, int var2, int var3) {
   }

   @ObfuscatedName("a")
   protected synchronized void vmethod3862(int var1) {
      if(this.field2537.method3838()) {
         int var2 = this.field2537.field2578 * this.field2518 / class109.field1640;

         do {
            long var3 = this.field2520 + (long)var1 * (long)var2;
            if(this.field2544 - var3 >= 0L) {
               this.field2520 = var3;
               break;
            }

            int var5 = (int)((this.field2544 - this.field2520 + (long)var2 - 1L) / (long)var2);
            this.field2520 += (long)var2 * (long)var5;
            this.field2543.vmethod3862(var5);
            var1 -= var5;
            this.method3770();
         } while(this.field2537.method3838());
      }

      this.field2543.vmethod3862(var1);
   }

   @ObfuscatedName("h")
   protected synchronized class119 vmethod3886() {
      return null;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-38"
   )
   void method3770() {
      int var1 = this.field2541;
      int var2 = this.field2540;

      long var3;
      for(var3 = this.field2544; var2 == this.field2540; var3 = this.field2537.method3804(var2)) {
         while(var2 == this.field2537.field2569[var1]) {
            this.field2537.method3834(var1);
            int var5 = this.field2537.method3801(var1);
            if(var5 == 1) {
               this.field2537.method3799();
               this.field2537.method3817(var1);
               if(this.field2537.method3806()) {
                  if(!this.field2538 || var2 == 0) {
                     this.method3780();
                     this.field2537.method3835();
                     return;
                  }

                  this.field2537.method3824(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3705(var5);
            }

            this.field2537.method3800(var1);
            this.field2537.method3817(var1);
         }

         var1 = this.field2537.method3805();
         var2 = this.field2537.field2569[var1];
      }

      this.field2541 = var1;
      this.field2540 = var2;
      this.field2544 = var3;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "327585286"
   )
   void method3778(int var1, int var2) {
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2118316534"
   )
   void method3780() {
      this.method3700(-1);
      this.method3686(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2523[var1] = this.field2522[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2524[var1] = this.field2522[var1] & -128;
      }

   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(LActor;IIIIII)V",
      garbageValue = "402460574"
   )
   static final void method3782(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if(var0 != null && var0.vmethod1691()) {
         if(var0 instanceof NPC) {
            NPCComposition var74 = ((NPC)var0).composition;
            if(var74.configs != null) {
               var74 = var74.method4652();
            }

            if(var74 == null) {
               return;
            }
         }

         int var6 = class96.field1507;
         int[] var7 = class96.field1508;
         int var8 = 3;
         int var14;
         int var21;
         int var22;
         if(!var0.combatInfoList.method3538()) {
            class56.method804(var0, var0.field1292 + 15);

            for(CombatInfoListHolder var9 = (CombatInfoListHolder)var0.combatInfoList.method3530(); var9 != null; var9 = (CombatInfoListHolder)var0.combatInfoList.method3540()) {
               CombatInfo1 var10 = var9.method1673(Client.gameCycle);
               if(var10 == null) {
                  if(var9.method1674()) {
                     var9.unlink();
                  }
               } else {
                  CombatInfo2 var11 = var9.combatInfo2;
                  SpritePixels var12 = var11.method4403();
                  SpritePixels var13 = var11.method4399();
                  int var15 = 0;
                  if(var12 != null && var13 != null) {
                     if(var11.field3372 * 2 < var13.width) {
                        var15 = var11.field3372;
                     }

                     var14 = var13.width - var15 * 2;
                  } else {
                     var14 = var11.healthScale;
                  }

                  int var16 = 255;
                  boolean var76 = true;
                  int var75 = Client.gameCycle - var10.field1306;
                  int var19 = var14 * var10.health / var11.healthScale;
                  int var20;
                  int var89;
                  if(var10.field1309 > var75) {
                     var20 = var11.field3369 == 0?0:var75 / var11.field3369 * var11.field3369;
                     var21 = var10.healthRatio * var14 / var11.healthScale;
                     var89 = (var19 - var21) * var20 / var10.field1309 + var21;
                  } else {
                     var89 = var19;
                     var20 = var11.field3370 + var10.field1309 - var75;
                     if(var11.field3368 >= 0) {
                        var16 = (var20 << 8) / (var11.field3370 - var11.field3368);
                     }
                  }

                  if(var10.health > 0 && var89 < 1) {
                     var89 = 1;
                  }

                  var20 = Client.field1124 + var2 - (var14 >> 1);
                  var21 = var3 + Client.field1093 - var8;
                  if(var12 != null && var13 != null) {
                     var20 -= var15;
                     if(var89 == var14) {
                        var89 += var15 * 2;
                     } else {
                        var89 += var15;
                     }

                     var22 = var12.height;
                     var8 += var22;
                     if(var16 >= 0 && var16 < 255) {
                        var12.method5052(var20, var21, var16);
                        Rasterizer2D.method4956(var20, var21, var89 + var20, var21 + var22);
                        var13.method5052(var20, var21, var16);
                     } else {
                        var12.method5047(var20, var21);
                        Rasterizer2D.method4956(var20, var21, var20 + var89, var22 + var21);
                        var13.method5047(var20, var21);
                     }

                     Rasterizer2D.method4940(var2, var3, var4 + var2, var5 + var3);
                     var8 += 2;
                  } else {
                     if(Client.field1124 > -1) {
                        Rasterizer2D.method4923(var20, var21, var89, 5, '\uff00');
                        Rasterizer2D.method4923(var20 + var89, var21, var14 - var89, 5, 16711680);
                     }

                     var8 += 7;
                  }
               }
            }
         }

         if(var8 < 30) {
            var8 = 30;
         }

         if(var1 < var6) {
            Player var85 = (Player)var0;
            if(var85.field913) {
               return;
            }

            if(var85.skullIcon != -1 || var85.overheadIcon != -1) {
               class56.method804(var0, var0.field1292 + 15);
               if(Client.field1124 > -1) {
                  if(var85.skullIcon != -1) {
                     class71.field873[var85.skullIcon].method5047(var2 + Client.field1124 - 12, Client.field1093 + var3 - var8);
                     var8 += 25;
                  }

                  if(var85.overheadIcon != -1) {
                     ScriptState.field781[var85.overheadIcon].method5047(Client.field1124 + var2 - 12, Client.field1093 + var3 - var8);
                     var8 += 25;
                  }
               }
            }

            if(var1 >= 0 && Client.field945 == 10 && var7[var1] == Client.field947) {
               class56.method804(var0, var0.field1292 + 15);
               if(Client.field1124 > -1) {
                  class51.field670[1].method5047(var2 + Client.field1124 - 12, Client.field1093 + var3 - var8);
               }
            }
         } else {
            NPCComposition var86 = ((NPC)var0).composition;
            if(var86.configs != null) {
               var86 = var86.method4652();
            }

            if(var86.field3573 >= 0 && var86.field3573 < ScriptState.field781.length) {
               class56.method804(var0, var0.field1292 + 15);
               if(Client.field1124 > -1) {
                  ScriptState.field781[var86.field3573].method5047(var2 + Client.field1124 - 12, Client.field1093 + var3 - 30);
               }
            }

            if(Client.field945 == 1 && Client.field946 == Client.field950[var1 - var6] && Client.gameCycle % 20 < 10) {
               class56.method804(var0, var0.field1292 + 15);
               if(Client.field1124 > -1) {
                  class51.field670[0].method5047(var2 + Client.field1124 - 12, Client.field1093 + var3 - 28);
               }
            }
         }

         if(var0.overhead != null && (var1 >= var6 || !var0.inSequence && (Client.field1031 == 4 || !var0.field1256 && (Client.field1031 == 0 || Client.field1031 == 3 || Client.field1031 == 1 && Projectile.method1749(((Player)var0).name, false))))) {
            class56.method804(var0, var0.field1292);
            if(Client.field1124 > -1 && Client.field1023 < Client.field1182) {
               Client.field998[Client.field1023] = XClanMember.field922.method4728(var0.overhead) / 2;
               Client.field1027[Client.field1023] = XClanMember.field922.field3652;
               Client.field1025[Client.field1023] = Client.field1124;
               Client.field1095[Client.field1023] = Client.field1093;
               Client.field1017[Client.field1023] = var0.field1245;
               Client.field1030[Client.field1023] = var0.field1294;
               Client.field1024[Client.field1023] = var0.field1258;
               Client.field1032[Client.field1023] = var0.overhead;
               ++Client.field1023;
            }
         }

         for(int var79 = 0; var79 < 4; ++var79) {
            int var80 = var0.field1264[var79];
            int var81 = var0.field1252[var79];
            class254 var87 = null;
            int var82 = 0;
            if(var81 >= 0) {
               if(var80 <= Client.gameCycle) {
                  continue;
               }

               var87 = class27.method203(var0.field1252[var79]);
               var82 = var87.field3416;
               if(var87 != null && var87.field3427 != null) {
                  var87 = var87.method4487();
                  if(var87 == null) {
                     var0.field1264[var79] = -1;
                     continue;
                  }
               }
            } else if(var80 < 0) {
               continue;
            }

            var14 = var0.field1265[var79];
            class254 var78 = null;
            if(var14 >= 0) {
               var78 = class27.method203(var14);
               if(var78 != null && var78.field3427 != null) {
                  var78 = var78.method4487();
               }
            }

            if(var80 - var82 <= Client.gameCycle) {
               if(var87 == null) {
                  var0.field1264[var79] = -1;
               } else {
                  class56.method804(var0, var0.field1292 / 2);
                  if(Client.field1124 > -1) {
                     if(var79 == 1) {
                        Client.field1093 -= 20;
                     }

                     if(var79 == 2) {
                        Client.field1124 -= 15;
                        Client.field1093 -= 10;
                     }

                     if(var79 == 3) {
                        Client.field1124 += 15;
                        Client.field1093 -= 10;
                     }

                     SpritePixels var17 = null;
                     SpritePixels var18 = null;
                     SpritePixels var83 = null;
                     SpritePixels var77 = null;
                     var21 = 0;
                     var22 = 0;
                     int var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     SpritePixels var29 = null;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     int var33 = 0;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     var17 = var87.method4509();
                     int var42;
                     if(var17 != null) {
                        var21 = var17.width;
                        var42 = var17.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var25 = var17.offsetX;
                     }

                     var18 = var87.method4491();
                     if(var18 != null) {
                        var22 = var18.width;
                        var42 = var18.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var26 = var18.offsetX;
                     }

                     var83 = var87.method4510();
                     if(var83 != null) {
                        var23 = var83.width;
                        var42 = var83.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var27 = var83.offsetX;
                     }

                     var77 = var87.method4492();
                     if(var77 != null) {
                        var24 = var77.width;
                        var42 = var77.height;
                        if(var42 > var41) {
                           var41 = var42;
                        }

                        var28 = var77.offsetX;
                     }

                     if(var78 != null) {
                        var29 = var78.method4509();
                        if(var29 != null) {
                           var33 = var29.width;
                           var42 = var29.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var37 = var29.offsetX;
                        }

                        var30 = var78.method4491();
                        if(var30 != null) {
                           var34 = var30.width;
                           var42 = var30.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var38 = var30.offsetX;
                        }

                        var31 = var78.method4510();
                        if(var31 != null) {
                           var35 = var31.width;
                           var42 = var31.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var39 = var31.offsetX;
                        }

                        var32 = var78.method4492();
                        if(var32 != null) {
                           var36 = var32.width;
                           var42 = var32.height;
                           if(var42 > var41) {
                              var41 = var42;
                           }

                           var40 = var32.offsetX;
                        }
                     }

                     Font var84 = var87.method4493();
                     if(var84 == null) {
                        var84 = class166.field2344;
                     }

                     Font var43;
                     if(var78 != null) {
                        var43 = var78.method4493();
                        if(var43 == null) {
                           var43 = class166.field2344;
                        }
                     } else {
                        var43 = class166.field2344;
                     }

                     String var44 = null;
                     String var45 = null;
                     boolean var46 = false;
                     int var47 = 0;
                     var44 = var87.method4488(var0.field1251[var79]);
                     int var88 = var84.method4728(var44);
                     if(var78 != null) {
                        var45 = var78.method4488(var0.field1266[var79]);
                        var47 = var43.method4728(var45);
                     }

                     int var48 = 0;
                     int var49 = 0;
                     if(var22 > 0) {
                        if(var83 == null && var77 == null) {
                           var48 = 1;
                        } else {
                           var48 = var88 / var22 + 1;
                        }
                     }

                     if(var78 != null && var34 > 0) {
                        if(var31 == null && var32 == null) {
                           var49 = 1;
                        } else {
                           var49 = var47 / var34 + 1;
                        }
                     }

                     int var50 = 0;
                     int var51 = var50;
                     if(var21 > 0) {
                        var50 += var21;
                     }

                     var50 += 2;
                     int var52 = var50;
                     if(var23 > 0) {
                        var50 += var23;
                     }

                     int var53 = var50;
                     int var54 = var50;
                     int var55;
                     if(var22 > 0) {
                        var55 = var48 * var22;
                        var50 += var55;
                        var54 += (var55 - var88) / 2;
                     } else {
                        var50 += var88;
                     }

                     var55 = var50;
                     if(var24 > 0) {
                        var50 += var24;
                     }

                     int var56 = 0;
                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61;
                     if(var78 != null) {
                        var50 += 2;
                        var56 = var50;
                        if(var33 > 0) {
                           var50 += var33;
                        }

                        var50 += 2;
                        var57 = var50;
                        if(var35 > 0) {
                           var50 += var35;
                        }

                        var58 = var50;
                        var60 = var50;
                        if(var34 > 0) {
                           var61 = var49 * var34;
                           var50 += var61;
                           var60 += (var61 - var47) / 2;
                        } else {
                           var50 += var47;
                        }

                        var59 = var50;
                        if(var36 > 0) {
                           var50 += var36;
                        }
                     }

                     var61 = var0.field1264[var79] - Client.gameCycle;
                     int var62 = var87.field3421 - var87.field3421 * var61 / var87.field3416;
                     int var63 = -var87.field3423 + var87.field3423 * var61 / var87.field3416;
                     int var64 = Client.field1124 + var2 - (var50 >> 1) + var62;
                     int var65 = var63 + (Client.field1093 + var3 - 12);
                     int var66 = var65;
                     int var67 = var65 + var41;
                     int var68 = var65 + 15 + var87.field3426;
                     int var69 = var68 - var84.field3639;
                     int var70 = var84.field3640 + var68;
                     if(var69 < var65) {
                        var66 = var69;
                     }

                     if(var70 > var67) {
                        var67 = var70;
                     }

                     int var71 = 0;
                     int var72;
                     int var73;
                     if(var78 != null) {
                        var71 = var78.field3426 + var65 + 15;
                        var72 = var71 - var43.field3639;
                        var73 = var71 + var43.field3640;
                        if(var72 < var66) {
                           ;
                        }

                        if(var73 > var67) {
                           ;
                        }
                     }

                     var72 = 255;
                     if(var87.field3428 >= 0) {
                        var72 = (var61 << 8) / (var87.field3416 - var87.field3428);
                     }

                     if(var72 >= 0 && var72 < 255) {
                        if(var17 != null) {
                           var17.method5052(var51 + var64 - var25, var65, var72);
                        }

                        if(var83 != null) {
                           var83.method5052(var52 + var64 - var27, var65, var72);
                        }

                        if(var18 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method5052(var64 + var53 - var26 + var22 * var73, var65, var72);
                           }
                        }

                        if(var77 != null) {
                           var77.method5052(var64 + var55 - var28, var65, var72);
                        }

                        var84.method4788(var44, var64 + var54, var68, var87.field3411, 0, var72);
                        if(var78 != null) {
                           if(var29 != null) {
                              var29.method5052(var56 + var64 - var37, var65, var72);
                           }

                           if(var31 != null) {
                              var31.method5052(var57 + var64 - var39, var65, var72);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5052(var58 + var64 - var38 + var73 * var34, var65, var72);
                              }
                           }

                           if(var32 != null) {
                              var32.method5052(var59 + var64 - var40, var65, var72);
                           }

                           var43.method4788(var45, var64 + var60, var71, var78.field3411, 0, var72);
                        }
                     } else {
                        if(var17 != null) {
                           var17.method5047(var51 + var64 - var25, var65);
                        }

                        if(var83 != null) {
                           var83.method5047(var52 + var64 - var27, var65);
                        }

                        if(var18 != null) {
                           for(var73 = 0; var73 < var48; ++var73) {
                              var18.method5047(var73 * var22 + (var53 + var64 - var26), var65);
                           }
                        }

                        if(var77 != null) {
                           var77.method5047(var55 + var64 - var28, var65);
                        }

                        var84.method4737(var44, var64 + var54, var68, var87.field3411 | -16777216, 0);
                        if(var78 != null) {
                           if(var29 != null) {
                              var29.method5047(var56 + var64 - var37, var65);
                           }

                           if(var31 != null) {
                              var31.method5047(var64 + var57 - var39, var65);
                           }

                           if(var30 != null) {
                              for(var73 = 0; var73 < var49; ++var73) {
                                 var30.method5047(var34 * var73 + (var58 + var64 - var38), var65);
                              }
                           }

                           if(var32 != null) {
                              var32.method5047(var64 + var59 - var40, var65);
                           }

                           var43.method4737(var45, var60 + var64, var71, var78.field3411 | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
