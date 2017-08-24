import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public class class205 extends class118 {
   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   static SpritePixels[] field2541;
   @ObfuscatedName("f")
   int[] field2530;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -969542781
   )
   int field2536;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1873540975
   )
   int field2528;
   @ObfuscatedName("s")
   int[] field2518;
   @ObfuscatedName("q")
   int[] field2520;
   @ObfuscatedName("o")
   int[] field2519;
   @ObfuscatedName("b")
   int[] field2523;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   HashTable field2527;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[[Lgr;"
   )
   class206[][] field2532;
   @ObfuscatedName("p")
   int[] field2526;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   class207 field2534;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   class209 field2540;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -185541807
   )
   int field2537;
   @ObfuscatedName("r")
   int[] field2538;
   @ObfuscatedName("n")
   int[] field2515;
   @ObfuscatedName("g")
   int[] field2539;
   @ObfuscatedName("k")
   int[] field2517;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      longValue = -832482221654781227L
   )
   long field2521;
   @ObfuscatedName("h")
   int[] field2529;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -175176101
   )
   int field2516;
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "[[Lgr;"
   )
   class206[][] field2533;
   @ObfuscatedName("al")
   boolean field2535;
   @ObfuscatedName("x")
   int[] field2514;
   @ObfuscatedName("l")
   int[] field2525;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      longValue = 3023145008081349471L
   )
   long field2522;
   @ObfuscatedName("d")
   int[] field2524;
   @ObfuscatedName("m")
   int[] field2531;

   public class205() {
      this.field2528 = 256;
      this.field2516 = 1000000;
      this.field2538 = new int[16];
      this.field2519 = new int[16];
      this.field2515 = new int[16];
      this.field2520 = new int[16];
      this.field2523 = new int[16];
      this.field2517 = new int[16];
      this.field2518 = new int[16];
      this.field2524 = new int[16];
      this.field2525 = new int[16];
      this.field2526 = new int[16];
      this.field2531 = new int[16];
      this.field2514 = new int[16];
      this.field2529 = new int[16];
      this.field2530 = new int[16];
      this.field2539 = new int[16];
      this.field2532 = new class206[16][128];
      this.field2533 = new class206[16][128];
      this.field2534 = new class207();
      this.field2540 = new class209(this);
      this.field2527 = new HashTable(128);
      this.method3786();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-89375826"
   )
   void method3791(int var1, int var2) {
      this.field2520[var1] = var2;
      this.field2517[var1] = var2 & -128;
      this.method3776(var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "106"
   )
   void method3779(int var1, int var2, int var3) {
      class206 var4 = this.field2532[var1][var2];
      if(var4 != null) {
         this.field2532[var1][var2] = null;
         if((this.field2526[var1] & 2) != 0) {
            for(class206 var5 = (class206)this.field2540.field2593.getFront(); var5 != null; var5 = (class206)this.field2540.field2593.getNext()) {
               if(var4.field2563 == var5.field2563 && var5.field2560 < 0 && var5 != var4) {
                  var4.field2560 = 0;
                  break;
               }
            }
         } else {
            var4.field2560 = 0;
         }

      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1395181935"
   )
   void method3871(int var1) {
      for(class206 var2 = (class206)this.field2540.field2593.getFront(); var2 != null; var2 = (class206)this.field2540.field2593.getNext()) {
         if(var1 < 0 || var2.field2563 == var1) {
            if(var2.field2561 != null) {
               var2.field2561.method2157(class73.sampleRate / 100);
               if(var2.field2561.method2148()) {
                  this.field2540.field2594.method1915(var2.field2561);
               }

               var2.method3877();
            }

            if(var2.field2560 < 0) {
               this.field2532[var2.field2563][var2.field2547] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "115"
   )
   public synchronized void method3772() {
      this.field2534.method3880();
      this.method3786();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "400943983"
   )
   void method3831(int var1) {
      if(var1 >= 0) {
         this.field2538[var1] = 12800;
         this.field2519[var1] = 8192;
         this.field2515[var1] = 16383;
         this.field2518[var1] = 8192;
         this.field2524[var1] = 0;
         this.field2525[var1] = 8192;
         this.method3766(var1);
         this.method3811(var1);
         this.field2526[var1] = 0;
         this.field2531[var1] = 32767;
         this.field2514[var1] = 256;
         this.field2529[var1] = 0;
         this.method3790(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3831(var1);
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1035444184"
   )
   void method3773(int var1, int var2, int var3) {
      this.method3779(var1, var2, 64);
      if((this.field2526[var1] & 2) != 0) {
         for(class206 var4 = (class206)this.field2540.field2593.getTail(); var4 != null; var4 = (class206)this.field2540.field2593.getPrevious()) {
            if(var4.field2563 == var1 && var4.field2560 < 0) {
               this.field2532[var1][var4.field2547] = null;
               this.field2532[var1][var2] = var4;
               int var5 = var4.field2559 + (var4.field2546 * var4.field2552 >> 12);
               var4.field2559 += var2 - var4.field2547 << 8;
               var4.field2546 = var5 - var4.field2559;
               var4.field2552 = 4096;
               var4.field2547 = var2;
               return;
            }
         }
      }

      class208 var9 = (class208)this.field2527.get((long)this.field2523[var1]);
      if(var9 != null) {
         class106 var8 = var9.field2581[var2];
         if(var8 != null) {
            class206 var6 = new class206();
            var6.field2563 = var1;
            var6.field2543 = var9;
            var6.field2550 = var8;
            var6.field2545 = var9.field2591[var2];
            var6.field2556 = var9.field2586[var2];
            var6.field2547 = var2;
            var6.field2548 = var3 * var3 * var9.field2588[var2] * var9.field2583 + 1024 >> 11;
            var6.field2549 = var9.field2584[var2] & 255;
            var6.field2559 = (var2 << 8) - (var9.field2590[var2] & 32767);
            var6.field2553 = 0;
            var6.field2554 = 0;
            var6.field2555 = 0;
            var6.field2560 = -1;
            var6.field2557 = 0;
            if(this.field2529[var1] == 0) {
               var6.field2561 = class116.method2156(var8, this.method3849(var6), this.method3792(var6), this.method3796(var6));
            } else {
               var6.field2561 = class116.method2156(var8, this.method3849(var6), 0, this.method3796(var6));
               this.method3814(var6, var9.field2590[var2] < 0);
            }

            if(var9.field2590[var2] < 0) {
               var6.field2561.method2133(-1);
            }

            if(var6.field2556 >= 0) {
               class206 var7 = this.field2533[var1][var6.field2556];
               if(var7 != null && var7.field2560 < 0) {
                  this.field2532[var1][var7.field2547] = null;
                  var7.field2560 = 0;
               }

               this.field2533[var1][var6.field2556] = var6;
            }

            this.field2540.field2593.addFront(var6);
            this.field2532[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1281607667"
   )
   void method3780(int var1, int var2, int var3) {
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1970743716"
   )
   void method3786() {
      this.method3871(-1);
      this.method3831(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2523[var1] = this.field2520[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2517[var1] = this.field2520[var1] & -128;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "14"
   )
   void method3776(int var1, int var2) {
      if(var2 != this.field2523[var1]) {
         this.field2523[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2533[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("k")
   protected synchronized void vmethod3936(int[] var1, int var2, int var3) {
      if(this.field2534.method3916()) {
         int var4 = this.field2534.field2573 * this.field2516 / class73.sampleRate;

         do {
            long var5 = this.field2522 + (long)var3 * (long)var4;
            if(this.field2521 - var5 >= 0L) {
               this.field2522 = var5;
               break;
            }

            int var7 = (int)((this.field2521 - this.field2522 + (long)var4 - 1L) / (long)var4);
            this.field2522 += (long)var4 * (long)var7;
            this.field2540.vmethod3936(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3799();
         } while(this.field2534.method3916());
      }

      this.field2540.vmethod3936(var1, var2, var3);
   }

   @ObfuscatedName("d")
   protected synchronized void vmethod3937(int var1) {
      if(this.field2534.method3916()) {
         int var2 = this.field2534.field2573 * this.field2516 / class73.sampleRate;

         do {
            long var3 = (long)var2 * (long)var1 + this.field2522;
            if(this.field2521 - var3 >= 0L) {
               this.field2522 = var3;
               break;
            }

            int var5 = (int)((this.field2521 - this.field2522 + (long)var2 - 1L) / (long)var2);
            this.field2522 += (long)var5 * (long)var2;
            this.field2540.vmethod3937(var5);
            var1 -= var5;
            this.method3799();
         } while(this.field2534.method3916());
      }

      this.field2540.vmethod3937(var1);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-26"
   )
   void method3781(int var1, int var2) {
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-741585947"
   )
   void method3857(int var1, int var2) {
      this.field2518[var1] = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected synchronized class118 vmethod3934() {
      return null;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lgr;I)I",
      garbageValue = "667698422"
   )
   int method3849(class206 var1) {
      int var2 = var1.field2559 + (var1.field2552 * var1.field2546 >> 12);
      var2 += (this.field2518[var1.field2563] - 8192) * this.field2514[var1.field2563] >> 12;
      class203 var3 = var1.field2545;
      int var4;
      if(var3.field2500 > 0 && (var3.field2499 > 0 || this.field2524[var1.field2563] > 0)) {
         var4 = var3.field2499 << 2;
         int var5 = var3.field2501 << 1;
         if(var1.field2558 < var5) {
            var4 = var4 * var1.field2558 / var5;
         }

         var4 += this.field2524[var1.field2563] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2551 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2550.field1618 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class73.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lhl;Lii;Ldr;IB)Z",
      garbageValue = "1"
   )
   synchronized boolean method3778(Track1 var1, IndexDataBase var2, class111 var3, int var4) {
      var1.method3954();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(class200 var7 = (class200)var1.field2597.method3628(); var7 != null; var7 = (class200)var1.field2597.method3625()) {
         int var8 = (int)var7.hash;
         class208 var9 = (class208)this.field2527.get((long)var8);
         if(var9 == null) {
            var9 = GameEngine.method1027(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2527.put(var9, (long)var8);
         }

         if(!var9.method3923(var3, var7.field2488, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3956();
      }

      return var5;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lgr;B)Z",
      garbageValue = "-47"
   )
   boolean method3800(class206 var1) {
      if(var1.field2561 == null) {
         if(var1.field2560 >= 0) {
            var1.unlink();
            if(var1.field2556 > 0 && var1 == this.field2533[var1.field2563][var1.field2556]) {
               this.field2533[var1.field2563][var1.field2556] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-488318552"
   )
   void method3766(int var1) {
      if((this.field2526[var1] & 2) != 0) {
         for(class206 var2 = (class206)this.field2540.field2593.getFront(); var2 != null; var2 = (class206)this.field2540.field2593.getNext()) {
            if(var2.field2563 == var1 && this.field2532[var1][var2.field2547] == null && var2.field2560 < 0) {
               var2.field2560 = 0;
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "18"
   )
   public int method3767() {
      return this.field2528;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "547032646"
   )
   void method3811(int var1) {
      if((this.field2526[var1] & 4) != 0) {
         for(class206 var2 = (class206)this.field2540.field2593.getFront(); var2 != null; var2 = (class206)this.field2540.field2593.getNext()) {
            if(var2.field2563 == var1) {
               var2.field2544 = 0;
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1709858966"
   )
   void method3789(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3779(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3773(var3, var4, var5);
         } else {
            this.method3779(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3780(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2517[var3] = (var5 << 14) + (this.field2517[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2517[var3] = (var5 << 7) + (this.field2517[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2524[var3] = (var5 << 7) + (this.field2524[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2524[var3] = var5 + (this.field2524[var3] & -128);
         }

         if(var4 == 5) {
            this.field2525[var3] = (var5 << 7) + (this.field2525[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2525[var3] = var5 + (this.field2525[var3] & -128);
         }

         if(var4 == 7) {
            this.field2538[var3] = (var5 << 7) + (this.field2538[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2538[var3] = var5 + (this.field2538[var3] & -128);
         }

         if(var4 == 10) {
            this.field2519[var3] = (var5 << 7) + (this.field2519[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2519[var3] = var5 + (this.field2519[var3] & -128);
         }

         if(var4 == 11) {
            this.field2515[var3] = (var5 << 7) + (this.field2515[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2515[var3] = var5 + (this.field2515[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2526[var3] |= 1;
            } else {
               this.field2526[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2526[var3] |= 2;
            } else {
               this.method3766(var3);
               this.field2526[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2531[var3] = (var5 << 7) + (this.field2531[var3] & 127);
         }

         if(var4 == 98) {
            this.field2531[var3] = (this.field2531[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2531[var3] = (var5 << 7) + (this.field2531[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2531[var3] = (this.field2531[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3871(var3);
         }

         if(var4 == 121) {
            this.method3831(var3);
         }

         if(var4 == 123) {
            this.method3785(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2531[var3];
            if(var6 == 16384) {
               this.field2514[var3] = (var5 << 7) + (this.field2514[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2531[var3];
            if(var6 == 16384) {
               this.field2514[var3] = var5 + (this.field2514[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2529[var3] = (var5 << 7) + (this.field2529[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2529[var3] = var5 + (this.field2529[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2526[var3] |= 4;
            } else {
               this.method3811(var3);
               this.field2526[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3790(var3, (var5 << 7) + (this.field2530[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3790(var3, var5 + (this.field2530[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3776(var3, var4 + this.field2517[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3781(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3857(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3786();
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "624991203"
   )
   public synchronized boolean method3827() {
      return this.field2534.method3916();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1826323116"
   )
   synchronized void method3769() {
      for(class208 var1 = (class208)this.field2527.method3628(); var1 != null; var1 = (class208)this.field2527.method3625()) {
         var1.method3924();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1287240462"
   )
   public synchronized void method3770() {
      for(class208 var1 = (class208)this.field2527.method3628(); var1 != null; var1 = (class208)this.field2527.method3625()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lgr;[IIII)Z",
      garbageValue = "1610888351"
   )
   boolean method3801(class206 var1, int[] var2, int var3, int var4) {
      var1.field2542 = class73.sampleRate / 100;
      if(var1.field2560 < 0 || var1.field2561 != null && !var1.field2561.method2147()) {
         int var5 = var1.field2552;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2525[var1.field2563]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2552 = var5;
         }

         var1.field2561.method2162(this.method3849(var1));
         class203 var6 = var1.field2545;
         boolean var7 = false;
         ++var1.field2558;
         var1.field2551 += var6.field2500;
         double var8 = (double)((var1.field2547 - 60 << 8) + (var1.field2546 * var1.field2552 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2502 > 0) {
            if(var6.field2498 > 0) {
               var1.field2553 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2498) + 0.5D);
            } else {
               var1.field2553 += 128;
            }
         }

         if(var6.field2495 != null) {
            if(var6.field2496 > 0) {
               var1.field2554 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2496) + 0.5D);
            } else {
               var1.field2554 += 128;
            }

            while(var1.field2555 < var6.field2495.length - 2 && var1.field2554 > (var6.field2495[var1.field2555 + 2] & 255) << 8) {
               var1.field2555 += 2;
            }

            if(var6.field2495.length - 2 == var1.field2555 && var6.field2495[var1.field2555 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2560 >= 0 && var6.field2494 != null && (this.field2526[var1.field2563] & 1) == 0 && (var1.field2556 < 0 || var1 != this.field2533[var1.field2563][var1.field2556])) {
            if(var6.field2497 > 0) {
               var1.field2560 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2497 * var8) + 0.5D);
            } else {
               var1.field2560 += 128;
            }

            while(var1.field2557 < var6.field2494.length - 2 && var1.field2560 > (var6.field2494[var1.field2557 + 2] & 255) << 8) {
               var1.field2557 += 2;
            }

            if(var6.field2494.length - 2 == var1.field2557) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2561.method2157(var1.field2542);
            if(var2 != null) {
               var1.field2561.vmethod3936(var2, var3, var4);
            } else {
               var1.field2561.vmethod3937(var4);
            }

            if(var1.field2561.method2148()) {
               this.field2540.field2594.method1915(var1.field2561);
            }

            var1.method3877();
            if(var1.field2560 >= 0) {
               var1.unlink();
               if(var1.field2556 > 0 && var1 == this.field2533[var1.field2563][var1.field2556]) {
                  this.field2533[var1.field2563][var1.field2556] = null;
               }
            }

            return true;
         } else {
            var1.field2561.method2143(var1.field2542, this.method3792(var1), this.method3796(var1));
            return false;
         }
      } else {
         var1.method3877();
         var1.unlink();
         if(var1.field2556 > 0 && var1 == this.field2533[var1.field2563][var1.field2556]) {
            this.field2533[var1.field2563][var1.field2556] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2113856808"
   )
   public synchronized void method3793(int var1) {
      this.field2528 = var1;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "645397497"
   )
   void method3790(int var1, int var2) {
      this.field2530[var1] = var2;
      this.field2539[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected synchronized class118 vmethod3943() {
      return this.field2540;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lhl;ZI)V",
      garbageValue = "-2030789611"
   )
   synchronized void method3795(Track1 var1, boolean var2) {
      this.method3772();
      this.field2534.method3895(var1.field2598);
      this.field2535 = var2;
      this.field2522 = 0L;
      int var3 = this.field2534.method3884();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2534.method3885(var4);
         this.field2534.method3888(var4);
         this.field2534.method3886(var4);
      }

      this.field2536 = this.field2534.method3892();
      this.field2537 = this.field2534.field2570[this.field2536];
      this.field2521 = this.field2534.method3891(this.field2537);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   void method3799() {
      int var1 = this.field2536;
      int var2 = this.field2537;

      long var3;
      for(var3 = this.field2521; var2 == this.field2537; var3 = this.field2534.method3891(var2)) {
         while(var2 == this.field2534.field2570[var1]) {
            this.field2534.method3885(var1);
            int var5 = this.field2534.method3910(var1);
            if(var5 == 1) {
               this.field2534.method3887();
               this.field2534.method3886(var1);
               if(this.field2534.method3882()) {
                  if(!this.field2535 || var2 == 0) {
                     this.method3786();
                     this.field2534.method3880();
                     return;
                  }

                  this.field2534.method3894(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3789(var5);
            }

            this.field2534.method3888(var1);
            this.field2534.method3886(var1);
         }

         var1 = this.field2534.method3892();
         var2 = this.field2534.field2570[var1];
      }

      this.field2536 = var1;
      this.field2537 = var2;
      this.field2521 = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgr;ZI)V",
      garbageValue = "1900008266"
   )
   void method3814(class206 var1, boolean var2) {
      int var3 = var1.field2550.field1616.length;
      int var4;
      if(var2 && var1.field2550.field1619) {
         int var5 = var3 + var3 - var1.field2550.field1617;
         var4 = (int)((long)var5 * (long)this.field2529[var1.field2563] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2561.method2140();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2529[var1.field2563] >> 6);
      }

      var1.field2561.method2139(var4);
   }

   @ObfuscatedName("b")
   protected synchronized int vmethod3950() {
      return 0;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lgr;I)I",
      garbageValue = "-245092485"
   )
   int method3792(class206 var1) {
      class203 var2 = var1.field2545;
      int var3 = this.field2515[var1.field2563] * this.field2538[var1.field2563] + 4096 >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = var3 * var1.field2548 + 16384 >> 15;
      var3 = var3 * this.field2528 + 128 >> 8;
      if(var2.field2502 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2502 * 1.953125E-5D * (double)var1.field2553) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2495 != null) {
         var4 = var1.field2554;
         var5 = var2.field2495[var1.field2555 + 1];
         if(var1.field2555 < var2.field2495.length - 2) {
            var6 = (var2.field2495[var1.field2555] & 255) << 8;
            var7 = (var2.field2495[var1.field2555 + 2] & 255) << 8;
            var5 += (var2.field2495[var1.field2555 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2560 > 0 && var2.field2494 != null) {
         var4 = var1.field2560;
         var5 = var2.field2494[var1.field2557 + 1];
         if(var1.field2557 < var2.field2494.length - 2) {
            var6 = (var2.field2494[var1.field2557] & 255) << 8;
            var7 = (var2.field2494[var1.field2557 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2494[var1.field2557 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lgr;I)I",
      garbageValue = "1151013360"
   )
   int method3796(class206 var1) {
      int var2 = this.field2519[var1.field2563];
      return var2 < 8192?var2 * var1.field2549 + 32 >> 6:16384 - ((128 - var1.field2549) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1562816276"
   )
   public synchronized void method3777(int var1, int var2) {
      this.method3791(var1, var2);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2080346283"
   )
   void method3785(int var1) {
      for(class206 var2 = (class206)this.field2540.field2593.getFront(); var2 != null; var2 = (class206)this.field2540.field2593.getNext()) {
         if((var1 < 0 || var2.field2563 == var1) && var2.field2560 < 0) {
            this.field2532[var2.field2563][var2.field2547] = null;
            var2.field2560 = 0;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([Lcp;II[I[II)V",
      garbageValue = "-456773520"
   )
   static void method3874(World[] var0, int var1, int var2, int[] var3, int[] var4) {
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
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1550()?1:0;
                     var12 = var8.method1550()?1:0;
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
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1550()?1:0;
                     var12 = var8.method1550()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
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

         method3874(var0, var1, var6, var3, var4);
         method3874(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1777260970"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
