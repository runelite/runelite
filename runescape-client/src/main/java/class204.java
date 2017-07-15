import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class204 extends class119 {
   @ObfuscatedName("b")
   int[] field2514;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 507355115
   )
   int field2536;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1968419167
   )
   int field2515;
   @ObfuscatedName("m")
   int[] field2530;
   @ObfuscatedName("v")
   int[] field2519;
   @ObfuscatedName("l")
   int[] field2520;
   @ObfuscatedName("s")
   int[] field2521;
   @ObfuscatedName("a")
   XHashTable field2528;
   @ObfuscatedName("y")
   class205[][] field2532;
   @ObfuscatedName("h")
   int[] field2526;
   @ObfuscatedName("ae")
   class206 field2529;
   @ObfuscatedName("aw")
   class208 field2540;
   @ObfuscatedName("e")
   int[] field2523;
   @ObfuscatedName("r")
   int[] field2534;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -2005292139
   )
   int field2537;
   @ObfuscatedName("q")
   int[] field2531;
   @ObfuscatedName("p")
   int[] field2522;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      longValue = 5165046383231895581L
   )
   long field2539;
   @ObfuscatedName("d")
   int[] field2516;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 829000707
   )
   int field2517;
   @ObfuscatedName("ai")
   class205[][] field2533;
   @ObfuscatedName("au")
   boolean field2535;
   @ObfuscatedName("i")
   int[] field2518;
   @ObfuscatedName("g")
   int[] field2525;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      longValue = -7023091034204842409L
   )
   long field2538;
   @ObfuscatedName("u")
   int[] field2524;
   @ObfuscatedName("z")
   int[] field2527;

   public class204() {
      this.field2515 = 256;
      this.field2517 = 1000000;
      this.field2534 = new int[16];
      this.field2519 = new int[16];
      this.field2523 = new int[16];
      this.field2520 = new int[16];
      this.field2521 = new int[16];
      this.field2522 = new int[16];
      this.field2530 = new int[16];
      this.field2524 = new int[16];
      this.field2525 = new int[16];
      this.field2526 = new int[16];
      this.field2527 = new int[16];
      this.field2518 = new int[16];
      this.field2516 = new int[16];
      this.field2514 = new int[16];
      this.field2531 = new int[16];
      this.field2532 = new class205[16][128];
      this.field2533 = new class205[16][128];
      this.field2529 = new class206();
      this.field2540 = new class208(this);
      this.field2528 = new XHashTable(128);
      this.method3718();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "32"
   )
   void method3706(int var1, int var2) {
      this.field2520[var1] = var2;
      this.field2522[var1] = var2 & -128;
      this.method3759(var1, var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-14"
   )
   void method3710(int var1, int var2, int var3) {
      class205 var4 = this.field2532[var1][var2];
      if(var4 != null) {
         this.field2532[var1][var2] = null;
         if((this.field2526[var1] & 2) != 0) {
            for(class205 var5 = (class205)this.field2540.field2590.getFront(); var5 != null; var5 = (class205)this.field2540.field2590.getNext()) {
               if(var5.field2545 == var4.field2545 && var5.field2551 < 0 && var4 != var5) {
                  var4.field2551 = 0;
                  break;
               }
            }
         } else {
            var4.field2551 = 0;
         }

      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1139234946"
   )
   void method3714(int var1) {
      for(class205 var2 = (class205)this.field2540.field2590.getFront(); var2 != null; var2 = (class205)this.field2540.field2590.getNext()) {
         if(var1 < 0 || var2.field2545 == var1) {
            if(var2.field2557 != null) {
               var2.field2557.method2123(ChatLineBuffer.sampleRate / 100);
               if(var2.field2557.method2127()) {
                  this.field2540.field2591.method1880(var2.field2557);
               }

               var2.method3804();
            }

            if(var2.field2551 < 0) {
               this.field2532[var2.field2545][var2.field2546] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-34001358"
   )
   public synchronized void method3703() {
      this.field2529.method3839();
      this.method3718();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2085610584"
   )
   void method3715(int var1) {
      if(var1 >= 0) {
         this.field2534[var1] = 12800;
         this.field2519[var1] = 8192;
         this.field2523[var1] = 16383;
         this.field2530[var1] = 8192;
         this.field2524[var1] = 0;
         this.field2525[var1] = 8192;
         this.method3748(var1);
         this.method3719(var1);
         this.field2526[var1] = 0;
         this.field2527[var1] = 32767;
         this.field2518[var1] = 256;
         this.field2516[var1] = 0;
         this.method3721(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3715(var1);
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1504444707"
   )
   void method3708(int var1, int var2, int var3) {
      this.method3710(var1, var2, 64);
      if((this.field2526[var1] & 2) != 0) {
         for(class205 var4 = (class205)this.field2540.field2590.getTail(); var4 != null; var4 = (class205)this.field2540.field2590.getPrevious()) {
            if(var4.field2545 == var1 && var4.field2551 < 0) {
               this.field2532[var1][var4.field2546] = null;
               this.field2532[var1][var2] = var4;
               int var5 = (var4.field2556 * var4.field2550 >> 12) + var4.field2549;
               var4.field2549 += var2 - var4.field2546 << 8;
               var4.field2550 = var5 - var4.field2549;
               var4.field2556 = 4096;
               var4.field2546 = var2;
               return;
            }
         }
      }

      class207 var9 = (class207)this.field2528.get((long)this.field2521[var1]);
      if(var9 != null) {
         class107 var8 = var9.field2579[var2];
         if(var8 != null) {
            class205 var6 = new class205();
            var6.field2545 = var1;
            var6.field2542 = var9;
            var6.field2543 = var8;
            var6.field2544 = var9.field2578[var2];
            var6.field2548 = var9.field2584[var2];
            var6.field2546 = var2;
            var6.field2547 = var9.field2583[var2] * var3 * var3 * var9.field2581 + 1024 >> 11;
            var6.field2563 = var9.field2582[var2] & 255;
            var6.field2549 = (var2 << 8) - (var9.field2580[var2] & 32767);
            var6.field2552 = 0;
            var6.field2553 = 0;
            var6.field2554 = 0;
            var6.field2551 = -1;
            var6.field2555 = 0;
            if(this.field2516[var1] == 0) {
               var6.field2557 = class117.method2178(var8, this.method3722(var6), this.method3800(var6), this.method3724(var6));
            } else {
               var6.field2557 = class117.method2178(var8, this.method3722(var6), 0, this.method3724(var6));
               this.method3709(var6, var9.field2580[var2] < 0);
            }

            if(var9.field2580[var2] < 0) {
               var6.field2557.method2212(-1);
            }

            if(var6.field2548 >= 0) {
               class205 var7 = this.field2533[var1][var6.field2548];
               if(var7 != null && var7.field2551 < 0) {
                  this.field2532[var1][var7.field2546] = null;
                  var7.field2551 = 0;
               }

               this.field2533[var1][var6.field2548] = var6;
            }

            this.field2540.field2590.addFront(var6);
            this.field2532[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "235161870"
   )
   void method3737(int var1, int var2, int var3) {
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   void method3718() {
      this.method3714(-1);
      this.method3715(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2521[var1] = this.field2520[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2522[var1] = this.field2520[var1] & -128;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1743954504"
   )
   void method3759(int var1, int var2) {
      if(var2 != this.field2521[var1]) {
         this.field2521[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2533[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("w")
   protected synchronized void vmethod3872(int[] var1, int var2, int var3) {
      if(this.field2529.method3816()) {
         int var4 = this.field2529.field2565 * this.field2517 / ChatLineBuffer.sampleRate;

         do {
            long var5 = this.field2538 + (long)var4 * (long)var3;
            if(this.field2539 - var5 >= 0L) {
               this.field2538 = var5;
               break;
            }

            int var7 = (int)((this.field2539 - this.field2538 + (long)var4 - 1L) / (long)var4);
            this.field2538 += (long)var4 * (long)var7;
            this.field2540.vmethod3872(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3730();
         } while(this.field2529.method3816());
      }

      this.field2540.vmethod3872(var1, var2, var3);
   }

   @ObfuscatedName("m")
   protected synchronized void vmethod3869(int var1) {
      if(this.field2529.method3816()) {
         int var2 = this.field2529.field2565 * this.field2517 / ChatLineBuffer.sampleRate;

         do {
            long var3 = (long)var1 * (long)var2 + this.field2538;
            if(this.field2539 - var3 >= 0L) {
               this.field2538 = var3;
               break;
            }

            int var5 = (int)((this.field2539 - this.field2538 + (long)var2 - 1L) / (long)var2);
            this.field2538 += (long)var2 * (long)var5;
            this.field2540.vmethod3869(var5);
            var1 -= var5;
            this.method3730();
         } while(this.field2529.method3816());
      }

      this.field2540.vmethod3869(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "92"
   )
   void method3712(int var1, int var2) {
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-33021930"
   )
   void method3713(int var1, int var2) {
      this.field2530[var1] = var2;
   }

   @ObfuscatedName("l")
   protected synchronized class119 vmethod3882() {
      return null;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "1620062431"
   )
   int method3722(class205 var1) {
      int var2 = (var1.field2550 * var1.field2556 >> 12) + var1.field2549;
      var2 += (this.field2530[var1.field2545] - 8192) * this.field2518[var1.field2545] >> 12;
      class202 var3 = var1.field2544;
      int var4;
      if(var3.field2492 > 0 && (var3.field2491 > 0 || this.field2524[var1.field2545] > 0)) {
         var4 = var3.field2491 << 2;
         int var5 = var3.field2493 << 1;
         if(var1.field2562 < var5) {
            var4 = var4 * var1.field2562 / var5;
         }

         var4 += this.field2524[var1.field2545] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2558 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2543.field1603 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)ChatLineBuffer.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LTrack1;LIndexDataBase;Lclass112;II)Z",
      garbageValue = "-1876587443"
   )
   public synchronized boolean method3699(Track1 var1, IndexDataBase var2, class112 var3, int var4) {
      var1.method3894();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(class199 var7 = (class199)var1.field2597.method3538(); var7 != null; var7 = (class199)var1.field2597.method3539()) {
         int var8 = (int)var7.hash;
         class207 var9 = (class207)this.field2528.get((long)var8);
         if(var9 == null) {
            var9 = class203.method3695(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2528.put(var9, (long)var8);
         }

         if(!var9.method3857(var3, var7.field2480, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3895();
      }

      return var5;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)Z",
      garbageValue = "-2061627458"
   )
   boolean method3731(class205 var1) {
      if(var1.field2557 == null) {
         if(var1.field2551 >= 0) {
            var1.unlink();
            if(var1.field2548 > 0 && var1 == this.field2533[var1.field2545][var1.field2548]) {
               this.field2533[var1.field2545][var1.field2548] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "11594"
   )
   void method3748(int var1) {
      if((this.field2526[var1] & 2) != 0) {
         for(class205 var2 = (class205)this.field2540.field2590.getFront(); var2 != null; var2 = (class205)this.field2540.field2590.getNext()) {
            if(var2.field2545 == var1 && this.field2532[var1][var2.field2546] == null && var2.field2551 < 0) {
               var2.field2551 = 0;
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "858750498"
   )
   int method3698() {
      return this.field2515;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1595298028"
   )
   public synchronized void method3786() {
      for(class207 var1 = (class207)this.field2528.method3538(); var1 != null; var1 = (class207)this.field2528.method3539()) {
         var1.method3858();
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "55"
   )
   void method3719(int var1) {
      if((this.field2526[var1] & 4) != 0) {
         for(class205 var2 = (class205)this.field2540.field2590.getFront(); var2 != null; var2 = (class205)this.field2540.field2590.getNext()) {
            if(var2.field2545 == var1) {
               var2.field2561 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-3534"
   )
   void method3720(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3710(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3708(var3, var4, var5);
         } else {
            this.method3710(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3737(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2522[var3] = (var5 << 14) + (this.field2522[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2522[var3] = (var5 << 7) + (this.field2522[var3] & -16257);
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
            this.field2534[var3] = (var5 << 7) + (this.field2534[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2534[var3] = var5 + (this.field2534[var3] & -128);
         }

         if(var4 == 10) {
            this.field2519[var3] = (var5 << 7) + (this.field2519[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2519[var3] = var5 + (this.field2519[var3] & -128);
         }

         if(var4 == 11) {
            this.field2523[var3] = (var5 << 7) + (this.field2523[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2523[var3] = var5 + (this.field2523[var3] & -128);
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
               this.method3748(var3);
               this.field2526[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2527[var3] = (var5 << 7) + (this.field2527[var3] & 127);
         }

         if(var4 == 98) {
            this.field2527[var3] = (this.field2527[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2527[var3] = (var5 << 7) + (this.field2527[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2527[var3] = var5 + (this.field2527[var3] & 16256) + 16384;
         }

         if(var4 == 120) {
            this.method3714(var3);
         }

         if(var4 == 121) {
            this.method3715(var3);
         }

         if(var4 == 123) {
            this.method3716(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2527[var3];
            if(var6 == 16384) {
               this.field2518[var3] = (var5 << 7) + (this.field2518[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2527[var3];
            if(var6 == 16384) {
               this.field2518[var3] = var5 + (this.field2518[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2516[var3] = (var5 << 7) + (this.field2516[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2516[var3] = var5 + (this.field2516[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2526[var3] |= 4;
            } else {
               this.method3719(var3);
               this.field2526[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3721(var3, (var5 << 7) + (this.field2514[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3721(var3, var5 + (this.field2514[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3759(var3, var4 + this.field2522[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3712(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3713(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3718();
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "166221106"
   )
   public synchronized boolean method3704() {
      return this.field2529.method3816();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-778826804"
   )
   public synchronized void method3697(int var1) {
      this.field2515 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1469676646"
   )
   synchronized void method3701() {
      for(class207 var1 = (class207)this.field2528.method3538(); var1 != null; var1 = (class207)this.field2528.method3539()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LTrack1;ZB)V",
      garbageValue = "30"
   )
   public synchronized void method3702(Track1 var1, boolean var2) {
      this.method3703();
      this.field2529.method3807(var1.field2598);
      this.field2535 = var2;
      this.field2538 = 0L;
      int var3 = this.field2529.method3810();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2529.method3811(var4);
         this.field2529.method3814(var4);
         this.field2529.method3812(var4);
      }

      this.field2536 = this.field2529.method3831();
      this.field2537 = this.field2529.field2569[this.field2536];
      this.field2539 = this.field2529.method3832(this.field2537);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(Lclass205;[IIII)Z",
      garbageValue = "555631900"
   )
   boolean method3780(class205 var1, int[] var2, int var3, int var4) {
      var1.field2560 = ChatLineBuffer.sampleRate / 100;
      if(var1.field2551 < 0 || var1.field2557 != null && !var1.field2557.method2126()) {
         int var5 = var1.field2556;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2525[var1.field2545] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2556 = var5;
         }

         var1.field2557.method2124(this.method3722(var1));
         class202 var6 = var1.field2544;
         boolean var7 = false;
         ++var1.field2562;
         var1.field2558 += var6.field2492;
         double var8 = (double)((var1.field2546 - 60 << 8) + (var1.field2550 * var1.field2556 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2494 > 0) {
            if(var6.field2490 > 0) {
               var1.field2552 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2490) + 0.5D);
            } else {
               var1.field2552 += 128;
            }
         }

         if(var6.field2488 != null) {
            if(var6.field2487 > 0) {
               var1.field2553 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2487) + 0.5D);
            } else {
               var1.field2553 += 128;
            }

            while(var1.field2554 < var6.field2488.length - 2 && var1.field2553 > (var6.field2488[var1.field2554 + 2] & 255) << 8) {
               var1.field2554 += 2;
            }

            if(var6.field2488.length - 2 == var1.field2554 && var6.field2488[var1.field2554 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2551 >= 0 && var6.field2486 != null && (this.field2526[var1.field2545] & 1) == 0 && (var1.field2548 < 0 || var1 != this.field2533[var1.field2545][var1.field2548])) {
            if(var6.field2489 > 0) {
               var1.field2551 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2489 * var8) + 0.5D);
            } else {
               var1.field2551 += 128;
            }

            while(var1.field2555 < var6.field2486.length - 2 && var1.field2551 > (var6.field2486[var1.field2555 + 2] & 255) << 8) {
               var1.field2555 += 2;
            }

            if(var6.field2486.length - 2 == var1.field2555) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2557.method2123(var1.field2560);
            if(var2 != null) {
               var1.field2557.vmethod3872(var2, var3, var4);
            } else {
               var1.field2557.vmethod3869(var4);
            }

            if(var1.field2557.method2127()) {
               this.field2540.field2591.method1880(var1.field2557);
            }

            var1.method3804();
            if(var1.field2551 >= 0) {
               var1.unlink();
               if(var1.field2548 > 0 && var1 == this.field2533[var1.field2545][var1.field2548]) {
                  this.field2533[var1.field2545][var1.field2548] = null;
               }
            }

            return true;
         } else {
            var1.field2557.method2113(var1.field2560, this.method3800(var1), this.method3724(var1));
            return false;
         }
      } else {
         var1.method3804();
         var1.unlink();
         if(var1.field2548 > 0 && var1 == this.field2533[var1.field2545][var1.field2548]) {
            this.field2533[var1.field2545][var1.field2548] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "5"
   )
   void method3721(int var1, int var2) {
      this.field2514[var1] = var2;
      this.field2531[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("e")
   protected synchronized class119 vmethod3883() {
      return this.field2540;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "23"
   )
   void method3730() {
      int var1 = this.field2536;
      int var2 = this.field2537;

      long var3;
      for(var3 = this.field2539; var2 == this.field2537; var3 = this.field2529.method3832(var2)) {
         while(var2 == this.field2529.field2569[var1]) {
            this.field2529.method3811(var1);
            int var5 = this.field2529.method3849(var1);
            if(var5 == 1) {
               this.field2529.method3813();
               this.field2529.method3812(var1);
               if(this.field2529.method3819()) {
                  if(!this.field2535 || var2 == 0) {
                     this.method3718();
                     this.field2529.method3839();
                     return;
                  }

                  this.field2529.method3820(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3720(var5);
            }

            this.field2529.method3814(var1);
            this.field2529.method3812(var1);
         }

         var1 = this.field2529.method3831();
         var2 = this.field2529.field2569[var1];
      }

      this.field2536 = var1;
      this.field2537 = var2;
      this.field2539 = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass205;ZB)V",
      garbageValue = "0"
   )
   void method3709(class205 var1, boolean var2) {
      int var3 = var1.field2543.field1607.length;
      int var4;
      if(var2 && var1.field2543.field1604) {
         int var5 = var3 + var3 - var1.field2543.field1605;
         var4 = (int)((long)var5 * (long)this.field2516[var1.field2545] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2557.method2119();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2516[var1.field2545] >> 6);
      }

      var1.field2557.method2165(var4);
   }

   @ObfuscatedName("s")
   protected synchronized int vmethod3871() {
      return 0;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "-1685397867"
   )
   int method3800(class205 var1) {
      class202 var2 = var1.field2544;
      int var3 = this.field2523[var1.field2545] * this.field2534[var1.field2545] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var1.field2547 * var3 + 16384 >> 15;
      var3 = var3 * this.field2515 + 128 >> 8;
      if(var2.field2494 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2494 * (double)var1.field2552 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2488 != null) {
         var4 = var1.field2553;
         var5 = var2.field2488[var1.field2554 + 1];
         if(var1.field2554 < var2.field2488.length - 2) {
            var6 = (var2.field2488[var1.field2554] & 255) << 8;
            var7 = (var2.field2488[var1.field2554 + 2] & 255) << 8;
            var5 += (var2.field2488[var1.field2554 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2551 > 0 && var2.field2486 != null) {
         var4 = var1.field2551;
         var5 = var2.field2486[var1.field2555 + 1];
         if(var1.field2555 < var2.field2486.length - 2) {
            var6 = (var2.field2486[var1.field2555] & 255) << 8;
            var7 = (var2.field2486[var1.field2555 + 2] & 255) << 8;
            var5 += (var2.field2486[var1.field2555 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass205;I)I",
      garbageValue = "-1352492662"
   )
   int method3724(class205 var1) {
      int var2 = this.field2519[var1.field2545];
      return var2 < 8192?var2 * var1.field2563 + 32 >> 6:16384 - ((128 - var1.field2563) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "24"
   )
   public synchronized void method3741(int var1, int var2) {
      this.method3706(var1, var2);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "871361115"
   )
   void method3716(int var1) {
      for(class205 var2 = (class205)this.field2540.field2590.getFront(); var2 != null; var2 = (class205)this.field2540.field2590.getNext()) {
         if((var1 < 0 || var2.field2545 == var1) && var2.field2551 < 0) {
            this.field2532[var2.field2545][var2.field2546] = null;
            var2.field2551 = 0;
         }
      }

   }
}
