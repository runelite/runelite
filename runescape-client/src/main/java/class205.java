import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class205 extends class120 {
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 2008764195
   )
   int field2517;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1747634435
   )
   int field2495;
   @ObfuscatedName("i")
   int[] field2511;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   XHashTable field2523;
   @ObfuscatedName("d")
   int[] field2503;
   @ObfuscatedName("k")
   int[] field2498;
   @ObfuscatedName("r")
   int[] field2500;
   @ObfuscatedName("z")
   int[] field2504;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[[Lgn;"
   )
   class206[][] field2494;
   @ObfuscatedName("p")
   int[] field2525;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   class207 field2515;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   class209 field2521;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1857025985
   )
   int field2518;
   @ObfuscatedName("y")
   int[] field2497;
   @ObfuscatedName("j")
   int[] field2508;
   @ObfuscatedName("u")
   int[] field2502;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      longValue = -9118587443194430333L
   )
   long field2520;
   @ObfuscatedName("v")
   int[] field2499;
   @ObfuscatedName("x")
   int[] field2510;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1596721305
   )
   int field2513;
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "[[Lgn;"
   )
   class206[][] field2507;
   @ObfuscatedName("au")
   boolean field2512;
   @ObfuscatedName("b")
   int[] field2509;
   @ObfuscatedName("l")
   int[] field2505;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      longValue = -2468669182736037017L
   )
   long field2519;
   @ObfuscatedName("o")
   int[] field2514;
   @ObfuscatedName("f")
   int[] field2496;

   public class205() {
      this.field2495 = 256;
      this.field2513 = 1000000;
      this.field2497 = new int[16];
      this.field2498 = new int[16];
      this.field2499 = new int[16];
      this.field2504 = new int[16];
      this.field2500 = new int[16];
      this.field2502 = new int[16];
      this.field2503 = new int[16];
      this.field2514 = new int[16];
      this.field2505 = new int[16];
      this.field2525 = new int[16];
      this.field2496 = new int[16];
      this.field2509 = new int[16];
      this.field2510 = new int[16];
      this.field2511 = new int[16];
      this.field2508 = new int[16];
      this.field2494 = new class206[16][128];
      this.field2507 = new class206[16][128];
      this.field2515 = new class207();
      this.field2521 = new class209(this);
      this.field2523 = new XHashTable(128);
      this.method3721();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "117"
   )
   void method3710(int var1, int var2) {
      this.field2504[var1] = var2;
      this.field2502[var1] = var2 & -128;
      this.method3711(var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1881028436"
   )
   void method3714(int var1, int var2, int var3) {
      class206 var4 = this.field2494[var1][var2];
      if(var4 != null) {
         this.field2494[var1][var2] = null;
         if((this.field2525[var1] & 2) != 0) {
            for(class206 var5 = (class206)this.field2521.field2572.getFront(); var5 != null; var5 = (class206)this.field2521.field2572.getNext()) {
               if(var5.field2528 == var4.field2528 && var5.field2532 < 0 && var4 != var5) {
                  var4.field2532 = 0;
                  break;
               }
            }
         } else {
            var4.field2532 = 0;
         }

      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "891611894"
   )
   void method3718(int var1) {
      for(class206 var2 = (class206)this.field2521.field2572.getFront(); var2 != null; var2 = (class206)this.field2521.field2572.getNext()) {
         if(var1 < 0 || var2.field2528 == var1) {
            if(var2.field2544 != null) {
               var2.field2544.method2161(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2544.method2165()) {
                  this.field2521.field2573.method1911(var2.field2544);
               }

               var2.method3814();
            }

            if(var2.field2532 < 0) {
               this.field2494[var2.field2528][var2.field2530] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-249439335"
   )
   public synchronized void method3738() {
      this.field2515.method3829();
      this.method3721();
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2082047203"
   )
   void method3772(int var1) {
      if(var1 >= 0) {
         this.field2497[var1] = 12800;
         this.field2498[var1] = 8192;
         this.field2499[var1] = 16383;
         this.field2503[var1] = 8192;
         this.field2514[var1] = 0;
         this.field2505[var1] = 8192;
         this.method3722(var1);
         this.method3797(var1);
         this.field2525[var1] = 0;
         this.field2496[var1] = 32767;
         this.field2509[var1] = 256;
         this.field2510[var1] = 0;
         this.method3725(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3772(var1);
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1308422916"
   )
   void method3712(int var1, int var2, int var3) {
      this.method3714(var1, var2, 64);
      if((this.field2525[var1] & 2) != 0) {
         for(class206 var4 = (class206)this.field2521.field2572.getTail(); var4 != null; var4 = (class206)this.field2521.field2572.getPrevious()) {
            if(var4.field2528 == var1 && var4.field2532 < 0) {
               this.field2494[var1][var4.field2530] = null;
               this.field2494[var1][var2] = var4;
               int var5 = (var4.field2531 * var4.field2536 >> 12) + var4.field2534;
               var4.field2534 += var2 - var4.field2530 << 8;
               var4.field2531 = var5 - var4.field2534;
               var4.field2536 = 4096;
               var4.field2530 = var2;
               return;
            }
         }
      }

      class208 var9 = (class208)this.field2523.get((long)this.field2500[var1]);
      if(var9 != null) {
         class108 var8 = var9.field2562[var2];
         if(var8 != null) {
            class206 var6 = new class206();
            var6.field2528 = var1;
            var6.field2527 = var9;
            var6.field2535 = var8;
            var6.field2529 = var9.field2570[var2];
            var6.field2540 = var9.field2567[var2];
            var6.field2530 = var2;
            var6.field2526 = var3 * var3 * var9.field2564[var2] * var9.field2566 + 1024 >> 11;
            var6.field2533 = var9.field2565[var2] & 255;
            var6.field2534 = (var2 << 8) - (var9.field2563[var2] & 32767);
            var6.field2537 = 0;
            var6.field2538 = 0;
            var6.field2539 = 0;
            var6.field2532 = -1;
            var6.field2541 = 0;
            if(this.field2510[var1] == 0) {
               var6.field2544 = class118.method2224(var8, this.method3726(var6), this.method3786(var6), this.method3728(var6));
            } else {
               var6.field2544 = class118.method2224(var8, this.method3726(var6), 0, this.method3728(var6));
               this.method3713(var6, var9.field2563[var2] < 0);
            }

            if(var9.field2563[var2] < 0) {
               var6.field2544.method2286(-1);
            }

            if(var6.field2540 >= 0) {
               class206 var7 = this.field2507[var1][var6.field2540];
               if(var7 != null && var7.field2532 < 0) {
                  this.field2494[var1][var7.field2530] = null;
                  var7.field2532 = 0;
               }

               this.field2507[var1][var6.field2540] = var6;
            }

            this.field2521.field2572.addFront(var6);
            this.field2494[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1756273291"
   )
   void method3750(int var1, int var2, int var3) {
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-24"
   )
   void method3721() {
      this.method3718(-1);
      this.method3772(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2500[var1] = this.field2504[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2502[var1] = this.field2504[var1] & -128;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-80"
   )
   void method3711(int var1, int var2) {
      if(var2 != this.field2500[var1]) {
         this.field2500[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2507[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("r")
   protected synchronized void vmethod3889(int[] var1, int var2, int var3) {
      if(this.field2515.method3822()) {
         int var4 = this.field2515.field2548 * this.field2513 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = this.field2519 + (long)var3 * (long)var4;
            if(this.field2520 - var5 >= 0L) {
               this.field2519 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2520 - this.field2519) - 1L) / (long)var4);
            this.field2519 += (long)var4 * (long)var7;
            this.field2521.vmethod3889(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3734();
         } while(this.field2515.method3822());
      }

      this.field2521.vmethod3889(var1, var2, var3);
   }

   @ObfuscatedName("d")
   protected synchronized void vmethod3890(int var1) {
      if(this.field2515.method3822()) {
         int var2 = this.field2515.field2548 * this.field2513 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = this.field2519 + (long)var1 * (long)var2;
            if(this.field2520 - var3 >= 0L) {
               this.field2519 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2520 - this.field2519) - 1L) / (long)var2);
            this.field2519 += (long)var5 * (long)var2;
            this.field2521.vmethod3890(var5);
            var1 -= var5;
            this.method3734();
         } while(this.field2515.method3822());
      }

      this.field2521.vmethod3890(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1899150509"
   )
   void method3800(int var1, int var2) {
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-67"
   )
   void method3764(int var1, int var2) {
      this.field2503[var1] = var2;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lgn;B)I",
      garbageValue = "103"
   )
   int method3726(class206 var1) {
      int var2 = var1.field2534 + (var1.field2536 * var1.field2531 >> 12);
      var2 += (this.field2503[var1.field2528] - 8192) * this.field2509[var1.field2528] >> 12;
      class203 var3 = var1.field2529;
      int var4;
      if(var3.field2478 > 0 && (var3.field2477 > 0 || this.field2514[var1.field2528] > 0)) {
         var4 = var3.field2477 << 2;
         int var5 = var3.field2475 << 1;
         if(var1.field2542 < var5) {
            var4 = var4 * var1.field2542 / var5;
         }

         var4 += this.field2514[var1.field2528] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2543 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2535.field1601 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldl;"
   )
   protected synchronized class120 vmethod3908() {
      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lhu;Lit;Ldp;IB)Z",
      garbageValue = "-76"
   )
   synchronized boolean method3703(Track1 var1, IndexDataBase var2, class113 var3, int var4) {
      var1.method3910();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(class200 var7 = (class200)var1.field2575.method3549(); var7 != null; var7 = (class200)var1.field2575.method3556()) {
         int var8 = (int)var7.hash;
         class208 var9 = (class208)this.field2523.get((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method4120(var8);
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

            this.field2523.put(var10, (long)var8);
         }

         if(!var9.method3879(var3, var7.field2466, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3912();
      }

      return var5;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lgn;I)Z",
      garbageValue = "1397996927"
   )
   boolean method3751(class206 var1) {
      if(var1.field2544 == null) {
         if(var1.field2532 >= 0) {
            var1.unlink();
            if(var1.field2540 > 0 && var1 == this.field2507[var1.field2528][var1.field2540]) {
               this.field2507[var1.field2528][var1.field2540] = null;
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
      garbageValue = "-66"
   )
   void method3722(int var1) {
      if((this.field2525[var1] & 2) != 0) {
         for(class206 var2 = (class206)this.field2521.field2572.getFront(); var2 != null; var2 = (class206)this.field2521.field2572.getNext()) {
            if(var2.field2528 == var1 && this.field2494[var1][var2.field2530] == null && var2.field2532 < 0) {
               var2.field2532 = 0;
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-463744169"
   )
   int method3702() {
      return this.field2495;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1319299791"
   )
   void method3797(int var1) {
      if((this.field2525[var1] & 4) != 0) {
         for(class206 var2 = (class206)this.field2521.field2572.getFront(); var2 != null; var2 = (class206)this.field2521.field2572.getNext()) {
            if(var2.field2528 == var1) {
               var2.field2546 = 0;
            }
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1941471578"
   )
   void method3804(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3714(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3712(var3, var4, var5);
         } else {
            this.method3714(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3750(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2502[var3] = (var5 << 14) + (this.field2502[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2502[var3] = (var5 << 7) + (this.field2502[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2514[var3] = (var5 << 7) + (this.field2514[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2514[var3] = var5 + (this.field2514[var3] & -128);
         }

         if(var4 == 5) {
            this.field2505[var3] = (var5 << 7) + (this.field2505[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2505[var3] = var5 + (this.field2505[var3] & -128);
         }

         if(var4 == 7) {
            this.field2497[var3] = (var5 << 7) + (this.field2497[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2497[var3] = var5 + (this.field2497[var3] & -128);
         }

         if(var4 == 10) {
            this.field2498[var3] = (var5 << 7) + (this.field2498[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2498[var3] = var5 + (this.field2498[var3] & -128);
         }

         if(var4 == 11) {
            this.field2499[var3] = (var5 << 7) + (this.field2499[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2499[var3] = var5 + (this.field2499[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2525[var3] |= 1;
            } else {
               this.field2525[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2525[var3] |= 2;
            } else {
               this.method3722(var3);
               this.field2525[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2496[var3] = (var5 << 7) + (this.field2496[var3] & 127);
         }

         if(var4 == 98) {
            this.field2496[var3] = (this.field2496[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2496[var3] = (var5 << 7) + (this.field2496[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2496[var3] = (this.field2496[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3718(var3);
         }

         if(var4 == 121) {
            this.method3772(var3);
         }

         if(var4 == 123) {
            this.method3720(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2496[var3];
            if(var6 == 16384) {
               this.field2509[var3] = (var5 << 7) + (this.field2509[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2496[var3];
            if(var6 == 16384) {
               this.field2509[var3] = var5 + (this.field2509[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2510[var3] = (var5 << 7) + (this.field2510[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2510[var3] = var5 + (this.field2510[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2525[var3] |= 4;
            } else {
               this.method3797(var3);
               this.field2525[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3725(var3, (var5 << 7) + (this.field2511[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3725(var3, var5 + (this.field2511[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3711(var3, var4 + this.field2502[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3800(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3764(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3721();
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-103"
   )
   public synchronized boolean method3708() {
      return this.field2515.method3822();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1799184012"
   )
   synchronized void method3704() {
      for(class208 var1 = (class208)this.field2523.method3549(); var1 != null; var1 = (class208)this.field2523.method3556()) {
         var1.method3880();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-12"
   )
   synchronized void method3705() {
      for(class208 var1 = (class208)this.field2523.method3549(); var1 != null; var1 = (class208)this.field2523.method3556()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lgn;[IIII)Z",
      garbageValue = "164690905"
   )
   boolean method3736(class206 var1, int[] var2, int var3, int var4) {
      var1.field2545 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2532 < 0 || var1.field2544 != null && !var1.field2544.method2164()) {
         int var5 = var1.field2536;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2505[var1.field2528] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2536 = var5;
         }

         var1.field2544.method2162(this.method3726(var1));
         class203 var6 = var1.field2529;
         boolean var7 = false;
         ++var1.field2542;
         var1.field2543 += var6.field2478;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2530 - 60 << 8) + (var1.field2531 * var1.field2536 >> 12));
         if(var6.field2473 > 0) {
            if(var6.field2479 > 0) {
               var1.field2537 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2479 * var8) + 0.5D);
            } else {
               var1.field2537 += 128;
            }
         }

         if(var6.field2471 != null) {
            if(var6.field2474 > 0) {
               var1.field2538 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2474 * var8) + 0.5D);
            } else {
               var1.field2538 += 128;
            }

            while(var1.field2539 < var6.field2471.length - 2 && var1.field2538 > (var6.field2471[var1.field2539 + 2] & 255) << 8) {
               var1.field2539 += 2;
            }

            if(var6.field2471.length - 2 == var1.field2539 && var6.field2471[var1.field2539 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2532 >= 0 && var6.field2472 != null && (this.field2525[var1.field2528] & 1) == 0 && (var1.field2540 < 0 || var1 != this.field2507[var1.field2528][var1.field2540])) {
            if(var6.field2480 > 0) {
               var1.field2532 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2480 * var8) + 0.5D);
            } else {
               var1.field2532 += 128;
            }

            while(var1.field2541 < var6.field2472.length - 2 && var1.field2532 > (var6.field2472[var1.field2541 + 2] & 255) << 8) {
               var1.field2541 += 2;
            }

            if(var6.field2472.length - 2 == var1.field2541) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2544.method2161(var1.field2545);
            if(var2 != null) {
               var1.field2544.vmethod3889(var2, var3, var4);
            } else {
               var1.field2544.vmethod3890(var4);
            }

            if(var1.field2544.method2165()) {
               this.field2521.field2573.method1911(var1.field2544);
            }

            var1.method3814();
            if(var1.field2532 >= 0) {
               var1.unlink();
               if(var1.field2540 > 0 && var1 == this.field2507[var1.field2528][var1.field2540]) {
                  this.field2507[var1.field2528][var1.field2540] = null;
               }
            }

            return true;
         } else {
            var1.field2544.method2160(var1.field2545, this.method3786(var1), this.method3728(var1));
            return false;
         }
      } else {
         var1.method3814();
         var1.unlink();
         if(var1.field2540 > 0 && var1 == this.field2507[var1.field2528][var1.field2540]) {
            this.field2507[var1.field2528][var1.field2540] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "32767"
   )
   synchronized void method3729(int var1) {
      this.field2495 = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Ldl;"
   )
   protected synchronized class120 vmethod3906() {
      return this.field2521;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1379168237"
   )
   void method3725(int var1, int var2) {
      this.field2511[var1] = var2;
      this.field2508[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lhu;ZI)V",
      garbageValue = "559869723"
   )
   synchronized void method3706(Track1 var1, boolean var2) {
      this.method3738();
      this.field2515.method3820(var1.field2576);
      this.field2512 = var2;
      this.field2519 = 0L;
      int var3 = this.field2515.method3823();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2515.method3824(var4);
         this.field2515.method3830(var4);
         this.field2515.method3839(var4);
      }

      this.field2517 = this.field2515.method3832();
      this.field2518 = this.field2515.field2552[this.field2517];
      this.field2520 = this.field2515.method3831(this.field2518);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-850156735"
   )
   void method3734() {
      int var1 = this.field2517;
      int var2 = this.field2518;

      long var3;
      for(var3 = this.field2520; var2 == this.field2518; var3 = this.field2515.method3831(var2)) {
         while(var2 == this.field2515.field2552[var1]) {
            this.field2515.method3824(var1);
            int var5 = this.field2515.method3828(var1);
            if(var5 == 1) {
               this.field2515.method3826();
               this.field2515.method3839(var1);
               if(this.field2515.method3833()) {
                  if(!this.field2512 || var2 == 0) {
                     this.method3721();
                     this.field2515.method3829();
                     return;
                  }

                  this.field2515.method3834(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3804(var5);
            }

            this.field2515.method3830(var1);
            this.field2515.method3839(var1);
         }

         var1 = this.field2515.method3832();
         var2 = this.field2515.field2552[var1];
      }

      this.field2517 = var1;
      this.field2518 = var2;
      this.field2520 = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgn;ZI)V",
      garbageValue = "590263318"
   )
   void method3713(class206 var1, boolean var2) {
      int var3 = var1.field2535.field1600.length;
      int var4;
      if(var2 && var1.field2535.field1603) {
         int var5 = var3 + var3 - var1.field2535.field1602;
         var4 = (int)((long)this.field2510[var1.field2528] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2544.method2230();
         }
      } else {
         var4 = (int)((long)this.field2510[var1.field2528] * (long)var3 >> 6);
      }

      var1.field2544.method2156(var4);
   }

   @ObfuscatedName("z")
   protected synchronized int vmethod3904() {
      return 0;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lgn;I)I",
      garbageValue = "-1230602849"
   )
   int method3786(class206 var1) {
      class203 var2 = var1.field2529;
      int var3 = this.field2497[var1.field2528] * this.field2499[var1.field2528] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2526 + 16384 >> 15;
      var3 = var3 * this.field2495 + 128 >> 8;
      if(var2.field2473 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2473 * (double)var1.field2537 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2471 != null) {
         var4 = var1.field2538;
         var5 = var2.field2471[var1.field2539 + 1];
         if(var1.field2539 < var2.field2471.length - 2) {
            var6 = (var2.field2471[var1.field2539] & 255) << 8;
            var7 = (var2.field2471[var1.field2539 + 2] & 255) << 8;
            var5 += (var2.field2471[var1.field2539 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2532 > 0 && var2.field2472 != null) {
         var4 = var1.field2532;
         var5 = var2.field2472[var1.field2541 + 1];
         if(var1.field2541 < var2.field2472.length - 2) {
            var6 = (var2.field2472[var1.field2541] & 255) << 8;
            var7 = (var2.field2472[var1.field2541 + 2] & 255) << 8;
            var5 += (var2.field2472[var1.field2541 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lgn;B)I",
      garbageValue = "-11"
   )
   int method3728(class206 var1) {
      int var2 = this.field2498[var1.field2528];
      return var2 < 8192?var2 * var1.field2533 + 32 >> 6:16384 - ((128 - var1.field2533) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "15"
   )
   public synchronized void method3709(int var1, int var2) {
      this.method3710(var1, var2);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "78"
   )
   void method3720(int var1) {
      for(class206 var2 = (class206)this.field2521.field2572.getFront(); var2 != null; var2 = (class206)this.field2521.field2572.getNext()) {
         if((var1 < 0 || var2.field2528 == var1) && var2.field2532 < 0) {
            this.field2494[var2.field2528][var2.field2530] = null;
            var2.field2532 = 0;
         }
      }

   }
}
