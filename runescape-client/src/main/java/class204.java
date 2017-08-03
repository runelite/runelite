import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class204 extends class121 {
   @ObfuscatedName("h")
   int[] field2500;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1498844493
   )
   int field2506;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 333662129
   )
   int field2484;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   XHashTable field2490;
   @ObfuscatedName("r")
   int[] field2504;
   @ObfuscatedName("e")
   int[] field2489;
   @ObfuscatedName("v")
   int[] field2496;
   @ObfuscatedName("t")
   int[] field2508;
   @ObfuscatedName("c")
   int[] field2513;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[[Lgd;"
   )
   class205[][] field2502;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   class206 field2492;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   class208 field2510;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -353068331
   )
   int field2507;
   @ObfuscatedName("y")
   int[] field2487;
   @ObfuscatedName("z")
   int[] field2501;
   @ObfuscatedName("i")
   int[] field2491;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      longValue = 7562705475738458095L
   )
   long field2483;
   @ObfuscatedName("f")
   int[] field2488;
   @ObfuscatedName("a")
   int[] field2499;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1259799689
   )
   int field2485;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "[[Lgd;"
   )
   class205[][] field2503;
   @ObfuscatedName("ax")
   boolean field2505;
   @ObfuscatedName("m")
   int[] field2512;
   @ObfuscatedName("s")
   int[] field2494;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      longValue = -5950651056739228119L
   )
   long field2486;
   @ObfuscatedName("g")
   int[] field2493;
   @ObfuscatedName("l")
   int[] field2497;

   public class204() {
      this.field2484 = 256;
      this.field2485 = 1000000;
      this.field2487 = new int[16];
      this.field2489 = new int[16];
      this.field2488 = new int[16];
      this.field2496 = new int[16];
      this.field2508 = new int[16];
      this.field2491 = new int[16];
      this.field2504 = new int[16];
      this.field2493 = new int[16];
      this.field2494 = new int[16];
      this.field2513 = new int[16];
      this.field2497 = new int[16];
      this.field2512 = new int[16];
      this.field2499 = new int[16];
      this.field2500 = new int[16];
      this.field2501 = new int[16];
      this.field2502 = new class205[16][128];
      this.field2503 = new class205[16][128];
      this.field2492 = new class206();
      this.field2510 = new class208(this);
      this.field2490 = new XHashTable(128);
      this.method3729();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1970360253"
   )
   void method3787(int var1, int var2) {
      this.field2496[var1] = var2;
      this.field2491[var1] = var2 & -128;
      this.method3719(var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2060504995"
   )
   void method3816(int var1, int var2, int var3) {
      class205 var4 = this.field2502[var1][var2];
      if(var4 != null) {
         this.field2502[var1][var2] = null;
         if((this.field2513[var1] & 2) != 0) {
            for(class205 var5 = (class205)this.field2510.field2568.getFront(); var5 != null; var5 = (class205)this.field2510.field2568.getNext()) {
               if(var5.field2533 == var4.field2533 && var5.field2528 < 0 && var4 != var5) {
                  var4.field2528 = 0;
                  break;
               }
            }
         } else {
            var4.field2528 = 0;
         }

      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1896600605"
   )
   void method3726(int var1) {
      for(class205 var2 = (class205)this.field2510.field2568.getFront(); var2 != null; var2 = (class205)this.field2510.field2568.getNext()) {
         if(var1 < 0 || var2.field2533 == var1) {
            if(var2.field2532 != null) {
               var2.field2532.method2237(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2532.method2213()) {
                  this.field2510.field2569.method1937(var2.field2532);
               }

               var2.method3834();
            }

            if(var2.field2528 < 0) {
               this.field2502[var2.field2533][var2.field2519] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1564937124"
   )
   public synchronized void method3819() {
      this.field2492.method3872();
      this.method3729();
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "202865831"
   )
   void method3724(int var1) {
      if(var1 >= 0) {
         this.field2487[var1] = 12800;
         this.field2489[var1] = 8192;
         this.field2488[var1] = 16383;
         this.field2504[var1] = 8192;
         this.field2493[var1] = 0;
         this.field2494[var1] = 8192;
         this.method3730(var1);
         this.method3731(var1);
         this.field2513[var1] = 0;
         this.field2497[var1] = 32767;
         this.field2512[var1] = 256;
         this.field2499[var1] = 0;
         this.method3733(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3724(var1);
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1215111622"
   )
   void method3723(int var1, int var2, int var3) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1875851944"
   )
   void method3727(int var1, int var2, int var3) {
      this.method3816(var1, var2, 64);
      if((this.field2513[var1] & 2) != 0) {
         for(class205 var4 = (class205)this.field2510.field2568.getTail(); var4 != null; var4 = (class205)this.field2510.field2568.getPrevious()) {
            if(var4.field2533 == var1 && var4.field2528 < 0) {
               this.field2502[var1][var4.field2519] = null;
               this.field2502[var1][var2] = var4;
               int var5 = (var4.field2524 * var4.field2523 >> 12) + var4.field2534;
               var4.field2534 += var2 - var4.field2519 << 8;
               var4.field2523 = var5 - var4.field2534;
               var4.field2524 = 4096;
               var4.field2519 = var2;
               return;
            }
         }
      }

      class207 var9 = (class207)this.field2490.get((long)this.field2508[var1]);
      if(var9 != null) {
         class109 var8 = var9.field2552[var2];
         if(var8 != null) {
            class205 var6 = new class205();
            var6.field2533 = var1;
            var6.field2515 = var9;
            var6.field2516 = var8;
            var6.field2520 = var9.field2556[var2];
            var6.field2518 = var9.field2557[var2];
            var6.field2519 = var2;
            var6.field2514 = 1024 + var3 * var3 * var9.field2563[var2] * var9.field2566 >> 11;
            var6.field2521 = var9.field2560[var2] & 255;
            var6.field2534 = (var2 << 8) - (var9.field2553[var2] & 32767);
            var6.field2525 = 0;
            var6.field2526 = 0;
            var6.field2517 = 0;
            var6.field2528 = -1;
            var6.field2529 = 0;
            if(this.field2499[var1] == 0) {
               var6.field2532 = class119.method2196(var8, this.method3734(var6), this.method3735(var6), this.method3736(var6));
            } else {
               var6.field2532 = class119.method2196(var8, this.method3734(var6), 0, this.method3736(var6));
               this.method3721(var6, var9.field2553[var2] < 0);
            }

            if(var9.field2553[var2] < 0) {
               var6.field2532.method2198(-1);
            }

            if(var6.field2518 >= 0) {
               class205 var7 = this.field2503[var1][var6.field2518];
               if(var7 != null && var7.field2528 < 0) {
                  this.field2502[var1][var7.field2519] = null;
                  var7.field2528 = 0;
               }

               this.field2503[var1][var6.field2518] = var6;
            }

            this.field2510.field2568.addFront(var6);
            this.field2502[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-986315458"
   )
   void method3729() {
      this.method3726(-1);
      this.method3724(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2508[var1] = this.field2496[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2491[var1] = this.field2496[var1] & -128;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-98"
   )
   void method3719(int var1, int var2) {
      if(var2 != this.field2508[var1]) {
         this.field2508[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2503[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("i")
   protected synchronized void vmethod3897(int[] var1, int var2, int var3) {
      if(this.field2492.method3870()) {
         int var4 = this.field2492.field2538 * this.field2485 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = (long)var3 * (long)var4 + this.field2486;
            if(this.field2483 - var5 >= 0L) {
               this.field2486 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2483 - this.field2486) - 1L) / (long)var4);
            this.field2486 += (long)var4 * (long)var7;
            this.field2510.vmethod3897(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3742();
         } while(this.field2492.method3870());
      }

      this.field2510.vmethod3897(var1, var2, var3);
   }

   @ObfuscatedName("g")
   protected synchronized void vmethod3898(int var1) {
      if(this.field2492.method3870()) {
         int var2 = this.field2492.field2538 * this.field2485 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = this.field2486 + (long)var1 * (long)var2;
            if(this.field2483 - var3 >= 0L) {
               this.field2486 = var3;
               break;
            }

            int var5 = (int)((this.field2483 - this.field2486 + (long)var2 - 1L) / (long)var2);
            this.field2486 += (long)var5 * (long)var2;
            this.field2510.vmethod3898(var5);
            var1 -= var5;
            this.method3742();
         } while(this.field2492.method3870());
      }

      this.field2510.vmethod3898(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1129954408"
   )
   void method3769(int var1, int var2) {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-931029828"
   )
   void method3725(int var1, int var2) {
      this.field2504[var1] = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected synchronized class121 vmethod3895() {
      return null;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lgd;I)I",
      garbageValue = "-855920538"
   )
   int method3734(class205 var1) {
      int var2 = (var1.field2523 * var1.field2524 >> 12) + var1.field2534;
      var2 += (this.field2504[var1.field2533] - 8192) * this.field2512[var1.field2533] >> 12;
      class202 var3 = var1.field2520;
      int var4;
      if(var3.field2466 > 0 && (var3.field2465 > 0 || this.field2493[var1.field2533] > 0)) {
         var4 = var3.field2465 << 2;
         int var5 = var3.field2460 << 1;
         if(var1.field2530 < var5) {
            var4 = var4 * var1.field2530 / var5;
         }

         var4 += this.field2493[var1.field2533] >> 7;
         double var6 = Math.sin((double)(var1.field2531 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2516.field1599 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lhb;Lim;Ldp;II)Z",
      garbageValue = "1830808675"
   )
   public synchronized boolean method3715(Track1 var1, IndexDataBase var2, class114 var3, int var4) {
      var1.method3921();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(class199 var7 = (class199)var1.field2575.method3564(); var7 != null; var7 = (class199)var1.field2575.method3565()) {
         int var8 = (int)var7.hash;
         class207 var9 = (class207)this.field2490.get((long)var8);
         if(var9 == null) {
            var9 = class155.method2989(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2490.put(var9, (long)var8);
         }

         if(!var9.method3884(var3, var7.field2454, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3922();
      }

      return var5;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(Lgd;B)Z",
      garbageValue = "11"
   )
   boolean method3829(class205 var1) {
      if(var1.field2532 == null) {
         if(var1.field2528 >= 0) {
            var1.unlink();
            if(var1.field2518 > 0 && var1 == this.field2503[var1.field2533][var1.field2518]) {
               this.field2503[var1.field2533][var1.field2518] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-59"
   )
   void method3730(int var1) {
      if((this.field2513[var1] & 2) != 0) {
         for(class205 var2 = (class205)this.field2510.field2568.getFront(); var2 != null; var2 = (class205)this.field2510.field2568.getNext()) {
            if(var2.field2533 == var1 && this.field2502[var1][var2.field2519] == null && var2.field2528 < 0) {
               var2.field2528 = 0;
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-672751970"
   )
   int method3792() {
      return this.field2484;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1168795816"
   )
   void method3731(int var1) {
      if((this.field2513[var1] & 4) != 0) {
         for(class205 var2 = (class205)this.field2510.field2568.getFront(); var2 != null; var2 = (class205)this.field2510.field2568.getNext()) {
            if(var2.field2533 == var1) {
               var2.field2527 = 0;
            }
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1855705323"
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
         this.method3816(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3727(var3, var4, var5);
         } else {
            this.method3816(var3, var4, 64);
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
            this.field2491[var3] = (var5 << 14) + (this.field2491[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2491[var3] = (var5 << 7) + (this.field2491[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2493[var3] = (var5 << 7) + (this.field2493[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2493[var3] = var5 + (this.field2493[var3] & -128);
         }

         if(var4 == 5) {
            this.field2494[var3] = (var5 << 7) + (this.field2494[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2494[var3] = var5 + (this.field2494[var3] & -128);
         }

         if(var4 == 7) {
            this.field2487[var3] = (var5 << 7) + (this.field2487[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2487[var3] = var5 + (this.field2487[var3] & -128);
         }

         if(var4 == 10) {
            this.field2489[var3] = (var5 << 7) + (this.field2489[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2489[var3] = var5 + (this.field2489[var3] & -128);
         }

         if(var4 == 11) {
            this.field2488[var3] = (var5 << 7) + (this.field2488[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2488[var3] = var5 + (this.field2488[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2513[var3] |= 1;
            } else {
               this.field2513[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2513[var3] |= 2;
            } else {
               this.method3730(var3);
               this.field2513[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2497[var3] = (var5 << 7) + (this.field2497[var3] & 127);
         }

         if(var4 == 98) {
            this.field2497[var3] = (this.field2497[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2497[var3] = (var5 << 7) + (this.field2497[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2497[var3] = (this.field2497[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3726(var3);
         }

         if(var4 == 121) {
            this.method3724(var3);
         }

         if(var4 == 123) {
            this.method3814(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2497[var3];
            if(var6 == 16384) {
               this.field2512[var3] = (var5 << 7) + (this.field2512[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2497[var3];
            if(var6 == 16384) {
               this.field2512[var3] = var5 + (this.field2512[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2499[var3] = (var5 << 7) + (this.field2499[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2499[var3] = var5 + (this.field2499[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2513[var3] |= 4;
            } else {
               this.method3731(var3);
               this.field2513[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3733(var3, (var5 << 7) + (this.field2500[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3733(var3, var5 + (this.field2500[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3719(var3, var4 + this.field2491[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3769(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3725(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3729();
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2101504387"
   )
   synchronized boolean method3716() {
      return this.field2492.method3870();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "19"
   )
   public synchronized void method3712() {
      for(class207 var1 = (class207)this.field2490.method3564(); var1 != null; var1 = (class207)this.field2490.method3565()) {
         var1.method3885();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1089916327"
   )
   synchronized void method3728() {
      for(class207 var1 = (class207)this.field2490.method3564(); var1 != null; var1 = (class207)this.field2490.method3565()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(Lgd;[IIII)Z",
      garbageValue = "-1389206879"
   )
   boolean method3739(class205 var1, int[] var2, int var3, int var4) {
      var1.field2522 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2528 < 0 || var1.field2532 != null && !var1.field2532.method2212()) {
         int var5 = var1.field2524;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2494[var1.field2533]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2524 = var5;
         }

         var1.field2532.method2206(this.method3734(var1));
         class202 var6 = var1.field2520;
         boolean var7 = false;
         ++var1.field2530;
         var1.field2531 += var6.field2466;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2519 - 60 << 8) + (var1.field2523 * var1.field2524 >> 12));
         if(var6.field2461 > 0) {
            if(var6.field2464 > 0) {
               var1.field2525 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2464 * var8) + 0.5D);
            } else {
               var1.field2525 += 128;
            }
         }

         if(var6.field2462 != null) {
            if(var6.field2467 > 0) {
               var1.field2526 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2467) + 0.5D);
            } else {
               var1.field2526 += 128;
            }

            while(var1.field2517 < var6.field2462.length - 2 && var1.field2526 > (var6.field2462[var1.field2517 + 2] & 255) << 8) {
               var1.field2517 += 2;
            }

            if(var6.field2462.length - 2 == var1.field2517 && var6.field2462[var1.field2517 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2528 >= 0 && var6.field2459 != null && (this.field2513[var1.field2533] & 1) == 0 && (var1.field2518 < 0 || var1 != this.field2503[var1.field2533][var1.field2518])) {
            if(var6.field2463 > 0) {
               var1.field2528 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2463) + 0.5D);
            } else {
               var1.field2528 += 128;
            }

            while(var1.field2529 < var6.field2459.length - 2 && var1.field2528 > (var6.field2459[var1.field2529 + 2] & 255) << 8) {
               var1.field2529 += 2;
            }

            if(var6.field2459.length - 2 == var1.field2529) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2532.method2237(var1.field2522);
            if(var2 != null) {
               var1.field2532.vmethod3897(var2, var3, var4);
            } else {
               var1.field2532.vmethod3898(var4);
            }

            if(var1.field2532.method2213()) {
               this.field2510.field2569.method1937(var1.field2532);
            }

            var1.method3834();
            if(var1.field2528 >= 0) {
               var1.unlink();
               if(var1.field2518 > 0 && var1 == this.field2503[var1.field2533][var1.field2518]) {
                  this.field2503[var1.field2533][var1.field2518] = null;
               }
            }

            return true;
         } else {
            var1.field2532.method2270(var1.field2522, this.method3735(var1), this.method3736(var1));
            return false;
         }
      } else {
         var1.method3834();
         var1.unlink();
         if(var1.field2518 > 0 && var1 == this.field2503[var1.field2533][var1.field2518]) {
            this.field2503[var1.field2533][var1.field2518] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "320276396"
   )
   public synchronized void method3709(int var1) {
      this.field2484 = var1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-402144738"
   )
   void method3733(int var1, int var2) {
      this.field2500[var1] = var2;
      this.field2501[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected synchronized class121 vmethod3913() {
      return this.field2510;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lhb;ZI)V",
      garbageValue = "-686244598"
   )
   public synchronized void method3776(Track1 var1, boolean var2) {
      this.method3819();
      this.field2492.method3837(var1.field2576);
      this.field2505 = var2;
      this.field2486 = 0L;
      int var3 = this.field2492.method3840();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2492.method3841(var4);
         this.field2492.method3860(var4);
         this.field2492.method3842(var4);
      }

      this.field2506 = this.field2492.method3849();
      this.field2507 = this.field2492.field2550[this.field2506];
      this.field2483 = this.field2492.method3848(this.field2507);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-18439"
   )
   void method3742() {
      int var1 = this.field2506;
      int var2 = this.field2507;

      long var3;
      for(var3 = this.field2483; var2 == this.field2507; var3 = this.field2492.method3848(var2)) {
         while(var2 == this.field2492.field2550[var1]) {
            this.field2492.method3841(var1);
            int var5 = this.field2492.method3836(var1);
            if(var5 == 1) {
               this.field2492.method3843();
               this.field2492.method3842(var1);
               if(this.field2492.method3850()) {
                  if(!this.field2505 || var2 == 0) {
                     this.method3729();
                     this.field2492.method3872();
                     return;
                  }

                  this.field2492.method3851(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3732(var5);
            }

            this.field2492.method3860(var1);
            this.field2492.method3842(var1);
         }

         var1 = this.field2492.method3849();
         var2 = this.field2492.field2550[var1];
      }

      this.field2506 = var1;
      this.field2507 = var2;
      this.field2483 = var3;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgd;ZI)V",
      garbageValue = "-441861630"
   )
   void method3721(class205 var1, boolean var2) {
      int var3 = var1.field2516.field1598.length;
      int var4;
      if(var2 && var1.field2516.field1601) {
         int var5 = var3 + var3 - var1.field2516.field1597;
         var4 = (int)((long)var5 * (long)this.field2499[var1.field2533] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2532.method2205();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2499[var1.field2533] >> 6);
      }

      var1.field2532.method2204(var4);
   }

   @ObfuscatedName("t")
   protected synchronized int vmethod3916() {
      return 0;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(Lgd;I)I",
      garbageValue = "1308090427"
   )
   int method3735(class205 var1) {
      class202 var2 = var1.field2520;
      int var3 = 4096 + this.field2487[var1.field2533] * this.field2488[var1.field2533] >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2514 + 16384 >> 15;
      var3 = 128 + var3 * this.field2484 >> 8;
      if(var2.field2461 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field2525 * (double)var2.field2461) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2462 != null) {
         var4 = var1.field2526;
         var5 = var2.field2462[var1.field2517 + 1];
         if(var1.field2517 < var2.field2462.length - 2) {
            var6 = (var2.field2462[var1.field2517] & 255) << 8;
            var7 = (var2.field2462[var1.field2517 + 2] & 255) << 8;
            var5 += (var2.field2462[var1.field2517 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      if(var1.field2528 > 0 && var2.field2459 != null) {
         var4 = var1.field2528;
         var5 = var2.field2459[var1.field2529 + 1];
         if(var1.field2529 < var2.field2459.length - 2) {
            var6 = (var2.field2459[var1.field2529] & 255) << 8;
            var7 = (var2.field2459[var1.field2529 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2459[var1.field2529 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(Lgd;B)I",
      garbageValue = "98"
   )
   int method3736(class205 var1) {
      int var2 = this.field2489[var1.field2533];
      return var2 < 8192?32 + var2 * var1.field2521 >> 6:16384 - ((128 - var1.field2521) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1362286700"
   )
   public synchronized void method3810(int var1, int var2) {
      this.method3787(var1, var2);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "17"
   )
   void method3814(int var1) {
      for(class205 var2 = (class205)this.field2510.field2568.getFront(); var2 != null; var2 = (class205)this.field2510.field2568.getNext()) {
         if((var1 < 0 || var2.field2533 == var1) && var2.field2528 < 0) {
            this.field2502[var2.field2533][var2.field2519] = null;
            var2.field2528 = 0;
         }
      }

   }
}
