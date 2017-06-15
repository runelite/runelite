import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class204 extends class119 {
   @ObfuscatedName("i")
   int[] field2523;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1896984823
   )
   int field2524;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -169558947
   )
   int field2525;
   @ObfuscatedName("ax")
   class206 field2526;
   @ObfuscatedName("z")
   int[] field2527;
   @ObfuscatedName("j")
   int[] field2528;
   @ObfuscatedName("t")
   int[] field2529;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1438236341
   )
   int field2530;
   @ObfuscatedName("c")
   int[] field2531;
   @ObfuscatedName("o")
   int[] field2532;
   @ObfuscatedName("d")
   int[] field2533;
   @ObfuscatedName("b")
   int[] field2535;
   @ObfuscatedName("l")
   int[] field2537;
   @ObfuscatedName("h")
   int[] field2538;
   @ObfuscatedName("af")
   boolean field2539;
   @ObfuscatedName("q")
   int[] field2541;
   @ObfuscatedName("y")
   int[] field2542;
   @ObfuscatedName("u")
   class205[][] field2543;
   @ObfuscatedName("p")
   XHashTable field2544;
   @ObfuscatedName("n")
   int[] field2545;
   @ObfuscatedName("f")
   int[] field2546;
   @ObfuscatedName("av")
   class205[][] field2547;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1177009033
   )
   int field2548;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      longValue = -324498590313700679L
   )
   long field2549;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      longValue = -8293108877337841207L
   )
   long field2550;
   @ObfuscatedName("ab")
   class208 field2551;
   @ObfuscatedName("x")
   int[] field2552;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "21"
   )
   void method3572(int var1, int var2) {
      this.field2532[var1] = var2;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)Z",
      garbageValue = "1908397886"
   )
   boolean method3573(class205 var1) {
      if(var1.field2565 == null) {
         if(var1.field2572 >= 0) {
            var1.unlink();
            if(var1.field2558 > 0 && this.field2547[var1.field2575][var1.field2558] == var1) {
               this.field2547[var1.field2575][var1.field2558] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1678772703"
   )
   int method3574() {
      return this.field2524;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LTrack1;LIndexDataBase;Lclass112;II)Z",
      garbageValue = "1561938993"
   )
   public synchronized boolean method3575(Track1 var1, IndexDataBase var2, class112 var3, int var4) {
      var1.method3797();
      boolean var5 = true;
      Object var6 = null;
      int[] var10 = new int[]{var4};

      for(class199 var7 = (class199)var1.field2605.method3435(); var7 != null; var7 = (class199)var1.field2605.method3429()) {
         int var8 = (int)var7.hash;
         class207 var9 = (class207)this.field2544.method3425((long)var8);
         if(var9 == null) {
            var9 = World.method1499(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2544.method3426(var9, (long)var8);
         }

         if(!var9.method3763(var3, var7.field2497, var10)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3799();
      }

      return var5;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1112371832"
   )
   public synchronized void method3576() {
      for(class207 var1 = (class207)this.field2544.method3435(); var1 != null; var1 = (class207)this.field2544.method3429()) {
         var1.method3761();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LTrack1;ZI)V",
      garbageValue = "1797918349"
   )
   public synchronized void method3578(Track1 var1, boolean var2) {
      this.method3579();
      this.field2526.method3710(var1.field2604);
      this.field2539 = var2;
      this.field2549 = 0L;
      int var3 = this.field2526.method3713();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2526.method3714(var4);
         this.field2526.method3717(var4);
         this.field2526.method3718(var4);
      }

      this.field2530 = this.field2526.method3721();
      this.field2548 = this.field2526.field2580[this.field2530];
      this.field2550 = this.field2526.method3716(this.field2548);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "511948873"
   )
   public synchronized void method3579() {
      this.field2526.method3711();
      this.method3586();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1633624674"
   )
   synchronized void method3581() {
      for(class207 var1 = (class207)this.field2544.method3435(); var1 != null; var1 = (class207)this.field2544.method3429()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1641305150"
   )
   void method3582(int var1, int var2) {
      this.field2523[var1] = var2;
      this.field2531[var1] = var2 & -128;
      this.method3583(var1, var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "741479584"
   )
   void method3583(int var1, int var2) {
      if(this.field2546[var1] != var2) {
         this.field2546[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2547[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "301539421"
   )
   void method3584(int var1, int var2, int var3) {
      this.method3639(var1, var2, 64);
      if((this.field2537[var1] & 2) != 0) {
         for(class205 var4 = (class205)this.field2551.field2599.method3488(); var4 != null; var4 = (class205)this.field2551.field2599.method3490()) {
            if(var1 == var4.field2575 && var4.field2572 < 0) {
               this.field2543[var1][var4.field2574] = null;
               this.field2543[var1][var2] = var4;
               int var5 = var4.field2562 + (var4.field2563 * var4.field2564 >> 12);
               var4.field2562 += var2 - var4.field2574 << 8;
               var4.field2563 = var5 - var4.field2562;
               var4.field2564 = 4096;
               var4.field2574 = var2;
               return;
            }
         }
      }

      class207 var9 = (class207)this.field2544.method3425((long)this.field2546[var1]);
      if(var9 != null) {
         class107 var8 = var9.field2591[var2];
         if(var8 != null) {
            class205 var6 = new class205();
            var6.field2575 = var1;
            var6.field2555 = var9;
            var6.field2559 = var8;
            var6.field2557 = var9.field2595[var2];
            var6.field2558 = var9.field2596[var2];
            var6.field2574 = var2;
            var6.field2560 = var9.field2593[var2] * var9.field2597 * var3 * var3 + 1024 >> 11;
            var6.field2561 = var9.field2592[var2] & 255;
            var6.field2562 = (var2 << 8) - (var9.field2590[var2] & 32767);
            var6.field2569 = 0;
            var6.field2566 = 0;
            var6.field2567 = 0;
            var6.field2572 = -1;
            var6.field2554 = 0;
            if(this.field2552[var1] == 0) {
               var6.field2565 = class117.method2039(var8, this.method3663(var6), this.method3598(var6), this.method3638(var6));
            } else {
               var6.field2565 = class117.method2039(var8, this.method3663(var6), 0, this.method3638(var6));
               this.method3609(var6, var9.field2590[var2] < 0);
            }

            if(var9.field2590[var2] < 0) {
               var6.field2565.method2149(-1);
            }

            if(var6.field2558 >= 0) {
               class205 var7 = this.field2547[var1][var6.field2558];
               if(var7 != null && var7.field2572 < 0) {
                  this.field2543[var1][var7.field2574] = null;
                  var7.field2572 = 0;
               }

               this.field2547[var1][var6.field2558] = var6;
            }

            this.field2551.field2599.method3505(var6);
            this.field2543[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "463586957"
   )
   void method3586() {
      this.method3589(-1);
      this.method3590(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2546[var1] = this.field2523[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2531[var1] = this.field2523[var1] & -128;
      }

   }

   public class204() {
      this.field2524 = 256;
      this.field2525 = 1000000;
      this.field2529 = new int[16];
      this.field2527 = new int[16];
      this.field2528 = new int[16];
      this.field2523 = new int[16];
      this.field2546 = new int[16];
      this.field2531 = new int[16];
      this.field2532 = new int[16];
      this.field2541 = new int[16];
      this.field2545 = new int[16];
      this.field2537 = new int[16];
      this.field2538 = new int[16];
      this.field2533 = new int[16];
      this.field2552 = new int[16];
      this.field2535 = new int[16];
      this.field2542 = new int[16];
      this.field2543 = new class205[16][128];
      this.field2547 = new class205[16][128];
      this.field2526 = new class206();
      this.field2551 = new class208(this);
      this.field2544 = new XHashTable(128);
      this.method3586();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2041360069"
   )
   void method3587(int var1, int var2) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1508424305"
   )
   void method3589(int var1) {
      for(class205 var2 = (class205)this.field2551.field2599.method3487(); var2 != null; var2 = (class205)this.field2551.field2599.method3512()) {
         if(var1 < 0 || var1 == var2.field2575) {
            if(var2.field2565 != null) {
               var2.field2565.method2052(class109.field1635 / 100);
               if(var2.field2565.method2151()) {
                  this.field2551.field2603.method1806(var2.field2565);
               }

               var2.method3707();
            }

            if(var2.field2572 < 0) {
               this.field2543[var2.field2575][var2.field2574] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "405553043"
   )
   void method3590(int var1) {
      if(var1 >= 0) {
         this.field2529[var1] = 12800;
         this.field2527[var1] = 8192;
         this.field2528[var1] = 16383;
         this.field2532[var1] = 8192;
         this.field2541[var1] = 0;
         this.field2545[var1] = 8192;
         this.method3593(var1);
         this.method3594(var1);
         this.field2537[var1] = 0;
         this.field2538[var1] = 32767;
         this.field2533[var1] = 256;
         this.field2552[var1] = 0;
         this.method3596(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3590(var1);
         }

      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1057513521"
   )
   void method3591(int var1) {
      for(class205 var2 = (class205)this.field2551.field2599.method3487(); var2 != null; var2 = (class205)this.field2551.field2599.method3512()) {
         if((var1 < 0 || var2.field2575 == var1) && var2.field2572 < 0) {
            this.field2543[var2.field2575][var2.field2574] = null;
            var2.field2572 = 0;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "16"
   )
   public synchronized void method3592(int var1) {
      this.field2524 = var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "946778134"
   )
   void method3593(int var1) {
      if((this.field2537[var1] & 2) != 0) {
         for(class205 var2 = (class205)this.field2551.field2599.method3487(); var2 != null; var2 = (class205)this.field2551.field2599.method3512()) {
            if(var1 == var2.field2575 && this.field2543[var1][var2.field2574] == null && var2.field2572 < 0) {
               var2.field2572 = 0;
            }
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-57"
   )
   void method3594(int var1) {
      if((this.field2537[var1] & 4) != 0) {
         for(class205 var2 = (class205)this.field2551.field2599.method3487(); var2 != null; var2 = (class205)this.field2551.field2599.method3512()) {
            if(var1 == var2.field2575) {
               var2.field2568 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-88"
   )
   void method3596(int var1, int var2) {
      this.field2535[var1] = var2;
      this.field2542[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass205;B)I",
      garbageValue = "113"
   )
   int method3598(class205 var1) {
      class202 var2 = var1.field2557;
      int var3 = this.field2529[var1.field2575] * this.field2528[var1.field2575] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var1.field2560 * var3 + 16384 >> 15;
      var3 = this.field2524 * var3 + 128 >> 8;
      if(var2.field2503 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field2569 * 1.953125E-5D * (double)var2.field2503) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2510 != null) {
         var4 = var1.field2566;
         var5 = var2.field2510[var1.field2567 + 1];
         if(var1.field2567 < var2.field2510.length - 2) {
            var6 = (var2.field2510[var1.field2567] & 255) << 8;
            var7 = (var2.field2510[var1.field2567 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2510[var1.field2567 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2572 > 0 && var2.field2506 != null) {
         var4 = var1.field2572;
         var5 = var2.field2506[var1.field2554 + 1];
         if(var1.field2554 < var2.field2506.length - 2) {
            var6 = (var2.field2506[var1.field2554] & 255) << 8;
            var7 = (var2.field2506[var1.field2554 + 2] & 255) << 8;
            var5 += (var2.field2506[var1.field2554 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("z")
   protected synchronized class119 vmethod3771() {
      return this.field2551;
   }

   @ObfuscatedName("j")
   protected synchronized class119 vmethod3780() {
      return null;
   }

   @ObfuscatedName("c")
   protected synchronized int vmethod3772() {
      return 0;
   }

   @ObfuscatedName("o")
   protected synchronized void vmethod3775(int[] var1, int var2, int var3) {
      if(this.field2526.method3712()) {
         int var4 = this.field2526.field2576 * this.field2525 / class109.field1635;

         do {
            long var5 = this.field2549 + (long)var4 * (long)var3;
            if(this.field2550 - var5 >= 0L) {
               this.field2549 = var5;
               break;
            }

            int var7 = (int)((this.field2550 - this.field2549 + (long)var4 - 1L) / (long)var4);
            this.field2549 += (long)var7 * (long)var4;
            this.field2551.vmethod3775(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3605();
         } while(this.field2526.method3712());
      }

      this.field2551.vmethod3775(var1, var2, var3);
   }

   @ObfuscatedName("n")
   protected synchronized void vmethod3773(int var1) {
      if(this.field2526.method3712()) {
         int var2 = this.field2525 * this.field2526.field2576 / class109.field1635;

         do {
            long var3 = (long)var1 * (long)var2 + this.field2549;
            if(this.field2550 - var3 >= 0L) {
               this.field2549 = var3;
               break;
            }

            int var5 = (int)((this.field2550 - this.field2549 + (long)var2 - 1L) / (long)var2);
            this.field2549 += (long)var2 * (long)var5;
            this.field2551.vmethod3773(var5);
            var1 -= var5;
            this.method3605();
         } while(this.field2526.method3712());
      }

      this.field2551.vmethod3773(var1);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "18235"
   )
   void method3605() {
      int var1 = this.field2530;
      int var2 = this.field2548;

      long var3;
      for(var3 = this.field2550; this.field2548 == var2; var3 = this.field2526.method3716(var2)) {
         while(var2 == this.field2526.field2580[var1]) {
            this.field2526.method3714(var1);
            int var5 = this.field2526.method3757(var1);
            if(var5 == 1) {
               this.field2526.method3715();
               this.field2526.method3718(var1);
               if(this.field2526.method3754()) {
                  if(!this.field2539 || var2 == 0) {
                     this.method3586();
                     this.field2526.method3711();
                     return;
                  }

                  this.field2526.method3723(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3674(var5);
            }

            this.field2526.method3717(var1);
            this.field2526.method3718(var1);
         }

         var1 = this.field2526.method3721();
         var2 = this.field2526.field2580[var1];
      }

      this.field2530 = var1;
      this.field2548 = var2;
      this.field2550 = var3;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(Lclass205;[IIII)Z",
      garbageValue = "-1322039993"
   )
   boolean method3607(class205 var1, int[] var2, int var3, int var4) {
      var1.field2573 = class109.field1635 / 100;
      if(var1.field2572 < 0 || var1.field2565 != null && !var1.field2565.method2055()) {
         int var5 = var1.field2564;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2545[var1.field2575]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2564 = var5;
         }

         var1.field2565.method2146(this.method3663(var1));
         class202 var6 = var1.field2557;
         boolean var7 = false;
         ++var1.field2570;
         var1.field2571 += var6.field2509;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2563 * var1.field2564 >> 12) + (var1.field2574 - 60 << 8));
         if(var6.field2503 > 0) {
            if(var6.field2507 > 0) {
               var1.field2569 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2507 * var8) + 0.5D);
            } else {
               var1.field2569 += 128;
            }
         }

         if(var6.field2510 != null) {
            if(var6.field2511 > 0) {
               var1.field2566 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2511 * var8) + 0.5D);
            } else {
               var1.field2566 += 128;
            }

            while(var1.field2567 < var6.field2510.length - 2 && var1.field2566 > (var6.field2510[var1.field2567 + 2] & 255) << 8) {
               var1.field2567 += 2;
            }

            if(var1.field2567 == var6.field2510.length - 2 && var6.field2510[var1.field2567 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2572 >= 0 && var6.field2506 != null && (this.field2537[var1.field2575] & 1) == 0 && (var1.field2558 < 0 || var1 != this.field2547[var1.field2575][var1.field2558])) {
            if(var6.field2505 > 0) {
               var1.field2572 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2505) + 0.5D);
            } else {
               var1.field2572 += 128;
            }

            while(var1.field2554 < var6.field2506.length - 2 && var1.field2572 > (var6.field2506[var1.field2554 + 2] & 255) << 8) {
               var1.field2554 += 2;
            }

            if(var6.field2506.length - 2 == var1.field2554) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2565.method2052(var1.field2573);
            if(var2 != null) {
               var1.field2565.vmethod3775(var2, var3, var4);
            } else {
               var1.field2565.vmethod3773(var4);
            }

            if(var1.field2565.method2151()) {
               this.field2551.field2603.method1806(var1.field2565);
            }

            var1.method3707();
            if(var1.field2572 >= 0) {
               var1.unlink();
               if(var1.field2558 > 0 && this.field2547[var1.field2575][var1.field2558] == var1) {
                  this.field2547[var1.field2575][var1.field2558] = null;
               }
            }

            return true;
         } else {
            var1.field2565.method2051(var1.field2573, this.method3598(var1), this.method3638(var1));
            return false;
         }
      } else {
         var1.method3707();
         var1.unlink();
         if(var1.field2558 > 0 && this.field2547[var1.field2575][var1.field2558] == var1) {
            this.field2547[var1.field2575][var1.field2558] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass205;ZI)V",
      garbageValue = "-1582440226"
   )
   void method3609(class205 var1, boolean var2) {
      int var3 = var1.field2559.field1605.length;
      int var4;
      if(var2 && var1.field2559.field1608) {
         int var5 = var3 + var3 - var1.field2559.field1606;
         var4 = (int)((long)var5 * (long)this.field2552[var1.field2575] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2565.method2048();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2552[var1.field2575] >> 6);
      }

      var1.field2565.method2047(var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1759275311"
   )
   void method3629(int var1, int var2, int var3) {
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "1709541888"
   )
   int method3638(class205 var1) {
      int var2 = this.field2527[var1.field2575];
      return var2 < 8192?var1.field2561 * var2 + 32 >> 6:16384 - ((128 - var1.field2561) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-11"
   )
   void method3639(int var1, int var2, int var3) {
      class205 var4 = this.field2543[var1][var2];
      if(var4 != null) {
         this.field2543[var1][var2] = null;
         if((this.field2537[var1] & 2) != 0) {
            for(class205 var5 = (class205)this.field2551.field2599.method3487(); var5 != null; var5 = (class205)this.field2551.field2599.method3512()) {
               if(var4.field2575 == var5.field2575 && var5.field2572 < 0 && var4 != var5) {
                  var4.field2572 = 0;
                  break;
               }
            }
         } else {
            var4.field2572 = 0;
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(BI)C",
      garbageValue = "1164621252"
   )
   public static char method3645(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class266.field3665[var1 - 128];
            if(var2 == 0) {
               var2 = 63;
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "-224203475"
   )
   int method3663(class205 var1) {
      int var2 = var1.field2562 + (var1.field2563 * var1.field2564 >> 12);
      var2 += this.field2533[var1.field2575] * (this.field2532[var1.field2575] - 8192) >> 12;
      class202 var3 = var1.field2557;
      int var4;
      if(var3.field2509 > 0 && (var3.field2508 > 0 || this.field2541[var1.field2575] > 0)) {
         var4 = var3.field2508 << 2;
         int var5 = var3.field2504 << 1;
         if(var1.field2570 < var5) {
            var4 = var1.field2570 * var4 / var5;
         }

         var4 += this.field2541[var1.field2575] >> 7;
         double var6 = Math.sin((double)(var1.field2571 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2559.field1604 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class109.field1635 + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1029394650"
   )
   void method3674(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3639(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3584(var3, var4, var5);
         } else {
            this.method3639(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3629(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2531[var3] = (var5 << 14) + (this.field2531[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2531[var3] = (var5 << 7) + (this.field2531[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2541[var3] = (this.field2541[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 33) {
            this.field2541[var3] = (this.field2541[var3] & -128) + var5;
         }

         if(var4 == 5) {
            this.field2545[var3] = (this.field2545[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 37) {
            this.field2545[var3] = (this.field2545[var3] & -128) + var5;
         }

         if(var4 == 7) {
            this.field2529[var3] = (var5 << 7) + (this.field2529[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2529[var3] = (this.field2529[var3] & -128) + var5;
         }

         if(var4 == 10) {
            this.field2527[var3] = (this.field2527[var3] & -16257) + (var5 << 7);
         }

         if(var4 == 42) {
            this.field2527[var3] = var5 + (this.field2527[var3] & -128);
         }

         if(var4 == 11) {
            this.field2528[var3] = (var5 << 7) + (this.field2528[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2528[var3] = (this.field2528[var3] & -128) + var5;
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2537[var3] |= 1;
            } else {
               this.field2537[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2537[var3] |= 2;
            } else {
               this.method3593(var3);
               this.field2537[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2538[var3] = (var5 << 7) + (this.field2538[var3] & 127);
         }

         if(var4 == 98) {
            this.field2538[var3] = (this.field2538[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2538[var3] = (var5 << 7) + (this.field2538[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2538[var3] = var5 + (this.field2538[var3] & 16256) + 16384;
         }

         if(var4 == 120) {
            this.method3589(var3);
         }

         if(var4 == 121) {
            this.method3590(var3);
         }

         if(var4 == 123) {
            this.method3591(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2538[var3];
            if(var6 == 16384) {
               this.field2533[var3] = (var5 << 7) + (this.field2533[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2538[var3];
            if(var6 == 16384) {
               this.field2533[var3] = var5 + (this.field2533[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2552[var3] = (var5 << 7) + (this.field2552[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2552[var3] = (this.field2552[var3] & -128) + var5;
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2537[var3] |= 4;
            } else {
               this.method3594(var3);
               this.field2537[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3596(var3, (this.field2535[var3] & -16257) + (var5 << 7));
         }

         if(var4 == 49) {
            this.method3596(var3, var5 + (this.field2535[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3583(var3, var4 + this.field2531[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3587(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3572(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3586();
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "130481083"
   )
   public synchronized boolean method3675() {
      return this.field2526.method3712();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "412555307"
   )
   public synchronized void method3689(int var1, int var2) {
      this.method3582(var1, var2);
   }
}
