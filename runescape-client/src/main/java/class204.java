import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class204 extends class119 {
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 998947175
   )
   int field2540;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 270463471
   )
   int field2518;
   @ObfuscatedName("h")
   int[] field2529;
   @ObfuscatedName("e")
   int[] field2527;
   @ObfuscatedName("i")
   XHashTable field2530;
   @ObfuscatedName("y")
   int[] field2519;
   @ObfuscatedName("r")
   int[] field2522;
   @ObfuscatedName("j")
   int[] field2528;
   @ObfuscatedName("x")
   class205[][] field2536;
   @ObfuscatedName("u")
   int[] field2531;
   @ObfuscatedName("ab")
   class206 field2538;
   @ObfuscatedName("ay")
   class208 field2544;
   @ObfuscatedName("s")
   int[] field2521;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 400604741
   )
   int field2541;
   @ObfuscatedName("g")
   int[] field2535;
   @ObfuscatedName("k")
   int[] field2526;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      longValue = -7049425228986243699L
   )
   long field2523;
   @ObfuscatedName("v")
   int[] field2542;
   @ObfuscatedName("d")
   int[] field2533;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2032262181
   )
   int field2520;
   @ObfuscatedName("ah")
   class205[][] field2539;
   @ObfuscatedName("aw")
   boolean field2543;
   @ObfuscatedName("q")
   int[] field2532;
   @ObfuscatedName("z")
   int[] field2537;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      longValue = -861686253006922307L
   )
   long field2524;
   @ObfuscatedName("o")
   int[] field2534;
   @ObfuscatedName("p")
   int[] field2525;

   public class204() {
      this.field2518 = 256;
      this.field2520 = 1000000;
      this.field2521 = new int[16];
      this.field2522 = new int[16];
      this.field2542 = new int[16];
      this.field2519 = new int[16];
      this.field2528 = new int[16];
      this.field2526 = new int[16];
      this.field2527 = new int[16];
      this.field2534 = new int[16];
      this.field2537 = new int[16];
      this.field2531 = new int[16];
      this.field2525 = new int[16];
      this.field2532 = new int[16];
      this.field2533 = new int[16];
      this.field2529 = new int[16];
      this.field2535 = new int[16];
      this.field2536 = new class205[16][128];
      this.field2539 = new class205[16][128];
      this.field2538 = new class206();
      this.field2544 = new class208(this);
      this.field2530 = new XHashTable(128);
      this.method3687();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1389946008"
   )
   void method3696(int var1, int var2) {
      this.field2519[var1] = var2;
      this.field2526[var1] = var2 & -128;
      this.method3677(var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-113502192"
   )
   void method3680(int var1, int var2, int var3) {
      class205 var4 = this.field2536[var1][var2];
      if(var4 != null) {
         this.field2536[var1][var2] = null;
         if((this.field2531[var1] & 2) != 0) {
            for(class205 var5 = (class205)this.field2544.field2594.getFront(); var5 != null; var5 = (class205)this.field2544.field2594.getNext()) {
               if(var4.field2559 == var5.field2559 && var5.field2560 < 0 && var4 != var5) {
                  var4.field2560 = 0;
                  break;
               }
            }
         } else {
            var4.field2560 = 0;
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1195279213"
   )
   void method3684(int var1) {
      for(class205 var2 = (class205)this.field2544.field2594.getFront(); var2 != null; var2 = (class205)this.field2544.field2594.getNext()) {
         if(var1 < 0 || var2.field2559 == var1) {
            if(var2.field2564 != null) {
               var2.field2564.method2140(FileSystem.sampleRate / 100);
               if(var2.field2564.method2251()) {
                  this.field2544.field2595.method1890(var2.field2564);
               }

               var2.method3802();
            }

            if(var2.field2560 < 0) {
               this.field2536[var2.field2559][var2.field2551] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-668983901"
   )
   public synchronized void method3740() {
      this.field2538.method3815();
      this.method3687();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-450988003"
   )
   void method3685(int var1) {
      if(var1 >= 0) {
         this.field2521[var1] = 12800;
         this.field2522[var1] = 8192;
         this.field2542[var1] = 16383;
         this.field2527[var1] = 8192;
         this.field2534[var1] = 0;
         this.field2537[var1] = 8192;
         this.method3745(var1);
         this.method3689(var1);
         this.field2531[var1] = 0;
         this.field2525[var1] = 32767;
         this.field2532[var1] = 256;
         this.field2533[var1] = 0;
         this.method3691(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3685(var1);
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-36"
   )
   void method3732(int var1, int var2, int var3) {
      this.method3680(var1, var2, 64);
      if((this.field2531[var1] & 2) != 0) {
         for(class205 var4 = (class205)this.field2544.field2594.getTail(); var4 != null; var4 = (class205)this.field2544.field2594.getPrevious()) {
            if(var4.field2559 == var1 && var4.field2560 < 0) {
               this.field2536[var1][var4.field2551] = null;
               this.field2536[var1][var2] = var4;
               int var5 = (var4.field2565 * var4.field2549 >> 12) + var4.field2554;
               var4.field2554 += var2 - var4.field2551 << 8;
               var4.field2565 = var5 - var4.field2554;
               var4.field2549 = 4096;
               var4.field2551 = var2;
               return;
            }
         }
      }

      class207 var9 = (class207)this.field2530.get((long)this.field2528[var1]);
      if(var9 != null) {
         class107 var8 = var9.field2586[var2];
         if(var8 != null) {
            class205 var6 = new class205();
            var6.field2559 = var1;
            var6.field2547 = var9;
            var6.field2548 = var8;
            var6.field2566 = var9.field2581[var2];
            var6.field2550 = var9.field2583[var2];
            var6.field2551 = var2;
            var6.field2552 = var9.field2584[var2] * var9.field2588 * var3 * var3 + 1024 >> 11;
            var6.field2553 = var9.field2585[var2] & 255;
            var6.field2554 = (var2 << 8) - (var9.field2590[var2] & 32767);
            var6.field2557 = 0;
            var6.field2558 = 0;
            var6.field2546 = 0;
            var6.field2560 = -1;
            var6.field2561 = 0;
            if(this.field2533[var1] == 0) {
               var6.field2564 = class117.method2127(var8, this.method3692(var6), this.method3693(var6), this.method3799(var6));
            } else {
               var6.field2564 = class117.method2127(var8, this.method3692(var6), 0, this.method3799(var6));
               this.method3720(var6, var9.field2590[var2] < 0);
            }

            if(var9.field2590[var2] < 0) {
               var6.field2564.method2126(-1);
            }

            if(var6.field2550 >= 0) {
               class205 var7 = this.field2539[var1][var6.field2550];
               if(var7 != null && var7.field2560 < 0) {
                  this.field2536[var1][var7.field2551] = null;
                  var7.field2560 = 0;
               }

               this.field2539[var1][var6.field2550] = var6;
            }

            this.field2544.field2594.addFront(var6);
            this.field2536[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "767907158"
   )
   void method3796(int var1, int var2, int var3) {
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-918348337"
   )
   void method3687() {
      this.method3684(-1);
      this.method3685(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2528[var1] = this.field2519[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2526[var1] = this.field2519[var1] & -128;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "704957520"
   )
   void method3677(int var1, int var2) {
      if(var2 != this.field2528[var1]) {
         this.field2528[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2539[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("j")
   protected synchronized void vmethod3889(int[] var1, int var2, int var3) {
      if(this.field2538.method3809()) {
         int var4 = this.field2538.field2568 * this.field2520 / FileSystem.sampleRate;

         do {
            long var5 = (long)var4 * (long)var3 + this.field2524;
            if(this.field2523 - var5 >= 0L) {
               this.field2524 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2523 - this.field2524) - 1L) / (long)var4);
            this.field2524 += (long)var4 * (long)var7;
            this.field2544.vmethod3889(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3699();
         } while(this.field2538.method3809());
      }

      this.field2544.vmethod3889(var1, var2, var3);
   }

   @ObfuscatedName("e")
   protected synchronized void vmethod3885(int var1) {
      if(this.field2538.method3809()) {
         int var2 = this.field2538.field2568 * this.field2520 / FileSystem.sampleRate;

         do {
            long var3 = this.field2524 + (long)var2 * (long)var1;
            if(this.field2523 - var3 >= 0L) {
               this.field2524 = var3;
               break;
            }

            int var5 = (int)((this.field2523 - this.field2524 + (long)var2 - 1L) / (long)var2);
            this.field2524 += (long)var5 * (long)var2;
            this.field2544.vmethod3885(var5);
            var1 -= var5;
            this.method3699();
         } while(this.field2538.method3809());
      }

      this.field2544.vmethod3885(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-24"
   )
   void method3682(int var1, int var2) {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-716782366"
   )
   void method3683(int var1, int var2) {
      this.field2527[var1] = var2;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "1457717810"
   )
   int method3692(class205 var1) {
      int var2 = (var1.field2565 * var1.field2549 >> 12) + var1.field2554;
      var2 += (this.field2527[var1.field2559] - 8192) * this.field2532[var1.field2559] >> 12;
      class202 var3 = var1.field2566;
      int var4;
      if(var3.field2500 > 0 && (var3.field2504 > 0 || this.field2534[var1.field2559] > 0)) {
         var4 = var3.field2504 << 2;
         int var5 = var3.field2501 << 1;
         if(var1.field2562 < var5) {
            var4 = var4 * var1.field2562 / var5;
         }

         var4 += this.field2534[var1.field2559] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2555 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2548.field1633 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)FileSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("v")
   protected synchronized class119 vmethod3865() {
      return null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LTrack1;LIndexDataBase;Lclass112;IB)Z",
      garbageValue = "13"
   )
   public synchronized boolean method3669(Track1 var1, IndexDataBase var2, class112 var3, int var4) {
      var1.method3892();
      boolean var5 = true;
      Object var6 = null;
      int[] var12 = new int[]{var4};

      for(class199 var7 = (class199)var1.field2600.method3533(); var7 != null; var7 = (class199)var1.field2600.method3538()) {
         int var8 = (int)var7.hash;
         class207 var9 = (class207)this.field2530.get((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method4120(var8);
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

            this.field2530.put(var10, (long)var8);
         }

         if(!var9.method3859(var3, var7.field2488, var12)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3891();
      }

      return var5;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(Lclass205;B)Z",
      garbageValue = "4"
   )
   boolean method3700(class205 var1) {
      if(var1.field2564 == null) {
         if(var1.field2560 >= 0) {
            var1.unlink();
            if(var1.field2550 > 0 && var1 == this.field2539[var1.field2559][var1.field2550]) {
               this.field2539[var1.field2559][var1.field2550] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   void method3745(int var1) {
      if((this.field2531[var1] & 2) != 0) {
         for(class205 var2 = (class205)this.field2544.field2594.getFront(); var2 != null; var2 = (class205)this.field2544.field2594.getNext()) {
            if(var2.field2559 == var1 && this.field2536[var1][var2.field2551] == null && var2.field2560 < 0) {
               var2.field2560 = 0;
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-664196668"
   )
   public int method3668() {
      return this.field2518;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1128316845"
   )
   void method3689(int var1) {
      if((this.field2531[var1] & 4) != 0) {
         for(class205 var2 = (class205)this.field2544.field2594.getFront(); var2 != null; var2 = (class205)this.field2544.field2594.getNext()) {
            if(var2.field2559 == var1) {
               var2.field2556 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1423310379"
   )
   void method3751(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3680(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3732(var3, var4, var5);
         } else {
            this.method3680(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3796(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2526[var3] = (var5 << 14) + (this.field2526[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2526[var3] = (var5 << 7) + (this.field2526[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2534[var3] = (var5 << 7) + (this.field2534[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2534[var3] = var5 + (this.field2534[var3] & -128);
         }

         if(var4 == 5) {
            this.field2537[var3] = (var5 << 7) + (this.field2537[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2537[var3] = var5 + (this.field2537[var3] & -128);
         }

         if(var4 == 7) {
            this.field2521[var3] = (var5 << 7) + (this.field2521[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2521[var3] = var5 + (this.field2521[var3] & -128);
         }

         if(var4 == 10) {
            this.field2522[var3] = (var5 << 7) + (this.field2522[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2522[var3] = var5 + (this.field2522[var3] & -128);
         }

         if(var4 == 11) {
            this.field2542[var3] = (var5 << 7) + (this.field2542[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2542[var3] = var5 + (this.field2542[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2531[var3] |= 1;
            } else {
               this.field2531[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2531[var3] |= 2;
            } else {
               this.method3745(var3);
               this.field2531[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2525[var3] = (var5 << 7) + (this.field2525[var3] & 127);
         }

         if(var4 == 98) {
            this.field2525[var3] = (this.field2525[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2525[var3] = (var5 << 7) + (this.field2525[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2525[var3] = var5 + (this.field2525[var3] & 16256) + 16384;
         }

         if(var4 == 120) {
            this.method3684(var3);
         }

         if(var4 == 121) {
            this.method3685(var3);
         }

         if(var4 == 123) {
            this.method3686(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2525[var3];
            if(var6 == 16384) {
               this.field2532[var3] = (var5 << 7) + (this.field2532[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2525[var3];
            if(var6 == 16384) {
               this.field2532[var3] = var5 + (this.field2532[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2533[var3] = (var5 << 7) + (this.field2533[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2533[var3] = var5 + (this.field2533[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2531[var3] |= 4;
            } else {
               this.method3689(var3);
               this.field2531[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3691(var3, (var5 << 7) + (this.field2529[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3691(var3, var5 + (this.field2529[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3677(var3, var4 + this.field2526[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3682(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3683(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3687();
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "633523269"
   )
   public synchronized boolean method3674() {
      return this.field2538.method3809();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1950534319"
   )
   public synchronized void method3666() {
      for(class207 var1 = (class207)this.field2530.method3533(); var1 != null; var1 = (class207)this.field2530.method3538()) {
         var1.method3858();
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   public synchronized void method3671() {
      for(class207 var1 = (class207)this.field2530.method3533(); var1 != null; var1 = (class207)this.field2530.method3538()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(Lclass205;[IIII)Z",
      garbageValue = "953991035"
   )
   boolean method3701(class205 var1, int[] var2, int var3, int var4) {
      var1.field2563 = FileSystem.sampleRate / 100;
      if(var1.field2560 < 0 || var1.field2564 != null && !var1.field2564.method2135()) {
         int var5 = var1.field2549;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2537[var1.field2559]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2549 = var5;
         }

         var1.field2564.method2203(this.method3692(var1));
         class202 var6 = var1.field2566;
         boolean var7 = false;
         ++var1.field2562;
         var1.field2555 += var6.field2500;
         double var8 = (double)((var1.field2551 - 60 << 8) + (var1.field2565 * var1.field2549 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2495 > 0) {
            if(var6.field2499 > 0) {
               var1.field2557 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2499 * var8) + 0.5D);
            } else {
               var1.field2557 += 128;
            }
         }

         if(var6.field2503 != null) {
            if(var6.field2498 > 0) {
               var1.field2558 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2498) + 0.5D);
            } else {
               var1.field2558 += 128;
            }

            while(var1.field2546 < var6.field2503.length - 2 && var1.field2558 > (var6.field2503[var1.field2546 + 2] & 255) << 8) {
               var1.field2546 += 2;
            }

            if(var6.field2503.length - 2 == var1.field2546 && var6.field2503[var1.field2546 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2560 >= 0 && var6.field2494 != null && (this.field2531[var1.field2559] & 1) == 0 && (var1.field2550 < 0 || var1 != this.field2539[var1.field2559][var1.field2550])) {
            if(var6.field2497 > 0) {
               var1.field2560 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2497) + 0.5D);
            } else {
               var1.field2560 += 128;
            }

            while(var1.field2561 < var6.field2494.length - 2 && var1.field2560 > (var6.field2494[var1.field2561 + 2] & 255) << 8) {
               var1.field2561 += 2;
            }

            if(var6.field2494.length - 2 == var1.field2561) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2564.method2140(var1.field2563);
            if(var2 != null) {
               var1.field2564.vmethod3889(var2, var3, var4);
            } else {
               var1.field2564.vmethod3885(var4);
            }

            if(var1.field2564.method2251()) {
               this.field2544.field2595.method1890(var1.field2564);
            }

            var1.method3802();
            if(var1.field2560 >= 0) {
               var1.unlink();
               if(var1.field2550 > 0 && var1 == this.field2539[var1.field2559][var1.field2550]) {
                  this.field2539[var1.field2559][var1.field2550] = null;
               }
            }

            return true;
         } else {
            var1.field2564.method2139(var1.field2563, this.method3693(var1), this.method3799(var1));
            return false;
         }
      } else {
         var1.method3802();
         var1.unlink();
         if(var1.field2550 > 0 && var1 == this.field2539[var1.field2559][var1.field2550]) {
            this.field2539[var1.field2559][var1.field2550] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1723187737"
   )
   public synchronized void method3694(int var1) {
      this.field2518 = var1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "685612868"
   )
   void method3691(int var1, int var2) {
      this.field2529[var1] = var2;
      this.field2535[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("r")
   protected synchronized class119 vmethod3864() {
      return this.field2544;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LTrack1;ZI)V",
      garbageValue = "863740167"
   )
   public synchronized void method3672(Track1 var1, boolean var2) {
      this.method3740();
      this.field2538.method3855(var1.field2599);
      this.field2543 = var2;
      this.field2524 = 0L;
      int var3 = this.field2538.method3810();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2538.method3811(var4);
         this.field2538.method3814(var4);
         this.field2538.method3812(var4);
      }

      this.field2540 = this.field2538.method3851();
      this.field2541 = this.field2538.field2571[this.field2540];
      this.field2523 = this.field2538.method3827(this.field2541);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2129849400"
   )
   void method3699() {
      int var1 = this.field2540;
      int var2 = this.field2541;

      long var3;
      for(var3 = this.field2523; var2 == this.field2541; var3 = this.field2538.method3827(var2)) {
         while(var2 == this.field2538.field2571[var1]) {
            this.field2538.method3811(var1);
            int var5 = this.field2538.method3816(var1);
            if(var5 == 1) {
               this.field2538.method3813();
               this.field2538.method3812(var1);
               if(this.field2538.method3822()) {
                  if(!this.field2543 || var2 == 0) {
                     this.method3687();
                     this.field2538.method3815();
                     return;
                  }

                  this.field2538.method3818(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3751(var5);
            }

            this.field2538.method3814(var1);
            this.field2538.method3812(var1);
         }

         var1 = this.field2538.method3851();
         var2 = this.field2538.field2571[var1];
      }

      this.field2540 = var1;
      this.field2541 = var2;
      this.field2523 = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass205;ZB)V",
      garbageValue = "-50"
   )
   void method3720(class205 var1, boolean var2) {
      int var3 = var1.field2548.field1630.length;
      int var4;
      if(var2 && var1.field2548.field1632) {
         int var5 = var3 + var3 - var1.field2548.field1629;
         var4 = (int)((long)this.field2533[var1.field2559] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2564.method2136();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2533[var1.field2559] >> 6);
      }

      var1.field2564.method2129(var4);
   }

   @ObfuscatedName("y")
   protected synchronized int vmethod3888() {
      return 0;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lclass205;B)I",
      garbageValue = "-6"
   )
   int method3693(class205 var1) {
      class202 var2 = var1.field2566;
      int var3 = this.field2521[var1.field2559] * this.field2542[var1.field2559] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2552 + 16384 >> 15;
      var3 = var3 * this.field2518 + 128 >> 8;
      if(var2.field2495 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2495 * (double)var1.field2557 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2503 != null) {
         var4 = var1.field2558;
         var5 = var2.field2503[var1.field2546 + 1];
         if(var1.field2546 < var2.field2503.length - 2) {
            var6 = (var2.field2503[var1.field2546] & 255) << 8;
            var7 = (var2.field2503[var1.field2546 + 2] & 255) << 8;
            var5 += (var2.field2503[var1.field2546 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2560 > 0 && var2.field2494 != null) {
         var4 = var1.field2560;
         var5 = var2.field2494[var1.field2561 + 1];
         if(var1.field2561 < var2.field2494.length - 2) {
            var6 = (var2.field2494[var1.field2561] & 255) << 8;
            var7 = (var2.field2494[var1.field2561 + 2] & 255) << 8;
            var5 += (var2.field2494[var1.field2561 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "-231585727"
   )
   int method3799(class205 var1) {
      int var2 = this.field2522[var1.field2559];
      return var2 < 8192?var1.field2553 * var2 + 32 >> 6:16384 - ((128 - var1.field2553) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1230586723"
   )
   public synchronized void method3675(int var1, int var2) {
      this.method3696(var1, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   void method3686(int var1) {
      for(class205 var2 = (class205)this.field2544.field2594.getFront(); var2 != null; var2 = (class205)this.field2544.field2594.getNext()) {
         if((var1 < 0 || var2.field2559 == var1) && var2.field2560 < 0) {
            this.field2536[var2.field2559][var2.field2551] = null;
            var2.field2560 = 0;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1079332985"
   )
   public static boolean method3743(int var0) {
      return var0 == class221.field2841.field2842;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1640332215"
   )
   public static boolean method3798(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
