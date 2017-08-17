import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class205 extends class120 {
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -508490345
   )
   int field2532;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1952615853
   )
   int field2511;
   @ObfuscatedName("q")
   int[] field2527;
   @ObfuscatedName("o")
   int[] field2514;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   XHashTable field2515;
   @ObfuscatedName("x")
   int[] field2533;
   @ObfuscatedName("l")
   int[] field2517;
   @ObfuscatedName("c")
   int[] field2528;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[[Lgm;"
   )
   class206[][] field2529;
   @ObfuscatedName("y")
   int[] field2523;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   class207 field2531;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   class209 field2537;
   @ObfuscatedName("p")
   int[] field2513;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1910143711
   )
   int field2534;
   @ObfuscatedName("n")
   int[] field2516;
   @ObfuscatedName("b")
   int[] field2518;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      longValue = 7837689466285561751L
   )
   long field2536;
   @ObfuscatedName("g")
   int[] field2510;
   @ObfuscatedName("k")
   int[] field2526;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1321020997
   )
   int field2512;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "[[Lgm;"
   )
   class206[][] field2530;
   @ObfuscatedName("an")
   boolean field2519;
   @ObfuscatedName("u")
   int[] field2525;
   @ObfuscatedName("i")
   int[] field2521;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      longValue = 3998992942954658031L
   )
   long field2535;
   @ObfuscatedName("m")
   int[] field2520;
   @ObfuscatedName("z")
   int[] field2524;

   public class205() {
      this.field2511 = 256;
      this.field2512 = 1000000;
      this.field2513 = new int[16];
      this.field2533 = new int[16];
      this.field2510 = new int[16];
      this.field2528 = new int[16];
      this.field2517 = new int[16];
      this.field2518 = new int[16];
      this.field2514 = new int[16];
      this.field2520 = new int[16];
      this.field2521 = new int[16];
      this.field2523 = new int[16];
      this.field2524 = new int[16];
      this.field2525 = new int[16];
      this.field2526 = new int[16];
      this.field2527 = new int[16];
      this.field2516 = new int[16];
      this.field2529 = new class206[16][128];
      this.field2530 = new class206[16][128];
      this.field2531 = new class207();
      this.field2537 = new class209(this);
      this.field2515 = new XHashTable(128);
      this.method3709();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-977179636"
   )
   void method3698(int var1, int var2) {
      this.field2528[var1] = var2;
      this.field2518[var1] = var2 & -128;
      this.method3806(var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1604256072"
   )
   void method3702(int var1, int var2, int var3) {
      class206 var4 = this.field2529[var1][var2];
      if(var4 != null) {
         this.field2529[var1][var2] = null;
         if((this.field2523[var1] & 2) != 0) {
            for(class206 var5 = (class206)this.field2537.field2591.getFront(); var5 != null; var5 = (class206)this.field2537.field2591.getNext()) {
               if(var5.field2544 == var4.field2544 && var5.field2553 < 0 && var5 != var4) {
                  var4.field2553 = 0;
                  break;
               }
            }
         } else {
            var4.field2553 = 0;
         }

      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1543913822"
   )
   void method3743(int var1) {
      for(class206 var2 = (class206)this.field2537.field2591.getFront(); var2 != null; var2 = (class206)this.field2537.field2591.getNext()) {
         if(var1 < 0 || var2.field2544 == var1) {
            if(var2.field2557 != null) {
               var2.field2557.method2199(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2557.method2204()) {
                  this.field2537.field2589.method1894(var2.field2557);
               }

               var2.method3817();
            }

            if(var2.field2553 < 0) {
               this.field2529[var2.field2544][var2.field2559] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public synchronized void method3758() {
      this.field2531.method3826();
      this.method3709();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1693918998"
   )
   void method3719(int var1) {
      if(var1 >= 0) {
         this.field2513[var1] = 12800;
         this.field2533[var1] = 8192;
         this.field2510[var1] = 16383;
         this.field2514[var1] = 8192;
         this.field2520[var1] = 0;
         this.field2521[var1] = 8192;
         this.method3786(var1);
         this.method3711(var1);
         this.field2523[var1] = 0;
         this.field2524[var1] = 32767;
         this.field2525[var1] = 256;
         this.field2526[var1] = 0;
         this.method3713(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3719(var1);
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-30"
   )
   void method3703(int var1, int var2, int var3) {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1207632709"
   )
   void method3764(int var1, int var2, int var3) {
      this.method3702(var1, var2, 64);
      if((this.field2523[var1] & 2) != 0) {
         for(class206 var4 = (class206)this.field2537.field2591.getTail(); var4 != null; var4 = (class206)this.field2537.field2591.getPrevious()) {
            if(var4.field2544 == var1 && var4.field2553 < 0) {
               this.field2529[var1][var4.field2559] = null;
               this.field2529[var1][var2] = var4;
               int var5 = (var4.field2548 * var4.field2549 >> 12) + var4.field2547;
               var4.field2547 += var2 - var4.field2559 << 8;
               var4.field2548 = var5 - var4.field2547;
               var4.field2549 = 4096;
               var4.field2559 = var2;
               return;
            }
         }
      }

      class208 var9 = (class208)this.field2515.get((long)this.field2517[var1]);
      if(var9 != null) {
         class108 var8 = var9.field2578[var2];
         if(var8 != null) {
            class206 var6 = new class206();
            var6.field2544 = var1;
            var6.field2540 = var9;
            var6.field2542 = var8;
            var6.field2541 = var9.field2582[var2];
            var6.field2543 = var9.field2583[var2];
            var6.field2559 = var2;
            var6.field2545 = var3 * var3 * var9.field2584[var2] * var9.field2581 + 1024 >> 11;
            var6.field2546 = var9.field2587[var2] & 255;
            var6.field2547 = (var2 << 8) - (var9.field2579[var2] & 32767);
            var6.field2550 = 0;
            var6.field2539 = 0;
            var6.field2552 = 0;
            var6.field2553 = -1;
            var6.field2555 = 0;
            if(this.field2526[var1] == 0) {
               var6.field2557 = class118.method2261(var8, this.method3714(var6), this.method3715(var6), this.method3716(var6));
            } else {
               var6.field2557 = class118.method2261(var8, this.method3714(var6), 0, this.method3716(var6));
               this.method3710(var6, var9.field2579[var2] < 0);
            }

            if(var9.field2579[var2] < 0) {
               var6.field2557.method2184(-1);
            }

            if(var6.field2543 >= 0) {
               class206 var7 = this.field2530[var1][var6.field2543];
               if(var7 != null && var7.field2553 < 0) {
                  this.field2529[var1][var7.field2559] = null;
                  var7.field2553 = 0;
               }

               this.field2530[var1][var6.field2543] = var6;
            }

            this.field2537.field2591.addFront(var6);
            this.field2529[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1551656833"
   )
   void method3709() {
      this.method3743(-1);
      this.method3719(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2517[var1] = this.field2528[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2518[var1] = this.field2528[var1] & -128;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1128486646"
   )
   void method3806(int var1, int var2) {
      if(var2 != this.field2517[var1]) {
         this.field2517[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2530[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("w")
   protected synchronized void vmethod3904(int[] var1, int var2, int var3) {
      if(this.field2531.method3854()) {
         int var4 = this.field2531.field2576 * this.field2512 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = this.field2535 + (long)var3 * (long)var4;
            if(this.field2536 - var5 >= 0L) {
               this.field2535 = var5;
               break;
            }

            int var7 = (int)((this.field2536 - this.field2535 + (long)var4 - 1L) / (long)var4);
            this.field2535 += (long)var7 * (long)var4;
            this.field2537.vmethod3904(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3722();
         } while(this.field2531.method3854());
      }

      this.field2537.vmethod3904(var1, var2, var3);
   }

   @ObfuscatedName("o")
   protected synchronized void vmethod3893(int var1) {
      if(this.field2531.method3854()) {
         int var2 = this.field2531.field2576 * this.field2512 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = (long)var2 * (long)var1 + this.field2535;
            if(this.field2536 - var3 >= 0L) {
               this.field2535 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2536 - this.field2535) - 1L) / (long)var2);
            this.field2535 += (long)var5 * (long)var2;
            this.field2537.vmethod3893(var5);
            var1 -= var5;
            this.method3722();
         } while(this.field2531.method3854());
      }

      this.field2537.vmethod3893(var1);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2054796291"
   )
   void method3771(int var1, int var2) {
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1842573418"
   )
   void method3705(int var1, int var2) {
      this.field2514[var1] = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "()Lda;"
   )
   protected synchronized class120 vmethod3888() {
      return null;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lgm;I)I",
      garbageValue = "-598195561"
   )
   int method3714(class206 var1) {
      int var2 = (var1.field2549 * var1.field2548 >> 12) + var1.field2547;
      var2 += (this.field2514[var1.field2544] - 8192) * this.field2525[var1.field2544] >> 12;
      class203 var3 = var1.field2541;
      int var4;
      if(var3.field2495 > 0 && (var3.field2488 > 0 || this.field2520[var1.field2544] > 0)) {
         var4 = var3.field2488 << 2;
         int var5 = var3.field2496 << 1;
         if(var1.field2556 < var5) {
            var4 = var4 * var1.field2556 / var5;
         }

         var4 += this.field2520[var1.field2544] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2554 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2542.field1615 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lhe;Lia;Ldy;II)Z",
      garbageValue = "1796561030"
   )
   public synchronized boolean method3690(Track1 var1, IndexDataBase var2, class113 var3, int var4) {
      var1.method3914();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(class200 var7 = (class200)var1.field2592.method3558(); var7 != null; var7 = (class200)var1.field2592.method3559()) {
         int var8 = (int)var7.hash;
         class208 var9 = (class208)this.field2515.get((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method4119(var8);
            class208 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class208(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field2515.put(var10, (long)var8);
         }

         if(!var9.method3877(var3, var7.field2483, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3916();
      }

      return var5;
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(Lgm;I)Z",
      garbageValue = "1656129855"
   )
   boolean method3695(class206 var1) {
      if(var1.field2557 == null) {
         if(var1.field2553 >= 0) {
            var1.unlink();
            if(var1.field2543 > 0 && var1 == this.field2530[var1.field2544][var1.field2543]) {
               this.field2530[var1.field2544][var1.field2543] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-954059980"
   )
   void method3786(int var1) {
      if((this.field2523[var1] & 2) != 0) {
         for(class206 var2 = (class206)this.field2537.field2591.getFront(); var2 != null; var2 = (class206)this.field2537.field2591.getNext()) {
            if(var2.field2544 == var1 && this.field2529[var1][var2.field2559] == null && var2.field2553 < 0) {
               var2.field2553 = 0;
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-9"
   )
   int method3704() {
      return this.field2511;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1782527166"
   )
   void method3711(int var1) {
      if((this.field2523[var1] & 4) != 0) {
         for(class206 var2 = (class206)this.field2537.field2591.getFront(); var2 != null; var2 = (class206)this.field2537.field2591.getNext()) {
            if(var2.field2544 == var1) {
               var2.field2560 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1661170871"
   )
   void method3712(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3702(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3764(var3, var4, var5);
         } else {
            this.method3702(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3703(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2518[var3] = (var5 << 14) + (this.field2518[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2518[var3] = (var5 << 7) + (this.field2518[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2520[var3] = (var5 << 7) + (this.field2520[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2520[var3] = var5 + (this.field2520[var3] & -128);
         }

         if(var4 == 5) {
            this.field2521[var3] = (var5 << 7) + (this.field2521[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2521[var3] = var5 + (this.field2521[var3] & -128);
         }

         if(var4 == 7) {
            this.field2513[var3] = (var5 << 7) + (this.field2513[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2513[var3] = var5 + (this.field2513[var3] & -128);
         }

         if(var4 == 10) {
            this.field2533[var3] = (var5 << 7) + (this.field2533[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2533[var3] = var5 + (this.field2533[var3] & -128);
         }

         if(var4 == 11) {
            this.field2510[var3] = (var5 << 7) + (this.field2510[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2510[var3] = var5 + (this.field2510[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2523[var3] |= 1;
            } else {
               this.field2523[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2523[var3] |= 2;
            } else {
               this.method3786(var3);
               this.field2523[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2524[var3] = (var5 << 7) + (this.field2524[var3] & 127);
         }

         if(var4 == 98) {
            this.field2524[var3] = (this.field2524[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2524[var3] = (var5 << 7) + (this.field2524[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2524[var3] = (this.field2524[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3743(var3);
         }

         if(var4 == 121) {
            this.method3719(var3);
         }

         if(var4 == 123) {
            this.method3708(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2524[var3];
            if(var6 == 16384) {
               this.field2525[var3] = (var5 << 7) + (this.field2525[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2524[var3];
            if(var6 == 16384) {
               this.field2525[var3] = var5 + (this.field2525[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2526[var3] = (var5 << 7) + (this.field2526[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2526[var3] = var5 + (this.field2526[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2523[var3] |= 4;
            } else {
               this.method3711(var3);
               this.field2523[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3713(var3, (var5 << 7) + (this.field2527[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3713(var3, var5 + (this.field2527[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3806(var3, var4 + this.field2518[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3771(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3705(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3709();
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1983740874"
   )
   synchronized boolean method3696() {
      return this.field2531.method3854();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   public synchronized void method3692() {
      for(class208 var1 = (class208)this.field2515.method3558(); var1 != null; var1 = (class208)this.field2515.method3559()) {
         var1.method3879();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-8"
   )
   synchronized void method3693() {
      for(class208 var1 = (class208)this.field2515.method3558(); var1 != null; var1 = (class208)this.field2515.method3559()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(Lgm;[IIIB)Z",
      garbageValue = "0"
   )
   boolean method3807(class206 var1, int[] var2, int var3, int var4) {
      var1.field2558 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2553 < 0 || var1.field2557 != null && !var1.field2557.method2159()) {
         int var5 = var1.field2549;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2521[var1.field2544] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2549 = var5;
         }

         var1.field2557.method2157(this.method3714(var1));
         class203 var6 = var1.field2541;
         boolean var7 = false;
         ++var1.field2556;
         var1.field2554 += var6.field2495;
         double var8 = (double)((var1.field2559 - 60 << 8) + (var1.field2549 * var1.field2548 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2494 > 0) {
            if(var6.field2493 > 0) {
               var1.field2550 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2493 * var8) + 0.5D);
            } else {
               var1.field2550 += 128;
            }
         }

         if(var6.field2490 != null) {
            if(var6.field2491 > 0) {
               var1.field2539 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2491 * var8) + 0.5D);
            } else {
               var1.field2539 += 128;
            }

            while(var1.field2552 < var6.field2490.length - 2 && var1.field2539 > (var6.field2490[var1.field2552 + 2] & 255) << 8) {
               var1.field2552 += 2;
            }

            if(var6.field2490.length - 2 == var1.field2552 && 0 == var6.field2490[var1.field2552 + 1]) {
               var7 = true;
            }
         }

         if(var1.field2553 >= 0 && var6.field2489 != null && (this.field2523[var1.field2544] & 1) == 0 && (var1.field2543 < 0 || var1 != this.field2530[var1.field2544][var1.field2543])) {
            if(var6.field2492 > 0) {
               var1.field2553 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2492 * var8) + 0.5D);
            } else {
               var1.field2553 += 128;
            }

            while(var1.field2555 < var6.field2489.length - 2 && var1.field2553 > (var6.field2489[var1.field2555 + 2] & 255) << 8) {
               var1.field2555 += 2;
            }

            if(var6.field2489.length - 2 == var1.field2555) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2557.method2199(var1.field2558);
            if(var2 != null) {
               var1.field2557.vmethod3904(var2, var3, var4);
            } else {
               var1.field2557.vmethod3893(var4);
            }

            if(var1.field2557.method2204()) {
               this.field2537.field2589.method1894(var1.field2557);
            }

            var1.method3817();
            if(var1.field2553 >= 0) {
               var1.unlink();
               if(var1.field2543 > 0 && var1 == this.field2530[var1.field2544][var1.field2543]) {
                  this.field2530[var1.field2544][var1.field2543] = null;
               }
            }

            return true;
         } else {
            var1.field2557.method2155(var1.field2558, this.method3715(var1), this.method3716(var1));
            return false;
         }
      } else {
         var1.method3817();
         var1.unlink();
         if(var1.field2543 > 0 && var1 == this.field2530[var1.field2544][var1.field2543]) {
            this.field2530[var1.field2544][var1.field2543] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "14"
   )
   public synchronized void method3689(int var1) {
      this.field2511 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lda;"
   )
   protected synchronized class120 vmethod3894() {
      return this.field2537;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-298479168"
   )
   void method3713(int var1, int var2) {
      this.field2527[var1] = var2;
      this.field2516[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lhe;ZB)V",
      garbageValue = "69"
   )
   public synchronized void method3717(Track1 var1, boolean var2) {
      this.method3758();
      this.field2531.method3820(var1.field2593);
      this.field2519 = var2;
      this.field2535 = 0L;
      int var3 = this.field2531.method3851();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2531.method3824(var4);
         this.field2531.method3822(var4);
         this.field2531.method3825(var4);
      }

      this.field2532 = this.field2531.method3831();
      this.field2534 = this.field2531.field2572[this.field2532];
      this.field2536 = this.field2531.method3830(this.field2534);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "611578778"
   )
   void method3722() {
      int var1 = this.field2532;
      int var2 = this.field2534;

      long var3;
      for(var3 = this.field2536; var2 == this.field2534; var3 = this.field2531.method3830(var2)) {
         while(var2 == this.field2531.field2572[var1]) {
            this.field2531.method3824(var1);
            int var5 = this.field2531.method3869(var1);
            if(var5 == 1) {
               this.field2531.method3847();
               this.field2531.method3825(var1);
               if(this.field2531.method3841()) {
                  if(!this.field2519 || var2 == 0) {
                     this.method3709();
                     this.field2531.method3826();
                     return;
                  }

                  this.field2531.method3833(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3712(var5);
            }

            this.field2531.method3822(var1);
            this.field2531.method3825(var1);
         }

         var1 = this.field2531.method3831();
         var2 = this.field2531.field2572[var1];
      }

      this.field2532 = var1;
      this.field2534 = var2;
      this.field2536 = var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgm;ZI)V",
      garbageValue = "-1472172887"
   )
   void method3710(class206 var1, boolean var2) {
      int var3 = var1.field2542.field1618.length;
      int var4;
      if(var2 && var1.field2542.field1617) {
         int var5 = var3 + var3 - var1.field2542.field1616;
         var4 = (int)((long)var5 * (long)this.field2526[var1.field2544] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2557.method2152();
         }
      } else {
         var4 = (int)((long)this.field2526[var1.field2544] * (long)var3 >> 6);
      }

      var1.field2557.method2200(var4);
   }

   @ObfuscatedName("l")
   protected synchronized int vmethod3889() {
      return 0;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(Lgm;I)I",
      garbageValue = "879128462"
   )
   int method3715(class206 var1) {
      class203 var2 = var1.field2541;
      int var3 = this.field2513[var1.field2544] * this.field2510[var1.field2544] + 4096 >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = var3 * var1.field2545 + 16384 >> 15;
      var3 = var3 * this.field2511 + 128 >> 8;
      if(var2.field2494 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2494 * 1.953125E-5D * (double)var1.field2550) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2490 != null) {
         var4 = var1.field2539;
         var5 = var2.field2490[var1.field2552 + 1];
         if(var1.field2552 < var2.field2490.length - 2) {
            var6 = (var2.field2490[var1.field2552] & 255) << 8;
            var7 = (var2.field2490[var1.field2552 + 2] & 255) << 8;
            var5 += (var2.field2490[var1.field2552 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2553 > 0 && var2.field2489 != null) {
         var4 = var1.field2553;
         var5 = var2.field2489[var1.field2555 + 1];
         if(var1.field2555 < var2.field2489.length - 2) {
            var6 = (var2.field2489[var1.field2555] & 255) << 8;
            var7 = (var2.field2489[var1.field2555 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2489[var1.field2555 + 3] - var5) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(Lgm;I)I",
      garbageValue = "859783875"
   )
   int method3716(class206 var1) {
      int var2 = this.field2533[var1.field2544];
      return var2 < 8192?32 + var2 * var1.field2546 >> 6:16384 - (32 + (128 - var1.field2546) * (16384 - var2) >> 6);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "739901551"
   )
   public synchronized void method3697(int var1, int var2) {
      this.method3698(var1, var2);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "13"
   )
   void method3708(int var1) {
      for(class206 var2 = (class206)this.field2537.field2591.getFront(); var2 != null; var2 = (class206)this.field2537.field2591.getNext()) {
         if((var1 < 0 || var2.field2544 == var1) && var2.field2553 < 0) {
            this.field2529[var2.field2544][var2.field2559] = null;
            var2.field2553 = 0;
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2101169103"
   )
   static void method3813(int var0) {
      if(var0 != -1) {
         if(Ignore.loadWidget(var0)) {
            Widget[] var1 = class176.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2730 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.field856 = var3.field2730;
                  class40.method567(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)Lhi;",
      garbageValue = "1392498278"
   )
   public static Widget method3812(int var0, int var1) {
      Widget var2 = class84.method1670(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }
}
