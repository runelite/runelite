import java.util.LinkedHashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public class class204 extends class117 {
   @ObfuscatedName("qw")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   static IndexFile field2552;
   @ObfuscatedName("w")
   int[] field2543;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1713032765
   )
   int field2549;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 175526889
   )
   int field2527;
   @ObfuscatedName("t")
   int[] field2535;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   HashTable field2553;
   @ObfuscatedName("g")
   int[] field2551;
   @ObfuscatedName("q")
   int[] field2530;
   @ObfuscatedName("r")
   int[] field2542;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[[Lgi;"
   )
   class205[][] field2545;
   @ObfuscatedName("h")
   int[] field2539;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   class206 field2547;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   class208 field2528;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -2142872923
   )
   int field2550;
   @ObfuscatedName("p")
   int[] field2526;
   @ObfuscatedName("n")
   int[] field2544;
   @ObfuscatedName("v")
   int[] field2534;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      longValue = -7417796099195722085L
   )
   long field2554;
   @ObfuscatedName("l")
   int[] field2540;
   @ObfuscatedName("s")
   int[] field2531;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -540352845
   )
   int field2537;
   @ObfuscatedName("ah")
   boolean field2548;
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "[[Lgi;"
   )
   class205[][] field2546;
   @ObfuscatedName("o")
   int[] field2529;
   @ObfuscatedName("z")
   int[] field2541;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      longValue = 4448332123827521033L
   )
   long field2532;
   @ObfuscatedName("y")
   int[] field2536;
   @ObfuscatedName("a")
   int[] field2538;

   public class204() {
      this.field2527 = 256;
      this.field2537 = 1000000;
      this.field2526 = new int[16];
      this.field2530 = new int[16];
      this.field2531 = new int[16];
      this.field2542 = new int[16];
      this.field2551 = new int[16];
      this.field2534 = new int[16];
      this.field2535 = new int[16];
      this.field2536 = new int[16];
      this.field2529 = new int[16];
      this.field2539 = new int[16];
      this.field2538 = new int[16];
      this.field2541 = new int[16];
      this.field2540 = new int[16];
      this.field2543 = new int[16];
      this.field2544 = new int[16];
      this.field2545 = new class205[16][128];
      this.field2546 = new class205[16][128];
      this.field2547 = new class206();
      this.field2528 = new class208(this);
      this.field2553 = new HashTable(128);
      this.method3817();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1325620943"
   )
   void method3806(int var1, int var2) {
      this.field2542[var1] = var2;
      this.field2534[var1] = var2 & -128;
      this.method3798(var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "85504"
   )
   void method3810(int var1, int var2, int var3) {
      class205 var4 = this.field2545[var1][var2];
      if(var4 != null) {
         this.field2545[var1][var2] = null;
         if((this.field2539[var1] & 2) != 0) {
            for(class205 var5 = (class205)this.field2528.field2601.getFront(); var5 != null; var5 = (class205)this.field2528.field2601.getNext()) {
               if(var4.field2563 == var5.field2563 && var5.field2571 < 0 && var4 != var5) {
                  var4.field2571 = 0;
                  break;
               }
            }
         } else {
            var4.field2571 = 0;
         }

      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-421679977"
   )
   void method3814(int var1) {
      for(class205 var2 = (class205)this.field2528.field2601.getFront(); var2 != null; var2 = (class205)this.field2528.field2601.getNext()) {
         if(var1 < 0 || var2.field2563 == var1) {
            if(var2.field2570 != null) {
               var2.field2570.method2198(class31.sampleRate / 100);
               if(var2.field2570.method2340()) {
                  this.field2528.field2606.method1979(var2.field2570);
               }

               var2.method3927();
            }

            if(var2.field2571 < 0) {
               this.field2545[var2.field2563][var2.field2574] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-88"
   )
   public synchronized void method3803() {
      this.field2547.method3934();
      this.method3817();
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1896998046"
   )
   void method3884(int var1) {
      if(var1 >= 0) {
         this.field2526[var1] = 12800;
         this.field2530[var1] = 8192;
         this.field2531[var1] = 16383;
         this.field2535[var1] = 8192;
         this.field2536[var1] = 0;
         this.field2529[var1] = 8192;
         this.method3818(var1);
         this.method3907(var1);
         this.field2539[var1] = 0;
         this.field2538[var1] = 32767;
         this.field2541[var1] = 256;
         this.field2540[var1] = 0;
         this.method3869(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3884(var1);
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "2"
   )
   void method3808(int var1, int var2, int var3) {
      this.method3810(var1, var2, 64);
      if((this.field2539[var1] & 2) != 0) {
         for(class205 var4 = (class205)this.field2528.field2601.getTail(); var4 != null; var4 = (class205)this.field2528.field2601.getPrevious()) {
            if(var4.field2563 == var1 && var4.field2571 < 0) {
               this.field2545[var1][var4.field2574] = null;
               this.field2545[var1][var2] = var4;
               int var5 = (var4.field2567 * var4.field2566 >> 12) + var4.field2565;
               var4.field2565 += var2 - var4.field2574 << 8;
               var4.field2566 = var5 - var4.field2565;
               var4.field2567 = 4096;
               var4.field2574 = var2;
               return;
            }
         }
      }

      class207 var9 = (class207)this.field2553.get((long)this.field2551[var1]);
      if(var9 != null) {
         class105 var8 = var9.field2593[var2];
         if(var8 != null) {
            class205 var6 = new class205();
            var6.field2563 = var1;
            var6.field2558 = var9;
            var6.field2559 = var8;
            var6.field2560 = var9.field2597[var2];
            var6.field2561 = var9.field2592[var2];
            var6.field2574 = var2;
            var6.field2576 = 1024 + var3 * var3 * var9.field2595[var2] * var9.field2598 >> 11;
            var6.field2557 = var9.field2596[var2] & 255;
            var6.field2565 = (var2 << 8) - (var9.field2594[var2] & 32767);
            var6.field2568 = 0;
            var6.field2569 = 0;
            var6.field2562 = 0;
            var6.field2571 = -1;
            var6.field2572 = 0;
            if(this.field2540[var1] == 0) {
               var6.field2570 = class115.method2352(var8, this.method3854(var6), this.method3823(var6), this.method3828(var6));
            } else {
               var6.field2570 = class115.method2352(var8, this.method3854(var6), 0, this.method3828(var6));
               this.method3809(var6, var9.field2594[var2] < 0);
            }

            if(var9.field2594[var2] < 0) {
               var6.field2570.method2346(-1);
            }

            if(var6.field2561 >= 0) {
               class205 var7 = this.field2546[var1][var6.field2561];
               if(var7 != null && var7.field2571 < 0) {
                  this.field2545[var1][var7.field2574] = null;
                  var7.field2571 = 0;
               }

               this.field2546[var1][var6.field2561] = var6;
            }

            this.field2528.field2601.addFront(var6);
            this.field2545[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2047745790"
   )
   void method3811(int var1, int var2, int var3) {
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-71"
   )
   void method3817() {
      this.method3814(-1);
      this.method3884(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2551[var1] = this.field2542[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2534[var1] = this.field2542[var1] & -128;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2118746977"
   )
   void method3798(int var1, int var2) {
      if(var2 != this.field2551[var1]) {
         this.field2551[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2546[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("v")
   protected synchronized void vmethod4004(int[] var1, int var2, int var3) {
      if(this.field2547.method3949()) {
         int var4 = this.field2547.field2579 * this.field2537 / class31.sampleRate;

         do {
            long var5 = (long)var4 * (long)var3 + this.field2532;
            if(this.field2554 - var5 >= 0L) {
               this.field2532 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2554 - this.field2532) - 1L) / (long)var4);
            this.field2532 += (long)var4 * (long)var7;
            this.field2528.vmethod4004(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3830();
         } while(this.field2547.method3949());
      }

      this.field2528.vmethod4004(var1, var2, var3);
   }

   @ObfuscatedName("y")
   protected synchronized void vmethod4023(int var1) {
      if(this.field2547.method3949()) {
         int var2 = this.field2547.field2579 * this.field2537 / class31.sampleRate;

         do {
            long var3 = this.field2532 + (long)var2 * (long)var1;
            if(this.field2554 - var3 >= 0L) {
               this.field2532 = var3;
               break;
            }

            int var5 = (int)((this.field2554 - this.field2532 + (long)var2 - 1L) / (long)var2);
            this.field2532 += (long)var2 * (long)var5;
            this.field2528.vmethod4023(var5);
            var1 -= var5;
            this.method3830();
         } while(this.field2547.method3949());
      }

      this.field2528.vmethod4023(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1887115167"
   )
   void method3812(int var1, int var2) {
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "855826166"
   )
   void method3813(int var1, int var2) {
      this.field2535[var1] = var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected synchronized class117 vmethod4002() {
      return null;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(Lgi;I)I",
      garbageValue = "1026742798"
   )
   int method3854(class205 var1) {
      int var2 = (var1.field2567 * var1.field2566 >> 12) + var1.field2565;
      var2 += (this.field2535[var1.field2563] - 8192) * this.field2541[var1.field2563] >> 12;
      class202 var3 = var1.field2560;
      int var4;
      if(var3.field2512 > 0 && (var3.field2511 > 0 || this.field2536[var1.field2563] > 0)) {
         var4 = var3.field2511 << 2;
         int var5 = var3.field2513 << 1;
         if(var1.field2573 < var5) {
            var4 = var4 * var1.field2573 / var5;
         }

         var4 += this.field2536[var1.field2563] >> 7;
         double var6 = Math.sin((double)(var1.field2564 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2559.field1597 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class31.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lhd;Lit;Ldi;II)Z",
      garbageValue = "830128654"
   )
   synchronized boolean method3846(Track1 var1, IndexDataBase var2, class110 var3, int var4) {
      var1.method4030();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(class199 var7 = (class199)var1.field2608.method3646(); var7 != null; var7 = (class199)var1.field2608.method3647()) {
         int var8 = (int)var7.hash;
         class207 var9 = (class207)this.field2553.get((long)var8);
         if(var9 == null) {
            var9 = class60.method1068(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2553.put(var9, (long)var8);
         }

         if(!var9.method3988(var3, var7.field2500, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4031();
      }

      return var5;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(Lgi;I)Z",
      garbageValue = "-1342976929"
   )
   boolean method3831(class205 var1) {
      if(var1.field2570 == null) {
         if(var1.field2571 >= 0) {
            var1.unlink();
            if(var1.field2561 > 0 && var1 == this.field2546[var1.field2563][var1.field2561]) {
               this.field2546[var1.field2563][var1.field2561] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-15"
   )
   void method3818(int var1) {
      if((this.field2539[var1] & 2) != 0) {
         for(class205 var2 = (class205)this.field2528.field2601.getFront(); var2 != null; var2 = (class205)this.field2528.field2601.getNext()) {
            if(var2.field2563 == var1 && this.field2545[var1][var2.field2574] == null && var2.field2571 < 0) {
               var2.field2571 = 0;
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "284968034"
   )
   public int method3865() {
      return this.field2527;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-32"
   )
   void method3907(int var1) {
      if((this.field2539[var1] & 4) != 0) {
         for(class205 var2 = (class205)this.field2528.field2601.getFront(); var2 != null; var2 = (class205)this.field2528.field2601.getNext()) {
            if(var2.field2563 == var1) {
               var2.field2577 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-288281984"
   )
   void method3820(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3810(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3808(var3, var4, var5);
         } else {
            this.method3810(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3811(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2534[var3] = (var5 << 14) + (this.field2534[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2534[var3] = (var5 << 7) + (this.field2534[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2536[var3] = (var5 << 7) + (this.field2536[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2536[var3] = var5 + (this.field2536[var3] & -128);
         }

         if(var4 == 5) {
            this.field2529[var3] = (var5 << 7) + (this.field2529[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2529[var3] = var5 + (this.field2529[var3] & -128);
         }

         if(var4 == 7) {
            this.field2526[var3] = (var5 << 7) + (this.field2526[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2526[var3] = var5 + (this.field2526[var3] & -128);
         }

         if(var4 == 10) {
            this.field2530[var3] = (var5 << 7) + (this.field2530[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2530[var3] = var5 + (this.field2530[var3] & -128);
         }

         if(var4 == 11) {
            this.field2531[var3] = (var5 << 7) + (this.field2531[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2531[var3] = var5 + (this.field2531[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2539[var3] |= 1;
            } else {
               this.field2539[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2539[var3] |= 2;
            } else {
               this.method3818(var3);
               this.field2539[var3] &= -3;
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
            this.field2538[var3] = (this.field2538[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3814(var3);
         }

         if(var4 == 121) {
            this.method3884(var3);
         }

         if(var4 == 123) {
            this.method3841(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2538[var3];
            if(var6 == 16384) {
               this.field2541[var3] = (var5 << 7) + (this.field2541[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2538[var3];
            if(var6 == 16384) {
               this.field2541[var3] = var5 + (this.field2541[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2540[var3] = (var5 << 7) + (this.field2540[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2540[var3] = var5 + (this.field2540[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2539[var3] |= 4;
            } else {
               this.method3907(var3);
               this.field2539[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3869(var3, (var5 << 7) + (this.field2543[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3869(var3, var5 + (this.field2543[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3798(var3, var4 + this.field2534[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3812(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3813(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3817();
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-125772784"
   )
   public synchronized boolean method3870() {
      return this.field2547.method3949();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   synchronized void method3800() {
      for(class207 var1 = (class207)this.field2553.method3646(); var1 != null; var1 = (class207)this.field2553.method3647()) {
         var1.method3997();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "971711461"
   )
   public synchronized void method3824() {
      for(class207 var1 = (class207)this.field2553.method3646(); var1 != null; var1 = (class207)this.field2553.method3647()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(Lgi;[IIIB)Z",
      garbageValue = "33"
   )
   boolean method3832(class205 var1, int[] var2, int var3, int var4) {
      var1.field2575 = class31.sampleRate / 100;
      if(var1.field2571 < 0 || var1.field2570 != null && !var1.field2570.method2219()) {
         int var5 = var1.field2567;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2529[var1.field2563] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2567 = var5;
         }

         var1.field2570.method2216(this.method3854(var1));
         class202 var6 = var1.field2560;
         boolean var7 = false;
         ++var1.field2573;
         var1.field2564 += var6.field2512;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2567 * var1.field2566 >> 12) + (var1.field2574 - 60 << 8));
         if(var6.field2509 > 0) {
            if(var6.field2510 > 0) {
               var1.field2568 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2510) + 0.5D);
            } else {
               var1.field2568 += 128;
            }
         }

         if(var6.field2516 != null) {
            if(var6.field2514 > 0) {
               var1.field2569 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2514 * var8) + 0.5D);
            } else {
               var1.field2569 += 128;
            }

            while(var1.field2562 < var6.field2516.length - 2 && var1.field2569 > (var6.field2516[var1.field2562 + 2] & 255) << 8) {
               var1.field2562 += 2;
            }

            if(var6.field2516.length - 2 == var1.field2562 && 0 == var6.field2516[var1.field2562 + 1]) {
               var7 = true;
            }
         }

         if(var1.field2571 >= 0 && var6.field2515 != null && (this.field2539[var1.field2563] & 1) == 0 && (var1.field2561 < 0 || var1 != this.field2546[var1.field2563][var1.field2561])) {
            if(var6.field2505 > 0) {
               var1.field2571 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2505) + 0.5D);
            } else {
               var1.field2571 += 128;
            }

            while(var1.field2572 < var6.field2515.length - 2 && var1.field2571 > (var6.field2515[var1.field2572 + 2] & 255) << 8) {
               var1.field2572 += 2;
            }

            if(var6.field2515.length - 2 == var1.field2572) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2570.method2198(var1.field2575);
            if(var2 != null) {
               var1.field2570.vmethod4004(var2, var3, var4);
            } else {
               var1.field2570.vmethod4023(var4);
            }

            if(var1.field2570.method2340()) {
               this.field2528.field2606.method1979(var1.field2570);
            }

            var1.method3927();
            if(var1.field2571 >= 0) {
               var1.unlink();
               if(var1.field2561 > 0 && var1 == this.field2546[var1.field2563][var1.field2561]) {
                  this.field2546[var1.field2563][var1.field2561] = null;
               }
            }

            return true;
         } else {
            var1.field2570.method2214(var1.field2575, this.method3823(var1), this.method3828(var1));
            return false;
         }
      } else {
         var1.method3927();
         var1.unlink();
         if(var1.field2561 > 0 && var1 == this.field2546[var1.field2563][var1.field2561]) {
            this.field2546[var1.field2563][var1.field2561] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "970712725"
   )
   public synchronized void method3797(int var1) {
      this.field2527 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected synchronized class117 vmethod4025() {
      return this.field2528;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1791637520"
   )
   void method3869(int var1, int var2) {
      this.field2543[var1] = var2;
      this.field2544[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lhd;ZI)V",
      garbageValue = "454404727"
   )
   synchronized void method3886(Track1 var1, boolean var2) {
      this.method3803();
      this.field2547.method3968(var1.field2609);
      this.field2548 = var2;
      this.field2532 = 0L;
      int var3 = this.field2547.method3948();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2547.method3971(var4);
         this.field2547.method3961(var4);
         this.field2547.method3938(var4);
      }

      this.field2549 = this.field2547.method3945();
      this.field2550 = this.field2547.field2586[this.field2549];
      this.field2554 = this.field2547.method3944(this.field2550);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "158831069"
   )
   void method3830() {
      int var1 = this.field2549;
      int var2 = this.field2550;

      long var3;
      for(var3 = this.field2554; var2 == this.field2550; var3 = this.field2547.method3944(var2)) {
         while(var2 == this.field2547.field2586[var1]) {
            this.field2547.method3971(var1);
            int var5 = this.field2547.method3941(var1);
            if(var5 == 1) {
               this.field2547.method3939();
               this.field2547.method3938(var1);
               if(this.field2547.method3946()) {
                  if(!this.field2548 || var2 == 0) {
                     this.method3817();
                     this.field2547.method3934();
                     return;
                  }

                  this.field2547.method3947(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3820(var5);
            }

            this.field2547.method3961(var1);
            this.field2547.method3938(var1);
         }

         var1 = this.field2547.method3945();
         var2 = this.field2547.field2586[var1];
      }

      this.field2549 = var1;
      this.field2550 = var2;
      this.field2554 = var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgi;ZB)V",
      garbageValue = "106"
   )
   void method3809(class205 var1, boolean var2) {
      int var3 = var1.field2559.field1596.length;
      int var4;
      if(var2 && var1.field2559.field1599) {
         int var5 = var3 + var3 - var1.field2559.field1598;
         var4 = (int)((long)var5 * (long)this.field2540[var1.field2563] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2570.method2297();
         }
      } else {
         var4 = (int)((long)this.field2540[var1.field2563] * (long)var3 >> 6);
      }

      var1.field2570.method2210(var4);
   }

   @ObfuscatedName("g")
   protected synchronized int vmethod4007() {
      return 0;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(Lgi;I)I",
      garbageValue = "841617956"
   )
   int method3823(class205 var1) {
      class202 var2 = var1.field2560;
      int var3 = this.field2526[var1.field2563] * this.field2531[var1.field2563] + 4096 >> 13;
      var3 = 16384 + var3 * var3 >> 15;
      var3 = 16384 + var3 * var1.field2576 >> 15;
      var3 = var3 * this.field2527 + 128 >> 8;
      if(var2.field2509 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field2568 * 1.953125E-5D * (double)var2.field2509) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2516 != null) {
         var4 = var1.field2569;
         var5 = var2.field2516[var1.field2562 + 1];
         if(var1.field2562 < var2.field2516.length - 2) {
            var6 = (var2.field2516[var1.field2562] & 255) << 8;
            var7 = (var2.field2516[var1.field2562 + 2] & 255) << 8;
            var5 += (var2.field2516[var1.field2562 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = 32 + var5 * var3 >> 6;
      }

      if(var1.field2571 > 0 && var2.field2515 != null) {
         var4 = var1.field2571;
         var5 = var2.field2515[var1.field2572 + 1];
         if(var1.field2572 < var2.field2515.length - 2) {
            var6 = (var2.field2515[var1.field2572] & 255) << 8;
            var7 = (var2.field2515[var1.field2572 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2515[var1.field2572 + 3] - var5) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(Lgi;I)I",
      garbageValue = "1253376616"
   )
   int method3828(class205 var1) {
      int var2 = this.field2530[var1.field2563];
      return var2 < 8192?32 + var2 * var1.field2557 >> 6:16384 - ((128 - var1.field2557) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "81"
   )
   public synchronized void method3805(int var1, int var2) {
      this.method3806(var1, var2);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "43"
   )
   void method3841(int var1) {
      for(class205 var2 = (class205)this.field2528.field2601.getFront(); var2 != null; var2 = (class205)this.field2528.field2601.getNext()) {
         if((var1 < 0 || var2.field2563 == var1) && var2.field2571 < 0) {
            this.field2545[var2.field2563][var2.field2574] = null;
            var2.field2571 = 0;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Ljl;",
      garbageValue = "-110"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-338123019"
   )
   static final void method3924(boolean var0) {
      if(var0) {
         Client.field957 = class90.field1438?class149.field2207:class149.field2212;
      } else {
         LinkedHashMap var1 = class23.preferences.preferences;
         String var3 = class90.username;
         int var4 = var3.length();
         int var5 = 0;

         for(int var6 = 0; var6 < var4; ++var6) {
            var5 = (var5 << 5) - var5 + var3.charAt(var6);
         }

         Client.field957 = var1.containsKey(Integer.valueOf(var5))?class149.field2210:class149.field2209;
      }

   }
}
